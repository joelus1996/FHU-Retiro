package pe.com.intralot.loto.layer.controller.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.boimpl.ClientSaleBoImpl;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;
 
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
public class AdvaisPage {

	
    @RequestMapping(value = "/advais_page_post")
    protected void doPagePost(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
        PrintWriter out = null;
        out = response.getWriter(); 
        Object[] outCadenas;
        String clientId = request.getParameter("clientId");
        String sessionId = request.getParameter("sessionId");
        String posAmount = request.getParameter("posAmount");
        String bono = request.getParameter("activ-bono");
        String wbbono = request.getParameter("activ-wbbono");
        String bonokey = "";//((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":"");
        
        HttpSession session = request.getSession();
        
        /*String bonoBienvenida = ClientUtils.verifiedWelcomeBonus(session);

        if (StringUtils.isNotEmpty(bonoBienvenida)) {
        	bonokey = bonoBienvenida;
        } else {
        	bonokey = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":"");
        }*/
        bonokey = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]:"")));
        
        LoggerAPI.info("/advais_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
        try {         
        	Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " sessionId=" + sessionId + " posAmount=" + posAmount+" advais_page_post");
            if (clientId == null || clientId.equals("") ||  
                	posAmount == null || posAmount.equals("")  ) { 
                    out.print("");
                    return;
                }
            outCadenas = AccountController.defineTransactionAdvais(clientId, sessionId, 0, Double.parseDouble(posAmount), 0, 0, 0, bonokey);
            String advaisTransaction = (String)outCadenas[0];
            String message = (String)outCadenas[2];
            
            boolean advaisEncrypted = Boolean.valueOf(ConnectionFactory.operationProperty("advaisEncrypted", Constants.contextSale).trim()).booleanValue();

            String output = advaisTransaction;
            if (advaisEncrypted==true) {
                output = getRSA(advaisTransaction);
            }
            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " advaisTransaction=" + advaisTransaction+" advaisEncrypted="+advaisEncrypted+" output="+output);
            
            out.print(output+"|||"+message);
             
        } catch (Exception e) {
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
            out.print("");
        } finally {
        	ClientSaleBo clientSaleBo =  new ClientSaleBoImpl();
        	try { ClientUtils.updateClientBalance(session, clientSaleBo);} catch (Exception e) {}
        }
    } 

    public static String getRSA(String input) throws Exception {
    	String resultado = null;
    	try {

            BASE64Decoder b64dec = new BASE64Decoder();
            BASE64Encoder b64enc = new BASE64Encoder();

            String key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbPlWOw4G7EOFiHbYo//X2q/uaOEksLfNN/0UVGFGofsr1Mk0gg3ygJtSJNBXGWvI2PXV/mjqsg0cD8RLnDhbv5gJXo1I67Uq0kTIuNcr2CPrqgLkBt2ED7MUPWCC+bHyCSsw7fdx4kaYrffFl+Ox6PfT6onSjdyeS6LZlZqyjUQIDAQAB";
    		AsymmetricKeyParameter publicKey = (AsymmetricKeyParameter) PublicKeyFactory.createKey(b64dec.decodeBuffer(key));
            
	    	AsymmetricBlockCipher e = new RSAEngine();
	    	e = new org.bouncycastle.crypto.encodings.PKCS1Encoding(e);
	    	e.init(true, publicKey);
	    	//String input = "Mensaje de Prueba";
	
	    	byte[] inputBytes = input.getBytes();
	    	byte[] cipheredBytes = e.processBlock(inputBytes, 0, input.length());

            resultado = b64enc.encode(cipheredBytes);

    	} catch (Exception e) {

    	}

        return URLEncoder.encode(resultado,"UTF-8");
    }
  
    public String query(String url1, String query) {
        Logger.getLogger(LoggerAPI.SALECARD).info("url1=" + url1 + " query=" + query);
        StringBuffer sb = new StringBuffer();
        try {
            // Abrimos la conexion y le pasamos nuestro contexto SSL
            // System.setProperty("https.proxyHost","192.168.100.14");
            // System.setProperty("https.proxyPort","8080");
            URL url = new URL(url1);
            HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
            conexion.setDoOutput(true);
            conexion.setDoInput(true);
            conexion.setUseCaches(false);
            OutputStreamWriter wr = new OutputStreamWriter(conexion.getOutputStream());
            //wr.write("i.do?m=contactenos");
            wr.write(query);
            wr.flush();
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];
            int leido;
            while ((leido = br.read(buffer)) > 0)
                // System.out.println(new String(buffer, 0, leido));
                sb.append(new String(buffer, 0, leido));
        } catch (MalformedURLException e) {
            // e.printStackTrace();
            Logger.getLogger(LoggerAPI.SALECARD).info("La consulta para " + url1 + " es incorrecta");
        } catch (IOException e) {
            // e.printStackTrace();
            Logger.getLogger(LoggerAPI.SALECARD).info("No se puede conectar a " + url1 + "  " + e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(LoggerAPI.SALECARD).info("Error al conectar a " + url1 + " " + e.getMessage());
        }
        return sb.toString();
    }

    @RequestMapping(value = "/advaispayURL")
    protected String safetyPayUrl(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
        return "client/home_user";
    }
    
    public static void main(String [] args) throws Exception {
    	 String o = getRSA("Mensaje de Prueba");
    	 System.out.println("o="+o+"*");
    }
}