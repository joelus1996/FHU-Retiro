package pe.com.intralot.loto.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.lib.StringLib;

/**
 * @author:   Jhonathan Luis Moran Gomez
 * @rol:	  Analista Programador
 */

@Component
public class QrUtil {
	
	public String generateQR(TicketProcedureGetClientTicket ticketProcedureGetClientTicket) {
		// Parametro numero de ticket
		String ticketNumber = null;
		
		try {
			if (ticketProcedureGetClientTicket.getCtTicketNumber() != null) {
				try {
					ticketNumber = StringLib.decodeLabel(ticketProcedureGetClientTicket.getCtTicketNumber());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			return "";
		}
		
		String qrImageBase64 = generateByTicketNumber(ticketNumber);
		
		return "data:image/png;base64,"+qrImageBase64;
    }
	
	public String generateQR(String ticketNumber) {
		// Parametro numero de ticket
		if (ticketNumber != null) {
			try {
				ticketNumber = StringLib.decodeLabel(ticketNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String qrImageBase64 = generateByTicketNumber(ticketNumber);
		
		return "data:image/png;base64,"+qrImageBase64;
    }
	
	public String generateQRString(String text) {
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	    return result;
	}
	
    public String generateByTicketNumber(String ticketNumber) {
		// Generacion del codigo QR
    	String result = null;
		
        try {
        	QRCodeWriter qrCodeWriter = new QRCodeWriter();
        	
    		Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
    		hints.put(EncodeHintType.MARGIN, 1);
    		
			BitMatrix bitMatrix = qrCodeWriter.encode(ticketNumber, BarcodeFormat.QR_CODE, 170, 170, hints);
			
			ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray();
		    
		    result = new sun.misc.BASE64Encoder().encode(pngData);
		    result = result.replace("\n", "").replace("\r", "");
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
    
	public String generateQR_Retail(TicketProcedureGetClientTicketRetail ticketProcedureGetClientTicketRetail) {
		// Parametro numero de ticket
		String ticketNumber = null;
		
		try {
			if (ticketProcedureGetClientTicketRetail.getCtTicketNumber() != null) {
				try {
					ticketNumber = StringLib.decodeLabel(ticketProcedureGetClientTicketRetail.getCtTicketNumber());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			return "";
		}
		
		String qrImageBase64 = generateByTicketNumber(ticketNumber);
		
		return "data:image/png;base64,"+qrImageBase64;
    }
}
