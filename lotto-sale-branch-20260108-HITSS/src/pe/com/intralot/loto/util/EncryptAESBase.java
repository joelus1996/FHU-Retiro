package pe.com.intralot.loto.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import java.nio.charset.Charset;
import java.security.spec.KeySpec;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;
import java.security.Security;


/**
 * @author:   Angel Chata
 * @rol:	  Jefe Desarrollo de Sistemas
 * @proyecto: lotto-ws-playerweb
 *
 */
 
@Component
public class EncryptAESBase {
	
    private static final String SECRET_KEY = "aVuJhQt3B2qHzGSro"; 
    private static byte[] SALT = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };
    
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    
    public String encrypt(String prefix, String strToEncrypt) {
        try {
            byte[] iv = new byte[16];
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            byte[] derivedKey = generateDerivedKey(SECRET_KEY, SALT, 65536, 256);
            SecretKeySpec secretKey = new SecretKeySpec(derivedKey, "AES");

            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);

            byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));

            String encryptedString = new String(Base64.encodeBase64(encryptedBytes))
                    .replace("+", ".")
                    .replace("/", "_")
                    .replace("=", "-");

            return prefix + encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] generateDerivedKey(String password, byte[] salt, int iterations, int keyLength)
            throws Exception {
        PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
        generator.init(PKCS5S2ParametersGenerator.PKCS5PasswordToUTF8Bytes(password.toCharArray()), salt, iterations);
        KeyParameter key = (KeyParameter)generator.generateDerivedParameters(keyLength);
        return key.getKey();
    }
    
    public String decrypt(String prefix, String strToDecrypt) throws BadPaddingException {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256", "BC");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT, 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);

            // Verificar y ajustar la cadena strToDecrypt antes de decodificar
            byte[] decodedBytes = Base64.decodeBase64(strToDecrypt.replace(".", "+").replace("_", "/").replace("-", "="));

            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            String decryptedString = new String(decryptedBytes, Charset.forName("UTF-8"));

            return prefix + decryptedString;
        } catch (BadPaddingException e) {
            throw new BadPaddingException("Error de relleno incorrecto al descifrar los datos: " + e.getMessage());
        } catch (Exception e) {
            LoggerApi.Log.info("Error decrypting: " + e.toString());
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) throws BadPaddingException {
   

        String originalString = "NO-9Z9855YR1";
        System.out.println("valor original " + originalString);
        
        EncryptAESBase e = new EncryptAESBase();

		long startTime = System.currentTimeMillis();
        String encryptedString = e.encrypt("",originalString);
        
        
        System.out.println(" valor encryptedString ===== " + encryptedString);
    	System.out.println("Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");

    	//encryptedString = "NJTXxWvUUC5NGoYdFaGjpQ==";
        System.out.println("*********************************************************************");
		long startTime1 = System.currentTimeMillis();
        String original2 = "BHkIpMJMqamBz1RSvJEdmA--";
        String decryptedString = e.decrypt("",original2);
        System.out.println("valor original " + original2);
        System.out.println("valor decryptedString ===== " + decryptedString);  
    	System.out.println("Time="+(System.currentTimeMillis()-startTime1)/1000.0 +" seconds");

      }
    
}

