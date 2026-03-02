package pe.com.intralot.loto.layer.controller.game.fechaza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.layer.service.game.fechaza.bo.FechazaBo;

@Controller
public class FechazaController {

    @Autowired
    private FechazaBo fechazaBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientTicketBo clientTicketBo;
/*
    @RequestMapping(value = "/juega-fechaza")
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
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                request.setAttribute("dataClient", dataClient);
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
            }
            
            //return "redirect:/mi-cuenta.html#jugadas";
             
            List<FechazaProcedureDrawData> fechazaSaleList = fechazaBo.findListDrawData();
            modelList.put("fechazaSaleList", fechazaSaleList);
            FechazaProcedureBetData fechazalSaleBean = fechazaBo.findByClientId(idClient);
            / *
             * fechazalSaleBean.setCloseDate(fechazaBo.DateFormat(fechazalSaleBean .getCloseDate()));
             * /
            request.setAttribute("fechazaSale", fechazalSaleBean);
            userBean.setpGame(Game.FECHAZALOTOS);
            session.setAttribute(Constants.USR_SESION, userBean);
            return "game/fechaza/home_fechaza_user";
            
        } catch (Exception e) {
            LoggerApi.severe(e);
            //request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            //return "game/fechaza/home_fechaza_user";
            return "redirect:/inicio.html";
        } finally {
            //request.setAttribute("isAllowed", fechazaBo.isAllowedGoIn(user));
        	request.setAttribute(Constants.ALERT_MSG, "Juego Fechaza cerrado.");
        }
    }

    @RequestMapping(value = "/login_fechaza")
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
        		LoggerApi.Log.info("Entro a FechazaController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a FechazaController loginByUserPass con captcha");
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
                        if (state == 1) {
                            mode = Integer.parseInt(clientProcedureLogin.getMode());
                            LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " Mode=" + mode);
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
                                userBean.setpGame(Game.FECHAZALOTOS);
                                userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
                                userBean.setpAgreement(agreement);
                                userBean.setpMailVerified(mverified);
                                userBean.setpPromotion(promotion);
                                userBean.setpPromotionibk(promotionibk);
                                session.setAttribute(Constants.USR_SESION, userBean);
                                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                                sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                                FechazaProcedureBetData fechazalSaleBean = fechazaBo.findByClientId(idClient);
                                Double monto1 = fechazalSaleBean.getBalanceAmount();
                                Double monto2 = fechazalSaleBean.getBalanceAmountGame();
                                if(agreement==null || agreement.trim().equals("")){
                                	respuesta_ajax = "TC|Por favor inf&oacute;rmese y confirme la aceptaci&oacute;n de los T&eacute;rminos y Condiciones.";
                                } else if(mverified!=null && !mverified.equals("S") && !mverified.equals("E") && !mverified.equals("P")) {
                                	if(mverified.equals("P")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/>Confirma que tu correo est&aacute; correctamente registrado o actual&iacute;zalo aqu&iacute;. Luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	if(mverified.equals("N")) respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico en tu cuenta, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";
                                	//if(mverified.equals("E")) respuesta_ajax = "MV|Hola, hemos verificado que no se ha enviado la confirmación al correo electr&oacute;nico de la cuenta <b>"+username+"</b>.<br/><br/>Reenvia aqu&iacute; un nuevo correo electr&oacute;nico, luego revisa tu correo, te enviaremos una nueva solicitud para que actives tu cuenta.";}
                                } else if(promotionibk!=null && !promotionibk.equals("")){
                                	respuesta_ajax = "IB|"+promotionibk;
                                } else if(promotion!=null && !promotion.equals("")){
                                	respuesta_ajax = "RD|"+promotion;
                                } else {
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
    }

    @RequestMapping(value = "/ajaxFechaza")
    public void ajaxJugadas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            double availableBalance = 0;
            int gameId;
            String ip;
            Double price;
            int multiDraws;
            String jugada;
            String clientId = "";
            if (session.getAttribute(Constants.USR_SESION) != null)
                clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
            String[] o = null;
            PrintWriter out = null;
            out = response.getWriter();
            String data = "";
            if (request.getParameter("dato") != null)
                data = String.valueOf(request.getParameter("dato"));
            String[] boleto = data.split("#");
            String array_total = "";
            for (String element : boleto) {
                String[] filas = element.split("\\|");
                String num_jugados = filas[0].trim();
                String num_sorteos = filas[1].trim();
                Double precio = Double.parseDouble(filas[2].trim());
                gameId = Game.FECHAZALOTOS;
                Game gm = new Game(gameId);
                String name_game = gm.getName();
                ip = request.getRemoteAddr().toString();
                price = precio;
                multiDraws = Integer.parseInt(num_sorteos);
                jugada = num_jugados;
                o = GameSaleLotos5Dispatcher.playCouponByWeb(clientId, ip, gameId, jugada, multiDraws, 0, "", 0, price, null, null);
                if (o != null) {
                    array_total += num_jugados + "|" + num_sorteos + "|" + precio + "|" + o[1] + "|" + o[0] + "|" + o[3] + "|" + o[4] + "|" + name_game + "|" + gameId + "#";
                    availableBalance = Double.parseDouble(o[3]);
                }
            }
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

    @RequestMapping(value = "/ticket_vista_previa_popup_fechaza")
    public ModelAndView ticket_vista_previa_popup_fechaza(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        Long ticketId = 0L;
        int drawId = 0, gameID = 0, clientid = 0;
        JsonArray jugadaCompleta = new JsonArray();
        JsonObject datos_jugada = new JsonObject();
        FechazacotejadorUtil fechaza = new FechazacotejadorUtil();
        fechaza.reiniciando_valores();
        try {
            HttpSession session = request.getSession();
            ticketId = Long.parseLong(request.getParameter("ticketid"));
            gameID = Integer.parseInt(request.getParameter("gameid"));
            clientid = Integer.parseInt(request.getParameter("clientid"));
            ClientTicket ticket = clientTicketBo.findById(ticketId);
            int from = ticket.getCtFromDraw();
            int to = ticket.getCtToDraw();
            datos_jugada.add("datos_jugada", fechazaBo.datosJugada(from, to, clientid, gameID, ticketId));
            datos_jugada.add("resultado_jugada", fechazaBo.resultado_premios(clientid, gameID, ticketId));
            jugadaCompleta.add(datos_jugada);
            request.setAttribute("jugadaCompleta", jugadaCompleta);
            return new ModelAndView("game/fechaza/fechaza_popup_cotejo");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/fechaza/fechaza_popup_cotejo");
        } finally {
        }
    }

    @RequestMapping(value = "/prize_table_fechaza")
    public ModelAndView findPrizeTableKinelo(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/fechaza/prize_table_fechaza");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/fechaza/prize_table_fechaza");
        } finally {
        }
    } */
}