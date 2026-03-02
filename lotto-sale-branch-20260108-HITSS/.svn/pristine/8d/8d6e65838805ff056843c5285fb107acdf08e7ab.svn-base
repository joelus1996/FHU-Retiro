package pe.com.intralot.loto.layer.service.game.kinelo.boimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KineloProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.KineloSaleDao;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.kinelo.bo.KineloBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.KinelocotejadorUtil;

@Service
public class KineloBoImpl implements KineloBo {

    @Autowired
    private KineloSaleDao kineloSaleDao;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private TicketSaleBo TicketBo;

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isKineloSale = Boolean.valueOf(ConnectionFactory.operationProperty("kineloSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String kineloSaleUsers = String.valueOf(ConnectionFactory.operationProperty("kineloSaleUsers", Constants.contextSale)).toString().trim();
        if (isKineloSale == false) {
            if (kineloSaleUsers != null && !kineloSaleUsers.equals("")) {
                String[] saleUsers = kineloSaleUsers.split(",");
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
    public KineloProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId= " + p_clientId);
        KineloProcedureBetData objectDomain = new KineloProcedureBetData();
        try {
            objectDomain = kineloSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("Status=" + objectDomain.getStatus() + " Message=" + objectDomain.getMessage() + " Prize=" + objectDomain.getPrize()
                        + " ActiveDraw=" + objectDomain.getActiveDraw() + " CloseDate=" + objectDomain.getCloseDate() + " CloseHour=" + objectDomain.getCloseHour()
                        + " NextDraw=" + objectDomain.getNextDraw() + " OpenDate=" + objectDomain.getOpenDate() + " OpenHour=" + objectDomain.getOpenHour()
                        + " NumbersMore=" + objectDomain.getNumbersMore() + " NumbersLess=" + objectDomain.getNumbersLess() + " PriceType=" + objectDomain.getPriceType() 
                        + " PriceMessage=" + objectDomain.getPriceMessage() + " SimpleBetPrice=" + objectDomain.getSimpleBetPrice() + " PromotionType=" + objectDomain.getPromotionType() 
                        + " BalanceAmount=" + objectDomain.getBalanceAmount() + " BalanceAmountGame="+ objectDomain.getBalanceAmountGame() + " Algorithm=" + objectDomain.getAlgorithm() 
                        + " Bets=" + objectDomain.getBets() + " Pay=" + objectDomain.getPay() + " Draws=" + objectDomain.getDraws() + " Cost=" + objectDomain.getCost() + " OtherAmount=" + objectDomain.getOtherAmount());
        }
        return objectDomain;
    }

    @Override
    public List<KineloProcedureDrawData> findListDrawData() throws Exception {
        LoggerApi.Log.info("=");
        List<KineloProcedureDrawData> resultQueryList = new ArrayList<KineloProcedureDrawData>();
        try {
            resultQueryList = kineloSaleDao.findListDrawData();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info("=");
        }
        return resultQueryList;
    }

    @Override
	public ArrayList cotejadoKinelo(int clientId,int gameId,Long ticketId) throws Exception {
		int ticke_id_num=0,ct_from_draw=0,ct_to_draw=0,draw_num=0;
		ArrayList resulta_jugada = new ArrayList();
        String ctbM1="",ctbM2="";
        Date fecha ;
		try {
			TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientId, gameId, ticketId);
			
			draw_num=ticket_client.getCtDrawId();
					
			Draw draw = drawBo.findByIdByGameId(draw_num,gameId);
			ticke_id_num=Integer.parseInt(ticket_client.getCtTicketId());
			ctbM1=" "+ticket_client.getCtBetMatrix1()+" ";
			ctbM2=" "+ticket_client.getCtBetMatrix2()+" ";
			ct_from_draw=ticket_client.getCtFromDraw();
			ct_to_draw=ticket_client.getCtToDraw();
			
			ctbM1.length();
			ctbM2.length();
						
			int j=0;
			for(int i=ct_from_draw;i<=ct_to_draw;i++){
			
				Draw draw_array = drawBo.findByIdByGameId(i,gameId);
				
				String recorrido=" "+draw_array.getDrResult()+" ";
				
				int hora=Integer.parseInt(draw_array.getDrCloseHour()+"");
				int minuto=Integer.parseInt(draw_array.getDrCloseMinute()+"");
				String hora_minuto="";

				if(hora==0){hora_minuto=12+":"+minuto+" a.m.";}
				else if(hora==12){hora_minuto=12+":"+minuto+" p.m.";}
				else if(hora>=0 && hora<12){hora_minuto=hora+":"+minuto+" p.m.";}
				else {hora_minuto=(hora-12)+":"+minuto+" p.m.";}
				
				fecha =draw.getDrDate();
	   			String fecha_completa=fecha+"";
	   			String dia="",mes="",ano="",fechas="";
	   	        ano=fecha_completa.substring(0, 4);
	   	        mes=fecha_completa.substring(5, 7);
	   	        dia=fecha_completa.substring(8, 10);
	   	        fechas=dia+"/"+mes+"/"+ano;
				
				KinelocotejadorUtil s = new KinelocotejadorUtil();
		        String juegoA = "",juegoB="";
				Map cotejoA = new HashMap();
				Map cotejoB = new HashMap();
				double premio_dos_jugadas=0.0;
				if(ctbM1.length()>2 && ctbM2.length()<6){
				juegoA = s.cotejo(recorrido, ctbM1);
				String [] juegaA;
				juegaA=juegoA.split("-");

		        Map cotejo_A=new HashMap();
		        cotejo_A.put("jugada_A", "A");
		        cotejo_A.put("tipo_jugada_A",juegaA[0]);
		        cotejo_A.put("aciertos_A", juegaA[1]);
		        cotejo_A.put("costo_A", juegaA[2]);
		        cotejo_A.put("multiplicador_A", juegaA[3]);
		        cotejo_A.put("f_base_A", juegaA[4]);
		        cotejo_A.put("total_A", juegaA[5]);
		        cotejo_A.put("efectivo_A", juegaA[6]);
		        cotejo_A.put("jugada_completa_A", juegaA[7]);
		        cotejo_A.put("fecha_jugada", fechas);
		        cotejo_A.put("hora_jugada", hora_minuto);
		        cotejo_A.put("sorteo_jugada", i);
		        cotejo_A.put("resultado", recorrido);
		        resulta_jugada.add(cotejo_A);
				}
				if(ctbM2.length()>6){
					
				juegoB = s.cotejo(recorrido, ctbM2);
				String [] juegaB;
				juegaB=juegoB.split("-");

		        Map cotejo_B=new HashMap();
		        cotejo_B.put("jugada_B", "B");
		        cotejo_B.put("tipo_jugada_B",juegaB[0]);
		        cotejo_B.put("aciertos_B", juegaB[1]);
		        cotejo_B.put("costo_B", juegaB[2]);
		        cotejo_B.put("multiplicador_B", juegaB[3]);
		        cotejo_B.put("f_base_B", juegaB[4]);
		        cotejo_B.put("total_B", juegaB[5]);
		        cotejo_B.put("efectivo_B", juegaB[6]);
		        
		        cotejo_B.put("jugada_completa_B", juegaB[7]);
		        
		     	
		        juegoA = s.cotejo(recorrido, ctbM1);
				String [] juegaA;
				juegaA=juegoA.split("-");
		        Map cotejo_A=new HashMap();
		        cotejo_B.put("jugada_A", "A");
		        cotejo_B.put("tipo_jugada_A",juegaA[0]);
		        cotejo_B.put("aciertos_A", juegaA[1]);
		        cotejo_B.put("costo_A", juegaA[2]);
		        cotejo_B.put("multiplicador_A", juegaA[3]);
		        cotejo_B.put("f_base_A", juegaA[4]);
		        cotejo_B.put("total_A", juegaA[5]);
		        cotejo_B.put("efectivo_A", juegaA[6]);
		        cotejo_B.put("jugada_completa_A", juegaA[7]);
		        cotejo_B.put("fecha_jugada", fechas);
		        cotejo_B.put("hora_jugada", hora_minuto);
		        cotejo_B.put("sorteo_jugada", i);
		        cotejo_B.put("resultado", recorrido);
		        	
		        double efectivo_A=Double.parseDouble(juegaA[6]);
		        double efectivo_B=Double.parseDouble(juegaB[6]);
		        premio_dos_jugadas=efectivo_A+efectivo_B;
		        cotejo_B.put("efectivo_total", premio_dos_jugadas);
		        resulta_jugada.add(cotejo_B);
				}
				j++;
			    }
		
		}catch(Exception e){
			System.out.println("Warning_Kinelo : "+e.getMessage());
			}
		return resulta_jugada;
		}

}
