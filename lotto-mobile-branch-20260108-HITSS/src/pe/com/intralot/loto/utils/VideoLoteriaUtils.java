package pe.com.intralot.loto.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class VideoLoteriaUtils extends Thread{
	
	private String accion;
	private String external_id;
	private String username;
	private ClientSaleBo clientSaleBo;
	private static final Gson gson = new Gson();
	
	public VideoLoteriaUtils() {}
	public VideoLoteriaUtils(String accion, String external_id, ClientSaleBo clientSaleBo) {
		this.accion = accion;
		this.external_id = external_id;
		this.username = String.format("%04d", new Long(external_id));
		this.clientSaleBo = clientSaleBo;
	}
	
	public String getLobbyUrlVl(String external_id, String game_id, String return_url, String language) {
		LoggerApi.Log.info("-------------- START getLobbyUrVl");
    	long startTime = System.currentTimeMillis();
    	StringBuilder sbResult = new StringBuilder();
    	String lobbyUrl = null;
    	try {
    		URL url = new URL(Constantes.VIDEO_LOTERIA_API_URL+"get/lobby");
    		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constantes.VIDEO_LOTERIA_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api video loteria getlobby");
	            }
	        }
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	        params.put("external_id", external_id);
	        params.put("game_id", game_id);
	        params.put("return_url", return_url);
	        params.put("site_id", Constantes.VIDEO_LOTERIA_SITE_ID);
	    	params.put("access_key", Constantes.VIDEO_LOTERIA_ACCESS_KEY);	
	    	params.put("language", Constantes.VIDEO_LOTERIA_LANGUAGE);
	    	params.put("username", external_id);
	    	params.put("currency", Constantes.VIDEO_LOTERIA_CURRENCY);
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
		        if ("true".equalsIgnoreCase(rootobj.get("status").getAsString())) {
	                lobbyUrl = rootobj.get("data")
	                        .getAsJsonObject()
	                        .get("session")
	                        .getAsJsonObject()
	                        .get("url")
	                        .getAsString();
	            }		        		        
	        } catch(IOException exception) {
	        	sbResult.append("false").append("@").append("Error en lectura json").append("@").append("Error");
	        }
	        if(inputStream!=null) inputStream.close();
	        conn.disconnect();
    	}catch(Exception e){
    		LoggerApi.severe(e);
			sbResult.append("false").append("@").append("Error").append("@").append("Error");
    	}finally {
			LoggerApi.Log.info(" ================== END getLobbyUrlVl  Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
    	return lobbyUrl;
	}
	public String createPlayer(String external_id) {
    	LoggerApi.Log.info("-------------- START createPlayer");
    	long startTime = System.currentTimeMillis();
    	
    	StringBuilder sbResult = new StringBuilder();
    	try {
    		
    		URL url = new URL(Constantes.VIDEO_LOTERIA_API_URL+"player/create");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// If secure connection
	        if (Constantes.VIDEO_LOTERIA_API_URL.startsWith("https")) {
	            try {
	                SSLContext sc;
	                sc = SSLContext.getInstance("TLS");
	                sc.init(null, null, new java.security.SecureRandom());
	                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
	            } catch (Exception e) {
	            	LoggerApi.severe(e,"Failed to construct SSL object: ","api video loteria getlobby");
	            }
	        }
	        
	        Map<String,Object> params = new LinkedHashMap<String,Object>();
	    	params.put("site_id", Constantes.VIDEO_LOTERIA_SITE_ID);
	    	params.put("access_key", Constantes.VIDEO_LOTERIA_ACCESS_KEY);
	    	params.put("external_id", external_id);
	    	params.put("username", String.format("%04d", new Long(external_id)));
	    	params.put("password", "000");
	    	params.put("currency", Constantes.VIDEO_LOTERIA_CURRENCY);
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
	
	public String checkPlayer(String external_id) {
	    LoggerApi.Log.info("-------------- START checkPlayer");
	    long startTime = System.currentTimeMillis();
	    String boundary = Long.toHexString(System.currentTimeMillis());
	    String LINE_FEED = "\r\n";
	    String charset = "UTF-8";
	    String result = "";

	    HttpURLConnection conn = null;
	    OutputStream output = null;
	    PrintWriter writer = null;
	    InputStream inputStream = null;

	    try {
	        URL url = new URL(Constantes.VIDEO_LOTERIA_API_URL + "player/check");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	        conn.setRequestProperty("Accept", "application/json");

	        // HTTPS
	        if (Constantes.VIDEO_LOTERIA_API_URL.startsWith("https")) {
	            SSLContext sc = SSLContext.getInstance("TLS");
	            sc.init(null, null, new java.security.SecureRandom());
	            ((HttpsURLConnection) conn).setSSLSocketFactory(sc.getSocketFactory());
	        }
	        
	        output = conn.getOutputStream();
	        OutputStreamWriter osWriter = new OutputStreamWriter(output, charset);
	        writer = new PrintWriter(osWriter);

	        // site_id
	        writer.append("--" + boundary).append(LINE_FEED);
	        writer.append("Content-Disposition: form-data; name=\"site_id\"").append(LINE_FEED);
	        writer.append("Content-Type: text/plain; charset=" + charset).append(LINE_FEED);
	        writer.append(LINE_FEED).append(Constantes.VIDEO_LOTERIA_SITE_ID).append(LINE_FEED).flush();

	        // access_key
	        writer.append("--" + boundary).append(LINE_FEED);
	        writer.append("Content-Disposition: form-data; name=\"access_key\"").append(LINE_FEED);
	        writer.append("Content-Type: text/plain; charset=" + charset).append(LINE_FEED);
	        writer.append(LINE_FEED).append(Constantes.VIDEO_LOTERIA_ACCESS_KEY).append(LINE_FEED).flush();

	        // external_id
	        writer.append("--" + boundary).append(LINE_FEED);
	        writer.append("Content-Disposition: form-data; name=\"external_id\"").append(LINE_FEED);
	        writer.append("Content-Type: text/plain; charset=" + charset).append(LINE_FEED);
	        writer.append(LINE_FEED).append(external_id).append(LINE_FEED).flush();

	        writer.append("--" + boundary + "--").append(LINE_FEED).flush();

	        inputStream = conn.getInputStream();
	        InputStreamReader reader = new InputStreamReader(inputStream, charset);
	        JsonElement root = new JsonParser().parse(reader);
	        JsonObject rootObj = root.getAsJsonObject();

	        String status = rootObj.get("status").getAsString();
	        String message = rootObj.get("messages").toString();
	        String playerId = "-";

	        if ("true".equalsIgnoreCase(status)) {
	            playerId = rootObj.get("data").getAsJsonObject().get("player").getAsJsonObject().get("id").getAsString();
	        }

	        result = status + "@" + message + "@" + playerId;
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	        result = "false@Error@Error";
	    } finally {
	        try {
	            if (writer != null) writer.close();
	            if (output != null) output.close();
	            if (inputStream != null) inputStream.close();
	            if (conn != null) conn.disconnect();
	        } catch (IOException e) {
	            LoggerApi.severe(e);
	        }
	        LoggerApi.Log.info(" ================== END checkPlayer  Time=" + (System.currentTimeMillis() - startTime) / 1000.0 + " seconds ");
	    }

	    return result;
	}

	
	 public String processCreate() {
		VideoLoteriaUtils u = new VideoLoteriaUtils();
    	String resultado = u.checkPlayer(this.external_id);
    	String status = resultado.split("@")[0];
    	String player_id = "";
    	if(status.equals("true")) {//existe cliente en XPgame
    		player_id = resultado.split("@")[2];
    		LoggerApi.Log.info("----CheckPlayer video loteria player_id: "+player_id);
    	}
    	if(status.equals("false")) {//no existe cliente en XPgame, se crea usuario
    		LoggerApi.Log.info("----CheckPlayer video loteria, no existe cliente client_id: "+this.external_id+" message:"+resultado.split("@")[1]);
    		String resultadoCrea = u.createPlayer(this.external_id);
    		String statusCrea = resultadoCrea.split("@")[0];
    		if(statusCrea.equals("true")) {//usuario creado
    			player_id = resultadoCrea.split("@")[2];
    			LoggerApi.Log.info("----Creacion usuario video loteria, client_id: " + this.external_id + " player_id: "+player_id);
    		}else {//usuario no se crea
    			LoggerApi.Log.info("----ERROR creacion usuario video loteria client_id: " + this.external_id + " message: "+resultadoCrea.split("@")[1]);
    		}
    	}
    	
    	return player_id;
    }
	
}
