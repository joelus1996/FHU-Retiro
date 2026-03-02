package pe.com.intralot.loto.layer.view.client;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.controller.client.bo.ClientPrizeBo;
import pe.com.intralot.loto.layer.controller.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.model.pojo.UbicacionRedDigital;
import pe.com.intralot.loto.layer.model.pojo.UbicacionTerminal;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.model.ClientTicket;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.QrUtil;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;
import pe.com.intralot.loto.www.sale.game.controller.GameTeApuestoController;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.dto.client.ClientInformationResponseDTO;
import pe.com.intralot.loto.layer.model.bean.QrResult;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetDataCollectPrizes;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleLotos5Dispatcher;
import com.google.gson.Gson;

@Controller
public class ClientPrizeController {

	//private static final Log logger = LogFactory.getLog(ClientPrizeController.class);
    @Autowired
    private ClientPrizeBo beanClientPrizeBo;
    @Autowired
    private IntralotUtils intralotUtils;
    
    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
	private ClientBalanceBo beanClientBalanceBo;
    
    @Autowired
    private QrUtil qrUtil;
    
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;
	
	private final Gson gson = new Gson();

    @RequestMapping("/client_price_show_information")
    public ModelAndView showInformation(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_price_show_information"); 
            HttpSession session = request.getSession();
            
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            
            if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
                if (StringUtils.isEmpty(request.getParameter("from"))) {
                    if (session.getAttribute("clientId") != null) {
                        String idClient = ((String) session.getAttribute("clientId")).trim();
                        if (!idClient.equals("")) {
                        	HashMap[]  pendingPrizeList = beanClientPrizeBo.getPendingPrize(Integer.valueOf(idClient));
                        	
                        	if(pendingPrizeList==null) {
                        		System.out.println("client_price_show_information pendingPrizeList nulo idClient"+idClient);
                        	}else {
                        		System.out.println("client_price_show_information pendingPrizeList.length: " + pendingPrizeList.length + " idClient:"+idClient);
                        		
                        		try {
                        			for (HashMap hashMap : pendingPrizeList) {
    									System.out.println("client_price_show_information pendingPrizeList hashMap "+hashMap.toString());
    								}
								} catch (Exception e) {
									e.printStackTrace();
								}
                        		
                        	}
                        	
                        	session.setAttribute("pendingPrizeList", pendingPrizeList);
                        	
                        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
            				PaymentPrizeProcedureGetDataCollectPrizes paymentPrizeProcedureGetDataCollectPrizes = paymentPrizeBo
            						.getDataCollectPrizes(user.getClientId());
            				session.setAttribute("saldoLiquidable", intralotUtils.formatCurrency(paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidable()));
            				session.setAttribute("saldoLiquidableCompleto", intralotUtils.formatCurrency(paymentPrizeProcedureGetDataCollectPrizes.getSaldoLiquidableCompleto()));
                        }else {
                        	System.out.println("client_price_show_information clientId vacio");
                        }
                    }else {
                    	System.out.println("client_price_show_information no se encontro clientId en session");
                    }
                }else {
                	System.out.println("client_price_show_information no se encontro parametro from");
                }
                return new ModelAndView("client/interface-prize");
            }else {
                return new ModelAndView("home/interface-home");
            }
        } catch (Exception e) {
        	e.printStackTrace();
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-prize");
        } finally {
    		LoggerApi.Log.info("-------------- END client_price_show_information"); 
        }
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("/client_price_find_information")
    public ModelAndView findInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	DecimalFormat df = new DecimalFormat("###,###,##0.00");
        try {
    		LoggerApi.Log.info("-------------- START client_price_find_information"); 
            HttpSession session = request.getSession();
            HashMap[] map = (HashMap[]) session.getAttribute("pendingPrizeList");
            //String play = request.getParameter("play");
            String gameId = request.getParameter("gameId");
            String ticket = request.getParameter("ticket");
            
            //HashMap<String, Object> ticketMap = beanClientPrizeBo.getPendingPrizeByTicketid(Integer.valueOf(gameId), Integer.valueOf(ticket));
            //HashMap<String, Object> ticketMap = beanClientPrizeBo.getTicketById(Integer.valueOf(gameId), Integer.valueOf(ticket));
            
            // Obtencion de QR
            //String clientId = (String) session.getAttribute("clientId");
            String base64Qr = null;
            /*
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;
            if(clientId!=null && gameId!=null && ticket!=null) {
            	ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(Integer.parseInt(clientId), Integer.parseInt(gameId), Long.valueOf(ticket));
            	
            	if(ticketProcedureGetClientTicket.getCtTwDefinePrize()!=null && ticketProcedureGetClientTicket.getCtTwDefinePrize().equals("2")) {
            		base64Qr = qrUtil.generateQR(ticketProcedureGetClientTicket);
            	}
            }*/
            
            //boolean kabalaPlusEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"));
            //boolean kabalaChauChambaEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB"));
            int chChDrawEnabled = Integer.valueOf(ConnectionFactory.operationProperty("kabalaChChDrawEnabled", "CARD-WEB").trim()).intValue();
            String maxPrizePaid = String.valueOf(ConnectionFactory.operationProperty("maxTerminalPrizePaid", "CARD-WEB")).toString();
            //Double dmaxMoney = (maxPrizePaid!=null && maxPrizePaid.equals(""))?Double.parseDouble(maxPrizePaid):150.0;
            Double dmaxMoney = (maxPrizePaid!=null && !maxPrizePaid.equals(""))?Double.parseDouble(maxPrizePaid):150.0;
            objectModelMap.put("pending", "YES");
            if (map != null) {
                //for (HashMap hashMap : map) {
            	for (int i=0; i<map.length; i++) {
            		HashMap hashMap = map[i];
                    //if (StringUtils.equals(hashMap.get("GMATRIX1").toString(), play) && StringUtils.equals(hashMap.get("GTICKET").toString(), ticket)) {
                	if (StringUtils.equals(hashMap.get("GAMEID").toString(), gameId) && StringUtils.equals(hashMap.get("GTICKET").toString(), ticket)) {
                		//hashMap.put("STATUS", ticketMap.get("STATUS"));
                		//hashMap.put("GSTATUS", ticketMap.get("GSTATUS"));
                		if(hashMap.get("TW_DEFINE_PRIZE_FLAG")!=null && hashMap.get("TW_DEFINE_PRIZE_FLAG").toString().equals("2")) {
                    		base64Qr = qrUtil.generateQR(hashMap.get("CT_TICKET_NUMBER").toString());
                    	}
                		
                		if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.KABALA) {
	                    	if(Integer.parseInt(hashMap.get("GFROMDRAW").toString())>=chChDrawEnabled){
	                    		if(hashMap.get("CT_ADDON_1") != null)
	                                if(hashMap.get("CT_ADDON_1").equals("1")) objectModelMap.put("Addon1", "(Plus+)");
	                                else objectModelMap.put("Addon1", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_2") != null)
	                                if(hashMap.get("CT_ADDON_2").equals("1")) objectModelMap.put("Addon2", "(Plus+)");
	                                else objectModelMap.put("Addon2", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_3") != null)
	                                if(hashMap.get("CT_ADDON_3").equals("1")) objectModelMap.put("Addon3", "(Plus+)");
	                                else objectModelMap.put("Addon3", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_4") != null)
	                                if(hashMap.get("CT_ADDON_4").equals("1")) objectModelMap.put("Addon4", "(Plus+)");
	                                else objectModelMap.put("Addon4", "(Chau Chamba)");
	                    	} else {
		                    	if (hashMap.get("CT_ADDON_1") != null)
		                            if (hashMap.get("CT_ADDON_1").equals("1")) objectModelMap.put("Addon1", "(Plus+)");
		                            else objectModelMap.put("Addon1", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_2") != null)
		                            if (hashMap.get("CT_ADDON_2").equals("1")) objectModelMap.put("Addon2", "(Plus+)");
		                            else objectModelMap.put("Addon2", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_3") != null)
		                            if (hashMap.get("CT_ADDON_3").equals("1")) objectModelMap.put("Addon3", "(Plus+)");
		                            else objectModelMap.put("Addon3", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_4") != null)
		                            if (hashMap.get("CT_ADDON_4").equals("1")) objectModelMap.put("Addon4", "(Plus+)");
		                            else objectModelMap.put("Addon4", "(Plus+)  (Chau Chamba)");
	                    	}
                    	}
                		if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.KINELO) {
                			if(hashMap.get("GMATRIX1")!=null && !hashMap.get("GMATRIX1").toString().isEmpty()) {
                				String GMATRIX1 = hashMap.get("GMATRIX1").toString();
                				int indice = GMATRIX1.indexOf("x");
                				if(indice>0) {
                					String jugada = GMATRIX1.substring(0, indice);
                    				String multiplicador = GMATRIX1.substring(indice, GMATRIX1.length());
                    				GMATRIX1 = jugada.trim().replace(" ", "-").concat(" ").concat(multiplicador);
                    				hashMap.put("GMATRIX1", GMATRIX1);
                				}
                			}
                			if(hashMap.get("GMATRIX2")!=null && !hashMap.get("GMATRIX2").toString().isEmpty()) {
                				String GMATRIX2 = hashMap.get("GMATRIX2").toString();
                				int indice = GMATRIX2.indexOf("x");
                				if(indice>0) {
                					String jugada = GMATRIX2.substring(0, indice);
                    				String multiplicador = GMATRIX2.substring(indice, GMATRIX2.length());
                    				GMATRIX2 = jugada.trim().replace(" ", "-").concat(" ").concat(multiplicador);
                    				hashMap.put("GMATRIX2", GMATRIX2);
                				}
                			}
                		}
                		System.out.println("client_price_find_information set pendingPrizeInfo");
                		try {
                			System.out.println("client_price_find_information pendingPrizeInfo hashMap "+hashMap.toString());
						} catch (Exception e) {
							e.printStackTrace();
						}
                		
                        session.setAttribute("pendingPrizeInfo", hashMap);
                        session.setAttribute("dmaxMoney", dmaxMoney);
                        session.setAttribute("maxMoney", df.format(dmaxMoney));
                        objectModelMap.put("GPRIZE", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GPRIZE").toString())));
                        objectModelMap.put("base64Qr", base64Qr);
                        
                        session.setAttribute("indexPrizeSelected", i);
                        break;
                    }else {
                    	System.out.println("client_price_find_information GAMEID y GTICKET diferentes");
                    }
                }
            }else {
            	System.out.println("client_price_find_information map es nulo");
            }
            return new ModelAndView("client/interface-prize-detail");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-prize-detail");
        } finally {
			LoggerApi.Log.info("-------------- END client_price_find_information"); 
        }
    }


    @SuppressWarnings({ "rawtypes", "null", "static-access" })
    @RequestMapping("/client_price_execute_collection")
    public ModelAndView executeCollection(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            LoggerApi.Log.info("-------------- START client_price_execute_collection"); 
            try {
            	Integer cid = Integer.parseInt( (String)session.getAttribute("clientId") );
                if (cid==null || cid <= 0) return new ModelAndView("redirect:security_login_execute_authentication.html");
            } catch (Exception e) {
    			return new ModelAndView("redirect:security_login_execute_authentication.html");
            } finally {
               // LoggerApi.Log.info("-------------- END client_price_execute_collection Exception"); 
            }
            if (StringUtils.isNotEmpty((String) session.getAttribute("clientId"))) {
                pe.com.intralot.loto.model.Client client = new pe.com.intralot.loto.model.Client();
                client.setClientId((String) session.getAttribute("clientId"));
                AccountController controller = new AccountController();
                ClientTicket clientTicket = new ClientTicket();
                Map mapGame = (Map) session.getAttribute("pendingPrizeInfo");
                if (mapGame != null) {
                    int gameid = Integer.valueOf(mapGame.get("GAMEID").toString());
                    Double gprize = Double.valueOf(mapGame.get("GPRIZE").toString());
                    String gticket = mapGame.get("GTICKET").toString();
                    String maxPrizePaid = String.valueOf(ConnectionFactory.operationProperty("maxTerminalPrizePaid", "CARD-WEB")).toString();
                    //Double dmaxMoney = (maxPrizePaid!=null && maxPrizePaid.equals(""))?Double.parseDouble(maxPrizePaid):150;
                    Double dmaxMoney = (maxPrizePaid!=null && !maxPrizePaid.equals(""))?Double.parseDouble(maxPrizePaid):150;
            		Logger.getLogger(LoggerAPI.SALECARD).info("ClientPrizeController.executeCollection( gameid="+gameid+" gprize="+gprize+" gticket="+gticket+" maxPrizePaid="+maxPrizePaid+" dmaxMoney="+dmaxMoney+" )");
            		
            		if ( gticket==null || gticket.equals("null") || gticket.equals("undefined") || gticket.equals("") ) {
                        session.setAttribute("alertAccount", "No se ha logrado procesar el cobro del premio");
                        return new ModelAndView("redirect:client_balance_show_information.html");
            		}

                    session.setAttribute("pendingPrizeInfo", null);
                    session.removeAttribute("pendingPrizeInfo");
                    mapGame = null;
                    //clientTicket = controller.getClientTicketPlay((String) session.getAttribute("clientId"), gameid, gticket);
                    if (gprize != null && gprize > 0 && gprize <= dmaxMoney) {
                        WEBTicketPay webTicketPay = new WEBTicketPay();
                        Game game = new Game();
                        game.setGame(gameid);
                        pe.com.intralot.loto.model.Client client1 = controller.getClientByClientId((String) session.getAttribute("clientId"));
                        WEBMessage web = new WEBMessage();
                        web.setClient(client1);
                        web.setIp(request.getRemoteAddr());
                        DateAPI d = new DateAPI();
                        web.setMessageId("W" + d.getTimeLong());
                        web.setGame(game);
                        web.setCarrier("MOBILE");
                        String message = StringUtils.EMPTY;
                        WEBTicketPay wtp = new WEBTicketPay();
                        if(gameid == Game.KINELO) {
                        	String clientId = session.getAttribute("clientId").toString();
                        	String clientIp = request.getRemoteAddr();
                        	TicketProcedureGetClientTicket ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(Integer.parseInt(clientId), gameid, Long.parseLong(gticket));
                        	String barCode = StringLib.decodeLabel(ticketProcedureGetClientTicket.getCtTicketNumber());
                        	String resp[] = GameSaleLotos5Dispatcher.payCouponToBalanceByWeb(null, clientId, clientIp, gameid, barCode, gticket, false);
                        	System.out.println(resp[0]);
                            if (resp[0] != null && resp[0] == "OK") {
                            	session.setAttribute("alertAccount", "Se ha recargado el saldo con   " + intralotUtils.formatCurrency(gprize) + " ver ");
                            	ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(Integer.parseInt(clientId));
            	  			  	accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
            	  			  	intralotUtils.updateBalanceSession(session,accountData,0,"");
                            }
                        }else {
                        	clientTicket = controller.getClientTicketPlay((String) session.getAttribute("clientId"), gameid, gticket);
	                        if (gameid == Game.TEAPUESTO)
	                            wtp = GameTeApuestoController.payTicketWinnerByWebTransactionLotos5(client1, web, game, clientTicket.getTicketNumber(), webTicketPay, false, true);
	                        else
	                            wtp = controller.payTicketWinnerByWebTransaction(client1, web, game, clientTicket.getTicketNumber(), webTicketPay, false, true);
	                        if (wtp.getMessage() != null)
	                            message = wtp.getMessage();
	                        if (StringUtils.contains(message, "OK"))
	                            session.setAttribute("alertAccount", "Se ha recargado el saldo con   " + intralotUtils.formatCurrency(gprize) + " ver ");
	                        else
	                            session.setAttribute("alertAccount", "No se ha logrado procesar el cobro del premio ir a");
                        }
                    } else session.setAttribute("alertAccount", "El premio obtenido es S/."+gprize+", el m&aacute;ximo a retirarse es S/."+dmaxMoney+". Retirar el premio en oficina principal");
                }
            }
            return new ModelAndView("redirect:client_balance_show_information.html");
        } catch (Exception e) {
            session.setAttribute("alertAccount", "No se ha logrado procesar el cobro del premio ir a");
            LoggerApi.severe(e);
            return new ModelAndView("redirect:client_balance_show_information.html");
        } finally {
            LoggerApi.Log.info("-------------- END client_price_execute_collection");
        }
    }
    
    @RequestMapping(value = "/cobrarQR")
    public void cobrarQR(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	HttpSession session = request.getSession();
        
        HashMap mapGame = (HashMap) session.getAttribute("pendingPrizeInfo");
        if (mapGame != null) {
            Integer gameId = Integer.valueOf(mapGame.get("GAMEID").toString());
            Double gprize = Double.valueOf(mapGame.get("GPRIZE").toString());
            String ticket = mapGame.get("GTICKET").toString();
            String maxPrizePaid = String.valueOf(ConnectionFactory.operationProperty("maxTerminalPrizePaid", "CARD-WEB")).toString();
            Double dmaxMoney = (maxPrizePaid!=null && maxPrizePaid.equals(""))?Double.parseDouble(maxPrizePaid):150;
    		Logger.getLogger(LoggerAPI.SALECARD).info("ClientPrizeController.cobrarQR( gameid="+gameId+" gprize="+gprize+" gticket="+ticket+" maxPrizePaid="+maxPrizePaid+" dmaxMoney="+dmaxMoney+" )");
    		
    		if ( ticket==null || ticket.equals("null") || ticket.equals("undefined") || ticket.equals("") ) {
                session.setAttribute("alertAccount", "No se ha logrado procesar el cobro del premio");
                return;
    		}
            
            // Obtencion de QR
            String clientId = (String) session.getAttribute("clientId");
            int definePrizeFlag = 2;
            String phone = "BY_MOBILE";
            
            String msg = BussinessSaleLotos5Dispatcher.definePrizeFlagPhone(Integer.parseInt(ticket), Integer.parseInt(clientId), gameId, definePrizeFlag, phone);
            LoggerApi.Log.info("msg ------------ > " + msg);
            
            if (!msg.equals("OK")) {
        		LoggerApi.Log.info("msg = "+msg);
                session.setAttribute("alertAccount", "En este momento estamos presentando problemas. Por favor intenta nuevamente más tarde.");
                return;
            }
            
            mapGame.put("TW_DEFINE_PRIZE_FLAG", "2"); // 2 = Cobrar en Punto de Venta
            /*
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;
            if(clientId!=null && gameId!=null && ticket!=null) {
            	ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(Integer.parseInt(clientId), gameId, Long.valueOf(ticket));
            }*/
            
            //HashMap<String, Object> ticketMap = beanClientPrizeBo.getTicketById(Integer.valueOf(gameId), Integer.valueOf(ticket));
            
        	//Obtener QR @jmoran 2019-05-24
        	String base64Qr = qrUtil.generateQR(mapGame.get("CT_TICKET_NUMBER").toString());
        	String htmlQrImage = "<div id='divQR'><img id='imgQR' src='"+base64Qr+"' style='border: 7px solid black' /></div>";
        	
        	QrResult qrResult = new QrResult();
        	qrResult.setHtmlQrImage(htmlQrImage);
        	
        	HashMap<String, Object> ticketMap = beanClientPrizeBo.getPendingPrizeByTicketid(Integer.valueOf(gameId), Integer.valueOf(ticket));
        	qrResult.setStatus((String) ticketMap.get("STATUS"));
        	
        	Gson gson = new Gson();
        	String jsonString = gson.toJson(qrResult);
        	
            PrintWriter out = response.getWriter();
        	
        	mapGame.put("STATUS", ticketMap.get("STATUS"));
        	
        	HashMap[] map = (HashMap[]) session.getAttribute("pendingPrizeList");
        	int idx = (Integer) session.getAttribute("indexPrizeSelected");
        	map[idx] = mapGame;
        	session.setAttribute("pendingPrizeList",map);
            
            // Limpiar pendingPrizeInfo
            session.setAttribute("pendingPrizeInfo", null);
            session.removeAttribute("pendingPrizeInfo");
            mapGame = null;
            
            try {
            	out.write(jsonString);
            } catch (Exception e) {
            	LoggerApi.severe(e); 
            }
            /*
            if (gprize != null && gprize > 0 && gprize <= dmaxMoney) {
                
            } else {
            	
            }*/
        }
    }

    @RequestMapping("/cpfi")
    public ModelAndView findInformationQR(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        // cpfi = client_play_find_information for QRCode
        try {
    		LoggerApi.Log.info("-------------- START findInformationQR"); 
            // HttpSession session = request.getSession();
            // HashMap[] map= (HashMap[]) session.getAttribute("client_play_show_informationList");
            String gameId = request.getParameter("g");
            String ticket = request.getParameter("t");
            // System.out.println("gameId="+gameId+" ticket="+ticket);
            // HashMap<String, Object> hashMap= (HashMap<String, Object>) beanClientPrizeBo.getClientPlayCouponByTicketid(Integer.valueOf(gameId),Integer.valueOf(ticket));
           //HashMap<String, Object> hashMap = beanClientPrizeBo.getPendingPrizeByTicketid(Integer.valueOf(gameId), Integer.valueOf(ticket));
            HashMap<String, Object> hashMap = beanClientPrizeBo.getTicketById(Integer.valueOf(gameId), Integer.valueOf(ticket));
            // for (HashMap hashMap : map) {
            // if(StringUtils.equals(hashMap.get("GAMEID").toString(),gameId) &&
            // StringUtils.equals(hashMap.get("GTICKET").toString(),ticket)){
            // System.out.println("gameId="+hashMap.get("GAMEID").toString()+" ticket="+hashMap.get("GTICKET").toString()+" prize="+hashMap.get("GPRIZE").toString()+" free="+hashMap.get("GFREE").toString()+" twoxone="+hashMap.get("GTWOXONE").toString());
            objectModelMap.put("pendingPrizeInfo", hashMap);
            // objectModelMap.put("GAMOUNT",intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GAMOUNT").toString())));
            if (hashMap.get("GPRIZE") != null)
                objectModelMap.put("GPRIZE", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GPRIZE").toString())));
            // break;
            // }
            // }
            return new ModelAndView("client/interface-prize-detail");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-prize-detail");
        } finally {
			LoggerApi.Log.info("-------------- END findInformationQR");
        }
    }

    @RequestMapping("/client_lotocard_show_geolocation_dynamicmap")
    public ModelAndView showGeolocationDynamicMap(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_lotocard_show_geolocation_dynamicmap"); 
            return new ModelAndView("client/interface-game-geolocation-dynamicmap");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-geolocation-dynamicmap");
        } finally {
			LoggerApi.Log.info("-------------- END client_lotocard_show_geolocation_dynamicmap"); 
        }
    }
    
    //Creado por JC
    @RequestMapping("/client_lotocard_show_geolocation_red_digital_dynamicmap")
    public ModelAndView showGeolocationRedDigitalDynamicMap(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_lotocard_show_geolocation_red_digital_dynamicmap");
            return new ModelAndView("client/interface-game-geolocation-red-digital-dynamicmap");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-geolocation-red-digital-dynamicmap");
        } finally {
			LoggerApi.Log.info("-------------- END client_lotocard_show_geolocation_red_digital_dynamicmap"); 
        }
    }

    @RequestMapping("/client_lotocard_show_geolocation_staticmap")
    public ModelAndView showGeolocationStaticMap(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_lotocard_show_geolocation_staticmap");
            return new ModelAndView("client/interface-game-geolocation-staticmap");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-geolocation-staticmap");
        } finally {
			LoggerApi.Log.info("-------------- END client_lotocard_load_balance"); 
        }
    }

    @RequestMapping(value = "/client_lotocard_show_map.html")
    public void showMap(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START client_lotocard_show_geolocation_staticmap");
        // String departmentId="0";
        // String provinceId="0";
        // String districtId="0";
        String latitude = "0";
        String longitude = "0";
        // departmentId=request.getParameter("departmentId");
        // provinceId=request.getParameter("provinceId");
        // districtId=request.getParameter("districtId");
        latitude = request.getParameter("latitude");
        longitude = request.getParameter("length");
        PrintWriter out = null;
        out = response.getWriter();
        List<UbicacionTerminal> listTerminalLocation = beanClientPrizeBo.findTerminalLocation(latitude, longitude);
        // for(UbicacionTerminal ut: listTerminalLocation) {
        if (listTerminalLocation != null) {
            for (int i = 0; i < listTerminalLocation.size(); i++) {
                UbicacionTerminal ut = listTerminalLocation.get(i);
                ut.setAddress(IntralotUtils.formatHtml(ut.getAddress()));
                ut.setReference(IntralotUtils.formatHtml(ut.getReference()));
                ut.setLuckyPoint(IntralotUtils.formatHtml(ut.getLuckyPoint()));
                listTerminalLocation.set(i, ut);
            }
            LoggerApi.Log.info("listTerminalLocation:" + listTerminalLocation.size());
            Gson gson = new Gson();
            out.println(gson.toJson(listTerminalLocation));
            //LoggerApi.Log.info("Salir del metodo: showMap.");
            //LoggerApi.Log.info("Salir de la clase: ClientPrizeController.");
        }
		LoggerApi.Log.info("-------------- END client_lotocard_show_geolocation_staticmap"); 
    }
    
    @RequestMapping(value = "/client_redDigital_show_map.html")
    public void showMapRedDigital(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START client_redDigital_show_map");

        String latitude = "0";
        String longitude = "0";

        latitude = request.getParameter("latitude");
        longitude = request.getParameter("length");
        PrintWriter out = null;
        out = response.getWriter();
        List<UbicacionRedDigital> listTerminalLocation = beanClientPrizeBo.findRedDigitalLocation(latitude, longitude);
        // for(UbicacionTerminal ut: listTerminalLocation) {
        if (listTerminalLocation != null) {
            for (int i = 0; i < listTerminalLocation.size(); i++) {
            	UbicacionRedDigital ut = listTerminalLocation.get(i);
                ut.setAddress(IntralotUtils.formatHtml(ut.getAddress()));
                //ut.setReference(IntralotUtils.formatHtml(ut.getReference()));
                //ut.setLuckyPoint(IntralotUtils.formatHtml(ut.getLuckyPoint()));
                listTerminalLocation.set(i, ut);
            }
            LoggerApi.Log.info("listTerminalLocation:" + listTerminalLocation.size());
            Gson gson = new Gson();
            out.println(gson.toJson(listTerminalLocation));
            //LoggerApi.Log.info("Salir del metodo: showMap.");
            //LoggerApi.Log.info("Salir de la clase: ClientPrizeController.");
        }
		LoggerApi.Log.info("-------------- END client_redDigital_show_map"); 

    }
    
    @RequestMapping(value = "/edit_client_autopayment_flag")
    public void editClientAutoPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- edit_client_autopayment_flag START");
		PrintWriter out = null;
	    String json = "";
	
        try {
            out = response.getWriter();
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("clientId") == null) {
                LoggerApi.Log.severe("-------------- ERROR edit_client_autopayment_flag: No hay sesión activa");
            } else {
                String idClient = (String) session.getAttribute("clientId");
                String flagAutoPayment = request.getParameter("autoPayEnabled");

                LoggerApi.Log.info("idClient: " + idClient);
                LoggerApi.Log.info("stateFlag recibido: " + flagAutoPayment);

                if (flagAutoPayment == null || flagAutoPayment.trim().isEmpty()) {
                    LoggerApi.Log.info("-------------- ERROR edit_client_autopayment_flag: Parametro faltante autoPayEnabled");
                } else {
                	String switchStatus = Boolean.parseBoolean(flagAutoPayment) ? "WEB" : "PDV";
                	ClientInformationResponseDTO clientInformationRequestDTO = beanClientPrizeBo.updateAutoPaymentFlag(idClient, switchStatus);
                	json = gson.toJson(clientInformationRequestDTO);
                }
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("-------------- END edit_client_autopayment_flag");
            if (out != null) {
                out.print(json);
                out.close();
            }
        }
    }
    
    @RequestMapping(value = "/get_client_autopayment_flag")
    public void getClientAutoPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- getClientAutoPayment Controller START");
		PrintWriter out = null;
        String json = "";

        try {
            out = response.getWriter();
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("clientId") == null) {
                LoggerApi.Log.severe("-------------- getClientAutoPayment ERROR: No hay sesión activa");
            } else {
                String idClient = ((String) session.getAttribute("clientId"));
                ClientInformationResponseDTO clientInformationRequestDTO = beanClientPrizeBo.getClientAutoPayment(idClient);
                json = gson.toJson(clientInformationRequestDTO);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("-------------- END getClientAutoPayment Controller");
            if (out != null) {
                out.print(json);
                out.close();
            }
        }
    }
    
}
