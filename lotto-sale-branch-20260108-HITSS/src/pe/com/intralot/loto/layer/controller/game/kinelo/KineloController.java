package pe.com.intralot.loto.layer.controller.game.kinelo;

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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KineloProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.game.kinelo.bo.KineloBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;

/**
 * <p>
 * NOMBRE: KineloController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Kinelo
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Límite montos mínimos y maximos de recarga parametrizado
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class KineloController {

    @Autowired
    private KineloBo kineloBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private TicketSaleBo TicketBo;
    /*@Autowired
    private ProvinceBo ProvinceBo;
    @Autowired
    private DrawBo drawBo;*/

    @RequestMapping(value = "/juega-kinelo")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        String context = Constants.contextCardWeb;
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
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
                userBean.setpGame(Game.KINELO);
                if (clientProcedureGetClient!=null && clientProcedureGetClient.getAmount()!=null) {
                    userBean.setpMonto(clientProcedureGetClient.getAmount());
                }
                
                ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
				clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
				String result = new Gson().toJson(clientProcedureAccountData);
				session.setAttribute("clientBalance", result);
				
                session.setAttribute(Constants.USR_SESION, userBean);
            }
            /*
             * Draw d =drawBo.findByIdByGameId(5474, 2168); System.out.print("drDate"+d.getDrDate());
             */
            /*
             * List<Draw> d=drawBo.findByDrawListByGameId(42, 10); for (Draw dr : d){ System.out.print("gameId"+dr.getId().getGameId()+"drDate"+dr.getDrDate()); }
             */
            List<KineloProcedureDrawData> kineloSaleList = kineloBo.findListDrawData();
            modelList.put("kineloSaleList", kineloSaleList);
            KineloProcedureBetData kineSaleBean = kineloBo.findByClientId(idClient);
            if(kineSaleBean.getBalanceAmount()!=null)kineSaleBean.setBalanceBill01(ClientUtils.formatCurrency(kineSaleBean.getBalanceAmount()));
            /*if(session.getAttribute("clientBalance") != null && !session.getAttribute("clientBalance").toString().trim().equals("")) {
            	JsonElement je= new JsonParser().parse(session.getAttribute("clientBalance").toString().trim());
            	JsonObject jo = je.getAsJsonObject();
            	if(jo.get("welcomeBonusMessage")!=null && !jo.get("welcomeBonusMessage").toString().trim().equals("")) kineSaleBean.setWelcomeBonusMessage(jo.get("welcomeBonusMessage").toString().trim());
            	else kineSaleBean.setWelcomeBonusMessage("");
            	if(jo.get("welcomeBonusStatus")!=null && jo.get("welcomeBonusStatus").toString().trim().equals("Reciente")) kineSaleBean.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+jo.get("welcomeBonusPercentaje").toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
            	else kineSaleBean.setWelcomeBonusMessagePor("");
            }*/
            request.setAttribute("kineloSale", kineSaleBean);
            
            request.setAttribute("isAllowed", kineloBo.isAllowedGoIn(user));
            JsonObject joDataClient = new JsonObject();
			joDataClient.addProperty("bcpMaxAmount", (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim():"10000");
            joDataClient.addProperty("bcpMinAmount", (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim():"50");
            joDataClient.addProperty("pefeMaxAmount", (ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim():"3000");
            joDataClient.addProperty("pefeMinAmount", (ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim():"40");
            joDataClient.addProperty("sfpyMaxAmount", (ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim():"3000");
            joDataClient.addProperty("sfpyMinAmount", (ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim():"40");
            request.setAttribute("chargeData", joDataClient);
            return "game/kinelo/home_kinelo_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/kinelo/home_kinelo_user";
        } finally {
            LoggerApi.Log.info("idClient:=" + idClient + " idSession:=" + idSession);
        }
    }

    /*@RequestMapping(value = "/login_kinelo")
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
        String agreement = "", mverified = "", phoneverified="", promotion= "", promotionibk= "";
        String authToken = "0";
        String channel = "1";
        
        try {
        	if(request.getParameter("captcha-client") == null) {
        		LoggerApi.Log.info("Entro a KineloController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a KineloController loginByUserPass con captcha");
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
                        phoneverified = clientProcedureLogin.getMobileStatus();
                        promotion = clientProcedureLogin.getPromotion();
                        promotionibk = clientProcedureLogin.getPromotionibk();
                        if (state == 1) {
                            mode = Integer.parseInt(clientProcedureLogin.getMode());
                            LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " Mode=" + mode);
                            if (mode == 0) {
                                UserBean userBean = new UserBean();
                                userBean.setpSessionid(clientProcedureLogin.getSessionId());
                                userBean.setpUser(username);
                                userBean.setpClientid(clientProcedureLogin.getClientId());
                                userBean.setpMail(clientProcedureLogin.getMail());
                                userBean.setpStatus(clientProcedureLogin.getStatus());
                                userBean.setpMode(Integer.parseInt(clientProcedureLogin.getMode()));
                                clientProcedureGetClient = clientSaleBo.findClient(clientProcedureLogin.getSessionId(), clientProcedureLogin.getClientId());
                                dataClient = clientSaleBo.findGetDataClient(clientProcedureLogin.getSessionId(), clientProcedureLogin.getClientId());
                                userBean.setpNombre(clientProcedureGetClient.getNombre());
                                userBean.setpMonto(clientProcedureGetClient.getAmount());
                                userBean.setpGame(Game.KINELO);
                                userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
                                userBean.setpAgreement(agreement);
                                userBean.setpMailVerified(mverified);
                                userBean.setpMobilePhone(clientProcedureLogin.getMobilePhone());
                      	        userBean.setpMobileStatus(clientProcedureLogin.getMobileStatus());
                      	        userBean.setpPromotion(promotion);
                      	        userBean.setpPromotionibk(promotionibk);
                                Double monto1=0.00,monto2=0.00;
                              
                                if(agreement==null || agreement.trim().equals("")){
                                	respuesta_ajax = "TC|Por favor inf&oacute;rmese y confirme la aceptaci&oacute;n de los T&eacute;rminos y Condiciones.";
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                	
                                } else if(mverified!=null && !mverified.equals("S") && !mverified.equals("E") && !mverified.equals("P")) {
                                	if(mverified.equals("P")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/>Confirma que tu correo est&aacute; correctamente registrado o actual&iacute;zalo aqu&iacute;. Luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	if(mverified.equals("N")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado en otra cuenta.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico.";
                                	//if(mverified.equals("N")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico en tu cuenta, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	failedBean.setpNombre(userBean.getpNombre());
                                	failedBean.setpMail(userBean.getpMail());
                                	failedBean.setpStatus(mverified);
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                	
                                //} else if (false) {//phoneverified.equals("DES") || !ClientUtils.verifySintaxMobilePhone(clientProcedureLogin.getMobilePhone().toString().trim())) {
                                } else if (Constants.flagValidacionSms.equals("true") && ((phoneverified.equals("DES") || !ClientUtils.verifySintaxMobilePhone(clientProcedureLogin.getMobilePhone().toString().trim())))) {
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	failedBean.setpNombre(userBean.getpNombre());
                                	failedBean.setpMobilePhone(userBean.getpMobilePhone());
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                	
                                	//respuesta_ajax = "AC|<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span>Hemos verificado que el tel&eacute;fono registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/><span id='sms-message'>Ingresa tu tel&eacute;fono registrado o actual&iacute;za uno nuevo aqu&iacute;, para enviarte el SMS de activaci&oacute;n de cuenta.</span>";
                                	respuesta_ajax = "AC|<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span>Ingresa el celular registrado en tu cuenta (Ejm: 999112233) o actual&iacute;zalo aqu&iacute;.<br/>Recibir&aacute;s un SMS con un c&oacute;digo de activaci&oacute;n.";
                                } else if(promotionibk!=null && !promotionibk.equals("")){
                                	respuesta_ajax = "IB|"+promotionibk;
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                } else if(promotion!=null && !promotion.equals("")){
                                	respuesta_ajax = "RD|"+promotion;
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                	
                                } else {
                                	ClientProcedureTokenGeneration tokenGeneration = clientSaleBo.getToken(userBean.getpClientid(), channel, request.getRemoteAddr());
                                    if (tokenGeneration!=null && tokenGeneration.getMessage().equals("OK")) {
                                        authToken = tokenGeneration.getIflexToken();
                                        userBean.setpToken(authToken);
                                    }
                                    session.setAttribute(Constants.USR_SESION, userBean);
                                    KineloProcedureBetData kineloProcedureBetDataBean = kineloBo.findByClientId(userBean.getpClientid());
                                    monto1 = kineloProcedureBetDataBean.getBalanceAmount();
                                    monto2 = kineloProcedureBetDataBean.getBalanceAmountGame();
                                    
	                                respuesta_ajax = "OK|" + username + "|" + clientProcedureGetClient.getAmount() + "|" + idClient + "|" + monto1
	                                        + "|" + monto2 + "|" + clientProcedureLogin.getLuckyIcon() + "|" + dataClient.getNombre() + "|" + dataClient.getApPaterno() + "|"
	                                        + dataClient.getApMaterno() + "|" + dataClient.getMail() + "|" + dataClient.getMobilePhone() + "|" + dataClient.getCountry() + "|"
	                                        + dataClient.getRegion() + "|" + dataClient.getAddress() + "|" + dataClient.getTypeId() + "|" + dataClient.getNumberId() + "|"
	                                        + dataClient.getControlAmount() + "|" + dataClient.getMail() + "|" + dataClient.getClientId() + "|" + sessionId + "|" + kineloProcedureBetDataBean.getOtherAmount();
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
                    //System.out.println("RESPUESTA AJAX:" + respuesta_ajax);
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

    @RequestMapping(value = "/ajaxJugadasKinelo")
    public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            KineloProcedureBetData kineSaleBean = new KineloProcedureBetData();
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
            int gameId = Game.KINELO;
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
                o = GameSaleLotos5Dispatcher.playCouponByWeb(clientId, ip, gameId, play, multiDraws, 0, "", 0, price, null, null);
                kineSaleBean = kineloBo.findByClientId(Integer.parseInt(clientId));
                jugadas = item_array[0].trim() + " | " + item_array[1].trim();
                if (o != null) {
                    jugadas += "|" + o[0] + "&" + o[1];
                    // jugadas + cantidad_sorteo + price +
                    array_total += jugadas + "|" + multiDraws + "|" + price + "|" + num_row + "|" + name_game + "|" + gameId + "|" + o[3] + "|" + o[4] + "|" + kineSaleBean.getBalanceQuantityGame() + "|" + kineSaleBean.getOtherQuantity() + "#";
                    num_row++;// ID DE LAS FILAS POSICION #7
                    jugadas = "";
                    availableBalance = Double.parseDouble(o[3]);
                }
            }
            array_total = array_total.substring(0, array_total.length() - 1);
            userBean.setpMonto(availableBalance);
            userBean.setpBilletera3(ClientUtils.formatCurrency(Double.parseDouble(kineSaleBean.getOtherAmount().replaceAll(",","."))));
            userBean.setpBilletera3Cant(kineSaleBean.getOtherQuantity());
            session.setAttribute(Constants.USR_SESION, userBean);
            out.print(array_total);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
        // o[0]-->mensaje
        // o[1]-->idticket
        // o[2]-->precio generado
        // o[3]-->Saldo disponible
        // o[4]-->Saldo promocional
    }

    @RequestMapping(value = "/prize_table_kinelo")
    public ModelAndView findPrizeTableKinelo(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/kinelo/prize_table_kinelo");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/prize_table_kinelo");
        } finally {
        }
    }

    @RequestMapping(value = "/ticket_vista_previa_popup_kinelo")
    public ModelAndView ticket_vista_previa_popup_kinelo(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Long ticketId = 0L;
        int drawId = 0, gameID = 0, clientid = 0;
        String ctbM1 = "", ctbM2 = "";
        try {
            LoggerApi.Log.info("cid=" + request.getParameter("clientid") + " p_gameid=" + request.getParameter("gameid") + " ticketId=" + request.getParameter("ticketid"));
            ArrayList resulta_jugada = new ArrayList();
            ticketId = Long.parseLong(request.getParameter("ticketid"));
            gameID = Integer.parseInt(request.getParameter("gameid"));
            clientid = Integer.parseInt(request.getParameter("clientid"));
            TicketProcedureGetClientTicket ticket_client = TicketBo.findByClientTicket(clientid, gameID, ticketId);
            ctbM1 = " " + ticket_client.getCtBetMatrix1() + " ";
            ctbM2 = " " + ticket_client.getCtBetMatrix2() + " ";
            resulta_jugada = kineloBo.cotejadoKinelo(clientid, gameID, ticketId);
            /**/
            objectModelMap.put("juego", " KINELO ");
            objectModelMap.put("ctbm1", ctbM1.length());
            objectModelMap.put("ctbm2", ctbM2.length());
            objectModelMap.put("ListJugada", resulta_jugada);
            /* return new ModelAndView("game/kinelo/kinelo_popup_cotejo"); */
            return new ModelAndView("game/kinelo/kinelo_popup_cotejo");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/kinelo_popup_cotejo");
            /* return new ModelAndView("game/kinelo/kinelo_popup_cotejo"); */
        } finally {
        }
    }
}
