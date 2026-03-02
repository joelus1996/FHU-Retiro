package pe.com.intralot.loto.layer.controller.game.ganadiario;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.card.setup.MailingForSale;
import pe.com.intralot.loto.layer.model.bean.GameBean;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.client.bo.ParameterBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.ganadiario.bo.GanadiarioBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicket;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.QrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * NOMBRE: GanadiarioController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Gana Diario
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
public class GanadiarioController {

    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private GanadiarioBo ganadiarioBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientTicketBo clientTicketBo;
    @Autowired
    private DrawBo drawBo;
    @Autowired
    private QrUtil qrUtil;
    @Autowired
    private ParameterBo parameterBo;
    
    @RequestMapping(value = "/juega-ganadiario")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelDraw, ModelMap model) throws Exception {
        HttpSession session = request.getSession();
        String context = Constants.contextCardWeb;
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        ClientProcedureGetDataClient dataClient = null;
        int state = 0;
        try {
        	if(request.getParameter("state")!=null && !request.getParameter("state").toString().trim().equals("")) state = Integer.parseInt(request.getParameter("state").toString().trim());        	        	
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                idSession = userBean.getpSessionid();
                idClient = userBean.getpClientid();
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                request.setAttribute("dataClient", dataClient);
                user = userBean.getpUser();
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
                userBean.setpGame(Game.GANADIARIO);
                if (clientProcedureGetClient!=null && clientProcedureGetClient.getAmount()!=null) {
                    userBean.setpMonto(clientProcedureGetClient.getAmount());
                }
                
                ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
				clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
				String result = new Gson().toJson(clientProcedureAccountData);
				session.setAttribute("clientBalance", result);
				
                session.setAttribute(Constants.USR_SESION, userBean);
            }
            // gameId = Integer.parseInt(request.getParameter("gameId"));
            if (ganadiarioBo.isSubscriptionAllowedGoIn(user) && state == 0) {
            	GanadiarioProcedureBetDataSubscribe ganadiarioProcedureBetDataBean = ganadiarioBo.findSubscribeByClientId(idClient);
            	
            	if(ganadiarioProcedureBetDataBean.getCloseDate()!=null && !ganadiarioProcedureBetDataBean.getCloseDate().isEmpty()) {
	            	ganadiarioProcedureBetDataBean.setCloseDate(ganadiarioBo.DateFormat(ganadiarioProcedureBetDataBean.getCloseDate()));
                }
                if(ganadiarioProcedureBetDataBean.getOpenDate()!=null && !ganadiarioProcedureBetDataBean.getOpenDate().isEmpty()) {
                	ganadiarioProcedureBetDataBean.setOpenDate(ganadiarioBo.DateFormat(ganadiarioProcedureBetDataBean.getOpenDate()));
                }
            	
            	List<GanadiarioProcedureDrawData> ganadiarioProcedureDrawDataList = ganadiarioBo.findListDraw();
	            modelDraw.put("ganadiarioProcedureDrawDataList", ganadiarioProcedureDrawDataList);
	            JsonObject joDataClient = new JsonObject();
				joDataClient.addProperty("bcpMaxAmount", (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim():"10000");
	            joDataClient.addProperty("bcpMinAmount", (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim():"50");
	            joDataClient.addProperty("pefeMaxAmount", (ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim():"3000");
	            joDataClient.addProperty("pefeMinAmount", (ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim():"40");
	            joDataClient.addProperty("sfpyMaxAmount", (ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim():"3000");
	            joDataClient.addProperty("sfpyMinAmount", (ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim():"40");
	            request.setAttribute("chargeData", joDataClient);
	            if(ganadiarioProcedureBetDataBean.getBalanceAmount()!=null)ganadiarioProcedureBetDataBean.setBalanceBill01(ClientUtils.formatCurrency(ganadiarioProcedureBetDataBean.getBalanceAmount()));
	            if(ganadiarioProcedureBetDataBean.getPriceMessage().trim().length()>6) {
	            	ganadiarioProcedureBetDataBean.setPromotionMessage(ganadiarioProcedureBetDataBean.getPriceMessage());
	            	ganadiarioProcedureBetDataBean.setPriceMessage("");
	            } else {
	            	ganadiarioProcedureBetDataBean.setPromotionMessage("Costo por jugada: ");
	            }
	            request.setAttribute("ganadiarioProcedureBetData", ganadiarioProcedureBetDataBean);
	           
	            return "game/ganadiario/home_ganadiario_subscription";
            }else {            
	            GanadiarioProcedureBetData ganadiarioProcedureBetDataBean = ganadiarioBo.findByClientId(idClient);
	            
	            if(ganadiarioProcedureBetDataBean.getCloseDate()!=null && !ganadiarioProcedureBetDataBean.getCloseDate().isEmpty()) {
	            	ganadiarioProcedureBetDataBean.setCloseDate(ganadiarioBo.DateFormat(ganadiarioProcedureBetDataBean.getCloseDate()));
                }
                if(ganadiarioProcedureBetDataBean.getOpenDate()!=null && !ganadiarioProcedureBetDataBean.getOpenDate().isEmpty()) {
                	ganadiarioProcedureBetDataBean.setOpenDate(ganadiarioBo.DateFormat(ganadiarioProcedureBetDataBean.getOpenDate()));
                }
	            
	            List<GanadiarioProcedureDrawData> ganadiarioProcedureDrawDataList = ganadiarioBo.findListDraw();
	            modelDraw.put("ganadiarioProcedureDrawDataList", ganadiarioProcedureDrawDataList);
	            if(ganadiarioProcedureBetDataBean.getBalanceAmount()!=null)ganadiarioProcedureBetDataBean.setBalanceBill01(ClientUtils.formatCurrency(ganadiarioProcedureBetDataBean.getBalanceAmount()));
	            if(ganadiarioProcedureBetDataBean.getPriceMessage().trim().length()>6) {
	            	ganadiarioProcedureBetDataBean.setPromotionMessage(ganadiarioProcedureBetDataBean.getPriceMessage());
	            	ganadiarioProcedureBetDataBean.setPriceMessage("");
	            } else {
	            	ganadiarioProcedureBetDataBean.setPromotionMessage("Costo por jugada: ");
	            }
	            request.setAttribute("ganadiarioProcedureBetData", ganadiarioProcedureBetDataBean);
	            
	            Double flagGd = (parameterBo.findByIdParameter(Constants.C_GD) == null) ? 0 : parameterBo.findByIdParameter(Constants.C_GD).getNumber();
	            model.put("flagConsecutivaGd", flagGd);
	           
	            return "game/ganadiario/home_ganadiario_user";
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/ganadiario/home_ganadiario_user";
        } finally {
            request.setAttribute("isAllowed", ganadiarioBo.isAllowedGoIn(user));
        }
    }

    /*@RequestMapping(value = "/login_ganadiario")
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
        		LoggerApi.Log.info("Entro a GanadiarioController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a GanadiarioController loginByUserPass con captcha");
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
                                userBean.setpGame(Game.GANADIARIO);
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
                                    GanadiarioProcedureBetData ganadiarioProcedureBetDataBean = ganadiarioBo.findByClientId(userBean.getpClientid());
                                    monto1 = ganadiarioProcedureBetDataBean.getBalanceAmount();
                                    monto2 = ganadiarioProcedureBetDataBean.getBalanceAmountGame();
                                	
	                                respuesta_ajax = "OK|" + username + "|" + clientProcedureGetClient.getAmount() + "|" + idClient + "|" + monto1
	                                        + "|" + monto2 + "|" + clientProcedureLogin.getLuckyIcon() + "|" + dataClient.getNombre() + "|" + dataClient.getApPaterno() + "|"
	                                        + dataClient.getApMaterno() + "|" + dataClient.getMail() + "|" + dataClient.getMobilePhone() + "|" + dataClient.getCountry() + "|"
	                                        + dataClient.getRegion() + "|" + dataClient.getAddress() + "|" + dataClient.getTypeId() + "|" + dataClient.getNumberId() + "|"
	                                        + dataClient.getControlAmount() + "|" + dataClient.getMail() + "|" + dataClient.getClientId() + "|" + sessionId + "|" + ganadiarioProcedureBetDataBean.getOtherAmount();
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

    @RequestMapping(value = "/ganadiario_find_countryAll")
    public String findCountryAll(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        try {
            List<Country> countryList = ganadiarioBo.findCountryAll();
            // Map<String, Object> model = new HashMap<String, Object>();
            model.put("countryList", countryList);
            return "";
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/ganadiario_find_draw_id_gameId")
    public String findDrawByIdByGameId(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Integer drawId = Integer.parseInt(request.getParameter("drawId"));
        Integer gameId = Integer.parseInt(request.getParameter("gameId"));
        try {
            Draw draw = ganadiarioBo.findDrawByIdByGameId(drawId, gameId);
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("draw", draw);
            return "game/ganadiario/interface-section-small-option";
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/ajaxJugadas")
    public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            GanadiarioProcedureBetData ganadiarioSaleBean = new GanadiarioProcedureBetData();
            double availableBalance = 0;
            PrintWriter out = null;
            out = response.getWriter();
            String data = "";
            if (request.getParameter("dato") != null)
                data = String.valueOf(request.getParameter("dato"));
            // LoggerApi.Log.info("data="+data);
            String[] boletos = (data + "").split("-");
            String[] item_array = null;
            String jugadas = "";
            String array_total = "";
            String[] o = null;
            // String play = "1 2 3 4 5 6";
            int gameId = Game.GANADIARIO;
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
                item_array = (boleto + "").split("\\|");
                for (int j = 0; j < item_array.length; j++) {
                    if (j != 0 && j < 4)
                        jugadas += "|";
                    if (j < 4)
                        jugadas += item_array[j];
                    if (j == 4) {
                        String[] juegos = (jugadas + "").split("\\|");
                        String juego = "";
                        for (int y = 0; y < 4; y++)
                            if (juegos[y].trim().equals("00") == false)
                                juego += juegos[y] + "|";
                        multiDraws = Integer.parseInt(item_array[5].trim());
                        price = Double.parseDouble(item_array[6].trim());
                        ip = request.getRemoteAddr().toString();
                        juego = juego.substring(0, juego.length() - 1);
                        // o = GameSaleDispatcher.playCouponByWeb(clientId, ip,
                        // gameId, jugadas, multiDraws, price, null, null);
                        o = GameSaleDispatcher.playCouponByWeb(clientId, ip, gameId, juego, multiDraws, price, null, null);
                        ganadiarioSaleBean = ganadiarioBo.findByClientId(Integer.parseInt(clientId));
                        if (o != null) {
                            jugadas += "|" + o[0] + "&" + o[1];
                            // o[2]-->precio generado
                            array_total += jugadas + "|" + item_array[5] + "|" + price + "|" + num_row + "|" + name_game + "|" + gameId + "|" + o[3] + "|" + o[4] + "|" + ganadiarioSaleBean.getBalanceQuantityGame() + "|" + ganadiarioSaleBean.getOtherQuantity() + "#";
                            num_row++;// ID DE LAS FILAS POSICION #7
                            /** POSICION 5 ---> CANTIDAD DE SORTEOS **/
                            /** POSICION 6 ---> PRECIO **/
                            jugadas = "";
                            availableBalance = Double.parseDouble(o[3]);
                        }
                    }
                }
            }
            array_total = array_total.substring(0, array_total.length() - 1);
            userBean.setpMonto(availableBalance);
            userBean.setpBilletera3(ClientUtils.formatCurrency(Double.parseDouble(ganadiarioSaleBean.getOtherAmount().replaceAll(",","."))));
            userBean.setpBilletera3Cant(ganadiarioSaleBean.getOtherQuantity());
            session.setAttribute(Constants.USR_SESION, userBean);
            //System.out.println("array_total="+array_total);
            out.print(array_total);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }
    
    @RequestMapping(value = "/jugadasSuscripcionGanadiario")
    public void ajaxPlaySubscription(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
        	MailingForSale mailingForSale = new MailingForSale();
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            double availableBalance = 0;
            PrintWriter out = null;
            out = response.getWriter();
            String data = "";
            if (request.getParameter("dato") != null)
                data = String.valueOf(request.getParameter("dato"));
            //System.out.println("DATA="+data);
            LoggerApi.Log.info("/jugadasSuscripcionGanadiario data="+data);
            String[] boletos = (data + "").split("-");
            LoggerApi.Log.info("/jugadasSuscripcionGanadiario boletos="+boletos);
            String jugadas = "";
            String array_total = "";
            String[] item_array = null, arr = null, o = null, next = null;
            //pe.com.intralot.loto.model.ClientTicket o = new pe.com.intralot.loto.model.ClientTicket();
            // String play = "1 2 3 4 5 6";
            int gameId = Game.GANADIARIO;
            Game gm = new Game(gameId);
            String name_game = gm.getName();
            String ip = "";
            int clientId = 0, sessionId = 0;
            String email = "";
            String gametype = null;
            if (session.getAttribute(Constants.USR_SESION) != null) {
                clientId = userBean.getpClientid();
                sessionId = userBean.getpSessionid();
            }
            int multiDraws = 0;
            int percent = 0;
            double price = 0;
            int num_row = 1;
            for (String boleto : boletos) {
                item_array = (boleto + "").split("\\|");
                LoggerApi.Log.info("/jugadasSuscripcionGanadiario item_array="+item_array);
                for (int j = 0; j < item_array.length; j++) {
                	if (j != 0 && j < 4)
                        jugadas += "|";
                    if (j < 4)
                        jugadas += item_array[j];
                    if (j == 4) {
                        String[] juegos = (jugadas + "").split("\\|");
                        String juego = "";
                        for (int y = 0; y < 4; y++) {
                        	if(y==0 && juegos[y].trim().equals("00")) break;
                            if (!juegos[y].trim().equals("00"))
                                juego += juegos[y] + "|";
                        }
                        if(item_array[4] != null && !item_array[4].trim().equals("null")) percent = Integer.parseInt(item_array[4].trim());
                        multiDraws = Integer.parseInt(item_array[5].trim());
                        LoggerApi.Log.info("/jugadasSuscripcionGanadiario multiDraws="+multiDraws);
                        price = Double.parseDouble(item_array[6].trim());
                        LoggerApi.Log.info("/jugadasSuscripcionGanadiario price="+price);
                        ip = request.getRemoteAddr().toString();
                        LoggerApi.Log.info("/jugadasSuscripcionGanadiario juego="+juego);
                        if(juego.trim().length()>0) {
                        	juego = juego.substring(0, juego.length() - 1);
                        	if(percent>0) {
                        		gametype = "SUS_IGUAL";
                        		juego = juego.split("\\|")[0].trim();
                        	}
                        } else if(juego.trim().length()==0 && percent>0) {
                        	gametype = "SUS_AZAR";
                        	juego = "AZAR";
                        }
                        LoggerApi.Log.info("/jugadasSuscripcionGanadiario gametype="+gametype);
                        LoggerApi.Log.info("/jugadasSuscripcionGanadiario juego-split="+juego);
                        o = GameSaleDispatcher.playCouponByWeb(clientId+"", ip, gameId, juego, multiDraws, price, null, gametype);
                        //System.out.println("clientId="+clientId+" ip="+ip+" gameId="+gameId+" juego="+juego+" multiDraws="+multiDraws+" price="+price+" gametype="+gametype);
                        //o = GameSaleDispatcher.playCouponByWebClientTicket(clientId, ip, gameId, juego, multiDraws, price, null, gametype);
                        if (o != null) {
                            jugadas += "|" + o[0] + "&" + o[1];
                        	//jugadas += "|" + o.getMessage() + "&" + o.getTicketId();
                            availableBalance = Double.parseDouble(o[3]);
                        	ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(sessionId, clientId);
                            if (clientProcedureGetClient.getMail() != null && !clientProcedureGetClient.getMail().equals(""))// && clientProcedureGetClient.getMailstatus() != null && clientProcedureGetClient.getMailstatus().equals("ACT"))
                                email = clientProcedureGetClient.getMail();
                            if(o[5]!=null && o[5].length()>0) arr = o[5].split("\\|");
                            //System.out.println("email="+email+" o[5]="+o[5]+" arr="+arr.length);
                            next = ganadiarioBo.findGanadiarioNextDraw();
                            
                            if (o[0].equals("OK")) {
                                int send = mailingForSale.sendGanadiarioSubscription(email, arr[5].toLowerCase(), arr[0], arr[3], arr[4], arr[11], arr[1].trim().replaceAll(" ", " - "), next[0], "S/ "+next[1]);
                                LoggerApi.Log.info(send + " CORREO ENVIADO email=*"+email+"*");
                            }
                        }
                        // o[2]-->precio generado
                        array_total += jugadas + "|" + item_array[5] + "|" + price + "|" + num_row + "|" + name_game + "|" + gameId + "|" + o[3] + "|" + o[4] + "|" + o[5] + "#";
                        //array_total += jugadas + "|" + item_array[5] + "|" + price + "|" + num_row + "|" + name_game + "|" + gameId + "|" + o.getReceiptAmount() + "|" + o.getNewBalanceAmount() + "|" + o.getReceiptDiscounted() + "|" + o.getPrice() + "|" + o.getPeriod() + "|" + o.getPercent() + "|" + o.getConsecutive() + "|" + o.getFromDraw() + "|" + o.getToDraw() + "|" + o.getBetMatrix1() + "#";
                        num_row++;// ID DE LAS FILAS POSICION #7
                        /** POSICION 5 ---> CANTIDAD DE SORTEOS **/
                        /** POSICION 6 ---> PRECIO **/
                        jugadas = "";
                    }
                }
            }
            if (!array_total.equals(""))
                array_total = array_total.substring(0, array_total.length() - 1);
            userBean.setpMonto(availableBalance);
            session.setAttribute(Constants.USR_SESION, userBean);
            out.print(array_total);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    /** PREMIOS **/
    @RequestMapping(value = "/premio_punto_venta_ganadiario")
    public void sale_dot_award(HttpServletRequest request, HttpServletResponse response, ModelMap modelDraw, ModelMap model) throws Exception {
        HttpSession session = request.getSession();
        int SessionId = 0;
        StringBuffer htmlTextCode = new StringBuffer();
        int gameId = 0;
        Long ticketId = 0L;
        String email = null;
        String emailStat = null;
        try {
            PrintWriter out = null;
            out = response.getWriter();
            int clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            int definePrizeFlag = 2;
            Integer idTicket = Integer.parseInt(session.getAttribute("gticket").toString());
            String phone = String.valueOf(request.getParameter("numberPhone"));
            int idGame = Game.GANADIARIO;
            LoggerApi.Log.info("idTicket: " + idTicket + "  phone: " + phone + "   clientId:  " + clientId);
            String msg = BussinessSaleLotos5Dispatcher.definePrizeFlagPhone(idTicket, clientId, idGame, definePrizeFlag, phone);
            LoggerApi.Log.info("msg ------------ > " + msg);
            SessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
            gameId = idGame;
            ticketId = Long.valueOf(idTicket);
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(clientId, gameId, ticketId);
            htmlTextCode = ticketSaleBo.findCouponByClientTicket(ticketProcedureGetClientTicket, 1);
            ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(SessionId, clientId);
            if (clientProcedureGetClient.getMail() != null)
                email = clientProcedureGetClient.getMail();
            // email2 = clientProcedureGetClient.getMail2();
            if (clientProcedureGetClient.getMailstatus() != null)
                emailStat = clientProcedureGetClient.getMailstatus();
            // email2Stat = clientProcedureGetClient.getMail2status();
            ticketProcedureGetClientTicket.getCtToDrawDate();
            request.setAttribute("gameid", gameId);
            request.setAttribute("gticket", ticketId);
            request.setAttribute("email", email);
            // request.setAttribute("email2", email2);
            request.setAttribute("emailStat", emailStat);
            // request.setAttribute("email2Stat", email2Stat);
            // model.put("clientsale",clientSaleBean);

            //Obtener QR @jmoran 2019-05-24
            String htmlQr = qrUtil.generateQR(ticketProcedureGetClientTicket, htmlTextCode.toString());
            
            //request.setAttribute("htmlTextCode", htmlTextCode.toString());
            // String array = msg + "|||" + htmlTextCode; @jmoran 2019-05-24
            request.setAttribute("htmlTextCode", htmlQr.toString());
            String array = msg + "|||" + htmlQr;
            
            out.print(array);
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
        }
    }

    @RequestMapping(value = "/premio_ganadiario")
    public String awardByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelDraw, ModelMap model) throws Exception {
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        //String user = "";
        try {
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
                idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                // LoggerApi.Log.info("idSession="+idSession+" idClient="+idClient);
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
            }
            GanadiarioProcedureBetData ganadiarioProcedureBetDataBean = ganadiarioBo.findByClientId(idClient);
            // GanadiarioSale ganadiarioProcedureBetDataBean =
            // ganadiarioProcedureBo.findByClientId(4);
            List<GanadiarioProcedureDrawData> ganadiarioProcedureDrawDataList = ganadiarioBo.findListDraw();
            modelDraw.put("ganadiarioProcedureDrawDataList", ganadiarioProcedureDrawDataList);
            if(ganadiarioProcedureBetDataBean.getPriceMessage().trim().length()>6) {
            	ganadiarioProcedureBetDataBean.setPromotionMessage(ganadiarioProcedureBetDataBean.getPriceMessage());
            	ganadiarioProcedureBetDataBean.setPriceMessage("");
            } else {
            	ganadiarioProcedureBetDataBean.setPromotionMessage("Costo por jugada: ");
            }
            request.setAttribute("ganadiarioProcedureBetData", ganadiarioProcedureBetDataBean);
            GameBean gameBean = new GameBean();
            String bet_free = (String) session.getAttribute("apGratis");
            String balance = (String) session.getAttribute("money");
            String ticket = session.getAttribute("gticket").toString();
            String date = (String) session.getAttribute("date");
            gameBean.setBet_free(bet_free);
            gameBean.setBalance(balance);
            gameBean.setNumber_ticket(ticket);
            gameBean.setDate(date);
            LoggerApi.Log.info("bet_free: " + bet_free + " balance: " + balance + " ticket: " + ticket + " date: " + date);
            session.setAttribute("award", gameBean);
            // session.setAttribute("loadBalance",);
            // session.setAttribute("numberTiket",);
            // session.setAttribute("dayTicket",);
            request.setAttribute("isAllowed", ganadiarioBo);
            return "game/ganadiario/award_ganadiario_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/ganadiario/award_ganadiario_user";
        } finally {
        }
    }

    @RequestMapping(value = "/award_free")
    public void award(HttpServletRequest request, HttpServletResponse response, ModelMap modelDraw, ModelMap model) throws Exception {
        HttpSession session = request.getSession();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String betFree = "";
            String balance = "";
            // String numberTicket="";
            // String date="";
            betFree = ((GameBean) session.getAttribute("award")).getBet_free();
            balance = ((GameBean) session.getAttribute("award")).getBalance();
            // numberTicket =
            // ((GameBean)session.getAttribute("award")).getNumber_ticket();
            // date= ((GameBean)session.getAttribute("award")).getDate();
            String cadena_valores = "";
            cadena_valores = betFree + "x" + balance;
            out.print(cadena_valores);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        }
    }

    @RequestMapping(value = "/payAwardMoneyganadiario")
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
            int gameId = Game.GANADIARIO;
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

    @RequestMapping(value = "/pay_award")
    public void payAward(HttpServletRequest request, HttpServletResponse response, ModelMap modelDraw, ModelMap model) throws Exception {
        HttpSession session = request.getSession();
        String message = "";
        try {
            WEBMessage web = new WEBMessage();
            boolean desist = false;
            boolean credit = true;
            String barCode = StringLib.decodeLabel(session.getAttribute("ticketNumber").toString());
            PrintWriter out = null;
            out = response.getWriter();
            String data = String.valueOf(request.getParameter("dato"));
            String[] boletos;
            boletos = (data + "").split("-");
            String[] item_array = null;
            String[] o = null;
            String jugadas = "";
            String array_total = "";
            // prize=0 free=1 2x1=0 from=2869 to=2898 df=1 cid=35726 tid=7062
            int ticketType = 1;
            // String play = "1 2 3 4 5 6";
            int gameId = Game.GANADIARIO;
            Game game = new Game(gameId);
            String name_game = game.getName();
            String ip = "";
            // String message = "";
            Client client = new Client();
            String clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());// Integer.parseInt(request.getParameter("clienIdClient"));
            client = BussinessSaleDispatcher.getClientByClientId(clientId);
            web.setClient(client);
            web.setIp(ip);
            DateAPI d = new DateAPI();
            web.setMessageId("W" + d.getTimeLong());
            web.setGame(game);
            WEBTicketPay webTicketPay = new WEBTicketPay();
            LinkedList<WEBTicket> listWEBTicket = new LinkedList<WEBTicket>();
            int multiDraws = 0;
            double price = 0;
            int num_row = 1;
            GroupAPI[] group;
            int cont = 0;
            LoggerApi.Log.info("data: ->   " + data);
            for (String boleto : boletos) {
                item_array = (boleto + "").split("\\|");
                WEBTicket webTickets = new WEBTicket();
                for (String element : item_array)
                    if ((element + "").length() > 12)
                        cont++;
                LoggerApi.Log.info("cont:  " + cont);
                int c = 0;
                group = new GroupAPI[cont];
                for (int j = 0; j < item_array.length; j++)
                    if ((item_array[j] + "").length() > 12) {
                        String ap[] = (item_array[j] + "").trim().split(" ");
                        int[] bets = null;
                        bets = new int[ap.length];
                        for (int k = 0; k < ap.length; k++) {
                            bets[k] = Integer.parseInt(ap[k]);
                            LoggerApi.Log.info("ap[" + k + "]=" + ap[k]);
                        }
                        group[c] = new GroupAPI();
                        group[c].setLottoBet(Game.GANADIARIO, GroupAPI.NORMAL, bets);
                        c++;
                        LoggerApi.Log.info("j:   " + j);
                    }
                LoggerApi.Log.info("c:   " + c);
                LoggerApi.Log.info("=================");
                webTickets.setGroups(group);
                if (ticketType == WEBTicket.FREE_TICKET)
                    webTickets.setTicketType(WEBTicket.FREE_TICKET);
                if (ticketType == WEBTicket.DOSPORUNO_TICKET)
                    webTickets.setTicketType(WEBTicket.DOSPORUNO_TICKET);
                listWEBTicket.add(webTickets);
                cont = 0;
            }
            webTicketPay.setWebTickets(listWEBTicket);
            WEBTicketPay wtp = GameSaleDispatcher.payTicketWinnerByWebTransaction(client, web, game, barCode, webTicketPay, desist, credit);
            if (wtp.getMessage() != null) {
                message = wtp.getMessage();
                LoggerApi.Log.info(message);
                if (message == "OK") {
                    String clientTicket = "";
                    int g = 0;
                    clientTicket += message + ";";
                    String resp = "";
                    for (WEBTicket ticket : wtp.getWebTickets()) {
                        g++;
                        pe.com.intralot.loto.model.ClientTicket ct = ticket.getClientTicket();
                        if (ct.getBetMatrix1() != null && ct.getBetMatrix1() != "") {
                            String matrix1 = (" " + ct.getBetMatrix1() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrix1 + " |";
                        } else
                            clientTicket += "00 |";
                        if (ct.getBetMatrix2() != null && ct.getBetMatrix2() != "") {
                            String matrix2 = (" " + ct.getBetMatrix2() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrix2 + " |";
                        } else
                            clientTicket += "00 |";
                        if (ct.getBetMatrix3() != null && ct.getBetMatrix3() != "") {
                            String matrix3 = (" " + ct.getBetMatrix3() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrix3 + " |";
                        } else
                            clientTicket += "00 |";
                        if (ct.getBetMatrix4() != null && ct.getBetMatrix4() != "") {
                            String matrix4 = (" " + ct.getBetMatrix4() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrix4 + " |";
                        } else
                            clientTicket += "00 |";
                        LoggerApi.Log.info("ct.getSaleType()--------------------->  " + ct.getSaleType());
                        if (Integer.parseInt(ct.getSaleType()) == 1)
                            resp = "Gratis";
                        if (Integer.parseInt(ct.getSaleType()) == 9)
                            resp = "Cambio";
                        clientTicket += ct.getMessage() + "&";
                        clientTicket += ct.getTicketId() + "|01 |1.0|";
                        clientTicket += g + "|";
                        clientTicket += name_game + "|" + gameId + "|" + wtp.getBalanceAmount() + "|" + resp + "#";
                    }
                    if (wtp.getClientTicketExchange() != null) {
                        pe.com.intralot.loto.model.ClientTicket cte = wtp.getClientTicketExchange();
                        if (cte.getBetMatrix1() != null && cte.getBetMatrix1() != "") {
                            String matrixe1 = (" " + cte.getBetMatrix1() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrixe1 + " |";
                        } else
                            clientTicket += "00 |";
                        if (cte.getBetMatrix2() != null && cte.getBetMatrix2() != "") {
                            String matrixe2 = (" " + cte.getBetMatrix2() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrixe2 + " |";
                        } else
                            clientTicket += "00 |";
                        if (cte.getBetMatrix3() != null && cte.getBetMatrix3() != "") {
                            String matrixe3 = (" " + cte.getBetMatrix3() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrixe3 + " |";
                        } else
                            clientTicket += "00 |";
                        if (cte.getBetMatrix4() != null && cte.getBetMatrix4() != "") {
                            String matrixe4 = (" " + cte.getBetMatrix4() + " ").replace(" 1 ", " 01 ").replace(" 2 ", " 02 ").replace(" 3 ", " 03 ").replace(" 4 ", " 04 ")
                                    .replace(" 5 ", " 05 ").replace(" 6 ", " 06 ").replace(" 7 ", " 07 ").replace(" 8 ", " 08 ").replace(" 9 ", " 09 ").trim();
                            clientTicket += matrixe4 + " |";
                        } else
                            clientTicket += "00 |";
                        if (Integer.parseInt(cte.getSaleType()) == 9)
                            resp = "Cambio";
                        g++;
                        clientTicket += cte.getMessage() + "&";
                        clientTicket += cte.getTicketId() + "|02 |1.0|";
                        clientTicket += g + "|";
                        clientTicket += name_game + "|" + gameId + "|" + wtp.getBalanceAmount() + "|" + resp + "#";
                    }
                    LoggerApi.Log.info(clientTicket);
                    clientTicket = clientTicket.substring(0, clientTicket.length() - 1);
                    out.print(clientTicket);
                } else {
                    for (String boleto : boletos) {
                        item_array = (boleto + "").split("\\|");
                        for (int j = 0; j < item_array.length; j++) {
                            if (j != 0 && j < 4)
                                jugadas += "|";
                            if (j < 4)
                                jugadas += item_array[j];
                            if (j == 4) {
                                String[] juegos = (jugadas + "").split("\\|");
                                String juego = "";
                                for (int y = 0; y < 4; y++)
                                    if (juegos[y].trim().equals("00") == false)
                                        juego += juegos[y] + "|";
                                multiDraws = Integer.parseInt(item_array[5].trim());
                                price = Double.parseDouble(item_array[6].trim());
                                // ip = (request.getRemoteAddr()).toString();
                                juego = juego.substring(0, juego.length() - 1);
                                // LoggerApi.Log.info(u+
                                // "------->   "+clientTicketArray[0]);
                                jugadas += "|" + "no&null" + "";
                                // o[2]-->precio generado
                                array_total += jugadas + "|" + item_array[5] + "|" + price + "|" + num_row + "|" + name_game + "|" + gameId + "|" + wtp.getBalanceAmount()
                                        + "|" + " " + "#";
                                num_row++;// ID DE LAS FILAS POSICION #7
                                /** POSICION 5 ---> CANTIDAD DE SORTEOS **/
                                /** POSICION 6 ---> PRECIO **/
                                jugadas = "";
                            }
                        }
                    }
                    array_total = message + ";" + array_total.substring(0, array_total.length() - 1);
                    out.print(array_total);
                }
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, message);
            throw e;
        } finally {
        }
    }

    /*********/
    /*
     * @RequestMapping(value = "/client_session") public void clientSession(HttpServletRequest request,HttpServletResponse response, ModelMap objectModelMap)throws Exception { HttpSession session =
     * request.getSession(); try { PrintWriter out = null; out = response.getWriter(); String user = String.valueOf(request.getParameter("user-client")); String pass =
     * String.valueOf(request.getParameter("password-client")); //validar user y pass y retornar: //arreglo[0]=true||false //arreglo[1]=Nombre del cliente //arreglo[2]=Monto disponible
     * //arreglo[3]=mensaje del porque no se inicio session(sea x clave o password) Boolean valida_session=true;//valida_session=arreglo[0](true||false) String respuesta_ajax="";
     * if(valida_session==true){ //CREAR VARIABLES DE SESSION EN EL SERVIDOR respuesta_ajax="true|luis santos|99999";//arreglo[0]|arreglo [1]|arreglo[2] }else{
     * respuesta_ajax="false|error en el ingreso";//arreglo[0]|arreglo[3] } out.print(respuesta_ajax); } catch (Exception e) { e.printStackTrace(); throw new Exception(e); } finally { } }
     */
    @RequestMapping(value = "/ganadiarioProcedure_find_draw")
    public String findDraw(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        try {
            List<GanadiarioProcedureDrawData> ganadiarioProcedureDrawDataList = ganadiarioBo.findListDraw();
            model.put("ganadiarioProcedureDrawDataList", ganadiarioProcedureDrawDataList);
            return "game/ganadiario/home_ganadiario_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    /*
     * @RequestMapping(value = "/ganadiarioProcedure_find_session_code") public String findSessionByCode(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws
     * Exception { logger.info("Ingresar a la clase: GanadiarioProcedureController."); logger.info("Ingresar al metodo: findSessionByCode."); String sessionCode = request.getParameter("sessionCode");
     * try { GanadiarioProcedureSessionData ganadiarioProcedureSessionData = ganadiarioProcedureBo.findSessionByCode(sessionCode); Map<String, Object> model = new HashMap<String, Object>();
     * model.put("ganadiarioProcedureSessionData", ganadiarioProcedureSessionData); logger.info("Salir del metodo: findSessionByCode.");
     * logger.info("Salir de la clase: GanadiarioProcedureController."); return "game/clicygana/section/quiz/interface-section-small-option"; } catch (Exception e) { e.printStackTrace(); throw new
     * Exception(e); } finally { } }
     */
    @RequestMapping(value = "/ticket_vista_previa_popup_ganadiario")
    public ModelAndView ticket_vista_previa_popup_ganadiario(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Long ticketId = 0L;
        int drawId = 0, gameID = 0, client_id = 0;
        JsonArray jugadaCompleta = new JsonArray();
        JsonObject datos_jugada = new JsonObject();
        JsonObject resultados = new JsonObject();
        JsonArray lista_resultadosA = new JsonArray();
        JsonArray lista_resultadosB = new JsonArray();
        JsonArray lista_resultadosC = new JsonArray();
        JsonArray lista_resultadosD = new JsonArray();
        ganadiarioBo.reinicioValoresAciertos();
        try {
            ticketId = Long.parseLong(request.getParameter("ticketId"));
            gameID = Integer.parseInt(request.getParameter("gameId"));
            ClientTicket ticket = clientTicketBo.findById(ticketId);
            drawId = Integer.parseInt(ticket.getCtDrawId());
            client_id = Integer.parseInt(ticket.getCtClientId());
            int from = ticket.getCtFromDraw();
            int to = ticket.getCtToDraw();
            String bet1 = "", bet2 = "", bet3 = "", bet4 = "";
            if (ticket.getCtBetMatrix1() != null)
                bet1 = " " + ticket.getCtBetMatrix1() + " ";
            if (ticket.getCtBetMatrix2() != null)
                bet2 = " " + ticket.getCtBetMatrix2() + " ";
            if (ticket.getCtBetMatrix3() != null)
                bet3 = " " + ticket.getCtBetMatrix3() + " ";
            if (ticket.getCtBetMatrix4() != null)
                bet4 = " " + ticket.getCtBetMatrix4() + " ";
            datos_jugada.addProperty("bet1", bet1.length());
            datos_jugada.addProperty("bet2", bet2.length());
            datos_jugada.addProperty("bet3", bet3.length());
            datos_jugada.addProperty("bet4", bet4.length());
            if (bet1.length() > 2 && bet2.length() < 6 && bet3.length() < 6 && bet4.length() < 6) {
                datos_jugada.add("datos_jugada_A", ganadiarioBo.datosJugada("A", from, to, gameID, ticketId));
                datos_jugada.add("resultado_jugada", ganadiarioBo.resultado_premios(client_id, gameID, ticketId));
            } else if (bet1.length() > 2 && bet2.length() > 6 && bet3.length() < 6 && bet4.length() < 6) {
                datos_jugada.add("datos_jugada_B", ganadiarioBo.datosJugada("B", from, to, gameID, ticketId));
                datos_jugada.add("resultado_jugada", ganadiarioBo.resultado_premios(client_id, gameID, ticketId));
            } else if (bet1.length() > 2 && bet2.length() > 6 && bet3.length() > 6 && bet4.length() < 6) {
                datos_jugada.add("datos_jugada_C", ganadiarioBo.datosJugada("C", from, to, gameID, ticketId));
                datos_jugada.add("resultado_jugada", ganadiarioBo.resultado_premios(client_id, gameID, ticketId));
            } else if (bet1.length() > 2 && bet2.length() > 6 && bet3.length() > 6 && bet4.length() > 6) {
                datos_jugada.add("datos_jugada_D", ganadiarioBo.datosJugada("D", from, to, gameID, ticketId));
                datos_jugada.add("resultado_jugada", ganadiarioBo.resultado_premios(client_id, gameID, ticketId));
            }
            jugadaCompleta.add(datos_jugada);
            request.setAttribute("jugadaCompleta", jugadaCompleta);
            return new ModelAndView("game/ganadiario/ganadiario_popup_cotejo");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/ganadiario/ganadiario_popup_cotejo");
        } finally {
        }
    }

    @RequestMapping(value = "/Ganadiario_cotejador_jugada")
    public ModelAndView GanadiarioCotejoJugada(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
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
            }
            GanadiarioProcedureBetData GanadiarioProcedureBetDataBean = ganadiarioBo.findByClientId(idClient);
            List<Draw> GanadiarioProcedureDrawDataList = drawBo.findByDrawListByGameId(Game.GANADIARIO, 180);
            modelList.put("ganadiarioSaleList", GanadiarioProcedureDrawDataList);
            ArrayList boletoValido = new ArrayList();
            boletoValido = ganadiarioBo.valoresBoleto();
            modelList.put("GanadiarioValoresBoleto", boletoValido);
            GanadiarioProcedureBetDataBean.setCloseDate(ganadiarioBo.DateFormat(GanadiarioProcedureBetDataBean.getCloseDate()));
            request.setAttribute("GnadiarioSale", GanadiarioProcedureBetDataBean);
            userBean.setpGame(Game.GANADIARIO);
            session.setAttribute(Constants.USR_SESION, userBean);
            return new ModelAndView("game/ganadiario/ganadiario_cotejo_jugada");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            request.setAttribute("isAllowed", ganadiarioBo.isAllowedGoIn(user));
        }
    }

    @RequestMapping(value = "/cotejo_ganadiario_ajax")
    public void loadBalanceLotocard(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        JsonArray jugadaCompleta = new JsonArray();
        JsonObject datos_jugada = new JsonObject();
        ganadiarioBo.reinicioValoresAciertos();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String data = String.valueOf(request.getParameter("dato"));
            String[] item_array = null;
            String jugadas = "";
            String array_total = "";
            String[] o = null;
            int gameId = Game.GANADIARIO;
            String[] datosJugadaCotejo = data.split("/");
            String jugadaA = " " + datosJugadaCotejo[0].trim() + " ";
            String jugadaB = " " + datosJugadaCotejo[1].trim() + " ";
            String jugadaC = " " + datosJugadaCotejo[2].trim() + " ";
            String jugadaD = " " + datosJugadaCotejo[3].trim() + " ";
            String plusA = " " + datosJugadaCotejo[8].trim() + " ";
            String plusB = " " + datosJugadaCotejo[9].trim() + " ";
            String plusC = " " + datosJugadaCotejo[10].trim() + " ";
            String plusD = " " + datosJugadaCotejo[11].trim() + " ";
            Integer chauCmbA = Integer.parseInt(datosJugadaCotejo[12].trim());
            Integer chauCmbB = Integer.parseInt(datosJugadaCotejo[13].trim());
            Integer chauCmbC = Integer.parseInt(datosJugadaCotejo[14].trim());
            Integer chauCmbD = Integer.parseInt(datosJugadaCotejo[15].trim());
            Integer from = Integer.parseInt(datosJugadaCotejo[16].trim());
            Integer to = Integer.parseInt(datosJugadaCotejo[17].trim());
            String jugadaCompl = jugadaA + "-" + jugadaB + "-" + jugadaC + "-" + jugadaD + "-";
            String plus = plusA + "-" + plusB + "-" + plusC + "-" + plusD + "-";
            String chauChamba = chauCmbA + "-" + chauCmbB + "-" + chauCmbC + "-" + chauCmbD + "-";
            datos_jugada.add("datos_jugada_A", ganadiarioBo.datosJugadaCotejo("D", from, to, Game.GANADIARIO, jugadaCompl, plus, chauChamba));
            jugadaCompleta.add(datos_jugada);
            out.print(jugadaCompleta);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info("OutData=" + jugadaCompleta.toString());
            LoggerApi.Log.info("Game.GANADIARIO=" + Game.GANADIARIO);
        }
    }
}
