package pe.com.intralot.loto.layer.controller.game.super3;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureDrawData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.super3.bo.Super3Bo;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicket;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.Super3cotejadorUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class Super3Controller {

    @Autowired
    private Super3Bo super3Bo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private DrawBo drawBo;

    @RequestMapping(value = "/juega-super3")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        ClientProcedureGetDataClient dataClient = null;
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
                // Validamos que la session y el redireccionamiento a la pagina
                // principal
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
            }
            List<Super3ProcedureDrawData> super3SaleList = super3Bo.findListDraw();
            modelList.put("super3SaleList", super3SaleList);
            Super3ProcedureBetData super3SaleBean = super3Bo.findByClientId(idClient);
            request.setAttribute("super3SaleBean", super3SaleBean);
            userBean.setpGame(Game.SUPER3);
            session.setAttribute(Constants.USR_SESION, userBean);
            return "game/super3/home_super3_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/super3/home_super3_user";
        } finally {
            request.setAttribute("isAllowed", super3Bo.isAllowedGoIn(user));
        }
    }

    /*@RequestMapping(value = "/login_super3")
    public void loginByUserPass(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Integer idClient = 0, sessionId = 0;
        String username = "", password = "", capchaCode="";
        PrintWriter out = null;
        out = response.getWriter();
        String respuesta_ajax = "";
        HttpSession session = request.getSession();
        ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        ClientProcedureGetDataClient dataClient = null;
        int mode = -1;
        Integer cid = 0;
        int captcha = 0;
        int state = 0;
        String agreement = "", mverified = "", promotion= "", promotionibk= "";
        try {
        	if(request.getParameter("captcha-client") == null) {
        		LoggerApi.Log.info("Entro a Super3Controller loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a Super3Controller loginByUserPass con captcha");
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
                                userBean.setpGame(Game.SUPER3);
                                userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
                                userBean.setpAgreement(agreement);
                                userBean.setpMailVerified(mverified);
                                userBean.setpPromotion(promotion);
                                userBean.setpPromotionibk(promotionibk);
                                session.setAttribute(Constants.USR_SESION, userBean);
                                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                                sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                                Super3ProcedureBetData super3ProcedureBetDataBean = super3Bo.findByClientId(idClient);
                                Double monto1 = super3ProcedureBetDataBean.getBalanceAmount();
                                Double monto2 = super3ProcedureBetDataBean.getBalanceAmountGame();
                                if(agreement==null || agreement.trim().equals("")){
                                	respuesta_ajax = "TC|Por favor inf&oacute;rmese y confirme la aceptaci&oacute;n de los T&eacute;rminos y Condiciones.";
                                } else if(mverified!=null && !mverified.equals("S") && !mverified.equals("E") && !mverified.equals("P")) {
                                	if(mverified.equals("P")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/>Confirma que tu correo est&aacute; correctamente registrado o actual&iacute;zalo aqu&iacute;. Luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	if(mverified.equals("N")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico en tu cuenta, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	//if(mverified.equals("E")) respuesta_ajax = "MV|Hola, hemos verificado que no se ha enviado la confirmación al correo electr&oacute;nico de la cuenta <b>"+username+"</b>.<br/><br/>Reenvia aqu&iacute; un nuevo correo electr&oacute;nico, luego revisa tu correo, te enviaremos una nueva solicitud para que actives tu cuenta.";
                                } else {
	                                respuesta_ajax = "OK|" + username + "|" + clientProcedureGetClient.getAmount() + "|" + idClient + "|" + monto1
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
                    } else
                        respuesta_ajax = "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado";
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

    @RequestMapping(value = "/ajaxJugadasSuper3")
    public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            double availableBalance = 0;
            PrintWriter out = null;
            out = response.getWriter();
            String data = "";
            if (request.getParameter("dato") != null)
                data = String.valueOf(request.getParameter("dato"));
            String[] boletos = (data + "").split("-");
            String[] item_array = null;
            String jugadas = "";
            String array_total = "";
            String[] o = null;
            int gameId = Game.SUPER3;
            Game gm = new Game(gameId);
            String name_game = gm.getName();
            String ip = "";
            String clientId = "";
            if (session.getAttribute(Constants.USR_SESION) != null)
                clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());// Integer.parseInt(request.getParameter("clienIdClient"));
            int multiDraws = 0;
            double price = 0;
            int num_row = 1;
            for (String boleto : boletos) {
                String play = "";
                item_array = (boleto + "").split("\\|");
                if (item_array[0].trim().equals("null"))
                    play = item_array[1].trim();
                else if (item_array[1].trim().equals("null"))
                    play = item_array[0].trim();
                else
                    play = item_array[0].trim() + " | " + item_array[1].trim();
                multiDraws = Integer.parseInt(item_array[3].trim());
                price = Double.parseDouble(item_array[4].trim());
                ip = request.getRemoteAddr().toString();
                o = GameSaleDispatcher.playCouponByWeb(clientId, ip, gameId, play, multiDraws, price, null, null);
                jugadas = item_array[0].trim() + " | " + item_array[1].trim();
                if (o != null) {
                    jugadas += "|" + o[0] + "&" + o[1];
                    // jugadas + cantidad_sorteo + price +
                    array_total += jugadas + "|" + multiDraws + "|" + price + "|" + num_row + "|" + name_game + "|" + gameId + "|" + o[3] + "|" + o[4] + "#";
                    num_row++;// ID DE LAS FILAS POSICION #7
                    jugadas = "";
                    availableBalance = Double.parseDouble(o[3]);
                }
            }
            array_total = array_total.substring(0, array_total.length() - 1);
            userBean.setpMonto(availableBalance);
            session.setAttribute(Constants.USR_SESION, userBean);
            out.print(array_total);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
        }
        // o[0]-->mensaje
        // o[1]-->idticket
        // o[2]-->precio generado
        // o[3]-->saldo promocional
        // o[4]-->saldo disponible
    }

    @RequestMapping(value = "/ticket_vista_previa_popup_super3")
    public ModelAndView ticket_vista_previa_popup_super3(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Long ticketId = 0L;
        int drawId = 0, gameID = 0, clientId = 0;
        JsonArray jugadaCompleta = new JsonArray();
        JsonObject datos_jugada = new JsonObject();
        Super3cotejadorUtil fechaza = new Super3cotejadorUtil();
        fechaza.reinicioValores();
        try {
            HttpSession session = request.getSession();
            ticketId = Long.parseLong(request.getParameter("ticketId"));
            gameID = Integer.parseInt(request.getParameter("gameId"));
            ClientTicket ticket = clientTicketBo.findById(ticketId);
            clientId = Integer.parseInt(ticket.getCtClientId());
            int from = ticket.getCtFromDraw();
            int to = ticket.getCtToDraw();
            datos_jugada.add("datos_jugada", super3Bo.datosJugada(from, to, gameID, ticketId));
            datos_jugada.add("resultado_jugada", super3Bo.resultado_premios(clientId, gameID, ticketId));
            datos_jugada.add("premio_tot", super3Bo.premio_total(clientId, gameID, ticketId));
            jugadaCompleta.add(datos_jugada);
            LoggerApi.Log.info("ARRAY_COTEJO :  " + jugadaCompleta.toString());
            request.setAttribute("jugadaCompleta", jugadaCompleta);
            return new ModelAndView("game/super3/supertres_popup_cotejo");
        } catch (Exception e) {
            LoggerApi.severe(e);
            LoggerApi.Log.info("Error : Super 3 - " + e.getMessage());
            return new ModelAndView("game/super3/supertres_popup_cotejo");
        } finally {
        }
    }

    @RequestMapping(value = "/payAwardMoneySuper3")
    public void payAwardMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String message = "";
        String tId = "";
        try {
            WEBMessage web = new WEBMessage();
            boolean desist = false;
            boolean credit = true;
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            String barCode = StringLib.decodeLabel(session.getAttribute("ticketNumber").toString());
            PrintWriter out = null;
            out = response.getWriter();
            int ticketType = 1;
            // String play = "1 2 3 4 5 6";
            int gameId = Game.SUPER3;
            Game game = new Game(gameId);
            String name_game = game.getName();
            String ip = "";
            Client client = new Client();
            String clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());// Integer.parseInt(request.getParameter("clienIdClient"));
            client = BussinessSaleDispatcher.getClientByClientId(clientId);
            web.setClient(client);
            web.setIp(ip);
            DateAPI d = new DateAPI();
            web.setMessageId("W" + d.getTimeLong());
            web.setGame(game);
            WEBTicketPay webTicketPay = new WEBTicketPay();
            //
            //
            WEBTicketPay wtp = GameSaleDispatcher.payTicketWinnerByWebTransaction(client, web, game, barCode, webTicketPay, desist, credit);
            //
            //
            int gratis = 0, mitadPrecio = 0;
            if (wtp.getMessage() != null) {
                message = wtp.getMessage();
                if (message.equals("OK")) {
                    if (wtp.getClientTicketExchange() != null)
                        tId = wtp.getClientTicketExchange().getTicketId();
                    if (wtp.getWebTickets() != null)
                        for (WEBTicket webTicket : wtp.getWebTickets())
                            // ES GRATIS caso contrario es 2x1
                            if (webTicket.getClientTicket() != null)
                                if (webTicket.getClientTicket().getReceiptAmount() == 0.0)
                                    // wtp.getClientTicket().getTicketId();
                                    gratis++;
                                else
                                    mitadPrecio++;
                }
                userBean.setpMonto(wtp.getBalanceAmount());
                LoggerApi.Log.info(message + ";" + wtp.getLoadAmount() + ";" + wtp.getBalanceAmount() + ";" + tId);
            }
            session.setAttribute(Constants.USR_SESION, userBean);
            out.print(message + ";" + wtp.getLoadAmount() + ";" + wtp.getBalanceAmount() + ";" + tId + ";" + gratis + ";" + mitadPrecio);
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, message);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/Super3_cotejador_jugada")
    public ModelAndView kabalaCotejoJugada(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        try {
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                idSession = userBean.getpSessionid();
                idClient = userBean.getpClientid();
                user = userBean.getpUser();
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                // Validamos que la session y el redireccionamiento a la pagina
                // principal
            }
            Super3ProcedureBetData Super3ProcedureBetDataBean = super3Bo.findByClientId(idClient);
            /*List<KabalaProcedureDrawData> kabalaProcedureDrawDataList = kabalaBo.findListDraw();
            modelList.put("kabalaSaleList", kabalaProcedureDrawDataList);*/
            List<Draw> kabalaProcedureDrawDataList = drawBo.findByDrawListByGameId(Game.KABALA, 180);
            modelList.put("super3SaleList", kabalaProcedureDrawDataList);
            ArrayList boletoValido = new ArrayList();
            boletoValido = super3Bo.valoresBoleto();
            modelList.put("super3ValoresBoleto", boletoValido);
            Super3ProcedureBetDataBean.setCloseDate(super3Bo.DateFormat(Super3ProcedureBetDataBean.getCloseDate()));
            request.setAttribute("super3Sale", Super3ProcedureBetDataBean);
            userBean.setpGame(Game.SUPER3);
            session.setAttribute(Constants.USR_SESION, userBean);
            return new ModelAndView("game/super3/super3_cotejo_jugada");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            request.setAttribute("isAllowed", super3Bo.isAllowedGoIn(user));
        }
    }
}
