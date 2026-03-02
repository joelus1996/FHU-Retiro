<!DOCTYPE html>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<html lang="es">
<head>
    
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
<!-- End Google Tag Manager -->
	
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name='description' content="La Tinka móvil, billetera" />
	<title>Recarga - La Tinka S.A.</title>
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>

	
	<style type="text/css">		
		body{
			background: fixed !important;
		}
    </style>
</head>
<!-- <body class="noscroll"> -->
<body>
	
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-5WTQR7D"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<input type="hidden" id="rechargetoken" value="${rechargetoken}" />
	<input type="hidden" id="operatorId" value="${operatorId}" />
	
	<input type="hidden" id="maximoCodigosBCP" value="${maximoCodigosBCP}" />
	<input type="hidden" id="maximoCodigosBBVA" value="${maximoCodigosBBVA}" />
	<input type="hidden" id="remote-addr" value="<c:out value='<%= request.getRemoteAddr() %>'/>">
	<input type="hidden" id="vn-sk" />
	<input type="hidden" id="vn-merchantlogo" value="<c:out value='${visanet_merchantlogo}'/>">
	<input type="hidden" id="cid" value="<c:out value='${cid}'/>">
	<input type="hidden" id="client-name" value='${name}'>
	<input type="hidden" id="client-lastname" value='${lastname} ${maidenname}'>
	<input type="hidden" id="client-email" value='${mail}'>
	<input type="hidden" id="hrefForAnalytics" value="<%=Constantes.HREF_FOR_ANALYTICS%>">
	
	<input type="hidden" id="docTypeIzi" value="${docTypeIzi}" >
	<input type="hidden" id="docNumber" value="${docNumber}" >
	
	<input type="hidden" id="mobilePhone" value="" >
	
	<input type="hidden" id="autoexclusion" value="true" />
	
	<input type="hidden" id="urlAutocontrol" value="${urlAutocontrol}" />
	
	<input type="hidden" id="pMontoRecharga" value="${billetera1Recarga}" />
	<input type="hidden" id="pBilletera2Recarga" value="${billetera2Recarga}" />
	<input type="hidden" id="billetera3Recarga" value="${billetera3Recarga}" />
	
<!-- 	<i id="cargando"></i> -->
	<div class="ilot">
      <div class="pop-recharge">
        <div class="pop-recharge__background"></div>
        <c:if test="${operatorId eq '5586'}">
        <button class="pop-recharge__close" id="lightbox-recharge-ilot-pop-close" ></button>
        </c:if>
        <div class="content" id="content">
          <div class="pop-recharge__content">
            <div class="recharge">
              <div class="recharge__content">
                <div class="recharge__header">
                  <h2 class="recharge__header-title">Cargar saldo</h2>
                  <ul class="recharge__header-info">
                    <li><strong>Saldo Actual</strong> <span id="clientSale-amount">S/ 0.00</span></li>
                    <li><strong>Bono Te Apuesto</strong> <span id="billetera2-amount">S/ 0.00</span></li>
                    <li><strong>Jugadas gratis</strong> <span id="billetera3-amount">S/ 0.00</span></li>
                  </ul>
                </div>
                <div class="recharge__body" style="min-height: 230px;">
                  <p class="recharge__body-text">Límite de autoexclusión activado. Infórmate en la sección de 
                 	 <a style=" color: #333333; text-decoration:underline;" href="javascript:void(0);" onclick="redirectToAutoControl()">Autocontrol</a>
                  	 
                  </p>
                  
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="error" id="alert">${alert}</div>
      
      <div id="popup-tyc" class="overlay" style="z-index:10000;">
			<div class="popup popup-sm">
				<a class="close js-close-modal"  href="#">&times;</a>
				<div class="wrap-modal">
					<jsp:include page="../client/interface-term.jsp"/>
				</div>
			</div>
	  </div>
      
<!--       <footer class="footer">footer</footer> -->
      <div class="gridview">
        <div class="content">
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
        </div>
      </div>
    </div>
    
	<div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" id="btnAlertContent" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">OK</button>
		</div>
	</div>
	
	<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content"></div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">Continuar</button>
			<button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">Retornar</button>
		</div>
	</div>
	
	<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>" charset="UTF-8"></script>
	<script type="text/javascript" src="layer-view-script/popModal.js"></script>
	<script type="text/javascript" src="layer-view-script/funcionesTaggingRecargas.js?v=4"></script>
	<script type="text/javascript" src="layer-view-script/client/analytics.js?v=9" charset="UTF-8"></script>
	<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>
	<script>
	  var lastHeight=0, newHeight=0;
      $(document).ready(function() {
        renderPopup();
//         if($('#rechargetoken').val()!=null && $('#rechargetoken').val()!=""){
//      		$('#lightbox-recharge-ilot-pop-close').remove();
//    	  }
//         alert($('#rechargetoken').val());
        loadRechargeRT();        
        
        //setInterval(bodyHeightCheck, 1000);
        
      });
      
      function bodyHeightCheck(){
    	  try {
    		newHeight = $("#content").height();
    		if(newHeight !== lastHeight) {
    			window.parent.postMessage('{"setHeight":"'+ newHeight +'px"}','*');
    		}
    		lastHeight = newHeight;
    	  } catch (e) {   
    	  	console.log(e);
    	  }
      }

      $(document).ready(function(){
  		var clientIdSesion= $('#cid').val();
  		 if(clientIdSesion!=''){
  			 validateSessionParent();
  			document.addEventListener("click", validateSessionParent);
  			document.addEventListener("keypress", validateSessionParent);
  		 }
//   		 else{
//   			 parent.location.href = "home.html";
//   		 }


  		var operatorIdApiVal = $("#operatorId").val();
        var operator=0;
        
        if (!operatorIdApiVal) {
            console.error("El valor de #operatorIdApi es nulo o indefinido");
            operator =5588;
        }
        operator = parseInt(operatorIdApiVal, 10);
        console.log("el valor operatorIdApi:" + operator);

        if (operator === 5586) {
        	$("#clientSale-amount").text("S/ " + $("#pMontoRecharga").val());
        	$("#billetera2-amount").text($("#pBilletera2Recarga").val());
        	$("#billetera3-amount").text($("#billetera3Recarga").val());
        }
  		
  	  });

      

     
      
      function redirectToAutoControl() {
          var operatorIdApiValue = $("#operatorId").val();
          var operator=0;
          
          if (!operatorIdApiValue) {
              console.error("El valor de #operatorId es nulo o indefinido");
              operator =5588;
          }
           
          operator = parseInt(operatorIdApiValue, 10);
          console.log("el valor operatorIdApi:" + operator);

          //location.href = $("#urlAutocontrol").val();

          if (operator === 5586) {
              console.log("flujo 1");
              location.href = $("#urlAutocontrol").val();
          } else {
              try {
                  console.log("flujo 2");
                  parent.parent.location.href = "client_edit_auto_control.html";
              } catch (e) {
                  console.error(e);
                  parent.location.href = "client_edit_auto_control.html";
              }
          }
          

      }
  	  
      
    </script>
	
</body>
</html>