<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
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
	<title>La Tinka : Formulario Derechos Arco</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	
	<link rel="stylesheet" href="layer-view-style/common/tav2-header.css?v=<%=Constantes.tav2_header_css%>" type="text/css" />
	
	<style>
		.disabled {    display: block !important; 	}
	</style>
	
	<meta name='description' content="Intralot móvil, registra un nuevo cliente" />
	
</head>

<body class="orange">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<%@ include file="../include/header.jsp" %>
	
	<div class="container">
							
			<div class="content">

	<div class="ilot">
      <div class="body__content">
        <div class="registro">
          <!--.registro__bg &nbsp;-->
          <div class="content">
            <div class="registro__sidebar">
              <h3 class="registro__sidebar-title" style="margin-top: 35px;">Actualiza tus Datos</h3>
              <p class="registro__sidebar-text">Ley N° 29733 - Ley de Protección de Datos Personales​</p><br>
              <p class="registro__sidebar-text" style="text-align: justify;">De conformidad con lo establecido en la Ley N° 29733 y su Reglamento, solicito el ejercicio de mis derechos en calidad titular de los datos personales contenidos en los bancos de datos de LA TINKA S.A. identificado con RUC N° 20506035121, en los términos señalados a continuación:</p>
            </div>
            <div class="registro__form">
              <form class="form" autocomplete="off" action="client_lotocard_register_form.html" method="post" id="derechos_arco_register_form" data-response-type="json">
                <div class="form__section">I.DATOS DEL TITULAR</div>
                <div class="form__input">
                  <label for="name">Nombres</label>
                  <input type="text" name="name" id="name"  maxlength="45" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres">
                </div>
                <div class="form__input">
                  <label for="lastname">Apellidos</label>
                  <input type="text" name="lastname" id="lastname"  maxlength="45" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos">
                </div>
                <div class="form__select">
                  <label for="typeDoc">Tipo de documento</label>
                  <select name="typeDoc" id="typeDoc" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
                    <!--option(value='') Seleccionar-->
                    <option value="DNI" selected>DNI</option>
                    <option value="PASAP">Pasaporte</option>
                    <option value="CAREX">Carnet de Extranjería</option>
                  </select>
                </div>
                <div class="form__input form__optional show">
                  <label for="numberDoc">Número de documento</label>
                  <input type="tel" name="numberDoc" id="numberDoc" maxlength="8" data-validation="length number" data-validation-length="8" data-validation-error-msg="debes ingresar un dni válido" data-validation-depends-on="typeDoc" data-validation-depends-on-value="DNI">
                </div>
                <div class="form__input form__optional">
                  <label for="documento-pasap">Número de documento</label>
                  <input type="text" name="documento-pasap"  id="documento-pasap" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="debes ingresar un pasaporte válido" data-validation-depends-on="typeDoc" data-validation-depends-on-value="PASAP">
                </div>
                <div class="form__input form__optional">
                  <label for="documento-carex">Número de documento</label>
                  <input type="text" name="documento-carex" id="documento-carex" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="debes ingresar un carnet de extranjería válido" data-validation-depends-on="typeDoc" data-validation-depends-on-value="CAREX">
                </div>
                             
                <div class="form__input">
                  <label for="user">Usuario</label>
                  <input type="text" name="user" id="user" maxlength="25" >
                </div>
               
                <div class="form__input">
                  <label for="mobilePhone">Número de celular</label>
                  <input type="tel" name="mobilePhone" id="mobilePhone"  maxlength="9" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="debes ingresar un celular válido">
                </div>
               
                <div class="form__input">
                  <label for="email">Correo electrónico</label>
                  <input type="text" name="email" id="email" data-validation="email" data-validation-error-msg="Debes ingresar un correo válido">
                </div>
                
                <div class="form__select2">
                  <label for="nacionalidad">Nacionalidad</label>
                  <select name="nacionalidad" id="nacionalidad"  data-validation="required" data-validation-error-msg="debes ingresar tu nacionalidad">
<!--                       <option value=" "></option>  -->
                  </select>
		      	</div>
              
                <div class="form__input">
                  <label for="domicilio">Dirección actual</label>
                  <input type="text" name="domicilio" id="domicilio" maxlength="70" data-validation="required" data-validation-error-msg="debes ingresar tu dirección actual">
                </div>
                
                <div class="form__select2">
		                  <label for="departamento">Departamento</label>
		                  <select name="departamento" id="departamento"  data-validation="required" data-validation-error-msg="debes ingresar tu departamento">
<!-- 		                      <option value=" "></option>  -->
<!-- 		                    <option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
		                  </select>
		      </div>
                
               <div class="form__select2">
		                  <label for="provincia">Provincia</label>
		                  <select name="provincia" id="provincia"  data-validation="required" data-validation-error-msg="debes ingresar tu provincia">
<!-- 		                      <option value=" " >Provincia</option>  -->
<!-- 		                    <option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
		                  </select>
		       </div>  
                
               <div class="form__select2">
		                  <label for="distrito">Distrito</label>
		                  <select name="distrito" id="distrito"  data-validation="required" data-validation-error-msg="debes ingresar tu distrito">
<!-- 		                      <option value=" " >Distrito</option>  -->
<!-- 		                    <option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
		                  </select>
		     </div> 
		     
		     <div class="fileup-image" id="divImgDniTransferencia" style="margin-bottom: 10px;">
				<div class="divDniPen" id="divDniLabelTransferencia">
					<label id="stateDniPENLabelTransferencia"><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline; font-size:14px; ">Adjunta aquí</span><span style="font-size:14px;"> la foto de tu DNI, Pasaporte y/o Carnet de Extranjería, por el lado que muestra la foto de tu rostro.</span>
					<input class="upimage is-simple" style="display:none;" type="file" name="iimage_1" id="imgDNITransferencia" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
					<canvas id="canvasDNITransferencia" style="display: none;" ></canvas>
					</label>
				</div>
						
				<div class="filenames empty" id="filenamesDniTransferencia"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpeg y png)</span>
							<div class="filename-simple" id="img-dni"></div>
				</div>	
			</div>
			
			    <div class="form__check_legal" id="chk_legal">
                  <input type="checkbox" name="legal-form" id="legal-form" value="1">
                  <label for="legal-form" style="font-size:14px;">Soy un representante legal</label>
                </div>
                
                <div id="form-legal" class="view-legal">
                
	                <div class="form__section" id="tipo_3">II.DATOS DEL REPRESENTANTE LEGAL.</div>
	                
	                <div class="form__input" style="width: 100%;">
			                  <label for="name-legal">Nombres</label>
			                  <input type="text" name="name-legal" maxlength="45" id="name-legal"  data-validation="required" data-validation-error-msg="Debes ingresar tus nombres">
			        </div>
			        
			        <div class="form__input" style="width: 100%;">
			                  <label for="ap-paterno-legal">Apellidos</label>
			                  <input type="text" name="ap-paterno-legal" maxlength="45" id="ap-paterno-legal"  data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos">
			       </div>
			       
			       <div class="form__select" style="width: 100%;">
			                  <label for="document-type-legal"> Tipo de Documento</label>
			                  <select name="document-type-legal" id="document-type-legal" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
			                    <!--option(value='') Seleccionar-->
			                    <option value="DNI" selected>DNI</option>
			                    <option value="PASAP">Pasaporte</option>
			                    <option value="CAREX">Carnet de Extranjería</option>
			                  </select>
			      </div>
			      <input type="hidden" value="" id="notvalidate">
			      <div class="form__input form__optional2 show" style="width: 100%;">
			                  <label for="document-number-legal">Número de documento</label>
			                  <input type="text" name="document-number-legal" id="document-number-legal" maxlength="8" data-validation="length number" data-validation-length="8" data-validation-error-msg="debes ingresar un dni válido" data-validation-depends-on="document-type-legal" data-validation-depends-on-value="DNI">
			      </div>
			      <div class="form__input form__optional2" style="width: 100%;">
			                  <label for="document-number-pasap-legal">Número de documento</label>
			                  <input type="text" name="document-number-pasap-legal" tabindex="13" id="document-number-pasap-legal" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="debes ingresar un pasaporte válido" data-validation-depends-on="document-type-legal" data-validation-depends-on-value="PASAP">
			      </div>
			       <div class="form__input form__optional2" style="width: 100%;">
			                  <label for="document-number-carex-legal">Número de documento</label>
			                  <input type="text" name="document-number-carex-legal" tabindex="13" id="document-number-carex-legal" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="debes ingresar un Carnet de Extranjería válido" data-validation-depends-on="document-type-legal" data-validation-depends-on-value="CAREX">
			      </div>
			      
			      
			      <div class="fileup-image" id="divImgDniTransferencia3" style="margin-bottom: 15px;">
								<div class="divDniPen" id="divDniLabelTransferencia3">
									<label id="stateDniPENLabelTransferencia3"><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;font-size:14px;">Adjunta aquí</span><span style="font-size:14px;"> la foto de tu DNI, Pasaporte y/o Carnet de Extranjería, por el lado que muestra la foto de tu rostro.</span>
										<input class="upimage is-simple" style="display:none;" type="file" name="iimage_3" id="imgDNITransferencia3" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
										<canvas id="canvasDNITransferencia3" style="display: none;" ></canvas>
									</label>
								</div>
								
								<div class="filenames empty" id="filenamesDniTransferencia3"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpeg y png)</span>
									<div class="filename-simple" id="img_legal"></div>
								</div>	
				</div>
				
				<div class="fileup-image" id="divImgDniTransferencia4">
					<div class="divDniPen" id="divDniLabelTransferencia4">
						<label id="stateDniPENLabelTransferencia4"><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;font-size:14px;">Adjunta aquí</span><span style="font-size:14px;"> la declaración jurada certificada por un notario que acredite tu representación.</span>
						<input class="upimage is-simple" style="display:none;" type="file" name="iimage_4" id="imgDNITransferencia4" accept="image/jpeg, image/png, image/pdf" data-validation="required" data-validation-error-msg="debes cargar tu foto">
						<canvas id="canvasDNITransferencia4" style="display: none;" ></canvas>
						</label>
					</div>
								
					<div class="filenames empty" id="filenamesDniTransferencia4"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpeg y png)</span>
						<div class="filename-simple" id="img_legal2"></div>
					</div>	
				</div>					
			      			      			      
		      </div>
		      		      
		      <div class="form__section" id="tipo_2" style="margin-bottom: 5px;">II.TIPO DE SOLICITUD</div>
		      <label style="font-size: 14px;">Seleccione un tipo de solicitud a ingresar</label><br>
		      
		       <div class="form__check_tipo_solicitud" id="tipo_solicitudes" style="text-align: justify;font-size: 14px;margin-top:5px;">	               	                
	                	<label class="tip_soli_estilo">Acceso</label><br>	                		                	
	                	<div class="celda_tipo_soli">         		                		                		                	
	                		<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_acceso" value="1" >
	                		<label class="lbl_tipo_soli" for="tipo_solicitud_acceso">Quiero saber ¿Cuáles son mis datos personales que se encuentran almacenados en las bases de datos que administra La Tinka?​<br>En "III. Coméntanos el detalle de tu solicitud de Acceso", detalla el motivo por el que deseas obtener dicha información.</label><br>
	                	</div><br> 	                 	                 	                         	           	
	                	<label class="tip_soli_estilo">Rectificación</label><br> 	                	                	
	                	<div class="celda_tipo_soli"> 
 	                		<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_rec" value="2">  
 	                		<label class="lbl_tipo_soli" for="tipo_solicitud_rec">Quiero actualizar uno o más datos personales que registré inicialmente en las website que administra La Tinka​ <br>En "III. Coméntanos el detalle de tu solicitud de Rectificación", detalla cada dato personal que deseas actualizar; por ejemplo "Solicito actualizar el celular registrado en mi cuenta de usuario de Te Apuesto al número 999112233".</label><br> 
	            		</div><br>	                		                		               	                 	                	                	
	                	<label class="tip_soli_estilo">Cancelación</label><br>	                		                	
	                	<div class="celda_tipo_soli">
	                		<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_can" value="3">
	                		<label class="lbl_tipo_soli" for="tipo_solicitud_can">Quiero eliminar mi cuenta de usuario que administra La Tinka.​<br>En "III. Coméntanos el detalle de tu solicitud de Cancelación", detalla el motivo por el que deseas cancelar tu cuenta; por ejemplo: "Deseo eliminar mi cuenta y/o datos personales almacenados en La Tinka debido a que no continuaré jugando".​</label><br> 
	                	</div><br>                		                		                	 	                	                 	                 	               	                	
	                	<label class="tip_soli_estilo">Oposición</label><br>	                		                	
	                	<div class="celda_tipo_soli">             		                		                		                	
	                		<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_opo" value="4">
	                		<label class="lbl_tipo_soli" for="tipo_solicitud_opo">Quiero que La Tinka ya no administre el uso de mis datos personales porque me está perjudicando o porque considero que están siendo usados con otros fines de los que se me comunicó al momento de mi registro.​<br>En "III. Coméntanos el detalle de tu solicitud de Oposición", detalla el motivo o el caso por el que considera se ve perjudicado o se esté administrando incorrectamente sus datos; por ejemplo: "Solicito no recibir publicidad ya que no autoricé al momento de mi registro recibir promociones y noticias a mi correo electrónico y/o celular".</label> <br>
	                	</div>
	                		                		               
                 </div>
                 
                 <div class="form__check_tipo_solicitud f" >  
                   <input type="checkbox" name="solicitud_f" id="solicitud_f" value="" data-validation="required" data-validation-error-msg="debes seleccionar un tipo de solicitud">  
                   <label for="solicitud_f"></label>
                  </div><br>
                  
                  <div class="form__section" id="razon_solicitud">
               		<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span>                              
               	 </div>
               
               <div class="seccion_razon_solicitud">
						<textarea cols="100" rows="3" class="razon_text" id="razon_solicitud_pd" name="razon_solicitud_pd" maxlength="300" autocomplete="off" data-validation="required" data-validation-error-msg="debes ingresar la razon de tu solicitud" ></textarea>
						
				</div>
				
				<div class="fileup-image" id="divImgDniTransferencia2">
						<div class="divDniPen" id="divDniLabelTransferencia2">
							<label id="stateDniPENLabelTransferencia2"><span style="font-size: 14px;"> Si tiene alguna evidencia sobre el tratamiento de tus datos personales, </span><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;font-size: 14px;">adjúntalo aquí</span>
								<input class="upimage is-simple" style="display:none;" type="file" name="iimage_2" id="imgDNITransferencia2" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
								<canvas id="canvasDNITransferencia2" style="display: none;" ></canvas>
							</label>
						</div>
						
						<div class="filenames empty" id="filenamesDniTransferencia2"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpeg y png)</span>
							<div class="filename-simple" id="img_razon"></div>
						</div>	
				</div>	
               
               <div class="form__section" id="razon_solicitud" style="text-align:justify;">
               		<span>NOTIFICACIÓN DE LA RESPUESTA </span>
               		<label class="notify_response">Responderemos a tu solicitud al correo registrado. Las solicitudes se responderán dentro de los plazos establecidos en el Capítulo I del Título IV del Reglamento de la Ley de Protección de Datos Personales, aprobado por Decreto Supremo No. 003-2013-JUS. Si no obtiene respuesta dentro de los plazos indicados podrá ejercer un procedimiento de tutela ante la Dirección General de Protección de Datos Personales (Ministerio de Justicia).
               		</label>                                
               	 </div>
                
                <div class="form__check_pd">
                  <input type="checkbox" name="terms" id="terms" value="1" data-validation="required" data-validation-error-msg="Los Términos y condiciones son requeridos">       
                  <label for="terms">He leído y acepto la <a href="<%= Constantes.URL_QW%>/politica-de-datos-personales/" target="_blank" class='link link__base' style="color:#1a6d30;border-bottom:solid 1px #1a6d30;font-weight: 500;">Política de Datos Personales</a> de LA TINKA</label>
                </div>
                
                <div class="align-g-recaptcha">						
						<div class="g-recaptcha" data-sitekey="6LelcgkcAAAAAOZT1dJlIKBBP0Rgnjvbs5_t0MkY" style="padding: 0px 15px;margin-bottom: 30px;" ></div>	
<!-- 							<div class="g-recaptcha" data-sitekey="6Le0VpsbAAAAAA7mLIgpUmNg9ORM5t1wB0E-c2eX" style="padding: 0px 15px;margin-bottom: 30px;" ></div> -->
				</div>
                                                   
                <div class="error" id="alert">${alert}</div>
                <div class="form__button">
                  <i></i>
                  <button class="button button__base_3" type="button" id="enviarPD" disabled>Enviar</button>
                </div>
                <br><br><br><br>
               
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>				
			</div>
		</div>
		
	<jsp:include page="../include/footer.jsp" />	
	<div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content" style="text-align: center;padding-bottom: 5px;"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">Cerrar</button>
		</div>
	</div>
	
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>

	<script type="text/javascript">
		
		$(document).ready(function(){
			$('#agre_tyc').click(function(){
				$("div#alert").html("");
        		openModal("#popup-tyc","");
			});
		
			$('#agree_terms').click(function(){
				$('#terms').prop('checked', true);
				$('#terms').removeClass("error");
				$('#terms').addClass("valid");
	
				if ($('#client_lotocard_register_form').isValid({}, {}, false)) {
			      $('#resgisterUser').attr('disabled', false);
			    } else {
			      $('#resgisterUser').attr('disabled', true);
			    }
				closeModal();
			});

		


// 			$.ajax({
//  		        type: "POST",
//  		        url: "getDepartamentos.html",
//  		        dataType: "json",
//  		        async: false,
// 		        success: function (data) {

//  		        	$.each(data,function(i,obj){
// 		        		$('#departamento').append('<option value='+obj.departmentId+'>'+obj.departmentName+'</option>');			     	
//  		        	 });					
//  		        }    		  	        
//  			});
			
			renderFormFields2();
			renderDerechosArcoFormDA();
			fileupImgDocument.init();
 			fileupImgDocument2.init();
 			fileupImgDocument3.init();
 			fileupImgDocument4.init();     		
			
			
			$("#name").on("copy paste", function(){
            	return false;
             });
            $("#lastname").on("copy paste", function(){
             	return false;
             });
			$("#email").on("copy paste", function(){
            	return false;
             });
			$("#domicilio").on("copy paste", function(){
            	return false;
             });
		});

		var maxMb=10;
		var imgBase64P1Trans = "";
		var imgBase64P2Trans = "";
		var imgBase64P3Trans = "";
		var imgBase64P4Trans = "";
		var tipsoli;

		const fileupImgDocument = (function () {
			  'use strict';

			  const file = $('#imgDNITransferencia'),
			  onChangeFile = function () {
			      var img = this.files[0],
			        parent = $(this).closest('.fileup-image'),
			        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
			        filenames = parent.find('.filenames'),
			        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
			        reader;

			       
			         
			        if(img!=undefined && img!=null){
				      if(img.type=="image/png" || img.type=="image/jpeg"){
				    	  if((img.size/1024/1024)<=maxMb){  
						      if ($(this).val() !== '') {
						        var sizeImgDNI = img.size;
						        var ico = $('#enviarPD').siblings('i');
						        $(ico).addClass('loading');
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      
						        $("#stateDniACTTransferencia").css("display","none");
						        
						        parent.removeClass('is-error');
						        $('#divDniLabelTransferencia').removeClass('is-error');
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia').getContext('2d');
					        	var imgCanvas = new Image();
					        	//setTimeout(function(){
					        		if(sizeImgDNI>7000000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.2);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>5000000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.25);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>4000000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.3);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>3000000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.38);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>2000000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.45);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>1500000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.55);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>1000000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.70);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
						        	}else if(sizeImgDNI>800000){
							        	imgCanvas.onload = function() {
							        		$(ico).removeClass('loading');
							        		var newCanvas = downScaleImagePD(imgCanvas, 0.85);
							        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
							        	}
							        	imgCanvas.src = URL.createObjectURL(img);
					        	
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		$(ico).removeClass('loading');
							        		imgBase64P1Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}
						        
					        	 //},5000);
						        
						        imgCanvas.onerror = function() {
						        	$(ico).removeClass('loading');
						        	$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	alertMessage('Debes adjuntar una imagen v&aacute;lida');
						        	$('#img-dni').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  alertMessage('Tu imagen debe ser menor a "+maxMb+"MB.');
				    			$('#img-dni').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  alertMessage('Solo se permiten imágenes con extensión JPEG o PNG.');
				    		$('#img-dni').html('');
				      }
			        }else{
			        	//$("#delimgDNITransferencia").trigger("click");
			        }

			       
			    },
			    			
			    init = function () {
			      file.on('change', onChangeFile);
			      //$("#updateDNITransferencia").on('click', (function () {$("#imgDNITransferencia").trigger("click")}));			      
			    };

			  return {
			    init: init
			  };
			}());


		const fileupImgDocument2 = (function () {
			  'use strict';

			  const file2 = $('#imgDNITransferencia2'),
			  onChangeFile2 = function () {
			      var img = this.files[0],
			        parent = $(this).closest('.fileup-image'),
			        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
			        filenames = parent.find('.filenames'),
			        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
			        reader;
			        
			        if(img!=undefined && img!=null){
				      if(img.type=="image/png" || img.type=="image/jpeg"){
				    	  if((img.size/1024/1024)<=maxMb){  
						      if ($(this).val() !== '') {
						        var sizeImgDNI = img.size;
						        var ico = $('#enviarPD').siblings('i');
						        $(ico).addClass('loading');
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      						       
						        
						        parent.removeClass('is-error');
						      
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia2').getContext('2d');
					        	var imgCanvas = new Image();
					        	//setTimeout(function(){
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.2);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.25);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.3);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.38);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.45);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.55);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.70);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.85);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {						        		
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		$(ico).removeClass('loading');
							        		imgBase64P2Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}

					        	 //},5000);
						        
						        imgCanvas.onerror = function() {
						        	 $(ico).removeClass('loading');
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	alertMessage("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img_razon').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  alertMessage("Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  $('#img_razon').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  alertMessage("Solo se permiten imágenes con extensión JPG o PNG.");
				    	  $('#img_razon').html('');
				      }
			        }else{
			        	//$("#delimgDNITransferencia").trigger("click");
			        }
			    },
			    			
			    init = function () {
			      file2.on('change', onChangeFile2);
			      $("#updateDNITransferencia").on('click', (function () {$("#imgDNITransferencia").trigger("click")}));			      
			    };

			  return {
			    init: init
			  };
			}());

		const fileupImgDocument3 = (function () {
			  'use strict';

			  const file3 = $('#imgDNITransferencia3'),
			  onChangeFile3 = function () {
			      var img = this.files[0],
			        parent = $(this).closest('.fileup-image'),
			        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
			        filenames = parent.find('.filenames'),
			        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
			        reader;
			        
			        if(img!=undefined && img!=null){
				      if(img.type=="image/png" || img.type=="image/jpeg"){
				    	  if((img.size/1024/1024)<=maxMb){  
						      if ($(this).val() !== '') {
						        var sizeImgDNI = img.size;
						        var ico = $('#enviarPD').siblings('i');
						        $(ico).addClass('loading');
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      						       
						        
						        parent.removeClass('is-error');
						      
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia3').getContext('2d');
					        	var imgCanvas = new Image();
					        	//setTimeout(function(){
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.2);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.25);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.3);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.38);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.45);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.55);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.70);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.85);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		$(ico).removeClass('loading');
							        		imgBase64P3Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}

					        	//},5000);
						        
						        imgCanvas.onerror = function() {
						        	$(ico).removeClass('loading');
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	alertMessage("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img_legal').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  alertMessage("Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  $('#img_legal').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  alertMessage("Solo se permiten imágenes con extensión JPEG o PNG.");
				    	  $('#img_legal').html('');
				      }
			        }else{
			        	//$("#delimgDNITransferencia").trigger("click");
			        }
			    },
			    			
			    init = function () {
			      file3.on('change', onChangeFile3);
			      //$("#updateDNITransferencia").on('click', (function () {$("#imgDNITransferencia").trigger("click")}));			      
			    };

			  return {
			    init: init
			  };
			}());

		const fileupImgDocument4 = (function () {
			  'use strict';

			  const file4 = $('#imgDNITransferencia4'),
			  onChangeFile4 = function () {
			      var img = this.files[0],
			        parent = $(this).closest('.fileup-image'),
			        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
			        filenames = parent.find('.filenames'),
			        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
			        reader;

			        
			        if(img!=undefined && img!=null){
				      if(img.type=="image/png" || img.type=="image/jpeg"){
				    	  if((img.size/1024/1024)<=maxMb){  
						      if ($(this).val() !== '') {
						        var sizeImgDNI = img.size;
						        var ico = $('#enviarPD').siblings('i');
						        $(ico).addClass('loading');
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      						       
						        
						        parent.removeClass('is-error');
						      
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia3').getContext('2d');
					        	var imgCanvas = new Image();
					        	//setTimeout(function(){
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.2);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.25);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.3);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		$(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.38);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.45);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.55);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.70);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		 $(ico).removeClass('loading');
						        		var newCanvas = downScaleImagePD(imgCanvas, 0.85);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		 $(ico).removeClass('loading');
							        		imgBase64P4Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}
						        
					        	//},5000);
					        
						        imgCanvas.onerror = function() {
						        	 $(ico).removeClass('loading');
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	alertMessage("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img_legal2').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  alertMessage("Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  $('#img_legal2').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  alertMessage("Solo se permiten imágenes con extensión JPEG o PNG.");
				    	  $('#img_legal2').html('');
				      }
			        }else{
			        	//$("#delimgDNITransferencia").trigger("click");
			        }
			    },
			    			
			    init = function () {
			      file4.on('change', onChangeFile4);
			      //$("#updateDNITransferencia").on('click', (function () {$("#imgDNITransferencia").trigger("click")}));			      
			    };

			  return {
			    init: init
			  };
			}());

		// scales the image by (float) scale < 1
		// returns a canvas containing the scaled image.
		function downScaleImagePD(img, scale) {
		    var imgCV = document.createElement('canvas');
		    imgCV.width = img.width;
		    imgCV.height = img.height;
		    var imgCtx = imgCV.getContext('2d');
		    imgCtx.drawImage(img, 0, 0);
		    return downScaleCanvasPD(imgCV, scale);
		}

		// scales the canvas by (float) scale < 1
		// returns a new canvas containing the scaled image.
		function downScaleCanvasPD(cv, scale) {
		    if (!(scale < 1) || !(scale > 0)) throw ('scale must be a positive number <1 ');
		    var sqScale = scale * scale; // square scale = area of source pixel within target
		    var sw = cv.width; // source image width
		    var sh = cv.height; // source image height
		    var tw = Math.floor(sw * scale); // target image width
		    var th = Math.floor(sh * scale); // target image height
		    var sx = 0, sy = 0, sIndex = 0; // source x,y, index within source array
		    var tx = 0, ty = 0, yIndex = 0, tIndex = 0; // target x,y, x,y index within target array
		    var tX = 0, tY = 0; // rounded tx, ty
		    var w = 0, nw = 0, wx = 0, nwx = 0, wy = 0, nwy = 0; // weight / next weight x / y
		    // weight is weight of current source point within target.
		    // next weight is weight of current source point within next target's point.
		    var crossX = false; // does scaled px cross its current px right border ?
		    var crossY = false; // does scaled px cross its current px bottom border ?
		    var sBuffer = cv.getContext('2d').
		    getImageData(0, 0, sw, sh).data; // source buffer 8 bit rgba
		    var tBuffer = new Float32Array(3 * tw * th); // target buffer Float32 rgb
		    var sR = 0, sG = 0,  sB = 0; // source's current point r,g,b
		    /* untested !
		    var sA = 0;  //source alpha  */    

		    for (sy = 0; sy < sh; sy++) {
		        ty = sy * scale; // y src position within target
		        tY = 0 | ty;     // rounded : target pixel's y
		        yIndex = 3 * tY * tw;  // line index within target array
		        crossY = (tY != (0 | ty + scale)); 
		        if (crossY) { // if pixel is crossing botton target pixel
		            wy = (tY + 1 - ty); // weight of point within target pixel
		            nwy = (ty + scale - tY - 1); // ... within y+1 target pixel
		        }
		        for (sx = 0; sx < sw; sx++, sIndex += 4) {
		            tx = sx * scale; // x src position within target
		            tX = 0 |  tx;    // rounded : target pixel's x
		            tIndex = yIndex + tX * 3; // target pixel index within target array
		            crossX = (tX != (0 | tx + scale));
		            if (crossX) { // if pixel is crossing target pixel's right
		                wx = (tX + 1 - tx); // weight of point within target pixel
		                nwx = (tx + scale - tX - 1); // ... within x+1 target pixel
		            }
		            sR = sBuffer[sIndex    ];   // retrieving r,g,b for curr src px.
		            sG = sBuffer[sIndex + 1];
		            sB = sBuffer[sIndex + 2];

		            /* !! untested : handling alpha !!
		               sA = sBuffer[sIndex + 3];
		               if (!sA) continue;
		               if (sA != 0xFF) {
		                   sR = (sR * sA) >> 8;  // or use /256 instead ??
		                   sG = (sG * sA) >> 8;
		                   sB = (sB * sA) >> 8;
		               }
		            */
		            if (!crossX && !crossY) { // pixel does not cross
		                // just add components weighted by squared scale.
		                tBuffer[tIndex    ] += sR * sqScale;
		                tBuffer[tIndex + 1] += sG * sqScale;
		                tBuffer[tIndex + 2] += sB * sqScale;
		            } else if (crossX && !crossY) { // cross on X only
		                w = wx * scale;
		                // add weighted component for current px
		                tBuffer[tIndex    ] += sR * w;
		                tBuffer[tIndex + 1] += sG * w;
		                tBuffer[tIndex + 2] += sB * w;
		                // add weighted component for next (tX+1) px                
		                nw = nwx * scale
		                tBuffer[tIndex + 3] += sR * nw;
		                tBuffer[tIndex + 4] += sG * nw;
		                tBuffer[tIndex + 5] += sB * nw;
		            } else if (crossY && !crossX) { // cross on Y only
		                w = wy * scale;
		                // add weighted component for current px
		                tBuffer[tIndex    ] += sR * w;
		                tBuffer[tIndex + 1] += sG * w;
		                tBuffer[tIndex + 2] += sB * w;
		                // add weighted component for next (tY+1) px                
		                nw = nwy * scale
		                tBuffer[tIndex + 3 * tw    ] += sR * nw;
		                tBuffer[tIndex + 3 * tw + 1] += sG * nw;
		                tBuffer[tIndex + 3 * tw + 2] += sB * nw;
		            } else { // crosses both x and y : four target points involved
		                // add weighted component for current px
		                w = wx * wy;
		                tBuffer[tIndex    ] += sR * w;
		                tBuffer[tIndex + 1] += sG * w;
		                tBuffer[tIndex + 2] += sB * w;
		                // for tX + 1; tY px
		                nw = nwx * wy;
		                tBuffer[tIndex + 3] += sR * nw;
		                tBuffer[tIndex + 4] += sG * nw;
		                tBuffer[tIndex + 5] += sB * nw;
		                // for tX ; tY + 1 px
		                nw = wx * nwy;
		                tBuffer[tIndex + 3 * tw    ] += sR * nw;
		                tBuffer[tIndex + 3 * tw + 1] += sG * nw;
		                tBuffer[tIndex + 3 * tw + 2] += sB * nw;
		                // for tX + 1 ; tY +1 px
		                nw = nwx * nwy;
		                tBuffer[tIndex + 3 * tw + 3] += sR * nw;
		                tBuffer[tIndex + 3 * tw + 4] += sG * nw;
		                tBuffer[tIndex + 3 * tw + 5] += sB * nw;
		            }
		        } // end for sx 
		    } // end for sy

		    // create result canvas
		    var resCV = document.createElement('canvas');
		    resCV.width = tw;
		    resCV.height = th;
		    var resCtx = resCV.getContext('2d');
		    var imgRes = resCtx.getImageData(0, 0, tw, th);
		    var tByteBuffer = imgRes.data;
		    // convert float32 array into a UInt8Clamped Array
		    var pxIndex = 0; //  
		    for (sIndex = 0, tIndex = 0; pxIndex < tw * th; sIndex += 3, tIndex += 4, pxIndex++) {
		        tByteBuffer[tIndex] = Math.ceil(tBuffer[sIndex]);
		        tByteBuffer[tIndex + 1] = Math.ceil(tBuffer[sIndex + 1]);
		        tByteBuffer[tIndex + 2] = Math.ceil(tBuffer[sIndex + 2]);
		        tByteBuffer[tIndex + 3] = 255;
		    }
		    // writing result to canvas.
		    resCtx.putImageData(imgRes, 0, 0);
		    return resCV;
		}

	</script>
<script type="text/javascript" src="layer-view-script/client/locationData.js?v=2"></script>
<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content">
		</div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">CERRAR</button>
			<!-- button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">ACEPTAR</button -->
		</div>
</div>


	<script>
		$('#btn_mobile_registrate').addClass('desactive');
	</script>
	
</body>
</html>