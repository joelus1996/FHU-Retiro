package pe.com.intralot.loto.util;

import java.io.UnsupportedEncodingException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.jboss.security.Base64Utils;

import pe.com.intralot.loto.sale.lib.LoggerApi;

public class CipherUtils {
    Cipher ecipher;
    Cipher dcipher;

    byte[] salt = {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
    };

    int iterationCount = 19;
	
    public CipherUtils() {
    	String passPhrase = "INTRALOTPERU";
        try {
       
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
             
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (Exception e) {
        	
        } 
    }

    public  String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);

            return new Base64Utils().tob64(enc);//encodeToString(enc);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String decrypt(String str) {
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
        } finally {}
        return null;
    }
    /*public String decrypt(String str) {
        try {
            byte[] dec = new Base64Utils().fromb64(str);//decode(str);
            byte[] utf8 = dcipher.doFinal(dec);
            
            return new String(utf8, "UTF8");
        } catch (Exception e) {
        	
        }
        return null;
    }*/

    public String decodeLabel(String labelEncoded)
    throws Exception
    {
        if (labelEncoded == null) return null;
        String decrypted = decrypt(labelEncoded.replaceAll(" ", "\\+"));
        return decrypted;
    }
}