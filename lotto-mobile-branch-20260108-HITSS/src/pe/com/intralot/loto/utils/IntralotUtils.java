package pe.com.intralot.loto.utils;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.io.*;
import java.lang.reflect.Type;

import javax.crypto.*;

import java.security.spec.*;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.spec.*;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.RegexValidator;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.model.pojo.BonoOtroJuego;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.Ganadiario;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioSale;
import pe.com.intralot.loto.layer.model.pojo.Kabala;
import pe.com.intralot.loto.layer.model.pojo.KabalaSale;
import pe.com.intralot.loto.layer.model.pojo.Tinka;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.sale.lib.LoggerApi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * <p>
 * NOMBRE: IntralotUtils.java
 * <br></p>
 * <p>
 * FUNCION: Utilitarios de datos de cuenta
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Depuración de comentarios
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Repository("intralotUtils")
public class IntralotUtils {
	
	private Gson gson;  
	
	private Cipher ecipher;
        
	private Cipher dcipher;
       
	private byte[] salt = {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
        };
    
	private int iterationCount = 19;
    
    public IntralotUtils() {
    	String passPhrase = "INTRALOTPERU";
        try {
       
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
                ecipher = Cipher.getInstance(key.getAlgorithm());
                dcipher = Cipher.getInstance(key.getAlgorithm());
                 
                AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
                ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
                dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            } catch (java.security.InvalidAlgorithmParameterException e) {
            	LoggerApi.severe(e);
            } catch (java.security.spec.InvalidKeySpecException e) {
            	LoggerApi.severe(e);
            } catch (javax.crypto.NoSuchPaddingException e) {
            	LoggerApi.severe(e);
            } catch (java.security.NoSuchAlgorithmException e) {
            	LoggerApi.severe(e);
            } catch (java.security.InvalidKeyException e) {
            	LoggerApi.severe(e);
            }
        }
    
  
        @SuppressWarnings("hiding")
	public String encrypt(String str) {
        try {
            
            byte[] utf8 = str.getBytes("UTF8");

            
            byte[] enc = ecipher.doFinal(utf8);
               
         return new sun.misc.BASE64Encoder().encode(enc);
        } catch (javax.crypto.BadPaddingException e) {
        	LoggerApi.severe(e);
        } catch (IllegalBlockSizeException e) {
        	LoggerApi.severe(e);
        } catch (UnsupportedEncodingException e) {
        	LoggerApi.severe(e);
        } catch (java.io.IOException e) {
        	LoggerApi.severe(e);
        }
        return null;
    }

    private String decrypt(String str) {
        try {
   
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
            
            byte[] utf8 = dcipher.doFinal(dec);
           
            return new String(utf8, "UTF8");
        } catch (javax.crypto.BadPaddingException e) {
        	LoggerApi.severe(e);
        } catch (IllegalBlockSizeException e) {
        	LoggerApi.severe(e);
        } catch (UnsupportedEncodingException e) {
        	LoggerApi.severe(e);
        } catch (java.io.IOException e) {
        	LoggerApi.severe(e);
        }
        return null;
    }

	
	public String decodeLabel(String labelEncoded)
	throws Exception
	{
		if (labelEncoded == null) return null;
		String decrypted = decrypt(labelEncoded.replaceAll(" ", "\\+"));
    		return decrypted;
    	}
    	
  
    	public String formatCurrency(double mount){    		
    		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    		DecimalFormat df = (DecimalFormat)nf;
    		df.applyPattern(Constantes.FORMATTER_CURRENCY);  
    		
			return df.format(mount); 
    	}
    	
    	public String formatCurrencyOneDecimal(double mount){    		
    		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    		DecimalFormat df = (DecimalFormat)nf;
    		df.applyPattern(Constantes.FORMATTER_CURRENCY_ONE_DECIMAL);  
    		
			return df.format(mount); 
    	}
    	
    	public String formatCurrency2(double mount){    		
    		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    		DecimalFormat df = (DecimalFormat)nf;
    		df.applyPattern(Constantes.FORMATTER_CURRENCY2);  
    		
			return df.format(mount); 
    	}
    	
    	public String formatCurrency3(int mount){    		
    		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    		DecimalFormat df = (DecimalFormat)nf;
    		df.applyPattern(Constantes.FORMATTER_CURRENCY3);  
    		
			return df.format(mount); 
    	}
    	
    	public String formatPorcentaje(double mount){    		
    		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    		DecimalFormat df = (DecimalFormat)nf;
    		df.applyPattern(Constantes.FORMATTER_PORCENTAJE);  
    		
			return df.format(mount); 
    	}
    	
      	public String toJson(Object T){    		
      		gson=new Gson();
    		return gson.toJson(T);
    	}
      	
     	public String toJsonTree(Object T){     		
    		gson=new Gson();   
    		JsonElement result=gson.toJsonTree(T);
    		return result.toString();
    	}
     	
     	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object toGenericObject(String json,Class clazz){
 		gson=new Gson();  
 		return gson.fromJson(json,clazz);
 	}
 	
	public  Object toGenericObject(String json, Type type){
		Gson gson = new Gson();  
 		return gson.fromJson(json, type);
 	}
  	

	public String convertHexToString(String hex){
		 
    StringBuilder out = new StringBuilder();    
	     		
	 for( int index=0; index<hex.length()-1; index+=2 ){ 
		out.append((char)Integer.parseInt(hex.substring(index, (index + 2)), 16));      		    
	 }    	
	 
	return out.toString();
	}
	
	public static String formatHtml(String text) {
		String UNICODE_SMALL_A_GRAVE = "\u00E0";
		String UNICODE_SMALL_A_ACUTE = "\u00E1";
		String UNICODE_SMALL_A_CIRC = "\u00E2";
		String UNICODE_SMALL_A_TILDE = "\u00E3";
		String UNICODE_SMALL_A_UML = "\u00E4";
		String UNICODE_SMALL_A_RING = "\u00E5";
		String UNICODE_SMALL_C_CEDIL = "\u00E7"; 
		String UNICODE_SMALL_E_GRAVE = "\u00E8";
		String UNICODE_SMALL_E_ACUTE = "\u00E9";
		String UNICODE_SMALL_E_CIRC = "\u00EA";
		String UNICODE_SMALL_E_UML = "\u00EB";
		String UNICODE_SMALL_I_GRAVE = "\u00EC";
		String UNICODE_SMALL_I_ACUTE = "\u00ED";
		String UNICODE_SMALL_I_CIRC = "\u00EE";
		String UNICODE_SMALL_I_UML = "\u00EF";
		String UNICODE_SMALL_O_GRAVE = "\u00F2";
		String UNICODE_SMALL_O_ACUTE = "\u00F3";
		String UNICODE_SMALL_O_CIRC = "\u00F4";
		String UNICODE_SMALL_O_TILDE = "\u00F5";
		String UNICODE_SMALL_O_UML = "\u00F6";
		String UNICODE_SMALL_U_GRAVE = "\u00F9";
		String UNICODE_SMALL_U_ACUTE = "\u00FA";
		String UNICODE_SMALL_U_CIRC = "\u00FB";
		String UNICODE_SMALL_U_UML = "\u00FC";
		String UNICODE_SMALL_N_TILDE = "\u00F1";
		String UNICODE_CAPITAL_A_GRAVE = "\u00C0";
		String UNICODE_CAPITAL_A_ACUTE = "\u00C1";
		String UNICODE_CAPITAL_A_CIRC = "\u00C2";
		String UNICODE_CAPITAL_A_TILDE = "\u00C3";
		String UNICODE_CAPITAL_A_UML = "\u00C4";
		String UNICODE_CAPITAL_A_RING = "\u00C5";
		String UNICODE_CAPITAL_C_CEDIL = "\u00C7"; 
		String UNICODE_CAPITAL_E_GRAVE = "\u00C8";
		String UNICODE_CAPITAL_E_ACUTE = "\u00C9";
		String UNICODE_CAPITAL_E_CIRC = "\u00CA";
		String UNICODE_CAPITAL_E_UML = "\u00CB";
		String UNICODE_CAPITAL_I_GRAVE = "\u00CC";
		String UNICODE_CAPITAL_I_ACUTE = "\u00CD";
		String UNICODE_CAPITAL_I_CIRC = "\u00CE";
		String UNICODE_CAPITAL_I_UML = "\u00CF";
		String UNICODE_CAPITAL_O_GRAVE = "\u00D2";
		String UNICODE_CAPITAL_O_ACUTE = "\u00D3";
		String UNICODE_CAPITAL_O_CIRC = "\u00D4";
		String UNICODE_CAPITAL_O_TILDE = "\u00D5";
		String UNICODE_CAPITAL_O_UML = "\u00D6";
		String UNICODE_CAPITAL_U_GRAVE = "\u00D9";
		String UNICODE_CAPITAL_U_ACUTE = "\u00DA";
		String UNICODE_CAPITAL_U_CIRC = "\u00DB";
		String UNICODE_CAPITAL_U_UML = "\u00DC";
		String UNICODE_CAPITAL_N_TILDE = "\u00D1";
		String UNICODE_IEXCLAMATION = "\u00A1";
		String UNICODE_GRADE = "\u00B0";
		String UNICODE_IQUESTION = "\u00BF";
		String UNICODE_RETURN = "\\u000D";
		String UNICODE_NEWLINE = "\\u000A";
		String UNICODE_DOBLEQUOTE = "\\u0022";
		String UNICODE_EURO = "\u0080";
		String UNICODE_PLUS = "\\u002B";
		String UNICODE_PLUS_MINUS = "\u00B1";
		String UNICODE_MAN_ORDINAL_INDICATOR = "\u00BA";
		String UNICODE_FEM_ORDINAL_INDICATOR = "\u00AA";
		String UNICODE_ACUTE_ACCENT = "\u00B4";
		return text.replaceAll(UNICODE_SMALL_A_GRAVE, "&agrave;")
					.replaceAll(UNICODE_SMALL_A_ACUTE, "&aacute;")
					.replaceAll(UNICODE_SMALL_A_CIRC, "&acirc;")
					.replaceAll(UNICODE_SMALL_A_TILDE, "&atilde;")
					.replaceAll(UNICODE_SMALL_A_UML, "&auml;")
					.replaceAll(UNICODE_SMALL_A_RING, "&aring;")
					.replaceAll(UNICODE_SMALL_C_CEDIL, "&ccedil;")
					.replaceAll(UNICODE_SMALL_E_GRAVE, "&egrave;")
					.replaceAll(UNICODE_SMALL_E_ACUTE, "&eacute;")
					.replaceAll(UNICODE_SMALL_E_CIRC, "&ecirc;")
					.replaceAll(UNICODE_SMALL_E_UML, "&euml;")
					.replaceAll(UNICODE_SMALL_I_GRAVE, "&igrave;")
					.replaceAll(UNICODE_SMALL_I_ACUTE, "&iacute;")
					.replaceAll(UNICODE_SMALL_I_CIRC, "&icirc;")
					.replaceAll(UNICODE_SMALL_I_UML, "&iuml;")
					.replaceAll(UNICODE_SMALL_O_GRAVE, "&ograve;")
					.replaceAll(UNICODE_SMALL_O_ACUTE, "&oacute;")
					.replaceAll(UNICODE_SMALL_O_CIRC, "&ocirc;")
					.replaceAll(UNICODE_SMALL_O_TILDE, "&otilde;")
					.replaceAll(UNICODE_SMALL_O_UML, "&ouml;")
					.replaceAll(UNICODE_SMALL_U_GRAVE, "&ugrave;")
					.replaceAll(UNICODE_SMALL_U_ACUTE, "&uacute;")
					.replaceAll(UNICODE_SMALL_U_CIRC, "&ucirc;")
					.replaceAll(UNICODE_SMALL_U_UML, "&uuml;")
					.replaceAll(UNICODE_SMALL_N_TILDE, "&ntilde;")
					.replaceAll(UNICODE_CAPITAL_A_GRAVE, "&Agrave;")
					.replaceAll(UNICODE_CAPITAL_A_ACUTE, "&Aacute;")
					.replaceAll(UNICODE_CAPITAL_A_CIRC, "&Acirc;")
					.replaceAll(UNICODE_CAPITAL_A_TILDE, "A")
					.replaceAll(UNICODE_CAPITAL_A_UML, "&Atilde;")
					.replaceAll(UNICODE_CAPITAL_A_RING, "&Auml;")
					.replaceAll(UNICODE_CAPITAL_C_CEDIL, "&Ccedil;")
					.replaceAll(UNICODE_CAPITAL_E_GRAVE, "&Egrave;")
					.replaceAll(UNICODE_CAPITAL_E_ACUTE, "&Eacute;")
					.replaceAll(UNICODE_CAPITAL_E_CIRC, "&Ecirc;")
					.replaceAll(UNICODE_CAPITAL_E_UML, "&Euml;")
					.replaceAll(UNICODE_CAPITAL_I_GRAVE, "&Igrave;")
					.replaceAll(UNICODE_CAPITAL_I_ACUTE, "&Iacute;")
					.replaceAll(UNICODE_CAPITAL_I_CIRC, "&Icirc;")
					.replaceAll(UNICODE_CAPITAL_I_UML, "&Iuml;")
					.replaceAll(UNICODE_CAPITAL_O_GRAVE, "&Ograve;")
					.replaceAll(UNICODE_CAPITAL_O_ACUTE, "&Oacute;")
					.replaceAll(UNICODE_CAPITAL_O_CIRC, "&Ocirc;")
					.replaceAll(UNICODE_CAPITAL_O_TILDE, "&Otilde;")
					.replaceAll(UNICODE_CAPITAL_O_UML, "&Ouml;")
					.replaceAll(UNICODE_CAPITAL_U_GRAVE, "&Ugrave;")
					.replaceAll(UNICODE_CAPITAL_U_ACUTE, "&Uacute;")
					.replaceAll(UNICODE_CAPITAL_U_CIRC, "&Ucirc;")
					.replaceAll(UNICODE_CAPITAL_U_UML, "&Uuml;")
					.replaceAll(UNICODE_CAPITAL_N_TILDE, "&Ntilde;")
					.replaceAll(UNICODE_IEXCLAMATION, "&iexcl;")
					.replaceAll(UNICODE_GRADE, "&deg;")
					.replaceAll(UNICODE_IQUESTION, "&iquest;")
					.replaceAll(UNICODE_RETURN, "<br/>")
					.replaceAll(UNICODE_NEWLINE, "<br/>")
					.replaceAll(UNICODE_DOBLEQUOTE, "&quot;")
					.replaceAll(UNICODE_EURO, "&euro;")
					.replaceAll(UNICODE_PLUS, "&plusmn;")
					.replaceAll(UNICODE_PLUS_MINUS, "&plusmn;")
					.replaceAll(UNICODE_MAN_ORDINAL_INDICATOR, "&ordm;")
					.replaceAll(UNICODE_FEM_ORDINAL_INDICATOR, "&ordf;")
					.replaceAll(UNICODE_ACUTE_ACCENT, "&acute;");
	}
	
	public static String formatText(String text) {
        String UNICODE_QUOTATION_MARK = "\\u0022";
        String UNICODE_NUMBER_SIGN = "\u0023";
        String UNICODE_AMPERSAND = "\u0026";
        String UNICODE_APOSTROPHE = "\u0027";
        String UNICODE_COMMA = "\u002C";
        String UNICODE_HYPHEN_MINUS = "\u002D";
        String UNICODE_SOLIDUS = "\u002F";
        String UNICODE_SMALL_A_GRAVE = "\u00E0";
        String UNICODE_SMALL_A_ACUTE = "\u00E1";
        String UNICODE_SMALL_A_CIRC = "\u00E2";
        String UNICODE_SMALL_A_TILDE = "\u00E3";
        String UNICODE_SMALL_A_UML = "\u00E4";
        String UNICODE_SMALL_A_RING = "\u00E5";
        String UNICODE_SMALL_C_CEDIL = "\u00E7";
        String UNICODE_SMALL_E_GRAVE = "\u00E8";
        String UNICODE_SMALL_E_ACUTE = "\u00E9";
        String UNICODE_SMALL_E_CIRC = "\u00EA";
        String UNICODE_SMALL_E_UML = "\u00EB";
        String UNICODE_SMALL_I_GRAVE = "\u00EC";
        String UNICODE_SMALL_I_ACUTE = "\u00ED";
        String UNICODE_SMALL_I_CIRC = "\u00EE";
        String UNICODE_SMALL_I_UML = "\u00EF";
        String UNICODE_SMALL_O_GRAVE = "\u00F2";
        String UNICODE_SMALL_O_ACUTE = "\u00F3";
        String UNICODE_SMALL_O_CIRC = "\u00F4";
        String UNICODE_SMALL_O_TILDE = "\u00F5";
        String UNICODE_SMALL_O_UML = "\u00F6";
        String UNICODE_SMALL_U_GRAVE = "\u00F9";
        String UNICODE_SMALL_U_ACUTE = "\u00FA";
        String UNICODE_SMALL_U_CIRC = "\u00FB";
        String UNICODE_SMALL_U_UML = "\u00FC";
        String UNICODE_SMALL_N_TILDE = "\u00F1";
        String UNICODE_CAPITAL_A_GRAVE = "\u00C0";
        String UNICODE_CAPITAL_A_ACUTE = "\u00C1";
        String UNICODE_CAPITAL_A_CIRC = "\u00C2";
        String UNICODE_CAPITAL_A_TILDE = "\u00C3";
        String UNICODE_CAPITAL_A_UML = "\u00C4";
        String UNICODE_CAPITAL_A_RING = "\u00C5";
        String UNICODE_CAPITAL_C_CEDIL = "\u00C7";
        String UNICODE_CAPITAL_E_GRAVE = "\u00C8";
        String UNICODE_CAPITAL_E_ACUTE = "\u00C9";
        String UNICODE_CAPITAL_E_CIRC = "\u00CA";
        String UNICODE_CAPITAL_E_UML = "\u00CB";
        String UNICODE_CAPITAL_I_GRAVE = "\u00CC";
        String UNICODE_CAPITAL_I_ACUTE = "\u00CD";
        String UNICODE_CAPITAL_I_CIRC = "\u00CE";
        String UNICODE_CAPITAL_I_UML = "\u00CF";
        String UNICODE_CAPITAL_O_GRAVE = "\u00D2";
        String UNICODE_CAPITAL_O_ACUTE = "\u00D3";
        String UNICODE_CAPITAL_O_CIRC = "\u00D4";
        String UNICODE_CAPITAL_O_TILDE = "\u00D5";
        String UNICODE_CAPITAL_O_UML = "\u00D6";
        String UNICODE_CAPITAL_U_GRAVE = "\u00D9";
        String UNICODE_CAPITAL_U_ACUTE = "\u00DA";
        String UNICODE_CAPITAL_U_CIRC = "\u00DB";
        String UNICODE_CAPITAL_U_UML = "\u00DC";
        String UNICODE_CAPITAL_N_TILDE = "\u00D1";
        String UNICODE_GRADE = "\u00B0";
        return text
                .replaceAll(UNICODE_NUMBER_SIGN, "No")
                .replaceAll(UNICODE_AMPERSAND, "y")
                .replaceAll("[" + UNICODE_QUOTATION_MARK + "|" + UNICODE_APOSTROPHE + "|" + UNICODE_COMMA + "|" + UNICODE_HYPHEN_MINUS + "|" + UNICODE_SOLIDUS + "]", " ")
                .replaceAll(
                        "[" + UNICODE_SMALL_A_GRAVE + "|" + UNICODE_SMALL_A_ACUTE + "|" + UNICODE_SMALL_A_CIRC + "|" + UNICODE_SMALL_A_TILDE + "|" + UNICODE_SMALL_A_UML + "|" + UNICODE_SMALL_A_RING
                                + "]", "a")
                .replaceAll(UNICODE_SMALL_C_CEDIL, "c")
                .replaceAll("[" + UNICODE_SMALL_E_GRAVE + "|" + UNICODE_SMALL_E_ACUTE + "|" + UNICODE_SMALL_E_CIRC + "|" + UNICODE_SMALL_E_UML + "]", "e")
                .replaceAll("[" + UNICODE_SMALL_I_GRAVE + "|" + UNICODE_SMALL_I_ACUTE + "|" + UNICODE_SMALL_I_CIRC + "|" + UNICODE_SMALL_I_UML + "]", "i")
                .replaceAll("[" + UNICODE_SMALL_O_GRAVE + "|" + UNICODE_SMALL_O_ACUTE + "|" + UNICODE_SMALL_O_CIRC + "|" + UNICODE_SMALL_O_TILDE + "|" + UNICODE_SMALL_O_UML + "]", "o")
                .replaceAll("[" + UNICODE_SMALL_U_GRAVE + "|" + UNICODE_SMALL_U_ACUTE + "|" + UNICODE_SMALL_U_CIRC + "|" + UNICODE_SMALL_U_UML + "]", "u")
                .replaceAll(UNICODE_SMALL_N_TILDE, "n")
                .replaceAll(
                        "[" + UNICODE_CAPITAL_A_GRAVE + "|" + UNICODE_CAPITAL_A_ACUTE + "|" + UNICODE_CAPITAL_A_CIRC + "|" + UNICODE_CAPITAL_A_TILDE + "|" + UNICODE_CAPITAL_A_UML + "|"
                                + UNICODE_CAPITAL_A_RING + "]", "A").replaceAll(UNICODE_CAPITAL_C_CEDIL, "C")
                .replaceAll("[" + UNICODE_CAPITAL_E_GRAVE + "|" + UNICODE_CAPITAL_E_ACUTE + "|" + UNICODE_CAPITAL_E_CIRC + "|" + UNICODE_CAPITAL_E_UML + "]", "E")
                .replaceAll("[" + UNICODE_CAPITAL_I_GRAVE + "|" + UNICODE_CAPITAL_I_ACUTE + "|" + UNICODE_CAPITAL_I_CIRC + "|" + UNICODE_CAPITAL_I_UML + "]", "I")
                .replaceAll("[" + UNICODE_CAPITAL_O_GRAVE + "|" + UNICODE_CAPITAL_O_ACUTE + "|" + UNICODE_CAPITAL_O_CIRC + "|" + UNICODE_CAPITAL_O_TILDE + "|" + UNICODE_CAPITAL_O_UML + "]", "O")
                .replaceAll("[" + UNICODE_CAPITAL_U_GRAVE + "|" + UNICODE_CAPITAL_U_ACUTE + "|" + UNICODE_CAPITAL_U_CIRC + "|" + UNICODE_CAPITAL_U_UML + "]", "U")
                .replaceAll(UNICODE_CAPITAL_N_TILDE, "N").replaceAll(UNICODE_GRADE, "o");
    }
	
	public String verifyPassword2(String pUser, String pPassword, String rePassword) throws Exception {
		String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
        //------------ VERIFICACION DE PASSWORD
        if (!pPassword.equals(rePassword)) {
        	return message;
        }
        // Password length must be at least 8 characters long. 
        if (pPassword.length()<8) {
        	return message;
        }
        // Password must consist at least 1 number and 1 letter. 
        boolean atleastOneAlpha = pPassword.matches(".*[a-zA-Z]+.*");
        boolean atleastOneNumber = pPassword.matches(".*[0-9]+.*");
        boolean atleastSpecialCharacter = pPassword.matches(".*[!@#$%^&*()+=\\[\\]\\';,\\/\\{\\}|\\\":<>?~`.\\-_¬€£¦]+.*");
        if (atleastOneAlpha==false || atleastOneNumber==false || atleastSpecialCharacter==false) {
        	return message;
        }
        //pUser vacio debido a que el codigo de verificacion es errado
        if (pUser.equals("")) {
        	return message;
        }
        // The password may not be equal to the user name. 
        if (pPassword.toLowerCase().contains(pUser.toLowerCase())) {
        	return message;
        }
        // Dictionary checking of limited words must be enabled (extensive dictionary checks may create problems: players may not be able to register leading to drop of sales).
        String[] list = {"passw0rd","password","123456","000000","111111","222222","tequiero","qwerty","abc123","estrella","iloveyou","654321","bonita","mariposa","america","starwars","azerty","sexo","dinero","amor","123456","password","12345678","1234","pussy","12345","dragon","qwerty","696969","mustang","letmein","baseball","master","michael","football","shadow","monkey","abc123","pass","fuckme","6969","jordan","harley","ranger","iwantu","jennifer","hunter","fuck","2000","test","batman","trustno1","thomas","tigger","robert","access","love","buster","1234567","soccer","hockey","killer","george","sexy","andrew","charlie","superman","asshole","fuckyou","dallas","jessica","panties","pepper","1111","austin","william","daniel","golfer","summer","heather","hammer","yankees","joshua","maggie","biteme","enter","ashley","thunder","cowboy","silver","richard","fucker","orange","merlin","michelle","corvette","bigdog","cheese","matthew","121212","patrick","martin","freedom","ginger","blowjob","nicole","sparky","yellow","camaro","secret","dick","falcon","taylor","111111","131313","123123","bitch","hello","scooter","please","porsche","guitar","chelsea","black","diamond","nascar","jackson","cameron","654321","computer","amanda","wizard","xxxxxxxx","money","phoenix","mickey","bailey","knight","iceman","tigers","purple","andrea","horny","dakota","aaaaaa","player","sunshine","morgan","starwars","boomer","cowboys","edward","charles","girls","booboo","coffee","xxxxxx","bulldog","ncc1701","rabbit","peanut","john","johnny","gandalf","spanky","winter","brandy","compaq","carlos","tennis","james","mike","brandon","fender","anthony","blowme","ferrari","cookie","chicken","maverick","chicago","joseph","diablo","sexsex","hardcore","666666","willie","welcome","chris","panther","yamaha","justin","banana","driver","marine","angels","fishing","david","maddog","hooters","wilson","butthead","dennis","fucking","captain","bigdick","chester","smokey","xavier","steven","viking","snoopy","blue","eagles","winner","samantha","house","miller","flower","jack","firebird","butter","united","turtle","steelers","tiffany","zxcvbn","tomcat","golf","bond007","bear","tiger","doctor","gateway","gators","angel","junior","thx1138","porno","badboy","debbie","spider","melissa","booger","1212","flyers","fish","porn","matrix","teens","scooby","jason","walter","cumshot","boston","braves","yankee","lover","barney","victor","tucker","princess","mercedes","5150","doggie","zzzzzz","gunner","horney","bubba","2112","fred","johnson","xxxxx","tits","member","boobs","donald","bigdaddy","bronco","penis","voyager","rangers","birdie","trouble","white","topgun","bigtits","bitches","green","super","qazwsx","magic","lakers","rachel","slayer","scott","2222","asdf","video","london","7777","marlboro","srinivas","internet","action","carter","jasper","monster","teresa","jeremy","11111111","bill","crystal","peter","pussies","cock","beer","rocket","theman","oliver","rosebud","jaguar","great","cool","cooper","1313","scorpio","mountain","madison","987654","brazil","lauren","japan","naked","squirt","stars","apple","alexis","aaaa","bonnie","peaches","jasmine","kevin","matt","qwertyui","danielle","beaver","4321","4128","runner","swimming","dolphin","gordon","casper","stupid","shit","saturn","gemini","apples","august","3333","canada","blazer","cumming","hunting","kitty","rainbow","112233","arthur","cream","calvin","shaved","surfer","samson","kelly","paul","mine","king","racing","5555","eagle","hentai","newyork","little","redwings","smith","sticky","cocacola","animal","broncos","private","skippy","marvin","blondes","enjoy","girl","apollo","parker","qwert","time","sydney","women","voodoo","magnum","juice","abgrtyu","777777","dreams","maxwell","music","rush2112","russia","scorpion","rebecca","tester","mistress","phantom","billy","6666","albert","prince","beach","amateur","7777777","muffin","redsox","star","testing","shannon","murphy","frank","hannah","dave","eagle1","11111","mother","nathan","raiders","steve","forever","angela","viper","ou812","jake","lovers","suckit","gregory","buddy","whatever","young","nicholas","lucky","helpme","jackie","monica","midnight","college","baby","cunt","brian","mark","startrek","sierra","leather","232323","4444","beavis","bigcock","happy","sophie","ladies","naughty","giants","booty","blonde","fucked","golden","fire","sandra","pookie","packers","einstein","dolphins","chevy","winston","warrior","sammy","slut","8675309","zxcvbnm","nipples","power","victoria","asdfgh","vagina","toyota","travis","hotdog","paris","rock","xxxx","extreme","redskins","erotic","dirty","ford","freddy","arsenal","access14","wolf","nipple","iloveyou","alex","florida","eric","legend","movie","success"};
        for (String s:list) {
            if (pPassword.toLowerCase().contains(s.toLowerCase())) {
            	return message;
            }
        }
        // System generated passwords will always have to be changed the first time a customer tries to log on with this password. 
        // The new password may not be equal to the generated one. 
        //------------ FIN DE VERIFICACION DE PASSWORD 
        return "OK";
    }
	
	public String verifyPassword(String pUser, String pPassword, String rePassword) throws Exception {
		String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
        //------------ VERIFICACION DE PASSWORD
        if (!pPassword.equals(rePassword)) {
        	return message;
        }
        // Password length must be at least 8 characters long. 
        if (pPassword.length()<8) {
        	return message;
        }
        // Password must consist at least 1 number and 1 letter. 
        boolean atleastOneAlpha = pPassword.matches(".*[a-zA-Z]+.*");
        boolean atleastOneNumber = pPassword.matches(".*[0-9]+.*");
        boolean atleastSpecialCharacter = pPassword.matches(".*[!@#$%^&*()+=\\[\\]\\';,\\/\\{\\}|\\\":<>?~`.\\-_¬€£¦]+.*");
        
        if (atleastOneAlpha==false || atleastOneNumber==false || atleastSpecialCharacter==false) {
        	return message;
        }
        //pUser vacio debido a que el codigo de verificacion es errado
        if (pUser.equals("")) {
        	return message;
        } 
        
    	// Expresión regular para validar que la contraseña tenga al menos una letra mayúscula y una letra minúscula
	    String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(pPassword);
	    if (!matcher.matches()) {
	    	return message;
	    } 
        return "OK";
    }
	
	public static String verifyEmail(String email) throws Exception {
		/*
        String mails = "@mailcatch.com,@trbvn.com,@20email,@clrmail.com,@emailsensei.com,@filzmail.com,@sharklasers.com,@grr.la,@guerrillamail,@spam4.me,@incognitomail.org,@uu1.pl,@mailinator.com,@mailnesia.com,@mintemail.com,@mt2015.com,@noclickemail.com,@spamfree24.org,@tempemail.net,@trashmail.ws,@yopmail.com,"
        		+ "";
        
        //------------ VERIFICACION DE MAIL
        String[] list = mails.split(",");
        for (String s:list) {
            if (email.toLowerCase().contains(s.toLowerCase())) {
            	return "Ingresar una direcci&oacute;n de correo correcto";
            }
        }*/
        //------------ FIN DE VERIFICACION DE MAIL
        Dbms rs = null;
        int domain = 0;
        try {
            rs = new Dbms();
    	    String sql = "select count(edt_domain) from lotocard.email_domains_temporary  where  trim(lower(edt_domain)) = trim(lower(substr(?,INSTR(?,'@')))) ";
    	    rs.setSql(sql);
            rs.setString(1,email);
            rs.setString(2,email);
            rs.executeQuery();
            if (rs.next()) {
            	domain = rs.getInt(1);
            }
		} finally {
			try {
				if(rs!=null) {
					System.out.println("<--------------------IntralotUtils.verifyEmail cerrando conexion------------------->");
					 rs.close();
				}
			} catch (Exception e) {
				System.out.println("<--------------------IntralotUtils.verifyEmail error cerrando conexion------------------->");
				e.printStackTrace();
			}
			
		}
        if (domain > 0) {
        	return "El correo registrado tiene un dominio invalido";
        }
        
        return "OK";
    }
	
	public String toUC1stLetter(String s) {
        String newString = "";
        s = s.trim();
        if (!"".equals(s)) {
            String words[] = s.replaceAll(" +", " ").split(" ");
            for (String word : words)
                newString = newString + ucFirst(word) + " ";
        }
        return newString.trim();
    }
	
	private String ucFirst(String word) {
        String exWords[] = { "a", "de", "del", "la", "los", "las", "van", "von", "der", "di" };
        boolean state = false;
        for (String exWord : exWords)
            if (exWord.equals(word.toLowerCase())) {
                state = true;
                break;
            }
        if (state)
            return word.toLowerCase();
        else
            return word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase();
    }
	
	/**
     * Metodo que obtiene el ultimo boleto de juego realizado
     * @param session
     * @return redireccion (url) del ultimo boleto realizado
     */
	public static String redireccionarUltimaJugada(HttpSession session,String urlDefault) throws Exception {	
		String redireccion=urlDefault;
    	try {
    		@SuppressWarnings("rawtypes")
			Map playList = (Map) session.getAttribute("lastJugada");
    		
    		try {if (StringUtils.isNotEmpty((String) playList.get("tinka_cad"))) {
    			LoggerApi.Log.info(":::::::::::TINKA_CAD:::::::::::::");
    			LoggerApi.Log.info((String) playList.get("tinka_cad"));
            	redireccion = "game_tinka_show_shoppingcart.html";
            }}catch (Exception e) {}
    		try {if (StringUtils.isNotEmpty((String) playList.get("ganadiario_cad"))) {
    			LoggerApi.Log.info(":::::::::::GANADIARIO_CAD:::::::::::::");
    			LoggerApi.Log.info((String) playList.get("ganadiario_cad"));
            	redireccion = "game_ganadiario_show_shoppingcart.html";
            }}catch (Exception e) {}
    		try {if (StringUtils.isNotEmpty((String) playList.get("id_"))) {
    			LoggerApi.Log.info(":::::::::::GANAGOL_CAD:::::::::::::");
    			LoggerApi.Log.info((String) playList.get("id_"));
            	redireccion = "game_ganagol_show_shoppingcart.html";
            }}catch (Exception e) {}
    		try {if (StringUtils.isNotEmpty((String) playList.get("kabala_cad"))) {
    			LoggerApi.Log.info(":::::::::::KABALA_CAD:::::::::::::");
    			LoggerApi.Log.info((String) playList.get("kabala_cad"));
            	redireccion = "game_kabala_show_shoppingcart.html";
            }}catch (Exception e) {}

        } catch (Exception e) {}
    	
		return redireccion;
	}
	
	@SuppressWarnings("rawtypes")
	public static int carItemUpdate(HttpSession session) {
		
		if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null) {
			if(!MapUtils.isEmpty(((Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)).getBoleto())) session.setAttribute("LottoCarTinka",1);
			else session.setAttribute("LottoCarTinka",0);
		} else session.setAttribute("LottoCarTinka",0);
		
		if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion8)!=null) {
			if(!MapUtils.isEmpty(((Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion8)).getBoleto())) session.setAttribute("LottoCarTinka8",1);
			else session.setAttribute("LottoCarTinka8",0);
		} else session.setAttribute("LottoCarTinka8",0);
		
		if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion24)!=null) {
			if(!MapUtils.isEmpty(((Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion24)).getBoleto())) session.setAttribute("LottoCarTinka24",1);
			else session.setAttribute("LottoCarTinka24",0);
		} else session.setAttribute("LottoCarTinka24",0);
		
		if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion48)!=null) {
			if(!MapUtils.isEmpty(((Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion48)).getBoleto())) session.setAttribute("LottoCarTinka48",1);
			else session.setAttribute("LottoCarTinka48",0);
		} else session.setAttribute("LottoCarTinka48",0);
		
		if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion96)!=null) {
			if(!MapUtils.isEmpty(((Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaSuscripcion96)).getBoleto())) session.setAttribute("LottoCarTinka96",1);
			else session.setAttribute("LottoCarTinka96",0);
		} else session.setAttribute("LottoCarTinka96",0);
		/*
		if (MapUtils.isEmpty((Map) session.getAttribute("gameKabalaB"))) {
			session.setAttribute("LottoCarKabala",0);
		} else {
			session.setAttribute("LottoCarKabala",1);	
		}*/
		if(session.getAttribute(Constantes.BoletoKabala.boletoKabalaRegular)!=null) {
			if(!MapUtils.isEmpty(((Kabala) session.getAttribute(Constantes.BoletoKabala.boletoKabalaRegular)).getBoleto())) session.setAttribute("LottoCarKabala",1);
			else session.setAttribute("LottoCarKabala",0);
		} else session.setAttribute("LottoCarKabala",0);

		if(session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion12)!=null) {
			if(!MapUtils.isEmpty(((Kabala) session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion12)).getBoleto())) session.setAttribute("LottoCarKabala12",1);
			else session.setAttribute("LottoCarKabala12",0);
		} else session.setAttribute("LottoCarKabala12",0);

		if(session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion36)!=null) {
			if(!MapUtils.isEmpty(((Kabala) session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion36)).getBoleto())) session.setAttribute("LottoCarKabala36",1);
			else session.setAttribute("LottoCarKabala36",0);
		} else session.setAttribute("LottoCarKabala36",0);

		if(session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion72)!=null) {
			if(!MapUtils.isEmpty(((Kabala) session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion72)).getBoleto())) session.setAttribute("LottoCarKabala72",1);
			else session.setAttribute("LottoCarKabala72",0);
		} else session.setAttribute("LottoCarKabala72",0);
		
		if(session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion144)!=null) {
			if(!MapUtils.isEmpty(((Kabala) session.getAttribute(Constantes.BoletoKabala.boletoKabalaSuscripcion144)).getBoleto())) session.setAttribute("LottoCarKabala144",1);
			else session.setAttribute("LottoCarKabala144",0);
		} else session.setAttribute("LottoCarKabala144",0);
		/*
		if (MapUtils.isEmpty((Map) session.getAttribute("gameGanadiarioBoleto"))) {
			session.setAttribute("LottoCarGanadiario",0);
		} else {
			session.setAttribute("LottoCarGanadiario",1);	
		}*/
		if(session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioRegular)!=null) {
			if(!MapUtils.isEmpty(((Ganadiario) session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioRegular)).getBoleto())) session.setAttribute("LottoCarGanadiario",1);
			else session.setAttribute("LottoCarGanadiario",0);
		} else session.setAttribute("LottoCarGanadiario",0);
		
		if(session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30)!=null) {
			if(!MapUtils.isEmpty(((Ganadiario) session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30)).getBoleto())) session.setAttribute("LottoCarGanadiario30",1);
			else session.setAttribute("LottoCarGanadiario30",0);
		} else session.setAttribute("LottoCarGanadiario30",0);
		
		if(session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90)!=null) {
			if(!MapUtils.isEmpty(((Ganadiario) session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90)).getBoleto())) session.setAttribute("LottoCarGanadiario90",1);
			else session.setAttribute("LottoCarGanadiario90",0);
		} else session.setAttribute("LottoCarGanadiario90",0);
		
		if(session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180)!=null) {
			if(!MapUtils.isEmpty(((Ganadiario) session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180)).getBoleto())) session.setAttribute("LottoCarGanadiario180",1);
			else session.setAttribute("LottoCarGanadiario180",0);
		} else session.setAttribute("LottoCarGanadiario180",0);
		
		if(session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365)!=null) {
			if(!MapUtils.isEmpty(((Ganadiario) session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365)).getBoleto())) session.setAttribute("LottoCarGanadiario365",1);
			else session.setAttribute("LottoCarGanadiario365",0);
		} else session.setAttribute("LottoCarGanadiario365",0);
		
		if (MapUtils.isEmpty((Map) session.getAttribute("gameGanagolBoleto"))) {
			session.setAttribute("LottoCarGanagol",0);
			session.setAttribute("ganagolJugadas", 288);
		} else {
			session.setAttribute("LottoCarGanagol",1);	
		}
		
		if (session.getAttribute("gameKinelo")==null || !(Boolean)session.getAttribute("gameKinelo")) {
			session.setAttribute("LottoCarKinelo",0);
		} else {
			session.setAttribute("LottoCarKinelo",1);	
		}
		
		int itemShop = 	Integer.parseInt(session.getAttribute("LottoCarTinka").toString())+
						Integer.parseInt(session.getAttribute("LottoCarTinka8").toString())+
						Integer.parseInt(session.getAttribute("LottoCarTinka24").toString())+
						Integer.parseInt(session.getAttribute("LottoCarTinka48").toString())+
						Integer.parseInt(session.getAttribute("LottoCarTinka96").toString())+
						Integer.parseInt(session.getAttribute("LottoCarGanagol").toString())+
						Integer.parseInt(session.getAttribute("LottoCarKabala").toString())+
						Integer.parseInt(session.getAttribute("LottoCarKabala12").toString())+
						Integer.parseInt(session.getAttribute("LottoCarKabala36").toString())+
						Integer.parseInt(session.getAttribute("LottoCarKabala72").toString())+
						Integer.parseInt(session.getAttribute("LottoCarKabala144").toString())+
						Integer.parseInt(session.getAttribute("LottoCarGanadiario").toString())+
						Integer.parseInt(session.getAttribute("LottoCarGanadiario30").toString())+
						Integer.parseInt(session.getAttribute("LottoCarGanadiario90").toString())+
						Integer.parseInt(session.getAttribute("LottoCarGanadiario180").toString())+
						Integer.parseInt(session.getAttribute("LottoCarGanadiario365").toString())+
						Integer.parseInt(session.getAttribute("LottoCarKinelo").toString());
		
		session.setAttribute("LottoCar",itemShop);
	
		return 0;
	}
	
	public String generatePassword(int length) {
		Random generator = new Random();
		String[][] letter = {{"a", "e", "i", "o", "u"},
				{"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"},
				{"br", "ch", "cr", "fr", "gr", "pr", "pl", "tr"}, {"lt", "lm", "ln", "ls", "mn", "st", "sm"}};
		int first = generator.nextInt(3);
		int component = generator.nextInt(letter[first].length);
		String password = letter[first][component];
		boolean cons = false;
		if(first != 0) cons = true;
		while (password.length() < length) {
			if(cons) {
				int index = generator.nextInt(5);
				password = password + letter[0][index];
				cons = false;
			} else {
				int[] prob = {1, 1, 1, 2, 3};
				int index = generator.nextInt(prob.length);
				int element = generator.nextInt(letter[prob[index]].length);
				password = password + letter[prob[index]][element];
				cons = !(cons);
			}
		}
		return password.substring(0, length);
	}
	
	
	public int updateBalanceSession(HttpSession p_session, ClientProcedureAccountData p_accountData, int gameId, String gameName) {
		try {
			p_session.setAttribute("saldo", formatCurrency(p_accountData.getBalanceAmount()));
		} catch (Exception e) {
			p_session.setAttribute("saldo", formatCurrency(0.00));
		}
		
		try {
			p_session.setAttribute("promo", p_accountData.getPromo().trim());
		} catch (Exception e) {
			p_session.setAttribute("promo", "");
		}
		
		try {
			p_session.setAttribute("promoDescription", p_accountData.getPromoDescription().trim());
		} catch (Exception e) {
			p_session.setAttribute("promoDescription", "");
		}
		
		try {
			p_session.setAttribute("promoMessage", p_accountData.getPromoMessage().trim());
		} catch (Exception e) {
			p_session.setAttribute("promoMessage", "");
		}
		
		try {
			p_session.setAttribute("promoDraw", p_accountData.getPromoDraw().trim());
		} catch (Exception e) {
			p_session.setAttribute("promoDraw", "");
		}
		
		try {
			p_session.setAttribute("promoCount", p_accountData.getPromoCount());
		} catch (Exception e) {
			p_session.setAttribute("promoCount", 0);
		}
		
		try {
			p_session.setAttribute("welcomeBonusStatus", p_accountData.getWelcomeBonusStatus()!=null?p_accountData.getWelcomeBonusStatus().trim():"");
			p_session.setAttribute("welcomeBonusPercentaje", p_accountData.getWelcomeBonusPercentaje()!=null?p_accountData.getWelcomeBonusPercentaje().trim():"");
			p_session.setAttribute("welcomeBonusMessage", p_accountData.getWelcomeBonusMessage()!=null?p_accountData.getWelcomeBonusMessage().trim():"");
			p_session.setAttribute("welcomeBonusLastDate", p_accountData.getWelcomeBonusLastDate()!=null?p_accountData.getWelcomeBonusLastDate().trim():"");
			p_session.setAttribute("welcomeBonusMessagePor", p_accountData.getWelcomeBonusMessagePor()!=null?p_accountData.getWelcomeBonusMessagePor().trim():"");
			p_session.setAttribute("welcomeBonusStepAmount", p_accountData.getWbStepAmount()!=null?p_accountData.getWbStepAmount().trim():"");
		} catch (Exception e) {
			p_session.setAttribute("welcomeBonusStatus", "");
			p_session.setAttribute("welcomeBonusPercentaje", "");
			p_session.setAttribute("welcomeBonusMessage", "");
			p_session.setAttribute("welcomeBonusLastDate", "");
			p_session.setAttribute("welcomeBonusMessagePor", "");
			p_session.setAttribute("welcomeBonusStepAmount", "");
		}
			
		try {
    		p_session.setAttribute("bonoTeApuesto", formatCurrency(Double.parseDouble(p_accountData.getBonusAmount().replaceAll(",","."))));
    	} catch (Exception e) {
    		p_session.setAttribute("bonoTeApuesto", formatCurrency(0.00));
		}
    	
    	try {
    		p_session.setAttribute("bonoLimit", formatCurrency(Double.parseDouble(p_accountData.getBonusLimit())));
    	} catch (Exception e) {
    		p_session.setAttribute("bonoLimit", formatCurrency(0.00));
		}
    	
    	try {
    		p_session.setAttribute("bonoForPlay", formatCurrency(Double.parseDouble(p_accountData.getBonusForPlay())));
    	} catch (Exception e) {
    		p_session.setAttribute("bonoForPlay", formatCurrency(0.00));
		}
    	
    	try {
    		p_session.setAttribute("bonusChannel", p_accountData.getBonusChannel());
    		p_session.setAttribute("bonusPercentage", p_accountData.getBonusPercentage());
    		p_session.setAttribute("stepAmount",p_accountData.getStepAmount());
		} catch (Exception e) {
			p_session.setAttribute("bonusChannel", "");
			p_session.setAttribute("bonusPercentage", "");
			p_session.setAttribute("stepAmount", "");
		}
    	
    	if(StringUtils.isNotEmpty(p_accountData.getBonusAmount())) {
	    	p_session.setAttribute("bonoStatus", p_accountData.getBonusStatus().trim());
	    	String splitBonusMessage[] = p_accountData.getBonusMessage().split("__");
	    	p_session.setAttribute("bonoPorcentaje", p_accountData.getBonusPercentage());
	    	try {
	    		p_session.setAttribute("bonoMensaje",splitBonusMessage[0].trim());
	        	p_session.setAttribute("bonoMensajePor",splitBonusMessage[1].trim());
			} catch (Exception e) {
	        	p_session.setAttribute("bonoMensajePor","");
			}
	    	p_session.setAttribute("bonoDate", p_accountData.getBonusDate());
	    	p_session.setAttribute("bonoClientStatus", p_accountData.getBonusClientStatus());
	    	
	    	p_session.setAttribute("bonoLastDate", p_accountData.getBonusLastDate());
	    	p_session.setAttribute("bonoMinOdd", p_accountData.getMinOdd());
    	
        	if(StringUtils.isNotEmpty(p_accountData.getBonusAddedBalance()) && StringUtils.isNotBlank(p_accountData.getBonusAddedBalance())) {
        		p_session.setAttribute("bonoAddedBalance", formatCurrency(Double.parseDouble(p_accountData.getBonusAddedBalance().replaceAll(",","."))));
        	} else {
        		p_session.setAttribute("bonoAddedBalance", formatCurrency(0.00));
        	}
    	}
    	
    	try {
    		p_session.setAttribute("bonoOtro", p_accountData.getOtherQuantity());
    	} catch (Exception e) {
    		p_session.setAttribute("bonoOtro", 0);
		}
    	
    	try {
    		p_session.setAttribute("bonoOtroFecha", p_accountData.getOtherExpire());
    		p_session.setAttribute("bonoOtroFechaFormat", p_accountData.getOtherExpireFormat());
    	} catch (Exception e) {
    		p_session.setAttribute("bonoOtroFecha", "");
    		p_session.setAttribute("bonoOtroFechaFormat", "");
		}
        int gameid = 0;
    	if(StringUtils.isNotEmpty(p_accountData.getBonusGameMobile())) {
    		String[] arrBonusGame = p_accountData.getBonusGameMobile().trim().split("\\|");
    		if(arrBonusGame.length>0 && !arrBonusGame[0].equals("")) {
	    		for (int i=0; i<arrBonusGame.length; i++) {
	    			String[] arrBonus = arrBonusGame[i].trim().split("_");
	    			if(i==0) {
	    				if(gameId==0&&arrBonus.length>1) {
		            		gameid = (arrBonus[0]!=null&&!arrBonus[0].trim().equals(""))?Integer.parseInt(arrBonus[0].trim()):0;
		            	} else {
		            		gameid = gameId;
		            	}
		    		}
	    		}
    		}
    	}
    	return gameid;
	}
	
	public List<BonoOtroJuego> bonoOtroJuegoHeader(String accountData,String  cadenaJunta){
		LoggerApi.Log.info("accountData "+accountData); 
		List<BonoOtroJuego> headers = new ArrayList<BonoOtroJuego>();
		if(StringUtils.isNotEmpty(accountData)) {
			String[] arrBonusGame = accountData.trim().split("\\|");			
		   String[] arrCadenaJun=cadenaJunta.trim().split(",");
			LoggerApi.Log.info("arrBonusGame "+arrBonusGame); 			
			if(arrBonusGame.length>0 && !arrBonusGame[0].equals("")) {				
				for (int i=0; i<arrBonusGame.length; i++) {
					String[] arrBonus = arrBonusGame[i].trim().split("_");
					String[] arrBonus2=new String[100];
					if(arrCadenaJun.length>0) {
						arrBonus2 = arrCadenaJun[i].trim().split("_");
					}
					else {
						arrBonus2[1]="0";	
					}
					LoggerApi.Log.info("arrBonus "+arrBonus); 
					BonoOtroJuego bono = new BonoOtroJuego();
					bono.setIdGame(Integer.parseInt(arrBonus[0]));
					bono.setNameGame(arrBonus[1]);
					bono.setGames(Integer.parseInt(arrBonus[2]));					
					bono.setCantidadDetalle(Integer.parseInt(arrBonus2[1]));
					bono.setExpireDate(arrBonus[4]);
					bono.setUnitPriceBonus(arrBonus[5]);
                    //ruth validacion para dshabilitar si no hay detalle y jugadas son cero  
					if(bono.getGames()==0 && bono.getCantidadDetalle()==0) {						
						//bono.setVisible("pointer-events: none;cursor: default;background:#B4B4B4;color:#9D9C9C;");	
						bono.setVisible("display: none");
					}else {
						bono.setVisible("");						
					}
					headers.add(bono);
				}	
			}	
		}				
		return headers;		
	}
	
	public static boolean verifySintaxMail(String pMail1) {
    	if(StringUtils.isNotEmpty(pMail1)) {
        	String EMAIL_PATTERN =
        			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        	Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        	Matcher matcher  = pattern.matcher(pMail1);
        	
        	return matcher.matches();	
        }
    	
    	return false;
    }
	
	public static boolean verifySintaxMobilePhone(String pMobilePhone) {
		
        if (pMobilePhone==null || pMobilePhone.equals("")) {
            return false;
        }

    	if(StringUtils.isNotEmpty(pMobilePhone)) {
        	String PHONE_PATTERN =
        			"^9\\d{8}";
        	Pattern pattern = Pattern.compile(PHONE_PATTERN);
        	Matcher matcher  = pattern.matcher(pMobilePhone);
        	
        	return matcher.matches();
        } else {
        	return true;
        }
    }
	
	public static boolean verifySintaxSmsCode(String pSmsCode, String pSize) {
    	if(StringUtils.isNotEmpty(pSmsCode)) {
        	String SMS_CODE_PATTERN =
        			"\\d{"+pSize+"}";
        	Pattern pattern = Pattern.compile(SMS_CODE_PATTERN);
        	Matcher matcher  = pattern.matcher(pSmsCode);
        	
        	return matcher.matches();
        }
    	
    	return false;
    }
	
	public String validarString(String cadena) {
		  if (StringUtils.isNotEmpty(cadena)) return cadena;
		  else return "";
	}
	
	public boolean validateDateFormat(String pBirthDate) {
		boolean flagdate = true;
		if (StringUtils.isNotEmpty(pBirthDate)) {
            
            String fecha = pBirthDate;
            fecha = fecha.replace('/', '-');
            
            int ruta = 0, r = 0, tramo = 0;
            for (int x = 0; x < fecha.length(); x++) {
                
                if (fecha.charAt(x) != '-')
                    ruta++;
                if (fecha.charAt(x) == '-') {
                    tramo++;
                    if (tramo == 1)
                        r = ruta;
                }
            }
            if (r == 4) {
                try {
                    Date fechas = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);   
                    pBirthDate = new SimpleDateFormat("dd/MM/yyyy").format(fechas);
                  
                } catch (Exception ex) {
                	
                    flagdate = false;
                    
                }
            } else if (r == 2) {
                try {
                    Date fechas = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
                    
                    pBirthDate = new SimpleDateFormat("dd/MM/yyyy").format(fechas);
                  
                } catch (Exception ex) {
                
                    flagdate = false;
                    
                }
            } else {
            	
                flagdate = false;
              
            }
           
        }
		
		return flagdate;
	}
	
	public String formatDateDDMMYYYY(String date) {
		String fecha = date;
        fecha = fecha.replace('/', '-');
		
        Date fechas;
		try {
			fechas = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
			 date = new SimpleDateFormat("dd/MM/yyyy").format(fechas);
		} catch (ParseException e) {}   
		
		return date;
	}
	
   public TinkaSale getdata(TinkaSale domain) {
	   if(domain.getPrize()!=null) {domain.setPozo(formatCurrency(domain.getPrize())); };
	   domain.setRegularCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()));
	   domain.setFirstCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()*(100-domain.getFirstDiscount())/100));
	   domain.setSecondCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()*(100-domain.getSecondDiscont())/100));
	   domain.setThirdCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()*(100-domain.getThirdDiscount())/100));
	   domain.setFourthCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()*(100-domain.getFourthDiscount())/100));
	   domain.setLastResult(domain.getLastResult().replace(" ", " - ")+" Boliyapa: "+domain.getLastYapa());
	   if(domain.getLastSiosi()!=null)domain.setLastSiosi(domain.getLastSiosi().replace(" ", " - "));
	  
	   return domain;
   }
   
   public KabalaSale getdataKB(KabalaSale domain) {
	   domain.setPozo(domain.getPrize());
	   domain.setRegularCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()));
	   domain.setFirstCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getFirstDiscount())/100));
	   domain.setSecondCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getSecondDiscont())/100));
	   domain.setThirdCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getThirdDiscount())/100));
	   domain.setFourthCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getFourthDiscount())/100));	   
	   domain.setLastResult(domain.getLastResult().replace(" ", " - ")+" Boliyapa: "+domain.getLastYapa());
	  
	   return domain;
   }
   
   public GanadiarioSale getdataGD(GanadiarioSale domain) {
	   domain.setPozo(domain.getPrize());
	   domain.setRegularCost(formatCurrencyOneDecimal(domain.getSimpleBetPrice()));
	   domain.setFirstCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getFirstDiscount())/100));
	   domain.setSecondCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getSecondDiscont())/100));
	   domain.setThirdCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getThirdDiscount())/100));
	   domain.setFourthCost(formatCurrency(domain.getSimpleBetPrice()*(100-domain.getFourthDiscount())/100));	   
	   domain.setLastResult(domain.getLastResult().replace(" ", " - ")+" Boliyapa: "+domain.getLastYapa());
	  
	   return domain;
   }
   
   public  void updateClientBalance(HttpSession session,ClientBalanceBo beanClientBalanceBo) throws Exception {
	   Integer clientId = 0;
	   try {
		   clientId = (session!=null && session.getAttribute(Constantes.USR_SESION)!=null && !(session.getAttribute(Constantes.USR_SESION).toString().trim()).equals(""))?((ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION)).getClientId():0;//(session.getAttribute(Constantes.USR_SESION)!=null)?(ClientProcedureGetLoginDatasession.getAttribute(Constantes.USR_SESION)).getClientId():0;
	   } catch(Exception e) {
		   clientId = 0;
	   }
	   	if (clientId!=0) {
	   		ClientProcedureAccountData clientProcedureAccountData = beanClientBalanceBo.findAccountData(clientId);
	   		clientProcedureAccountData = verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
	   		if (clientProcedureAccountData!=null) {
	   			updateBalanceSession(session,clientProcedureAccountData,0,"");
	   		}
	   	}
   }
   
   public ClientProcedureAccountData verifiedTestUsersWelcomeBonus(ClientProcedureAccountData accountData, HttpSession session) {
	String clientId = "";
	try {
		clientId = (session!=null && session.getAttribute(Constantes.USR_SESION)!=null && !(session.getAttribute(Constantes.USR_SESION).toString().trim()).equals(""))?((ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION)).getClientId().toString():"";
	} catch(Exception e) {
		clientId = "";
	}
   	if(Constantes.welcameBonusUsers.equals("ALL-ALLOWED") || (clientId!=null && !clientId.trim().equals("") && Constantes.welcameBonusUsers.contains(clientId))) {
   		accountData.setWelcomeBonusLastDate(accountData.getWelcomeBonusLastDate().trim());
		accountData.setWelcomeBonusMessage(accountData.getWelcomeBonusMessage().trim());
		accountData.setWelcomeBonusPercentaje(accountData.getWelcomeBonusPercentaje().trim());
		accountData.setWelcomeBonusStatus(accountData.getWelcomeBonusStatus().trim());
		//if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Reciente"))
		if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Reciente")) accountData.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+accountData.getWelcomeBonusPercentaje().toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"CONTINUAR\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
     	else accountData.setWelcomeBonusMessagePor("");
   		return accountData;
   	} else {
   		accountData.setWelcomeBonusLastDate("");
   		accountData.setWelcomeBonusMessage("");
   		accountData.setWelcomeBonusPercentaje("");
   		accountData.setWelcomeBonusStatus("");
   		return accountData;
   	}
   }
   
   public ClientProcedureAccountData verifiedTestUsersWelcomeBonusRT(ClientProcedureAccountData accountData, ClientProcedureTokenValidation tokenValidation) {
		String clientId = "";
		try {
//			clientId = (session!=null && session.getAttribute(Constantes.USR_SESION)!=null && !(session.getAttribute(Constantes.USR_SESION).toString().trim()).equals(""))?((ClientProcedureLogin)session.getAttribute(Constantes.USR_SESION)).getClientId().toString():"";
			clientId= tokenValidation.getClientId();
		} catch(Exception e) {
			clientId = "";
		}
	   	if(Constantes.welcameBonusUsers.equals("ALL-ALLOWED") || (clientId!=null && !clientId.trim().equals("") && Constantes.welcameBonusUsers.contains(clientId))) {
	   		accountData.setWelcomeBonusLastDate(accountData.getWelcomeBonusLastDate().trim());
			accountData.setWelcomeBonusMessage(accountData.getWelcomeBonusMessage().trim());
			accountData.setWelcomeBonusPercentaje(accountData.getWelcomeBonusPercentaje().trim());
			accountData.setWelcomeBonusStatus(accountData.getWelcomeBonusStatus().trim());
			//if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Reciente"))
			if(accountData.getWelcomeBonusStatus()!=null && accountData.getWelcomeBonusStatus().toString().trim().equals("Reciente")) accountData.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+accountData.getWelcomeBonusPercentaje().toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"CONTINUAR\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
	     	else accountData.setWelcomeBonusMessagePor("");
	   		return accountData;
	   	} else {
	   		accountData.setWelcomeBonusLastDate("");
	   		accountData.setWelcomeBonusMessage("");
	   		accountData.setWelcomeBonusPercentaje("");
	   		accountData.setWelcomeBonusStatus("");
	   		return accountData;
	   	}
   }
   
   public  void updateClientBalanceRT(ClientProcedureTokenValidation tokenValidation,ClientBalanceBo beanClientBalanceBo) throws Exception {
	   Integer clientId = 0;
	   try {
		   clientId = Integer.parseInt(tokenValidation.getClientId());
	   } catch(Exception e) {
		   clientId = 0;
	   }
	   	if (clientId!=0) {
	   		ClientProcedureAccountData clientProcedureAccountData = beanClientBalanceBo.findAccountData(clientId);
	   		clientProcedureAccountData = verifiedTestUsersWelcomeBonusRT(clientProcedureAccountData, tokenValidation);
//	   		if (clientProcedureAccountData!=null) {
//	   			updateBalanceSession(session,clientProcedureAccountData,0,"");
//	   		}
	   	}
   }
   
   public static String verifyPersonalInformation(String documentType, String document, String name, String lastname)
			throws Exception {

		// ------------ VERIFICACION DE TIPO DE DOCUMENTO
		if ((documentType==null || documentType.equals("")) || (!documentType.equals("DNI") && !documentType.equals("PASAP") && !documentType.equals("CAREX"))) {
			return "El tipo de documento ingresado es invalido";
		}
		// ------------ VERIFICACION DE DOCUMENTO
		if (documentType.equals("DNI")) {
			String expRegDocument = "^\\d{8}$";
			Boolean verifyDocument = new RegexValidator(expRegDocument).isValid(document);
			if(!verifyDocument) {
				return "El documento debe tener 8 caracteres numericos";
			}
		}
		if (documentType.equals("PASAP") || documentType.equals("CAREX")) {
			String expRegDocument = "^[a-zA-Z0-9]{9,12}$";
			Boolean verifyDocument = new RegexValidator(expRegDocument).isValid(document);
			if(!verifyDocument) {
				return "El documento debe tener mas de 8 caracteres y menos de 13 caracteres alfanumericos";
			}
		}
		// ------------ VERIFICACION DE NOMBRES
		String expRegName ="^[a-zA-Z\\sáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ]+{1,74}$";
		Boolean verifyName = new RegexValidator(expRegName).isValid(name.trim());
		if(!verifyName) {
			return "Los nombres ingresado son invalidos";
		}
		// ------------ VERIFICACION DE TIPO APELLIDOS
		verifyName = new RegexValidator(expRegName).isValid(lastname.trim());
		if(!verifyName) {
			return "Los apellidos ingresado son invalidos";
		}
       
       return "OK";
   }
   
   public static String verifyContactInformation(String nacionalidad, String domicilio, String departamento, String provincia, String distrito) {		
		String expRegAddress = "[a-zA-Z0-9°#.,\\sáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ-]+";
		String expRegCode = "\\d{2}";
		String expCouCode = "^[A-Z]{2}$";
		//validar nacionalidad
		Boolean verifyCountry = new RegexValidator(expCouCode).isValid(nacionalidad);        
        if (!verifyCountry) {
            return "Seleccionar una nacionalidad correcta";       
        }
		 //validar domicilio
       if(domicilio.length()>70) {           
           return "La direcci&oacute;n debe tener menos de 70 caracteres";        	
       }else {
       	Boolean verifyAddress = new RegexValidator(expRegAddress).isValid(domicilio.trim());        
           if (!verifyAddress) { 
               return "Ingresar una direcci&oacute;n correcta"; 
           }
       }
       Boolean verifyDepartamento = new RegexValidator(expRegCode).isValid(departamento);        
       if (!verifyDepartamento) {
           return "Seleccionar un departamento correcto";       
       }
      //validar provincia        
       Boolean verifyProvincia = new RegexValidator(expRegCode).isValid(provincia);        
       if (!verifyProvincia) {
           return "Seleccionar una provincia correcta";
       }
       //validar distrito        
       Boolean verifyDistrito = new RegexValidator(expRegCode).isValid(distrito);        
       if (!verifyDistrito) {
           return "Seleccionar un distrito correcto";           
       }
		return "OK";
	}
   
   public String verifyPasswordRegisterClient(String pPassword,String pNombre, String pApPaterno, String pNumberId, String pBirthDate, String pMobilePhone) throws Exception {
		String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
		//validar mayusculas y minusculas
		// Expresión regular para validar que la contraseña tenga al menos una letra mayúscula y una letra minúscula
       String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(pPassword);
       if (!matcher.matches()) {
       	return message;
       }         
		
		//validar nombres
		//quitar extraños
		pNombre=normalizarTexto(pNombre);
		//upper
		pPassword=pPassword.toUpperCase();
		pNombre=pNombre.toUpperCase();
		//separar
		String snombre[]=pNombre.split(" ");
		//lista blanca
		String[] list = {"EL","LA","LOS","LAS","DE","DEL","Y","O"};
		for (String sn:snombre) {
			boolean white=false;
			for(String li:list){
				if(sn.equals(li)) {
					white=true;
					break;
				}
			}
			if(white)
				continue;
			
			if(pPassword.contains(sn)) {
				return message;
			}
		}
				
		//validar apellidos
		//quitar extraños
		pApPaterno=normalizarTexto(pApPaterno);
		//upper
		pApPaterno=pApPaterno.toUpperCase();
		//separar
		String sapellidos[]=pApPaterno.split(" ");
		for (String sn:sapellidos) {
			boolean white=false;
			for(String li:list){
				if(sn.equals(li)) {
					white=true;
					break;
				}
			}
			if(white)
				continue;
			
			if(pPassword.contains(sn)) {
				return message;
			}
		}
		
		//validar document
		if(pPassword.contains(pNumberId)) {
			return message;
		}
		
		//validar birthdate
		//ddmmyyyy
		String pBirthDate1=pBirthDate.replaceAll("/", "");
		if(pPassword.contains(pBirthDate1)) {
			return message;
		}
		//yyyy
		String spBirthDate[]=pBirthDate.split("/");
		String pBirthDate2=spBirthDate[2];
		if(pPassword.contains(pBirthDate2)) {
			return message;
		}
		//yyyymmdd
		String pBirthDate3=spBirthDate[2]+spBirthDate[1]+spBirthDate[0];		
		if(pPassword.contains(pBirthDate3)) {
			return message;
		}
		
		//validar mobilephone
		if(pPassword.contains(pMobilePhone)) {
			return message;
		}
				
		return "OK";
	}
	
	public static String normalizarTexto(String cadena) {
       String cadenaNormalizada = Normalizer.normalize(cadena, Normalizer.Form.NFD);
       return cadenaNormalizada.replaceAll("[^\\p{ASCII}ñÑ]", "");
   }
	
	public String verifyPasswordChangePassword(String pPassword,String pNombre, String pApPaterno, String pNumberId, String pBirthDate, String pMobilePhone) throws Exception {
		String message="Esta contrase&ntilde;a debe tener al menos 8 caracteres, incluir may&uacute;sculas, min&uacute;sculas, n&uacute;meros y s&iacute;mbolos ($%&+!@), y ser diferente de las &uacute;ltimas 6 contrase&ntilde;as que hayas usado.";
		//validar mayusculas y minusculas
		// Expresión regular para validar que la contraseña tenga al menos una letra mayúscula y una letra minúscula
        String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pPassword);
        if (!matcher.matches()) {
        	return message;
        }   
        
        //lista blanca
		String[] list = {"EL","LA","LOS","LAS","DE","DEL","Y","O"};
		
		//validar nombres		
        if(!pNombre.equals("")) {
        	//quitar extraños
        	pNombre=normalizarTexto(pNombre);
    		//upper
    		pPassword=pPassword.toUpperCase();
    		pNombre=pNombre.toUpperCase();
    		//separar
    		String snombre[]=pNombre.split(" ");    		
    		for (String sn:snombre) {
    			boolean white=false;
    			for(String li:list){
    				if(sn.equals(li)) {
    					white=true;
    					break;
    				}
    			}
    			if(white)
    				continue;
    			
    			if(pPassword.contains(sn)) {
    				return message;
    			}
    		}
        }
		
				
		//validar apellidos
        if(!pApPaterno.equals("")) {
        	//quitar extraños
    		pApPaterno=normalizarTexto(pApPaterno);
    		//upper
    		pApPaterno=pApPaterno.toUpperCase();
    		//separar
    		String sapellidos[]=pApPaterno.split(" ");
    		for (String sn:sapellidos) {
    			boolean white=false;
    			for(String li:list){
    				if(sn.equals(li)) {
    					white=true;
    					break;
    				}
    			}
    			if(white)
    				continue;
    			
    			if(pPassword.contains(sn)) {
    				return message;
    			}
    		}
        }
		
		
		//validar document
		if(!pNumberId.equals("") && pPassword.contains(pNumberId)) {
			return message;
		}
		
		//validar birthdate
		if(!pBirthDate.equals("")) {
			//ddmmyyyy
			String pBirthDate1=pBirthDate.replaceAll("/", "");
			if(pPassword.contains(pBirthDate1)) {
				return message;
			}
			//yyyy
			String spBirthDate[]=pBirthDate.split("/");
			String pBirthDate2=spBirthDate[2];
			if(pPassword.contains(pBirthDate2)) {
				return message;
			}
			//yyyymmdd
			String pBirthDate3=spBirthDate[2]+spBirthDate[1]+spBirthDate[0];		
			if(pPassword.contains(pBirthDate3)) {
				return message;
			}
		}
		
		
		//validar mobilephone
		if(!pMobilePhone.equals("") && pPassword.contains(pMobilePhone)) {
			return message;
		}
				
		return "OK";
	}
	
}
