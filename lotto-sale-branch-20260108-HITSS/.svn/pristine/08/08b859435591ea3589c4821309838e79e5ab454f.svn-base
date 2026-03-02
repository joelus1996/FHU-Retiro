package pe.com.intralot.loto.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.model.bean.LaunchRequestQTBean;
import pe.com.intralot.loto.layer.model.bean.ResponseQTBean;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class CasinoXpgUtils extends Thread {
    
	private String accion;
	private String external_id;
	private String username;
	private ClientSaleBo clientSaleBo;
	private static final Gson gson = new Gson();
    
	public CasinoXpgUtils() {}
	public CasinoXpgUtils(String accion, String external_id, ClientSaleBo clientSaleBo) {
		this.accion = accion;
		this.external_id = external_id;
		this.username = String.format("%04d", new Long(external_id));
		this.clientSaleBo = clientSaleBo;
	}
	
    public String getLobbyUrl(String external_id, String game_id, String return_url, String language) {
    	LoggerApi.Log.info("-------------- START getLobbyUrl");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constants.CASINO_API_URL+"get/lobby");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constants.CASINO_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api casino getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constants.CASINO_SITE_ID);
	    	params.put("access_key", Constants.CASINO_ACCESS_KEY);
	    	params.put("game_id", game_id);
	    	params.put("external_id", external_id);
	    	params.put("mobile", "0");
	    	params.put("return_url", return_url);
	    	params.put("language", Constants.CASINO_LANGUAGE);
	        StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String,Object> param : params.entrySet()) {
	    		if (postData.length() != 0) postData.append('&');
	    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    	}
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        conn.getOutputStream().write( postDataBytes );
	        
	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
		        sbResult.append(rootobj.get("status").toString());
		        sbResult.append("@");
		        sbResult.append(rootobj.get("messages").toString());
		        sbResult.append("@");
		        if(rootobj.get("status").toString().equals("true"))
		        	sbResult.append(rootobj.get("data").getAsJsonObject().get("session").getAsJsonObject().get("url").getAsString());
		        else
		        	sbResult.append("-");		        		        
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END getLobbyUrl  Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return sbResult.toString();
    }
    
    public String getLobbyUrlPreprod(String external_id, String game_id, String return_url, String language) {
    	LoggerApi.Log.info("-------------- START getLobbyUrlPreprod");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constants.PREPROD_CASINO_API_URL+"get/lobby");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constants.PREPROD_CASINO_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api casino getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constants.PREPROD_CASINO_SITE_ID);
	    	params.put("access_key", Constants.PREPROD_CASINO_ACCESS_KEY);
	    	params.put("game_id", game_id);
	    	params.put("external_id", external_id);
	    	params.put("mobile", "0");
	    	params.put("return_url", return_url);
	    	params.put("language", Constants.CASINO_LANGUAGE);
	        StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String,Object> param : params.entrySet()) {
	    		if (postData.length() != 0) postData.append('&');
	    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    	}
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        conn.getOutputStream().write( postDataBytes );
	        
	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
		        sbResult.append(rootobj.get("status").toString());
		        sbResult.append("@");
		        sbResult.append(rootobj.get("messages").toString());
		        sbResult.append("@");
		        if(rootobj.get("status").toString().equals("true"))
		        	sbResult.append(rootobj.get("data").getAsJsonObject().get("session").getAsJsonObject().get("url").getAsString());
		        else
		        	sbResult.append("-");		        		        
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END getLobbyUrl preprod Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return sbResult.toString();
    }
    
    public String createPlayer(String external_id) {
    	LoggerApi.Log.info("-------------- START createPlayer");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constants.CASINO_API_URL+"player/create");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constants.CASINO_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api casino getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constants.CASINO_SITE_ID);
	    	params.put("access_key", Constants.CASINO_ACCESS_KEY);
	    	params.put("external_id", external_id);
	    	params.put("username", String.format("%04d", new Long(external_id)));
	    	params.put("password", "000");
	    	params.put("currency", Constants.CASINO_CURRENCY);
	        StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String,Object> param : params.entrySet()) {
	    		if (postData.length() != 0) postData.append('&');
	    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    	}
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        conn.getOutputStream().write( postDataBytes );
	        
	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
	    		sbResult.append(rootobj.get("status").toString());
		        sbResult.append("@");
		        sbResult.append(rootobj.get("messages").toString());
		        sbResult.append("@");
		        if(rootobj.get("status").toString().equals("true"))
		        	sbResult.append(rootobj.get("data").getAsJsonObject().get("player_id").getAsString());
		        else
		        	sbResult.append("-");
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END createPlayer Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return sbResult.toString();
    }
    
    public String createPlayerPreprod(String external_id) {
    	LoggerApi.Log.info("-------------- START createPlayer preprod");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constants.PREPROD_CASINO_API_URL+"player/create");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constants.PREPROD_CASINO_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api casino getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constants.PREPROD_CASINO_SITE_ID);
	    	params.put("access_key", Constants.PREPROD_CASINO_ACCESS_KEY);
	    	params.put("external_id", external_id);
	    	params.put("username", String.format("%04d", new Long(external_id)));
	    	params.put("password", "000");
	    	params.put("currency", Constants.CASINO_CURRENCY);
	        StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String,Object> param : params.entrySet()) {
	    		if (postData.length() != 0) postData.append('&');
	    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    	}
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        conn.getOutputStream().write( postDataBytes );
	        
	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
	    		sbResult.append(rootobj.get("status").toString());
		        sbResult.append("@");
		        sbResult.append(rootobj.get("messages").toString());
		        sbResult.append("@");
		        if(rootobj.get("status").toString().equals("true"))
		        	sbResult.append(rootobj.get("data").getAsJsonObject().get("player_id").getAsString());
		        else
		        	sbResult.append("-");
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END createPlayer preprod Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return sbResult.toString();
    }
    
    public String checkPlayer(String external_id) {
    	LoggerApi.Log.info("-------------- START checkPlayer");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constants.CASINO_API_URL+"player/check");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constants.CASINO_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api casino getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constants.CASINO_SITE_ID);
	    	params.put("access_key", Constants.CASINO_ACCESS_KEY);
	    	params.put("external_id", external_id);	    	
	        StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String,Object> param : params.entrySet()) {
	    		if (postData.length() != 0) postData.append('&');
	    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    	}
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        conn.getOutputStream().write( postDataBytes );
	        
	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
	    		sbResult.append(rootobj.get("status").toString());
		        sbResult.append("@");
		        sbResult.append(rootobj.get("messages").toString());
		        sbResult.append("@");
		        if(rootobj.get("status").toString().equals("true"))
		        	sbResult.append(rootobj.get("data").getAsJsonObject().get("player").getAsJsonObject().get("id").getAsString());
		        else
		        	sbResult.append("-");
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END checkPlayer  Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return sbResult.toString();
    }
    
    public String checkPlayerPreprod(String external_id) {
    	LoggerApi.Log.info("-------------- START checkPlayer preprod");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constants.PREPROD_CASINO_API_URL+"player/check");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constants.PREPROD_CASINO_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api casino getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constants.PREPROD_CASINO_SITE_ID);
	    	params.put("access_key", Constants.PREPROD_CASINO_ACCESS_KEY);
	    	params.put("external_id", external_id);	    	
	        StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String,Object> param : params.entrySet()) {
	    		if (postData.length() != 0) postData.append('&');
	    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    	}
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        conn.setReadTimeout(20000);
	        conn.setConnectTimeout(20000);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDefaultUseCaches(false);
	        conn.getOutputStream().write( postDataBytes );
	        
	        InputStream inputStream = null;
	        try {
	            inputStream = conn.getInputStream();
	            JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream,"UTF-8"));
		        JsonObject rootobj = root.getAsJsonObject();
	    		sbResult.append(rootobj.get("status").toString());
		        sbResult.append("@");
		        sbResult.append(rootobj.get("messages").toString());
		        sbResult.append("@");
		        if(rootobj.get("status").toString().equals("true"))
		        	sbResult.append(rootobj.get("data").getAsJsonObject().get("player").getAsJsonObject().get("id").getAsString());
		        else
		        	sbResult.append("-");
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END checkPlayer preprod Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return sbResult.toString();
    }
    
    public String processCreate() {
    	CasinoXpgUtils u = new CasinoXpgUtils();
    	String resultado = u.checkPlayer(this.external_id);
    	String status = resultado.split("@")[0];
    	String player_id = "";
    	if(status.equals("true")) {//existe cliente en XPgame
    		player_id = resultado.split("@")[2];
    		LoggerApi.Log.info("----CheckPlayer casino XPG player_id: "+player_id);
    	}
    	if(status.equals("false")) {//no existe cliente en XPgame, se crea usuario
    		LoggerApi.Log.info("----CheckPlayer casino  XPG, no existe cliente client_id: "+this.external_id+" message:"+resultado.split("@")[1]);
    		String resultadoCrea = u.createPlayer(this.external_id);
    		String statusCrea = resultadoCrea.split("@")[0];
    		if(statusCrea.equals("true")) {//usuario creado
    			player_id = resultadoCrea.split("@")[2];
    			LoggerApi.Log.info("----Creacion usuario casino XPG, client_id: " + this.external_id + " player_id: "+player_id);
    		}else {//usuario no se crea
    			LoggerApi.Log.info("----ERROR creacion usuario casino XPG client_id: " + this.external_id + " message: "+resultadoCrea.split("@")[1]);
    		}
    	}
    	
    	//se actualiza CL_PLAYER_ID_XPG en tabla Client
    	/*try {
    		if(!player_id.isEmpty())
    			this.clientSaleBo.updatePlayerId(Integer.valueOf(this.external_id), player_id);
		} catch (Exception e) {
            LoggerApi.severe(e);	            
        }
    	*/
    	return player_id;
    }
    
    public String processCreatePreprod() {
    	CasinoXpgUtils u = new CasinoXpgUtils();
    	String resultado = u.checkPlayerPreprod(this.external_id);
    	String status = resultado.split("@")[0];
    	String player_id = "";
    	if(status.equals("true")) {//existe cliente en XPgame
    		player_id = resultado.split("@")[2];
    		LoggerApi.Log.info("----CheckPlayerPreprod casino XPG player_id: "+player_id);
    	}
    	if(status.equals("false")) {//no existe cliente en XPgame, se crea usuario
    		LoggerApi.Log.info("----CheckPlayerPreprod casino  XPG, no existe cliente client_id: "+this.external_id+" message:"+resultado.split("@")[1]);
    		String resultadoCrea = u.createPlayerPreprod(this.external_id);
    		String statusCrea = resultadoCrea.split("@")[0];
    		if(statusCrea.equals("true")) {//usuario creado
    			player_id = resultadoCrea.split("@")[2];
    			LoggerApi.Log.info("----Creacion usuario casino XPG preprod, client_id: " + this.external_id + " player_id: "+player_id);
    		}else {//usuario no se crea
    			LoggerApi.Log.info("----ERROR creacion usuario casino XPG preprod client_id: " + this.external_id + " message: "+resultadoCrea.split("@")[1]);
    		}
    	}
    	
    	return player_id;
    }
    
    public String getLobbyUrlQT(String player_id, String game_id, String return_url, String session) {
    	LoggerApi.Log.info(" ================== START getLobbyUrlQT");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	LaunchRequestQTBean launchRequest = new LaunchRequestQTBean();
    	ResponseQTBean dataResponse = new ResponseQTBean();
    	HttpsURLConnection conn = null;
    	try {
    		String token = AuthenticationQTTrx.getToken("", false);
    		LoggerApi.Log.info("token>>>"+token);
    		
    		for (int i=1; i<=2; i++) {	
	    		URL url = new URL(Constants.CASINO_QT_API_URL+"/v1/games/" + game_id + "/launch-url");
	    		conn = (HttpsURLConnection) url.openConnection();
				conn.setSSLSocketFactory(new TSLSocketConnectionFactory());			
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "Bearer "+token);
		        
		    	launchRequest.setPlayerId(player_id);
		    	launchRequest.setCurrency(Constants.CASINO_QT_CURRENCY);
		    	launchRequest.setCountry(Constants.CASINO_QT_COUNTRY);
		    	launchRequest.setLang(Constants.CASINO_QT_LANGUAGE);
		    	launchRequest.setMode(Constants.CASINO_QT_REAL);
		    	launchRequest.setDevice(Constants.CASINO_QT_DEVICE);
		    	launchRequest.setReturnUrl(return_url);
		    	launchRequest.setWalletSessionId(session);
				
				String json = gson.toJson(launchRequest);		    	
		        
		        OutputStream os = conn.getOutputStream();
	            os.write(json.getBytes("UTF-8"));
	            os.close();
		        
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
	 			String jsonResponse = sb.toString();
	 				            
	            if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
	            	dataResponse = gson.fromJson(  jsonResponse , ResponseQTBean.class);
	            	sbResult.append("true");
			        sbResult.append("@");
			        sbResult.append("-");
			        sbResult.append("@");
			        sbResult.append(dataResponse.getUrl());
					break;
	            } else {
	            	dataResponse  = gson.fromJson(  jsonResponse , ResponseQTBean.class);
					if (dataResponse.isTokenError() && dataResponse.getCode().equals("INVALID_TOKEN")) {
						LoggerApi.Log.info("jsonResponse="+jsonResponse);
			        	token = AuthenticationQTTrx.getToken("", true);
					} else {
						sbResult.append("-");
				        sbResult.append("@");
				        sbResult.append("-");
				        sbResult.append("@");
				        sbResult.append("-");
				        sbResult.append("@");
						break;
					}
	            }
	            
		        conn.disconnect();
    		}
		} catch (Exception e) {
			LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
		}finally {
			LoggerApi.Log.info(" ================== END getLobbyUrlQT  Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
			if (conn!=null) conn.disconnect(); conn = null; 
		}
    	return sbResult.toString();
    }
    
    public void run() {
    	
    	if(this.accion.equals("createPlayer")) {
    		CasinoXpgUtils u = new CasinoXpgUtils();
        	String resultado = u.checkPlayer(this.external_id);
        	String status = resultado.split("@")[0];
        	String player_id = "";
        	if(status.equals("true")) {//existe cliente en XPgame
        		player_id = resultado.split("@")[2];
        		LoggerApi.Log.info("----CheckPlayer casino XPG player_id: "+player_id);
        	}
        	if(status.equals("false")) {//no existe cliente en XPgame, se crea usuario
        		LoggerApi.Log.info("----CheckPlayer casino  XPG, no existe cliente client_id: "+this.external_id+" message:"+resultado.split("@")[1]);
        		String resultadoCrea = u.createPlayer(this.external_id);
        		String statusCrea = resultadoCrea.split("@")[0];
        		if(statusCrea.equals("true")) {//usuario creado
        			player_id = resultadoCrea.split("@")[2];
        			LoggerApi.Log.info("----Creacion usuario casino XPG, client_id: " + this.external_id + " player_id: "+player_id);
        		}else {//usuario no se crea
        			LoggerApi.Log.info("----ERROR creacion usuario casino XPG client_id: " + this.external_id + " message: "+resultadoCrea.split("@")[1]);
        		}
        	}
        	
        	//se actualiza CL_PLAYER_ID_XPG en tabla Client
        	try {
        		if(!player_id.isEmpty())
        			this.clientSaleBo.updatePlayerId(Integer.valueOf(this.external_id), player_id);
			} catch (Exception e) {
	            LoggerApi.severe(e);	            
	        } 
    	}    	
    }    
}
