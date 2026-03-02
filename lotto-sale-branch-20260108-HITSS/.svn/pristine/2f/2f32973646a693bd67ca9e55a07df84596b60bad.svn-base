package pe.com.intralot.loto.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.intralot.loto.layer.service.game.ganadiario.bo.GanadiarioBo;
import pe.com.intralot.loto.layer.service.game.tinka.bo.TinkaBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import sun.misc.BASE64Decoder;

/**
 * <p>
 * NOMBRE: Constants.java
 * <br></p>
 * <p>
 * FUNCION: Variables constantes para el manejo de datos de la cuenta 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Asignación de variables con URLs parametrizado
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Component
public class Constants {
	
	public static TinkaBo beanTinkaBo;
	public static GanadiarioBo beanGanadiarioBo;
	
	@Autowired(required = true)
	public void setBeanTinkaBo(TinkaBo beanTinkaBo) {
		Constants.beanTinkaBo = beanTinkaBo;
	}
	public static TinkaBo getBeanTinkaBo() {
		return beanTinkaBo;
	}	
	
	@Autowired(required = true)
	public void setBeanGanadiarioBo(GanadiarioBo beanGanadiarioBo) {
		Constants.beanGanadiarioBo = beanGanadiarioBo;
	}
	public static GanadiarioBo getBeanGanadiarioBo() {
		return beanGanadiarioBo;
	}
	



	public static final String contextCardWeb = "CARD-WEB";
	public static final String contextSale = "SALE";
	public static final String contextRechargeApi = "RECHARGEAPI";
	public static final String contextSaleSmsRegister = "register";
	public static final String contextPlayerWebApi = "PLAYERWEBAPI";
	public static final String contextEpago = "EPAGO";
	public static final String contextWelcome = "WELCOME";
    // constante de session del usuario
    public static final String USR_SESION = "User";
    public static final String CLIENT_SESION = "clientSesion";
    // constante de session del visitante
    public static final String VST_SESSION = "Visitor";
    // constante de session del client
    public static final String CLT_SESSION = "Client";
    // constante de session del asociado
    public static final String TRM_SESSION = "Terminal";
    // constantes de atributos de request
    public static final String ALERT_MSG = "ALERT_MSG";
    public static final String WARN_MSG = "WARNING_MSG";
    // valores por defecto en Datos de DrawPromotion
    public static final String NOR_PROMOTION = "NOR";
    public static final String ALG_PROMOTION = "ALG";
    public static final String TAB_PROMOTION = "TAB";
    
    // parametros
    public static String iflexGameProviderBaseUrl = ConnectionFactory.operationProperty("iflexGameProviderBaseUrl", contextSale).trim();
    public static String iflexLanguage = ConnectionFactory.operationProperty("iflexLanguage", contextSale).trim();
    public static String iflexOperatorId = ConnectionFactory.operationProperty("iflexOperatorId", contextSale).trim();
    public static String iflexCurrency = ConnectionFactory.operationProperty("iflexCurrency", contextSale).trim();
    public static String iflexGameProviderCloseUrl = ConnectionFactory.operationProperty("iflexGameProviderCloseUrl", contextSale).trim();
    
    //PARA LOS VIDEO DE TK, GG Y GD
    public static String iflexTinkaYoutubeUrl = ConnectionFactory.operationProperty("iflexTinkaYoutubeUrl", contextSale).trim();
    public static String iflexKabalaYoutubeUrl = ConnectionFactory.operationProperty("iflexKabalaYoutubeUrl", contextSale).trim();
    public static String iflexGanaDiarioYoutubeUrl = ConnectionFactory.operationProperty("iflexGanaDiarioYoutubeUrl", contextSale).trim();
     
    public static String gamesXML = (ConnectionFactory.operationProperty("gamesXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("gamesXML", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("gamesXML", contextSale)).toString().trim():"https://www.latinka.com.pe/intralot/swf/intralot/games.xml";//ConnectionFactory.operationProperty("gamesXML", contextSale).trim();
    public static String responsabilidadSocialXML = (ConnectionFactory.operationProperty("responsabilidadSocialXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("responsabilidadSocialXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("responsabilidadSocialXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/responsabilidad-social.xml";
    public static String inversionistasXML = (ConnectionFactory.operationProperty("inversionistasXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("inversionistasXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("inversionistasXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/inversionistas.xml";
    public static String portalServiceKinelo = ConnectionFactory.operationProperty("portalServiceKinelo", contextSale).trim();
    public static String portalKineloWeb = ConnectionFactory.operationProperty("portalKineloWeb", contextSale).trim();
    
//    public static String estadisticaTinka = ConnectionFactory.operationProperty("estadisticaTinka", contextSale).trim();
//    public static String estadisticaKabala = ConnectionFactory.operationProperty("estadisticaKabala", contextSale).trim();
//    public static String estadisticaGanadiario = ConnectionFactory.operationProperty("estadisticaGanadiario", contextSale).trim();
    
    public static String flagValidacionSms = ConnectionFactory.operationProperty("flagValidacionSms", contextSale).trim();
    public static String flagValidacionMail = ConnectionFactory.operationProperty("flagValidacionMail", contextSale).trim();
    public static String flagRecargaRedDigital = ConnectionFactory.operationProperty("flagRecargaRedDigital", contextSale).trim();
    public static String flagRecargaInterbank = ConnectionFactory.operationProperty("flagRecargaInterbank", contextSale).trim();
    
    public static String welcameBonusUsers = ConnectionFactory.operationProperty("welcameBonusUsers", contextSale).trim();
    
    public static String lapollaEnabled = ConnectionFactory.operationProperty("lapollaEnabled2022", contextSale).trim();
    public static String lapollaGameProviderBaseUrl = ConnectionFactory.operationProperty("lapollaGameProviderBaseUrl2022", contextSale).trim();
    public static String lapollaOperatorId = ConnectionFactory.operationProperty("lapollaOperatorId2022", contextSale).trim();
    public static String lapollaGameProviderCloseUrl = ConnectionFactory.operationProperty("lapollaGameProviderCloseUrl2022", contextSale).trim();
    public static String lapollaGameProviderBalanceUrl = ConnectionFactory.operationProperty("lapollaGameProviderBalanceUrl2022", contextSale).trim();
    
    public static String tav2Enabled = ConnectionFactory.operationProperty("tav2Enabled", contextSale).trim();
    public static String tav2GameProviderBaseUrl = (ConnectionFactory.operationProperty("tav2GameProviderBaseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderBaseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderBaseUrl", contextSale)).toString().trim():"https://api.nuevoteapuesto.pe/api/v1/intralot/desktop";
    public static String tav2OperatorId = ConnectionFactory.operationProperty("tav2OperatorId", contextSale).trim();
    public static String tav2GameProviderCloseUrl = (ConnectionFactory.operationProperty("tav2GameProviderCloseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderCloseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderCloseUrl", contextSale)).toString().trim():"https://www.nuevoteapuesto.pe";
    public static String tav2GameProviderNewRegisterUrl = String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderNewRegisterDesktopUrl", contextSale)).toString().trim();

    public static String ddvvGameProviderCloseUrl = (ConnectionFactory.operationProperty("ddvvGameProviderCloseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("ddvvGameProviderCloseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("ddvvGameProviderCloseUrl", contextSale)).toString().trim():"https://www.teapuesto.pe/virtuals";
    //public static String bannersUrl = String.valueOf(ConnectionFactory.operationProperty("bannersUrl", contextSale)).toString().trim();
    public static String iflexBonoTyC = (ConnectionFactory.operationProperty("iflexBonoTyC", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("iflexBonoTyC", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("iflexBonoTyC", contextSale)).toString().trim():"https://zonasegura.intralot.com.pe/minisite/recarga-bono/";
    public static String wbBonoTyC = (ConnectionFactory.operationProperty("wbBonoTyC", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("wbBonoTyC", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("wbBonoTyC", contextSale)).toString().trim():"https://zonasegura.intralot.com.pe/minisite/recarga-bono/";
    //public static String tinkaSuscriptionUrl = String.valueOf(ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)).toString().trim();
    public static String tinkaSuscriptionUrl = (ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)).toString().trim():"https://www.latinka.com.pe/latinka/minisite/combos-tinkeros/";
    public static String kabalaSuscriptionUrl = (ConnectionFactory.operationProperty("kabalaSuscriptionUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("kabalaSuscriptionUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("kabalaSuscriptionUrl", contextSale)).toString().trim():"https://www.latinka.com.pe/latinka/minisite/combos-kabala/";
    public static String ganadiarioSuscriptionUrl = (ConnectionFactory.operationProperty("ganadiarioSuscriptionUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("ganadiarioSuscriptionUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("ganadiarioSuscriptionUrl", contextSale)).toString().trim():"https://www.latinka.com.pe/latinka/minisite/combos-ganadiario/";
    public static String eCommerceHome = (ConnectionFactory.operationProperty("eCommerceHome", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("eCommerceHome", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("eCommerceHome", contextSale)).toString().trim():"https://www.latinka.com.pe/p/";
    public static String juegosVirtualesGameProviderCloseUrl = (ConnectionFactory.operationProperty("juegosVirtualesGameProviderCloseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderCloseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderCloseUrl", contextSale)).toString().trim():"https://www.teapuesto.pe/";
    public static String juegosVirtualesGameProviderBaseUrl = (ConnectionFactory.operationProperty("juegosVirtualesGameProviderBaseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderBaseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderBaseUrl", contextSale)).toString().trim():"https://api.teapuestobet.com/api/v1/intralot/desktop";
    
    //public static String epochTimeNewsKabala = "1569128400000";//este epoch time es del 22/09/2019 
    //public static String epochTimeNewsKabala = "1568696400000";//este epoch time es del 17/09/2019 para UAT
    public static String epochTimeNewsKabala = (ConnectionFactory.operationProperty("epochTimeNewsKabala", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("epochTimeNewsKabala", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("epochTimeNewsKabala", contextSale)).toString().trim():"4097493939000";
    
    // Constantes para mostrar u ocultar el chatbot
    public static String CHATBOT_STATUS_LOGGEDIN = "loggedin";
    public static String CHATBOT_STATUS_ALWAYS = "always";
    public static String CHATBOT_STATUS_NEVER = "never";
    
    //constantes para analytics
    public static String HREF_FOR_ANALYTICS = ConnectionFactory.operationProperty("hrefForAnalytics", contextSale).trim();
    
    //Definicion de juegos raspaditas
    public static String RASPADITAS_SOURCE = ConnectionFactory.operationProperty("raspaditasSrc", contextSale).trim();
    public static String RASPADITAS_PARTNER = ConnectionFactory.operationProperty("raspaditasPartner", contextSale).trim();
    public static String RASPADITAS_LANGUAGE = "es-pe";
    public static String RASPADITAS_CURRENCY = "PEN";
    public static String RASPADITAS_CHANNEL = "desktop";
        
    //orden de juegos raspaditas
    public static String raspaditasTodosXML = (ConnectionFactory.operationProperty("raspaYaTodosXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("raspaYaTodosXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("raspaYaTodosXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/intralot/raspaYaTodos.xml";
    public static String raspaditasPorPrecioXML = (ConnectionFactory.operationProperty("raspaYaPorPrecioXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("raspaYaPorPrecioXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("raspaYaPorPrecioXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/raspaYaPorPrecio.xml";
    public static String raspaditasPorPremioXML = (ConnectionFactory.operationProperty("raspaYaPorPremioXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("raspaYaPorPremioXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("raspaYaPorPremioXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/raspaYaPorPremio.xml";
    
    //productos casino
    public static String productosCasinoXML = (ConnectionFactory.operationProperty("productosCasinoXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("productosCasinoXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("productosCasinoXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/productosCasino.xml";
    
    //Casino
    public static String CASINO_LANGUAGE   = "es";
    public static String CASINO_CURRENCY   = "PEN";
    public static String CASINO_SITE_ID    = (ConnectionFactory.operationProperty("casino_site_id", contextSale)!=null)?ConnectionFactory.operationProperty("casino_site_id", contextSale).trim():"0";
    public static String CASINO_ACCESS_KEY = (ConnectionFactory.operationProperty("casino_access_key", contextSale)!=null)?ConnectionFactory.operationProperty("casino_access_key", contextSale).trim():"0";    
    public static String CASINO_API_URL    = (ConnectionFactory.operationProperty("casino_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("casino_api_url", contextSale).trim():"0";
    //Casino preprod
    public static String PREPROD_CASINO_SITE_ID    = (ConnectionFactory.operationProperty("preprod_casino_site_id", contextSale)!=null)?ConnectionFactory.operationProperty("preprod_casino_site_id", contextSale).trim():"0";
    public static String PREPROD_CASINO_ACCESS_KEY = (ConnectionFactory.operationProperty("preprod_casino_access_key", contextSale)!=null)?ConnectionFactory.operationProperty("preprod_casino_access_key", contextSale).trim():"0";    
    public static String PREPROD_CASINO_API_URL    = (ConnectionFactory.operationProperty("preprod_casino_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("preprod_casino_api_url", contextSale).trim():"0";
    
    //Video Loteria
    public static String VIDEO_LOTERIA_API_URL = (ConnectionFactory.operationProperty("video_loteria_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("video_loteria_api_url", contextSale).trim():"0";
    public static String VIDEO_LOTERIA_SITE_ID    = (ConnectionFactory.operationProperty("video_loteria_site_id", contextSale)!=null)?ConnectionFactory.operationProperty("video_loteria_site_id", contextSale).trim():"0";
    public static String VIDEO_LOTERIA_ACCESS_KEY = (ConnectionFactory.operationProperty("video_loteria_access_key", contextSale)!=null)?ConnectionFactory.operationProperty("video_loteria_access_key", contextSale).trim():"0";    
    public static String VIDEO_LOTERIA_LANGUAGE   = "es";
    public static String VIDEO_LOTERIA_CURRENCY   = "PEN";
    //URL base de QW
    public static String URL_QW = (ConnectionFactory.operationProperty("URL_QW", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("URL_QW", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("URL_QW", contextSale)).toString().trim():"https://latinkaportal.com.pe";
    
  //URL recuperar contrasenia 
    public static String latinkaUrlContrasenia = (ConnectionFactory.operationProperty("urlLatinkaUser", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("urlLatinkaUser", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("urlLatinkaUser", contextSale).trim():"https://www.latinka.com.pe/p/cambiar-password.html";
    
    //URL recuperar contrasenia TA
    public static String latinkaUrlContraseniaTA = (ConnectionFactory.operationProperty("urlLatinkaUserTA", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("urlLatinkaUserTA", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("urlLatinkaUserTA", contextSale).trim():"http://190.12.81.36/lotto-uat125-14/cambiar-password-ta.html";
    
   //URL resultados anteriores
    public static String resultsServerURI = (ConnectionFactory.operationProperty("resultsServerURI", contextCardWeb)!=null && !String.valueOf(ConnectionFactory.operationProperty("resultsServerURI", contextCardWeb)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("resultsServerURI", contextCardWeb)).toString().trim():"https://resultados.latinka.com.pe/";

    public static String BANNER_REGISTRO  = ConnectionFactory.operationProperty("bannerRegistro", contextSale);
    
    public static String BANNER_REGISTRO_TA  = ConnectionFactory.operationProperty("bannerRegistroTA", contextSale);
    
    //Pago de Premio
    public static final String FILTER_TYPE_ALL = "1";
    public static final String FILTER_TYPE_LAST_WEEK = "2";
    public static final String FILTER_TYPE_LAST_MONTH = "3";
    public static final String FILTER_TYPE_RANGE = "4";
    public static final String BASE_NAME_FILE_PP = "Retiro efectivo La Tinka ";
    public static final String EXTENSION_PDF =".pdf";
    public static final String PENDIENTE = "PENDIENTE";
    public static final String COBRADO = "COBRADO";
    public static final String TYPE_PAYMENT_CASH = "EFECTIVO";
    public static final String TYPE_PAYMENT_VISA = "VISA";
    public static final String TYPE_PAYMENT_AGORA = "AGORA";
    public static final String TYPE_PAYMENT_TRANSFERENCIA = "TRANSFERENCIA";
    public static final String TYPE_PAYMENT_PREMIO_MAYOR = "PREMIO_MAYOR";
    public static final String PLATAFORM = "DESKTOP";
    public static final int OPERATOR_ID = 1;
    public static final String MSG_NO_CREDIT = "No tienes premios que liquidar";
    public static final String MSG_NO_CREDIT_SUFICENT = "El monto que intentas solicitar es mayor al monto disponible para retirar. Edita el monto y envía tu solicitud";
    public static final String MSG_NO_CREDIT_COMMISSION_SUFICENT = "Necesitas tener saldo disponible para el cobro de comisión por retiro de ";
    public static final String MSG_EXCEPTION = "Por favor, int&eacute;ntalo de nuevo en unos minutos.";
    public static final String MSG_INVALID_DATE = "Debes ingresar fechas v&aacute;lidas";
    public static final String MSG_RANGE_INVALID_DATE = "Debes ingresar una fecha desde menor a fecha hasta";
    public static final String MSG_DATE_OUT_RANGE = "El rango de fechas no debe ser mayor a 12 meses";
    public static final String MSG_AMOUNT_OUT_RANGE = "Ingrese un monto entre S/MIN y S/MAX soles";
    public static final String MONEDA_SOLES = "S/";
    public static final String PP_MAIL_SUBJECT_PART1 = ", tu recibo de retiro efectivo Nº";
    public static final String PP_MAIL_SUBJECT_PART2 = " La Tinka";
    public static final String DOMAIN_MAIL = "@latinka.com.pe";
    public static final String JR_MAIL_PP = "jpTicketsPayment.jasper";
    public static final String JR_MAIL_DEBITIDQR_PP = "jpTicketsPaymentDebitIdQR.jasper";
    public static final String JAVA_HOME = System.getProperty("java.home");
    public static final String SEPARETOR = System.getProperty("file.separator");
    public static final String BASE_PATH_TEMPLATE = JAVA_HOME+SEPARETOR+"setup"+SEPARETOR+"template"+SEPARETOR;
    public static final String FORMAT_HTML_UTF8 ="text/html; charset=UTF-8";
    public static final String APPLICATION_JSON="application/json";
    public static final String CHARSET_UTF8="UTF-8";
    public static final String INTERNAL_PATH_LOGO_MAIL ="/layer-view-image/v2/logo-latinka.gif";
    public static final String INTERNAL_PATH_LOGOS_JUEGOS_MAIL ="/layer-view-image/v2/logos-juegos.gif";
    public static final String INTERNAL_PATH_LOGOS_JUEGOS_MAIL_V2 ="/layer-view-image/v2/collage-logos.gif";
    public static final String LOADED_IMAGE_YES = "YES";
    public static final String LOADED_IMAGE_NO = "NO";
    public static final String DNI_STATE_ACTIVE = "ACT";
    public static final String MSG_DNI_NOT_LOADED = "Debes adjuntar una foto de tu DNI";
    public static final String MSG_DNI_NOT_VALID = "Debes adjuntar una imagen v&aacute;lida";
    public static final String MSG_DNI_LIMIT_MB = "T&uacute; imagen de DNI no debe ser mayor a ";
    public static final String MB = "MB";
    public static final String RESULT_OK = "OK";
    public static final String FORMATTER_CURRENCY3 = "#,###,###,##0";
    public static final String MSG_SUCCESS_REQUEST_VISA = "Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles. En caso tengas tarjeta de crédito, la transferencia tomará 2 días adicionales.<br><br>Revisa el estado de tu retiro en el Historial de Retiros.";
    public static final String MSG_SUCCESS_REQUEST_AGORA = "Confirmaremos tu retiro en un plazo máximo de 2 días hábiles.  <br><br>Revisa el estado de tu retiro.";
    public static final String MSG_SUCCESS_REQUEST_CASH = "La mayoría de las solicitudes se confirman en menos de 30 minutos. De haber un problema con tu confirmación, podría demorar hasta 72 horas.<br><br>Revisa el estado de tu retiro en el Historial de Retiros.";
    public static final String MSG_SUCCESS_REQUEST_TRANSFERENCIA = "Confirmaremos tu retiro en un plazo máximo de 2 días hábiles. De no tener observaciones, recibirás un correo con la confirmación de la transferencia.<br><br>Revisa tu historial de retiro.";
    public static final String MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO2 = "Confirmaremos tu retiro en un plazo máximo de 2 días hábiles. Luego, por tu seguridad, un representante de La Tinka se comunicará contigo para coordinar el proceso de pago que se realizará en un plazo máximo de 30 días.<br><br>Revisa tu historial de retiro.";
    public static final String MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO3 = "Confirmaremos tu retiro en un plazo máximo de 2 días hábiles. Luego, por tu seguridad, un representante de La Tinka se comunicará contigo para coordinar el proceso de pago que se realizará en un plazo máximo de 90 días.<br><br>Revisa tu historial de retiro.";
    public static final String MSG_SUCCESS_REQUEST_TRANSFERENCIA_RANGO4 = "Confirmaremos tu retiro en un plazo máximo de 2 días hábiles. Luego, por tu seguridad, un representante de La Tinka se comunicará contigo para coordinar el proceso de pago que se realizará en un plazo máximo de 90 días.<br><br>Revisa tu historial de retiro.";
    public static final String MSG_COMMISSION = "<br><br>Comisión por retiro con Tarjeta Visa: ";
    public static final String PROCESS_SECURITY_API="SECURITY_API";
    public static final String PROCESS_SESSION_API="SESSION_API";
    public static final String PROCESS_TOKEN_API="TOKEN_API";
    public static final String PROCESS_FD_API="FD_API";
    public static final String VACIO="";
    public static final String BLACKLIST_INACTIVE="0";
    public static final String MSG_BLACKLIST = "Por incumplimiento del art&iacute;culo 6 de los t&eacute;rminos y condiciones. Tu dinero esta disponible.";
	public static int TRANSACTION_ID = 1;
	public static final String FD_MONNET_NAME="La Tinka";
	public static final String FD_MONNET_COUNTRY="PER";
	public static final String FD_MONNET_CURRENCY="PEN";
	public static final String FD_MONNET_DETAIL_INDEX="1";
	public static final String FD_MONNET_DETAIL_CURRENCY="PEN";
	public static final String FD_MONNET_DETAIL_AMOUNT_USD="1";
	public static final String FD_MONNET_DETAIL_MERCHANT="La Tinka";
	public static final String FD_MONNET_DETAIL_ACCOUNT_TYPE="1";
	public static final String FD_MONNET_DETAIL_ID_TYPE_DNI="1";
	public static final String FD_MONNET_DETAIL_ID_TYPE_PAS="2";
	public static final String FD_MONNET_DETAIL_ID_TYPE_CE="3";
	public static final String FD_MONNET_DETAIL_USER_NAME="admin_intralot_prod";
	public static final String FD_MONNET_DETAIL_ACCOUNT_NUMBER="1031";
	public static final String FD_MONNET_DETAIL_PHONE="999999999";
	public static final String ESPACIO=" ";
	public static final String APPLICATION_TYPE="ECOMMERCE";
	public static final String FD_MONNET_DETAIL_EMAIL_DEFAULT= "DesarrollodeSistemas@latinka.com.pe";
	public static String fdCheckoutJs = ConnectionFactory.operationProperty("checkout_js_tokenization_card", contextSale).trim();
	/**********************************AGORA*******************************************/
    public static final String STATE_WITHOUT_AGORA = "0";
    public static final String STATE_WITH_AGORA = "1";
    public static final String MSG_PHONE_INVALID = "Ingresa un tel&eacute;fono correcto"; 
    public static final String AGORA_ERROR_CODE_ECM_PAY_02 = "ECM_PAY_02";
    public static final String AGORA_MSG_ECM_PAY_02 = "Tu n&uacute;mero de celular no est&aacute; registrado en una cuenta Agora. Descarga tu app Agora y vuelve a solicitar tu recarga.";
	
    /* VALORES AÑADIDOS PARA KYC */
    //public static final String KYC_API_URL = "http://localhost:18080/lotto-ws-kyc-v1/tn/v1";
    //public static final String KYC_API_URL = "http://192.168.200.39:8080/lotto-ws-kyc-v1/tn/v1";
    public static final String KYC_API_URL = ConnectionFactory.operationProperty("kycApiUrl", contextSale).trim();
    public static final String KYC_USERNAME = ConnectionFactory.operationProperty("kycUserName", contextSale).trim();
    public static final String KYC_PASSWORD = ConnectionFactory.operationProperty("kycPassword", contextSale).trim();
    public static final String KYC_FLOWID = ConnectionFactory.operationProperty("flowId", contextSale).trim();
    
    /**********************************ePago*******************************************/
    public static final String EPAGO_API_KEY = ConnectionFactory.operationProperty("apiKey", contextEpago).trim();
    public static final String EPAGO_SECRET_KEY = ConnectionFactory.operationProperty("secretKey", contextEpago).trim();
    public static final String EPAGO_PAYMENT_METHODS = ConnectionFactory.operationProperty("paymentMethods", contextEpago).trim();
    public static final String EPAGO_ENVIRONMENT = ConnectionFactory.operationProperty("environment", contextEpago).trim();
    
	public static int generateTransactionId() {
		return TRANSACTION_ID++;
	}
    
	public static String getPropertyContextSale(String property) {
    	return ConnectionFactory.operationProperty(property, contextSale).trim() ;
    }
    
    public static class ConstantesString{
		public static final String TOSTRING = " gamesXML="+gamesXML+"\n"+
				" responsabilidadSocialXML="+responsabilidadSocialXML+"\n"+
				" inversionistasXML="+inversionistasXML+"\n"+
				" tav2Enabled="+tav2Enabled+"\n"+
				" tav2GameProviderBaseUrl="+tav2GameProviderBaseUrl+"\n"+
				" tav2OperatorId="+tav2OperatorId+"\n"+
				" tav2GameProviderCloseUrl="+tav2GameProviderCloseUrl+"\n"+
				" ddvvGameProviderCloseUrl="+ddvvGameProviderCloseUrl;
	}
    
    //ID flag parametros Consecutivas loterias
    public static final String C_TK   = "CTK";
    public static final String C_KB   = "CKB";
    public static final String C_GD   = "CGD"; 
    
    // constante de analytics
    public static final String analytics_js = "10";
    
    //map de jakpots
    public static Map<String, String> jackpotsMap = new HashMap<String, String>();
    public static final String CASINO_REGEX			="[\"\\[\\]]";
    public static final String CASINO_VACIO			="";
    public static final String URL_JACKPOT_CASINO	=ConnectionFactory.operationProperty("urlJackpotCasino", contextSale).trim();
    
    public static final String css_v2_styles_v   = "42";
	public static final String tav2_header_css   = "14";
    public static final String main_css   = "24";
    public static final String common_css   = "3";
    public static final String common_style_css   = "18";
    public static final String dhtmlwindow_css   = "3";
    public static final String index_js   = "24";
    public static final String utils_js   = "24";
    public static final String v2_main_js   = "8";
    public static final String client_main_js   = "97";
    public static final String plugins_js = "5";
    public static final String popModal_css = "3";
    
    //Constantes para virtuales
    public static final String XPRESS_LANGUAGE    = "es";
    public static final String XPRESS_TOKEN_DEMO  = "1a2b3c4d5e6f7g8h9i";
    public static final String XPRESS_MODE_DEMO   = "0";
    public static final String XPRESS_MODE_REAL   = "1";
    public static final String XPRESS_PLATFORM    = "desktop";
    public static final String XPRESS_REGRESAR_LOBBY1 = "Deportes Virtuales";
    public static final String XPRESS_REGRESAR_LOBBY2 = " / Golden Race";
    public static final String XPRESS_PRIVATE_KEY = ConnectionFactory.operationProperty("xpressPrivateKey", contextSale).trim();
    public static final String XPRESS_URL_LOBBY   = ConnectionFactory.operationProperty("xpressUrlLobby", contextSale).trim();
    
    //Constantes para virtuales Leap Gaming
    public static final String LEAP_LANGUAGE      = "es";
    public static final String LEAP_CURRENCY      = "PEN";
    public static final String LEAP_SITE_ID  	  = "1";
    public static final String LEAP_SKIN_ID  	  = "154";
    public static final String LEAP_TOKEN_DEMO    = "12345";
    public static final String LEAP_PLAYER_DEMO   = "12345";
    public static final String LEAP_MODE_DEMO     = "fun";
    public static final String LEAP_MODE_REAL     = "real";
    public static final String LEAP_REGRESAR_LOBBY= " / Leap Gaming";
    public static final String LEAP_URL_LOBBY     = ConnectionFactory.operationProperty("leapUrlLobby", contextSale).trim();
    public static final String LEAP_IS_TEST   	  = ConnectionFactory.operationProperty("leap_is_test", contextSale).trim();
    
    //Activar Promocion Bicolor
    public static final String flagPromoBicolor	=ConnectionFactory.operationProperty("flagPromoBicolor", contextCardWeb).trim();
    public static final String flagPromoTinka	=ConnectionFactory.operationProperty("flagPromoTinka", contextCardWeb).trim();
    public static final String flagPromoHincha	=ConnectionFactory.operationProperty("flagPromoHincha", contextCardWeb).trim();
    public static final String flagPromoCasino	=ConnectionFactory.operationProperty("flagPromoCasino", contextCardWeb).trim();
    
    //DDVV Golden
    public static String GOLDEN_URL_FINDBYID = ConnectionFactory.operationProperty("goldenUrlFindById", contextSale).trim();
    public static String GOLDEN_URL_FINDBYLIST= ConnectionFactory.operationProperty("goldenUrlFindByList", contextSale).trim();
    public static String ENTITY_ID= ConnectionFactory.operationProperty("entityId", contextSale).trim();
    public static String API_HASH= ConnectionFactory.operationProperty("apiHash", contextSale).trim();
    public static String API_ID= ConnectionFactory.operationProperty("apiId", contextSale).trim();
    public static String API_DOMAIN= ConnectionFactory.operationProperty("apiDomain", contextSale).trim();
    
    //API RENIEC WS
    public static String API_RENIECWS= ConnectionFactory.operationProperty("uriReniecWs", contextSale).trim();
    public static String USER_RENIEC_WS= ConnectionFactory.operationProperty("userReniecWs", contextSale).trim();
    public static String PASS_RENIEC_WS= ConnectionFactory.operationProperty("passReniecWs", contextSale).trim();
    
    
    //restablecer microfront
    public static final String urlPamRestablecer	=ConnectionFactory.operationProperty("urlPamRestablecer", contextSale).trim();
    
    public static String validarImagen(String imagen) {
    	String mensaje = "";
    	try {
	    	BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(imagen.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
			Double peso = (double) decodedBytes.length;
			if((peso/1024/1024)<=10) {
				try {
					ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
					BufferedImage image = ImageIO.read(bis);
			        bis.close();
			        if(image==null) {
			        	mensaje="ERROR_IMAGEN";
			        }
				} catch (Exception e) {
				} catch (OutOfMemoryError e) {
		        }
			}else {
				mensaje="ERROR_PESO";
			}
    	} catch (Exception e) {
    		mensaje="ERROR";
		}
		return mensaje;
    }
    
    public static String generateSignatureSHA512(String hsString) {
    	StringBuilder sb = new StringBuilder();
    	try {
	    	MessageDigest md = MessageDigest.getInstance("SHA-512");
	    	 byte[] data = md.digest(hsString.getBytes());
	    	 for(int i=0;i<data.length;i++){
	    		 sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
	    	 }
	    } catch (NoSuchAlgorithmException e) {
	    	sb.append("ERROR");
	    }
    	return sb.toString();
    }
    
  //Casino QTECH
    public static String CASINO_QT_LANGUAGE   = "es_ES";
    public static String CASINO_QT_CURRENCY   = "PEN";
    public static String CASINO_QT_COUNTRY    = "PE";
    public static String CASINO_QT_REAL    	  = "real";
    public static String CASINO_QT_DEVICE 	  = "desktop";
    public static String CASINO_QT_API_URL    = (ConnectionFactory.operationProperty("casino_qt_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("casino_qt_api_url", contextSale).trim():"0";
    public static String CASINO_QT_USERNAME   = (ConnectionFactory.operationProperty("casino_qt_username", contextSale)!=null)?ConnectionFactory.operationProperty("casino_qt_username", contextSale).trim():"0";    
    public static String CASINO_QT_PASSWORD   = (ConnectionFactory.operationProperty("casino_qt_password", contextSale)!=null)?ConnectionFactory.operationProperty("casino_qt_password", contextSale).trim():"0";
    
    public class GameTeapuesto{
		public static final String DISPLAY_AVIONPERU = "/p/avion-del-hincha-te-lleva-eliminatorias-peru.html";
	}
    
    //recuper url respuesta lista blanca
    public static String url_respuesta_lista_blanca = ConnectionFactory.operationProperty("url_respuesta_lista_blanca", contextSale).trim();
    
    //recuperar url para restablecer contraseña
    public static String url_restablecer_contrasenia= ConnectionFactory.operationProperty("url_restablecer_contrasenia", contextSale).trim();
    
}
