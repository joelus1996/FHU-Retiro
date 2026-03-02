package pe.com.intralot.loto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.model.bean.SmsResultBean;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import sun.misc.BASE64Encoder;

//@SuppressWarnings({ "deprecation", "unused" })
public class SmsProviderUtils {

    public String generateRandomCode() {
    	
    	int randomCode;
    	int size = Integer.parseInt(ConnectionFactory.operationProperty("smsCodeSize", Constantes.contextSale).toString());
    	LoggerApi.Log.info("/generateRandomCode size="+size);
    	Random randomGenerator = new Random();
    	
    	int base = (int) (Math.pow(10, size-1));
    	randomCode =base + randomGenerator.nextInt(base * 9);
    	LoggerApi.Log.info("/generateRandomCode randomCode="+randomCode);
    	return Integer.toString(randomCode);
    }
     
    public SmsResultBean sendNetSMS(String mobile, String message) {
    	SmsResultBean result = new SmsResultBean();
    	try {
    		String urlStr = ConnectionFactory.operationProperty("smsUrlProvider", Constantes.contextSale);
    		String user = ConnectionFactory.operationProperty("smsParamUsername", Constantes.contextSale);
    		String password = ConnectionFactory.operationProperty("smsParamPassword", Constantes.contextSale);
			URL url = new URL(urlStr+mobile+"/"+URLEncoder.encode(message,"UTF-8"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (urlStr.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","SMS");
	            }
	        }
	        // Use this if you need basic authentication
	        if ((user != null) && (password != null)) {
	            String userPass = user + ":" + password;
	            String basicAuth = "Basic " + new BASE64Encoder().encode(userPass.getBytes());
	            conn.setRequestProperty("Authorization", basicAuth);
	        }
	        /*conn.setReadTimeout(7000);
	        conn.setConnectTimeout(7000);*/
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        
	        InputStream inputStream = null;
	        try {
	        	//int rc = conn.getResponseCode();
	        	//LoggerApi.Log.info("Response Code = "+rc);
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
	    		result.setCode(Integer.parseInt(rootobj.get("codigo").toString()));
	    		result.setStatus(Integer.parseInt(rootobj.get("status").toString()));
	    		result.setMessage(rootobj.get("mensaje").toString());
	        } catch(IOException exception) {
	        	StringBuffer sb = new StringBuffer();
	            inputStream = conn.getErrorStream();
	            if(inputStream!=null) {
	            	BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
	            	char[] buffer = new char[1000];
		            int leido;
		            while ((leido = br.read(buffer)) > 0) sb.append(new String(buffer, 0, leido));
		            buffer = null;
	            }
	            result.setCode(500);
	    		result.setStatus(-1);
	    		result.setMessage("ERROR INESPERADO. "+sb.toString());
				LoggerApi.severe(exception);
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
    	return result;
    }
    
    public SmsResultBean sendNetWa(String mobile, String message) {
    	SmsResultBean result = new SmsResultBean();
    	try {
    		String urlStr = ConnectionFactory.operationProperty("waUrlProvider", Constantes.contextSale);
    		String user = ConnectionFactory.operationProperty("smsParamUsername", Constantes.contextSale);
    		String password = ConnectionFactory.operationProperty("smsParamPassword", Constantes.contextSale);
			URL url = new URL(urlStr+mobile+"/"+URLEncoder.encode(message,"UTF-8"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			LoggerApi.Log.info("urlStr="+urlStr);
			// If secure connection
	        if (urlStr.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","WA");
	            }
	        }
	        // Use this if you need basic authentication
	        if ((user != null) && (password != null)) {
	            String userPass = user + ":" + password;
	            String basicAuth = "Basic " + new BASE64Encoder().encode(userPass.getBytes());
	            conn.setRequestProperty("Authorization", basicAuth);
	        }
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);

	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
	    		result.setCode(Integer.parseInt(rootobj.get("codigo").toString()));
	    		result.setStatus(Integer.parseInt(rootobj.get("status").toString()));
	    		result.setMessage(rootobj.get("mensaje").toString());
	        } catch(IOException exception) {
	        	StringBuffer sb = new StringBuffer();
	            inputStream = conn.getErrorStream();
	            if(inputStream!=null) {
	            	BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
	            	char[] buffer = new char[1000];
		            int leido;
		            while ((leido = br.read(buffer)) > 0) sb.append(new String(buffer, 0, leido));
	            }
	            result.setCode(500);
	    		result.setStatus(-1);
	    		result.setMessage("ERROR INESPERADO. "+sb.toString());
            	LoggerApi.severe(exception);
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
    	return result;
    }
}
