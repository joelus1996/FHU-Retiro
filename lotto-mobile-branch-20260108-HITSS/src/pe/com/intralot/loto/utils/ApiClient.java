package pe.com.intralot.loto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;

import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;

public class ApiClient {

    private static final List<Integer> listHttpStatusAllowed = Arrays.asList(
            HttpURLConnection.HTTP_OK, HttpURLConnection.HTTP_BAD_REQUEST, HttpURLConnection.HTTP_UNAUTHORIZED, HttpURLConnection.HTTP_NOT_FOUND
    );

    @SuppressWarnings("resource")
	public static String post(String apiUrl, String body, String username, String password, Map<String,String> headers) throws IOException {

    
    	URL url = new URL(apiUrl);
        LoggerApi.Log.info("apiUrl="+apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String auth = username + ":" + password;
        auth = Base64.encodeBase64String(auth.getBytes());
        StringBuilder response = new StringBuilder();

    try {    
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Basic "+auth);
        
        for (String key : headers.keySet()) {
        	connection.setRequestProperty(key, headers.get(key));
        }
        
        if (apiUrl.startsWith("https")) {
        	((HttpsURLConnection) connection).setSSLSocketFactory(new TSLSocketConnectionFactory());
        }
                
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoOutput(true);
        connection.getOutputStream().write(body.getBytes(Constantes.CHARSET_UTF8));
        connection.setConnectTimeout(Integer.parseInt(ConnectionFactory.operationProperty("connectTimeout", Constantes.contextSale )));
        connection.setReadTimeout(Integer.parseInt(ConnectionFactory.operationProperty("readTimeout", Constantes.contextSale)));

        InputStream inputStream = (connection.getResponseCode() == HttpURLConnection.HTTP_OK) ? connection.getInputStream() : connection.getErrorStream();

        if(!listHttpStatusAllowed.contains(connection.getResponseCode())) {
        	LoggerApi.Log.info("Service return code error:"+ connection.getResponseCode()+
                    " message:"+connection.getResponseMessage());
            throw new RuntimeException("Http Failed, error code: "+ connection.getResponseCode() +
                    " message:"+ connection.getResponseMessage());
        }
        
        LoggerApi.Log.info("response code="+connection.getResponseCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constantes.CHARSET_UTF8));

        String inputLine;
        
        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        
        bufferedReader.close();
        connection.disconnect();
    } catch (Exception e) { 
		LoggerApi.Log.info(e.toString());
	} finally {
		if (connection!=null) connection.disconnect(); connection = null; 	
	}   
        return response.toString();
    }
    
    @SuppressWarnings("resource")
	public static String get(String apiUrl, String username, String password, Map<String,String> headers) throws IOException {

        URL url = new URL(apiUrl);
        LoggerApi.Log.info("apiUrl="+apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String auth = username + ":" + password;
        auth = Base64.encodeBase64String(auth.getBytes());
        StringBuilder response = new StringBuilder();
    try {   
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Basic "+auth);
        
        for (String key : headers.keySet()) {
        	connection.setRequestProperty(key, headers.get(key));
        }
        
        if (apiUrl.startsWith("https")) {
        	((HttpsURLConnection) connection).setSSLSocketFactory(new TSLSocketConnectionFactory());
        }
                
        connection.setRequestProperty("Content-Type", "application/json");

        
        connection.setConnectTimeout(Integer.parseInt(ConnectionFactory.operationProperty("connectTimeout", Constantes.contextSale )));
        connection.setReadTimeout(Integer.parseInt(ConnectionFactory.operationProperty("readTimeout", Constantes.contextSale)));

        InputStream inputStream = (connection.getResponseCode() == HttpURLConnection.HTTP_OK) ? connection.getInputStream() : connection.getErrorStream();

        if(!listHttpStatusAllowed.contains(connection.getResponseCode())) {
        	LoggerApi.Log.info("Service return code error:"+ connection.getResponseCode()+
                    " message:"+connection.getResponseMessage());
            throw new RuntimeException("Http Failed, error code: "+ connection.getResponseCode() +
                    " message:"+ connection.getResponseMessage());
        }
        
        LoggerApi.Log.info("response code="+connection.getResponseCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constantes.CHARSET_UTF8));

        String inputLine;
        

        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        
        bufferedReader.close();
        connection.disconnect();
    } catch (Exception e) { 
		LoggerApi.Log.info(e.toString());
	} finally {
		if (connection!=null) connection.disconnect(); connection = null; 	
	}
        return response.toString();
    }
}
