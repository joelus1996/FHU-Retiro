package pe.com.intralot.loto.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.intralot.loto.layer.controller.game.ganadiario.bo.GanadiarioBetBo;
import pe.com.intralot.loto.layer.controller.game.tinka.bo.TinkaBetBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import sun.misc.BASE64Decoder;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

@Component
public class Constantes {
	
	public static TinkaBetBo beanTinkaBetBo;
	public static GanadiarioBetBo beanGanadiarioBetBo;
	
	@Autowired(required = true)
	  public void setBeanTinkaBetBo(TinkaBetBo beanTinkaBetBo) {
	    Constantes.beanTinkaBetBo = beanTinkaBetBo;
	  }
	 public static TinkaBetBo getBeanTinkaBetBo() {
		    return beanTinkaBetBo;
		  }
	 
	@Autowired(required = true)
	public  void setBeanGanadiarioBetBo(GanadiarioBetBo beanGanadiarioBetBo) {
		Constantes.beanGanadiarioBetBo = beanGanadiarioBetBo;
	}
	public static GanadiarioBetBo getBeanGanadiarioBetBo() {
		return beanGanadiarioBetBo;
	}
	
	public static String calculateCRC(String data) {
        int crc = 0xFFFFFFFF;
        for (int i = 0; i < data.length(); i++) {
            int byteValue = data.charAt(i) & 0xFF;
            crc ^= byteValue;
            for (int j = 0; j < 8; j++) {
                if ((crc & 1) != 0) {
                    crc = (crc >>> 1) ^ 0xEDB88320;
                } else {
                    crc >>>= 1;
                }
            }
        }
        crc ^= 0xFFFFFFFF;
        return padStart(Integer.toHexString(crc).toUpperCase(), 8, '0');
    }
	
	public static String padStart(String cadena, int longitudObjetivo, char caracterDeRelleno) {
        int longitudActual = cadena.length();
        if (longitudActual >= longitudObjetivo) {
            return cadena;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int cantidadRelleno = longitudObjetivo - longitudActual;
            for (int i = 0; i < cantidadRelleno; i++) {
                stringBuilder.append(caracterDeRelleno);
            }
            stringBuilder.append(cadena);
            return stringBuilder.toString();
        }
    }



	public static final String FORMATTER_CURRENCY = "'S/' #,###,###,##0.00";
	public static final String FORMATTER_CURRENCY2 = "'S/' #,###,###,##0";
	public static final String FORMATTER_CURRENCY3 = "#,###,###,##0";
	public static final String FORMATTER_CURRENCY_ONE_DECIMAL = "'S/' #,###,###,##0.0";
	public static final String FORMATTER_PORCENTAJE = "'%' #,###,###,##0";
	public static final String contextSale = "SALE";
	public static final String contextCardWeb = "CARD-WEB";
	public static final String USR_SESION="user";
	public static final String USR_SESION_FAILED="failedUser";
	public static final String contextSaleSmsRegister = "register";
	public static final String contextRechargeApi = "RECHARGEAPI";
	public static final String contextPlayerWebApi = "PLAYERWEBAPI";
	public static final String contextEpago = "EPAGO";
	public static final String contextWelcome = "WELCOME";
	
	public static final String MOBILE_CLICKWHEEL="clickwheel";
	public static final String MOBILE_TOUCHSCREEN="touchscreen";
	public static final String CLIENT_SESION = "clientSesion";
	public static final String PLATAFORMA="MOBILE";
	
	public static String gamesXML = (ConnectionFactory.operationProperty("gamesXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("gamesXML", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("gamesXML", contextSale)).toString().trim():"https://m.latinka.com.pe/xml/games.xml";
    //public static String responsabilidadSocialXML = (ConnectionFactory.operationProperty("responsabilidadSocialXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("responsabilidadSocialXML", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("responsabilidadSocialXML", contextSale)).toString().trim():"";
    //public static String inversionistasXML = (ConnectionFactory.operationProperty("inversionistasXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("inversionistasXML", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("inversionistasXML", contextSale)).toString().trim():"";
    
    public static String flagValidacionSms = String.valueOf(ConnectionFactory.operationProperty("flagValidacionSms", contextSale)).toString().trim();
    public static String flagValidacionMail = String.valueOf(ConnectionFactory.operationProperty("flagValidacionMail", contextSale)).toString().trim();
    public static String flagRecargaRedDigital = String.valueOf(ConnectionFactory.operationProperty("flagRecargaRedDigital", contextSale)).toString().trim();
    public static String flagRecargaInterbank = String.valueOf(ConnectionFactory.operationProperty("flagRecargaInterbank", contextSale)).toString().trim();
   	
    public static String welcameBonusUsers = String.valueOf(ConnectionFactory.operationProperty("welcameBonusUsers", contextSale)).toString().trim();
    
    public static String iflexGameProviderBaseUrl = String.valueOf(ConnectionFactory.operationProperty("iflexGameProviderBaseUrl", contextSale)).toString().trim();
    public static String iflexLanguage = String.valueOf(ConnectionFactory.operationProperty("iflexLanguage", contextSale)).toString().trim();
    public static String iflexOperatorId = String.valueOf(ConnectionFactory.operationProperty("iflexOperatorId", contextSale)).toString().trim();
    public static String iflexCurrency = String.valueOf(ConnectionFactory.operationProperty("iflexCurrency", contextSale)).toString().trim();
    public static String iflexGameProviderCloseUrl = String.valueOf(ConnectionFactory.operationProperty("iflexGameProviderCloseUrl", contextSale)).toString().trim();
    
    public static String lapollaEnabled = String.valueOf(ConnectionFactory.operationProperty("lapollaEnabled2022", contextSale)).toString().trim();
    public static String lapollaGameProviderBaseUrl = String.valueOf(ConnectionFactory.operationProperty("lapollaGameProviderBaseUrl2022", contextSale)).toString().trim();
    public static String lapollaOperatorId = String.valueOf(ConnectionFactory.operationProperty("lapollaOperatorId2022", contextSale)).toString().trim();
    public static String lapollaGameProviderCloseUrl = String.valueOf(ConnectionFactory.operationProperty("lapollaGameProviderCloseUrl2022", contextSale)).toString().trim();
    public static String lapollaGameProviderBalanceUrl = String.valueOf(ConnectionFactory.operationProperty("lapollaGameProviderBalanceUrl2022", contextSale)).toString().trim();
        
    public static String tav2Enabled = String.valueOf(ConnectionFactory.operationProperty("tav2Enabled", contextSale)).toString().trim();
    public static String tav2GameProviderBaseUrl = (ConnectionFactory.operationProperty("tav2GameProviderBaseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderBaseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderBaseUrl", contextSale)).toString().trim():"http://api.novassets.com/api/v1/intralot/mobile";
    public static String tav2OperatorId = String.valueOf(ConnectionFactory.operationProperty("tav2OperatorId", contextSale)).toString().trim();
    public static String tav2GameProviderCloseUrl = (ConnectionFactory.operationProperty("tav2GameProviderCloseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderCloseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderCloseUrl", contextSale)).toString().trim():"http://mobile.novassets.com/";
    public static String tav2GameProviderNewRegisterUrl = String.valueOf(ConnectionFactory.operationProperty("tav2GameProviderNewRegisterMobileUrl", contextSale)).toString().trim();
    
    public static String bannersUrl = (ConnectionFactory.operationProperty("bannersUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("bannersUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("bannersUrl", contextSale)).toString().trim():"https://m.latinka.com.pe/banner/";
    public static String iflexBonoTyC = (ConnectionFactory.operationProperty("iflexBonoTyC", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("iflexBonoTyC", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("iflexBonoTyC", contextSale)).toString().trim():"https://m.latinka.com.pe/minisite/recarga-bono/";
    public static String wbBonoTyC = (ConnectionFactory.operationProperty("wbBonoTyC", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("wbBonoTyC", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("wbBonoTyC", contextSale)).toString().trim():"https://m.latinka.com.pe/minisite/recarga-bono/";
    public static String tinkaSuscriptionUrl = (ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tinkaSuscriptionUrl", contextSale)).toString().trim():"https://www.latinka.com.pe/latinka/minisite/combos-tinkeros/";
    public static String kabalaSuscriptionUrl = (ConnectionFactory.operationProperty("kabalaSuscriptionUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("kabalaSuscriptionUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("kabalaSuscriptionUrl", contextSale)).toString().trim():"https://www.latinka.com.pe/latinka/minisite/combos-kabala/";
    public static String ganadiarioSuscriptionUrl = (ConnectionFactory.operationProperty("ganadiarioSuscriptionUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("ganadiarioSuscriptionUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("ganadiarioSuscriptionUrl", contextSale)).toString().trim():"https://www.latinka.com.pe/latinka/minisite/combos-ganadiario/";
    public static String ddvvGameProviderCloseUrl = (ConnectionFactory.operationProperty("ddvvGameProviderCloseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("ddvvGameProviderCloseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("ddvvGameProviderCloseUrl", contextSale)).toString().trim():"http://mobile.teapuesto.pe/virtuals";
    public static String juegosVirtualesGameProviderCloseUrl = (ConnectionFactory.operationProperty("juegosVirtualesGameProviderCloseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderCloseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderCloseUrl", contextSale)).toString().trim():"https://mobile.teapuesto.pe/";
    public static String juegosVirtualesGameProviderBaseUrl = (ConnectionFactory.operationProperty("juegosVirtualesGameProviderBaseUrl", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderBaseUrl", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("juegosVirtualesGameProviderBaseUrl", contextSale)).toString().trim():"https://api.teapuesto.pe/api/v1/intralot/mobile";
    
    public static String eCommerceHome = (ConnectionFactory.operationProperty("eCommerceHome", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("eCommerceHome", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("eCommerceHome", contextSale)).toString().trim():"https://m.latinka.com.pe/";
    
    //public static String epochTimeNewsKabala = "1569128400000";//este epoch time es del 22/09/2019 
    //public static String epochTimeNewsKabala = "1568696400000";//este epoch time es del 17/09/2019 para UAT
    public static String epochTimeNewsKabala = (ConnectionFactory.operationProperty("epochTimeNewsKabala", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("epochTimeNewsKabala", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("epochTimeNewsKabala", contextSale)).toString().trim():"4097493939000";
    
    public static String isTinkaSubscription = (ConnectionFactory.operationProperty("tinkaSubscriptionEnabled", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("tinkaSubscriptionEnabled", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("tinkaSubscriptionEnabled", contextSale)).toString().trim():"false"; 
    public static String isKabalaSubscription = (ConnectionFactory.operationProperty("kabalaSubscriptionEnabled", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("kabalaSubscriptionEnabled", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("kabalaSubscriptionEnabled", contextSale)).toString().trim():"false";
    public static String isGanadiarioSubscription = (ConnectionFactory.operationProperty("ganadiarioSubscriptionEnabled", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("ganadiarioSubscriptionEnabled", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("ganadiarioSubscriptionEnabled", contextSale)).toString().trim():"false";
    
    //orden de juegos raspaditas
    public static String raspaditasTodosXML = (ConnectionFactory.operationProperty("raspaYaTodosXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("raspaYaTodosXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("raspaYaTodosXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/raspaYaTodos.xml";
    public static String raspaditasPorPrecioXML = (ConnectionFactory.operationProperty("raspaYaPorPrecioXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("raspaYaPorPrecioXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("raspaYaPorPrecioXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/raspaYaPorPrecio.xml";
    public static String raspaditasPorPremioXML = (ConnectionFactory.operationProperty("raspaYaPorPremioXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("raspaYaPorPremioXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("raspaYaPorPremioXML", contextSale).trim():"https://www.latinka.com.pe/latinka/swf/latinka/raspaYaPorPremio.xml";    
    
  //Video Loteria
    public static String VIDEO_LOTERIA_API_URL = (ConnectionFactory.operationProperty("video_loteria_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("video_loteria_api_url", contextSale).trim():"0";
    public static String VIDEO_LOTERIA_SITE_ID    = (ConnectionFactory.operationProperty("video_loteria_site_id", contextSale)!=null)?ConnectionFactory.operationProperty("video_loteria_site_id", contextSale).trim():"0";
    public static String VIDEO_LOTERIA_ACCESS_KEY = (ConnectionFactory.operationProperty("video_loteria_access_key", contextSale)!=null)?ConnectionFactory.operationProperty("video_loteria_access_key", contextSale).trim():"0";    
    public static String VIDEO_LOTERIA_LANGUAGE   = "es";
    public static String VIDEO_LOTERIA_CURRENCY   = "PEN";
    
    //venta cruzada loterias
    public static String ventaCruzadaLoteriasXML = (ConnectionFactory.operationProperty("ventaCruzadaLoteriasXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("ventaCruzadaLoteriasXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("ventaCruzadaLoteriasXML", contextSale).trim():"https://m.latinka.com.pe/banner/ventaCruzadaLoterias.xml";
    
    //productos casino
    public static String productosCasinoXML = (ConnectionFactory.operationProperty("productosCasinoXML", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("productosCasinoXML", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("productosCasinoXML", contextSale).trim():"https://m.latinka.com.pe/banner/productosCasino.xml";
   
    //banner header casino
    public static String iframeHomeBannerCasinoURL = (ConnectionFactory.operationProperty("iframeHomeBannerCasinoURL", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("iframeHomeBannerCasinoURL", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("iframeHomeBannerCasinoURL", contextSale).trim():"https://m.latinka.com.pe/banner/casino/bannermobile.html";
    
    //banner header virtuales
    public static String iframeHomeBannerVirtualesURL = (ConnectionFactory.operationProperty("iframeHomeBannerVirtualesURL", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("iframeHomeBannerVirtualesURL", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("iframeHomeBannerVirtualesURL", contextSale).trim():"https://m.latinka.com.pe/banner/deportesvirtuales/bannermobile.html";
    
  //banner header raspaya
    public static String iframeHomeBannerRaspaYaURL = (ConnectionFactory.operationProperty("iframeHomeBannerRaspaYaURL", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("iframeHomeBannerRaspaYaURL", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("iframeHomeBannerRaspaYaURL", contextSale).trim():"https://m.latinka.com.pe/banner/raspaya/bannermobile.html";
    
  //banner header video loterías
    public static String iframeHomeBannerVideoLoteriaURL = (ConnectionFactory.operationProperty("iframeHomeBannerVideoLoteriaURL", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("iframeHomeBannerVideoLoteriaURL", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("iframeHomeBannerVideoLoteriaURL", contextSale).trim():"https://m.latinka.com.pe/banner/casino/bannermobile.html";
    
    //URL base de QW
    public static String URL_QW = (ConnectionFactory.operationProperty("URL_QW", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("URL_QW", contextSale)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("URL_QW", contextSale)).toString().trim():"http://latinkaportal.com.pe";
    
    //URL recuperar contrasenia 
    public static String latinkaUrlContrasenia = (ConnectionFactory.operationProperty("urlLatinka", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("urlLatinka", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("urlLatinka", contextSale).trim():"https://m.latinka.com.pe/cambiar-password.html";
    
    //URL recuperar contrasenia TA
    public static String latinkaUrlContraseniaTA = (ConnectionFactory.operationProperty("urlLatinkaTA", contextSale)!=null && !String.valueOf(ConnectionFactory.operationProperty("urlLatinkaTA", contextSale)).toString().trim().equals(""))?ConnectionFactory.operationProperty("urlLatinkaTA", contextSale).trim():"https://m.latinka.com.pe/cambiar-password-ta.html";

    public static String BANNER_REGISTRO = String.valueOf(ConnectionFactory.operationProperty("bannerRegistro", contextSale)).toString().trim();
    public static String BANNER_REGISTRO_TA = String.valueOf(ConnectionFactory.operationProperty("bannerRegistroTA", contextSale)).toString().trim();
    
    public static String CARACTER_X = "x";
    public static String PIPE = "|";
    public static String ESPACIO_VACIO = " ";
	public class Boleto {
		public static final String typeBoleto="typeBoleto";
		public static final String idBoleto="idBoleto";
	}
	
	public class BoletoTinka {
		public static final String boletoTinkaRegular="tkREG";
		public static final String boletoTinkaSuscripcion8="tkS08";
		public static final String boletoTinkaSuscripcion24="tkS24";
		public static final String boletoTinkaSuscripcion48="tkS48";
		public static final String boletoTinkaSuscripcion96="tkS96";
	
	}
	
	public class BoletoKabala {
		public static final String boletoKabalaRegular="kbREG";
		public static final String boletoKabalaSuscripcion12="kbS12";
		public static final String boletoKabalaSuscripcion36="kbS36";
		public static final String boletoKabalaSuscripcion72="kbS72";
		public static final String boletoKabalaSuscripcion144="kbS144";
	
	}
	
	public class BoletoGanadiario {
		public static final String boletoGanadiarioRegular="gdREG";
		public static final String boletoGanadiarioSuscripcion30="gdS30";
		public static final String boletoGanadiarioSuscripcion90="gdS90";
		public static final String boletoGanadiarioSuscripcion180="gdS180";
		public static final String boletoGanadiarioSuscripcion365="gdS365";
	
	}
	
	public class Home {
		public static final String DO_NOT_MATCH_MOZILLA = "DO_NOT_MATCH_MOZILLA";
		public static final String DO_NOT_MATCH_REMOVE_OPERA_MINI="DO_NOT_MATCH_REMOVE_OPERA_MINI";
	}
	
	public class ClientAccount{
		public static final String STATUS_MAIL_ACT = "ACT";				
	}
	
	public class GameTeapuesto{
		public static final String DISPLAY_TEAPUESTO= "teapuesto";
		public static final String DISPLAY_AVIONQATAR= "avionQatar";
		public static final String DISPLAY_AVIONESTAMBUL = "avionEstambul";
		public static final String DISPLAY_AVIONESTAMBUL_2 = "te-apuesto-te-lleva-final-estambul";
		public static final String DISPLAY_AVIONPERU = "avionPeru";
		public static final String DISPLAY_AVIONPERU_2 = "te-apuesto-te-lleva-copa";
		public static final String DISPLAY_AVIONPERU_2NEW = "avion-del-hincha-te-lleva-eliminatorias-peru";
	}
	
	public class GameTinkaMegabol{		
		public static final String DISPLAY_TINKAMEGABOL= "tinkamegabol";
	}
	
	public class GameTinka{
		public static final String DISPLAY_TINKA= "tinka";
		public static final String DISPLAY_TINKAEXPRESS= "tinka_express";
		public static final String DISPLAY_TINKA_SUSCRIPCION= "tinkaSuscripcion";
	}
	
	public class GameGanagol{
		public static final String DISPLAY_GANAGOL= "ganagol";
		public static final String DISPLAY_PREMIAZOGANAGOL= "premiazoganagol";
	}
	
	public class CopaCasa{
		public static final String DISPLAY_COPACASA= "copacasa";
	}
	
	public class CopaBicolor{
		public static final String DISPLAY_COPABICOLOR= "copabicolor";
	}
	
	public class GameGanadiario{	
		public static final String DISPLAY_GANADIARIO= "ganadiario";
		public static final String DISPLAY_GANADIARIO_SUSCRIPCION= "ganadiarioSuscripcion";
	}	
	
	public class GameKinelo{	
		public static final String GAME_ID="1121";
		public static final String DISPLAY_KINELO="kinelo";
	}
	
	public class GameFechaza{	
		public static final String GAME_ID="5209";
	}
	
	public class GameKabala{	
		public static final String DISPLAY_KABALA="kabala";
		public static final String DISPLAY_KABALA_SUSCRIPCION="kabalaSuscripcion";
	}
	
	public class GameVirtuales{	
		public static final String DISPLAY_JUEGA_GANA_DDVV="juegaGanaDDVV";
		public static final String DISPLAY_JUEGA_GANA_DDVV_2="juega-y-gana-con-virtuales";
	}
	
	public static class ConstantesString{
		public static final String TOSTRING = " gamesXML="+gamesXML+"\n"+
				" tav2Enabled="+tav2Enabled+"\n"+
				" tav2GameProviderBaseUrl="+tav2GameProviderBaseUrl+"\n"+
				" tav2OperatorId="+tav2OperatorId+"\n"+
				" tav2GameProviderCloseUrl="+tav2GameProviderCloseUrl+"\n"+
				" bannersUrl="+bannersUrl+"\n"+
				" iflexBonoTyC="+iflexBonoTyC+"\n"+
				" tinkaSuscriptionUrl="+tinkaSuscriptionUrl+"\n"+
				" kabalaSuscriptionUrl="+kabalaSuscriptionUrl+"\n"+
				" ganadiarioSuscriptionUrl="+ganadiarioSuscriptionUrl;
	}
	
	// Constantes para mostrar u ocultar el chatbot
    public static String chatbot_status_loggedin = "loggedin";
    public static String chatbot_status_always = "always";
    public static String chatbot_status_never = "never";
    
    //Constantes para la evaluacion para mostrar el tutorial
    public static String TUTORIAL_ENABLED = (ConnectionFactory.operationProperty("tutorial_enabled", contextSale)!=null)?ConnectionFactory.operationProperty("tutorial_enabled", contextSale).trim():"true";
    public static int TUTORIAL_MAX_DAYS = (ConnectionFactory.operationProperty("tutorial_max_days", contextSale)!=null)?Integer.parseInt(ConnectionFactory.operationProperty("tutorial_max_days", contextSale).trim()):30;
    public static int TUTORIAL_MAX_TOTAL = (ConnectionFactory.operationProperty("tutorial_max_total", contextSale)!=null)?Integer.parseInt(ConnectionFactory.operationProperty("tutorial_max_total", contextSale).trim()):25;
    public static int TUTORIAL_MAX_PER_DAY = (ConnectionFactory.operationProperty("tutorial_max_per_day", contextSale)!=null)?Integer.parseInt(ConnectionFactory.operationProperty("tutorial_max_per_day", contextSale).trim()):5;
    
  //Definicion de juegos raspaditas
    public static String RASPADITAS_SOURCE = ConnectionFactory.operationProperty("raspaditasSrc", contextSale).trim();
    public static String RASPADITAS_PARTNER = ConnectionFactory.operationProperty("raspaditasPartner", contextSale).trim();
    public static String RASPADITAS_LANGUAGE = "es-pe";
    public static String RASPADITAS_CURRENCY = "PEN";
    public static String RASPADITAS_CHANNEL = "mobile";
        
    //Casino
    public static String CASINO_LANGUAGE   = "es";
    public static String CASINO_CURRENCY   = "PEN";
    public static String CASINO_SITE_ID    = (ConnectionFactory.operationProperty("casino_site_id", contextSale)!=null)?ConnectionFactory.operationProperty("casino_site_id", contextSale).trim():"0";
    public static String CASINO_ACCESS_KEY = (ConnectionFactory.operationProperty("casino_access_key", contextSale)!=null)?ConnectionFactory.operationProperty("casino_access_key", contextSale).trim():"0";    
    public static String CASINO_API_URL    = (ConnectionFactory.operationProperty("casino_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("casino_api_url", contextSale).trim():"0";
    //preprod
    public static String PREPROD_CASINO_SITE_ID    = (ConnectionFactory.operationProperty("preprod_casino_site_id", contextSale)!=null)?ConnectionFactory.operationProperty("preprod_casino_site_id", contextSale).trim():"0";
    public static String PREPROD_CASINO_ACCESS_KEY = (ConnectionFactory.operationProperty("preprod_casino_access_key", contextSale)!=null)?ConnectionFactory.operationProperty("preprod_casino_access_key", contextSale).trim():"0";    
    public static String PREPROD_CASINO_API_URL    = (ConnectionFactory.operationProperty("preprod_casino_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("preprod_casino_api_url", contextSale).trim():"0";
    
    //constantes para analytics
    public static String HREF_FOR_ANALYTICS = ConnectionFactory.operationProperty("hrefForAnalytics", contextSale).trim();

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
    public static final String PLATAFORM = "MOBILE";
    public static final String MSG_NO_CREDIT = "No tienes premios que liquidar";
    public static final String MSG_NO_CREDIT_SUFICENT = "El monto que intentas solicitar es mayor al monto disponible para retirar. Edita el monto y env&iacute;a tu solicitud";
    public static final String MSG_NO_CREDIT_COMMISSION_SUFICENT = "Necesitas tener saldo disponible para el cobro de comisión por retiro de ";
    public static final String MSG_EXCEPTION = "Por favor, int&eacute;ntalo de nuevo en unos minutos.";
    public static final String MSG_INVALID_DATE = "Debes ingresar fechas v&aacute;lidas";
    public static final String MSG_RANGE_INVALID_DATE = "Debes ingresar una fecha desde menor a fecha hasta";
    public static final String MSG_DATE_OUT_RANGE = "El rango de fechas no debe ser mayor a 12 meses";
    public static final String MSG_AMOUNT_OUT_RANGE = "Ingrese un monto entre S/MIN y S/MAX soles";
    public static final String MONEDA_SOLES = "S/";
    public static final String PP_MAIL_SUBJECT_PART1 = ", tu recibo de retiro efectivo Nº ";
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
    public static final String LOADED_IMAGE_YES = "YES";
    public static final String LOADED_IMAGE_NO = "NO";
    public static final String DNI_STATE_ACTIVE = "ACT";
    public static final String MSG_DNI_NOT_LOADED = "Debes adjuntar una foto de tu DNI";
    public static final String MSG_DNI_NOT_VALID = "Debes adjuntar una imagen v&aacute;lida";
    public static final String MSG_DNI_LIMIT_MB = "T&uacute; imagen de DNI no debe ser mayor a ";
    public static final String MB = "MB";
    public static final String RESULT_OK = "OK";
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
	public static int OPERATOR_ID = 1;
	
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
    public static String fdCheckoutJs = String.valueOf(ConnectionFactory.operationProperty("checkout_js_tokenization_card", contextSale)).toString().trim();
    
    //ID flag parametros Consecutivas loterias
    public static final String C_TK   = "CTK";
    public static final String C_KB   = "CKB";
    public static final String C_GD   = "CGD";
    
	/**********************************PARAMETROS FD*******************************************/
	public static String PURCHASE_NUMBER = getLastPurchaseNumberFD();
	public static final String FD_CHANNEL = "mobile";
	public static final String FD_TERMINAL_ID = "1";
	public static final String FD_APPLICATION_ID = "pe.intralot.og";//PROD:pe.intralot.og	QA:VisaDirectOCTFD
	public static final String FD_ORDER_BUSINESS_APPLICATION_ID = "OG";//PROD:OG			QA:FD
	public static final String FD_ORDER_CURRENCY = "PEN";
	public static final String FD_MERCHANT_NAME = "LA TINKA";
	public static final String FD_MERCHANT_CATEGORY_CODE = "7995";
	public static final String FD_MERCHANT_ADDRESS_COUNTRY = "PER";
	public static final String FD_RECIPIENT_CAPTURE_TYPE = "manual";
	public static final String FD_RECIPIENT_ADDRESS = "Lima Peru";
	public static final String FD_RECIPIENT_CITY = "Lima";
	public static final String FD_RECIPIENT_STATE_CODE = "15";
	public static final String FD_RECIPIENT_COUNTRY_CODE = "PER";
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
    
    
    public synchronized static String generatePurchaseNumberFD() {
		int purchaseNumber = Integer.parseInt(PURCHASE_NUMBER);
		if(purchaseNumber>=500000) {
			PURCHASE_NUMBER="250001";
		}else {
			purchaseNumber++;
			PURCHASE_NUMBER=purchaseNumber+"";
		}
		return PURCHASE_NUMBER;
	}
    
    public static String getLastPurchaseNumberFD() {
    	return "250001";
    }
    
    public static int generateTransactionId() {
		return TRANSACTION_ID++;
	}
    
    public static String getPropertyContextSale(String property) {
    	return ConnectionFactory.operationProperty(property, contextSale).trim() ;
    }
    
    
    //map de jakpots
    public static Map<String, String> jackpotsMap = new HashMap<String, String>();
    public static final String CASINO_REGEX			="[\"\\[\\]]";
    public static final String CASINO_VACIO			="";
    public static final String URL_JACKPOT_CASINO	=ConnectionFactory.operationProperty("urlJackpotCasino", contextSale).trim();
    
    public static final String styles_css   = "50";
    public static final String main_1_0_css   = "40";
    public static final String tav2_header_css   = "17";
    public static final String popModal_css = "2";
    
    public static final String main_1_0_js   = "84";
    public static final String plugins_js   = "4";
    public static final String lotto_mobile_1_0_js   = "33";
    
  //Constantes para virtuales
    public static final String XPRESS_LANGUAGE    = "es";
    public static final String XPRESS_TOKEN_DEMO  = "1a2b3c4d5e6f7g8h9i";
    public static final String XPRESS_MODE_DEMO   = "0";
    public static final String XPRESS_MODE_REAL   = "1";
    public static final String XPRESS_PLATFORM    = "mobile";
    public static final String XPRESS_REGRESAR_LOBBY = "Deportes Virtuales / Golden Race";
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
    public static final String LEAP_REGRESAR_LOBBY= "Deportes Virtuales / Leap Gaming";
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
    
    //Casino QTECH
    public static String CASINO_QT_LANGUAGE   = "es_ES";
    public static String CASINO_QT_CURRENCY   = "PEN";
    public static String CASINO_QT_COUNTRY    = "PE";
    public static String CASINO_QT_REAL    	  = "real";
    public static String CASINO_QT_DEVICE 	  = "mobile";
    public static String CASINO_QT_API_URL    = (ConnectionFactory.operationProperty("casino_qt_api_url", contextSale)!=null)?ConnectionFactory.operationProperty("casino_qt_api_url", contextSale).trim():"0";
    public static String CASINO_QT_USERNAME   = (ConnectionFactory.operationProperty("casino_qt_username", contextSale)!=null)?ConnectionFactory.operationProperty("casino_qt_username", contextSale).trim():"0";    
    public static String CASINO_QT_PASSWORD   = (ConnectionFactory.operationProperty("casino_qt_password", contextSale)!=null)?ConnectionFactory.operationProperty("casino_qt_password", contextSale).trim():"0";

    /**********************************ePago*******************************************/
    public static final String EPAGO_API_KEY = ConnectionFactory.operationProperty("apiKey", contextEpago).trim();
    public static final String EPAGO_SECRET_KEY = ConnectionFactory.operationProperty("secretKey", contextEpago).trim();
    public static final String EPAGO_PAYMENT_METHODS = ConnectionFactory.operationProperty("paymentMethods", contextEpago).trim();
    public static final String EPAGO_ENVIRONMENT = ConnectionFactory.operationProperty("environment", contextEpago).trim();
    
    //API RENIEC WS
    public static String API_RENIECWS= ConnectionFactory.operationProperty("uriReniecWs", contextSale).trim();
    public static String USER_RENIEC_WS= ConnectionFactory.operationProperty("userReniecWs", contextSale).trim();
    public static String PASS_RENIEC_WS= ConnectionFactory.operationProperty("passReniecWs", contextSale).trim();
    
    
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

    public static final String BANNER_CONFIG_XML = ConnectionFactory.operationProperty("bannerConfigXML", contextSale).trim();

}
