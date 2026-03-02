package pe.com.intralot.loto.layer.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.model.bean.SmsResultBean;
import sun.misc.BASE64Encoder;

public class SmsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String result = "";
		String inputLine;
		// JSON data
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject obj = new JsonObject();
		try {
		
			// Headers
			ArrayList<String[]> headers = new ArrayList<String[]>();
			headers.add(new String[]{"custom-header", "custom value"});
			headers.add(new String[]{"Content-Type", "application/json"});
			SmsResultBean httpResult = httpPost("http://qa.m.intralot.com.pe/lotto-ws-sms/ilot/sms/mt/", "SMSTestUser", "TeApuestoTuPasion", "990271017,999136897,999148057", "Prueba MT Nro 1 06-03-2018", headers, 7000);//obj.toString(), headers, 7000);
			//BufferedReader in = new BufferedReader(new InputStreamReader(httpResult.getResponse()));
			/*while ((inputLine = in.readLine()) != null) {
				result += inputLine;
			}*/
			System.out.println("result :" + httpResult.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static SmsResultBean httpPost(String urlStr, String user, String password, String mobile, String message, ArrayList<String[]> headers, int timeOut) throws IOException{
        // Set url
        URL url = new URL(urlStr+URLEncoder.encode(mobile,"UTF-8")+"/"+URLEncoder.encode(message,"UTF-8"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // If secure connection
        if (urlStr.startsWith("https")) {
            try {
                SSLContext sc;
                sc = SSLContext.getInstance("TLS");
                sc.init(null, null, new java.security.SecureRandom());
                ((HttpsURLConnection)conn).setSSLSocketFactory(sc.getSocketFactory());
            } catch (Exception e) {
            	System.out.println("Failed to construct SSL object: "+e);
            }
        }

        // Use this if you need basic authentication
        if ((user != null) && (password != null)) {
            String userPass = user + ":" + password;
            String basicAuth = "Basic " + new BASE64Encoder().encode(userPass.getBytes());
            conn.setRequestProperty("Authorization", basicAuth);
        }

        // Set Timeout and method
        conn.setReadTimeout(timeOut);
        conn.setConnectTimeout(timeOut);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        if (headers != null) {
            for (int i = 0; i < headers.size(); i++) {
                conn.setRequestProperty(headers.get(i)[0], headers.get(i)[1]);
            }
        }

        InputStream inputStream = null;
        try {
            inputStream = conn.getInputStream();
        } catch(IOException exception) {
            inputStream = conn.getErrorStream();
        }

        JsonElement root = new JsonParser().parse(new InputStreamReader(inputStream));
        SmsResultBean result = new SmsResultBean();
        JsonObject rootobj = root.getAsJsonObject();
        result.setCode(Integer.parseInt(rootobj.get("codigo").toString()));
		result.setStatus(Integer.parseInt(rootobj.get("status").toString()));
		result.setMessage(rootobj.get("mensaje").toString());
		inputStream.close();
        conn.disconnect();
        return result;
    }
}
