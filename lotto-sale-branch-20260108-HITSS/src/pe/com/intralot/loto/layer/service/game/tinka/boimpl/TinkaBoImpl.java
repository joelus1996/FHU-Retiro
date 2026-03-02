package pe.com.intralot.loto.layer.service.game.tinka.boimpl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.ViewFlagPopupSiosi;
import pe.com.intralot.loto.layer.model.persistence.dao.FlagPopupSiosiDao;
import pe.com.intralot.loto.layer.model.persistence.dao.TinkaSaleDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.tinka.bo.TinkaBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.CombinacionesUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.CotejadorUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class TinkaBoImpl implements TinkaBo {

    @Autowired
    private TinkaSaleDao tinkaSaleDao;
    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private FlagPopupSiosiDao flagPopupSiosiDao;

    @Override
    public TinkaProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId= " + p_clientId);
        TinkaProcedureBetData objectDomain = new TinkaProcedureBetData();
        try {
            objectDomain = tinkaSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("Status= " + objectDomain.getStatus() + " Message=" + objectDomain.getMessage() + " Prize=" + objectDomain.getPrize()
                        + " ActiveDraw=" + objectDomain.getActiveDraw() + " CloseDate=" + objectDomain.getCloseDate() + " CloseHour=" + objectDomain.getCloseHour()
                        + " NextDraw=" + objectDomain.getNextDraw() + " OpenDate=" + objectDomain.getOpenDate() + " OpenHour=" + objectDomain.getOpenHour()
                        + " NumbersMore=" + objectDomain.getNumbersMore() + " NumbersLess=" + objectDomain.getNumbersLess() + " PriceType="+ objectDomain.getPriceType() 
                        + " PriceMessage=" + objectDomain.getPriceMessage() + " SimpleBetPrice=" + objectDomain.getSimpleBetPrice() + " PromotionType=" + objectDomain.getPromotionType() 
                        + " BalanceAmount=" + objectDomain.getBalanceAmount() + " BalanceAmountGame=" + objectDomain.getBalanceAmountGame() + " Algorithm=" + objectDomain.getAlgorithm() 
                        + " Bets=" + objectDomain.getBets() + " Pay=" + objectDomain.getPay() + " Draws=" + objectDomain.getDraws() + " Cost=" + objectDomain.getCost() + " OtherAmount=" + objectDomain.getOtherAmount()
                        + " OtherQuantity=" + objectDomain.getOtherQuantity());        }
        return objectDomain;
    }
    
    @Override
    public TinkaProcedureBetDataSubscribe findSubscribeByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId= " + p_clientId);
        TinkaProcedureBetDataSubscribe objectDomain = new TinkaProcedureBetDataSubscribe();
        try {
            objectDomain = tinkaSaleDao.findBetDataSubscribe(p_clientId);
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
                        + " BalanceAmount=" + objectDomain.getBalanceAmount() + " BalanceAmountGame=" + objectDomain.getBalanceAmountGame() + " Algorithm=" + objectDomain.getAlgorithm() 
                        + " Bets=" + objectDomain.getBets() + " Pay=" + objectDomain.getPay() + " Draws=" + objectDomain.getDraws() + " Cost=" + objectDomain.getCost() 
                        + " FirstMonths=" + objectDomain.getFirstMonths() + " FirstDraws=" + objectDomain.getFirstDraws() + " FirstDiscount=" + objectDomain.getFirstDiscount() 
						+ " SecondMonths=" + objectDomain.getSecondMonths() + " SecondDraws=" + objectDomain.getSecondDraws() + " SecondDiscont=" + objectDomain.getSecondDiscont() 
						+ " TirdMonths=" + objectDomain.getTirdMonths() + " TirdDraws=" + objectDomain.getTirdDraws() + " TirdDiscount=" + objectDomain.getTirdDiscount() 
						+ " FourthMonths=" + objectDomain.getFourthMonths() + " FourthDraws=" + objectDomain.getFourthDraws() + " FourthDiscount=" + objectDomain.getFourthDiscount() +" BasePrice=" + objectDomain.getBasePrice() + " OtherAmount=" + objectDomain.getOtherAmount());
        }
        return objectDomain;
    }

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isTinkaSale = Boolean.valueOf(ConnectionFactory.operationProperty("tinkaSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String tinkaSaleUsers = ""; // String.valueOf(ConnectionFactory.operationProperty("tinkaSaleUsers", Constants.contextSale)).toString().trim();
        if (isTinkaSale == false) {
            if (tinkaSaleUsers != null && !tinkaSaleUsers.equals("")) {
                String[] saleUsers = tinkaSaleUsers.split(",");
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
    public boolean isSubscriptionAllowedGoIn(String user) {
        boolean isTinkaSubscription = Boolean.valueOf(ConnectionFactory.operationProperty("tinkaSubscriptionEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String tinkaSubscriptionUsers = String.valueOf(ConnectionFactory.operationProperty("tinkaSubscriptionUsers", Constants.contextSale)).toString().trim();
        if (isTinkaSubscription == false) {
            if (tinkaSubscriptionUsers != null && !tinkaSubscriptionUsers.equals("")) {
                String[] subscriptionUsers = tinkaSubscriptionUsers.split(",");
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
    public void reinicioValoresAciertos() {
        AciertoscotejadorUtil a_c = new AciertoscotejadorUtil();
        a_c.dos_aciertos = 0;
        a_c.tres_aciertos = 0;
        a_c.cuatro_ac_yapa = 0;
        a_c.cuatro_aciertos = 0;
        a_c.cinco_ac_yapa = 0;
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
                String bet1 = "", bet2 = "", bet3 = "", bet4 = "", resultado = "", yapa = "";
                resultado = " " + draw_array.getDrResult() + " ";
                yapa = " " + draw_array.getDrExtra() + " ";
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
                yapa = " " + draw_array.getDrExtra() + " ";
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
                            cotejo.addProperty("yapa", yapa);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado, yapa);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                        }
                } else if (tipo_jugada.equals("B")) {
                    if (ticket.getCtBetMatrix2() != null) {
                        jugada = " " + ticket.getCtBetMatrix2() + " ";
                        if (bet2.length() > 5) {
                            cotejo.addProperty("sorteo", drawId);
                            cotejo.addProperty("fecha", fechas);
                            cotejo.addProperty("yapa", yapa);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado, yapa);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaB", bet2);
                            CotejadorUtil cotejador_alg_b2 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
                            CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado, yapa);
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
                            cotejo.addProperty("yapa", yapa);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado, yapa);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaB", bet2);
                            CotejadorUtil cotejador_alg_b2 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
                            CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado, yapa);
                            cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaC", bet3);
                            CotejadorUtil cotejador_alg_b3 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b3.ordenar_array_menor_mayor(bet3);
                            CombinacionesUtil combinaciones_b3 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3, resultado, yapa);
                            cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
                        }
                    }
                } else if (tipo_jugada.equals("D"))
                    if (ticket.getCtBetMatrix2() != null) {
                        jugada = " " + ticket.getCtBetMatrix2() + " ";
                        if (jugada.length() > 5) {
                            cotejo.addProperty("sorteo", drawId);
                            cotejo.addProperty("fecha", fechas);
                            cotejo.addProperty("yapa", yapa);
                            cotejo.addProperty("resultado", resultado);
                            cotejo.addProperty("jugadaA", bet1);
                            CotejadorUtil cotejador_alg = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado, yapa);
                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaB", bet2);
                            CotejadorUtil cotejador_alg_b2 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
                            CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado, yapa);
                            cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaC", bet3);
                            CotejadorUtil cotejador_alg_b3 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b3.ordenar_array_menor_mayor(bet3);
                            CombinacionesUtil combinaciones_b3 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3, resultado, yapa);
                            cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
                            cotejo.addProperty("jugadaD", bet4);
                            CotejadorUtil cotejador_alg_b4 = new CotejadorUtil();
                            jugada_ordenada = cotejador_alg_b4.ordenar_array_menor_mayor(bet4);
                            CombinacionesUtil combinaciones_b4 = new CombinacionesUtil(jugada_ordenada, 6);
                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b4, resultado, yapa);
                            cotejo.add("cotejo_jugada_D", new Gson().toJsonTree(jugada_resultado));
                        }
                    }
                datos_jugada_cotejo.add(cotejo);
            }
        } catch (Exception e) {
            System.out.println("Mensaje_Warning_tinka: " + e.getMessage());
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
            resultados.addProperty("dos", num_a.dos_aciertos);
            if (num_a.dos_aciertos > 0) {
                resultados.addProperty("acierto_dos", "2 aciertos");
                resultados.addProperty("caduca_dos", ticketSale.getCt2x1ExpirationDate());
                if (ticketSale.getTw2x1Columns() == 1)
                    resultados.addProperty("premio_total_dos", num_a.dos_aciertos * 2 + " jugada a mitad de precio");
                else
                    resultados.addProperty("premio_total_dos", num_a.dos_aciertos * 2 + " jugadas a mitad de precio");
            }
            resultados.addProperty("tres", num_a.getTres_aciertos());
            if (num_a.dos_aciertos > 0)
                if (num_a.getTres_aciertos() > 0) {
                    resultados.addProperty("acierto_tres", "3 aciertos");
                    resultados.addProperty("caduca_tres", ticketSale.getCtFreeExpirationDate());
                    if (ticketSale.getTwTwfreeColumns() == 1)
                        resultados.addProperty("premio_total_tres", num_a.getTres_aciertos() + " jugada Gratis");
                    else
                        resultados.addProperty("premio_total_tres", num_a.getTres_aciertos() + " jugadas Gratis");
                }
            resultados.addProperty("cuatro", num_a.getCuatro_aciertos());
            if (num_a.getCuatro_aciertos() > 0) {
                resultados.addProperty("acierto_cuatro", "4 aciertos");
                resultados.addProperty("premio_total_cuatro", "S/." + num_a.getCuatro_aciertos() * 100);
                resultados.addProperty("caduca_cuatro", ticketSale.getCtPrizeExpirationDate());
            }
            resultados.addProperty("cuatro_yapa", num_a.getCuatro_ac_yapa());
            if (num_a.getCuatro_ac_yapa() > 0) {
                resultados.addProperty("acierto_cuatro_yapa", "4 aciertos + 1");
                resultados.addProperty("premio_total_cuatro_yapa", "S/." + num_a.cuatro_ac_yapa * 5000);
                resultados.addProperty("caduca_cuatro_yapa", ticketSale.getCtPrizeExpirationDate());
            }
            resultados.addProperty("cinco", num_a.cinco_aciertos);
            if (num_a.cinco_aciertos > 0) {
                resultados.addProperty("acierto_cinco", "5 aciertos");
                resultados.addProperty("premio_total_cinco", "S/." + num_a.cinco_aciertos * 3000);
                resultados.addProperty("caduca_cinco", ticketSale.getCtPrizeExpirationDate());
            }
            resultados.addProperty("cinco_yapa", num_a.cinco_ac_yapa);
            if (num_a.cinco_ac_yapa > 0) {
                resultados.addProperty("acierto_cinco_yapa", "5 aciertos + 1");
                resultados.addProperty("premio_total_cinco_yapa", "S/." + num_a.cinco_ac_yapa * 30000);
                resultados.addProperty("caduca_cinco_yapa", ticketSale.getCtPrizeExpirationDate());
            }
            resultados.addProperty("seis", num_a.seis_aciertos);
            if (num_a.seis_aciertos > 0) {
                resultados.addProperty("acierto_seis", "6 aciertos");
                resultados.addProperty("premio_total_seis", "POZO MILLONARIO");
                resultados.addProperty("caduca_seis", ticketSale.getCtPrizeExpirationDate());
            }
            NumberFormat formatter = new DecimalFormat("#0.00");
            resultados.addProperty("totalPremio", formatter.format(ticketSale.getCtTwPrizeAmount()));
            resultado_premio.add(resultados);
        } catch (Exception e) {
            System.out.println("Mensaje_Warning_tinka : " + e.getMessage());
        } finally {
        }
        return resultado_premio;
    }

    @Override
    public List<TinkaProcedureDrawData> findListDraw() throws Exception {
        List<TinkaProcedureDrawData> resultQueryList = new ArrayList<TinkaProcedureDrawData>();
        try {
            resultQueryList = tinkaSaleDao.findListDrawData();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("size= " + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public JsonArray cotejoJugada(String tipo_jugada, int from, int to, int gameID, int ticketId) {
        ArrayList jugada_ordenada = new ArrayList();
        ArrayList jugada_resultado = new ArrayList();
        JsonArray jaLists = new JsonArray();
        /*
         * try{ for(int i=from;i<=to;i++){ ClientTicket ticket = clientTicketBo.findById(ticketId); Draw draw_array = drawBo.findByIdByGameId(i,gameID); String
         * bet1="",bet2="",bet3="",bet4="",resultado="",yapa=""; resultado=" "+draw_array.getDrResult()+" "; yapa=" "+draw_array.getDrExtra()+" "; String jugada =""; if(tipo_jugada.equals("A")){
         * jugada=" "+ticket.getCtBetMatrix1()+" "; }else if(tipo_jugada.equals("B")){ jugada=" "+ticket.getCtBetMatrix2()+" "; }else if(tipo_jugada.equals("C")){
         * jugada=" "+ticket.getCtBetMatrix3()+" "; }else if(tipo_jugada.equals("D")){ jugada=" "+ticket.getCtBetMatrix4()+" "; } algoritmo_cotejadores cotejo=new algoritmo_cotejadores();
         * jugada_ordenada=cotejo.ordenar_array_menor_mayor(jugada); algoritmo_combinaciones_jugada combinaciones=new algoritmo_combinaciones_jugada(jugada_ordenada, 6) ; jugada_resultado=
         * cotejo.cotejo_aciertos_jugada(combinaciones,resultado,yapa); JsonObject joElement = new JsonObject(); for(int k=0;k<jugada_resultado.size();k++){ String
         * resultado_combinatoria=jugada_resultado.get(k).toString(); joElement.addProperty("combinatorias",resultado_combinatoria); System.out.println("N�: "+k+"(RESULTADOS COTEJOS :  "+
         * resultado_combinatoria+")"); } jaLists.add(joElement); } } catch(Exception e) { System.out.println("Mensaje : "+e.getMessage()); } finally { }
         */
        return jaLists;
    }

    @Override
    public ArrayList<Integer> valoresBoleto() throws Exception {
        ArrayList<Integer> valoresBol = new ArrayList<Integer>();
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
    public JsonArray datosJugadaCotejo(String tipo_jugada, int from, int to, int gameID, String jugadaCompl, String plus, String chauChamba) {
        JsonArray datos_jugada_cotejo = new JsonArray();
        String[] jugadaCompleta;
        jugadaCompleta = jugadaCompl.split("-"); 
        String jugadaA = jugadaCompleta[0];
        String jugadaB = jugadaCompleta[1];
        String jugadaC = jugadaCompleta[2];
        String jugadaD = jugadaCompleta[3]; 
        try {
            for (int i = from; i < to; i++) {
                JsonObject cotejo = new JsonObject();
                ArrayList<String> jugada_resultado = new ArrayList<String>(); 
                Draw draw_array = drawBo.findByIdByGameId(i, gameID);
                String bet1 = "", bet2 = "", bet3 = "", bet4 = "", resultado = "" ;
                resultado = " " + draw_array.getDrResult() + " "; 
                boolean is3mas12mas1 = (draw_array.getDrCat15()!=null && draw_array.getDrCat15().intValue() > 0);
                bet1 = jugadaA.replace("01", "1").replace("02", "2").replace("03", "3").replace("04", "4").replace("05", "5").replace("06", "6").replace("07", "7").replace("08", "8").replace("09", "9");
                bet2 = jugadaB.replace("01", "1").replace("02", "2").replace("03", "3").replace("04", "4").replace("05", "5").replace("06", "6").replace("07", "7").replace("08", "8").replace("09", "9");
                bet3 = jugadaC.replace("01", "1").replace("02", "2").replace("03", "3").replace("04", "4").replace("05", "5").replace("06", "6").replace("07", "7").replace("08", "8").replace("09", "9");
                bet4 = jugadaD.replace("01", "1").replace("02", "2").replace("03", "3").replace("04", "4").replace("05", "5").replace("06", "6").replace("07", "7").replace("08", "8").replace("09", "9");
                String fecha_r = " " + draw_array.getDrDate().toString() + " ";
                String fecha_completa = fecha_r + "";
                String dia = "", mes = "", ano = "", fechas = "";
                ano = fecha_completa.substring(1, 5);
                mes = fecha_completa.substring(6, 8);
                dia = fecha_completa.substring(9, 11);
                fechas = dia + "/" + mes + "/" + ano;
                String drawId = "";
                drawId = String.valueOf(i);
                CotejadorUtil cotejador_alg = new CotejadorUtil();
                cotejo.addProperty("sorteo", drawId);
                cotejo.addProperty("fecha", fechas);
                cotejo.addProperty("resultado", resultado);
                cotejo.addProperty("yapa", draw_array.getDrExtra()); 
                if (bet1.length() > 4) {
                    cotejo.addProperty("jugadaA", bet1);
                    jugada_resultado = cotejador_alg.cotejoAciertosTinka(bet1, resultado, draw_array.getDrExtra(), is3mas12mas1);
                    cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
                }
                if (bet2.length() > 4) {
                    cotejo.addProperty("jugadaB", bet2);
                    jugada_resultado = cotejador_alg.cotejoAciertosTinka(bet2, resultado, draw_array.getDrExtra(), is3mas12mas1);
                    cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
                }
                if (bet3.length() > 4) {
                    cotejo.addProperty("jugadaC", bet3);
                    jugada_resultado = cotejador_alg.cotejoAciertosTinka(bet3, resultado, draw_array.getDrExtra(), is3mas12mas1);
                    cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
                }
                if (bet4.length() > 4) {
                    cotejo.addProperty("jugadaD", bet4);
                    jugada_resultado = cotejador_alg.cotejoAciertosTinka(bet4, resultado, draw_array.getDrExtra(), is3mas12mas1);
                    cotejo.add("cotejo_jugada_D", new Gson().toJsonTree(jugada_resultado));
                }
                datos_jugada_cotejo.add(cotejo);
            }
        } catch (Exception e) {
        	LoggerApi.severe(e); 
        } finally {
        }
        return datos_jugada_cotejo;
    }
    
    @Override
    public String[] findTinkaNextDraw() throws Exception {
        String[] resultQuery = null;
        try {
            resultQuery = tinkaSaleDao.findTinkaNextDraw();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("size= " + resultQuery.length);
        }
        return resultQuery;
    }
    
    @Override
    public boolean isPopupSiosiActive() {        
    	String valueFlag = (ConnectionFactory.operationProperty("flagPromoTinka", Constants.contextCardWeb)!=null && !String.valueOf(ConnectionFactory.operationProperty("flagPromoTinka", Constants.contextCardWeb)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("flagPromoTinka", Constants.contextCardWeb)).toString().trim():"0";
    	boolean isFlagPromoTinka = BooleanUtils.toBoolean(Integer.parseInt(valueFlag.trim()));
        boolean isActive = false;
        try {
	        if (isFlagPromoTinka) {
	        	ViewFlagPopupSiosi viewFlagPopupSiosi = flagPopupSiosiDao.getFlagPopup();
	        	if( BooleanUtils.toBoolean(viewFlagPopupSiosi.getFlagPopup()) ) {
	        		isActive = true;
	        	}	        	
	        } 
        } catch (Exception e) {
        	LoggerApi.severe(e); 
        } finally {
        }
        return isActive;
    }
    

    public boolean isPopup3x12Active() {
    	boolean isPopup3x12Active = false;
    	try {
    		Calendar calendarHoy = Calendar.getInstance();
    		Calendar StartPopupTinka3x12 = Calendar.getInstance();
			Calendar EndPopupTinka3x12 = Calendar.getInstance();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    		String str_StartPopupTinka3x12 = String.valueOf(ConnectionFactory.operationProperty("startPopupTinka3x12", Constants.contextSale)).toString().trim();
        	String str_EndPopupTinka3x12 = String.valueOf(ConnectionFactory.operationProperty("endPopupTinka3x12", Constants.contextSale)).toString().trim();
        	StartPopupTinka3x12.setTime(formato.parse(str_StartPopupTinka3x12));
        	EndPopupTinka3x12.setTime(formato.parse(str_EndPopupTinka3x12));
			if(calendarHoy.after(StartPopupTinka3x12) && calendarHoy.before(EndPopupTinka3x12) )
				isPopup3x12Active = true;
    	}catch (Exception e) {
        	LoggerApi.severe(e); 
        }
    	
    	return isPopup3x12Active;
    }
}
