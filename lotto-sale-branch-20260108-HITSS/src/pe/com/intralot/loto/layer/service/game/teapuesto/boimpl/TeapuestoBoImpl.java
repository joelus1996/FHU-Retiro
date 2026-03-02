package pe.com.intralot.loto.layer.service.game.teapuesto.boimpl;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialData;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.TeapuestocotejadorUtil;
import pe.com.intralot.loto.util.CombinacionesUtil;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialGroup;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialHeader;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialMenu;
import pe.com.intralot.loto.layer.model.persistence.dao.TeapuestoSaleDao;
import pe.com.intralot.loto.layer.service.game.teapuesto.bo.TeapuestoBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class TeapuestoBoImpl implements TeapuestoBo {

    @Autowired
    private TeapuestoSaleDao teapuestoSaleDao;
    @Autowired
	private TicketSaleBo TicketBo;
    
    @Override
    public JsonObject createBetData(Integer idClient) throws Exception {
        TeapuestoProcedureBetData teapuestoProcedureBetData = findByClientId(idClient);
        JsonObject joBetData = new JsonObject();
        joBetData.addProperty("status", teapuestoProcedureBetData.getStatus());
        joBetData.addProperty("message", teapuestoProcedureBetData.getMessage());
        joBetData.addProperty("priceType", teapuestoProcedureBetData.getPriceType());
        joBetData.addProperty("priceMessage", teapuestoProcedureBetData.getPriceMessage());
        joBetData.addProperty("simpleBetPrice", teapuestoProcedureBetData.getSimpleBetPrice());
        joBetData.addProperty("promotionType", teapuestoProcedureBetData.getPromotionType());
        joBetData.addProperty("balanceAmount", teapuestoProcedureBetData.getBalanceAmount());
        joBetData.addProperty("balanceAmountGame", teapuestoProcedureBetData.getBalanceAmountGame());
        joBetData.addProperty("algorithm", teapuestoProcedureBetData.getAlgorithm());
        joBetData.addProperty("bets", teapuestoProcedureBetData.getBets());
        joBetData.addProperty("pay", teapuestoProcedureBetData.getPay());
        joBetData.addProperty("draws", teapuestoProcedureBetData.getDraws());
        joBetData.addProperty("cost", teapuestoProcedureBetData.getCost());
        joBetData.addProperty("channel1Order", teapuestoProcedureBetData.getChannel1Order());
        joBetData.addProperty("channel2Order", teapuestoProcedureBetData.getChannel2Order());
        return joBetData;
    }

    @Override
    public JsonArray createDrawList(int id) throws Exception {
        List<TeapuestoProcedureDrawData> teapuestoProcedureDrawData = findListDrawData(id);
        JsonArray jaDrawList = new JsonArray();
        for (TeapuestoProcedureDrawData teapuestoSale : teapuestoProcedureDrawData) {
            JsonObject joEvent = new JsonObject();
            joEvent.addProperty("hour", teapuestoSale.getHour());
            joEvent.addProperty("eventId", teapuestoSale.getEventId());
            joEvent.addProperty("leagueId", teapuestoSale.getLeagueId());
            joEvent.addProperty("minimun", teapuestoSale.getMinimum());
            joEvent.addProperty("teams", teapuestoSale.getTeams());
            joEvent.addProperty("exactGoal", teapuestoSale.getExactGoal());
            joEvent.addProperty("local", teapuestoSale.getLocal());
            joEvent.addProperty("equal", teapuestoSale.getEqual());
            joEvent.addProperty("visitor", teapuestoSale.getVisitor());
            joEvent.addProperty("localEqual", teapuestoSale.getLocalEqual());
            joEvent.addProperty("localVisitor", teapuestoSale.getLocalVisitor());
            joEvent.addProperty("equalVisitor", teapuestoSale.getEqualVisitor());
            joEvent.addProperty("t1tLocal", teapuestoSale.getT1tLocal());
            joEvent.addProperty("t1tEqual", teapuestoSale.getT1tEqual());
            joEvent.addProperty("t1tVisitor", teapuestoSale.getT1tVisitor());
            joEvent.addProperty("t1tLocal2tLocal", teapuestoSale.getT1tLocal2tLocal());
            joEvent.addProperty("t1tEqual2tLocal", teapuestoSale.getT1tEqual2tLocal());
            joEvent.addProperty("t1tVisitor2tLocal", teapuestoSale.getT1tVisitor2tLocal());
            joEvent.addProperty("t1tLocal2tEqual", teapuestoSale.getT1tLocal2tEqual());
            joEvent.addProperty("t1tEqual2tEqual", teapuestoSale.getT1tEqual2tEqual());
            joEvent.addProperty("t1tVisitor2tEqual", teapuestoSale.getT1tVisitor2tEqual());
            joEvent.addProperty("t1tLocal2tVisitor", teapuestoSale.getT1tLocal2tVisitor());
            joEvent.addProperty("t1tEqual2tVisitor", teapuestoSale.getT1tEqual2tVisitor());
            joEvent.addProperty("t1tVisitor2tVisitor", teapuestoSale.getT1tVisitor2tVisitor());
            joEvent.addProperty("goalLower2", teapuestoSale.getGoalLower2());
            joEvent.addProperty("goalOver3", teapuestoSale.getGoalOver3());
            joEvent.addProperty("goal_0_1", teapuestoSale.getGoal_0_1());
            joEvent.addProperty("goal_2_3", teapuestoSale.getGoal_2_3());
            joEvent.addProperty("goal4More", teapuestoSale.getGoal4More());
            jaDrawList.add(joEvent);
        }
        return jaDrawList;
    }

    @Override
    public JsonObject createExactData(Integer p_drawId, Integer p_eventId) throws Exception {
        TeapuestoProcedureExactData teapuestoSale = findtExactData(p_drawId, p_eventId);
        JsonObject joScore = new JsonObject();
        joScore.addProperty("eventId", teapuestoSale.getEventId());
        joScore.addProperty("date", teapuestoSale.getDate());
        joScore.addProperty("hour", teapuestoSale.getHour());
        joScore.addProperty("local", teapuestoSale.getLocal());
        joScore.addProperty("imageLocal", teapuestoSale.getImageLocal());
        joScore.addProperty("visitor", teapuestoSale.getVisitor());
        joScore.addProperty("imageVisitor", teapuestoSale.getImageVisitor());
        joScore.addProperty("s00", teapuestoSale.getS00());
        joScore.addProperty("s10", teapuestoSale.getS10());
        joScore.addProperty("s20", teapuestoSale.getS20());
        joScore.addProperty("s30", teapuestoSale.getS30());
        joScore.addProperty("s40", teapuestoSale.getS40());
        joScore.addProperty("s5More0", teapuestoSale.getS5More0());
        joScore.addProperty("s21", teapuestoSale.getS21());
        joScore.addProperty("s31", teapuestoSale.getS31());
        joScore.addProperty("s41", teapuestoSale.getS41());
        joScore.addProperty("s5More1", teapuestoSale.getS5More1());
        joScore.addProperty("s32", teapuestoSale.getS32());
        joScore.addProperty("s42", teapuestoSale.getS42());
        joScore.addProperty("s5More2", teapuestoSale.getS5More2());
        joScore.addProperty("s43", teapuestoSale.getS43());
        joScore.addProperty("s5More3", teapuestoSale.getS5More3());
        joScore.addProperty("s5More4", teapuestoSale.getS5More4());
        joScore.addProperty("s11", teapuestoSale.getS11());
        joScore.addProperty("s22", teapuestoSale.getS22());
        joScore.addProperty("s33", teapuestoSale.getS33());
        joScore.addProperty("s44", teapuestoSale.getS44());
        joScore.addProperty("s5More5", teapuestoSale.getS5More5More());
        joScore.addProperty("s45More", teapuestoSale.getS45More());
        joScore.addProperty("s34", teapuestoSale.getS34());
        joScore.addProperty("s35More", teapuestoSale.getS35More());
        joScore.addProperty("s23", teapuestoSale.getS23());
        joScore.addProperty("s24", teapuestoSale.getS24());
        joScore.addProperty("s25More", teapuestoSale.getS25More());
        joScore.addProperty("s12", teapuestoSale.getS12());
        joScore.addProperty("s13", teapuestoSale.getS13());
        joScore.addProperty("s14", teapuestoSale.getS14());
        joScore.addProperty("s15More", teapuestoSale.getS15More());
        joScore.addProperty("s01", teapuestoSale.getS01());
        joScore.addProperty("s02", teapuestoSale.getS02());
        joScore.addProperty("s03", teapuestoSale.getS03());
        joScore.addProperty("s04", teapuestoSale.getS04());
        joScore.addProperty("s05More", teapuestoSale.getS05More());
        return joScore;
    }

    @Override
    public JsonArray createSpecialData(String header) throws Exception {
        List<TeapuestoProcedureSpecialMenu> teapuestoProcedureSpecialMenu = findListSpecialMenu(header);
        JsonArray jaData = new JsonArray();
        for (TeapuestoProcedureSpecialMenu specialMenu : teapuestoProcedureSpecialMenu) {
            JsonArray jaGroup = new JsonArray();
            List<TeapuestoProcedureSpecialGroup> teapuestoProcedureSpecialGroup = findListSpecialGroup(header, specialMenu.getTadrawId());
            for (TeapuestoProcedureSpecialGroup specialGroup : teapuestoProcedureSpecialGroup) {
                JsonArray jaLists = new JsonArray();
                List<TeapuestoProcedureSpecialData> teapuestoProcedureSpecialData = findListSpecialData(header, specialMenu.getTadrawId(), specialGroup.getLeagueId());
                for (TeapuestoProcedureSpecialData specialData : teapuestoProcedureSpecialData) {
                    JsonObject joElement = new JsonObject();
                    joElement.addProperty("itemId", specialData.getItemId());
                    joElement.addProperty("groupCode", specialData.getGroupCode());
                    joElement.addProperty("groupTitle", specialData.getGroupTitle());
                    joElement.addProperty("itemCode", specialData.getItemCode());
                    joElement.addProperty("itemDate", specialData.getItemDate());
                    joElement.addProperty("itemDescription", specialData.getItemDescription());
                    joElement.addProperty("itemHour", specialData.getItemHour());
                    joElement.addProperty("itemImage", specialData.getItemImage());
                    joElement.addProperty("odds", specialData.getOdds());
                    jaLists.add(joElement);
                }
                JsonObject joList = new JsonObject();
                joList.addProperty("leagueId", specialGroup.getLeagueId());
                joList.addProperty("groupTitle", specialGroup.getGroupTitle());
                joList.addProperty("subHeader", specialGroup.getSubHeader());
                joList.addProperty("groupImage", specialGroup.getGroupImage());
                joList.add("lists", jaLists);
                jaGroup.add(joList);
            }
            JsonObject joData = new JsonObject();
            joData.addProperty("tadrawId", specialMenu.getTadrawId());
            joData.addProperty("menu", specialMenu.getMenu());
            joData.add("groupList", jaGroup);
            jaData.add(joData);
        }
        return jaData;
    }

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isTeapuestoSale = Boolean.valueOf(ConnectionFactory.operationProperty("teapuestoSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String teapuestoSaleUsers = String.valueOf(ConnectionFactory.operationProperty("teapuestoSaleUsers", Constants.contextSale)).toString().trim();
        if (isTeapuestoSale == false) {
            if (teapuestoSaleUsers != null && !teapuestoSaleUsers.equals("")) {
                String[] saleUsers = teapuestoSaleUsers.split(",");
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
    public TeapuestoProcedureBetData findByClientId(Integer p_clientId) throws Exception {
    	//LoggerApi.Log.info("clientId=" + p_clientId);
        TeapuestoProcedureBetData objectDomain = new TeapuestoProcedureBetData();
        try {
            objectDomain = teapuestoSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            // LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_draw_1=" + objectDomain.getDraw1() + " w_draw_2="
                        + objectDomain.getDraw2() + " w_draw_3=" + objectDomain.getDraw3() + " w_draw_4=" + objectDomain.getDraw4() + " w_draw_5=" + objectDomain.getDraw5()
                        + " w_draw_6=" + objectDomain.getDraw6() + " w_draw_7=" + objectDomain.getDraw7() + " w_date_1=" + objectDomain.getDate1() + " w_date_2="
                        + objectDomain.getDate2() + " w_date_3=" + objectDomain.getDate3() + " w_date_4=" + objectDomain.getDate4() + " w_date_5=" + objectDomain.getDate5()
                        + " w_date_6=" + objectDomain.getDate6() + " w_date_7=" + objectDomain.getDate7() + " w_price_type=" + objectDomain.getPriceType()
                        + " w_price_message=" + objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice() + " w_promotion_type="
                        + objectDomain.getPromotionType() + " w_balance_amount=" + objectDomain.getBalanceAmount() + " w_balance_amount_game="
                        + objectDomain.getBalanceAmountGame() + " w_algorithm=" + objectDomain.getAlgorithm() + " w_bets=" + objectDomain.getBets() + " w_pay="
                        + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost());
            */
        }
        return objectDomain;
    }

    @Override
    public List<TeapuestoProcedureDrawData> findListDrawData(Integer p_drawId) throws Exception {
    	//LoggerApi.Log.info("drawId=" + p_drawId);
        List<TeapuestoProcedureDrawData> resultQueryList = new ArrayList<TeapuestoProcedureDrawData>();
        try {
            resultQueryList = teapuestoSaleDao.findListDrawData(p_drawId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureDrawMenu> findListDrawMenu() throws Exception {
        List<TeapuestoProcedureDrawMenu> resultQueryList = new ArrayList<TeapuestoProcedureDrawMenu>();
        try {
            resultQueryList = teapuestoSaleDao.findListDrawMenu();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureExactMenu> findListExactMenu() throws Exception {
        List<TeapuestoProcedureExactMenu> resultQueryList = new ArrayList<TeapuestoProcedureExactMenu>();
        try {
            resultQueryList = teapuestoSaleDao.findListExactMenu();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureSpecialData> findListSpecialData(String p_header, String p_tadrawId, Integer p_leagueId) throws Exception {
    	//LoggerApi.Log.info("header=" + p_header + " leagueId=" + p_leagueId);
        List<TeapuestoProcedureSpecialData> resultQueryList = new ArrayList<TeapuestoProcedureSpecialData>();
        try {
            resultQueryList = teapuestoSaleDao.findListSpecialData(p_header, p_tadrawId, p_leagueId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureSpecialMenu> findListSpecialMenu(String p_header) throws Exception {
    	//LoggerApi.Log.info("header=" + p_header);
        List<TeapuestoProcedureSpecialMenu> resultQueryList = new ArrayList<TeapuestoProcedureSpecialMenu>();
        try {
            resultQueryList = teapuestoSaleDao.findListSpecialMenu(p_header);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public List<TeapuestoProcedureSpecialHeader> findSpecialHeader() throws Exception {
        List<TeapuestoProcedureSpecialHeader> resultQueryList = new ArrayList<TeapuestoProcedureSpecialHeader>();
        try {
            resultQueryList = teapuestoSaleDao.findSpecialHeader();
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
    public TeapuestoProcedureExactData findtExactData(Integer p_drawId, Integer p_eventId) throws Exception {
    	//LoggerApi.Log.info("drawId=" + p_drawId + " eventId" + p_eventId);
        TeapuestoProcedureExactData objectDomain = new TeapuestoProcedureExactData();
        try {
            objectDomain = teapuestoSaleDao.findtExactData(p_drawId, p_eventId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("w_event_id=" + objectDomain.getEventId() + " w_date=" + objectDomain.getDate() + " w_hour=" + objectDomain.getHour() + " w_local="
                        + objectDomain.getLocal() + " w_image_local=" + objectDomain.getImageLocal() + " w_visitor=" + objectDomain.getVisitor() + " w_image_visitor="
                        + objectDomain.getImageVisitor() + " w_s_0_0= " + objectDomain.getS00() + " w_s_1_0=" + objectDomain.getS10() + " w_s_2_0=" + objectDomain.getS20()
                        + " w_s_3_0=" + objectDomain.getS30() + " w_s_4_0=" + objectDomain.getS40() + " w_s_5_more_0=" + objectDomain.getS5More0() + " w_s_2_1="
                        + objectDomain.getS21() + " w_s_3_1=" + objectDomain.getS31() + " w_s_4_1=" + objectDomain.getS41() + " w_s_5_more_1=" + objectDomain.getS5More1()
                        + " w_s_3_2=" + objectDomain.getS32() + " w_s_4_2=" + objectDomain.getS42() + " w_s_5_more_2=" + objectDomain.getS5More2() + " w_s_4_3="
                        + objectDomain.getS43() + " w_s_5_more_3=" + objectDomain.getS5More3() + " w_s_5_more_4=" + objectDomain.getS5More4() + " w_s_1_1="
                        + objectDomain.getS11() + " w_s_2_2=" + objectDomain.getS22() + " w_s_3_3=" + objectDomain.getS33() + " w_s_4_5=" + objectDomain.getS44()
                        + " w_s_5_more_5_more=" + objectDomain.getS5More5More() + " w_s_4_5_more=" + objectDomain.getS45More() + " w_s_3_4=" + objectDomain.getS34()
                        + " w_s_3_5_more=" + objectDomain.getS35More() + " w_s_2_3=" + objectDomain.getS23() + " w_s_2_4=" + objectDomain.getS24() + " w_s_2_5_more="
                        + objectDomain.getS25More() + " w_s_1_2=" + objectDomain.getS12() + " w_s_1_3=" + objectDomain.getS13() + " w_s_1_4= " + objectDomain.getS14()
                        + " w_s_1_5_more=" + objectDomain.getS15More() + " w_s_0_1=" + objectDomain.getS01() + " w_s_0_2=" + objectDomain.getS02() + " w_s_0_3="
                        + objectDomain.getS03() + " w_s_0_4=" + objectDomain.getS04() + "w_s_0_5_more=" + objectDomain.getS05More());
             */
        }
        return objectDomain;
    }

    @Override
    public List<TeapuestoProcedureSpecialGroup> findListSpecialGroup(String p_header, String p_tadrawId) throws Exception {
        List<TeapuestoProcedureSpecialGroup> resultQueryList = new ArrayList<TeapuestoProcedureSpecialGroup>();
        try {
            resultQueryList = teapuestoSaleDao.findListSpecialGroup(p_header, p_tadrawId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	//if (resultQueryList != null)
        	//    LoggerApi.Log.info("size=" + resultQueryList.size());
        }
        return resultQueryList;
    }

    @Override
	public JsonArray datosCotejador(int clientId, int gameId, Long ticketId)
			throws Exception {

		ArrayList jugada_teapuesto = new ArrayList();
		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		int indicador = 0;
		String cadena = "";
		
		JsonArray datos_cotejo_tabla = new JsonArray();

		try {
			
			TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientId, gameId, ticketId);
			cadena = ticket_client.getCtEventItems();
			TeapuestocotejadorUtil tc = new TeapuestocotejadorUtil();
			jugada_teapuesto = tc.Resultado_Jugada(cadena);

			ArrayList jugada_combinatoria = new ArrayList();
			String[] jugada, pr;
			Double apuesta_cantidad = 1.0, factor_ = 0.0;
			ArrayList juego = new ArrayList();
			
			jugada = cadena.split("____");

			for (int i = 0; i < jugada.length; i++) {
				juego.add(jugada[i]);
			}
			num_a.num_partido_teApuesto=juego.size();
			for (int j = 0; j < juego.size(); j++) {
				pr = juego.get(j).toString().split("__");
				jugada_combinatoria.add(pr[0].toString());
			}

			String tipo_combi = ticket_client.getCtCombined();
			String[] tipo_comb;
			tipo_comb = tipo_combi.split(" ");

			for (int r = 0; r < tipo_comb.length; r++) {
				CombinacionesUtil combinaciones = new CombinacionesUtil(jugada_combinatoria, Integer.parseInt(tipo_comb[r]));
				int aciertos=0;
				Iterator s = combinaciones.iterator();
				ArrayList cadena_combinatoria = new ArrayList();
				while (s.hasNext()) {

					List<String> listares = (List<String>) s.next();
					cadena_combinatoria.add(listares);
				}

				String[] ticket;
				String cadena_recorrido = "";
				// jugada_resultado =
				// cotejo.cotejo_aciertos_jugada(combinaciones, resultado);

				for (int i = 0; i < cadena_combinatoria.size(); i++) {
					ArrayList resultado_jugada = new ArrayList();
					cadena_recorrido = ((cadena_combinatoria.get(i)).toString()).replace("[", "");
					cadena_recorrido = cadena_recorrido.replace("]", "").replace(",", "");

					ticket = cadena_recorrido.split(" ");
					for (int p = 0; p < ticket.length; p++) {
						
						for (int j = 0; j < juego.size(); j++) {
							Map cotejo = new HashMap();
							
							pr = juego.get(j).toString().split("__");
							String acierto = "";
							
							
							
							if (ticket[p].equals(pr[0])) {

								if (pr[12].equals("1")) {
									acierto = "<b>ACERTO</b>";
								}
								
								if(pr[6].equals(pr[11])){
								aciertos++;
								num_a.acierto_teApuesto++;
								}
								cotejo.put("ticket", pr[0]);
								cotejo.put("partido", pr[1]);
								cotejo.put("apuesta", pr[6]);
								cotejo.put("factor", pr[8]);
								cotejo.put("acerto", acierto);
								cotejo.put("resultado", pr[11]);
								resultado_jugada.add(cotejo);
								if (p == (ticket.length) - 1) {
									JsonObject datos_tabla = new JsonObject();
									datos_tabla.addProperty("combinada", tipo_comb[r]);
									if(aciertos==ticket.length-1){
									datos_tabla.addProperty("acierto", "Jugada Ganadora");
									}else{
									datos_tabla.addProperty("acierto", "No acert�");
									}
									datos_tabla.add("acierto_jugada",new Gson().toJsonTree(resultado_jugada));
									datos_cotejo_tabla.add(datos_tabla);
									
								}
							}
						}
					}

				}

			}

			if (jugada_teapuesto.size() > 0) {
				indicador = 1;
			}

			
		} catch (Exception ex) {
			System.out.println("WARNING TE APUESTO : " + ex.getMessage());
		}
		return datos_cotejo_tabla;
	}

	@Override
	public JsonArray resultado_premios(Integer clientId, Integer gameId,Long ticketId) {
		
		 double premio_t=0.0,multiplicador=0.0;
		 AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
		 JsonArray premio_total = new JsonArray();
		 JsonObject premio= new JsonObject();
		try { 
			 TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientId, gameId, ticketId);
			 
			 String tipo_combi = "";
			 if(ticket_client.getCtCombined()==null ||ticket_client.getCtCombined().equals(" ")){
			 tipo_combi="-";
			 }else{
			 tipo_combi=ticket_client.getCtCombined();
			 }
			 
			 NumberFormat formatter = new DecimalFormat("#0.00");
			 
			 if(ticket_client.getCtTwPrizeAmount()==null || ticket_client.getCtTwPrizeAmount().equals(" ")){
			 premio_t=0.0;
			 }else{
			 premio_t=ticket_client.getCtTwPrizeAmount();
			 }
			 multiplicador=ticket_client.getCtBetMultiA();
			 if(multiplicador==0.0){
				 multiplicador=1.0;
			 }
			 premio.addProperty("premio",premio_t);
			 premio.addProperty("multiplicador",multiplicador);
			 premio.addProperty("probabilidades_ganadas",(premio_t/multiplicador));
			 premio.addProperty("tipo_combinaciones",tipo_combi);
			 premio.addProperty("numero_jugada",num_a.num_partido_teApuesto);
			 premio.addProperty("aciertos",num_a.acierto_teApuesto);
			 premio_total.add(premio);
			
		}catch(Exception e){
			System.out.println("Warning_Te_APUESTO: "+e.getMessage());
		}
		
		return premio_total;
	}
}