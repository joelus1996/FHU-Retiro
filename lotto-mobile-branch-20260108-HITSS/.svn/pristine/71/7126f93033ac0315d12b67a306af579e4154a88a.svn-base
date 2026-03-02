package pe.com.intralot.loto.utils;

import pe.com.intralot.loto.sale.lib.LoggerApi;
import sun.misc.BASE64Encoder;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.lib.ConnectionFactory;

public class JackpotCasinoUtils{
    
	
	public JackpotCasinoUtils() {}

	public static void main(String[] args) throws Exception {
	
		System.out.println(formatoJackpot("12345"));

	}
	public static void updateJackpotCasino() throws Exception{
		//long startTime = System.currentTimeMillis();
		//String log="updateJackpotCasino";
		
		if ( !ConnectionFactory.operationProperty("activeUpdateJackpot", Constantes.contextSale).equals("true") ) return;
		try {			
			int timeRetry = 1;
			for (int i=1; i<=timeRetry; i++) {
				try {
					updateJackpotTrx(i, null); 
				} catch (java.net.ConnectException e) {
					if (i<timeRetry) { try { Thread.sleep(i*1000); } catch(InterruptedException ex) { Thread.currentThread().interrupt(); } } 
					else { throw e; }
				} catch (Exception e) { throw e; }
			}			
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			//LoggerApi.Log.info("JackpotCasinoUtil updateJackpotCasino end "+jackpoturl+" in "+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");	
		}
	}
	
	
	private static String updateJackpotTrx(int times, String log) throws Exception { 
		
		//long startTime = System.currentTimeMillis();
		HttpURLConnection conn = null;
		String surl=null;
		String valJackpot = "ok";
		try { 
		     
        	surl= Constantes.URL_JACKPOT_CASINO;
			URL url = new URL(surl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			String userPass = "iflextestuser:tinkalatinka";
            String basicAuth = "Basic " + new BASE64Encoder().encode(userPass.getBytes());
            conn.setRequestProperty("Authorization", basicAuth);
			conn.setRequestMethod("GET");
			JsonObject jObject1;
            if (conn.getResponseCode() == 200) {
            	JsonElement root = new JsonParser().parse(new InputStreamReader((conn.getInputStream()), "UTF-8"));
            	if(root.toString().length() > 2) {   				
					for(JsonElement je1 : root.getAsJsonArray()) {
						jObject1 = je1.getAsJsonObject();
						Constantes.jackpotsMap.put(removeUnfit(jObject1.get("jackpotid").toString()), formatoJackpot(removeUnfit(jObject1.get("valor").toString())) );
					} 
            	} 	
			}else {
				valJackpot = "error-status code:"+conn.getResponseCode();
			} 	            
            conn.disconnect();
	        
		} catch (Exception e) { 
			LoggerApi.Log.info(e.toString());
		} finally {
			//LoggerApi.Log.info(log+" end "+times+" [updateJackpotTrx] response valJackpot=s"+valJackpot+" in "+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");
			if (conn!=null) conn.disconnect(); conn = null; 	
		}
		return valJackpot;
	}
	
	private static String removeUnfit(String str) {		
		return str.replaceAll(Constantes.CASINO_REGEX, Constantes.CASINO_VACIO);
	}
	
	private static String formatoJackpot(String numero) {
		java.text.DecimalFormat formato = new java.text.DecimalFormat("S/ ###,###,###");
		String valorFormateado = formato.format(new Integer(numero));
		valorFormateado = valorFormateado.replace(".", ",");
		if (valorFormateado.contains(",")) {
			valorFormateado = valorFormateado.split(",").length>2?StringUtils.replaceOnce(valorFormateado, ",", "'"):valorFormateado;
		}		
		
		return valorFormateado;
	}
		
}
