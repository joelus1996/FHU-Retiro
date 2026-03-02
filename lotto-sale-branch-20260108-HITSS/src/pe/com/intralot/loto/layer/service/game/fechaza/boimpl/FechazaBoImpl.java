package pe.com.intralot.loto.layer.service.game.fechaza.boimpl;

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
import pe.com.intralot.loto.layer.model.domain.FechazaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.FechazaProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.FechazaSaleDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.fechaza.bo.FechazaBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.FechazacotejadorUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class FechazaBoImpl implements FechazaBo {

    @Autowired
    private FechazaSaleDao fechazaSaleDao;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private TicketSaleBo TicketBo;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private TicketSaleBo ticketSaleBo;

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isAllowed = false;
        boolean isFechazaSale = Boolean.valueOf(ConnectionFactory.operationProperty("fechazaSaleEnabled", Constants.contextSale).trim()).booleanValue();
        String fechazaSaleUsers = String.valueOf(ConnectionFactory.operationProperty("fechazaSaleUsers", Constants.contextSale)).toString().trim();
        if (isFechazaSale == false) {
            if (fechazaSaleUsers != null && !fechazaSaleUsers.equals("")) {
                String[] saleUsers = fechazaSaleUsers.split(",");
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
    public FechazaProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        FechazaProcedureBetData objectDomain = new FechazaProcedureBetData();
        try {
            objectDomain = fechazaSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_prize=" + objectDomain.getPrize()
                        + " w_active_draw=" + objectDomain.getActiveDraw() + " w_close_date=" + objectDomain.getCloseDate() + " w_close_hour=" + objectDomain.getCloseHour()
                        + " w_next_draw=" + objectDomain.getNextDraw() + " w_open_date=" + objectDomain.getOpenDate() + " w_open_hour=" + objectDomain.getOpenHour()
                        + " w_numbers_more=" + objectDomain.getNumbersMore() + " w_numbers_less=" + objectDomain.getNumbersLess() + " w_price_type="
                        + objectDomain.getPriceType() + " w_price_message=" + objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice()
                        + " w_promotion_type=" + objectDomain.getPromotionType() + " w_balance_amount=" + objectDomain.getBalanceAmount() + " w_balance_amount_game="
                        + objectDomain.getBalanceAmountGame() + " w_algorithm=" + objectDomain.getAlgorithm() + " w_bets=" + objectDomain.getBets() + " w_pay="
                        + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost());
        }
        return objectDomain;
    }

    @Override
    public List<FechazaProcedureDrawData> findListDrawData() throws Exception {
        LoggerApi.Log.info("=");
        List<FechazaProcedureDrawData> resultQueryList = new ArrayList<FechazaProcedureDrawData>();
        try {
            resultQueryList = fechazaSaleDao.findListDrawData();
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
    public String DateFormat(String date) {
        SimpleDateFormat name, formato;
        String nameFormat;
        formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date calDate = null;
        try {
            calDate = formato.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        name = new SimpleDateFormat("EEE dd MMM", new Locale("es", "ES"));
        nameFormat = name.format(calDate);
        return nameFormat.toUpperCase();
    }

    @Override
	public JsonArray datosJugada(int from, int to,int clientid,int gameID, Long ticketId) {
		// TODO Auto-generated method stub
		FechazacotejadorUtil fech_cotejador= new FechazacotejadorUtil();
		ArrayList fechaza_lista = new ArrayList();
		JsonArray datos_jugada_cotejo = new JsonArray();
		try {
			
			for (int i = from; i <= to; i++) {
				JsonObject cotejo = new JsonObject();
				ArrayList jugada_ordenada = new ArrayList();
				ArrayList jugada_resultado = new ArrayList();
				ClientTicket ticket = clientTicketBo.findById(ticketId);
				Draw draw_array = drawBo.findByIdByGameId(i, gameID);
				TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientid, gameID, ticketId);
				String bet1 = "", resultado = "";
				int multiplicador=0;
				
				resultado = " " + draw_array.getDrResult() + " ";
				if (ticket_client.getCtBetMatrix1() != null) {
					bet1 = " " +ticket_client.getCtBetMatrix1()+ " ";
				}
				
				resultado = " " + draw_array.getDrResult() + " ";

				String fecha_r = " " + draw_array.getDrDate().toString() + " ";
				multiplicador=ticket_client.getCtBetMultiA();
				String fecha_completa = fecha_r + "";
				String dia = "", mes = "", ano = "", fechas = "";
				ano = fecha_completa.substring(1, 5);
				mes = fecha_completa.substring(6, 8);
				dia = fecha_completa.substring(9, 11);
				fechas = dia + "/" + mes + "/" + ano;

				String drawId = "",hora_minuto="";
				drawId = ticket.getCtDrawId();

				int hora=Integer.parseInt(draw_array.getDrCloseHour()+"");
				int minuto=Integer.parseInt(draw_array.getDrCloseMinute()+"");

				if(hora==0){hora_minuto=12+":"+minuto+" a.m.";}
				else if(hora==12){hora_minuto=12+":"+minuto+" p.m.";}
				else if(hora>=0 && hora<12){hora_minuto=hora+":"+minuto+" p.m.";}
				else {hora_minuto=(hora-12)+":"+minuto+" p.m.";}
				
				 String[] corte_cadena;
				 String jugada="";
                 corte_cadena = bet1.toString().split(":");
                 jugada = corte_cadena[0].toString();
				
					if (ticket.getCtBetMatrix1() != null) {
						if (bet1.length() > 5) {
							cotejo.addProperty("sorteo", drawId);
							cotejo.addProperty("fecha", fechas);
							cotejo.addProperty("hora", hora_minuto);
							cotejo.addProperty("resultado", resultado);
							cotejo.addProperty("multiplicador", multiplicador);
							cotejo.addProperty("jugadaA", jugada);
							fechaza_lista = fech_cotejador.fechaza(bet1, resultado);
							cotejo.add("cotejo_jugada", new Gson().toJsonTree(fechaza_lista));
						/*	algoritmo_cotejadores cotejador_alg=new algoritmo_cotejadores();
							jugada_ordenada=cotejador_alg.ordenar_array_menor_mayor(bet1);
							
							algoritmo_combinaciones_jugada combinaciones= new algoritmo_combinaciones_jugada(jugada_ordenada, 5) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones,resultado);
							cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));*/
						}
					}
				datos_jugada_cotejo.add(cotejo);
			}

		} catch (Exception e) {
			System.out.println("Mensaje : " + e.getMessage());
		} finally {
		}
		
		return datos_jugada_cotejo;
	}

    @Override
	public JsonArray resultado_premios(Integer clientId, Integer gameId,Long ticketId) {
		JsonArray resultado_premio = new JsonArray();
		ArrayList resultado_jugada = new ArrayList();
		Map aciertos_resultado=new HashMap();
		JsonObject premio= new JsonObject();
		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		
		try {
			TicketProcedureGetClientTicket ticketSale = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
			String bet1 = "";int multiplicador=0;
			multiplicador=ticketSale.getCtBetMultiA();
			if (ticketSale.getCtBetMatrix1() != null) {
				bet1 = " " +ticketSale.getCtBetMatrix1()+ " ";
			}
			 String[] corte_cadena;
			 String jugada="";
	         corte_cadena = bet1.toString().split(":");
	         jugada = corte_cadena[1].toString();
			
			AciertoscotejadorUtil s = new AciertoscotejadorUtil();
		
			if(s.d_m_a_primero>0){	
			aciertos_resultado.put("A", "A");	
			aciertos_resultado.put("acierto",s.d_m_a_primero);	
			aciertos_resultado.put("tipo_A","DMA");
			aciertos_resultado.put("jugada",jugada);
			aciertos_resultado.put("factor","15,000");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(15000*1*multiplicador));
			}
			if(s.d_m_primero>0){
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",s.d_m_primero);	
			aciertos_resultado.put("tipo_A","DM");
			aciertos_resultado.put("jugada",jugada.substring(0,jugada.length()-3));
			aciertos_resultado.put("factor","30");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(30*1*multiplicador));
			}
			if(s.d_primero>0){
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",s.d_primero);	
			aciertos_resultado.put("tipo_A","D");
			aciertos_resultado.put("jugada",jugada.substring(0,jugada.length()-6));
			aciertos_resultado.put("factor","30");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(4*1*multiplicador));
			}
	
		
			if(s.d_m_segundo>0){
			aciertos_resultado.put("A", "A");	
			aciertos_resultado.put("acierto",s.d_m_segundo);	
			aciertos_resultado.put("tipo_A","DM");
			aciertos_resultado.put("jugada",jugada);
			aciertos_resultado.put("factor","200");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(200*1*multiplicador));
			}
			if(s.d_segundo>0){
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",s.d_segundo);	
			aciertos_resultado.put("tipo_A","D");
			aciertos_resultado.put("jugada",jugada.substring(0,jugada.length()-3));
			aciertos_resultado.put("factor","4");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(4*1*multiplicador));
			}	
		
				
			if(s.anio>0){
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",s.anio);	
			aciertos_resultado.put("tipo_A","A");
			aciertos_resultado.put("jugada",jugada);
			aciertos_resultado.put("factor","60");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(60*1*multiplicador));
			}
			
			
			if(s.dia>0){
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",s.dia);	
			aciertos_resultado.put("tipo_A","D");
			aciertos_resultado.put("jugada",jugada);
			aciertos_resultado.put("factor","20");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(20*1*multiplicador));
			}
		
			if(s.mes>0){
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",s.mes);	
			aciertos_resultado.put("tipo_A","M");
			aciertos_resultado.put("jugada",jugada);
			aciertos_resultado.put("factor","6");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio",(6*1*multiplicador));
			}
				
			
			
			else{
			aciertos_resultado.put("A", "A");
			aciertos_resultado.put("acierto",0);	
			aciertos_resultado.put("tipo_A",corte_cadena[0].toString());
			aciertos_resultado.put("jugada","-");
			aciertos_resultado.put("factor","0");
			aciertos_resultado.put("apuesta","1.0");
			aciertos_resultado.put("multiplicador",multiplicador);
			aciertos_resultado.put("premio","0.0");	
				
				
			}
			resultado_jugada.add(aciertos_resultado);
			if(s.d_m_a_primero>0 || s.d_m_primero>0 || s.d_primero>0 || s.d_m_segundo>0 || s.d_segundo>0
					|| s.anio>0 || s.dia>0 || s.mes>0){
				NumberFormat formatter = new DecimalFormat("#0.00");
				if(String.valueOf(ticketSale.getCtTwPrizeAmount())== null){
				premio.addProperty("totalPremio","0.0");
				}else{
				premio.addProperty("totalPremio",formatter.format(ticketSale.getCtTwPrizeAmount()));
				}
			}else{
				premio.addProperty("totalPremio","0.0");	
			}
			premio.add("acierto_jugada", new Gson().toJsonTree(resultado_jugada));
			
			resultado_premio.add(premio);
			
		} catch (Exception e) {
			System.out.println("Mensaje_Warning_Fechaza: " + e.getMessage());
		} finally {

		}

		return resultado_premio;
	}
	


}
