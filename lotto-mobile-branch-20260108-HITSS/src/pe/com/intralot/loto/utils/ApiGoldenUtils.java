package pe.com.intralot.loto.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import pe.com.intralot.loto.layer.controller.client.bo.DeportesVirtualesBo;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenColor;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenDog;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenFutbol;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenGiraGana;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenKinelo;
import pe.com.intralot.loto.layer.model.pojo.DeportesvirtualesProcedureGetEventsTraduction;
import pe.com.intralot.loto.sale.lib.LoggerApi;



@Component
public class ApiGoldenUtils {
	
	private final DeportesVirtualesBo deportesVirtualesBo;

    @Autowired
    public ApiGoldenUtils(DeportesVirtualesBo deportesVirtualesBo) {
        this.deportesVirtualesBo = deportesVirtualesBo;
    }
	
	
	public  String sendRequestGolden(String ticketId, String url, String tipo) {

        String entityId = Constantes.ENTITY_ID;  
        String apiHash =  Constantes.API_HASH; 
        String apiId = Constantes.API_ID;
        String apiDomain = Constantes.API_DOMAIN; 
        String ticketVal = null;
        boolean advanceInfo = true;
        String fullUrl=null;
        
        String rptaGolden ="ERROR";
        String method="sendRequestGolden";
        
        InputStream is = null;
        StringBuffer buffer = new StringBuffer();
        
        HttpsURLConnection connection = null;
        
        LoggerApi.Log.info( method + " INICIO consulta=============================");
        
        try {
        	ticketVal = ticketId;
        	
        	if(tipo.equals("findTicket") ) {
        		fullUrl = url + "?entityId=" + entityId + "&ticketId=" + ticketVal + "&advanceInfo=" + advanceInfo;
        	}else {
        		fullUrl = url + "?playlistIds=" + ticketId;
        	}
            URL apiUrl = new URL(fullUrl);
            connection = (HttpsURLConnection) apiUrl.openConnection();
            connection.setSSLSocketFactory(new TSLSocketConnectionFactory());
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("apiDomain", apiDomain);
            connection.setRequestProperty("apiId", apiId);
            connection.setRequestProperty("apiHash", apiHash);
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            int responseCode = connection.getResponseCode();

            LoggerApi.Log.info("responseCode" + responseCode);
            if (responseCode == HttpsURLConnection.HTTP_OK) {
            	
                is = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                	buffer.append(str); 
                }          
                bufferedReader.close();
                rptaGolden= buffer.toString();  

            } 
            
	    } catch (SocketTimeoutException e) {
	    	rptaGolden ="ERROR";
	    	LoggerApi.Log.info( " [" + method + "Reply]="  + " So:" + e.getMessage());
	    	e.printStackTrace();
	    	
	    } catch (Exception e) {
	    	 rptaGolden ="ERROR";
	    	  LoggerApi.Log.info( " [" + method + "Reply]="  + " Ex:" + e.getMessage());
	        e.printStackTrace(System.out);
	    } finally {
	       if (connection != null)
	        	connection.disconnect(); 
	    }
  
        LoggerApi.Log.info( method + " FIN consulta=============================");
        return rptaGolden;
    }

	
	public String getCodeGame(String respuestaApiGolden ) {
	
		String typeGame ="OTRO";
		String method="getTypeGame";
		try {		
			JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(respuestaApiGolden).getAsJsonObject();
            if (jsonObject.has("gameType")) {
                JsonElement gameTypeElement = jsonObject.get("gameType");
                if (gameTypeElement.isJsonArray()) {
                    JsonArray gameTypeArray = gameTypeElement.getAsJsonArray();
                    if (gameTypeArray.size() > 0) {
                        typeGame = gameTypeArray.get(0).getAsString();
                    }
                }
            } 
		} catch (JsonSyntaxException e) {
	        typeGame = "OTRO";
	        LoggerApi.Log.info("[" + method + " Reply]=" + " Ex: " + e.getMessage());
	        e.printStackTrace(System.out);
	    } catch (Exception e) {
	        typeGame = "OTRO";
	        LoggerApi.Log.info("[" + method + " Reply]=" + " Ex: " + e.getMessage());
	        e.printStackTrace(System.out);
	    }
		return typeGame;
	}
	
	

	public   String castReponseGolden(Object objeto,String respuestaApiGolden ) {		
		
		StringBuffer htmlTextHeader = new StringBuffer();
		StringBuffer htmlTextBodyApuesta = new StringBuffer();
		StringBuffer htmlTextBodyEventos = new StringBuffer();	
		StringBuffer htmlTextTemplate = new StringBuffer();
		
		Gson gson = new Gson();
		int numEventos =0;
		int numApuestas = 0;
		String method="method castReponseGolden";
		String betType = "";
		LoggerApi.Log.info(method+ "START ============================================================================");
		List<Double>  listaCuotas=new ArrayList<Double>();
		
		String id;
		String estado;
		String fecha;
		String importe;
		String ganancia;
		 
		 try {
			 //TICKETS DE FUTBOL
			 if (objeto instanceof TicketGoldenFutbol) {
		            TicketGoldenFutbol ticket = (TicketGoldenFutbol) objeto;
		            ticket = gson.fromJson(respuestaApiGolden, TicketGoldenFutbol.class);
            
		            //Apuestas Simple o Combinada
			        numEventos= ticket.getDetails().getEvents().size();
			        if( numEventos == 1 ) {
			        	betType="Simple";
			        }else if ( numEventos > 1 ){//Combinada
			        	betType="Combinada";
		            }
  
			        // Cabecera del ticket  
			        LoggerApi.Log.info("FUTBOL ID de Ticket: " + ticket.getTicketId());
		            id=  Long.toString(ticket.getTicketId());
		            estado= ticket.getStatus();
		            fecha=formatearFecha(ticket.getTimeRegister());
		            importe=  String.format("%.2f", ticket.getStake());
		            
		            LoggerApi.Log.info("Estado: " + ticket.getStatus() != null ? ticket.getStatus() : null);  
		            //Con Premio Sin Premio
		            if( "WON".equals(estado)  || "PAIDOUT".equals(estado)) {
		            	LoggerApi.Log.info("Con Premio Golden Futbol: " + ticket.getWonData().getWonAmount());
		            	ganancia =  String.format("%.2f", (ticket.getWonData().getWonAmount() + ticket.getWonData().getWonJackpot()));
		            }else  {
		            	ganancia="0.00";
		            }
		            
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	                	//obtener cuotas
	                	for (int j = 0; j < numApuestas ; j++) {
	                		listaCuotas.add(  Double.parseDouble(ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue()) );					
						}	
					}
		            //cabecera
		            htmlTextHeader.append(  getHtmlHeader(id, estado, fecha, betType, importe, ganancia).toString() ); 
		            // Apuestas - Resumen de combinadas solo en combinadas
		            if ( numEventos > 1 ){	
		            	htmlTextBodyApuesta.append( getHtmlTipoCombinaciones(getCombinations(respuestaApiGolden)).toString() );
		            }
		            
		            //Eventos
		            htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'>");
		            htmlTextBodyEventos.append("<tbody>");
		            htmlTextBodyEventos.append("<tr class='table-active tableHead'><th>Eventos - ").append( consultTranslate(consultName( String.valueOf(ticket.getDetails().getEvents().get(0).getPlaylistId()))) ).append("</th></tr>");
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	                	//detalle de cada apuesta
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		// para iterar
	    		            htmlTextBodyEventos.append("<tr>");
	    		            htmlTextBodyEventos.append("<td>");
	    		            htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'><tbody>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Evento</th><td>").append(ticket.getDetails().getEvents().get(i).getEventId() + "  " + ticket.getDetails().getEvents().get(i).getData().getParticipants().get(0).getFifaCode() + "-"+ ticket.getDetails().getEvents().get(i).getData().getParticipants().get(1).getFifaCode()).append("</td></tr>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Fecha Inicio</th><td>").append( formatearFecha(ticket.getDetails().getEvents().get(i).getEventTime()) ).append("</td></tr>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Mercados</th><td>").append( consultTranslate(ticket.getDetails().getEvents().get(i).getBets().get(j).getMarketId())  ).append("</td></tr>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Seleccion</th><td>").append( consultTranslate(ticket.getDetails().getEvents().get(i).getBets().get(j).getOddId()) ).append("</td></tr>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Tipo</th><td>").append(betType).append("</td></tr>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Cuota</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue() ).append("</td></tr>");
	    		            htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Resultado</th><td>").append(  convertState(ticket.getDetails().getEvents().get(i).getBets().get(j).getStatus()) ).append("</td></tr>");
	    		            htmlTextBodyEventos.append("</tbody></table>");
	    		            htmlTextBodyEventos.append("</td>");
	    		            htmlTextBodyEventos.append("</tr>");
	    		            // para iterar
						}	
					}
		            
		            htmlTextBodyEventos.append("</tbody>");
		            htmlTextBodyEventos.append("</table>");  

		        }else  if (objeto instanceof TicketGoldenDog) {//TICKETS DE GALGOS
		        	
		        	TicketGoldenDog ticket = (TicketGoldenDog) objeto;
		        	ticket = gson.fromJson(respuestaApiGolden, TicketGoldenDog.class);
		        	
		        	//Apuestas Simple o Combinada
			        numEventos= ticket.getDetails().getEvents().size();
			        if( numEventos == 1 ) {
			        	betType="Simple";
			        }else if ( numEventos > 1 ){//Combinada
			        	betType="Combinada";
		            }
			        
			        //Cabecera del ticket
			        LoggerApi.Log.info("GALGOS Y OTROS ID de Ticket: " + ticket.getTicketId());
		            
		            id=  Long.toString(ticket.getTicketId());
		            estado= ticket.getStatus();
		            fecha=formatearFecha(ticket.getTimeRegister());
		            importe=  String.format("%.2f", ticket.getStake());
		            
		            LoggerApi.Log.info("Con Premio Golden Futbol: " + ticket.getWonData().getWonAmount());
		            //Con Premio Sin Premio
		            if( "WON".equals(estado)|| "PAIDOUT".equals(estado)) {
		            	LoggerApi.Log.info("Con Premio Galgos: " + ticket.getWonData().getWonAmount());
		            	ganancia =  String.format("%.2f", (ticket.getWonData().getWonAmount() +  ticket.getWonData().getWonJackpot()));
		            }else  {
		            	ganancia="0.00";
		            }
		            
		            for (int i = 0; i < numEventos; i++) {
	            		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	            		//obtener cuotas
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		listaCuotas.add( Double.parseDouble(ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue()) );	// Cuota			
						} 
					}
		            
		            //Cabecera
		            htmlTextHeader.append( getHtmlHeader(id, estado, fecha, betType, importe, ganancia).toString() );
		            //Eventos
		            htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'>");
		            htmlTextBodyEventos.append("<tbody>");
		            htmlTextBodyEventos.append("<tr class='table-active tableHead'><th>Eventos - ").append( getTitleGame(ticket.getGameType().get(0)) ).append("</th></tr>"); //Nombre del evento

		            //Nombre del evento
		            for (int i = 0; i < numEventos; i++) {
	            		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	            		//detalle de cada apuesta
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		htmlTextBodyEventos.append("<tr>");
	                		htmlTextBodyEventos.append("<td>");
	                		htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'><tbody>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Evento</th><td>").append( consultTranslate(consultName(String.valueOf(ticket.getDetails().getEvents().get(0).getPlaylistId()))) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Fecha Inicio</th><td>").append( formatearFecha(ticket.getDetails().getEvents().get(i).getEventTime()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Mercados</th><td>").append( consultTranslate(ticket.getDetails().getEvents().get(i).getBets().get(j).getMarketId()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Seleccion</th><td>").append( consultTranslate(ticket.getDetails().getEvents().get(i).getBets().get(j).getBetParam() !=null? ticket.getDetails().getEvents().get(i).getBets().get(j).getBetParam():ticket.getDetails().getEvents().get(i).getBets().get(j).getOddId()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Tipo</th><td>").append("Simple").append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Cuota</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue()  ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Resultado</th><td>").append( convertState(ticket.getDetails().getEvents().get(i).getBets().get(j).getStatus())  ).append("</td></tr>");
	                		htmlTextBodyEventos.append("</tbody></table>");
	                		htmlTextBodyEventos.append("</td>");
	                		htmlTextBodyEventos.append("</tr>");
						}
					}
		            htmlTextBodyEventos.append("</tbody>");
		            htmlTextBodyEventos.append("</table>");

		        }else  if (objeto instanceof TicketGoldenKinelo) {
		        	
		        	TicketGoldenKinelo ticket = (TicketGoldenKinelo) objeto;
		        	ticket = gson.fromJson(respuestaApiGolden, TicketGoldenKinelo.class);
		        	
		        	numEventos= ticket.getDetails().getEvents().size();
		        	//Cabecera del ticket
		        	LoggerApi.Log.info("KINELO ID de Ticket: " + ticket.getTicketId());
		            
		            id=  Long.toString(ticket.getTicketId());
		            estado= ticket.getStatus();
		            fecha=formatearFecha(ticket.getTimeRegister());
		            importe=  String.format("%.2f", ticket.getStake());
		            betType="Simple"; 
		            //Con Premio Sin Premio
		            
		            LoggerApi.Log.info("Estado: " + ticket.getStatus() != null ? ticket.getStatus() : null);   
		            if( "WON".equals(estado) || "PAIDOUT".equals(estado)) {
		            	LoggerApi.Log.info("Con Premio Kinelo " + ticket.getWonData().getWonAmount());
		            	ganancia =  String.format("%.2f", (ticket.getWonData().getWonAmount() + ticket.getWonData().getWonJackpot()));
		            }else  {
		            	ganancia="0.00";
		            }   
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
                		//obtener cuotas
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		listaCuotas.add( Double.parseDouble(ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue()) ); // Cuota					
	                	}	
		            }
		            
		            //Cabecera
		            htmlTextHeader.append( getHtmlHeader(id, estado, fecha, betType, importe, ganancia ).toString() );     
		            // Eventos
		            htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'>");
		            htmlTextBodyEventos.append("<tbody>");
		            htmlTextBodyEventos.append("<tr class='table-active tableHead'><th>Eventos -").append( getTitleGame(ticket.getGameType().get(0)) ).append("</th></tr>");
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	                	//detalle de cada apuesta
	                	for (int j = 0; j < numApuestas ; j++) {	
	                		// para iterar
	                		htmlTextBodyEventos.append("<tr>");
	                		htmlTextBodyEventos.append("<td>");
	                		htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'><tbody>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Evento</th><td>").append( ticket.getDetails().getEvents().get(i).getEventId() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Fecha Inicio</th><td>").append( formatearFecha(ticket.getDetails().getEvents().get(i).getEventTime()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Mercados</th><td>").append("Número").append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Seleccion</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getBetParam() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Tipo</th><td>").append("Simple").append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Cuota</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Resultado</th><td>").append( convertState(ticket.getDetails().getEvents().get(i).getBets().get(j).getStatus()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("</tbody></table>");
	                		htmlTextBodyEventos.append("</td>");
	                		htmlTextBodyEventos.append("</tr>");
	                		// para iterar
					
	                	}	
		            }
		            htmlTextBodyEventos.append("</tbody>");
		            htmlTextBodyEventos.append("</table>");
 
			        
		        }else  if (objeto instanceof TicketGoldenGiraGana) {
		        	
		        	TicketGoldenGiraGana ticket = (TicketGoldenGiraGana) objeto;
		        	ticket = gson.fromJson(respuestaApiGolden, TicketGoldenGiraGana.class);
		        	
		        	numEventos= ticket.getDetails().getEvents().size();
		        	//Cabecera del ticket
		        	LoggerApi.Log.info("GIRA GANA ID de Ticket: " + ticket.getTicketId());
		            
		            id=  Long.toString(ticket.getTicketId());
		            estado= ticket.getStatus();
		            fecha=formatearFecha(ticket.getTimeRegister());
		            importe=  String.format("%.2f", ticket.getStake());
		            betType="Simple";
		            
		            //Con Premio Sin Premio
		            LoggerApi.Log.info("Estado: " + ticket.getStatus() != null ? ticket.getStatus() : null);   
		            if( "WON".equals(estado) || "PAIDOUT".equals(estado)) {
		            	LoggerApi.Log.info("Con Premio gira y gana: " + ticket.getWonData().getWonAmount());
		            	ganancia =  String.format("%.2f", (ticket.getWonData().getWonAmount() + ticket.getWonData().getWonJackpot()));
		            }else  {
		            	ganancia="0.00";
		            }
		            
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
                		//obtener cuotas
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		listaCuotas.add(  Double.parseDouble(ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue()) ); // Cuota				
	                	}	
		            }
		            
		            //Cabecera
		            htmlTextHeader.append( getHtmlHeader(id, estado, fecha, betType, importe, ganancia).toString() );  
		            // Eventos
		            htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'>");
		            htmlTextBodyEventos.append("<tbody>");
		            htmlTextBodyEventos.append("<tr class='table-active tableHead'><th>Eventos - ").append( getTitleGame(ticket.getGameType().get(0)) ).append("</th></tr>");
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	                	//detalle de cada apuesta
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		// para iterar
	                		htmlTextBodyEventos.append("<tr>");
	                		htmlTextBodyEventos.append("<td>");
	                		htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'><tbody>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Evento</th><td>").append( ticket.getDetails().getEvents().get(i).getEventId() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Fecha Inicio</th><td>").append( formatearFecha(ticket.getDetails().getEvents().get(i).getEventTime()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Mercados</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getMarketName() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Seleccion</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddName() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Tipo</th><td>").append( "Simple" ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Cuota</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Resultado</th><td>").append( convertState(ticket.getDetails().getEvents().get(i).getBets().get(j).getStatus()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("</tbody></table>");
	                		htmlTextBodyEventos.append("</td>");
	                		htmlTextBodyEventos.append("</tr>");
	                		// para iterar				
	                	}	
		            }
		            htmlTextBodyEventos.append("</tbody>");
		            htmlTextBodyEventos.append("</table>");
		            

		        }else  if (objeto instanceof TicketGoldenColor) {
		        	
		        	TicketGoldenColor ticket = (TicketGoldenColor) objeto;
		        	ticket = gson.fromJson(respuestaApiGolden, TicketGoldenColor.class);
		        	
		        	numEventos= ticket.getDetails().getEvents().size();
		        	//Cabecera del ticket
		        	LoggerApi.Log.info("COLOR ID de Ticket: " + ticket.getTicketId());
		            
		            id=  Long.toString(ticket.getTicketId());
		            estado= ticket.getStatus();
		            fecha=formatearFecha(ticket.getTimeRegister());
		            importe=  String.format("%.2f", ticket.getStake());
		            betType="Simple";
		            
		            //Con Premio Sin Premio
		            LoggerApi.Log.info("Estado: " + ticket.getStatus() != null ? ticket.getStatus() : null);   
		            if( "WON".equals(estado) || "PAIDOUT".equals(estado)) {
		            	LoggerApi.Log.info("Con Premio golden color: " + ticket.getWonData().getWonAmount());            	
		            	ganancia =  String.format("%.2f", (ticket.getWonData().getWonAmount() + ticket.getWonData().getWonJackpot()));
		            }else  {
		            	ganancia="0.00";
		            }
		            
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	                	//detalle de cada apuesta
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		listaCuotas.add(  Double.parseDouble( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue()) ); // Cuota		
	                	}	
		            }
		            
		            //Cabecera
		            htmlTextHeader.append( getHtmlHeader(id, estado, fecha, betType, importe,ganancia).toString() );    
		            
		            //Eventos
		            htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'>");
		            htmlTextBodyEventos.append("<tbody>");
		            htmlTextBodyEventos.append("<tr class='table-active tableHead'><th>Eventos - ").append( getTitleGame(ticket.getGameType().get(0)) ).append("</th></tr>");
		            for (int i = 0; i < numEventos; i++) {
                		numApuestas= ticket.getDetails().getEvents().get(i).getBets().size();
	                	//detalle de cada apuesta
	                	for (int j = 0; j < numApuestas ; j++) {		
	                		// para iterar
	                		htmlTextBodyEventos.append("<tr>");
	                		htmlTextBodyEventos.append("<td>");
	                		htmlTextBodyEventos.append("<table class='table-gracia table-bordered table-hover'><tbody>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Evento</th><td>").append( ticket.getDetails().getEvents().get(i).getEventId() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Fecha Inicio</th><td>").append( formatearFecha(ticket.getDetails().getEvents().get(i).getEventTime()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Mercados</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getMarketName() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Seleccion</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getBetParam() !=null? ticket.getDetails().getEvents().get(i).getBets().get(j).getBetParam():ticket.getDetails().getEvents().get(i).getBets().get(j).getOddName() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Tipo</th><td>").append( "Simple" ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Cuota</th><td>").append( ticket.getDetails().getEvents().get(i).getBets().get(j).getOddValue() ).append("</td></tr>");
	                		htmlTextBodyEventos.append("<tr><th class='tableSubHead'>Resultado</th><td>").append( convertState(ticket.getDetails().getEvents().get(i).getBets().get(j).getStatus()) ).append("</td></tr>");
	                		htmlTextBodyEventos.append("</tbody></table>");
	                		htmlTextBodyEventos.append("</td>");
	                		htmlTextBodyEventos.append("</tr>");
	                		// para iterar			
	                	}	
		            }
		            htmlTextBodyEventos.append("</tbody>");
		            htmlTextBodyEventos.append("</table>");
		            
		        }
			 
			 //LLENAR LA INFORMACION 
			 htmlTextTemplate.append(htmlTextHeader.toString()==null ?"":htmlTextHeader.toString());
			 htmlTextTemplate.append(htmlTextBodyApuesta.toString()==null ?"":htmlTextBodyApuesta.toString());
			 htmlTextTemplate.append(htmlTextBodyEventos.toString()==null ?"":htmlTextBodyEventos.toString());
	         
	         //htmlTextTemplate.append(htmlTextHeader.toString());
			
		} catch (JsonSyntaxException e) {
	        
	        LoggerApi.Log.info("[" + method + " Reply]=" + " Ex: " + e.getMessage());
	        e.printStackTrace(System.out);
	    } catch (Exception e) {
	        
	        LoggerApi.Log.info("[" + method + " Reply]=" + " Ex: " + e.getMessage());
	        e.printStackTrace(System.out);
	    }

		 LoggerApi.Log.info(method+ "START ============================================================================");
		 
		return htmlTextTemplate.toString();
	}
	
	public static  List<String[]>  getCombinations(String stringJson) {
	
		ArrayList<String[]> arrayListOfArrays = new ArrayList<String[]>();
		
		// Parsear el JSON
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(stringJson).getAsJsonObject();  
        // Navegar hasta el array systemBets
        JsonObject detailsObject = jsonObject.getAsJsonObject("details");
        if (detailsObject != null) {
            JsonArray systemBetsArray = detailsObject.getAsJsonArray("systemBets");
            if (systemBetsArray != null) {
                for (JsonElement betElement : systemBetsArray) {
                    JsonObject betObject = betElement.getAsJsonObject();
                    String grouping = betObject.get("grouping").getAsString();
                    String systemCount = betObject.get("systemCount").getAsString();
                    String stake =  String.format("%.2f", betObject.get("stake").getAsDouble() ); 
                    String[] arrayList = {grouping, systemCount,stake};
                    // Agregar los arrays al ArrayList
                    arrayListOfArrays.add(arrayList); 
                }
            } 
        }
        
        return arrayListOfArrays;
	}
	
	/*public  String getTypeGame  (String stringJson) {
		
		ArrayList<String> listaCombinacion = new ArrayList<String>();
		String tipoJuego = "";	
		// Parsear el JSON
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(stringJson).getAsJsonObject();  
        // Navegar hasta el array systemBets
        JsonObject detailsObject = jsonObject.getAsJsonObject("details");
        if (detailsObject != null) {
            JsonArray systemBetsArray = detailsObject.getAsJsonArray("systemBets");
            if (systemBetsArray != null) {
                for (JsonElement betElement : systemBetsArray) {
                    JsonObject betObject = betElement.getAsJsonObject();
                    String grouping = betObject.get("grouping").getAsString();
                    String systemCount = betObject.get("systemCount").getAsString();
                    String stake =  String.format("%.2f", betObject.get("stake") ); 
                    listaCombinacion.add(grouping==null?"KO":grouping);
                    listaCombinacion.add(systemCount==null?"KO":systemCount);
                    listaCombinacion.add(stake==null?"KO":stake);
                    
                    // Imprimir los valores
                    System.out.println("Grouping: " + listaCombinacion.get(0));
                    System.out.println("System Count: " + listaCombinacion.get(1));
                }
            } else {
                System.out.println("No system bets found.");
                tipoJuego="Simple";
            }
        } else {
            System.out.println("Details object not found.");
        }
        
        return tipoJuego;
	}*/
	
	public   StringBuffer getHtmlHeader ( String id, String estado, String fecha, String tipoApuesta,String importe, String ganancia ) {
		StringBuffer htmlTextHeader = new StringBuffer();
		htmlTextHeader.append("<table class='table-gracia table-bordered table-hover'>");
		htmlTextHeader.append("<tbody>");
		htmlTextHeader.append("<tr class='table-active tableHead'><th colspan='2'>Cupón</th></tr>");
		htmlTextHeader.append("<tr><th>Cód. De Apuesta</th><td>").append(id).append("</td></tr>");
		htmlTextHeader.append("<tr><th>ID de cupón</th><td>").append(id).append("</td></tr>");;
		htmlTextHeader.append("<tr><th>Estado del cupón</th><td>").append( convertState(estado) ).append("</td></tr>");
		htmlTextHeader.append("<tr><th>Fecha</th><td>").append(fecha).append("</td></tr>");
		htmlTextHeader.append("<tr><th>Importe</th><td> S/").append(importe).append("</td></tr>");
		htmlTextHeader.append("<tr><th>Ganancias Totales</th><td> S/").append(ganancia).append("</td></tr>");
		htmlTextHeader.append("</tbody>");
		htmlTextHeader.append("</table>"); 
        return htmlTextHeader;	
	}
	
	public    String convertState( String status  ) {
		
		String statusEN="";
		
		if( "WON".equals(status) ) {
			statusEN="Ganador";
		}else if ( "LOST".equals(status) ) {
			statusEN="Sin Premio";
		}else if ( "PENDING".equals(status) ) {
			statusEN="Pendiente";
		}else if ( "EXPIRED".equals(status) ) {
			statusEN="Expirado";
		}else if ( "PAIDOUT".equals(status) ) {
			statusEN="Pagado";
		}else if ( "CANCELLED".equals(status) ) {
			statusEN="Cancelado";
		}else if ( "REJECTED".equals(status) ) {
			statusEN="Rechazado";
		}else  {
			statusEN="Pendiente";
		}
	
		
	return statusEN;	
	}
	
	
	public    StringBuffer getHtmlTipoCombinaciones(List<String[]>  listaCombinacion) {
		
		StringBuffer htmlTextBodyApuesta = new StringBuffer();
    	
    	//------------------------------------------------
    	htmlTextBodyApuesta.append("<table class='table-gracia table-bordered table-hover'>");
    	htmlTextBodyApuesta.append("<tbody>");
    	htmlTextBodyApuesta.append("<tr class='table-active tableHead'><th>Apuestas</th></tr>");
    	// para iterar
    	for ( int i=0; i< listaCombinacion.size(); i++) {
    	htmlTextBodyApuesta.append("<tr>");
    	htmlTextBodyApuesta.append("<td>");
    	htmlTextBodyApuesta.append("<table class='table-gracia table-bordered table-hover'>");
    	htmlTextBodyApuesta.append("<tbody>");
    	htmlTextBodyApuesta.append("<tr><th class='tableSubHead'>Tipo de combinación</th><td> Grupo").append(listaCombinacion.get(i)[0]).append("</td></tr>");
    	htmlTextBodyApuesta.append("<tr><th class='tableSubHead'>N de combinaciones</th><td> Combinada").append(listaCombinacion.get(i)[1]).append("</td></tr>");
    	htmlTextBodyApuesta.append("<tr><th class='tableSubHead'>Apuesta</th><td> S/").append(listaCombinacion.get(i)[2]).append("</td></tr>");
    	htmlTextBodyApuesta.append("</tbody>");
    	htmlTextBodyApuesta.append("</table>");
    	htmlTextBodyApuesta.append("</td>");
    	htmlTextBodyApuesta.append("</tr>");
    	}
    	// para iterar
    	htmlTextBodyApuesta.append("</tbody>");
    	htmlTextBodyApuesta.append("</table>");

	
		return htmlTextBodyApuesta;
		
		
	}
	
	public   String getTitleGame (String code) {
		
		Map<String, String> gameTypeMap = new HashMap<String, String>();
		gameTypeMap.put("CH", "Carrera ");
		gameTypeMap.put("DOG", "Carrera de Galgos");
		gameTypeMap.put("HORSE", "Carrera de Caballos");
		gameTypeMap.put("DIRTTRACK", "Carrera de Dirt Track");
		gameTypeMap.put("KART", "Carrera de Karts");
		gameTypeMap.put("MOTORBIKE", "Carrera de Motos");
		gameTypeMap.put("MMA", "Combate individual de MMA");
		gameTypeMap.put("KN", "Kinel8");
		gameTypeMap.put("SN", "Gira y Gana");
		gameTypeMap.put("RAINBOW", "Color Color");
		gameTypeMap.put("PENALTY", "Penalt2Win");
		
		return gameTypeMap.get(code)==null?"Carrera":gameTypeMap.get(code);
	}
	
	 // Convertir la fecha ISO 8601 a hora peru
	public   String formatearFecha( String isoDate ) {
		
		String peruDate=null;
		try {	
			if (isoDate != null ) {
				// Parsear la fecha en formato ISO 8601
	            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	            isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	            Date date = isoFormat.parse(isoDate);

	            // Convertir a la zona horaria de Perú
	            SimpleDateFormat peruFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	            peruFormat.setTimeZone(TimeZone.getTimeZone("America/Lima"));
	            peruDate = peruFormat.format(date);

			}else {
				isoDate="--";
				peruDate="--";
			}   
        } catch (ParseException e) {
            e.printStackTrace();
            peruDate="--";
        }
		
		return peruDate;	
	}
	
	//obtener el nombre del evento
	public String consultName(String codigo ) throws Exception {
		
		String respuestaApiGolden =null;
		String shortName="";
		String fullName="";
		String url = Constantes.GOLDEN_URL_FINDBYLIST; //"https://america-api.virtustec.com/api/external/v2/playlists/findByIds";
    	String tipo="findTickets";
    	//Realizar conexion y recibir rpta
    	respuestaApiGolden = sendRequestGolden(codigo, url, tipo);
    	try {
    		 // Parsear el JSON
            JsonParser parser = new JsonParser();
            JsonElement jsonTree = parser.parse(respuestaApiGolden);   
            // Verificar si es un array
            if (jsonTree.isJsonArray()) {
                JsonArray jsonArray = jsonTree.getAsJsonArray();
                // Obtener el primer objeto en el array
                JsonObject firstObject = jsonArray.get(0).getAsJsonObject();
                // Obtener el valor de "shortName"
                if (firstObject.has("shortName")) {
                	shortName= firstObject.get("shortName").getAsString();
                } else {
                    shortName="-";
                }
            } else {
                shortName="-";
            }	
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return shortName;
	}
	
	//obtener traduccion de mercado seleccion
	public  String consultTranslate(String codigo ) throws Exception {
			
		String fullName="";
    	try {        
            //consulta a BBDD con procedure
    		DeportesvirtualesProcedureGetEventsTraduction deportesvirtualesProcedureGetEventsTraduction = deportesVirtualesBo.getEventsTraduction(codigo);
        	fullName= deportesvirtualesProcedureGetEventsTraduction.getPlaylistTraduction();    	
		} catch (Exception e) {
			e.printStackTrace();
			fullName=codigo;
		}

    	return fullName;
	}
	
	




}
