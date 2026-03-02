package pe.com.intralot.loto.layer.controller.client;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ApiClient;
import pe.com.intralot.loto.util.CasinoXpgUtils;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.SecurityUtils;
import pe.com.intralot.loto.layer.dto.pam.LoginDataResponse;
import pe.com.intralot.loto.layer.dto.pam.RequestGenerateTokenData;
import pe.com.intralot.loto.layer.dto.pam.SecurityTokenResponse;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetPlayerId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetLastNotifications;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureHasPendingNotificationsRead;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureUpdateNotification;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.lib.StringLib;

import static pe.com.intralot.loto.util.Constants.getPropertyContextSale;
/**
 * <p>
 * NOMBRE: ClientSecurityController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador inicio de sesión
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Inicio de sesión La Polla y Nuevo Te Apuesto
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class ClientSecurityController {

	@Autowired
	private ClientSaleBo clientSaleBo;
	@Autowired
	private SecurityUtils securityUtils;
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;
	@Autowired
    private ClientBo clientBo;

    @RequestMapping(value = "/libro-reclamaciones")
    public String bookform(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/form";
    }
    
    @RequestMapping(value = "/notificaciones")
    public String notificaciones(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	try {
            HttpSession session = request.getSession();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                return "client/notificaciones";
            } else
                return "redirect:/inicio.html";
        } catch (Exception e) {
            LoggerApi.severe(e);
            return "redirect:/inicio.html";
        }
    }
    
    @RequestMapping(value = "/getNotifications")
    public void getNotifications(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        Gson gson = new Gson();
        try {       	
        	if (session != null && session.getAttribute(Constants.USR_SESION) != null) {
        		Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        		List<PaymentPrizeProcedureGetNotifications> lista = paymentPrizeBo.getNotifications(clientId);
        		o.addProperty("status", "OK");
        		o.addProperty("listaNotificaciones", gson.toJson(lista));
        		session.setAttribute("listaNotificaciones", gson.toJson(lista));
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
    @RequestMapping(value = "/getLastNotifications")
    public void getLastNotifications(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        Gson gson = new Gson();
        try {        	
        	if (session != null && session.getAttribute(Constants.USR_SESION) != null) {
        		Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        		List<PaymentPrizeProcedureGetLastNotifications> lista = paymentPrizeBo.getLastNotifications(clientId);
        		o.addProperty("status", "OK");
        		o.addProperty("listaNotificaciones", gson.toJson(lista));
        		session.setAttribute("listaNotificaciones", gson.toJson(lista));
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
    @RequestMapping(value = "/hasPendingNotificationsRead")
    public void hasPendingNotificationsRead(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        Gson gson = new Gson();
        try {        	
        	if (session != null && session.getAttribute(Constants.USR_SESION) != null) {
        		Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        		if ( clientId==null ) {
        			o.addProperty("notificacionesPendientes", 0);
            		session.setAttribute("notificacionesPendientes", 0);
        		} else {
            		PaymentPrizeProcedureHasPendingNotificationsRead obj = paymentPrizeBo.hasPendingNotificationsRead(clientId);
            		o.addProperty("status", "OK");
            		if(obj.getPendientes()>0) {
            			o.addProperty("notificacionesPendientes", obj.getPendientes());
                		session.setAttribute("notificacionesPendientes", obj.getPendientes());
            		}else {
            			o.addProperty("notificacionesPendientes", obj.getPendientes());
                		session.setAttribute("notificacionesPendientes", 0);
            		}        			
        		}
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
    @RequestMapping(value = "/updateNotification")
    public void updateNotification(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        try { 
        	if (session != null && session.getAttribute(Constants.USR_SESION) != null) {
        		Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        		String idNotificacion = request.getParameter("idNotificacion");
        		PaymentPrizeProcedureUpdateNotification obj = paymentPrizeBo.updateNotification(clientId, idNotificacion);
        		o.addProperty("status", obj.getMessage());
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
	@RequestMapping(value = "/derechos-arco")
    public String formDerechosArco(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "wp/interface-form-derechos-arco";
    }
    @RequestMapping(value = "/libro-reclamaciones-respuesta")
    public String bookecho(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String secuencia      = request.getParameter("secuencia"); 
    	if(secuencia!=null) {
    		return "client/echo";
    	}else {
    		return "client/form";
    	}
    }
    
    @RequestMapping(value = "/home_qw4")
    public String home_qw4(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/home_user_qw4";
    }
    
    @RequestMapping(value = "/salir_qw4")
    public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            if (session != null)
                session.invalidate();
            return new ModelAndView("redirect:home_qw4.html");
        } catch (Exception e) {
            String id = LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos." + id);
            return new ModelAndView("redirect:home_qw4.html");
        } finally {
        }
    }
    

    @RequestMapping(value = "/data_session")
    public void loadRecharge(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	o.addProperty("status", "OK");
    	out.print(o);
    }
    
    @RequestMapping(value = "/usr_sesion")
    public void loadUserSesion(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	try {
    		HttpSession session = request.getSession();
    		UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            if (userBean != null && userBean.getpClientid() != null) {
            	o.addProperty("clientId", userBean.getpClientid());
            }else {
            	o.addProperty("clientId", "");
            }
		} catch (Exception e) {
			o.addProperty("clientId", "");
		}
    	out.print(o);
    }
    
	/*
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	@ResponseBody
	public void createCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int tamanioCodigoCaptcha = CaptchaRandomization.getRandomCodeLength(Integer.valueOf("4"), Integer.valueOf("5"));
		IImageGenerator generadorImagen;		
		
		String levelCaptcha = ((ConnectionFactory.operationProperty("levelCaptcha", Constants.contextSale) != null)?ConnectionFactory.operationProperty("levelCaptcha", Constants.contextSale).trim():"2");
		switch (Integer.valueOf(levelCaptcha)) {
			case 1: generadorImagen = new AncientMosaicImageGenerator(); break;
			case 2: generadorImagen = new BlackOverlapImageGenerator(); break;
			case 3: generadorImagen = new BubblesImageGenerator(); break;
			case 4: generadorImagen = new Bullets2ImageGenerator(); break;
			case 5: generadorImagen = new BulletsImageGenerator(); break;
			case 6: generadorImagen = new CaughtInTheNet2ImageGenerator(); break;
			case 7: generadorImagen = new CaughtInTheNetImageGenerator(); break;
			case 8: generadorImagen = new ChalkboardImageGenerator(); break;
			case 9: generadorImagen = new Chess3DImageGenerator(); break;
			case 10: generadorImagen = new ChessImageGenerator(); break;
			case 11: generadorImagen = new ChippedImageGenerator(); break;
			case 12: generadorImagen = new CirclesImageGenerator(); break;
			case 13: generadorImagen = new CollageImageGenerator(); break;
			case 14: generadorImagen = new CorrosionImageGenerator(); break;
			case 15: generadorImagen = new CrossShadow2ImageGenerator(); break;
			case 16: generadorImagen = new CrossShadowImageGenerator(); break;
			case 17: generadorImagen = new CutImageGenerator(); break;
			case 18: generadorImagen = new DartsImageGenerator(); break;
			case 19: generadorImagen = new DistortionImageGenerator(); break;
			case 20: generadorImagen = new ElectricImageGenerator(); break;
			case 21: generadorImagen = new FingerprintsImageGenerator(); break;
			case 22: generadorImagen = new FlashImageGenerator(); break;
			case 23: generadorImagen = new GhostlyImageGenerator(); break;
			case 24: generadorImagen = new Graffiti2ImageGenerator(); break;
			case 25: generadorImagen = new GraffitiImageGenerator(); break;
			case 26: generadorImagen = new HaloImageGenerator(); break;
			case 27: generadorImagen = new InBandagesImageGenerator(); break;
			case 28: generadorImagen = new JailImageGenerator(); break;
			case 29: generadorImagen = new LegoImageGenerator(); break;
			case 30: generadorImagen = new MassImageGenerator(); break;
			case 31: generadorImagen = new MeltingHeat2ImageGenerator(); break;
			case 32: generadorImagen = new MeltingHeatImageGenerator(); break;
			case 33: generadorImagen = new NegativeImageGenerator(); break;
			case 34: generadorImagen = new Neon2ImageGenerator(); break;
			case 35: generadorImagen = new NeonImageGenerator(); break;
			case 36: generadorImagen = new Overlap2ImageGenerator(); break;
			case 37: generadorImagen = new OverlapImageGenerator(); break;
			case 38: generadorImagen = new PaintMessImageGenerator(); break;
			case 39: generadorImagen = new RadarImageGenerator(); break;
			case 40: generadorImagen = new Ripple2ImageGenerator(); break;
			case 41: generadorImagen = new RippleImageGenerator(); break;
			case 42: generadorImagen = new RoughImageGenerator(); break;
			case 43: generadorImagen = new SnowImageGenerator(); break;
			case 44: generadorImagen = new SpiderWeb2ImageGenerator(); break;
			case 45: generadorImagen = new SpiderWebImageGenerator(); break;
			case 46: generadorImagen = new Split2ImageGenerator(); break;
			case 47: generadorImagen = new SplitImageGenerator(); break;
			case 48: generadorImagen = new StitchImageGenerator(); break;
			case 49: generadorImagen = new StrippyImageGenerator(); break;
			case 50: generadorImagen = new SunAndWarmAirImageGenerator(); break;
			case 51: generadorImagen = new Sunrays2ImageGenerator(); break;
			case 52: generadorImagen = new SunraysImageGenerator(); break;
			case 53: generadorImagen = new ThickThinLines2ImageGenerator(); break;
			case 54: generadorImagen = new ThickThinLinesImageGenerator(); break;
			case 55: generadorImagen = new ThinWavyLettersImageGenerator(); break;
			case 56: generadorImagen = new VertigoImageGenerator(); break;
			case 57: generadorImagen = new WantedCircularImageGenerator(); break;
			case 58: generadorImagen = new WaveImageGenerator(); break;
			case 59: generadorImagen = new WavyChessImageGenerator(); break;
			default: generadorImagen = new WavyColorLettersImageGenerator(); break;
		}
		
		ImageSize imageSize = new ImageSize(200, 60);
		CodeStyle estiloCodigoGenerar = CodeStyle.ALPHANUMERIC;
		String textoCaptchaGenerado = generarValorCaptcha(CodeGenerationPurpose.IMAGE_GENERATION, tamanioCodigoCaptcha, estiloCodigoGenerar);
		HttpSession session = request.getSession();		
		String captchaEncode = StringLib.encodeLabel(textoCaptchaGenerado);
		session.setAttribute("captcha", captchaEncode);
		final ByteArrayOutputStream captchaByteArrayOutputStream = generadorImagen.generateImage(textoCaptchaGenerado, CaptchaDefaults.LOCALIZATION, imageSize, null, null).getStream(ImageFormat.PNG);
		response.setHeader("Cache-Control", "private,no-cache,no-store");
		response.setContentType("image/" + ImageFormat.PNG.name().toLowerCase());
		response.getOutputStream().write(captchaByteArrayOutputStream.toByteArray());
	}
	
	private String generarValorCaptcha(final CodeGenerationPurpose paramCodeGenerationPurpose, final int tamanio, final CodeStyle codeStyle) {
		CodeCollection codeCollection = new CodeCollection();
		codeCollection.setCharacterSet(CharacterSetFactory.get(CaptchaDefaults.LOCALIZATION, CaptchaDefaults.CUSTOM_CHARACTER_SET_NAME));
		return codeCollection.getCode("", paramCodeGenerationPurpose, codeStyle, tamanio);
	}
	*/
	public boolean validateLength(HttpServletRequest request) {
		int userLength = 0;
		String user = request.getParameter("user-client");
		if(user!=null) {
			userLength = user.length();
		} else {
			LoggerApi.Log.info("validateLength user=null");
			return false;
		}
		if(userLength==0 || userLength>35) {
			LoggerApi.Log.info("validateLength userLength="+userLength);
			return false;
		}
		String strippedUser = pe.com.intralot.loto.util.StringLib.stripXSS(user);
		if (!strippedUser.equals(user)) {
			LoggerApi.Log.info("validateLength user="+user+" strippedUser="+strippedUser);
			return false;
		}
		
		int passwordLength = 0;
		String password = request.getParameter("password-client");
		if(password!=null) {
			passwordLength = password.length();
		} else {
			LoggerApi.Log.info("validateLength password=null");
			return false;
		}
		if(passwordLength==0 || passwordLength>70) {
			LoggerApi.Log.info("validateLength passwordLength="+passwordLength);
			return false;
		}
		String strippedPassword = pe.com.intralot.loto.util.StringLib.stripXSS(password);
		if (!strippedPassword.equals(password)) {
			try {
				LoggerApi.Log.info("validateLength password="+StringLib.encodeLabel(password)+" strippedPassword="+StringLib.encodeLabel(strippedPassword));
			} catch (Exception e) {}
			return false;
		}
		
		int contentLength = request.getContentLength();
		if(contentLength>419) { // la longitud por default para este request es de 214, por ello 319 considera la longitud del usuario y password
			LoggerApi.Log.info("validateLength contentLength="+request.getContentLength());
			return false;
		}
		return true;
	}
	
    @RequestMapping(value = "/redirectAccountActive")
    public void redirectAccountActive(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START  redirectAccountActive");
    	response.setCharacterEncoding(Constants.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        
    	HttpSession session = request.getSession();
    	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute("clientProcedureLoginTMP");
    	
    	UserBean userBean = new UserBean();
    	userBean.setpSessionid(client.getSessionId());
    	userBean.setpClientid(client.getClientId());
    	userBean.setpNombre(client.getCl_nombre());
    	userBean.setpMail(client.getMail());
    	userBean.setpSessionCode(client.getSessionCode());
    	userBean.setpStatus(client.getStatus());
    	userBean.setpMode(Integer.parseInt(client.getMode()));
    	userBean.setpAgreement(client.getAgreement());
    	userBean.setpMailVerified(client.getMailVerified());
    	userBean.setpMailStatus(client.getMailStatus());
    	userBean.setpMobilePhone(client.getMobilePhone());
    	userBean.setpMobileStatus(client.getMobileStatus());
    	userBean.setpMonto(client.getBalanceAmount());
    	userBean.setpGame(0);
    	userBean.setpUser(client.getUser());						
    	
    	ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(client.getClientId());
    	userBean.setpBilletera2(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getBonusAmount().replaceAll(",","."))));
		userBean.setpBilletera3(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getOtherAmount().replaceAll(",","."))));
		userBean.setpBilletera3Cant(clientProcedureAccountData.getOtherQuantity());

    	session.setAttribute(Constants.USR_SESION, userBean); 

    	ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(client.getSessionId(), client.getClientId());
    	session.setAttribute("email", dataClient.getMail());
    	session.setAttribute("fullName", dataClient.getNombre());
    	session.setAttribute("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
    	session.setAttribute("cid", dataClient.getClientId());

    	ClientProcedureGetDataClient clientS = new ClientProcedureGetDataClient();
    	clientS.setClientId(dataClient.getClientId());
    	clientS.setNombre(dataClient.getNombre());
    	clientS.setApPaterno(dataClient.getApPaterno());
    	clientS.setApMaterno(dataClient.getApMaterno());
    	clientS.setMail(dataClient.getMail());
    	clientS.setNumberId(dataClient.getNumberId());
    	clientS.setTypeId(dataClient.getTypeId());
    	session.setAttribute("CLIENT_SESSION", clientS);
    	
    	o.addProperty("message", Constants.RESULT_OK);
    	o.addProperty("status", Constants.RESULT_OK);
    	out.print(o);
    	LoggerApi.Log.info("-------------- END  redirectAccountActive");
    }
    
	@RequestMapping(value = "/common_login")
	public void loginByUserPass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 LoggerApi.Log.info("start ---------- common_login");
		ClientProcedureGetLoginData client = null;
		Integer cid = 0;
		//Integer captcha = 0;
		Integer state = 0;
		Integer isDataComplete = 1;
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		JsonObject o = new JsonObject();
		Gson gson = new Gson();
		LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
		LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent"));
		
		if(!validateLength(request)) {
			o.addProperty("message", "Datos para ingreso incorrectos. Ingreso denegado.");
			out.print(o);
			return;
		}
		
		Integer gameCode = ((request.getParameter("game-code")!=null) ? Integer.parseInt(request.getParameter("game-code")):0);
		
		LoggerApi.Log.info("/common_login gameCode=" + gameCode );
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("operatorId");
			
			LoggerApi.Log.info("/security_login_session from FORM");
			
			LoggerApi.Log.info("pathName :: " + request.getParameter("pathName") );

			client = securityUtils.obtenerLogin(request, clientSaleBo);
			
			if(client == null) {
				/* A VECES APARECE ESTE MENSAJE INNECESARIAMENTE */
				o.addProperty("message", "Usuario no encontrado [3404]");
				return;
			}
			
				state = client.getState();
				cid = client.getClientId();
				
				LoggerApi.Log.info("/common_login state=" + state + " cid="+cid );
			
			if((client.getStatus() != null && client.getStatus().equals("ERROR")) && client.getMessage() != null && client.getMessage().equals("VALIDACION_DATOS")) {
					o.addProperty("state", "ERROR_VALIDACION_DATOS");
					session.invalidate();
					LoggerApi.Log.info("validarUsuario=" + client.getStatus());
					//o.addProperty("url_error", "./validacion-datos.html");
					return;
			}
				
			if(!client.getStatus().equals("OK")) {
				o.addProperty("error", client.getStatus());
            	o.addProperty("alertLogin", client.getStatus());
            	o.addProperty("title", client.getTitle());
            	o.addProperty("message", client.getMessage());
            	String button=client.getButton();
            	o.addProperty("button", client.getButton());
            	if(button.equals("127")) {
            		o.addProperty("lrdn", session.getAttribute("lrdn").toString());
            		session.removeAttribute("lrdn");
            	}else if(!client.getStatus().equals("AC")){//nuevo
            		session.removeAttribute("typeDoc");
        			session.removeAttribute("tipoDocumento");
        		}
            	
            	
            	if(client.getStatus().equals("AC")) {
            		JsonObject requestJson = new JsonObject();
            		JsonObject jsonRequestData = new JsonObject();
            		jsonRequestData.addProperty("mobilePhone", client.getMessage() );
            		jsonRequestData.addProperty("clientId", client.getTitle() );
            		jsonRequestData.addProperty("where", request.getParameter("pathName").toString() ); 
            		
            		requestJson.add("data", jsonRequestData);
            		requestJson.addProperty("requestIp", "192.68.1.1"); // TODO: falta esto modificar
      		      	
            		Map<String,String> headers = new HashMap<String,String>();
            		String apiClientUser = "";
            		String apiClientPassword = "";
      		      	LoggerApi.Log.info("requestJson.toString() :: " + requestJson.toString());
      		      	
      		      	String responseGenerateToken = ApiClient.post(getPropertyContextSale("urlGenerateTokenActivate"), requestJson.toString(), apiClientUser, apiClientPassword, headers); // TODO: modificar el enlace por el valor de sale.propertiees -- urlGenerateTokenActivate
      		      	SecurityTokenResponse securityTokenResponse = gson.fromJson(responseGenerateToken, SecurityTokenResponse.class);
      		      	
      		      	if(securityTokenResponse != null && securityTokenResponse.getToken() != null){
      		      		
      		      		session.setAttribute("lrdn", StringLib.encodeLabel( StringLib.encodeLabel( request.getParameter("user-client") )+"-"+StringLib.encodeLabel( request.getParameter("password-client") ) ));
      		      	
      		      		String rutaRedirect = "" ;
      		      		String server = request.getRequestURL().toString();
      		      		server = server.substring(0, server.lastIndexOf('/') + 1 );
      					if (pe.com.intralot.loto.util.ConnectionFactory.isDevelopment()) {      						
      						rutaRedirect = getPropertyContextSale("urlPamActivate") + // TODO: modificar con el valor a urlPamActivate 
		      							"?token=" + securityTokenResponse.getToken() + 
		      							"&from=tinkaoglogin&tinkaEnvironment=" + server ;
      					}else {
      						rutaRedirect = getPropertyContextSale("urlPamActivate") + // TODO: modificar con el valor a urlPamActivate 
		      							"?token=" + securityTokenResponse.getToken() + 
		      							"&from=tinkaoglogin" ;
      					}
      		      		
      		      		o.addProperty("redirectActivate", rutaRedirect);
      		      		
      		      	}
            	}
            	
            	return;
			}
			
				
					o = securityUtils.validarUsuarioJson(client, gameCode, request,clientSaleBo);
					if(o.get("state").toString().equals("OK")) request.setAttribute("clientSale", client);
					
					session = request.getSession(false);
					if(session==null || !request.isRequestedSessionIdValid()) {
						session = request.getSession();
					}
					
					
					ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(client.getSessionId(), client.getClientId());
					session.setAttribute("email", dataClient.getMail());
					session.setAttribute("fullName", dataClient.getNombre());
					session.setAttribute("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
					session.setAttribute("cid", dataClient.getClientId());
					
					ClientProcedureGetDataClient clientS = new ClientProcedureGetDataClient();
                	clientS.setClientId(dataClient.getClientId());
                	clientS.setNombre(dataClient.getNombre());
                	clientS.setApPaterno(dataClient.getApPaterno());
                	clientS.setApMaterno(dataClient.getApMaterno());
                	clientS.setMail(dataClient.getMail());
                	clientS.setNumberId(dataClient.getNumberId());
                	clientS.setTypeId(dataClient.getTypeId());
                	
                	HttpSession clientSession = request.getSession();
                	clientSession.setAttribute("CLIENT_SESSION", clientS);
                	
                	ClientProcedureGetPlayerId dataPlayerId = clientSaleBo.findGetPlayerId(client.getClientId());
                	
                	if(dataPlayerId.getPlayerIdXpg() == null) {
                		CasinoXpgUtils u = new CasinoXpgUtils("createPlayer",dataClient.getClientId().toString(), clientSaleBo);            		
                		String playerId = u.processCreate();
                		try {
                    		if(!playerId.isEmpty())
                    			clientSaleBo.updatePlayerId(client.getClientId(), playerId);
                		} catch (Exception e) {
                            LoggerApi.severe(e);	            
                        }
                		
                	}
					
                	if(dataClient.getNombre() == null || dataClient.getApPaterno() == null || dataClient.getTypeId() == null || dataClient.getNumberId() == null  || 
     				   dataClient.getBirthDate() == null || dataClient.getUser() == null || dataClient.getMail() == null || dataClient.getMobilePhone() == null ||
     				  dataClient.getPpe() == null)
     					isDataComplete = 0;
                	
                	o.addProperty("isDataComplete", isDataComplete);
                   
				LoggerApi.Log.info("cid=" + cid + " state=" + state );
			
			
		} catch (Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [3500]");
			LoggerApi.severe(e, o.toString(), o.toString());
	   
		} finally {
			out.print(o);
			if (client != null)
				LoggerApi.Log.info("cid=" + cid + " json="+o.toString());
			else LoggerApi.Log.info(" clientProcedureLogin=null");
	   
		}
  
	}

	@RequestMapping(value = "/teapuesto1")
    public ModelAndView viewTeApuestoFrame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/teapuesto/teapuesto_frame");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/teapuesto_frame");
        } finally {
        }
    }
    @RequestMapping(value = "/teapuesto")
    public ModelAndView viewTeApuestoGame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/teapuesto/teapuesto_header");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/teapuesto_header");
        } finally {
        }
    }
    @RequestMapping(value = "/teapuesto-home")
	public void viewTeApuestoHome(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
        JsonObject o = new JsonObject();
        ClientProcedureAccountData data = null;
		Integer cid = 0;
        
		try {
			if(session != null && session.getAttribute(Constants.USR_SESION) != null) {
				UserBean userBean = (UserBean)session.getAttribute(Constants.USR_SESION);
				cid = userBean.getpClientid();
				String token = userBean.getpToken();
				String agreement = userBean.getpAgreement();
                
                if (cid==null || token==null) {
    				o.addProperty("message", "");
    			} else {
    				
	    				DecimalFormat df = new DecimalFormat("###,###,##0.00");
	    				data = clientSaleBo.findAccountData(cid);
	    				data = ClientUtils.verifiedTestUsersWelcomeBonus(data,session);
	    				o.addProperty("id", cid);
	    				o.addProperty("user", userBean.getpUser());
	    				o.addProperty("balanceAmount", df.format(data.getBalanceAmount()));
	    				o.addProperty("prizeAmount", df.format(data.getKironPrizeAmount()));
	    				if(agreement==null || agreement.trim().equals("")) o.addProperty("message", "TC");
	    				else o.addProperty("message", "OK");
    				
    			}
			} else {
				o.addProperty("message", "");
			}
		} catch(Exception e){
			LoggerApi.severe(e);	
			o.addProperty("message", "");
		} finally {
			out.print(callback + "(" + o + ")");
            LoggerApi.Log.info("/teapuesto-home "+o.toString());
		}
	}
    @RequestMapping(value = "/teapuesto-login")
    public void viewTeApuestoLogin(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	String username = "", password = "";
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		JsonObject joLogin = new JsonObject();
		String outData = "";
		int mode = -1;
		int state = 0;
		ClientProcedureLogin login = null;
		
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		try {
			if(session != null && session.getAttribute(Constants.USR_SESION) != null) {
				
                session.setAttribute(Constants.USR_SESION, null);
			}
			if(StringUtils.isNotEmpty(request.getParameter("user")) && StringUtils.isNotEmpty(request.getParameter("password"))) {
				username = request.getParameter("user").trim().toUpperCase();
				password = request.getParameter("password").trim().toUpperCase();
				if (!username.equals("") && !password.equals("")) {
					login = clientSaleBo.findLogin(username, password);
					if(login != null && login.getClientId()!=null) {
						state = login.getState();
					} else {
						joLogin.addProperty("message", "El usuario o password son incorrectos [1]");
					}
				}
			} else {
				joLogin.addProperty("message", "El usuario o password son incorrectos [2]");
			}
			
			if(state == 1) {
				mode = Integer.parseInt(login.getMode());
				if(mode == 0) {
					UserBean userBean = new UserBean();
                    userBean.setpSessionid(login.getSessionId());
                    userBean.setpUser(username);
                    userBean.setpClientid(login.getClientId());
                    userBean.setpSessionCode(login.getSessionCode());
                    userBean.setpStatus(login.getStatus());
                    userBean.setpMode(Integer.parseInt(login.getMode()));
                    userBean.setpLuckyIcon(login.getLuckyIcon());
                    userBean.setpAgreement(login.getAgreement());
                                       
                    String nombre = login.getCl_nombre();
                 
                    userBean.setpNombre(nombre);
                    userBean.setpMonto(login.getBalanceAmount());
                    userBean.setpMailStatus(login.getMailStatus()); 
                    
                    userBean.setpGame(0);
                    session.setAttribute(Constants.USR_SESION, userBean);
					
					joLogin.addProperty("id", login.getClientId());
					joLogin.addProperty("user", nombre);
					joLogin.addProperty("balanceAmount", df.format(login.getBalanceAmount()));
					joLogin.addProperty("prizeAmount", df.format(0));
					joLogin.addProperty("message", "OK");
					
				} else if(mode > 0) joLogin.addProperty("message", "Con esta cuenta no es posible ingresar a este sistema [3]");
			} else if(state == 2) joLogin.addProperty("message", "El usuario o password son incorrectos. Ingreso denegado [4]");
			else if(state == 3) joLogin.addProperty("message", "El usuario o password son incorrectos. Ingreso denegado [5]");
			else if(state == -1) joLogin.addProperty("message", "Este usuario ha sido bloqueado, comunicarse con La Tinka [6]");
			else joLogin.addProperty("message", "El usuario o password son incorrectos. Ingreso denegado [7]");
			outData = callback + "(" + joLogin + ")";
		} catch(Exception e) {
			joLogin.addProperty("message", "Incidente inesperado [8]");
			outData = callback + "(" + joLogin + ")";
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			LoggerApi.Log.info("/teapuesto-login "+joLogin.toString());
		}
    }
    
    @RequestMapping(value = "/teapuesto-logout")
    public void viewTeApuestoLogout(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
        try {
            HttpSession session = request.getSession(false);
            if(session != null && session.getAttribute(Constants.USR_SESION) != null) session.invalidate();
            o.addProperty("message", "OK");
            o.addProperty("logout", Constants.iflexGameProviderCloseUrl);
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("logout", "");
        } finally {
        	out.print(callback + "(" + o + ")");
            LoggerApi.Log.info(o.toString());
        }
    }
    
    @RequestMapping(value = "/teapuesto-iflex")
    public void viewTeApuestoLoginIflexLaunch(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData client = null;
		try {
			LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
            LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent"));
            
            HttpSession session = request.getSession();
            
            if(session.getAttribute(Constants.CLT_SESSION)!=null) {
          		
          		try {
          			LoggerApi.Log.info("/security_login_session from SESSION");
          			client = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        		} catch (Exception e) {
        			LoggerApi.Log.info("/security_login_session from SESSION EXCEPTION");
        			session.invalidate();
        			session = request.getSession(true); 
        			client = securityUtils.obtenerLogin(request, clientSaleBo);
        		}	
          		LoggerApi.Log.info("/security_login_session client AGREEMENT= "+client.getAgreement()+" ACCOUNT="+client.getMobileStatus());
          	} else {
          		LoggerApi.Log.info("/security_login_session from FORM");
          		//captcha = validarCaptcha(request);
          		client = securityUtils.obtenerLogin(request, clientSaleBo);
          		
          		LoggerApi.Log.info("/security_login_session client AGREEMENT= "+client.getAgreement()+" ACCOUNT="+client.getMobileStatus());
          	} 
            
            
            
            if (client != null) {
                state = client.getState();
                cid = client.getClientId();

                LoggerApi.Log.info("/teapuesto-iflex state=" + state + " cid="+ cid );
                if (state.equals(1)) {
                	o = securityUtils.validarUsuarioJson(client, 108, request,clientSaleBo);
                	String iflexConfig = "", authToken="";
                	if(o.get("state").getAsString().equals("OK")) {
                		request.setAttribute("clientSale", client);
                		o.addProperty("id", cid);
    					o.addProperty("user", client.getCl_nombre());
    					authToken = client.getIflexToken();
				    	iflexConfig = Constants.iflexGameProviderBaseUrl+" | "+Constants.iflexLanguage+" | "+Constants.iflexOperatorId+" | "+Constants.iflexCurrency;
					}
                	
                	o.addProperty("iflex", iflexConfig+" | "+cid+" | "+authToken+" |OK");
                }
                else if (state.equals(2)) {
                	o.addProperty("state", "CC");
                	o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
                }
                else if (state.equals(3)) {
                	o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
                }
                else if (state.equals(-1)) {
                	o.addProperty("message", "Este usuario ha sido bloqueado, comun&iacute;quese a La Tinka.");
                }
                else {
                	o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
                }

                LoggerApi.Log.info("cid=" + cid + " state=" + state );
               } else o.addProperty("message", "Usuario no encontrado [4404]");
           outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [4500]");
			outData = callback + "(" + o + ")";
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			LoggerApi.Log.info("/teapuesto-iflex "+o.toString());
		}
    }
    
    @RequestMapping(value = "/lapolla1")
    public ModelAndView viewLPLoginFrame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	//System.out.println("LAPOLLA1");
        try {
            return new ModelAndView("game/lapolla/lapolla_frame");
        } catch (Exception e) {
        	pe.com.intralot.loto.util.LoggerApi.severe(e);
            return new ModelAndView("game/lapolla/lapolla_frame");
        } finally {
        }
    }
	
    @RequestMapping(value = "/lapolla")
    public ModelAndView viewLPLoginGame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	long startTime = System.currentTimeMillis();
    	//System.out.println("LAPOLLA");
    	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla");
        try {
            return new ModelAndView("game/lapolla/lapolla_header");
        } catch (Exception e) {
        	pe.com.intralot.loto.util.LoggerApi.severe(e);
            return new ModelAndView("game/lapolla/lapolla_header");
        } finally {
        	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
    
    @RequestMapping(value = "/lapolla-logout")
    public void viewLPLogout(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-logout");
    	response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
        try {
        	//System.out.println("session.invalidate=");
            HttpSession session = request.getSession(false);
            if(session != null && session.getAttribute(Constants.USR_SESION) != null) session.invalidate();
            o.addProperty("message", "OK");
            o.addProperty("logout", Constants.lapollaGameProviderCloseUrl);
        } catch (Exception e) {
        	pe.com.intralot.loto.util.LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("logout", "");
        } finally {
        	out.print(callback + "(" + o + ")");
            //LoggerApi.Log.info(o.toString());
            Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-logout jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
    
	@RequestMapping(value = "/lapolla-login")
	public void viewLPLogin(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-login");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData client = null;
		
		try {
			//LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
			Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("Navigator="+request.getParameter("user-browser"));
			//LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent"));
			Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("UserAgent="+request.getHeader("User-Agent"));
            
			HttpSession session = request.getSession();
			
			if(session.getAttribute(Constants.CLT_SESSION)!=null) {	
				try {
					//LoggerApi.Log.info("/lapolla-login from SESSION");
					Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login from SESSION");
					client = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
				} catch (Exception e) {
					//LoggerApi.Log.info("/lapolla-login from SESSION EXCEPTION");
					Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login from SESSION EXCEPTION");
					session.invalidate();
					session = request.getSession(true); 
					client = securityUtils.obtenerLogin(request, clientSaleBo);
				}	
				//LoggerApi.Log.info("/lapolla-login client AGREEMENT= "+procedureLogin.getAgreement()+" ACCOUNT="+procedureLogin.getMobileStatus());
				Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login client AGREEMENT= "+client.getAgreement()+" ACCOUNT="+client.getMobileStatus());
			} else {
				//LoggerApi.Log.info("/lapolla-login from FORM");
				Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login from FORM");
				client = securityUtils.obtenerLogin(request, clientSaleBo);
				//LoggerApi.Log.info("/lapolla-login client AGREEMENT= "+procedureLogin.getAgreement()+" ACCOUNT="+procedureLogin.getMobileStatus());
				Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login client AGREEMENT= "+client.getAgreement()+" ACCOUNT="+client.getMobileStatus());
			}
            
			if(client != null) {
				state = client.getState();
				cid = client.getClientId();

				//LoggerApi.Log.info("/lapolla-login state=" + state + " cid="+ cid );
				Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login state=" + state + " cid="+ cid);
				if(state.equals(1)) {
					//o = validarUsuarioJson(procedureLogin,0,request);
					o = securityUtils.validarUsuarioJson(client, 5587, request,clientSaleBo);
					String LapollaConfig = "", authToken="";
					if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
						request.setAttribute("clientSale", client);
						o.addProperty("id", cid);
						o.addProperty("user", client.getCl_nombre());
						authToken = client.getLapollaToken();
						LapollaConfig = Constants.lapollaGameProviderBaseUrl;
					}
                	
					o.addProperty("lapolla", LapollaConfig+" | "+authToken);
				} else if (state.equals(2)) {
					o.addProperty("state", "CC");
					o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
				} else if (state.equals(3)) {
					o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
				} else if (state.equals(-1)) {
					o.addProperty("message", "Este usuario ha sido bloqueado, comun&iacute;quese a La Tinka.");
				} else {
					o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
				}
				//LoggerApi.Log.info("cid=" + cid + " state=" + state );
				Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login cid=" + cid + " state=" + state);
			} else o.addProperty("message", "Usuario no encontrado [5404]");
			outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [5500]");
			outData = callback + "(" + o + ")";
			pe.com.intralot.loto.util.LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			//LoggerApi.Log.info("/lapolla-login "+o.toString());
			Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-login jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
	}
 
	@RequestMapping(value = "/lapolla-session")
	public void viewLPSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-session");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		UserBean userBean = new UserBean();
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constants.USR_SESION)!=null) {
            	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constants.lapollaGameProviderBaseUrl);
                ClientProcedureLPTokenGeneration lpTokenGeneration = clientSaleBo.getLPToken(userBean.getpClientid(), request.getRemoteAddr());
	          	if (lpTokenGeneration!=null && lpTokenGeneration.getMessage().equals("OK")) {
	          		o.addProperty("authToken", lpTokenGeneration.getLapollaToken());
	          	}
            } else {
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constants.lapollaGameProviderCloseUrl);
            }
        } catch (Exception e) {
        	pe.com.intralot.loto.util.LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            //LoggerApi.Log.info(o.toString());
        	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-session jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
	
	@RequestMapping(value = "/lapolla-nosession")
	public void viewLPNoSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-nosession");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
        try {
        	HttpSession session = request.getSession();
        	if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.lapollaOperatorId.toString().trim())) {
        		o.addProperty("redireccion", Constants.lapollaGameProviderBalanceUrl);
        		Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== lapolla-nosession redireccion="+Constants.lapollaGameProviderBalanceUrl);
            	session.removeAttribute("operatorId");
        	}
        } catch (Exception e) {
        	pe.com.intralot.loto.util.LoggerApi.severe(e);
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            //LoggerApi.Log.info(o.toString());
        	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-nosession jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
	
	@RequestMapping(value = "/tav21")
    public ModelAndView viewTANLoginFrame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	//System.out.println("TAv21");
        try {
            return new ModelAndView("game/teapuesto/tav2_frame");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/tav2_frame");
        } finally {
        }
    }
	
    @RequestMapping(value = "/tav2")
    public void viewTANLoginGame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	//System.out.println("TAv2");
        try {
			HttpSession session = request.getSession();
        	if(session.getAttribute(Constants.CLT_SESSION)!=null) {	
        		session.removeAttribute(Constants.CLT_SESSION);
        	}
        	String redirectGame = request.getParameter("redirectGame");
        	String urlRedirect5588 = request.getParameter("urlRedirect5588");
        	String ref = (request.getParameter("ref") == null ? "" : request.getParameter("ref"));
        	request.setAttribute("redirectGame", redirectGame);
        	request.setAttribute("urlRedirect5588", urlRedirect5588);
        	request.setAttribute("ref", ref);
        	
        	session.setAttribute("redirectGame", redirectGame);
        	session.setAttribute("urlRedirect5588", urlRedirect5588);
        	session.setAttribute("ref", ref);
        	
        	String urlRedirect5587 = request.getParameter("urlRedirect5587");
        	if(urlRedirect5587!=null && !urlRedirect5587.trim().isEmpty()) {
            	session.setAttribute("operatorId", "5587");
            	session.setAttribute("OperatorId", "5587");
            	session.setAttribute("urlRedirect5587", urlRedirect5587);
            }else {
            	session.setAttribute("operatorId", "5588");
            	session.setAttribute("OperatorId", "5588");
            }
        	
        	// TODO: agregando logica de redireccion al login
			String redirect = getPropertyContextSale("urlPamLogin") + "?operatorId=5588&from=teapuesto" ;
			String bodyRequest = "{}";
			Map<String,String> headers = new HashMap<String,String>();
			headers.put("X-Ip-Origin", "192.68.1.1"); // TODO : aqui falta modificar el request.getRemoteAddr()
			headers.put("X-Company", "ECOM");
			//obtiene token
			String tokenResponse = ApiClient.post( getPropertyContextSale("urlSecurityToken") , bodyRequest, "12345678", "12345678", headers);

			String token = "" ;
			
			SecurityTokenResponse responseToken = new SecurityTokenResponse();
			Gson gson = new Gson();
			
			responseToken = gson.fromJson(tokenResponse, SecurityTokenResponse.class);
			LoggerApi.Log.info("tokenResponse="+tokenResponse);
			if (responseToken.getToken() != null && !responseToken.getToken().equals("")) {
				token = "&token=" + responseToken.getToken();
			}
        	
			redirect += token + "&ref=" + ref.replaceAll("/","*");
			
			response.sendRedirect(redirect);
        	
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        }
    }
    
    @RequestMapping(value = "/tav2-logout")
    public void viewTANLogout(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
        try {
        	//System.out.println("session.invalidate=");
            HttpSession session = request.getSession(false);
            if(session != null && session.getAttribute(Constants.USR_SESION) != null) session.invalidate();
            o.addProperty("message", "OK");
            o.addProperty("logout", Constants.tav2GameProviderCloseUrl);
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("logout", "");
        } finally {
        	out.print(callback + "(" + o + ")");
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/laPollaTA")
    public String laPollaTA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "game/lapolla/lapolla_tav2";
    }
	
	@RequestMapping(value = "/laPollaTARedirect")
	public void laPollaTARedirect(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START laPollaTARedirect uuid="+uuid.toString());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
			String urlRedirect5587 = Constants.lapollaGameProviderBaseUrl;
			HttpSession session = request.getSession();
			ClientProcedureGetLoginData procedureLogin = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
			if(procedureLogin!=null) {
				urlRedirect5587+="?authToken="+procedureLogin.getLapollaToken();
			}
			System.out.println("laPollaTARedirect urlRedirect5587: " + urlRedirect5587);
			o.addProperty("url", urlRedirect5587);
			out.print(o);
		} catch (Exception e) {
			out.print(o);
			LoggerApi.severe(e);
		}
		LoggerApi.Log.info("-------------- END laPollaTARedirect uuid="+uuid.toString());
	}
	
	@RequestMapping(value = "/tav2-login")
	public void viewTANLogin(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData client = null;
		
		try {
			LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
			LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent"));
            
			if(!validateLength(request)) {
				o.addProperty("message", "Dato para ingreso incorrecto. Ingreso denegado.");
	        	outData = callback + "(" + o + ")";
	        	out.print(outData);
				return;
			}
			
			HttpSession session = request.getSession();
//			String valor = request.getParameter("sentCaptcha");
//			if(valor!=null && !valor.trim().isEmpty()) {
//				Object captcha = session.getAttribute("captcha");
//				if(captcha!=null && !captcha.toString().isEmpty()){
//					String captchaDecode = StringLib.decodeLabel(captcha.toString());
//					if(!valor.equalsIgnoreCase(captchaDecode.toString())){
//						session.setAttribute("captcha", null);
//						o.addProperty("message", "El código ingresado es incorrecto");
//						outData = callback + "(" + o + ")";
//						return;
//					}else {
//						session.setAttribute("captcha", null);
//						LoggerApi.Log.info("/tav2-login from FORM");
//						procedureLogin = securityUtils.obtenerLogin(request, clientSaleBo);
//						LoggerApi.Log.info("/tav2-login client AGREEMENT= "+procedureLogin.getAgreement()+" ACCOUNT="+procedureLogin.getMobileStatus());
//					}
//				}else {
//					session.setAttribute("captcha", null);
//					o.addProperty("message", "Datos no validos");
//					outData = callback + "(" + o + ")";
//					return;
//				}
//			}else {
//				session.setAttribute("captcha", null);
//				o.addProperty("message", "Acceso no valido");
//				outData = callback + "(" + o + ")";
//				return;
//			}
			client = securityUtils.obtenerLogin(request, clientSaleBo);
			if(client != null) {
				state = client.getState();
				cid = client.getClientId();

				LoggerApi.Log.info("/tav2-login state=" + state + " cid="+ cid );
//				if(state.equals(1)) {
				if (client.getStatus().equals("OK")) {
					o = securityUtils.validarUsuarioJson(client, 5588, request,clientSaleBo);
					String TAv2Config = "", authToken="", ref="";
					String urlRedirect5587="";
					String operatorId="";
					if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
						session = request.getSession(false);
						if(session==null || !request.isRequestedSessionIdValid()) {
							session = request.getSession();
						}
						
						request.setAttribute("clientSale", client);
						o.addProperty("id", cid);
						o.addProperty("user", client.getCl_nombre());
						
						if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587") && request.getParameter("urlRedirect5587")!=null) {							
							if (!ConnectionFactory.operationProperty("applicationArea", "sale").toString().trim().toLowerCase().equals("production")) {
								urlRedirect5587 = request.getParameter("urlRedirect5587").toString().trim();
							}else {
								urlRedirect5587 = Constants.lapollaGameProviderBaseUrl;
							}
							operatorId="5587";
							authToken = client.getLapollaToken();
						}else {
							operatorId="5588";
							authToken = client.getTav2Token();
						}
						String urlRedirect5588	= request.getParameter("urlRedirect5588");
						ref = "&ref="+request.getParameter("ref");
						TAv2Config = (urlRedirect5588 != null && !urlRedirect5588.equals("")) ? urlRedirect5588 : Constants.tav2GameProviderBaseUrl;			
						
						Integer idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
						Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
					
						if (idSession != null && idClient != null) {
							ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
							session.setAttribute("email", dataClient.getMail());
							session.setAttribute("fullName", dataClient.getNombre());
							session.setAttribute("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
							session.setAttribute("cid", dataClient.getClientId());
							
							ClientProcedureGetDataClient clientS = new ClientProcedureGetDataClient();
		                	clientS.setClientId(dataClient.getClientId());
		                	clientS.setNombre(dataClient.getNombre());
		                	clientS.setApPaterno(dataClient.getApPaterno());
		                	clientS.setApMaterno(dataClient.getApMaterno());
		                	clientS.setMail(dataClient.getMail());
		                	clientS.setNumberId(dataClient.getNumberId());
		                	clientS.setTypeId(dataClient.getTypeId());
		                	
		                	HttpSession clientSession = request.getSession();
		                	clientSession.setAttribute("CLIENT_SESSION", clientS);
						}
					}	
					
					if(operatorId.equals("5588")) {
						System.out.println("tav2: " + TAv2Config+" | "+authToken+ref);
						o.addProperty("tav2", TAv2Config+" | "+authToken+ref);
					}else {
						System.out.println("tav2: " + urlRedirect5587+" | "+authToken);
						o.addProperty("tav2", urlRedirect5587+" | "+authToken);
					}
					
					// Corrije NullPointer en el session del lightbox de SMS
				    session.setAttribute(Constants.CLT_SESSION, client);
				    
				    // Validacion de contraseña expirada para usar en el front
				    if(client.getButton()!=null && client.getButton().equals("145")) {
				    	o.addProperty("flagPassword", client.getButton());
				    	o.addProperty("mensajePassword", client.getMessage());
				    	o.addProperty("tituloPassword", client.getTitle());
				    }
				} else {
					o.addProperty("error", client.getStatus());
	            	o.addProperty("alertLogin", client.getStatus());
	            	o.addProperty("title", client.getTitle());
	            	o.addProperty("message", client.getMessage());
	            	String button=client.getButton();
	            	o.addProperty("button", client.getButton());
	            	if(button.equals("127")) {
	            		o.addProperty("lrdn", session.getAttribute("lrdn").toString());
	            		session.removeAttribute("lrdn");
	            	}
				}
				
//				else if (state.equals(2)) {
//					o.addProperty("state", "CC");
//					o.addProperty("message", "EL USUARIO O CONTRASEÑA SON INV&Aacute;LIDOS");
//				} else if (state.equals(3)) {
//					o.addProperty("message", "EL USUARIO O CONTRASEÑA SON INV&Aacute;LIDOS");
//				} else if (state.equals(-1)) {
//					o.addProperty("message", "Este usuario ha sido bloqueado, comun&iacute;quese a La Tinka.");
//				} else {
//					o.addProperty("message", "EL USUARIO O CONTRASEÑA SON INV&Aacute;LIDOS");
//				}
				LoggerApi.Log.info("cid=" + cid + " state=" + state );
			} else o.addProperty("message", "Usuario no encontrado [6404]");
			outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [6500]");
			outData = callback + "(" + o + ")";
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			LoggerApi.Log.info("/tav2-login "+o.toString());
		}
	}
 
	@RequestMapping(value = "/tav2-session")
	public void viewTANSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 LoggerApi.Log.info("start ---------- tav2-session");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		UserBean userBean = new UserBean();
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constants.USR_SESION)!=null) {
            	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constants.tav2GameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(userBean.getpClientid(), request.getRemoteAddr());
	          	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
	          		o.addProperty("authToken", tanTokenGeneration.getTav2Token());
	          	}
            } else {
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constants.tav2GameProviderCloseUrl);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/tav2-nosession")
	public void viewTANNoSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
        try {
        	HttpSession session = request.getSession();
        	if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.tav2OperatorId.toString().trim())) {
        		if(request.getParameter("redirectGame") != null && request.getParameter("redirectGame").toString().equals("DV"))
        			o.addProperty("redireccion", Constants.ddvvGameProviderCloseUrl);
        		else
        			o.addProperty("redireccion", Constants.tav2GameProviderCloseUrl);
        		//session.removeAttribute("operatorId");
        	}
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/ddvv-session")
	public void viewDDVVSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		UserBean userBean = new UserBean();
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constants.USR_SESION)!=null) {
            	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constants.tav2GameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(userBean.getpClientid(), request.getRemoteAddr());
	          	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
	          		o.addProperty("authToken", tanTokenGeneration.getTav2Token()+"&ref=/virtuals");
	          	}
            } else {
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constants.ddvvGameProviderCloseUrl);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/recuperar-contrasenia-ta")//recuperar-password-ta
	   public String recuperarPasswordTA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		//return new ModelAndView("redirect:tav2-session.html");
		return "game/teapuesto/tav2_recuperar_password";
	}
	
	@RequestMapping(value = "/cambiar-contrasenia-ta")
	   public String cambiarPasswordTA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		 String log="cambiar-contrasenia-ta";
    	 LoggerApi.Log.info("-------------- START "+log);
    	 JSONObject convertedObject=null;
    	 String redirectUrl = Constants.tav2GameProviderCloseUrl;
		 String codigoPass = (request.getParameter("param1")!=null)?request.getParameter("param1").replaceAll(" ", "\\+"):"";
		 String email = (request.getParameter("param2")!=null)?request.getParameter("param2"):"";
		 		 
		 try {
			JsonObject jdata = new JsonObject();
			String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi",	Constants.contextPlayerWebApi);
			jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("param1", codigoPass);
			jdata.addProperty("param2", email);
			jdata.addProperty("operatorId", 5588);
			jdata.addProperty("platform", Constants.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "validateLink"));
			if (convertedObject.has("status") && convertedObject.getString("status").equals("OK")) {
				HttpSession session = request.getSession();
				session.setAttribute("clientIdRecoveryPass", convertedObject.get("clientId"));
				objectModelMap.put("codigoPass", codigoPass);
			    objectModelMap.put("email", email);
			    return "game/teapuesto/tav2_cambiar_password";
				 }else {
				return "redirect:" + redirectUrl;
	         				}
	         			} catch (Exception e) {
	            LoggerApi.severe(e);
				 return "redirect:" + redirectUrl;
         } finally {
        	LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
					 
			 }
	   	 
	   }
	
	@RequestMapping(value = "/recuperar-usuario-ta")
	   public String recuperarUserTA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		//return new ModelAndView("redirect:tav2-session.html");
		return "game/teapuesto/tav2_recuperar_user";
	   }
	
	@RequestMapping(value = "/teapuesto-tav2")
    public String teapuesto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "game/teapuesto/teapuesto_tav2";
    }
	
	@RequestMapping(value = "/juegos-virtuales-session")
	public void viewJuegosVirtualesSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		UserBean userBean = new UserBean();
		String producto = request.getParameter("producto");
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constants.USR_SESION)!=null) {
            	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constants.juegosVirtualesGameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(userBean.getpClientid(), request.getRemoteAddr());
	          	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
	          		o.addProperty("authToken", tanTokenGeneration.getTav2Token()+"&ref=/" + producto);
	          	}
            } else {
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constants.juegosVirtualesGameProviderCloseUrl+producto);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/common_login_dt")
	public void loginByUserPassDT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("start ---------- common_login_dt");
		ClientProcedureGetLoginData client = null;
		Integer cid = 0;
		//Integer captcha = 0;
		Integer state = 0;
		Integer isDataComplete = 1;
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		JsonObject o = new JsonObject();
		
		LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
		LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent"));
		
		if(!validateLengthDT(request)) {
			o.addProperty("message", "Datos para ingreso incorrectos. Ingreso denegado.");
			out.print(o);
			return;
		}
		
		Integer gameCode = ((request.getParameter("game-code")!=null) ? Integer.parseInt(request.getParameter("game-code")):0);
		
		LoggerApi.Log.info("/common_login gameCode=" + gameCode );
		try {
			HttpSession session = request.getSession();
			LoggerApi.Log.info("/security_login_session from FORM");

			client = securityUtils.obtenerLogin(request, clientSaleBo);

			if(request.getParameter("lg-document-type")!=null && !request.getParameter("lg-document-type").trim().equals("")) {
				session.setAttribute("tipoDocumento", request.getParameter("lg-document-type").trim());
			}
				
			if (client == null) {
				/* A VECES APARECE ESTE MENSAJE INNECESARIAMENTE */
				o.addProperty("message", "Usuario no encontrado [3404]");
			}
			
			if((client.getStatus() != null && client.getStatus().equals("ERROR")) && client.getMessage() != null && client.getMessage().equals("VALIDACION_DATOS")) {
				LoggerApi.Log.info("validarUsuario=" + client.getStatus());
				o.addProperty("state", "ERROR_VALIDACION_DATOS");
				session.invalidate();
				session = request.getSession(true);
				//o.addProperty("url_error", "./validacion-datos.html");
				return;
			}
				state = client.getState();
				cid = client.getClientId();
				
			LoggerApi.Log.info("/common_login_dt state=" + state + " cid="+cid );
				if (!client.getStatus().equals("OK")) {
					this.activationMicroFront(client, session, request, o);       
					return;
				} else {					
					o = securityUtils.validarUsuarioJson(client, gameCode, request,clientSaleBo);
					if(o.get("state").toString().equals("OK")) request.setAttribute("clientSale", client);
					
					session = request.getSession(false);
					if(session==null || !request.isRequestedSessionIdValid()) {
						session = request.getSession();
					}
					
					
					ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(client.getSessionId(), client.getClientId());
					session.setAttribute("email", dataClient.getMail());
					session.setAttribute("fullName", dataClient.getNombre());
					session.setAttribute("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
					session.setAttribute("cid", dataClient.getClientId());
					
					ClientProcedureGetDataClient clientS = new ClientProcedureGetDataClient();
                	clientS.setClientId(dataClient.getClientId());
                	clientS.setNombre(dataClient.getNombre());
                	clientS.setApPaterno(dataClient.getApPaterno());
                	clientS.setApMaterno(dataClient.getApMaterno());
                	clientS.setMail(dataClient.getMail());
                	clientS.setNumberId(dataClient.getNumberId());
                	clientS.setTypeId(dataClient.getTypeId());
                	
                	HttpSession clientSession = request.getSession();
                	clientSession.setAttribute("CLIENT_SESSION", clientS);
                	
                	ClientProcedureGetPlayerId dataPlayerId = clientSaleBo.findGetPlayerId(client.getClientId());
                	
                	if(dataPlayerId.getPlayerIdXpg() == null) {
                		CasinoXpgUtils u = new CasinoXpgUtils("createPlayer",dataClient.getClientId().toString(), clientSaleBo);            		
                		String playerId = u.processCreate();
                		try {
                    		if(!playerId.isEmpty())
                    			clientSaleBo.updatePlayerId(client.getClientId(), playerId);
                		} catch (Exception e) {
                            LoggerApi.severe(e);	            
                        }
                		
                	}
					
                	if(dataClient.getNombre() == null || dataClient.getApPaterno() == null || dataClient.getTypeId() == null || dataClient.getNumberId() == null  || 
     				   dataClient.getBirthDate() == null || dataClient.getUser() == null || dataClient.getMail() == null || dataClient.getMobilePhone() == null ||
      				   dataClient.getPpe() == null)
     					isDataComplete = 0;
				LoggerApi.Log.info("cid=" + cid + " state=" + state );
			}
			
		} catch (Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [3500]");
			LoggerApi.severe(e, o.toString(), o.toString());
	   
		} finally {
			out.print(o);
			if (client != null)
				LoggerApi.Log.info("cid=" + cid + " json="+o.toString());
			else LoggerApi.Log.info(" clientProcedureLogin=null");
	   
		}
  
	}
	
	private void activationMicroFront(ClientProcedureGetLoginData client, HttpSession session, HttpServletRequest request,
			JsonObject o) throws Exception {
		
		o.addProperty("error", client.getStatus());
		o.addProperty("alertLogin", client.getStatus());
		o.addProperty("title", client.getTitle());
		o.addProperty("message", client.getMessage());
		String button = client.getButton();
		o.addProperty("button", client.getButton());
		if (button.equals("127")) {
			o.addProperty("lrdn", session.getAttribute("lrdn").toString());
			session.removeAttribute("lrdn");
		}
		if (client.getStatus().equals("AC")) {
			Gson gson = new Gson();
			JsonObject requestJson = new JsonObject();
			JsonObject jsonRequestData = new JsonObject();
			jsonRequestData.addProperty("mobilePhone", client.getMessage());
			jsonRequestData.addProperty("clientId", client.getTitle());
			jsonRequestData.addProperty("where", request.getParameter("pathName").toString());

			requestJson.add("data", jsonRequestData);
			requestJson.addProperty("requestIp", "192.68.1.1"); // TODO: falta esto modificar

			Map<String, String> headers = new HashMap<String, String>();
			String apiClientUser = "";
			String apiClientPassword = "";
			LoggerApi.Log.info("requestJson.toString() :: " + requestJson.toString());

			String responseGenerateToken = ApiClient.post(getPropertyContextSale("urlGenerateTokenActivate"),
					requestJson.toString(), apiClientUser, apiClientPassword, headers); // TODO: modificar el enlace por
																						// el valor de sale.propertiees
																						// -- urlGenerateTokenActivate
			SecurityTokenResponse securityTokenResponse = gson.fromJson(responseGenerateToken,
					SecurityTokenResponse.class);

			if (securityTokenResponse != null && securityTokenResponse.getToken() != null) {

				String[] lrdn = StringLib.decodeLabel(request.getParameter("lrdn")).split("-");
				String user = StringLib.decodeLabel(lrdn[0]).toLowerCase().trim();
				String password = StringLib.decodeLabel(lrdn[1]);
				session.setAttribute("lrdn",
						StringLib.encodeLabel(StringLib.encodeLabel(user) + "-"
								+ StringLib.encodeLabel(password)));

				String rutaRedirect = getPropertyContextSale("urlPamActivate") + // TODO: modificar con el valor a
																					// urlPamActivate
						"?token=" + securityTokenResponse.getToken() + "&from=tinkaoglogin";
				o.addProperty("redirectActivate", rutaRedirect);
			}
		}else {//nuevo
			session.removeAttribute("typeDoc");
			session.removeAttribute("tipoDocumento");
		} 
	}

	public boolean validateLengthDT(HttpServletRequest request) throws Exception {
		int userLength = 0;
		String[] lrdn=StringLib.decodeLabel(request.getParameter("lrdn")).split("-");
		String user = StringLib.decodeLabel(lrdn[0]).toLowerCase().trim();
		if(user!=null) {
			userLength = user.length();
		} else {
			LoggerApi.Log.info("validateLength user=null");
			return false;
		}
		if(userLength==0 || userLength>35) {
			LoggerApi.Log.info("validateLength userLength="+userLength);
			return false;
		}
		String strippedUser = pe.com.intralot.loto.util.StringLib.stripXSS(user);
		if (!strippedUser.equals(user)) {
			LoggerApi.Log.info("validateLength user="+user+" strippedUser="+strippedUser);
			return false;
		}
		
		int passwordLength = 0;
		String password = StringLib.decodeLabel(lrdn[1]);
		if(password!=null) {
			passwordLength = password.length();
		} else {
			LoggerApi.Log.info("validateLength password=null");
			return false;
		}
		if(passwordLength==0 || passwordLength>70) {
			LoggerApi.Log.info("validateLength passwordLength="+passwordLength);
			return false;
		}
		String strippedPassword = pe.com.intralot.loto.util.StringLib.stripXSS(password);
		if (!strippedPassword.equals(password)) {
			try {
				LoggerApi.Log.info("validateLength password="+StringLib.encodeLabel(password)+" strippedPassword="+StringLib.encodeLabel(strippedPassword));
			} catch (Exception e) {}
			return false;
		}
		
		int docTypeLength = 0;
		String docType = request.getParameter("lg-document-type"); 
		
		if(docType!=null) {
			docTypeLength = docType.length();
		} else {
			LoggerApi.Log.info("validateLength typeDoc=null");
			return false;
		}
		if(docTypeLength==0 || docTypeLength>5) {
			LoggerApi.Log.info("validateLength docTypeLength="+docTypeLength);
			return false;
		}
		String strippedDocType = pe.com.intralot.loto.util.StringLib.stripXSS(docType);
		if (!strippedDocType.equals(docType)) {
			LoggerApi.Log.info("validateLength docType="+docType+" strippedUser="+strippedDocType);
			return false;
		}
		
		int contentLength = request.getContentLength();
		if(contentLength>419) { // la longitud por default para este request es de 214, por ello 319 considera la longitud del usuario y password
			LoggerApi.Log.info("validateLength contentLength="+request.getContentLength());
			return false;
		}
		return true;
	}
	
	@RequestMapping(value = "/tav2-login-dt")
	public void viewTANLoginDT(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData client = null;
		
		try {
			LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
			LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent"));
            
			if(!validateLengthDT(request)) {
				o.addProperty("message", "Dato para ingreso incorrecto. Ingreso denegado.");
	        	outData = callback + "(" + o + ")";
	        	out.print(outData);
				return;
			}
			
			HttpSession session = request.getSession();

			client = securityUtils.obtenerLogin(request, clientSaleBo);
			if(client != null) {
				state = client.getState();
				cid = client.getClientId();

				LoggerApi.Log.info("/tav2-login-dt state=" + state + " cid="+ cid );
//				if(state.equals(1)) {
				if (client.getStatus().equals("OK")) {
					o = securityUtils.validarUsuarioJson(client, 5588, request,clientSaleBo);
					String TAv2Config = "", authToken="", ref="";
					String urlRedirect5587="";
					String operatorId="";
					if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
						session = request.getSession(false);
						if(session==null || !request.isRequestedSessionIdValid()) {
							session = request.getSession();
						}
						
						request.setAttribute("clientSale", client);
						o.addProperty("id", cid);
						o.addProperty("user", client.getCl_nombre());
						
						if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587") && request.getParameter("urlRedirect5587")!=null) {							
							if (!ConnectionFactory.operationProperty("applicationArea", "sale").toString().trim().toLowerCase().equals("production")) {
								urlRedirect5587 = request.getParameter("urlRedirect5587").toString().trim();
							}else {
								urlRedirect5587 = Constants.lapollaGameProviderBaseUrl;
							}
							operatorId="5587";
							authToken = client.getLapollaToken();
						}else {
							operatorId="5588";
							authToken = client.getTav2Token();
						}
						String urlRedirect5588	= request.getParameter("urlRedirect5588");
						ref = "&ref="+request.getParameter("ref");
						TAv2Config = (urlRedirect5588 != null && !urlRedirect5588.equals("")) ? urlRedirect5588 : Constants.tav2GameProviderBaseUrl;			
						
						Integer idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
						Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
					
						if (idSession != null && idClient != null) {
							ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
							session.setAttribute("email", dataClient.getMail());
							session.setAttribute("fullName", dataClient.getNombre());
							session.setAttribute("lastName", dataClient.getApPaterno() + " " + dataClient.getApMaterno());
							session.setAttribute("cid", dataClient.getClientId());
							
							ClientProcedureGetDataClient clientS = new ClientProcedureGetDataClient();
		                	clientS.setClientId(dataClient.getClientId());
		                	clientS.setNombre(dataClient.getNombre());
		                	clientS.setApPaterno(dataClient.getApPaterno());
		                	clientS.setApMaterno(dataClient.getApMaterno());
		                	clientS.setMail(dataClient.getMail());
		                	clientS.setNumberId(dataClient.getNumberId());
		                	clientS.setTypeId(dataClient.getTypeId());
		                	
		                	HttpSession clientSession = request.getSession();
		                	clientSession.setAttribute("CLIENT_SESSION", clientS);
						}
					}	
					
					if(operatorId.equals("5588")) {
						System.out.println("tav2: " + TAv2Config+" | "+authToken+ref);
						o.addProperty("tav2", TAv2Config+" | "+authToken+ref);
					}else {
						System.out.println("tav2: " + urlRedirect5587+" | "+authToken);
						o.addProperty("tav2", urlRedirect5587+" | "+authToken);
					}
					
					// Corrije NullPointer en el session del lightbox de SMS
				    session.setAttribute(Constants.CLT_SESSION, client);
				} else {
					o.addProperty("error", client.getStatus());
	            	o.addProperty("alertLogin", client.getStatus());
	            	o.addProperty("title", client.getTitle());
	            	o.addProperty("message", client.getMessage());
	            	String button=client.getButton();
	            	o.addProperty("button", client.getButton());
	            	if(button.equals("127")) {
	            		o.addProperty("lrdn", session.getAttribute("lrdn").toString());
	            		session.removeAttribute("lrdn");
	            	}
				}
				
				LoggerApi.Log.info("cid=" + cid + " state=" + state );
			} else o.addProperty("message", "Usuario no encontrado [6404]");
			outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [6500]");
			outData = callback + "(" + o + ")";
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			LoggerApi.Log.info("/tav2-login-dt "+o.toString());
		}
	}
	
	@RequestMapping(value = "/get-fast-token")
	public void getFastToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		SecurityTokenResponse responseToken = new SecurityTokenResponse();
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		session.setAttribute("display", request.getParameter("display"));
		try {
			o.addProperty("message", "OK");
			if (pe.com.intralot.loto.util.ConnectionFactory.isDevelopment()) {
				String server = request.getRequestURL().toString();
				server = server.substring(0, server.lastIndexOf('/') + 1 );
				o.addProperty("redirect", getPropertyContextSale("urlPamLogin") + "?operatorId=1&from=tinka&tinkaEnvironment=" + server);
			}else {
				o.addProperty("redirect", getPropertyContextSale("urlPamLogin") + "?operatorId=1&from=tinka");
			}
			String bodyRequest = "{}";
			Map<String,String> headers = new HashMap<String,String>();
			headers.put("X-Ip-Origin", "192.68.1.1");
			headers.put("X-Company", "ECOM");
			//obtiene token
			String tokenResponse = ApiClient.post(getPropertyContextSale("urlSecurityToken"), bodyRequest, "12345678", "12345678", headers);
			o.addProperty("token", "");
			responseToken = gson.fromJson(tokenResponse, SecurityTokenResponse.class);
			LoggerApi.Log.info("tokenResponse="+tokenResponse);
			if (responseToken.getToken() != null && !responseToken.getToken().equals("")) {
				o.addProperty("token", responseToken.getToken());
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("message", "");
			o.addProperty("redirect", "");
		} finally {
			out.print(o);
			LoggerApi.Log.info(o.toString());
		}
	}
	
	// 
	@RequestMapping(value = "/validarTokenLogin")
	public void validarTokenLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		LoginDataResponse loginDataResponse = new LoginDataResponse();
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		try {
			//obtiene token
			String tokenRequest = request.getParameter("token").toString();
			
			if (tokenRequest != null ) {
				Map<String,String> headers = new HashMap<String,String>();
				headers.put("X-Ip-Origin", "192.68.1.1");
				headers.put("X-Company", "ECOM");
				//obtiene token
				String tokenResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+tokenRequest, "12345678", "12345678", headers);
				loginDataResponse = gson.fromJson(tokenResponse, LoginDataResponse.class);
				LoggerApi.Log.info("tokenResponse="+tokenResponse);
				if (loginDataResponse.getError() == null ) {
					o.addProperty("status", "OK");
					o.addProperty("lrdn",session.getAttribute("lrdn").toString());
					session.removeAttribute("lrdn");
				}
			}
		} catch (Exception e) {
			o.addProperty("status", "error");
			LoggerApi.severe(e);
		} finally {
			out.print(o);
			LoggerApi.Log.info(o.toString());
		}
	}
	
	@RequestMapping(value = "/loginportal")
    public ModelAndView loginportal(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	
        try {
            return new ModelAndView("include/login-portal");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("index");
        } finally {
        }
    }
	
	@RequestMapping(value = "/ta-preprod")
    public String viewTANPreprod(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	return "game/teapuesto/tav2_preprod"; 
    }
	
	@RequestMapping(value = "/validate-session")
    public void validateSession(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String log="validateSession";
//    	LoggerApi.Log.info("-------------- START " +log);
		HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject oResponse = new JsonObject();
        ClientUpdateProcedureValidateSession validateSession=null;
    	ClientUpdateProcedureExpiredSession expiredSession=null;
    	JsonParser jparser = null;
    	String closeSession=session.getAttribute("closeSession")!=null?(String)session.getAttribute("closeSession"):"";
        try { 
        	if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
        		// Obtener el tiempo de la última interacción del usuario
                long ultimaInteraccion = session.getLastAccessedTime();
                
                
                // Obtener el tiempo actual
                long tiempoActual = System.currentTimeMillis();
                long lastValidateSession=session.getAttribute("lastValidateSession")!=null?(Long)session.getAttribute("lastValidateSession"):0;
                if(lastValidateSession!=0) {
                	ultimaInteraccion=lastValidateSession;
                }
                session.setAttribute("lastValidateSession",tiempoActual);
                
                // Calcular el tiempo transcurrido desde la última interacción
                long tiempoInactivo = tiempoActual - ultimaInteraccion;
                
                //Obtener tiempo para cierre de session
                int tiempoCierre = 30*60;
                String propTiempoCierre =ConnectionFactory.operationProperty("tiempoCierreSesion", Constants.contextSale); 
                tiempoCierre=!propTiempoCierre.equals("")?Integer.parseInt(propTiempoCierre)*60:tiempoCierre;
                oResponse.addProperty("status","OK");
                oResponse.addProperty("message","Sesion activa");
                if(tiempoInactivo/1000>=tiempoCierre && closeSession.equals("")) { //cierre de sesion si se supera 30 minutos de inactividad
                	//logica para regitrar evento de cierre de sesion
                	expiredSession=null;
    	        	jparser = new JsonParser();
    		        	JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
    		        	Integer clientId=sessionData.get("clientId").getAsInt();
    		        	
    	            	expiredSession = clientBo.expiredSession(clientId);
    	            	//funcion http para cerrar TA
		        		String urlTA=securityUtils.fetchTA(request, response);
		        		oResponse.addProperty("urlTA",urlTA);
//    	            	session.invalidate();
//    		        	LoggerApi.Log.info("expiredSession: estado="+expiredSession.getState()+" mensaje="+expiredSession.getMessage());
//    		        	LoggerApi.Log.info("Cierre de session por inactividad: Tiempo de inactividad: "+(tiempoInactivo/1000));
    		        	session = request.getSession();
    		        	session.setAttribute("closeSession", "closeSession");
    		        	oResponse.addProperty("status","ERROR_EXPIRATION");
    	    			oResponse.addProperty("message","Cierre de sesion por tiempo de incatividad"); 
    	    			
//                }else if(tiempoInactivo/1000>2) { //cierre de sesion: inicio de sesion en otro dispositivo, bloqueo de cuenta 
                }else {
                	//logica para valiar tokensession
                	validateSession=null;
    	        	jparser = new JsonParser();      
    				
    					JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
    		        	String tokenSession=sessionData.get("tokenSession").getAsString();
    		        	Integer clientId=sessionData.get("clientId").getAsInt();
    		        	String mobilePhone=sessionData.get("celular").getAsString();
    		        	String docType=sessionData.get("tipoDocumento").getAsString();
    		        	String docNumber=sessionData.get("numeroDocumento").getAsString();
    					validateSession = clientBo.validateSession(tokenSession, clientId, mobilePhone, docType, docNumber);
    					//si token es diferente cerrar sesion
    		        	if(!validateSession.getState().equals("OK")) {
    		        		if(!validateSession.getState().equals("ERROR_TOKEN")) {
	    		        		//funcion http para cerrar TA
	    		        		String urlTA=securityUtils.fetchTA(request, response);
	    		        		oResponse.addProperty("urlTA",urlTA);
    		        		}    		        		
    		        		session.invalidate();
    		        		oResponse.addProperty("status",validateSession.getState());
        	    			oResponse.addProperty("message",validateSession.getMessage());
//    		        		LoggerApi.Log.info("Cierre de session por validateSession: Tiempo de inactividad: "+(tiempoInactivo/1000));
    		            }
                
                }	        		
	    		
        	}else {
//        		session = request.getSession();
//	        	session.setAttribute("closeSession", "closeSession");
	        	oResponse.addProperty("status","OK");
    			oResponse.addProperty("message","No se encuentran datos de sesion");
        	}
        	out.print(oResponse);
//        	LoggerApi.Log.info("-------------- END " +log+" oResponse:"+oResponse);
		} catch (Exception e) {
			oResponse.addProperty("status", "OK");
			oResponse.addProperty("message","EXCEPTION");
			out.print(oResponse);
			LoggerApi.severe(e);
		}
    }
	
	@RequestMapping(value = "/validate-session2")
    public void validateSession2(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String log="validateSession2";
//    	LoggerApi.Log.info("-------------- START " +log);
		HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject oResponse = new JsonObject();
        try { 
//        	String closeSession=(String)session.getAttribute("closeSession");
        	session.removeAttribute("closeSession");
        	session.invalidate();
        	oResponse.addProperty("status","OK");
			oResponse.addProperty("message","Se elimona atributo de cierre de sesion");        	
        	out.print(oResponse);
		} catch (Exception e) {
			oResponse.addProperty("status", "OK");
			oResponse.addProperty("message","EXCEPTION");
			out.print(oResponse);
			LoggerApi.severe(e);
		}
    }
}