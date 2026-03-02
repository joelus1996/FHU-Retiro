<!DOCTYPE html>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<html lang="es">
    <head>
        <!-- Google Tag Manager -->
        <script>(function (w, d, s, l, i) {
                w[l] = w[l] || []; w[l].push({
                    'gtm.start':
                        new Date().getTime(), event: 'gtm.js'
                }); var f = d.getElementsByTagName(s)[0],
                    j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : ''; j.async = true; j.src =
                        'https://www.googletagmanager.com/gtm.js?id=' + i + dl; f.parentNode.insertBefore(j, f);
            })(window, document, 'script', 'dataLayer', 'GTM-58FNN4L');
        </script>
        <!-- End Google Tag Manager -->
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<meta name='description' content="La Tinka móvil, billetera" />
		<title>Validación de Documentos de terminos y condiciones y Política de datos personales</title>
		<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
		<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
		<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
<!--         <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/mainDocsPendings.css?v=1"> -->
        <style type="text/css">		
			body{
				background: fixed !important;
			}
					
			.overlay:target, .overlay.opened {
			    visibility: visible;
			    opacity: 1;
			    z-index: 99999;
			    overflow: scroll;
			}
			
			.overlay {
			    position: fixed;
			    top: 0;
			    bottom: 0;
			    left: 0;
			    right: 0;
			    background: rgba(0, 0, 0, 0.7);
			    -webkit-transition: opacity 500ms;
			    -moz-transition: opacity 500ms;
			    -o-transition: opacity 500ms;
			    transition: opacity 500ms;
			    visibility: hidden;
			    opacity: 0;
			    z-index: 11;
			}
			
			.btn.btn-recuperar-password {
			    background-color: #07663a;
			    color: #fafafa;
			    box-shadow: none;
			    border-radius: 30px;
			    text-transform: none;
			    height: 2.9em;
			    line-height: 1em;
			    box-shadow: 0px 4px 8px 3px rgba(0, 0, 0, 0.3);
			    text-align: center;
			    width: 100%;
			    display: block;
			    border: medium none;
			    font-family: AllerBold, Arial, sans-serif;
			    cursor: pointer;
			    padding: 0;
			}
			
			.popup .close-popup {
			    position: absolute;
			    top: -0.7em;
			    right: 1px;
			    -webkit-transition: all 200ms;
			    -moz-transition: all 200ms;
			    -o-transition: all 200ms;
			    font-size: 3.25em;
			    color: #dddddd;
			    width: 0.5em;
			    line-height: 0.8em;
			    margin-left: -0.5em;
			    text-decoration: none;
			    font-family: ui-monospace;
			}
			
			#blockTitlePendingDocs {
			    text-align: center;
			}
			
			.align-modal-v-center {
		    	align-content: center;
			}
			
			.align-x-button-v-center {
				top: 180px !important;
			}
			
			#blockDescriptionPendingDocs {
				text-align: justify;
			}
	    </style>
    </head>

    <body class="no-scroll">
        <!-- Google Tag Manager (noscript) -->
        <noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
        <!-- End Google Tag Manager (noscript) -->
        <div class="ilot">
			<div class="pop-recharge align-modal-v-center" id="popupTYCPDPPending">
				<input type="hidden" id="redirectCaseLoginCompraTYCPDP" value="${redirectCaseLoginCompraTYCPDP}">
			  	<div class="pop-recharge__background"></div>
			  	<button class="pop-recharge__close align-x-button-v-center" onclick="closePopUpIframeTYCPDP()"></button>
			  	<div class="content" id="content">
			  		<div class="pop-recharge__content">
			            <div class="recharge">
			              	<div class="recharge__content">
			              		<div class="recharge__header">
                  					<h2 class="recharge__header-title" id="blockTitlePendingDocs"></h2>
                  				</div>
                  				<div class="recharge__body modalpp">
                  					<div id="blockDescriptionPendingDocs" class="recharge__body-text"></div>
									<div id="blockTyc" class="record recharge__body-text"></div>						
									<div id="blockPdp" class="record recharge__body-text"></div>
									<div id="blockButtonTycPdp" style="text-align: center; width: 100%;">
                      				</div>
                  				</div>
			              	</div>
		              	</div>
	              	</div>
			  	</div>
		  	</div>
	  	</div>
        <script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
        <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
        <script type="text/javascript" src="layer-view-script/popModal.js?v=1"></script>
        <script type="text/javascript" src="layer-view-script/client/mainPendingDocs.js?v=1" charset="UTF-8"></script>
        <script type="text/javascript" src="layer-view-script/client/analytics.js?v=9" charset="UTF-8"></script>
        <script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>
    </body>
</html>