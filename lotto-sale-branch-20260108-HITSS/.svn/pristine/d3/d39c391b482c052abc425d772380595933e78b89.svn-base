package pe.com.intralot.loto.layer.service.game.super3.boimpl;

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
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.Super3SaleDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.super3.bo.Super3Bo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.Super3cotejadorUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class Super3BoImpl implements Super3Bo {
	@Autowired
	private Super3SaleDao super3SaleDao;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private TicketSaleBo TicketBo;

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isSuper3Sale = Boolean.valueOf(ConnectionFactory.operationProperty("super3SaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String super3SaleUsers = String.valueOf(ConnectionFactory.operationProperty("super3SaleUsers", Constants.contextSale)).toString().trim();
        if (isSuper3Sale == false) {
            if (super3SaleUsers != null && !super3SaleUsers.equals("")) {
                String[] saleUsers = super3SaleUsers.split(",");
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
    public Super3ProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId= " + p_clientId);
        Super3ProcedureBetData objectDomain = new Super3ProcedureBetData();
        try {
            objectDomain = super3SaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("w_status= " + objectDomain.getStatus() + "w_message= " + objectDomain.getMessage() + "w_prize= " + objectDomain.getPrize()
                        + "w_active_draw= " + objectDomain.getActiveDraw() + "w_close_date= " + objectDomain.getCloseDate() + "w_close_hour= " + objectDomain.getCloseHour()
                        + "w_next_draw= " + objectDomain.getNextDraw() + "w_open_date= " + objectDomain.getOpenDate() + "w_open_hour= " + objectDomain.getOpenHour()
                        + "w_numbers_more= " + objectDomain.getNumbersMore() + "w_numbers_less= " + objectDomain.getNumbersLess() + "w_price_type= "
                        + objectDomain.getPriceType() + "w_price_message= " + objectDomain.getPriceMessage() + "w_simple_bet_price= " + objectDomain.getSimpleBetPrice()
                        + "w_promotion_type= " + objectDomain.getPromotionType() + "w_balance_amount= " + objectDomain.getBalanceAmount() + "w_balance_amount_game= "
                        + objectDomain.getBalanceAmountGame() + "w_algorithm= " + objectDomain.getAlgorithm() + "w_bets= " + objectDomain.getBets() + "w_pay= "
                        + objectDomain.getPay() + "w_draws= " + objectDomain.getDraws() + "w_cost= " + objectDomain.getCost());
        }
        return objectDomain;
    }

    @Override
    public List<Super3ProcedureDrawData> findListDraw() throws Exception {
        LoggerApi.Log.info("=");
        List<Super3ProcedureDrawData> resultQueryList = new ArrayList<Super3ProcedureDrawData>();
        try {
            resultQueryList = super3SaleDao.findListDrawData();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info("=");
        }
        return resultQueryList;
    }

	@Override
	public JsonArray datosJugada(int from, int to, int gameID,Long ticketId) {
		 
		 AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		 int ticke_id_num=0,draw_num=0,multiplicador=0;
         String ctbM1="",ctbM2="";
         String result = "";
         int tres_desordenada_A=0,tres_ordena_A=0,dos_ordenada_A=0,uno_ordenada_A=0;
         int tres_desordenada_B=0,tres_ordena_B=0,dos_ordenada_B=0,uno_ordenada_B=0;
         String fecha_expriacion="";
         Date fecha ;
         JsonArray resultado_datos = new JsonArray();
         
 		try { 
 			
 			for (int i = from; i <= to; i++) {
 			Super3cotejadorUtil alg_super_tres_A = new Super3cotejadorUtil();
 			Super3cotejadorUtil alg_super_tres_B = new Super3cotejadorUtil();
 			JsonObject datos_cotejador= new JsonObject();
			Map aciertos_resultado=new HashMap();
			
			ArrayList datos_cotejo = new ArrayList();
 			ArrayList resultado_tot = new ArrayList();
 			ArrayList resultadoCotejoA = new ArrayList();
 			ArrayList resultadoCotejoB = new ArrayList();
 			
 			ClientTicket ticket = clientTicketBo.findById(ticketId);
 			
 			int clientid=Integer.parseInt(ticket.getCtClientId());
 			
 			TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientid, gameID, ticketId);
 			 			
 			Draw draw = drawBo.findByIdByGameId(i,gameID);
 			
 			ticke_id_num=Integer.parseInt(ticket.getTicketId());
 			ctbM1=" "+ticket.getCtBetMatrix1()+" ";
 			ctbM2=" "+ticket.getCtBetMatrix2()+" ";
 			tres_desordenada_A=ticket.getCtBet3anyA();
 			tres_desordenada_B=ticket.getCtBet3anyB();
 			tres_ordena_A=ticket.getCtBet3exactA();
 			tres_ordena_B=ticket.getCtBet3exactB();
 			dos_ordenada_A=ticket.getCtBet2exactA();
 			dos_ordenada_B=ticket.getCtBet2exactB();
 			uno_ordenada_A=ticket.getCtBet1exactA();
 			uno_ordenada_B=ticket.getCtBet1exactB();
 			multiplicador=ticket_client.getCtBetMultiA();
 			result =" "+draw.getDrResult()+" ";
 			fecha_expriacion=ticket_client.getCtPrizeExpirationDate();
 			
 			String fecha_r =" "+draw.getDrDate()+" ";
			String fecha_completa=fecha_r+"";
			String dia="",mes="",ano="",fechas="";
	        ano=fecha_completa.substring(1, 5);
	        mes=fecha_completa.substring(6, 8);
	        dia=fecha_completa.substring(9, 11);
	        fechas=dia+"/"+mes+"/"+ano;
	        String tipo_jugada_A="",tipo_jugada_B="";
	         			
 			if(tres_desordenada_A==0){
 				num_a.tres_ju_desorden_A_ind="no";
 			}else{
 				if(tres_ordena_A==1){
 					tipo_jugada_A=tipo_jugada_A+", 3 en cualquier orden";
 				}else{
 					tipo_jugada_A=tipo_jugada_A+"3 en cualquier orden";
 				}
 				num_a.tres_ju_desorden_A_ind="si";}
 			if(tres_desordenada_B==0){
 				num_a.tres_ju_desorden_B_ind="no";
 			}else{
 				if(tres_ordena_B==1){
 					tipo_jugada_B=tipo_jugada_B+", 3 en cualquier orden";
 				}else{
 					tipo_jugada_B=tipo_jugada_B+"3 en cualquier orden";
 				}
 				num_a.tres_ju_desorden_B_ind="si";}
 			if(tres_ordena_A==0){
 				num_a.tres_ju_ord_A_ind="no";
 			}else{
	 				tipo_jugada_A=tipo_jugada_A+"3 en orden";
	 				num_a.tres_ju_ord_A_ind="si";}
 			if(tres_ordena_B==0){
 					num_a.tres_ju_ord_B_ind="no";
 			}else{
	 				tipo_jugada_B=tipo_jugada_B+"3 en orden";
	 				num_a.tres_ju_ord_B_ind="si";}
 			if(dos_ordenada_A==0){
 					num_a.dos_ju_ord_A_ind="no";
 			}else{
 				if(tres_ordena_A==1 || tres_desordenada_A==1){
 					tipo_jugada_A=tipo_jugada_A+", 2 en orden";
 				}else{
 					tipo_jugada_A=tipo_jugada_A+"2 en orden";
 				}
 					num_a.dos_ju_ord_A_ind="si";}
 			if(dos_ordenada_B==0){
 					num_a.dos_ju_ord_B_ind="no";
 			}else{
 				if(tres_ordena_B==1 || tres_desordenada_B==1){
 					tipo_jugada_B=tipo_jugada_B+", 2 en orden";
 				}else{
 					tipo_jugada_B=tipo_jugada_B+"2 en orden";
 				}
 					num_a.dos_ju_ord_B_ind="si";}
 			if(uno_ordenada_A==0){
 					num_a.uno_ju_ord_A_ind="no";
 			}else{
 				if(tres_ordena_A==1 || tres_desordenada_A==1 || dos_ordenada_A==1 ){
 					tipo_jugada_A=tipo_jugada_A+", 1 en orden";
 				}else{
 					tipo_jugada_A=tipo_jugada_A+"1 en orden";
 				}
 					num_a.uno_ju_ord_A_ind="si";}
 			if(uno_ordenada_B==0){
 					num_a.uno_ju_ord_B_ind="no";
 			}else{
 				if(tres_ordena_B==1 || tres_desordenada_B==1 || dos_ordenada_B==1 ){
 					tipo_jugada_B=tipo_jugada_B+", 1 en orden";
 				}else{
 					tipo_jugada_B=tipo_jugada_B+"1 en orden";
 				}
 					num_a.uno_ju_ord_B_ind="si";
 				}
 			
 			aciertos_resultado.put("sorteo", i);
 			aciertos_resultado.put("fecha", fechas);
 			aciertos_resultado.put("resultado", result);
 			aciertos_resultado.put("jugaA", ctbM1);
 			aciertos_resultado.put("jugadaB", ctbM2);
 			aciertos_resultado.put("tipo_jugada_A", tipo_jugada_A);
 			aciertos_resultado.put("tipo_jugada_B", tipo_jugada_B);
 			aciertos_resultado.put("multiplicador", multiplicador);
 			datos_cotejo.add(aciertos_resultado);
 			resultadoCotejoA=alg_super_tres_A.metodo_ordenamiento("A",ctbM1, result, num_a.tres_ju_desorden_A_ind, num_a.tres_ju_ord_A_ind, num_a.dos_ju_ord_A_ind, num_a.uno_ju_ord_A_ind);
 			resultadoCotejoB=alg_super_tres_B.metodo_ordenamiento("B",ctbM2, result, num_a.tres_ju_desorden_B_ind, num_a.tres_ju_ord_B_ind, num_a.dos_ju_ord_B_ind, num_a.uno_ju_ord_B_ind);
 			
 			
 			datos_cotejador.add("datos_cotejo",new Gson().toJsonTree(datos_cotejo));
 			datos_cotejador.add("cotejo_jugadaA",new Gson().toJsonTree(resultadoCotejoA));
 			datos_cotejador.add("cotejo_jugadaB",new Gson().toJsonTree(resultadoCotejoB));
 			
 			resultado_datos.add(datos_cotejador);
 			}
 	        
 		}catch(Exception e){
 			System.out.println("Warning_Super_3 : "+e.getMessage());
 		}
		
		return resultado_datos;
	}

	@Override
	public JsonArray resultado_premios(Integer clientId, Integer gameId,Long ticketId) {
		
		JsonArray resultado_total_datos = new JsonArray();
		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		String ctbM1="",ctbM2="",fecha_expriacion="";
		int multiplicador=0;
		
		String tres_ju_desorden_A_ind=num_a.tres_ju_desorden_A_ind,tres_ju_ord_A_ind=num_a.tres_ju_ord_A_ind,dos_ju_ord_A_ind=num_a.dos_ju_ord_A_ind,uno_ju_ord_A_ind=num_a.uno_ju_ord_A_ind;
		String tres_ju_desorden_B_ind=num_a.tres_ju_desorden_B_ind,tres_ju_ord_B_ind=num_a.tres_ju_ord_B_ind,dos_ju_ord_B_ind=num_a.dos_ju_ord_B_ind,uno_ju_ord_B_ind=num_a.uno_ju_ord_B_ind;
				
		try {
			TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientId, gameId, ticketId);
			ClientTicket ticket = clientTicketBo.findById(ticketId);
			ctbM1=" "+ticket.getCtBetMatrix1()+" ";
 			ctbM2=" "+ticket.getCtBetMatrix2()+" ";
 			multiplicador=ticket_client.getCtBetMultiA();
 			
 			if(ticket_client.getCtPrizeExpirationDate()== null || ticket_client.getCtPrizeExpirationDate().equals(" ")){
 			fecha_expriacion="-";	
 			}else{
 			fecha_expriacion=ticket_client.getCtPrizeExpirationDate();	
 			}
 			
 			
 			/*fecha_expriacion=ticket_client.getCtPrizeExpirationDate();
 			premio_total=ticket_client.getCtTwPrizeAmount();*/
 			
 			
			if(ctbM1.length()>0 && ctbM2.length()<0){
	 			if(tres_ju_desorden_A_ind.equals("si") && tres_ju_ord_A_ind.equals("no") && dos_ju_ord_A_ind.equals("no") && uno_ju_ord_A_ind.equals("no")){
	 				JsonObject resultado_datos_total= new JsonObject();
	 				Map resultado_total = new HashMap();
	 				ArrayList resultado_tot = new ArrayList();
	 				resultado_total.put("jugada", "A");
	 				resultado_total.put("tipo_jugada", "3 en cualquier orden");
	 				resultado_total.put("aciertos",num_a.aciertos_super3_desordenA );
	 				resultado_total.put("premio_apuesta","S/." + (1*100) );
	 				resultado_total.put("multiplicacion",multiplicador );
	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_desordenA*1*100*multiplicador) );
	 				resultado_total.put("expira",fecha_expriacion);
	 				resultado_tot.add(resultado_total);
	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 				resultado_total_datos.add(resultado_datos_total);
	 				
	 			}if(tres_ju_desorden_A_ind.equals("no") && tres_ju_ord_A_ind.equals("si") && dos_ju_ord_A_ind.equals("no") && uno_ju_ord_A_ind.equals("no")){
	 				JsonObject resultado_datos_total= new JsonObject();
	 				Map resultado_total = new HashMap();
	 				ArrayList resultado_tot = new ArrayList();
	 				resultado_total.put("jugada", "A");
	 				resultado_total.put("tipo_jugada", "3 en orden");
	 				resultado_total.put("aciertos",num_a.aciertos_super3_3ordenA);
	 				resultado_total.put("premio_apuesta","S/." + (1*600) );
	 				resultado_total.put("multiplicacion",multiplicador );
	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_3ordenA*600*multiplicador) );
	 				resultado_total.put("expira",fecha_expriacion);
	 				resultado_tot.add(resultado_total);
	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 				resultado_total_datos.add(resultado_datos_total);
	 				
	 			}if(tres_ju_desorden_A_ind.equals("no") && tres_ju_ord_A_ind.equals("no") && dos_ju_ord_A_ind.equals("si") && uno_ju_ord_A_ind.equals("no")){
	 				JsonObject resultado_datos_total= new JsonObject();
	 				Map resultado_total = new HashMap();
	 				ArrayList resultado_tot = new ArrayList();
	 				resultado_total.put("jugada", "A");
	 				resultado_total.put("tipo_jugada", "2 en orden");
	 				resultado_total.put("aciertos",num_a.aciertos_super3_2ordenA );
	 				resultado_total.put("premio_apuesta","S/." + (1*20) );
	 				resultado_total.put("multiplicacion",multiplicador );
	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_2ordenA*20*multiplicador) );
	 				resultado_total.put("expira",fecha_expriacion);
	 				resultado_tot.add(resultado_total);
	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 				resultado_total_datos.add(resultado_datos_total);
	 				
	 				
	 			}if(tres_ju_desorden_A_ind.equals("no") && tres_ju_ord_A_ind.equals("no") && dos_ju_ord_A_ind.equals("no") && uno_ju_ord_A_ind.equals("si")){
	 				JsonObject resultado_datos_total= new JsonObject();
	 				Map resultado_total = new HashMap();
	 				ArrayList resultado_tot = new ArrayList();
	 				resultado_total.put("jugada", "A");
	 				resultado_total.put("tipo_jugada", "1 en orden");
	 				resultado_total.put("aciertos",num_a.aciertos_super3_1ordenA );
	 				resultado_total.put("premio_apuesta","S/." + (1*2) );
	 				resultado_total.put("multiplicacion",multiplicador );
	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_1ordenA*2*multiplicador) );
	 				resultado_total.put("expira",fecha_expriacion);
	 				resultado_tot.add(resultado_total);
	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 				resultado_total_datos.add(resultado_datos_total);
	 				
	 			}if(tres_ju_desorden_A_ind.equals("si") && tres_ju_ord_A_ind.equals("si") && dos_ju_ord_A_ind.equals("si") && uno_ju_ord_A_ind.equals("si")){
	 				for(int i=0;i<4;i++){
	 					if(i==0){
	 						JsonObject resultado_datos_total= new JsonObject();
	 						Map resultado_total = new HashMap();
	 						ArrayList resultado_tot = new ArrayList();
	 						resultado_total.put("jugada", "A");
			 				resultado_total.put("tipo_jugada", "3 en orden");
			 				resultado_total.put("aciertos",num_a.aciertos_super3_3ordenA );
			 				resultado_total.put("premio_apuesta","S/." + (1*100) );
			 				resultado_total.put("multiplicacion",multiplicador );
			 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_3ordenA*100*multiplicador) );
			 				resultado_total.put("expira",fecha_expriacion);
			 				resultado_tot.add(resultado_total);
			 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
			 				resultado_total_datos.add(resultado_datos_total);	
	 					}
	 					
		 				if(i==1){
		 					JsonObject resultado_datos_total= new JsonObject();
		 					Map resultado_total = new HashMap();
		 					ArrayList resultado_tot = new ArrayList();
			 				resultado_total.put("jugada", "A");
			 				resultado_total.put("tipo_jugada", "3 en cualquier orden");
			 				resultado_total.put("aciertos",num_a.aciertos_super3_desordenA );
			 				resultado_total.put("premio_apuesta","S/." + (1*100) );
			 				resultado_total.put("multiplicacion",multiplicador );
			 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_desordenA*100*multiplicador) );
			 				resultado_total.put("expira",fecha_expriacion);
			 				resultado_tot.add(resultado_total);
			 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
			 				resultado_total_datos.add(resultado_datos_total);
		 				}
	 					
		 				if(i==2){
		 					JsonObject resultado_datos_total= new JsonObject();
		 					Map resultado_total = new HashMap();
		 					ArrayList resultado_tot = new ArrayList();
		 					resultado_total.put("jugada", "A");
		 	 				resultado_total.put("tipo_jugada", "2 en orden");
		 	 				resultado_total.put("aciertos",num_a.aciertos_super3_2ordenA );
		 	 				resultado_total.put("premio_apuesta","S/." + (1*20) );
		 	 				resultado_total.put("multiplicacion",multiplicador );
		 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_2ordenA*20*multiplicador) );
		 	 				resultado_total.put("expira",fecha_expriacion);
		 	 				resultado_tot.add(resultado_total);
		 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
		 	 				resultado_total_datos.add(resultado_datos_total);
		 				}
		 				if(i==3){
		 					JsonObject resultado_datos_total= new JsonObject();
		 					Map resultado_total = new HashMap();
		 					ArrayList resultado_tot = new ArrayList();
		 					resultado_total.put("jugada", "A");
		 	 				resultado_total.put("tipo_jugada", "1 en orden");
		 	 				resultado_total.put("aciertos",num_a.aciertos_super3_1ordenA );
		 	 				resultado_total.put("premio_apuesta","S/." + (1*2) );
		 	 				resultado_total.put("multiplicacion",multiplicador );
		 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_1ordenA*2*multiplicador) );
		 	 				resultado_total.put("expira",fecha_expriacion);
		 	 				resultado_tot.add(resultado_total);
		 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
		 	 				resultado_total_datos.add(resultado_datos_total);
		 				}
		 				
		 				
	 				}
	 				
	 				
	 				
	 			}
	 			
	 			}else{
	 				if(tres_ju_desorden_A_ind.equals("si") && tres_ju_ord_A_ind.equals("no") && dos_ju_ord_A_ind.equals("no") && uno_ju_ord_A_ind.equals("no")){
		 				JsonObject resultado_datos_total= new JsonObject();
		 				Map resultado_total = new HashMap();
		 				ArrayList resultado_tot = new ArrayList();
		 				resultado_total.put("jugada", "A");
		 				resultado_total.put("tipo_jugada", "3 en cualquier orden");
		 				resultado_total.put("aciertos",num_a.aciertos_super3_desordenA );
		 				resultado_total.put("premio_apuesta","S/." + (1*100) );
		 				resultado_total.put("multiplicacion",multiplicador );
		 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_desordenA*100*multiplicador) );
		 				resultado_total.put("expira",fecha_expriacion);
		 				resultado_tot.add(resultado_total);
		 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
		 				resultado_total_datos.add(resultado_datos_total);
		 				
		 			}if(tres_ju_desorden_A_ind.equals("no") && tres_ju_ord_A_ind.equals("si") && dos_ju_ord_A_ind.equals("no") && uno_ju_ord_A_ind.equals("no")){
		 				JsonObject resultado_datos_total= new JsonObject();
		 				Map resultado_total = new HashMap();
		 				ArrayList resultado_tot = new ArrayList();
		 				resultado_total.put("jugada", "A");
		 				resultado_total.put("tipo_jugada", "3 en orden");
		 				resultado_total.put("aciertos",num_a.aciertos_super3_3ordenA);
		 				resultado_total.put("premio_apuesta","S/." + (1*600) );
		 				resultado_total.put("multiplicacion",multiplicador );
		 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_3ordenA*600*multiplicador) );
		 				resultado_total.put("expira",fecha_expriacion);
		 				resultado_tot.add(resultado_total);
		 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
		 				resultado_total_datos.add(resultado_datos_total);
		 				
		 			}if(tres_ju_desorden_A_ind.equals("no") && tres_ju_ord_A_ind.equals("no") && dos_ju_ord_A_ind.equals("si") && uno_ju_ord_A_ind.equals("no")){
		 				JsonObject resultado_datos_total= new JsonObject();
		 				Map resultado_total = new HashMap();
		 				ArrayList resultado_tot = new ArrayList();
		 				resultado_total.put("jugada", "A");
		 				resultado_total.put("tipo_jugada", "2 en orden");
		 				resultado_total.put("aciertos",num_a.aciertos_super3_2ordenA);
		 				resultado_total.put("premio_apuesta","S/." + (1*20) );
		 				resultado_total.put("multiplicacion",multiplicador );
		 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_2ordenA*20*multiplicador) );
		 				resultado_total.put("expira",fecha_expriacion);
		 				resultado_tot.add(resultado_total);
		 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
		 				resultado_total_datos.add(resultado_datos_total);
		 				
		 				
		 			}if(tres_ju_desorden_A_ind.equals("no") && tres_ju_ord_A_ind.equals("no") && dos_ju_ord_A_ind.equals("no") && uno_ju_ord_A_ind.equals("si")){
		 				JsonObject resultado_datos_total= new JsonObject();
		 				Map resultado_total = new HashMap();
		 				ArrayList resultado_tot = new ArrayList();
		 				resultado_total.put("jugada", "A");
		 				resultado_total.put("tipo_jugada", "1 en orden");
		 				resultado_total.put("aciertos",num_a.aciertos_super3_1ordenA );
		 				resultado_total.put("premio_apuesta","S/." + (1*2) );
		 				resultado_total.put("multiplicacion",multiplicador );
		 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_1ordenA*2*multiplicador) );
		 				resultado_total.put("expira",fecha_expriacion);
		 				resultado_tot.add(resultado_total);
		 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
		 				resultado_total_datos.add(resultado_datos_total);
		 				
		 			}if(tres_ju_desorden_A_ind.equals("si") && tres_ju_ord_A_ind.equals("si") && dos_ju_ord_A_ind.equals("si") && uno_ju_ord_A_ind.equals("si")){
		 				for(int i=0;i<4;i++){
		 					if(i==0){
		 						JsonObject resultado_datos_total= new JsonObject();
		 						Map resultado_total = new HashMap();
		 						ArrayList resultado_tot = new ArrayList();
		 						resultado_total.put("jugada", "A");
				 				resultado_total.put("tipo_jugada", "3 en orden");
				 				resultado_total.put("aciertos",num_a.aciertos_super3_3ordenA);
				 				resultado_total.put("premio_apuesta","S/." + (1*100) );
				 				resultado_total.put("multiplicacion",multiplicador );
				 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_3ordenA*100*multiplicador) );
				 				resultado_total.put("expira",fecha_expriacion);
				 				resultado_tot.add(resultado_total);
				 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
				 				resultado_total_datos.add(resultado_datos_total);	
		 					}
		 					
			 				if(i==1){
			 					JsonObject resultado_datos_total= new JsonObject();
			 					Map resultado_total = new HashMap();
			 					ArrayList resultado_tot = new ArrayList();
				 				resultado_total.put("jugada", "A");
				 				resultado_total.put("tipo_jugada", "3 en cualquier orden");
				 				resultado_total.put("aciertos",num_a.aciertos_super3_desordenA);
				 				resultado_total.put("premio_apuesta","S/." + (1*100) );
				 				resultado_total.put("multiplicacion",multiplicador );
				 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_desordenA*100*multiplicador) );
				 				resultado_total.put("expira",fecha_expriacion);
				 				resultado_tot.add(resultado_total);
				 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
				 				resultado_total_datos.add(resultado_datos_total);	
			 				}
		 					
			 				if(i==2){
			 					JsonObject resultado_datos_total= new JsonObject();
			 					Map resultado_total = new HashMap();
			 					ArrayList resultado_tot = new ArrayList();
			 					resultado_total.put("jugada", "A");
			 	 				resultado_total.put("tipo_jugada", "2 en orden");
			 	 				resultado_total.put("aciertos",num_a.aciertos_super3_2ordenA);
			 	 				resultado_total.put("premio_apuesta","S/." + (1*20) );
			 	 				resultado_total.put("multiplicacion",multiplicador );
			 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_2ordenA*20*multiplicador) );
			 	 				resultado_total.put("expira",fecha_expriacion);
			 	 				resultado_tot.add(resultado_total);
			 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
			 	 				resultado_total_datos.add(resultado_datos_total);	
			 				}
			 				if(i==3){
			 					JsonObject resultado_datos_total= new JsonObject();
			 					Map resultado_total = new HashMap();
			 					ArrayList resultado_tot = new ArrayList();
			 					resultado_total.put("jugada", "A");
			 	 				resultado_total.put("tipo_jugada", "1 en orden");
			 	 				resultado_total.put("aciertos",num_a.aciertos_super3_1ordenA);
			 	 				resultado_total.put("premio_apuesta","S/." + (1*2) );
			 	 				resultado_total.put("multiplicacion",multiplicador );
			 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_1ordenA*2*multiplicador) );
			 	 				resultado_total.put("expira",fecha_expriacion);
			 	 				resultado_tot.add(resultado_total);
			 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
			 	 				resultado_total_datos.add(resultado_datos_total);	
			 				}
			 				
		 				}	
		 			}
	 				
	 				
	 	 			if(tres_ju_desorden_B_ind.equals("si") && tres_ju_ord_B_ind.equals("no") && dos_ju_ord_B_ind.equals("no") && uno_ju_ord_B_ind.equals("no")){
	 	 				
	 	 				JsonObject resultado_datos_total= new JsonObject();
	 	 				Map resultado_total = new HashMap();
	 	 				ArrayList resultado_tot = new ArrayList();
	 	 				resultado_total.put("jugada", "B");
	 	 				resultado_total.put("tipo_jugada", "3 en cualquier orden");
	 	 				resultado_total.put("aciertos",num_a.aciertos_super3_desordenB);
	 	 				resultado_total.put("premio_apuesta","S/." + (1*100) );
	 	 				resultado_total.put("multiplicacion",multiplicador );
	 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_desordenB*100*multiplicador) );
	 	 				resultado_total.put("expira",fecha_expriacion);
	 	 				resultado_tot.add(resultado_total);
	 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 	 				resultado_total_datos.add(resultado_datos_total);	
	 	 				
	 	 				
	 	 			}if(tres_ju_desorden_B_ind.equals("no") && tres_ju_ord_B_ind.equals("si") && dos_ju_ord_B_ind.equals("no") && uno_ju_ord_B_ind.equals("no")){
	 	 				
	 	 				JsonObject resultado_datos_total= new JsonObject();
	 	 				Map resultado_total = new HashMap();
	 	 				ArrayList resultado_tot = new ArrayList();
	 	 				resultado_total.put("jugada", "B");
	 	 				resultado_total.put("tipo_jugada", "3 en orden");
	 	 				resultado_total.put("aciertos",num_a.aciertos_super3_3ordenB);
	 	 				resultado_total.put("premio_apuesta","S/." + (1*600) );
	 	 				resultado_total.put("multiplicacion",multiplicador );
	 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_3ordenB*600*multiplicador) );
	 	 				resultado_total.put("expira",fecha_expriacion);
	 	 				resultado_tot.add(resultado_total);
	 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 	 				resultado_total_datos.add(resultado_datos_total);	
	 	 				
	 	 				
	 	 			}if(tres_ju_desorden_B_ind.equals("no") && tres_ju_ord_B_ind.equals("no") && dos_ju_ord_B_ind.equals("si") && uno_ju_ord_B_ind.equals("no")){
	 	 				
	 	 				JsonObject resultado_datos_total= new JsonObject();
	 	 				Map resultado_total = new HashMap();
	 	 				ArrayList resultado_tot = new ArrayList();
	 	 				resultado_total.put("jugada", "B");
	 	 				resultado_total.put("tipo_jugada", "2 en orden");
	 	 				resultado_total.put("aciertos",num_a.aciertos_super3_2ordenB);
	 	 				resultado_total.put("premio_apuesta","S/." + (1*20) );
	 	 				resultado_total.put("multiplicacion",multiplicador );
	 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_2ordenB*20*multiplicador) );
	 	 				resultado_total.put("expira",fecha_expriacion);
	 	 				resultado_tot.add(resultado_total);
	 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 	 				resultado_total_datos.add(resultado_datos_total);
	 	 				
	 	 				
	 	 			}if(tres_ju_desorden_B_ind.equals("no") && tres_ju_ord_B_ind.equals("no") && dos_ju_ord_B_ind.equals("no") && uno_ju_ord_B_ind.equals("si")){
	 	 				
	 	 				JsonObject resultado_datos_total= new JsonObject();
	 	 				Map resultado_total = new HashMap();
	 	 				ArrayList resultado_tot = new ArrayList();
	 	 				resultado_total.put("jugada", "B");
	 	 				resultado_total.put("tipo_jugada", "1 en orden");
	 	 				resultado_total.put("aciertos",num_a.aciertos_super3_1ordenB);
	 	 				resultado_total.put("premio_apuesta","S/." + (1*2) );
	 	 				resultado_total.put("multiplicacion",multiplicador );
	 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_1ordenB*2*multiplicador) );
	 	 				resultado_total.put("expira",fecha_expriacion);
	 	 				resultado_tot.add(resultado_total);
	 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 	 				resultado_total_datos.add(resultado_datos_total);
	 	 				
	 	 			}if(tres_ju_desorden_B_ind.equals("si") && tres_ju_ord_B_ind.equals("si") && dos_ju_ord_B_ind.equals("si") && uno_ju_ord_B_ind.equals("si")){
	 	 			
	 	 				for(int i=0;i<4;i++){
	 	 					if(i==0){
	 	 						Map resultado_total = new HashMap();
	 	 						ArrayList resultado_tot = new ArrayList();
	 	 						JsonObject resultado_datos_total= new JsonObject();
	 	 						resultado_total.put("jugada", "B");
	 		 	 				resultado_total.put("tipo_jugada", "3 en orden");
	 		 	 				resultado_total.put("aciertos",num_a.aciertos_super3_3ordenB);
	 		 	 				resultado_total.put("premio_apuesta","S/." + (1*100) );
	 		 	 				resultado_total.put("multiplicacion",multiplicador );
	 		 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_3ordenB*100*multiplicador) );
	 		 	 				resultado_total.put("expira",fecha_expriacion);
	 		 	 				resultado_tot.add(resultado_total);
	 		 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 		 	 				resultado_total_datos.add(resultado_datos_total);
	 	 					}
	 	 					if(i==1){
	 	 						Map resultado_total = new HashMap();
	 	 						ArrayList resultado_tot = new ArrayList();
		 	 					JsonObject resultado_datos_total= new JsonObject();
		 	 					resultado_total.put("jugada", "B");
			 	 				resultado_total.put("tipo_jugada", "3 en cualquier orden");
			 	 				resultado_total.put("aciertos",num_a.aciertos_super3_desordenB);
			 	 				resultado_total.put("premio_apuesta","S/." + (1*100) );
			 	 				resultado_total.put("multiplicacion",multiplicador );
			 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_desordenB*100*multiplicador) );
			 	 				resultado_total.put("expira",fecha_expriacion);
			 	 				resultado_tot.add(resultado_total);
			 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
			 	 				resultado_total_datos.add(resultado_datos_total);
		 	 				}
	 	 					if(i==2){
	 	 						Map resultado_total = new HashMap();
	 	 						ArrayList resultado_tot = new ArrayList();
	 	 						JsonObject resultado_datos_total= new JsonObject();
	 	 						resultado_total.put("jugada", "B");
	 		 	 				resultado_total.put("tipo_jugada", "2 en orden");
	 		 	 				resultado_total.put("aciertos",num_a.aciertos_super3_2ordenB);
	 		 	 				resultado_total.put("premio_apuesta","S/." + (1*20) );
	 		 	 				resultado_total.put("multiplicacion",multiplicador );
	 		 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_2ordenB*20*multiplicador) );
	 		 	 				resultado_total.put("expira",fecha_expriacion);
	 		 	 				resultado_tot.add(resultado_total);
	 		 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 		 	 				resultado_total_datos.add(resultado_datos_total);
	 	 					}
	 	 					if(i==3){
	 	 						Map resultado_total = new HashMap();
	 	 						ArrayList resultado_tot = new ArrayList();
	 	 						JsonObject resultado_datos_total= new JsonObject();
	 	 						resultado_total.put("jugada", "B");
	 		 	 				resultado_total.put("tipo_jugada", "1 en orden");
	 		 	 				resultado_total.put("aciertos",num_a.aciertos_super3_1ordenB);
	 		 	 				resultado_total.put("premio_apuesta","S/." + (1*2) );
	 		 	 				resultado_total.put("multiplicacion",multiplicador );
	 		 	 				resultado_total.put("premio_total","S/."+(num_a.aciertos_super3_1ordenB*2*multiplicador) );
	 		 	 				resultado_total.put("expira",fecha_expriacion);
	 		 	 				resultado_tot.add(resultado_total);
	 		 	 				resultado_datos_total.add("datos_total_cotejo",new Gson().toJsonTree(resultado_tot));
	 		 	 				resultado_total_datos.add(resultado_datos_total);
	 	 					}
	 	 					
	 	 				}		
	 	 				
	 	 			}
	 			}
			
			
		} catch (Exception e) {
			System.out.println("Mensaje_Warnin_Super_3: " + e.getMessage());
		} finally {

		}
		return resultado_total_datos;
	}

	@Override
	public JsonArray premio_total(Integer clientId, Integer gameId,Long ticketId) {
		 double premio_t=0.0;
		
		
		 JsonArray premio_total = new JsonArray();
		 JsonObject premio= new JsonObject();
		try { 
			 TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientId, gameId, ticketId);
			 			 
			if(ticket_client.getCtTwPrizeAmount()== null){
				premio_t=0.0;
 			}else{
 				premio_t=ticket_client.getCtTwPrizeAmount();
 			}
			 
			 premio.addProperty("premio",premio_t);
			 premio_total.add(premio);
			
		}catch(Exception e){
			System.out.println("Warning_Super_3 : "+e.getMessage());
		}
		
		return premio_total;
	}

	@Override
	public String DateFormat(String date) {
        SimpleDateFormat name, formato;
        String nameFormat;
        formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date calDate = null;
        if (date != null) {
            try {
                calDate = formato.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            name = new SimpleDateFormat("EEE dd MMM", new Locale("es", "ES"));
            nameFormat = name.format(calDate);
            return nameFormat.toUpperCase();
        } else
            return "";
    }

	@Override
	public ArrayList valoresBoleto() throws Exception {
		ArrayList valoresBol= new ArrayList();
		valoresBol.add(1);
		valoresBol.add(2);
		valoresBol.add(3);
		valoresBol.add(4);
		valoresBol.add(5);
		valoresBol.add(6);
		valoresBol.add(8);
		valoresBol.add(12);
		valoresBol.add(16);
		valoresBol.add(20);
		valoresBol.add(26);
		return valoresBol;
	}
}
