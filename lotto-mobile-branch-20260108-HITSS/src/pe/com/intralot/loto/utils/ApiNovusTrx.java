package pe.com.intralot.loto.utils;

import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import pe.com.intralot.loto.layer.dto.novus.NovusDataResponse;
import pe.com.intralot.loto.layer.dto.novus.NovusError;
import pe.com.intralot.loto.layer.dto.novus.RegisterDataResponse;
import pe.com.intralot.loto.layer.dto.novus.RegisterModel;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class ApiNovusTrx {

    private   static Gson gson = new Gson();
    /*
    public static void main(String[] args) throws Exception { 
		
		DataResponse balance = setBalance("", 561799L, 12.5, 0.0, 0.0);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXX"+balance.getResult());
			
	}
	*/
	public static RegisterDataResponse registerUser(String log, Long client_id, String username, String email, String name) throws Exception {
		 
		RegisterDataResponse jresponse = null;
		int timeRetry = 3;
		for (int i=1; i<=timeRetry; i++) {
			try {
				jresponse = registerUserTrx(i, log, client_id, username, email, name); 
				if (jresponse.getError()!=null) { break; }
				if (jresponse.getResult()!=null) { break; }
			} catch (java.net.ConnectException e) {
				if (i<timeRetry) { try { Thread.sleep(i*1000); } catch(InterruptedException ex) { Thread.currentThread().interrupt(); } } 
				else { throw e; }
			} catch (Exception e) { throw e; }
		}
		return jresponse;
	}
 
	private static RegisterDataResponse registerUserTrx(int times, String log, Long client_id, String username, String email, String name) throws Exception { 
		
		long startTime = System.currentTimeMillis();
		LoggerApi.Log.info(log+" start "+times+" [RegisterUserTrx] client_id="+client_id+" username="+username+" email="+email+" name="+name);
		HttpsURLConnection conn = null;  
		RegisterDataResponse jResponse = new RegisterDataResponse();
		RegisterModel registerModel = new RegisterModel();
		String surl=null;
		try { 
			registerModel.setUser_id(client_id);
			registerModel.setUsername(username);
			registerModel.setEmail(email);
			registerModel.setName(name);
			
		     
	        String json = gson.toJson(registerModel);

        	String token = AuthenticationNovusTrx.getToken(log, false);
        	if (ConnectionFactory.isDevelopment()) {
        		LoggerApi.Log.info(log+" Token = "+token);
    		}
        	
	        for (int i=1; i<=2; i++) {
	        	jResponse = new RegisterDataResponse();
				surl= AuthenticationNovusTrx.SERVER+"/api/v3/secure-area/user/register";
				LoggerApi.Log.info(log+" RegisterTrx request "+surl+" "+registerModel);	
				URL url = new URL(surl);
				conn = (HttpsURLConnection) url.openConnection();
				conn.setSSLSocketFactory(new TSLSocketConnectionFactory());
				
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "Bearer "+token);
				
				OutputStream os = conn.getOutputStream();
	            os.write(json.getBytes("UTF-8"));
	            os.close(); 

	            jResponse.setResponseCodeMessage(conn.getResponseCode() + " " + conn.getResponseMessage());
				if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
					jResponse = gson.fromJson(  HttpLib.getJsonString(conn.getInputStream(), false) , RegisterDataResponse.class);
					break;
	            } else {
		            NovusError error  = gson.fromJson(  HttpLib.getJsonString(conn.getErrorStream()) , NovusError.class);
	    	    	jResponse.setError(error);
					if (jResponse.isTokenError()) {
			        	token = AuthenticationNovusTrx.getToken(log, true);
					} else {
						break;
					}
	            }
	        }
	        
		} catch (Exception e) { 
			LoggerApi.Log.info(e.toString());
		} finally {
			LoggerApi.Log.info(log+" end "+times+" [registerUserTrx] response "+jResponse.toString()+" in "+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");
			if (conn!=null) conn.disconnect(); conn = null; 	
		}
		return jResponse;
	}
	
}

