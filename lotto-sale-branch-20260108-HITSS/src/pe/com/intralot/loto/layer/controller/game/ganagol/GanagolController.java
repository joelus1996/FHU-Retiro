package pe.com.intralot.loto.layer.controller.game.ganagol;

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

import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureSaleLoadPrepaidCard;
import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureProgramData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.layer.service.game.ganagol.bo.GanagolBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.model.Group;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.card.model.WEBTicket;
import pe.com.intralot.loto.sale.card.model.WEBTicketPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * NOMBRE: GanagolController.java <br>
 * </p>
 * <p>
 * FUNCION: Controlador juego Ganagol <br>
 * </p>
 * <p>
 * NOTAS: Ninguna. <br>
 * </p>
 * <p>
 * VERSIONES
 * 
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Límite montos mínimos y maximos de recarga parametrizado
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * 
 * <br>
 * </p>
 */

@Controller
public class GanagolController {

	@Autowired
	private GanagolBo ganagolBo;
	@Autowired
	private ClientSaleBo clientSaleBo;
	@Autowired
	private ClientTicketBo clientTicketBo;
	@Autowired
	private DrawBo drawBo;

	@RequestMapping(value = "/juega-ganagol")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        String context = Constants.contextCardWeb;
        Integer idSession = 0;
        Integer idClient = 0;
        ClientProcedureGetDataClient dataClient = null;
        try {
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
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
                userBean.setpGame(Game.GANAGOL);
                if (clientProcedureGetClient!=null && clientProcedureGetClient.getAmount()!=null) {
                    userBean.setpMonto(clientProcedureGetClient.getAmount());
                }
                
                ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
				clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
				String result = new Gson().toJson(clientProcedureAccountData);
				session.setAttribute("clientBalance", result);
				
                session.setAttribute(Constants.USR_SESION, userBean);
            }
            List<GanagolProcedureDrawData> ganagolSaleList = ganagolBo.findListDrawData();
            /* List<GanagolProcedureProgramData> List = ganagolBo.findListProgramData(5016);
            for (GanagolProcedureProgramData pd : List)
                System.out.print("List: " + pd.getItem() + "----" + pd.getLocal()); */
            modelList.put("ganagolSaleList", ganagolSaleList);
            JsonObject joDataClient = new JsonObject();
			joDataClient.addProperty("bcpMaxAmount", (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim():"10000");
            joDataClient.addProperty("bcpMinAmount", (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim():"50");
            joDataClient.addProperty("pefeMaxAmount", (ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim():"3000");
            joDataClient.addProperty("pefeMinAmount", (ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim():"40");
            joDataClient.addProperty("sfpyMaxAmount", (ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim():"3000");
            joDataClient.addProperty("sfpyMinAmount", (ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim():"40");
            request.setAttribute("chargeData", joDataClient);
            GanagolProcedureBetData ganagolSaleBean = ganagolBo.findByClientId(idClient);
            if(ganagolSaleBean.getBalanceAmount()!=null)ganagolSaleBean.setBalanceBill01(ClientUtils.formatCurrency(ganagolSaleBean.getBalanceAmount()));
            if(ganagolSaleBean.getPriceMessage().trim().length()>6) {
            	ganagolSaleBean.setPromotionMessage(ganagolSaleBean.getPriceMessage());
            	ganagolSaleBean.setPriceMessage("");
            } else {
            	ganagolSaleBean.setPromotionMessage("Costo por jugada: ");
            }
            if(ganagolSaleBean.getLastDraw()!=null)ganagolSaleBean.setLastDraw(Integer.toString(Integer.parseInt(ganagolSaleBean.getLastDraw())-5000));
            if(ganagolSaleBean.getActiveDraw()!=null)ganagolSaleBean.setActiveDraw(Integer.toString(Integer.parseInt(ganagolSaleBean.getActiveDraw())-5000));
            if(ganagolSaleBean.getProgram()!=null)ganagolSaleBean.setProgram(Integer.toString(Integer.parseInt(ganagolSaleBean.getProgram())-5000));
            if(ganagolSaleBean.getNextDraw()!=null)ganagolSaleBean.setNextDraw(Integer.toString(Integer.parseInt(ganagolSaleBean.getNextDraw())-5000));
            /*if(session.getAttribute("clientBalance") != null && !session.getAttribute("clientBalance").toString().trim().equals("")) {
            	JsonElement je= new JsonParser().parse(session.getAttribute("clientBalance").toString().trim());
            	JsonObject jo = je.getAsJsonObject();
            	if(jo.get("welcomeBonusMessage")!=null && !jo.get("welcomeBonusMessage").toString().trim().equals("")) ganagolSaleBean.setWelcomeBonusMessage(jo.get("welcomeBonusMessage").toString().trim());
            	else ganagolSaleBean.setWelcomeBonusMessage("");
            	if(jo.get("welcomeBonusStatus")!=null && jo.get("welcomeBonusStatus").toString().trim().equals("Reciente")) ganagolSaleBean.setWelcomeBonusMessagePor("<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+jo.get("welcomeBonusPercentaje").toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
            	else ganagolSaleBean.setWelcomeBonusMessagePor("");
            }*/
            request.setAttribute("ganagolSale", ganagolSaleBean);
            
            return "game/ganagol/home_ganagol_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/ganagol/home_ganagol_user";
        } finally {
        }
    }

    /*@RequestMapping(value = "/login_ganagol")
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
        		LoggerApi.Log.info("Entro a GanagolController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a GanagolController loginByUserPass con captcha");
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
                        LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " Mode=" + mode);
                        if (state == 1) {
                            mode = Integer.parseInt(clientProcedureLogin.getMode());
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
                                userBean.setpGame(Game.GANAGOL);
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
                                    GanagolProcedureBetData ganagolSaleBean = ganagolBo.findByClientId(userBean.getpClientid());
                                    if (ganagolSaleBean != null) {
                                        monto1 = ganagolSaleBean.getBalanceAmount();
                                        monto2 = ganagolSaleBean.getBalanceAmountGame();
                                    }
	                                respuesta_ajax = "OK|" + username + "|" + clientProcedureGetClient.getAmount() + "|" + idClient + "|" + monto1
	                                        + "|" + monto2 + "|" + clientProcedureLogin.getLuckyIcon() + "|" + dataClient.getNombre() + "|" + dataClient.getApPaterno() + "|"
	                                        + dataClient.getApMaterno() + "|" + dataClient.getMail() + "|" + dataClient.getMobilePhone() + "|" + dataClient.getCountry() + "|"
	                                        + dataClient.getRegion() + "|" + dataClient.getAddress() + "|" + dataClient.getTypeId() + "|" + dataClient.getNumberId() + "|"
	                                        + dataClient.getControlAmount() + "|" + dataClient.getMail() + "|" + dataClient.getClientId() + "|" + sessionId + "|" + ganagolSaleBean.getOtherAmount();
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

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/ajaxGanagol")
	public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		HttpSession session = request.getSession();
		double availableBalance = -1;
		try {
			UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
			GanagolProcedureBetData ganagolSaleBean = new GanagolProcedureBetData();
			PrintWriter out = null;
			out = response.getWriter();
			String data = "";
			if (request.getParameter("dato") != null)
				data = String.valueOf(request.getParameter("dato"));
//			data = data.replace("-", "");
			Game game = new Game();
			game.setGame(Game.GANAGOL);
			int gameId = Game.GANAGOL;
			Game g = new Game(Game.GANAGOL);
			String gameName= g.getName(); 
			String[] boletos = (data + "").split("-");
			//String[] item_array = null;
			//String[] o = null;
			ArrayList<String> plays = new ArrayList<String>();
			String array_total = "";			
			int index = 1;
			
			String ip = request.getRemoteAddr().toString();
			String clientId = "";
			if (session.getAttribute(Constants.USR_SESION) != null)
				clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
			if (clientId == null || clientId.trim().equals("") || clientId.trim().equals("null")) {
				out.print("");
				return;
			}
			int consecutives = 0;
	        double price = 0;
			String jugadas = "";
			for (String boleto : boletos) {

				String[] all = boleto.trim().split("\\|");
				plays = new ArrayList<String>();
				for (int x = 0; x < all.length; x++) {
					String addons = "";
					if (x < 4) {
						jugadas += all[x].trim();
						if (x < 3)
							jugadas += "|";
						if (!all[x].trim().equals("00")) {
							addons += " " + (all[x + 8].trim().equals("AD1") ? all[x + 8].trim() : "");
							plays.add(all[x] + addons.trim());
						}
					}
					
					if(x == 4) {
						
						GroupAPI[] group = new GroupAPI[plays.size()];
                        String[] numbers = {};
                        int countPlay = 0;
                        int columns = 0;
                        String addon = "";
                        boolean flagAddon=false;
                        for (String play : plays) {
                        	//System.out.println("PLAY="+play+" AD1="+play.indexOf("AD1")+" AD2="+play.indexOf("AD2"));
                        	addon = "";                           
                            System.out.println(play.indexOf("AD1"));
                            System.out.println(play.indexOf("AD2"));
                            if(play.contains("AD1")) {
                            	play = play.replace("AD1", "").trim();
                                flagAddon = true;
                            }
                            
                            String[] bet = play.trim().split(" ");
                            if(bet.length==15) {
                            	addon = bet[bet.length-1].substring(2).trim();
                            	addon =addon.replaceFirst("^0+(?!$)", "");                           	
                            }
                            
                            if(bet.length==16) {
                            	bet[14] = bet[14].replace("a","").trim(); 
                            	addon = bet[14].substring(2).trim();
                            	                       	
                            }
                            
                            if(addon.equals("4446")) {
                            	addon="4445";
                            }
                            
                            numbers = new String[14];
                                                                                                                                      
                            for (int i=0;i<14;i++) {
                           	
                                numbers[i] = bet[i];
                               
                                numbers[i]=  numbers[i].replace("0","");
                                numbers[i] =  numbers[i].replace("1", "");
                                numbers[i] =  numbers[i].replace("2", "");
                                numbers[i] =  numbers[i].replace("3", "");
                                numbers[i] =  numbers[i].replace("4", "");
                                numbers[i] =  numbers[i].replace("5", "");
                                numbers[i] =  numbers[i].replace("6", "");
                                numbers[i] =  numbers[i].replace("7", "");
                                numbers[i] =  numbers[i].replace("8", "");
                                numbers[i] =  numbers[i].replace("9", "");
                                                               	
                            }
                            
                            group[countPlay] = new GroupAPI();
                            group[countPlay].setTotoBetNewLotos5(Game.GANAGOL, Group.NORMAL, numbers, addon);
                            columns = (int) (columns + group[countPlay].getColumns());
                            countPlay++;
                        }
                        
                        String zip="";
        				if(!flagAddon) {
        					zip=request.getRemoteAddr().toString();
        				}else {
        					zip = request.getRemoteAddr().toString() +"[1]V[2]"+game.getGameNumber()+"[3]"+columns;	
        				}
                        
                        consecutives = Integer.parseInt(all[5].trim());
                        price = Double.parseDouble(all[6].replaceAll("\\s",""));
                        AccountController accountController = new AccountController();
                        Client client = accountController.getClientByClientId(clientId.toString());
                        DateAPI date = new DateAPI();
                        WEBMessage web = new WEBMessage();
                        web.setClient(client);
                        web.setCarrier("WEB");
                        web.setIp(zip);
                        web.setGame(game);
                        web.setGroup(group);
                        web.setMessageId("W" + date.getTimeLong() + Game.GANAGOL);
                        pe.com.intralot.loto.model.ClientTicket ct = GameSaleDispatcher.playCouponByWebTransaction(client, web, game, consecutives, group, price);
					
					ganagolSaleBean = ganagolBo.findByClientId(Integer.parseInt(clientId));
					
					
					jugadas += "|" + ct.getMessage() + "&" + ct.getTicketId();
                   
                    array_total += jugadas + "|" + all[5] + "|" + price + "|" + index + "|" + all[8] + "|" + all[9] + "|" + all[10] + "|" + all[11] + "|" 
                    			+ gameName + "|" + gameId + "|" + ganagolSaleBean.getBalanceAmount() + "|"
                    			+ client.getGameBalanceString() + "|" + ganagolSaleBean.getBalanceQuantityGame() + "|" + ganagolSaleBean.getOtherQuantity() + "#";
                    index++;
                    jugadas = "";
					availableBalance = client.getBalanceAmount();
					
					}
				}

			}
			
			//jugadas = jugadas.substring(0, jugadas.length() - 1);
			if (availableBalance != -1)
				userBean.setpMonto(availableBalance);
			userBean.setpBilletera3(ClientUtils
					.formatCurrency(Double.parseDouble(ganagolSaleBean.getOtherAmount().replaceAll(",", "."))));
			userBean.setpBilletera3Cant(ganagolSaleBean.getOtherQuantity());
			session.setAttribute(Constants.USR_SESION, userBean);
			array_total = array_total.substring(0, array_total.length() - 1);
			System.out.println("array_total=["+array_total+"]");
			out.print(array_total);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
		}
	}

	@RequestMapping(value = "/ticket_vista_previa_popup_ganagol")
    public ModelAndView ticket_vista_previa_popup_ganagol(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		Long ticketId = 0L;
		int drawId = 0, gameID = 0, clientid = 0, ctbM1 = 0, ctbM2 = 0, ctbM3 = 0, ctbM4 = 0;
		JsonArray jugadaCompleta = new JsonArray();
		JsonObject datos_jugada = new JsonObject();
		try {
			ticketId = Long.parseLong(request.getParameter("ticketId"));
			gameID = Integer.parseInt(request.getParameter("gameId"));
			ClientTicket ticket = clientTicketBo.findById(ticketId);
			clientid = Integer.parseInt(ticket.getCtClientId());
			LoggerApi.Log.info("CLIENTE : " + clientid);
			datos_jugada.addProperty("ctbM1", (" " + ticket.getCtBetMatrix1() + " ").length());
			datos_jugada.addProperty("ctbM2", (" " + ticket.getCtBetMatrix2() + " ").length());
			datos_jugada.addProperty("ctbM3", (" " + ticket.getCtBetMatrix3() + " ").length());
			datos_jugada.addProperty("ctbM4", (" " + ticket.getCtBetMatrix4() + " ").length());
			datos_jugada.add("datos_jugada", ganagolBo.cotejadorGanagol(clientid, gameID, ticketId));
			datos_jugada.add("tabla_datos", ganagolBo.resultado_premios(clientid, gameID, ticketId));
			datos_jugada.add("premio_tot", ganagolBo.premio_total(clientid, gameID, ticketId));
			jugadaCompleta.add(datos_jugada);
			LoggerApi.Log.info("ARRAY COTEJO: " + jugadaCompleta.toString());
			LoggerApi.Log.info("ARRAY COMPLETO: " + ganagolBo.cotejadorGanagol(clientid, gameID, ticketId).toString());
			request.setAttribute("jugadaCompleta", jugadaCompleta);
			return new ModelAndView("game/ganagol/ganagol_popup_cotejo");
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/ganagol/ganagol_popup_cotejo");
		} finally {
		}
	}

	@RequestMapping(value = "/payAwardMoneyGanagol")
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
			int gameId = Game.GANAGOL;
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

	@RequestMapping(value = "/Ganagol_cotejador_jugada")
    public ModelAndView GanagolCotejoJugada(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
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
			GanagolProcedureBetData GanagolProcedureBetDataBean = ganagolBo.findByClientId(idClient);
			List<Draw> GanagolProcedureDrawDataList = drawBo.findByDrawListByGameId(Game.GANAGOL, 180);
			modelList.put("GanagolSaleList", GanagolProcedureDrawDataList);
			request.setAttribute("ganagol", GanagolProcedureBetDataBean);
			userBean.setpGame(Game.GANAGOL);
			session.setAttribute(Constants.USR_SESION, userBean);
			return new ModelAndView("game/ganagol/ganagol_cotejo_jugada");
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			request.setAttribute("isAllowed", ganagolBo.isAllowedGoIn(user));
		}
	}

	@RequestMapping(value = "/equipos_ganadiario_ajax")
    public void loadBalanceLotocard(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		JsonArray equiposTotales = new JsonArray();
		JsonObject equipos = new JsonObject();
		ArrayList idEquipos = new ArrayList();
		ArrayList local = new ArrayList();
		ArrayList visitante = new ArrayList();
		ArrayList imageLocal = new ArrayList();
		ArrayList imageVisitante = new ArrayList();
		try {
			PrintWriter out = null;
			out = response.getWriter();
			String data = String.valueOf(request.getParameter("dato"));
			// System.out.println("DATA : " + data);
			int draw = Integer.parseInt(data.trim());
			List<GanagolProcedureProgramData> listaEquipos = ganagolBo.findListProgramData(draw);
			if (listaEquipos != null) {
				for (int i = 0; i < listaEquipos.size(); i++) {
					GanagolProcedureProgramData eq = listaEquipos.get(i);
					idEquipos.add(eq.getItem());
					local.add(eq.getLocal());
					visitante.add(eq.getVisitor());
					imageLocal.add(eq.getImageLocal());
					imageVisitante.add(eq.getImageVisitor());
				}
				equipos.add("idEquipos", new Gson().toJsonTree(idEquipos));
				equipos.add("localEq", new Gson().toJsonTree(local));
				equipos.add("visitanteEq", new Gson().toJsonTree(visitante));
				equipos.add("localImg", new Gson().toJsonTree(imageLocal));
				equipos.add("visitanteImg", new Gson().toJsonTree(imageVisitante));
				equiposTotales.add(equipos);
			}
			out.print(equiposTotales);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("OutData=" + equiposTotales.toString());
			LoggerApi.Log.info("Game.GANAGOL=" + Game.GANAGOL);
		}
	}

	@RequestMapping(value = "/cotejo_ajax_ganagol")
    public void CotejadorAjax(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		HttpSession session = request.getSession();
		ClientProcedureSaleLoadPrepaidCard clientProcedureSaleLoadPrepaidCard = new ClientProcedureSaleLoadPrepaidCard();
		String outData = "";
		JsonArray jugadaCompleta = new JsonArray();
		JsonObject datos_jugada = new JsonObject();
		JsonObject resultados = new JsonObject();
		try {
			PrintWriter out = null;
			out = response.getWriter();
			String data = String.valueOf(request.getParameter("dato"));
			String[] item_array = null;
			String jugadas = "";
			String array_total = "";
			String[] o = null;
			// System.out.println("DATA : " + data);
			String[] datosJugadaCotejo = data.split("/");
			String jugadaA = " " + datosJugadaCotejo[0].trim() + " ";
			String jugadaB = " " + datosJugadaCotejo[1].trim() + " ";
			String jugadaC = " " + datosJugadaCotejo[2].trim() + " ";
			String jugadaD = " " + datosJugadaCotejo[3].trim() + " ";
			String golazoA = " " + datosJugadaCotejo[5].trim() + " ";
			String golazoB = " " + datosJugadaCotejo[6].trim() + " ";
			String golazoC = " " + datosJugadaCotejo[7].trim() + " ";
			String golazoD = " " + datosJugadaCotejo[8].trim() + " ";
			Integer from = Integer.parseInt(datosJugadaCotejo[4].trim());
			Integer to = Integer.parseInt(datosJugadaCotejo[4].trim());
			String jugadaCompl = jugadaA + "," + jugadaB + "," + jugadaC + "," + jugadaD + ","+
					golazoA + "," + golazoB + "," + golazoC + "," + golazoD + ",";
			JsonArray juego_completo=ganagolBo.datosJugadaCotejo("D", from, to, Game.GANAGOL, jugadaCompl);
			JsonObject datosJugada=(JsonObject)juego_completo.get(0);
			datosJugada.addProperty("golazoA", golazoA);
			datosJugada.addProperty("golazoB", golazoB);
			datosJugada.addProperty("golazoC", golazoC);
			datosJugada.addProperty("golazoD", golazoD);
			datos_jugada.add("datos_jugada_A", juego_completo);
			jugadaCompleta.add(datos_jugada);
			out.print(jugadaCompleta);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("OutData=" + jugadaCompleta.toString());
			LoggerApi.Log.info("Game.GANAGOL=" + Game.GANAGOL);
		}
	}
}
