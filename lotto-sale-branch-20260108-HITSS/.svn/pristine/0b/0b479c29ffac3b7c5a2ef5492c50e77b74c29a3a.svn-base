<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.util.Constants"%>
<html lang="es">
<head>    
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

	<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
	<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js?v=1"></script>
	<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=10"></script>
	<script type="text/javascript">
		$(document).ready(function() {		

			var operatorIdApiVal = $("#operatorIdApi").val();
	        var operator=0;
	        
	        if (!operatorIdApiVal) {
	            console.error("El valor de #operatorIdApi es nulo o indefinido");
	            operator =5588;
	        }
	        operator = parseInt(operatorIdApiVal, 10);
	        console.log("el valor operatorIdApi:" + operator);
	
	        if (operator !== 5586) {
	        	$("#clientSale-amount").text($("#pMontoRecharga").val());
	        	$("#billetera2-amount").text($("#pBilletera2Recarga").val());
	        	$("#billetera3-amount").text($("#pBilletera3CantRecarga").val());
	        }
			
			
		});
	</script>
	
	<meta charset="utf-8">
    <meta name="viewport" content="width=1024">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/main.css?v=<%=Constants.main_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <style type="text/css">		
		body{
			background: fixed;
		}
    </style>
    <title>Recarga - La Tinka de Perú</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body class="noscroll">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-5WTQR7D"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->  
	
	<input type="hidden" id="rechargetoken" value="${rechargetoken}" />
	<input type="hidden" id="operatorIdApi" value="${operatorIdApi}" />
	<input type="hidden" id="maximoCodigosBCP" value="${maximoCodigosBCP}" />
    <input type="hidden" id="maximoCodigosBBVA" value="${maximoCodigosBBVA}" />
	<input type="hidden" id="vn-merchantlogo" value="<c:out value='${visanet_merchantlogo}'/>">
	<input type="hidden" id="vn-sk" />
	<input type="hidden" id="remote-addr" value="<%= request.getRemoteAddr() %>"/>
	
	<input type="hidden" id="cid" value="${cid}" >
	<input type="hidden" id="full-name" value="${fullName}" >
	<input type="hidden" id="last-name" value="${lastName}" >
	<input type="hidden" id="email" value="${email}" >
	<input type="hidden" id="hrefForAnalytics" value="<%=Constants.HREF_FOR_ANALYTICS%>">
	
	<input type="hidden" id="docTypeIzi" value="${docTypeIzi}" >
	<input type="hidden" id="docNumber" value="${docNumber}" >
	
	<input type="hidden" id="urlAutocontrol" value="${urlAutocontrol}" />
	
	<input type="hidden" id="pMontoRecharga" value="${pMontoRecharga}" />
	<input type="hidden" id="pBilletera2Recarga" value="${pBilletera2Recarga}" />
	<input type="hidden" id="pBilletera3CantRecarga" value="${pBilletera3CantRecarga}" />
	
	<input type="hidden" id="mobilePhone" value="" >
	<div class="ilot">
		<div class="recharge">
	    <div class="pop-recharge" style="overflow: unset;">
	        <div class="pop-recharge__background"></div>
	        <div class="content">
	          <div class="pop-recharge__content">
	            <div class="recharge">
	              <div class="recharge__content">
	                <div class="recharge__header">
	                  <h2 class="recharge__header-title">Cargar saldo</h2>
	                  <ul class="recharge__header-info">
	                    <li><strong>Saldo Actual</strong> S/ <span id="clientSale-amount">${sessionScope.User.pMonto}</span></li>
	                    <li><strong>Bono Te Apuesto</strong><span id="billetera2-amount">${sessionScope.User.pBilletera2}</span></li>
	                    <li><strong>Jugadas gratis</strong><span id="billetera3-amount">${sessionScope.User.pBilletera3Cant}</span></li>
	                  </ul>
	                </div>
	                <div class="recharge__body" style="min-height: 110px;">
             
	                  <p class="recharge__body-text" style="line-height: 150%;">Límite de autoexclusión activado. Infórmate en la sección de 
	                  	<a style=" color: #333333; text-decoration:underline;" href="#" onclick="redirectToAutoControl()">Autocontrol</a>

<!-- 	                  	<a style=" color: #333333; text-decoration:underline;" href="#" onclick="redirectToAutoControlTest1()">Autocontrol2</a> -->
<!-- 	                  	<br/>  -->
	                  	
<!-- 	                  	<a style=" color: #333333; text-decoration:underline;" href="#" onclick="redirectToAutoControlTest2()">Autocontrol3</a> -->
<!-- 	                  	<br/>  -->
	                  	
<!-- 	                  	<a style=" color: #333333; text-decoration:underline;" href="#" onclick="redirectToAutoControlTest4()">Autocontrol4</a> -->
<!-- 	                  	<br/>  -->
	                  	
<!-- 	                  	<a style=" color: #333333; text-decoration:underline;" href="#" onclick="redirectToAutoControlTest5()">Autocontrol5</a> -->
	                  	<br/> 
	                  </p>
   
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	    </div>
	    </div>
    </div>
    <script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
    <script>
    $(document).ready(function(){
		var clientIdSesion= $('#cid').val();
		 if(clientIdSesion!=''){
			 validateSessionParent();
			document.addEventListener("click", validateSessionParent);
			document.addEventListener("keypress", validateSessionParent);
		 }
// 		 else{
// 			 parent.location.href = "inicio.html";
// 		 }
		
	});

   

    function redirectToAutoControl() {
        var operatorIdApiValue = $("#operatorIdApi").val();
        var operator=0;
        
        if (!operatorIdApiValue) {
            console.error("El valor de #operatorIdApi es nulo o indefinido");
            operator =5588;
        }
        operator = parseInt(operatorIdApiValue, 10);
        console.log("el valor operatorIdApi:" + operator);

        if (operator === 5586) {
            console.log("flujo 1");
            window.parent.postMessage('closeLightboxAutocontrol', '*');
        } else {
            try {
                console.log("flujo 2");
                parent.parent.location.href = "autocontrol.html";
            } catch (e) {
                console.error(e);
                parent.location.href = "autocontrol.html";
            }
        }

        
    }

    /*
    function redirectToAutoControlTest1() {

    	$.ajax({
            type: 'post',
            url: 'redireccionarAutocontrolTest1.html',
            dataType: 'json'
    	}).done(function(d) {
    		 console.log("ingresado");
        });
     
    }

    
    function redirectToAutoControlTest2() {

    	$.ajax({
            type: 'post',
            url: 'redireccionarAutocontrolTest2.html',
            dataType: 'json'
    	}).done(function(d) {
    		 console.log("ingresado");
        });
     
    }

    function redirectToAutoControlTest2() {

    	parent.location.href = "autocontrol.html";
     
    }

    function redirectToAutoControlTest4() {
    	 console.log("flujo redirectToAutoControlTest4");
    	parent.parent.location.href = "autocontrol.html";
     
    }

    function redirectToAutoControlTest5() {
    	 console.log("flujo redirectToAutoControlTest5");
    	parent.parent.location.href = "https://uat-3vbyhz.latinka.com.pe/movil-s03/client_edit_auto_control.html";
     
    }*/

    

    
    </script>
</body>
</html>