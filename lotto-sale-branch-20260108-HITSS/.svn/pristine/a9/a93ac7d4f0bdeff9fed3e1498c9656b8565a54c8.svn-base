package pe.com.intralot.loto.layer.service.game.ganadiario.boimpl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.DrawItem;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketWinner;
import pe.com.intralot.loto.layer.model.domain.TicketWinnerLotos5;
import pe.com.intralot.loto.layer.model.persistence.dao.CountryDao;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawItemDao;
import pe.com.intralot.loto.layer.model.persistence.dao.GanadiarioSaleDao;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketWinnerDao;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketWinnerLotos5Dao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.ganadiario.bo.GanadiarioBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.CombinacionesUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.CotejadorUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**NOMBRE: GanadiarioBoImpl.java
 * 
 * VERSIONES
 * 
 * VER   MODIFICADO  FECHA     COMENTARIO
 * 001   c_achata    13/28/18  valoresBoleto se define sorteos consecutivos correctos
 *
 **/

@Service
public class GanadiarioBoImpl implements GanadiarioBo {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private DrawDao drawDao;
    @Autowired
    private DrawItemDao drawItemDao;
    @Autowired
    private TicketWinnerLotos5Dao ticketWinnerLotos5Dao;
    @Autowired
    private TicketWinnerDao ticketWinnerDao;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private GanadiarioSaleDao ganadiarioSaleDao;

    @Override
    public GanadiarioProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        GanadiarioProcedureBetData objectDomain = new GanadiarioProcedureBetData();
        try {
            objectDomain = ganadiarioSaleDao.findProcedureBetData(p_clientId);
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
                        + " Bets=" + objectDomain.getBets() + " Pay=" + objectDomain.getPay() + " Draws=" + objectDomain.getDraws() + " Cost=" + objectDomain.getCost() + " OtherAmount=" + objectDomain.getOtherAmount());
        }
        return objectDomain;
    }
    
    @Override
	public GanadiarioProcedureBetDataSubscribe findSubscribeByClientId(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId=" + p_clientId);
        GanadiarioProcedureBetDataSubscribe objectDomain = new GanadiarioProcedureBetDataSubscribe();
        try {
            objectDomain = ganadiarioSaleDao.findProcedureBetDataSubscribe(p_clientId);
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
    public List<GanadiarioProcedureDrawData> findListDraw() throws Exception {
        List<GanadiarioProcedureDrawData> resultQueryList = new ArrayList<GanadiarioProcedureDrawData>();
        try {
            resultQueryList = ganadiarioSaleDao.findProcedureDrawData();
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
    public boolean isAllowedGoIn(String user) {
        boolean isGanadiarioSale = Boolean.valueOf(ConnectionFactory.operationProperty("ganadiarioSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String ganadiarioSaleUsers = String.valueOf(ConnectionFactory.operationProperty("ganadiarioSaleUsers", Constants.contextSale)).toString().trim();
        if (isGanadiarioSale == false) {
            if (ganadiarioSaleUsers != null && !ganadiarioSaleUsers.equals("")) {
                String[] saleUsers = ganadiarioSaleUsers.split(",");
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
    public List<Country> findCountryAll() throws Exception {
        logger.info("Ingresar a la clase: GanadiarioProcedureBoImpl.");
        logger.info("Ingresar al metodo: findCountryAll.");
        List<Country> resultQueryList = new ArrayList<Country>();
        try {
            resultQueryList = countryDao.findCountry();
            logger.info("Salir del metodo: findCountryAll.");
            logger.info("Salir de la clase: GanadiarioProcedureBoImpl.");
            return resultQueryList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public Draw findDrawByIdByGameId(Integer drawId, Integer gameID) throws Exception {
        logger.info("Ingresar a la clase: GanadiarioProcedureBoImpl.");
        logger.info("Ingresar al metodo: findDrawByIdByGameId.");
        Draw resultQuery = new Draw();
        try {
            resultQuery = drawDao.findByIdByGameId(drawId, gameID);
            logger.info("Salir del metodo: findDrawByIdByGameId.");
            logger.info("Salir de la clase: GanadiarioProcedureBoImpl.");
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public DrawItem findDrawItemByIdByGameId(Integer drawId, Integer gameID) throws Exception {
        logger.info("Ingresar a la clase: findDrawItemByIdByGameId.");
        logger.info("Ingresar al metodo: findDrawItemByIdByGameId.");
        DrawItem resultQuery = new DrawItem();
        try {
            resultQuery = drawItemDao.findByIdByGameId(drawId, gameID);
            logger.info("Salir del metodo: findDrawItemByIdByGameId.");
            logger.info("Salir de la clase: findDrawItemByIdByGameId.");
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public TicketWinner findTicketWinnerById(Long ticketId) throws Exception {
        logger.info("Ingresar a la clase: GanadiarioProcedureBoImpl.");
        logger.info("Ingresar al metodo: findTicketWinnerById.");
        TicketWinner resultQuery = new TicketWinner();
        try {
            resultQuery = ticketWinnerDao.findById(ticketId);
            logger.info("Salir del metodo: findTicketWinnerById.");
            logger.info("Salir de la clase: GanadiarioProcedureBoImpl.");
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public TicketWinner findTicketWinnerByTicketNumber(String ticketNumber) throws Exception {
        logger.info("Ingresar a la clase: GanadiarioProcedureBoImpl.");
        logger.info("Ingresar al metodo: findTicketWinnerByTicketNumber.");
        TicketWinner resultQuery = new TicketWinner();
        try {
            resultQuery = ticketWinnerDao.findByTicketNumber(ticketNumber);
            logger.info("Salir del metodo: findTicketWinnerByTicketNumber.");
            logger.info("Salir de la clase: GanadiarioProcedureBoImpl.");
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public TicketWinnerLotos5 findTicketWinnerLotos5ById(Long ticketId) throws Exception {
        logger.info("Ingresar a la clase: GanadiarioProcedureBoImpl.");
        logger.info("Ingresar al metodo: findTicketWinnerLotos5ById.");
        TicketWinnerLotos5 resultQuery = new TicketWinnerLotos5();
        try {
            resultQuery = ticketWinnerLotos5Dao.findById(ticketId);
            logger.info("Salir del metodo: findTicketWinnerLotos5ById.");
            logger.info("Salir de la clase: GanadiarioProcedureBoImpl.");
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public TicketWinnerLotos5 findTicketWinnerLotos5ByTicketNumber(String ticketNumber) throws Exception {
        logger.info("Ingresar a la clase: GanadiarioBoImpl.");
        logger.info("Ingresar al metodo: findTicketWinnerLotos5ByTicketNumber.");
        TicketWinnerLotos5 resultQuery = new TicketWinnerLotos5();
        try {
            resultQuery = ticketWinnerLotos5Dao.findByTicketNumber(ticketNumber);
            logger.info("Salir del metodo: findTicketWinnerLotos5ByTicketNumber.");
            logger.info("Salir de la clase: GanadiarioBoImpl.");
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Override
    public JsonArray cotejoJugada(String tipo_jugada, int from, int to, int gameID, int ticketId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void reinicioValoresAciertos() {
        AciertoscotejadorUtil a_c = new AciertoscotejadorUtil();
        a_c.dos_aciertos = 0;
        a_c.tres_aciertos = 0;
        a_c.cuatro_aciertos = 0;
        a_c.cinco_aciertos = 0;
    }

    @Override
	public JsonArray datosJugadaCotejo(String tipo_jugada, int from, int to,int gameID, String jugadaCompl, String plus,String chauChamba) {
		 JsonArray datos_jugada_cotejo = new JsonArray();
		 String [] jugadaCompleta,pluscompleto,chauchambaCompleto;
		 
		 pluscompleto=plus.split("-");
		 jugadaCompleta=jugadaCompl.split("-");
		 chauchambaCompleto=chauChamba.split("-");
		 
		 String jugadaA=jugadaCompleta[0];
		 String jugadaB=jugadaCompleta[1];
		 String jugadaC=jugadaCompleta[2];
		 String jugadaD=jugadaCompleta[3];
		 
		 String plusA=pluscompleto[0].trim();
		 String plusB=pluscompleto[1].trim();
		 String plusC=pluscompleto[2].trim();
		 String plusD=pluscompleto[3].trim();
		 
		 String chauChmbA=chauchambaCompleto[0].trim();
		 String chauChmbB=chauchambaCompleto[1].trim();
		 String chauChmbC=chauchambaCompleto[2].trim();
		 String chauChmbD=chauchambaCompleto[3].trim();
		 
	        try {
	            for (int i = from; i < to; i++) {
	                JsonObject cotejo = new JsonObject();
	                ArrayList jugada_ordenada = new ArrayList();
	                ArrayList jugada_resultado = new ArrayList();
	                
	                
	                Draw draw_array = drawBo.findByIdByGameId(i, gameID);
	                String bet1 = "", bet2 = "", bet3 = "", bet4 = "", resultado = "",resultado_chauChamba = "";
	                resultado = " " + draw_array.getDrResult() + " ";
	                resultado_chauChamba = " " + draw_array.getDrAddonResult2() + " ";
	                
                    bet1 =jugadaA;
                    bet2 =jugadaB;
                    bet3 =jugadaC;
                    bet4 =jugadaD;
	                
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
	                            cotejo.addProperty("resultadoChauchamba", resultado_chauChamba);
	                            
	                            if(bet1.length()>4){
	                            	jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet1);
		                            CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_ordenada, 5);
		                            
		                            	cotejo.addProperty("jugadaA", bet1);
		                          
		                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones, resultado,resultado_chauChamba,plusA,Integer.parseInt(chauChmbA));
		                            cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
	                            }
	                            
	                            
	                            if(bet2.length()>4){
	                            	 jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet2);
			                         CombinacionesUtil combinaciones_b2 = new CombinacionesUtil(jugada_ordenada, 5);    
			                         
		                            	cotejo.addProperty("jugadaB", bet2);
		                            
		                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2, resultado,resultado_chauChamba,plusB,Integer.parseInt(chauChmbB));
		                            cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
	                            }
	                            
	                            if(bet3.length()>4){
	                            	jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet3);
		                            CombinacionesUtil combinaciones_b3 = new CombinacionesUtil(jugada_ordenada, 5);
		                          
		                            	cotejo.addProperty("jugadaC", bet3);
		                            
		                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3, resultado,resultado_chauChamba,plusC,Integer.parseInt(chauChmbC));
		                            cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
	                            }
	                            
	                            if(bet4.length()>4){
	                            	jugada_ordenada = cotejador_alg.ordenar_array_menor_mayor(bet4);
		                            CombinacionesUtil combinaciones_b4 = new CombinacionesUtil(jugada_ordenada, 5);
		                        
		                            	cotejo.addProperty("jugadaD", bet4);
		                            
		                            jugada_resultado = cotejador_alg.cotejo_aciertos_jugada(combinaciones_b4, resultado,resultado_chauChamba,plusD,Integer.parseInt(chauChmbD));
		                            cotejo.add("cotejo_jugada_D", new Gson().toJsonTree(jugada_resultado));
	                            }
	                          
	                datos_jugada_cotejo.add(cotejo);
	            }
	        } catch (Exception e) {
	        	System.out.println("Mensaje_Warning_Ganadiario : " + e.getMessage());
	        } finally {
	        }
	        return datos_jugada_cotejo;
	}

    @Override
	public JsonArray resultado_premios(Integer clientId,Integer gameId,Long ticketId) {
		JsonArray resultado_premio = new JsonArray();
		JsonObject resultados = new JsonObject();
		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		try {
			TicketProcedureGetClientTicket ticketSale = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
			resultados.addProperty("dos", num_a.getDos_aciertos());
			if(num_a.getDos_aciertos()>0){
			resultados.addProperty("acierto_dos", "2 aciertos");
			resultados.addProperty("caduca_dos", ticketSale.getCtFreeExpirationDate());
			if (ticketSale.getTwTwfreeColumns() == 1) {
				resultados.addProperty("premio_total_dos", num_a.getDos_aciertos()+ " jugada Gratis");
			} else {
				resultados.addProperty("premio_total_dos", num_a.getDos_aciertos()+ " jugadas Gratis");
			}
			}
			
			resultados.addProperty("tres", num_a.getTres_aciertos());
			if(num_a.getTres_aciertos()>0){
			resultados.addProperty("acierto_tres", "3 aciertos");
			resultados.addProperty("caduca_tres", ticketSale.getCtPrizeExpirationDate());
			resultados.addProperty("premio_total_tres", "S/."+ (num_a.getTres_aciertos() * 5));
			}
			
			resultados.addProperty("cuatro", num_a.getCuatro_aciertos());
			if(num_a.getCuatro_aciertos()>0){
			resultados.addProperty("acierto_cuatro", "4 aciertos");
			resultados.addProperty("premio_total_cuatro", "S/."+ (num_a.getCuatro_aciertos() * 100));
			resultados.addProperty("caduca_cuatro", ticketSale.getCtPrizeExpirationDate());
			}
			
			resultados.addProperty("cinco", num_a.cinco_aciertos);
			if(num_a.cinco_aciertos>0){
			resultados.addProperty("acierto_cinco", "5 aciertos");
			resultados.addProperty("premio_total_cinco", "S/."+ (num_a.cinco_aciertos * 100000));
			resultados.addProperty("caduca_cinco", ticketSale.getCtPrizeExpirationDate());
			}
			
			NumberFormat formatter = new DecimalFormat("#0.00");
			if(String.valueOf(ticketSale.getCtTwPrizeAmount())==null || ticketSale.getCtTwPrizeAmount().equals(" ")){
			 resultados.addProperty("totalPremio","0.0");	
			 }else{
			 resultados.addProperty("totalPremio",formatter.format(ticketSale.getCtTwPrizeAmount()));
			 }
			
			resultado_premio.add(resultados);
		} catch (Exception e) {
			System.out.println("Mensaje_Warnin_Ganadiario: " + e.getMessage());
		} finally {

		}

		return resultado_premio;
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
	public ArrayList<Integer> valoresBoleto() throws Exception {
		ArrayList<Integer> valoresBol= new ArrayList<Integer>();
		valoresBol.add(1);
		valoresBol.add(2);
		valoresBol.add(3);
		valoresBol.add(4);
		valoresBol.add(5);
		valoresBol.add(6);
		valoresBol.add(7);
		valoresBol.add(8);
		valoresBol.add(9);
		valoresBol.add(10);
		valoresBol.add(12);
		valoresBol.add(15);
		valoresBol.add(30);
		return valoresBol;
	}

    @Override
	public JsonArray datosJugada(String tipo_jugada, int from, int to,int gameID, Long ticketId) {
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
				if (ticket.getCtBetMatrix1() != null) {
					bet1 = " " + ticket.getCtBetMatrix1() + " ";
				}
				if (ticket.getCtBetMatrix2() != null) {
					bet2 = " " + ticket.getCtBetMatrix2() + " ";
				}
				if (ticket.getCtBetMatrix3() != null) {
					bet3 = " " + ticket.getCtBetMatrix3() + " ";
				}
				if (ticket.getCtBetMatrix4() != null) {
					bet4 = " " + ticket.getCtBetMatrix4() + " ";
				}
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
					if (ticket.getCtBetMatrix1() != null) {
						if (bet1.length() > 5) {
							cotejo.addProperty("sorteo", drawId);
							cotejo.addProperty("fecha", fechas);
							cotejo.addProperty("resultado", resultado);
							cotejo.addProperty("jugadaA", bet1);
							
							CotejadorUtil cotejador_alg=new CotejadorUtil();
							jugada_ordenada=cotejador_alg.ordenar_array_menor_mayor(bet1);
							
							CombinacionesUtil combinaciones= new CombinacionesUtil(jugada_ordenada, 5) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones,resultado);
							cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
						}
					}
				} else if (tipo_jugada.equals("B")) {
					if (ticket.getCtBetMatrix2() != null) {
						jugada = " " + ticket.getCtBetMatrix2() + " ";
						if (bet2.length() > 5) {
							cotejo.addProperty("sorteo", drawId);
							cotejo.addProperty("fecha", fechas);
							cotejo.addProperty("resultado", resultado);
							cotejo.addProperty("jugadaA", bet1);
							CotejadorUtil cotejador_alg=new CotejadorUtil();
							jugada_ordenada=cotejador_alg.ordenar_array_menor_mayor(bet1);
							
							CombinacionesUtil combinaciones= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones,resultado);
							cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
							
							cotejo.addProperty("jugadaB", bet2);
							CotejadorUtil cotejador_alg_b2=new CotejadorUtil();
							jugada_ordenada=cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
							
							CombinacionesUtil combinaciones_b2= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2,resultado);
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
							CotejadorUtil cotejador_alg=new CotejadorUtil();
							jugada_ordenada=cotejador_alg.ordenar_array_menor_mayor(bet1);
							CombinacionesUtil combinaciones= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones,resultado);
							cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
							
							cotejo.addProperty("jugadaB", bet2);
							CotejadorUtil cotejador_alg_b2=new CotejadorUtil();
							jugada_ordenada=cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
							CombinacionesUtil combinaciones_b2= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2,resultado);
							cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
							
							cotejo.addProperty("jugadaC", bet3);
							CotejadorUtil cotejador_alg_b3=new CotejadorUtil();
							jugada_ordenada=cotejador_alg_b3.ordenar_array_menor_mayor(bet3);
							CombinacionesUtil combinaciones_b3= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3,resultado);
							cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
						}
					}
				} else if (tipo_jugada.equals("D")) {
					if (ticket.getCtBetMatrix2() != null) {
						jugada = " " + ticket.getCtBetMatrix2() + " ";
						if (jugada.length() > 5) {
							cotejo.addProperty("sorteo", drawId);
							cotejo.addProperty("fecha", fechas);
							cotejo.addProperty("resultado", resultado);
							cotejo.addProperty("jugadaA", bet1);
							CotejadorUtil cotejador_alg=new CotejadorUtil();
							jugada_ordenada=cotejador_alg.ordenar_array_menor_mayor(bet1);
							CombinacionesUtil combinaciones= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones,resultado);
							cotejo.add("cotejo_jugada_A", new Gson().toJsonTree(jugada_resultado));
							
							cotejo.addProperty("jugadaB", bet2);
							CotejadorUtil cotejador_alg_b2=new CotejadorUtil();
							jugada_ordenada=cotejador_alg_b2.ordenar_array_menor_mayor(bet2);
							CombinacionesUtil combinaciones_b2= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones_b2,resultado);
							cotejo.add("cotejo_jugada_B", new Gson().toJsonTree(jugada_resultado));
							
							cotejo.addProperty("jugadaC", bet3);
							CotejadorUtil cotejador_alg_b3=new CotejadorUtil();
							jugada_ordenada=cotejador_alg_b3.ordenar_array_menor_mayor(bet3);
							CombinacionesUtil combinaciones_b3= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones_b3,resultado);
							cotejo.add("cotejo_jugada_C", new Gson().toJsonTree(jugada_resultado));
														
							cotejo.addProperty("jugadaD", bet4);
							CotejadorUtil cotejador_alg_b4=new CotejadorUtil();
							jugada_ordenada=cotejador_alg_b4.ordenar_array_menor_mayor(bet4);
							CombinacionesUtil combinaciones_b4= new CombinacionesUtil(jugada_ordenada, 6) ;
							jugada_resultado=cotejador_alg.cotejo_aciertos_jugada(combinaciones_b4,resultado);
							cotejo.add("cotejo_jugada_D", new Gson().toJsonTree(jugada_resultado));
						}
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
	public boolean isSubscriptionAllowedGoIn(String user) {
		 boolean isGanadiarioSubscription = Boolean.valueOf(ConnectionFactory.operationProperty("ganadiarioSubscriptionEnabled", Constants.contextSale).trim()).booleanValue();
	        boolean isAllowed = false;
	        String ganadiarioSubscriptionUsers = String.valueOf(ConnectionFactory.operationProperty("ganadiarioSubscriptionUsers", Constants.contextSale)).toString().trim();
	        if (isGanadiarioSubscription == false) {
	            if (ganadiarioSubscriptionUsers != null && !ganadiarioSubscriptionUsers.equals("")) {
	                String[] subscriptionUsers = ganadiarioSubscriptionUsers.split(",");
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
	public String[] findGanadiarioNextDraw() throws Exception {
		String[] resultQuery = null;
        try {
            resultQuery = ganadiarioSaleDao.findGanadiarioNextDraw();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("size= " + resultQuery.length);
        }
        return resultQuery;
	}
	
	public boolean isPopup3x5solesActive() {
    	boolean active = false;
    	try {
    		Calendar calendarHoy = Calendar.getInstance();
    		Calendar startPopup = Calendar.getInstance();
			Calendar endPopup = Calendar.getInstance();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    		String strStartPopup = String.valueOf(ConnectionFactory.operationProperty("startPopupGD3x5", Constants.contextSale)).toString().trim();
        	String strEndPopup = String.valueOf(ConnectionFactory.operationProperty("endPopupGD3x5", Constants.contextSale)).toString().trim();
        	startPopup.setTime(formato.parse(strStartPopup));
        	endPopup.setTime(formato.parse(strEndPopup));
			if(calendarHoy.after(startPopup) && calendarHoy.before(endPopup) )
				active = true;
    	}catch (Exception e) {
        	LoggerApi.severe(e); 
        }
    	
    	return active;
    }

}
