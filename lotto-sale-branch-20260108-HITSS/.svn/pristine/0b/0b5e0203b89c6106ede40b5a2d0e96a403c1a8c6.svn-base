package pe.com.intralot.loto.layer.controller.game.rapitinkas;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.layer.model.bean.GameBean;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.game.rapitinkas.bo.RapitinkasBo;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.ClientBalance;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.game.dispatcher.SalesGameDispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;

@Controller
public class RapitinkasController {

    @Autowired
    private RapitinkasBo rapitinkasBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private TicketSaleBo ticketSaleBo;

    @RequestMapping(value = "/juega-rapitinkas")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {

        return "redirect:/inicio.html";
        
    	/*
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        ClientProcedureGetDataClient dataClient = null;
        PrintWriter out = null;
        out = response.getWriter();
        try {
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                idSession = userBean.getpSessionid();
                idClient = userBean.getpClientid();
                user = userBean.getpUser();
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                request.setAttribute("dataClient", dataClient);
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
            }
            RapitinkasProcedureBetData rapitinkaSaleBean = rapitinkasBo.findByClientId(idClient);
            request.setAttribute("rapitinkaSale", rapitinkaSaleBean);
            userBean.setpGame(Game.INSTANT);
            session.setAttribute(Constants.USR_SESION, userBean);
            return "game/rapitinkas/home_rapitinkas_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/rapitinkas/home_rapitinkas_user";
        } finally {
            request.setAttribute("isAllowed", rapitinkasBo.isAllowedGoIn(user));
        }
        */
    }

    /*@RequestMapping(value = "/login_rapitinkas")
    public void loginByUserPass(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Integer idClient = 0, sessionId = 0;
        String username = "", password = "", capchaCode="";
        PrintWriter out = null;
        out = response.getWriter();
        String respuesta_ajax = "";
        HttpSession session = request.getSession();
        ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        int mode = -1;
        ClientProcedureGetDataClient dataClient = null;
        Integer cid = 0;
        int captcha = 0;
        int state = 0;
        String agreement = "", mverified = "", promotion= "", promotionibk= "";
        try {
        	if(request.getParameter("captcha-client") == null) {
        		LoggerApi.Log.info("Entro a RapitinkasController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a RapitinkasController loginByUserPass con captcha");
					captcha = 2;
				}
			}
            if (request.getParameter("user-client") != null && request.getParameter("password-client") != null) {
                username = request.getParameter("user-client").toLowerCase().trim();
                password = request.getParameter("password-client").toUpperCase().trim();
                if (!username.equals("") && !password.equals("") && (captcha == 1 || captcha == 2)) {
                    ClientProcedureLogin clientProcedureLogin = null;
                    clientProcedureLogin = clientSaleBo.findLogin(username, password);
                    if (clientProcedureLogin != null) {
                        state = clientProcedureLogin.getState();
                        cid = clientProcedureLogin.getClientId();
                        agreement = clientProcedureLogin.getAgreement();
                        mverified = clientProcedureLogin.getMailVerified();
                        promotion = clientProcedureLogin.getPromotion();
                        promotionibk = clientProcedureLogin.getPromotionibk();
                        LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " Mode=" + mode);
                        if (state == 1) {
                            mode = Integer.parseInt(clientProcedureLogin.getMode());
                            if (mode == 0) {
                                UserBean userBean = new UserBean();
                                userBean.setpSessionid(clientProcedureLogin.getSessionId());
                                userBean.setpUser(username);
                                userBean.setpClientid(clientProcedureLogin.getClientId());
                                userBean.setpStatus(clientProcedureLogin.getStatus());
                                userBean.setpMode(Integer.parseInt(clientProcedureLogin.getMode()));
                                clientProcedureGetClient = clientSaleBo.findClient(clientProcedureLogin.getSessionId(), clientProcedureLogin.getClientId());
                                dataClient = clientSaleBo.findGetDataClient(clientProcedureLogin.getSessionId(), clientProcedureLogin.getClientId());
                                userBean.setpNombre(clientProcedureGetClient.getNombre());
                                userBean.setpMonto(clientProcedureGetClient.getAmount());
                                userBean.setpGame(Game.INSTANT);
                                userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
                                userBean.setpAgreement(agreement);
                                userBean.setpMailVerified(mverified);
                                userBean.setpPromotion(promotion);
                                userBean.setpPromotionibk(promotionibk);
                                session.setAttribute(Constants.USR_SESION, userBean);
                                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                                sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                                RapitinkasProcedureBetData rapitinkasProcedureBetData = rapitinkasBo.findByClientId(idClient);
                                Double monto1 = 0.0, monto2 = 0.0;
                                if (rapitinkasProcedureBetData != null) {
                                    monto1 = rapitinkasProcedureBetData.getBalanceAmount();
                                    monto2 = rapitinkasProcedureBetData.getBalanceAmountGame();
                                }
                                if(agreement==null || agreement.trim().equals("")){
                                	respuesta_ajax = "TC|Por favor inf&oacute;rmese y confirme la aceptaci&oacute;n de los T&eacute;rminos y Condiciones.";
                                } else if(mverified!=null && !mverified.equals("S") && !mverified.equals("E") && !mverified.equals("P")) {
                                	if(mverified.equals("P")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/>Confirma que tu correo est&aacute; correctamente registrado o actual&iacute;zalo aqu&iacute;. Luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	if(mverified.equals("N")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico en tu cuenta, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	//if(mverified.equals("E")) respuesta_ajax = "MV|Hola, hemos verificado que no se ha enviado la confirmación al correo electr&oacute;nico de la cuenta <b>"+username+"</b>.<br/><br/>Reenvia aqu&iacute; un nuevo correo electr&oacute;nico, luego revisa tu correo, te enviaremos una nueva solicitud para que actives tu cuenta.";
                                } else if(promotionibk!=null && !promotionibk.equals("")){
                                	respuesta_ajax = "IB|"+promotionibk;
                                } else if(promotion!=null && !promotion.equals("")){
                                	respuesta_ajax = "RD|"+promotion;
                                } else {
	                                if (dataClient != null)
	                                    respuesta_ajax = "OK|" + clientProcedureGetClient.getNombre() + "|" + clientProcedureGetClient.getAmount() + "|" + idClient + "|" + monto1
	                                            + "|" + monto2 + "|" + clientProcedureLogin.getLuckyIcon() + "|" + dataClient.getNombre() + "|" + dataClient.getApPaterno() + "|"
	                                            + dataClient.getApMaterno() + "|" + dataClient.getMail() + "|" + dataClient.getMobilePhone() + "|" + dataClient.getCountry() + "|"
	                                            + dataClient.getRegion() + "|" + dataClient.getAddress() + "|" + dataClient.getTypeId() + "|" + dataClient.getNumberId() + "|"
	                                            + dataClient.getControlAmount() + "|" + dataClient.getMail() + "|" + dataClient.getClientId() + "|" + sessionId;
	                                request.setAttribute("clientSale", clientProcedureGetClient);
                                }
                            } else if (mode > 0)
                                respuesta_ajax = "Con esta cuenta no es posible ingresar a este sistema.";
                        } else if (state == 2)
                            respuesta_ajax = "CC|El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado";
                        else if (state == 3)
                            respuesta_ajax = "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado";
                        else if (state == -1)
                            respuesta_ajax = "Este usuario ha sido bloqueado, comun&iacute;quese a Intralot de Per&uacute;";
                        else
                            respuesta_ajax = "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado";
                    }
                    //out.print(respuesta_ajax);
                } else {
                	respuesta_ajax = "CC|Ingresa el texto de la imagen correctamente.";
                }
                out.print(respuesta_ajax);
                LoggerApi.Log.info("cid=" + cid + " respuesta_ajax=" + respuesta_ajax);
                LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " Mode=" + mode);
            }
        } catch (Exception e) {
            respuesta_ajax = "Sucedio un error al iniciar sesi&oacute;n";
            out.print(respuesta_ajax);
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info("Nombre=" + clientProcedureGetClient.getNombre() + " Amount=" + clientProcedureGetClient.getAmount());
        }
    }*/

    @RequestMapping(value = "/play_rapitinkas_user")
    public void findPrizeRapitinkas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        String gname = request.getParameter("name");
        String gameFaceTicket = "_";
        String gameFaceScratch = "_";
        Integer gameEdition = 0;
        Integer gameSubEdition = 0;
        String gameName = "_";
        String gameTrimName = "_";
        String gameInstruction = "_";
        String gamePrize = "_";
        Integer gameIndex = 0;
        Integer ticketBook = 0;
        Integer ticketNumber = 0;
        String prizeIconsList = "_";
        Integer prizeLevel = 0;
        Double prizeNet = 0.0;
        Double prizeGross = 0.0;
        Double prizePrinted = 0.0;
        String messageResult = "_";
        Double amoountNew = 0.0;
        String clientIp = "_";
        String name_ = null;
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            double availableBalance = 0;
            PrintWriter out = null;
            out = response.getWriter();
            String stateportal = gname;
            int clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            int sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid(); 
            LoggerApi.Log.info("cid=" + clientId + " sessionId=" + sessionId);
            if (gname != null) {
                String name[] = gname.split("_");
                Object[] outCadenas = SalesGameDispatcher.getGameNameToIdInstantaneas(name[0]);
                gameEdition = Integer.parseInt(outCadenas[0].toString());
                gameSubEdition = Integer.parseInt(outCadenas[1].toString());
                gameTrimName = outCadenas[2].toString();
                gameInstruction = outCadenas[3].toString();
                gamePrize = outCadenas[4].toString();
                gameName = outCadenas[5].toString();
                gameIndex = Integer.parseInt(name[1].toString());
                LoggerApi.Log.info("cid=" + clientId + " gameEdition=" + gameEdition + " gameSubEdition=" + gameSubEdition + " gameIndex=" + gameIndex);
            }
            Object[] outCadenas = SalesDispatcher.getClientRegisterById(String.valueOf(sessionId), String.valueOf(clientId));
            if (outCadenas[0] != null)
                name_ = outCadenas[0].toString();
            LoggerApi.Log.info("cid=" + clientId + " name_=" + name_);
            clientIp = request.getRemoteAddr();
            String dataConcatTicket = SalesGameDispatcher.getRandomAndUpdateByTicketInstantaneas(String.valueOf(clientId), gameEdition, gameSubEdition, gameIndex, clientIp);
            String[] arrayResultGame = new String[10];
            arrayResultGame = StringUtils.split(dataConcatTicket, "||");
            ticketBook = new Integer(arrayResultGame[0].trim());
            ticketNumber = new Integer(arrayResultGame[1].trim());
            prizeIconsList = arrayResultGame[2].trim();
            LoggerApi.Log.info("cid=" + clientId + " ticketBook=" + ticketBook );
            // verificar prizeLevel >=1 ganaste premio
            prizeLevel = new Integer(arrayResultGame[3].trim());
            prizeNet = new Double(arrayResultGame[4].trim());
            prizeGross = new Double(arrayResultGame[5].trim());
            prizePrinted = new Double(arrayResultGame[6].trim());
            // ticketSaleDate = arrayResultGame[7].trim();
            amoountNew = new Double(arrayResultGame[8].trim());
            messageResult = arrayResultGame[9].trim();
            GameBean gamebean = new GameBean();           
            LoggerApi.Log.info("cid=" + clientId + " messageResult=" + messageResult);
            if (messageResult.equals("OK")) {
                // Cargar los datos de Ticket
                // gameEdition + "||" + ticketBook + "||" + ticketNumber
                gameFaceTicket = gameEdition + "||" + ticketBook + "||" + ticketNumber + "||" + gameInstruction + "||" + gamePrize;
                gamebean.setGameFaceTicket(gameFaceTicket);
                // Cargar los datos del Flash
                gameFaceScratch = gameTrimName + "||" + gameIndex + "||" + prizeIconsList + "||" + prizeLevel + "||" + prizeNet + "||" + prizeGross + "||" + prizePrinted
                        + "||" + gameName;
                gamebean.setGameFaceScratch(gameFaceScratch);
                // Cargar el Nombre y Saldo del Usuario
                gamebean.setName(name_);
                gamebean.setAmount(amoountNew);
                gamebean.setStateportal(stateportal);
                // Enviar el estado 0 de la imagen raspada hacia el flash
                gamebean.setGameStateImageFlash("1");
                availableBalance = gamebean.getAmount();
                userBean.setpMonto(availableBalance);
                session.setAttribute(Constants.USR_SESION, userBean);
                out.print(gamebean.getGameFaceTicket() + "**" + gamebean.getGameFaceScratch() + "**" + gamebean.getName() + "**" + gamebean.getAmount() + "**"
                        + gamebean.getStateportal() + "**" + gamebean.getGameStateImageFlash());
            } else
                out.print(messageResult);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/pay_rapitinkas_user")
    public void findPayRapitinkas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        String clientIp = "_";
        double amount = 0.0;
        Integer editionId = 0;
        Integer prizeBook = 0;
        Integer prizeNum = 0;
        try {
            clientIp = request.getRemoteAddr();
            PrintWriter out = null;
            out = response.getWriter();
            amount = Double.parseDouble(request.getParameter("amount"));
            editionId = Integer.parseInt(request.getParameter("editionId"));
            prizeBook = Integer.parseInt(request.getParameter("prizeBook"));
            prizeNum = Integer.parseInt(request.getParameter("prizeNum"));
            int clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            int sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
            int gameid = Game.INSTANT;
            // controller.setClientPrizeToLoadBalance(gameEdition, ticketBook,
            // ticketNumber);
            Game game = new Game();
            game.setGame(gameid);
            Client client = BussinessSaleDispatcher.getClientByClientId(String.valueOf(clientId));
            WEBMessage web = new WEBMessage();
            web.setClient(client);
            web.setIp(clientIp);
            DateAPI d = new DateAPI();
            web.setMessageId("W" + d.getTimeLong());
            web.setGame(game);
            ClientBalance clientBalance = SalesGameDispatcher.payTicketWinnerByWebTransactionLotosInstantaneas(client, web, game, amount, editionId, prizeBook, prizeNum);
            out.print(clientBalance.getLoadAmount() + "||" + clientBalance.getNewAmount() + "||" + clientBalance.getPrevAmount());
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
    }

    @RequestMapping(value = "/verifyByTicket")
    public void DataVerifyByTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Integer editionId = 0;
        Integer prizeBook = 0;
        Integer prizeNum = 0;
        String msg = "";
        Double prizeAmount = 0.0;
        try {
            PrintWriter out = null;
            out = response.getWriter();
            int clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            String idTicket = request.getParameter("parameterId");
            int gameId = Integer.parseInt(request.getParameter("gameId"));
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, Long.parseLong(idTicket));
            // session.getAttribute("gticket").toString();
            // Integer prizeLevel =
            // Integer.parseInt(session.getAttribute("prize").toString());
            editionId = Integer.parseInt(idTicket.substring(0, 3));
            prizeBook = Integer.parseInt(idTicket.substring(3, 9));
            prizeNum = Integer.parseInt(idTicket.substring(9, 12));
            SalesGameDispatcher.setClientPrizeToVerifyTicketInstantaneas(editionId, prizeBook, prizeNum);
            if (ticketProcedureGetClientTicket.getCtTwPrizeAmount() != null)
                prizeAmount = ticketProcedureGetClientTicket.getCtTwPrizeAmount();
            if (prizeAmount <= 0)
                msg = "No obtuvo premio " + prizeAmount;
            if (prizeAmount > 0)
                msg = "Tiene un premio de S/. " + prizeAmount + " revisar MIS PREMIOS.";
            out.print(msg);
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
        }
        // ticketsale.getClientTicket usar p_twprizeamount
        // SalesGameDispatcher.setClientPrizeToVerifyTicketInstantaneas(
        // editionId, prizeBook, prizeNum )
        // c- mensajes.
        // 1. Si no tiene premio: "No tuvo premio" p_twprizeamount<=0 o nulo
        // 2. Si tiene premio: "Tiene un premio de S/...., revisar MIS PREMIOS"
        // p_twprizeamount >0
    }
    /*
     * @RequestMapping(value = "/ajaxInstantaneas") public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception { HttpSession session =
     * request.getSession(); try { PrintWriter out = null; out = response.getWriter(); String data = String.valueOf(request.getParameter("dato")); String[] boletos = (data + "").split("-"); String[]
     * item_array = null; String[] o = null; int gameId = Game.GANAGOL; Game gm = new Game(gameId); String name_game = gm.getName(); String ip = ""; String clientId = String.valueOf(((UserBean)
     * session.getAttribute(Constants.USR_SESION)).getpClientid()); String jugadas = ""; for (String boleto : boletos) { String juego = ""; item_array = (boleto + "").split("\\|"); for (int j = 0; j
     * <= 3; j++) { if ((item_array[j].trim()).equals("00") == false) { juego += "|"; juego += item_array[j]; } } String temp_game = ""; temp_game = juego.replace("0", ""); temp_game =
     * temp_game.replace("1", ""); temp_game = temp_game.replace("2", ""); temp_game = temp_game.replace("3", ""); temp_game = temp_game.replace("4", ""); temp_game = temp_game.replace("5", "");
     * temp_game = temp_game.replace("6", ""); temp_game = temp_game.replace("7", ""); temp_game = temp_game.replace("8", ""); temp_game = temp_game.replace("9", ""); juego = juego.substring(1,
     * juego.length()); temp_game = temp_game.substring(1, temp_game.length()); int multiDraws = 1; double price = Double.parseDouble(item_array[4]); o = GameSaleDispatcher.playCouponByWeb(clientId,
     * ip, gameId, temp_game, multiDraws, price, null, ""); String message = o[0]; String id = o[1]; double s_disponible = Double.parseDouble(o[3]); double s_promocional = Double.parseDouble(o[4]);
     * juego += "&" + price + "&" + message + "&" + id + "&" + s_disponible + "&" + s_promocional + "&" + name_game + "&" + gameId; (juego); jugadas += juego + "\n#"; } jugadas = jugadas.substring(0,
     * jugadas.length() - 1); out.print(jugadas); } catch (Exception e) { e.printStackTrace(); throw new Exception(e); } finally { } }
     */

    @RequestMapping(value = "/lista-rapitinkas")
    public String listaRapitinkas(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
           return "game/rapitinkas/home_rapitinkas_web";
    }
}
