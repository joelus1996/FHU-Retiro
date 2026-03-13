<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="es">
<head>
	<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
	<script src="<%=Constantes.fdCheckoutJs%>"></script>
<!-- 	<script src="https://static-content-qas.vnforapps.com/vToken/js/checkout.js"></script> -->
<!-- 	<script src="https://static-content-nlb.vnforapps.com/vToken/js/checkout.js?static=true"></script> -->
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
				var inputs = root.querySelectorAll('input');
				for (var i = 0; i < inputs.length; i++) {
					var inp = inputs[i];
					var ph = (inp.getAttribute('placeholder') || '').toLowerCase();
					var aria = (inp.getAttribute('aria-label') || '').toLowerCase();
					var name = (inp.getAttribute('name') || '').toLowerCase();
					var id = (inp.getAttribute('id') || '').toLowerCase();
					var combo = (ph + ' ' + aria + ' ' + name + ' ' + id);
					if (combo.indexOf('número') >= 0 || combo.indexOf('numero') >= 0 || combo.indexOf('card') >= 0 || combo.indexOf('pan') >= 0) {
						if (isVisibleEl(inp)) return true;
					}
				}
				return false;
			} catch (e) {
				return false;
			}
		}

		function getTokenizationCompletionModeAgora() {
			try {
				var root = document.getElementById('visaNetJS');
				if (!root) return 'unknown';
				if (hasSavedCardOptions(root)) return 'saved';
				if (isNewCardFormView(root)) return 'new';
				return 'unknown';
			} catch (e) {
				return 'unknown';
			}
		}

		function openNiubiz(data) {
			VisanetCheckout.configure({
				sessiontoken : JSON.parse(data.json).sessionKey,
				channel : 'paycard',
				merchantid : data.merchantid,
				purchasenumber : data.purchasenumber,
				amount : '1',
				formbuttoncolor : '#FF8000',
				formbuttontext : data.formbuttontext,
				merchantlogo : data.merchantlogo,
				showamount : 'false',
				cardholdername : data.cardholdername.replace(/[0123456789]/g,''),
				cardholderlastname : data.cardholderlastname.replace(/[0123456789]/g,''),
				usertoken : data.userToken,
				cardholderemail : data.cardholderemail,
				expirationminutes : '20',
				timeouturl : data.timeouturl,
				action: 'tokenizeCardAgora.html?prizetoken='+data.prizetoken,
				method: 'POST',
				cancel: function (){
					console.log("Cancel VisanetCheckout");
					try { window.parent.postMessage('hideLightboxTokenizationAgora','*'); } catch (e) {   }	
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
						var mode = getTokenizationCompletionModeAgora();
						window.parent.postMessage('tokenizationCompletedAgora|' + mode,'*');
					} catch (e) { }
				}
			});
			VisanetCheckout.open();
		}
	
		function createSessionTokenization(){
			var vheaders={"prizetoken":$('#prizetoken').val()};
			$.ajax({
		        type: "POST",
		        url: "createSessionTokenizationCard.html",
		        headers: vheaders,
		        dataType: "json",
			})
			.done(function(data) {
				if(data.status=="OK"){
					var sesion = JSON.parse(data.json).sessionKey;
					openNiubiz(data);
					setTimeout(function(){ try { window.parent.postMessage('hideLoadingTokenization','*'); } catch (e) {   } }, 1500);
					setTimeout(function(){ try { window.parent.postMessage('observerLightboxTokenizationAgora','*'); } catch (e) {   } }, 5000);
					setTimeout(function(){ try { window.parent.postMessage('hideLightboxTokenizationAgora','*'); } catch (e) {   } }, 900000);
				}else{
					window.parent.postMessage('errorLoadingTokenizationAgora|'+data.message,'*');	
				}
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				if(jqXHR.status==403){
		    		window.location.href = 'home.html';
		    	}else{
		    		window.parent.postMessage('errorLoadingTokenizationAgora|Por favor, int�ntalo de nuevo en unos minutos','*');
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
				console.log("createSessionTokenization ready localStorage prizetoken="+prizetoken);
			}
			console.log("createSessionTokenization ready prizetoken="+prizetoken);		
			$('#prizetoken').val(prizetoken);
			createSessionTokenization();
		});
	</script>
</head>
<body>
<input type="hidden" id="prizetoken" value="${prizetoken}" />
</body>
</html>