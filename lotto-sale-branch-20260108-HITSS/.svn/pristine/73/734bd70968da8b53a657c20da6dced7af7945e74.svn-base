package pe.com.intralot.loto.util;
 
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;

import pe.com.intralot.loto.layer.dto.novus.AuthNovusRequest;
import pe.com.intralot.loto.layer.dto.novus.NovusDataResponse;
import pe.com.intralot.loto.layer.dto.novus.NovusError;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.lib.ConnectionFactory;

public class AuthenticationNovusTrx {

	private static final Gson gson = new Gson();
	public static String SERVER  			= ConnectionFactory.operationProperty("teapuestoApiServer", "sale"); 
	public static String CLIENT_ID  		= ConnectionFactory.operationProperty("teapuestoApiClientId", "sale");
	public static String CLIENT_SECRET  	= ConnectionFactory.operationProperty("teapuestoApiClientSecret", "sale");
	public static final String GRANT_TYPE  	= "client_credentials"; 
	
	public static NovusDataResponse authentication;
	
	public static String getToken(String log, boolean regenerate) throws Exception {
		if (regenerate==true) authentication=null;
		if (authentication==null) {
			NovusDataResponse auth = AuthenticationNovusTrx.authentication(log, regenerate);
			authentication = auth;
		}
		if (authentication.getData()==null || authentication.getData().getAccess_token()==null || authentication.getData().getAccess_token().equals("")) {
			NovusDataResponse auth = AuthenticationNovusTrx.authentication(log, regenerate);
			authentication = auth;
		}
		return authentication.getData().getAccess_token();
	}
	
	
	public static void main(String[] args) throws Exception {
		NovusDataResponse jResponse = authentication("",false);
		
		if(jResponse.getError()!=null) {
			System.out.println(jResponse.getError().getError_code());
		}else {// mensaje correcto
			String token = jResponse.getData().getAccess_token();
			System.out.println(token);
		}
		
	}

	private static NovusDataResponse authentication(String log, boolean regenerate) throws Exception { 
		long startTime = System.currentTimeMillis();
		LoggerApi.Log.info(log+" start [AuthenticationNovusTrx] regenerate="+regenerate);
		//HttpURLConnection conn = null;
		HttpsURLConnection conn = null;
		NovusDataResponse dataAuthResponse = new NovusDataResponse();
		AuthNovusRequest authRequest = new AuthNovusRequest();
		String surl= null;
		try {
			surl= SERVER+"/api/v3/oauth/access_token";
			LoggerApi.Log.info(log+" AuthenticationNovusTrx request "+surl);	
			URL url = new URL(surl);
			
			conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(new TSLSocketConnectionFactory());
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//conn.setRequestProperty("Host", "api.teapuesto.pe");
			
			authRequest.setGrant_type(GRANT_TYPE); 
			authRequest.setClient_id(Long.parseLong(CLIENT_ID));
			authRequest.setClient_secret(CLIENT_SECRET);
			
			String json = gson.toJson(authRequest);
			
			OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
			
			dataAuthResponse.setResponseCodeMessage(conn.getResponseCode() + " " + conn.getResponseMessage());
			if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
				NovusDataResponse dataResponse = gson.fromJson(  HttpLib.getJsonString(conn.getInputStream(), false) , NovusDataResponse.class); 
				dataAuthResponse.setData(dataResponse.getData());
            } else {
            	NovusError error  = gson.fromJson(  HttpLib.getJsonString(conn.getErrorStream()) , NovusError.class);
            	System.out.println("error authenticationNovus>>>>"+error.getError_code());
            	dataAuthResponse.setError(error);
            }
	        
		} catch (Exception e) { 
			throw e;
		} finally {
			LoggerApi.Log.info(log+" end [AuthenticationNovusTrx] response "+dataAuthResponse+" in "+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");
			if (conn!=null) conn.disconnect(); conn = null;
		}
		return dataAuthResponse;
	}

	
}
