package pe.com.intralot.loto.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GetResultKyc {
	
	private static final Gson gson = new Gson();
	
	public static String SERVER  			 = Constants.KYC_API_URL; 
	public static String USERNAME  			 = Constants.KYC_USERNAME;
	public static String PASSWORD  			 = Constants.KYC_PASSWORD;  
	
    public static void main(String[] args) {
        
        System.out.println(getResultKyc(100000288));

    }
    
    public static JsonObject getResultKyc(int clientId) {
    	String json = resultKyc(clientId);
    	JsonObject resultado;
    	JsonElement jsn = gson.fromJson(json, JsonElement.class);
    	JsonObject result = jsn.getAsJsonObject();
    	if(result != null) {
    		resultado = result.get("result").getAsJsonObject();
    	}else {
    		resultado = result;
    	}
    	return resultado;
    }
    
	
	public static String resultKyc(int clientId) {
		LoggerApi.Log.info("-----inicio resultKyc-----");
		
		String responseBody = "";
		HttpsURLConnection connection=null;
        BufferedReader in = null;
		
		try {
			URL url = new URL(SERVER + "/getResultKyc");
			String credentials = USERNAME + ":" + PASSWORD;
			String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(credentials.getBytes());
			 
			connection = (HttpsURLConnection) url.openConnection();
			connection.setSSLSocketFactory(new TSLSocketConnectionFactory());
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", basicAuth);
			
			// Establecer tiempo límite de conexión
			connection.setConnectTimeout(60000);
			// Establecer tiempo límite de lectura
			connection.setReadTimeout(60000);
			
			// Configurar el cuerpo de la solicitud
            String requestBody = "{\"clientId\": \"" + clientId + "\"}";
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
			

			int responseCode = connection.getResponseCode();

			if (responseCode == HttpsURLConnection.HTTP_OK) {
				LoggerApi.Log.info("conexion metamap ok");
			    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			    String inputLine;
			    StringBuilder response = new StringBuilder();

			    while ((inputLine = in.readLine()) != null) {
			        response.append(inputLine);
			    }

			    responseBody = response.toString();
			    //System.out.println(responseBody);
			    
			}else {
				LoggerApi.Log.info("conexion metamap ko");
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
            try {
                if(in != null) {
                    in.close();
                }
           } catch (IOException e) {
               e.printStackTrace();
               LoggerApi.Log.info(e.getMessage());
           }
            if(connection != null) {
                connection.disconnect();
            }
		}
		LoggerApi.Log.info("----fin resultKyc-----");
		
		return responseBody;	
	}
	
}

