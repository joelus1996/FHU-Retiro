<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
      <meta name='description' content='La Tinka móvil, términos y condiciones' />
      <title>La Tinka : Términos y condiciones</title>
   </head>
   <body>
      <div class="content-modal has-action" style="text-align: center !important; font-family: AllerRegular, Arial, sans-serif !important; letter-spacing: 0 !important;">
      	<c:if test="${locacionTYC == 'login'}">
         	<c:if test="${empty agreement}">
            	<p ><br/>Estimado cliente, hemos actualizado los t&eacute;rminos y condiciones de nuestra tienda virtual, por lo tanto le invitamos a informarse y aceptar el contenido de los mismos para que pueda continuar usando su cuenta de La Tinka en cualquiera de nuestras plataformas.</p>
         	</c:if>
         </c:if>
         <div align="center">
            <h1>T&Eacute;RMINOS Y CONDICIONES</h1>
         </div>
         <div style="margin-right: 5px; margin-left: 5px;">
            <div  data-role="collapsible" data-theme="a" data-content-theme="d"  >
               <div>
                  <div>
                     <ul class="indice">
                        <li><a href="#" onclick="window.document.location.href='#lblIntro';return false;">Introducci&oacute;n</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblAlcan';return false;">Alcances generales</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblRegis';return false;">Registro o cuenta de usuario</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblRecar';return false;">Recarga de la cuenta de usuario</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblCierr';return false;">Cierre de la cuenta de usuario</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblCondi';return false;">Condiciones generales de la jugada</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblPagos';return false;">Pagos de premios</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblOblig';return false;">Obligaciones como usuario</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblPolit';return false;">Pol&iacute;tica de privacidad</a></li>
                        <!-- <li><a href="#" onclick="window.document.location.href='#lblConfi';return false;">Confidencialidad de datos</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblConse';return false;">Consentimiento del usuario</a></li> -->
                        <li><a href="#" onclick="window.document.location.href='#lblRecla';return false;">Reclamaciones y/o quejas</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblLimit';return false;">Limitaci&oacute;n de responsabilidad</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblIncum';return false;">Incumplimiento</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblPropi';return false;">Propiedad intelectual</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblLegis';return false;">Legislaci&oacute;n aplicable</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblCesio';return false;">Cesi&oacute;n de posici&oacute;n contractual</a></li>
                        <li><a href="#" onclick="window.document.location.href='#lblAcuer';return false;">Acuerdo</a></li>
                     </ul>
                     <br/>
                     <br/>
                     <h2 id="lblIntro">Introducción</h2>
                     <p>Bienvenido a la plataforma virtual de LA TINKA S.A. (en adelante LA TINKA), en la que el usuario podrá divertirse, participar, revisar información relevante; así como registrarse o crear una Cuenta virtual que le permitirá comprar en línea sus juegos de Loterías y Apuestas Deportivas.</p>
                     <p>Lea los siguientes términos y condiciones (T&amp;C) cuidadosamente, a fin de conocer los beneficios, restricciones, administración de la plataforma web, accesible desde su página web: www.latinka.com.pe, tienda virtual: zonasegura.intralot.com.pe, web móvil: m.latinka.com.pe; así como de otro tipo de medio y/o URL relacionada a los juegos que ofrece LA TINKA y para conocer del uso de su información personal.</p>
                     <h2 id="lblAlcan">CAPITULO PRIMERO<br />ALCANCES GENERALES</h2>
                     <p><b>1.1</b> Los T&amp;C constituyen un acuerdo vinculante entre el Usuario e LA TINKA, y al hacer clic en “ACEPTO LOS TÉRMINOS Y CONDICIONES” al momento de registrase o crear su cuenta, el Usuario reconoce ante LA TINKA que ha leído atentamente, entiende y que los acepta, por lo que se obliga a cumplirlos y respetarlos.</p>
                     <p><b>1.2</b>  En caso de no estar de acuerdo con los T&amp;C de manera total o parcial, no se permitirá su registro. En caso ya se encuentre registrado deberá suspender el uso de su cuenta.</p>
                     <p><b>1.3</b>  LA TINKA, se reserva el derecho de modificar o eliminar parcial o totalmente los presentes T&amp;C en cualquier momento. Cuando esto suceda se informará al Usuario de las nuevas reglas.</p>
                     <p><b>1.4</b>  Las modificaciones serán efectivas desde el momento que se publiquen en la tienda virtual y web móvil, para lo cual el Usuario es el único responsable de revisar, verificar y aceptar el presente acuerdo.</p>
                     <p><b>1.5</b>  Las normas, instrucciones, libro de reclamaciones, los reglamentos de cada juego y cualquier otra información importante para participar en los Juegos de LA TINKA, se ofrecen en sus respectivas Página Web del Portal de LA TINKA.</p>
                     <h2 id="lblRegis">CAPITULO SEGUNDO<br />REGISTRO O CUENTA DE USUARIO</h2>
                     <p><b>2.1</b> Los juegos, modalidades y/o actividades promociones de LA TINKA son sólo para personas naturales mayores de 18 años, que residen en el país.</p>
                     <p><b>2.2 Registro</b></p>
                     <ul class="list">
                        <li>
                           <p>Para registrarse o crear un Cuenta para jugar a través de la tienda virtual y/o web móvil, el Usuario deberá hacer clic en el enlace o acceso “REGÍSTRATE”.</p>
                        </li>
                        <li>
                           <p>Completar correctamente el formulario de registro y aceptar los T&amp;C.</p>
                        </li>
                        <li>
                           <p>A continuación recibirá un correo electrónico confirmando su registro y la opción para “ACTIVAR CUENTA”</p>
                        </li>
                        <li>
                           <p>Una vez activa su cuenta podrá iniciar sesión con sus datos de usuario y contraseña registrados.</p>
                        </li>
                     </ul>
                    <p><b>2.3</b> Con el fin de garantizar la Seguridad de la Cuenta, el Cliente / Usuario se compromete a registrar su propia cuenta con datos reales, correctos y completos. Solo se permite una cuenta por persona, familia, hogar, direcci&oacute;n (postal e IP), correo electr&oacute;nico o entorno donde se comparta ordenador (ejemplo: centro de estudio, puestos de trabajo, locutorios, cabinas de internet, entre otros). No se permite m&aacute;s de una cuenta por ordenador (o dispositivo de acceso). Tampoco se permite suplantaci&oacute;n de identidad de la cuenta y de los datos ingresados para su creaci&oacute;n. Cualquier otra cuenta que no cumpla con los presentes T&eacute;rminos y Condiciones ser&aacute; denominada "Cuenta Duplicada". La Tinka se reserva el derecho de cerrar cualquier duplicaci&oacute;n, pero no est&aacute; obligada a hacerlo. Si La Tinka cierra una Cuenta Duplicada, as&iacute; como cualquier cuenta que sea fraudulenta, todos los bonos, apuestas gratis y las ganancias acumuladas de dichas promociones ser&aacute;n anuladas. La Tinka puede, a su entera discreci&oacute;n, anular todas las ganancias y devolver los dep&oacute;sitos/recargas (menos las cantidades referentes a las ganancias anuladas o jugadas perdidas) derivadas de la Cuenta Duplicada o fraudulenta y, en caso de quedar saldo negativo, La Tinka puede recuperar dicho monto directamente desde cualquier cuenta del cliente (incluyendo otras Cuentas Duplicadas). La Tinka puede, a su sola discreci&oacute;n, permitir el uso de una Cuenta Duplicada, en cuyo caso todas las p&eacute;rdidas y apuestas realizadas por o para el Cliente a trav&eacute;s de dicha cuenta ser&aacute;n retenidas por La Tinka. Este criterio y regularizaci&oacute;n son aceptados por el cliente al momento de registrarse en La Tinka. En caso de que la cuenta se encuentre con saldo cero, la cuenta ser&aacute; cerrada y anulada evitando la realizaci&oacute;n de p&eacute;rdidas, para lo cual no se realizar&aacute; devoluci&oacute;n alguna.</p>
					<p><b>2.4</b> En caso el usuario ingrese datos incorrectos o no v&aacute;lidos LA TINKA se reserva el derecho a no proceder con el registro.</p>
					<p><b>2.5</b> LA TINKA est&aacute; autorizado a realizar procesos de verificaci&oacute;n por s&iacute; mismo o a trav&eacute;s de tercero, en caso tenga indicios de que la informaci&oacute;n ingresada es incorrecta o falsa, para lo cual podr&aacute; bloquear, suspender o cerrar las Cuentas de Usuario.</p>
					<p><b>2.6</b> LA TINKA, no se hace responsable de cualquier abuso o mal uso de la cuenta de Usuario por parte de terceros. En caso el Usuario tome conocimiento de cualquier uso no autorizado de su cuenta por parte de terceros, deber&aacute; notificarlo inmediatamente a LA TINKA llamando al n&uacute;mero de tel&eacute;fono 01 513 5502, con la finalidad de suspender la cuenta. Sin embargo, LA TINKA no ser&aacute; responsable de las p&eacute;rdidas que ocasione dicho evento.</p>
					<p><b>2.7</b> Asimismo, cualquier activaci&oacute;n o transacci&oacute;n que se realice en la cuenta de Usuario, utilizando la contrase&ntilde;a y nombre de Usuario correctos ser&aacute; considerada por LA TINKA como un acceso v&aacute;lido por parte del Usuario.</p>
					<p><b>2.8</b> Al momento del registro el Usuario autoriza expresamente a LA TINKA, mediante la aceptaci&oacute;n de los presentes T&amp;C, a enviar informaci&oacute;n de publicidad, promociones, y/o cualquier tipo de informaci&oacute;n al correo electr&oacute;nico, , n&uacute;mero de tel&eacute;fono y/o cualquier otro medio de contacto brindado al momento del registro</p>
					<p>Si el USUARIO desea dejar de recibir publicidad de LA TINKA, deberá deber&aacute; llamar al n&uacute;mero de tel&eacute;fono 01 513 5502; o en su defecto en la opción regístrate, deberá desmarcar dicha opción.</p>
					                     <h2 id="lblRecar">CAPITULO TERCERO<br />RECARGA DE LA CUENTA DE USUARIO</h2>
                     <p><b>3.1</b> Para poder realizar jugadas, el Cliente deberá cargar saldo a su cuenta ingresando a la sección “SALDO” desde cualquier plataforma y elegir la modalidad de recarga de su preferencia:</p>
                     <ul class="list">
                        <li>
                           <p><b>VISANET, MasterCard y Agora.-</b> El usuario podrá realizar recargas en línea desde S/20 hasta S/1,000 con sus tarjetas de débito y/o crédito VISA y/o MasterCard nacionales o con su tarjeta Agora. Se hará el cobro de una comisión que se vera reflejada en el proceso de recarga. LA TINKA asumirá el monto por concepto de IGV correspondiente a las comisiones por recarga.<br/><br/>LA TINKA es una empresa compatible con el cumplimiento PCI de seguridad de VISA. LA TINKA no procesa ni almacena los datos de la tarjeta de los usuarios por lo que todas las transacciones de recarga son codificadas y 100% seguras a través de la plataforma de VISA.<br/><br/>LA TINKA no se hace responsable de depósitos realizados con tarjetas de propiedad de terceros. Es responsabilidad del cliente de la transacción que se realiza en su cuenta, cualquier reclamo deberá efectuarse directamente a su banco.
                           </p>
                        </li>
                        <li>
                           <p><b>LOTOCARD.-</b> el Usuario deberá adquirir su tarjeta prepago LOTOCARD en todos los Puntos de venta de La Tinka a nivel nacional, raspar el área gris que tiene en la parte posterior e ingresar el código PIN de 14 dígitos. En caso adquiera un código PIN VIRTUAL a través de alguna modalidad y/o promoción deberá realizar el mismo proceso.<br />El derecho al uso del crédito caduca a los ciento ochenta (180) días calendario contados desde la fecha de activación.<br />Por el hecho de activar la tarjeta pre impresa LOTOCARD o adquirir un pin virtual, el jugador acepta la recepción de publicidad de LA TINKA.
                           </p>
                        </li>
                        <li>
                           <p><b>Con Interbank.-</b> Para cargar saldo a través de la Cuenta del Banco Interbank, el cliente deberá ingresar a su Banca por Internet o acercarse a algún agente autorizado y solicitar su carga de saldo por un monto mínimo de S/10 (diez y 00/100 Soles) y máximo S/10,000  (diez mil y 00/100 Soles), mediante los siguientes procesos:</p>
                           <ul class="sublist">
                              <li>
                                 <p>Ingresando al App Interbank o la Banca por Internet Interbank.pe, luego a Operaciones / Pagos y Recargas / Pago a Institución o Empresas / La Tinka / Recarga Web. En la página del banco procederá a ingresar el monto a cargar y el DNI registrado en su cuenta de Usuario.</p>
                              </li>
                              <li>
                                 <p>Acudiendo a cualquier Interbank agente, a nivel nacional, el cliente solicitará su recarga web La Tinka indicando el importe a pagar y su DNI.</p>
                              </li>
                           </ul>
                        </li>
                        <li>
                           <p><b>Con cuenta BCP.-</b> Para cargar saldo a través de la Cuenta del Banco BCP, el cliente deberá generar el Código BCP, cuyo monto mínimo para solicitarlo es de S/30 (treinta y 00/100 Soles), y el máximo S/10,000 (diez mil y 00/100 Soles) el cual posteriormente se deberá pagar a través del banco BCP, mediante los siguientes procesos:</p>
                           <ul class="sublist">
                              <li>
                                 <p>Ingresando a www.viabcp.com, luego a la sección pago de servicios/compras/La Tinka/Recargas Lotocard. En la página del banco procederá a ingresar el Código BCP generado, y posteriormente deberá pagar el importe solicitado.</p>
                              </li>
                              <li>
                                 <p>O acudiendo a cualquier agencia o agente BCP a nivel nacional con el código BCP generado y pagar la suma correspondiente de acuerdo al siguiente rubro: pago de servicios/empresas diversas/La Tinka/recargas Lotocard. El Usuario deberá indicar al funcionario del banco el Código BCP y el importe a pagar.</p>
                              </li>
                           </ul>
                        </li>
                        <li>
                           <p><b>A través de SafetyPay (Banca por Internet).-</b> El Usuario debe generar el código de transacción solicitando cómo mínimo S/ 40.00 (cuarenta y 00/100 Soles) y máximo S/ 3,000 (Tres mil con 00/100 soles)<br />El Usuario deberá elegir entre pagar a través de su Banca por Internet o Efectivo en las agencias o agentes del BCP, BBVA Continental, Interbank, Scotiabank. Para realizar el pago el usuario debe indicar el código generado y verificar la carga de saldo en su Cuenta La Tinka.</p>
                        </li>
                        <li>
                           <p><b>A través de Pago Efectivo.-</b> El Usuario debe generar el código de transacción solicitando como mínimo S/ 40.00 (cuarenta y 00/100 Soles) y máximo S/ 3000.00 (tres mil y 00/100 Soles).<br />El Usuario deberá elegir pagar a través de su Banca por Internet o en Efectivo a través de cualquier agente corresponsal del BBVA, BCP, Interbank, Scotiabank, Banbif, Kasnet, Western Union - Pagos de Servicios y Fullcarga. Para realizar el pago el usuario debe indicar el código generado y verificar la carga de saldo en su Cuenta La Tinka.</p>
                        </li>
                        <li>
                        	<p><b>En Red Digital.-</b> El Usuario podr&aacute; realizar sus recargas en efectivo en todos los agentes autorizados de Red Digital, solicitando recargas de Te Apuesto o La Tinka, con un monto m&iacute;nimo de S/ 10 y m&aacute;ximo de S/ 150 por recarga.</p>
							<p>Para solicitar la recarga el usuario tambi&eacute;n deber&aacute; indicar el n&uacute;mero de DNI y el n&uacute;mero de celular registrado en su cuenta de La Tinka.</p>
						</li>
                     </ul>
                     <p><b>3.2</b> La recarga de la cuenta a través de cualquier medio puede demorar más de 24 horas, debido a las verificaciones de las empresas intervinientes. LA TINKA no asume ningún tipo de responsabilidad por el tiempo tomado para realizar las verificaciones necesarias.</p>
                     <p><b>3.3</b> El saldo cargado a través de las diferentes modalidades de recarga, no se podrá cobrar en efectivo. Sólo se puede liquidar/cobrar en efectivo los montos de los premios.</p>
                     <p><b>3.4</b> El Usuario no podrá transferir saldo entre cuentas de Usuario de su propiedad o de terceros, tampoco podrá recibir saldo en su cuenta proveniente de otras cuentas de Usuario, en caso de incumplimiento LA TINKA podrá dar por concluido el presente acuerdo y cerrar las cuentas de Usuario involucradas.</p>
                     <p><b>3.5</b> El Usuario sólo podrá realizar jugadas, siempre que tenga saldo suficiente para realizarlas. LA TINKA no le dará ningún crédito para participar en ningún juego.</p>
                     <p><b>3.6</b> LA TINKA, como empresa administradora, tiene el derecho de nombrar Proveedores de Soluciones de Pago para que actúen, reciban y/o paguen fondos a su nombre.</p>
                     <p><b>3.7</b> Las instrucciones e información adicional para abonar saldo a la Cuenta de Usuario, se encuentra disponible en su cuenta. El Usuario puede utilizar cualquiera de los métodos disponibles para la recarga, LA TINKA no se hace responsable de cualquier daño o perjuicio que se pueda causar al Usuario en caso algún método de recarga no esté disponible en su país. LA TINKA, se reserva el derecho de modificar las modalidades de recarga de acuerdo a las disposiciones comerciales que considere conveniente.</p>
                     <p><b>3.8</b> Dependiendo del método seleccionado y/o Entidad Bancaria, los abonos pueden llevar cargos y/o intereses adicionales.</p>
                     <p><b>3.9</b> LA TINKA está facultado a utilizar procedimientos y/o medios adicionales con la finalidad de verificar la identidad del Usuario, como medida de seguridad al momento de que éste realice recargas en su cuenta de Usuario, esta facultad no responsabiliza a LA TINKA, en caso el cliente sufra contingencia en sus cuentas bancarias.</p>
                     <p><b>3.10</b> El saldo depositado en la Cuenta de Usuario, sólo podrá ser utilizado para jugar los juegos proveídos por LA TINKA, a través de la tienda virtual y/o web móvil de LA TINKA. El Usuario se compromete a no utilizarlo para fines diferentes a los mencionados anteriormente.</p>
                     <p><b>3.11</b> El saldo que se mantenga en la cuenta de Usuario no generará intereses de ningún tipo.</p>
                     <p><b>3.12</b> El saldo que se mantenga en una cuenta sin actividad de recarga por un período de 6 meses, retornará a LA TINKA.</p>
                     <h2 id="lblCierr">CAPITULO CUARTO<br />CIERRE DE LA CUENTA DE USUARIO</h2>
                     <p><b>4.1</b> LA TINKA se reserva el derecho de cerrar y/o anular cualquier cuenta de Usuario que viole o vaya en contra de las leyes, la buena costumbre y/o el orden público. Asimismo, LA TINKA podrá iniciar las acciones legales que considere pertinentes.</p>
                     <h2 id="lblCondi">CAPITULO QUINTO<br />CONDICIONES GENERALES DE LA JUGADA</h2>
                     <p><b>5.1</b> Todos los juegos que se realicen a través de la tienda virtual y/o web móvil de LA TINKA, serán registrados en el sistema de LA TINKA. En la tienda virtual el Usuario podrá visualizar su historial de jugadas con un período de antigüedad de hasta 180 días ingresando al enlace o acceso “Mis Jugadas”, ubicada dentro de la sección “Mi Cuenta”; mientras que en web móvil el Usuario podrá visualizar su historial de jugadas con un período de antigüedad de hasta 30 días.</p>
                     <p><b>5.2</b> El Usuario es consciente que las jugadas no pueden ser anuladas, en ningún momento y bajo ninguna circunstancia.</p>
                     <p><b>5.3</b> En caso el Usuario esté realizando una jugada y antes del término de la misma se pierda la conexión, el sistema automáticamente completará la jugada. LA TINKA no se hace responsable por los resultados de dicha jugada, puesto que es responsabilidad del Usuario contar con el sistema adecuado.</p>
                     <p><b>5.4</b> El Usuario podrá visualizar el estado de sus boletos de jugadas con premio, sin premio o expirados ingresando a “Mis Jugadas”, ubicada dentro de la sección “Mi Cuenta”</p>
                     <h2 id="lblPagos">CAPITULO SEXTO<br />PAGOS DE PREMIOS</h2>
                     <p><b>6.1</b> Los premios monetarios obtenidos de las jugadas realizadas de loterías y Ganagol en la web de La Tinka podrán ser cobrados de dos formas:</p>
                     <ul class="list lista-alpha">
                        <li>
                           <p><b>Cargando premio al saldo de su Cuenta</b><br/>El cliente tendrá la opción de cobrar sus premios en "Cobrar mis Premios", seleccionando la opción "Cargar al saldo". Dicho monto se incrementará automáticamente al total de su saldo y no podrá ser cobrado en efectivo en caso el cliente lo desee.</p>
                           <p>El cliente también podrá visualizar la carga realizada en la sección "Movimientos".</p>
                        </li>
                        <li>
                           <p><b>Efectivo o Punto de Venta</b><br/>El cliente deberá ingresar a la sección "Últimas jugadas", acceder a su boleto, generar el código de QR y presentarse en su punto de venta más cercano.</p>
                           <p>Los boletos con premios de hasta S/ 5,000 deberán ser cobrados a partir del primer día útil siguiente al sorteo y/o evento correspondiente, previa presentación del boleto ganador (siempre que el boleto tenga un premio pendiente en el sistema), en todos los puntos de venta a nivel nacional, siempre que dicho punto disponga de dinero en efectivo. De lo contrario, el ganador deberá acercarse a otro punto de venta o a la Tienda Autorizada más cercana cuya ubicación se encuentra en www.latinka.com.pe.</p>
                           <p>Los premios mayores o iguales a S/ 5,000 y menores a S/ 1´000,000 deberán cobrarse en las Tiendas Autorizadas cuya ubicación se encuentra en www.latinka.com.pe de lunes a viernes entre las 9:00 a.m. y las 6:00 p.m. Estos podrán ser pagados en un plazo máximo de treinta (30) días calendarios siguientes a la fecha en que haya sido debidamente presentado y validado el boleto ganador, siempre que el boleto tenga un premio pendiente en el sistema. El pago de dicho premio podrá realizarse en cheque o transferencia bancaria de acuerdo con la disposición de La Tinka. En caso, se realice por transferencia bancaria el ganador deberá indicar un número de cuenta a su nombre para proceder con la transferencia.</p>
                           <p>Los premios millonarios mayores o iguales a S/ 1´000,000 deberán cobrarse en la oficina principal de La Tinka S.A. en Lima, cuya dirección se encuentra publicada en www.latinka.com.pe, podrán ser pagados en un plazo máximo de noventa (90) días.</p>
                           <p>En todos los casos, el ganador debe identificarse con su documento de identidad correspondiente, cuando La Tinka lo requiera.</p>
                        </li>
                     </ul>
                     <p><b>6.2</b> Los premios monetarios acumulados obtenidos a través de los juegos de Te Apuesto, Casino, RaspaYá y Deportes Virtuales, podrán ser cobrados de dos formas:</p>
                     <ul class="list lista-alpha">
                        <li>
                           <p><b>Efectivo o Punto de Venta</b><br/>El cliente deberá ingresar a la sección "Cobrar mis Premios", seleccionar "Efectivo/ Punto de venta" y solicitar el monto que desee cobrar.</p>
                           <p>La Tinka definirá bajo criterio de control de seguridad y fraude la solicitud del DNI del cliente a partir de un monto especifico.</p>
                           <p>Una vez realizada la solicitud, la evaluación de su retiro se realizará máximo 72 horas después realizada su solicitud. No obstante, La Tinka podrá extender dicho plazo a su solo criterio. </p>
                           <p>Una vez aprobado el retiro, es indispensable acercarse al punto con el DNI para la comprobación de sus datos y el cobro correspondiente.</p>
                        </li>
                        <li>
                           <p><b>Visa o Agora</b><br/>El cliente deberá ingresar a la sección "Cobrar mis Premios", seleccionar los métodos "Visa" o "Agora" y solicitar el monto que desee cobrar con sus tarjetas de débito y/o crédito VISA nacionales o su tarjeta Agora. Se hará el cobro de una comisión que se vera reflejada en el proceso de retiro. LA TINKA asumirá el monto por concepto de IGV correspondiente a las comisiones por retiro.</p>
                           <p>La Tinka definirá bajo criterio de control de seguridad y fraude la solicitud del DNI del cliente a partir de un monto especifico.</p>
                           <p>LA TINKA es una empresa compatible con el cumplimiento PCI de seguridad de VISA. LA TINKA no procesa ni almacena los datos de la tarjeta de los usuarios por lo que todas las transacciones para retiro son codificadas y 100% seguras a través de la plataforma VISA.</p>
                           <p>La primera vez que solicite un retiro, deberá adjuntar una imagen de su DNI vigente. Para los siguientes retiros, no será necesario cumplir con esta condición, debido a que su cuenta de La Tinka se encontrará validada para retiro. Si actualiza el adjunto de su DNI, se realizará una nueva validación.</p>
                           <p>La Tinka no se hace responsable de retiros realizados con tarjetas de propiedad de terceros. Es responsabilidad del cliente de la solicitud de retiro que se realice a su cuenta, cualquier reclamo deberá efectuarse directamente a su banco.</p>
                           <p>La evaluación de su retiro se realizará máximo 72 horas después realizada su solicitud. No obstante, La Tinka podrá extender dicho plazo a su solo criterio.</p>
                           <p>Si la tarjeta cuenta con Fast Funds, la transferencia es inmediata luego de La Tinka haber aprobado dicha transacción. Si no contara con este atributo, la transferencia será procesada después de 48 horas como máximo.</p>
                        </li>
                     </ul>
                     <p><b>6.3</b> Por temas de seguridad y procedimientos contra el lavado de dinero, fraude y/o abusos de bonos, se debe tener en cuenta que, para la aprobación de su retiro, este dinero debe haber sido apostado al 100%.</p>
                     <p><b>6.4</b> Puede retirar la cantidad de la bolsa liquidable en su cuenta mediante la emisión de una notificación válida de retiro. Los avisos de retiro sólo deben hacerse en el sitio web.</p>
                     <p><b>6.5</b> La Tinka puede rechazar una solicitud de retiro si se sospecha que se están retirando fondos para cualquier tipo de fines fraudulentos o de lavado de dinero.</p>
                     <p><b>6.6</b> El cliente es responsable de informar a La Tinka cualquier cambio de cuenta. Para dicho fin deberá comunicarse a Servicio al Cliente 513 5502 Opc. 2, enviar nuevamente su DNI y los datos de la cuenta nueva. En caso no realice la comunicación oportuna de dicho cambio, La Tinka no se hace responsable ni está obligado a procesar nuevamente la transacción.</p>
                     <p><b>6.7</b> Los métodos de pago vigentes están publicados en la sección "Tutoriales - ¿Cómo cobrar mis Premios?" de la web. No se realizan pagos a la cuenta por métodos no incluidos en la sección.</p>
                     <h2 id="lblOblig">CAPITULO SEPTIMO<br />OBLIGACIONES COMO USUARIO</h2>
                     <p><b>7.1</b> Al momento de ACEPTAR los T&amp;C, el Usuario garantiza y reconoce lo siguiente:</p>
                     <ul class="list">
                        <li><p>Que es mayor de edad (de 18 años a más), y que no tiene impedimento legal para participar en los juegos de loterías y apuestas deportivas que ofrece LA TINKA.</p></li>
                        <li><p>Que utiliza esta página y su cuenta de Usuario única y exclusivamente con la intención de participar en los juegos de loterías y apuestas deportivas ofrecidos por LA TINKA, y no por cualquier otra finalidad.</p></li>
                        <li><p>Que participa en los juegos de loterías y apuestas deportivas de LA TINKA, en nombre propio y no a favor de terceros.</p></li>
                        <li><p>Que toda la información que facilita a LA TINKA durante la validez del presente contrato es verdadera, completa y correcta, en caso existiese la necesidad de realizar algún cambio de información, el Usuario deberá modificarlo inmediatamente. Asimismo, el Usuario es consciente que la información ingresada servirá para hacer efectivo el cobro de sus premios, por lo tanto es el único responsable de consignar la información correcta.</p></li>
                        <li><p>Que todo monto cargado a su cuenta por concepto de saldo, no proviene de fuente prohibida y/o ilegal. Asimismo, LA TINKA podrá iniciar las acciones legales y comerciales pertinentes.</p></li>
                        <li><p>Que no está implicado en ninguna actividad fraudulenta, abusiva, manipuladora o ilegal en relación con su participación o de terceras personas, a través de los juegos de loterías y apuestas deportivas y no utilizará métodos asistidos de software, técnicas y/o dispositivos de hardware para participar en ninguno de los juegos. Por la presente LA TINKA se reserva el derecho de invalidar o cerrar su Cuenta de Usuario o invalidar su participación en un Juego en el caso de que ocurra dicho comportamiento.</p></li>
                     </ul>
                     <p><b>7.2</b> El Usuario se compromete a indemnizar de manera total a LA TINKA por cualquier, daño, perjuicio, pérdida, y/o gasto que genere a LA TINKA, por causas imputables a él, que puedan surgir en relación con el uso de la página web o de su participación en los juegos que ofrece.</p>
                     <h2 id="lblPolit">CAPITULO OCTAVO<br />POLÍTICA DE PRIVACIDAD</h2>
                     <p><b>8.1</b> El Usuario no podrá hacer uso de la tienda virtual y/o web móvil de LA TINKA de forma ilegal o en cualquier otra manera que pudiera dañarla, incapacitarla o perjudicarla.</p>
                     <p><b>8.2</b> El Usuario autoriza a LA TINKA a usar su información personal para los fines comerciales que considere conveniente. Sin embargo, LA TINKA estará facultado a proporcionar los datos personales ingresados por los Usuarios, en caso sea exigido por ley o mandato judicial.</p>
                     <p><b>8.3</b> LA TINKA a través de su tienda virtual y web móvil recopila una pequeña pieza de información enviada desde su navegador, llamada cookie. En caso el Usuario desee desactivar el cookie deberá verificar las instrucciones de su navegador.</p>
                     <!-- <h2 id="lblConfi">CAPITULO NOVENO<br />CONFIDENCIALIDAD RESPECTO DE DATOS PERSONALES DEL USUARIO</h2>
                     <p><b>9.1</b> Conforme a lo establecido en la Ley de Protección de Datos Personales - Ley 29733 y su Reglamento, LA TINKA en su calidad de titular de un banco de datos personales, garantiza el adecuado tratamiento de los datos personales del USUARIO que serán informados por este (los “Datos Personales”) y, a su vez, se compromete a guardar plena confidencialidad sobre todos los Datos Personales del USUARIO que solicite y/o tome conocimiento, según lo que se indica a continuación:</p>
                     <ul class="list">
                        <li><p>LA TINKA considerará a la información recibida como estrictamente confidencial y privada, debiendo tomar todas las medidas de seguridad del caso a fin de preservar dicha confidencialidad.</p></li>
                        <li><p>LA TINKA utilizará la información recibida con un propósito informativo y como parte de las actividades económicas e internas de la empresa, sin ánimo de lucro y comprometiéndose a no transferir la información a terceros, salvo los consentimientos que otorgo en virtud de este documento.</p></li>
                     </ul>
                     <h2 id="lblConse">CAPITULO DECIMO<br />CONSENTIMIENTO DEL USUARIO A LA TINKA PARA EL TRATAMIENTO DE SUS DATOS PERSONALES</h2>
                     <p><b>10.1</b> El USUARIO entregará a LA TINKA los Datos Personales, respecto de los cuales se tendrá en cuenta lo siguiente:</p>
                     <ul class="list">
                        <li><p>El USUARIO otorga su total y absoluto consentimiento a LA TINKA para que este realice el tratamiento de los Datos Personales a los que ha tenido acceso, conforme a lo establecido en la Ley de Protección de Datos Personales y su Reglamento, manifestando haber tomado conocimiento de que la única finalidad para la que los Datos Personales han sido obtenidos es de carácter informativo y como parte de las actividades económicas de LA TINKA, sin ánimos de lucro y sin ningún objetivo ilícito.</p></li>
                        <li><p>Conforme a lo indicado en el numeral anterior, el USUARIO ha tomado conocimiento del tratamiento al que los Datos Personales serán sometidos, el cual se basará únicamente en el almacenamiento, registro, organización, recopilación, conservación, consulta y utilización de los mismos.</p></li>
                        <li><p>El USUARIO ha tomado conocimiento de la existencia del banco de datos personales en que se almacenarán los Datos Personales, cuyo titular es LA TINKA, el cual se encuentra domiciliado en Av. José Pardo Nro. 434, Piso 11, distrito de Miraflores, provincia y departamento de Lima.</p></li>
                        <li><p>El USUARIO ha tomado conocimiento de que no existirá transferencia de los Datos Personales.</p></li>
                        <li><p>El USUARIO declara conocer las consecuencias de proporcionar los Datos Personales, los cuales serán objeto de tratamiento por parte de LA TINKA, conforme a lo indicado en el numeral 2 anterior.</p></li>
                        <li><p>El USUARIO ha tomado conocimiento que el plazo durante el cual serán almacenados los Datos Personales será de 5 años.</p></li>
                        <li><p>El USUARIO ha tomado conocimiento de la posibilidad de ejercer los derechos que la Ley de Protección de Datos Personales y su Reglamento le concede, estando a su disposición los medios y procedimientos previstos para ello en LA TINKA.</p></li>
                     </ul>
                     <p><b>10.2</b> El USUARIO manifiesta su pleno consentimiento en que LA TINKA transfiera sus datos personales en caso estos sean requeridos por alguna entidad o autoridad judicial, policial, fiscal o administrativa.</p>
                     <p><b>10.3</b> El USUARIO deja constancia que el consentimiento a LA TINKA para el tratamiento de los Datos Personales ha sido otorgado de manera libre, previa, expresa, inequívoca y estando informado con lenguaje sencillo de lo anteriormente mencionado.</p>
                     <p><b>10.4</b> El USUARIO ha tomado conocimiento de que podrá revocar el consentimiento al tratamiento de los Datos Personales, sin necesidad de indicar ningún motivo para ello. La revocación deberá formalizarse mediante correo electrónico, dirigido a DatosPersonales@latinka.com.pe, siendo automáticos los efectos de la declaración revocatoria.</p>-->
                     <h2 id="lblRecla">CAPITULO NOVENO<br />RECLAMACIONES, QUEJAS Y/O SUGERENCIAS</h2>
                     <p><b>9.1</b> En caso el Usuario o el titular de la cuenta virtual tenga una queja, reclamo y/o sugerencia correspondiente a los productos y/o servicios brindados podrá realizarlo a través de las líneas telefónicas de atención al cliente, la sección “Contáctanos” y/o ingresando una hoja de reclamación a través del Libro de Reclamaciones.</p>
                     <h2 id="lblLimit">CAPITULO DECIMO<br />LIMITACIÓN DE RESPONSABILIDAD</h2>
                     <p><b>10.1</b> El Usuario es el responsable de sus actos y de las consecuencias que este ocasione, por lo tanto participa en los Juegos bajo su propio riesgo. LA TINKA no ofrece garantías de ningún tipo, tanto explícito como implícito.</p>
                     <p><b>10.2</b> LA TINKA, no garantiza que el software de la Página web sea compatible con todas las versiones de navegador.</p>
                     <p><b>10.3</b> LA TINKA no garantiza que el software y la página web estén libre de errores.</p>
                     <p><b>10.4</b> LA TINKA no garantiza que las páginas web y/o juegos estén accesibles sin interrupciones.</p>
                     <p><b>10.5</b> LA TINKA no será responsable de ninguna pérdida, costas y/o costos, gastos o daños, tanto directos como indirectos, especiales, consecuentes, accidentales o de cualquier otro tipo, que surjan en relación del uso de sus plataformas virtuales o de su participación en los juegos de la misma.</p>
                     <h2 id="lblIncum">CAPITULO DECIMO PRIMERO<br />INCUMPLIMIENTO</h2>
                     <p><b>11.1</b> En caso el Usuario incumpla con cualquier disposición de los presentes T&amp;C, o se vea implicado en actividades ilegales y/o fraudulentas, LA TINKA podrá suspender, cerrar y/o cancelar la Cuenta de Usuario, e iniciar las acciones legales pertinentes.</p>
                     <h2 id="lblPropi">CAPITULO DECIMO SEGUNDO<br />PROPIEDAD INTELECTUAL</h2>
                     <p><b>12.1</b> El Usuario no podrá atentar contra los derechos de propiedad intelectual del software que LA TINKA pone a su disposición. En ese sentido, el Usuario sólo podrá utilizar el software para su uso personal, de entretenimiento de acuerdo con todas las normas, términos y condiciones que se establecen en el presente instrumento.</p>
                     <p><b>12.2</b> Todo el contenido disponible en el portal, tienda virtual y/o web móvil de LA TINKA, incluyendo diseños, texto, gráficos, cuadros, video, información, usos, software, música, sonido y otros archivos, y su selección y arreglo, es propiedad exclusiva de LA TINKA, de sus filiales o de sus licenciantes. Ningún contenido puede ser modificado, copiado, distribuido, enmarcado, reproducido, descargado, mostrado, fijado, transmitido, o vendido en cualquier forma o por cualquier medio, en todo o en parte, sin el permiso previo por escrito de la LA TINKA.</p>
                     <p><b>12.3</b> El registro en la tienda virtual y/o web móvil de LA TINKA; así como en otro tipo de medio y/o URL relacionada a los juegos que ofrece LA TINKA y el uso de los juegos de loterías y apuestas deportivas no confiere ningún derecho de propiedad intelectual a favor del Usuario o de terceras partes.</p>
                     <p><b>12.4</b> LA TINKA se reserva el derecho de iniciar acciones legales contra el Usuario que realice un uso ilícito, indebido y/o no autorizado de los signos distintivos de los juegos de loterías y apuestas deportivas.</p>
                     <h2 id="lblLegis">CAPITULO DECIMO TERCERO<br />LEGISLACIÓN APLICABLE</h2>
                     <p><b>13.1</b> Todo lo no previsto en los presentes T&amp;C, se regirá bajo las normas competentes en la materia que se encuentren vigentes en la República del Perú.</p>
                     <h2 id="lblCesio">CAPITULO DECIMO CUARTO<br />CESIÓN DE POSICIÓN CONTRACTUAL</h2>
                     <p><b>14.1</b> LA TINKA está facultado para ceder su posición y/o derechos que se deriven del presente acuerdo.</p>
                     <h2 id="lblAcuer">CAPITULO DECIMO QUINTO<br />ACUERDO</h2>
                     <p><b>15.1</b> El presente acuerdo y/o cualquier otra comunicación electrónica relacionada al presente acuerdo podrán ser utilizados como prueba en procesos judiciales, administrativos, arbitrales o de cualquier otra índole.</p>
                  	 <br/>
					 <p>Junio de 2018</p>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <c:if test="${locacionTYC == 'home'}">
         <div class="body-popup">
         </div>
      </c:if>
      <c:if test="${locacionTYC == 'login'}">
         <div class="body-popup">
            <button type="button" id="client_confirm_agreement" class="js-close-modal btn btn-orange white">Aceptar t&eacute;rminos y condiciones</button>
         </div>
      </c:if>
       <c:if test="${locacionTYC == 'register'}">
         <div class="body-popup">
            <button type="button" id="agree_terms" class="js-close-modal btn btn-orange white" style="height: 2.9em !important;line-height: 1em !important;border-radius: 1.45em !important;box-shadow: 0px 4px 8px 3px rgba(0, 0, 0, 0.3) !important;text-align: center !important;width: 100% !important;display: block !important;border: medium none !important;font-family: Arial, sans-serif !important;cursor: pointer !important;padding: 0 !important;">Aceptar t&eacute;rminos y condiciones</button>
         </div>
      </c:if>
   </body>
</html>