package pe.com.intralot.loto.util;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.com.intralot.loto.layer.model.bean.ResponseQTBean;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class AuthenticationQTTrx {

	private static final Gson gson = new Gson();
	
	public static String SERVER  			 = Constants.CASINO_QT_API_URL; 
	public static String USERNAME  			 = Constants.CASINO_QT_USERNAME;
	public static String PASSWORD  			 = Constants.CASINO_QT_PASSWORD;  
	public static final String GRANT_TYPE  	 = "password";
	public static final String RESPONSE_TYPE = "token";
	
	public static ResponseQTBean authentication;
	
	public static String getToken(String log, boolean regenerate) throws Exception {
		if (regenerate==true) authentication=null;
		if (authentication==null || authentication.getAccess_token()==null || authentication.getAccess_token().equals("")) {
			ResponseQTBean auth = AuthenticationQTTrx.authentication(log, regenerate);
			authentication = auth;
		}
		return authentication.getAccess_token();
	}
	
	public static void main(String[] args) throws Exception {
		ResponseQTBean jResponse = authentication("",false);
		
		if(jResponse.getCode()!=null) {
			System.out.println(jResponse.getCode());
		}else {// mensaje correcto
			String token = jResponse.getAccess_token();
			System.out.println(token);
		}		
	}

	private static ResponseQTBean authentication(String log, boolean regenerate) throws Exception { 
		long startTime = System.currentTimeMillis();
		LoggerApi.Log.info(log+" start [AuthenticationQTTrx] regenerate="+regenerate);
		HttpsURLConnection conn = null;
		ResponseQTBean dataAuthResponse = new ResponseQTBean();
		String surl= null;
		String jsonResponse = null;
		try {
			surl= SERVER+"/v1/auth/token?grant_type=" + GRANT_TYPE + "&response_type=" + RESPONSE_TYPE + "&username=" + USERNAME + "&password=" + PASSWORD;
			URL url = new URL(surl);
			
			conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(new TSLSocketConnectionFactory());			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			
            BufferedReader br = null;
 			int responseCode = conn.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((conn.getInputStream()),Constants.CHARSET_UTF8));
 			}else {
 				br = new BufferedReader(new InputStreamReader((conn.getErrorStream()),Constants.CHARSET_UTF8));
 			}
 			StringBuilder sb = new StringBuilder();
 			char[] buffer = new char[1000];
 	        int leido;
 	        while ((leido = br.read(buffer)) > 0) {
 	        	sb.append(new String(buffer, 0, leido));
 	        }
 			br.close();
 			jsonResponse = sb.toString();
 			if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
				ResponseQTBean dataResponse = gson.fromJson(  jsonResponse , ResponseQTBean.class);
				dataAuthResponse = dataResponse;
            } else {
            	ResponseQTBean error  = gson.fromJson(  jsonResponse , ResponseQTBean.class);
            	dataAuthResponse = error;
            }	        
		} catch (Exception e) { 
			throw e;
		} finally {
			LoggerApi.Log.info(log+" end [AuthenticationQTTrx] response "+jsonResponse+" in "+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");
			if (conn!=null) conn.disconnect(); conn = null;
		}
		return dataAuthResponse;
	}

	
}
