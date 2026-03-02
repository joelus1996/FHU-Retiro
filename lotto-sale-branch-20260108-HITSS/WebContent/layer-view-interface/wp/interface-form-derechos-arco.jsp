<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->



<meta charset="utf-8">
<meta name="viewport" content="width=1024">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/client/signUp.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/style.css?v=2">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/dhtmlwindow.css">

<!-- 	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/ta.min.css"> -->

<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/v2/styles.css?v=7">
<link rel="stylesheet" type="text/css"
	href="layer-view-style/common/tav2-header.css?v=<%=Constants.tav2_header_css%>">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/client/main.css?v=<%=Constants.main_css%>">

<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>
<title>La Tinka | Formulario de Derechos Arco</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon2.ico">
</head>
<body oncontextmenu="return false" onselectstart="return false" ondragtart="return false">
	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


    	<%@ include file="../include/header.jspf"%>
     
    <div class="ilot">
<div id="wrapper-form">
      <div class="body__content">
        <div class="registro">
          <div class="registro__bg">&nbsp;</div>
          <div class="content" style="max-width: none;">
             <div class="registro__sidebar" style="width: 41.48387%;padding-top:46px;">
               <h3 class="registro__sidebar-title">Solicitud de Derechos Arco</h3> 
              <p class="registro__sidebar-text">Ley N° 29733 - Ley de Protección de Datos Personales​</p><br>
              <p class="registro__sidebar-text" style="text-align:justify;">De conformidad con lo establecido en la Ley N° 29733 y su Reglamento, solicito el ejercicio de mis derechos en calidad titular de los datos personales contenidos en los bancos de datos de LA TINKA S.A. identificado con RUC N° 20506035121, en los términos señalados a continuación:</p> 
            </div>

						
            <div class="registro__form" style="max-width: 960px;width: 58.51613%;padding-top:46px;">
              <form class="form" id="frm-enviar-derechos-arco" action="enviarDerechosArco.html" autocomplete="off" method="post" style="margin-left: 3%;">
              
                <div class="form__section">I.DATOS DEL TITULAR.</div>
                <div class="col-register-12">
	                <div class="col-register-4">
		                <div class="form__input" style="width: 100%;">
		                  <label for="name">Nombres</label>
		                  <input type="text" name="name" id="name" maxlength="45" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres">
		                </div>
	                 </div>
	                 <div class="col-register-4">                 
		                <div class="form__input" style="width: 100%;">
		                  <label for="ap-paterno">Apellidos</label>
		                  <input type="text" name="ap-paterno" id="ap-paterno" maxlength="45" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos">
		                </div>
	                </div>
	                
	                <div class="col-register-4">                 
		                <div class="form__input" style="width: 100%;">
		                  <label for="usuario">Usuario</label>
		                  <input type="text" name="usuario" id="usuario" maxlength="25" >
		                </div>
	                </div>

                </div>
                              
                <div class="col-register-12">
                	<div class="col-register-4">
		                <div class="form__select" style="width: 100%;">
		                  <label for="document-type"> Tipo de documento</label>
		                  <select name="document-type" id="document-type" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
		                    <!--option(value='') Seleccionar-->
		                    <option value="DNI" selected>DNI</option> 
		                    <option value="PASAP">Pasaporte</option>
		                    <option value="CAREX">Carnet de Extranjería</option>
		                  </select>
		                </div>
	                </div>
	                <div class="col-register-4"> 
	                	<input type="hidden" value="" id="notvalidate">
		                <div class="form__input form__optional show" style="width: 100%;">
		                  <label for="document-number">Número de documento</label>
		                  <input type="text" name="document-number" id="document-number" maxlength="8" data-validation="length number" data-validation-length="8" data-validation-error-msg="debes ingresar un dni válido" data-validation-depends-on="document-type" data-validation-depends-on-value="DNI">
		                </div>
	                
	                
		                <div class="form__input form__optional" style="width: 100%;">
		                  <label for="document-number-pasap">Número de documento</label>
		                  <input type="text" name="document-number-pasap"  id="document-number-pasap" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="debes ingresar un pasaporte válido" data-validation-depends-on="document-type" data-validation-depends-on-value="PASAP">
		                </div>
	              
	               
		                <div class="form__input form__optional" style="width: 100%;">
		                  <label for="document-number-carex">Número de documento</label>
		                  <input type="text" name="document-number-carex"  id="document-number-carex" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="debes ingresar un carnet de extranjería válido" data-validation-depends-on="document-type" data-validation-depends-on-value="CAREX">
		                </div>
	             </div>
	              <div class="col-register-4"> 
		              <div class="form__input" style="width: 100%;">
	                  <label for="mobile-phone">Número de celular</label>
	                  <input type="text" name="mobile-phone" id="mobile-phone"  maxlength="9" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="debes ingresar un celular válido">
	                  </div>
                  </div>
	                
                </div>

                                
<!--                 <div class="form__section">Datos de acceso</div> -->
 				<div class="col-register-12">
 					<div class="col-register-4"> 
		                <div class="form__input" style="width: 100%;">
		                  <label for="email">Correo electrónico</label>
		                  <input type="text" name="email" id="email"  data-validation="email" data-validation-error-msg="Debes ingresar un correo válido">
		                </div>
	               </div> 
	               <div class="col-register-4">
		                <div class="form__select3" style="width: 100%;">
		                  <label for="nacionalidad">Nacionalidad</label>
		                  <select name="nacionalidad" id="nacionalidad"  data-validation="required" data-validation-error-msg="debes ingresar tu nacionalidad">
<!-- 		                      <option value=" "></option>  -->
		                  </select>
		               </div>
		            </div> 
	               <div class="col-register-4"> 	               
	                  <div class="form__input" style="width: 100%;">
		                  <label for="domicilio">Dirección actual</label>		
						  <input type="text" name="domicilio" id="domicilio" maxlength="70" autocomplete="off" data-validation="required" data-validation-error-msg="Tu dirección actual es requerida">
		                </div>	                
	               </div>

                </div>
              
                <div class="col-register-12">
                	<div class="col-register-4">
		                <div class="form__select3" style="width: 100%;">
		                  <label for="departamento">Departamento</label>
		                  <select name="departamento" id="departamento"  data-validation="required" data-validation-error-msg="debes ingresar tu departamento">
<!-- 		                      <option value=" "></option>  -->
<!-- 		                    <option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
		                  </select>
		               </div>
		            </div> 
		                
		             <div class="col-register-4">
		                <div class="form__select3" style="width: 100%;">
		                  <label for="provincia">Provincia</label>
		                  <select name="provincia" id="provincia"  data-validation="required" data-validation-error-msg="debes ingresar tu provincia">
<!-- 		                      <option value=" " >Provincia</option>  -->
<!-- 		                    <option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
		                  </select>
		                </div>
		             </div>
		             
		             <div class="col-register-4">
		                <div class="form__select3" style="width: 100%;">
		                  <label for="distrito">Distrito</label>
		                  <select name="distrito" id="distrito"  data-validation="required" data-validation-error-msg="Seleccionar distrito">
<!-- 		                      <option value=" " >Distrito</option>  -->
<!-- 		                    <option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
		                  </select>
		                </div>
		             </div>
		                
	                
              
            	</div>
            	
            	
					<div class="fileup-image" id="divImgDniTransferencia">
						<div class="divDniPen" id="divDniLabelTransferencia">
							<label id="stateDniPENLabelTransferencia"><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;">Adjunta aquí</span><span> la foto de tu DNI, Pasaporte y/o Carnet de Extranjería, por el lado que muestra la foto de tu rostro.</span>
								<input class="upimage is-simple" style="display:none;" type="file" name="iimage_1" id="imgDNITransferencia" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
								<canvas id="canvasDNITransferencia" style="display: none;" ></canvas>
							</label>
						</div>
						
						<div class="filenames empty" id="filenamesDniTransferencia"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpeg y png)</span>
							<div class="filename-simple" id="img-dni"></div>
						</div>	
					</div><br>
					
            	
            	<div class="form__check_legal" id="chk_legal">
                  <input type="checkbox" name="legal-form" id="legal-form" value="1">
                  <label for="legal-form">Soy un representante legal</label>
                </div>
                
                <div id="form-legal" class="view-legal">
                
            	<div class="form__section" id="tipo_3"><label>II.DATOS DEL REPRESENTANTE LEGAL.</label></div>
            	                      	
            	<div class="col-register-12">
	                <div class="col-register-6">
		                <div class="form__input" style="width: 100%;">
		                  <label for="name-legal">Nombres</label>
		                  <input type="text" name="name-legal" id="name-legal" maxlength="45" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres">
		                </div>
	                 </div>
	                 <div class="col-register-6">                 
		                <div class="form__input" style="width: 100%;">
		                  <label for="ap-paterno-legal">Apellidos</label>
		                  <input type="text" name="ap-paterno-legal" id="ap-paterno-legal" maxlength="45" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos">
		                </div>
	                </div>
	                
	                
                </div>
                
                <div class="col-register-12">
                	<div class="col-register-4">
		                <div class="form__select2" style="width: 100%;">
		                  <label for="document-type-legal"> Tipo de documento</label>
		                  <select name="document-type-legal" id="document-type-legal" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
		                    <!--option(value='') Seleccionar-->
		                    <option value="DNI" selected>DNI</option>
		                    <option value="PASAP">Pasaporte</option>
		                    <option value="CAREX">Carnet de Extranjería</option>
		                  </select>
		                </div>
	                </div>
	                <div class="col-register-4"> 
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
	             </div>
	              	                
                </div>
                
                <div class="col-register-12">
	                <div class="col-register-6">	                	
							<div class="fileup-image" id="divImgDniTransferencia3">
								<div class="divDniPen" id="divDniLabelTransferencia3">
									<label id="stateDniPENLabelTransferencia3"><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;">Adjunta aquí</span><span> la foto de tu DNI, Pasaporte y/o Carnet de Extranjería, por el lado que muestra la foto de tu rostro.</span>
										<input class="upimage is-simple" style="display:none;" type="file" name="iimage_1" id="imgDNITransferencia3" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
										<canvas id="canvasDNITransferencia3" style="display: none;" ></canvas>
									</label>
								</div>
								
								<div class="filenames empty" id="filenamesDniTransferencia3"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpg y png)</span>
									<div class="filename-simple" id="img_legal"></div>
								</div>	
							</div>							
					</div>
					
					
					<div class="col-register-6">	                	
							<div class="fileup-image" id="divImgDniTransferencia4">
								<div class="divDniPen" id="divDniLabelTransferencia4">
									<label id="stateDniPENLabelTransferencia4"><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;">Adjunta aquí</span><span> la declaración jurada certificada por un notario que acredite tu representación.</span>
										<input class="upimage is-simple" style="display:none;" type="file" name="iimage_1" id="imgDNITransferencia4" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
										<canvas id="canvasDNITransferencia4" style="display: none;" ></canvas>
									</label>
								</div>
								
								<div class="filenames empty" id="filenamesDniTransferencia4"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpg y png)</span>
									<div class="filename-simple" id="img_legal2"></div>
								</div>	
							</div>							
					</div>
                </div>
                
                </div>
                
                <div class="form__section" id="tipo_2"><label>II.TIPO DE SOLICITUD </label></div>
                <label>Seleccione un tipo de solicitud a ingresar</label><br><br>
                
                <div class="form__check_tipo_solicitud" id="tipo_solicitudes">
	                <div class="col-register-12">
	                	<div class="col-register-3"> 
	                	<label class="lbl_tipos_soli">Acceso</label>
	                	</div>
	                	
	                	<div class="col-register-9">	                		                		                		                	
	                	<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_acceso" value="1" >
	                	<label for="tipo_solicitud_acceso">Quiero saber ¿Cuáles son mis datos personales que se encuentran almacenados en las bases de datos que administra La Tinka?​<br>En "III. Coméntanos el detalle de tu solicitud de Acceso", detalla el motivo por el que deseas obtener dicha información.</label>
	                	</div>
	                 </div><br>
	                 
	                 <div class="col-register-12">
	                	<div class="col-register-3"> 	                	
	                	<label class="lbl_tipos_soli">Rectificación</label>
	                	</div>
	                	
	                	<div class="col-register-9"> 
	                	<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_rec" value="2"> 
	                	<label for="tipo_solicitud_rec">Quiero actualizar uno o más datos personales que registré inicialmente en las website que administra La Tinka​ <br>En "III. Coméntanos el detalle de tu solicitud de Rectificación", detalla cada dato personal que deseas actualizar; por ejemplo "Solicito actualizar el celular registrado en mi cuenta de usuario de Te Apuesto al número 999112233".</label>
	                	</div>
	                		                	
	                 </div><br>
	                 
	                 <div class="col-register-12">
	                	<div class="col-register-3"> 
	                	<label class="lbl_tipos_soli">Cancelación</label>
	                	</div>
	                	
	                	<div class="col-register-9"> 
	                	<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_can" value="3">
	                	<label for="tipo_solicitud_can">Quiero eliminar mi cuenta de usuario que administra La Tinka.​<br>En "III. Coméntanos el detalle de tu solicitud de Cancelación", detalla el motivo por el que deseas cancelar tu cuenta; por ejemplo: "Deseo eliminar mi cuenta y/o datos personales almacenados en La Tinka debido a que no continuaré jugando”​.</label> 
	                	</div>
	                		                		                	 	                
	                 </div><br>
	                 
	                 <div class="col-register-12">
	                	<div class="col-register-3"> 
	                	<label class="lbl_tipos_soli">Oposición</label>
	                	</div>
	                	
	                	<div class="col-register-9"> 	                		                		                		                	
	                	<input type="checkbox" name="tipo_solicitud_acceso" id="tipo_solicitud_opo" value="4">
	                	<label for="tipo_solicitud_opo">Quiero que La Tinka ya no administre el uso de mis datos personales porque me está perjudicando o porque considero que están siendo usados con otros fines de los que se me comunicó al momento de mi registro.​<br>En "III. Coméntanos el detalle de tu solicitud de Oposición", detalla el motivo o el caso por el que considera se ve perjudicado o se esté administrando incorrectamente sus datos; por ejemplo: "Solicito no recibir publicidad ya que no autoricé al momento de mi registro recibir promociones y noticias a mi correo electrónico y/o celular".</label> 	                	
	                 	</div>
	                 </div>
                 </div><br>
                 
                 <div class="form__check_tipo_solicitud f" >  
                   <input type="checkbox" name="solicitud_f" id="solicitud_f" value="" data-validation="required" data-validation-error-msg="debes seleccionar un tipo de solicitud">  
                   <label for="solicitud_f"></label>
                  </div> 
                 		                                              	          
               <div class="form__section" id="razon_solicitud">
               		<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span>                              
               </div>
               
               <div class="seccion_razon_solicitud row col-12" style="padding: 15px;">
						<textarea style="background-color: #f2f2f2;height: 85px;" cols="100" rows="3" class="razon_text" id="razon_solicitud_pd" name="razon_solicitud_pd" maxlength="300" autocomplete="off" data-validation="required" data-validation-error-msg="debes ingresar la razon de tu solicitud" ></textarea>
						
				</div>	
				
				
					<div class="fileup-image" id="divImgDniTransferencia2">
						<div class="divDniPen" id="divDniLabelTransferencia2">
							<label id="stateDniPENLabelTransferencia2"><span style="font-size: 14px;"> Si tiene alguna evidencia sobre el tratamiento de tus datos personales, </span><span class="text" style="color: #1a6d30;font-weight: 700;cursor: pointer;text-decoration: underline;font-size: 14px;">adjúntalo aquí</span>
								<input class="upimage is-simple" style="display:none;" type="file" name="iimage_1" id="imgDNITransferencia2" accept="image/jpeg, image/png" data-validation="required" data-validation-error-msg="debes cargar tu foto">
								<canvas id="canvasDNITransferencia2" style="display: none;" ></canvas>
							</label>
						</div>
						
						<div class="filenames empty" id="filenamesDniTransferencia2"><span class="filename-empty" style="font-size:11px;">Peso máximo (10mb) en formato (jpg y png)</span>
							<div class="filename-simple" id="img_razon"></div>
						</div>	
					</div>	
					
				  	              
				
				<div class="form__section" id="notificacion_respuesta" style="text-align: justify;padding-right: 30px;">
               		<span>NOTIFICACIÓN DE LA RESPUESTA </span> <br>
               		<label class="notify_response">Responderemos a tu solicitud al correo registrado. Las solicitudes se responderán dentro de los plazos establecidos en el Capítulo I del Título IV del Reglamento de la Ley de Protección de Datos Personales, aprobado por Decreto Supremo No. 003-2013-JUS. Si no obtiene respuesta dentro de los plazos indicados podrá ejercer un procedimiento de tutela ante la Dirección General de Protección de Datos Personales (Ministerio de Justicia).
               		</label>                             
               </div>
				
				<div class="form__check_pd">
                  <input type="checkbox" name="terms_politica" id="terms_politica" value="1" data-validation="required" data-validation-error-msg="La Política de Datos Personales es requerido">
                  <label for="terms_politica">He leído y acepto <a href="<%=Constants.URL_QW%>/politica-de-datos-personales/" target="_blank" class='link link__base pd'>Política de Datos Personales</a> de LA TINKA</label>
                </div>
                
                <div class="align-g-recaptcha">						
						<div class="g-recaptcha" data-sitekey="6LelcgkcAAAAAOZT1dJlIKBBP0Rgnjvbs5_t0MkY" style="margin-bottom: 30px;" ></div>
				</div>
				
				
				
                <div class="form__button">
                  <i></i>
                  <button class="button button__base_4" type="submit" id="btsubmit" disabled>Enviar</button>
                </div> 
              </form>
            </div>
          </div>
        </div>
      </div>
</div>	
    </div>

    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
    
<!-- 	<script type="text/javascript" src="layer-view-script/client/signUp.js"></script> -->

	<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=11"></script>
	<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
	
	<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
 	<script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
<!-- 	<script type="text/javascript" src="layer-view-script/common/captcha.js"></script> -->
<script src="https://www.google.com/recaptcha/api.js" async defer></script>

	<c:if test="${OperatorId ne 5588}">
		<%@ include file="../include/footer.jspf"%>
	</c:if>
	
    <%@ include file="../include/message.jspf"%>
	<script type="text/javascript">

		$(document).ready(function() {			

			renderFormFields2();
			renderFormFields3();
			//renderRegisterForm();
			renderRegisterFormDerechosArco();
			
// 			setTimeout(function(){
// 				$('input').val('');
// 			},200);
			
			$("#name").on("drop copy paste", function(){
            	return false;
             });
            $("#ap-paterno").on("drop copy paste", function(){
             	return false;
             });
			$("#email").on("drop copy paste", function(){
            	return false;
             });
			$("#domicilio").on("drop copy paste", function(){
             	return false;
             });

//  			$.ajax({
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

 			fileupImgDocument.init();
 			fileupImgDocument2.init();
 			fileupImgDocument3.init();
 			fileupImgDocument4.init();     			
		});

		var dep;
		var depart;
		var provi;
		var distri;
		var tipsoli;
		var imgBase64P3Trans = "";
		var imgBase64P4Trans = "";
		
// 		$('#departamento').change(function(){
// 			var $this = $(this)
// 			depart = $this.children(":selected").text()
// 			dep = $('#departamento').val();
			
// 			console.log(dep);
			
// 			$('#provincia').parent().removeClass('selected');
// 			$('#provincia').siblings('div').html('');
// 			$('#provincia').empty().append('<option value="" >Provincia</option> ');

// 			$('#distrito').parent().removeClass('selected');
// 			$('#distrito').siblings('div').html('');
// 			$('#distrito').empty().append('<option value="" >Distrito</option> ');


// 			$.ajax({
// 				type: "GET",
// 				url: "getProvincias.html?departamento=" + dep,
// 				dataType: "json",
//  		        async: false,
// 		        success: function (data) {

//  		        	$.each(data,function(i,obj){
//  		        		$('#provincia').append('<option value='+obj.provinceId+'>'+obj.provinceName+'</option>');
			     	
//  		        	 });					
//  		        }    
		  	        
//  			});  
									
// 		});

// 		$('#provincia').change(function(){
// 			var $this = $(this)
// 			provi = $this.children(":selected").text()
// 			var prov = $('#provincia').val();
// 			console.log(prov);
						
// 			$('#distrito').parent().removeClass('selected');
// 			$('#distrito').siblings('div').html('');
// 			$('#distrito').empty().append('<option value="" >Distrito</option> ');
			
// 			$.ajax({
// 				type: "GET",
// 				url: "getDistritos.html?provincia=" + prov +"&&departamento=" + dep,
// 				dataType: "json",
//  		        async: false,
// 		        success: function (data) {

//  		        	$.each(data,function(i,obj){
//  		        		$('#distrito').append('<option value='+obj.districId+'>'+obj.districtName+'</option>');
			     	
//  		        	 });					
//  		        }    
		  	        
//  			});  
									
// 		});

// 		$('#distrito').change(function(){
// 			var $this = $(this)
// 			distri = $this.children(":selected").text()

// 		});	

		$("#legal-form").change(function() {
		    if(this.checked) {
		        $('#form-legal').removeClass('view-legal');
		        $('#tipo_2').html('<label>III.TIPO DE SOLICITUD A INGRESAR.</label>');
		        $('#razon_solicitud').html('<span>IV.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span>  ');
		        
		    }else{
		    	$('#form-legal').addClass('view-legal');
		    	$('#tipo_2').html('<label>II.TIPO DE SOLICITUD A INGRESAR.</label>');
		        $('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span>  ');

		        $('#name-legal').val('');
		        $('#ap-paterno-legal').val('');
		        $('#document-number-legal').val('');
		        $('#document-number-pasap-legal').val('');
		        $('#document-number-carex-legal').val('');
		        $('#img_legal').html('');
		        $('#img_legal2').html('');
		        imgBase64P3Trans = "";
				imgBase64P4Trans = "";	
			}

		    var $form = $('#frm-enviar-derechos-arco');
		    if ($form.isValid({}, {}, false)) {
			      $('#btsubmit').attr('disabled', false);
			    } else {
			      $('#btsubmit').attr('disabled', true);
			    }
			
		});

		$('#tipo_solicitudes input[type="checkbox"]').on('change', function() {
			
			 var x =$(this).val();
			if(x == "1"){
				tipsoli = "Acceso";
			}else if(x == "2"){
				tipsoli = "Rectificación";
			}else if(x == "3"){
				tipsoli = "Cancelación";
			}else if(x == "4"){
				tipsoli = "Oposición";
			}

			 $( "#solicitud_f" ).on( "click", function() {
				 //$( "#solicitud_f" ).addClass("selected");
				});
			
			 
			 if($(this).prop('checked')){

				 //trigger
				 
				 if( !$( "#solicitud_f" ).prop('checked')){
					 $( "#solicitud_f" ).trigger( "click" );
					 }
				 				 
							
 			if( x == "1"){ 	
 				$('#razon_solicitud').html('<span">III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">ACCESO</span>');
 			}else if(x== "2"){	
				$('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">RECTIFICACIÓN</span>');				
 			}else if(x == "3"){ 		
 				$('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">CANCELACIÓN</span>');
 			}else if(x == "4"){ 			
				$('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">OPOSICIÓN</span>');				
 			}

			 }else{
				 $('#razon_solicitud').html('<span">III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span></span>');
				 $( "#solicitud_f" ).trigger( "click" );

			}											
 			   $('#tipo_solicitudes input[type="checkbox"]').not(this).prop('checked', false);
			
			});

		
		var renderFormFields2 = function () {
			  // pulldown
			  $(".form__select2 select").each(function () {
			    var $this = $(this),
			      $pull = $this.parent();

			    if ($pull.find("div").length === 0) {
			      $pull.prepend("<div></div>");
			    }

			    if ($this.val() === "") {
			      $pull.removeClass("selected");
			    } else {
 			      $pull.children("div").text($this.children(":selected").text());//comentado
 			      $pull.addClass("selected");//comentado
			    }

			    $this.on('change', function () {
			      $pull.children("div").text($this.children(":selected").text());
			      if ($this.val() === "") {
			        $pull.children("div").text('');
			        $pull.removeClass("selected");
			      } else {
			        $pull.children("div").text($this.children(":selected").text());
			        $pull.addClass("selected");
			      }
			    });
			  });

		  };



		  var renderFormFields3 = function () {
			  // pulldown
			  $(".form__select3 select").each(function () {
			    var $this = $(this),
			      $pull = $this.parent();

			    if ($pull.find("div").length === 0) {
			      $pull.prepend("<div></div>");
			    }

			    if ($this.val() === "") {
			      $pull.removeClass("selected");
			    } else {
 			      //$pull.children("div").text($this.children(":selected").text());//comentado
 			      //$pull.addClass("selected");//comentado
			    }

			    $this.on('change', function () {
			      $pull.children("div").text($this.children(":selected").text());
			      if ($this.val() === "") {
			        $pull.children("div").text('');
			        $pull.removeClass("selected");
			      } else {
			        $pull.children("div").text($this.children(":selected").text());
			        $pull.addClass("selected");
			      }
			    });
			  });

		  };


		  

		  var maxMb=10;
		  var imgBase64P1Trans = "";
		  var imgBase64P2Trans = "";
		  		
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
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      
						        $("#stateDniACTTransferencia").css("display","none");
						        
						        parent.removeClass('is-error');
						        $('#divDniLabelTransferencia').removeClass('is-error');
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia').getContext('2d');
					        	var imgCanvas = new Image;
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.2);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.25);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.3);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.38);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.45);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.55);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.70);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.85);
						        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		imgBase64P1Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}
						        
						        imgCanvas.onerror = function() {
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	jAlert("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img-dni').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  jAlert("Tu imagen debe ser menor a "+maxMb+"MB.");
				    			$('#img-dni').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  jAlert("Solo se permiten imágenes con extensión JPG o PNG.");
				    		$('#img-dni').html('');
				      }
			        }else{
			        	//$("#delimgDNITransferencia").trigger("click");
			        }
			    },
			    			
			    init = function () {
			      file.on('change', onChangeFile);
			      $("#updateDNITransferencia").on('click', (function () {$("#imgDNITransferencia").trigger("click")}));			      
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
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia2" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      						       
						        
						        parent.removeClass('is-error');
						      
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia2').getContext('2d');
					        	var imgCanvas = new Image;
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.2);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.25);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.3);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.38);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.45);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.55);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.70);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.85);
						        		imgBase64P2Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		imgBase64P2Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}
						        
						        imgCanvas.onerror = function() {
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	jAlert("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img_razon').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  jAlert("Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  $('#img_razon').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  jAlert("Solo se permiten imágenes con extensión JPG o PNG.");
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
						    				        
						        filename.html('<span class="filename"  type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia3" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      						       
						        
						        parent.removeClass('is-error');
						      
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia3').getContext('2d');
					        	var imgCanvas = new Image;
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.2);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.25);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.3);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.38);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.45);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.55);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.70);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.85);
						        		imgBase64P3Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		imgBase64P3Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}
						        
						        imgCanvas.onerror = function() {
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	jAlert("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img_legal').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  jAlert("Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  $('#img_legal').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  jAlert("Solo se permiten imágenes con extensión JPG o PNG.");
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
						    				        
						        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia4" class="delimg icon-error-min"></span></span><img src="layer-view-image/client/icon-valid.svg" width="20" height="20" style="margin-left:5px;">');
						      						       
						        
						        parent.removeClass('is-error');
						      
						        filenames.removeClass('empty');
						        		        		 
					        	var ctx = document.getElementById('canvasDNITransferencia3').getContext('2d');
					        	var imgCanvas = new Image;
						        if(sizeImgDNI>7000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.2);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>5000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.25);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>4000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.3);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>3000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.38);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>2000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.45);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1500000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.55);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>1000000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.70);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else if(sizeImgDNI>800000){
						        	imgCanvas.onload = function() {
						        		var newCanvas = downScaleImage(imgCanvas, 0.85);
						        		imgBase64P4Trans = newCanvas.toDataURL(img.type);
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}else{
						        	imgCanvas.onload = function() {
						        		reader = new FileReader();
								        reader.readAsDataURL(img);
							        	reader.onloadend = function () {
							        		imgBase64P4Trans = reader.result;
							        	};
						        	}
						        	imgCanvas.src = URL.createObjectURL(img);
					        	}
						        
						        imgCanvas.onerror = function() {
						        	//$("#delimgDNITransferencia").trigger("click");
						        	//showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
						        	jAlert("Debes adjuntar una imagen v&aacute;lida");
						        	$('#img_legal2').html('');
					        	}
						      }  
				    	  }else{
				    		  //showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  jAlert("Tu imagen debe ser menor a "+maxMb+"MB.");
				    		  $('#img_legal2').html('');
				    	  }
				      }else{
				    	  //showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
				    	  jAlert("Solo se permiten imágenes con extensión JPG o PNG.");
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


		  $('#btsubmit').click(function(){

			  	var ico = $(this).siblings('i');
	    		var response = grecaptcha.getResponse();
	    		var nacion = $('#nacionalidad').children(":selected").text();
	    		//$("#document").addClass("valid");

	    		if(response.length !=0){
	    					
	    			 $.ajax({
	    	              url: "enviarDerechosArco.html",
	    	              data: {"imgBase64P1Trans":imgBase64P1Trans,"imgBase64P2Trans":imgBase64P2Trans,"nombres":$('#name').val(),"apellidos":$('#ap-paterno').val(),
		    	              "email":$('#email').val(),"dni":$('#document-number').val(),"document-number-pasap":$('#document-number-pasap').val(),"document-number-carex":$('#document-number-carex').val(),"usuario":$('#usuario').val(),"telefono":$('#mobile-phone').val(),"departamento":depart,
		    	              "provincia":provi,"distrito":distri,"domicilio":$('#domicilio').val(),"solicitud":tipsoli,"razon":$('#razon_solicitud_pd').val(), "name-legal":$('#name-legal').val(),
		    	              "ap-paterno-legal":$('#ap-paterno-legal').val(),"document-number-legal":$('#document-number-legal').val(),"document-number-pasap-legal":$('#document-number-pasap-legal').val(),
		    	              "document-number-carex-legal":$('#document-number-carex-legal').val(),"imgBase64P3Trans":imgBase64P3Trans,"imgBase64P4Trans":imgBase64P4Trans, "document-type": $("#document-type").val(), "document-type-legal": $("#document-type-legal").val(), 
		    	              "is-representante": $('#legal-form').prop("checked"), "nacionalidad":nacion
		    	              },
	    	              type: 'POST',
	    	              dataType: 'json',
	    	              beforeSend: function () {
	    	            	  $(ico).addClass('loading-ilot');
	    	            	  //$('body').append('<div id="loader-frm-register"></div>');
	    	              },
	    	              error: function () {
	    	            	  //$('body').find('#loader-frm-register').remove();
	    	            	  $(ico).removeClass('loading-ilot');
	    	            	  jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
	    	              },
	    	              success: function (data) {
	    	            	  //$('body').find('#loader-frm-register').remove();
	    	            	  $(ico).removeClass('loading-ilot');
	    	            	  if(data.message==="OK"){
	    	            		 // $("#secuencia").val(data.secuencia);
	    	            		  //$("#fecha").val(data.fecha);
	    	            		  //form.submit();
	    	            		  jAlert('Tu solicitud de Derechos Arco ha sido enviada, te responderemos dentro del plazo establecido.', null, function (r) {if(r) {$(parent.location).attr('href', 'mi-cuenta.html');}});
	    	            	  }else if(data.message ==="IMGKO"){
	    	            		  jAlert(data.errorimg);
	    	            	  }else if(data.message ==="KO"){
		    	            	 jAlert('¡No se envio el correo! \nPor favor inténtelo nuevamente.');  
		    	              } else{
		    	            		  jAlert(data.error);
		    	            		  
		    	            	  }
	    	            	 
	    	              }
	    			  });

	    		}else{
	    			jAlert('Por seguridad, debes seleccionar el código captcha.');
	    			
	    		}
	    	});

		  $('#imgDNITransferencia').on("click",function(){
				$(this).val('');
				console.log(this);
				
			});

			$('#imgDNITransferencia2').on("click",function(){
				$(this).val('');
				console.log(this);
				
			});

			$('#imgDNITransferencia3').on("click",function(){
				$(this).val('');
				console.log(this);
				
			});

			$('#imgDNITransferencia4').on("click",function(){
				$(this).val('');
				console.log(this);
				
			});

			 $('#document-type').on("click",function(){

				 var x = $(this).val();
				 console.log(x);
			 });
			
					  	
	
	</script>
<script type="text/javascript" src="layer-view-script/client/locationData.js?v=2"></script>

    
    	
</body>
</html>