package pe.com.intralot.loto.layer.service.game.kabala.boimpl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataChCh;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.KabalaSaleDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.kabala.bo.KabalaBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.CombinacionesUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.CotejadorUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**<p> NAME:    KabalaBoImpl.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    06/07/2018  Se quita import innecesario DateAPI y lectura del kabalaSaleUsers (properties) 
 * </pre>
 * </p>
 */

@Service
public class KabalaBoImpl implements KabalaBo {

    @Autowired
    private KabalaSaleDao kabalaProcedureDao;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private TicketSaleBo ticketSaleBo;

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isKabalaSale = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String kabalaSaleUsers = ""; // String.valueOf(ConnectionFactory.operationProperty("kabalaSaleUsers", Constants.contextSale)).toString().trim();
        if (isKabalaSale == false) {
            if (kabalaSaleUsers != null && !kabalaSaleUsers.equals("")) {
                String[] saleUsers = kabalaSaleUsers.split(",");
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
    public KabalaProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        KabalaProcedureBetData objectDomain = new KabalaProcedureBetData();
        try {
            objectDomain = kabalaProcedureDao.findProcedureBetData(p_clientId);
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
	public KabalaProcedureBetDataSubscribe findSubscribeByClientId(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId=" + p_clientId);
        KabalaProcedureBetDataSubscribe objectDomain = new KabalaProcedureBetDataSubscribe();
        try {
            objectDomain = kabalaProcedureDao.findProcedureBetDataSubscribe(p_clientId);
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
                        + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost()
                        + " w_1st_months=" + objectDomain.getFirstMonths() + " w_1st_draws=" + objectDomain.getFirstDraws() + " w_1st_discount=" + objectDomain.getFirstDiscount() 
						+ " w_2nd_months=" + objectDomain.getSecondMonths() + " w_2nd_draws=" + objectDomain.getSecondDraws() + " w_2nd_discount=" + objectDomain.getSecondDiscont() 
						+ " w_3rd_months=" + objectDomain.getTirdMonths() + " w_3rd_draws=" + objectDomain.getTirdDraws() + " w_3rd_discount=" + objectDomain.getTirdDiscount() 
						+ " w_4th_months=" + objectDomain.getFourthMonths() + " w_4th_draws=" + objectDomain.getFourthDraws() + " w_4th_discount=" + objectDomain.getFourthDiscount() + " w_base_price=" + objectDomain.getBasePrice() + " OtherAmount=" + objectDomain.getOtherAmount());
        }
        return objectDomain;
	}
    
    @Override
    public KabalaProcedureBetDataChCh findByClientIdChCh(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        KabalaProcedureBetDataChCh objectDomain = new KabalaProcedureBetDataChCh();
        try {
            objectDomain = kabalaProcedureDao.findProcedureBetDataChCh(p_clientId);
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
                        + " w_prev_bet_price=" + objectDomain.getPrevBetPrice() + " w_promotion_type=" + objectDomain.getPromotionType() + " w_balance_amount="
                        + objectDomain.getBalanceAmount() + " w_balance_amount_game=" + objectDomain.getBalanceAmountGame() + " w_balance_quantity_game=" + objectDomain.getBalanceQuantityGame() + " w_algorithm=" + objectDomain.getAlgorithm()
                        + " w_bets=" + objectDomain.getBets() + " w_pay=" + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost());
        }
        return objectDomain;
    }

    @Override
    public List<KabalaProcedureDrawData> findListDraw() throws Exception {
        List<KabalaProcedureDrawData> resultQueryList = new ArrayList<KabalaProcedureDrawData>();
        try {
            resultQueryList = kabalaProcedureDao.findProcedureDrawData();
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
        if (date != null) {
            try {
                calDate = formato.parse(date);
            } catch (ParseException e) { 
                e.printStackTrace();
            }
            name = new SimpleDateFormat("EEE dd MMM", new Locale("es", "ES"));
            nameFormat = name.format(calDate);
            return nameFormat.toUpperCase();
        } else
            return "";
    }

    @Override
    public JsonArray cotejoJugada(String tipo_jugada, int from, int to, int gameID, Long ticketId) { 
        return null;
    }

    @Override
    public void reinicioValoresAciertos() {
        AciertoscotejadorUtil a_c = new AciertoscotejadorUtil();
        a_c.dos_aciertos = 0;
        a_c.tres_aciertos = 0;
        a_c.cuatro_aciertos = 0;
        a_c.cinco_aciertos = 0;
        a_c.seis_aciertos = 0;
    }

    @Override
    public JsonArray datosJugada(String tipo_jugada, int from, int to, int gameID, Long ticketId) {
        JsonArray datos_jugada_cotejo = new JsonArray();
        try {
            for (int i = from; i <= to; i++) {
                JsonObject cotejo = new JsonObject();
                ArrayList jugada_ordenada = new ArrayList();
                ArrayList jugada_resultado = new ArrayList();
                ClientTicket ticket = clientTicketBo.findById(ticketId);
                Draw draw_array = drawBo.findByIdByGameId(i, gameID);
                String bet1 = "", bet2 = "", bet3 = "", bet4 = "", resultado = "";
                resultado = " " + draw_array.getDrResult() + " ";
                String jugada = "";
                if (ticket.getCtBetMatrix1() != null)
                    bet1 = " " + ticket.getCtBetMatrix1() + " ";
                if (ticket.getCtBetMatrix2() != null)
                    bet2 = " " + ticket.getCtBetMatrix2() + " ";
                if (ticket.getCtBetMatrix3() != null)
                    bet3 = " " + ticket.getCtBetMatrix3() + " ";
                if (ticket.getCtBetMatrix4() != null)
                    bet4 = " " + ticket.getCtBetMatrix4() + " ";
                resultado = " " + draw_array.getDrResult() + " ";
                String fecha_r = " " + draw_array.getDrDate().toString() + " ";
                String fecha_completa = fecha_r + "";
                String dia = "", mes = "", ano = "", fechas = "";
                ano = fecha_completa.substring(1, 5);
                mes = fecha_completa.substring(6, 8);
                dia = fecha_completa.substring(9, 11);
                fechas = dia + "/" + mes + "/" + ano;
                String drawId = "";
                drawId = ticket.getCtDrawId();
                if (tipo_jugada.equals("A")) {
                    if (ticket.getCtBetMatrix1() != null)
                        if (bet1.length() > 5) {
                            cotejo.addProperty("sorteo", drawId);
                            cotejo.addProperty("fecha", fechas);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 5);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                        }
                } else if (tipo_jugada.equals("B")) {
                    if (ticket.getCtBetMatrix2() != null) {
                        jugada = " " + ticket.getCtBetMatrix2() + " ";
                        if (bet2.length() > 5) {
                            cotejo.addProperty("sorteo", drawId);
                            cotejo.addProperty("fecha", fechas);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaB", bet2);
                            CotejadorUtil cotejador_alg_b2 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
                            CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado);
                            cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
                            // cotejo.addProperty("jugadaB", new Gson().toJsonTree(src));
                        }
                    }
                } else if (tipo_jugada.equals("C")) {
                    if (ticket.getCtBetMatrix2() != null) {
                        jugada = " " + ticket.getCtBetMatrix2() + " ";
                        if (bet3.length() > 5) {
                            cotejo.addProperty("sorteo", drawId);
                            cotejo.addProperty("fecha", fechas);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaB", bet2);
                            CotejadorUtil cotejador_alg_b2 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
                            CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado);
                            cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaC", bet3);
                            CotejadorUtil cotejador_alg_b3 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b3.ordenar_array_menor_mayor(bet3);
                            CombinacionesUtil combinaciones_b3 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3, resultado);
                            cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
                        }
                    }
                } else if (tipo_jugada.equals("D"))
                    if (ticket.getCtBetMatrix2() != null) {
                        jugada = " " + ticket.getCtBetMatrix2() + " ";
                        if (jugada.length() > 5) {
                            cotejo.addProperty("sorteo", drawId);
                            cotejo.addProperty("fecha", fechas);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaB", bet2);
                            CotejadorUtil cotejador_alg_b2 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
                            CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado);
                            cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaC", bet3);
                            CotejadorUtil cotejador_alg_b3 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b3.ordenar_array_menor_mayor(bet3);
                            CombinacionesUtil combinaciones_b3 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3, resultado);
                            cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaD", bet4);
                            CotejadorUtil cotejador_alg_b4 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b4.ordenar_array_menor_mayor(bet4);
                            CombinacionesUtil combinaciones_b4 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b4, resultado);
                            cotejo.add("cotejo_jugada_D", new Gson().toJsonTree(jugada_resultado));
                        }
                    }
                datos_jugada_cotejo.add(cotejo);
            }
        } catch (Exception e) {
        	System.out.println("Mensaje_Warning_Kabala : " + e.getMessage());
        } finally {
        }
        return datos_jugada_cotejo;
    }

    @Override
    public JsonArray resultado_premios(Integer clientId, Integer gameId, Long ticketId) {
        JsonArray resultado_premio = new JsonArray();
        JsonObject resultados = new JsonObject();
        AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
        try {
            TicketProcedureGetClientTicket ticketSale = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
            resultados.addProperty("dos", num_a.getDos_aciertos());
            if (num_a.getDos_aciertos() > 0) {
                resultados.addProperty("acierto_dos", "2 aciertos");
                resultados.addProperty("caduca_dos", ticketSale.getCtFreeExpirationDate());
                if (ticketSale.getTwTwfreeColumns() == 1)
                    resultados.addProperty("premio_total_dos", num_a.getDos_aciertos() + " jugada Gratis");
                else
                    resultados.addProperty("premio_total_dos", num_a.getDos_aciertos() + " jugadas Gratis");
            }
            resultados.addProperty("tres", num_a.getTres_aciertos());
            if (num_a.getTres_aciertos() > 0) {
                resultados.addProperty("acierto_tres", "3 aciertos");
                resultados.addProperty("caduca_tres", ticketSale.getCtPrizeExpirationDate());
                resultados.addProperty("premio_total_tres", "S/." + num_a.getTres_aciertos() * 1.5);
            }
            resultados.addProperty("cuatro", num_a.getCuatro_aciertos());
            if (num_a.getCuatro_aciertos() > 0) {
                resultados.addProperty("acierto_cuatro", "4 aciertos");
                resultados.addProperty("premio_total_cuatro", "S/." + num_a.getCuatro_aciertos() * 15);
                resultados.addProperty("caduca_cuatro", ticketSale.getCtPrizeExpirationDate());
            }
            resultados.addProperty("cinco", num_a.cinco_aciertos);
            if (num_a.cinco_aciertos > 0) {
                resultados.addProperty("acierto_cinco", "5 aciertos");
                resultados.addProperty("premio_total_cinco", "S/." + num_a.cinco_aciertos * 500);
                resultados.addProperty("caduca_cinco", ticketSale.getCtPrizeExpirationDate());
            }
            resultados.addProperty("seis", num_a.seis_aciertos);
            if (num_a.seis_aciertos > 0) {
                resultados.addProperty("acierto_seis", "6 aciertos");
                resultados.addProperty("premio_total_seis", "S/." + num_a.seis_aciertos * 190000);
                resultados.addProperty("caduca_seis", ticketSale.getCtPrizeExpirationDate());
            }
            NumberFormat formatter = new DecimalFormat("#0.00");
            resultados.addProperty("totalPremio", formatter.format(ticketSale.getCtTwPrizeAmount()));
            resultado_premio.add(resultados);
        } catch (Exception e) {
        	System.out.println("Mensaje_Warning_Kabala: " + e.getMessage());
        } finally {
        }
        return resultado_premio;
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

	@Override
	public JsonArray cotejoAciertosKabala(String tipoJugada, int from, int to,int gameID, String jugadaCompl, String plus, String chauChamba) {
		
         LoggerApi.Log.info("cotejo_ajax tipoJugada=" + tipoJugada + " from=" + from + " to=" + to + " gameID=" + gameID + " jugadaCompl=" + jugadaCompl +  " plus=" + plus +  " chauChamba=" + chauChamba);

		 JsonArray datosJugadaCotejo = new JsonArray(); 
		 
		 String [] pluscompleto=plus.split("-");
		 String [] jugadaCompleta=jugadaCompl.split("-");
		 String [] chauchambaCompleto=chauChamba.split("-");
		 
		 String jugadaA=jugadaCompleta[0].replace("01","1").replace("02","2").replace("03","3").replace("04","4").replace("05","5").replace("06","6").replace("07","7").replace("08","8").replace("09","9");
		 String jugadaB=jugadaCompleta[1].replace("01","1").replace("02","2").replace("03","3").replace("04","4").replace("05","5").replace("06","6").replace("07","7").replace("08","8").replace("09","9");
		 String jugadaC=jugadaCompleta[2].replace("01","1").replace("02","2").replace("03","3").replace("04","4").replace("05","5").replace("06","6").replace("07","7").replace("08","8").replace("09","9");
		 String jugadaD=jugadaCompleta[3].replace("01","1").replace("02","2").replace("03","3").replace("04","4").replace("05","5").replace("06","6").replace("07","7").replace("08","8").replace("09","9");
		 
		 String plusA=pluscompleto[0].trim();
		 String plusB=pluscompleto[1].trim();
		 String plusC=pluscompleto[2].trim();
		 String plusD=pluscompleto[3].trim();
		 
		 String chauChmbA=chauchambaCompleto[0].trim().replace("0", "");
		 String chauChmbB=chauchambaCompleto[1].trim().replace("0", "");
		 String chauChmbC=chauchambaCompleto[2].trim().replace("0", "");
		 String chauChmbD=chauchambaCompleto[3].trim().replace("0", "");
		 
	        try {
	            for (int i = from; i < to; i++) {
	                JsonObject cotejo = new JsonObject(); 
	                ArrayList<String> jugadaResultado = new ArrayList<String>(); 
	                
	                Draw draw_array = drawBo.findByIdByGameId(i, gameID);
	                //System.out.println("DrResult="+draw_array.getDrResult().replaceAll("\n", " "));
	                
	                String resultado = "";
	                if(draw_array!=null && draw_array.getDrResult()!=null && !draw_array.getDrResult().trim().equals("")) resultado = draw_array.getDrResult().trim().replaceAll("\n", " ");
	                String resultadoChauChamba = "";
	                if(draw_array!=null && draw_array.getDrAddonResult2()!=null && !draw_array.getDrAddonResult2().trim().equals("")) resultadoChauChamba = draw_array.getDrAddonResult2().trim().replaceAll("\n", " ");

	                LoggerApi.Log.info("cotejo_ajax resultado["+i+"]=" + resultado+" resultado_chauChamba["+i+"]=" + resultadoChauChamba);

                	if (resultado==null || resultado.trim().equals("")) {
                		continue;
                	}
                	
	                String fechas = (new SimpleDateFormat("dd/MM/yyyy")).format( draw_array.getDrDate().getTime() );
	        		
	                String drawId = "";
	                drawId = String.valueOf(i);
	                
	                CotejadorUtil cotejadorUtil = new CotejadorUtil();
	                    	
                	if((chauChmbA.equals("1")) || (chauChmbB.equals("1")) || (chauChmbC.equals("1")) || (chauChmbD.equals("1"))){
                    	cotejo.addProperty("resultadoChauchamba", resultadoChauChamba);	
                    }else{
                    	cotejo.addProperty("resultadoChauchamba", "null");
                    }
                	
                    cotejo.addProperty("sorteo", drawId);
                    cotejo.addProperty("fecha", fechas);
                    cotejo.addProperty("resultado", resultado);
                    
                    if (jugadaA.length()>4) {
                    	cotejo.addProperty("jugadaA", jugadaA + (plusA.equals("AD1")?" Plus":" ")  + (chauChmbA.equals("1")?"/Chau Chamba":" ") );
                    	jugadaResultado = cotejadorUtil.cotejoAciertosKabala(jugadaA, resultado,resultadoChauChamba,plusA,chauChmbA,i);
                        cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugadaResultado));
                    }
                    
                    if (jugadaB.length()>4) { 
                    	cotejo.addProperty("jugadaB", jugadaB + (plusB.equals("AD1")?" Plus":" ")  + (chauChmbB.equals("1")?"/Chau Chamba":" ") );
                    	jugadaResultado = cotejadorUtil.cotejoAciertosKabala(jugadaB, resultado,resultadoChauChamba,plusB,chauChmbB,i);
                        cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugadaResultado));
                    }
                    
                    if (jugadaC.length()>4) { 
                    	cotejo.addProperty("jugadaC", jugadaC + (plusC.equals("AD1")?" Plus":" ")  + (chauChmbC.equals("1")?"/Chau Chamba":" ") );
                    	jugadaResultado = cotejadorUtil.cotejoAciertosKabala(jugadaC, resultado,resultadoChauChamba,plusC,chauChmbC,i);
                        cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugadaResultado));
                    }
                    
                    if (jugadaD.length()>4) { 
                    	cotejo.addProperty("jugadaD", jugadaD + (plusD.equals("AD1")?" Plus":" ")  + (chauChmbD.equals("1")?"/Chau Chamba":" ") );
                    	jugadaResultado = cotejadorUtil.cotejoAciertosKabala(jugadaD, resultado,resultadoChauChamba,plusD,chauChmbD,i);
                        cotejo.add("cotejo_jugada_D", new Gson().toJsonTree(jugadaResultado));
                    }
	                          
                    datosJugadaCotejo.add(cotejo);
	            }
	        } catch (Exception e) {
	        	LoggerApi.severe(e); 
	        } finally {
	        }
	        return datosJugadaCotejo;
	}

	@Override
	public boolean isSubscriptionAllowedGoIn(String user) {
		boolean isKabalaSubscription = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaSubscriptionEnabled", Constants.contextSale).trim()).booleanValue();
	       boolean isAllowed = false;
	       String kabalaSubscriptionUsers = String.valueOf(ConnectionFactory.operationProperty("kabalaSubscriptionUsers", Constants.contextSale)).toString().trim();
	       if (isKabalaSubscription == false) {
	           if (kabalaSubscriptionUsers != null && !kabalaSubscriptionUsers.equals("")) {
	               String[] subscriptionUsers = kabalaSubscriptionUsers.split(",");
	               for (String subscriptionUser : subscriptionUsers)
	                   if (subscriptionUser.equals(user)) {
	                       isAllowed = true;
	                       break;
	                   }
	           }
	       } else isAllowed = true;
	    return isAllowed; 		
	}

	@Override
	public String[] findKabalaNextDraw() throws Exception {
		String[] resultQuery = null;
        try {
            resultQuery = kabalaProcedureDao.findKabalaNextDraw();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("size= " + resultQuery.length);
        }
        return resultQuery;
	}
	
}
