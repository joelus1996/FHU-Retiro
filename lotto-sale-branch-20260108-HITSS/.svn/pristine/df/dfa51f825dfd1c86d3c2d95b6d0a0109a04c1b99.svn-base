package pe.com.intralot.loto.layer.controller.game.awardAllPlays;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.api.model.CouponAPI;
import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataChCh;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.game.ganadiario.bo.GanadiarioBo;
import pe.com.intralot.loto.layer.service.game.kabala.bo.KabalaBo;
import pe.com.intralot.loto.layer.service.game.tinka.bo.TinkaBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.Coupon;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.model.Group;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicket;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.card.model.WEBTicketPrePay;
import pe.com.intralot.loto.sale.card.service.ClientTicketService;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class AwardController {

    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private TinkaBo tinkaBo;
    @Autowired
    private GanadiarioBo ganadiarioBo;
    @Autowired
    private KabalaBo kabalaBo;

    @RequestMapping("/premios_juegos")
    public void awardPlay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String resultClient = "";
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        try {
            PrintWriter out = null;
            out = response.getWriter();
            int gameId = Integer.parseInt(request.getParameter("idGame").toString());
            String ticketId = request.getParameter("parameterId");
            LoggerApi.Log.info("gameId=" + gameId + " tid=" + ticketId);
            WEBTicketPrePay web = new WEBTicketPrePay();
            if (gameId == Game.TINKA || gameId == Game.KABALA || gameId == Game.GANADIARIO) {
                LoggerApi.Log.info("gameId=" + gameId + " tid=" + ticketId + " GameSaleDispatcher.prepayTicketWinnerByWebTransactionNewLotos5");
                web = GameSaleDispatcher.prepayTicketWinnerByWebTransactionNewLotos5(gameId, ticketId);
                //System.out.println("WEBTicketPrePay=" + web);
                if (web != null && web.getMessage() != null && web.getMessage().equals("OK")) {
                	resultClient = web.getMessage();
                    resultClient += ";" + df.format(web.getPrizeAmount()) + ";" + df.format(web.getTotalOption2x1Amount()) + ";" + web.getFree() + ";" + web.getOption2x1() + ";" + df.format(web.getFreeAmount()) + ";";
                    if(web.getFreeAmount()==0.0 && web.getFreeCoupon()!=null && web.getFreeCoupon().length>0) {
	                    CouponAPI[] freeCoupon = web.getFreeCoupon();
	                    for (int i = 0; i < freeCoupon.length; i++) {
	                        resultClient += i + 1 + "|" + (freeCoupon[i].getPrizeType() == Coupon.PLAY_DOS_POR_UNO ? "(2x1)" : " ") + "|" + freeCoupon[i].getFreeTicketGroups()
	                                + "|" + (freeCoupon[i].getSaleType() == Coupon.PLAY_FREE_TICKET ? "Gratis" : "Precio Regular") + "|" + freeCoupon[i].getFreeTicketDraws()
	                                + "|" + (freeCoupon[i].getAmount() > 0 ? "S/." + df.format(freeCoupon[i].getAmount()) : "-");
	                        if (i < freeCoupon.length - 1)
	                            resultClient += "||";
	                    }
                    } else resultClient += " ";
                    //session.setAttribute("webTPP", web);
                    //out.print(resultClient);
                    //return;
                } else {
                    LoggerApi.Log.info("No se pudo verificar: message=" + (web != null && web.getMessage() != null ? web.getMessage() : "Error de conexión") + " gameId="
                            + gameId + " ticketId=" + ticketId);
                    if (web != null && web.getMessage() != null){
                    	if(web.getMessage().toUpperCase().equals(web.getMessage())) {
	                    	String[] arrS = (web.getMessage()).split("\\. ");
	                    	resultClient = "";
	                        for(int i=0; i<arrS.length; i++) resultClient += arrS[i].substring(0,1)+arrS[i].substring(1).toLowerCase()+". ";//wtp.getMessage().charAt(0) + wtp.getMessage().substring(1).toLowerCase();
	                    } else resultClient = web.getMessage();
                    } else resultClient = "No se pudo verificar.";
                }
            } else {
                LoggerApi.Log.info("Juego no encontrado gameId=" + gameId + " ticketId=" + ticketId);
                resultClient = "Juego no encontrado";
            }
            session.setAttribute("webTPP", web);
            LoggerApi.Log.info(resultClient);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            //request.setAttribute(Constants.ALERT_MSG, message);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/verifica_premio")
    public String verifyAwardPlay(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        //String outData = "";
        JsonArray jaEvents = new JsonArray();
        JsonObject joAward = new JsonObject();
        //System.out.println("DESIST=" + request.getParameter("d"));
        String direct = "";
        boolean flagPlus = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaPlusEnabled", Constants.contextCardWeb).trim()).booleanValue();
    	boolean flagChauChamba = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", Constants.contextCardWeb).trim()).booleanValue();
    	UserBean userBean = new UserBean();
    	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
    	
    	try {
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
                idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                // LoggerApi.Log.info("idSession="+idSession+" idClient="+idClient);
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
            }
            if((WEBTicketPrePay)session.getAttribute("webTPP") != null) {
	            WEBTicketPrePay web = (WEBTicketPrePay) session.getAttribute("webTPP");
	            int gameId = Integer.parseInt(request.getParameter("g"));
	            String desist = request.getParameter("d").toString();
	            int cash = Integer.parseInt(request.getParameter("c"));
	            if (gameId == Game.TINKA) {
	            	userBean.setpGame(Game.TINKA);
	                List<TinkaProcedureDrawData> tinkaSaleList = tinkaBo.findListDraw();
	                modelList.put("tinkaSaleList", tinkaSaleList);
	                TinkaProcedureBetData tinkaSaleBean = tinkaBo.findByClientId(idClient);
	                tinkaSaleBean.setCloseDate(tinkaBo.DateFormat(tinkaSaleBean.getCloseDate()));
	                if(tinkaSaleBean.getPriceMessage().trim().length()>6) {
	                	tinkaSaleBean.setPromotionMessage(tinkaSaleBean.getPriceMessage());
	                	tinkaSaleBean.setPriceMessage("");
	                } else {
	                	tinkaSaleBean.setPromotionMessage("Costo por jugada: ");
	                }
	                request.setAttribute("tinkaSale", tinkaSaleBean);
	                direct = "game/tinka/award_tinka_user";
	            } else if (gameId == Game.GANADIARIO) {
	            	userBean.setpGame(Game.GANADIARIO);
	                List<GanadiarioProcedureDrawData> ganadiarioSaleList = ganadiarioBo.findListDraw();
	                modelList.put("ganadiarioSaleList", ganadiarioSaleList);
	                GanadiarioProcedureBetData ganadiarioSaleBean = ganadiarioBo.findByClientId(idClient);
	                ganadiarioSaleBean.setCloseDate(ganadiarioBo.DateFormat(ganadiarioSaleBean.getCloseDate()));
	                request.setAttribute("ganadiarioSale", ganadiarioSaleBean);
	                direct = "game/ganadiario/award_ganadiario_user";
	            } else if (gameId == Game.KABALA) {
	            	userBean.setpGame(Game.KABALA);
	                List<KabalaProcedureDrawData> kabalaSaleList = kabalaBo.findListDraw();
	                modelList.put("kabalaSaleList", kabalaSaleList);
	                KabalaProcedureBetData kabalaSaleBean = new KabalaProcedureBetData();//kabalaBo.findByClientId(idClient);
	                if(!flagPlus && flagChauChamba){
	                	kabalaSaleBean = kabalaBo.findByClientId(idClient);
	                	/*
                    	KabalaProcedureBetDataChCh kabalaProcedureBetDataChChBean = kabalaBo.findByClientIdChCh(idClient);
                    	kabalaSaleBean.setStatus(kabalaProcedureBetDataChChBean.getStatus());
                    	kabalaSaleBean.setMessage(kabalaProcedureBetDataChChBean.getMessage());
                    	kabalaSaleBean.setPrize(kabalaProcedureBetDataChChBean.getPrize());
                    	kabalaSaleBean.setActiveDraw(kabalaProcedureBetDataChChBean.getActiveDraw());
                    	kabalaSaleBean.setCloseDate(kabalaProcedureBetDataChChBean.getCloseDate());
                    	kabalaSaleBean.setCloseHour(kabalaProcedureBetDataChChBean.getCloseHour());
                    	kabalaSaleBean.setNextDraw(kabalaProcedureBetDataChChBean.getNextDraw());
                    	kabalaSaleBean.setOpenDate(kabalaProcedureBetDataChChBean.getOpenDate());
                    	kabalaSaleBean.setOpenHour(kabalaProcedureBetDataChChBean.getOpenHour());
                    	kabalaSaleBean.setNumbersMore(kabalaProcedureBetDataChChBean.getNumbersMore());
                    	kabalaSaleBean.setNumbersLess(kabalaProcedureBetDataChChBean.getNumbersLess());
                    	kabalaSaleBean.setPriceType(kabalaProcedureBetDataChChBean.getPriceType());
                    	kabalaSaleBean.setPriceMessage(kabalaProcedureBetDataChChBean.getPriceMessage());
                    	kabalaSaleBean.setSimpleBetPrice(kabalaProcedureBetDataChChBean.getSimpleBetPrice());
                    	kabalaSaleBean.setPromotionType(kabalaProcedureBetDataChChBean.getPromotionType());
                    	kabalaSaleBean.setBalanceAmount(kabalaProcedureBetDataChChBean.getBalanceAmount());
                    	kabalaSaleBean.setBalanceAmountGame(kabalaProcedureBetDataChChBean.getBalanceAmountGame());
                    	kabalaSaleBean.setAlgorithm(kabalaProcedureBetDataChChBean.getAlgorithm());
                    	kabalaSaleBean.setBets(kabalaProcedureBetDataChChBean.getBets());
                    	kabalaSaleBean.setPay(kabalaProcedureBetDataChChBean.getPay());
                    	kabalaSaleBean.setDraws(kabalaProcedureBetDataChChBean.getDraws());
                    	kabalaSaleBean.setCost(kabalaProcedureBetDataChChBean.getCost());
                    	*/
                    } else {
                    	kabalaSaleBean = kabalaBo.findByClientId(idClient);
                    }
	                kabalaSaleBean.setCloseDate(kabalaBo.DateFormat(kabalaSaleBean.getCloseDate()));
	                if(kabalaSaleBean.getPriceMessage().trim().length()>8) {
	                	kabalaSaleBean.setPromotionMessage(kabalaSaleBean.getPriceMessage());
	                	kabalaSaleBean.setPriceMessage("");
	                } else {
	                	kabalaSaleBean.setPromotionMessage("Costo por jugada: ");
	                }
	                request.setAttribute("kabalaSale", kabalaSaleBean);
	                request.setAttribute("iflexKabalaYoutubeUrl", ConnectionFactory.operationProperty("iflexTinkaYoutubeUrl", Constants.contextSale).trim());
	                direct = "game/kabala/award_kabala_user";
	            }
	            session.setAttribute(Constants.USR_SESION, userBean);
	            //GameBean gameBean = new GameBean();
	            //String bet_free = web.getFree() + "";
	            //(String) session.getAttribute("apGratis");
	            String balance = df.format(web.getPrizeAmount());//(String) session.getAttribute("money");
	            String ticket = web.getTicketId();//session.getAttribute("gticket").toString();
	            //String date = (String) session.getAttribute("date");
	            //String bet_middle_price = web.getOption2x1() + "";//(String) session.getAttribute("apMtadPrmio");
	            String amount2x1 = df.format(web.getTotalOption2x1Amount());
	            if (desist.equals("true")) amount2x1="0.00";
	            
	            if(web.getFreeCoupon()!=null && web.getFreeCoupon().length>0) {
		            CouponAPI[] freeCoupon = web.getFreeCoupon();//null;
		            /*if(Boolean.valueOf(desist).booleanValue()) {
		            	int cnt = 0;
		            	for (CouponAPI element : web.getFreeCoupon()) {
		            		if(element.getPrizeType() != Coupon.PLAY_DOS_POR_UNO) cnt++;
		            	}
		            	freeCoupon = new CouponAPI[cnt];
		            	for(int i=0; i<web.getFreeCoupon().length; i++) {
		            		CouponAPI element = web.getFreeCoupon()[i];
		            		if(element.getPrizeType() != Coupon.PLAY_DOS_POR_UNO) freeCoupon[i] = element;
		            	}
		            } else freeCoupon = web.getFreeCoupon();
		            //List<AwardBean> couponList = new ArrayList<AwardBean>();
		            web.setFreeCoupon(freeCoupon);*/
		            for(CouponAPI element : freeCoupon) {
		                /*AwardBean awardBean = new AwardBean();
		                awardBean.setPrizeType(freeCoupon[i].getPrizeType() == Coupon.PLAY_DOS_POR_UNO ? "(2x1)" : " ");
		                awardBean.setTicketGroups(freeCoupon[i].getFreeTicketGroups() + "");
		                awardBean.setSaleType(freeCoupon[i].getSaleType() == Coupon.PLAY_FREE_TICKET ? "Gratis" : "Precio Regular");
		                awardBean.setTicketDraws(freeCoupon[i].getFreeTicketDraws() + "");
		                awardBean.setAmount(freeCoupon[i].getAmount() > 0 ? "S/." + df.format(freeCoupon[i].getAmount()) : "-");
		                if (i == 0)
		                    awardBean.setState(false);
		                couponList.add(awardBean);*/
		                if (!Boolean.valueOf(desist).booleanValue() || element.getPrizeType() != Coupon.PLAY_DOS_POR_UNO) {
		                    JsonObject joElement = new JsonObject();
		                    joElement.addProperty("prizeType", element.getPrizeType() == Coupon.PLAY_DOS_POR_UNO ? "(2x1)" : " ");
		                    joElement.addProperty("ticketGroups", element.getFreeTicketGroups() + "");
		                    joElement.addProperty("saleType", element.getSaleType() == Coupon.PLAY_FREE_TICKET ? "Gratis" : "Precio Regular");
		                    joElement.addProperty("ticketDraws", element.getFreeTicketDraws() + "");
		                    joElement.addProperty("amount", element.getAmount() > 0 ? "S/." + df.format(element.getAmount()) : "-");
		                    //joElement.addProperty("state", i == 0 ? false : null);
		                    /*jObj += "{ prizeType : &quot;" + (freeCoupon[i].getPrizeType() == Coupon.PLAY_DOS_POR_UNO ? "(2x1)" : " ") + "&quot;, ticketGroups : &quot;"
		                            + freeCoupon[i].getFreeTicketGroups() + "&quot;, saleType : &quot;"
		                            + (freeCoupon[i].getSaleType() == Coupon.PLAY_FREE_TICKET ? "Gratis" : "Precio Regular") + "&quot;, ticketDraws : &quot;"
		                            + freeCoupon[i].getFreeTicketDraws() + "&quot;, amount : &quot;"
		                            + (freeCoupon[i].getAmount() > 0 ? "S/." + df.format(freeCoupon[i].getAmount()) : "-") + "&quot;}";
		                    if (i < freeCoupon.length - 1)
		                        jObj += ",";*/
		                    jaEvents.add(joElement);
		                }
		            }
	            }
	            /*for (AwardBean award : couponList)
	                jaEvents.add(new Gson().toJsonTree(award));*/
	            //joAward.addProperty("bet_free", bet_free);
	            joAward.addProperty("gameid", gameId);
	            joAward.addProperty("balance", balance);
	            joAward.addProperty("number_ticket", ticket);
	            //joAward.addProperty("bet_middle_price", bet_middle_price);
	            joAward.addProperty("cash", cash);
	            joAward.addProperty("amount", amount2x1);
	            joAward.addProperty("state", 0);
	            joAward.addProperty("desist", desist);
	            joAward.add("group", jaEvents);
	            //outData = callback + "(" + joTicket + ")";
	            //modelList.put("couponList", couponList);
	            modelList.put("awardList", joAward);
	            //request.setAttribute("awardList", joAward);
	            //gameBean.setBet_free(bet_free);
	            //gameBean.setBalance(balance);
	            //gameBean.setNumber_ticket(ticket);
	            //gameBean.setDate(date);
	            //gameBean.setBet_middle_price(bet_middle_price);
	            //gameBean.setAmount(amount2x1);
	            //LoggerApi.Log.info("bet_free: " + bet_free + " balance: " + balance + " ticket: " + ticket + " date: " + date + " bet_middle_price: " + bet_middle_price);
	            LoggerApi.Log.info("gameId: " + gameId + " balance: " + balance + " number_ticket: " + ticket + " desist: " + desist + "");
            } else {
            	direct = "redirect:/mi-cuenta.html#movimientos";
            }
            //session.setAttribute("award", gameBean);
            return direct;
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return direct;
        } finally {
        }
    }

    @RequestMapping(value = "/pago_premio")
    public void payAwardPlay(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        String clientId = "";
        String array_total = "";
        String errorInDataMessage = "";
        Client client = null;
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            double availableBalance = 0;
            PrintWriter out = null;
            out = response.getWriter();
            String data = "";
            boolean desist2x1orFree = false;
            boolean creditPrize = true;
            int gameId = 0;
            if (request.getParameter("dato") != null)
                data = String.valueOf(request.getParameter("dato"));
            if (request.getParameter("desist") != null)
                desist2x1orFree = Boolean.valueOf(request.getParameter("desist")).booleanValue();
            /*if (request.getParameter("credit") != null)
            	creditPrize = (request.getParameter("credit").equals("1"))?false:true;*/
            if (request.getParameter("game") != null)
                gameId = Integer.parseInt(request.getParameter("game"));
            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " data=*" +data+"* desist2x1orFree="+desist2x1orFree+" creditPrize="+creditPrize+" gameId="+gameId );
            String[] boletos = data.split("-");
            String[] jugada = null;
            String jugadas = "";
            String[] o = new String[5];
            pe.com.intralot.loto.model.ClientTicket ct = null;
            Game gm = new Game(gameId);
            String name_game = gm.getName();
            String clientIp = "";
            if((WEBTicketPrePay)session.getAttribute("webTPP") != null) {
	            WEBTicketPrePay webTicketPrePay = (WEBTicketPrePay) session.getAttribute("webTPP");//null;
	            String originalId = webTicketPrePay.getOriginalId();
	            clientId = webTicketPrePay.getClientId();
	            String barCode = webTicketPrePay.getBarCode();
	            //Client client = webTicketPrePay.getClient();
	            String ticketId = webTicketPrePay.getTicketId();
	            LinkedList<WEBTicket> webTickets = new LinkedList<WEBTicket>();
	            /*System.out.println("prizeAmount=" + webTicketPrePay.getPrizeAmount());
	            System.out.println("totalOption2x1Amount=" + webTicketPrePay.getTotalOption2x1Amount());
	            System.out.println("free=" + webTicketPrePay.getFree());
	            System.out.println("2x1=" + webTicketPrePay.getOption2x1());
	            System.out.println("desist2x1orFree=" + desist2x1orFree);
	            System.out.println("originalId=" + originalId + " clientId=" + clientId + " barCode=" + barCode + " ticketId=" + ticketId + " \ndata=" + data);*/
	            double price = webTicketPrePay.getTotalOption2x1Amount();
	            if (desist2x1orFree==true) {
	            	price = 0.0;
	            }
	            int num_row = 1;
	            clientIp = request.getRemoteAddr().toString();
	            String clientCarrier = "WEBCO";
	            boolean errorInData = false;
	            client = BussinessSaleDispatcher.getClientByClientId(clientId);
	            
	            Game game = new Game();
	            game.setGame(gameId);
	            //System.out.println("DATA="+data+" BOLETOS="+boletos.length);
	            if(webTicketPrePay.getFreeCoupon()!=null && webTicketPrePay.getFreeCoupon().length>0 && ((!desist2x1orFree && webTicketPrePay.getFreeCoupon().length == boletos.length)||desist2x1orFree)) {
	            	CouponAPI[] freeCoupon = webTicketPrePay.getFreeCoupon();
	            	//System.out.println("freeCoupon.length=" + freeCoupon.length);
	                //for(int i = 0; i < freeCoupon.length; i++) {
	            	int cnt = 0;
	            	Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " boletos=*" +boletos+"* clientIp="+clientIp );
	            	if(data.contains("|")) {
		            	for(int i = 0; i < freeCoupon.length; i++) {
		                	if((desist2x1orFree && freeCoupon[i].getPrizeType() != Coupon.PLAY_DOS_POR_UNO) || !desist2x1orFree) {
			                    int groups = freeCoupon[i].getFreeTicketGroups();
			                    GroupAPI[] group = new GroupAPI[groups];
			                    jugada = boletos[cnt].split("\\|");
			                    for(int j = 0; j < group.length; j++) {
			                        if(!jugada[j].trim().equals("00")) {
			                            String addons = "";
			                            String ap[] = jugada[j].trim().split(" ");
			                            int[] number = new int[ap.length];
			                            for (int k = 0; k < ap.length; k++) {
			                                try {
			                                    number[k] = Integer.parseInt(ap[k]);
			                                } catch (Exception e) {
			                                    errorInData = true;
			                                    errorInDataMessage = "Numero elegido esta incorrecto, refrescar la sesion.";
			                                }
			                                Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " number[" + k + "]= " + number[k] + " GameSaleDispatcher.playCouponByWeb");
			                            }
			                            group[j] = new GroupAPI();
			                            group[j].setLottoBetNewLotos5(gameId, Group.NORMAL, number, addons.trim());
			                            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " group[" + j + "] = " + group[j] + " GameSaleDispatcher.playCouponByWeb game.getNumbersSimpleBet()="+game.getNumbersSimpleBet());
			                            LoggerApi.Log.info("cid=" + clientId + " "+number.length+" > "+ game.getNumbersSimpleBet() ); 
			                            if ( number.length > game.getNumbersSimpleBet() ) {
		                                    errorInData = true;
		                                    errorInDataMessage = "Numero elegido es incorrecto.";
			                            }
			                        } else {
			                            errorInData = true;
			                            errorInDataMessage = "Faltan agregar apuestas. Complete sus jugadas.";
			                        }
			                    }
			                    WEBTicket webTicket = new WEBTicket();
			                    webTicket.setGroups(group);
			                    webTicket.setTicketType(freeCoupon[i].getSaleType());
			                    freeCoupon[i].setTicketIdRoot(originalId);
			                    webTicket.setCouponSelected(freeCoupon[i]);
			                    webTickets.add(webTicket);
	
			                    jugadas += (!jugada[0].trim().equals("") ? jugada[0].trim() : " ") + "|" + (!jugada[1].trim().equals("") ? jugada[1].trim() : " ") + "|"
			                            + (!jugada[2].trim().equals("") ? jugada[2].trim() : " ") + "|" + (!jugada[3].trim().equals("") ? jugada[3].trim() : " ") + "&"
			                            + (!jugada[5].trim().equals("") ? Integer.parseInt(jugada[5].trim()) : " ") + "&"
			                            + (!jugada[6].trim().equals("") ? Double.parseDouble(jugada[6].trim()) : " ") + "||";
			                    cnt++;
		                	} else {
	
	                            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " " +i+" !  (desist2x1orFree && freeCoupon[i].getPrizeType() != Coupon.PLAY_DOS_POR_UNO) || !desist2x1orFree " );
		                	}
		                }
	            	}
	            } else {
	                if (data.equals(ticketId))
	                    errorInData = false;
	                else
	                    errorInData = true;
	                errorInDataMessage = "Faltan agregar mas apuestas. Complete sus jugadas.";
	            }
	            WEBTicketPay webTicketPay = new WEBTicketPay();
	            webTicketPay.setWebTickets(webTickets.size()>0?webTickets:null);
	            webTicketPay.setOriginalId(originalId);
	            
	            pe.com.intralot.loto.model.ClientTicket originalTicket = BussinessSaleDispatcher.getTicketByBarCode(barCode);
	            LoggerApi.Log.info("cid=" + clientId + " "+ originalTicket.getGameId()+" equals(gameId) "+gameId );
	            if (!originalTicket.getGameId().equals(gameId+"")) {
                    errorInData = true;
                    errorInDataMessage = "Juego elegido es incorrecto.";
	            }
	            
                LoggerApi.Log.info("cid=" + clientId + " webTicketPay="+webTicketPay);

	            if (errorInData == false) {
	                DateAPI d = new DateAPI();
	                WEBMessage web = new WEBMessage();
	                web.setIp(clientIp);
	                web.setMessageId("W" + d.getTimeLong() + gameId);
	                WEBTicketPay wtp = GameSaleDispatcher.payTicketWinnerByWebTransactionNewLotos5(clientCarrier, client, web, game, barCode,//webTicketPrePay.getBarCode(),
	                        webTicketPay, desist2x1orFree, creditPrize);
	                //System.out.println("getMessage=" + wtp.getMessage());
	                LoggerApi.Log.info("cid=" + clientId + " message=" + wtp.getMessage() + " balanceAmount="+wtp.getBalanceAmount() + " ---payTicketWinnerByWebTransactionNewLotos5");
	                if (wtp.getMessage().equals("OK")) {
	                	
	    	            if (desist2x1orFree==true) {
		                	wtp.setSimpleBetPrice(0.00f);
	    	            }
	                	
	                    /*System.out.println("---payTicketWinnerByWebTransactionNewLotos5");
	                    System.out.println("getPrizeAmount=" + wtp.getPrizeAmount());
	                    System.out.println("getDosxUnoColumns=" + wtp.getDosxUnoColumns());
	                    System.out.println("getFreeColumns=" + wtp.getFreeColumns());
	                    System.out.println("getMessage=" + wtp.getMessage());
	                    System.out.println("getWinnerRequest=" + wtp.getWinnerRequest());
	                    System.out.println("getWinnerPayed=" + wtp.getWinnerPayed());
	                    System.out.println("getCouponExchange=" + wtp.getCouponExchange());
	                    System.out.println("getBalanceAmount=" + wtp.getBalanceAmount());*/
	                    client = BussinessSaleDispatcher.getClientByClientId(clientId);
	                    
	                    o = null;
	                    if(wtp.getWebTickets()!=null && wtp.getWebTickets().size()>0) {
		                    for (WEBTicket ticket : wtp.getWebTickets()) {
		                        //System.out.println("--getCouponPlayed=" + ticket.getCouponPlayed());
		                        //System.out.println("----getClientTicket=" + ticket.getClientTicket());
		                        ct = ticket.getClientTicket();
		                        //System.out.println("------getPrice=" + ct.getPrice() + " getColumns=" + ct.getColumns() + " getNumColumns=" + ct.getNumColumns() + " getNumGroups="
		                        //        + ct.getNumGroups());
		                        array_total += (!ct.getBetMatrix1().equals("") ? ct.getBetMatrix1() : " ") + "|" + (!ct.getBetMatrix2().equals("") ? ct.getBetMatrix2() : " ") + "|"
		                                + (!ct.getBetMatrix3().equals("") ? ct.getBetMatrix3() : " ") + "|" + (!ct.getBetMatrix4().equals("") ? ct.getBetMatrix4() : " ") + "|"
		                                + (!wtp.getMessage().equals("") ? wtp.getMessage() : " ") + "&" + (!ct.getTicketId().equals("") ? ct.getTicketId() : " ") + "&"
		                                + df.format(wtp.getBalanceAmount()) + "|" + ct.getConsecutive() + "|" + wtp.getSimpleBetPrice() + "|" + num_row + "|"
		                                + (!name_game.equals("") ? name_game : " ") + "|" + gameId + "|" + df.format(client.getBalanceAmount()) + "|" + price + "#";
		                        num_row++;
		                    }
	                    } else {
	                    	array_total += " | | | |" + (!wtp.getMessage().equals("") ? wtp.getMessage() : " ") + "& &" + df.format(wtp.getBalanceAmount()) + "| | |" + num_row + "|" + (!name_game.equals("") ? name_game : " ") + "|" + gameId + "|" + df.format(client.getBalanceAmount()) + "|" + price + "#";
	                        num_row++;
	                    }
	                    //System.out.println("getClientTicketExchange=" + wtp.getClientTicketExchange());
	                    if (wtp.getClientTicketExchange() != null) {
	                        ct = wtp.getClientTicketExchange();
	                        array_total += (!ct.getBetMatrix1().equals("") ? ct.getBetMatrix1() : " ") + "|" + (!ct.getBetMatrix2().equals("") ? ct.getBetMatrix2() : " ") + "|"
	                                + (!ct.getBetMatrix3().equals("") ? ct.getBetMatrix3() : " ") + "|" + (!ct.getBetMatrix4().equals("") ? ct.getBetMatrix4() : " ") + "|"
	                                + "TC&" + (!ct.getTicketId().equals("") ? ct.getTicketId() : " ") + "&" + df.format(wtp.getBalanceAmount()) + "|" + ct.getConsecutive() + "|" + wtp.getSimpleBetPrice() + "|" + num_row + "|" + (!name_game.equals("") ? name_game : " ") + "|" + gameId + "|"
	                                + df.format(client.getBalanceAmount()) + "|" + price + "#";
	                    }
	                } else {
	                    if (wtp.getMessage().toUpperCase().equals(wtp.getMessage())) {
	                    	//String[] arrS = (wtp.getMessage()).split("\\. ");
	                    	o[0] = wtp.getMessage().charAt(0) + wtp.getMessage().substring(1).toLowerCase().replace(".", ";");
	                        //for(int i=0; i<arrS.length; i++) o[0] += arrS[i].substring(0,1)+arrS[i].substring(1).toLowerCase()+". ";//wtp.getMessage().charAt(0) + wtp.getMessage().substring(1).toLowerCase();
	                    } else o[0] = wtp.getMessage();
	                    o[1] = ticketId;
	                    o[2] = "";
	                    o[3] = df.format(client.getBalanceAmount()) + "";
	                }
	            } else {
	                o[0] = errorInDataMessage;
	                o[1] = "";
	                o[2] = "";
	                client = BussinessSaleDispatcher.getClientByClientId(clientId);
	                o[3] = df.format(client.getBalanceAmount()) + "";
	            }
	            if(o != null) {
	            	if(jugadas != null && !jugadas.equals("")) {
	            		jugadas = jugadas.substring(0, jugadas.length() - 2);
		                if (!o[0].equals("OK") && !jugadas.equals("")) {
		                    boletos = jugadas.split("\\|\\|");//StringUtils.split(jugadas, "||");
		                    for (String boleto : boletos) {
		                        jugada = boleto.split("&");
		                        array_total += jugada[0] + "|" + o[0] + "&" + o[1] + "& |" + (jugada.length>1?jugada[1]:" ") + "|" + (jugada.length>2?jugada[2]:" ") + "|" + num_row + "|" + name_game + "|" + gameId + "|" + o[3]
		                                + "|" + price + "#";
		                        num_row++;
		                    }
		                }
	            	} else {
	            		array_total += " | | | |" + o[0] + "&" + o[1] + "& | | |" + num_row + "|" + name_game + "|" + gameId + "|" + o[3] + "| #";
	                    num_row++;
	            	}
	            }
            }
            //System.out.println("ARRAY_TOTAL="+array_total);
            if (!array_total.equals("")) {
                array_total = array_total.substring(0, array_total.length() - 1);
            }
            else {
            	array_total = " | | | | & & | | | | |" + gameId + "| | ";
            }
            
            if (client==null) { client = BussinessSaleDispatcher.getClientByClientId(clientId); }
            availableBalance = client.getBalanceAmount();
            userBean.setpMonto(availableBalance);
            session.setAttribute(Constants.USR_SESION, userBean);
            session.removeAttribute("webTPP");
            out.print(array_total);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info("cid=" + clientId + " errorInDataMessage="+errorInDataMessage+" array_total="+ array_total + " finally ---payTicketWinnerByWebTransactionNewLotos5");

        }
    }
}
