package pe.com.intralot.loto.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import pe.com.intralot.loto.layer.model.bean.qr.QrParameters;
import pe.com.intralot.loto.layer.model.bean.qr.QrResponse;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.lib.StringLib;

/**
 * @author:   Jhonathan Luis Moran Gomez
 * @rol:	  Analista Programador
 */

@Component
public class QrUtil {

	//@Autowired
    //private LottoParametersBoImpl lottoParametersBo;
	/*
	public String callWsQR(String serverIP, TicketProcedureGetClientTicket ticketProcedureGetClientTicket, String htmlText) {
    	if(htmlText.contains("<pre>")) {
    		try {
    			// Parametro numero de ticket
    			QrParameters qrParameters = new QrParameters();
    			String ticketNumber = null;
    			if (ticketProcedureGetClientTicket.getCtTicketNumber() != null) {
    				try {
    					ticketNumber = StringLib.decodeLabel(ticketProcedureGetClientTicket.getCtTicketNumber());
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    				qrParameters.setTicketNumber(ticketNumber);
    			}
    			Gson gson = new Gson();
    	    	String json = gson.toJson(qrParameters);
    	    	byte[] utf8Json = json.getBytes("UTF8");
    			
    			String urlGenerateQr = lottoParametersBo.getUrlGenerateQr(serverIP);
    			
    			URL url = new URL(urlGenerateQr);
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    			conn.setDoOutput(true);
    			conn.setRequestMethod("POST");
    			conn.setRequestProperty("Content-Type", "application/json");
    			conn.setRequestProperty("Accept", "application/json");

    			OutputStream os = conn.getOutputStream();
    			os.write(utf8Json, 0, utf8Json.length);
    			os.close();

    			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
    				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
    			}

    			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

    			String output;
    			
    			while ((output = br.readLine()) != null) {
    				break;
    			}
    			conn.disconnect();
    			
    			QrResponse qrResponse = gson.fromJson(output, QrResponse.class);
    			
    			//Reemplazar codigo de barras con QR
    			String[] html1 = htmlText.split("<pre>");
    			String[] html2 = html1[1].split("</pre>");
    			
    			String htmlQR = qrResponse.getHtmlImage().replace("\n", "").replace("\r", "");
    			htmlQR = html1[0]+"<pre>"+html2[0]+"<br><br>"+htmlQR+"</pre>"+html2[1];
    			
    			return htmlQR;
    		} catch (MalformedURLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		return null;
    	}else {
    		return htmlText;
    	}
    }*/
	
	public String generateQR(String text) {
		String result = "";
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hints.put(EncodeHintType.MARGIN, 0);
			BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 80, 80, hints);
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray();
		    result = new sun.misc.BASE64Encoder().encode(pngData);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
	    return result;
	}
	
	public String generateQRStringDebitId(String text) {
		String result = "";
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hints.put(EncodeHintType.MARGIN, 0);
			BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 140, 140, hints);
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray();
		    result = new sun.misc.BASE64Encoder().encode(pngData);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
	    return result;
	}
	
	public String generateQR(TicketProcedureGetClientTicket ticketProcedureGetClientTicket, String htmlText) {
    	if(htmlText.contains("<pre>")) {
    		// Parametro numero de ticket
			QrParameters qrParameters = new QrParameters();
			String ticketNumber = null;
			if (ticketProcedureGetClientTicket.getCtTicketNumber() != null) {
				try {
					ticketNumber = StringLib.decodeLabel(ticketProcedureGetClientTicket.getCtTicketNumber());
				} catch (Exception e) {
					e.printStackTrace();
				}
				qrParameters.setTicketNumber(ticketNumber);
			}
			
			QrResponse qrResponse = generateByTicketNumber(qrParameters);
			
			//Reemplazar codigo de barras con QR
			String[] html1 = htmlText.split("<pre>");
			String[] html2 = html1[1].split("</pre>");
			
			String htmlQR = qrResponse.getHtmlImage().replace("\n", "").replace("\r", "");
			htmlQR = html1[0]+"<pre>"+html2[0]+"<br><br>"+htmlQR+"</pre>"+html2[1];
			
			return htmlQR;
    	}else {
    		return htmlText;
    	}
    }
	
    public QrResponse generateByTicketNumber(QrParameters qrParameters) {
		// Generacion del codigo QR
		String htmlImage = null;
		
        try {
        	QRCodeWriter qrCodeWriter = new QRCodeWriter();
        	
    		Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
    		hints.put(EncodeHintType.MARGIN, 0);
    		
			BitMatrix bitMatrix = qrCodeWriter.encode(qrParameters.getTicketNumber(), BarcodeFormat.QR_CODE, 100, 100, hints);
			
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray();
		    
		    String result = new sun.misc.BASE64Encoder().encode(pngData);
		    
		    htmlImage = "<img id='ItemPreview' src='data:image/png;base64,"+result+"' style='border: 5px solid black;' />";
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        QrResponse qrResponse = new QrResponse();
        qrResponse.setHtmlImage(htmlImage);
		return qrResponse;
	}
    
    public String generateQR_Retail(TicketProcedureGetClientTicketRetail ticketProcedureGetClientTicketRetail, String htmlText) {
    	if(htmlText.contains("<pre>")) {
    		// Parametro numero de ticket
			QrParameters qrParameters = new QrParameters();
			String ticketNumber = null;
			if (ticketProcedureGetClientTicketRetail.getCtTicketNumber() != null) {
				try {
					ticketNumber = StringLib.decodeLabel(ticketProcedureGetClientTicketRetail.getCtTicketNumber());
				} catch (Exception e) {
					e.printStackTrace();
				}
				qrParameters.setTicketNumber(ticketNumber);
			}
			
			QrResponse qrResponse = generateByTicketNumber(qrParameters);
			
			//Reemplazar codigo de barras con QR
			String[] html1 = htmlText.split("<pre>");
			String[] html2 = html1[1].split("</pre>");
			
			String htmlQR = qrResponse.getHtmlImage().replace("\n", "").replace("\r", "");
			htmlQR = html1[0]+"<pre>"+html2[0]+"<br><br>"+htmlQR+"</pre>"+html2[1];
			
			return htmlQR;
    	}else {
    		return htmlText;
    	}
    }
}
