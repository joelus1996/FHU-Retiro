package pe.com.intralot.loto.layer.controller.game.teapuesto;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedHashMap;
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

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureDrawMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureExactMenu;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialData;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialGroup;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialHeader;
import pe.com.intralot.loto.layer.model.domain.TeapuestoProcedureSpecialMenu;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.game.teapuesto.bo.TeapuestoBo;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.FechazacotejadorUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class TeapuestoController {

    @Autowired
    private TeapuestoBo teapuestoBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientTicketBo clientTicketBo;

    @RequestMapping(value = "/juega-teapuesto")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        ClientProcedureGetDataClient dataClient = null;
        JsonObject TeApuestoData = new JsonObject();
        JsonArray jaDrawData = new JsonArray();
        JsonArray jaExactData = new JsonArray();
        JsonArray jaSpecialData = new JsonArray();
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
                userBean.setpGame(Game.TEAPUESTO);
                session.setAttribute(Constants.USR_SESION, userBean);
            }
            
            TeApuestoData.add("BetData", teapuestoBo.createBetData(idClient));
            request.setAttribute("BetData", teapuestoBo.createBetData(idClient));
            List<TeapuestoProcedureDrawMenu> teapuestoSaleListDrawMenu = teapuestoBo.findListDrawMenu();
            for (TeapuestoProcedureDrawMenu drawMenu : teapuestoSaleListDrawMenu) {
                JsonObject joElement = new JsonObject();
                joElement.addProperty("drawId", drawMenu.getDrawId());
                joElement.addProperty("date", drawMenu.getDate());
                joElement.add("events", teapuestoBo.createDrawList(drawMenu.getDrawId()));
                jaDrawData.add(joElement);
            }
            TeApuestoData.add("DrawData", jaDrawData);
            request.setAttribute("DrawData", jaDrawData);
            List<TeapuestoProcedureExactMenu> teapuestoSaleExactMenu = teapuestoBo.findListExactMenu();
            for (TeapuestoProcedureExactMenu exactMenu : teapuestoSaleExactMenu) {
                JsonObject joElement = new JsonObject();
                joElement.addProperty("drawId", exactMenu.getDrawId());
                joElement.addProperty("eventId", exactMenu.getEventId());
                joElement.addProperty("teamsMenu", exactMenu.getTeamsMenu());
                joElement.add("data", teapuestoBo.createExactData(exactMenu.getDrawId(), exactMenu.getEventId()));
                jaExactData.add(joElement);
            }
            TeApuestoData.add("ExactData", jaExactData);
            request.setAttribute("ExactData", jaExactData);
            List<TeapuestoProcedureSpecialHeader> teapuestoSaleSpecialHeader = teapuestoBo.findSpecialHeader();
            for (TeapuestoProcedureSpecialHeader specialHeader : teapuestoSaleSpecialHeader) {
                JsonObject joElement = new JsonObject();
                joElement.addProperty("header", specialHeader.getHeader());
                joElement.addProperty("name", specialHeader.getName());
                joElement.add("data", teapuestoBo.createSpecialData(specialHeader.getHeader()));
                jaSpecialData.add(joElement);
            }
            request.setAttribute("SpecialData", jaSpecialData);
            TeApuestoData.add("SpecialData", jaSpecialData);
            request.setAttribute("b5435566a27c88b4745c39e0b3d91da7", TeApuestoData);
            
            return "game/teapuesto/home_teapuesto_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/teapuesto/home_teapuesto_user";
        } finally {
            request.setAttribute("isAllowed", teapuestoBo.isAllowedGoIn(user));
            LoggerApi.Log.info("idClient:=" + idClient + " idSession:=" + idSession);
        }
    }

    /*@RequestMapping(value = "/login_teapuesto")
    public void loginByUserPass(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Integer sessionId = 0;
        Integer clientId = 0;
        String username = "", password = "", capchaCode="";
        PrintWriter out = response.getWriter();
        String respuesta_ajax = "";
        HttpSession session = request.getSession();
        ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        ClientProcedureGetDataClient dataClient = null;
        int mode = 0;
        Integer cid = 0;
        int captcha = 0;
        int state = 0;
        String agreement = "", mverified = "", phoneverified="", promotion= "", promotionibk= "";
        try {
        	if(request.getParameter("captcha-client") == null) {
        		LoggerApi.Log.info("Entro a TeapuestoController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a TeapuestoController loginByUserPass con captcha");
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
                                userBean.setpGame(Game.TEAPUESTO);
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
                                	if(mverified.equals("N")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico en tu cuenta, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	failedBean.setpNombre(userBean.getpNombre());
                                	failedBean.setpMail(userBean.getpMail());
                                	failedBean.setpStatus(mverified);
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                	
                                } else if (false) {//phoneverified.equals("DES") || !ClientUtils.verifySintaxMobilePhone(clientProcedureLogin.getMobilePhone().toString().trim())) {
                                	UserBean failedBean = new UserBean();
                                	failedBean.setpClientid(userBean.getpClientid());
                                	failedBean.setpNombre(userBean.getpNombre());
                                	failedBean.setpMobilePhone(userBean.getpMobilePhone());
                                	session.setAttribute(Constants.USR_SESION, failedBean);
                                	
                                	respuesta_ajax = "AC|<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span>Hemos verificado que el tel&eacute;fono registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/><span id='sms-message'>Ingresa tu tel&eacute;fono registrado o actual&iacute;za uno nuevo aqu&iacute;, para enviarte el sms de activaci&oacute;n de cuenta.</span>";
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
                                	session.setAttribute(Constants.USR_SESION, userBean);
                                    sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                                    clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                                    TeapuestoProcedureBetData teapuestoProcedureBetDataBean = teapuestoBo.findByClientId(userBean.getpClientid());
                                    monto1 = teapuestoProcedureBetDataBean.getBalanceAmount();
                                    monto2 = teapuestoProcedureBetDataBean.getBalanceAmountGame();
                                    
	                                respuesta_ajax = "OK|" + username + "|" + clientProcedureGetClient.getAmount() + "|" + clientId + "|" + monto1
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
                    } else
                        respuesta_ajax = "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado";
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

    @RequestMapping(value = "/ajaxJugadasTeapuesto")
    public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            Double availableBalance = 0.0;
            JsonArray data = new JsonParser().parse(request.getParameter("data")).getAsJsonArray();
            PrintWriter out = response.getWriter();
            int gameId = Game.TEAPUESTO;
            Game gm = new Game(gameId);
            String name_game = gm.getName();
            String ip = "";
            String clientId = "";
            if (session.getAttribute(Constants.USR_SESION) != null)
                clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
            int num_row = 1;
            JsonArray array_total = new JsonArray();
            for (JsonElement elem : data) {
                String play = elem.getAsJsonObject().get("play").toString().replaceAll("\"", "");
                int multiplier = Integer.parseInt(elem.getAsJsonObject().get("multiplier").toString());
                String combined = elem.getAsJsonObject().get("combined").toString().replaceAll("\"", "");
                int saleType = Integer.parseInt(elem.getAsJsonObject().get("saleType").toString());
                double price = Double.parseDouble(elem.getAsJsonObject().get("price").toString());
                ip = request.getRemoteAddr().toString();
                String[] o = GameSaleLotos5Dispatcher.playCouponByWeb(clientId, ip, gameId, play, 0, multiplier, combined, saleType, price, null, null);
                String ticket = "";
                if (o != null)
                    ticket = o[0] + "&" + o[1];
                JsonObject joTotal = new JsonObject();
                joTotal.addProperty("play", play);
                joTotal.addProperty("multiplier", multiplier);
                joTotal.addProperty("combined", combined);
                joTotal.addProperty("price", price);
                joTotal.addProperty("saleType", saleType);
                joTotal.addProperty("ticket", ticket);
                joTotal.addProperty("num_row", num_row);
                joTotal.addProperty("gameId", gameId);
                joTotal.addProperty("name_game", name_game);
                if (o != null) {
                    joTotal.addProperty("available_balance", o[3]);
                    joTotal.addProperty("promotional_balance", o[4]);
                    availableBalance = Double.parseDouble(o[3]);
                }
                array_total.add(joTotal);
                num_row++;
            }
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
        // o[3]-->Saldo disponible
        // o[4]-->Saldo promocional
    }

    @RequestMapping(value = "/ticket_vista_previa_popup_teapuesto")
    public ModelAndView ticket_vista_previa_popup_teapuesto(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Long ticketId = 0L;
        int gameId = 0, clientId = 0;
        JsonArray jugadaCompleta = new JsonArray();
        JsonObject datos_jugada = new JsonObject();
        FechazacotejadorUtil fechaza = new FechazacotejadorUtil();
        fechaza.reiniciando_valores();
        try {
            if (request.getParameter("ticketid") != null)
                ticketId = Long.parseLong(request.getParameter("ticketid"));
            if (request.getParameter("gameid") != null)
                gameId = Integer.parseInt(request.getParameter("gameid"));
            if (request.getParameter("clientid") != null)
                clientId = Integer.parseInt(request.getParameter("clientid"));
            datos_jugada.add("datos_jugada", teapuestoBo.datosCotejador(clientId, gameId, ticketId));
            datos_jugada.add("resultado_tabla", teapuestoBo.resultado_premios(clientId, gameId, ticketId));
            jugadaCompleta.add(datos_jugada);
            request.setAttribute("jugadaCompleta", jugadaCompleta);
            return new ModelAndView("game/teapuesto/teapuesto_popup_cotejo");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/teapuesto_popup_cotejo");
        } finally {
        }
    }
    
    @RequestMapping(value = "/lista-teapuesto")
    public String findTeApuestoList(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {  
        try { 
        	Map<TeapuestoProcedureDrawMenu, List<TeapuestoProcedureDrawData>> teapuestoSaleListDrawData = new LinkedHashMap<TeapuestoProcedureDrawMenu, List<TeapuestoProcedureDrawData>>();
            List<TeapuestoProcedureDrawMenu> teapuestoSaleListDrawMenu = teapuestoBo.findListDrawMenu();
            for (TeapuestoProcedureDrawMenu drawMenu : teapuestoSaleListDrawMenu) {
                List<TeapuestoProcedureDrawData> teapuestoProcedureDrawData = teapuestoBo.findListDrawData(drawMenu.getDrawId());
                Collections.reverse(teapuestoProcedureDrawData);
                teapuestoSaleListDrawData.put(drawMenu, teapuestoProcedureDrawData);
            }
            request.setAttribute("DrawData", teapuestoSaleListDrawData);
            
        	Map<TeapuestoProcedureExactMenu, TeapuestoProcedureExactData> teapuestoSaleExactData = new LinkedHashMap<TeapuestoProcedureExactMenu, TeapuestoProcedureExactData>();
            List<TeapuestoProcedureExactMenu> teapuestoSaleExactMenu = teapuestoBo.findListExactMenu();
            for (TeapuestoProcedureExactMenu exactMenu : teapuestoSaleExactMenu) {
                TeapuestoProcedureExactData teapuestoSale = teapuestoBo.findtExactData(exactMenu.getDrawId(), exactMenu.getEventId()); 
                teapuestoSaleExactData.put(exactMenu, teapuestoSale);
            }
            request.setAttribute("ExactData", teapuestoSaleExactData);
            
        	Map<TeapuestoProcedureSpecialHeader, Map<TeapuestoProcedureSpecialMenu, Map<TeapuestoProcedureSpecialGroup, List<TeapuestoProcedureSpecialData>>>>
        	    teapuestoSpecialHeader = new LinkedHashMap<TeapuestoProcedureSpecialHeader, Map<TeapuestoProcedureSpecialMenu, Map<TeapuestoProcedureSpecialGroup, List<TeapuestoProcedureSpecialData>>>>();
            List<TeapuestoProcedureSpecialHeader> teapuestoSaleSpecialHeader = teapuestoBo.findSpecialHeader();
            for (TeapuestoProcedureSpecialHeader specialHeader : teapuestoSaleSpecialHeader) {
            	
            	String header = specialHeader.getHeader();
            	Map<TeapuestoProcedureSpecialMenu, Map<TeapuestoProcedureSpecialGroup, List<TeapuestoProcedureSpecialData>>> teapuestoSpecialMenu = new LinkedHashMap<TeapuestoProcedureSpecialMenu, Map<TeapuestoProcedureSpecialGroup, List<TeapuestoProcedureSpecialData>>>();
                List<TeapuestoProcedureSpecialMenu> teapuestoProcedureSpecialMenu = teapuestoBo.findListSpecialMenu(header);
                for (TeapuestoProcedureSpecialMenu specialMenu : teapuestoProcedureSpecialMenu) {

                	Map<TeapuestoProcedureSpecialGroup, List<TeapuestoProcedureSpecialData>> teapuestoSpecialGroup = new LinkedHashMap<TeapuestoProcedureSpecialGroup, List<TeapuestoProcedureSpecialData>>();
                    List<TeapuestoProcedureSpecialGroup> teapuestoProcedureSpecialGroup = teapuestoBo.findListSpecialGroup(header, specialMenu.getTadrawId());
                    for (TeapuestoProcedureSpecialGroup specialGroup : teapuestoProcedureSpecialGroup) {
                    	
                        List<TeapuestoProcedureSpecialData> teapuestoProcedureSpecialData = teapuestoBo.findListSpecialData(header, specialMenu.getTadrawId(), specialGroup.getLeagueId());
                        teapuestoSpecialGroup.put(specialGroup, teapuestoProcedureSpecialData);
                        
                    }
                    teapuestoSpecialMenu.put(specialMenu, teapuestoSpecialGroup);

                }
                teapuestoSpecialHeader.put(specialHeader, teapuestoSpecialMenu);                
            } 
            request.setAttribute("SpecialData", teapuestoSpecialHeader);            
            return "game/teapuesto/teapuesto_list";
            
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/teapuesto/teapuesto_list";
        } finally {
        }
    }

}