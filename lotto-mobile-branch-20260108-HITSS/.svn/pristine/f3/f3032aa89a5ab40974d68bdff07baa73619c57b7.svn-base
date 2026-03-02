<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="es">
<head>
	<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
	<script src="<%=Constantes.fdCheckoutJs%>"></script>
<!-- 	<script src="https://static-content-qas.vnforapps.com/vToken/js/checkout.js"></script> -->
<!-- 	<script src="https://static-content-nlb.vnforapps.com/vToken/js/checkout.js?static=true"></script> -->
	<script>
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
				}
			});
			VisanetCheckout.open();
		}
	
		
		function createSessionTokenization(){
			var vheaders={"prizetoken":$('#prizetoken').val()};
			console.log("createSessionTokenization vheaders="+vheaders);
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
		    		window.parent.postMessage('errorLoadingTokenization|Por favor, inténtalo de nuevo en unos minutos','*');	
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