package pe.com.intralot.loto.layer.service.game.ganagol.boimpl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureProgramData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.GanagolSaleDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.ganagol.bo.GanagolBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.CombinacionesUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.CotejadorUtil;
import pe.com.intralot.loto.util.GanagolcotejadorUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class GanagolBoImpl implements GanagolBo {

    @Autowired
    private GanagolSaleDao ganagolSaleDao;
	
	@Autowired
	private TicketSaleBo ticketSaleBo;
	
    @Autowired
    private ClientTicketBo clientTicketBo;
    
    @Autowired
    private DrawBo drawBo;
    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isGanagolSale = Boolean.valueOf(ConnectionFactory.operationProperty("ganagolSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String ganagolSaleUsers = String.valueOf(ConnectionFactory.operationProperty("ganagolSaleUsers", Constants.contextSale)).toString().trim();
        if (isGanagolSale == false) {
            if (ganagolSaleUsers != null && !ganagolSaleUsers.equals("")) {
                String[] saleUsers = ganagolSaleUsers.split(",");
                for (String saleUser : saleUsers)
                    if (saleUser.equals(user)) {
                        isAllowed = true;
                        break;
                    } else
                        isAllowed = false;
            }
        } else
            isAllowed = true;
        return isAllowed;
    }

    @Override
    public GanagolProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        GanagolProcedureBetData objectDomain = new GanagolProcedureBetData();
        try {
            objectDomain = ganagolSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("Status=" + objectDomain.getStatus() + " Message=" + objectDomain.getMessage() + " Prize=" + objectDomain.getPrize()
                        + " ActiveDraw=" + objectDomain.getActiveDraw() + " CloseDate=" + objectDomain.getCloseDate() + " CloseHour=" + objectDomain.getCloseHour()
                        + " NextDraw=" + objectDomain.getNextDraw() + " OpenDate=" + objectDomain.getOpenDate() + " OpenHour=" + objectDomain.getOpenHour()
                        + " Notes= " + objectDomain.getNotes() + " Program=" + objectDomain.getProgram() + " PriceType=" + objectDomain.getPriceType()
                        + " PriceMessage=" + objectDomain.getPriceMessage() + " SimpleBetPrice=" + objectDomain.getSimpleBetPrice() + " PromotionType=" + objectDomain.getPromotionType() 
                        + " BalanceAmount=" + objectDomain.getBalanceAmount() + " BalanceAmountGame=" + objectDomain.getBalanceAmountGame() + " BalanceQuantityGame=" + objectDomain.getBalanceQuantityGame()
                        + " Algorithm=" + objectDomain.getAlgorithm() + " Bets=" + objectDomain.getBets() + " Pay=" + objectDomain.getPay() + " Draws=" + objectDomain.getDraws() + " Cost=" + objectDomain.getCost() 
                        + " OtherAmount=" + objectDomain.getOtherAmount());        }
        return objectDomain;
    }

    @Override
    public List<GanagolProcedureDrawData> findListDrawData() throws Exception {
        List<GanagolProcedureDrawData> resultQueryList = new ArrayList<GanagolProcedureDrawData>();
        try {
            resultQueryList = ganagolSaleDao.findListDrawData();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }


	@Override
	public JsonArray cotejadorGanagol(int clientId, int gameId, Long ticketId)
			throws Exception {
		JsonArray juego_completo = new JsonArray();
    	AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
    	num_a.diez_aciertos =0;
    	num_a.once_aciertos =0;
	  	num_a.doce_aciertos =0;
	  	num_a.trece_aciertos =0;
	  	num_a.catorce_aciertos =0;  
	  	TicketProcedureGetClientTicket ticketSale = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
        GanagolcotejadorUtil ad= new GanagolcotejadorUtil();
        CotejadorUtil clase_ord = new CotejadorUtil();
        String it_jugada="";
        int ticke_id_num=0,ct_from_draw=0,ct_to_draw=0,draw_num=0;
        String ctbM1="",ctbM2="",ctbM3="",ctbM4="";
        String result = "",a_result="";
        Date fecha ;
		try {
			
			JsonObject datos_jugada = new JsonObject();
			
			int recorrido_1=0,recorrido_2=0,recorrido_3=0,recorrido_4=0;
						
			ArrayList resultado = new ArrayList();
			ArrayList a_sorteo = new ArrayList();
			ArrayList a_fecha = new ArrayList();
			ClientTicket ticket = clientTicketBo.findById(ticketId);
			
			draw_num=Integer.parseInt(ticket.getCtDrawId());
			Draw draw = drawBo.findByIdByGameId(draw_num,gameId);
			
			ticke_id_num=Integer.parseInt(ticket.getTicketId());
			ctbM1=" "+ticket.getCtBetMatrix1()+" ";
			ctbM2=" "+ticket.getCtBetMatrix2()+" ";
			ctbM3=" "+ticket.getCtBetMatrix3()+" ";
			ctbM4=" "+ticket.getCtBetMatrix4()+" ";
			ct_from_draw=ticket.getCtFromDraw();
			ct_to_draw=ticket.getCtToDraw();
			result =" "+draw.getDrResult()+" ";	
				
			int j=0;
			for(int i=ct_from_draw;i<=ct_to_draw;i++){
			
				Draw draw_array = drawBo.findByIdByGameId(i,gameId);
				
				String recorrido=" "+draw_array.getDrResult()+" ";
				resultado.add(recorrido);
				
				
				String fecha_r =" "+draw_array.getDrDate()+" ";
				String fecha_completa=fecha_r+"";
				String dia="",mes="",ano="",fechas="";
		        ano=fecha_completa.substring(1, 5);
		        mes=fecha_completa.substring(6, 8);
		        dia=fecha_completa.substring(9, 11);
		        fechas=dia+"/"+mes+"/"+ano;
		        a_fecha.add(fechas);
		        a_sorteo.add(i);     
		        
				j++;
			}
			String num_sorteo= a_sorteo.toString().replace("[","").replace("]","");
			fecha =draw.getDrDate();
			String fecha_completa=fecha+"";
			String dia="",mes="",ano="",fechas="";
	        ano=fecha_completa.substring(0, 4);
	        mes=fecha_completa.substring(5, 7);
	        dia=fecha_completa.substring(8, 10);
	        fechas=dia+"/"+mes+"/"+ano;
	        
	        datos_jugada.addProperty("fecha", fechas);
	        datos_jugada.addProperty("num_sorteo", num_sorteo);
	        datos_jugada.addProperty("resultados", result);
	        datos_jugada.addProperty("ctbM1", ctbM1);
	        datos_jugada.addProperty("ctbM2", ctbM2);
	        datos_jugada.addProperty("ctbM3", ctbM3);
	        datos_jugada.addProperty("ctbM4", ctbM4); 
	        
	        if(ctbM1.length()>2){
				datos_jugada.add("cotejo_jugadaA", new Gson().toJsonTree(ad.aciertos_depo(ctbM1, result)));
				recorrido_1=2;

			}
			if(ctbM2.length()>6){
				datos_jugada.add("cotejo_jugadaB", new Gson().toJsonTree(ad.aciertos_depo(ctbM2, result)));
				recorrido_2=2;

			}
			if(ctbM3.length()>6){
				datos_jugada.add("cotejo_jugadaC", new Gson().toJsonTree(ad.aciertos_depo(ctbM3, result)));
				recorrido_3=2;

			}
			if(ctbM4.length()>6){
				datos_jugada.add("cotejo_jugadaD", new Gson().toJsonTree(ad.aciertos_depo(ctbM4, result)));
				recorrido_4=2;

			}	
			
			
						
	        juego_completo.add(datos_jugada);
	        
		}
		catch(Exception ex){
		System.out.println("MENSAJE WARNING GANAGOL : "+ex.getMessage());
		}
		return juego_completo;
	}


	@Override
	public JsonArray resultado_premios(Integer clientId, Integer gameId,
			Long ticketId) {
		
		JsonArray tabla_resultados= new JsonArray();
		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		try{
			TicketProcedureGetClientTicket ticketSale = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
			if(num_a.getDiez_aciertos()>0){
				JsonObject datos_tabla_result = new JsonObject();
				Map aciertos = new HashMap();
				ArrayList datos_tabla = new ArrayList();
				aciertos.put("aciertos", "10 aciertos");
				aciertos.put("total_aciertos", num_a.getDiez_aciertos());	
				//aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());
				if(ticketSale.getCtPrizeExpirationDate()==null || ticketSale.getCtPrizeExpirationDate().equals(" ")){
				aciertos.put("caduca", "-");
				}else{
				aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());	
				}
				datos_tabla.add(aciertos);
				datos_tabla_result.add("cotejo_jugada", new Gson().toJsonTree(datos_tabla));
				tabla_resultados.add(datos_tabla_result);
				
			}if(num_a.getOnce_aciertos()>0){
				JsonObject datos_tabla_result = new JsonObject();
				Map aciertos = new HashMap();
				ArrayList datos_tabla = new ArrayList();
				aciertos.put("aciertos", "11 aciertos");
				aciertos.put("total_aciertos", num_a.getOnce_aciertos());
				//aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());
				if(ticketSale.getCtPrizeExpirationDate()==null || ticketSale.getCtPrizeExpirationDate().equals(" ")){
				aciertos.put("caduca", "-");
				}else{
				aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());	
				}
				datos_tabla.add(aciertos);
				datos_tabla_result.add("cotejo_jugada", new Gson().toJsonTree(datos_tabla));
				tabla_resultados.add(datos_tabla_result);
				
			}if(num_a.getDoce_aciertos()>0){
				JsonObject datos_tabla_result = new JsonObject();
				Map aciertos = new HashMap();
				ArrayList datos_tabla = new ArrayList();
				aciertos.put("aciertos", "12 acieros");
				aciertos.put("total_aciertos", num_a.getDoce_aciertos());
				//aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());
				if(ticketSale.getCtPrizeExpirationDate()==null || ticketSale.getCtPrizeExpirationDate().equals(" ")){
				aciertos.put("caduca", "-");
				}else{
				aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());	
				}
				datos_tabla.add(aciertos);
				datos_tabla_result.add("cotejo_jugada", new Gson().toJsonTree(datos_tabla));
				tabla_resultados.add(datos_tabla_result);
				
			}if(num_a.getTrece_aciertos()>0){
				JsonObject datos_tabla_result = new JsonObject();
				Map aciertos = new HashMap();
				ArrayList datos_tabla = new ArrayList();
				aciertos.put("aciertos", "13 aciertos");
				aciertos.put("total_aciertos", num_a.getTrece_aciertos());
				//aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());
				if(ticketSale.getCtPrizeExpirationDate()==null || ticketSale.getCtPrizeExpirationDate().equals(" ")){
				aciertos.put("caduca", "-");
				}else{
				aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());	
				}
				datos_tabla.add(aciertos);
				datos_tabla_result.add("cotejo_jugada", new Gson().toJsonTree(datos_tabla));
				tabla_resultados.add(datos_tabla_result);
				
			}if(num_a.getCatorce_aciertos()>0){
				JsonObject datos_tabla_result = new JsonObject();
				Map aciertos = new HashMap();
				ArrayList datos_tabla = new ArrayList();
				aciertos.put("aciertos","14 aciertos");
				aciertos.put("total_aciertos", num_a.getCatorce_aciertos());
				//aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());
				if(ticketSale.getCtPrizeExpirationDate()==null || ticketSale.getCtPrizeExpirationDate().equals(" ")){
				aciertos.put("caduca", "-");
				}else{
				aciertos.put("caduca", ticketSale.getCtPrizeExpirationDate());	
				}
				datos_tabla.add(aciertos);
				datos_tabla_result.add("cotejo_jugada", new Gson().toJsonTree(datos_tabla));
				tabla_resultados.add(datos_tabla_result);
			}	
		}catch(Exception ex){
			
		}
		NumberFormat formatter = new DecimalFormat("#0.00");
		//datos_jugada.addProperty("totalPremio",formatter.format(ticketSale.getCtTwPrizeAmount()));
		return tabla_resultados;
	}

	@Override
	public JsonArray premio_total(Integer clientId, Integer gameId,Long ticketId) {

		 double premio_t=0.0;
		 JsonArray premio_total = new JsonArray();
		 JsonObject premio= new JsonObject();
		try { 
			 TicketProcedureGetClientTicket ticket_client = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
			 NumberFormat formatter = new DecimalFormat("#0.00");
			 if(String.valueOf(premio_t)==null || String.valueOf(premio_t).equals(" ")){
				 premio.addProperty("premio","0.0");
			 }else{
				 premio.addProperty("premio",formatter.format(ticket_client.getCtTwPrizeAmount()));	 
			 }
			 
			 premio_total.add(premio);
			
		}catch(Exception e){
			System.out.println("Warning_Ganagol : "+e.getMessage());
		}
		
		return premio_total;
	}

	@Override
	public List<GanagolProcedureProgramData> findListProgramData(Integer p_drawId)
			throws Exception {
		List<GanagolProcedureProgramData> resultQueryList = new ArrayList<GanagolProcedureProgramData>();
        try {
            resultQueryList = ganagolSaleDao.findListProgramData(p_drawId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
	}

	 @Override
		public JsonArray datosJugadaCotejo(String tipo_jugada, int from, int to, int gameID, String jugadaCompl){
		 System.out.println("paso primero");
			JsonArray juego_completo = new JsonArray();
	    	AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
	    	String [] jugadaCompleta;
	    	jugadaCompleta=jugadaCompl.split(",");
			 
			 String jugadaA=jugadaCompleta[0].trim();
			 String jugadaB=jugadaCompleta[1].trim();
			 String jugadaC=jugadaCompleta[2].trim();
			 String jugadaD=jugadaCompleta[3].trim();
			 String golazoA=jugadaCompleta[4].trim();
			 String golazoB=jugadaCompleta[5].trim();
			 String golazoC=jugadaCompleta[6].trim();
			 String golazoD=jugadaCompleta[7].trim();
			 
	    	num_a.diez_aciertos =0;
	    	num_a.once_aciertos =0;
		  	num_a.doce_aciertos =0;
		  	num_a.trece_aciertos =0;
		  	num_a.catorce_aciertos =0;  
	        GanagolcotejadorUtil ad= new GanagolcotejadorUtil();
	        CotejadorUtil clase_ord = new CotejadorUtil();
	        String it_jugada="";
	        int ticke_id_num=0,ct_from_draw=0,ct_to_draw=0;
	        String ctbM1="",ctbM2="",ctbM3="",ctbM4="";
	        String result = "",a_result="", resultado_golazo200="";
	        Date fecha ;
			try {
				
				JsonObject datos_jugada = new JsonObject();
				
				int recorrido_1=0,recorrido_2=0,recorrido_3=0,recorrido_4=0;
				System.out.println("paso");			
				ArrayList resultado = new ArrayList();
				ArrayList a_sorteo = new ArrayList();
				ArrayList a_fecha = new ArrayList();
				
				Draw draw = drawBo.findByIdByGameId(from,gameID);
				
				ctbM1=" "+jugadaA+" ";
				ctbM2=" "+jugadaB+" ";
				ctbM3=" "+jugadaC+" ";
				ctbM4=" "+jugadaD+" ";
				
				result =" "+draw.getDrResult().toString()+" ";	
				resultado_golazo200=" "+draw.getDrAddonResult1().toString()+" ";
				System.out.println("paso2");
				int j=0;
				for(int i=from;i<=to;i++){
					System.out.println("paso antes del 3");
					Draw draw_array = drawBo.findByIdByGameId(i,gameID);
					System.out.println("paso3");
					String recorrido=" "+draw_array.getDrResult()+" ";
					System.out.println("paso4");
					resultado.add(recorrido);
					System.out.println("paso5");
					
					String fecha_r =" "+draw_array.getDrDate()+" ";
					System.out.println("paso6");
					String fecha_completa=fecha_r+"";
					String dia="",mes="",ano="",fechas="";
			        ano=fecha_completa.substring(1, 5);
			        mes=fecha_completa.substring(6, 8);
			        dia=fecha_completa.substring(9, 11);
			        fechas=dia+"/"+mes+"/"+ano;
			        a_fecha.add(fechas);
			        a_sorteo.add(i);     
			        System.out.println("paso7");
					j++;
				}
				System.out.println("paso8");
				String num_sorteo= a_sorteo.toString().replace("[","").replace("]","");
				fecha =draw.getDrDate();
				String fecha_completa=fecha+"";
				String dia="",mes="",ano="",fechas="";
		        ano=fecha_completa.substring(0, 4);
		        mes=fecha_completa.substring(5, 7);
		        dia=fecha_completa.substring(8, 10);
		        fechas=dia+"/"+mes+"/"+ano;
		        
		        System.out.println("paso9");
		        
		        datos_jugada.addProperty("fecha", fechas);
		        datos_jugada.addProperty("num_sorteo", num_sorteo);
		        datos_jugada.addProperty("resultados", result);
		        datos_jugada.addProperty("ctbM1", ctbM1);
		        datos_jugada.addProperty("ctbM2", ctbM2);
		        datos_jugada.addProperty("ctbM3", ctbM3);
		        datos_jugada.addProperty("ctbM4", ctbM4);
		        datos_jugada.addProperty("resultado_golazo200", resultado_golazo200);
		        System.out.println("paso10"); 
		        
		        System.out.println("paso11");
		        if(ctbM1!=null ){
		        	if(!ctbM1.trim().equals("null") && !ctbM1.trim().equals("") && !ctbM1.trim().equals(" vacio ")){
		        		System.out.print("ctbM1:"+ctbM1);
		        		if(ctbM1.length()>2){
		        			ctbM1=ctbM1.replace("", "");
		        			ArrayList<String> lista_jugada_final=ad.aciertos_depo(ctbM1, result);
		        			ad.acierto_golazo_200(lista_jugada_final, golazoA, resultado_golazo200);
		        			datos_jugada.add("cotejo_jugadaA", new Gson().toJsonTree(lista_jugada_final));
		        			
		        			recorrido_1=2;

		        		}
		        	}
		        }
		        
		        if(ctbM2!=null){
		        	if(!ctbM2.trim().equals("null") && !ctbM2.trim().equals("") && !ctbM2.trim().equals(" vacio ")){
		        	System.out.print("ctbM2:"+ctbM2);
				if(ctbM2.length()>6){
					ArrayList<String> lista_jugada_final=ad.aciertos_depo(ctbM2, result);
        			ad.acierto_golazo_200(lista_jugada_final, golazoB, resultado_golazo200);
					datos_jugada.add("cotejo_jugadaB", new Gson().toJsonTree(lista_jugada_final));
					recorrido_2=2;

				}
				}
				}
		        
		        if(ctbM3!=null){
		        	if(!ctbM3.trim().equals("null") && !ctbM3.trim().equals("") && !ctbM3.trim().equals(" vacio ")){
		        	System.out.print("ctbM3:"+ctbM3);
				if(ctbM3.length()>6){
					ArrayList<String> lista_jugada_final=ad.aciertos_depo(ctbM3, result);
        			ad.acierto_golazo_200(lista_jugada_final, golazoC, resultado_golazo200);
					datos_jugada.add("cotejo_jugadaC", new Gson().toJsonTree(lista_jugada_final));
					recorrido_3=2;

				}
		        }
		        }
		        
		        if(ctbM4!=null){
		        	if(!ctbM4.trim().equals("null") && !ctbM4.trim().equals("") && !ctbM4.trim().equals(" vacio ")){
		        	System.out.print("ctbM4:"+ctbM4);
				if(ctbM4.length()>6){
					ArrayList<String> lista_jugada_final=ad.aciertos_depo(ctbM4, result);
        			ad.acierto_golazo_200(lista_jugada_final, golazoD, resultado_golazo200);
					datos_jugada.add("cotejo_jugadaD", new Gson().toJsonTree(lista_jugada_final));
					recorrido_4=2;

				}	
		        }
		        }
				
							
		        juego_completo.add(datos_jugada);
		        
			}
			catch(Exception ex){
			System.out.println("MENSAJE WARNING GANAGOL : "+ex.getMessage());
			}
			return juego_completo;
		}
	 
}

