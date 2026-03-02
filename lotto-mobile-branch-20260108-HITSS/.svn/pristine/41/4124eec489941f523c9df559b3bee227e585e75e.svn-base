<%@include file="/layer-view-interface/include/taglib.jsp"%>
<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
<link rel="stylesheet" href="layer-view-style/game/virtuales/juegaGanaConVirtuales.css?v=2" type="text/css"/>
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/bannerCookies.css?v=6">

<header id="header">
	<input type="hidden" value="${clientId}" id="clientId">
	<input type="hidden" id="isDataComplete" value="<c:out value='${isDataComplete}'/>">
	<input type="hidden" value="<%= Constantes.flagPromoBicolor %>" id="flagPromoBicolor">
	<%-- <input type="hidden" value="<%= Constantes.flagPromoTinka %>" id="flagPromoTinka"> --%>
	<input type="hidden" value="<%= Constantes.getBeanTinkaBetBo().isPopupSiosiActive() %>" id="flagPromoTinka">
	<input type="hidden" value=<%= Constantes.getBeanTinkaBetBo().isPopup3x12Active() %> id="flagPromoTinka3x12">
	<input type="hidden" value=<%= Constantes.getBeanGanadiarioBetBo().isPopup3x5solesActive() %> id="flagPromoGD3x5">
	<input type="hidden" value="<%= Constantes.URL_QW%>" id="urlQw">
	<input type="hidden" value="<%= Constantes.flagPromoHincha %>" id="flagPromoHincha">
	<input type="hidden" value="<%= Constantes.flagPromoCasino %>" id="flagPromoCasino">
	<input type="hidden" id="openSession" name="openSession" value="${openSession}">
	<% 
	    //Parametro para cerrar sesion de TeApuesto en otro dispositivo
	  	String openSession=(String)session.getAttribute("openSession");
		if(openSession!=null) {
			session.removeAttribute("openSession");
		}
	%>
	<input type="hidden" id="closeSession2" name="closeSession2" value="${closeSession}">
	
	<div class="logo">
		<a href="#" id="btn_mobile_home">
<!-- 			<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 482.8 135.2" style="enable-background:new 0 0 482.8 135.2;" xml:space="preserve"><style type="text/css">.st0{fill:#FFFFFF;}.st1{fill:#FFFFFF;}.st2{fill-rule:evenodd;clip-rule:evenodd;fill:#FFFFFF;}</style><g id="Capa_2"></g><g id="Layer_1"><g><path class="st0" d="M404.6,83.6c-57.7,7-245.5,16.9-304.8,16.9c-59.3,0-45.9-16.5-39.5-16.9C65.8,83.2,404.6,83.6,404.6,83.6L404.6,83.6z"/></g><g><path class="st1" d="M92.2,28.7l-5.5,48h15l4.6-31.7c0.2-2,0.7-3.5,1.4-4.4c0.7-0.9,1.7-1.3,3.2-1.3c1.4,0,2.4,0.4,2.9,1.3c0.5,0.9,0.6,2.3,0.4,4.4l-3.6,31.7h15l5.1-36.2c0.3-2.6,0.2-4.7-0.2-6.4c-0.5-1.7-1.2-3-2.2-4c-1-1-2.3-1.7-3.8-2c-1.4-0.4-3-0.6-4.8-0.6c-5.7,0-9.8,2.4-12.4,7.1h-0.2l0.1-5.9H92.2L92.2,28.7z"/><path class="st1" d="M134.1,28.7l-1.2,10.7h5.3L135.3,65c-0.3,2.7-0.3,4.8,0,6.5c0.4,1.6,1,2.8,2,3.6c1,0.8,2.4,1.4,4.1,1.6c1.7,0.2,3.8,0.3,6.2,0.3c1.4,0,2.8-0.1,4.3-0.2c1.5-0.1,2-0.1,3.5-0.1l2.2-10.7H155c-1.3,0-2.2-0.3-2.8-0.8c-0.5-0.6-1.7-1.6-1.5-2.9l3.6-22.9h6.3l1.2-10.7h-6.8l1.1-8.7h-13.8l-2.7,8.7H134.1L134.1,28.7z"/><polygon class="st1" points="235.2,2.4 251.2,2.4 241.4,76.7 226.2,76.7 235.2,2.4 "/><path class="st1" d="M289.5,43c0-3.1-0.6-5.8-1.7-8.1c-1.1-2.3-2.9-4.1-5.5-5.4c-2.6-1.4-6.2-2-10.9-2c-4.5,0-8.2,0.7-11.1,2.2c-2.8,1.4-5.1,3.3-6.8,5.7c-1.7,2.4-2.9,5.1-3.8,8.1c-0.8,3-1.3,6.1-1.7,9.2c-0.4,3.5-0.6,6.8-0.6,9.9c0.1,3,0.7,5.7,1.8,8c1.1,2.2,2.9,4,5.5,5.3c2.6,1.2,6.2,1.9,10.9,1.9c4.5,0,8.2-0.7,11-2c2.9-1.4,5.2-3.3,6.9-5.6c1.7-2.4,2.9-5.1,3.7-8.1c0.8-3,1.4-6.1,1.8-9.2C289.4,49.3,289.6,46,289.5,43z M274,45.5c-0.2,1.9-0.5,4.4-0.9,7.4c-0.4,3-0.9,5.5-1.3,7.4c-0.4,1.9-0.9,3.4-1.4,4.5c-0.5,1.1-1,1.9-1.7,2.3c-0.7,0.4-1.4,0.6-2.3,0.5c-0.9,0-1.6-0.3-2.1-0.7c-0.5-0.4-0.8-1.2-1-2.3c-0.2-1.1-0.2-2.6,0-4.5c0.2-1.9,0.5-4.4,0.9-7.4c0.4-3,0.9-5.5,1.3-7.4c0.4-1.9,0.9-3.5,1.4-4.6c0.5-1.1,1.1-1.9,1.7-2.3c0.7-0.4,1.4-0.6,2.3-0.5c0.9,0,1.6,0.3,2.1,0.7c0.5,0.4,0.9,1.2,1,2.3C274.1,42,274.1,43.5,274,45.5z"/><path class="st1" d="M292.7,28.7l-1.2,10.7h5.3L293.8,65c-0.3,2.7-0.3,4.8,0,6.5c0.4,1.6,1,2.8,2,3.6c1,0.8,2.4,1.4,4.1,1.6c1.7,0.2,3.8,0.3,6.2,0.3c1.4,0,2.8-0.1,4.3-0.2c1.5-0.1,2-0.1,3.5-0.1l2.2-10.7h-2.5c-1.3,0-2.2-0.3-2.8-0.8c-0.5-0.6-1.7-1.6-1.5-2.9l3.6-22.9h6.3l1.2-10.7h-6.8l1.1-8.7h-13.8l-2.7,8.7H292.7L292.7,28.7z"/><path class="st1" d="M225,35.3c-0.7-2-1.8-3.6-3.4-4.7c-1.5-1.2-3.4-2-5.8-2.4c-2.3-0.5-4.8-0.7-7.6-0.7l-1.5,0l-12.4,0c-2.4,0-6.7,0.8-8.8,2.3c-2.1,1.5-3.8,3.7-5.2,6.6l0.3-7.6h-14.9l-5.5,48h15l4.3-22.2c2-11,10.1-12.6,22.9-14.6c2.3-0.4,4.1-0.7,4.5-0.7c2.7,0,3.7,0.7,3.4,3.4c-0.1,1.3-0.7,2.1-1.2,2.5c-0.8,0.8-2.1,1.4-3.8,1.8l-6.5,1.5c-2.6,0.6-4.8,1.3-6.6,2.2c-1.8,0.8-3.3,1.9-4.4,3.1c-1.1,1.2-2,2.6-2.7,4.3c-0.6,1.7-1,3.6-1.3,5.9c-0.2,2.1-0.2,4,0.1,5.7c0.3,1.7,0.9,3.2,1.8,4.4c0.9,1.2,2.2,2.2,3.8,2.8c1.6,0.7,3.7,1,6.1,1c2.5,0,4.7-0.5,6.8-1.6c2.1-1.1,3.7-2.7,4.8-4.8l0.2,2.8c0,0.9,0.1,1.7,0.3,2.6h13.8c0.1-1.6,1-8.1,1.3-10.4l2.7-23.4C225.9,39.8,225.8,37.2,225,35.3z M208.8,59.3c-0.3,2.7-0.9,4.6-1.8,5.9c-0.9,1.3-2.3,2-4,2c-1.2,0-2.1-0.5-2.7-1.4c-0.6-0.9-0.8-2.2-0.6-3.8c0.2-1.6,0.6-2.9,1.1-3.8c0.6-1,1.5-1.8,2.8-2.4c1.2-0.5,5.1-1.6,5.7-2.2L208.8,59.3z"/><polygon class="st1" points="72,28.7 67.1,76.7 82.1,76.7 87.8,28.7 72,28.7"/></g><g><path class="st2" d="M217,130.3l0.2-1.9h-0.1c-0.5,0.4-0.9,0.8-1.3,1.1c-0.4,0.3-0.8,0.5-1.1,0.6c-0.3,0.2-0.7,0.3-1,0.3c-0.4,0.1-0.8,0.1-1.2,0.1c-0.9,0-1.7-0.2-2.4-0.7c-0.7-0.5-1.2-1.2-1.6-2c-0.4-0.8-0.6-1.8-0.7-2.9c-0.1-1.1-0.1-2.2,0-3.4c0.1-1.4,0.4-2.6,0.7-3.9c0.3-1.2,0.8-2.3,1.3-3.3c0.6-1,1.3-1.7,2.1-2.3c0.8-0.6,1.8-0.8,3-0.8c0.8,0,1.5,0.1,2.1,0.4c0.6,0.3,1.1,0.7,1.6,1.2l1-9.6h5.8l-2.7,26.9H217L217,130.3z M218.1,115.6c-0.2-0.3-0.4-0.5-0.7-0.6c-0.3-0.2-0.6-0.3-1.1-0.3c-0.5,0-0.9,0.2-1.2,0.6c-0.3,0.4-0.5,0.9-0.7,1.5c-0.2,0.6-0.3,1.2-0.4,1.9c-0.1,0.7-0.1,1.3-0.2,1.8c-0.1,1-0.2,1.9-0.2,2.7c-0.1,0.8-0.1,1.4,0,2c0,0.5,0.2,0.9,0.4,1.2c0.2,0.3,0.5,0.5,0.9,0.5c0.4,0,0.8-0.1,1.2-0.4c0.4-0.3,0.7-0.6,1-1.1L218.1,115.6L218.1,115.6z"/><path class="st2" d="M231.4,122.2c0,0.4-0.1,0.9-0.1,1.4c0,0.5,0.1,1,0.2,1.5c0.1,0.5,0.4,0.8,0.7,1.2c0.3,0.3,0.8,0.5,1.3,0.5c0.7,0,1.4-0.2,2-0.7c0.6-0.5,1-1.1,1.2-1.9l3.8,1.5c-0.1,0.2-0.3,0.6-0.6,1.2c-0.3,0.6-0.8,1.1-1.4,1.7c-0.6,0.6-1.4,1.1-2.3,1.5c-0.9,0.5-2,0.7-3.3,0.7c-1.4,0-2.6-0.3-3.5-0.8c-1-0.6-1.7-1.3-2.3-2.2c-0.6-0.9-0.9-2-1.2-3.2c-0.2-1.2-0.2-2.5-0.1-3.8c0.1-1.3,0.4-2.6,0.9-3.8c0.5-1.2,1.1-2.3,1.8-3.2c0.8-0.9,1.7-1.6,2.7-2.2c1.1-0.5,2.3-0.8,3.6-0.8c1.4,0,2.6,0.3,3.5,0.9c0.9,0.6,1.6,1.3,2.1,2.3c0.5,0.9,0.8,2,1,3.2c0.2,1.2,0.2,2.4,0.1,3.6l-0.1,1.3H231.4L231.4,122.2z M236.2,118.6c0-0.5,0.1-0.9,0.1-1.4c0-0.5-0.1-0.9-0.2-1.2c-0.1-0.4-0.3-0.7-0.6-0.9c-0.3-0.2-0.6-0.3-1.1-0.3c-0.4,0-0.8,0.1-1.1,0.3c-0.3,0.2-0.6,0.5-0.8,0.9c-0.2,0.4-0.4,0.8-0.5,1.2c-0.1,0.5-0.2,0.9-0.2,1.4H236.2L236.2,118.6z"/><path class="st2" d="M263.1,111c-0.2,1.5-0.5,2.8-1.1,3.9c-0.6,1.1-1.3,2-2.3,2.6c-0.9,0.7-2,1.2-3.1,1.5c-1.2,0.3-2.4,0.5-3.7,0.5c-0.4,0-0.8,0-1.2,0c-0.4,0-0.8-0.1-1.2-0.1l-1.1,10.9h-6.5l2.7-26.9h9.6c1.2,0,2.3,0.2,3.4,0.5c1,0.3,1.9,0.8,2.6,1.4c0.7,0.6,1.3,1.4,1.6,2.3C263.2,108.6,263.3,109.7,263.1,111L263.1,111zM256.4,111.5c0.1-0.6,0-1.2-0.2-1.6c-0.2-0.4-0.5-0.8-0.8-1c-0.4-0.3-0.8-0.4-1.2-0.5c-0.5-0.1-0.9-0.2-1.4-0.2h-1.1l-0.7,6.6h1.1c0.5,0,0.9-0.1,1.4-0.2c0.5-0.1,0.9-0.3,1.3-0.5c0.4-0.3,0.8-0.6,1-1C256.2,112.7,256.3,112.1,256.4,111.5L256.4,111.5z"/><path class="st2" d="M268.4,122.2c0,0.4-0.1,0.9-0.1,1.4c0,0.5,0.1,1,0.2,1.5c0.1,0.5,0.4,0.8,0.7,1.2c0.3,0.3,0.8,0.5,1.3,0.5c0.7,0,1.4-0.2,2-0.7c0.6-0.5,1-1.1,1.2-1.9l3.8,1.5c-0.1,0.2-0.3,0.6-0.6,1.2c-0.3,0.6-0.8,1.1-1.4,1.7c-0.6,0.6-1.4,1.1-2.3,1.5c-0.9,0.5-2,0.7-3.3,0.7c-1.4,0-2.6-0.3-3.5-0.8c-1-0.6-1.7-1.3-2.3-2.2c-0.6-0.9-0.9-2-1.2-3.2c-0.2-1.2-0.2-2.5-0.1-3.8c0.1-1.3,0.4-2.6,0.9-3.8c0.5-1.2,1.1-2.3,1.8-3.2c0.8-0.9,1.7-1.6,2.7-2.2c1.1-0.5,2.3-0.8,3.6-0.8c1.4,0,2.6,0.3,3.5,0.9c0.9,0.6,1.6,1.3,2.1,2.3c0.5,0.9,0.8,2,1,3.2c0.2,1.2,0.2,2.4,0.1,3.6l-0.1,1.3H268.4L268.4,122.2z M273.1,118.6c0-0.5,0.1-0.9,0.1-1.4c0-0.5-0.1-0.9-0.2-1.2c-0.1-0.4-0.3-0.7-0.6-0.9c-0.3-0.2-0.6-0.3-1.1-0.3c-0.4,0-0.8,0.1-1.1,0.3c-0.3,0.2-0.6,0.5-0.8,0.9c-0.2,0.4-0.4,0.8-0.5,1.2c-0.1,0.5-0.2,0.9-0.2,1.4H273.1L273.1,118.6z"/><path class="st2" d="M292.1,117.1c-0.4-0.2-0.8-0.3-1.1-0.4c-0.4-0.1-0.8-0.2-1.2-0.2c-1,0-1.7,0.1-2.1,0.4c-0.4,0.3-0.8,0.6-1.2,1.1l-1.2,12.3h-5.8l1.9-19h5.7l-0.3,2.9h0.1c0.2-0.6,0.6-1.1,1-1.5c0.4-0.4,0.9-0.8,1.5-1c0.6-0.3,1.1-0.5,1.7-0.6c0.6-0.1,1.2-0.2,1.8-0.2L292.1,117.1L292.1,117.1z"/><path class="st2" d="M301,130.3l0.3-2.5h-0.1c-0.7,1-1.5,1.7-2.5,2.2c-0.9,0.5-1.9,0.8-3,0.8c-1.2,0-2.1-0.4-2.7-1.1c-0.6-0.8-0.8-1.8-0.7-3.1l1.5-15.2h5.8l-1.3,13.4c-0.1,0.5,0,0.9,0.1,1.2c0.2,0.3,0.5,0.5,1.1,0.5c0.6,0,1.2-0.3,1.6-0.8l0.3-0.5l1.4-13.9h5.8l-1.9,19H301L301,130.3z"/></g></g></svg> -->
			  <c:if test="${black_menu ne 'black_menu'}">
              	 <img src="layer-view-image/v2/logo-tinka-header.png?v=1" 
				     alt="tinka" 
				     style="margin: 0; max-width: 125px; height: auto; padding-left: 5px;" />
              </c:if>
              <c:if test="${black_menu eq 'black_menu'}">
              		<img src="layer-view-image/v2/logo-tinka-header-bn.png?v=2"  alt="tinka" 
				     style="margin: 0; max-width: 150px; height: auto;" />
              </c:if> 
			
		</a>
	</div>
	<div class="sub-header">

		<span id="bellNotification" class="cart-count" style="display: none;"></span>
		 
		<c:if test="${LottoCar > 0}" >	
				<span id="open-button-card" class="cart-count">${LottoCar}</span>
		 </c:if>
		<div class="cont-header">
			<c:if test="${empty clientId or agreement==''}">
				<a class="btn-balance" href="javascript:void(0)" id="btn_mobile_ingresar">
	              <span>Ingresa</span>
	            </a>
	            <a class="btn-balance" href="javascript:void(0)" id="btn_mobile_registrate">
	              <span>Regístrate</span>
	            </a>
			</c:if>
			<c:if test="${!empty clientId && agreement!=''}">
				<a class="btn-icon jsBtnIcon" href="#myCredit" onclick="closeMensajeNotificacion()">
				  <c:if test="${black_menu ne 'black_menu'}">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="25.902" height="25.902" viewBox="0 0 25.902 25.902">
	                     <g id="Grupo_3396" data-name="Grupo 3396" opacity="1">
	                        <path id="Trazado_2159" data-name="Trazado 2159" d="M12.951,0A12.951,12.951,0,1,0,25.9,12.951,12.966,12.966,0,0,0,12.951,0Zm0,24.725A11.774,11.774,0,1,1,24.725,12.951,11.787,11.787,0,0,1,12.951,24.725Z" fill="#07663a"/>
	                        <path id="Trazado_2160" data-name="Trazado 2160" d="M29.463,19.5a9.963,9.963,0,1,0,9.963,9.963A9.974,9.974,0,0,0,29.463,19.5Zm0,19.595a9.632,9.632,0,1,1,9.632-9.632A9.643,9.643,0,0,1,29.463,39.095Z" transform="translate(-16.512 -16.511)" fill="#07663a"/>
	                        <g id="Grupo_3380" data-name="Grupo 3380" transform="translate(6.974 7.97)">
	                           <g id="S" transform="translate(0 0)">
	                           <g id="Grupo_3379" data-name="Grupo 3379">
	                              <path id="Trazado_2164" data-name="Trazado 2164" d="M155.115,417.911a2.612,2.612,0,0,0,.359,1.283,2.346,2.346,0,0,0,2.126.924,3.674,3.674,0,0,0,1.243-.2,1.426,1.426,0,0,0,1.084-1.4,1.227,1.227,0,0,0-.459-1.081,4.536,4.536,0,0,0-1.459-.55l-1.218-.285a5.429,5.429,0,0,1-1.691-.614,1.962,1.962,0,0,1-.858-1.739,2.716,2.716,0,0,1,.843-2.055,3.327,3.327,0,0,1,2.388-.8,4.071,4.071,0,0,1,2.415.705,2.573,2.573,0,0,1,.994,2.254H159.7a2.393,2.393,0,0,0-.389-1.145,2.2,2.2,0,0,0-1.873-.727,2.1,2.1,0,0,0-1.534.468,1.5,1.5,0,0,0-.467,1.088,1.07,1.07,0,0,0,.552,1,7.939,7.939,0,0,0,1.636.505l1.262.3a3.811,3.811,0,0,1,1.409.589,2.226,2.226,0,0,1,.859,1.89,2.378,2.378,0,0,1-1.095,2.208,4.8,4.8,0,0,1-2.544.664,3.747,3.747,0,0,1-2.645-.885,3.022,3.022,0,0,1-.937-2.385Z" transform="translate(-153.932 -411.385)" fill="#07663a"/>
	                           </g>
	                           </g>
	                           <rect id="Rectángulo_1938" data-name="Rectángulo 1938" width="9.796" height="0.996" transform="matrix(0.25, -0.968, 0.968, 0.25, 7.739, 9.971)" fill="#07663a"/>
	                        </g>
	                     </g>
	                  </svg>	              	              	
	              </c:if>
	              <c:if test="${black_menu eq 'black_menu'}">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="25.902" height="25.902" viewBox="0 0 25.902 25.902">
	                     <g id="Grupo_3396" data-name="Grupo 3396" opacity="1">
	                        <path id="Trazado_2159" data-name="Trazado 2159" d="M12.951,0A12.951,12.951,0,1,0,25.9,12.951,12.966,12.966,0,0,0,12.951,0Zm0,24.725A11.774,11.774,0,1,1,24.725,12.951,11.787,11.787,0,0,1,12.951,24.725Z" fill="white"/>
	                        <path id="Trazado_2160" data-name="Trazado 2160" d="M29.463,19.5a9.963,9.963,0,1,0,9.963,9.963A9.974,9.974,0,0,0,29.463,19.5Zm0,19.595a9.632,9.632,0,1,1,9.632-9.632A9.643,9.643,0,0,1,29.463,39.095Z" transform="translate(-16.512 -16.511)" fill="white"/>
	                        <g id="Grupo_3380" data-name="Grupo 3380" transform="translate(6.974 7.97)">
	                           <g id="S" transform="translate(0 0)">
	                           <g id="Grupo_3379" data-name="Grupo 3379">
	                              <path id="Trazado_2164" data-name="Trazado 2164" d="M155.115,417.911a2.612,2.612,0,0,0,.359,1.283,2.346,2.346,0,0,0,2.126.924,3.674,3.674,0,0,0,1.243-.2,1.426,1.426,0,0,0,1.084-1.4,1.227,1.227,0,0,0-.459-1.081,4.536,4.536,0,0,0-1.459-.55l-1.218-.285a5.429,5.429,0,0,1-1.691-.614,1.962,1.962,0,0,1-.858-1.739,2.716,2.716,0,0,1,.843-2.055,3.327,3.327,0,0,1,2.388-.8,4.071,4.071,0,0,1,2.415.705,2.573,2.573,0,0,1,.994,2.254H159.7a2.393,2.393,0,0,0-.389-1.145,2.2,2.2,0,0,0-1.873-.727,2.1,2.1,0,0,0-1.534.468,1.5,1.5,0,0,0-.467,1.088,1.07,1.07,0,0,0,.552,1,7.939,7.939,0,0,0,1.636.505l1.262.3a3.811,3.811,0,0,1,1.409.589,2.226,2.226,0,0,1,.859,1.89,2.378,2.378,0,0,1-1.095,2.208,4.8,4.8,0,0,1-2.544.664,3.747,3.747,0,0,1-2.645-.885,3.022,3.022,0,0,1-.937-2.385Z" transform="translate(-153.932 -411.385)" fill="white"/>
	                           </g>
	                           </g>
	                           <rect id="Rectángulo_1938" data-name="Rectángulo 1938" width="9.796" height="0.996" transform="matrix(0.25, -0.968, 0.968, 0.25, 7.739, 9.971)" fill="white"/>
	                        </g>
	                     </g>
	                  </svg>	              	
	              </c:if> 
                  
	       		  
                </a>
                <a class="btn-icon jsBtnIcon" href="#myAbout" onclick="closeMensajeNotificacion()">
	              <c:if test="${black_menu ne 'black_menu'}">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32">
	                    <path id="Trazado_1718" data-name="Trazado 1718" d="M239.6,838.65a5.818,5.818,0,1,1,5.818-5.818,5.818,5.818,0,0,1-5.818,5.818Zm0,12.027a16,16,0,1,0-16-16,16,16,0,0,0,16,16Zm-9.275-4.848a10.015,10.015,0,0,1,18.55,0,14.505,14.505,0,1,0-18.55,0Z" transform="translate(-223.595 -818.677)" fill="#07663a" fill-rule="evenodd"/>
	                  </svg>              	
	              </c:if>
	              <c:if test="${black_menu eq 'black_menu'}">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32">
	                    <path id="Trazado_1718" data-name="Trazado 1718" d="M239.6,838.65a5.818,5.818,0,1,1,5.818-5.818,5.818,5.818,0,0,1-5.818,5.818Zm0,12.027a16,16,0,1,0-16-16,16,16,0,0,0,16,16Zm-9.275-4.848a10.015,10.015,0,0,1,18.55,0,14.505,14.505,0,1,0-18.55,0Z" transform="translate(-223.595 -818.677)" fill="white" fill-rule="evenodd"/>
	                  </svg>
	              </c:if>                
                  
                </a>
                <a class="btn-balance" href="javascript:void(0)" id="agregarSaldo">
                  <span style="font-family: AllerRegular, Arial, sans-serif !important;">Cargar Saldo</span>                   
                </a>
			</c:if>      
            <a class="button-menu" id="open-button">
              <c:if test="${black_menu ne 'black_menu'}">
              	<img id="img-open-button" src="layer-view-image/v2/menu-green.svg" alt="" />              	
              </c:if>
              <c:if test="${black_menu eq 'black_menu'}">
              	<img id="img-open-button" src="layer-view-image/v2/menu.svg?v=2" alt="" />
              	<c:set var = "black_menu" scope = "session" value = "not_black_menu"/>
              </c:if> 
              
            </a>
        </div>
	</div>
</header>
<div class="tutorial_hands">
	<div class="tutorialS">
     		  	<svg xmlns="http://www.w3.org/2000/svg" width="27.082" height="45.766" viewBox="0 0 27.082 45.766">
		  <g id="_1558108" data-name="1558108" transform="translate(-44.389 -30.857)">
		    <path id="Trazado_2044" data-name="Trazado 2044" d="M70.883,55.476,66.43,53.957a.774.774,0,0,0-.531-.67l-4.487-1.805h0a.848.848,0,0,0-.587-.817l-4.441-1.505V41.272a3.377,3.377,0,1,0-6.753,0V52.9l-4.875,3.421a.864.864,0,0,0-.367.706v8.209a6.436,6.436,0,0,0,3.819,5.776c1.97.734,2.05,2.175,2.028,4.874l0,2.048v0a.863.863,0,1,0,1.726,0l0-2.033c.021-2.492.045-5.316-3.152-6.505a4.746,4.746,0,0,1-2.692-4.159V57.477l3.516-2.467v3.674a.863.863,0,0,0,1.726,0V41.272a1.651,1.651,0,0,1,3.3,0V57.028a.863.863,0,0,0,1.726,0V50.981l3.3,1.117V59.45a.863.863,0,0,0,1.726,0V53.34l3.3,1.328v6.805a.863.863,0,0,0,1.726,0V55.779l3.3,1.127v9.912a3.605,3.605,0,0,1-1.564,2.969,6.925,6.925,0,0,0-2.9,5.752v2.394a.863.863,0,1,0,1.726,0V75.541a5.2,5.2,0,0,1,2.153-4.33,5.331,5.331,0,0,0,2.312-4.392V56.292a.863.863,0,0,0-.588-.817Z" transform="translate(0 -2.179)" fill="#fff"/>
		    <path id="Trazado_2045" data-name="Trazado 2045" d="M45.925,39.875a.863.863,0,0,0,.863-.863,6.429,6.429,0,1,1,12.858,0,.863.863,0,1,0,1.726,0,8.155,8.155,0,1,0-16.31,0A.863.863,0,0,0,45.925,39.875Z" transform="translate(-0.208)" fill="#fff"/>
		  </g>
		</svg>
	<span>Ver saldo</span>
	</div>
	<div class="tutorialS">
	       		  	<svg xmlns="http://www.w3.org/2000/svg" width="27.082" height="45.766" viewBox="0 0 27.082 45.766">
					  <g id="_1558108" data-name="1558108" transform="translate(-44.389 -30.857)">
					    <path id="Trazado_2044" data-name="Trazado 2044" d="M70.883,55.476,66.43,53.957a.774.774,0,0,0-.531-.67l-4.487-1.805h0a.848.848,0,0,0-.587-.817l-4.441-1.505V41.272a3.377,3.377,0,1,0-6.753,0V52.9l-4.875,3.421a.864.864,0,0,0-.367.706v8.209a6.436,6.436,0,0,0,3.819,5.776c1.97.734,2.05,2.175,2.028,4.874l0,2.048v0a.863.863,0,1,0,1.726,0l0-2.033c.021-2.492.045-5.316-3.152-6.505a4.746,4.746,0,0,1-2.692-4.159V57.477l3.516-2.467v3.674a.863.863,0,0,0,1.726,0V41.272a1.651,1.651,0,0,1,3.3,0V57.028a.863.863,0,0,0,1.726,0V50.981l3.3,1.117V59.45a.863.863,0,0,0,1.726,0V53.34l3.3,1.328v6.805a.863.863,0,0,0,1.726,0V55.779l3.3,1.127v9.912a3.605,3.605,0,0,1-1.564,2.969,6.925,6.925,0,0,0-2.9,5.752v2.394a.863.863,0,1,0,1.726,0V75.541a5.2,5.2,0,0,1,2.153-4.33,5.331,5.331,0,0,0,2.312-4.392V56.292a.863.863,0,0,0-.588-.817Z" transform="translate(0 -2.179)" fill="#fff"/>
					    <path id="Trazado_2045" data-name="Trazado 2045" d="M45.925,39.875a.863.863,0,0,0,.863-.863,6.429,6.429,0,1,1,12.858,0,.863.863,0,1,0,1.726,0,8.155,8.155,0,1,0-16.31,0A.863.863,0,0,0,45.925,39.875Z" transform="translate(-0.208)" fill="#fff"/>
					  </g>
					</svg>
	       		  	<span>Ver cuenta</span>
	       		  </div>
	<div class="tutorialS">
		    <svg xmlns="http://www.w3.org/2000/svg" width="27.082" height="45.766" viewBox="0 0 27.082 45.766">
			  <g id="_1558108" data-name="1558108" transform="translate(-44.389 -30.857)">
			    <path id="Trazado_2044" data-name="Trazado 2044" d="M70.883,55.476,66.43,53.957a.774.774,0,0,0-.531-.67l-4.487-1.805h0a.848.848,0,0,0-.587-.817l-4.441-1.505V41.272a3.377,3.377,0,1,0-6.753,0V52.9l-4.875,3.421a.864.864,0,0,0-.367.706v8.209a6.436,6.436,0,0,0,3.819,5.776c1.97.734,2.05,2.175,2.028,4.874l0,2.048v0a.863.863,0,1,0,1.726,0l0-2.033c.021-2.492.045-5.316-3.152-6.505a4.746,4.746,0,0,1-2.692-4.159V57.477l3.516-2.467v3.674a.863.863,0,0,0,1.726,0V41.272a1.651,1.651,0,0,1,3.3,0V57.028a.863.863,0,0,0,1.726,0V50.981l3.3,1.117V59.45a.863.863,0,0,0,1.726,0V53.34l3.3,1.328v6.805a.863.863,0,0,0,1.726,0V55.779l3.3,1.127v9.912a3.605,3.605,0,0,1-1.564,2.969,6.925,6.925,0,0,0-2.9,5.752v2.394a.863.863,0,1,0,1.726,0V75.541a5.2,5.2,0,0,1,2.153-4.33,5.331,5.331,0,0,0,2.312-4.392V56.292a.863.863,0,0,0-.588-.817Z" transform="translate(0 -2.179)" fill="#fff"/>
			    <path id="Trazado_2045" data-name="Trazado 2045" d="M45.925,39.875a.863.863,0,0,0,.863-.863,6.429,6.429,0,1,1,12.858,0,.863.863,0,1,0,1.726,0,8.155,8.155,0,1,0-16.31,0A.863.863,0,0,0,45.925,39.875Z" transform="translate(-0.208)" fill="#fff"/>
			  </g>
			</svg>
	  	<span>Cargar saldo</span>
	  </div>
</div>
<c:if test="${!empty clientId && agreement!=''}">
	<div class="menu-not-wrap" id="myCredit">
	  <ul>
	    <li class="first-c">
	       <div class="fixed-padd">
	          <div class="fixed-padd-left">Saldo:</div>
	          <div class="fixed-padd-right" id="clientSale-amount">${saldo}</div>
	       </div>
	    </li>
	    <li>
	       <a href="client_balance_bono_te_apuesto_show_information.html">
	          <div class="fixed-padd linkicon">
	             <div class="fixed-padd-left">Bono Te Apuesto:</div>
	             <div class="fixed-padd-right" id="billetera2-amount">${bonoTeApuesto}</div>
	          </div>
	       </a>
	    </li>
	    <li>
	       <a href="client_balance_bono_games_show_information.html">
	          <div class="fixed-padd linkicon">
	             <div class="fixed-padd-left">Jugadas gratis:</div>
	             <div class="fixed-padd-right" id="billetera3-amount">${bonoOtro}</div>
	          </div>
	       </a>
	    </li>
	  </ul>
	</div>
	<div class="menu-not-wrap" id="myAbout">
	 <ul>
	    <li class="first-c">
	       <p class="">
	       	  <i><svg xmlns="http://www.w3.org/2000/svg" width="13.325" height="18.047" viewBox="0 0 13.325 18.047"><g id="Grupo_4005" data-name="Grupo 4005" transform="translate(351.855 18.75)">
				    <path id="Trazado_2370" data-name="Trazado 2370" d="M-285.335-9.4c1.729,0,3.13-1.7,3.13-3.8s-.46-3.8-3.13-3.8-3.13,1.7-3.13,3.8S-287.064-9.4-285.335-9.4Z" transform="translate(-59.857 -1)" fill="none" stroke="#959595" stroke-miterlimit="10" stroke-width="1.5"/>
				    <path id="Trazado_2371" data-name="Trazado 2371" d="M-351.1,283.438c0-.128,0-.036,0,0Z" transform="translate(0 -287.029)" fill="none" stroke="#959595" stroke-miterlimit="10" stroke-width="1.5"/>
				    <path id="Trazado_2372" data-name="Trazado 2372" d="M-84.915,284.6c0-.035,0-.243,0,0Z" transform="translate(-254.366 -288.094)" fill="none" stroke="#959595" stroke-miterlimit="10" stroke-width="1.5"/>
				    <path id="Trazado_2373" data-name="Trazado 2373" d="M-339.275,166.1c-.058-3.658-.536-4.7-4.191-5.36a2.191,2.191,0,0,1-1.714.656,2.192,2.192,0,0,1-1.714-.656c-3.616.653-4.122,1.679-4.189,5.241-.005.291-.008.306-.009.272,0,.063,0,.18,0,.384,0,0,.87,1.754,5.911,1.754s5.911-1.754,5.911-1.754c0-.131,0-.222,0-.284A2.374,2.374,0,0,1-339.275,166.1Z" transform="translate(-0.012 -169.845)" fill="none" stroke="#959595" stroke-miterlimit="10" stroke-width="1.5"/>
				  </g>
				</svg>
	       	  </i>
	          Mi cuenta
	       </p>
	    </li>
	    <li class="">
	       <a href="client_balance_show_information.html" class="fixed-padd linkicon linkAbout">
	          <i><svg xmlns="http://www.w3.org/2000/svg" width="20.979" height="20.979" viewBox="0 0 20.979 20.979">
				  <g id="Grupo_4003" data-name="Grupo 4003" transform="translate(659.751 183.94)">
				    <g id="Grupo_3952" data-name="Grupo 3952" transform="translate(-653.586 -177.923)">
				      <g id="Grupo_3951" data-name="Grupo 3951" transform="translate(0 0)">
				        <path id="Trazado_2374" data-name="Trazado 2374" d="M-479.911,225.4a.225.225,0,0,0-.225-.225h-7.656l1.346-1.346a.223.223,0,0,0,0-.316.223.223,0,0,0-.316,0l-1.728,1.728a.223.223,0,0,0,0,.316l1.728,1.728a.223.223,0,0,0,.159.066.223.223,0,0,0,.159-.066.223.223,0,0,0,0-.316l-1.346-1.346h7.658A.222.222,0,0,0-479.911,225.4Z" transform="translate(488.558 -218.402)" fill="#959595" stroke="#959595" stroke-width="0.6"/>
				        <path id="Trazado_2375" data-name="Trazado 2375" d="M-480.063-18.232l-1.728-1.726a.223.223,0,0,0-.316,0,.223.223,0,0,0,0,.316l1.346,1.346h-7.658a.225.225,0,0,0-.225.225.225.225,0,0,0,.225.225h7.658l-1.346,1.342a.223.223,0,0,0,0,.316.223.223,0,0,0,.159.066.223.223,0,0,0,.159-.066l1.728-1.728A.225.225,0,0,0-480.063-18.232Z" transform="translate(488.645 20.024)" fill="#959595" stroke="#959595" stroke-width="0.6"/>
				      </g>
				    </g>
				    <g id="Grupo_3953" data-name="Grupo 3953" transform="translate(-659.452 -183.64)">
				      <path id="Trazado_2376" data-name="Trazado 2376" d="M-649.767-163.766a10.125,10.125,0,0,1-3.966-.8,10.155,10.155,0,0,1-3.239-2.184,10.158,10.158,0,0,1-2.184-3.239,10.131,10.131,0,0,1-.8-3.966,10.131,10.131,0,0,1,.8-3.966,10.158,10.158,0,0,1,2.184-3.239,10.154,10.154,0,0,1,3.239-2.184,10.125,10.125,0,0,1,3.966-.8,10.126,10.126,0,0,1,3.966.8,10.153,10.153,0,0,1,3.239,2.184,10.154,10.154,0,0,1,2.184,3.239,10.127,10.127,0,0,1,.8,3.966,10.127,10.127,0,0,1-.8,3.966,10.154,10.154,0,0,1-2.184,3.239,10.154,10.154,0,0,1-3.239,2.184A10.126,10.126,0,0,1-649.767-163.766Zm0-19.843a9.59,9.59,0,0,0-6.826,2.827,9.59,9.59,0,0,0-2.828,6.826,9.59,9.59,0,0,0,2.828,6.826,9.59,9.59,0,0,0,6.826,2.827,9.59,9.59,0,0,0,6.826-2.827,9.589,9.589,0,0,0,2.828-6.826,9.589,9.589,0,0,0-2.828-6.826A9.59,9.59,0,0,0-649.767-183.609Z" transform="translate(659.957 184.145)" fill="#959595" stroke="#959595" stroke-width="0.6"/>
				    </g>
				  </g>
				</svg>
	          </i>
	          Mis Movimientos
	       </a>
	    </li>
	    <li class="">
	       <a href="client_play_show_information.html" class="fixed-padd linkicon linkAbout">
	          <i><svg xmlns="http://www.w3.org/2000/svg" width="16.981" height="17.737" viewBox="0 0 16.981 17.737">
				  <g id="Grupo_4002" data-name="Grupo 4002" transform="translate(-16.038 -24)">
				    <g id="Grupo_3955" data-name="Grupo 3955" transform="translate(16.038 24)">
				      <path id="Trazado_2377" data-name="Trazado 2377" d="M217.428,122.33a4.5,4.5,0,0,0,1.287,1.16l1.194.716a.377.377,0,0,0,.388,0l1.171-.7a4.641,4.641,0,0,0,1.325-1.194,1.42,1.42,0,0,0,.272-1.06,1.471,1.471,0,0,0-2.327-.958l-.635.478h0l-.636-.477a1.456,1.456,0,0,0-2.038,2.038Zm.744-1.434a.7.7,0,0,1,.841,0l.636.477a.749.749,0,0,0,.9,0l.636-.478a.705.705,0,0,1,.864.017.674.674,0,0,1,.135.943h0a3.879,3.879,0,0,1-1.11,1l-.977.586-1-.6a3.747,3.747,0,0,1-1.071-.966.7.7,0,0,1,.14-.981Z" transform="translate(-207.65 -115.472)" fill="#959595"/>
				      <path id="Trazado_2378" data-name="Trazado 2378" d="M216,56h.755v.755H216Z" transform="translate(-206.567 -54.49)" fill="#959595"/>
				      <path id="Trazado_2379" data-name="Trazado 2379" d="M328,248h.755v.755H328Z" transform="translate(-313.283 -237.433)" fill="#959595"/>
				      <path id="Trazado_2380" data-name="Trazado 2380" d="M114.5,121.132l.69-.306.306.69-.69.306Z" transform="translate(-109.857 -116.258)" fill="#959595"/>
				      <path id="Trazado_2381" data-name="Trazado 2381" d="M24.833,41.738a1.129,1.129,0,0,0,.821-.352l3.814-4.022,1.2-.532h1.222A1.133,1.133,0,0,0,33.019,35.7V25.132A1.133,1.133,0,0,0,31.887,24H25.094a1.133,1.133,0,0,0-1.132,1.132v.637l-4.233,1.875a1.132,1.132,0,0,0-.577,1.494v0l.137.31-2.944,3.1a1.138,1.138,0,0,0,.042,1.6l7.665,7.276A1.131,1.131,0,0,0,24.833,41.738Zm-.117-16.606a.378.378,0,0,1,.377-.377h6.793a.378.378,0,0,1,.377.377V35.7a.378.378,0,0,1-.377.377H25.094a.378.378,0,0,1-.377-.377Zm-4.882,3.413a.379.379,0,0,1,.2-.211L23.962,26.6v9.1a1.133,1.133,0,0,0,1.132,1.132H28.8l-4.181,1.856a.372.372,0,0,1-.287.007.381.381,0,0,1-.21-.2l-4.042-9.123-.241-.539A.373.373,0,0,1,19.834,28.545ZM16.9,33.068,19.621,30.2l3.815,8.6a1.13,1.13,0,0,0,1.489.579l.005,0,2.745-1.218-2.568,2.708a.379.379,0,0,1-.535.013L16.908,33.6a.377.377,0,0,1-.015-.532l0,0Z" transform="translate(-16.038 -24)" fill="#959595"/>
				    </g>
				    <path id="Trazado_2382" data-name="Trazado 2382" d="M51.3,210.524l.52-.547.547.52-.52.547Z" transform="translate(-33.594 -177.204)" fill="#959595"/>
				  </g>
				</svg>
	          </i>
	          Mis Jugadas
	       </a>
	    </li>
	    <li class="">
	       <a href="client_price_show_information.html" class="fixed-padd linkicon linkAbout">
	       	  <i><svg xmlns="http://www.w3.org/2000/svg" width="15.297" height="14.322" viewBox="0 0 15.297 14.322">
				  <g id="Grupo_4001" data-name="Grupo 4001" transform="translate(-104 -94.314)">
				    <g id="Grupo_3948" data-name="Grupo 3948" transform="translate(104 94.314)">
				      <path id="Trazado_2369" data-name="Trazado 2369" d="M118.341,98.12h-3.025a3.716,3.716,0,0,0,.533-.427,2,2,0,0,0,0-2.813,2.021,2.021,0,0,0-2.8,0,5.261,5.261,0,0,0-1.362,3.24h-.069a5.267,5.267,0,0,0-1.362-3.24,2.021,2.021,0,0,0-2.8,0,2,2,0,0,0,0,2.813,3.784,3.784,0,0,0,.534.427h-3.025a.958.958,0,0,0-.956.956v2.39a.478.478,0,0,0,.478.478h.478v5.736a.958.958,0,0,0,.956.956h11.473a.958.958,0,0,0,.956-.956v-5.736h.478a.478.478,0,0,0,.478-.478v-2.39A.958.958,0,0,0,118.341,98.12Zm-10.216-2.566a1.019,1.019,0,0,1,1.448,0c.644.648,1.285,2.3,1.062,2.535a.315.315,0,0,1-.177.032,4.7,4.7,0,0,1-2.334-1.1A1.043,1.043,0,0,1,108.125,95.553Zm3.045,12.127h-5.258v-5.736h5.258Zm0-6.692h-6.214V99.076h6.214Zm2.553-5.434a1.03,1.03,0,1,1,1.448,1.465,4.7,4.7,0,0,1-2.334,1.1.314.314,0,0,1-.178-.032C112.438,97.858,113.079,96.2,113.723,95.553Zm3.662,12.127h-5.258v-5.736h5.258Zm.956-6.692h-6.214V99.076h6.214Z" transform="translate(-104 -94.314)" fill="#959595"/>
				    </g>
				  </g>
				</svg>
	       	  </i>
	          Retirar mis premios
	       </a>
	    </li>
	    <li class="">
	       <a id="client_account_show_information" class="fixed-padd linkicon linkAbout" style="cursor: pointer" href="#">
	       	  <i><svg xmlns="http://www.w3.org/2000/svg" width="16.386" height="13.473" viewBox="0 0 16.386 13.473">
				  <path id="Trazado_9459" data-name="Trazado 9459" d="M65.074,30.382h-.659V28H56.873l-1.324-1.853H50.576a.724.724,0,0,0-.723.723V38.436h0a.676.676,0,0,0,.678.683H62.383a.672.672,0,0,0,.649-.48l2.707-7.423v-.047A.709.709,0,0,0,65.074,30.382Zm-1.189-1.853v1.853H61.767v-.794a.265.265,0,1,0-.53,0v.794H59.914v-.794a.265.265,0,1,0-.53,0v.794H58.061v-.794a.265.265,0,0,0-.53,0v.794H56.207v-.794a.265.265,0,0,0-.53,0v.794H54.354v-.794a.265.265,0,0,0-.53,0v.794h-.6a.679.679,0,0,0-.112.009.668.668,0,0,0-.537.471l-.084.231-1.314,3.6V30.117h1.589V28.529h11.12ZM51.551,29.588l.685-.685v.685Zm-1.169-2.719a.194.194,0,0,1,.194-.194h4.7L56.222,28H52.391l-1.744,1.744V36.12l-.265.722Zm12.144,11.61a.15.15,0,0,1-.144.11H50.532a.146.146,0,0,1-.119-.059.143.143,0,0,1-.033-.108l.266-.73h0l2.425-6.649.007-.022a.15.15,0,0,1,.144-.11H65.074c.1,0,.126.145.133.217Z" transform="translate(-49.603 -25.896)" fill="#959595" stroke="#959595" stroke-width="0.5"/>
				</svg>
	       	  </i>
	          Mi Perfil
	       </a>
	    </li>
	 </ul>
	</div>
	<div class="close-menu-not-wrap"></div>
</c:if> 

<div class="menu-wrap">
    <nav class="menu">
        <div class="icon-list">
            <div class="box-account">
	           	<c:if test="${empty clientId or agreement==''}">
					<div class="box-account__content box-notlogin">
		                <a href="security_login_execute_authentication.html" id="btn_mobile_ingresar">
		                 		<img src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjUxMnB4IiBoZWlnaHQ9IjUxMnB4IiB2aWV3Qm94PSIwIDAgOTUuNjY3IDk1LjY2NyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgOTUuNjY3IDk1LjY2NzsiIHhtbDpzcGFjZT0icHJlc2VydmUiPgo8Zz4KCTxnPgoJCTxwYXRoIGQ9Ik0zOS4xNzMsNzIuMzQ0bDM5LjQ0Ny0yMi43NzdjMC42MTktMC4zNTYsMS0xLjAxOCwxLTEuNzMxcy0wLjM4MS0xLjM3NS0xLTEuNzMyTDM5LjE3MywyMy4zMjQgICAgYy0wLjYxOS0wLjM1Ny0xLjM4MS0wLjM1Ny0yLDBjLTAuNjE5LDAuMzU3LTEsMS4wMTgtMSwxLjczMnYxMC42MDVIMi4xMjFjLTEuMTA0LDAtMiwwLjg5Ni0yLDJ2MjAuMzQ0YzAsMS4xMDQsMC44OTYsMiwyLDIgICAgaDM0LjA1M3YxMC42MDRjMCwwLjcxNiwwLjM4MSwxLjM3NSwxLDEuNzMyYzAuMzEsMC4xOCwwLjY1NSwwLjI2OCwxLDAuMjY4QzM4LjUxOSw3Mi42MDksMzguODY0LDcyLjUyMSwzOS4xNzMsNzIuMzQ0eiIgZmlsbD0iIzAwMDAwMCIvPgoJCTxwYXRoIGQ9Ik04MC43NzUsMEg0MC4wMjZjLTEuMTA0LDAtMiwwLjg5Ni0yLDJ2NmMwLDEuMTA0LDAuODk2LDIsMiwyaDQwLjc0OWMyLjYzMiwwLDQuNzcxLDIuMTQxLDQuNzcxLDQuNzcxdjY2LjEyNSAgICBjMCwyLjYzMS0yLjE0MSw0Ljc3MS00Ljc3MSw0Ljc3MUg0MC4wMjZjLTEuMTA0LDAtMiwwLjg5Ni0yLDJ2NmMwLDEuMTA0LDAuODk2LDIsMiwyaDQwLjc0OWM4LjE0NiwwLDE0Ljc3MS02LjYyNywxNC43NzEtMTQuNzcxICAgIFYxNC43NzJDOTUuNTQ2LDYuNjI3LDg4LjkyLDAsODAuNzc1LDB6IiBmaWxsPSIjMDAwMDAwIi8+Cgk8L2c+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==" />
		                 	<span>INGRESA</span>
		                 </a>
		            </div>
		            <div class="box-account__content">
	                 	<a href="client_lotocard_show_form.html" class="white_btn" id="btn_mobile_registrate">
	                 		<img src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iTGF5ZXJfMSIgeD0iMHB4IiB5PSIwcHgiIHZpZXdCb3g9IjAgMCAyNTguNzUgMjU4Ljc1IiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCAyNTguNzUgMjU4Ljc1OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjUxMnB4IiBoZWlnaHQ9IjUxMnB4Ij4KPGc+Cgk8Y2lyY2xlIGN4PSIxMjkuMzc1IiBjeT0iNjAiIHI9IjYwIiBmaWxsPSIjMDAwMDAwIi8+Cgk8cGF0aCBkPSJNMTI5LjM3NSwxNTBjLTYwLjA2MSwwLTEwOC43NSw0OC42ODktMTA4Ljc1LDEwOC43NWgyMTcuNUMyMzguMTI1LDE5OC42ODksMTg5LjQzNiwxNTAsMTI5LjM3NSwxNTB6IiBmaWxsPSIjMDAwMDAwIi8+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==" />
							<span>REGÍSTRATE</span>
	                 	</a>
	              	</div>
				</c:if>
				<c:if test="${!empty clientId && agreement!=''}">
					<div class="box-account__header">
					<c:set var="nombres" value="${name}" />
	                <c:set var="aNombres" value="${fn:split(nombres, ' ')}" />
                     <div class="username">
                        <span id="clientMobile-name">Hola ${fn:toUpperCase(fn:substring(aNombres[0], 0, 1))}${fn:toLowerCase(fn:substring(aNombres[0], 1,fn:length(aNombres[0])))}</span>
                     </div>
                     <div class="balance">
                        <div class="icon">
                           <svg xmlns="http://www.w3.org/2000/svg" width="25.902" height="25.902" viewBox="0 0 25.902 25.902">
                              <g id="Grupo_3396" data-name="Grupo 3396" opacity="0.503">
                                 <path id="Trazado_2159" data-name="Trazado 2159" d="M12.951,0A12.951,12.951,0,1,0,25.9,12.951,12.966,12.966,0,0,0,12.951,0Zm0,24.725A11.774,11.774,0,1,1,24.725,12.951,11.787,11.787,0,0,1,12.951,24.725Z" fill="#fff"/>
                                 <path id="Trazado_2160" data-name="Trazado 2160" d="M29.463,19.5a9.963,9.963,0,1,0,9.963,9.963A9.974,9.974,0,0,0,29.463,19.5Zm0,19.595a9.632,9.632,0,1,1,9.632-9.632A9.643,9.643,0,0,1,29.463,39.095Z" transform="translate(-16.512 -16.511)" fill="#fff"/>
                                 <g id="Grupo_3380" data-name="Grupo 3380" transform="translate(6.974 7.97)">
                                    <g id="S" transform="translate(0 0)">
                                    <g id="Grupo_3379" data-name="Grupo 3379">
                                       <path id="Trazado_2164" data-name="Trazado 2164" d="M155.115,417.911a2.612,2.612,0,0,0,.359,1.283,2.346,2.346,0,0,0,2.126.924,3.674,3.674,0,0,0,1.243-.2,1.426,1.426,0,0,0,1.084-1.4,1.227,1.227,0,0,0-.459-1.081,4.536,4.536,0,0,0-1.459-.55l-1.218-.285a5.429,5.429,0,0,1-1.691-.614,1.962,1.962,0,0,1-.858-1.739,2.716,2.716,0,0,1,.843-2.055,3.327,3.327,0,0,1,2.388-.8,4.071,4.071,0,0,1,2.415.705,2.573,2.573,0,0,1,.994,2.254H159.7a2.393,2.393,0,0,0-.389-1.145,2.2,2.2,0,0,0-1.873-.727,2.1,2.1,0,0,0-1.534.468,1.5,1.5,0,0,0-.467,1.088,1.07,1.07,0,0,0,.552,1,7.939,7.939,0,0,0,1.636.505l1.262.3a3.811,3.811,0,0,1,1.409.589,2.226,2.226,0,0,1,.859,1.89,2.378,2.378,0,0,1-1.095,2.208,4.8,4.8,0,0,1-2.544.664,3.747,3.747,0,0,1-2.645-.885,3.022,3.022,0,0,1-.937-2.385Z" transform="translate(-153.932 -411.385)" fill="#fff"/>
                                    </g>
                                    </g>
                                    <rect id="Rectángulo_1938" data-name="Rectángulo 1938" width="9.796" height="0.996" transform="matrix(0.25, -0.968, 0.968, 0.25, 7.739, 9.971)" fill="#fff"/>
                                 </g>
                              </g>
                              </svg>
                        </div>
                        <div class="amount">
                           <span id="clientSale-amount-menu-lateral">${saldo}</span>
                        </div>
                     </div>
                  </div>
                  <div class="box-account__content">
                     <a href="javascript:void(0)" id="client_lotocard_show_information" class="btn_red_new">Cargar Saldo</a>
                  </div>
				</c:if>
            </div>
            <ul class="menu__list">
            	<c:if test="${!empty gameGanagolBoleto || !empty gdREG.boleto || !empty gdS30.boleto || !empty gdS90.boleto || !empty gdS180.boleto || !empty gdS365.boleto  || !empty ShoppingListTeapuesto || !empty tkREG.boleto || !empty tkS08.boleto || !empty tkS24.boleto || !empty tkS48.boleto || !empty tkS96.boleto || !empty kbREG.boleto || !empty kbS12.boleto || !empty kbS36.boleto || !empty kbS72.boleto || !empty kbS144.boleto || ( (not empty gameKinelo) && (gameKinelo) ) }">            	
            		<li class="menu__list__item slide">
		                <div class="inline-item">
		                	<div class="menu__list__item__flex">
			                    <a href="#">
			                    	<span class="icon-list-item" data="2"><i><svg xmlns="http://www.w3.org/2000/svg" width="16.521" height="12.124" viewBox="0 0 16.521 12.124"><g transform="translate(0.2 -5.8)"><g transform="translate(0 6)"><path d="M15.754,6H.366A.366.366,0,0,0,0,6.366V17.357a.366.366,0,0,0,.366.366H15.754a.366.366,0,0,0,.366-.366V6.366A.366.366,0,0,0,15.754,6Zm-.366,10.1-4.539-4.538-.518.518,4.906,4.906H.883l4.906-4.906-.518-.518L.733,16.1V6.733H15.387Z" transform="translate(0 -6)"/></g><g transform="translate(0.733 6.733)"><path class="a" d="M15.914,8,9.327,14.587,2.74,8H2v.3l7.068,7.068a.366.366,0,0,0,.518,0L16.655,8.3V8Z" transform="translate(-2 -8)"/></g></g></svg></i>Boletos</span></a>
                              	<button class="toggle" href="javascript:void(0)">
                                       <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAQAAAC1+jfqAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAADdcAAA3XAUIom3gAAAAHdElNRQfjBRYUBgCs4+iVAAAAzElEQVQoz3XRzwpBQRTH8e/17ypbZSmFcstCvIGlWChlIQtLC97C3sYDIJ7CG1jP5E9JVsqW5N9YuHFHc3+bMzWfzpzTgBuZkDEMCXzKLqIGqieTvoA7QzKqI9M+IKWQjIirtszqwPodhU2BBhemzsoIQNiUqHHzEktvKKKUqPD4kYAOnCtLFiRoboJG4ObF639N7xNljswzTwMQNkWqPJg5W0MHYVOgru/gASJMnhZnJt7rLzhY5OhyYuys9alCbo3QZ2PNcnv84vfdb7qYOpti37tOAAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDE5LTA1LTIyVDE4OjA2OjAwKzAyOjAw2R+vxgAAACV0RVh0ZGF0ZTptb2RpZnkAMjAxOS0wNS0yMlQxODowNjowMCswMjowMKhCF3oAAAAZdEVYdFNvZnR3YXJlAHd3dy5pbmtzY2FwZS5vcmeb7jwaAAAAAElFTkSuQmCC
                                       ">
                              	</button>
                            </div>
		                </div>
		                <ul class="submenu">
                            <c:if test="${!empty gameGanagolBoleto}">
                            	<li class="submenu__item">
									<a href="#" class="pending" id="game_ganagol_show_shoppingcart">
										<span class="icon-list-item">Boleto Ganagol</span>
									</a>
								</li>
							</c:if>
							<c:if test="${!empty gdREG.boleto}">
								<li class="submenu__item">
								<form action="game_ganadiario_show_shoppingcart.html">						
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Ganadiario Regular</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty gdS30.boleto}">
								<li class="submenu__item">
								<form action="game_ganadiario_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_30">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Ganadiario Suscripción 30</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty gdS90.boleto}">
								<li class="submenu__item">
								<form action="game_ganadiario_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_90">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Ganadiario Suscripción 90</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty gdS180.boleto}">
								<li class="submenu__item">
								<form action="game_ganadiario_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_180">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Ganadiario Suscripción 180</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty gdS365.boleto}">
								<li class="submenu__item">
								<form action="game_ganadiario_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_365">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Ganadiario Suscripción 365</span>
									</a>
								</form>	
								</li>		
							</c:if>
							<c:if test="${!empty ShoppingListTeapuesto}">
								<li class="submenu__item">
								<a href="#" class="pending" id="game_teapuesto_show_shoppingcart_resume">
									<span class="icon-list-item">Boleto Te Apuesto</span>
								</a>
								</li>
							</c:if>
							<c:if test="${!empty tkREG.boleto}">
								<li class="submenu__item">
								<c:if test="${!empty clientId}">
									<form action="game_tinka_show_shoppingcart.html">
								</c:if>
								<c:if test="${empty clientId}">
									<form action="game_tinka_show_shoppingcart_tinkaexpress.html">
								</c:if>														
										<a href="javascript:;" class="pending" onclick="parentNode.submit();">
											<span class="icon-list-item">Boleto Tinka Regular</span>
										</a>
									</form>
								</li>
							</c:if>
							<c:if test="${!empty tkS08.boleto}">
								<li class="submenu__item">
								<form action="game_tinka_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_8">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Tinka Suscripción 8</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty tkS24.boleto}">
								<li class="submenu__item">
								<form action="game_tinka_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_24">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Tinka Suscripción 24</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty tkS48.boleto}">
								<li class="submenu__item">
								<form action="game_tinka_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_48">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Tinka Suscripción 48</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty tkS96.boleto}">
								<li class="submenu__item">
								<form action="game_tinka_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_96">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Tinka Suscripción 96</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty kbREG.boleto}">
								<li class="submenu__item">
								<form action="game_kabala_show_shoppingcart.html">						
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Kabala Regular</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty kbS12.boleto}">
								<li class="submenu__item">
								<form action="game_kabala_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_12">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Kabala Suscripción 12</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty kbS36.boleto}">
								<li class="submenu__item">
								<form action="game_kabala_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_36">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Kabala Suscripción 36</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty kbS72.boleto}">
								<li class="submenu__item">
								<form action="game_kabala_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_72">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Kabala Suscripción 72</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${!empty kbS144.boleto}">
								<li class="submenu__item">
								<form action="game_kabala_show_shoppingcart_suscripcion.html">
									<input  name="boleto" type="hidden" value="boleto_144">							
									<a href="javascript:;" class="pending" onclick="parentNode.submit();">
										<span class="icon-list-item">Boleto Kabala Suscripción 144</span>
									</a>
								</form>
								</li>
							</c:if>
							<c:if test="${(not empty gameKinelo) && (gameKinelo) }">
								<li class="submenu__item">
								<a href="#" class="pending" id="game_kinelo_show_shoppingcart">
									<span class="icon-list-item">Boleto Kinelo</span>
								</a>
								</li>
							</c:if>
                     	</ul>
	              	</li>
              	</c:if>
              	<c:if test="${!empty clientId}">
	              	<li class="menu__list__item">
		                 <div class="inline-item">
		                    <a href="notificaciones.html" onclick="window.location='notificaciones.html'">
		                    	<span class="icon-list-item">
			                    	<i id="iconoNotificacion">
										
									</i>
		                    	Notificaciones</span>
		                    </a>
		                 </div>
	              	</li>
              	</c:if>
              	<li class="menu__list__item">
	                 <div class="inline-item">
	                    <a href="promociones.html" onclick="window.open('<%= Constantes.URL_QW%>/promociones/','_blank')"><span class="icon-list-item">
	                    	<i><svg xmlns="http://www.w3.org/2000/svg" width="18.908" height="15.023" viewBox="0 0 18.908 15.023">
							  <g id="Grupo_4000" data-name="Grupo 4000" transform="translate(0.25 -53.77)">
							    <path id="Trazado_2355" data-name="Trazado 2355" d="M465.332,246h-1.008a.359.359,0,0,0,0,.719h1.008a.359.359,0,0,0,0-.719Z" transform="translate(-447.283 -185.079)" fill="#d6d6d6" stroke="#d6d6d6" stroke-width="0.5"/>
							    <path id="Trazado_2356" data-name="Trazado 2356" d="M464.321,188.71a.358.358,0,0,0,.179-.048l.66-.381a.359.359,0,1,0-.359-.623l-.66.381a.36.36,0,0,0,.18.671Z" transform="translate(-447.281 -128.787)" fill="#d6d6d6" stroke="#d6d6d6" stroke-width="0.5"/>
							    <path id="Trazado_2357" data-name="Trazado 2357" d="M465.161,294.218l-.66-.381a.36.36,0,0,0-.359.623l.66.381a.36.36,0,1,0,.359-.623Z" transform="translate(-447.281 -231.148)" fill="#d6d6d6" stroke="#d6d6d6" stroke-width="0.5"/>
							    <path id="Trazado_2358" data-name="Trazado 2358" d="M13.787,54.02a.762.762,0,0,0-.349.084L.22,59.656a.359.359,0,0,0-.22.331v2.588a.359.359,0,0,0,.22.331l1.939.815h0l.929.39v2.256a1.026,1.026,0,0,0,1.025,1.025H7.388a1.026,1.026,0,0,0,1.024-1.025v-.02l5.026,2.112a.765.765,0,0,0,.348.084c.634,0,1.114-.752,1.469-2.3a23.291,23.291,0,0,0,.472-4.961,23.289,23.289,0,0,0-.472-4.961C14.9,54.772,14.42,54.02,13.787,54.02ZM7.693,66.369a.306.306,0,0,1-.306.306H4.116a.306.306,0,0,1-.306-.306V64.415l3.883,1.631ZM3.248,63.4h0l-.587-.247-.719-.3L1.4,62.624l-.684-.287v-2.11l11.923-5.008q-.092.239-.175.527l0,.012c-.018.058-.1.32-.184.713-.052.234-.109.515-.158.828-.041.258-.077.539-.1.832h0a27.687,27.687,0,0,0-.171,3.151,23.291,23.291,0,0,0,.472,4.961,8.28,8.28,0,0,0,.324,1.1Zm9.346-3.441a1.348,1.348,0,0,1,0,2.657c-.02-.434-.03-.88-.03-1.333S12.574,60.389,12.594,59.958Zm1.961,6.125c-.328,1.432-.695,1.743-.768,1.743l-.01,0-.018-.009-.009,0c-.12-.073-.441-.461-.731-1.729a18.532,18.532,0,0,1-.383-2.747,2.067,2.067,0,0,0,0-4.1,18.543,18.543,0,0,1,.383-2.756c.29-1.267.61-1.656.731-1.729l.032-.013h.005c.073,0,.44.31.768,1.743a22.549,22.549,0,0,1,.454,4.8A22.549,22.549,0,0,1,14.555,66.082Z" transform="translate(0 0)" fill="#d6d6d6" stroke="#d6d6d6" stroke-width="0.5"/>
							  </g>
							</svg></i>
	                    	Promociones</span>
	                    </a>
	                 </div>
              	</li>
                <li class="menu__list__item slide">
		                <div class="inline-item">
		                	<div class="menu__list__item__flex">
			                    <a href="help.html" ><span class="icon-list-item">
			                    	<i><svg id="_906794" data-name="906794" xmlns="http://www.w3.org/2000/svg" width="15.888" height="15.888" viewBox="0 0 15.888 15.888">
									  <g id="Grupo_3233" data-name="Grupo 3233">
									    <g id="Grupo_3232" data-name="Grupo 3232">
									      <circle id="Elipse_115" data-name="Elipse 115" cx="0.776" cy="0.776" r="0.776" transform="translate(7.168 10.97)" fill="#d6d6d6"/>
									      <path id="Trazado_2156" data-name="Trazado 2156" d="M7.944,0a7.944,7.944,0,1,0,7.944,7.944A7.94,7.94,0,0,0,7.944,0Zm0,14.647a6.7,6.7,0,1,1,6.7-6.7A6.7,6.7,0,0,1,7.944,14.647Z" fill="#d6d6d6"/>
									      <path id="Trazado_2157" data-name="Trazado 2157" d="M178.483,128.5A2.485,2.485,0,0,0,176,130.983a.621.621,0,0,0,1.241,0,1.241,1.241,0,1,1,1.241,1.241.621.621,0,0,0-.621.621V134.4a.621.621,0,0,0,1.241,0v-1.009a2.483,2.483,0,0,0-.621-4.887Z" transform="translate(-170.538 -124.512)" fill="#d6d6d6"/>
									    </g>
									  </g>
									</svg></i>
			                    	Ayuda</span>
			                    </a>
			                    <button class="toggle" href="javascript:void(0)">
	                                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAQAAAC1+jfqAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAADdcAAA3XAUIom3gAAAAHdElNRQfjBRYUBgCs4+iVAAAAzElEQVQoz3XRzwpBQRTH8e/17ypbZSmFcstCvIGlWChlIQtLC97C3sYDIJ7CG1jP5E9JVsqW5N9YuHFHc3+bMzWfzpzTgBuZkDEMCXzKLqIGqieTvoA7QzKqI9M+IKWQjIirtszqwPodhU2BBhemzsoIQNiUqHHzEktvKKKUqPD4kYAOnCtLFiRoboJG4ObF639N7xNljswzTwMQNkWqPJg5W0MHYVOgru/gASJMnhZnJt7rLzhY5OhyYuys9alCbo3QZ2PNcnv84vfdb7qYOpti37tOAAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDE5LTA1LTIyVDE4OjA2OjAwKzAyOjAw2R+vxgAAACV0RVh0ZGF0ZTptb2RpZnkAMjAxOS0wNS0yMlQxODowNjowMCswMjowMKhCF3oAAAAZdEVYdFNvZnR3YXJlAHd3dy5pbmtzY2FwZS5vcmeb7jwaAAAAAElFTkSuQmCC">
	                            </button>
                            </div>
		                </div>
		                <ul class="submenu">
                           <li class="submenu__item">
                                <a href="tutoriales.html"  onclick="window.open('<%= Constantes.URL_QW%>/tutoriales/','_blank')">Tutoriales</a>
                           </li>
                           <c:if test="${!empty clientId && agreement!=''}">
                           <li class="submenu__item">
                                <a href="client_edit_auto_control.html" onclick="window.location='client_edit_auto_control.html'">Autocontrol</a>
                           </li>
                           </c:if>
                           <li class="submenu__item">
                                <a href="preguntas-frecuentes.html" onclick="window.open('<%= Constantes.URL_QW%>/preguntas-frecuentes/','_blank')">Preguntas frecuentes</a>
                           </li>
                           <li class="submenu__item">
                                <a href="terminos-condiciones.html" onclick="window.open('<%= Constantes.URL_QW%>/terminos-y-condiciones/','_blank')">Términos y Condiciones</a>
                           </li>
                           <li class="submenu__item">
                                <a href="politica-datos.html" onclick="window.open('<%= Constantes.URL_QW%>/politica-de-datos-personales/','_blank')">Política de datos personales</a>
                           </li>
                           <li class="submenu__item">
                                <a href="derechos-arco.html" onclick="window.location='derechos-arco.html'">Actualiza tus Datos</a>
                           </li>
                           <li class="submenu__item">
                                <a href="politica-cookies.html" onclick="window.open('<%= Constantes.URL_QW%>/politica-de-cookies/','_blank')">Política de Cookies</a>
                           </li>
                           <li class="submenu__item">
                                <a href="https://www.gob.pe/765-inscribirse-en-el-registro-de-personas-prohibidas-a-acceder-a-juegos-de-casinos-y-maquinas-tragamonedas" 
                                onclick="window.open('https://www.gob.pe/765-inscribirse-en-el-registro-de-personas-prohibidas-a-acceder-a-juegos-de-casinos-y-maquinas-tragamonedas')" 
                                >Registro de personas prohibidas</a>
                           </li>
                     	</ul>
	              	</li>
              	<li class="menu__list__item">
	                 <div class="inline-item">
	                    <a href="client_lotocard_show_geolocation_dynamicmap.html" onclick="window.location='client_lotocard_show_geolocation_dynamicmap.html'"><span class="icon-list-item">
	                    	<i><svg xmlns="http://www.w3.org/2000/svg" width="15.965" height="20.959" viewBox="0 0 15.965 20.959">
							  <g id="_612801" data-name="612801" transform="translate(-61)">
							    <g id="Grupo_3918" data-name="Grupo 3918" transform="translate(64.684 3.725)">
							      <g id="Grupo_3917" data-name="Grupo 3917">
							        <path id="Trazado_2359" data-name="Trazado 2359" d="M152.842,91a1.842,1.842,0,1,0,1.842,1.842A1.844,1.844,0,0,0,152.842,91Zm0,2.456a.614.614,0,1,1,.614-.614A.615.615,0,0,1,152.842,93.456Z" transform="translate(-151 -91)" fill="#d6d6d6"/>
							      </g>
							    </g>
							    <g id="Grupo_3920" data-name="Grupo 3920" transform="translate(69.597 8.637)">
							      <g id="Grupo_3919" data-name="Grupo 3919">
							        <path id="Trazado_2360" data-name="Trazado 2360" d="M272.842,211a1.842,1.842,0,1,0,1.842,1.842A1.844,1.844,0,0,0,272.842,211Zm0,2.456a.614.614,0,1,1,.614-.614A.615.615,0,0,1,272.842,213.456Z" transform="translate(-271 -211)" fill="#d6d6d6"/>
							      </g>
							    </g>
							    <g id="Grupo_3922" data-name="Grupo 3922" transform="translate(65.912 3.725)">
							      <g id="Grupo_3921" data-name="Grupo 3921">
							        <path id="Trazado_2361" data-name="Trazado 2361" d="M186.866,91.1a.614.614,0,0,0-.852.17L181.1,98.641a.614.614,0,0,0,1.022.681l4.912-7.368A.614.614,0,0,0,186.866,91.1Z" transform="translate(-180.999 -90.999)" fill="#d6d6d6"/>
							      </g>
							    </g>
							    <g id="Grupo_3924" data-name="Grupo 3924" transform="translate(61)">
							      <g id="Grupo_3923" data-name="Grupo 3923">
							        <path id="Trazado_2362" data-name="Trazado 2362" d="M68.983,0A8.012,8.012,0,0,0,61,8.023,7.915,7.915,0,0,0,62.585,12.8l5.905,7.914a.614.614,0,0,0,.984,0l6.012-8.06.008-.012a7.93,7.93,0,0,0,1.47-4.617A8.012,8.012,0,0,0,68.983,0ZM74.5,11.924l-5.515,7.395-5.413-7.254a6.7,6.7,0,0,1-1.341-4.04,6.755,6.755,0,1,1,13.509,0A6.708,6.708,0,0,1,74.5,11.924Z" transform="translate(-61)" fill="#d6d6d6"/>
							      </g>
							    </g>
							  </g>
							</svg></i>
	                    	Puntos de Venta</span>
	                    </a>
	                 </div>
              	</li>
              	<li class="menu__list__item">
	                 <div class="inline-item">
	                    <a href="https://franquiciastinkateapuesto.com/" onclick="window.location='https://franquiciastinkateapuesto.com/'" target="_blank"><span class="icon-list-item">
	                    	<i><svg xmlns="http://www.w3.org/2000/svg" width="15.965" height="20.959" viewBox="0 0 15.965 20.959">
							  <g id="_612801" data-name="612801" transform="translate(-61)">
							    <g id="Grupo_3918" data-name="Grupo 3918" transform="translate(64.684 3.725)">
							      <g id="Grupo_3917" data-name="Grupo 3917">
							        <path id="Trazado_2359" data-name="Trazado 2359" d="M152.842,91a1.842,1.842,0,1,0,1.842,1.842A1.844,1.844,0,0,0,152.842,91Zm0,2.456a.614.614,0,1,1,.614-.614A.615.615,0,0,1,152.842,93.456Z" transform="translate(-151 -91)" fill="#d6d6d6"/>
							      </g>
							    </g>
							    <g id="Grupo_3920" data-name="Grupo 3920" transform="translate(69.597 8.637)">
							      <g id="Grupo_3919" data-name="Grupo 3919">
							        <path id="Trazado_2360" data-name="Trazado 2360" d="M272.842,211a1.842,1.842,0,1,0,1.842,1.842A1.844,1.844,0,0,0,272.842,211Zm0,2.456a.614.614,0,1,1,.614-.614A.615.615,0,0,1,272.842,213.456Z" transform="translate(-271 -211)" fill="#d6d6d6"/>
							      </g>
							    </g>
							    <g id="Grupo_3922" data-name="Grupo 3922" transform="translate(65.912 3.725)">
							      <g id="Grupo_3921" data-name="Grupo 3921">
							        <path id="Trazado_2361" data-name="Trazado 2361" d="M186.866,91.1a.614.614,0,0,0-.852.17L181.1,98.641a.614.614,0,0,0,1.022.681l4.912-7.368A.614.614,0,0,0,186.866,91.1Z" transform="translate(-180.999 -90.999)" fill="#d6d6d6"/>
							      </g>
							    </g>
							    <g id="Grupo_3924" data-name="Grupo 3924" transform="translate(61)">
							      <g id="Grupo_3923" data-name="Grupo 3923">
							        <path id="Trazado_2362" data-name="Trazado 2362" d="M68.983,0A8.012,8.012,0,0,0,61,8.023,7.915,7.915,0,0,0,62.585,12.8l5.905,7.914a.614.614,0,0,0,.984,0l6.012-8.06.008-.012a7.93,7.93,0,0,0,1.47-4.617A8.012,8.012,0,0,0,68.983,0ZM74.5,11.924l-5.515,7.395-5.413-7.254a6.7,6.7,0,0,1-1.341-4.04,6.755,6.755,0,1,1,13.509,0A6.708,6.708,0,0,1,74.5,11.924Z" transform="translate(-61)" fill="#d6d6d6"/>
							      </g>
							    </g>
							  </g>
							</svg></i>
	                    	Solicita tu Franquicia</span>
	                    </a>
	                 </div>
              	</li>
              	<li class="menu__list__item">
	                 <div class="inline-item">
<!-- 	                    <a href="contacto.html" onclick="window.location='contacto.html'"><span class="icon-list-item"> -->
	                    <a href="contacto.html" onclick="window.open('<%= Constantes.URL_QW%>/contactanos/','_blank')"><span class="icon-list-item">
	                    	<i><svg xmlns="http://www.w3.org/2000/svg" width="16.521" height="12.124" viewBox="0 0 16.521 12.124">
							  <g id="_133667" data-name="133667" transform="translate(0.2 -5.8)">
							    <g id="Grupo_125" data-name="Grupo 125" transform="translate(0 6)">
							      <g id="Grupo_124" data-name="Grupo 124">
							        <path id="Trazado_304" data-name="Trazado 304" d="M15.754,6H.366A.366.366,0,0,0,0,6.366V17.357a.366.366,0,0,0,.366.366H15.754a.366.366,0,0,0,.366-.366V6.366A.366.366,0,0,0,15.754,6Zm-.366,10.1-4.539-4.538-.518.518,4.906,4.906H.883l4.906-4.906-.518-.518L.733,16.1V6.733H15.387Z" transform="translate(0 -6)" fill="#d6d6d6" stroke="#d6d6d6" stroke-width="0.4"/>
							      </g>
							    </g>
							    <g id="Grupo_127" data-name="Grupo 127" transform="translate(0.733 6.733)">
							      <g id="Grupo_126" data-name="Grupo 126">
							        <path id="Trazado_305" data-name="Trazado 305" d="M15.914,8,9.327,14.587,2.74,8H2v.3l7.068,7.068a.366.366,0,0,0,.518,0L16.655,8.3V8Z" transform="translate(-2 -8)" fill="#d6d6d6" stroke="#d6d6d6" stroke-width="0.4"/>
							      </g>
							    </g>
							  </g>
							</svg></i>
	                    	Contáctanos</span>
	                    </a>
	                 </div>
              	</li>              	           	
              	<c:if test="${!empty clientId && agreement!=''}">
              		<li class="menu__list__item">
	                     <div class="inline-item">
	                        <a href="#" id="security-close-session"><span class="icon-list-item"><i><svg xmlns="http://www.w3.org/2000/svg" width="17.229" height="17.228" viewBox="0 0 17.229 17.228"><g transform="translate(0.199 0.2)"><path d="M16.8,7.46a.306.306,0,0,0,0-.234.312.312,0,0,0-.066-.1L13.067,3.455a.306.306,0,1,0-.433.433l3.149,3.149H11.015V.306A.306.306,0,0,0,10.709,0H.307A.28.28,0,0,0,.279.006a.282.282,0,0,0-.048.01A.3.3,0,0,0,.152.048c-.008,0-.018,0-.025.01S.11.075.1.082L.085.1A.318.318,0,0,0,.029.18C.026.186.025.192.022.2A.305.305,0,0,0,0,.306V14.38a.3.3,0,0,0,.022.109.306.306,0,0,0,.016.032.294.294,0,0,0,.04.06l.028.028a.3.3,0,0,0,.059.04.272.272,0,0,0,.034.017l.014.007,6.731,2.142a.316.316,0,0,0,.092.014.306.306,0,0,0,.306-.306V14.686h3.365a.306.306,0,0,0,.306-.306V7.649h4.769L12.635,10.8a.306.306,0,1,0,.433.433l3.671-3.671A.308.308,0,0,0,16.8,7.46ZM6.732,16.1.613,14.156V.724L6.732,2.671ZM10.4,14.074H7.344V2.448a.306.306,0,0,0-.213-.292L2.278.612H10.4Z" transform="translate(0)"/><path class="a" d="M15.95,29.633l-1.53-.612a.306.306,0,1,0-.227.568l1.53.612a.3.3,0,0,0,.114.022.306.306,0,0,0,.114-.59Z" transform="translate(-9.716 -20.127)"/></g></svg></i>Cerrar Sesión</span></a>
	                     </div>
                  	</li>
              	</c:if>
            </ul>
        </div>
    </nav>
    <button class="close-button" id="close-button">Close Menu</button>
</div>


<div id="loading">
	<div class="sk-circle">
	  <div class="sk-circle1 sk-child"></div>
	  <div class="sk-circle2 sk-child"></div>
	  <div class="sk-circle3 sk-child"></div>
	  <div class="sk-circle4 sk-child"></div>
	  <div class="sk-circle5 sk-child"></div>
	  <div class="sk-circle6 sk-child"></div>
	  <div class="sk-circle7 sk-child"></div>
	  <div class="sk-circle8 sk-child"></div>
	  <div class="sk-circle9 sk-child"></div>
	  <div class="sk-circle10 sk-child"></div>
	  <div class="sk-circle11 sk-child"></div>
	  <div class="sk-circle12 sk-child"></div>
	</div>
</div>

<%--  Desarrollo copa en tu casa DRUIZ no tocar
   <div id="popup-copacasa" class="overlay">
						<div id = "popup-scrool-copa" class="popup popup-sm-copacasa margen" style="text-align: center;">
							<a class="close-copa js-close-modal" href="#">&times;</a>
							<div class="wrap-modal">
								<div class="gana-copa-header">
									<img class="img-logo-teapuesto-popup" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif">
									<div class="descripcion-copa-casa">
										<span>¡GANA CON</span><br>
										<span>LA COPA EN TU CASA!</span>
									</div>
								</div>
								<div class="gana-copa-footer">
									<img class="home-popup" src="layer-view-image/game/copaentucasa/Home_popup.jpg">
									<div class="descripcion-footer">
										<span>Todas tus jugadas desde S/ 5</span><br>
										<span>participan AUTOMÁTICAMENTE</span>
									</div>
									<button type="button" id="btn_mobile_ingresar_copacasa" onclick="return false;"class="button-ingresar">Ingresa aquí</button>								
								</div>
																							
							</div>
						</div>
 </div>-->
 
 
		<!--  Desarrollo copa bicolor en tu casa DRUIZ no tocar-->
	 	  <div id="popup-copacasa" class="overlay">
			<div id = "popup-scrool-copa" class="popup popup-sm-copacasa margen" style="text-align: center;">
			<a class="close-copa js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="gana-copa-footer" style="background-color: #fff;border-radius: 20px;">
						<img class="home-popup" src="layer-view-image/game/copabicolor/img-popup-premiazogg.png">
						<button type="button" id="btn_mobile_ingresar_copabicolor" onclick="return false;"class="button-ingresar"  >Infórmate aquí</button>								
					</div>															
				</div>
			</div>
		</div>  --%> 
		
		<!-- Popup Avion Qatar -->	  
		<!-- <div id="popup-avionqatar" class="overlay">
			<div id = "popup-scrool-copa" class="popup popup-sm-avionqatar" style="text-align: center;">
				<a class="close-avionqatar js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<img class="home-popup" src="layer-view-image/game/teapuesto/avionQatar/popup_taqatar.png" alt="Apuestas Mundial Qatar 2022 Te Apuesto">
					<button style="top: -87px;position: relative;" type="button" id="btn_home_avion_qatar" onclick="return false;"class="button-avion-qatar-amarillo"  >Infórmate aquí</button>																				
				</div>
			</div>
		</div>
		
		<div id="popup-avionQatar-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-avionqatar">
				<a class="close-avionqatar js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
						<img src="layer-view-image/game/teapuesto/avionQatar/cabecera_popup.png" alt="Apuestas Mundial Qatar 2022 Te Apuesto" style="display: block;"> 
						<div id= "nivel-avionQatar"></div>																		
				</div>
			</div>
		</div>-->
		<!-- Popup Avion Qatar -->

		<!-- Popup Avion Estambul -->	  
		<!--<div id="popup-avionestambul" class="overlay">
			<div id = "popup-scrool-copa" class="popup popup-sm-avionestambul" style="text-align: center;">
				<a class="close-avionestambul js-close-modal" href="#" onclick="evalPopupInformativo();">&times;</a>
				<div class="wrap-modal">
					<img class="home-popup" src="layer-view-image/game/teapuesto/avionEstambul/popup-estambul.png" alt="Te Apuesto te lleva a la Final de la Champions 2023">
					<button style="top: -62px;position: relative;" type="button" id="btn_home_avion_estambul" onclick="return false;"class="button-avion-qatar-naranja"  >Infórmate aquí</button>																				
				</div>
			</div>
		</div>
		
		<div id="popup-avionEstambul-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-avionestambul">
				<a class="close-avionestambul js-close-modal" href="#" onclick="evalPopupInformativo();">&times;</a>
				<div class="wrap-modal">
						<img src="layer-view-image/game/teapuesto/avionEstambul/popup-categorias-estambul.png" alt="Te Apuesto te lleva a la Final de la Champions 2023" style="display: block;"> 
						<div id= "nivel-avionEstambul" style="background-color: #d7e2e4;"></div>																		
				</div>
			</div>
		</div>
		-->
		<!-- Popup Avion Estambul -->

		<!-- Popup Avion Peru -->
		<!-- Se comenta solicitado por NNDD 23/05/2024 -->
		<!-- 	  -->
		<!--<div id="popup-avionPeru" class="overlay">
			<div id = "popup-scrool-copa" class="popup popup-sm-avionPeru" style="text-align: center;">
				<a class="close-avionPeru js-close-modal" href="#" onclick="evalPopupInformativo();">&times;</a>
				<div class="wrap-modal">
					<img class="home-popup" src="layer-view-image/game/teapuesto/avionPeru/popup-peru.png" alt="Avión del Hincha Eliminatorias 2026">
					<button style="top: -62px;position: relative;background-color: #000000;" type="button" id="btnHomeAvionPeru" onclick="return false;"class="button-avion-qatar-naranja"  >Infórmate aquí</button>																				
				</div>
			</div>
		</div>
		
		<div id="popup-avionPeru-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-avionPeru">
				<a class="close-avionPeru js-close-modal" href="#" onclick="evalPopupInformativo();">&times;</a>
				<div class="wrap-modal">
						<img src="layer-view-image/game/teapuesto/avionPeru/popup-categorias-peru.png" alt="Avión del Hincha Eliminatorias 2026" style="display: block;"> 
						<div id= "nivel-avionPeru" style="background-color: #d7e2e4;"></div>
				</div>
			</div>
		</div>-->
		<!-- Popup Avion Peru -->
		
		<!-- Popup Juega Gana con Virtuales -->	  
		<!-- <div id="popup-juegaGanaVirtuales" class="overlay">
			<div id = "popup-scrool-copa" class="popup popup-sm-juegaGanaVirtuales" style="text-align: center;">
				<a class="close-juegaGanaVirtuales js-close-modal" >&times;</a>
				<div class="wrap-modal">
					<img class="home-popup" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/popup-virtuales.png" alt="Juega Deportes Virtuales">
					<button type="button" id="btn_home_juegaGanaVirtuales" class="button-juegaGanaVirtuales-naranja btn-popup-informate" >Infórmate aquí</button>																				
				</div>
			</div>
		</div> -->
		<!--
		<div id="popup-juegaGanaVirtuales-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-juegaGanaVirtuales">
				<a class="close-juegaGanaVirtuales js-close-modal" onclick="evalPopupInformativo();">&times;</a>
				<div class="wrap-modal">
						<img src="layer-view-image/game/virtuales/juegaGanaConVirtuales/popup-categorias-virtuales.png"  alt="Juega Deportes Virtuales" style="display: block;"> 
						<div id= "nivel-juegaGanaVirtuales">
							<div class="posicion-nivel-img-popup">
								<img   class="level-header-copa-casa-popup">
								<div class="desc-nivel-position-popup">
									<span class="tipo-nivel-popup">typeLevel</span><br>
									<span class="tipo-nivel-descripcion-superior-popup">Tienes </span>
									<span class="puntaje-por-nivel-popup">Score</span><br>
									<span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>
									<span class="tipo-nivel-descripcion-popup">de premios mayores</span>
								</div>
							</div>
							<div class="copa-opciones-popup">
								<button type="button" id="btnJuegaGanaDDVVResultados" onclick="return false;" class="button-juegaGanaVirtuales-blanco" style="width:140px;margin-right: 5px;border-color: #e16e1a;">Ver mis jugadas</button>
								<button type="button" id="btn_mobile_virtuales_home" onclick="return false;" class="button-juegaGanaVirtuales-naranja" style="width:158px;margin-bottom: 7px;">Juega desde S/ 5</button>
								<p class="jugadas-popup-descripcion" style="color: #e16e1a; ">Tus jugadas WEB participan automáticamente</p>
								<p class="jugadas-popup-descripcion2" style="color: #000000">¡Son S/ 10,000 en saldo al instante!</p>
							</div>
						</div>																		
				</div>
			</div>
		</div>-->
		<!-- Popup Juega Gana con Virtuales -->
		
	<!-- Popup Casino -->	    
	    <div id="popup-casino" class="overlay">
		    <div class="popup popup-sm-tinka margen" style="text-align: center;">
				<a class="close-copa js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-tinka-footer" style="background-color:#fff;">
						<img class="home-popup" src="layer-view-image/game/casino/popup_casino.jpg" alt="Jugar Casino Online">
						<button type="button" id="btn_mobile_ingresar_casino" onclick="return false;"class="button-ingresar" style="background-color:#febb05;margin-right: 15px;"><a href="#" style="text-decoration: none;color: #000000;">Juega aquí</a></button>								
					</div>																			
				</div>
			</div>						
		</div>			
   	<!-- fin popup Casino -->

    <!-- Popup La Tinka -->	    
	    <div id="popup-tinka" class="overlay">
		    <div class="popup popup-sm-tinka margen" style="text-align: center;">
				<a class="close-copa js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-tinka-footer" style="background-color:#fff;">
						<img class="home-popup" src="layer-view-image/game/tinka/popup_siosi_100.jpg?v=1" alt="Jugar La Tinka Lotería">
						<button type="button" id="btn_mobile_ingresar_tinka" onclick="return false;"class="button-ingresar" style="background-color:#E30613;margin-right: 15px;"><a href="#" style="text-decoration: none;color: white;">Juega aquí</a></button>								
					</div>																			
				</div>
			</div>						
		</div>			
   	<!-- fin popup La Tinka -->	
   	 
   	<!-- Popup La Tinka 3x12 -->
	    <div id="popup-tinka-3x12" class="overlay">
		    <div class="popup popup-standard margen">
				<a class="close-popup" onclick="closePopup(this)" >&times;</a> 
				<div class="popup-img-button">
					<img class="home-popup" src="layer-view-image/game/tinka/popup_juega_tinka.jpg" alt="Juega Tinka">
					<div class="footer-button accion-1">
						<button id="btn_juega_tinka_3x12" class="button-ingresar">Juega aquí</button>
					</div>
					<div class="footer-button accion-2">
						<a id="enlace_ingresar_tinka_3x12">Infórmate de los términos y condiciones</a>
					</div>
				</div>
			</div>						
		</div>			
   	<!-- fin popup La Tinka 3x12 -->
   	
   	<!-- Popup Gana Diario 3x5 -->
	    <div id="popup-ganadiario-3x5" class="overlay">
		    <div class="popup popup-standard margen">
				<a class="close-popup" onclick="closePopup(this)" >&times;</a> 
				<div class="popup-img-button">
					<img class="home-popup" src="layer-view-image/game/ganadiario/popup_juega_gana_diario_3x5.jpg" alt="Juega Gana Diario">
					<div class="footer-button accion-1">
						<button id="btn_juega_ganadiario_3x5" class="button-ingresar">Juega aquí</button>
					</div>
					<div class="footer-button accion-2">
						<a id="enlace_ingresar_ganadiario_3x5">Infórmate de los términos y condiciones</a>
					</div>
				</div>
			</div>						
		</div>			
   	<!-- fin popup Gana Diario 3x5 -->
   	 
   	<%@ include file="popups.jsp" %>
   	 
   	<!-- Popup avion del hincha -->	    
 	<!--    <div id="popup-hincha-informate" class="overlay">
			<div class="popup popup-sm-hincha margen" style="border-radius: 7px;">
				<a class="close-hincha js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-hincha-footer" style="background-color:#fff;">
						<img class="home-popup" style="border-radius: 7px;" src="layer-view-image/game/aviondelhincha/popup-informate.jpg" alt="tinka">
						<button type="button" id="btn_mobile_informate_hincha" onclick="return false;"class="button-informate" style="margin-right: 15px;"><a href="#" style="text-decoration: none;color: white;">INFÓRMATE AQUÍ</a></button>								
					</div>																			
				</div>
			</div>
		</div>
        
 	    <div id="popup-hincha-participa" class="overlay">
			<div class="popup popup-sm-hincha margen" style="border-radius: 7px;">
				<a class="close-hincha js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-hincha-footer" style="background-color:#fff;">
						<img class="home-popup" style="border-radius: 7px;" src="layer-view-image/game/aviondelhincha/popup-participa.jpg">
						<button type="button" id="btn_mobile_participa_hincha" onclick="return false;"class="button-participa" style="margin-right: 15px;"><a href="#" style="text-decoration: none;color: white;">PARTICIPA AQUÍ<img src="layer-view-image/game/aviondelhincha/check.png" style="margin-left: 10px;vertical-align: text-bottom;"></a></button>								
					</div>																			
				</div>
			</div>
		</div>-->
	<!-- fin popup avion del hincha -->
   	
   	<!-- popup Faltan Datos de Usuario --> 
    <div id="popupDataComplete" class="overlayData">
		<div class="popup popup-sm">
			<a class="close-tinka js-close-modal" id="closeDirec" >&times;</a>
			<div>
				<div><img id="imgPopupData" src="layer-view-image/client/icon-editar.png"></div>
				<div class="mensaje-popup" >
					<span id="popupDataTitulo" >Vemos que a tu perfil le faltan algunos datos </span>
					<span>¡Complétalo ahora!</span>
					<span id="popupDataMensaje">Recuerda que para poder procesar tu retiro, necesitamos validar tus datos, los cuales deben ser precisos y estar completos.</span>
				</div>
				<div class="popupDataButton">
					<button id="btnEditarPerfil" class="my-button" type="button" style="width: 50%;">EDITAR PERFIL</button>
				</div>
			</div>
		</div>
	</div>
	<!-- fin popup Faltan Datos de Usuario --> 
	
	<!-- popup Mi Perfil --> 
	<div id="popupMiPerfil" class="overlayData">
		<div class="popup popup-sm"> 
			<div>
				<div><img id="imgPopupPerfil" src="layer-view-image/client/icon-ok.png" style="margin-bottom:20px;"></div>
				<div class="mensaje-popup" >
					<span id="popupPerfilTitulo" ></span>
					<span id="popupPerfilMensaje"></span>
				</div>
				<div class="popupDataButton" id="popupPerfilButton">
				</div>
			</div>
		</div>
	</div>				
	<!-- fin popup Mi Perfil --> 
			
	<!-- Popup GG-3VS -->
 	    <div id="popup-GG-3VS" class="overlay">
			<div class="popup popup-sm-GG-3VS" >
				<a class="close-GG-3VS js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-GG-3VS-footer" style="background-color:#fff; text-align: center;">
						<img class="home-popup" src="layer-view-image/game/ganagol/popup_gg.jpg" alt="Jugar Ganagol Apuestas de Fútbol">
						<button type="button" id="btn_desktop_GG_3VS" onclick="return false;"class="button-GG-3VS">
							<a href="#" style="text-decoration: none;color: white;">Haz tu jugada aquí</a>
						</button>
					</div>
				</div>
			</div>
		</div>
	<!-- fin Popup GG-3VS -->		
				
	<!-- Popup motazo-DDVV -->
 	<!--    <div id="popup-motazoDDVV" class="overlay">
			<div class="popup popup-sm-GG-3VS" >
				<a class="close-GG-3VS js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-GG-3VS-footer" style="background-color:#fff; text-align: center;">
						<img class="home-popup" src="layer-view-image/game/virtuales/popupMotazoDDVV.jpg" alt="Jugar Deportes Virtuales">
						<button type="button" id="btn_desktop_motazo_DDVV" onclick="return false;"class="button-GG-3VS">
							<a href="#" style="text-decoration: none;color: white;">Infórmate aquí</a>
						</button>
					</div>
				</div>
			</div>
		</div>-->
	<!-- fin Popup motazo-DDVV -->
		
	<!-- Banner Cookies -->		
<!-- 	<div id="bannerCookies" class="BannerCookies closeBanner" > -->
<!-- 		<div class="txtBanner"> -->
<!-- 			La Tinka utiliza cookies. Al hacer click en el botón Aceptar, aceptas su uso. -->
<!-- 		    Obtén más información sobre las cookies y cómo evitar su uso en este <span id="enlaceBanner">enlace.</Span> -->
<!-- 		</div> -->
<!-- 		<button type="button" id="btnBannerCookies" onclick="return false;" class="buttonBanner"> -->
<!-- 			Aceptar -->
<!-- 		</button> -->
<!-- 	</div>			 -->

<div>
	<div id="bannerCookiesModal"></div>
	<div id="bannerCookies" class="ck-font-family ck-banner-cookies" style="text-align: left; letter-spacing: normal;" > 
		<div class="ck-cookie-bar shadow-lg z-50" id="cookieBanner" style="z-index: 100;">
	      <div>
	        <div class="ck-cookie-paragraph">
	          La Tinka utiliza cookies para ofrecer la mejor experiencia a nuestros usuarios. Al seguir navegando aceptas el uso de cookies.
	        </div>
	      </div>
	      <div class="ck-btn-container d-flex">
	        <button
	          class="ck-custom-botton ck-conf-btn"
	          data-bs-toggle="modal"
	          data-bs-target="#cookieModal"
	        >
	          Configurar cookies
	        </button>
	        <button id="acceptAllBtn" class="ck-custom-botton ck-accept-btn">
	          Aceptar todas
	        </button>
	      </div>
	    </div>
	<div class="ckb-modal fade" tabindex="-1" id="cookieModal" style="z-index: 2000;">
	      <div class="ckb-modal-dialog">
	        <div class="ckb-modal-content ck-custom-modal-content" style="text-align: justify !important;">
	          <div class="ckb-modal-header ck-custom-modal-header">
	            <h5 class="ck-custom-modal-title">Configuración de Cookies</h5>
	            <img class="ck-logo" src="layer-view-image/client/logo-banner-cookies.png" />
	          </div>
			  
	          <div class="ckb-modal-body">
	            <div class="ck-main-text">
	              Nuestros sitios web podrían obtener o guardar información en tu
	              navegador, mediante el uso de cookies. Respetando tu derecho a la
	              privacidad, puedes escoger no permitirnos usar ciertas cookies,
	              sin embargo, el bloqueo de algunos tipos de cookies puede afectar
	              tu experiencia en nuestros sitios y con los servicios que te
	              ofrecemos.
	            </div>
	            <div
	              class="accordion ck-accordion accordion-flush"
	              id="accordionFlushExample"
	            >
	              <div class="accordion-item">
	                <div
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseOne"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseOne"
	                  >
	                    <label class="ck-color-gray">
	                      Estrictamente necesarias
	                    </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <label
	                      class="ck-siempre-label"
	                      onclick="event.stopPropagation()"
	                    >
	                      Siempre activas
	                    </label>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseOne"
	                      data-bs-target="#flush-collapseOne"
	                      class="accord ck-accord ck-arrow-1"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseOne"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies son necesarias para que el sitio web funcione,
	                    no se pueden desactivar en nuestro sistema. No guardan
	                    ninguna información personal identificable. Puedes
	                    configurar tu navegador para bloquear o alertar sobre estas
	                    cookies, pero algunas partes del sitio no funcionarán.
	                  </div>
	                </div>
	              </div>
	              <div class="accordion-item">
	                <div
	                  id="main-accord"
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseTwo"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseTwo"
	                  >
	                    <label class="ck-color-gray"> Estadísticas </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <div class="ck-switch-container">
	                      <div class="ck-switch">
	                        <input
	                          id="userAcceptsStatistics"
	                          type="checkbox"
	                          class="ck-switch-input"
	                        />
	                        <label
	                          for="userAcceptsStatistics"
	                          class="ck-switch-label"
	                        ></label>
	                      </div>
	                    </div>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseTwo"
	                      data-bs-target="#flush-collapseTwo"
	                      class="accord ck-accord ck-arrow-2"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseTwo"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies registran el número de visitantes y su
	                    comportamiento en el sitio, para medir su actividad y
	                    elaborar perfiles de navegación de usuarios.
	                  </div>
	                </div>
	              </div>
	              <div class="accordion-item">
	                <div
	                  id="main-accord"
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseThree"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseThree"
	                  >
	                    <label class="ck-color-gray"> Marketing </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <div class="ck-switch-container">
	                      <div class="ck-switch">
	                        <input
	                          id="userAcceptsMarketing"
	                          type="checkbox"
	                          class="ck-switch-input"
	                        />
	                        <label
	                          for="userAcceptsMarketing"
	                          class="ck-switch-label"
	                        ></label>
	                      </div>
	                    </div>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseThree"
	                      class="accord ck-accord ck-arrow-3"
	                      data-bs-target="#flush-collapseThree"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseThree"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies son utilizadas para fines
	                    publicitarios (registrar una identificación geográfica en
	                    dispositivos móviles, medir la eficacia de un anuncio y
	                    almacenar preferencias del reproductor de video del
	                    usuario).
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	
	          <div class="ckb-modal-footer ck-modal-footer">
	            <div class="ck-modal-btns d-flex">
	              <button
	                id="rejectCustomizationsBtn"
	                class="ck-custom-botton ck-rechazar-btn"
	                data-bs-dismiss="modal" onclick="hideModalCK();"
	              >
	                Rechazar todas
	              </button>
	              <button
	                data-bs-dismiss="modal" onclick="hideModalCK();"
	                id="acceptCustomizationsBtn"
	                class="ck-custom-botton ck-guarder-btn"
	              >
	                Guardar cambios
	              </button>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	</div>
</div>
	<!-- fin Banner Cookies -->			
					
<script type="text/javascript" src="layer-view-script/game/copabicolor/jquery_1.7.1.min.js"></script>
<!--<script type="text/javascript" src="layer-view-script/game/copabicolor/popup_time.js?v=1"></script>-->
<script type="text/javascript" src="layer-view-script/game/tinka/tinka-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/game/casino/casino-popup_time.js"></script>
<!--<script type="text/javascript" src="layer-view-script/game/aviondelhincha/hincha-popup_time.js"></script>--> 
<script type="text/javascript" src="layer-view-script/game/ganagol/GG3VS-popup_time.js"></script>
<!--<script type="text/javascript" src="layer-view-script/game/virtuales/motazoDDVV-popup_time.js"></script>--> 

<!--  <script type="text/javascript" src="layer-view-script/game/teapuesto/avionQatar/avionQatar-popup_time.js?v=3"  charset="UTF-8"></script> --> 
<script type="text/javascript" src="layer-view-script/client/validateDataClient.js?v=8"></script>
<script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=15"></script>
<!-- <script type="text/javascript" src="layer-view-script/game/virtuales/juegaGanaConVirtuales.js?v=2"  charset="UTF-8"></script> -->
<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>
<!--  <script type="text/javascript" src="layer-view-script/game/teapuesto/avionEstambul/avionEstambul-popup_time.js?v=7"  charset="UTF-8"></script> -->
<!--  <script type="text/javascript" src="layer-view-script/game/teapuesto/avionPeru/avionPeru.js?v=5"  charset="UTF-8"></script> -->
<script type="text/javascript">
														
			var URLactual = window.location.pathname;
			/*Desarrollo copa bicolor en tu casa DRUIZ no tocar*/
			window.addEventListener("orientationchange", ()=> {
				console.log(window.screen.orientation.type);
			    console.log('cambio horientazion');
			    if(window.screen.orientation.type == "landscape-primary"){
			    	$('#popup-scrool-copa').removeClass("margen");
			    	
				 }else if(window.screen.orientation.type == "portrait-primary" ){
					 $('#popup-scrool-copa').addClass("margen");
				 }
			});

			

			$(document).delegate('#btn_mobile_ingresar_copabicolor', 'click', function () {			
				 window.location.href = 'premiazoganagol.html';		   
			});	
 
			function closeMensajeNotificacion(){
				try {
					cerrarMensajeNotificacion();
				} catch (e) {
					
				}
			}
			
			function openModal(popup,ctrl) {
				$(popup).addClass('opened');
				$('body').addClass('modal');
				if($.trim(ctrl).length>0) control = $.trim(ctrl);
			}

			//popup tinka 
 			var flagPromoTinka = $("#flagPromoTinka").val();							
			if(flagPromoTinka == 'true'){
				if(window.location.pathname.includes("game_tinka_show_menu.html") || window.location.pathname.includes("home.html")){
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(()=>{} , timeUp) ;					
				}
			}
			//fin popup tinka
			
			
			
			//popup Casino
			var flagPromoCasino = $("#flagPromoCasino").val();
			var fechaFinCasino = new Date(2022,8,30,23,59,59); // 30/09/22
			var fechaActualCasino = new Date();			
			$(document).ready(function(){				
				$.ajax({
			        type: "POST",
			        url: "hasPendingNotificationsRead.html",
			        dataType: "json",
			        async: false
				})
				.done(function(data) {
					if(data.notificacionesPendientes>0){
						$("#iconoNotificacion").html('<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 39.2 41.2" style="enable-background:new 0 0 39.2 41.2;" xml:space="preserve"> <style type="text/css"> .stbc0{display:none;} .st1{display:inline;fill:#959595;stroke:#959595;stroke-width:0.25;stroke-miterlimit:10;} .st2{fill:#FFFFFF;stroke:#FFFFFF;stroke-miterlimit:10;} 	.st3{fill:#E20E18;}  </style> <g id="Capa_1_00000042699466363403887480000008827349134144596363_" class="stbc0"> <path class="st1" d="M16.9,33.3c-0.4-0.5-0.7-0.8-0.7-1.6v-3.2c0-2.6-1.3-4.5-3.5-5.1C12.5,22.6,11.8,22,11,22 c-0.9,0-1.6,0.6-1.7,1.4c-2.2,0.6-3.5,2.5-3.5,5.1v3.3c0,0.7-0.3,1.1-0.7,1.6c-0.5,0.7-1.2,1.5-1.2,3.5c0,0.1,0.1,0.2,0.2,0.2H8 c0.1,1.6,1.4,2.8,3,2.8s2.9-1.3,3-2.8h3.9c0.1,0,0.2-0.1,0.2-0.2C18.1,34.8,17.4,34,16.9,33.3z M11,39.4c-1.4,0-2.5-1.1-2.6-2.4 h5.2C13.5,38.3,12.4,39.4,11,39.4z M13.8,36.6H8.2H4.3c0-1.7,0.6-2.3,1.1-3c0.4-0.5,0.8-1,0.8-1.8v-3.3c0-2.5,1.2-4.2,3.3-4.7 c0.1,0,0.2-0.1,0.2-0.2c0.1-0.7,0.6-1.2,1.3-1.2s1.2,0.5,1.3,1.2c0,0.1,0.1,0.2,0.2,0.2c2.1,0.5,3.3,2.3,3.3,4.7v3.3 c0,0.9,0.4,1.4,0.8,1.8c0.5,0.6,1.1,1.3,1.1,3H13.8z"/> </g> <path class="st2" d="M31.6,26.4c-0.8-1-1.6-1.8-1.6-3.4v-7c0-5.6-2.8-9.8-7.6-11c-0.4-1.8-2-3-3.6-3c-2,0-3.4,1.2-3.6,3 c-4.8,1.4-7.6,5.4-7.6,11v7.2c0,1.6-0.6,2.4-1.6,3.4c-1,1.6-2.6,3.2-2.6,7.6c0,0.2,0.2,0.4,0.4,0.4h8.4c0.2,3.4,3,6,6.4,6 s6.2-2.8,6.4-6h8.4c0.2,0,0.4-0.2,0.4-0.4C34.2,29.6,32.6,28,31.6,26.4z M18.9,39.6c-3,0-5.4-2.4-5.6-5.2h11.2 C24.3,37.2,21.9,39.6,18.9,39.6z M24.9,33.6h-12H4.6c0-3.6,1.2-5,2.4-6.4c0.8-1,1.8-2.2,1.8-3.8V16c0-5.4,2.6-9,7.2-10.2 c0.2,0,0.4-0.2,0.4-0.4C16.4,4,17.4,3,19,3s2.6,1,2.8,2.6C21.8,5.8,22,6,22.2,6c4.6,1,6.7,5,6.7,10l0.1,7.2c0,2,0.9,3,1.9,3.8 c1,1.2,2,3,2,6.6h-7.6H24.9z"/> <circle class="st3" cx="29.9" cy="7.4" r="6.5"/> </svg>');
						$("#bellNotification").html('<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 25 25" style="enable-background:new 0 0 25 25;" xml:space="preserve"> <style type="text/css"> .stbell0{fill:#E30B17;} .stbell1{fill-rule:evenodd;clip-rule:evenodd;fill:#FFFFFF;} </style> <circle class="stbell0" cx="12.9" cy="12.5" r="11.2"/> <path class="stbell1" d="M12.9,5.9c-0.8,0-0.9,0.3-1.2,1c-0.1,0.2-0.2,0.4-0.5,0.5c-1.5,0.6-1.9,1.7-2,3c-0.1,1.2,0.1,2.5-0.2,3.3 c-0.1,0.4-0.6,0.9-0.9,1.4c-0.3,0.5-0.6,1.2-0.3,1.8h5.1H18c0.2-0.7,0-1.3-0.3-1.8c-0.3-0.5-0.8-1-0.9-1.4c-0.3-0.8-0.1-2.1-0.2-3.3 c-0.1-1.2-0.5-2.4-2-3c-0.4-0.1-0.5-0.3-0.5-0.5C13.8,6.2,13.7,5.9,12.9,5.9 M14.7,17.7c-0.2,0.8-0.9,1.4-1.8,1.4 c-0.9,0-1.6-0.7-1.8-1.4l1.8,0L14.7,17.7z"/> </svg>');
						$("#bellNotification").css("display","block");
					}else{
						$("#iconoNotificacion").html('<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 39.2 40.3" style="enable-background:new 0 0 39.2 40.3;" xml:space="preserve"> <style type="text/css"> .stbc0{display:none;} .st1{display:inline;fill:#959595;stroke:#959595;stroke-width:0.25;stroke-miterlimit:10;} .st2{fill:#FFFFFF;stroke:#FFFFFF;stroke-miterlimit:10;} .st3{display:none;fill:#E20E18;} </style> <g id="Capa_1_00000171680712685116261680000003486186573347873176_" class="stbc0"> <path class="st1" d="M16.9,23.4c-0.4-0.5-0.7-0.8-0.7-1.6v-3.2c0-2.6-1.3-4.5-3.5-5.1c-0.2-0.8-0.9-1.4-1.7-1.4 c-0.9,0-1.6,0.6-1.7,1.4c-2.2,0.6-3.5,2.5-3.5,5.1v3.3c0,0.7-0.3,1.1-0.7,1.6C4.6,24.2,3.9,25,3.9,27c0,0.1,0.1,0.2,0.2,0.2H8 c0.1,1.6,1.4,2.8,3,2.8s2.9-1.3,3-2.8h3.9c0.1,0,0.2-0.1,0.2-0.2C18.1,24.9,17.4,24.1,16.9,23.4z M11,29.5c-1.4,0-2.5-1.1-2.6-2.4 h5.2C13.5,28.4,12.4,29.5,11,29.5z M13.8,26.7H8.2H4.3c0-1.7,0.6-2.3,1.1-3c0.4-0.5,0.8-1,0.8-1.8v-3.3c0-2.5,1.2-4.2,3.3-4.7 c0.1,0,0.2-0.1,0.2-0.2c0.1-0.7,0.6-1.2,1.3-1.2s1.2,0.5,1.3,1.2c0,0.1,0.1,0.2,0.2,0.2c2.1,0.5,3.3,2.3,3.3,4.7v3.3 c0,0.9,0.4,1.4,0.8,1.8c0.5,0.6,1.1,1.3,1.1,3C17.7,26.7,13.8,26.7,13.8,26.7z"/> </g> <path class="st2" d="M32.7,25c-0.8-1-1.5-1.7-1.5-3.2v-6.7c0-5.3-2.7-9.4-7.3-10.5c-0.4-1.7-1.9-2.9-3.4-2.9c-1.9,0-3.2,1.3-3.4,2.9 c-4.6,1.1-7.4,5.2-7.4,10.5v6.9c0,1.5-0.6,2.3-1.5,3.2c-1,1.5-2.5,3.1-2.5,7.3c0,0.2,0.2,0.4,0.4,0.4h8c0.2,3.2,2.9,5.7,6.3,5.7 s6.1-2.7,6.3-5.7h8c0.2,0,0.4-0.2,0.4-0.4C35.2,28.2,33.9,26.5,32.7,25z M20.5,37.8c-2.9,0-5.2-2.3-5.3-5H26 C25.6,35.5,23.4,37.8,20.5,37.8z M26.2,31.9H14.8H6.6c0-3.4,1.3-4.8,2.3-6.3c0.8-1,1.7-2.1,1.7-3.8v-6.7c0-5.2,2.5-8.8,6.9-9.7 c0.2,0,0.4-0.2,0.4-0.4c0.2-1.5,1.3-2.5,2.7-2.5c1.3,0,2.5,1,2.7,2.5c0,0.2,0.2,0.4,0.4,0.4c4.4,1,6.9,4.8,6.9,9.7v6.9 c0,1.9,0.8,2.9,1.7,3.8c1,1.3,2.2,2.5,2.2,6.1H26.2L26.2,31.9z"/> <circle class="st3" cx="15.1" cy="14.4" r="2.4"/> </svg>');
						$("#bellNotification").html('');
						$("#bellNotification").css("display","none");
					}
				})
				.fail(function( jqXHR, textStatus, errorThrown ) {
			    	console.log("error hasPendingNotificationsRead");
			    });
				
				if( fechaActualCasino.getTime() < fechaFinCasino.getTime() ){
					if((URLactual.includes("/game_casino_show_home.html")) && flagPromoCasino == '1'){
						let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
						setTimeout(activarPopupCasino , timeUp) ;
					}
				}		

				$(".menu__list__item a").on('click', function() {
				   
				    datalayerMenuLateralDerecho($(this).text().trim());
				});

				//Llamar a url del home para cerrar sesion
			  	var closeSession2 = $('#closeSession2').val();
			  	var currentPathname = window.location.pathname;
			  	var filename = pathname.substring(pathname.lastIndexOf('/') + 1);
        		if(closeSession2!='' && filename!='home.html'){
        			window.location.href = "home.html";
        		}

				//Llamar a url de TA para cerrar sesion
			  	var openSession = $('#openSession').val();
        		if(openSession!=''){
					$.ajax({
				        type: 'post',
				        url: 'tav2-session.html',
				        dataType: 'json'
					}).done(function(d) {
						if(d.message=="OK") {
							fetch(d.redireccion+"?authToken="+d.authToken)
						    .then(response => {
						      // Manejar la respuesta
						    })
						    .catch(error => {
						      // Manejar errores
						    });
						} 
				    });
				}

						
			});			
			//fin popup casino
			
			//popup PremiazoGG
/*		    var estadoWeb = URLactual.includes("premiazoganagol.html");
		    var flagPromoBicolor = $("#flagPromoBicolor").val(); 
		    var idsession = $("#clientId").val();
			$(document).ready(function(){
				if(idsession == '' && (URLactual.includes("/game_ganagol_show_menu.html")) && flagPromoBicolor == '1'){
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(checkCount , timeUp) ;
				}
				if(idsession == '' && (URLactual.includes("/home.html")) && flagPromoBicolor == '1' && flagPromoTinka == 'false' && flagPromoCasino == '0'){
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(checkCount , timeUp) ;
				}
			}); */
			
			//popup hincha
			
			//fin popup hincha
			
			//popup GG-3VS
			var fechaFin = new Date(2022,4,28,21,59,59);
			var fechaActual = new Date();
			if( (fechaActual.getTime() < fechaFin.getTime() ) && ( window.location.pathname.includes("game_ganagol_show_menu.html") || window.location.pathname.includes("game_ganagol_show_bet.html")  ) ){
				let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
				setTimeout(activarPopupGG3VS , timeUp) ;
			}

			$(document).delegate('#btn_desktop_GG_3VS', 'click', function () {			
				 window.location.href = 'game_ganagol_show_bet.html?play=a';		   
			});	
			
			//fin popup GG-3VS
			
			
			//popup motazo-DDVV
			/* fechaFin = new Date(2022,4,29,23,59,59); // 14 de abril al 29 de Mayo
			 fechaActual = new Date();
			if( (fechaActual.getTime() < fechaFin.getTime() ) &&  ( window.location.pathname.includes("game_virtuales_show_home.html") ) ){
				let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
				setTimeout(activarPopupmotazoDDVV , timeUp) ;
			}

			$(document).delegate('#btn_desktop_motazo_DDVV', 'click', function () {			
				 window.location.href = 'http://latinkaportal.com.pe/promociones/ganaconvirtuales/'; 
				 //window.location.href = 'http://qa.intralotportal.com.pe/promociones/ganaconvirtuales/';	// UAT   
			});
			*/
			//fin popup motazo-DDVV
			
			$(document).ready(function(){
				var clientIdSesion= $('#clientId').val();
				 if(clientIdSesion!=''){
					 validateSession();
					document.addEventListener("click", validateSession);
					document.addEventListener("keypress", validateSession);
				 }
				
			});
			  
			  
			  
		// escuchando el iframe para eliminar la session tinka
		window.addEventListener('message', function(event) {
		  if (event.data === 'eliminarTinkaSession') {
			    let jugadaSession = $("#open-button-card").text();
		    	jugadaSession = parseInt(jugadaSession) - 1 ;
		    	if(jugadaSession <= 0)
		    		$("#open-button-card").remove();
		    	if(jugadaSession >= 1)
		    		$("#open-button-card").text(jugadaSession);
		  }
		}, false);
</script>