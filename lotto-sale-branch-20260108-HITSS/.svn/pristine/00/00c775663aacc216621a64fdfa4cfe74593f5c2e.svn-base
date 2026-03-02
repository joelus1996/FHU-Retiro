package pe.com.intralot.loto.layer.controller.game.deportesvirtuales;

/**
 * @author:   Victor Farro Veramendi
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.DeportesvirtualesProcedureBetData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.game.deportesvirtuales.bo.DeportesVirtualesBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;

@Controller
public class DeportesvirtualesController {

    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private DeportesVirtualesBo deportesVirtualesBo;

    @RequestMapping(value = "/juega-deportesvirtuales")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        ClientProcedureGetDataClient dataClient = null;
        ClientProcedureGetClient clientProcedureGetClient = null;
        try {
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                idSession = userBean.getpSessionid();
                idClient = userBean.getpClientid();
                user = userBean.getpUser();
                clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                request.setAttribute("dataClient", dataClient);
                LoggerApi.Log.info("cid="+idClient+" idSession="+idSession+" user="+dataClient.getUser());
                if (clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
            } 
            /*if (idClient == 0) {
                session.invalidate();
                return "redirect:/inicio.html";
            }*/
            DeportesvirtualesProcedureBetData deportesvirtualesSaleBean = deportesVirtualesBo.findByClientId(idClient);
            LoggerApi.Log.info("cid="+idClient+" deportesvirtualesSale.message="+deportesvirtualesSaleBean.getMessage());
            request.setAttribute("deportesvirtualesSale", deportesvirtualesSaleBean);
            userBean.setpGame(717);
            session.setAttribute(Constants.USR_SESION, userBean);
            request.setAttribute("deportesVirtualesURI", String.valueOf(ConnectionFactory.operationProperty("kirongamesURI", Constants.contextCardWeb)).toString().trim());
            if(clientProcedureGetClient!=null && !clientProcedureGetClient.getSessionCode().equals("")) request.setAttribute("sessionCode", clientProcedureGetClient.getSessionCode() );
            
            return "game/deportesvirtuales/home_deportesvirtuales_user";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/deportesvirtuales/home_deportesvirtuales_user";
        } finally {
            request.setAttribute("isAllowed", deportesVirtualesBo.isAllowedGoIn(user));
        }
    }

    /*@RequestMapping(value = "/login_deportesvirtuales")
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
        		LoggerApi.Log.info("Entro a DeportesvirtualesController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a DeportesvirtualesController loginByUserPass con captcha");
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
                                // userBean.setpGame(Game.CLICYGANA);
                                userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
                                userBean.setpAgreement(agreement);
                                userBean.setpMailVerified(mverified);
                                userBean.setpPromotion(promotion);
                                userBean.setpPromotionibk(promotionibk);
                                session.setAttribute(Constants.USR_SESION, userBean);
                                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                                sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                                DeportesvirtualesProcedureBetData deportesvirtualesProcedureBetData = deportesVirtualesBo.findByClientId(idClient);
                                Double monto1 = deportesvirtualesProcedureBetData.getBalanceAmount();
                                Double monto2 = deportesvirtualesProcedureBetData.getBalanceAmountGame();
                                String user = deportesvirtualesProcedureBetData.getUser();
                                String nickName = deportesvirtualesProcedureBetData.getNickName();
                                String sessionCode = clientProcedureLogin.getSessionCode();
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
	                                        + "|" + monto2 + "|" + user + "|" + nickName + "|" + sessionCode + "|" + clientProcedureLogin.getLuckyIcon() + "|"
	                                        + dataClient.getNombre() + "|" + dataClient.getApPaterno() + "|" + dataClient.getApMaterno() + "|" + dataClient.getMail() + "|"
	                                        + dataClient.getMobilePhone() + "|" + dataClient.getCountry() + "|" + dataClient.getRegion() + "|" + dataClient.getAddress() + "|"
	                                        + dataClient.getTypeId() + "|" + dataClient.getNumberId() + "|" + dataClient.getControlAmount() + "|" + dataClient.getMail() + "|"
	                                        + dataClient.getClientId() + "|" + sessionId;
	                                LoggerApi.Log.info("cid="+idClient+" respuesta_ajax="+respuesta_ajax);
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
}
