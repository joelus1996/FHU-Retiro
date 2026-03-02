package pe.com.latinka.loto.layer.pam.cert;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;
import java.sql.SQLException;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.RegexValidator;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.dto.img.ImgDto;
import pe.com.intralot.loto.layer.model.bean.ClientBean;
import pe.com.intralot.loto.layer.model.bean.ResultBean;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateClientSamp;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivatePromotion;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureCancelPromotion;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivatePromotionibk;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateWBPromotion;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateWBPromotionibk;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureCancelPromotionibk;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureEditSelfcontrol;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetNewCode;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetNovusId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetPasswordCode;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureNewSessionData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureSessionData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateAgreement;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateMail;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePhone;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateSmsRegister;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureVerifyClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureVerifyClientBond;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureVerifyClientPromo;
import pe.com.intralot.loto.layer.model.domain.ClientSecurityProcedureCheckIp;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureUpdatePasswordNotification;
import pe.com.intralot.loto.layer.model.domain.Reclamacion;
import pe.com.intralot.loto.layer.model.domain.Region;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.CountryBo;
import pe.com.intralot.loto.layer.service.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.service.client.bo.RegionBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.lib.MailLib;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ApiNovusUtils;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.SecurityUtils;
import sun.misc.BASE64Decoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * NOMBRE: PAMCertClientSaleController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador datos de la cuenta
 * <br></p>
 * <p>
 * VERSION: 6295
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  ActivaciÛn del bono TA por recargas Interbank
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class PAMCertClientSaleController {

	@Autowired
	private ClientSaleBo clientSaleBo;
	@Autowired
	private SecurityUtils securityUtils;
    @Autowired
    private CountryBo countryBo;
    @Autowired
    private RegionBo regionBo;
    @Autowired
	private PaymentPrizeBo paymentPrizeBo;
    @Autowired
    private ClientBo clientBo;
      
    @RequestMapping(value = "/redireccionar")
    public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 return new ModelAndView("client/redirect");
    }

    @RequestMapping(value = "/inicio")
    public String loginByIdCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String plainstr = "";
        String random = "";
        int idGame = 0;
        long gettime = 0;
        int idClient = 0;
        int idSession = 0;
        String clname = "";
        String cluser = "";
        String status = "";
        int mode = 0;
        String authToken = "0";
        String channel = "";
        
        if( request.getParameter("channel")!= null) 
         channel = request.getParameter("channel");
        
        if (request.getParameter("clientId") != null)
            plainstr = request.getParameter("clientId");
        ClientProcedureSessionData clientProcedureSessionData = new ClientProcedureSessionData();
        ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        HttpSession session = request.getSession();
        UserBean userBean = new UserBean();
        try {
            if (plainstr != null && !plainstr.equals("")) {
                LoggerApi.Log.info("plainstr=" + plainstr);
                plainstr = plainstr.replace("+", "%2B");
                LoggerApi.Log.info("%plainstr=" + plainstr);
                plainstr = URLDecoder.decode(plainstr, "UTF-8");
                LoggerApi.Log.info("decoded=" + plainstr);
                plainstr = ClientUtils.decrypt_sda(plainstr);
                LoggerApi.Log.info("decrypt=" + plainstr);
                String[] arrPlainstr = plainstr.split("\\|");
                if (arrPlainstr.length > 1) {
                    LoggerApi.Log.info("gameId=" + arrPlainstr[1] + " clName=" + arrPlainstr[4] + " clUser=" + arrPlainstr[5] + " clientId=" + arrPlainstr[6] + " status="
                            + arrPlainstr[7] + " mode=" + arrPlainstr[8]);
                    if (arrPlainstr[0] != null && !arrPlainstr[0].trim().equals(""))
                        random = arrPlainstr[0].trim();
                    if (arrPlainstr[1] != null && !arrPlainstr[1].trim().equals(""))
                        idGame = Integer.parseInt(arrPlainstr[1].trim());
                    if (arrPlainstr[2] != null && !arrPlainstr[2].trim().equals(""))
                        gettime = Long.parseLong(arrPlainstr[2].trim());
                    if (arrPlainstr[3] != null && !arrPlainstr[3].trim().equals(""))
                        idSession = Integer.parseInt(arrPlainstr[3].trim());
                    if (arrPlainstr[4] != null && !arrPlainstr[4].trim().equals(""))
                        clname = arrPlainstr[4].trim();
                    if (arrPlainstr[5] != null && !arrPlainstr[5].trim().equals(""))
                        cluser = arrPlainstr[5].trim();
                    if (arrPlainstr[6] != null && !arrPlainstr[6].trim().equals(""))
                        idClient = Integer.parseInt(arrPlainstr[6].trim());
                    if (arrPlainstr[7] != null && !arrPlainstr[7].trim().equals(""))
                        status = arrPlainstr[7].trim();
                    if (arrPlainstr[8] != null && !arrPlainstr[8].trim().equals(""))
                        mode = Integer.parseInt(arrPlainstr[8].trim());
                    long timedelay = 0;
                    if (idClient > 0) {
                        clientProcedureSessionData = clientSaleBo.updateRandomCode(idSession, idClient, random);
                        if (mode == 0) {
                            if (clientProcedureSessionData != null && clientProcedureSessionData.getMessage().equals("OK")) {
                                Date today = clientProcedureSessionData.getSessiondate();// (Date) obj[1];
                                timedelay = today.getTime() - gettime;
                                if (timedelay >= 0 && timedelay < 10000) {
                                    clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                                    if (clientProcedureGetClient != null) {
                                        request.setAttribute("clientSale", clientProcedureGetClient);
                                        userBean.setpSessionid(idSession);
                                        userBean.setpUser(cluser);
                                        userBean.setpClientid(idClient);
                                        userBean.setpStatus(status);
                                        userBean.setpMode(mode);
                                        userBean.setpNombre(clname);
                                        userBean.setpMonto(clientProcedureGetClient.getAmount());
                                        userBean.setpGame(idGame);
                                        userBean.setpSessionCode(clientProcedureGetClient.getSessionCode());
                                        userBean.setpMailStatus(clientProcedureGetClient.getMailstatus());
                                        ClientProcedureTokenGeneration tokenGeneration = clientSaleBo.getToken(userBean.getpClientid(), channel, request.getRemoteAddr());
                                        if (tokenGeneration!=null && tokenGeneration.getMessage().equals("OK")) {
                                            authToken = tokenGeneration.getIflexToken();
                                            userBean.setpToken(authToken);
                                        } 
                                        session.setAttribute(Constants.USR_SESION, userBean);
                                    }
                                } else
                                    request.setAttribute(Constants.ALERT_MSG, "Excedi&oacute; el tiempo para cargar la p&aacute;gina por " + (10000 - timedelay) / 1000 + " seg.");
                            } else
                                request.setAttribute(Constants.ALERT_MSG, "No se logr&oacute; acceder. Vuelva a intentarlo. " + clientProcedureSessionData.getMessage());
                        } else
                            request.setAttribute(Constants.ALERT_MSG, "No puedes realizar jugadas con tu cuenta de asociado en esta p&aacute;gina.");
                    }
                }
                if (idGame == Game.GANADIARIO)
                    return "forward:/juega-ganadiario.html";
                else if (idGame == Game.TINKA || idGame == Game.MEGATINKA)
                    return "redirect:/juega-tinka.html";
                else if (idGame == Game.KABALA)
                    return "redirect:/juega-kabala.html";
                else if (idGame == Game.GANAGOL)
                    return "redirect:/juega-ganagol.html";
                else if (idGame == Game.FECHAZALOTOS)
                    return "redirect:/mi-cuenta.html#saldo";
                else if (idGame == Game.SUPER3)
                    return "redirect:/juega-super3.html";
                else if (idGame == Game.TEAPUESTO)
                    return "redirect:/juega-teapuesto.html";
                else if (idGame == Game.CLICYGANA)
                    return "redirect:/juega-clicygana.html";
                else if (idGame == Game.INSTANT)
                    return "redirect:/juega-rapitinkas.html";
                else if (idGame == 717)
                    return "redirect:/juega-deportesvirtuales.html";
                else if (idGame == Game.KINELO)
                    return "redirect:/juega-kinelo.html";
                else if (idGame == 1234567890)
                    return "redirect:/mi-cuenta.html#saldo";
                else
                    return "redirect:/inicio.html";
            } else {
            	try {
            		userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
//            		String closeSession=(String)session.getAttribute("closeSession");
//            		if(closeSession!=null) {
//            			request.setAttribute("closeSession", closeSession);
//            		}
//            		String urlTA=(String)session.getAttribute("urlTA");
//            		if(urlTA!=null) {
//            			request.setAttribute("urlTA", urlTA);
//            		}
				} catch (Exception e) {
					session.invalidate();
	            	session = request.getSession(true);
				}
            	return "index";
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            return "index";
        } finally {
            request.setAttribute("messagePromo", session.getAttribute("messagePromo"));
            session.removeAttribute("messagePromo");
            if(userBean!=null) LoggerApi.Log.info("Nombre=" + userBean.getpNombre() + " Amount=" + userBean.getpMonto());
        }
    }

    @RequestMapping(value = "/login")
    public void loginByUserPass(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        String username = "", password = "", capchaCode="";
        PrintWriter out = null;
        out = response.getWriter();
        String respuesta_ajax = "";
        HttpSession session = request.getSession();
        //ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        ClientProcedureLogin clientProcedureLogin = null;
        int mode = 0;
        Integer cid = 0;
        int captcha = 0;
        int state = 0;
        String agreement = "", mverified = "", phoneverified="", promotion = "", promotionibk = "";
        String authToken = "0";
        String channel = "1";
        try {
        	LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
            LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent")+" IP="+request.getRemoteAddr());
            
        	if(request.getParameter("captcha-client") == null) {
        		LoggerApi.Log.info("Entro a ClientSaleController loginByUserPass sin captcha");
        		captcha = 1;
			} else {
				capchaCode = request.getParameter("captcha-client");
				String sessionCaptchaCode = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				if(capchaCode.equals(sessionCaptchaCode)) {
					Logger.getLogger(LoggerAPI.SALECARD).info("Entro a ClientSaleController loginByUserPass con captcha");
					captcha = 2;
				}
			}
            if (request.getParameter("user-client") != null && request.getParameter("password-client") != null) {
                username = request.getParameter("user-client").toLowerCase().trim();
                password = request.getParameter("password-client").toUpperCase().trim();
                if (!username.equals("") && !password.equals("") && (captcha == 1 || captcha == 2)) {
                    clientProcedureLogin = clientSaleBo.findLogin(username, password);
                    if (clientProcedureLogin != null) {
                        state = clientProcedureLogin.getState();
                        cid = clientProcedureLogin.getClientId();
                        agreement = clientProcedureLogin.getAgreement();
                        mverified = clientProcedureLogin.getMailVerified();
                        phoneverified = clientProcedureLogin.getMobileStatus();
                        promotion = clientProcedureLogin.getPromotion();
                        promotionibk = clientProcedureLogin.getPromotionibk();
                        LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " clientProcedureLogin.getMode()=" + clientProcedureLogin.getMode());
                        if (state == 1) {
                            try {
                                mode = Integer.parseInt(clientProcedureLogin.getMode());
                            } catch (Exception e) {
                                mode = 999;
                            }
                            if (mode == 0) {
                                UserBean userBean = new UserBean();
                                userBean.setpSessionid(clientProcedureLogin.getSessionId());
                                userBean.setpUser(username);
                                userBean.setpClientid(clientProcedureLogin.getClientId());
                                userBean.setpMail(clientProcedureLogin.getMail());
                                userBean.setpSessionCode(clientProcedureLogin.getSessionCode());
                                userBean.setpStatus(clientProcedureLogin.getStatus());
                                userBean.setpMode(Integer.parseInt(clientProcedureLogin.getMode()));
                                userBean.setpLuckyIcon(clientProcedureLogin.getLuckyIcon());
                                userBean.setpAgreement(agreement);
                                userBean.setpMailVerified(mverified);
                     	    	userBean.setpMobilePhone(clientProcedureLogin.getMobilePhone());
                     	        userBean.setpMobileStatus(clientProcedureLogin.getMobileStatus());
                     	        userBean.setpPromotion(promotion);
                     	        userBean.setpPromotionibk(promotionibk);
                                
                                LoggerApi.Log.info("cid=" + cid + " getSessionId()=" + clientProcedureLogin.getSessionId());

	                                String nombre = clientProcedureLogin.getCl_nombre();
	                                Double kironAmount = 0.0;
	                                try { kironAmount = Double.parseDouble(clientProcedureLogin.getToday());
	                                } catch (Exception ex){}
	                                
                                    userBean.setpNombre(nombre);
                                    userBean.setpMonto(clientProcedureLogin.getBalanceAmount());
                                    userBean.setpMailStatus(clientProcedureLogin.getMailStatus());
                                    userBean.setpKironAmount(kironAmount);
                                    userBean.setpGame(0);
                                   
                                    if(agreement==null || agreement.trim().equals("")){
                                    	respuesta_ajax = "TC|Por favor inf&oacute;rmese y confirme la aceptaci&oacute;n de los T&eacute;rminos y Condiciones.";
                                    	UserBean failedBean = new UserBean();
                                    	failedBean.setpClientid(userBean.getpClientid());
                                    	session.setAttribute(Constants.USR_SESION, failedBean);
                                    	
                                    } else if(mverified!=null && !mverified.equals("S") && !mverified.equals("E") && !mverified.equals("P")) {
                                    	if(mverified.equals("P")) { respuesta_ajax = "MV|<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span>Hemos verificado que el correo electr&oacute;nico registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/>Ingresa tu correo registrado o actual&iacute;za uno nuevo aqu&iacute;, para enviarte la solicitud de activaci&oacute;n de cuenta.";}
                                    	if(mverified.equals("N")) { respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico de la cuenta <b>"+username+"</b> ha sido registrado en otra cuenta.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";}
                                    	//if(mverified.equals("N")) { respuesta_ajax = "MV|Hola, hemos verificado que el correo electr&oacute;nico de la cuenta <b>"+username+"</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico, luego revisa tu correo, te enviaremos una solicitud para que actives tu cuenta.";}
                                    	
                                    	UserBean failedBean = new UserBean();
                                    	failedBean.setpClientid(userBean.getpClientid());
                                    	failedBean.setpNombre(userBean.getpNombre());
                                    	failedBean.setpMail(userBean.getpMail());
                                    	failedBean.setpStatus(mverified);
                                    	session.setAttribute(Constants.USR_SESION, failedBean);	
                                    //} else if (phoneverified.equals("DES") || !ClientUtils.verifySintaxMobilePhone(clientProcedureLogin.getMobilePhone().toString().trim())) {
                                    } else if (Constants.flagValidacionSms.equals("true") && ((phoneverified.equals("DES") || !ClientUtils.verifySintaxMobilePhone(clientProcedureLogin.getMobilePhone().toString().trim())))) {
                                    	UserBean failedBean = new UserBean();
                                    	failedBean.setpClientid(userBean.getpClientid());
                                    	failedBean.setpNombre(userBean.getpNombre());
                                    	failedBean.setpMobilePhone(userBean.getpMobilePhone());
                                    	session.setAttribute(Constants.USR_SESION, failedBean);
                                    	
                                    	//respuesta_ajax = "AC|<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span>Hemos verificado que el tel&eacute;fono registrado en tu cuenta <b>"+username+"</b> a&uacute;n no ha sido activado.<br/><br/>Ingresa tu tel&eacute;fono registrado o actual&iacute;za uno nuevo aqu&iacute;, para enviarte el SMS de activaci&oacute;n de cuenta.";
                                    	respuesta_ajax = "AC|<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span>Ingresa el celular registrado en tu cuenta (Ejm: 999112233) o actual&iacute;zalo aqu&iacute;.<br/>Recibir&aacute;s un SMS con un c&oacute;digo de activaci&oacute;n.";
                                    	
                                    } else if(Constants.flagRecargaInterbank.equals("true")  && (promotionibk!=null && !promotionibk.equals(""))){
                                    	respuesta_ajax = "IB|"+promotionibk;
                                    	UserBean failedBean = new UserBean();
                                    	failedBean.setpClientid(userBean.getpClientid());
                                    	session.setAttribute(Constants.USR_SESION, failedBean);
                                    } else if(Constants.flagRecargaRedDigital.equals("true")  && (promotion!=null && !promotion.equals(""))){
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
                                    	respuesta_ajax = "OK|" + username + "|" + clientProcedureLogin.getBalanceAmount() + "|"
                                            + clientProcedureLogin.getClientId() + "|" + clientProcedureLogin.getMailStatus() + "|" + clientProcedureLogin.getSessionCode()
                                            + "|" + clientProcedureLogin.getLuckyIcon();
                                    	request.setAttribute("clientSale", clientProcedureLogin);
                                    }
                                    LoggerApi.Log.info("ESTADO VERIFICACION CORREO: "+mverified);
                                    LoggerApi.Log.info("ESTADO VERIFICACION TELEFONO: "+phoneverified);
                                
                            } else if (mode > 0)
                                respuesta_ajax = "Con esta cuenta no es posible ingresar a este sistema.";
                        } else if (state == 2)
                            respuesta_ajax = "CC|El usuario o contraseÒa son inv·lidos";
                        else if (state == 3)
                            respuesta_ajax = "El usuario o contraseÒa son inv·lidos";
                        else if (state == -1)
                            respuesta_ajax = "Este usuario ha sido bloqueado, comun&iacute;quese a La Tinka";
                        else
                            respuesta_ajax = "El usuario o contraseÒa son inv·lidos";
                    }
                } else {
                	respuesta_ajax = "CC|Ingresa el texto de la imagen correctamente.";
                }
                out.print(respuesta_ajax);
                LoggerApi.Log.info("cid=" + cid + " respuesta_ajax=" + respuesta_ajax);
                LoggerApi.Log.info("cid=" + cid + " Username=" + username + " State=" + state + " Mode=" + mode);
            } else respuesta_ajax = "Usuario "+request.getParameter("user-client")+" no encontrado";
        } catch (Exception e) {
            respuesta_ajax = "Sucedio un error al iniciar sesi&oacute;n";
            out.print(respuesta_ajax);
            LoggerApi.severe(e, respuesta_ajax, respuesta_ajax);
        } finally {
            if (clientProcedureLogin != null)
                LoggerApi.Log.info("cid=" + cid + " Nombre=" + clientProcedureLogin.getCl_nombre() + " Amount=" + clientProcedureLogin.getBalanceAmount() );
            else
                LoggerApi.Log.info("cid=" + cid + " clientProcedureGetClient=null");
        }
    }
    
    @RequestMapping(value = "/salirCA")
    public void logoutUserCA(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("salirCA");
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	HttpSession session = request.getSession();
        ClientUpdateProcedureClosedSession closedSession=null;
        try {
            if (session != null) {
            	JsonParser jparser = new JsonParser();
            	if(session.getAttribute("sessionData")!=null) {
            		JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
    	        	Integer clientId=sessionData.get("clientId").getAsInt();                    
                    closedSession=clientBo.closedSession(clientId);
                    LoggerApi.Log.info("closedSession: estado="+closedSession.getState()+" mensaje="+closedSession.getMessage());
            	}            	
                session.invalidate();
            }
            o.addProperty("eCommerceHome", ConnectionFactory.operationProperty("eCommerceHome", Constants.contextSale));
            out.print(o);
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos." + id);
            o.addProperty("eCommerceHome", ConnectionFactory.operationProperty("eCommerceHome", Constants.contextSale));
            out.print(o);
        } 
    }

    @RequestMapping(value = "/salir")
    public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        ClientUpdateProcedureClosedSession closedSession=null;
        try {
            if (session != null) {
            	JsonParser jparser = new JsonParser();
            	if(session.getAttribute("sessionData")!=null) {
            		JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
    	        	Integer clientId=sessionData.get("clientId").getAsInt();                    
                    closedSession=clientBo.closedSession(clientId);
                    LoggerApi.Log.info("closedSession: estado="+closedSession.getState()+" mensaje="+closedSession.getMessage());
            	} 
            	String urlTA=securityUtils.fetchTA(request, response);                
                session.invalidate();
                session = request.getSession();
                session.setAttribute("urlTA", urlTA);
            }
            if(request.getParameter("urlRedirect5587") != null ) {
            	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== salir urlRedirect5587="+request.getParameter("urlRedirect5587"));
            	return new ModelAndView("redirect:"+request.getParameter("urlRedirect5587"));
            }
            if(request.getParameter("urlRedirect5588") != null )
            	return new ModelAndView("redirect:"+request.getParameter("urlRedirect5588"));
            
            return new ModelAndView("redirect:inicio.html");
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos." + id);
            return new ModelAndView("redirect:inicio.html");
        } finally {
        }
    }
    
    @RequestMapping(value = "/close-session")
	public void closeSession(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
            	 session.invalidate();
            }            
            PrintWriter out = response.getWriter();
        	JsonObject o = new JsonObject();
        	o.addProperty("close", "OK");
        	out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        }
    }
    
    @RequestMapping(value = "/volver")
    public String logoutByIdCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // IndexForm formbean = (IndexForm)form;
        // AccountController controller = new AccountController();
        ClientProcedureNewSessionData clientProcedureNewSessionData = new ClientProcedureNewSessionData();
        //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        HttpSession session = request.getSession();
        String plainurl = "";
        try {
            // if(formbean.getS() != null) gameid = formbean.getS();
            /*
             * Date today = new Date(); if(today != null) { Calendar cal = Calendar.getInstance(); cal.setTime(today); //cal.set(Calendar.HOUR_OF_DAY, 0); //cal.set(Calendar.MINUTE, 0);
             * //cal.set(Calendar.SECOND, 0); cal.set(Calendar.MILLISECOND, 0); //today.setTime(cal.getTime().getTime()); today = cal.getTime(); }
             */
            String lotogame = String.valueOf(ConnectionFactory.operationProperty("lotocardServerURI", context)).toString().trim();
            // String appArea = String.valueOf(ConnectionFactory.operationProperty("applicationArea",context)).toString().trim().toUpperCase();
            String sessionId = " ";
            String clientName = " ";
            String username = " ";
            String clientId = " ";
            String status = " ";
            int gameid = 0;
            String mode = " ";
            String random = " ";
            long datetime = 0;
            if (session.getAttribute(Constants.USR_SESION) != null) {
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid().equals(""))
                    sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid().toString();
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpNombre() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpNombre().equals(""))
                    clientName = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpNombre();
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser().equals(""))
                    username = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser();
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().equals(""))
                    clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString();
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpStatus() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpStatus().equals(""))
                    status = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpStatus();
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpGame() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpGame().equals(""))
                    gameid = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpGame();
                if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpMode() != null
                        && !((UserBean) session.getAttribute(Constants.USR_SESION)).getpMode().equals(""))
                    mode = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpMode()).toString();
                Random r = new Random();
                int te = r.nextInt(25);
                random = ClientUtils.randomString(100 + te);
                // random = StringLib.encodeLongLabel(random);
                // datetime = controller.updClientRandomCode(sessionId, clientId, random);
                if (!sessionId.trim().equals("") && !clientId.trim().equals("")) {
                    int idsession = Integer.parseInt(sessionId);
                    int idclient = Integer.parseInt(clientId);
                    clientProcedureNewSessionData = clientSaleBo.setClientRandomCode(idsession, idclient, random);
                    datetime = ((Date) clientProcedureNewSessionData.getSessiondate()).getTime();
                }
            }
            String plainstr = random + "|" + gameid + "|" + datetime + "|" + sessionId + "|" + clientName + "|" + username + "|" + clientId + "|" + status + "|" + mode;
            // plainstr = plainstr.replaceAll("\\+", "\\\\+").replaceAll("\\/","\\\\/");
            // LoggerApi.Log.info("plainstr="+plainstr);
            // Logger.getLogger(LoggerAPI.SALECARD).info("plainstr="+plainstr);
            LoggerApi.Log.info("plainstr=" + plainstr);
            plainurl = lotogame + "i.do?m=oldHome&k=";
            /*
             * if(appArea.equals("PRODUCTION")) plainstr = ClientUtils.encrypt_sda(plainstr); else
             */
            plainstr = URLEncoder.encode(ClientUtils.encrypt_sda(plainstr), "UTF-8");
            // Logger.getLogger(LoggerAPI.SALECARD).info("encrypt="+plainstr);
            LoggerApi.Log.info("encrypt=" + plainstr);
            plainurl += plainstr;
            // Logger.getLogger(LoggerAPI.SALECARD).info("plainurl="+plainurl);
            // LoggerApi.Log.info("plainurl="+plainurl);
            // LoggerApi.Log.info("plainstr1="+plainstr);
            // plainstr = lotosale+"/inicio.html?clientId="+plainstr.replaceAll("\\+", "%2B").replaceAll("\\/", "%2F");
            // LoggerApi.Log.info("plainstr2="+plainstr);
            // formbean.setP("newhome");
            // formbean.setK(plainurl);
            // ClientUtils.excutePost(lotosale+"/inicio.html", "clientId="+URLEncoder.encode(plainstr, "UTF-8"));
            /*
             * // initialize the POST method PostMethod post = new PostMethod(lotosale+"/inicio.html"); post.addParameter("clientId",URLEncoder.encode(plainstr, "UTF-8")); // execute the POST
             * HttpClient client = new HttpClient(); int st = client.executeMethod(post); String rs = post.getResponseBodyAsString();
             */
            // response.sendRedirect("");
            // RequestDispatcher rd = request.getRequestDispatcher(response.encodeURL(lotosale+"/inicio.html?clientId="+plainstr));
            // rd.forward(request, response);
            return "redirect:" + plainurl;
        } catch (Exception e) {
            LoggerApi.severe(e);
            return loginByIdCliente(request, response);
        } finally {
            // Logger.getLogger(LoggerAPI.SALECARD).finest(" IndexAction.newHome()--> plainstr="+formbean.getK());
            LoggerApi.Log.info("plainurl=" + plainurl);
        }
    }
    
    @RequestMapping(value = "/activar")
    public String formActivar(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
    	
    	return "client/activate_form";
    }
    
    @RequestMapping(value = "/registro")
    public String formRegisterUserv2(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
    	try {
    		HttpSession session = request.getSession();
    		JsonObject o = new JsonObject();
    		String mailCode = (String)session.getAttribute("keyCode");
    		if(mailCode!=null && mailCode.trim().length()>0) o.addProperty("keycode", mailCode);
    		
    		UserBean userBean = null;
//            if (session.getAttribute(Constants.USR_SESION) != null) {
        	if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
            	return "index";
//                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
//                Integer clientId = userBean.getpClientid();
//                Integer sessionId = userBean.getpSessionid();
//                ClientProcedureGetDataClient clientProcedureGetDataClient = null;
//                if (sessionId != null && clientId != null)
//                    clientProcedureGetDataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
//                if (clientProcedureGetDataClient != null) {
//                    o.addProperty("clientId", clientProcedureGetDataClient.getClientId());
//                    o.addProperty("email", clientProcedureGetDataClient.getMail());
//                    o.addProperty("name", clientProcedureGetDataClient.getNombre());
//                }
            }
            request.setAttribute("DataUser", o);
            
            if(request.getParameter("operatorId")!=null) {
            	session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            	session.setAttribute("OperatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            }else {
            	session.setAttribute("operatorId", "");
            	session.setAttribute("OperatorId", "");
            }
            if(request.getParameter("redirectGame")!=null) {
            	session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
            }else {
            	session.setAttribute("redirectGame", "");
            }
            if(request.getParameter("ref")!=null) {
            	session.setAttribute("ref", String.valueOf(request.getParameter("ref")).toString().trim());
            }else {
            	session.setAttribute("ref", "");
            }
            if(request.getParameter("urlRedirect5588")!=null) {
            	session.setAttribute("urlRedirect5588", String.valueOf(request.getParameter("urlRedirect5588")).toString().trim());
            }else {
            	session.setAttribute("urlRedirect5588", "");
            }
            if(request.getParameter("urlRedirect5587")!=null) {
            	session.setAttribute("urlRedirect5587", String.valueOf(request.getParameter("urlRedirect5587")).toString().trim());
            }else {
            	session.setAttribute("urlRedirect5587", "");
            }
            modelList.put("OperatorId", request.getParameter("operatorId"));
            modelList.put("redirectGame", request.getParameter("redirectGame"));
            modelList.put("urlRedirect5588", request.getParameter("urlRedirect5588"));
            modelList.put("urlRedirect5587", request.getParameter("urlRedirect5587"));
            modelList.put("ref", request.getParameter("ref"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    	Constants.BANNER_REGISTRO  = ConnectionFactory.operationProperty("bannerRegistro", Constants.contextSale);
    	return "client/registration_form_v2";
    }
   
    /*
    @RequestMapping(value = "/registro")
    public String formRegisterUser(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
        try {
            HttpSession session = request.getSession();
            JsonObject o = new JsonObject();
            //JsonObject joDataClient = new JsonObject();
            //joDataClient = (JsonObject) request.getAttribute("DataClient");
            String mailCode = (String)session.getAttribute("keyCode");
            //System.out.println("mailCode="+mailCode);
            if(mailCode!=null && mailCode.trim().length()>0) o.addProperty("keycode", mailCode);
            List<Country> countries = countryBo.findCountry();
            if (countries != null)
                modelList.put("countries", countries);
            List<Region> regions = regionBo.findRegion();
            if (regions != null)
                modelList.put("regions", regions);
            UserBean userBean = null;
            if (session.getAttribute(Constants.USR_SESION) != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                Integer clientId = userBean.getpClientid();
                Integer sessionId = userBean.getpSessionid();
                ClientProcedureGetDataClient clientProcedureGetDataClient = null;
                if (sessionId != null && clientId != null)
                    clientProcedureGetDataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
                if (clientProcedureGetDataClient != null) {
                    o.addProperty("clientId", clientProcedureGetDataClient.getClientId());
                    o.addProperty("email", clientProcedureGetDataClient.getMail());
                    o.addProperty("name", clientProcedureGetDataClient.getNombre());
                }
            }
            request.setAttribute("DataUser", o);
            
            if(request.getParameter("operatorId")!=null) session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            if(request.getParameter("redirectGame")!=null) session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
            if(request.getParameter("ref")!=null) session.setAttribute("ref", String.valueOf(request.getParameter("ref")).toString().trim());
            modelList.put("OperatorId", request.getParameter("operatorId"));
            modelList.put("redirectGame", request.getParameter("redirectGame"));
            modelList.put("urlRedirect5588", request.getParameter("urlRedirect5588"));
            modelList.put("ref", request.getParameter("ref"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "client/registration_form";
    }
    */

    @RequestMapping("/registrarReclamacion")
    public void registrarReclamacion(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	JsonObject o = new JsonObject();
    	PrintWriter out = response.getWriter();
    	try {
    		String dni         = request.getParameter("document-number");
        	String email       = request.getParameter("email");
        	String nombre      = request.getParameter("nombre");
        	String direccion   = request.getParameter("direccion");
        	String telefono    = request.getParameter("telefono");
        	String tipobien    = request.getParameter("tipobien");
        	String monto       = request.getParameter("monto");
        	String bien        = request.getParameter("bien");
        	String tiporeclamo = request.getParameter("tiporeclamo");
        	String reclamo     = request.getParameter("reclamo");
        	String pedido      = request.getParameter("pedido");
        	String imgTinka= "https://www.latinka.com.pe/latinka/mailing-sale/logo_tinka.gif";
    		String imgBanner ="https://www.latinka.com.pe/latinka/mailing-sale/collage-logos.gif";
    		String[] imgEviList = new String[3];
    		imgEviList[0] = request.getParameter("imgEvi1")!=null?request.getParameter("imgEvi1").replace(" ","+") :"";
       		imgEviList[1] = request.getParameter("imgEvi2")!=null?request.getParameter("imgEvi2").replace(" ","+") :"";
       		imgEviList[2] = request.getParameter("imgEvi3")!=null?request.getParameter("imgEvi3").replace(" ","+") :"";
       		
        	Reclamacion reclamacion = new Reclamacion();
        	reclamacion.setId(109951);
        	reclamacion.setNombre(nombre);
        	reclamacion.setDireccion(direccion);
        	reclamacion.setDni(dni);
        	reclamacion.setTelefono(telefono);
        	reclamacion.setEmail(email);
        	reclamacion.setTipoBien(tipobien);
        	reclamacion.setBien(bien);
        	reclamacion.setTipoReclamo(tiporeclamo);
        	reclamacion.setReclamo(reclamo);
        	reclamacion.setMonto(monto);
        	reclamacion.setPedido(pedido);
        	reclamacion.setImgEviList(imgEviList);
        	
        	List<ImgDto> listaImgDto= new ArrayList<ImgDto>();
           	BufferedImage image = null;
    		try {
    			for(int i=0;i<imgEviList.length;i++) {
               		if(!imgEviList[i].trim().isEmpty()) {
        				Double peso = 0.0;
        				BASE64Decoder decoder = new BASE64Decoder();
        				ImgDto imgdto = new ImgDto();
        				byte[] decodedBytes = decoder.decodeBuffer(imgEviList[i].substring(imgEviList[i].indexOf(",")+1)); 
        				String extension = imgEviList[i].substring(imgEviList[i].indexOf("/")+1,imgEviList[i].indexOf(";")) ;
        				peso = (double) decodedBytes.length;
        				if( (peso/1024/1024)<=10.0) {
        					try {
        						 ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
        						 image = ImageIO.read(bis);
        						 bis.close();
        				        
        	        			imgdto.setContenidoImg(decodedBytes);
        	        			imgdto.setFileName("img"+(i+1)+"."+extension);
        	        			if(extension.contains("png")) {
        	        				imgdto.setTipoImg("image/png");
        	        			}else if(extension.contains("jpeg")) {
        	        				imgdto.setTipoImg("image/jpeg");
        	        			}else if(extension.contains("jpg")) {
        	        				imgdto.setTipoImg("image/jpg");
        	        			}
        	        			listaImgDto.add(imgdto);
        					} catch (Exception e) {
        						System.out.println("El archivo no es una imagen");
        						System.out.println("catch IOException : "+e.getMessage());
        						o.addProperty("message", "KO");
        						o.addProperty("error", "<p>Debes adjuntar im·genes v&aacute;lidas</p>");
        						out.print(o);
        					} 							    
        	    		}else {
        	    			o.addProperty("message", "KO");
        	    			o.addProperty("error", "T&uacute; imagen de Evidencia no debe ser mayor a 10MB");
        	    			out.print(o);
        	    		}
        			}
            	}
    		
	           	try {
	           		reclamacion = clientSaleBo.registrarReclamacion(reclamacion);
	        		
	            	String body = "<html>\r\n" + 
	            			"<head>\r\n" + 
	            			"<title>La Tinka - Libro de Reclamaciones</title>\r\n" + 
	            			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
	            			"</head>\r\n" + 
	            			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
	            			"\r\n" + 
	            			"<table width=\"600\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	            			"		<td colspan=\"3\" bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>\r\n" + 
	            			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"3\">\r\n" + 
	            			"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	            			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>\r\n" + 
	            			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong> " +nombre+ "</strong></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"50\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">Tu reclamo N∞ "+reclamacion.getSecuencia()+" ha sido registrado y ser&aacute; atendido dentro del plazo establecido. Te enviamos una copia de los datos recibidos.</td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"	<td width=\"20\"></td>\r\n" + 
	            			"	<td width=\"430\" bgcolor=\"#ffffff\" style=\"display:block; color:#5a5a5a; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">\r\n" + 
	            			"		<strong>HOJA DE RECLAMACI&Oacute;N </strong><br><br>\r\n" + 
	            			"		Fecha: "+reclamacion.getFecha()+"<br>\r\n" + 
	            			"		<br>\r\n" + 
	            			"		<strong>1. IDENTIFICACI&Oacute;N DEL CONSUMIDOR RECLAMANTE </strong><br><br>\r\n" + 
	            			"		Nombre: "+nombre+"<br>\r\n" + 
	            			"		Domicilio: "+direccion+"<br>\r\n" + 
	            			"		DNI/CE: "+dni+"<br>\r\n" + 
	            			"		Tel&eacute;fono: "+telefono+"<br>\r\n" + 
	            			"		E-mail: "+email+"<br>\r\n" + 
	            			"		<br>\r\n" + 
	            			"		<strong>2. IDENTIFICACI&Oacute;N DEL BIEN CONTRATADO</strong><br>\r\n" + 
	            			"		"+tipobien+"<br>\r\n" + 
	            			"		Monto reclamado: "+monto+"<br>\r\n" + 
	            			"		Descripci&oacute;n: "+bien+"<br>\r\n" + 
	            			"		<br>\r\n" + 
	            			"		<strong>3. DETALLE DE LA RECLAMACI&Oacute;N</strong><br>\r\n" + 
	            			"		"+tiporeclamo+"<br>\r\n" + 
	            			"		Detalle: "+reclamo+"<br>\r\n" + 
	            			"		Pedido: "+pedido+"<br>\r\n" + 
	            			"		<br>\r\n" + 
	            			"\r\n" + 
	            			"		</td>\r\n" + 
	            			"		<td width=\"20\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td width=\"20\"></td>\r\n" + 
	            			"		<td bgcolor=\"#ffffff\" width=\"430\" alt=\"\" style=\"display:block; color:#707070; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:11px; padding-left\">Responderemos tu reclamo en un plazo de 15 d&iacute;as h&aacute;biles, el cual empieza a contar a partir del d&iacute;a siguiente de ingresado.\r\n" + 
	            			"		<br><br></td>\r\n" + 
	            			"		<td width=\"20\"></td>\r\n" + 
	            			"	</tr>	\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"5\" bgcolor=\"#dedede\">\r\n" + 
	            			"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"	<tr>\r\n" + 
	            			"		<td colspan=\"5\" bgcolor=\"#dedede\" width=\"600\" height=\"20\" alt=\"\"></td>\r\n" + 
	            			"	</tr>\r\n" + 
	            			"</table>\r\n" + 
	            			"</body>\r\n" + 
	            			"</html>";
	            			
	            	String subject = "Hoja de ReclamaciÛn 109951-"+reclamacion.getSecuencia();
	            	//pe.com.intralot.loto.lib.MailLib.sendMail(email , subject , body);
	            	pe.com.intralot.loto.util.MailLib.sendMail(email , subject , body);
	                pe.com.intralot.loto.lib.MailLib.sendValidMail("reclamos@latinka.com.pe" , subject , body);
	            	
	               	String sdSubject = "###ASD Hoja de ReclamaciÛn Virtual 109951-"+reclamacion.getSecuencia();          
	               	String sdBody = 
	        						"##OPERATION=ADD_REQUEST##\r\n"+
	        						"##REQUESTTEMPLATE=Reclamos##\r\n"+
	        						"##CATEGORY=Reclamos##\r\n"+
	        						"##SUBCATEGORY=Por determinar##\r\n"+
	        						"##ITEM=Por determinar##\r\n"+
	        						"##REQUESTER=Service Desk##\r\n"+
	        						"##REQUESTTYPE=Incident##\r\n"+
	        						"\r\n"+
	        						"##SUBJECT=Hoja de ReclamaciÛn Virtual 109951-"+reclamacion.getSecuencia()+"##\r\n"+   
	        						"##UDF_CHAR12="+nombre+"##\r\n"+
	        						"##UDF_CHAR13="+direccion+"##\r\n"+
	        						"##UDF_CHAR14=DNI"+dni+"##\r\n"+
	        						"##UDF_CHAR15="+telefono+"##\r\n"+
	        						"##UDF_CHAR16="+email+"##\r\n"+
	        						"##UDF_CHAR17="+tipobien+"##\r\n"+
	        						"##UDF_DOUBLE2="+monto+"##\r\n"+
	        						"##UDF_CHAR21="+bien+"##\r\n"+
	        						"##UDF_CHAR18="+tiporeclamo+"##\r\n"+
	        						"##UDF_CHAR19="+reclamo+"##\r\n"+
	        						"##UDF_CHAR20="+pedido+"##\r\n"+
	        						"##UDF_CHAR22=Hoja de ReclamaciÛn Virtual##\r\n";
	               	
	                sdBody += "\r\n\r\n"+sdBody.replace("<br/>", "\r\n");
	        		
	               	//sendRawMail("reclamosvirtuales@latinka.com.pe","AtencionesSD@latinka.com.pe", sdSubject, sdBody,listaImgDto);
	               	sendRawMail("reclamosvirtuales@latinka.com.pe","ventasaltas@sdp731217583.zm.sdpondemand.com", sdSubject, sdBody,listaImgDto);
	               	try { sendRawMail("reclamosvirtuales@latinka.com.pe","soporteweb@latinka.com.pe", sdSubject, sdBody,listaImgDto); } catch (Exception e) {;}
	               	
	            	o.addProperty("message", "OK");
	            	o.addProperty("dni", dni);
	            	o.addProperty("email", email);
	            	o.addProperty("nombre", nombre);
	            	o.addProperty("direccion", direccion);
	            	o.addProperty("telefono", telefono);
	            	o.addProperty("tipobien", tipobien);
	            	o.addProperty("monto", monto);
	            	o.addProperty("bien", bien);
	            	o.addProperty("tiporeclamo", tiporeclamo);
	            	o.addProperty("reclamo", reclamo);
	            	o.addProperty("pedido", pedido);
	            	o.addProperty("secuencia", reclamacion.getSecuencia());
	            	o.addProperty("fecha", reclamacion.getFecha());
	            	out.print(o);
            	
	           	}catch(SQLException e) {
		       		System.out.println("catch SQL Exception: " + e.getMessage());
					o.addProperty("message", "KO");
					o.addProperty("error", "<p>Ya existe Reclamaci&oacute;n con fecha de hoy para su DNI:"+reclamacion.getDni()+"</p>");
					out.print(o);
		       	}
			}catch(Exception e) {
				System.out.println("catch de imagenes Exception: " + e.getMessage());
				o.addProperty("message", "KOImg");
				o.addProperty("error", "<p>Se produjo un error inesperado al cargar las im&aacute;genes, int&eacute;ntelo nuevamente</p>");
				out.print(o);
			}   	
        	
		}catch (Exception e) {
			pe.com.intralot.loto.lib.MailLib.sendValidMail("DesarrollodeSistemas@latinka.com.pe" , "LIBRO DE RECLAMACIONES "+e.getMessage(), e.toString() );
			o.addProperty("message", "KO");
			o.addProperty("error", "<p>Revise los datos antes de enviarlos. Alguno de ellos puede tener un tamaÒo muy grande.</p>");
			out.print(o);
		}
    }
    
    private void sendRawMail(String mailSource, String mailTarget, String mailSubject, String mailBody,List<ImgDto> listImgDto) {
		try {

			Session session = null;
			
			String contentType = "text/plain; charset=UTF-8";
			
			System.out.println(">>>>>> START sendRawMail mailSource="+mailSource+" mailTarget="+mailTarget);
			System.out.println("sendRawMail mailSubject="+mailSubject);
			System.out.println("sendRawMail mailBody="+mailBody);
			
			String mailServer = "";
			
			try {
				Context ic = new InitialContext();
				session = (Session)ic.lookup("java:Mail"); 
				//session = (javax.mail.Session) new javax.naming.InitialContext().lookup("java:Mail");
				System.out.println("sendRawMail session=java:Mail");
				 
				System.out.println( "host="+session.getProperty("mail.smtp.host") );
				System.out.println( "port="+session.getProperty("mail.smtp.port") );
				System.out.println( "from="+session.getProperty("mail.from") );
				System.out.println( "user="+session.getProperty("User") );
			
				 
			} catch (javax.naming.NamingException e) {
				//System.out.println("mailBody="+mailBody);
				try {
					mailServer = ConnectionFactory.operationProperty("mailServer", "CARD-SMS"); //MAIL_SERVER;
					//mailSource = operationProperty("mailSource", context); //MAIL_SOURCE;
					//System.out.println("mailServer="+mailServer);
					java.util.Properties props = new java.util.Properties();
					props.put("mail.smtp.host", mailServer);
					session = Session.getInstance(props, null);
				} catch (Exception ex) {
					System.out.println("sendRawMail ex.getMessage()="+ex.getMessage());
					//ex.printStackTrace(System.out);
				}
				System.out.println("sendRawMail mailServer="+mailServer);
			}
			
			// construct the message

			Message msg = new MimeMessage(session);
			
			InternetAddress[] ccaddress = InternetAddress.parse(StringLib.removeWhitespaces(mailTarget));
			
			if (mailSource!=null) {
				InternetAddress from = new InternetAddress(mailSource);//(origen);
		        msg.setFrom(from);
			}
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailBody, contentType);
			
			multipart.addBodyPart(messageBodyPart);
			
			if(listImgDto != null) {
				for(ImgDto imgdto : listImgDto) {
	        		BodyPart adjunto = new MimeBodyPart();
		       		ByteArrayDataSource attachment = new  ByteArrayDataSource(imgdto.getContenidoImg(),imgdto.getTipoImg());
		       		adjunto.setDataHandler(new DataHandler(attachment));
		            adjunto.setFileName(imgdto.getFileName());
		            multipart.addBodyPart(adjunto);
	        	}
			}
        	
			System.out.println("sendRawMail contentType="+contentType);

			
			// enviamos todo el contenido
			msg.setRecipients(Message.RecipientType.TO,ccaddress);
			msg.setSubject(mailSubject);//(subject);
			msg.setContent(multipart, contentType);
			msg.setHeader("Content-Transfer-Encoding", "binary");
			
			Transport.send(msg);
			
			System.out.println("<<<<<< END sendRawMail mailSource="+mailSource+" mailTarget="+mailTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
    
	public static void sendRawMail(String mailSource, String mailTarget, String mailSubject, String mailBody)  
	{ 
		try {

			Session session = null;
			
			String contentType = "text/plain; charset=UTF-8";
			
			System.out.println(">>>>>> START sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
			System.out.println("sendValidMail mailSubject="+mailSubject);
			System.out.println("sendValidMail mailBody="+mailBody);
			
			String mailServer = "";
			
			try {
				Context ic = new InitialContext();
				session = (Session)ic.lookup("java:Mail"); 
				//session = (javax.mail.Session) new javax.naming.InitialContext().lookup("java:Mail");
				System.out.println("sendValidMail session=java:Mail");
				 
				try {
					System.out.println( "host="+session.getProperty("mail.smtp.host") );
					System.out.println( "port="+session.getProperty("mail.smtp.port") );
					System.out.println( "from="+session.getProperty("mail.from") );
					System.out.println( "user="+session.getProperty("User") );
				} catch (Exception e) {
					;
				}
				 
			} catch (javax.naming.NamingException e) {
				//System.out.println("mailBody="+mailBody);
				try {
					mailServer = ConnectionFactory.operationProperty("mailServer", "CARD-SMS"); //MAIL_SERVER;
					//mailSource = operationProperty("mailSource", context); //MAIL_SOURCE;
					//System.out.println("mailServer="+mailServer);
					java.util.Properties props = new java.util.Properties();
					props.put("mail.smtp.host", mailServer);
					session = Session.getInstance(props, null);
				} catch (Exception ex) {
					System.out.println("sendValidMail ex.getMessage()="+ex.getMessage());
					//ex.printStackTrace(System.out);
				}
				System.out.println("sendValidMail mailServer="+mailServer);
			}
		// construct the message

			Message msg = new MimeMessage(session);
			
			//InternetAddress[] ccaddress = new InternetAddress[1];
			//ccaddress[0] = new InternetAddress(mailTarget);//(destino);
			InternetAddress[] ccaddress = InternetAddress.parse(StringLib.removeWhitespaces(mailTarget));
			
			if (mailSource!=null) {
				InternetAddress from = new InternetAddress(mailSource);//(origen);
		        msg.setFrom(from);
			}

			//System.out.println("mailSource="+mailSource+" mailTarget="+mailTarget+" mailSubject="+mailSubject);
			msg.setRecipients(Message.RecipientType.TO,ccaddress);
			msg.setSubject(mailSubject);//(subject);
			//msg.setContent(mailBody, "text/html; charset=UTF-8");//(cuerpo,content);

			System.out.println("sendValidMail contentType="+contentType);
			
			msg.setContent(mailBody, contentType);
			msg.setHeader("Content-Transfer-Encoding", "binary");
			
			Transport.send(msg);
			
			System.out.println("<<<<<< END sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	    
    @RequestMapping("/registrar")
    public void doRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String pUser = request.getParameter("user-client");
        String pPassword = request.getParameter("password-client");
        
        String rePassword =pPassword;
        		
        String pMail1 = request.getParameter("email");
        String pMail2 = request.getParameter("email");
        String pNombre = request.getParameter("name");
        String pApPaterno = request.getParameter("ap-paterno");
        String pApMaterno = "";//request.getParameter("ap-materno");
        String pTypeId = request.getParameter("document-type");
        String pNumberId = "";//request.getParameter("document-number");
        
        if("DNI".equals(pTypeId)) {
        	pNumberId = request.getParameter("document-number");
        }else if("PASAP".equals(pTypeId)) {
        	pNumberId = request.getParameter("document-number-pasap");
        }else if("CAREX".equals(pTypeId)) {
        	pNumberId = request.getParameter("document-number-carex");;
        }
        JsonObject o = new JsonObject();
        String verifyPersonalInformation=ClientUtils.verifyPersonalInformation(pTypeId,  pNumberId,  pNombre,  pApPaterno);
        if(!verifyPersonalInformation.equals("OK")) {
        	o.addProperty("message", "KO");
        	o.addProperty("info", verifyPersonalInformation);
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyPersonalInformation);
        	out.print(o);
        	return;
        }
        request.setAttribute("pNumberId", pNumberId);
        
        String pGender = "";
        String pBirthDate = request.getParameter("fechanac");
        String pMobilePhone = request.getParameter("mobile-phone");
        Integer pMode = 0;
        Integer pTerms = 1;
        String pConfirm = "Y";
        
        Calendar calendario = Calendar.getInstance();
        Calendar calendario2 = Calendar.getInstance();
		calendario.setTime(sdf.parse(pBirthDate));
		calendario2.setTime(sdf.parse(pBirthDate));
		calendario.add(Calendar.YEAR, 18);
		calendario2.add(Calendar.YEAR, 101);
		if(calendario.getTime().after(new Date())){
			o.addProperty("message", "KO");
        	o.addProperty("info", "Los juegos son solo para mayores de 18 aÒos.");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "Los juegos son solo para mayores de 18 aÒos.");
        	out.print(o);
        	return;
		}
		
		if(calendario2.getTime().before(new Date())){
			o.addProperty("message", "KO");
        	o.addProperty("info", "Los juegos son solo para menores de 101 aÒos.");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "Los juegos son solo para menores de 101 aÒos.");
        	out.print(o);
        	return;
		}
        
        if(!ClientUtils.verifySintaxMobilePhone(pMobilePhone)) {
        	o.addProperty("message", "KO");
        	o.addProperty("info", "Ingresar n&uacute;mero de celular correcto");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "Ingresar n&uacute;mero de celular correcto");
        	out.print(o);
        	return;
        }
        
        if(!ClientUtils.verifySintaxMail(pMail1))  {
        	o.addProperty("message", "KO");
        	o.addProperty("info", "El correo ingresado es incorrecto [1]");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "El correo ingresado es incorrecto [1]");
        	out.print(o);
        	return;
        }
        
        String verifyString = ClientUtils.verifyPassword(pNumberId, pPassword, rePassword);        
        
        if (!verifyString.equals("OK")) {
            o.addProperty("message", "KO");
            o.addProperty("info", verifyString);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyString);
            out.print(o);
            return;
        }
        
        //validar que contraseÒa no contenga datos del usuario
    	String verifyString2 = ClientUtils.verifyPasswordRegisterClient(pPassword, pNombre, pApPaterno, pNumberId, pBirthDate, pMobilePhone);
    	if (!verifyString2.equals("OK")) {
    		o.addProperty("message", "KO");
            o.addProperty("info", verifyString2);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyString2);
            out.print(o);
            return;
        }

        String verifyMailString = ClientUtils.verifyEmail(pMail1);
        if (!verifyMailString.equals("OK")) {
            o.addProperty("message", "KO");
            o.addProperty("info", verifyMailString);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyMailString);
            out.print(o);            
            return;
        }
        
        //validar nacionalidad, domicilio, departamento, provincia, distrito
        String nacionalidad = request.getParameter("nacionalidad");
        String domicilio = request.getParameter("domicilio");
        String departamento = request.getParameter("departamento");
        String provincia = request.getParameter("provincia");
        String distrito = request.getParameter("distrito");    
        String verifyContactInformation = ClientUtils.verifyContactInformation(nacionalidad,domicilio, departamento, provincia, distrito);
        if (!verifyContactInformation.equals("OK")) {
            o.addProperty("message", "KO");
            o.addProperty("info", verifyContactInformation);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyContactInformation);
            out.print(o);            
            return;
        }
        
		
        
        HttpSession session = request.getSession();
        if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587")) {
        	pMode = 5587;
        }else if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5588")) {
        	pMode = 5588;
        }else {
        	pMode = 1;
        }
        
        String bonoQR = (request.getParameter("channel") != null)
        				?	StringLib.decodeLongLabel(request.getParameter("channel")).trim() 
        				: null;
        
       LoggerApi.Log.info("/registrar ------------ pMode:" + pMode + " ------- bonoQR:" + bonoQR);

        JsonObject jdata = new JsonObject();
        String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
		jdata.addProperty("token", tokenPlayerWebApi);
		jdata.addProperty("nombres", pNombre);
		jdata.addProperty("apellidos", (pApPaterno+" "+pApMaterno).trim());
		jdata.addProperty("tipoDocumento", pTypeId);
		jdata.addProperty("numeroDocumento", pNumberId.trim());
		jdata.addProperty("fechaNacimiento", pBirthDate);
		jdata.addProperty("password", pPassword);
		jdata.addProperty("email", pMail1.toLowerCase().trim());
		jdata.addProperty("celular", pMobilePhone.trim());
		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
		jdata.addProperty("confirm", pConfirm);
		jdata.addProperty("operatorId", pMode);
		jdata.addProperty("platform", Constants.PLATAFORM);
		jdata.addProperty("region", "");
		jdata.addProperty("nacionalidad", nacionalidad);
		jdata.addProperty("direccion", domicilio);
		jdata.addProperty("departamento", departamento);
		jdata.addProperty("provincia", provincia);
		jdata.addProperty("distrito", distrito);
		jdata.addProperty("ppeFlag", pTerms.toString());
		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "newRegister"));//registerPlayer
        
        if (convertedObject.getString("estado").equals("OK")) {
           
            String welcome = "Bienvenido a La Tinka, tu registro se ha realizado correctamente.";
            
            o.addProperty("message", "REGISTRO_OK");
            
            ClientProcedureGetLoginData client = null;
            request.setAttribute("nuevoregistro", "true");
            client = securityUtils.obtenerLoginSegCta(request, clientSaleBo);
            LoggerApi.Log.info("/registrar clientId="+client.getClientId());
            session.setAttribute("clientProcedureLoginTMP", client); 
            
            session.setAttribute("cel", pMobilePhone);
            session.setAttribute("user", pUser);
            session.setAttribute("pass", pPassword);
            session.setAttribute("clientId", client.getClientId());
            /*ResultBean resultSmsRegister = putSmsClient(putClient.getClientId(),clientBean.getpMobilePhone());
            
            if(resultSmsRegister.getState().equals(200)) {
            	o.addProperty("message", putClient.getMessage());
            } else {
            	welcome += resultSmsRegister.getMessage();
            	o.addProperty("message", "KO");
            }*/
            LoggerApi.Log.info("/registrar clientId="+client.getClientId());//+" sms-state="+resultSmsRegister.getState()+ " sms-code="+resultSmsRegister.getCode());
            
            o.addProperty("info", welcome);
            o.addProperty("code", 200);
            o.addProperty("clientid","-");
            
            if(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").toString().trim().equals("") && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.lapollaOperatorId.toString().trim())) {            	
            	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
            	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== registrar status="+session.getAttribute("operatorId").toString().trim());
            	//session.removeAttribute("operatorId");
            }
            if(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").toString().trim().equals("") && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.tav2OperatorId.toString().trim())) {
            	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
            	//session.removeAttribute("operatorId");
            }
            
			/*se envia client id para crear cliente novus id por ajax*/
			o.addProperty("clientid", client.getClientId());
			/*fin*/
			
			//se guarda dato bonoQR
			if (bonoQR != null)
				clientSaleBo.updateBonoQr(client.getClientId(), bonoQR);
            
        } else {
            o.addProperty("message", "KO");
//            o.addProperty("info", putClient.getMessage());
            o.addProperty("rtitle", convertedObject.getString("resp_title"));
        	o.addProperty("rmessage", convertedObject.getString("resp_message"));
        	o.addProperty("rbutton", convertedObject.getString("resp_button"));
            LoggerApi.Log.info("/registrar clientState="+convertedObject.getString("estado")+" error="+convertedObject.getString("mensaje"));
        }
        out.print(o);
    }
     

    @RequestMapping(value = "/activate-client")
    public void activateClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int p_clientId = Integer.parseInt(request.getParameter("id-client-verify"));
        String p_mailCode = request.getParameter("verification-code");
        ClientProcedureActivateClient activateClient = clientSaleBo.findActivateClient(p_clientId, p_mailCode);
        JsonObject o = new JsonObject();
        if (activateClient.getMessage().equals("OK")) {
            UserBean userBean = new UserBean();
            Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            Integer sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
            ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(sessionId, clientId);
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null)
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            userBean.setpMailStatus(clientProcedureGetClient.getMailstatus());
            session.setAttribute(Constants.USR_SESION, userBean);
            o.addProperty("mailstatus", clientProcedureGetClient.getMailstatus());
        }
        o.addProperty("clientId", activateClient.getClientId());
        o.addProperty("message", activateClient.getMessage());
        out.print(o);
    }

    @RequestMapping(value = "/update-mail")
    public void updateEmail(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        JsonObject o = new JsonObject();
        //MailingForSale mailingForSale = new MailingForSale();
        HttpSession session = request.getSession();
        ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        //UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        int clientId = 0;
        String mail = "", outData = "";
        String mailVerified = user.getMailVerified(),message = "";
        try {
	        if(request.getParameter("id-client-um")!=null && !request.getParameter("id-client-um").trim().equals("")) clientId = Integer.parseInt(request.getParameter("id-client-um"));
	        else if(user!=null && user.getClientId()!=null) clientId = user.getClientId();
	        if(request.getParameter("email-client-um")!=null) mail = request.getParameter("email-client-um");
	        
	        boolean validacionSintaxis = ClientUtils.verifySintaxMail(mail);
	        
	        if(validacionSintaxis) {

	        	if(!mail.trim().equals(user.getMail()) && mailVerified.equals("N")) {
	        		ClientProcedureUpdateMail updateMail = clientSaleBo.findUpdateMail(clientId, mail);
	        		mailVerified = updateMail.getMailVerified();
	        		message = updateMail.getMessage();
	        		o.addProperty("status", message);
	        	} else {
	        		o.addProperty("status", "KO");
	        		o.addProperty("message", "Error inexperado [1]");
	        	}
	        	
		        if(!mailVerified.equals("S")) {
	            	//if(mailVerified.equals("P")) o.addProperty("message", "La solicitud de activaci&oacute;n ha sido enviada. Revisa tu correo.");//"El correo que ingresaste a&uacute;n no ha sido activado, confirma tu correo si est&aacute; correcto o actual&iacute;zalo.");
	            	if(mailVerified.equals("N")) o.addProperty("message", "El correo que ingresaste ya est· registrado en otra cuenta, por favor ingresa un nuevo correo.");
	            	 //o.addProperty("send",0);
		         } else {
		        	 
		        	//ClientProcedureGetNewCode newCode = clientSaleBo.findGetNewCode(clientId);
		        	user.setMail(mail);
	        		user.setMailVerified(mailVerified);
		        	session.setAttribute(Constants.CLT_SESSION, user); 
		        	 
				    o.addProperty("clientId", user.getClientId());
				    o.addProperty("email", mail);
			        o.addProperty("message", message);
			        //o.addProperty("send",mailingForSale.sendActivationMail(userBean.getpClientid(), userBean.getpNombre().replaceAll("_", " "), mail, newCode.getMailCode(), mailingForSale.MAIL_TEMPLATE_ACTIVE)); 
			    }
		    } else o.addProperty("message", "El correo electr&oacute;nico es incorrecto. Verifique si lo escribi&oacute; correctamente.");
		    
	        LoggerApi.Log.info("/update-mail validacionSintaxis="+validacionSintaxis+" mail="+mail+" userBean.getMail()="+user.getMail()+" mailVerified="+mailVerified +" equal-mails="+!mail.trim().equals(user.getMail())+" equal-n="+mailVerified.equals("N"));
	        outData = callback + "(" + o + ")";
        } catch(SQLIntegrityConstraintViolationException e) {
        	o.addProperty("message", "Hemos verificado que el correo electrÛnico ingresado ha sido registrado y activado en otra cuenta.");
        
        	outData = callback + "(" + o + ")";
        } catch (Exception e) {
        	o.addProperty("message", "OcurriÛ un error inesperado. Vuelva a intentarlo.");
            LoggerApi.severe(e);
            outData = callback + "(" + o + ")";
        } finally {
        	out.print(outData);
        	LoggerApi.Log.info("/update-mail "+o.toString());
        }
        
    }

    @RequestMapping(value = "/new-code")
    public void getNewCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        String mail = request.getParameter("email-client-code");
        ClientProcedureGetNewCode newCode = clientSaleBo.findGetNewCode(userBean.getpClientid());
        JsonObject o = new JsonObject();
        o.addProperty("clientId", newCode.getClientId());
        o.addProperty("message", newCode.getMessage());
        o.addProperty("send", clientSaleBo.clientSendMail(mail, userBean.getpNombre().replaceAll("_", " "), newCode.getMailCode(), 2, null));
        LoggerApi.Log.info("/new-code getNewCode mail="+mail+" o="+o);
        out.print(o);
    }

    @RequestMapping(value = "/update-client")
    public void updateClient(HttpServletRequest request, HttpServletResponse response) {
       
    	response.setContentType("application/json");
    	try {
            JsonObject o = new JsonObject();
            HttpSession session = request.getSession();
            UserBean userBean = new UserBean();
            if (session.getAttribute(Constants.USR_SESION) != null) userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            PrintWriter out = response.getWriter();
            //String mobile_phone =request.getParameter("mobile-phone").trim();
            String email = request.getParameter("email").trim();
            //String phone_operator = request.getParameter("comMovil").trim();
            String region = request.getParameter("region");
            String gender = request.getParameter("gender");    
            
            ClientBean clientBean = new ClientBean();
            clientBean.setpTerms(0);
            clientBean.setpMail1(email);
            clientBean.setpMail2(email);
            clientBean.setpGender(gender);
            clientBean.setpRegion(region);
            //clientBean.setpFixedPhone((request.getParameter("fixed-phone")!=null)?request.getParameter("fixed-phone").trim():"");//clientBean.setpFixedPhone(request.getParameter("fixed-phone").trim());
            //clientBean.setpMobilePhone(mobile_phone);
            //clientBean.setpComPhones(phone_operator);
      
            if(!ClientUtils.verifySintaxMail(clientBean.getpMail1()))  {
            	o.addProperty("info", "El correo ingresado es incorrecto [2]");
            	return;
            }
            /*
            if(!ClientUtils.verifySintaxMobilePhone(clientBean.getpMobilePhone())) {
            	o.addProperty("info", "Ingresar n&uacute;mero de celular correcto");
            	return;
            }
            */
            String pConfirm = "N";
            if (request.getParameter("confirm") != null) pConfirm = request.getParameter("confirm");
            clientBean.setpConfirm(pConfirm);
            clientBean.setpSessionid(userBean.getpSessionid());
            clientBean.setpClientid(userBean.getpClientid());
            if (session.getAttribute(Constants.USR_SESION) != null) {
                ClientProcedureUpdateClient updateClient = clientSaleBo.updateClient(clientBean);
                if (updateClient != null) {
                    o.addProperty("state", updateClient.getState());
                    if (updateClient.getState() == 1) {
                    	String message = "Los cambios de su perfil se han guardado satisfactoriamente.";
                        /*
                         * Enviar sms, realizar login, invalidar session y guardar en session el login
                         */
                    	/*
                    	LoggerApi.Log.info("/update-client change_mobile_phone="+!userBean.getpMobilePhone().equals(mobile_phone));
                        
                        if(!userBean.getpMobilePhone().equals(mobile_phone) && updateClient.getMobileStatus().trim().equals("DES")) {
                        	ResultBean resultSmsRegister = securityUtils.putSmsClient(clientBean.getpClientid(),clientBean.getpMobilePhone(), clientSaleBo);
                               
                            if(resultSmsRegister.getState().equals(200)) {
                            	 message+=resultSmsRegister.getMessage();
                            }  
                            
                            ClientProcedureLogin clientProcedureLogin = (ClientProcedureLogin) session.getAttribute(Constants.CLT_SESSION);
                            
                            if(clientProcedureLogin!=null) {
                            //if(userBean!=null) {
                            	session.invalidate();
                            	session = request.getSession(true);
                            	clientProcedureLogin.setMobilePhone(mobile_phone);
                            	clientProcedureLogin.setMobileStatus(updateClient.getMobileStatus());
                            	clientProcedureLogin.setMail(email);
                            	session.setAttribute(Constants.CLT_SESSION, clientProcedureLogin);
                            	userBean.setpMobilePhone(mobile_phone);
                            	userBean.setpMobileStatus(updateClient.getMobileStatus());
                            	userBean.setpMail(email);
                            	session.setAttribute(Constants.USR_SESION, userBean);
                            	o.addProperty("state", 707);
                            	o.addProperty("code", resultSmsRegister.getCode());
                            	LoggerApi.Log.info("/update-client clientId="+userBean.getpClientid() +" sms-state="+resultSmsRegister.getState());
                                
                            } else {
                            	
                            	LoggerApi.Log.info("/update-client clientId="+userBean +" sms-state="+resultSmsRegister.getState());  
                            }
                    	
                        }
  						*/
                    	o.addProperty("message", message);   
                        
                 
                    } else o.addProperty("message", updateClient.getMessage());
                    
                } else o.addProperty("message", "No se realiz&oacute; ningun cambio; por favor inicie sesi&oacute;n.");
            } else
                o.addProperty("message", "No se realiz&oacute; ningun cambio; por favor inicie sesi&oacute;n.");
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        }
    }

    @RequestMapping(value = "/autocontrol")
    public String selfControl(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
        try {
            HttpSession session = request.getSession();
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                session.setAttribute(Constants.USR_SESION, userBean);
                return "client/self_control_user";
            } else
                return "redirect:/inicio.html";
        } catch (Exception e) {
            LoggerApi.severe(e);
            return "redirect:/inicio.html";
        }
    }
    
  //obtener valores del la configuraciÛn limite 
    @RequestMapping(value = "/getDataSelfControl")
    public void getDataSelfControl(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START getDataSelfControl uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
    	try {
			HttpSession session = request.getSession();
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
				&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                ClientProcedureGetSelfcontrol getSelfcontrol = clientSaleBo.getDataSelfcontrol(Integer.valueOf(idClient) );
             	
                o.addProperty("clientId", getSelfcontrol.getClientId());
				o.addProperty("showDisable",getSelfcontrol.getShowDisable());
				o.addProperty("typeLimit",getSelfcontrol.getTypeLimit());
				o.addProperty("valueLimit",getSelfcontrol.getValueLimit());
				o.addProperty("dateLimit",getSelfcontrol.getDateLimit());


			}else {
				o.addProperty("controlFlag", "KO");
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
	    } 
    	LoggerApi.Log.info("-------------- END getDataSelfControl uuid="+uuid.toString());
    }

    @RequestMapping(value = "/define-limit")
    public void defineLimit(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        String clientId = "";
        Integer sessionId = 0;
        String message = "";
        String p_type="OTRO";
        Integer monto_control=0;

        LoggerApi.Log.info("editar limites de autocontrol");
        
        try {
            PrintWriter out = response.getWriter();
            JsonObject o = new JsonObject();
            if (session != null && session.getAttribute(Constants.USR_SESION) != null) {
                
            	try {
            		p_type= request.getParameter("type");
            		LoggerApi.Log.info("p_type=" + p_type);
            		if( p_type.equals("POR_MONTO")) {
            			monto_control = Integer.parseInt(request.getParameter("soles"));
            		}else if( p_type.equals("POR_HORAS")) {
            			monto_control = Integer.parseInt(request.getParameter("hours"));
            		}else if ( p_type.equals("POR_AUTOEXCLUSION")) {
            			monto_control = Integer.parseInt(request.getParameter("value-autoexclusion"));
            		}  				
				} catch (Exception e) {
					// TODO: handle exception
					monto_control=0;			
				}
            	
                if (!((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString().equals("")) {
                    clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString();
                    sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                    //message = SalesDispatcher.setDataSelfcontrol(clientId, amount, hours);
                    
                    ClientProcedureEditSelfcontrol editSelfcontrol = clientSaleBo.editDataSelfcontrol(Integer.valueOf(clientId), monto_control, p_type );
                    message= editSelfcontrol.getMensaje();
                    
                    if (message.equals("OK")) {
                        o.addProperty("message", message);
                        ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(sessionId, Integer.parseInt(clientId));
                        o.addProperty("lastDate", dataClient.getControlLastDate());
                    } else if (message.equals("ERROR_POR_FECHA")) {
                        o.addProperty("message", message);
                        o.addProperty("info",
                                "Ya tienes una opci&oacute;n de Autocontrol registrada en tu cuenta. \nPara modificarla o desactivarla debes esperar 24 horas desde tu elecci&oacute;n. \nInf&oacute;rmate en los t&eacute;rminos y condiciones.");
                    } else {
                        o.addProperty("message", message);
                        o.addProperty("info", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");
                    }
                }
            }
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("clientId=" + clientId);
        }
    }

    @RequestMapping(value = "/recordar-usuario")
    public String formReminderMail(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
        /* LoggerApi.Log.info("INGRESO AL METODO"); */
        return "client/reminder_form";
    }
    
    @RequestMapping(value = "/recordar-usuario-mail")
    public void formReminder(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String mail = request.getParameter("email-user");
        LoggerApi.Log.info("recordarUsuarioMail EMAIL: " + mail);
        try {
        	if (mail == null || mail.trim().equals("")) {
                LoggerApi.Log.info("clientBo.findByMail no definido:" + mail);
                o.addProperty("message", "Correo no definido");
                o.addProperty("send", "Su correo no esta definido, verificar el correo.");
        	} else {
            	mail = mail.trim();
                //Client findClient = clientBo.findByMail(mail);
            	String send = clientSaleBo.clientSendUserMail(mail);
                if (send != null && send.equals("OK")) {
                    o.addProperty("message", send);
                    o.addProperty("send", "Tu usuario ha sido enviado a tu correo "+mail);
                } else if(send != null && send.equals("KO")) {
                	LoggerApi.Log.info("recordarUsuarioMail clientBo.findByMail no existe:" + mail);
                    o.addProperty("send", "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.");
                } else {
                    LoggerApi.Log.info("recordarUsuarioMail clientBo.findByMail no existe:" + mail);
                    o.addProperty("message", "Correo no ha sido registrado");
                    o.addProperty("send", "Correo no ha sido registrado, verificarlo");
                }
        	}
            LoggerApi.Log.info("restablecerMail o="+o);
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("finally restablecerMail EMAIL:" + mail);
        }
    }
    
    @RequestMapping(value = "/restablecer")
    public String formRestablecer(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
        /* LoggerApi.Log.info("INGRESO AL METODO"); */
    	HttpSession session = request.getSession();
    	if(session.getAttribute("operatorId")!=null) {
    		session.removeAttribute("operatorId");
    	}
    	if(request.getParameter("operatorId")!=null) session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
        //return "client/restablecer_form";
        return "redirect:"+Constants.urlPamRestablecer;
    }

    @RequestMapping(value = "/restablecer-mail") 
    public void restablecerMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String mail = request.getParameter("email-user");
        String p_password_code = StringLib.encodeLabel(StringLib.generatePassword(30).toUpperCase());
        String p_game = request.getParameter("game").toString();
        LoggerApi.Log.info("restablecerMail EMAIL: " + mail);
        HttpSession session = request.getSession();
        try {
        	if (mail == null || mail.trim().equals("")) {
                LoggerApi.Log.info("clientBo.findByMail no definido:" + mail);
                o.addProperty("message", "Correo no definido");
                o.addProperty("send", "Su correo no esta definido, verificar el correo.");
        	} else {
            	mail = mail.trim();
                //Client findClient = clientBo.findByMail(mail);
                ClientProcedureGetPasswordCode passwordCode = clientSaleBo.findGetPasswordCode(mail, p_password_code);
                if (passwordCode != null && passwordCode.getMessage() != null && passwordCode.getMessage().equals("OK")) {
                    String nombreUser = passwordCode.getName();
                    o.addProperty("clientId", passwordCode.getClientId());
                    o.addProperty("email", mail);
                    o.addProperty("message", passwordCode.getMessage());
                    o.addProperty("send", clientSaleBo.clientSendMail2(mail, nombreUser, passwordCode.getPasswordCode(), 3, passwordCode.getUser(),p_game));
                    session.setAttribute("email", mail);
                    Date dt = new Date();
                    //System.out.println("Fecha de hoy:    " + dt);
                    Date tomorrow = new Date(dt.getTime() + (24*60*60*1000));//24hrs
                    Long time_expiration= tomorrow.getTime();
                    //System.out.println("Fecha next: " + tomorrow);
                    //int test = (int)time_expiration_url;
                    String time_expiration_url = Long.toString(time_expiration);
                    
                    Dbms rs = null;
                    
                    try {
                        rs = new Dbms();
                	    String sql = "update lotocard.client set cl_recovery_expiration_url = ?  where  trim(lower(cl_mail)) = trim(lower(?))  and  cl_password_code = ?";
                	    rs.setSql(sql);
                	    rs.setString(1, time_expiration_url);
                	    rs.setString(2,mail);
                	    rs.setString(3,passwordCode.getPasswordCode());
                        rs.executeUpdate();
                       
            		} finally {
            			try {
            				if(rs!=null) {
            					System.out.println("<--------------------SecurityLoginController cerrando conexion------------------->");
            					 rs.close();
            				}
            			} catch (Exception e) {
            				System.out.println("<--------------------SecurityLoginController error cerrando conexion------------------->");
            				e.printStackTrace();
            			}
            			
            		}
                } else {
                    LoggerApi.Log.info("restablecerMail clientBo.findByMail no existe:" + mail);
                    o.addProperty("message", "Correo no ha sido registrado");
                    o.addProperty("send", "Correo no ha sido registrado, verificarlo");
                }
        	}
            LoggerApi.Log.info("restablecerMail o="+o);
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("finally restablecerMail EMAIL:" + mail);
        }
    }

    @RequestMapping(value = "/update-password")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="update-password";
    	LoggerApi.Log.info("-------------- START "+log);
    	JSONObject convertedObject = null; 
    	
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        HttpSession session = request.getSession();
        String codigoPass = (request.getParameter("codigoPass")!=null)?request.getParameter("codigoPass").replaceAll(" ", "\\+"):"";
		String email = (request.getParameter("email")!=null)?request.getParameter("email"):"";
        String pass1 = request.getParameter("password");
        String pass2 = request.getParameter("new-password");
        
        try {
        	String clientIdRecoveryPass=session.getAttribute("clientIdRecoveryPass")!=null?session.getAttribute("clientIdRecoveryPass").toString():"";
        	int operatorId=(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").equals(""))?Integer.parseInt(session.getAttribute("operatorId").toString()):0;
        	if(operatorId==0) {
        		operatorId=Constants.OPERATOR_ID;
        	}
        	JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("tipoDocumento", "");
    		jdata.addProperty("numeroDocumento", "");
    		jdata.addProperty("clientId", clientIdRecoveryPass);
    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
    		jdata.addProperty("operatorId", operatorId);
    		jdata.addProperty("platform", Constants.PLATAFORM);
    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
            
            if (!convertedObject.getString("status").equals("OK")) {
            	o.addProperty("message", "KO");
	            o.addProperty("send", "Revisa si el documento que ingresaste es correcto");
	            o.addProperty("title", "Validaci&oacute;n de datos");
	            out.print(o);
            	LoggerApi.Log.info(clientIdRecoveryPass+":" + convertedObject);
            	return;
            }
        	
            String puser =convertedObject.has("usuario")?convertedObject.getString("usuario"):"";
            String verifyString = ClientUtils.verifyPassword(puser, pass1, pass2);
            if (!verifyString.equals("OK")) {
	        	o.addProperty("message", "KO");
	            o.addProperty("send", verifyString);
	            o.addProperty("title", "Validaci&oacute;n de datos");
	            out.print(o);
                LoggerApi.Log.info(puser+":" + verifyString);
                return;
           }
            
            //validar que contraseÒa no contenga datos del usuario
            String nombres=convertedObject.has("nombres")?convertedObject.getString("nombres"):"";
            String apellidos=convertedObject.has("apellidos")?convertedObject.getString("apellidos"):"";
            String numeroDocumento=convertedObject.has("numeroDocumento")?convertedObject.getString("numeroDocumento"):"";
            String fechaNacimiento=	convertedObject.has("fechaNacimiento")?convertedObject.getString("fechaNacimiento"):"";
            String celular=convertedObject.has("celular")?convertedObject.getString("celular"):"";
        	String verifyString2 = ClientUtils.verifyPasswordChangePassword(pass1, nombres, apellidos, numeroDocumento, fechaNacimiento, celular);
        	if (!verifyString2.equals("OK")) {
        		o.addProperty("message", "KO");
	            o.addProperty("send", verifyString2);
	            o.addProperty("title", "Validaci&oacute;n de datos");
	            out.print(o);
                return;
            }
            	
            jdata = new JsonObject();
//			String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi",	Constants.contextPlayerWebApi);
        	
			jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("transaccionId", "");
			jdata.addProperty("param1", codigoPass);
			jdata.addProperty("param2", email);
			jdata.addProperty("password", pass1);
			jdata.addProperty("passwordConfirm", pass2);
			jdata.addProperty("operatorId", operatorId);
			jdata.addProperty("platform", Constants.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updatePasswordMail"));
			if (convertedObject.has("status") && convertedObject.getString("status").equals("OK")) {
				o.addProperty("clientId", clientIdRecoveryPass);
                o.addProperty("message", convertedObject.getString("status"));
                o.addProperty("send", convertedObject.getString("resp_message"));
                
                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.lapollaOperatorId.toString().trim())) {
                	o.addProperty("lapolla", Constants.lapollaGameProviderBaseUrl+" | ");
                	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== update-password lapolla="+Constants.lapollaGameProviderBaseUrl+" mail="+convertedObject.getString("email"));
                	session.removeAttribute("operatorId");
    			}
                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.tav2OperatorId.toString().trim())) {
                	String urlTav2="tav2.html?"+session.getAttribute("urlRedirect5588")+"&"+session.getAttribute("redirectGame");
                	o.addProperty("tav2", urlTav2);
                	if(session.getAttribute("urlRedirect5588")==null || session.getAttribute("urlRedirect5588").toString().equals("")) {
                		o.addProperty("tav2", Constants.tav2GameProviderCloseUrl);
                	}            	
                	session.removeAttribute("operatorId");
    			}
                
                //modificar notificacion de contraseÒa
	            List<PaymentPrizeProcedureGetNotifications> listObj=paymentPrizeBo.getNotifications(Integer.parseInt(clientIdRecoveryPass));
	            for (PaymentPrizeProcedureGetNotifications notifications : listObj) {
					if(notifications.getType().equals("4")) {
						PaymentPrizeProcedureUpdatePasswordNotification obj = paymentPrizeBo.updatePasswordNotification(Integer.parseInt(clientIdRecoveryPass), notifications.getId());
			    		LoggerApi.Log.info(log+" passwordNotification="+obj.getMessage());
					}
				}
	            
			}else {
				o.addProperty("message", "KO");
	            o.addProperty("send", convertedObject.getString("resp_message"));
	            o.addProperty("title", convertedObject.getString("resp_title"));
			}
        	
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
        }
    }

    @RequestMapping(value = "/automatic-access")
    public String name(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String p_client_id = "";
        String p_mail = "";
        String p_mail_code = "";
        String p_random_code = "";
        String p_game_code = "";
        String key = "";
        JsonObject o = new JsonObject();
        try {
            if (request.getParameter("key") != null && !request.getParameter("key").equals("")) {
            	key = request.getParameter("key");
                LoggerApi.Log.info("plainstr=" + key);
                key = key.replace("+", "%2B");
                LoggerApi.Log.info("%plainstr=" + key);
                key = URLDecoder.decode(key, "UTF-8");
                LoggerApi.Log.info("decoded=" + key);
                key = ClientUtils.decrypt_sda(key);
                LoggerApi.Log.info("decrypt=" + key);
                String[] aKey = key.split("\\|");
                p_client_id = aKey[0];
                p_mail = aKey[1];
                p_mail_code = aKey[2];
                p_random_code = aKey[3];
                p_game_code = aKey[4];
                o.addProperty("p_client_id", p_client_id);
                o.addProperty("p_mail", p_mail);
                o.addProperty("p_mail_code", p_mail_code);
                o.addProperty("p_random_code", p_random_code);
                o.addProperty("p_game_code", p_game_code);
                ClientProcedureActivateClientSamp activateClientSamp = clientSaleBo.activateClientSamp(p_client_id, p_mail, p_mail_code, p_random_code, p_game_code);
                ClientProcedureLogin clientLogin = clientSaleBo.findLogin(activateClientSamp.getUser(), StringLib.decodeLabel(activateClientSamp.getPassword()));
                ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(clientLogin.getSessionId(), clientLogin.getClientId());
                // ClientProcedureSessionData clientProcedureSessionData = new ClientProcedureSessionData();
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(clientLogin.getSessionId(), clientLogin.getClientId());
                JsonObject joDataClient = new JsonObject();
                joDataClient.addProperty("user", dataClient.getUser());
                joDataClient.addProperty("email", dataClient.getMail());
                joDataClient.addProperty("luckyIcon", dataClient.getLuckyIcon());
                joDataClient.addProperty("fullName", dataClient.getNombre());
                joDataClient.addProperty("identity", dataClient.getTypeId() + " " + dataClient.getNumberId());
                joDataClient.addProperty("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
                joDataClient.addProperty("gender", dataClient.getGender());
                joDataClient.addProperty("birthDate", dataClient.getBirthDate());
                joDataClient.addProperty("region", dataClient.getRegion());
                joDataClient.addProperty("fixedPhone", dataClient.getFixedPhone());
                joDataClient.addProperty("mobilePhone", dataClient.getMobilePhone());
                joDataClient.addProperty("confirm", dataClient.getConfirm());
                HttpSession session = request.getSession();
                UserBean userBean = new UserBean();
                userBean.setpSessionid(clientLogin.getSessionId());
                userBean.setpUser(clientLogin.getCl_nombre());
                userBean.setpClientid(clientLogin.getClientId());
                userBean.setpSessionCode(clientLogin.getSessionCode());
                userBean.setpStatus(clientLogin.getStatus());
                userBean.setpMode(Integer.parseInt(clientLogin.getMode()));
                userBean.setpLuckyIcon(clientLogin.getLuckyIcon());
                userBean.setpNombre(clientProcedureGetClient.getNombre());
                userBean.setpMonto(clientProcedureGetClient.getAmount());
                userBean.setpMailStatus(clientProcedureGetClient.getMailstatus());
                userBean.setpGame(0);
                userBean.setpAgreement(clientLogin.getAgreement());
                userBean.setpMailVerified(clientLogin.getMailVerified());
                userBean.setpPromotion(clientLogin.getPromotion());
                userBean.setpPromotionibk(clientLogin.getPromotionibk());
                session.setAttribute(Constants.USR_SESION, userBean);
                //request.setAttribute("clientSale", clientProcedureGetClient);
                request.setAttribute("DataClient", joDataClient);
                request.setAttribute("regions", regionBo.findRegion());
                session.setAttribute("messagePromo", activateClientSamp.getMessage());
                /** Account Data **/
                ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(clientLogin.getClientId());
                clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
                request.setAttribute("clientBalance", clientProcedureAccountData);
                request.setAttribute("clientSale", clientProcedureGetClient);
            }
            return "redirect:/mi-cuenta.html#saldo";
        } catch (Exception e) {
        	LoggerApi.severe(e);
            return "redirect:/inicio.html";
        } finally {
            LoggerApi.Log.info(o.toString());
        }
    }
    
    @RequestMapping(value = "/automatic-activation")
    public String activationClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String p_client_id = "";
        String p_mail = "";
        String p_mail_code = "";
        //String p_random_code = "";
        String p_game_code = "";
        String key = "";
        JsonObject o = new JsonObject();
        String usr = "";
        String pwd = "";
        String msg = "";
        String directo = "redirect:/mi-cuenta.html";
        try {
        	HttpSession session = request.getSession();
        	//System.out.println("key="+request.getParameter("key"));
            if (request.getParameter("key") != null && !request.getParameter("key").equals("")) {
                key = request.getParameter("key");
                LoggerApi.Log.info("plainstr=" + key);
                key = key.replace("+", "%2B");
                LoggerApi.Log.info("%plainstr=" + key);
                key = URLDecoder.decode(key, "UTF-8");
                LoggerApi.Log.info("decoded=" + key);
                key = ClientUtils.decrypt_sda(key);
                LoggerApi.Log.info("decrypt=" + key);
                String[] aKey = key.split("\\|");
                p_client_id = aKey[0];
                p_mail = aKey[1].trim();
                if(aKey[2] != null && !aKey[2].trim().equals("")) p_mail_code = aKey[2].trim();
                //p_random_code = aKey[3];
                if(aKey[3] != null && !aKey[3].trim().equals("")) p_game_code = aKey[3].trim();
                o.addProperty("p_client_id", p_client_id);
                o.addProperty("p_mail", p_mail);
                o.addProperty("p_mail_code", p_mail_code);
                //o.addProperty("p_random_code", p_random_code);
                o.addProperty("p_game_code", p_game_code);
                session.setAttribute("keyCode",p_mail_code);
                /*o.addProperty("clientId", p_client_id);
                o.addProperty("email", p_mail);
                o.addProperty("name", clientProcedureGetDataClient.getNombre());
                o.addProperty("keycode", p_mail_code);
                request.setAttribute("DataUser", o);*/
                ClientProcedureVerifyClient verifyClient = null;
                ClientProcedureVerifyClientBond verifyClientBond = null;
                //ClientProcedureActivateClientSamp activateClientSamp = clientSaleBo.activateClientSamp(p_client_id, p_mail, p_mail_code, p_random_code, p_game_code);
                if(!p_mail.equals("")) verifyClient = clientSaleBo.verifyClient(p_client_id, p_mail, p_mail_code);
                else verifyClientBond = clientSaleBo.verifyClientBond(p_client_id, p_mail_code);
                if ((verifyClient != null && verifyClient.getUser() != null) || (verifyClientBond != null && verifyClientBond.getUser() != null)) {
	                if(verifyClient != null && verifyClient.getUser() != null) {
	                	usr = verifyClient.getUser();
	                	pwd = verifyClient.getPassword();
	                	msg = verifyClient.getMessage();
	                	directo = "redirect:/mi-cuenta.html";
	                } else if(verifyClientBond != null && verifyClientBond.getUser() != null) {
	                	usr = verifyClientBond.getUser();
	                	pwd = verifyClientBond.getPassword();
	                	msg = verifyClientBond.getMessage();
	                	directo = "redirect:/mi-cuenta.html#saldo";
	                }
	                ClientProcedureLogin clientLogin = clientSaleBo.findLogin(usr, StringLib.decodeLabel(pwd));//activateClientSamp.getUser(), StringLib.decodeLabel(activateClientSamp.getPassword()));
	                ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(clientLogin.getSessionId(), clientLogin.getClientId());
	                // ClientProcedureSessionData clientProcedureSessionData = new ClientProcedureSessionData();
	                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(clientLogin.getSessionId(), clientLogin.getClientId());
	                //clientProcedureGetClient.setKeycode(p_mail_code);
	                JsonObject joDataClient = new JsonObject();
	                joDataClient.addProperty("user", dataClient.getUser());
	                joDataClient.addProperty("email", dataClient.getMail());
	                joDataClient.addProperty("luckyIcon", dataClient.getLuckyIcon());
	                joDataClient.addProperty("fullName", dataClient.getNombre());
	                joDataClient.addProperty("identity", dataClient.getTypeId() + " " + dataClient.getNumberId());
	                joDataClient.addProperty("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
	                joDataClient.addProperty("gender", dataClient.getGender());
	                joDataClient.addProperty("birthDate", dataClient.getBirthDate());
	                joDataClient.addProperty("region", dataClient.getRegion());
	                joDataClient.addProperty("fixedPhone", dataClient.getFixedPhone());
	                joDataClient.addProperty("mobilePhone", dataClient.getMobilePhone());
	                joDataClient.addProperty("confirm", dataClient.getConfirm());
	                //joDataClient.addProperty("keycode", p_mail_code);
	                ClientProcedureTokenGeneration tokenGeneration = clientSaleBo.getToken(clientLogin.getClientId(), "1", request.getRemoteAddr());
	                ClientProcedureLPTokenGeneration lpTokenGeneration = clientSaleBo.getLPToken(clientLogin.getClientId(), request.getRemoteAddr());
	                ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(clientLogin.getClientId(), request.getRemoteAddr());
	                ClientUtils.updateUserSession(session,clientLogin,tokenGeneration,lpTokenGeneration,tanTokenGeneration,0);
	                
	                request.setAttribute("DataClient", joDataClient);
	                request.setAttribute("regions", regionBo.findRegion());
	                session.setAttribute("messagePromo", msg);
	                /** Account Data **/
	                ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(clientLogin.getClientId());
	                clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
	                request.setAttribute("clientBalance", clientProcedureAccountData);
	                request.setAttribute("clientSale", clientProcedureGetClient);
                } else {
	                if(verifyClient != null && verifyClient.getUser() == null) {
	                	msg = verifyClient.getMessage();
	                } else if(verifyClientBond != null && verifyClientBond.getUser() == null) {
	                	msg = verifyClientBond.getMessage();
	                }
                    session.setAttribute("messagePromo", msg);
                    LoggerApi.Log.info("messagePromo="+msg);
                    //return "redirect:/mi-cuenta.html";
                }
            }
            return directo;//"redirect:/registro.html#activa-tu-cuenta";
        } catch (Exception e) {
        	LoggerApi.severe(e);
            return "redirect:/inicio.html";
        } finally {
            LoggerApi.Log.info("o.toString()="+o.toString());
        }
    }

    @RequestMapping(value = "/promo-tinka-terminos-y-condiciones")
    public String promoTinka() {
        return "client/promo_tinka_terms";
    }

    @RequestMapping(value = "/contacto")
    public String contact(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
        try {
            HttpSession session = request.getSession();
            JsonObject o = new JsonObject();
            List<Country> countries = countryBo.findCountry();
            if (countries != null)
                modelList.put("countries", countries);
            List<Region> regions = regionBo.findRegion();
            if (regions != null)
                modelList.put("regions", regions);
            UserBean userBean = null;
            if (session.getAttribute(Constants.USR_SESION) != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                Integer clientId = userBean.getpClientid();
                Integer sessionId = userBean.getpSessionid();
                ClientProcedureGetDataClient clientProcedureGetDataClient = null;
                if (sessionId != null && clientId != null)
                    clientProcedureGetDataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
                if (clientProcedureGetDataClient != null) {
                    String fecha[] = clientProcedureGetDataClient.getBirthDate().split("/");
                    o.addProperty("clientId", clientProcedureGetDataClient.getClientId());
                    o.addProperty("name", clientProcedureGetDataClient.getNombre());
                    o.addProperty("ApPaterno", clientProcedureGetDataClient.getApPaterno());
                    o.addProperty("ApMaterno", clientProcedureGetDataClient.getApMaterno());
                    o.addProperty("typeId", clientProcedureGetDataClient.getTypeId());
                    o.addProperty("numberId", clientProcedureGetDataClient.getNumberId());
                    o.addProperty("day", fecha[0]);
                    o.addProperty("month", fecha[1]);
                    o.addProperty("year", fecha[2]);
                    o.addProperty("region", clientProcedureGetDataClient.getRegion());
                    o.addProperty("fixedPhone", clientProcedureGetDataClient.getFixedPhone());
                    o.addProperty("mobilePhone", clientProcedureGetDataClient.getMobilePhone());
                    o.addProperty("email", clientProcedureGetDataClient.getMail());
                }
            }
            request.setAttribute("DataUser", o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "client/user_contact";
    }

    @RequestMapping(value = "/save-claims")
    public void bookClaims(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String sopenpos = "";
        String sproblem = "";
        String email = request.getParameter("email");
        String firstname = request.getParameter("name");
        String lastname = request.getParameter("ap-paterno");
        String maidenname = request.getParameter("ap-materno");
        String doctype = request.getParameter("document-type");
        String docnumber = request.getParameter("document-number");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String problem = request.getParameter("opt");
        String birthdate = day + "/" + month + "/" + year;
        String department = request.getParameter("region");
        String phone = "";
        String fixed_phone = request.getParameter("fixed-phone");
        String mobile_phone = request.getParameter("mobile-phone");
        if (fixed_phone != null && fixed_phone.length() != 0)
            phone = fixed_phone;
        if (mobile_phone != null && mobile_phone.length() >= 9)
            phone = mobile_phone;
        String openpos = request.getParameter("opt2");
        boolean tinka = request.getParameter("Tinka") != "" ? true : false;
        boolean teapuesto = request.getParameter("Teapuesto") != "" ? true : false;
        boolean ganagol = request.getParameter("Ganagol") != "" ? true : false;
        boolean ganadiario = request.getParameter("Ganadiario") != "" ? true : false;
        boolean kabala = request.getParameter("Kabala") != "" ? true : false;
        boolean super3 = request.getParameter("Super3") != "" ? true : false;
        boolean instantaneas = request.getParameter("Ganadiario") != "" ? true : false;
        boolean reventon = request.getParameter("Reventon") != "" ? true : false;
        boolean clicygana = request.getParameter("ClicGana") != "" ? true : false;
        boolean rapTrapG = request.getParameter("RapTRapG") != "" ? true : false;
        boolean fechaza = request.getParameter("Fechaza") != "" ? true : false;
        String message = ClientUtils.formatHtml(request.getParameter("coment"));
        String pMobilePhone = request.getParameter("mobile-phone");
        LoggerApi.Log.info("problem --> " + problem + " openpos --> " + openpos + " tinka --> " + tinka);
        String province = "-";
        String gender = "";
        String clientid = "";
        String district = "-";
        String sgender = "";
        int probtinka = 0;
        int probteapuesto = 0;
        int probganagol = 0;
        int probganadiario = 0;
        int probkabala = 0;
        int probsuper3 = 0;
        int probinstantaneas = 0;
        int probreventon = 0;
        int probclicygana = 0;
        int probfechaza = 0;
        String sgame = "";
        String detail = "";
        String deptname = "";
        String provname = "";
        String distname = "";
        String doctname = "";
        UserBean userBean = null;
        if (session.getAttribute(Constants.USR_SESION) != null) {
            userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            clientid = userBean.getpClientid().toString();
        }
        if (problem != null)
            if (problem.equals("SUGGESTION"))
                sproblem = "Sugerencias y preguntas";
            else if (problem.equals("SOLUTION"))
                sproblem = "SoluciÛn de problemas";
            else if (problem.equals("SUPPORT"))
                sproblem = "Soporte tÈcnico Web";
            else if (problem.equals("OPENPOS"))
                sproblem = "Deseo abrir un punto de venta";
            else if (problem.equals("OTHERS"))
                sproblem = "Otros";
            else if (problem.equals("PROMOTER"))
                sproblem = "Comentarios sobre una Promotora";
        if (problem.equals("OPENPOS")) {
            if (openpos != null)
                if (openpos.equals("SHOPCENTER"))
                    sopenpos = " Dentro de un centro comercial";
                else if (openpos.equals("MARKET"))
                    sopenpos = " Dentro de un mercado";
                else if (openpos.equals("MAINROAD"))
                    sopenpos = " En una avenida principal";
                else if (openpos.equals("MAINSTREET"))
                    sopenpos = " En una calle principal";
                else if (openpos.equals("SIDESTREET"))
                    sopenpos = " En una calle secundaria / jir&oacute;n";
                else if (openpos.equals("OTHERPOINT"))
                    sopenpos = " Otros";
            detail = sopenpos;
        } else if (problem.equals("SUGGESTION") || problem.equals("SOLUTION") || problem.equals("SUPPORT") || problem.equals("OTHERS")) {
            if (tinka) {
                probtinka = 1;
                sgame += " Tinka -";
            }
            if (teapuesto) {
                probteapuesto = 1;
                sgame += " Te Apuesto -";
            }
            if (ganagol) {
                probganagol = 1;
                sgame += " Ganagol -";
            }
            if (ganadiario) {
                probganadiario = 1;
                sgame += " Gana Diario -";
            }
            if (kabala) {
                probkabala = 1;
                sgame += " K·bala -";
            }
            if (super3) {
                probsuper3 = 1;
                sgame += " Super 3 -";
            }
            if (instantaneas) {
                probinstantaneas = 1;
                sgame += " Rapitinkas y Rapigana -";
            }
            if (reventon) {
                probreventon = 1;
                sgame += " El ReventÛn -";
            }
            if (clicygana) {
                probclicygana = 1;
                sgame += " Clic & Gana -";
            }
            if (fechaza) {
                probfechaza = 1;
                sgame += " Fechaza -";
            }
            LoggerApi.Log.info(" sgame --->  " + sgame);
            detail = sgame.substring(0, sgame.lastIndexOf("-"));
        }
        //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        Object[] outCadenas = SalesDispatcher.putCommentRegister(clientid, firstname, lastname, maidenname, department, province, district, doctype, docnumber, birthdate,
                gender, phone, email, problem, probtinka, probteapuesto, probganagol, probganadiario, probkabala, probsuper3, probinstantaneas, probreventon, probclicygana,
                probfechaza, openpos, message);
        String clientIp = request.getRemoteAddr();
        String browser = "";
        String game = "";
        StringBuffer mailBody = new StringBuffer();
        String mailSubject = null;
        mailBody.append("<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' "
                + "rightmargin='0' bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'>"
                + "<tr><td style='background:url("
                + String.valueOf(ConnectionFactory.operationProperty("lotocardServerURI", context)).toString().trim()
                + "/img/account/header-intralot."
                + "jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'></td></tr><tr><td>"
                + "<table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("
                + String.valueOf(ConnectionFactory.operationProperty("lotocardServerURI", context)).toString().trim()
                + "/img/account/header-contactenos.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 110px;'></td></tr><tr><td style='background:url("
                + String.valueOf(ConnectionFactory.operationProperty("lotocardServerURI", context)).toString().trim()
                + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; "
                + "padding: 0; width: 109px;'></td><td bgcolor='#F7F7F7' valign='top' align='center'><table width='549' border='0' cellpadding='0' cellspacing='0' bgcolor='#F7F7F7' "
                + "style='background: #F7F7F7; font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e;'>"
                + "<tr><td colspan='2'>&nbsp;</td></tr><tr><td width='35%'>&nbsp;</td><td width='65%'>&nbsp;</td></tr>");
        if (clientid != null && !clientid.equals(""))
            mailBody.append("<tr><td><b>ID Cliente: </b></td><td>" + clientid + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>");
        mailBody.append("<tr><td><b>Nombres: </b></td><td>" + ClientUtils.formatHtml(firstname) + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td><b>Apellido Paterno: </b></td><td>" + ClientUtils.formatHtml(lastname) + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td><b>Apellido Materno: </b></td><td>" + ClientUtils.formatHtml(maidenname) + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td><b>Ubicaci&oacute;n: </b></td><td>" + ClientUtils.formatHtml(deptname) + " - " + ClientUtils.formatHtml(provname) + " - "
                + ClientUtils.formatHtml(distname) + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>" + "<tr><td><b>Documento: </b></td><td>" + doctname + " - " + docnumber
                + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>" + "<tr><td><b>Fecha de nacimiento: </b></td><td>" + birthdate
                + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>" + "<tr><td><b>Sexo: </b></td><td>" + sgender + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td><b>Tel&eacute;fono: </b></td><td>" + phone + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td><b>Correo electr&oacute;nico: </b></td><td>" + email + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>" + "<tr><td><b>"
                + ClientUtils.formatHtml(sproblem) + ": </b></td><td>" + ClientUtils.formatHtml(detail) + "</td></tr><tr><td colspan='2'>&nbsp;</td></tr>"
                + "<tr><td><b>Mensaje: </b></td><td style='text-align:justify;'>" + ClientUtils.formatHtml(message)
                + "</td></tr><tr><td colspan='2' style='height:20px;'>&nbsp;</td></tr><tr><td colspan='2' "
                + "style='font-size:9px;width:140px;padding:0 0 0 410px;'>Browser: " + browser + "<br/>IP: " + clientIp + "<br/>Viene de: " + game + "</td></tr></table></td>"
                + "<td style='background:url(" + String.valueOf(ConnectionFactory.operationProperty("lotocardServerURI", context)).toString().trim()
                + "/img/account/box-right.gif) repeat-y; " + "border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' style='background:url("
                + String.valueOf(ConnectionFactory.operationProperty("lotocardServerURI", context)).toString().trim()
                + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr></table></td></tr></table></body></html>");
        mailSubject = "[LA_TINKA] " + sproblem;
        if (!detail.equals(""))
            mailSubject += ":" + detail;
        mailSubject += " " + email + "-" + phone;
        String mailSender = String.valueOf(ConnectionFactory.operationProperty("contactMail", context)).toString().trim();
        MailLib.sendValidMail(mailSender, mailSubject, mailBody.toString());
        LoggerApi.Log.info("  outCadenas[0] --> " + outCadenas[0]);
        LoggerApi.Log.info("  outCadenas[1] --> " + outCadenas[1]);
        if (String.valueOf(outCadenas[1]).equals("1")) {
            o.addProperty("message", String.valueOf(outCadenas[1]));
            o.addProperty("info", "Mensaje enviado.");
        }
        if (String.valueOf(outCadenas[1]).equals("2")) {
            o.addProperty("message", String.valueOf(outCadenas[1]));
            o.addProperty("info", "No puede Mensaje enviado.");
        }
        out.print(o);
    }

    @RequestMapping(value = "/verifica-usuario")
    public String verifyUser(HttpServletRequest request, HttpServletResponse response) {
        String p_client_id = "";
        String p_mail = "";
        String p_mail_code = "";
        String p_random_code = "";
        String key = "";
        JsonObject o = new JsonObject();
        try {
            if (request.getParameter("key") != null && !request.getParameter("key").equals("")) {
            	key = request.getParameter("key");
                LoggerApi.Log.info("plainstr=" + key);
                key = key.replace("+", "%2B");
                LoggerApi.Log.info("%plainstr=" + key);
                key = URLDecoder.decode(key, "UTF-8");
                LoggerApi.Log.info("decoded=" + key);
                key = ClientUtils.decrypt_sda(key);
                LoggerApi.Log.info("decrypt=" + key);
                String[] aKey = key.split("\\|");
                p_client_id = aKey[0];
                p_mail = aKey[1];
                p_mail_code = aKey[2];
                p_random_code = aKey[3];
                LoggerApi.Log.info(p_client_id + "|" + p_mail + "|" + p_mail_code + "|" + p_random_code);
                o.addProperty("p_client_id", p_client_id);
                o.addProperty("p_mail", p_mail);
                o.addProperty("p_mail_code", p_mail_code);
                o.addProperty("p_random_code", p_random_code);
                ClientProcedureVerifyClientPromo verifyClientPromo = clientSaleBo.verifyClientPromo(p_client_id, p_mail, p_mail_code, p_random_code);
                HttpSession session = request.getSession();
                if (verifyClientPromo != null && verifyClientPromo.getUser() != null) {
                    ClientProcedureLogin clientLogin = clientSaleBo.findLogin(verifyClientPromo.getUser(), StringLib.decodeLabel(verifyClientPromo.getPassword()));
                   
                    if (clientLogin.getClientId() != null) {
                        ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(clientLogin.getSessionId(), clientLogin.getClientId());
                      
                        ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(clientLogin.getSessionId(), clientLogin.getClientId());
                        
                        JsonObject joDataClient = new JsonObject();
                        joDataClient.addProperty("name", dataClient.getNombre());//nombre
                        joDataClient.addProperty("ApPaterno", dataClient.getApPaterno());//ap paterno
                        joDataClient.addProperty("ApMaterno", dataClient.getApMaterno());//ap materno
                        joDataClient.addProperty("typeId", dataClient.getTypeId());//tipo documento
                        joDataClient.addProperty("numberId", dataClient.getNumberId());//numero documento
                        joDataClient.addProperty("gender", dataClient.getGender());//genero     
                        joDataClient.addProperty("birthDate", dataClient.getBirthDate()); //fecha  de naciento   
                        joDataClient.addProperty("mobilePhone", dataClient.getMobilePhone()); //celular
                        joDataClient.addProperty("comPhones", dataClient.getComPhones()); //tipo de empresa movil
                        joDataClient.addProperty("confirm", dataClient.getConfirm());//check conformidad
                        joDataClient.addProperty("luckyIcon", dataClient.getLuckyIcon());
                        joDataClient.addProperty("fixedPhone", dataClient.getFixedPhone());
                        UserBean userBean = new UserBean();
                        userBean.setpSessionid(clientLogin.getSessionId());
                        userBean.setpUser(clientLogin.getCl_nombre());
                        userBean.setpClientid(clientLogin.getClientId());
                        userBean.setpSessionCode(clientLogin.getSessionCode());
                        userBean.setpStatus(clientLogin.getStatus());
                        userBean.setpMode(Integer.parseInt(clientLogin.getMode()));
                        userBean.setpLuckyIcon(clientLogin.getLuckyIcon());
                        userBean.setpNombre(clientProcedureGetClient.getNombre());
                        userBean.setpMonto(clientProcedureGetClient.getAmount());
                        userBean.setpMailStatus(clientProcedureGetClient.getMailstatus());
                        userBean.setpGame(0);
                        userBean.setpAgreement(clientLogin.getAgreement());
                        userBean.setpMailVerified(clientLogin.getMailVerified());
                        userBean.setpPromotion(clientLogin.getPromotion());
                        userBean.setpPromotionibk(clientLogin.getPromotionibk());
                        session.setAttribute(Constants.USR_SESION, userBean);
                      
                        request.setAttribute("DataClient", joDataClient);
                        request.setAttribute("dataClient", dataClient);
                        request.setAttribute("regions", regionBo.findRegion());
                        ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(clientLogin.getClientId());
                        clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
                        request.setAttribute("clientBalance", clientProcedureAccountData);
                        request.setAttribute("clientSale", clientProcedureGetClient);
                        return "client/verify_user";
                    }
                } else {
                    session.setAttribute("messagePromo", verifyClientPromo.getMessage());
                    LoggerApi.Log.info("messagePromo(redirect:/mi-cuenta.html) --> " + verifyClientPromo.getMessage());
                    return "redirect:/mi-cuenta.html";
                }
            }
            return "redirect:/mi-cuenta.html";
        } catch (Exception e) {
        	LoggerApi.severe(e);
            return "redirect:/mi-cuenta.html";
        } finally {
            LoggerApi.Log.info("verifyUser redirect:/mi-cuenta.html -->" + o.toString());
        }
    }

    @RequestMapping(value = "/get-balance")
    public void getClientBalance(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        UserBean userBean = new UserBean();
        Integer clientId = -9999;
        
        try {        
        	clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        } catch (Exception e) {
        	out.print("null");
        	return;
        }
        		
        Integer sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
        String balanceAmountString = "null";
        if (clientId > 0 && sessionId > 0) {
            ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(sessionId, clientId);
            if (clientProcedureGetClient != null) {
                double balanceAmount = clientProcedureGetClient.getAmount();
                if (balanceAmount >= 0) {
                    if ((UserBean) session.getAttribute(Constants.USR_SESION) != null)
                        userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                    userBean.setpMonto(balanceAmount);
                    session.setAttribute(Constants.USR_SESION, userBean);
                    balanceAmountString = String.valueOf(balanceAmount);
                }
            }
        }
        out.print(balanceAmountString);
    }

    @RequestMapping(value = "update-data-promotion")
    public void updateDataPromotion(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            JsonObject o = new JsonObject();
            HttpSession session = request.getSession();
            UserBean userBean = new UserBean();
            if (session.getAttribute(Constants.USR_SESION) != null)
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            PrintWriter out = response.getWriter();
            ClientBean clientBean = new ClientBean();
            clientBean.setpNombre(request.getParameter("name").trim());
            clientBean.setpApPaterno(request.getParameter("ap-paterno").trim());
            clientBean.setpApMaterno(request.getParameter("ap-materno").trim());
            clientBean.setpTypeId(request.getParameter("typeId").trim());
            clientBean.setpNumberId(request.getParameter("numberId").trim());
            clientBean.setpGender(request.getParameter("gender"));
            clientBean.setpMobilePhone(request.getParameter("mobile-phone").trim());
            clientBean.setpComPhones(request.getParameter("comPhones").trim());
            String day = request.getParameter("day").trim();
            String month = request.getParameter("month").trim();
            String year = request.getParameter("year").trim();
            clientBean.setpBirthDate(day + "/" + month + "/" + year);
            String pConfirm = "N";
            if (request.getParameter("confirm") != null)
                pConfirm = request.getParameter("confirm");
            clientBean.setpConfirm(pConfirm);
            clientBean.setpSessionid(userBean.getpSessionid());
            clientBean.setpClientid(userBean.getpClientid());
            LoggerApi.Log.info("clientBean.getpNombre() -> " + clientBean.getpNombre() + "  " + "clientBean.getpApPaterno() -> " + clientBean.getpApPaterno() + "  "
                    + "clientBean.getpApMaterno() -> " + clientBean.getpApMaterno() + "  " + "clientBean.getpGender() -> " + clientBean.getpGender() + "  "
                    + "clientBean.getpTypeId() -> " + clientBean.getpTypeId() + "  " + "clientBean.getpNumberId() -> " + clientBean.getpNumberId() + "  "
                    + "clientBean.getpMobilePhone() -> " + clientBean.getpMobilePhone() + "  " + "clientBean.getpComPhones() -> " + clientBean.getpComPhones() + "  "
                    + "clientBean.getpBirthDate() -> " + clientBean.getpBirthDate() + "  " + "clientBean.getpConfirm() -> " + clientBean.getpConfirm() + "  "
                    + "clientBean.getpSessionid() -> " + clientBean.getpSessionid() + "  " + "clientBean.getpClientid() -> " + clientBean.getpClientid());
            if (session.getAttribute(Constants.USR_SESION) != null) {
                String mensaje = clientSaleBo.updateClientPromo(clientBean);
                o.addProperty("message", mensaje);
            } else
                o.addProperty("message", "No se realizÔøΩ ningun cambio; por favor inicie sesiÔøΩn.");
           
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        }
    }

    @RequestMapping(value = "update-promo-Condiciones")
    public String updatePromoCondiciones() {
        return "client/update-data-promo";
    }
    
    @RequestMapping("/iflex_launch")
    public void gameLaunch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
      
        Integer clientId = 0;
       
        String authToken = "0";
    	String iflexConfig = Constants.iflexGameProviderBaseUrl+" | "+Constants.iflexLanguage+" | "+Constants.iflexOperatorId+" | "+Constants.iflexCurrency;
        String message = null;
        boolean agreement = false;
 
        UserBean userBean = null;
        try {       
        	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	clientId = userBean.getpClientid();
        	authToken = userBean.getpToken();
        } catch (Exception e) {
        	out.print(iflexConfig+" | "+clientId+" | "+authToken+" | No ha iniciado sesi&oacute;n");
    		
        	return;
        }
 
		if (clientId==null) {
			message = "LOGOUT";
			session.setAttribute("loggedTeApuesto", false);
		} else { 
			  Double saldo = null; 
			  Double bono  = null;	
			try {
				 pe.com.intralot.loto.lib.Dbms rs = new pe.com.intralot.loto.lib.Dbms();
				 String sql = " select max(nvl(cl_balance_amount,0)) + sum(nvl(decode(cg_sale_type,0,cg_balance_amount,0),0)), sum(nvl(decode(cg_sale_type,1,cg_balance_amount,0),0)) from lotocard.client, lotocard.client_game where client_id = ? and client_id = cg_client_id(+) and cg_game_id(+) = 108 ";
				 rs.setSql(sql);
			     rs.setString(1,String.valueOf(userBean.getpClientid()));
			     rs.executeQuery();
			     if (rs.next()) {
			        saldo = rs.getDouble(1);
			        bono  = rs.getDouble(2);
			     }
			     rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        	message = "LOGGED";
	        	session.setAttribute("loggedTeApuesto", agreement);
	        	session.setAttribute("user", userBean.getpUser());
	        	session.setAttribute("saldo", saldo);
	        	session.setAttribute("bono", bono);
	        	agreement = (userBean.getpAgreement()==null || userBean.getpAgreement().trim().equals(""))?false:true;
	        	LoggerApi.Log.info("/iflex_parameters loggedTeApuesto="+agreement+" user="+userBean.getpUser()+" saldo="+saldo+" bono="+bono);
		}
		
    	out.print(iflexConfig+" | "+clientId+" | "+authToken+" | "+message);
		LoggerApi.Log.info("/iflex_launch cid="+clientId+" iflexConfig="+iflexConfig+" | "+clientId+" | "+userBean.getpUser()+" | "+authToken+" | "+agreement+" | "+message+" 3"); 
    }
 
    @RequestMapping(value = "/confirma-tyc")
    public void updateAgreement(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
    	HttpSession session = request.getSession();
        JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        try {
            String agreement = (request.getParameter("agreement")!=null)?request.getParameter("agreement"):"";
            if (session.getAttribute(Constants.CLT_SESSION) != null && agreement.equals("true")) {
            	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
            	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                Integer clientId = (user!=null && user.getClientId()!=null)?user.getClientId():0;
                ClientProcedureUpdateAgreement clientProcedureUpdateAgreement = null;
                if (clientId != null)
                	clientProcedureUpdateAgreement = clientSaleBo.updateAgreement(clientId);
                if (clientProcedureUpdateAgreement != null) {
                	user.setAgreement(clientProcedureUpdateAgreement.getMessage());
            		session.setAttribute(Constants.CLT_SESSION, user);
            		//userBean.setpAgreement(clientProcedureUpdateAgreement.getMessage());
            		//session.setAttribute(Constants.USR_SESION, userBean);
                    o.addProperty("clientId", clientProcedureUpdateAgreement.getClientId());
                    o.addProperty("message", clientProcedureUpdateAgreement.getMessage());
                }
            }   
            outData = callback + "(" + o + ")";
        } catch (Exception e) {
        	o.addProperty("message", "Incidente inesperado [8]");
			outData = callback + "(" + o + ")";
			LoggerApi.severe(e);
			throw e;
        } finally {
        	out.print(outData);
        	LoggerApi.Log.info("/teapuesto-iflex "+o.toString());
        }
    }
    
    @RequestMapping(value = "/send-sms-validation")
    public void putSmsRegister(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData ="";
        try {
	        String phone = (request.getParameter("phone-client")!=null)?request.getParameter("phone-client").toString().trim():"";
	        if(phone.equals("")) {
	        	String registerType=session.getAttribute("registerType")!=null?session.getAttribute("registerType").toString():"";
	        	if(registerType.equals("201")) {
	        		phone=session.getAttribute("celular").toString();
	        	}
	        }
	        
	        ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
	        if(user.getMask_phone()==1 && user.getRegister_incomplete()==1) {
	        	phone=(user!=null)?user.getMobilePhone():"";
	        }
	        //UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
	    	Integer idClient= (user!=null && user.getClientId()!=null)?user.getClientId():0;
	    	//String phoneClient = (user!=null && user.getMobilePhone()!=null)?user.getMobilePhone():"";
	    	String phoneClient = (user!=null)?user.getMobilePhone():"";
	    	boolean update = true,valid=true;
	        
	    	LoggerApi.Log.info("/putSmsRegister phone= "+phone+" idClient= "+idClient+" phoneClient= "+phoneClient);
	        
	    	 if(!ClientUtils.verifySintaxMobilePhone(phone)) {
	    		o.addProperty("status", 9);
	         	o.addProperty("message", "Ingresar n&uacute;mero de celular v&acute;lido");
	         	valid=false;
	         }
	    	 
	    	 if(!phone.equals(phoneClient) && valid) {
	    		 //update phone
	    		 LoggerApi.Log.info(" paso1 phoneClient"+phoneClient+"--phone"+phone);
	    		 ClientProcedureUpdatePhone updatePhone = clientSaleBo.updatePhoneClient(idClient, phone);
	    		 if(!updatePhone.getState().equals(1)) {
	    			 update = false;
	    			 o.addProperty("status", updatePhone.getState());
		        	 o.addProperty("message", updatePhone.getMessage());
		        	 LoggerApi.Log.info(" paso2 update="+update);
	    		 } 

	    	 }
	    	 
	    	if(update && valid) {
	    		user.setMobilePhone(phone);
	    		session.setAttribute(Constants.CLT_SESSION, user);
	    		
	    		ResultBean registerSendSms = securityUtils.putSmsClient(idClient,user.getMobilePhone(), clientSaleBo);
	    		
//	    		o.addProperty("code", registerSendSms.getCode());
	    		o.addProperty("status", registerSendSms.getState());
        		o.addProperty("message", registerSendSms.getMessage());
	    		
//        		session.setAttribute("cel", phone);
        		
	    	}
	         
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [500]");
			LoggerApi.severe(e);
			throw e;
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/putSmsRegister "+o.toString());
		}
    }
    
    @RequestMapping(value = "/validation-activation")
    public void validarActivacion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
            String outData = "";
    		String mobileSmsStatus  = "";
            JsonObject o = new JsonObject();
            
            if(session.getAttribute("clientId")!=null) {
            	mobileSmsStatus= clientSaleBo.findMobileSmsStatus(Integer.parseInt(session.getAttribute("clientId").toString()));
            }
            
            o.addProperty("mobileSmsStatus", mobileSmsStatus);
    		outData = callback + "(" + o + ")";
			out.print(outData);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
    }

    @RequestMapping(value = "/send-code-validation")
    public void updateSmsRegister(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        boolean valid=true;
        
        try {
        	String smsCode = (request.getParameter("sms-code")!=null)?request.getParameter("sms-code").toString().trim():"";
        	
        	String codeValidSize = ConnectionFactory.operationProperty("smsCodeSize", Constants.contextSale);
        	
        	if(!ClientUtils.verifySintaxSmsCode(smsCode,codeValidSize)) {
        		o.addProperty("status", 9);
        		o.addProperty("message", "CÛdigo incorrecto. Verifique si lo escribiÛ correctamente");
        		valid=false;
        	}
        	
        	if(valid) {
        		
        		ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        		//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            	int idClient= (user.getClientId()!=null)?user.getClientId():0;
            	int validTime = Integer.parseInt(ConnectionFactory.operationProperty("smsValidTimeFrame", Constants.contextSale).toString());
            	ClientProcedureUpdateSmsRegister domain = clientSaleBo.updateSmsRegister(idClient, smsCode, validTime);
            	
            	if(domain.getState()==1) {
            		user.setMobileStatus("ACT");
            		session.setAttribute(Constants.CLT_SESSION, user);
            		session.removeAttribute("cel");
            		
            	}
            	String ipUser = ClientUtils.getClientIp(request);
            	ClientSecurityProcedureCheckIp result = clientSaleBo.findGetCheckIp(idClient, ipUser, "DESKTOP");
            	if(result.getStatus().equals("OK_REGISTRO")) {
            		LoggerApi.Log.info("Nuevo Usuario --- Se registro ip en lista blanca + cw_estado=2" );
            	}
            	o.addProperty("status", domain.getState());
            	o.addProperty("message", domain.getMessage());
        		
        	}

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/updateSmsRegister "+o.toString());
		}
    }
    
    /*@RequestMapping(value = "/resend-sms-register")
    public void resendSmsRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        
        ClientProcedureLogin user = (ClientProcedureLogin) session.getAttribute(Constants.USR_SESION);
    	Integer idClient= user.getClientId();
    	String phoneClient = user.getMobilePhone();
    	
        ResultBean result = putSmsClient(idClient,phoneClient);
        
        o.addProperty("code", result.getCode());
        o.addProperty("status", result.getState());
        o.addProperty("message", result.getMessage());
        
        LoggerApi.Log.info("/resend-sms-register "+o.toString());
        out.print(o);
    }*/

    @RequestMapping(value = "/activate-promotion")
    public void activatePromotion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";

        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        		
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	int idClient= user.getClientId();
        	
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureActivatePromotion domain = clientSaleBo.activatePromotion(values);
        	
        	if(domain.getState()==1) {
        		user.setPromotion("");
        		session.setAttribute(Constants.CLT_SESSION, user);
        	}

        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activatePromotion "+o.toString());
		}
    }
    
    @RequestMapping(value = "/activate-wbpromotion")
    public void activateWBPromotion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	int idClient= user.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureActivateWBPromotion domain = clientSaleBo.activateWBPromotion(values);
        	if(domain.getState()==1) {
        		user.setPromotion("");
        		session.setAttribute(Constants.CLT_SESSION, user);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activateWBPromotion "+o.toString());
		}
    }
    
    @RequestMapping(value = "/cancel-promotion")
    public void cancelPromotion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        
        		
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	int idClient= user.getClientId();
        	
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureCancelPromotion domain = clientSaleBo.cancelPromotion(values);
        	
        	if(domain.getState()==1) {
        		user.setPromotion("");
        		session.setAttribute(Constants.CLT_SESSION, user);
        	}

        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/cancelPromotion "+o.toString());
		}
    }
    
    @RequestMapping(value = "/activate-promotionibk")
    public void activatePromotionibk(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";

        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        		
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	int idClient= user.getClientId();
        	
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureActivatePromotionibk domain = clientSaleBo.activatePromotionibk(values);
        	
        	if(domain.getState()==1) {
        		user.setPromotionibk("");
        		session.setAttribute(Constants.CLT_SESSION, user);
        	}

        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activatePromotionibk "+o.toString());
		}
    }
    
    @RequestMapping(value = "/activate-wbpromotionibk")
    public void activateWBPromotionibk(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	int idClient= user.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureActivateWBPromotionibk domain = clientSaleBo.activateWBPromotionibk(values);
        	if(domain.getState()==1) {
        		user.setPromotionibk("");
        		session.setAttribute(Constants.CLT_SESSION, user);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activateWBPromotionibk "+o.toString());
		}
    }
    
    @RequestMapping(value = "/cancel-promotionibk")
    public void cancelPromotionibk(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        
        		
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        	int idClient= user.getClientId();
        	
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureCancelPromotionibk domain = clientSaleBo.cancelPromotionibk(values);
        	
        	if(domain.getState()==1) {
        		user.setPromotionibk("");
        		session.setAttribute(Constants.CLT_SESSION, user);
        		//userBean.setpPromotion("");
        		//session.setAttribute(Constants.USR_SESION, userBean);
        	}

        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/cancelPromotionibk "+o.toString());
		}
    }
    
    //@RequestMapping(value = "/juego-responsable")
    @RequestMapping(value = "/juega-bien")
    public ModelAndView juegoResponsable(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("landing/juego-responsable-landing");
        } catch (Exception e) {
            return new ModelAndView("landing/juego-responsable-landing");
        } 
    }
    
    @RequestMapping(value = "/inversionistas")
    public ModelAndView inversionistas(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
        	return new ModelAndView("redirect:/");
        	//return new ModelAndView("landing/inversionistas-landing");
        } catch (Exception e) {
        	return new ModelAndView("landing/inversionistas-landing");
        } 
    }
    
    @RequestMapping(value = "/responsabilidad-social")
    public ModelAndView responsabilidadSocial(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
        	return new ModelAndView("landing/responsabilidad-social-landing");
        } catch (Exception e) {
            return new ModelAndView("landing/responsabilidad-social-landing");
        } 
    }
    
    @RequestMapping(value = "/responsabilidad-social/{articulo}")
    public ModelAndView responsabilidadSocialArticulo(@PathVariable String articulo,HttpServletRequest request, ModelMap modelMap) throws Exception {
    	ModelAndView modelAndView = new ModelAndView("../../layer-view-interface/landing/responsabilidad-social");
    	
    	try {
        	modelMap.put("title", request.getParameter("title"));
        	modelMap.put("image", request.getParameter("image"));
        	modelMap.put("date", request.getParameter("date"));
        	modelMap.put("contenido", request.getParameter("contenido"));
        	LoggerApi.Log.info("/responsabilidad-social/{articulo} before ");
        	
        	return modelAndView;
        } catch (Exception e) {
            return modelAndView;
        } 
    }
    
    @RequestMapping(value = "/checkChatbot")
    public void checkChatbot(HttpServletRequest request, HttpServletResponse response) throws Exception {
     	PrintWriter out = response.getWriter();
     	JsonObject gson = new JsonObject();
        try {
        	String srcChatbot = ConnectionFactory.operationProperty("chatbot_src", Constants.contextSale);
        	gson.addProperty("src", srcChatbot);
        	
        	String flagChatbot = ConnectionFactory.operationProperty("chatbot_flag", Constants.contextSale);
        	
			if(flagChatbot.equals(Constants.CHATBOT_STATUS_LOGGEDIN)) {
				HttpSession session = request.getSession();
				ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
				if(client!=null) {
					gson.addProperty("visible", "TRUE");
					gson.addProperty("urls", ConnectionFactory.operationProperty("urls_active_chat", Constants.contextSale));
					out.write(gson.toString());
				}else {
					gson.addProperty("visible", "FALSE");
					out.write(gson.toString());
				}
			}else if(flagChatbot.equals(Constants.CHATBOT_STATUS_ALWAYS)) {
				gson.addProperty("visible", "TRUE");
				gson.addProperty("urls", ConnectionFactory.operationProperty("urls_active_chat", Constants.contextSale));
				out.write(gson.toString());
			}else if(flagChatbot.equals(Constants.CHATBOT_STATUS_NEVER)) {
				gson.addProperty("visible", "FALSE");
				out.write(gson.toString());
			}else {
				gson.addProperty("visible", "FALSE");
				out.write(gson.toString());
			}
        } catch (Exception e) {
        	LoggerApi.severe(e);
        	out.write("FALSE");
        }
    }
    
    @RequestMapping(value = "/cambiar-contrasenia")//cambiar-password
    public String changePassword(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception{        
    	String log="cambiar-contrasenia";
    	LoggerApi.Log.info("-------------- START "+log);
    	JSONObject convertedObject=null;
    	String eCommerceHome = Constants.eCommerceHome;
		 String codigoPass = (request.getParameter("param1")!=null)?request.getParameter("param1").replaceAll(" ", "\\+"):"";
		 String email = (request.getParameter("param2")!=null)?request.getParameter("param2"):"";
		 
		try {
			JsonObject jdata = new JsonObject();
			String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi",	Constants.contextPlayerWebApi);
			jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("param1", codigoPass);
			jdata.addProperty("param2", email);
			jdata.addProperty("operatorId", Constants.OPERATOR_ID);
			jdata.addProperty("platform", Constants.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "validateLink"));
			if (convertedObject.has("status") && convertedObject.getString("status").equals("OK")) {
				HttpSession session = request.getSession();
				session.setAttribute("clientIdRecoveryPass", convertedObject.get("clientId"));
				objectModelMap.put("codigoPass", codigoPass);
			    objectModelMap.put("email", email);
				return "client/restablecer_password";
			}else {				
				 return "redirect:" + eCommerceHome;
			}
			

		} catch (Exception e) {
            LoggerApi.severe(e);
            return "redirect:" + eCommerceHome;
        } finally {
        	LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
        	
        }
        
    }
    
@RequestMapping(value ="/enviarDerechosArco")
    public void enviarformDerechosArco(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	JsonObject o = new JsonObject();
    	response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
    	String tipoDocumento ="";
    	String numeroDocumento="";
    	String tipoDocumentolegal ="";
    	String numeroDocumentolegal="";
    	String codeClient = "";
    	String tipo_solicitudSW = "";
    	Date fechaHoy = new Date();
    	String pattern = "dd MMM yyyy',' hh:mm:ss";		
		SimpleDateFormat simpleDateFormat =
		        new SimpleDateFormat(pattern);
		String strDate = simpleDateFormat.format(fechaHoy).toUpperCase();
		String imgTinka= "https://www.latinka.com.pe/latinka/mailing-sale/logo_tinka.gif";
		String imgBanner ="https://www.latinka.com.pe/latinka/mailing-sale/collage-logos.gif";
    	
    	try {
    		String dni         = request.getParameter("dni");
    		String pasaporte         = request.getParameter("document-number-pasap");
    		String carnetext         = request.getParameter("document-number-carex");
    		String imgDNI	   = request.getParameter("imgBase64P1Trans")!=null?request.getParameter("imgBase64P1Trans"):"";
    		String imgDNI2	   = request.getParameter("imgBase64P2Trans")!=null?request.getParameter("imgBase64P2Trans"):"";
    		String imgDNI3	   = request.getParameter("imgBase64P3Trans")!=null?request.getParameter("imgBase64P3Trans"):"";
    		String imgDNI4	   = request.getParameter("imgBase64P4Trans")!=null?request.getParameter("imgBase64P4Trans"):"";
        	String email       = request.getParameter("email");
        	String nombres      = request.getParameter("nombres");
        	String apellidos   = request.getParameter("apellidos");
        	String user    	   = request.getParameter("usuario");
        	String nacionalidad = request.getParameter("nacionalidad");
        	String domicilio   = request.getParameter("domicilio");
        	String telefono    = request.getParameter("telefono");
        	String departamento = request.getParameter("departamento");
        	String provincia = request.getParameter("provincia");
        	String distrito = request.getParameter("distrito");
        	String tipo_solicitud = request.getParameter("solicitud");
        	String razon_solicitud = request.getParameter("razon");
        	String nombre_legal= request.getParameter("name-legal");
        	String apellidos_legal= request.getParameter("ap-paterno-legal");
        	String dni_legal= request.getParameter("document-number-legal");
        	String pasaporte_legal= request.getParameter("document-number-pasap-legal");
        	String carnetex_legal= request.getParameter("document-number-carex-legal");
        	String documentType= request.getParameter("document-type");
        	String documentTypeLegal= request.getParameter("document-type-legal");
        	String isRepresentante= request.getParameter("is-representante");
        	
        	String mensajeError ="";
        	
        	if(nombres==null || nombres.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tus nombres";
        	}else if(apellidos==null || apellidos.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tus apellidos";
//        	}else if(user==null || user.trim().isEmpty()) {
//        		mensajeError ="Debes ingresar tu usuario";
        	}else if(documentType==null) {
        		mensajeError ="Debes seleccionar tu tipo de documento";
        	}else if(!documentType.equals("DNI") && !documentType.equals("PASAP") && !documentType.equals("CAREX")) {
        		mensajeError ="Debes seleccionar un tipo de documento v·lido";
        	}else if(documentType.trim().equals("DNI") && (dni==null || dni.trim().isEmpty())) {
        		mensajeError ="Debes ingresar un DNI v·lido";
        	}else if(documentType.trim().equals("PASAP") && (pasaporte==null || pasaporte.trim().isEmpty())) {
        		mensajeError ="Debes ingresar un pasaporte v·lido";
        	}else if(documentType.trim().equals("CAREX") && (carnetext==null || carnetext.trim().isEmpty())) {
        		mensajeError ="Debes ingresar un carnet de extranjerÌa v·lido";
        	}else if(telefono==null || telefono.trim().isEmpty()) {
        		mensajeError ="Debes ingresar un celular v·lido";
        	}else if(email==null || email.trim().isEmpty()) {
        		mensajeError ="Debes ingresar un correo v·lido";
        	}else if(nacionalidad==null || nacionalidad.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tu nacionalidad";
        	}else if(domicilio==null || domicilio.trim().isEmpty()) {
        		mensajeError ="Tu domicilio es requerido";
        	}else if(departamento==null || departamento.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tu departamento";
        	}else if(provincia==null || provincia.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tu provincia";
        	}else if(distrito==null || distrito.trim().isEmpty()) {
        		mensajeError ="Seleccionar distrito";
        	}else if(imgDNI==null || imgDNI.trim().isEmpty()) {
        		mensajeError ="Debes adjuntar tu documento de identidad";
			}else if(razon_solicitud==null || razon_solicitud.trim().isEmpty()) {
        		mensajeError ="Debes ingresar la razÛn de tu solicitud";
			}else if(tipo_solicitud==null || tipo_solicitud.trim().isEmpty()) {
        		mensajeError ="Debes seleccionar un tipo de solicitud";
			}else if(!tipo_solicitud.equalsIgnoreCase("RECTIFICACI”N") && !tipo_solicitud.equalsIgnoreCase("ACCESO") && 
					!tipo_solicitud.equalsIgnoreCase("CANCELACI”N") && !tipo_solicitud.equalsIgnoreCase("OPOSICI”N")) {
				mensajeError ="Debes seleccionar un tipo de solicitud v·lido";
			}else if(isRepresentante!=null && isRepresentante.trim().equals("true")) {
				if(nombre_legal==null || nombre_legal.trim().isEmpty()) {
	        		mensajeError ="Debes ingresar tus nombres de representante legal";
	        	}else if(apellidos_legal==null || apellidos_legal.trim().isEmpty()) {
	        		mensajeError ="Debes ingresar tus apellidos de representante legal";
	        	}else if(documentTypeLegal==null) {
	        		mensajeError ="Debes seleccionar tu tipo de documento de representante legal";
	        	}else if(!documentTypeLegal.equals("DNI") && !documentTypeLegal.equals("PASAP") && !documentTypeLegal.equals("CAREX")) {
	        		mensajeError ="Debes seleccionar un tipo de documento v·lido de representante legal";
	        	}else if(documentTypeLegal.trim().equals("DNI") && (dni_legal==null || dni_legal.trim().isEmpty())) {
	        		mensajeError ="Debes ingresar un DNI v·lido de representante legal";
	        	}else if(documentTypeLegal.trim().equals("PASAP") && (pasaporte_legal==null || pasaporte_legal.trim().isEmpty())) {
	        		mensajeError ="Debes ingresar un pasaporte v·lido de representante legal";
	        	}else if(documentTypeLegal.trim().equals("CAREX") && (carnetex_legal==null || carnetex_legal.trim().isEmpty())) {
	        		mensajeError ="Debes ingresar un carnet de extranjerÌa v·lido de representante legal";
	        	}else if(imgDNI3==null || imgDNI3.trim().isEmpty()) {
	        		mensajeError ="Debes adjuntar tu documento de identidad de representante legal";
				}else if(imgDNI4==null || imgDNI4.trim().isEmpty()) {
	        		mensajeError ="Debes adjuntar tu declaraciÛn jurada";
				}
			}
        	
        	//validacion de peso e imagen dni correcta
        	if(mensajeError.isEmpty()) {
        		String mensajeValidacion = Constants.validarImagen(imgDNI);
        		if(!mensajeValidacion.isEmpty()) {
        			if(mensajeValidacion.equals("ERROR_PESO")) {
        				mensajeError="T&uacute; imagen de documento de identidad no debe ser mayor a 10mb";
        			}else {
        				mensajeError="Debes adjuntar una imagen de documento de identidad v&aacute;lida";
        			}
        		}
        	}
        	//validacion de peso e imagen evidencia correcta
        	if(mensajeError.isEmpty() && imgDNI2!=null && !imgDNI2.trim().isEmpty()) {
        		String mensajeValidacion = Constants.validarImagen(imgDNI2);
        		if(!mensajeValidacion.isEmpty()) {
        			if(mensajeValidacion.equals("ERROR_PESO")) {
        				mensajeError="T&uacute; imagen de evidencia no debe ser mayor a 10mb";
        			}else {
        				mensajeError="Debes adjuntar una imagen de evidencia v&aacute;lida";
        			}
        		}
        	}
        	//validaciones de peso e imagen legal
        	if(mensajeError.isEmpty() &&  isRepresentante!=null && isRepresentante.trim().equals("true")) {
        		String mensajeValidacion = Constants.validarImagen(imgDNI3);
        		if(!mensajeValidacion.isEmpty()) {
        			if(mensajeValidacion.equals("ERROR_PESO")) {
        				mensajeError="T&uacute; imagen de documento de identidad de representante legal no debe ser mayor a 10mb";
        			}else {
        				mensajeError="Debes adjuntar una imagen de documento de identidad de representante legal v&aacute;lida";
        			}
        		}else {
        			mensajeValidacion = Constants.validarImagen(imgDNI4);
        			if(!mensajeValidacion.isEmpty()) {
            			if(mensajeValidacion.equals("ERROR_PESO")) {
            				mensajeError="T&uacute; imagen de declaraciÛn jurada de representante legal no debe ser mayor a 10mb";
            			}else {
            				mensajeError="Debes adjuntar una imagen de declaraciÛn jurada de representante legal v&aacute;lida";
            			}
            		}
        		}
        	}

        	if(mensajeError.isEmpty()) {
	        	if(!dni.equalsIgnoreCase("")){
	        		tipoDocumento = "DNI";
	        		numeroDocumento = dni;
	        	}else if(!pasaporte.equalsIgnoreCase("")) {
	        		tipoDocumento = "Pasaporte";
	        		numeroDocumento = pasaporte;
	        	}else if(!carnetext.equalsIgnoreCase("")) {
	        		tipoDocumento = "Carnet de Extranjeria";
	        		numeroDocumento = carnetext;
	        	}
	        	
	        	if(!dni_legal.equalsIgnoreCase("")){
	        		tipoDocumentolegal = "DNI";
	        		numeroDocumentolegal = dni;
	        	}else if(!pasaporte_legal.equalsIgnoreCase("")) {
	        		tipoDocumentolegal = "Pasaporte";
	        		numeroDocumentolegal = pasaporte;
	        	}else if(!carnetex_legal.equalsIgnoreCase("")) {
	        		tipoDocumentolegal = "Carnet de Extranjeria";
	        		numeroDocumentolegal = carnetext;
	        	}
	        	
	        	if(codeClient == "" ) {
	        		codeClient = clientSaleBo.findCodUserfilter1(dni, nombres);
	        	}
	        	
	        	if(codeClient  == "") {
	        		codeClient = clientSaleBo.findCodUserfilter2(dni, email);
	        	}
	        	
	        	if(codeClient  == "") {
	        		codeClient = clientSaleBo.findCodUserfilter3(dni, telefono);
	        	}
	        	
	        	if(tipo_solicitud.equalsIgnoreCase("RECTIFICACI”N")) {
	        		tipo_solicitudSW = "RectificaciÛn de Datos Personales";
	        	}else if(tipo_solicitud.equalsIgnoreCase("ACCESO")) {
	        		tipo_solicitudSW = "Acceso a Datos Personales";
	        	}else if(tipo_solicitud.equalsIgnoreCase("CANCELACI”N")) {
	        		tipo_solicitudSW = "CancelaciÛn de Cuenta";
	        	}else if(tipo_solicitud.equalsIgnoreCase("OPOSICI”N")) {
	        		tipo_solicitudSW = "OposiciÛn al uso de datos";
	        	}
	        	
	        	StringBuffer strbf = new StringBuffer();
	        	StringBuffer strbf2 = new StringBuffer();
	        	StringBuffer strbf3 = new StringBuffer();
	        	StringBuffer strbf4 = new StringBuffer();
	    	      Matcher match = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(apellidos);
	    	      Matcher match2 = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(nombres);
	    	      Matcher match3 = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(apellidos_legal);
	    	      Matcher match4 = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(nombre_legal);
	    	      while(match.find()) 
	    	      {
	    	         match.appendReplacement(strbf, match.group(1).toUpperCase() + match.group(2).toLowerCase());
	    	      }
	    	      while(match2.find()) 
	    	      {
	  	         match2.appendReplacement(strbf2, match2.group(1).toUpperCase() + match2.group(2).toLowerCase());
	    	      }
	    	      while(match3.find()) 
	    	      {
	    	    	  match3.appendReplacement(strbf3, match3.group(1).toUpperCase() + match3.group(2).toLowerCase());
	    	      }
	    	      while(match4.find()) 
	    	      {
	    	    	  match4.appendReplacement(strbf4, match4.group(1).toUpperCase() + match4.group(2).toLowerCase());
	    	      }
	    	      //System.out.println(match.appendTail(strbf).toString());
	    	      String f_apellido = match.appendTail(strbf).toString();
	    	      String f_nombres = match2.appendTail(strbf2).toString();
	    	      String fl_apellido = match3.appendTail(strbf3).toString();
	    	      String fl_nombres = match4.appendTail(strbf4).toString();
	        	        	
	        	String bodyCliente = "<html>\r\n" + 
	        			"<head>\r\n" + 
	        			"<title>La Tinka - Derechos Arco</title>\r\n" + 
	        			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
	        			"</head>\r\n" + 
	        			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
	        			"\r\n" + 
	        			"<table width=\"600\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>\r\n" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\">\r\n" + 
	        			"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>\r\n" + 
	        			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>"+f_nombres+" "+f_apellido+"</strong></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"50\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">Recibimos tu solicitud, ser&aacute; atendida dentro del plazo establecido. Te enviamos una copia de los datos recibidos.</td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"	<td width=\"20\"></td>\r\n" + 
	        			"	<td width=\"430\" bgcolor=\"#ffffff\" style=\"display:block; color:#5a5a5a; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">\r\n" + 
	        			"		<strong>DATOS DEL TITULAR</strong><br>\r\n" + 
	        			"		Nombre: "+f_nombres+"<br>\r\n" + 
	        			"		Apellidos: "+f_apellido+"<br>\r\n" + 
	        			"		Usuario: "+user+"<br>\r\n" + 
	        			"		DNI: "+dni+"<br>\r\n" + 
	        			"		Pasaporte: "+pasaporte+"<br>\r\n" + 
	        			"		Carnet de Extranjer&iacute;a: "+carnetext+"<br>\r\n" + 
	        			"		N&uacute;mero de Celular: "+telefono+"<br>\r\n" + 
	        			"		E-mail: "+email+"<br>\r\n" + 
	        			"		Nacionalidad: "+nacionalidad+"<br>\r\n" + 
	        			"		Domicilio: "+domicilio+"<br>\r\n" + 
	        			"		Departamento: "+departamento+"<br>\r\n" + 
	        			"		Provincia: "+provincia+"<br>\r\n" + 
	        			"		Distrito: "+distrito+"<br>\r\n" + 
	        			"		<br>\r\n" + 
	        			"		<strong>DATOS DEL REPRESENTANTE LEGAL</strong><br>\r\n" + 
	        			"		Nombre: "+fl_nombres+"<br>\r\n" + 
	        			"		Apellidos: "+fl_apellido+"<br>\r\n" + 
	        			"		DNI: "+dni_legal+"<br>\r\n" + 
	        			"		Pasaporte: "+pasaporte_legal+"<br> \r\n" + 
	        			"		Carnet de Extranjer&iacute;a: "+carnetex_legal+"<br> \r\n" + 
	        			"		<br>\r\n" + 
	        			"		<strong>TIPO DE SOLICITUD</strong> <br>\r\n" + 
	        			"		Tipo: "+tipo_solicitud+"<br>\r\n" + 
	        			"		<br>\r\n" + 
	        			"		<strong>RAZON DE LA SOLICITUD</strong> <br>\r\n" + 
	        			"		Comentario:"+razon_solicitud+"<br>\r\n" + 
	        			"		\r\n" + 
	        			"		<br>\r\n" + 
	        			"		<br>\r\n" + 
	        			"		</td>\r\n" + 
	        			"		<td width=\"20\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td width=\"20\"></td>\r\n" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"430\"  alt=\"\" style=\"display:block; color:#707070; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:11px; padding-left\">Responderemos a tu solicitud al correo registrado. Las solicitudes se responder·n dentro de los plazos establecidos en el CapÌtulo I del TÌtulo IV del Reglamento de la Ley de ProtecciÛn de Datos Personales, aprobado por Decreto Supremo No. 003-2013-JUS. Si no obtiene respuesta dentro de los plazos indicados podr· ejercer un procedimiento de tutela ante la DirecciÛn General de ProtecciÛn de Datos Personales (Ministerio de Justicia).\r\n" + 
	        			"		<br><br></td>\r\n" + 
	        			"		<td width=\"20\"></td>\r\n" + 
	        			"	</tr>	\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"5\" bgcolor=\"#dedede\">\r\n" + 
	        			"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"5\" bgcolor=\"#dedede\" width=\"600\" height=\"20\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"</table>\r\n" + 
	        			"</body>\r\n" + 
	        			"</html>";
	        	
	        	String body = 
						"##OPERATION=ADD_REQUEST##\r\n"+
						"##REQUESTTEMPLATE=Default Request##\r\n"+
						"##CATEGORY=Canal Web##\r\n"+
						"##SUBCATEGORY=Derechos ARCO (Datos Personales)##\r\n"+
						"##REQUESTTYPE=Incident##\r\n"+
						"##UDF_DATE1="+strDate+"##\r\n"+
						"##UDF_CHAR1=Autoservicio Datos Personales##\r\n"+
						"##ITEM="+tipo_solicitudSW+"##\r\n"+
						"##UDF_CHAR5="+apellidos+"##\r\n"+
						"##UDF_CHAR6="+nombres+"##\r\n"+
						"##UDF_CHAR7="+user+"##\r\n"+
						"##UDF_CHAR4="+telefono+"##\r\n"+
						"##UDF_CHAR3="+email+"##\r\n"+
						"##UDF_CHAR18="+tipoDocumento+"##\r\n"+
						"##UDF_CHAR19="+numeroDocumento+"##\r\n"+
						"##UDF_CHAR34="+nacionalidad+"##\r\n"+						
						"##UDF_CHAR20="+domicilio+"##\r\n"+
						"##UDF_CHAR21="+departamento+"##\r\n"+
						"##UDF_CHAR22="+provincia+"##\r\n"+
						"##UDF_CHAR23="+distrito+"##\r\n"+
						"##UDF_CHAR24="+nombre_legal+"##\r\n"+
						"##UDF_CHAR25="+apellidos_legal+"##\r\n"+
						"##UDF_CHAR26="+tipoDocumentolegal+"##\r\n"+
						"##UDF_CHAR27="+numeroDocumentolegal+"##\r\n"+
						"##UDF_CHAR28="+razon_solicitud+"##\r\n"+
						"##UDF_CHAR2="+codeClient+"##\r\n"+
						"##SUBJECT=ID Cliente "+codeClient+"/ Derechos ARCO - DATOS PERSONALES##\r\n";
	               	        	
	        	o = generarCorreoFormularioPD(imgDNI,imgDNI2, imgDNI3, imgDNI4, o,body,tipo_solicitud,f_nombres,f_apellido,tipoDocumento,numeroDocumento,bodyCliente,email);
        	}else {
        		o.addProperty("message", "KOO");
    			o.addProperty("error", mensajeError);
        	}
        	out.print(o);
		} catch (Exception e) {
			//pe.com.intralot.loto.lib.MailLib.sendValidMail("DesarrollodeSistemas@intralot.com.pe" , "FORMULARIO DERECHOS ARCO "+e.getMessage(), e.toString() );
			o.addProperty("message", "KO");
			o.addProperty("error", "Revise los datos antes de enviarlos.");
			out.print(o);
		}
    
    }
	
	
	public JsonObject generarCorreoFormularioPD(String imgDNI, String imgDNI2,String imgDNI3,String imgDNI4,JsonObject o,String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento,String numeroDocumento,String bodyCliente,String email){
		List<ImgDto> listaImgDto= new ArrayList<ImgDto>();
		try {	
			ImgDto imgdto = new ImgDto();
			ImgDto imgdto2 = new ImgDto();
			ImgDto imgdto3 = new ImgDto();
			ImgDto imgdto4 = new ImgDto();
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
			imgdto.setContenidoImg(decodedBytes);
			imgdto.setFileName("img1.jpg");
			if(imgDNI.contains("png")) {
				imgdto.setTipoImg("image/png");
			}else if(imgDNI.contains("jpeg")) {
				imgdto.setTipoImg("image/jpeg");
			}
			listaImgDto.add(imgdto);
			if(!imgDNI2.equalsIgnoreCase("")) {
				byte[] decodedBytes2 = decoder.decodeBuffer(imgDNI2.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
				imgdto2.setContenidoImg(decodedBytes2);
				imgdto2.setFileName("img2.jpg");
				if(imgDNI2.contains("png")) {
					imgdto2.setTipoImg("image/png");
				}else if(imgDNI2.contains("jpeg")) {
					imgdto2.setTipoImg("image/jpeg");
				}
				listaImgDto.add(imgdto2);
			}
			if(!imgDNI3.equalsIgnoreCase("")) {
				byte[] decodedBytes3 = decoder.decodeBuffer(imgDNI3.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
				imgdto3.setContenidoImg(decodedBytes3);
				imgdto3.setFileName("img3.jpg");
				if(imgDNI3.contains("png")) {
					imgdto3.setTipoImg("image/png");
				}else if(imgDNI3.contains("jpeg")) {
					imgdto3.setTipoImg("image/jpeg");
				}
				listaImgDto.add(imgdto3);
			}
			
			if(!imgDNI4.equalsIgnoreCase("")) {
				byte[] decodedBytes4 = decoder.decodeBuffer(imgDNI4.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
				imgdto4.setContenidoImg(decodedBytes4);
				imgdto4.setFileName("img4.jpg");
				if(imgDNI4.contains("png")) {
					imgdto4.setTipoImg("image/png");
				}else if(imgDNI4.contains("jpeg")) {
					imgdto4.setTipoImg("image/jpeg");
				}
				listaImgDto.add(imgdto4);
			}
																																														
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(decodedBytes);
			baos.flush();
			baos.close();
        	
        	//Envio de correo
			clientSaleBo.enviarMailClientePD(bodyCliente,tipo_solicitud,nombres,apellidos,tipoDocumento,numeroDocumento,email);
			//String result = sendRawMailPD("reclamosvirtuales@latinka.com.pe","SoporteWeb@latinka.com.pe","###WEB Derechos ARCO", body,baos,listaImgDto);
			String result = sendRawMailPD("reclamosvirtuales@latinka.com.pe","soporteweb@sdp730275231.zm.sdpondemand.com","###WEB Derechos ARCO", body,baos,listaImgDto);
			try { sendRawMailPD("reclamosvirtuales@latinka.com.pe","soporteweb@latinka.com.pe","###WEB Derechos ARCO", body,baos,listaImgDto); } catch (Exception e) {;}
        	
        	if(result.equalsIgnoreCase("OK")) {
        		o.addProperty("message", "OK");
        	}else if(result.equalsIgnoreCase("KO")) {
        		o.addProperty("message", "KO");
        	}
		} catch (Exception e) {
			o.addProperty("message", "KO");
			o.addProperty("error", "<p>Revise los datos antes de enviarlos. Alguno de ellos puede tener un tamaÒo muy grande.</p>");
		}
		return o;
	}
	
	
	public String sendRawMailPD(String mailSource, String mailTarget, String mailSubject, String mailBody,ByteArrayOutputStream baos,List<ImgDto> listImgDto)  
	{ 
		try {

			Session session = null;
			
			String contentType = "text/plain; charset=UTF-8";
			
			System.out.println(">>>>>> START sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
			System.out.println("sendValidMail mailSubject="+mailSubject);
			System.out.println("sendValidMail mailBody="+mailBody);
			
			String mailServer = "";
			
			try {
				Context ic = new InitialContext();
				session = (Session)ic.lookup("java:Mail"); 
				//session = (javax.mail.Session) new javax.naming.InitialContext().lookup("java:Mail");
				System.out.println("sendValidMail session=java:Mail");
				 
				try {
					System.out.println( "host="+session.getProperty("mail.smtp.host") );
					System.out.println( "port="+session.getProperty("mail.smtp.port") );
					System.out.println( "from="+session.getProperty("mail.from") );
					System.out.println( "user="+session.getProperty("User") );
				} catch (Exception e) {
					;
				}
				 
			} catch (javax.naming.NamingException e) {
				//System.out.println("mailBody="+mailBody);
				try {
					mailServer = ConnectionFactory.operationProperty("mailServer", "CARD-SMS"); //MAIL_SERVER;
					//mailSource = operationProperty("mailSource", context); //MAIL_SOURCE;
					//System.out.println("mailServer="+mailServer);
					java.util.Properties props = new java.util.Properties();
					props.put("mail.smtp.host", mailServer);
					session = Session.getInstance(props, null);
				} catch (Exception ex) {
					System.out.println("sendValidMail ex.getMessage()="+ex.getMessage());
					//ex.printStackTrace(System.out);
				}
				System.out.println("sendValidMail mailServer="+mailServer);
			}
		// construct the message
			
			
			BodyPart texto = new MimeBodyPart();
	        texto.setContent(mailBody, contentType);
	        MimeMultipart multiParte = new MimeMultipart();
	        multiParte.addBodyPart(texto);
	        
	        
	        if(baos!=null){
	        	for(ImgDto imgdto : listImgDto) {
	        		BodyPart adjunto = new MimeBodyPart();         
		       		ByteArrayDataSource attachment = new  ByteArrayDataSource(imgdto.getContenidoImg(),imgdto.getTipoImg());
		       		adjunto.setDataHandler(new DataHandler(attachment));
		            adjunto.setFileName(imgdto.getFileName());
		            multiParte.addBodyPart(adjunto);
	        	}
	            
	        }
			
			
			

			Message msg = new MimeMessage(session);
			
			//InternetAddress[] ccaddress = new InternetAddress[1];
			//ccaddress[0] = new InternetAddress(mailTarget);//(destino);
			InternetAddress[] ccaddress = InternetAddress.parse(StringLib.removeWhitespaces(mailTarget));
			
			if (mailSource!=null) {
				InternetAddress from = new InternetAddress(mailSource);//(origen);
		        msg.setFrom(from);
			}

			//System.out.println("mailSource="+mailSource+" mailTarget="+mailTarget+" mailSubject="+mailSubject);
			msg.setRecipients(Message.RecipientType.TO,ccaddress);
			msg.setSubject(mailSubject);//(subject);
			//msg.setContent(mailBody, "text/html; charset=UTF-8");//(cuerpo,content);

			System.out.println("sendValidMail contentType="+contentType);
			
			//msg.setContent(mailBody, contentType);
			msg.setContent(multiParte,contentType);
			msg.setHeader("Content-Transfer-Encoding", "binary");
			
			Transport.send(msg);
			
			System.out.println("<<<<<< END sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
			
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "KO";
		}
		
		
		
	}
	
	@RequestMapping(value = "/create-novus-id")
    public void createNovusId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        Integer p_clientId = Integer.parseInt(request.getParameter("client-id"));
        JsonObject o = new JsonObject();
        
        ClientProcedureGetNovusId clientProcedureGetNovusId = clientSaleBo.findGetNovusId(p_clientId);
        
        /*se envia datos del nuevo cliente a novus y se actuliza tabla client cl_novus_id*/
        ApiNovusUtils apiNovus = new ApiNovusUtils("/create-novus-id", p_clientId.longValue(), clientProcedureGetNovusId.getClientUser(), clientProcedureGetNovusId.getClientMail(), clientProcedureGetNovusId.getNombre());
		Long novusid = apiNovus.createUser();
		clientSaleBo.updateNovusId(p_clientId, novusid);
		/*fin*/
        
        out.print(o);
    }
	
	@RequestMapping(value ="/documentvalidation")
    public void documentvalidation(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	JsonObject o = new JsonObject();
    	response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
     	String tipoDocumento ="";
    	String numeroDocumento="";
    	
    	try {
    		tipoDocumento         = request.getParameter("docType");
    		numeroDocumento         = request.getParameter("document");
        	String mensajeError ="";
        	
        	if(tipoDocumento==null || tipoDocumento.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tipo de documento";
        	}
        	if(numeroDocumento==null || numeroDocumento.trim().isEmpty()) {
        		mensajeError ="Debes ingresar N∞ de documento";
        	}
        	
        	if(mensajeError.isEmpty()) {        				        	
        		JsonObject jdata = new JsonObject();
        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", tipoDocumento);
	    		jdata.addProperty("numeroDocumento", numeroDocumento.trim());
	    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
	    		jdata.addProperty("operatorId", Constants.OPERATOR_ID);
	    		jdata.addProperty("platform", Constants.PLATAFORM);
	            
	    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
	            
	            if (convertedObject.getString("status").equals("OK")) {
	            	o.addProperty("message", convertedObject.getString("status"));
	            	o.addProperty("flag", convertedObject.getString("passwordFlag"));
	            	o.addProperty("locked", convertedObject.getString("listaNegra"));
	            }else {
	            	o.addProperty("message", convertedObject.getString("status"));
	            	if(convertedObject.getString("resp_title")!=null) {
	            		o.addProperty("titulo", convertedObject.getString("resp_title"));
		            	o.addProperty("mensaje", convertedObject.getString("resp_message"));
		            	o.addProperty("boton", convertedObject.getString("resp_button"));
	            	}
	            }
	        	 
	        	
        	}else {
        		o.addProperty("message", "KOO");
    			o.addProperty("error", mensajeError);
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("message", "KO");
			o.addProperty("error", "Revise los datos antes de enviarlos");
			out.print(o);
		}    	
    	
    }
	
	@RequestMapping(value = "/completar-registro")
    public String completarRegistro(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
		String log="completar-registro";
		try {
			LoggerApi.Log.info("-------------- START "+log); 
    		HttpSession session = request.getSession();
    		JsonObject o = new JsonObject();
    		String mailCode = (String)session.getAttribute("keyCode");
    		if(mailCode!=null && mailCode.trim().length()>0) o.addProperty("keycode", mailCode);
    		
//    		UserBean userBean = null;
            if (session.getAttribute(Constants.USR_SESION) != null) {
            	return "index";
            }
            request.setAttribute("DataUser", o);
            
            String typedoc=request.getParameter("typedoc");
            String document=request.getParameter("document");
            
            //validaciÛn de datos
            String retypedoc="[A-Z]{3,5}+";
            String redni="[0-9]{8}+";
            String redocument="[a-zA-Z0-9]{9,12}+";
            Boolean verifyTypedoc = new RegexValidator(retypedoc).isValid(typedoc);
            if (!verifyTypedoc){
            	LoggerApi.Log.info(log+" typedoc incorrecto: "+typedoc);
	            return "redirect:registro.html";
            }
            if(typedoc.equals("DNI")) {
            	 Boolean verifyDni = new RegexValidator(redni).isValid(document);
            	 if(!verifyDni) {
            		 LoggerApi.Log.info(log+" dni incorrecto: "+document);
     	             return "redirect:registro.html";
            	 }
            }else {
            	Boolean verifyDocument = new RegexValidator(redocument).isValid(document);
	           	if(!verifyDocument) {
	           		LoggerApi.Log.info(log+" documento incorrecto: "+document);
	    	        return "redirect:registro.html";
	           	 }
            }            
            session.setAttribute("typedoc", typedoc);
            session.setAttribute("document", document);
            
            //obtener celular	            
            String celular="";
            JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("tipoDocumento", typedoc);
    		jdata.addProperty("numeroDocumento", document);
    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
    		jdata.addProperty("operatorId", Constants.OPERATOR_ID);
    		jdata.addProperty("platform", Constants.PLATAFORM);	            
    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
    		if (convertedObject.getString("status").equals("OK")) {
    			if(!convertedObject.getString("passwordFlag").equals("9")) {
    				return "redirect:registro.html";
	    		}
            	celular=convertedObject.getString("celular");
            	session.setAttribute("celular", celular);
            	int length=celular.length();
            	celular=celular.substring(length-3, length);
            	celular="*** *** "+celular;	            	
            }else {
            	return "redirect:registro.html";
            }
    		session.setAttribute("cel", celular);
    		
             if(request.getParameter("operatorId")!=null) {
            	session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            	session.setAttribute("OperatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            }else {
            	session.setAttribute("operatorId", "");
            	session.setAttribute("OperatorId", "");
            }
            if(request.getParameter("redirectGame")!=null) {
            	session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
            }else {
            	session.setAttribute("redirectGame", "");
            }
            if(request.getParameter("ref")!=null) {
            	session.setAttribute("ref", String.valueOf(request.getParameter("ref")).toString().trim());
            }else {
            	session.setAttribute("ref", "");
            }
            if(request.getParameter("urlRedirect5588")!=null) {
            	session.setAttribute("urlRedirect5588", String.valueOf(request.getParameter("urlRedirect5588")).toString().trim());
            }else {
            	session.setAttribute("urlRedirect5588", "");
            }
            if(request.getParameter("urlRedirect5587")!=null) {
            	session.setAttribute("urlRedirect5587", String.valueOf(request.getParameter("urlRedirect5587")).toString().trim());
            }else {
            	session.setAttribute("urlRedirect5587", "");
            }
            modelList.put("OperatorId", request.getParameter("operatorId"));
            modelList.put("redirectGame", request.getParameter("redirectGame"));
            modelList.put("urlRedirect5588", request.getParameter("urlRedirect5588"));
            modelList.put("urlRedirect5587", request.getParameter("urlRedirect5587"));
            modelList.put("ref", request.getParameter("ref"));
            Constants.BANNER_REGISTRO  = ConnectionFactory.operationProperty("bannerRegistro", Constants.contextSale);
            return "client/complete_registration_form_v2";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:registro.html";
        }finally {
			LoggerApi.Log.info("-------------- END "+log); 
		}
    	
    }
	
	@RequestMapping(value = "/completando-registro")
	public void completandoRegistro(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String pPassword = request.getParameter("password-client");
        
        String rePassword =pPassword;
        		
        String pMail1 = request.getParameter("email");
        String pNombre = request.getParameter("name");
        String pApPaterno = request.getParameter("ap-paterno");
        HttpSession session = request.getSession();
        String pTypeId = session.getAttribute("typedoc").toString();
        String pNumberId = session.getAttribute("document").toString();
        JsonObject o = new JsonObject();
        String verifyPersonalInformation=ClientUtils.verifyPersonalInformation(pTypeId,  pNumberId,  pNombre,  pApPaterno);
        if(!verifyPersonalInformation.equals("OK")) {
        	o.addProperty("message", "KO");
        	o.addProperty("info", verifyPersonalInformation);
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyPersonalInformation);
        	out.print(o);
        	return;
        }
        request.setAttribute("pNumberId", pNumberId);
        
        
        String pBirthDate = request.getParameter("fechanac");
        
        String pMobilePhone = request.getParameter("mobile-phone1");
        Integer pMode = 0;
        String pConfirm = "Y";
        
        Calendar calendario = Calendar.getInstance();
        Calendar calendario2 = Calendar.getInstance();
		calendario.setTime(sdf.parse(pBirthDate));
		calendario2.setTime(sdf.parse(pBirthDate));
		calendario.add(Calendar.YEAR, 18);
		calendario2.add(Calendar.YEAR, 101);
		if(calendario.getTime().after(new Date())){
			o.addProperty("message", "KO");
        	o.addProperty("info", "Los juegos son solo para mayores de 18 aÒos.");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "Los juegos son solo para mayores de 18 aÒos.");
        	out.print(o);
        	return;
		}
		
		if(calendario2.getTime().before(new Date())){
			o.addProperty("message", "KO");
        	o.addProperty("info", "Los juegos son solo para menores de 101 aÒos.");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "Los juegos son solo para menores de 101 aÒos.");
        	out.print(o);
        	return;
		}
        
        if(!ClientUtils.verifySintaxMail(pMail1))  {
        	o.addProperty("message", "KO");
        	o.addProperty("info", "El correo ingresado es incorrecto [1]");
        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", "El correo ingresado es incorrecto [1]");
        	out.print(o);
        	return;
        }
        
        String verifyString = ClientUtils.verifyPassword(pNumberId, pPassword, rePassword);        
        
        if (!verifyString.equals("OK")) {
            o.addProperty("message", "KO");
            o.addProperty("info", verifyString);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyString);
            out.print(o);
            return;
        }
        
        //validar que contraseÒa no contenga datos del usuario
    	String verifyString2 = ClientUtils.verifyPasswordRegisterClient(pPassword, pNombre, pApPaterno, pNumberId, pBirthDate, pMobilePhone);
    	if (!verifyString2.equals("OK")) {
    		o.addProperty("message", "KO");
            o.addProperty("info", verifyString2);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyString2);
            out.print(o);
            return;
        }

        String verifyMailString = ClientUtils.verifyEmail(pMail1);
        if (!verifyMailString.equals("OK")) {
            o.addProperty("message", "KO");
            o.addProperty("info", verifyMailString);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyMailString);
            out.print(o);
            return;
        }
        
        //validar nacionalidad, domicilio, departamento, provincia, distrito
        String nacionalidad = request.getParameter("nacionalidad");
        String domicilio = request.getParameter("domicilio");
        String departamento = request.getParameter("departamento");
        String provincia = request.getParameter("provincia");
        String distrito = request.getParameter("distrito");    
        String verifyContactInformation = ClientUtils.verifyContactInformation(nacionalidad, domicilio, departamento, provincia, distrito);
        if (!verifyContactInformation.equals("OK")) {
            o.addProperty("message", "KO");
            o.addProperty("info", verifyContactInformation);
            o.addProperty("rtitle", "Validaci&oacute;n de datos");
        	o.addProperty("rmessage", verifyContactInformation);
            out.print(o);            
            return;
        }
        
        if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587")) {
        	pMode = 5587;
        }else if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5588")) {
        	pMode = 5588;
        }else {
        	pMode = 1;
        }
        
        String bonoQR = (pMode == 5588 && request.getParameter("channel") != null)
				?	StringLib.decodeLongLabel(request.getParameter("channel")).trim() 
				: null;
        
      //servicio updateClientData
		JsonObject jdata = new JsonObject();
		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
		jdata.addProperty("token", tokenPlayerWebApi);
		jdata.addProperty("nombres", pNombre);
		jdata.addProperty("apellidos", pApPaterno);
		jdata.addProperty("tipoDocumento", pTypeId);
		jdata.addProperty("numeroDocumento", pNumberId.trim());
		jdata.addProperty("fechaNacimiento", pBirthDate);
		jdata.addProperty("password", pPassword);
		jdata.addProperty("email", pMail1.toLowerCase().trim());
		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
		jdata.addProperty("confirm", pConfirm);
		jdata.addProperty("operatorId", pMode);
		jdata.addProperty("platform", Constants.PLATAFORM);
		jdata.addProperty("nacionalidad", nacionalidad);
		jdata.addProperty("direccion", domicilio);
		jdata.addProperty("departamento", departamento);
		jdata.addProperty("provincia", provincia);
		jdata.addProperty("distrito", distrito);
		jdata.addProperty("ppeFlag", "1");
		jdata.addProperty("ppeFlag", "1");
		jdata.addProperty("celular", session.getAttribute("celular").toString());		
		
		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updateClientData"));//updateClientData
        
        if (convertedObject.getString("status").equals("OK")) {
           
            String welcome = "Bienvenido a La Tinka, tu registro se ha realizado correctamente.";
            
            o.addProperty("message", "REGISTRO_OK");
            
            ClientProcedureGetLoginData client = null;
            request.setAttribute("nuevoregistro", "true");
            client = securityUtils.obtenerLoginSegCta(request, clientSaleBo);
            LoggerApi.Log.info("/completando-registro clientId="+client.getClientId());
            session.setAttribute("clientProcedureLoginTMP", client); 
            
            session.setAttribute("cel", pMobilePhone);
            session.setAttribute("user", pNumberId);
            session.setAttribute("pass", pPassword);
            session.setAttribute("clientId", client.getClientId());
            session.setAttribute("celular", client.getMobilePhone());
            session.setAttribute("registerType", "201");
            
            LoggerApi.Log.info("/registrar clientId="+client.getClientId());//+" sms-state="+resultSmsRegister.getState()+ " sms-code="+resultSmsRegister.getCode());
            
            o.addProperty("info", welcome);
            o.addProperty("code", 201);
            
            if(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").toString().trim().equals("") && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.lapollaOperatorId.toString().trim())
            		&& !session.getAttribute("operatorId").toString().trim().equals("")) {            	
            	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
            	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== registrar status="+session.getAttribute("operatorId").toString().trim());
            	
            }
            if(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").toString().trim().equals("") && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.tav2OperatorId.toString().trim())
            		&& !session.getAttribute("operatorId").toString().trim().equals(""))  {
            	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
            	
            }
            
            /*se envia client id para crear cliente novus id por ajax*/
			o.addProperty("clientid", client.getClientId());
			/*fin*/
			
			if (bonoQR != null)
				clientSaleBo.updateBonoQr(client.getClientId(), bonoQR);
			
        } else {
            o.addProperty("message", "KO");
            o.addProperty("rtitle", convertedObject.getString("resp_title"));
        	o.addProperty("rmessage", convertedObject.getString("resp_message"));
        	o.addProperty("rbutton", convertedObject.getString("resp_button"));
            LoggerApi.Log.info("/registrar clientState="+convertedObject.getString("status")+" error="+convertedObject.getString("message"));
        }
        out.print(o);
    }
	
	@RequestMapping(value = "/send_password_mail") 
    public void resettlePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="resettlePassword";
		LoggerApi.Log.info("--------------  START "+log);
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String pTypeId = (request.getParameter("document-type")!=null)?request.getParameter("document-type"):"";
        String pNumberId = "";
        JSONObject convertedObject=null;
        String p_game = request.getParameter("game").toString();
        String mail="";
        Dbms rs = null;
//        
//        HttpSession session = request.getSession();
        try {
        	if("DNI".equals(pTypeId) && request.getParameter("document-number").length()==8) {
            	pNumberId = request.getParameter("document-number").trim();
            }else if("PASAP".equals(pTypeId) && request.getParameter("document-number-pasap").length()>=8 && request.getParameter("document-number-pasap").length()<=12) {
            	pNumberId = request.getParameter("document-number-pasap").trim();
            }else if("CAREX".equals(pTypeId) && request.getParameter("document-number-carex").length()>=8 && request.getParameter("document-number-carex").length()<=12) {
            	pNumberId = request.getParameter("document-number-carex").trim();
            }
        	if (pNumberId == null || pNumberId.trim().equals("")) {
                LoggerApi.Log.info(log+" Document no definido: " + pNumberId);
                o.addProperty("message", "Document no definido");
                o.addProperty("rtitle", "Documento no definido");
            	o.addProperty("rmessage", "Su documento no esta definido, verificar el documento.");
            	out.print(o);
            	return;
        	}
        	LoggerApi.Log.info(log+ " Document Type: " + pTypeId+" Document: "+pNumberId);
        	//obtener operatorid
        	int operatorId=Constants.OPERATOR_ID;
        	if(p_game.equals("2")) {
        		operatorId=5588;
        	}
        	//obtener el correo de cliente        	
        	JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("tipoDocumento", pTypeId);
    		jdata.addProperty("numeroDocumento", pNumberId.trim());
    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
    		jdata.addProperty("operatorId", operatorId);
    		jdata.addProperty("platform", Constants.PLATAFORM);
            
    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
            
            if (convertedObject.getString("status").equals("OK")) {
            	mail=convertedObject.getString("email");
            }else {
            	LoggerApi.Log.info(log+" message: " +convertedObject.getString("resp_title")+" "+convertedObject.getString("resp_message"));
//                o.addProperty("message", convertedObject.getString("mensaje"));
            	o.addProperty("rtitle", convertedObject.getString("resp_title"));
            	o.addProperty("rmessage", convertedObject.getString("resp_message"));
                o.addProperty("rbutton", convertedObject.getString("resp_button"));
            	return;
            }
        	
	        	jdata = new JsonObject();
//	    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", pTypeId);
	    		jdata.addProperty("numeroDocumento", pNumberId.trim());
	    		jdata.addProperty("mailOCelular", "MAIL");
	    		jdata.addProperty("link", "");
	    		jdata.addProperty("operatorId", operatorId);
	    		jdata.addProperty("platform", Constants.PLATAFORM);
	    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi2(jdata.toString(), "recoveryPassByDocNumber"));
//                ClientProcedureGetPasswordCode passwordCode = clientSaleBo.findGetPasswordCode(mail, p_password_code);
	    		if (convertedObject.getString("estado").equals("OK")) {
                	o.addProperty("message", convertedObject.getString("estado"));
                    o.addProperty("mailEco", convertedObject.getString("mailEco"));
                    o.addProperty("rtitle", convertedObject.getString("resp_title"));
                    o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));                  
            		
                    
                } else {
                	LoggerApi.Log.info(log+" message: " +convertedObject.getString("mensaje"));
                    o.addProperty("message", convertedObject.getString("mensaje"));
                    o.addProperty("rtitle", convertedObject.getString("resp_title"));
                    o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));
                }
        	
            LoggerApi.Log.info(log+" o="+o);
            
        } catch (Exception e) {
        	o.addProperty("message", "Ocurrio un error");
            o.addProperty("rtitle", "Ocurrio un error");
        	o.addProperty("rmessage", "Ocurrio un error. Revisa si digitaste correctamente y vuelve a intentarlo.");
            LoggerApi.severe(e);
        } finally {
        	out.print(o);
        	try {
				if(rs!=null) {
					System.out.println(log+" cerrando conexion");
					 rs.close();
				}
			} catch (Exception e) {
				System.out.println(log+" cerrando conexion");
				e.printStackTrace();
			}        	
        	LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
        }
    }
	
	@RequestMapping(value = "/send_user_mail")
    public void formUserReminder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="send_user_mail";
		LoggerApi.Log.info("-------------- START "+log);
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String pTypeId = (request.getParameter("document-type")!=null)?request.getParameter("document-type"):"";
        String pNumberId = "";
        JSONObject convertedObject=null;        
        try {
        	if("DNI".equals(pTypeId) && request.getParameter("document-number").length()==8) {
            	pNumberId = request.getParameter("document-number").trim();
            }else if("PASAP".equals(pTypeId) && request.getParameter("document-number-pasap").length()>=8 && request.getParameter("document-number-pasap").length()<=12) {
            	pNumberId = request.getParameter("document-number-pasap").trim();
            }else if("CAREX".equals(pTypeId) && request.getParameter("document-number-carex").length()>=8 && request.getParameter("document-number-carex").length()<=12) {
            	pNumberId = request.getParameter("document-number-carex").trim();
            }
        	
        	if (pNumberId == null || pNumberId.trim().equals("")) {
                LoggerApi.Log.info(log+" Document no definido: " + pNumberId);
                o.addProperty("message", "Document no definido");
                o.addProperty("rtitle", "Documento no definido");
            	o.addProperty("rmessage", "Su documento no esta definido, verificar el documento.");
            	out.print(o);
            	return;
        	}   
        	LoggerApi.Log.info("resettlePassword Document Type: " + pTypeId+" Document: "+pNumberId);
        	        	
            	JsonObject jdata = new JsonObject();
        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", pTypeId);
	    		jdata.addProperty("numeroDocumento", pNumberId.trim());
	    		jdata.addProperty("mailOCelular", "MAIL");
	    		jdata.addProperty("operatorId", Constants.OPERATOR_ID);
	    		jdata.addProperty("platform", Constants.PLATAFORM);
	    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi2(jdata.toString(), "recoveryUserByDocNumber"));
                
	    		if (convertedObject.getString("estado").equals("OK")) {
                	if(convertedObject.getString("resp_button").equals("201")) {
                		o.addProperty("message", convertedObject.getString("estado"));
                        o.addProperty("rtitle", convertedObject.getString("resp_title"));
                        o.addProperty("rmessage", convertedObject.getString("resp_message"));
                        o.addProperty("rbutton", convertedObject.getString("resp_button"));
                	}
                	if(convertedObject.getString("resp_button").equals("202")) {
                		o.addProperty("message", convertedObject.getString("mensaje"));
                        o.addProperty("rmessage", convertedObject.getString("resp_message"));
                        o.addProperty("rbutton", convertedObject.getString("resp_button"));
                	}
                    
                } else {
                    LoggerApi.Log.info("message: "+convertedObject.getString("mensaje"));
                    o.addProperty("message", convertedObject.getString("mensaje"));
                    o.addProperty("rtitle", convertedObject.getString("resp_title"));
                    o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));
                }
        	
            LoggerApi.Log.info(log+" o="+o);
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        	LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
        }
    }

    public static void main(String args[]) {
    	String promo = "LOYALTY";
    	try {
    		for(int i=1; i<=5;i++) {
    			System.out.println(promo.concat(String.valueOf(i))+"->"+StringLib.encodeLongLabel(promo.concat(String.valueOf(i))));
    		}
    		
    		System.out.println("OPTIPOP->"+StringLib.encodeLongLabel("OPTIPOP"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}