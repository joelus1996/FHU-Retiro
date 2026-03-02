package pe.com.intralot.loto.layer.controller.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pe.com.intralot.loto.layer.dto.agora.PaymentRequest;
import pe.com.intralot.loto.layer.dto.agora.PaymentResponse;
import pe.com.intralot.loto.layer.dto.client.ClientInformationResponseDTO;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenColor;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenDog;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenFutbol;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenGiraGana;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenKinelo;
import pe.com.intralot.loto.layer.dto.pam.LoginDataResponse;
import pe.com.intralot.loto.layer.dto.visa.JsonButtonForm;
import pe.com.intralot.loto.layer.dto.visa.PagoParameters;
import pe.com.intralot.loto.layer.dto.visa.VisanetParameters;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBalanceList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBalanceListFilter;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBonusList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetMontoPorDia;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetMontoPorDiaAgora;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetOtherList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetPromoList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureCodeValidation;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginBcpRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginLotocardRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginVisaRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureSaleLoadPrepaidCard;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateStateRechargeAgora;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateVisaSession;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureValidateNewPhoneAgora;
import pe.com.intralot.loto.layer.model.domain.ClientSecurityWhiteList;
import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5;
import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.domain.GetClientSecurity;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureRegisterErrorCA;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureUpdatePasswordNotification;
import pe.com.intralot.loto.layer.model.domain.PinPrinted;
import pe.com.intralot.loto.layer.model.domain.ProcedureDefineTransactionIzipay;
import pe.com.intralot.loto.layer.model.domain.ProcedurePayTransactionIzipay;
import pe.com.intralot.loto.layer.model.domain.ProcedureYapePlinTupayVerifyTransaction;
import pe.com.intralot.loto.layer.model.domain.ProcedureYapePlinVerifyTransaction;
import pe.com.intralot.loto.layer.model.domain.PromoFirstAccount;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetRetailTeApuestoGrecia;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;
import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketLotos5Bo;
import pe.com.intralot.loto.layer.service.client.bo.CountryBo;
import pe.com.intralot.loto.layer.service.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.service.client.bo.ProvinceBo;
import pe.com.intralot.loto.layer.service.client.bo.RegionBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketRetailBo;
import pe.com.intralot.loto.layer.service.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.service.game.deportesvirtuales.bo.DeportesVirtualesBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.client.model.KeyPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ApiClient;
import pe.com.intralot.loto.util.ApiGoldenUtils;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.EncryptAESBase;
import pe.com.intralot.loto.util.LookupService;
import pe.com.intralot.loto.util.MailLib;
import pe.com.intralot.loto.util.SecurityUtils;
import pe.com.intralot.loto.util.StringLib;
import pe.com.intralot.loto.util.TSLSocketConnectionFactory;
import pe.com.intralot.loto.www.sale.client.lib.WebConsts;

import com.alignet.bean.VPOS20Bean;
import com.alignet.plugin.Send20;
import com.alignet.plugin.exception.InvalidVPOSParameterException;
import com.alignet.plugin.exception.PlugInVPOSException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static pe.com.intralot.loto.util.Constants.getPropertyContextSale;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;


/**
 * <p>
 * NOMBRE: ClientBalanceController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador movimientos de cuenta
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
public class ClientBalanceController {

    @Autowired
    private BalanceSaleBo balanceSaleBo;
    // @Autowired
    // private ClientBalanceBo ClientBalanceBalanceBo;
    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private ClientSaleBo clientSaleBo; 
    @Autowired
    private ClientBo clientBo;
    @Autowired 
    private CountryBo countryBo;
    @Autowired
    private RegionBo regionBo;
    @Autowired
    private ProvinceBo provinceBo;
    @Autowired
    private ClientTicketLotos5Bo clientTicketLotos5Bo;
    @Autowired
	private SecurityUtils securityUtils;
    @Autowired
	private PaymentPrizeBo paymentPrizeBo;
    //@Autowired
    //private CulqiBo culqiBo;
    
    @Autowired
    private DeportesVirtualesBo deportesVirtualesBo;
    
    @Autowired
    ApiGoldenUtils  apiGoldenUtils = new ApiGoldenUtils(deportesVirtualesBo);
    
    
    @Autowired
    private TicketRetailBo ticketRetailBo;
    
    private final Gson gson = new Gson();
    
    @PostConstruct
    public void init() {
        Security.addProvider(new BouncyCastleProvider());
    }
    
    @RequestMapping(value = "/recarga-epago")
    public String recarga_epago(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "client/recarga_epago";
    }

    @RequestMapping(value = "/validacion-datos")
    public String validacion_datos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "client/validacion_datos";
    }

    @RequestMapping(value = "/bienvenido")
    public String formActivar(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {
		HttpSession session = request.getSession();
		String context = Constants.contextWelcome;
        try {
        	/*
	        String imgBannerWelcomeTinka1 = ConnectionFactory.operationProperty("bannerWelcomeTinka1", context);
	        String linkBannerWelcomeTinka1 = ConnectionFactory.operationProperty("linkBannerWelcomeTinka1", context);
	        String imgBannerWelcomeTinka2 = ConnectionFactory.operationProperty("bannerWelcomeTinka2", context);
	        String linkBannerWelcomeTinka2 = ConnectionFactory.operationProperty("linkBannerWelcomeTinka2", context);
	        String imgBannerWelcomeTinka3 = ConnectionFactory.operationProperty("bannerWelcomeTinka3", context);
	        String linkBannerWelcomeTinka3 = ConnectionFactory.operationProperty("linkBannerWelcomeTinka3", context);
	
	        modelList.addAttribute("imgBannerWelcomeTinka1", imgBannerWelcomeTinka1);
	        modelList.addAttribute("linkBannerWelcomeTinka1", linkBannerWelcomeTinka1);
	        modelList.addAttribute("imgBannerWelcomeTinka2", imgBannerWelcomeTinka2);
	        modelList.addAttribute("linkBannerWelcomeTinka2", linkBannerWelcomeTinka2);
	        modelList.addAttribute("imgBannerWelcomeTinka3", imgBannerWelcomeTinka3);
	        modelList.addAttribute("linkBannerWelcomeTinka3", linkBannerWelcomeTinka3);
	        */
	        
	        if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
	            return "client/home_welcome";
	        } else {
	            return "redirect:/inicio.html";
	        }
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	        return "redirect:/inicio.html";
	    }
    }
    
    @RequestMapping(value = "/mi-cuenta")
    public String main_user(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        String origen  = request.getParameter("origen");
        request.setAttribute("origenLink", origen);
        //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        int bpayCount = 0;
        int bpayMode = 0;
        double bpayAmount = 0;
        double bpayExchange = 0;
        String bpayDate = "";
        String idcommerce = "";
        String result = "";
        ClientProcedureAccountData clientProcedureAccountData=null;
        JsonObject joDataClient=null, joDataClientResponse=null;
        
        try {
        	//Parametro para cerrar sesion de TeApuesto en otro dispositivo
        	String openSession=(String)session.getAttribute("openSession");
    		if(openSession!=null) {
    			request.setAttribute("openSession", openSession);
    			session.removeAttribute("openSession");
    		}
    		
            ClientProcedureGetDataClient dataClient = null;
            UserBean userBeanFirst = (UserBean) session.getAttribute(Constants.USR_SESION);
            
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
            	//LoggerApi.Log.info("getpSessionid "+ userBeanFirst.getpSessionid());
                //LoggerApi.Log.info("getpClientid "+ userBeanFirst.getpClientid());
                LoggerApi.Log.info("getpUser "+ userBeanFirst.getpUser());
                idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                user = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser();
                if (idSession != null && idClient != null) {

	                JsonObject jdata = new JsonObject();
	        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
		    		jdata.addProperty("token", tokenPlayerWebApi);
		    		jdata.addProperty("tipoDocumento", "");
		    		jdata.addProperty("numeroDocumento", "");
		    		jdata.addProperty("clientId", String.valueOf(idClient));
		    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
		    		jdata.addProperty("operatorId", Constants.OPERATOR_ID);
		    		jdata.addProperty("platform", Constants.PLATAFORM);
			    	JsonParser jsonParser = new JsonParser();
	                joDataClientResponse = jsonParser.parse(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData")).getAsJsonObject();
                    dataClient=JsonConvertClient(joDataClientResponse);
                }
                if (dataClient!=null) {
                	Client client = clientBo.findByIdClient(idClient);
                	//LoggerApi.Log.info("mobilePhoneUpdate ==> "+ client.getMobilePhoneUpdate());
                	joDataClient = ClientConvertJson(dataClient);
                    joDataClient.addProperty("mailUpdate", client.getMailUpdate());
                    joDataClient.addProperty("mobileUpdate", client.getMobileUpdate());
                    // ATACO - CONSULTA DATA COMPLETA
//                    if(joDataClientResponse.has("camposVacios")) {
//                    	session.setAttribute("isDataComplete", 0);
//                    }else {
//                    	session.setAttribute("isNotPerPolExp", dataClient.getPpe());
//                    }
                    if(dataClient.getNombre() == null || dataClient.getApPaterno() == null || 
                       dataClient.getTypeId() == null || dataClient.getNumberId() == null  || dataClient.getBirthDate() == null ||
                       dataClient.getUser() == null	|| dataClient.getMail() == null 	   || dataClient.getMobilePhone() == null ||
      				   dataClient.getPpe()==null) {
                    	session.setAttribute("isDataComplete", 0);
                    }                   
                    else {
                    	session.setAttribute("isPerPolExp", dataClient.getPpe());
                    }
                    // fin ATACO - CONSULTA DATA COMPLETA
                    request.setAttribute("messagePromo", session.getAttribute("messagePromo"));
                    session.removeAttribute("messagePromo");
                }
                request.setAttribute("DataClient", joDataClient);
                objectModelMap.put("regions", regionBo.findRegion());
                clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
                //ruth
                String estiloTA="";
                if(clientProcedureAccountData.getPromo()==null && clientProcedureAccountData.getPromoMessage()==null) {
                	 estiloTA="display: none;";
                }
                else {
                	 estiloTA="display: block;";
                }
                request.setAttribute("estiloTA", estiloTA);
                //ruth
                clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
                result = new Gson().toJson(clientProcedureAccountData);
                request.setAttribute("clientBalance", result);//clientProcedureAccountData);
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                //objectModelMap.put("customerCards", new Gson().toJson(culqiBo.listCustomerCard(idClient)));
                request.setAttribute("bpayCount", bpayCount);
                request.setAttribute("bpayMode", bpayMode);
                request.setAttribute("bpayAmount", bpayAmount);
                request.setAttribute("bpayExchange", bpayExchange);
                request.setAttribute("bpayDate", bpayDate);
                /*joDataClient = new JsonObject();
                joDataClient.addProperty("culqiMaxAmount", (ConnectionFactory.operationProperty("culqiMaxAmount", context) != null)?ConnectionFactory.operationProperty("culqiMaxAmount", context).trim():"");
                joDataClient.addProperty("culqiMinAmount", (ConnectionFactory.operationProperty("culqiMinAmount", context) != null)?ConnectionFactory.operationProperty("culqiMinAmount", context).trim():"");
                joDataClient.addProperty("culqiPublicKey", (ConnectionFactory.operationProperty("culqiPublicKey", context) != null)?ConnectionFactory.operationProperty("culqiPublicKey", context).trim():"");
                request.setAttribute("culqiData", joDataClient);*/
                JsonObject joDataClient2 = new JsonObject();
				joDataClient2.addProperty("bcpMaxAmount", (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim():"10000");
                joDataClient2.addProperty("bcpMinAmount", (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim():"30");
                joDataClient2.addProperty("pefeMaxAmount", (ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim():"3000");
                joDataClient2.addProperty("pefeMinAmount", (ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim():"40");
                joDataClient2.addProperty("sfpyMaxAmount", (ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim():"3000");
                joDataClient2.addProperty("sfpyMinAmount", (ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim():"40");
                request.setAttribute("chargeData", joDataClient2);
                /** BizPay **/
                idcommerce = String.valueOf(ConnectionFactory.operationProperty("idcommerce", context)).toString().trim();
                boolean isBizPay = Boolean.valueOf(ConnectionFactory.operationProperty("bizpayEnabled", context).trim()).booleanValue();
                if (isBizPay) {
                    Object[] outObj1 = SalesDispatcher.getCountBizPayTransaction(idSession.toString(), idcommerce);
                    if (outObj1[0] != null)
                        bpayCount = Integer.parseInt(outObj1[0].toString());
                    if (outObj1[1] != null)
                        bpayMode = Integer.parseInt(outObj1[1].toString());
                    Object[] outObj2 = SalesDispatcher.getLastBizPayTransactionError(idClient.toString(), idcommerce);
                    if (outObj2[0] != null)
                        bpayAmount = Double.parseDouble(outObj2[0].toString());
                    if (outObj2[1] != null)
                        bpayExchange = Double.parseDouble(outObj2[1].toString());
                    if (outObj2[2] != null)
                        bpayDate = outObj2[2].toString();
                }
                request.setAttribute("dataClient", dataClient);
            }
            UserBean userBean = new UserBean();
            
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null)
            {
            	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
	            LoggerApi.Log.info("getpSessionid "+ userBean.getpSessionid());
	            LoggerApi.Log.info("getpClientid "+ userBean.getpClientid());
	            LoggerApi.Log.info("getpUser "+ userBean.getpUser());
            }
                
            userBean.setpGame(0);
            if (clientProcedureAccountData!=null && clientProcedureAccountData.getBalanceAmount()!=null) {
                userBean.setpMonto(clientProcedureAccountData.getBalanceAmount());
            }
            session.setAttribute(Constants.USR_SESION, userBean);
            
            if(request.getParameter("operatorId")!=null) session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            request.setAttribute("OperatorId", request.getParameter("operatorId"));
            if(request.getParameter("redirectGame")!=null) session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
            /*if(request.getParameter("urlRedirect5587")!=null) session.setAttribute("urlRedirect5587", String.valueOf(request.getParameter("urlRedirect5587")).toString().trim());
            if(request.getParameter("urlRedirect5588")!=null) session.setAttribute("urlRedirect5588", String.valueOf(request.getParameter("urlRedirect5588")).toString().trim());*/
            LoggerApi.Log.info("cid=" + idClient + " userBean=" + userBean);

            if(session.getAttribute("visanetTransaction")!=null) {
            	request.setAttribute("visanetTransaction", session.getAttribute("visanetTransaction"));
            }
            
            if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null) {
                if (dataClient.getUser() == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                } else {
                	boolean hiddenUser = false;
                	String datePlayerWebApi = ConnectionFactory.operationProperty("datePlayerWebApi", Constants.contextSale);
                	if(datePlayerWebApi==null || datePlayerWebApi.equals("")) {
                		datePlayerWebApi="2023-07-14 00:00:00";
                	}
                	Timestamp playerWebStart = Timestamp.valueOf(datePlayerWebApi);
                	String sInsertDate= dataClient.getInsertDate();
                	Timestamp insertDate = Timestamp.valueOf(sInsertDate);
                	if(playerWebStart.before(insertDate)) {
                		hiddenUser = true;
                		joDataClient.addProperty("user", "");
                		request.setAttribute("DataClient", joDataClient);
                	}             	
                	objectModelMap.put("hiddenUser",hiddenUser);
                	
                	boolean hiddenPpe = false;
                	String datePerPolExp = ConnectionFactory.operationProperty("datePerPolExp", Constants.contextSale);
                	if(datePerPolExp==null || datePerPolExp.equals("")) {
                		datePlayerWebApi="2024-01-12 00:00:00";
                	}
                	Timestamp ppeStart = Timestamp.valueOf(datePerPolExp);
                	if(ppeStart.before(insertDate)) {
                		hiddenPpe = true;
                	}             	
                	objectModelMap.put("hiddenPpe",hiddenPpe);
                    return "client/home_user";
                }
            } else
                return "redirect:/inicio.html";
        } catch (Exception e) {
        	LoggerApi.Log.info("getpSessionid null");
            LoggerApi.Log.info("getpClientid null");
            LoggerApi.Log.info("getpUser null");
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "redirect:/inicio.html";
        } finally {
            request.setAttribute("isAllowed", clientSaleBo.isAllowedGoIn(user));
        }
    }

    @RequestMapping(value = "/clientBalance_findPrizesList")
    public void findPrizesList(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String resultClient = "";
        try {
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                List<TicketProcedureGetPrizesList> ticketPrizesList = null;
                if (userBean.getpClientid() != null)
                    ticketPrizesList = ticketSaleBo.findPrizesList(userBean.getpClientid());
                if (ticketPrizesList != null)
                    for (TicketProcedureGetPrizesList ticketPrizes : ticketPrizesList) {
                        resultClient += ticketPrizes.getGameName() + "|";
                        resultClient += ticketPrizes.getSaleDate() + "|";
                        resultClient += ticketPrizes.getPrize() + "|";
                        resultClient += ticketPrizes.getMorePrizes() + "|";
                        resultClient += ticketPrizes.getExpirationDate() + "|";
                        resultClient += ticketPrizes.getTicketId() + "|";
                        resultClient += ticketPrizes.getPrintPay() + "|";
                        resultClient += ticketPrizes.getGameId() + "|";
                        resultClient += ticketPrizes.getPrizesSet() + "|";
                        resultClient += ticketPrizes.getStatus() + "|";
                        resultClient += ticketPrizes.getPrintCompare() + "|";
                        resultClient += ticketPrizes.getParameterId() + "#";
                    }
            }
            if (!resultClient.equals(""))
                resultClient = resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/clientBalance_TicketsListFilter")
    public void findTicketsListFilter(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	
    	LoggerApi.Log.info("--------------- START - clientBalance_TicketsListFilter");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String resultClient = "";
        String temp_moreBets = "";
        
        String iflexGameProviderBaseUrl = ConnectionFactory.operationProperty("iflexGameProviderBaseUrl", Constants.contextSale).trim();
        
        try {
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                String startdate = request.getParameter("startdate");
        		String enddate = request.getParameter("enddate");
                if (userBean.getpClientid() != null) {
                	
                	if(startdate != null && enddate != null) { 
            			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            			Calendar calendarioinicio = Calendar.getInstance();
            			calendarioinicio.setTime(sdf.parse(startdate));
            			
            			Calendar calendariofin = Calendar.getInstance();
            			calendariofin.setTime(sdf.parse(enddate));
            			
            			Date timeinicio = calendarioinicio.getTime();
            			Date timefin = calendariofin.getTime();
            			long day = TimeUnit.MILLISECONDS.toDays(Math.abs(timefin.getTime()-timeinicio.getTime()));
            			
            			if(timefin.before(timeinicio)) {
            				resultClient = "La fecha de finalización debe ser posterior a la fecha de inicio.";
            				LoggerApi.Log.info("Las fechas incorrectas = " +  resultClient);
    						out.print(resultClient);
    						return;
            			}
            			
            			if(day > 29)  {      	
    						resultClient = "El rango de fecha de búsqueda no puede superar los 30 días ";
    						LoggerApi.Log.info("fechas diferente de 30 = " +  resultClient);
    						out.print(resultClient);
    						return;
            			} 
            		}
                    
                    List<TicketProcedureGetTicketsFilterList> tiketsListAll = ticketSaleBo.findTicketsListFilterAll(userBean.getpClientid(), startdate, enddate);
                    
                    // Ordenar la lista por SaleDate desc
                    Collections.sort(tiketsListAll, new Comparator<TicketProcedureGetTicketsFilterList>() {
                        public int compare(TicketProcedureGetTicketsFilterList t1, TicketProcedureGetTicketsFilterList t2) {
                            return t2.getTicketDate().compareTo(t1.getTicketDate()); 
                        }
                    });
                    
                	if(tiketsListAll!= null && !tiketsListAll.isEmpty()) {
                    	for (TicketProcedureGetTicketsFilterList ticket : tiketsListAll) {
                            resultClient += ticket.getGameName() + "$";
                            resultClient += ticket.getSaleDate() + "$";
                            resultClient += ticket.getBet() + "$";
                            temp_moreBets = ticket.getMoreBets() + "";
                            temp_moreBets = temp_moreBets.replace("|", "<br>");
                            resultClient += temp_moreBets + "$";
                            resultClient += ticket.getTicketId() + "$";
                            resultClient += ticket.getStatus() + "$";
                            resultClient += ticket.getGameId() + "$";
                            resultClient += ticket.getParameterId() + "$"; // AQUI VIENE EL couponId={couponid}
                            resultClient += ticket.getWithTicket() + "$"; // AQUI VIENE "URL"
                            resultClient += ticket.getWithDraw() + "$";  // AQUI VIENE EL authToken={Token}
                            resultClient += userBean.getpClientid() + "$"; // AQUI VIENE EL playerId={id}
                            resultClient += iflexGameProviderBaseUrl + "$";
                            resultClient += ticket.getMoreStatus() + "$"; // AQUI VIENE "Expirado el dd/mm/yyyy"
                            resultClient += ticket.getSales_channel() + "$"; // CANAL DE VENTA [13]
                            resultClient += ticket.getPid_ticket() + "$"; //[14]
                            resultClient += ticket.getCoupon_id() + "$"; // cpn
                            resultClient += ticket.getPrograma() + "$"; // [16]
                            resultClient += ticket.getOpenGrecia() + "$"; // [17] mostrar el visor 
                            resultClient += ticket.getCvTicketd() + "$"; //[18]
                            resultClient += ticket.getIdOperacion() +  "#"; //[19]
                          
                        }
                    }else {
                    	LoggerApi.Log.info("Si no tienes jugadas");
                    	resultClient = "No tienes jugadas";
                    	out.print(resultClient);
						return;
                    }
                	
                }
            }
            if (!resultClient.equals(""))
                resultClient = resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	LoggerApi.Log.info("--------------- END - clientBalance_TicketsListFilter");
        }
    }
    
    @RequestMapping(value = "/clientBalance_TicketsList")
    public void findTicketsList(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("--------------- START - clientBalance_TicketsList");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String resultClient = "";
        String temp_moreBets = "";
        
        String iflexGameProviderBaseUrl = ConnectionFactory.operationProperty("iflexGameProviderBaseUrl", Constants.contextSale).trim();
        
        try {
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                if (userBean.getpClientid() != null) {
                    //Obtener jugadas web + retail               
                    List<TicketProcedureGetTicketsList> tiketsListAll = ticketSaleBo.findTicketsListAll(userBean.getpClientid());
                
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    
                    // Ordenar la lista por SaleDate desc
                    Collections.sort(tiketsListAll, new Comparator<TicketProcedureGetTicketsList>() {
                        public int compare(TicketProcedureGetTicketsList t1, TicketProcedureGetTicketsList t2) {
                            return t2.getTicketDate().compareTo(t1.getTicketDate()); 
                        }
                    });
                    
                    if(tiketsListAll!= null && tiketsListAll.size()>0) {
                    	 for (TicketProcedureGetTicketsList ticket : tiketsListAll) {
                             resultClient += ticket.getGameName() + "$";
                             resultClient += ticket.getSaleDate() + "$";
                             resultClient += ticket.getBet() + "$";
                             temp_moreBets = ticket.getMoreBets() + "";
                             temp_moreBets = temp_moreBets.replace("|", "<br>");
                             resultClient += temp_moreBets + "$";
                             resultClient += ticket.getTicketId() + "$";
                             resultClient += ticket.getStatus() + "$";
                             resultClient += ticket.getGameId() + "$";
                             resultClient += ticket.getParameterId() + "$"; // AQUI VIENE EL couponId={couponid}
                             resultClient += ticket.getWithTicket() + "$"; // AQUI VIENE "URL"
                             resultClient += ticket.getWithDraw() + "$";  // AQUI VIENE EL authToken={Token}
                             resultClient += userBean.getpClientid() + "$"; // AQUI VIENE EL playerId={id}
                             resultClient += iflexGameProviderBaseUrl + "$";
                             resultClient += ticket.getMoreStatus() + "$"; // AQUI VIENE "Expirado el dd/mm/yyyy"
                             resultClient += ticket.getSales_channel() + "$"; // CANAL DE VENTA
                             resultClient += ticket.getPid_ticket() + "$";
                             resultClient += ticket.getCoupon_id() + "$"; //[15]
                             resultClient += ticket.getPrograma() + "$"; // [16]
                             resultClient += ticket.getOpenGrecia() + "$"; // [17] mostrar el visor
                             resultClient += ticket.getCvTicketd() + "$"; //[18]
                             resultClient += ticket.getIdOperacion() +  "#"; //[19]
                             
                         }
                    }else {
                    	resultClient = "No tienes jugadas";
                    	out.print(resultClient);
						return;
                    }
                   
                }
            }
            if (!resultClient.equals(""))
                resultClient = resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	LoggerApi.Log.info("--------------- END - clientBalance_TicketsList");
        }
    }


    @RequestMapping(value = "/clientBalance_find_idClient")
    public void findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        LoggerApi.Log.info("--------------START clientBalance_find_idClient");
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String resultClient = "";
            int i = 0;
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
               
                List<BalanceProcedureGetBalanceList> balanceList = balanceSaleBo.findBalanceList(userBean.getpClientid());
                ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(userBean.getpClientid());
                if(balanceList!=null && balanceList.size()>0) {
	                userBean.setpMonto(balanceList.get(0).getNewAmount());
	                session.setAttribute(Constants.USR_SESION, userBean);
	                
	                Double montoPrevio = 0.0;
	                Double nuevoMonto = 0.0;

	                montoPrevio = balanceList.get(0).getPrevAmount();
	                resultClient += i++ + "|";
                    resultClient += balanceList.get(0).getDescription() + "|";
                    resultClient += balanceList.get(0).getBalanceDate() + "|";
                    resultClient += balanceList.get(0).getPrevAmount() + "|";
                    resultClient += balanceList.get(0).getLoadAmount() + "|";
                    resultClient += (balanceList.get(0).getNewAmount()+balanceList.get(0).getCommissionRecharge()+balanceList.get(0).getCommissionRequest()) + "|";
                    resultClient += balanceList.get(0).getNeoprizeAmount() + "|";
                    resultClient += (ClientUtils.formatAmountBalance(balanceList.get(0).getKironprizeAmount()+balanceList.get(0).getNeoprizeAmount())) + "|";
                    resultClient += clientProcedureAccountDataPart.getBalanceAmount() + "|";
                    resultClient += ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))) + "|";
                    resultClient += clientProcedureAccountDataPart.getOtherAmount() + "|";
                    resultClient += (balanceList.get(0).getCommissionRecharge()!=0?balanceList.get(0).getCommissionRecharge():"-") + "|";
                    resultClient += (balanceList.get(0).getCommissionRequest()!=0?balanceList.get(0).getCommissionRequest():"-") + "#";
                    //resultClient += balanceList.get(0).getSales_channel() + "#"; // canal de venta
                    if(balanceList.size()>0) {
                    	for (int j = 1; j < balanceList.size(); j++) {
                    		nuevoMonto = balanceList.get(j).getNewAmount();
                    		Double montoPrevioTemp = 0.0;
                    		Double commissionRecharge = 0.0;
                    		Double commissionRequest = 0.0;
                    		if(montoPrevio.doubleValue()==nuevoMonto.doubleValue() && (balanceList.get(j).getCommissionRecharge()>0 || balanceList.get(j).getCommissionRequest()>0)) {
                    			if(balanceList.get(j).getCommissionRecharge()<0) {
                    				commissionRecharge=balanceList.get(j).getCommissionRecharge()*-1;
                    			}else {
                    				commissionRecharge=balanceList.get(j).getCommissionRecharge();
                    			}
                    			
                    			if(balanceList.get(j).getCommissionRequest()<0) {
                    				commissionRequest=balanceList.get(j).getCommissionRequest()*-1;
                    			}else {
                    				commissionRequest=balanceList.get(j).getCommissionRequest();
                    			}
                    			
                    			montoPrevioTemp=balanceList.get(j).getPrevAmount()-commissionRecharge-commissionRequest;
                    			//nuevoMonto=balanceList.get(j).getNewAmount();
                    		}else {
                    			montoPrevioTemp=balanceList.get(j).getPrevAmount();
                    			nuevoMonto=balanceList.get(j).getNewAmount()+balanceList.get(j).getCommissionRecharge()+balanceList.get(j).getCommissionRequest();
                    		}
                    		montoPrevio = balanceList.get(j).getPrevAmount();
                    		
    		                resultClient += i++ + "|";
    	                    resultClient += balanceList.get(j).getDescription() + "|";
    	                    resultClient += balanceList.get(j).getBalanceDate() + "|";
    	                    resultClient += montoPrevioTemp + "|";
    	                    resultClient += balanceList.get(j).getLoadAmount() + "|";
    	                    resultClient += nuevoMonto + "|";
    	                    resultClient += balanceList.get(j).getNeoprizeAmount() + "|";
    	                    resultClient += (ClientUtils.formatAmountBalance(balanceList.get(j).getKironprizeAmount()+balanceList.get(j).getNeoprizeAmount())) + "|";
    	                    resultClient += clientProcedureAccountDataPart.getBalanceAmount() + "|";
    	                    resultClient += ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))) + "|";
    	                    resultClient += clientProcedureAccountDataPart.getOtherAmount() + "|";
    	                    resultClient += (balanceList.get(j).getCommissionRecharge()!=0?balanceList.get(j).getCommissionRecharge():"-") + "|";
    	                    resultClient += (balanceList.get(j).getCommissionRequest()!=0?balanceList.get(j).getCommissionRequest():"-") + "#";
    	                    //resultClient += balanceList.get(0).getSales_channel() + "#"; // canal de venta
    					}
                    }else {
                		resultClient = "No tienes movimientos ";
                    }
                }else {
					resultClient = "No tienes movimientos ";
                }
            }
            if (!resultClient.equals(""))
                resultClient = resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } 
        LoggerApi.Log.info("--------------END clientBalance_find_idClient");
    }
    
    @RequestMapping(value = "/clientBalance_filter")
    public void findFilterByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
		LoggerApi.Log.info("--------------START clientBalance_filter");
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String resultClient = "";
            int i = 0;
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                String startdate = request.getParameter("startdate");
        		String enddate = request.getParameter("enddate");
        		LoggerApi.Log.info( "startdate " + startdate + " / enddate " +  enddate );
        		if(startdate != null && enddate != null) {
        			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        			
        			Calendar calendarioinicio = Calendar.getInstance();
        			calendarioinicio.setTime(sdf.parse(startdate));
        			
        			Calendar calendariofin = Calendar.getInstance();
        			calendariofin.setTime(sdf.parse(enddate));
        			
        			Date timeinicio = calendarioinicio.getTime();
        			Date timefin = calendariofin.getTime();
        			long day = TimeUnit.MILLISECONDS.toDays(Math.abs(timefin.getTime()-timeinicio.getTime()));
        			
        			if(timefin.before(timeinicio)) {
        				resultClient = "La fecha de finalización debe ser posterior a la fecha de inicio.";
						out.print(resultClient);
						return;
        			}
        			
        			if(day > 29)  {      	
						resultClient = "El rango de fecha de búsqueda no puede superar los 30 días ";
						out.print(resultClient);
						return;
        			} 
        			
        		}
        		ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(userBean.getpClientid());
                  
                if(startdate != null &&  enddate != null) {
                	resultClient = "";
                	  List<BalanceProcedureGetBalanceListFilter> balanceListFilter = balanceSaleBo.findBalanceListFilter(userBean.getpClientid(), startdate, enddate);
                	 if(balanceListFilter!=null && !balanceListFilter.isEmpty()) {
                		 resultClient = transformeBalanceListFilter(resultClient, balanceListFilter, userBean, session, clientProcedureAccountDataPart, i);	                
                     }else {
                     	resultClient = "No tienes movimientos ";
                     }
                }
                

            }
            if (!resultClient.equals(""))
                resultClient = resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } 
    }
    
    @RequestMapping(value = "/bonusBalance_find_idClient")
    public void findBonusByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        ClientProcedureAccountData clientProcedureAccountData=null;
        String result = "";
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String resultClient = "";
            int i = 0;
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                clientProcedureAccountData = clientSaleBo.findAccountData(userBean.getpClientid());
                if(clientProcedureAccountData.getBonusAmount().trim().equals("")) clientProcedureAccountData.setBonusAmount("0.00");
                clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
                result = new Gson().toJson(clientProcedureAccountData);
                //request.setAttribute("clientBalance", result);
                List<BalanceProcedureGetBonusList> balanceList = balanceSaleBo.findBonusList(userBean.getpClientid());
                for (BalanceProcedureGetBonusList balance : balanceList) {
                    resultClient += i++ + "|";
                    resultClient += balance.getDescription() + "|";
                    resultClient += balance.getBalanceDate() + "|";
                    resultClient += balance.getPrevAmount() + "|";
                    resultClient += balance.getLoadAmount() + "|";
                    resultClient += balance.getNewAmount() + "|";
                    resultClient += balance.getRolloverTimes() + "|";
                    resultClient += balance.getRolloverValidates() + "|";
                    resultClient += balance.getRolloverStatus() + "|";
                    resultClient += balance.getPrizeStatus() + "¬";
                }
            }
            if (!resultClient.equals(""))
            	resultClient = resultClient+result;//resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }

    @RequestMapping(value = "/otherBalance_find_idClient")
    public void findOtherByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        ClientProcedureAccountData clientProcedureAccountData=null;
        String result = "", resultClient = "";
        try {
            PrintWriter out = null;
            out = response.getWriter();
            int i = 0;
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                clientProcedureAccountData = clientSaleBo.findAccountData(userBean.getpClientid());
                if(clientProcedureAccountData.getBonusAmount().trim().equals("")) clientProcedureAccountData.setBonusAmount("0.00");
                clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
                result = new Gson().toJson(clientProcedureAccountData);
                //request.setAttribute("clientBalance", result);
                //int gameId = 41;
                List<BalanceProcedureGetOtherList> balanceList = balanceSaleBo.findOtherList(userBean.getpClientid());
                for (BalanceProcedureGetOtherList balance : balanceList) {
                	resultClient += i++ + "|";
                	resultClient += balance.getDescription() + "|";
                    //resultClient += (balance.getTicketId()!=null)?balance.getTicketId():"" + "|";
                    resultClient += balance.getBalanceDate() + "|";
                    resultClient += balance.getPrevAmount() + "|";
                    resultClient += balance.getLoadAmount() + "|";
                    if(balance.getGameId().intValue() == 30 || balance.getGameId().intValue() == 31 || balance.getGameId().intValue() == 29)
                    	resultClient += balance.getNewAmount() + "@" + balance.getNewAmountMoney() + "|";
                    else
                    	resultClient += balance.getNewAmount() + "|";
                    resultClient += balance.getGameId()+ "|";
                    resultClient += balance.getBalanceDateFormat() + "¬";
                    /*resultClient += balance.getRolloverTimes() + "|";
                    resultClient += balance.getRolloverValidates() + "|";
                    resultClient += balance.getRolloverStatus() + "|";
                    resultClient += balance.getPrizeStatus() + "#";*/
                }
            }
            if (!resultClient.equals(""))
            	resultClient = resultClient+result;//resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	LoggerApi.Log.info(resultClient.toString());
        }
    }
    
    @RequestMapping(value = "/promoBalance_find_idClient")
    public void findPromoByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        ClientProcedureAccountData clientProcedureAccountData=null;
        String result = "", resultClient = "";
    	LoggerApi.Log.info("/promoBalance_find_idClient START");
        try {
            PrintWriter out = null;
            out = response.getWriter();
            int i = 0;
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                clientProcedureAccountData = clientSaleBo.findAccountData(userBean.getpClientid());
                if(clientProcedureAccountData.getBonusAmount().trim().equals("")) clientProcedureAccountData.setBonusAmount("0.00");
                clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
                result = new Gson().toJson(clientProcedureAccountData);
                request.setAttribute("clientBalance", result);
                //int gameId = 41;
                List<BalanceProcedureGetPromoList> balanceList = balanceSaleBo.findPromoList(userBean.getpClientid());
                for (BalanceProcedureGetPromoList balance : balanceList) {
                	resultClient += i++ + "|";
                	resultClient += balance.getDescription() + "|";
                    resultClient += balance.getPromCount() + "|";
                    resultClient += balance.getState() + "|";
                    resultClient += balance.getPromDate() + "|";
                    resultClient += balance.getStatus() + "#";
                }
            }
            if (!resultClient.equals(""))
            	resultClient = resultClient+result;//resultClient.substring(0, resultClient.length() - 1);
            out.print(resultClient);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	LoggerApi.Log.info("/promoBalance_find_idClient END "+resultClient.toString());
        }
    }
    
    @RequestMapping(value = "/recarga_lotocard")
    public void loadBalanceLotocard(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        UserBean userBean = new UserBean();
        if (session.getAttribute(Constants.USR_SESION) != null)
            userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        ClientProcedureSaleLoadPrepaidCard clientProcedureSaleLoadPrepaidCard = new ClientProcedureSaleLoadPrepaidCard();
        PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        ClientProcedureAccountData accountData = new ClientProcedureAccountData();
        try {
            int cid = 0;
            String pin = "", bono = "", wbbono = "";
            String company = "WEBCO";
            String carrier = null;
            String phone = null;
            String message = "";
            double amount = 0;
            double newAmount = 0;
            String ip = "";
            String clientId = "";
            String promotionEco = "";
            String promotionMessage = "";
            String result = "", gameAmount = "", gameName = "";
            int balanceItem=0;
            if (session.getAttribute(Constants.USR_SESION) != null) {
                clientId = String.valueOf(((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid());
                int option = -1;
                if (request.getParameter("option-card") != null)
                    if (!request.getParameter("option-card").equals("null"))
                        option = Integer.parseInt(request.getParameter("option-card"));
                LoggerApi.Log.info("cid=" + clientId + " Option=" + option + " ClientId=" + clientId);
                if (option == 0)
                    message = "OK";
                else if (option == 1) {
                    if (clientId != null)
                        clientId = clientId.trim();
                    if (!clientId.equals(""))
                        cid = Integer.parseInt(clientId);
                    pin = request.getParameter("pin-number");
                    bono = request.getParameter("activ-bono");
                    wbbono = request.getParameter("activ-wbbono");
                    
                    /*String bonoBienvenida = ClientUtils.verifiedWelcomeBonus(session);

                    if (StringUtils.isNotEmpty(bonoBienvenida)) {
                     ip=bonoBienvenida+"|"+request.getRemoteAddr();
                    } else {
                     ip = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":"")+request.getRemoteAddr();
                    }*/
                    ip = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA|":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]+"|":"")))+request.getRemoteAddr();
                    
                    LoggerApi.Log.info("/recarga_lotocard: activ-bono="+bono+" activ-wbbono="+wbbono+" ip="+ip+" redirectGame="+session.getAttribute("redirectGame"));
                    
                    clientProcedureSaleLoadPrepaidCard = clientSaleBo.findSaleLoadPrepaidCard(cid, company, carrier, phone, ip, pin);
                    if (clientProcedureSaleLoadPrepaidCard != null) {
                        message = clientProcedureSaleLoadPrepaidCard.getMessage();
                        amount = clientProcedureSaleLoadPrepaidCard.getAmountLoaded();
                        balanceItem= clientProcedureSaleLoadPrepaidCard.getBalanceItem();
                        if (message.equals("OK")) {
                            if (clientProcedureSaleLoadPrepaidCard.getNewAmount() != null)
                                newAmount = clientProcedureSaleLoadPrepaidCard.getNewAmount();
                            userBean.setpMonto(newAmount);
                            PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(clientProcedureSaleLoadPrepaidCard.getClientId(),
                                    clientProcedureSaleLoadPrepaidCard.getBalanceItem());
                            if (promoFistAccount != null) {
                                promotionMessage = promoFistAccount.getPromotion_message();
                                if (promotionMessage.equals("OK")) {
                                    promotionEco = promoFistAccount.getPromotion_eco();
                                    o.addProperty("promotionMessage", promotionEco);
                                } else
                                    o.addProperty("promotionMessage", promotionMessage);
                            }
                            if ((bono!=null&&bono.trim().equals("true")) || (wbbono!=null&&wbbono.trim().equals("true"))) {
    							accountData = clientSaleBo.findAccountData(cid);
    							accountData = ClientUtils.verifiedTestUsersWelcomeBonus(accountData,session);
    			                result = new Gson().toJson(accountData);
    			                request.setAttribute("clientBalance", result);
    			                Integer gameCode = ((request.getParameter("gamecode")!=null) ? Integer.parseInt(request.getParameter("gamecode")):0);
    			                int gameid = 0;
    			                String[] arrBonusGame = accountData.getBonusGame().split("\\|");
    							if(arrBonusGame.length>0) {
    								for (int i=0; i<arrBonusGame.length; i++) {
    									String[] arrBonus = arrBonusGame[i].trim().split("_");
    									gameid = (arrBonus[0]!=null&&!arrBonus[0].trim().equals(""))?Integer.parseInt(arrBonus[0].trim()):0;
    									if(gameCode==gameid&&arrBonus.length>1) {
    										gameAmount = arrBonus[3];
    										gameName = arrBonus[1];
    									}
    								}
    							}
    						} 
//                            else {
//    							message = "Se ha recargado el saldo con un monto de S/"+amount+". Su nuevo saldo es de S/"+newAmount;
//    						}
                        } else {
                            if (clientProcedureSaleLoadPrepaidCard.getNewAmount() != null)
                                newAmount = clientProcedureSaleLoadPrepaidCard.getNewAmount();
                            userBean.setpMonto(newAmount);
                        }
                    }
                    session.setAttribute(Constants.USR_SESION, userBean);
                    //ClientUtils.updateClientBalance(session, clientSaleBo);
                }

                o.addProperty("message", message);
                o.addProperty("amount", ClientUtils.formatAmount(amount));
                o.addProperty("newAmount", ClientUtils.formatAmount(newAmount));
                o.addProperty("bonusAmount", ((accountData.getBonusAmount()!=null && !accountData.getBonusAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoTeApuesto").toString());
    			o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getOtherAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoOtro").toString());
    			o.addProperty("gameName", gameName);
				o.addProperty("gameAmount", gameAmount);
				o.addProperty("wbMessage", accountData.getWelcomeBonusMessage());
				o.addProperty("balanceItem", balanceItem);
                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.lapollaOperatorId.toString().trim())) {
    				o.addProperty("lapolla", Constants.lapollaGameProviderBalanceUrl+" | ");
    				Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== recarga_lotocard lapolla="+Constants.lapollaGameProviderBalanceUrl+ "clientid= "+clientId);
    				if(message.equals("OK")) session.removeAttribute("operatorId");
                }
                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.tav2OperatorId.toString().trim())) {
                	 ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(userBean.getpClientid(), request.getRemoteAddr());
                	 if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
	   					  String authToken = tanTokenGeneration.getTav2Token();					 
	   					  if(session.getAttribute("redirectGame") != null && session.getAttribute("redirectGame").toString().equals("DV"))
	   		        			o.addProperty("tav2", Constants.tav2GameProviderBaseUrl+" | "+authToken+"&ref=/virtuals");
	   		        	  else
	   		        			o.addProperty("tav2", Constants.tav2GameProviderBaseUrl+" | "+authToken);
	   				  }
                	//o.addProperty("tav2", Constants.tav2GameProviderBaseUrl+" | ");
                	if(message.equals("OK")) {
                		session.removeAttribute("operatorId");
                		session.removeAttribute("redirectGame");
                	}
                	
                }
            }
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info(o.toString());
        }
    }
    
    @RequestMapping(value = "/recarga_lotocard_api")
    public void loadBalanceLotocardAPI(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String log="loadBalanceLotocardAPI";
    	LoggerApi.Log.info("------------- start "+log);
    	String rechargetoken=request.getHeader("rechargetoken");		
    	String ip=ClientUtils.getClientIp(request);
    	//Validar token
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
    			
        ClientProcedureSaleLoadPrepaidCard clientProcedureSaleLoadPrepaidCard = new ClientProcedureSaleLoadPrepaidCard();
        PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        ClientProcedureAccountData accountData = new ClientProcedureAccountData();
        try {
            int cid = 0;
            String pin = "", bono = "", wbbono = "";
            String company = "WEBCO";
            String carrier = null;
            String phone = null;
            String message = "";
            double amount = 0;
            double newAmount = 0;
            String clientId = "";
            String promotionEco = "";
            String promotionMessage = "";
            String result = "", gameAmount = "", gameName = "";
            int balanceItem=0;
            if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
                clientId = tokenValidation.getClientId();
                int option = -1;
                if (request.getParameter("option-card") != null)
                    if (!request.getParameter("option-card").equals("null"))
                        option = Integer.parseInt(request.getParameter("option-card"));
                LoggerApi.Log.info("cid=" + clientId + " Option=" + option + " ClientId=" + clientId);
                if (option == 0)
                    message = "OK";
                else if (option == 1) {
                    if (clientId != null)
                        clientId = clientId.trim();
                    if (!clientId.equals(""))
                        cid = Integer.parseInt(clientId);
                    pin = request.getParameter("pin-number");
                    //validar activación de bono
		            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
		        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";		        	
		            JsonObject jresult=ClientBalanceController.backCodePromotionalValidation(rechargetoken, ip, request.getRemoteAddr(), 
		            		codePromotional, channel, amount, pin, clientSaleBo);
		            bono=jresult.get("bono").getAsString();
		            wbbono=jresult.get("wbbono").getAsString();
                    
                    /*String bonoBienvenida = ClientUtils.verifiedWelcomeBonus(session);

                    if (StringUtils.isNotEmpty(bonoBienvenida)) {
                     ip=bonoBienvenida+"|"+request.getRemoteAddr();
                    } else {
                     ip = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":"")+request.getRemoteAddr();
                    }*/
                    ip = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA|":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]+"|":"")))+request.getRemoteAddr();
                    
                    LoggerApi.Log.info("/recarga_lotocard: activ-bono="+bono+" activ-wbbono="+wbbono+" ip="+ip);
                    
                    clientProcedureSaleLoadPrepaidCard = clientSaleBo.findSaleLoadPrepaidCard(cid, company, carrier, phone, ip, pin);
                    if (clientProcedureSaleLoadPrepaidCard != null) {
                        message = clientProcedureSaleLoadPrepaidCard.getMessage();
                        amount = clientProcedureSaleLoadPrepaidCard.getAmountLoaded();
                        balanceItem= clientProcedureSaleLoadPrepaidCard.getBalanceItem();
                        if (message.equals("OK")) {
                        	//Registrar recarga, identificar web de recarga
                        	String platform = Constants.PLATAFORM;
        					String transactionId = StringLib.encodeLabel(pin);
        					String operatorId=tokenValidation.getOperatorId();
        					ClientProcedureOriginLotocardRecharge originLotocardRecharge = clientSaleBo.setOriginLotocardRecharge(transactionId, platform, operatorId);
        					if(!originLotocardRecharge.getStatus().equals("OK")) {
        						LoggerApi.Log.info("-------------- client_lotocard_load_balance_rt"+" originLotocardRecharge.getMessage=" +originLotocardRecharge.getMessage());
        					}
                            if (clientProcedureSaleLoadPrepaidCard.getNewAmount() != null)
                                newAmount = clientProcedureSaleLoadPrepaidCard.getNewAmount();
                            PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(clientProcedureSaleLoadPrepaidCard.getClientId(),
                                    clientProcedureSaleLoadPrepaidCard.getBalanceItem());
                            if (promoFistAccount != null) {
                                promotionMessage = promoFistAccount.getPromotion_message();
                                if (promotionMessage.equals("OK")) {
                                    promotionEco = promoFistAccount.getPromotion_eco();
                                    o.addProperty("promotionMessage", promotionEco);
                                } else
                                    o.addProperty("promotionMessage", promotionMessage);
                            }
                            if ((bono!=null&&bono.trim().equals("true")) || (wbbono!=null&&wbbono.trim().equals("true"))) {
    							accountData = clientSaleBo.findAccountData(cid);
    			                result = new Gson().toJson(accountData);
    			                request.setAttribute("clientBalance", result);
    			                Integer gameCode = ((request.getParameter("gamecode")!=null) ? Integer.parseInt(request.getParameter("gamecode")):0);
    			                int gameid = 0;
    			                String[] arrBonusGame = accountData.getBonusGame().split("\\|");
    							if(arrBonusGame.length>0) {
    								for (int i=0; i<arrBonusGame.length; i++) {
    									String[] arrBonus = arrBonusGame[i].trim().split("_");
    									gameid = (arrBonus[0]!=null&&!arrBonus[0].trim().equals(""))?Integer.parseInt(arrBonus[0].trim()):0;
    									if(gameCode==gameid&&arrBonus.length>1) {
    										gameAmount = arrBonus[3];
    										gameName = arrBonus[1];
    									}
    								}
    							}
    						} 
//                            else {
//    							message = "Se ha recargado el saldo con un monto de S/"+amount+". Su nuevo saldo es de S/"+newAmount;
//    						}
                        } else {
                            if (clientProcedureSaleLoadPrepaidCard.getNewAmount() != null)
                                newAmount = clientProcedureSaleLoadPrepaidCard.getNewAmount();
                        }
                    }
                }

                o.addProperty("message", message);
                o.addProperty("amount", ClientUtils.formatAmount(amount));
                o.addProperty("newAmount", ClientUtils.formatAmount(newAmount));
                o.addProperty("bonusAmount", ((accountData.getBonusAmount()!=null && !accountData.getBonusAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoTeApuesto").toString());
    			o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getOtherAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoOtro").toString());
    			o.addProperty("gameName", gameName);
				o.addProperty("gameAmount", gameAmount);
				o.addProperty("wbMessage", accountData.getWelcomeBonusMessage());
				o.addProperty("balanceItem", balanceItem);
            }else {
            	o.addProperty("message", tokenValidation.getMessage());
            	o.addProperty("status", tokenValidation.getStatus());
            }
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	LoggerApi.Log.info("------------- end "+log+" out="+o.toString());
//            LoggerApi.Log.info(o.toString());
        }
    }
    
    @RequestMapping(value = "/verifica-codigo-bcp-api")
    public void verifyKeyPayBCPApi(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="verifyKeyPayBCPApi";
    	LoggerApi.Log.info("------------- start "+log);
    	String context = Constants.contextCardWeb;
    	String idSession = "";
        String idClient = "";
        String ipClient = "";
        //HttpSession session = request.getSession();
        String data = "";
        String outData = "";
        int result = 0;
        String resulttrx = "";
        String trx = "";
        String mssg = "", bono = "", bonokey = "", wbbono = "";
        double amount = 0;
        double maxAmount = 0;
        double minAmount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=ClientUtils.getClientIp(request);
        try {
            PrintWriter out = null;
            out = response.getWriter();
            ipClient = request.getRemoteAddr();
            
            //Validar token
    		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
    		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
    		if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
    			idClient=tokenValidation.getClientId();
    		}else {
    			if(tokenValidation.getStatus().equals("TIMEOUTTR")) {
    				mssg = tokenValidation.getStatus();
    			}else {
    				mssg = "No se ha completado la operaci&oacute;n";
    			}
    			
                outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||-1";
                out.print(outData);
                return;
    		}
    		
    		ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();
    		accountDataPart = clientSaleBo.findAccountDataPart(Integer.parseInt(idClient));
    		
    		idSession = accountDataPart.getSessionId().toString();
            //if (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)
            //    maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim());
            //if (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)
            //    minAmount = Double.parseDouble(ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim());
            maxAmount = accountDataPart.getAmtMaxRechargeBcp();
            minAmount = accountDataPart.getAmtMinRechargeBcp();
            
            if (request.getParameter("bcp-amount") != null && !request.getParameter("bcp-amount").equals(""))
                amount = Double.parseDouble(request.getParameter("bcp-amount").toLowerCase().replace("s/.", "").trim().replace(",", "."));
            else
                amount = -1;
            if (request.getParameter("bcp-transact") != null)
                trx = request.getParameter("bcp-transact").trim();
            //validar activación de bono
            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";

            LoggerApi.Log.info("/verifica-codigo-bcp: bonokey="+codePromotional + " channel="+channel +" lotocard="+lotocard);
            LoggerApi.Log.info("IdClient=" + idClient + " IpClient=" + ipClient + " Amount=" + amount + " MinAmount=" + minAmount + " MaxAmount=" + maxAmount + " Transaccion=" + trx);
            if (amount != -1)
                if (amount >= minAmount) {
                    if (amount > maxAmount)
                        mssg = "Debe ingresar un monto de carga no mayor de S/ " + maxAmount + " soles.";
                    else {
                        resulttrx = SalesDispatcher.getDefineTransaction(idClient, idSession, amount, codePromotional);
                        if (resulttrx.equals(""))
                            mssg = "No se ha logrado generar el c&oacute;digo para realizar el pago con su cuenta BCP. ";
                    }
                } else
                    mssg = "Debe ingresar un monto de carga a partir de S/ " + minAmount + " soles. ";
            if (!trx.equals("")) {
                result = SalesDispatcher.getExpiryTransaction(trx);
                if (result == -1)
                    mssg = "No se ha logrado anular el pago pendiente";
            }
          //Registrar recarga, identificar plataforma y web de recarga
			String platform=Constants.PLATAFORM;
			String operatorId=tokenValidation.getOperatorId();
			ClientProcedureOriginBcpRecharge originBcpRecharge = clientSaleBo.setOriginBcpRecharge(resulttrx, platform, operatorId);
			if(!originBcpRecharge.getStatus().equals("OK")) {
				LoggerApi.Log.info("-------------- verifyKeyPayBCPApi"+" originBcpRecharge.getMessage=" +originBcpRecharge.getMessage());
			}
            result = SalesDispatcher.getActiveTransaction(idClient, ipClient);
            @SuppressWarnings("unchecked")
            List<KeyPay> lista = SalesDispatcher.getCheckTransaction(idClient);
            for (KeyPay kp : lista) {
                if (kp.getShortId() != null && !kp.getShortId().trim().equals(""))
                    data += kp.getShortId() + "|";
                else
                    data += " |";
                if (kp.getAmount() != null)
                    data += kp.getAmount() + "|";
                else
                    data += " |";
                if (kp.getExpiryDate() != null)
                    data += sdf.format(kp.getExpiryDate()) + "|";
                else
                    data += " |";
                if (kp.getStatus() != null && !kp.getStatus().trim().equals(""))
                    data += kp.getStatus() + "|";
                else
                    data += " |";
                if (kp.getTransactId() != null && !kp.getTransactId().trim().equals(""))
                    data += kp.getTransactId() + "||";
                else
                    data += " ||";
            }
            
            int idSessionInt = 0;
            int idClientInt = 0;
            try {
                idSessionInt = Integer.parseInt(idSession);
                idClientInt = Integer.parseInt(idClient);
            } catch (Exception ex) {
            	idSessionInt = 0;
            	idClientInt = 0;
            }
            
            if ( idClientInt>0 ) {
                clientProcedureGetClient = clientSaleBo.findClient(idSessionInt, idClientInt);
                if (clientProcedureGetClient != null) {
                    if (result == 1) {
                        mssg = "Se ha recargado saldo desde tu cuenta BCP. Tu nuevo saldo es S/." + clientProcedureGetClient.getAmount();
                    }
                    /*if (result != 1)
                        mssg = "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BCP";*/
                    outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||" + clientProcedureGetClient.getAmount();
                }
            } else {
                mssg = "No se ha completado la operaci&oacute;n";
                outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||-1";
            }
            out.print(outData);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	LoggerApi.Log.info("------------- end "+log+" Resultado=" + result + " OutData=" + outData);
//            LoggerApi.Log.info("Resultado=" + result + " OutData=" + outData);
        }
    }

    @RequestMapping(value = "/verifica-codigo-bcp")
    public void verifyKeyPayBCP(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("-------------- START verifica-codigo-bcp"); 
    	String context = Constants.contextCardWeb;
    	String idSession = "";
        String idClient = "";
        String ipClient = "";
        HttpSession session = request.getSession();
        String data = "";
        String outData = "";
        int result = 0;
        String resulttrx = "";
        String trx = "";
        String mssg = "", bono = "", bonokey = "", wbbono = "", promotionKey="";
        double amount = 0;
        double maxAmount = 0;
        double minAmount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        ClientProcedureGetClient clientProcedureGetClient = new ClientProcedureGetClient();
        UserBean userBean = null;
        if (session.getAttribute(Constants.USR_SESION) != null)
            userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        try {
            PrintWriter out = null;
            out = response.getWriter();
            if (userBean != null) {
                idSession = userBean.getpSessionid().toString();
                idClient = userBean.getpClientid().toString();
            }
            ipClient = request.getRemoteAddr();
            
            ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
            //if (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)
            //    maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim());
            //if (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)
            //    minAmount = Double.parseDouble(ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim());
            maxAmount = accountDataPart.getAmtMaxRechargeBcp();
            minAmount = accountDataPart.getAmtMinRechargeBcp();
            
            if (request.getParameter("bcp-amount") != null && !request.getParameter("bcp-amount").equals(""))
                amount = Double.parseDouble(request.getParameter("bcp-amount").toLowerCase().replace("s/.", "").trim().replace(",", "."));
            else
                amount = -1;
            if (request.getParameter("bcp-transact") != null)
                trx = request.getParameter("bcp-transact").trim();
            bono = request.getParameter("activ-bono");
            wbbono = request.getParameter("activ-wbbono");
            promotionKey = request.getParameter("codePromotional");
            LoggerApi.Log.info("/verifica-codigo-bcp: activ-bono="+bono+" activ-wbbono="+wbbono+" promotionKey="+promotionKey);
            LoggerApi.Log.info("IdClient=" + idClient + " IpClient=" + ipClient + " Amount=" + amount + " MinAmount=" + minAmount + " MaxAmount=" + maxAmount + " Transaccion=" + trx);
            if (amount != -1)
                if (amount >= minAmount) {
                    if (amount > maxAmount)
                        mssg = "Debe ingresar un monto de carga no mayor de S/ \" + maxAmount + \" soles.";
                    else {
                        resulttrx = SalesDispatcher.getDefineTransaction(idClient, idSession, amount, promotionKey);
                        if (resulttrx.equals(""))
                            mssg = "No se ha logrado generar el c&oacute;digo para realizar el pago con su cuenta BCP. ";
                    }
                } else
                    mssg = "Debe ingresar un monto de carga a partir de S/ " + minAmount + " soles. ";
            if (!trx.equals("")) {
                result = SalesDispatcher.getExpiryTransaction(trx);
                if (result == -1)
                    mssg = "No se ha logrado anular el pago pendiente";
            }
            result = SalesDispatcher.getActiveTransaction(idClient, ipClient);
            @SuppressWarnings("unchecked")
            List<KeyPay> lista = SalesDispatcher.getCheckTransaction(idClient);
            for (KeyPay kp : lista) {
                if (kp.getShortId() != null && !kp.getShortId().trim().equals(""))
                    data += kp.getShortId() + "|";
                else
                    data += " |";
                if (kp.getAmount() != null)
                    data += kp.getAmount() + "|";
                else
                    data += " |";
                if (kp.getExpiryDate() != null)
                    data += sdf.format(kp.getExpiryDate()) + "|";
                else
                    data += " |";
                if (kp.getStatus() != null && !kp.getStatus().trim().equals(""))
                    data += kp.getStatus() + "|";
                else
                    data += " |";
                if (kp.getTransactId() != null && !kp.getTransactId().trim().equals(""))
                    data += kp.getTransactId() + "||";
                else
                    data += " ||";
            }
            
            int idSessionInt = 0;
            int idClientInt = 0;
            try {
                idSessionInt = Integer.parseInt(idSession);
                idClientInt = Integer.parseInt(idClient);
            } catch (Exception ex) {
            	idSessionInt = 0;
            	idClientInt = 0;
            }
            
            if ( idClientInt>0 ) {
                clientProcedureGetClient = clientSaleBo.findClient(idSessionInt, idClientInt);
                if (clientProcedureGetClient != null) {
                    if (result == 1) {
                        userBean.setpMonto(clientProcedureGetClient.getAmount());
                        session.setAttribute(Constants.USR_SESION, userBean);
                        mssg = "Se ha recargado saldo desde tu cuenta BCP. Tu nuevo saldo es S/." + clientProcedureGetClient.getAmount();
                    }
                    /*if (result != 1)
                        mssg = "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BCP";*/
                    outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||" + clientProcedureGetClient.getAmount();
                }
            } else {
                mssg = "No se ha completado la operaci&oacute;n";
                outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||-1";
            }
            out.print(outData);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            LoggerApi.Log.info("Resultado=" + result + " OutData=" + outData);
            LoggerApi.Log.info("-------------- END verifica-codigo-bcp"); 
        }
    }

    @RequestMapping(value = "/anular")
    public void expiryTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pin = request.getParameter("pin");
        int status = SalesDispatcher.getExpiryTransaction(pin);
        JsonObject o = new JsonObject();
        if (status == -1)
            o.addProperty("menssage", "No se pudo anular la transacciï¿½n");
        else
            o.addProperty("message", "Anulado!");
    }

    @RequestMapping(value = "/verificar")
    public void verifyTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("-------------- START verificar"); 
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        String idSession = userBean.getpSessionid().toString();
        String idClient = userBean.getpClientid().toString();
        String ipClient = request.getRemoteAddr();
        String alertmsg = "";//promotionEco = "";
        String promotionMessage = "";
        double amount = ((request.getParameter("amount")!=null && !request.getParameter("amount").toString().trim().equals(""))?Double.parseDouble(request.getParameter("amount").toString().replaceAll("S/ ", "").trim()):0);
        //int result = SalesDispatcher.getActiveTransaction(idClient, ipClient);
        String pin = request.getParameter("pin");
        int result = SalesDispatcher.getVerifyTransaction(pin, idClient);
        ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(Integer.parseInt(idSession), Integer.parseInt(idClient));
        JsonObject o = new JsonObject();
        ClientProcedureAccountData accountData = new ClientProcedureAccountData();
        String gameAmount = "", gameName = "", gameQuantity = "";
        if (result >= 1) {
        	PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(Integer.parseInt(idClient), result);
            if (promoFistAccount != null) {
                promotionMessage = promoFistAccount.getPromotion_message();
                if (promotionMessage.equals("OK")) {
                	promotionMessage = promoFistAccount.getPromotion_eco();
                }
            }
            if(!promotionMessage.trim().equals("") && clientProcedureGetClient.getAmount()>amount) {
				accountData = clientSaleBo.findAccountData(Integer.parseInt(idClient));
				accountData = ClientUtils.verifiedTestUsersWelcomeBonus(accountData,session);
                request.setAttribute("clientBalance", new Gson().toJson(accountData));
                Integer gameCode = ((request.getParameter("gamecode")!=null) ? Integer.parseInt(request.getParameter("gamecode")):0);
                int gameid = 0;
                String[] arrBonusGame = accountData.getBonusGame().split("\\|");
				if(arrBonusGame.length>0) {
					for (int i=0; i<arrBonusGame.length; i++) {
						String[] arrBonus = arrBonusGame[i].trim().split("_");
						gameid = (arrBonus[0]!=null&&!arrBonus[0].trim().equals(""))?Integer.parseInt(arrBonus[0].trim()):0;
						if(gameCode==gameid&&arrBonus.length>1) {
							gameAmount = arrBonus[3];
							gameName = arrBonus[1];
							gameQuantity = arrBonus[2];
						}
					}
				}
                if (promotionMessage.indexOf("insuficiente") > -1 ) {
                    alertmsg = promotionMessage + "<br/><br/>La recarga ha sido abonada a su saldo principal.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency((clientProcedureGetClient.getAmount()-amount)) ;                                  
                } else {
                    alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency((clientProcedureGetClient.getAmount()-amount)) + "<br/>" + promotionMessage;                               
                }
            } else {
            	    if(promotionMessage.contains("100%")) {
            	    	 alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/>"+ promotionMessage;
            	    }else {
            	    	 alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency((clientProcedureGetClient.getAmount()-amount)) + "<br/>Tu saldo disponible es: " + ClientUtils.formatCurrency(clientProcedureGetClient.getAmount()) + "<br/>" + promotionMessage;
            	    }
            }
            o.addProperty("state", "OK");
            o.addProperty("message", alertmsg);//"Se ha recargado saldo desde tu cuenta BCP. Tu nuevo saldo es S/." + clientProcedureGetClient.getAmount());
            o.addProperty("amount", clientProcedureGetClient.getAmount());
            o.addProperty("bonusAmount", ((accountData.getBonusAmount()!=null && !accountData.getBonusAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoTeApuesto").toString());
			o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getOtherAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoOtro").toString());
			o.addProperty("gameName", gameName);
			o.addProperty("gameAmount", gameAmount);
			o.addProperty("gameQuantity", gameQuantity);
			o.addProperty("wbMessage", accountData.getWelcomeBonusMessage());
            userBean.setpMonto(clientProcedureGetClient.getAmount());
            session.setAttribute(Constants.USR_SESION, userBean);
        } else {
            o.addProperty("state", "KO");
            o.addProperty("message", "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BCP");
        }
        out.print(o);
        LoggerApi.Log.info("-------------- END verificar"); 
    }
    
    @RequestMapping(value = "/verificarAPI")
    public void verifyAPITransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="verifyAPITransaction";
    	LoggerApi.Log.info("-------------- start "+log);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=ClientUtils.getClientIp(request);
        JsonObject o = new JsonObject();
        
        //Validar token
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
		Integer clientId=0;
		if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
	        String idClient = tokenValidation.getClientId();
	        ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();
			accountDataPart = clientSaleBo.findAccountDataPart(Integer.parseInt(tokenValidation.getClientId()));	
			String idSession = accountDataPart.getSessionId().toString();
	        
	        String ipClient = request.getRemoteAddr();
	        String alertmsg = "";//promotionEco = "";
	        String promotionMessage = "";
	        double amount = ((request.getParameter("amount")!=null && !request.getParameter("amount").isEmpty())?Double.parseDouble(request.getParameter("amount").toString().replaceAll("S/ ", "").trim()):0);
	        //int result = SalesDispatcher.getActiveTransaction(idClient, ipClient);
	        String pin = request.getParameter("pin");
	        int result = SalesDispatcher.getVerifyTransaction(pin, idClient);
	        ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(Integer.parseInt(idSession), Integer.parseInt(idClient));
	        
	        ClientProcedureAccountData accountData = new ClientProcedureAccountData();
	        String gameAmount = "", gameName = "", gameQuantity = "";
	        if (result >= 1) {
	        	PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(Integer.parseInt(idClient), result);
	            if (promoFistAccount != null) {
	                promotionMessage = promoFistAccount.getPromotion_message();
	                if (promotionMessage.equals("OK")) {
	                	promotionMessage = promoFistAccount.getPromotion_eco();
	                }
	            }
	            if(!promotionMessage.trim().equals("") && clientProcedureGetClient.getAmount()>amount) {
					accountData = clientSaleBo.findAccountData(Integer.parseInt(idClient));
					//accountData = ClientUtils.verifiedTestUsersWelcomeBonus(accountData,session);
	                request.setAttribute("clientBalance", new Gson().toJson(accountData));
	                Integer gameCode = ((request.getParameter("gamecode")!=null) ? Integer.parseInt(request.getParameter("gamecode")):0);
	                int gameid = 0;
	                String[] arrBonusGame = accountData.getBonusGame().split("\\|");
					if(arrBonusGame.length>0) {
						for (int i=0; i<arrBonusGame.length; i++) {
							String[] arrBonus = arrBonusGame[i].trim().split("_");
							gameid = (arrBonus[0]!=null&&!arrBonus[0].trim().equals(""))?Integer.parseInt(arrBonus[0].trim()):0;
							if(gameCode==gameid&&arrBonus.length>1) {
								gameAmount = arrBonus[3];
								gameName = arrBonus[1];
								gameQuantity = arrBonus[2];
							}
						}
					}
	                if (promotionMessage.indexOf("insuficiente") > -1 ) {
	                    alertmsg = promotionMessage + "<br/><br/>La recarga ha sido abonada a su saldo principal.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency((clientProcedureGetClient.getAmount()-amount)) ;                                  
	                } else {
	                    alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency((clientProcedureGetClient.getAmount()-amount)) + "<br/>" + promotionMessage;                               
	                }
	            } else {
	            	    if(promotionMessage.contains("100%")) {
	            	    	 alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/>"+ promotionMessage;
	            	    }else {
	            	    	 alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency((clientProcedureGetClient.getAmount()-amount)) + "<br/>Tu saldo disponible es: " + ClientUtils.formatCurrency(clientProcedureGetClient.getAmount()) + "<br/>" + promotionMessage;
	            	    }
	            }
	            o.addProperty("state", "OK");
	            o.addProperty("message", alertmsg);//"Se ha recargado saldo desde tu cuenta BCP. Tu nuevo saldo es S/." + clientProcedureGetClient.getAmount());
	            o.addProperty("amount", clientProcedureGetClient.getAmount());
	            o.addProperty("bonusAmount", ((accountData.getBonusAmount()!=null && !accountData.getBonusAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoTeApuesto").toString());
				o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?ClientUtils.formatCurrency(Double.parseDouble(accountData.getOtherAmount().replaceAll(",","."))):ClientUtils.formatCurrency(0.00)));//session.getAttribute("bonoOtro").toString());
				o.addProperty("gameName", gameName);
				o.addProperty("gameAmount", gameAmount);
				o.addProperty("gameQuantity", gameQuantity);
				o.addProperty("wbMessage", accountData.getWelcomeBonusMessage());
	        } else {
	            o.addProperty("state", "KO");
	            o.addProperty("message", "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BCP");
	        }
		}else {
			o.addProperty("state", tokenValidation.getStatus());
		}
        out.print(o);
        LoggerApi.Log.info("-------------- end "+log);
    }


    @RequestMapping(value = "/cuenta-vpos")
    public String dataCreditCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String context = "CARD-WEB";
    	String context = Constants.contextCardWeb;
    	String idSession = "";
        String idClient = "";
        HttpSession session = request.getSession();
        DecimalFormat df = new DecimalFormat("#####0.00");
        // String mssg = "";
        double amount = 0;
        double bizpayMaxAmount = 0;
        // int mode = 0;
        String mode = "";
        // String outData = "";
        ClientProcedureGetDataClient clientProcedureGetDataClient = new ClientProcedureGetDataClient();
        try {
            // PrintWriter out = null;
            // out = response.getWriter();
            if (session.getAttribute(Constants.USR_SESION) != null) {
                idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid().toString();
                idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString();
            }
            /*
             * ClientProcedureAccountData clientProcedureAccountData = ClientBalanceBalanceBo.findByIdClient(idClient); request.setAttribute("clientBalance", clientProcedureAccountData);
             */
            /*
             * ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(Integer.parseInt(idSession), Integer.parseInt(idClient)); request.setAttribute("clientSale",
             * clientProcedureGetClient); UserBean userBean = new UserBean(); if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) userBean = (UserBean)
             * session.getAttribute(Constants.USR_SESION); userBean.setpGame(0); session.setAttribute(Constants.USR_SESION, userBean);
             */
            if (!idSession.equals("") && !idClient.equals("")) {
                if (ConnectionFactory.operationProperty("bizpayMaxAmount", context) != null)
                	bizpayMaxAmount = Double.parseDouble(ConnectionFactory.operationProperty("bizpayMaxAmount", context).trim());
                if (request.getParameter("pos-amount") != null && !request.getParameter("pos-amount").equals(""))
                    amount = Double.parseDouble(request.getParameter("pos-amount").trim());
                if (request.getParameter("pos-mode") != null && !request.getParameter("pos-mode").equals(""))
                    mode = request.getParameter("pos-mode").trim();
                // String[] armode = smode.split("|||");
                // String bet = armode[0];
                // mode = Integer.parseInt(armode[1]);
                LoggerApi.Log.info("cid=" + idClient + " mmount=" + amount + " bizpayMaxAmount=" + bizpayMaxAmount + " Mode=" + mode);
                if (amount != -1)
                    if (amount >= 20) {
                        if (amount > bizpayMaxAmount)
                            request.setAttribute(Constants.ALERT_MSG, "Debe ingresar un monto de carga no mayor de S/. " + bizpayMaxAmount + " soles.");
                        else {
                            // String mail = null;
                            // String mail2 = null;
                            // String email = null;
                            String[] address = null;
                            // Object[] outCadenas =
                            // SalesDispatcher.getClientRegister(idSession,
                            // idClient);
                            clientProcedureGetDataClient = clientSaleBo.findGetDataClient(Integer.parseInt(idSession), Integer.parseInt(idClient));
                            if (clientProcedureGetDataClient != null) {
                                address = clientProcedureGetDataClient.getAddress().split("__");
                                clientProcedureGetDataClient.setAddress(address[0]);
                                clientProcedureGetDataClient.setMobilePhone(address[2]);
                                request.setAttribute("clientData", clientProcedureGetDataClient);
                                if (!clientProcedureGetDataClient.getComStatus().equals("BIZPAYOK")) {
                                    request.setAttribute(Constants.ALERT_MSG, clientProcedureGetDataClient.getComStatus());
                                }
                            }
                            double exchangerate = SalesDispatcher.getExchangeRate();
                            double damount = amount / exchangerate;
                            String dollaramount = df.format(damount);
                            request.setAttribute("posAmount", amount);
                            request.setAttribute("posMode", mode);
                            request.setAttribute("exchangeRate", exchangerate);
                            request.setAttribute("dollarAmount", dollaramount);
                            request.setAttribute("countries", countryBo.findCountry());
                            request.setAttribute("regions", regionBo.findRegion());
                            request.setAttribute("provinces", provinceBo.findViewProvinciaList());
                            // request.setAttribute("districs", districtBo.findDistrict());
                            /*
                             * if(clientProcedureGetDataClient.getNombre() != null) outData += clientProcedureGetDataClient.getNombre(); if(clientProcedureGetDataClient.getApPaterno() != null) outData
                             * += clientProcedureGetDataClient.getApPaterno(); if(clientProcedureGetDataClient.getApMaterno() != null) outData += clientProcedureGetDataClient.getApMaterno();
                             * if(clientProcedureGetDataClient.getMail() != null) mail = clientProcedureGetDataClient.getMail(); if(clientProcedureGetDataClient.getComRegion() != null) outData +=
                             * clientProcedureGetDataClient.getComRegion(); if(clientProcedureGetDataClient.getMail2() != null) mail2 = clientProcedureGetDataClient.getMail2();
                             * if(clientProcedureGetDataClient.getCountry() != null) outData += clientProcedureGetDataClient.getCountry(); if(clientProcedureGetDataClient.getTypeId() != null) outData
                             * += clientProcedureGetDataClient.getTypeId(); if(clientProcedureGetDataClient.getNumberId() != null) outData += clientProcedureGetDataClient.getNumberId();
                             * if(clientProcedureGetDataClient.getAddress() != null) address = clientProcedureGetDataClient.getAddress(); aaddress = address.split("__"); address = aaddress[0]; phone =
                             * aaddress[2]; if(mail != null) email = mail; else if(mail2 != null) email = mail2; double xchangerate = SalesDispatcher.getExchangeRate(); double damount =
                             * amount/xchangerate; String dollaramount = df.format(damount); outData += email; outData += address; outData += phone; outData += amount; outData += mode; outData +=
                             * xchangerate; outData += dollaramount;
                             */
                        }
                    } else
                        request.setAttribute(Constants.ALERT_MSG, "Debe ingresar un monto de carga a partir de veinte soles.");
            }
            return "client/vpos_form";
            // outData = (data.length()>2?data.substring(0, data.length() -
            // 2):"__")+"|||"+mssg+"|||"+clientProcedureGetClient.getAmount();
            // out.print(outData);
        } catch (NumberFormatException e) {
            request.setAttribute(Constants.ALERT_MSG, "Ingrese el nï¿½mero correcto");
            return "client/vpos_form";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "client/vpos_form";
        } finally {
            LoggerApi.Log.info("cid=" + idClient +" Nombre=" + clientProcedureGetDataClient.getNombre() + " " + clientProcedureGetDataClient.getApPaterno() + " "
                    + clientProcedureGetDataClient.getApMaterno());
        }
    }

    // @RequestMapping(value = "/secure-payment-gateway")
    // public String gatewayCredidCard(HttpServletRequest request,
    // HttpServletResponse response) throws Exception {
    // System.out.println("#-I");
    // return "client/vpos_gateway";
    // }
    @RequestMapping(value = "/pasarela-vpos")
    public String gatewayCreditCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String context = "CARD-WEB";
    	String context = Constants.contextCardWeb;
    	DecimalFormat df = new DecimalFormat("#####0.00");
        HttpSession session = request.getSession();
        String operationNumber = "";
        String idSession = "";
        String idClient = "";
        String userName = "";
        try {
        	UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
            try {
                idSession = userBean.getpSessionid().toString();
                idClient = userBean.getpClientid().toString();
                userName = userBean.getpUser().toString();
                LoggerApi.Log.info("cid=" + idClient + " idSession=" + idSession + " userName=" + userName);
            } catch (Exception ex) {
                LoggerApi.Log.info("cid=" + userBean);
                request.setAttribute(Constants.ALERT_MSG, "Lo sentimos.\nLe rogamos que vuelva nuevamente a colocar sus datos de manera correcta.\nMil Gracias.");
                request.setAttribute("posAmount", request.getParameter("pos-amount"));// formbean.setPosAmount(amount);
                return "forward:/vpos_form.html";
            }
            String sep = System.getProperty("file.separator");
            String path = System.getProperty("java.home") + sep + "setup" + sep + "sale" + sep;
            String fileCriptoPublicAlignet = path + String.valueOf(ConnectionFactory.operationProperty("criptoPublicAlignet", context)).toString().trim();
            String fileSignaturePrivateIntralot = path + String.valueOf(ConnectionFactory.operationProperty("signaturePrivateIntralot", context)).toString().trim();
            String vectorInicializacion = String.valueOf(ConnectionFactory.operationProperty("initializationVector", context)).toString().trim();
            String idacquirer = String.valueOf(ConnectionFactory.operationProperty("idacquirer", context)).toString().trim();
            String idcommerce = String.valueOf(ConnectionFactory.operationProperty("idcommerce", context)).toString().trim();
            String firstname = request.getParameter("name").trim();
            if (firstname != null && !firstname.equals("") && firstname.length() > 30)
                firstname = ClientUtils.formatText(firstname.substring(0, 30));
            else if (firstname == null || firstname.equals(""))
                firstname = " ";
            String lastname = request.getParameter("ap-paterno").trim() + " " + request.getParameter("ap-materno").trim();
            if (lastname == null || lastname.equals(""))
                lastname = " ";
            else if (lastname != null && !lastname.equals("") && lastname.length() > 50)
                lastname = ClientUtils.formatText(lastname.substring(0, 50));
            String email = request.getParameter("email").trim();
            String country = request.getParameter("country").trim();
            if (country == null || country.equals(""))
                country = " ";
            else if (country != null && !country.equals("") && country.length() > 2)
                country = country.substring(0, 2);
            String city = request.getParameter("region").trim();
            if (city == null || city.equals(""))
                city = " ";
            else if (city != null && !city.equals("") && city.length() > 50)
                city = ClientUtils.formatText(city.substring(0, 50));
            String state = request.getParameter("province").trim();
            if (state == null || state.equals(""))
                state = " ";
            else if (state != null && !state.equals("") && state.length() > 15)
                state = ClientUtils.formatText(state.substring(0, 15));
            String address = request.getParameter("address").trim();
            if (address == null || address.equals(""))
                address = " ";
            else if (address != null && !address.equals("") && address.length() > 50)
                address = ClientUtils.formatText(address.substring(0, 50));
            String zipcode = request.getParameter("zipcode").trim();
            if (zipcode == null || zipcode.equals(""))
                zipcode = " ";
            else if (zipcode != null && !zipcode.equals("") && zipcode.length() > 10)
                zipcode = zipcode.substring(0, 10);
            String phone = request.getParameter("phone").trim();
            if (phone == null || phone.equals(""))
                phone = " ";
            else if (phone != null && !phone.equals("") && phone.length() > 15)
                phone = phone.substring(0, 15);
            String typeid = request.getParameter("document-type").trim();
            if (typeid == null || typeid.equals(""))
                typeid = " ";
            else if (typeid != null && !typeid.equals("") && typeid.length() > 15)
                typeid = typeid.substring(0, 15);
            String numberid = request.getParameter("document-number").trim();
            if (numberid == null || numberid.equals(""))
                numberid = " ";
            else if (numberid != null && !numberid.equals("") && numberid.length() > 15)
                numberid = numberid.substring(0, 15);
            String clientdata = idClient + "__" + userName + "__" + firstname + "__" + lastname + "__" + typeid + "__" + numberid + "__" + email + "__" + address + "__"
                    + zipcode + "__" + country + "__" + city + "__" + state + "__" + phone + "__NEW ECOMMERCE";
            String sessionkey = "";
            String xmlreq = "";
            String digitalsign = "";
            double damount = Double.parseDouble(request.getParameter("pos-amount").trim());
            int mode = Integer.parseInt(request.getParameter("pos-mode").trim());
            double amount = 0;
            String tamount = "";
            String namount = "";
            int result = 0;
            Object[] outCadenas = SalesDispatcher.getDefineBizPayTransaction(idClient, idSession, idcommerce, damount, mode);
            // System.out.println("####### outCadenas #######");
            // System.out.println("[0] " + outCadenas[0]);
            // System.out.println("[1] " + outCadenas[1]);
            // System.out.println("[2] " + outCadenas[2]);
            // System.out.println("[3] " + outCadenas[3]);
            // System.out.println("[4] " + outCadenas[4]);
            if (outCadenas[0] != null)
                operationNumber = outCadenas[0].toString(); // Number
            
            if (operationNumber==null || operationNumber.trim().equals("") || operationNumber.trim().equals("null") ) {
                LoggerApi.Log.info("cid=" + userBean);
                request.setAttribute(Constants.ALERT_MSG, "Lo sentimos.\nNo se ha creado el codigo de pago.\nEspere a que evaluen los pedidos pendientes.");
                request.setAttribute("posAmount", request.getParameter("pos-amount"));// formbean.setPosAmount(amount);
                return "forward:/vpos_form.html";
            }
            
            if (outCadenas[1] != null)
                xmlreq = outCadenas[1].toString(); // XML_Req
            if (outCadenas[2] != null)
                sessionkey = outCadenas[2].toString(); // Session_key
            if (outCadenas[3] != null)
                digitalsign = outCadenas[3].toString(); // Digital_Sign
            if (outCadenas[4] != null)
                amount = new Double(outCadenas[4].toString()); // Amount
            tamount = df.format(amount);
            namount = tamount.replace(".", "");
            
            LoggerApi.Log.info("cid=" + idClient + " operationNumber=" + operationNumber + " amount=" + amount);

            if (!xmlreq.equals(""))
                result = 1;
            else {
                // Pasarela de pago ByzPay -- Uso del Plug-in Java para enviar
                // informaciï¿½n al V-POS
                // Crear una instancia de la clase VPOSBean del paquete
                VPOS20Bean bean = new VPOS20Bean();
                // Setear los parï¿½metros dentro de las propiedades del objeto
                // Plugin
                try {
                    bean.setAcquirerId(idacquirer); // Cï¿½digo de adquirente
                                                    // asignado por Alignet.
                                                    // Valor fijo igual al
                                                    // parï¿½metro IDACQUIRER
                                                    // (obligatorio)
                    bean.setCommerceId(idcommerce); // Cï¿½digo ï¿½nico de Comercio
                                                    // asignado por Alignet.
                                                    // Valor fijo igual al
                                                    // parï¿½metro IDCOMMERCE
                                                    // (obligatorio)
                    bean.setPurchaseOperationNumber(operationNumber);// ("5646554");
                                                                     // //Identificador
                                                                     // ï¿½nico
                                                                     // por
                                                                     // cada
                                                                     // transacciï¿½n,
                                                                     // dado
                                                                     // por
                                                                     // el
                                                                     // comercio
                                                                     // (obligatorio)
                    bean.setPurchaseAmount(namount); // Valor total de la
                                                     // compra, dado por el
                                                     // Comercio. el monto
                                                     // debe ir sin separador
                                                     // decimal (Si el monto
                                                     // es 100.30 dï¿½lares
                                                     // entonces la cantidad
                                                     // a
                                                     // enviar es 10030)
                                                     // (obligatorio)
                    bean.setPurchaseCurrencyCode("840"); // Moneda Segï¿½n
                                                         // Estï¿½ndar numerico
                                                         // ISO Tipo
                                                         // alfanumerico,
                                                         // longitud de 3
                                                         // caracteres (Debe
                                                         // estar en las
                                                         // monedas
                                                         // permitidas para
                                                         // el comercio)
                                                         // (obligatorio)
                    bean.setBillingFirstName(firstname.trim()); // Nombre del
                                                                // tarjetahabiente.
                                                                // (como aparece
                                                                // en la tarjeta
                                                                // de credito)
                    bean.setBillingLastName(lastname.trim()); // Apellido del
                                                              // tarjetahabiente
                                                              // (como aparece
                                                              // en la tarjeta
                                                              // de credito)
                    bean.setBillingEMail(email.trim()); // Direcciï¿½n electrï¿½nica
                                                        // del tarjetahabiente
                    bean.setBillingAddress(address.trim()); // Direcciï¿½n del
                                                            // tarjetahabiente
                    bean.setBillingZIP(zipcode.trim()); // Cï¿½digo Postal del
                                                        // tarjetahabiente
                    bean.setBillingCity(city.trim()); // Nombre de la ciudad del
                                                      // tarjetahabiente.
                    bean.setBillingState(state.trim()); // Nombre del
                                                        // estado/regiï¿½n del
                                                        // tarjetahabiente.
                    bean.setBillingCountry(country.trim()); // Cï¿½digo ISO del
                                                            // paï¿½s del
                                                            // tarjetahabiente.
                    bean.setBillingPhone(phone.trim()); // Telï¿½fono del
                                                        // tarjetahabiente.
                    bean.setReserved1(typeid.trim());
                    bean.setReserved2(numberid.trim());
                    bean.setReserved3(idClient);
                    bean.setReserved4(userName);
                    bean.setReserved5(email);
                    bean.setLanguage("SP"); // Idioma usado Espanol (SP)
                    // Seguir seteando los demï¿½s datos.
                } catch (InvalidVPOSParameterException e) {
                    LoggerApi.severe(e);
                    throw e;
                }
                // setear campos opcionales si es el caso
                // setear campos Reservados si es el caso
                // bean.setReserved1("5646554");
                // setear plugin con lo valores para encriptar
                try {
                    // instanciar una clase Send , pasar como parï¿½metro la llave
                    // publica para encriptar
                    // la privada para firmar y
                    // el vector de inicializaciï¿½n
                    Send20 send = new Send20(new FileReader(fileCriptoPublicAlignet), new FileReader(fileSignaturePrivateIntralot), vectorInicializacion);
                    // encriptar
                    send.execute(bean);
                } catch (PlugInVPOSException e) {
                    LoggerApi.severe(e);
                    throw e;
                } catch (FileNotFoundException e) {
                    LoggerApi.severe(e);
                    throw e;
                }
                sessionkey = bean.getCipheredSessionKey();
                xmlreq = bean.getCipheredXML();
                digitalsign = bean.getCipheredSignature();
                result = SalesDispatcher.getCheckBizPayTransaction(idClient, idcommerce, operationNumber, xmlreq, sessionkey, digitalsign, clientdata);
            }
            // System.out.println("####### result #######");
            // System.out.println(result);
            if (result == 1 && !xmlreq.equals("")) {
                String clientIp = request.getRemoteAddr();
                String dbfile1 = path + "GeoIP.dat";
                LookupService ls = new LookupService(dbfile1, LookupService.GEOIP_STANDARD);
                Country geocountry = ls.getCountry(clientIp);
                ls.close();
                // controller.sendHTMLTrakingMail(clientId, firstname, lastname,
                // "", "", typeid, numberid, "", mail, "", user,
                // address+" - "+geocountry.getCountryName(), "", "", "", "",
                // "", "", "",
                // tamount, "Recarga de saldo");
                if (geocountry.getCountryId().equals("US")) {
                    request.setAttribute(Constants.ALERT_MSG, "Lo sentimos. No puede realizar esta operaciï¿½n.");
                    request.setAttribute("posAmount", amount);// formbean.setPosAmount(amount);
                    return "forward:/tarjeta-datos.html";
                } else {
                    request.setAttribute("idAcquirer", idacquirer);// formbean.setIdAcquirer(idacquirer);
                    request.setAttribute("idCommerce", idcommerce);// formbean.setIdCommerce(idcommerce);
                    request.setAttribute("xmlReq", xmlreq);// formbean.setXmlReq(xmlreq);
                    request.setAttribute("digitalSign", digitalsign);// formbean.setDigitalSign(digitalsign);
                    request.setAttribute("sessionKey", sessionkey);// formbean.setSessionKey(sessionkey);
                    return "client/vpos_gateway";
                }
            } else {
                request.setAttribute(Constants.ALERT_MSG, "Lo sentimos.\nLe rogamos que vuelva nuevamente a colocar sus datos de manera correcta.\nMil Gracias.");
                request.setAttribute("posAmount", amount);// formbean.setPosAmount(amount);
                return "forward:/vpos_form.html";
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "forward:/vpos_form.html";
        } finally {
            LoggerApi.Log.info("cid=" + idClient + " UserName=" + userName + " OperationNumber=" + operationNumber);
        }
    }

    @RequestMapping(value = "/cancela_vpos")
    public String calcelCreditCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String context = "CARD-WEB";
    	String context = Constants.contextCardWeb;
    	HttpSession session = request.getSession();
        String idClient = "";
        String idcommerce = "";
        try {
            idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString();
            idcommerce = String.valueOf(ConnectionFactory.operationProperty("idcommerce", context)).toString().trim();
            SalesDispatcher.getCancelBizPayTransaction(idClient, idcommerce);
            return "client/vpos_canceled";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "client/vpos_canceled";
        } finally {
            LoggerApi.Log.info("IdClient=" + idClient + " Idcommerce=" + idcommerce);
        }
    }

    @RequestMapping(value = "/reporte_vpos")
    public String reportCreditCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String context = "CARD-WEB";
    	String context = Constants.contextCardWeb;
    	HttpSession session = request.getSession();
        String idClient = "";
        String ipClient = "";
        String idcommerce = "";
        try {
            idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString();
            ipClient = request.getRemoteAddr();
            idcommerce = String.valueOf(ConnectionFactory.operationProperty("idcommerce", context)).toString().trim();
            Object[] outObj = SalesDispatcher.generateBizPayHTMLMessage(idClient, ipClient, idcommerce);
            boolean printFlag = Boolean.parseBoolean(outObj[0].toString());
            StringBuffer htmlText = new StringBuffer(outObj[1].toString());
            request.setAttribute("stringText", htmlText);
            if (printFlag)
                request.setAttribute(Constants.ALERT_MSG, "Se ha enviado el mensaje con el reporte del comercio");
            return "client/print_results";
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "client/print_results";
        } finally {
            LoggerApi.Log.info("IdClient=" + idClient + " Idcommerce=" + idcommerce);
        }
    }

    @RequestMapping(value = "/politicas-ventas")
    public String salePolicies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/user_policies";
    }

    @RequestMapping(value = "/informacion-seguridad")
    public String saleSecurityInformation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/user_security";
    }

    @RequestMapping(value = "/term_condiciones")
    public String term_condiciones(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/term_condiciones";
    }

    @RequestMapping(value = "/reclama_premio")
    public String reclama_premio(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/reclamatuPremio";
    }

    @RequestMapping(value = "/term_condiciones_cyber_mdy")
    public String term_cond_cyber_mdy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/term_cond_cyber_mdy";
    }
    
    @RequestMapping(value = "/term_condiciones_bono")
    public String term_cond_bono(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "client/term_cond_bono";
    }
    
    @RequestMapping(value = "/resultados_juego")
    public void game_results(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
    	String url = ((ConnectionFactory.operationProperty("resultsServerURI", "CARD-WEB") != null)?ConnectionFactory.operationProperty("resultsServerURI", "CARD-WEB").trim():""), game = request.getParameter("game"), parameter = "", random = "";
//    	String url = "http://www.desarrollo.intralotvirtual.com.pe/lotto-game/", game = request.getParameter("game"), parameter = "", random = "";
//    	String url = "http://localhost:8080/lotto-game/", game = request.getParameter("game"), parameter = "", random = "";
    	
    	long seed = System.currentTimeMillis();
	    Random generator = new Random(seed);
	    random = (generator.nextInt((20000-10000)+1)+10000)+"";
	    JsonObject o = new JsonObject();
	    if(game.equals("ganadiario")) parameter = "&t=0&s=164";
	    else if (game.equals("kabala")) parameter = "&t=0&s=42";
	    else if(game.equals("kinelo")) parameter = "&t=0&s=1121";
	    else if(game.equals("tinka")) parameter = "&t=0&s=41";
	    else parameter = "&t=1&s=4";
    	try {
    		parameter = StringLib.encrypt(random+"|"+parameter+"|"+game+"|"+seed+"|"+random);
    		o.addProperty("url", url+"i.do?m=resultados&p="+Base64.encodeBase64URLSafeString(parameter.getBytes()));
		} catch (Exception e) {
			o.addProperty("url", url);
			e.printStackTrace();
		}
        out.print(o);
    }
    
    /*public static void main(String[] args) {
    	ClientBalanceController cb = new ClientBalanceController();
		cb.game_results();
	}*/
    
    @RequestMapping(value = "/detalle_ticket")
    public void ticket_detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
    	String url = ((ConnectionFactory.operationProperty("TANServerURI", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANServerURI", "CARD-WEB").trim():"");
    	String authKey = ((ConnectionFactory.operationProperty("TANauthKey", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANauthKey", "CARD-WEB").trim():"");
    	String couponId = request.getParameter("couponId"), time = "", auth = "";
       	String gameId = request.getParameter("gameId");
       	

       	
    	time = String.valueOf(new java.util.Date().getTime()/1000);
	    
       	System.out.println("----> detalle_ticket: " +" &couponId="+couponId +  " | gameId=" + gameId + " url=" + url);
       	
    	String ticketId="";
    	
    	JsonObject o = new JsonObject();
    	
    	try{
    		ClientTicketLotos5 clientTicketLotos5 = clientTicketLotos5Bo.findByCouponId(Integer.parseInt(couponId));
    		
    		if( clientTicketLotos5 != null ) {
        		o.addProperty("tan", "true");
        		ticketId = String.valueOf(clientTicketLotos5.getTicketId());
        		//ticketId = ((ConnectionFactory.operationProperty("TANTicketId", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANTicketId", "CARD-WEB").trim():"");//SE DEBE RETIRAR ESTA LINEA EN PRODUCCION!!!!!!!!!!!
        		try {
        	    	auth = DigestUtils.sha1Hex(ticketId + authKey + time);
        	    	o.addProperty("url", url+"?time="+time+"&ticket_id="+ticketId+"&auth="+auth);
            		System.out.println("---->"+url+"?time="+time+"&ticket_id="+ticketId+"&auth="+auth);
        		} catch (Exception e) {
        			o.addProperty("url", url);
        			o.addProperty("tan", "false");
        			e.printStackTrace();
        		}
        		
        	}else {
        		o.addProperty("tan", "false");
        		o.addProperty("url", "-");
        	}
    	}catch(NumberFormatException ex) {
    		o.addProperty("tan", "true");
    		ticketId = couponId;
    		//ticketId = ((ConnectionFactory.operationProperty("TANTicketId", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANTicketId", "CARD-WEB").trim():"");//SE DEBE RETIRAR ESTA LINEA EN PRODUCCION!!!!!!!!!!!
    		try {
    	    	auth = DigestUtils.sha1Hex(ticketId + authKey + time);
    	    	o.addProperty("url", url+"?time="+time+"&ticket_id="+ticketId+"&auth="+auth);
        		System.out.println("---->TA "+url+"?time="+time+"&ticket_id="+ticketId+"&auth="+auth);
    		} catch (Exception e) {
    			o.addProperty("url", url);
    			o.addProperty("tan", "false");
    			e.printStackTrace();
    		}
    	}
    	
        out.print(o);
    }
    
    @RequestMapping(value = "/detalle_ticket_tanovus")
    public void ticket_detail_tanovus(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
    	String url = ((ConnectionFactory.operationProperty("TANServerURI", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANServerURI", "CARD-WEB").trim():"");
    	String authKey = ((ConnectionFactory.operationProperty("TANauthKey", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANauthKey", "CARD-WEB").trim():"");
    	String couponId = request.getParameter("couponId"), time = "", auth = "";
       	
    	time = String.valueOf(new java.util.Date().getTime()/1000);

        String ticketId = couponId;
        
       	System.out.println("----> detalle_ticket_novus: " +" &ticketId="+ticketId +  " | authKey=" + authKey + " url=" + url);
       
    	JsonObject o = new JsonObject();
    	
    	try{

    		o.addProperty("tan", "true");
    		auth = DigestUtils.sha1Hex(ticketId + authKey + time);
	    	o.addProperty("url", url+"?time="+time+"&ticket_id="+ticketId+"&auth="+auth);
    		System.out.println("---->url_novus: "+url+"?time="+time+"&ticket_id="+ticketId+"&auth="+auth);

    	}catch(NumberFormatException e) {
    		o.addProperty("url", url);
    		o.addProperty("tan", "false");
    		e.printStackTrace();
    		
    	}
    	
        out.print(o);
    }
      
    @RequestMapping(value = "/detalle_virtuales_ticket")
    public ModelAndView detalle_virtuales_ticket(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {   
    	//GoldenTicketResponse responseData = new GoldenTicketResponse();
    	
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String ticketId = null;
        String htmlTextTemplate;  
        JsonObject jsonResponse = new JsonObject();
        String method="detalle_virtuales_ticket";
        String respuestaApiGolden ="ERROR";
        String typeGameGolden ="OTRO";
        
        LoggerApi.Log.info( method + " START ============================================================================");
        
    	try {
        	//obtener el clientid
        	ticketId= request.getParameter("couponId");	
        	//if(ticketId != null  ) {
        	//}
        	String url = Constants.GOLDEN_URL_FINDBYID; // "https://america-api.virtustec.com/api/external/v2/ticket/findById";
        	String tipo="findTicket";
        	//Realizar conexion y recibir rpta
        	respuestaApiGolden = apiGoldenUtils.sendRequestGolden(ticketId, url, tipo);
        	if( respuestaApiGolden != "ERROR" ) {	
        		//obtener tipo de juego
        		typeGameGolden = apiGoldenUtils.getCodeGame(respuestaApiGolden);
        		if(typeGameGolden !="OTRO" || !typeGameGolden.equals("OTRO")) {	
        			Object objeto = null;
            		//Realizar casteo de rpta de golden
            		Map<String, Class<?>> gameTypeMap = new HashMap<String, Class<?>>();
            		gameTypeMap.put("CH", TicketGoldenFutbol.class);
            		gameTypeMap.put("DOG", TicketGoldenDog.class);
            		gameTypeMap.put("HORSE", TicketGoldenDog.class);
            		gameTypeMap.put("DIRTTRACK", TicketGoldenDog.class);
            		gameTypeMap.put("KART", TicketGoldenDog.class);
            		gameTypeMap.put("MOTORBIKE", TicketGoldenDog.class);
            		gameTypeMap.put("MMA", TicketGoldenDog.class);
            		gameTypeMap.put("KN", TicketGoldenKinelo.class);
            		gameTypeMap.put("SN", TicketGoldenGiraGana.class);
            		gameTypeMap.put("RAINBOW", TicketGoldenColor.class);
            		gameTypeMap.put("PENALTY", TicketGoldenGiraGana.class);
            		
            		Class<?> clazz = gameTypeMap.get(typeGameGolden);
            		if (clazz != null) {
            		    objeto = clazz.getDeclaredConstructor().newInstance();
            		}
            		
            		LoggerApi.Log.info("Invocando Casteo de response");
            		htmlTextTemplate = apiGoldenUtils.castReponseGolden(objeto, respuestaApiGolden );
            		request.setAttribute("htmlText", htmlTextTemplate);
            }
        	}
        		
        } catch (Exception e) {
			// TODO: handle exception
			return new ModelAndView("client/print_coupon_golden");
        }
    	LoggerApi.Log.info( method + " END ============================================================================");

        out.print(jsonResponse);
		return new ModelAndView("client/print_coupon_golden");
    }
    
    @RequestMapping(value = "/find_lotocard")
    public void findLotocard(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START findLotocard"); 
    	String pin = "";
    	PinPrinted pinPrinted = null;
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	if (request.getParameter("pin-number") != null) {
    		pin = request.getParameter("pin-number");
    		try {
    			pinPrinted = clientSaleBo.findLotocard(pin);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	if(pinPrinted==null) {
    		o.addProperty("message", "No Existe");
    	}else {
    		o.addProperty("message", "Existe");
    		o.addProperty("amount",pinPrinted.getPinAmount());
    	}
    	out.print(o);
    }
    
	@RequestMapping(value = "/rechargeqw")
    public String recharge_form_qw(@RequestParam("marca") String marca,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        request.setAttribute("visanet_merchantlogo", baseUri+"/layer-view-image/v2/landing/img/"+marca);
        HttpSession session = request.getSession();
        session.setAttribute("WS_URL_PAGO_TOKEN_RESULT", ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_QW", Constants.contextSale));
        session.setAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT_QW", Constants.contextSale));
        return "client/recharge_form";
    }
    
	@RequestMapping(value = "/rechargei")
    public String recharge_form(@RequestParam("marca") String marca,HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String log="rechargei";
		LoggerApi.Log.info("-------------- start "+ log);
        String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();		
        request.setAttribute("visanet_merchantlogo", baseUri+"/layer-view-image/v2/landing/img/"+marca);
        HttpSession session = request.getSession();
        String clientId="";
        String operatorId="5586";
        objectModelMap.put("operatorIdApi",operatorId);
        
        UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
        try{      	
        ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
	        clientId = (user.getClientId() != null) ? user.getClientId().toString() : "0";
        }catch (Exception e) {
        	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
        	return "client/recharge_form_api";
		}
        //servicio tokenrecharge
      	JsonObject jdata = new JsonObject();
      	jdata.addProperty("operatorId", operatorId);
      	jdata.addProperty("platform", "desktop");
      	jdata.addProperty("playerId", clientId);
      	String ip=ClientUtils.getClientIp(request);
      	jdata.addProperty("playerIp", ip);
      	String iarechargeResponse=requestWSIflexApiRecharge(jdata.toString(), "tokenrecharge2");
      	JSONObject convertedObject = new JSONObject(iarechargeResponse);
      	String status = convertedObject.getString("status");
      	if(!status.equals("OK")) {
      		request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
          return "client/recharge_form_api";
      	}
      	String token=convertedObject.getString("token");
//        String operatorId=convertedObject.getString("operatorId");
		objectModelMap.put("rechargetoken",token);
		
		//Validar si cliente tiene activado limite de autoexclusion para ecommerce
		try {
			String urlAutocontrol = ConnectionFactory.operationProperty("urlAutocontrol", Constants.contextSale).trim();
			
			ClientProcedureGetSelfcontrol getSelfcontrol = clientSaleBo.getDataSelfcontrol(Integer.valueOf(clientId) );
			if(getSelfcontrol.getTypeLimit().equals("AUTOEXCLUSION") && getSelfcontrol.getValueLimit()>0 ) {
				//enviar vista autoexclusion que no permite recargas
				ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(Integer.valueOf(clientId));
				LoggerApi.Log.info("activado autoexclusion ecommerce");
				objectModelMap.put("urlAutocontrol",urlAutocontrol);
				
				userBean.setpBilletera2(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
				userBean.setpBilletera3Cant(clientProcedureAccountDataPart.getOtherAmount());
				userBean.setpMonto(clientProcedureAccountDataPart.getBalanceAmount());
				LoggerApi.Log.info("traer los saldo en ecommerce ->amount:" + clientProcedureAccountDataPart.getBalanceAmount());
				session.setAttribute(Constants.USR_SESION, userBean);
				
				
				return "client/recharge_form_autocontrol";
			}else{
				LoggerApi.Log.info("no tiene autoexclusion");
			}
			
		} catch (Exception e) {
			request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
        	return "client/recharge_form_api";
		}
		
//        session.setAttribute("WS_URL_PAGO_TOKEN_RESULT", ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT", Constants.contextSale));
//        session.setAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", Constants.contextSale));
		LoggerApi.Log.info("-------------- end "+ log);
		return "client/recharge_form_api";
    }
	
	@RequestMapping(value = "/recharge")
    public String recharge_form(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        
        String token=request.getParameter("rechargetoken");
		objectModelMap.put("rechargetoken",token);
		
        request.setAttribute("visanet_merchantlogo", baseUri+"/layer-view-image/v2/landing/img/logo-teapuesto_03_v2.png");
        /*
        HttpSession session = request.getSession();
        session.setAttribute("WS_URL_PAGO_TOKEN_RESULT", ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_TA", Constants.contextSale));
        session.setAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT_TA", Constants.contextSale));
        session.setAttribute("WS_URL_PAYMENT_CALLBACK", ConnectionFactory.operationProperty("WS_URL_PAYMENT_CALLBACK", Constants.contextSale));
        session.setAttribute("auth_key_payment_callback", ConnectionFactory.operationProperty("auth_key_payment_callback", Constants.contextSale));
        */
        
      //Validar si cliente tiene activado limite de autoexclusion para teapuesto 
        LoggerApi.Log.info("start recharge  te apuesto");
        ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
        String ip=ClientUtils.getClientIp(request);
        Integer clientId = null;
        
        HttpSession session = request.getSession();
        UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
       
        try {
        	LoggerApi.Log.info("obtener data de autocontrol RECHARGE Te Apuesto");
        	 tokenValidation = clientSaleBo.getTokenValidation(token, ip);
             LoggerApi.Log.info("result de tokenValidation:" + tokenValidation.toString()); 
             if ((tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Show")) || (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated"))) {
            	objectModelMap.put("rechargetoken",tokenValidation.getRechargeToken());
     			clientId =Integer.parseInt( tokenValidation.getClientId());
     			LoggerApi.Log.info("clientId:" + clientId);
 				String urlAutocontrol = ConnectionFactory.operationProperty("urlAutocontrol", Constants.contextSale).trim();
 				ClientProcedureGetSelfcontrol getSelfcontrol = clientSaleBo.getDataSelfcontrol(clientId);
 				if (getSelfcontrol.getTypeLimit().equals("AUTOEXCLUSION") && getSelfcontrol.getValueLimit() > 0) {
 					// enviar vista que no muestre btns de recarga
 					LoggerApi.Log.info("activado autoexclusion en te apuesto");
 					objectModelMap.put("urlAutocontrol", urlAutocontrol);
 					objectModelMap.put("operatorIdApi", tokenValidation.getOperatorId());
 					
 					
 					ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(clientId);
 					LoggerApi.Log.info("traer los saldo en teapuesto ->amount:" + clientProcedureAccountDataPart.getBalanceAmount());
		
 					objectModelMap.put("pMontoRecharga", clientProcedureAccountDataPart.getBalanceAmount() );
 					objectModelMap.put("pBilletera2Recarga", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))) );
 					objectModelMap.put("pBilletera3CantRecarga", clientProcedureAccountDataPart.getOtherAmount() );
 					
 					return "client/recharge_form_autocontrol";
 				}
     		}	
		} catch (Exception e) {
			request.setAttribute(WebConsts.ALERT_MSG,"Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
			return "client/recharge_form_api";
		}
        
        return "client/recharge_form_api";
    }
	
	@RequestMapping(value = "/send-code-promotional-validation")
    public void codePromotionalValidation(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START sendCodePromotionalValidation"); 
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	PinPrinted pinPrinted = null;
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        try {
        	String ip = request.getRemoteAddr();
        	String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
        	Double amount = (request.getParameter("amount")!=null)?Double.parseDouble(request.getParameter("amount").toString().trim()):0;
        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";
        	ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constants.CLT_SESSION);
        	String clientId= (user.getClientId()!=null)?user.getClientId().toString():"0";
        	
        	
        	LoggerApi.Log.info("codePromotional="+codePromotional + " amount="+amount + " clientId="+clientId);
        	
        	if(amount <= 0 && !channel.equals("IBK")) {
        		o.addProperty("status", "DES");
    			o.addProperty("message", "El monto no debe ser diferente de vacio o cero");
    			return;
        	}
        	
        	if(!lotocard.trim().isEmpty()) {
        		pinPrinted = clientSaleBo.findLotocard(lotocard);
        		if(pinPrinted!=null) {
        			amount = pinPrinted.getPinAmount();
        		}else {
        			o.addProperty("status", "DES");
        			o.addProperty("message", "C&oacute;digo lotocard no existe");
        			return;
        		}
        	}
        	
        	Object[] values = new Object[6];
        	values[0] = codePromotional;
        	values[1] = clientId;
        	values[2] = channel;
        	values[3] = "desktop";
        	values[4] = amount;
        	values[5] = ip;
        	
        	ClientProcedureCodeValidation clientProcedureCodeValidation = clientSaleBo.codePromotionalValidation(values);
        	if(clientProcedureCodeValidation!=null) {
        		o.addProperty("status", clientProcedureCodeValidation.getState());
    			o.addProperty("message", clientProcedureCodeValidation.getMessage());
    			o.addProperty("idCode", clientProcedureCodeValidation.getIdCodePromotional());
        	}else {
        		o.addProperty("status", 500);
    			o.addProperty("message", "Incidente inesperado");
        	}
        }catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/sendCodePromotionalValidation "+o.toString());
		}
        LoggerApi.Log.info("-------------- END sendCodePromotionalValidation");
	}
	
	@RequestMapping(value = "/yapePlinVerifyTransaction")
    public void yapePlinVerifyTransaction(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			response.setCharacterEncoding(Constants.CHARSET_UTF8);
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	        
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
				&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();		
				String channel = request.getParameter("channel");
				
				ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction = clientSaleBo.yapePlinVerifyTransaction(idClient, channel);
				if(yapePlinVerifyTransaction!=null && yapePlinVerifyTransaction.getStatus().trim().equals("ACT")) {
					ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(idClient);
					o.addProperty("status", "ACT");
					o.addProperty("billetera1", clientProcedureAccountDataPart.getBalanceAmount());
					o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
					o.addProperty("billetera3", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("billetera3Cant", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("amount", yapePlinVerifyTransaction.getAmount());
					
					if(yapePlinVerifyTransaction.getPromotionMessage()!=null || yapePlinVerifyTransaction.getPromotionEco()!=null) {
						String promotionMessage = yapePlinVerifyTransaction.getPromotionMessage();
						if (promotionMessage.equals("OK")) {
							String promotionEco = yapePlinVerifyTransaction.getPromotionEco();
							o.addProperty("promotionMessage", promotionEco);
						} else {
							o.addProperty("promotionMessage", promotionMessage);
						}
					}
				}else{
					String mensaje = "";
					if(channel.trim().equals("YAPE")) {
						mensaje="Aún no se ha realizado el pago de tu código QR YAPE";
					}else if(channel.trim().equals("PLIN")) {
						mensaje="Aún no se ha realizado el pago de tu código QR PLIN";
					}else if(channel.trim().equals("PEFE")) {
						mensaje="Aún no se ha realizado el pago de tu código PagoEfectivo";
					}				
					o.addProperty("status", "PEN");
					o.addProperty("message", mensaje);
				}
			}else {
				o.addProperty("status", "ERROR");
				o.addProperty("message", "debe autenticarse");
			}
			out.print(o);
		} catch (Exception e) {
            LoggerApi.severe(e);
        } 
	}
			
	@RequestMapping(value = "/yapePlinVerifyTransactionAPI")
    public void yapePlinVerifyTransactionAPI(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String log="yapePlinVerifyTransactionAPI";
		LoggerApi.Log.info("-------------- start "+log);
		JsonObject o = new JsonObject();
		try {			
			response.setCharacterEncoding(Constants.CHARSET_UTF8);
			PrintWriter out = response.getWriter();	        
	        String rechargetoken=request.getHeader("rechargetoken");
	        String ip=ClientUtils.getClientIp(request);
	        
	        //Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
	        
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				Integer idClient = Integer.parseInt(tokenValidation.getClientId());	
				String channel = request.getParameter("channel");
				
				ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction = clientSaleBo.yapePlinVerifyTransaction(idClient, channel);
				if(yapePlinVerifyTransaction!=null && yapePlinVerifyTransaction.getStatus().trim().equals("ACT")) {
					ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(idClient);
					o.addProperty("status", "ACT");
					o.addProperty("billetera1", clientProcedureAccountDataPart.getBalanceAmount());
					o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
					o.addProperty("billetera3", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("billetera3Cant", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("amount", yapePlinVerifyTransaction.getAmount());
					
					if(yapePlinVerifyTransaction.getPromotionMessage()!=null || yapePlinVerifyTransaction.getPromotionEco()!=null) {
						String promotionMessage = yapePlinVerifyTransaction.getPromotionMessage();
						if (promotionMessage.equals("OK")) {
							String promotionEco = yapePlinVerifyTransaction.getPromotionEco();
							o.addProperty("promotionMessage", promotionEco);
						} else {
							o.addProperty("promotionMessage", promotionMessage);
						}
					}
				}else{
					String mensaje = "";
					if(channel.trim().equals("YAPE")) {
						mensaje="Aún no se ha realizado el pago de tu código QR YAPE";
					}else if(channel.trim().equals("PLIN")) {
						mensaje="Aún no se ha realizado el pago de tu código QR PLIN";
					}else if(channel.trim().equals("PEFE")) {
						mensaje="Aún no se ha realizado el pago de tu código PagoEfectivo";
					}				
					o.addProperty("status", "PEN");
					o.addProperty("message", mensaje);
				}
			}else {
				if(tokenValidation.getStatus().equals("TIMEOUTTR")) {
					o.addProperty("status", tokenValidation.getStatus());
				}else {
					o.addProperty("status", "ERROR");
					o.addProperty("message", "debe autenticarse");
				}
				
			}
			out.print(o);
		} catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        	LoggerApi.Log.info("-------------- end "+log);
		}
	}
	
	@RequestMapping(value = "/load_recharge_api")
	public void loadRechargeAPI(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		String log="loadRechargeAPI";
		LoggerApi.Log.info("-------------- start "+log);
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		try {
			response.setCharacterEncoding(Constants.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			//parametro que debe enviar TA
			String rechargetoken=request.getHeader("rechargetoken");			
			String ip=ClientUtils.getClientIp(request);
			String rstatus=(request.getParameter("rstatus")!=null)?request.getParameter("rstatus"):"";
			
			if (rechargetoken != null && !rechargetoken.equals("")) {
				// Validación de token
				tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
				LoggerApi.Log.info("tokenValidation de teapuesto ->" + tokenValidation.toString());
				if ((tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Show")) ||(tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated"))) {
					o.addProperty("status", tokenValidation.getStatus());
					o.addProperty("rechargetoken", tokenValidation.getRechargeToken());
					o.addProperty("operatorIdApi", tokenValidation.getOperatorId());
					
					Integer idClient = Integer.parseInt(tokenValidation.getClientId());
					
					ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(idClient);
					o.addProperty("billetera1", clientProcedureAccountDataPart.getBalanceAmount());
					o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
					o.addProperty("billetera3", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("billetera3Cant", clientProcedureAccountDataPart.getOtherAmount());
					String maximoCodigosBCP = ((ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale) != null)?ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale).trim():"3");
					o.addProperty("maximoCodigosBCP", maximoCodigosBCP);
					o.addProperty("amtMinRechargeAgr", clientProcedureAccountDataPart.getAmtMinRechargeAgr());
					o.addProperty("amtMaxRechargeAgr", clientProcedureAccountDataPart.getAmtMaxRechargeAgr());
					o.addProperty("stateRechargeAgr", clientProcedureAccountDataPart.getStateRechargeAgr());

					o.addProperty("amtMinRechargeVisa", clientProcedureAccountDataPart.getAmtMinRechargeVisa());
					o.addProperty("amtMaxRechargeVisa", clientProcedureAccountDataPart.getAmtMaxRechargeVisa());
					o.addProperty("comMinRan1Visa", clientProcedureAccountDataPart.getComMinRan1Visa());
					o.addProperty("comMaxRan1Visa", clientProcedureAccountDataPart.getComMaxRan1Visa());
					o.addProperty("comAmtRan1Visa", clientProcedureAccountDataPart.getComAmtRan1Visa());
					o.addProperty("comMinRan2Visa", clientProcedureAccountDataPart.getComMinRan2Visa());
					o.addProperty("comMaxRan2Visa", clientProcedureAccountDataPart.getComMaxRan2Visa());
					o.addProperty("comAmtRan2Visa", clientProcedureAccountDataPart.getComAmtRan2Visa());
					o.addProperty("comMinRan3Visa", clientProcedureAccountDataPart.getComMinRan3Visa());
					o.addProperty("comMaxRan3Visa", clientProcedureAccountDataPart.getComMaxRan3Visa());
					o.addProperty("comAmtRan3Visa", clientProcedureAccountDataPart.getComAmtRan3Visa());
					o.addProperty("comMinRan4Visa", clientProcedureAccountDataPart.getComMinRan4Visa());
					o.addProperty("comMaxRan4Visa", clientProcedureAccountDataPart.getComMaxRan4Visa());
					o.addProperty("comAmtRan4Visa", clientProcedureAccountDataPart.getComAmtRan4Visa());
					o.addProperty("comMinRan1Agr", clientProcedureAccountDataPart.getComMinRan1Agr());
					o.addProperty("comMaxRan1Agr", clientProcedureAccountDataPart.getComMaxRan1Agr());
					o.addProperty("comAmtRan1Agr", clientProcedureAccountDataPart.getComAmtRan1Agr());
					o.addProperty("comMinRan2Agr", clientProcedureAccountDataPart.getComMinRan2Agr());
					o.addProperty("comMaxRan2Agr", clientProcedureAccountDataPart.getComMaxRan2Agr());
					o.addProperty("comAmtRan2Agr", clientProcedureAccountDataPart.getComAmtRan2Agr());
					o.addProperty("comMinRan3Agr", clientProcedureAccountDataPart.getComMinRan3Agr());
					o.addProperty("comMaxRan3Agr", clientProcedureAccountDataPart.getComMaxRan3Agr());
					o.addProperty("comAmtRan3Agr", clientProcedureAccountDataPart.getComAmtRan3Agr());
					o.addProperty("comMinRan4Agr", clientProcedureAccountDataPart.getComMinRan4Agr());
					o.addProperty("comMaxRan4Agr", clientProcedureAccountDataPart.getComMaxRan4Agr());
					o.addProperty("comAmtRan4Agr", clientProcedureAccountDataPart.getComAmtRan4Agr());				
					o.addProperty("msjComVisa", clientProcedureAccountDataPart.getMsjComVisa());
					o.addProperty("msjComAgr", clientProcedureAccountDataPart.getMsjComAgr());
					o.addProperty("rechargeAgora", clientProcedureAccountDataPart.getRechargeAgora());
					o.addProperty("mobilePhone", clientProcedureAccountDataPart.getMobilePhone());
					o.addProperty("amtMinRechargeBcp", clientProcedureAccountDataPart.getAmtMinRechargeBcp());
					o.addProperty("amtMaxRechargeBcp", clientProcedureAccountDataPart.getAmtMaxRechargeBcp());
					o.addProperty("maxRechargePerDayVisa", clientProcedureAccountDataPart.getMaxRechargePerDayVisa());
					o.addProperty("maxAmtPerWeekVisa", clientProcedureAccountDataPart.getMaxAmtPerWeekVisa());

					o.addProperty("stateRechargeVisa", clientProcedureAccountDataPart.getStateRechargeVisa());
					o.addProperty("stateRechargeBcp", clientProcedureAccountDataPart.getStateRechargeBcp());
					o.addProperty("stateRechargeLoto", clientProcedureAccountDataPart.getStateRechargeLoto());
					o.addProperty("stateRechargeIbk", clientProcedureAccountDataPart.getStateRechargeIbk());
					o.addProperty("amtMinRechargeIbk", clientProcedureAccountDataPart.getAmtMinRechargeIbk());
					o.addProperty("amtMaxRechargeIbk", clientProcedureAccountDataPart.getAmtMaxRechargeIbk());
					o.addProperty("stateRechargePefe", clientProcedureAccountDataPart.getStateRechargePefe());
					o.addProperty("amtMinRechargePefe", clientProcedureAccountDataPart.getAmtMinRechargePefe());
					o.addProperty("amtMaxRechargePefe", clientProcedureAccountDataPart.getAmtMaxRechargePefe());
					o.addProperty("stateRechargeSpay", clientProcedureAccountDataPart.getStateRechargeSpay());
					o.addProperty("amtMinRechargeSpay", clientProcedureAccountDataPart.getAmtMinRechargeSpay());
					o.addProperty("amtMaxRechargeSpay", clientProcedureAccountDataPart.getAmtMaxRechargeSpay());
					
					o.addProperty("stateRechargeYape", clientProcedureAccountDataPart.getStateRechargeYape());
					o.addProperty("amtMinRechargeYape", clientProcedureAccountDataPart.getAmtMinRechargeYape());
					o.addProperty("amtMaxRechargeYape", clientProcedureAccountDataPart.getAmtMaxRechargeYape());
					o.addProperty("stateRechargePlin", clientProcedureAccountDataPart.getStateRechargePlin());
					o.addProperty("amtMinRechargePlin", clientProcedureAccountDataPart.getAmtMinRechargePlin());
					o.addProperty("amtMaxRechargePlin", clientProcedureAccountDataPart.getAmtMaxRechargePlin());
					
					o.addProperty("stateRechargeBbva", clientProcedureAccountDataPart.getStateRechargeBbva());
					o.addProperty("amtMinRechargeBbva", clientProcedureAccountDataPart.getAmtMinRechargeBbva());
					o.addProperty("amtMaxRechargeBbva", clientProcedureAccountDataPart.getAmtMaxRechargeBbva());
					String maximoCodigosBBVA = ((ConnectionFactory.operationProperty("maximoCodigosBBVA", Constants.contextSale) != null)? ConnectionFactory.operationProperty("maximoCodigosBBVA", Constants.contextSale).trim(): "3");
					o.addProperty("maximoCodigosBBVA", maximoCodigosBBVA);				
					o.addProperty("stateRechargeIzi", clientProcedureAccountDataPart.getStateRechargeIzi());
					o.addProperty("amtMinRechargeIzi", clientProcedureAccountDataPart.getAmtMinRechargeIzi());
					o.addProperty("amtMaxRechargeIzi", clientProcedureAccountDataPart.getAmtMaxRechargeIzi());
					
					o.addProperty("docTypeIzi", clientProcedureAccountDataPart.getDocTypeIzi());
					o.addProperty("docNumber", clientProcedureAccountDataPart.getDocNumber());
					o.addProperty("nombre", clientProcedureAccountDataPart.getNombre());
					o.addProperty("apellidos", clientProcedureAccountDataPart.getApellidos());
					o.addProperty("cid", tokenValidation.getClientId());
					o.addProperty("stateRechargePlinTupay", clientProcedureAccountDataPart.getStateRechargePlinTupay());
					o.addProperty("amtMinRechargePlinTupay", clientProcedureAccountDataPart.getAmtMinRechargePlinTupay());
					o.addProperty("amtMaxRechargePlinTupay", clientProcedureAccountDataPart.getAmtMaxRechargePlinTupay());
					o.addProperty("stateRechargeYapeTupay", clientProcedureAccountDataPart.getStateRechargeYapeTupay());
					o.addProperty("amtMinRechargeYapeTupay", clientProcedureAccountDataPart.getAmtMinRechargeYapeTupay());
					o.addProperty("amtMaxRechargeYapeTupay", clientProcedureAccountDataPart.getAmtMaxRechargeYapeTupay());
				}
				
				o.addProperty("message", tokenValidation.getMessage());
				
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			LoggerApi.Log.info("-------------- end "+log+" tokenValidation=" +tokenValidation);
		}
	}
	
    @RequestMapping(value = "/load_recharge")
    public void loadRecharge(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			response.setCharacterEncoding(Constants.CHARSET_UTF8);
			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
			PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
				&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
				
				/*
				ClientProcedureAccountData clientProcedureAccountData=null;
				clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
				userBean.setpBilletera2(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getBonusAmount().replaceAll(",","."))));
				userBean.setpBilletera3(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getOtherAmount().replaceAll(",","."))));
				userBean.setpBilletera3Cant(clientProcedureAccountData.getOtherQuantity());
				userBean.setpMonto(clientProcedureAccountData.getBalanceAmount());
				session.setAttribute(Constants.USR_SESION, userBean);
				o.addProperty("billetera1", clientProcedureAccountData.getBalanceAmount());
				o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getBonusAmount().replaceAll(",","."))));
				o.addProperty("billetera3", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getOtherAmount().replaceAll(",","."))));
				o.addProperty("billetera3Cant", clientProcedureAccountData.getOtherQuantity());
				String maximoCodigosBCP = ((ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale) != null)?ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale).trim():"3");
				o.addProperty("maximoCodigosBCP", maximoCodigosBCP);
				*/
				
				ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(idClient);
				o.addProperty("billetera1", clientProcedureAccountDataPart.getBalanceAmount());
				o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
				o.addProperty("billetera3", clientProcedureAccountDataPart.getOtherAmount());
				o.addProperty("billetera3Cant", clientProcedureAccountDataPart.getOtherAmount());
				String maximoCodigosBCP = ((ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale) != null)?ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale).trim():"3");
				o.addProperty("maximoCodigosBCP", maximoCodigosBCP);
				o.addProperty("amtMinRechargeAgr", clientProcedureAccountDataPart.getAmtMinRechargeAgr());
				o.addProperty("amtMaxRechargeAgr", clientProcedureAccountDataPart.getAmtMaxRechargeAgr());
				o.addProperty("stateRechargeAgr", clientProcedureAccountDataPart.getStateRechargeAgr());
				
				o.addProperty("amtMinRechargeVisa", clientProcedureAccountDataPart.getAmtMinRechargeVisa());
				o.addProperty("amtMaxRechargeVisa", clientProcedureAccountDataPart.getAmtMaxRechargeVisa());
				o.addProperty("comMinRan1Visa", clientProcedureAccountDataPart.getComMinRan1Visa());
				o.addProperty("comMaxRan1Visa", clientProcedureAccountDataPart.getComMaxRan1Visa());
				o.addProperty("comAmtRan1Visa", clientProcedureAccountDataPart.getComAmtRan1Visa());
				o.addProperty("comMinRan2Visa", clientProcedureAccountDataPart.getComMinRan2Visa());
				o.addProperty("comMaxRan2Visa", clientProcedureAccountDataPart.getComMaxRan2Visa());
				o.addProperty("comAmtRan2Visa", clientProcedureAccountDataPart.getComAmtRan2Visa());
				o.addProperty("comMinRan3Visa", clientProcedureAccountDataPart.getComMinRan3Visa());
				o.addProperty("comMaxRan3Visa", clientProcedureAccountDataPart.getComMaxRan3Visa());
				o.addProperty("comAmtRan3Visa", clientProcedureAccountDataPart.getComAmtRan3Visa());
				o.addProperty("comMinRan4Visa", clientProcedureAccountDataPart.getComMinRan4Visa());
				o.addProperty("comMaxRan4Visa", clientProcedureAccountDataPart.getComMaxRan4Visa());
				o.addProperty("comAmtRan4Visa", clientProcedureAccountDataPart.getComAmtRan4Visa());
				o.addProperty("comMinRan1Agr", clientProcedureAccountDataPart.getComMinRan1Agr());
				o.addProperty("comMaxRan1Agr", clientProcedureAccountDataPart.getComMaxRan1Agr());
				o.addProperty("comAmtRan1Agr", clientProcedureAccountDataPart.getComAmtRan1Agr());
				o.addProperty("comMinRan2Agr", clientProcedureAccountDataPart.getComMinRan2Agr());
				o.addProperty("comMaxRan2Agr", clientProcedureAccountDataPart.getComMaxRan2Agr());
				o.addProperty("comAmtRan2Agr", clientProcedureAccountDataPart.getComAmtRan2Agr());
				o.addProperty("comMinRan3Agr", clientProcedureAccountDataPart.getComMinRan3Agr());
				o.addProperty("comMaxRan3Agr", clientProcedureAccountDataPart.getComMaxRan3Agr());
				o.addProperty("comAmtRan3Agr", clientProcedureAccountDataPart.getComAmtRan3Agr());
				o.addProperty("comMinRan4Agr", clientProcedureAccountDataPart.getComMinRan4Agr());
				o.addProperty("comMaxRan4Agr", clientProcedureAccountDataPart.getComMaxRan4Agr());
				o.addProperty("comAmtRan4Agr", clientProcedureAccountDataPart.getComAmtRan4Agr());				
				o.addProperty("msjComVisa", clientProcedureAccountDataPart.getMsjComVisa());
				o.addProperty("msjComAgr", clientProcedureAccountDataPart.getMsjComAgr());
				o.addProperty("rechargeAgora", clientProcedureAccountDataPart.getRechargeAgora());
				o.addProperty("mobilePhone", clientProcedureAccountDataPart.getMobilePhone());
				o.addProperty("amtMinRechargeBcp", clientProcedureAccountDataPart.getAmtMinRechargeBcp());
				o.addProperty("amtMaxRechargeBcp", clientProcedureAccountDataPart.getAmtMaxRechargeBcp());
				o.addProperty("maxRechargePerDayVisa", clientProcedureAccountDataPart.getMaxRechargePerDayVisa());
				o.addProperty("maxAmtPerWeekVisa", clientProcedureAccountDataPart.getMaxAmtPerWeekVisa());
				
				o.addProperty("stateRechargeVisa", clientProcedureAccountDataPart.getStateRechargeVisa());
				o.addProperty("stateRechargeBcp", clientProcedureAccountDataPart.getStateRechargeBcp());
				o.addProperty("stateRechargeLoto", clientProcedureAccountDataPart.getStateRechargeLoto());
				o.addProperty("stateRechargeIbk", clientProcedureAccountDataPart.getStateRechargeIbk());
				o.addProperty("amtMinRechargeIbk", clientProcedureAccountDataPart.getAmtMinRechargeIbk());
				o.addProperty("amtMaxRechargeIbk", clientProcedureAccountDataPart.getAmtMaxRechargeIbk());
				o.addProperty("stateRechargePefe", clientProcedureAccountDataPart.getStateRechargePefe());
				o.addProperty("amtMinRechargePefe", clientProcedureAccountDataPart.getAmtMinRechargePefe());
				o.addProperty("amtMaxRechargePefe", clientProcedureAccountDataPart.getAmtMaxRechargePefe());
				o.addProperty("stateRechargeSpay", clientProcedureAccountDataPart.getStateRechargeSpay());
				o.addProperty("amtMinRechargeSpay", clientProcedureAccountDataPart.getAmtMinRechargeSpay());
				o.addProperty("amtMaxRechargeSpay", clientProcedureAccountDataPart.getAmtMaxRechargeSpay());
				
				o.addProperty("stateRechargeYape", clientProcedureAccountDataPart.getStateRechargeYape());
				o.addProperty("amtMinRechargeYape", clientProcedureAccountDataPart.getAmtMinRechargeYape());
				o.addProperty("amtMaxRechargeYape", clientProcedureAccountDataPart.getAmtMaxRechargeYape());
				o.addProperty("stateRechargePlin", clientProcedureAccountDataPart.getStateRechargePlin());
				o.addProperty("amtMinRechargePlin", clientProcedureAccountDataPart.getAmtMinRechargePlin());
				o.addProperty("amtMaxRechargePlin", clientProcedureAccountDataPart.getAmtMaxRechargePlin());
				
				session.setAttribute("accountDataPart", clientProcedureAccountDataPart);
				
				userBean.setpBilletera2(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
				userBean.setpBilletera3(clientProcedureAccountDataPart.getOtherAmount());
				userBean.setpBilletera3Cant(clientProcedureAccountDataPart.getOtherAmount());
				userBean.setpMonto(clientProcedureAccountDataPart.getBalanceAmount());
				session.setAttribute(Constants.USR_SESION, userBean);
				
			}
			out.print(o);
		} catch (Exception e) {
            LoggerApi.severe(e);
        } 
	}
    
    @RequestMapping(value = "/get_data")
    public void getData(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	Integer isDataComplete = 1;
		try {
			HttpSession session = request.getSession();
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
				&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
				Integer idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
				ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(idClient);
				ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
				o.addProperty("status", "OK");
				
				if(dataClient.getNombre() == null || dataClient.getApPaterno() == null || dataClient.getTypeId() == null || dataClient.getNumberId() == null  || 
 				   dataClient.getBirthDate() == null || dataClient.getUser() == null || dataClient.getMail() == null || dataClient.getMobilePhone() == null ||
  				  dataClient.getPpe() == null)
 					isDataComplete = 0;
            	
            	o.addProperty("isDataComplete", isDataComplete);
				o.addProperty("cid", idClient);
//				o.addProperty("username", clientProcedureAccountDataPart.getClientUser());
				String name=dataClient.getNombre();
				//Dar formato al nombre del cliente
				if(name!=null && !name.trim().equals("")) {
					//Primer nombre del cliente
					name=name.split(" ")[0];					
					//Capitalize
					name=name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();					
				}
				o.addProperty("name", name);
				o.addProperty("billetera1", clientProcedureAccountDataPart.getBalanceAmount());
				o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
				o.addProperty("billetera3", clientProcedureAccountDataPart.getOtherAmount());
				String maximoCodigosBCP = ((ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale) != null)?ConnectionFactory.operationProperty("maximoCodigosBCP", Constants.contextSale).trim():"3");
				o.addProperty("maximoCodigosBCP", maximoCodigosBCP);
				o.addProperty("amtMinRechargeAgr", clientProcedureAccountDataPart.getAmtMinRechargeAgr());
				o.addProperty("amtMaxRechargeAgr", clientProcedureAccountDataPart.getAmtMaxRechargeAgr());
				o.addProperty("stateRechargeAgr", clientProcedureAccountDataPart.getStateRechargeAgr());
			}else {
				o.addProperty("status", "ERROR");
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
            LoggerApi.severe(e);
        } 
	}
    
    @RequestMapping(value = "/pagoTokenForm")
    public void pagoTokenForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String transactionToken = request.getParameter("transactionToken");
    	String sk = request.getParameter("sk");
    	String email = request.getParameter("email");
    	String channel = request.getParameter("channel");
    	
    	String url_pago = ConnectionFactory.operationProperty("url_ws_pago", "sale");
    	try {
			
            LoggerApi.Log.info("url_pago "+ url_pago);
			
			URL url = new URL(url_pago);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			PagoParameters param = new PagoParameters();
			param.setTransactionToken(transactionToken);
			param.setSessionKey(sk);
			param.setEmail(email);
			param.setChannel(channel);
			
			Gson gson = new Gson();
			String json = gson.toJson(param);
	        PrintWriter out = response.getWriter();
			
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF-8"));

			String output;
			while ((output = br.readLine()) != null) {
				break;
			}
			conn.disconnect();
			
			//Resultado
			//PagoResult jsonButtonForm = gson.fromJson(output, PagoResult.class);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = "/pagoTokenFormResult")
    public void pagoTokenFormResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="pagoTokenFormResult";
    	LoggerApi.Log.info("----- start "+log);
    	String transactionToken = request.getParameter("transactionToken");
    	String sk = request.getParameter("sk");
    	String email = request.getParameter("email");
    	String channel = request.getParameter("channel");
    	String actbono = request.getParameter("actbono");
    	String actwbbono = request.getParameter("actwbbono");
    	String monto = request.getParameter("monto");
    	String url_pago = ConnectionFactory.operationProperty("url_ws_pago", "sale");
    	String rechargetoken = request.getParameter("rechargetoken");
    	String ip=ClientUtils.getClientIp(request);
    	String origin=request.getHeader("Origin");
		boolean redirect=false;
		if(!(origin.equals("https://www.latinka.com.pe") || origin.equals("https://m.latinka.com.pe") || 
				origin.equals("https://www.teapuesto.pe") || origin.equals("https://mobile.teapuesto.pe") ||
				origin.equals("https://www.lapollateapuesto.pe") || 
				origin.equals("http://polla-web-tinka.s3-website-sa-east-1.amazonaws.com") ||
				origin.equals("https://www.uat.teapuestobet.com") || origin.equals("https://mobile.uat.teapuestobet.com") ||
				origin.equals("http://190.12.81.36") || origin.equals("http://www.desarrollo.intralotvirtual.com.pe") || 
				origin.equals("http://localhost:8080")  || origin.equals("https://uat-3vbyhz.latinka.com.pe")
				)) {
			redirect=true;
		}

        LoggerApi.Log.info("START pagoTokenFormResult transactionToken="+ transactionToken+" sk="+sk+" email="+email+" channel="+channel+" actbono="+actbono
        		+" actwbbono="+actwbbono+" monto="+monto+" url_pago="+url_pago);
        
    	try {
			
			URL url = new URL(url_pago);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			PagoParameters param = new PagoParameters();
			param.setTransactionToken(transactionToken);
			param.setSessionKey(sk);
			param.setEmail(email);
			param.setChannel(channel);
			
			Gson gson = new Gson();
			String json = gson.toJson(param);
			
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				LoggerApi.Log.info("getResponseCode="+ conn.getResponseCode());
			}
			conn.disconnect();
			
//			HttpSession session = request.getSession();
//			UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
	        LoggerApi.Log.info("request.getLocalAddr()="+ request.getLocalAddr());
//	        LoggerApi.Log.info("userBean="+ userBean);
	      //Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			Integer clientId=0;
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}
			String jsonString = callWsRecargaResult(request.getLocalAddr(), sk, clientId);
			
			JSONObject jsonObject = new JSONObject(jsonString);
			jsonObject.put("actbono", actbono);
			jsonObject.put("actwbbono", actwbbono);
						
			double comision = 0.0;
			try {
				comision = jsonObject.getDouble("commissionAmount");
			} catch (Exception e) {
				
			}
			monto = (Double.parseDouble(monto)-comision)+"";
			jsonObject.put("monto", ClientUtils.formatCurrency(Double.parseDouble(monto)).replace("S", "").replace("/", "") );
			
			if(actbono.contains("true-casino") || actbono.equalsIgnoreCase("true") || actwbbono.equalsIgnoreCase("true")) {
        		String balanceItem = jsonObject.getString("balanceItem");
        		if(!balanceItem.equals("0")) {
        			 PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(clientId, Integer.parseInt(balanceItem));
        			 LoggerApi.Log.info("promoFistAccount="+ promoFistAccount);
                     if (promoFistAccount != null) {
                    	 String promotionMessage = promoFistAccount.getPromotion_message();
                    	 LoggerApi.Log.info("promotionMessage0="+ promotionMessage);
                         if (promotionMessage.equals("OK")) {
                        	 String promotionEco = promoFistAccount.getPromotion_eco();
                        	 jsonObject.put("promotionMessage", promotionEco);
                         } else {
                        	 jsonObject.put("promotionMessage", promotionMessage);
                         }                         
                     }
        		}
        	}
			jsonString = jsonObject.toString();
			HttpSession session = request.getSession();
			session.setAttribute("visanetTransaction", jsonString);
//			response.sendRedirect(ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", Constants.contextSale));
			if(redirect) {
				response.sendRedirect(ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", Constants.contextSale));
			}else {
				response.sendRedirect("white.html");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//	        LoggerApi.Log.info("END pagoTokenFormResult transactionToken="+ transactionToken+" email="+email);
	        LoggerApi.Log.info("----- end "+log+" transactionToken="+ transactionToken+" email="+email);
		}
    }
    
    @RequestMapping(value = "/pagoTokenFormResultTA")
    public void pagoTokenFormResultTA(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="pagoTokenFormResultTA";
    	LoggerApi.Log.info("------------- start "+log);
    	String transactionToken = request.getParameter("transactionToken");
    	String sk = request.getParameter("sk");
    	String email = request.getParameter("email");
    	String channel = request.getParameter("channel");
    	String actbono = request.getParameter("actbono");
    	String actwbbono = request.getParameter("actwbbono");
    	String monto = request.getParameter("monto");
    	String url_pago = ConnectionFactory.operationProperty("url_ws_pago", "sale");
    	String rechargetoken = request.getParameter("rechargetoken");
    	String ip=ClientUtils.getClientIp(request);
    	String origin=request.getHeader("Origin");
		boolean redirect=false;
		if(!(origin.equals("https://www.latinka.com.pe") || origin.equals("https://m.latinka.com.pe") || 
				origin.equals("https://www.teapuesto.pe") || origin.equals("https://mobile.teapuesto.pe") ||
				origin.equals("https://www.lapollateapuesto.pe") || 
				origin.equals("http://polla-web-tinka.s3-website-sa-east-1.amazonaws.com") ||
				origin.equals("https://www.uat.teapuestobet.com") || origin.equals("https://mobile.uat.teapuestobet.com") ||
				origin.equals("http://190.12.81.36") || origin.equals("http://www.desarrollo.intralotvirtual.com.pe") || 
				origin.equals("http://localhost:8080") 
				)) {
			redirect=true;
		}
    	try {
			
			URL url = new URL(url_pago);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			PagoParameters param = new PagoParameters();
			param.setTransactionToken(transactionToken);
			param.setSessionKey(sk);
			param.setEmail(email);
			param.setChannel(channel);
			
			Gson gson = new Gson();
			String json = gson.toJson(param);
			
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

			}
			conn.disconnect();
			
			//HttpSession session = request.getSession();
			//UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
			
			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			Integer clientId=0;
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}
			
			String jsonString = callWsRecargaResult(request.getLocalAddr(), sk, clientId);
			
			JSONObject jsonObject = new JSONObject(jsonString);
			jsonObject.put("actbono", actbono);
			jsonObject.put("actwbbono", actwbbono);
			jsonObject.put("monto", monto);
			String promotionMessage = "";
			if(actbono.contains("true-casino") || actbono.equalsIgnoreCase("true") || actwbbono.equalsIgnoreCase("true")) {
        		String balanceItem = jsonObject.getString("balanceItem");
        		if(!balanceItem.equals("0")) {
        			 PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(clientId, Integer.parseInt(balanceItem));
                     if (promoFistAccount != null) {
                         promotionMessage = promoFistAccount.getPromotion_message();
                         if (promotionMessage.equals("OK")) {
                        	 String promotionEco = promoFistAccount.getPromotion_eco();
                        	 promotionMessage = promotionEco;
                        	 jsonObject.put("promotionMessage", promotionEco);
                         } else {
                        	 jsonObject.put("promotionMessage", promotionMessage);
                         }                         
                     }
        		}
        	}

			String time = String.valueOf(new java.util.Date().getTime() / 1000);
			String auth = DigestUtils.sha1Hex(clientId +  ConnectionFactory.operationProperty("auth_key_payment_callback", Constants.contextSale) + time);
			String content = "";

			String resultKey = jsonObject.getString("resultKey");
			String resultMessage = jsonObject.getString("resultMessage");

			if (resultKey.equals("OK")) {
				double comision = 0.0;
				try {
					comision = jsonObject.getDouble("commissionAmount");
				} catch (Exception e) {
					
				}
				monto = (Double.parseDouble(monto)-comision)+"";
				
				String[] arrayResultMessage = resultMessage.split("\\|");
				String rptaTransaccion = "";
				rptaTransaccion += "<br>Nº Transacción:" + arrayResultMessage[2];
				rptaTransaccion += "<br>Visa:" + arrayResultMessage[4];
				rptaTransaccion += "<br>" + arrayResultMessage[3];
				if(comision>0) {
					rptaTransaccion+="<br>Comisión por recarga con Tarjeta Visa: "+ClientUtils.formatCurrency(comision);
				}
				rptaTransaccion += "<br><br><span style=\"font-size: 11px;\">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>";
				String montoFormateado = ClientUtils.formatCurrency(Double.parseDouble(monto));
				if (!promotionMessage.isEmpty()) {
					if (actbono.contains("true-casino") || actbono.equalsIgnoreCase("true")) {
						if (promotionMessage.contains("insuficiente") == true) {
							content = "<p style=\"text-align: justify;margin: 0px;\">" + promotionMessage
									+ "<br><br>La recarga ha sido abonada a su saldo principal.<br><br>Monto cargado: <span style=\"font-weight: bold;\">"
									+ montoFormateado + "</span><br>" + rptaTransaccion + "</p>";
						} else {
							content = "<p style=\"text-align: justify;margin: 0px;\">Su recarga se ha realizado exitosamente<br>"
									+ promotionMessage + "<br>" + rptaTransaccion + "</p>";
						}
					} else {
						promotionMessage = "<br>" + promotionMessage + "<br>";
						content = "<p style=\"text-align: justify;margin: 0px;\">Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style=\"font-weight: bold;\">"
								+ montoFormateado + "</span>" + promotionMessage + rptaTransaccion + "</p>";
					}
				} else {
					content = "<p style=\"text-align: justify;margin: 0px;\">Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style=\"font-weight: bold;\">"
							+ montoFormateado + "</span><br>" + rptaTransaccion + "</p>";
				}
			} else {
				String[] arrayResultMessage = resultMessage.split("\\|");
				String rptaTransaccion = "";
				rptaTransaccion += "<br>" + arrayResultMessage[1];
				rptaTransaccion += "<br>Nº Transacción:" + arrayResultMessage[2];
				rptaTransaccion += "<br>" + arrayResultMessage[3];
				content = "<p style=\"text-align: justify;margin: 0px;\">" + rptaTransaccion + "</p>";
			}

			URL urlApi = new URL(ConnectionFactory.operationProperty("WS_URL_PAYMENT_CALLBACK", Constants.contextSale));
			HttpsURLConnection connApi = (HttpsURLConnection) urlApi.openConnection();
			connApi.setSSLSocketFactory(new TSLSocketConnectionFactory());
			connApi.setRequestMethod("POST");
			connApi.setRequestProperty("Content-Type", "application/json; utf-8");
			connApi.setRequestProperty("Accept", "application/json");
			connApi.setDoOutput(true);
			JSONObject jsonObjectApi = new JSONObject("{}");
			jsonObjectApi.put("user_id", clientId);
			jsonObjectApi.put("time", time);
			jsonObjectApi.put("auth", auth);
			jsonObjectApi.put("title", "");
			jsonObjectApi.put("content", content);
			String jsonInputString = jsonObjectApi.toString();
			byte[] input = jsonInputString.getBytes("utf-8");
			OutputStream osApi = connApi.getOutputStream();
			osApi.write(input, 0, input.length);
			osApi.flush();
			osApi.close();

			StringBuilder sb = new StringBuilder();
			BufferedReader br = null;

			if (connApi.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader((connApi.getInputStream()), "UTF-8"));
			} else {
				br = new BufferedReader(new InputStreamReader((connApi.getErrorStream()), "UTF-8"));
			}

			char[] buffer = new char[1000];
			int leido;
			while ((leido = br.read(buffer)) > 0) {
				sb.append(new String(buffer, 0, leido));
			}
			br.close();
			connApi.disconnect();
			if(redirect) {
				response.sendRedirect(ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT_TA", Constants.contextSale));
			}else {
				response.sendRedirect("white.html");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			LoggerApi.Log.info("------------- end "+log);
		}	
    }
        
	@RequestMapping(value = "/pagoTokenFormResultQW")
    public void pagoTokenFormResultQW(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String transactionToken = request.getParameter("transactionToken");
    	String sk = request.getParameter("sk");
    	String email = request.getParameter("email");
    	String channel = request.getParameter("channel");
    	String actbono = request.getParameter("actbono");
    	String actwbbono = request.getParameter("actwbbono");
    	String monto = request.getParameter("monto");
    	String url_pago = ConnectionFactory.operationProperty("url_ws_pago", "sale");
    	try {
			
			URL url = new URL(url_pago);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			PagoParameters param = new PagoParameters();
			param.setTransactionToken(transactionToken);
			param.setSessionKey(sk);
			param.setEmail(email);
			param.setChannel(channel);
			
			Gson gson = new Gson();
			String json = gson.toJson(param);
			
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

			}
			conn.disconnect();
			
			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
			String jsonString = callWsRecargaResult(request.getLocalAddr(), sk, userBean.getpClientid());
			
			JSONObject jsonObject = new JSONObject(jsonString);
			jsonObject.put("actbono", actbono);
			jsonObject.put("actwbbono", actwbbono);
			jsonObject.put("monto", monto);
			String promotionMessage = "";
			if(actbono.contains("true-casino") || actbono.equalsIgnoreCase("true") || actwbbono.equalsIgnoreCase("true")) {
        		String balanceItem = jsonObject.getString("balanceItem");
        		if(!balanceItem.equals("0")) {
        			 PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(userBean.getpClientid(), Integer.parseInt(balanceItem));
                     if (promoFistAccount != null) {
                         promotionMessage = promoFistAccount.getPromotion_message();
                         if (promotionMessage.equals("OK")) {
                        	 String promotionEco = promoFistAccount.getPromotion_eco();
                        	 promotionMessage = promotionEco;
                        	 jsonObject.put("promotionMessage", promotionEco);
                         } else {
                        	 jsonObject.put("promotionMessage", promotionMessage);
                         }                         
                     }
        		}
        	}

			String content = "";

			String resultKey = jsonObject.getString("resultKey");
			String resultMessage = jsonObject.getString("resultMessage");

			if (resultKey.equals("OK")) {
				double comision = 0.0;
				try {
					comision = jsonObject.getDouble("commissionAmount");
				} catch (Exception e) {
					
				}
				monto = (Double.parseDouble(monto)-comision)+"";
				
				String[] arrayResultMessage = resultMessage.split("\\|");
				String rptaTransaccion = "";
				rptaTransaccion += "<br>Nº Transacción:" + arrayResultMessage[2];
				rptaTransaccion += "<br>Visa:" + arrayResultMessage[4];
				rptaTransaccion += "<br>" + arrayResultMessage[3];
				if(comision>0) {
					rptaTransaccion+="<br>Comisión por recarga con Tarjeta Visa: "+ClientUtils.formatCurrency(comision);
				}
				rptaTransaccion += "<br><br><span style=\"font-size: 11px;\">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>";
				String montoFormateado = ClientUtils.formatCurrency(Double.parseDouble(monto));
				if (!promotionMessage.isEmpty()) {
					if (actbono.contains("true-casino") || actbono.equalsIgnoreCase("true")) {
						if (promotionMessage.contains("insuficiente") == true) {
							content = "<p style=\"text-align: justify;margin: 0px;\">" + promotionMessage
									+ "<br><br>La recarga ha sido abonada a su saldo principal.<br><br>Monto cargado: <span style=\"font-weight: bold;\">"
									+ montoFormateado + "</span><br>" + rptaTransaccion + "</p>";
						} else {
							content = "<p style=\"text-align: justify;margin: 0px;\">Su recarga se ha realizado exitosamente<br>"
									+ promotionMessage + "<br>" + rptaTransaccion + "</p>";
						}
					} else {
						promotionMessage = "<br>" + promotionMessage + "<br>";
						content = "<p style=\"text-align: justify;margin: 0px;\">Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style=\"font-weight: bold;\">"
								+ montoFormateado + "</span>" + promotionMessage + rptaTransaccion + "</p>";
					}
				} else {
					content = "<p style=\"text-align: justify;margin: 0px;\">Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style=\"font-weight: bold;\">"
							+ montoFormateado + "</span><br>" + rptaTransaccion + "</p>";
				}
			} else {
				String[] arrayResultMessage = resultMessage.split("\\|");
				String rptaTransaccion = "";
				rptaTransaccion += "<br>" + arrayResultMessage[1];
				rptaTransaccion += "<br>Nº Transacción:" + arrayResultMessage[2];
				rptaTransaccion += "<br>" + arrayResultMessage[3];
				content = "<p style=\"text-align: justify;margin: 0px;\">" + rptaTransaccion + "</p>";
			}
			response.sendRedirect(session.getAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT").toString()+content);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
	
    @RequestMapping(value = "/buildVisaForm")
    public void buildVisaForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	LoggerApi.Log.info("------------- START buildVisaForm");  	
    	response.setCharacterEncoding(Constants.CHARSET_UTF8);
     	PrintWriter out = response.getWriter();
    	Gson gsonJson = new Gson();
    	JsonButtonForm jsonButtonForm = null;
        try {
	    	BufferedReader reader = request.getReader();
	    	Gson gsonForm = new Gson();
	    	VisanetParameters paramForm = gsonForm.fromJson(reader, VisanetParameters.class);
	    	
	    	if(paramForm!=null) {
	    		HttpSession session = request.getSession();
				ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
				int visanetMinAmount = 20;
				int visanetMaxAmount = 1000;
				double comision = 0;
				double amount = Double.parseDouble(paramForm.getAmount());
	    		//int amount = Integer.parseInt(paramForm.getAmount());
	    		//int visanetMinAmount = ((ConnectionFactory.operationProperty("visanetMinAmount", Constants.contextCardWeb) != null)?Integer.parseInt(ConnectionFactory.operationProperty("visanetMinAmount", Constants.contextCardWeb).trim()):10);
				if(paramForm.getTypeCard().equals("VISA")) {
					visanetMinAmount = accountDataPart.getAmtMinRechargeVisa().intValue();
					visanetMaxAmount = accountDataPart.getAmtMaxRechargeVisa().intValue();
					
					if(amount>=accountDataPart.getComMinRan1Visa() && amount<=accountDataPart.getComMaxRan1Visa()){
						comision=accountDataPart.getComAmtRan1Visa();
					}else if(amount>=accountDataPart.getComMinRan2Visa() && amount<=accountDataPart.getComMaxRan2Visa()){
						comision=accountDataPart.getComAmtRan2Visa();
					}else if(amount>=accountDataPart.getComMinRan3Visa() && amount<=accountDataPart.getComMaxRan3Visa()){
						comision=accountDataPart.getComAmtRan3Visa();
					}else if(amount>=accountDataPart.getComMinRan4Visa() && amount<=accountDataPart.getComMaxRan4Visa()){
						comision=accountDataPart.getComAmtRan4Visa();
					}
				}else if(paramForm.getTypeCard().equals("AGORA")) {
					visanetMinAmount = accountDataPart.getAmtMinRechargeAgr().intValue();
					visanetMaxAmount = accountDataPart.getAmtMaxRechargeAgr().intValue();
					
					if(amount>=accountDataPart.getComMinRan1Agr() && amount<=accountDataPart.getComMaxRan1Agr()){
						comision=accountDataPart.getComAmtRan1Agr();
					}else if(amount>=accountDataPart.getComMinRan2Agr() && amount<=accountDataPart.getComMaxRan2Agr()){
						comision=accountDataPart.getComAmtRan2Agr();
					}else if(amount>=accountDataPart.getComMinRan3Agr() && amount<=accountDataPart.getComMaxRan3Agr()){
						comision=accountDataPart.getComAmtRan3Agr();
					}else if(amount>=accountDataPart.getComMinRan4Agr() && amount<=accountDataPart.getComMaxRan4Agr()){
						comision=accountDataPart.getComAmtRan4Agr();
					}
				}else {
					jsonButtonForm = new JsonButtonForm();
					jsonButtonForm.setSessionKey("0");
					jsonButtonForm.setHtmlText("Tipo de tarjeta no v&aacute;lido.");
					out.write(gsonJson.toJson(jsonButtonForm));
					return;
				}
				
				if(amount>=visanetMinAmount) {
	    			//int visanetMaxAmount = ((ConnectionFactory.operationProperty("visanetMaxAmount", Constants.contextCardWeb) != null)?Integer.parseInt(ConnectionFactory.operationProperty("visanetMaxAmount", Constants.contextCardWeb).trim()):10);
	    			if(amount<=visanetMaxAmount) {
						ClientProcedureGetDataClient client = (ClientProcedureGetDataClient) session.getAttribute("CLIENT_SESSION");
						
						BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa = balanceSaleBo.resultEvalRulesVisa(Integer.parseInt(client.getClientId()), amount);
						if(resultEvalRulesVisa.getResult().equals(Constants.RESULT_OK)) {
							VisanetParameters param = new  VisanetParameters();
							param.setClientId(Integer.parseInt(client.getClientId()));
							//param.setAmount(paramForm.getAmount());
							double montoTotal = amount+comision;
							param.setAmount(montoTotal+"");
							param.setRemoteAddr(request.getRemoteAddr());
							param.setCardHolderName(client.getNombre().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a")
									.replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o")
									.replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "")
									.replace("5", "").replace("6", "").replace("7", "").replace("8", ""));
							param.setCardHolderLastName((client.getApPaterno()+((client.getApMaterno()!=null)?" "+client.getApMaterno():"")).toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i")
									.replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e")
									.replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "").replace("2", "")
									.replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", ""));
							param.setCardHolderEmail("CID"+client.getClientId()+"@intralot.com.pe");
							param.setMerchantLogo(paramForm.getMerchantLogo());
							param.setTimeoutUrl(paramForm.getTimeoutUrl());
							param.setActbono(paramForm.getActbono());
							param.setActwbbono(paramForm.getActwbbono());
							param.setPagoTokenUrl(session.getAttribute("WS_URL_PAGO_TOKEN_RESULT").toString());
							param.setTypeCard(paramForm.getTypeCard());
							param.setComision(comision);
													
							Gson gson = new Gson();
							String json = gson.toJson(param);
				        	String jsonString = callWsVisaForm(request.getLocalAddr(), json);
	
				        	jsonButtonForm = gsonJson.fromJson(jsonString, JsonButtonForm.class);
				        	String sk = jsonButtonForm.getSessionKey();
				        	session.setAttribute("VISANET_SK",sk);     
				        	if(!sk.equals("0")) {
				        		jsonButtonForm.setSessionKey("");
				        	}
				        	out.write(gsonJson.toJson(jsonButtonForm));
						}else {
							jsonButtonForm = new JsonButtonForm();
							jsonButtonForm.setSessionKey("0");
							jsonButtonForm.setHtmlText(resultEvalRulesVisa.getMessage());
							out.write(gsonJson.toJson(jsonButtonForm));
						}
	    			}else {
	    				jsonButtonForm = new JsonButtonForm();
	    				jsonButtonForm.setSessionKey("0");
	    				jsonButtonForm.setHtmlText("Debe ingresar un monto de carga no mayor de S/"+visanetMaxAmount+" soles.");
	    				out.write(gsonJson.toJson(jsonButtonForm));
	    			}
	    		}else {
	    			jsonButtonForm = new JsonButtonForm();
	    			jsonButtonForm.setSessionKey("0");
    				jsonButtonForm.setHtmlText("Debe ingresar un monto de carga a partir de S/"+visanetMinAmount+" soles.");
    				out.write(gsonJson.toJson(jsonButtonForm));
	    		}
	    	}else {
	    		jsonButtonForm = new JsonButtonForm();
	        	jsonButtonForm.setSessionKey("0");
	        	jsonButtonForm.setHtmlText("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
				out.write(gsonJson.toJson(jsonButtonForm));
	    	}
        } catch (Exception e) {
        	LoggerApi.severe(e); 
        	jsonButtonForm = new JsonButtonForm();
        	jsonButtonForm.setSessionKey("0");
        	jsonButtonForm.setHtmlText("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
			out.write(gsonJson.toJson(jsonButtonForm));
        }
        
    	LoggerApi.Log.info("------------- END buildVisaForm");  	
    }
    
    public String callWsVisaForm(String serverIP, String json) {
		try {			
			//String urlVisanetForm = visanetParametrosBo.getUrlVisanetForm(serverIP);
			String urlVisanetForm = getUrWslVisanet();
			
            LoggerApi.Log.info("urlVisanetForm "+ urlVisanetForm);
			
			URL url = new URL(urlVisanetForm);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF-8"));

			String output;
			while ((output = br.readLine()) != null) {
				break;
			}
			conn.disconnect();
			
			return output;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public static String getUrWslVisanet() {
    	return ConnectionFactory.operationProperty("url_ws_visanet", "sale");
    	/*
    	try {
    		InputStream input = ClientBalanceController.class.getClassLoader().getResourceAsStream("resource/visanet.properties");
    		
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            return prop.getProperty("url_ws_visanet");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } */
	}
    
    @RequestMapping(value = "/findVisanetRecargaResult")
    public void findVisanetRecargaResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("------------- START findVisanetRecargaResult");  	
    	BufferedReader reader = request.getReader();
    	Gson gson = new Gson();
    	VisanetParameters paramForm = gson.fromJson(reader, VisanetParameters.class);

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);		
		String sk = (String) session.getAttribute("VISANET_SK");
		
		
        PrintWriter out = response.getWriter();
        
        try {
        	String jsonString = callWsRecargaResult(request.getLocalAddr(), sk, userBean.getpClientid());
        	
        	LoggerApi.Log.info("------------- codigo promocional" + paramForm.getCodePromotional());  	
        	if(paramForm.getCodePromotional() !=null || !paramForm.getCodePromotional().isEmpty()) {
        		JSONObject jsonObject = new JSONObject(jsonString);
        		String balanceItem = jsonObject.getString("balanceItem");
        		if(!balanceItem.equals("0")) {
        			 PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(userBean.getpClientid(), Integer.parseInt(balanceItem));
                     if (promoFistAccount != null) {
                         String promotionMessage = promoFistAccount.getPromotion_message();
                         if (promotionMessage.equals("OK")) {
                        	 String promotionEco = promoFistAccount.getPromotion_eco();
                        	 jsonObject.put("promotionMessage", promotionEco);
                         } else {
                        	 jsonObject.put("promotionMessage", promotionMessage);
                         }
                         jsonString = jsonObject.toString();
                     }
        		}
        	}
        	out.write(jsonString);
        } catch (Exception e) {
        	LoggerApi.severe(e); 
        }
    	LoggerApi.Log.info("------------- END findVisanetRecargaResult");  	
    }
    
    public String callWsRecargaResult(String serverIP, String sk, Integer clientId) {
		try {
			//String urlUpdateBalance = visanetParametrosBo.getUrlUpdateBalance(serverIP);
			String urlUpdateBalance = ConnectionFactory.operationProperty("url_ws_result", "sale");
            LoggerApi.Log.info("start urlUpdateBalance "+ urlUpdateBalance+"/"+sk+"/"+ "CID"+clientId+"@intralot.com.pe"+ " cid="+clientId);
			
			URL url = new URL(urlUpdateBalance+"/"+sk+"/"+ "CID"+clientId+"@intralot.com.pe"); //param.getCardHolderEmail());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			int responseCode = conn.getResponseCode(); 
			
			if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + responseCode);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF-8"));

			String output;
			while ((output = br.readLine()) != null) {
				break;
			}
			conn.disconnect();
			
			return output;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            LoggerApi.Log.info("end urlUpdateBalance cid="+clientId);
		}
		return null;
    }
	
    @RequestMapping(value = "/redireccionarRecarga")
    public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 return new ModelAndView("client/redirectRecharge");
    }
    
    @RequestMapping(value = "/white")
	public ModelAndView white(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("client/white");
	}
    
    @RequestMapping(value = "/resetVisanetTransaction")
    public void resetVisanetTransaction(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("------------- START resetVisanetTransaction");  	
    	HttpSession session = request.getSession();
    	session.setAttribute("visanetTransaction", null);
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	o.addProperty("reset", "OK");
    	out.print(o);
    	LoggerApi.Log.info("------------- END resetVisanetTransaction");  
    }
    
    @RequestMapping(value = "/montoPorDia")
    public void findByMontoPorDia(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String resultClient = "";
            
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);  
                List<BalanceProcedureGetMontoPorDia> balanceList = balanceSaleBo.findMontoPorDia(userBean.getpClientid());
                if(balanceList.get(0)!=null) {
                	 resultClient=balanceList.get(0).getM_dia();	
                	 out.print(resultClient);
                }
                else {
                	  resultClient="0";
                	 out.print(resultClient);
                }
            }
          
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        }
    }
    
    @RequestMapping(value = "/montoPorDiaAgora")
    public void findByMontoPorDiaAgora(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String resultClient = "";
            
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                UserBean userBean = (UserBean) session.getAttribute(Constants.USR_SESION);  
                List<BalanceProcedureGetMontoPorDiaAgora> balanceList = balanceSaleBo.findMontoPorDiaAgora(userBean.getpClientid());
                if(balanceList.get(0)!=null) {
                	resultClient=balanceList.get(0).getMontoPorDia();	
                	out.print(resultClient);
                }
                else {
                	resultClient="0";
                	out.print(resultClient);
                }
            }
          
        } catch (Exception e) {
            LoggerApi.severe(e);
        } 
    }
    
    @RequestMapping(value = "/rechargeAgora")
	public void rechargeAgora(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		LoggerApi.Log.info("-------------- START rechargeAgora");
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		HttpSession session = request.getSession();
		try {
			String ip = request.getRemoteAddr();
			String monto = request.getParameter("monto");
			String bono = request.getParameter("actbono");
			String wbbono = request.getParameter("actwbbono");
			String phoneUpdate = request.getParameter("phoneUpdate"); 
			String phoneUpdateAgora = request.getParameter("phoneUpdateAgora");
			String promotionCode = request.getParameter("codePromotional");
			double amount = 0.0;
			int clientId = 0;
			LoggerApi.Log.info("ip: "+ip+" monto: "+monto+" bono: "+bono+" wbbono: "+wbbono+" phoneUpdateAgora: "+phoneUpdateAgora+" phoneUpdate: "+phoneUpdate);			
			if(monto!=null && !monto.trim().isEmpty()) {
				amount = Double.parseDouble(monto);
			}
			if(session.getAttribute(Constants.USR_SESION) != null) {
				clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
	    	}
			
			ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
			if(clientId>0) {
				if(amount<=accountDataPart.getAmtMaxRechargeAgr()) {
					if(amount>=accountDataPart.getAmtMinRechargeAgr()) {
						BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora = balanceSaleBo.resultEvalRulesAgora(clientId, amount);
						if(resultEvalRulesAgora.getResult().equals(Constants.RESULT_OK)) {
							String phone = accountDataPart.getMobilePhone();
							String msgPhoneValidation = "";
							if(accountDataPart.getRechargeAgora().trim().equals(Constants.STATE_WITHOUT_AGORA) && phoneUpdateAgora.equals("1")) {
								phone=phoneUpdate;
					            if(!ClientUtils.verifySintaxMobilePhone(phone)) {
					            	msgPhoneValidation = Constants.MSG_PHONE_INVALID;
					            }else {
					            	ClientProcedureValidateNewPhoneAgora objValidateNewPhoneAgora = clientSaleBo.validateNewPhoneAgora(clientId, phone);
					            	if(objValidateNewPhoneAgora!=null && !objValidateNewPhoneAgora.getResult().equals(Constants.RESULT_OK)) {
					            		msgPhoneValidation = objValidateNewPhoneAgora.getMessage();
					            	}
					            }
							}
							
							if(phone!=null && !phone.trim().isEmpty()) {
								if(msgPhoneValidation.isEmpty()) {
									LoggerApi.Log.info("promotionCode: "+promotionCode+" monto: "+amount+" clientId: "+clientId);	
									PaymentRequest paymentRequest = new PaymentRequest(); 
					                PaymentResponse paymentResponse = new PaymentResponse(); 
					                paymentRequest.setPlataform(Constants.PLATAFORM);
					                paymentRequest.setPromotionKey(promotionCode);
					                paymentRequest.setAmount(amount);
					                paymentRequest.setPhone(phone);
					                paymentRequest.setClientId(clientId);
					                Gson gson = new Gson();
					    			String json = gson.toJson(paymentRequest);	
					                paymentResponse = getPaymentAgoraResponse(json, uuid);
					                if(paymentResponse!=null) {
					                	if(paymentResponse.getState().equals(Constants.RESULT_OK)) {
					                		o.addProperty("btnName", "Volver a mi cuenta");
						                	String mensaje = "<p style='text-align: center;'>Confirma la recarga desde tu app Agora.</p>";
						                	if(accountDataPart.getRechargeAgora().trim().equals(Constants.STATE_WITHOUT_AGORA)) {
						                		ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora = clientSaleBo.updateStateRechargeAgora(clientId, phoneUpdateAgora, phone);
						                		if(updateStateRechargeAgora!=null && updateStateRechargeAgora.getResult().equals(Constants.RESULT_OK)) {
						                			accountDataPart.setRechargeAgora(Constants.STATE_WITH_AGORA);
						                			session.setAttribute("accountDataPart",accountDataPart);
						                			if(updateStateRechargeAgora.getStateUpdatePhone().equals(Constants.RESULT_OK)) {
						                				mensaje += "<p style='text-align: justify;'>Para poder ver la recarga en tu cuenta, cierra &eacute;sta sesi&oacute;n, vuelve a iniciarla, y activa tu cuenta con el c&oacute;digo que te enviamos por SMS.</p>";
						                				o.addProperty("btnName", "Cerrar sesi&oacute;n");
						                			}
						                			o.addProperty("stateUpdatePhone", updateStateRechargeAgora.getStateUpdatePhone());
						                		}
						                	}
						                	o.addProperty("state", "OK");
											o.addProperty("message", mensaje);
					                	}else {
					                		String code = paymentResponse.getCode();
					                		if(code!=null && code.trim().equals(Constants.AGORA_ERROR_CODE_ECM_PAY_02)) {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constants.AGORA_MSG_ECM_PAY_02);
					                		}else {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constants.MSG_EXCEPTION);
					                		}
					                	}
					                }else {
					                	o.addProperty("state", "KO");
					    				o.addProperty("message", Constants.MSG_EXCEPTION);
					                }
								}else {
									o.addProperty("state", "KO");
				    				o.addProperty("message", msgPhoneValidation);
								}
							}else {
								o.addProperty("state", "KO");
			    				o.addProperty("message", Constants.MSG_PHONE_INVALID);
							}
						}else {
							o.addProperty("state", "KO");
		    				o.addProperty("message", resultEvalRulesAgora.getMessage());
						}
					}else {
						o.addProperty("state", "KO");
						o.addProperty("message", "Debe ingresar un monto de carga a partir de S/" + accountDataPart.getAmtMinRechargeAgr() + " soles.");
					}
				}else {
					o.addProperty("state", "KO");
					o.addProperty("message", "Debe ingresar un monto de carga no mayor de S/" + accountDataPart.getAmtMaxRechargeAgr() + " soles.");
				}
			}else {
				o.addProperty("state", "KO");
				o.addProperty("message", Constants.MSG_EXCEPTION);
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("state", "KO");
			o.addProperty("message", Constants.MSG_EXCEPTION);
		}
		LoggerApi.Log.info("-------------- START rechargeAgora");
	}
    
    @RequestMapping(value = "/errorIzipay")
   	public void error_epago_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
   			throws Exception {
   		String uuid = UUID.randomUUID().toString().replace("-", "");
   		LoggerApi.Log.info("-------------- START errorIzipay");
   		response.setCharacterEncoding(Constants.CHARSET_UTF8);
   		PrintWriter out = response.getWriter();
   		JsonObject o = new JsonObject();
   		try {
 			String uniqueIdentifier = request.getParameter("uniqueIdentifier");
 			String number = request.getParameter("number");
 			String brand = request.getParameter("brand");
 			String amount = request.getParameter("amount");
 			String code = request.getParameter("code");
 			String rechargetoken = request.getHeader("rechargetoken");
			String ip=ClientUtils.getClientIp(request);
 			String operatorId = request.getParameter("operatorId");
 			String jsonRequest = request.getParameter("json_request");
 			String jsonResponse = request.getParameter("json_response");
 			String platform = Constants.PLATAFORM;
 			String website = "LATINKA";
 			double amountD = 0.0;
 			int clientId = 0;
 			if(operatorId!=null) {
 				if(operatorId.equals("5586")) {
 					website = "LATINKA";
 				}else if(operatorId.equals("5587")) {
 					website = "LAPOLLA";
 				}else if(operatorId.equals("5588")) {
 					website = "TEAPUESTO";
 				}
 			}
 			LoggerApi.Log.info("ip: "+ip+" uniqueIdentifier: "+uniqueIdentifier+" number: "+number+" brand: "+brand+" amount: "+amount +" code: "+code);			

 			if(amount!=null && !amount.trim().isEmpty()) {
 				amountD = Double.parseDouble(amount);
 			}
 			
 			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}else {
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
					o.addProperty("message", Constants.MSG_EXCEPTION);
					out.print(o);
					return;
				}
			}
			
			if(clientId>0) {
				Object[] values = new Object[12];
                values[0] = ip;
                values[1] = uniqueIdentifier;
                values[2] = number;
                values[3] = brand;
                values[4] = amountD;
                values[5] = code;
                values[6] = operatorId;
                values[7] = platform;
                values[8] = website;
                values[9] = clientId;
                values[10] = jsonRequest;
                values[11] = jsonResponse;
                balanceSaleBo.registerErrorIzipay(values);    
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                o.addProperty("fecha", sdf.format(new Date()));
                o.addProperty("state", "OK");
			}else {
 				o.addProperty("state", "KO");
 				o.addProperty("message", Constants.MSG_EXCEPTION);
 			}
 			out.print(o);
   		} catch (Exception e) {
 			LoggerApi.severe(e);
 			o.addProperty("state", "KO");
 			o.addProperty("message", Constants.MSG_EXCEPTION);
 		}
 		LoggerApi.Log.info("-------------- END errorIzipay");
 	}

    @RequestMapping(value = "/defineRechargeIzipay")
 	public void define_recharge_izipay(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
 			throws Exception {
    	String uuid = UUID.randomUUID().toString().replace("-", "");
 		LoggerApi.Log.info("-------------- START defineRechargeIzipay");
 		response.setCharacterEncoding(Constants.CHARSET_UTF8);
 		PrintWriter out = response.getWriter();
 		JsonObject o = new JsonObject();
	 	try {
 			String amount = request.getParameter("amount");
 			String actbono = request.getParameter("actbono");
 			String actwbbono = request.getParameter("actwbbono");
 			String codePromotional = request.getParameter("codePromotional"); 
 			String rechargetoken = request.getHeader("rechargetoken");
 			String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
			String ip=ClientUtils.getClientIp(request);
 			String operatorId = request.getParameter("operatorId");
 			String platform = Constants.PLATAFORM;
 			String website = "LATINKA";
 			double amountD = 0.0;
 			int clientId = 0;
 			if(operatorId!=null) {
 				if(operatorId.equals("5586")) {
 					website = "LATINKA";
 				}else if(operatorId.equals("5587")) {
 					website = "LAPOLLA";
 				}else if(operatorId.equals("5588")) {
 					website = "TEAPUESTO";
 				}
 			}
 			LoggerApi.Log.info("ip: "+ip+" amount: "+amount+" actbono: "+actbono+" actwbbono: "+actwbbono+" codePromotional: "+codePromotional+" channel:"+channel);			
 			if(amount!=null && !amount.trim().isEmpty()) {
 				amountD = Double.parseDouble(amount);
 			}
 			
 			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			LoggerApi.Log.info("tokenValidation "+tokenValidation.getStatus());
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}else {
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
					o.addProperty("message", Constants.MSG_EXCEPTION);
					out.print(o);
					return;
				}
			}
 			 			
 			if(clientId>0) {
 				
 				Object[] values = new Object[7];
                values[0] = ip;
                values[1] = amountD;
                values[2] = codePromotional;
                values[3] = operatorId;
                values[4] = platform;
                values[5] = website;
                values[6] = clientId;
                ProcedureDefineTransactionIzipay defineTransactionIzipay = balanceSaleBo.defineTransactionIzipay(values);
                LoggerApi.Log.info("-------------- IdTransactionIzipay "+defineTransactionIzipay.getIdTransactionIzipay());
                o.addProperty("idTransactionIzipay", defineTransactionIzipay.getIdTransactionIzipay());
                o.addProperty("state", defineTransactionIzipay.getStatus());
                if(defineTransactionIzipay!=null && defineTransactionIzipay.getStatus()!=null && defineTransactionIzipay.getStatus().equals(Constants.RESULT_OK)) {
                	String signature = Constants.generateSignatureSHA512(Constants.EPAGO_API_KEY+defineTransactionIzipay.getIdTransactionIzipay()+"PEN"+amount+Constants.EPAGO_SECRET_KEY);
                	
                	if(!signature.equals("ERROR")) {
                		o.addProperty("signature", signature);
                		o.addProperty("apiKey", Constants.EPAGO_API_KEY);
                	}else {
                		o.addProperty("state", "ERROR");
                		o.addProperty("message", Constants.MSG_EXCEPTION);
                	}
                }else {
                	o.addProperty("state", "KO");
                	o.addProperty("message", Constants.MSG_EXCEPTION);
                }
 			}else {
 				o.addProperty("state", "KO");
 				o.addProperty("message", Constants.MSG_EXCEPTION);
 			}	 		
	 		out.print(o);
 		} catch (Exception e) {
 			LoggerApi.severe(e);
 			o.addProperty("state", "KO");
 			o.addProperty("message", Constants.MSG_EXCEPTION);
 		}
 		LoggerApi.Log.info("-------------- END defineRechargeIzipay");
    }
    
    @RequestMapping(value = "/rechargeIzipay")
 	public void recarga_epago_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
 			throws Exception {
 		String uuid = UUID.randomUUID().toString().replace("-", "");
 		LoggerApi.Log.info("-------------- START rechargeIzipay");
 		response.setCharacterEncoding(Constants.CHARSET_UTF8);
 		PrintWriter out = response.getWriter();
 		JsonObject o = new JsonObject();
	 	try {
 			String state = request.getParameter("state");
 			String uniqueIdentifier = request.getParameter("uniqueIdentifier");
 			String number = request.getParameter("number");
 			String brand = request.getParameter("brand");
 			String amount = request.getParameter("amount");
 			String created = request.getParameter("created");
 			String code = request.getParameter("code");
 			String message = request.getParameter("message");
 			String operationNumber = request.getParameter("operationNumber");
 			String actbono = request.getParameter("actbono");
 			String actwbbono = request.getParameter("actwbbono");
 			String codePromotional = request.getParameter("codePromotional"); 
 			String rechargetoken = request.getHeader("rechargetoken");
 			String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
			String ip=ClientUtils.getClientIp(request);
 			String operatorId = request.getParameter("operatorId");
 			String jsonRequest = request.getParameter("json_request");
 			String jsonResponse = request.getParameter("json_response");
 			String idIzipay = request.getParameter("idIzipay");
 			String platform = Constants.PLATAFORM;
 			String website = "LATINKA";
 			double amountD = 0.0;
 			int clientId = 0;
 			if(operatorId!=null) {
 				if(operatorId.equals("5586")) {
 					website = "LATINKA";
 				}else if(operatorId.equals("5587")) {
 					website = "LAPOLLA";
 				}else if(operatorId.equals("5588")) {
 					website = "TEAPUESTO";
 				}
 			}
 			LoggerApi.Log.info("ip: "+ip+" state: "+state+" uniqueIdentifier: "+uniqueIdentifier+" number: "+number+" brand: "+brand+" amount: "+amount
 					+" created: "+created+" code: "+code+" message: "+message+" operationNumber: "+operationNumber+" actbono: "+actbono+" actwbbono: "+actwbbono+" codePromotional: "+codePromotional + " channel="+channel);			
 			if(amount!=null && !amount.trim().isEmpty()) {
 				amountD = Double.parseDouble(amount);
 			}
 			
 			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			LoggerApi.Log.info("tokenValidation "+ tokenValidation.getStatus());
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}else {
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
					o.addProperty("message", Constants.MSG_EXCEPTION);
					out.print(o);
					return;
				}
			}
			
			 LoggerApi.Log.info("-------------- jsonRequest "+ jsonRequest);
			 LoggerApi.Log.info("-------------- jsonResponse "+ jsonResponse);
 			 			
 			if(clientId>0) {	
                Object[] values = new Object[18];
                values[0] = ip;
                values[1] = state;
                values[2] = uniqueIdentifier;
                values[3] = number;
                values[4] = brand;
                values[5] = amountD;
                values[6] = created;
                values[7] = code;
                values[8] = message;
                values[9] = operationNumber;
                values[10] = codePromotional;
                values[11] = operatorId;
                values[12] = platform;
                values[13] = website;
                values[14] = clientId;
                values[15] = jsonRequest;
                values[16] = jsonResponse;
                values[17] = idIzipay;
                ProcedurePayTransactionIzipay payTransactionIzipay = balanceSaleBo.payTransactionIzipay(values);
                LoggerApi.Log.info("-------------- IdTransactionIzipay "+payTransactionIzipay.getStatus() + "client_id=" +clientId);
                
 				o.addProperty("newAmount", payTransactionIzipay.getNewAmount());	 				
 				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                o.addProperty("fecha", sdf.format(new Date()));
 				if(codePromotional != null && !codePromotional.isEmpty()) {
 					PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(clientId, payTransactionIzipay.getBalanceItem());
 					LoggerApi.Log.info("promoFistAccount="+ promoFistAccount);
                    if (promoFistAccount != null) {
                    	String promotionMessage = promoFistAccount.getPromotion_message();
                   	 	LoggerApi.Log.info("promotionMessage0="+ promotionMessage);
                        if (promotionMessage.equals("OK")) {
                        	String promotionEco = promoFistAccount.getPromotion_eco();
                       	 	o.addProperty("promotionMessage", promotionEco);
                        } else {
                       	 	o.addProperty("promotionMessage", promotionMessage);
                        }                         
                    }
 				}
 				
 			}else {
 				o.addProperty("state", "KO");
 				o.addProperty("message", Constants.MSG_EXCEPTION);
 			}
 			out.print(o);
 		} catch (Exception e) {
 			LoggerApi.severe(e);
 			o.addProperty("state", "KO");
 			o.addProperty("message", Constants.MSG_EXCEPTION);
 		}
 		LoggerApi.Log.info("-------------- END rechargeIzipay");
 	}
	

    @SuppressWarnings("static-access")
	@RequestMapping(value = "/user-update")
    public void userUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- STAR user-update"); 
		
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        Integer clientId = 0;
        Integer sessionId = 0; 
        String user = "";
        String ppe = "";
        PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject(); 
        JsonObject joDataClient = new JsonObject();
        JsonObject joDataClientResponse=null;
        try {
        	
            if (session == null || session.getAttribute(Constants.USR_SESION) == null) {
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");    
            	return;
            } 
            if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString().equals("")) {
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            	return;
            }
            
            clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
            sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
            ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
            
            dataClient = requestDataClient(dataClient,request);
            user = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser();
            if(dataClient.getUser()!=user && user!=null && !user.equals("")) {
            	dataClient.setUser(user);
            }
            ppe = (session.getAttribute("isPerPolExp")!=null?session.getAttribute("isPerPolExp").toString():"");
            if(dataClient.getPpe()!=ppe && ppe!=null && !ppe.equals("")) {
            	dataClient.setPpe(ppe);
            }
            
            Map<Object,String> verificaData = verificaData(dataClient);
            
            if(!Boolean.parseBoolean(verificaData.get("verificador"))) {
            	o.addProperty("result", verificaData.get("status")); 
            	o.addProperty("message", verificaData.get("message"));
            	return;
            }
            
//        	ClientProcedureUpdateDataClient clientUpdate = clientSaleBo.updateClient(dataClient,sessionId, clientId);
        	//servicio updateClientData
    		JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("clientId", String.valueOf(clientId));
//    		jdata.addProperty("usuario", user);
    		jdata.addProperty("nombres", dataClient.getNombre());
    		jdata.addProperty("apellidos", dataClient.getApPaterno());
    		jdata.addProperty("email", dataClient.getMail());
    		jdata.addProperty("fechaNacimiento", dataClient.getBirthDate());
    		jdata.addProperty("celular", dataClient.getMobilePhone());
    		jdata.addProperty("tipoDocumento", dataClient.getTypeId());
    		jdata.addProperty("numeroDocumento", dataClient.getNumberId());
    		jdata.addProperty("confirm", dataClient.getConfirm());
    		jdata.addProperty("nacionalidad", dataClient.getCountry());
    		jdata.addProperty("direccion", dataClient.getAddress2());
    		jdata.addProperty("departamento", dataClient.getRegion());
    		jdata.addProperty("provincia", dataClient.getProvince());
    		jdata.addProperty("distrito", dataClient.getDistrict());
    		jdata.addProperty("ppeFlag", dataClient.getPpe());
    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
    		jdata.addProperty("operatorId", Constants.OPERATOR_ID);
    		jdata.addProperty("platform", Constants.PLATAFORM);
    		
    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updateProfile"));//updateClientData
            
    		o.addProperty("status", convertedObject.getString("status").equals("OK")?convertedObject.getString("state"):"0");
        	o.addProperty("message", convertedObject.getString("message"));
        	
        	if(!convertedObject.getString("status").equals("OK")) {
        		o.addProperty("result", "KO");
            	o.addProperty("title",convertedObject.getString("resp_title"));
            	o.addProperty("message",convertedObject.getString("resp_message"));
            	o.addProperty("button",convertedObject.getString("resp_button"));
        		return;
        	}
        	
        	JsonObject jdata2 = new JsonObject();
    		jdata2.addProperty("token", tokenPlayerWebApi);
    		jdata2.addProperty("tipoDocumento", "");
    		jdata2.addProperty("numeroDocumento", "");
    		jdata2.addProperty("clientId", String.valueOf(clientId));
    		jdata2.addProperty("playerIp", ClientUtils.getClientIp(request));
    		jdata2.addProperty("operatorId", Constants.OPERATOR_ID);
    		jdata2.addProperty("platform", Constants.PLATAFORM);
	    	JsonParser jsonParser = new JsonParser();
            joDataClientResponse = jsonParser.parse(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData")).getAsJsonObject();
            dataClient=JsonConvertClient(joDataClientResponse);
        		  
//            dataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
    		joDataClient = ClientConvertJson(dataClient);
            o.add("DataClient", joDataClient);
            o.addProperty("result", "OK");
            
            session.setAttribute("isDataComplete", 1);
            session.setAttribute("fullName", dataClient.getNombre());
            
        } catch (Exception e) {
        	o.addProperty("result", "KO");
        	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            LoggerApi.severe(e);
        } finally {
        	out.print(o);
        	LoggerApi.Log.info("-------------- END user-update");
        }
    }
    
    @RequestMapping(value = "/password-update")
    public void passwordUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="password-update";
    	LoggerApi.Log.info("-------------- STAR "+log); 
		JSONObject convertedObject=null;
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
 
        try {
        	
        	if (session == null || session.getAttribute(Constants.USR_SESION) == null) { 
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");    
            	return;
            }
            if (((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid().toString().equals("")) {
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            	return;
            } 
            
        	String usr = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser();
        	String passActual = (request.getParameter("password-actual")!=null) ? request.getParameter("password-actual") : "";
        	Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        	
        	String passUpdate = (request.getParameter("new-password")!=null) ? request.getParameter("new-password") : "";
            String passConfirm = (request.getParameter("confirm-password")!=null) ? request.getParameter("confirm-password") : "";
            
            if(request.getParameter("password-actual").equals(passUpdate) ) {
        		o.addProperty("result", "KO");
            	o.addProperty("message", "La nueva contraseña no puede ser igual a la actual contraseña");
            	return;
        	}
            
        	String verifyString = ClientUtils.verifyPassword(usr, passUpdate, passConfirm);
        	if (!verifyString.equals("OK")) {
                o.addProperty("result", "KO");
                o.addProperty("message", verifyString);
                return;
            }
        	
        	//obtener datos del cliente            
            JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("tipoDocumento", "");
    		jdata.addProperty("numeroDocumento", "");
    		jdata.addProperty("clientId", String.valueOf(clientId));
    		jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
    		jdata.addProperty("operatorId", Constants.OPERATOR_ID);
    		jdata.addProperty("platform", Constants.PLATAFORM);
    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
            
            //validar que contraseña no contenga datos del usuario
            String nombres=convertedObject.has("nombres")?convertedObject.getString("nombres"):"";
            String apellidos=convertedObject.has("apellidos")?convertedObject.getString("apellidos"):"";
            String numeroDocumento=convertedObject.has("numeroDocumento")?convertedObject.getString("numeroDocumento"):"";
            String fechaNacimiento=	convertedObject.has("fechaNacimiento")?convertedObject.getString("fechaNacimiento"):"";
            String celular=convertedObject.has("celular")?convertedObject.getString("celular"):"";
            
        	/*String verifyString2 = ClientUtils.verifyPasswordChangePassword(passUpdate, nombres, apellidos, numeroDocumento, fechaNacimiento, celular);
        	if (!verifyString2.equals("OK")) {
                o.addProperty("result", "KO");
                o.addProperty("message", verifyString2);
                return;
            }*/
        	
        	String tipoDocumento=convertedObject.has("tipoDocumento")?convertedObject.getString("tipoDocumento"):"";
        	jdata = new JsonObject();
        	jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("transaccionId", "");
			jdata.addProperty("tipoDocumento", tipoDocumento);
			jdata.addProperty("numeroDocumento", numeroDocumento);
			jdata.addProperty("passwordAnterior", passActual);
			jdata.addProperty("password", passUpdate);
			jdata.addProperty("passwordConfirm", passConfirm);
			jdata.addProperty("operatorId", Constants.OPERATOR_ID);
			jdata.addProperty("usuario", "");
			jdata.addProperty("platform", Constants.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updatePassword"));
			o.addProperty("status", convertedObject.getString("mensaje"));
        	o.addProperty("message", convertedObject.getString("resp_message"));
			if(convertedObject.getString("estado").equals("OK")) {
				o.addProperty("result", "OK");
				
				//modificar notificacion de contraseña
				List<PaymentPrizeProcedureGetNotifications> listObj=paymentPrizeBo.getNotifications(clientId);
				for (PaymentPrizeProcedureGetNotifications notifications : listObj) {
					if(notifications.getType().equals("4")) {
						PaymentPrizeProcedureUpdatePasswordNotification obj = paymentPrizeBo.updatePasswordNotification(clientId, notifications.getId());
						LoggerApi.Log.info(log+" passwordNotification="+obj.getMessage());
					}
				}
				
        	}else {
        		o.addProperty("result", "KO");
        	}
                	
                
        } catch (Exception e) {
        	o.addProperty("result", "KO");
        	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            LoggerApi.severe(e);
        } finally {
        	out.print(o);
        	LoggerApi.Log.info("-------------- END "+log);
        } 
        
    }
    
	private PaymentResponse getPaymentAgoraResponse(String json, String uuid) {
		PaymentResponse paymentResponse = new PaymentResponse();
		Gson gson = new Gson();
		try {
			String urlPaymentAgoraAPI = ConnectionFactory.operationProperty("urlPaymentAgoraAPI", Constants.contextSale);
			String userAgoraAPI = ConnectionFactory.operationProperty("userAgoraAPI", Constants.contextSale);
			String passAgoraAPI = ConnectionFactory.operationProperty("passAgoraAPI", Constants.contextSale);
			String credenciales = userAgoraAPI+":"+passAgoraAPI;
			credenciales = Base64.encodeBase64String(credenciales.getBytes());
 	    	URL url = new URL(urlPaymentAgoraAPI);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
 			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
 			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
     		con.setDoOutput(true);
     		OutputStream os = con.getOutputStream();
 			os.write(json.getBytes(Constants.CHARSET_UTF8));
 			os.flush();
 			os.close();
 			BufferedReader br = null;
 			int responseCode = con.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
 			}else {
 				LoggerApi.Log.info("API Agora HTTP CODE: "+responseCode+" uuid: "+uuid+ " json: "+json);
 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
 			}
 			StringBuilder sb = new StringBuilder();
 			char[] buffer = new char[1000];
 	        int leido;
 	        while ((leido = br.read(buffer)) > 0) {
 	        	sb.append(new String(buffer, 0, leido));
 	        }
 			br.close();
 			con.disconnect();
 			String jsonResponsePayment = sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info("API Agora RESPONSE: "+jsonResponsePayment+" uuid: "+uuid+ " json: "+json);	
 			}
 			paymentResponse = gson.fromJson(jsonResponsePayment, PaymentResponse.class);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
		return paymentResponse;
	}
	
	

	@SuppressWarnings("static-access")
	private Map<Object,String> verificaData(ClientProcedureGetDataClient dataClient) throws Exception   {
		Map<Object,String> resultado = new HashMap<Object, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(sdf.parse(dataClient.getBirthDate()));
		Calendar calendario2 = Calendar.getInstance();
		calendario.add(Calendar.YEAR, 18);
		calendario2.setTime(sdf.parse(dataClient.getBirthDate()));
		calendario2.add(Calendar.YEAR, 101);
		boolean flagEdad = true;
		String expRegMobile = "^9\\d{8}";
		String expRegAddress = "[a-zA-Z0-9°#.,\\sáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ-]+";
		String expRegCode = "\\d{2}";
		String expCouCode = "^[A-Z]{2}$";
		
		//validar nacionalidad        
        Boolean verifyCountry = new RegexValidator(expCouCode).isValid(dataClient.getCountry());        
        if (!verifyCountry) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar una nacionalidad correcta");           
        }
		
		if(calendario.getTime().after(new Date())){
			resultado.put("status", "KO"); 
			resultado.put("message", "Los juegos son solo para mayores de 18 años.");
        	flagEdad = false;
		}
		
		if(calendario2.getTime().before(new Date())){
			resultado.put("status", "KO");
			resultado.put("message", "Los juegos son solo para menores de 101 años.");
        	flagEdad = false;
		}
		
		Boolean verifyBirthDate = DateValidator.getInstance().isValid(dataClient.getBirthDate(), "dd/mm/yyyy");
		if(!verifyBirthDate) {
			resultado.put("status", "KO");
        	resultado.put("message", "Ingresar un formato de fecha correcta");
		}
		
		String verifyEMailString = ClientUtils.verifyEmail(dataClient.getMail()); 
        if (!verifyEMailString.equals("OK")) {
        	resultado.put("status", "KO");
        	resultado.put("message", verifyEMailString);               
        }
        
        Boolean verifyMailString = EmailValidator.getInstance().isValid(dataClient.getMail()) ;
        if (!verifyMailString) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Ingresar una direcci&oacute;n de correo correcto");
        }
        		
		Boolean verifyMobilePhone = new RegexValidator(expRegMobile).isValid(dataClient.getMobilePhone());
         
        if (!verifyMobilePhone) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Ingresar un tel&eacute;fono correcto");
           
        }
        
        //validar domicilio
        Boolean verifyAddress=true;
        if(dataClient.getAddress2().length()>70) {
        	verifyAddress=false;
        	resultado.put("status", "KO");
        	resultado.put("message", "La direcci&oacute;n debe tener menos de 70 caracteres");
        }else {
        	verifyAddress = new RegexValidator(expRegAddress).isValid((dataClient.getAddress2()).trim());        
            if (!verifyAddress) {
            	resultado.put("status", "KO");
            	resultado.put("message", "Ingresar una direcci&oacute;n correcta");           
            }
        }
        
        //validar departamento        
        Boolean verifyDepartamento = new RegexValidator(expRegCode).isValid(dataClient.getRegion());        
        if (!verifyDepartamento) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar un departamento correcto");           
        }
        //validar provincia        
        Boolean verifyProvincia = new RegexValidator(expRegCode).isValid(dataClient.getProvince());        
        if (!verifyProvincia) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar una provincia correcta");           
        }
        //validar distrito        
        Boolean verifyDistrito = new RegexValidator(expRegCode).isValid(dataClient.getDistrict());        
        if (!verifyDistrito) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar un distrito correcto");           
        }
        //validar check no es una persona politicamente expuesta   
        Boolean verifyPpe=true;
        if (!dataClient.getPpe().equals("1")) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar que no es una persona politicamente expuesta");           
        }
         
        if (verifyEMailString.equals("OK") && verifyBirthDate && verifyMailString && verifyMobilePhone && flagEdad
        		&& verifyAddress && verifyDepartamento && verifyProvincia && verifyDistrito && verifyPpe)
        	resultado.put("verificador","true"); 
         else 
        	resultado.put("verificador","false"); 
        
        return resultado;
	}
	
	private ClientProcedureGetDataClient requestDataClient(ClientProcedureGetDataClient dataClient, HttpServletRequest request) {

		
		dataClient.setUser((request.getParameter("user-client")!=null) ? request.getParameter("user-client").trim() : null);
        
        dataClient.setNombre((request.getParameter("name")!=null) ? request.getParameter("name").trim() : null);
        
        dataClient.setApPaterno((request.getParameter("ap-paterno")!=null) ? request.getParameter("ap-paterno").trim() : null);
        	 
        dataClient.setMail((request.getParameter("email")!=null) ? request.getParameter("email").trim().toLowerCase() : null);
        
        dataClient.setBirthDate((request.getParameter("fechanac")!=null) ? request.getParameter("fechanac").trim() : null);
        
        dataClient.setMobilePhone((request.getParameter("mobile-phone")!=null) ? request.getParameter("mobile-phone").trim() : null);
        
        dataClient.setTypeId((request.getParameter("document-type")!=null) ? request.getParameter("document-type").trim() : null);
        
    	if("DNI".equals(dataClient.getTypeId()))
    		dataClient.setNumberId((request.getParameter("document-number")!=null) ? request.getParameter("document-number").trim() : null);
        else if("PASAP".equals(dataClient.getTypeId()))
        	dataClient.setNumberId((request.getParameter("document-number-pasap")!=null) ? request.getParameter("document-number-pasap").trim() : null);
        else if("CAREX".equals(dataClient.getTypeId()))
        	dataClient.setNumberId((request.getParameter("document-number-carex")!=null) ? request.getParameter("document-number-carex").trim() : null);
    	
    	dataClient.setAddress2((request.getParameter("domicilio")!=null) ? request.getParameter("domicilio").trim() : null);
    	dataClient.setRegion((request.getParameter("departamento")!=null) ? request.getParameter("departamento").trim() : null);
    	dataClient.setProvince((request.getParameter("provincia")!=null) ? request.getParameter("provincia").trim() : null);
    	dataClient.setDistrict((request.getParameter("distrito")!=null) ? request.getParameter("distrito").trim() : null);
    	dataClient.setPpe((request.getParameter("ppe")!=null) ? request.getParameter("ppe").trim() : null);
    	dataClient.setCountry((request.getParameter("nacionalidad")!=null) ? request.getParameter("nacionalidad").trim() : null);
    	
        if( request.getParameter("confirm")!=null )
        	dataClient.setConfirm("Y");
        else
        	dataClient.setConfirm("N");
        
		return dataClient;
	}
	
	private JsonObject ClientConvertJson(ClientProcedureGetDataClient dataClient) {
		JsonObject joDataClient = new JsonObject();
		joDataClient.addProperty("user", (dataClient.getUser()!=null ) ? dataClient.getUser() : null);
		joDataClient.addProperty("email", (dataClient.getMail() !=null) ? dataClient.getMail() : null);
		joDataClient.addProperty("luckyIcon", (dataClient.getLuckyIcon() !=null) ? dataClient.getLuckyIcon() : null);
        joDataClient.addProperty("fullName", (dataClient.getNombre() !=null) ? dataClient.getNombre() : null);
        joDataClient.addProperty("typeId", (dataClient.getTypeId() !=null && dataClient.getNumberId() != null) ? dataClient.getTypeId() : null);
        joDataClient.addProperty("numberId", (dataClient.getNumberId() !=null && dataClient.getTypeId() !=null) ? dataClient.getNumberId() : null);
        joDataClient.addProperty("lastName", (dataClient.getApPaterno() !=null) ? dataClient.getApPaterno() : null);
        joDataClient.addProperty("gender", (dataClient.getGender() !=null) ? dataClient.getGender() : null);
        joDataClient.addProperty("birthDate", (dataClient.getBirthDate() !=null) ? dataClient.getBirthDate() : null);
        joDataClient.addProperty("region", (dataClient.getRegion() !=null) ? dataClient.getRegion() : null);
        joDataClient.addProperty("fixedPhone", (dataClient.getFixedPhone() !=null) ? dataClient.getFixedPhone() : null);
        joDataClient.addProperty("mobilePhone", (dataClient.getMobilePhone() !=null) ? dataClient.getMobilePhone() : null);
        //joDataClient.addProperty("mobilePhoneUpdate", dataClient.getMobilePhoneUpdate());
        joDataClient.addProperty("confirm", (dataClient.getConfirm() !=null) ? dataClient.getConfirm() : null);
        
        joDataClient.addProperty("nacionalidad", (dataClient.getCountry() !=null) ? dataClient.getCountry() : null);
        joDataClient.addProperty("nnacionalidad", (dataClient.getNcountry() !=null) ? dataClient.getNcountry() : null);
        joDataClient.addProperty("domicilio", (dataClient.getAddress2() !=null) ? dataClient.getAddress2() : null);
        joDataClient.addProperty("provincia", (dataClient.getProvince() !=null) ? dataClient.getProvince() : null);
        joDataClient.addProperty("distrito", (dataClient.getDistrict() !=null) ? dataClient.getDistrict() : null);
        joDataClient.addProperty("ppe", (dataClient.getPpe()!=null) ? dataClient.getPpe() : null);
        joDataClient.addProperty("nregion", (dataClient.getNregion() !=null) ? dataClient.getNregion() : null);
        joDataClient.addProperty("nprovincia", (dataClient.getNprovince() !=null) ? dataClient.getNprovince() : null);
        joDataClient.addProperty("ndistrito", (dataClient.getNdistrict() !=null) ? dataClient.getNdistrict() : null);       
        LoggerApi.Log.info("joDataClient: "+ joDataClient.toString() );
		return joDataClient;
	}
	
	@RequestMapping(value = "/buildVisaFormAPI")
	public void buildVisaFormAPI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="buildVisaFormAPI";
    	LoggerApi.Log.info("------------- start "+log);
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
     	PrintWriter out = response.getWriter();
    	Gson gsonJson = new Gson();
    	JsonButtonForm jsonButtonForm = null;
		try {
			BufferedReader reader = request.getReader();
			Gson gsonForm = new Gson();
			VisanetParameters paramForm = gsonForm.fromJson(reader, VisanetParameters.class);
			String rechargetoken=request.getHeader("rechargetoken");
			String ip=ClientUtils.getClientIp(request);

			if (paramForm != null) {
				ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();				
				Client client= new Client();
				String pagoTokenUrl="";
				
				//Validar token
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);				
				if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
					Integer idClient = Integer.parseInt(tokenValidation.getClientId());
					accountDataPart = clientSaleBo.findAccountDataPart(idClient);						
					client=clientBo.findByIdClient(idClient);	
					if(tokenValidation.getOperatorId().equals("5586")) {
						pagoTokenUrl=ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT", Constants.contextSale);
					}
					else {
						pagoTokenUrl=ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_TA", Constants.contextSale);
					}
				}else {
					jsonButtonForm = new JsonButtonForm();
					jsonButtonForm.setSessionKey("0");
					String estado=tokenValidation.getStatus();
					if(estado.equals("TIMEOUTTR")) {
						jsonButtonForm.setHtmlText(estado);
					}else {
						jsonButtonForm.setHtmlText("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
					}
					
					out.write(gsonJson.toJson(jsonButtonForm));
					LoggerApi.Log.info("-------------- end buildVisaFormAPI"+" tokenValidation=" +tokenValidation);
					return;
				}							
				
				int visanetMinAmount = 20;
				int visanetMaxAmount = 1000;
				double comision = 0;
				
				//Validar monto ingresado
				String samount = (paramForm.getAmount() != null)? paramForm.getAmount()	: "";
				Boolean veryfyAmount= DoubleValidator.getInstance().isValid(samount);
				if(!veryfyAmount) {
				  jsonButtonForm = new JsonButtonForm();
				  jsonButtonForm.setSessionKey("0");
				  jsonButtonForm.setHtmlText("El monto ingresado es incorrecto");
				  out.write(gsonJson.toJson(jsonButtonForm));
				  return;
				}
				double amount = Double.parseDouble(samount);
				//double amount = Double.parseDouble(paramForm.getAmount());
				if(paramForm.getTypeCard().equals("VISA")) {
					visanetMinAmount = accountDataPart.getAmtMinRechargeVisa().intValue();
					visanetMaxAmount = accountDataPart.getAmtMaxRechargeVisa().intValue();
					
					if(amount>=accountDataPart.getComMinRan1Visa() && amount<=accountDataPart.getComMaxRan1Visa()){
						comision=accountDataPart.getComAmtRan1Visa();
					}else if(amount>=accountDataPart.getComMinRan2Visa() && amount<=accountDataPart.getComMaxRan2Visa()){
						comision=accountDataPart.getComAmtRan2Visa();
					}else if(amount>=accountDataPart.getComMinRan3Visa() && amount<=accountDataPart.getComMaxRan3Visa()){
						comision=accountDataPart.getComAmtRan3Visa();
					}else if(amount>=accountDataPart.getComMinRan4Visa() && amount<=accountDataPart.getComMaxRan4Visa()){
						comision=accountDataPart.getComAmtRan4Visa();
					}
				}else if(paramForm.getTypeCard().equals("AGORA")) {
					visanetMinAmount = accountDataPart.getAmtMinRechargeAgr().intValue();
					visanetMaxAmount = accountDataPart.getAmtMaxRechargeAgr().intValue();
					
					if(amount>=accountDataPart.getComMinRan1Agr() && amount<=accountDataPart.getComMaxRan1Agr()){
						comision=accountDataPart.getComAmtRan1Agr();
					}else if(amount>=accountDataPart.getComMinRan2Agr() && amount<=accountDataPart.getComMaxRan2Agr()){
						comision=accountDataPart.getComAmtRan2Agr();
					}else if(amount>=accountDataPart.getComMinRan3Agr() && amount<=accountDataPart.getComMaxRan3Agr()){
						comision=accountDataPart.getComAmtRan3Agr();
					}else if(amount>=accountDataPart.getComMinRan4Agr() && amount<=accountDataPart.getComMaxRan4Agr()){
						comision=accountDataPart.getComAmtRan4Agr();
					}
				}else {
					jsonButtonForm = new JsonButtonForm();
					jsonButtonForm.setSessionKey("0");
					jsonButtonForm.setHtmlText("Tipo de tarjeta no v&aacute;lido.");
					out.write(gsonJson.toJson(jsonButtonForm));
					return;
				}
				
				if(amount>=visanetMinAmount) {
					if(amount<=visanetMaxAmount) {					
						BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa = balanceSaleBo.resultEvalRulesVisa(client.getIdClient(), amount);
						if(resultEvalRulesVisa.getResult().equals(Constants.RESULT_OK)) {
							VisanetParameters param = new VisanetParameters();
							param.setClientId(client.getIdClient());
							double montoTotal = amount+comision;
							param.setAmount(montoTotal+"");
							param.setRemoteAddr(request.getRemoteAddr());
							param.setCardHolderName(client.getNombre().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a")
									.replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o")
									.replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "")
									.replace("5", "").replace("6", "").replace("7", "").replace("8", ""));
							param.setCardHolderLastName((client.getLastname()+((client.getMaidenname()!=null)?" "+client.getMaidenname():"")).toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i")
									.replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e")
									.replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "").replace("2", "")
									.replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", ""));				
							param.setCardHolderEmail("CID"+client.getIdClient()+"@intralot.com.pe");
							param.setMerchantLogo(paramForm.getMerchantLogo());
							param.setTimeoutUrl(paramForm.getTimeoutUrl());
							//validar activación de bono
							LoggerApi.Log.info("-------------- codigo promocional" +paramForm.getCodePromotional());
							param.setActbono("");
							param.setActwbbono("");
							param.setPagoTokenUrl(pagoTokenUrl);
							param.setTypeCard(paramForm.getTypeCard());
							param.setComision(comision);
							param.setCodePromotional(paramForm.getCodePromotional());
	
							Gson gson = new Gson();
							String json = gson.toJson(param);
							String jsonString = callWsVisaForm(request.getLocalAddr(), json);
							
							jsonButtonForm = gsonJson.fromJson(jsonString, JsonButtonForm.class);
							String sk = jsonButtonForm.getSessionKey();

							ClientProcedureUpdateVisaSession visaSession = clientSaleBo.setVisaSession(client.getIdClient(), sk);
							if(!visaSession.getMessage().equals("OK")) {
								jsonButtonForm = new JsonButtonForm();
								jsonButtonForm.setSessionKey("0");
								jsonButtonForm.setHtmlText("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
								out.write(gsonJson.toJson(jsonButtonForm));
								LoggerApi.Log.info("-------------- end buildVisaFormAPI"+" visaSession.getMessage=" +visaSession.getMessage());
								return;
							}
							
							if (!sk.equals("0")) {
								jsonButtonForm.setSessionKey("");				
								String html=jsonButtonForm.getHtmlText();
								String[] ahtml=html.split("monto");
								ahtml[0]=ahtml[0]+"rechargetoken="+rechargetoken+"&amp;monto";
								html=ahtml[0]+ahtml[1];
								jsonButtonForm.setHtmlText(html);
							}
							//Registrar recarga, identificar plataforma y web de recarga
							String clientId = tokenValidation.getClientId();
							String platform=Constants.PLATAFORM;
							String operatorId=tokenValidation.getOperatorId();
							ClientProcedureOriginVisaRecharge originVisaRecharge = clientSaleBo.setOriginVisaRecharge(sk, clientId, amount, platform, operatorId);
							if(!originVisaRecharge.getStatus().equals("OK")) {
								LoggerApi.Log.info("-------------- buildVisaFormAPI"+" originVisaRecharge.getMessage=" +originVisaRecharge.getMessage());
//								return;
							}
							
							out.write(gsonJson.toJson(jsonButtonForm));
						}else {
							jsonButtonForm = new JsonButtonForm();
							jsonButtonForm.setSessionKey("0");
							jsonButtonForm.setHtmlText(resultEvalRulesVisa.getMessage());
							out.write(gsonJson.toJson(jsonButtonForm));
						}
					} else {
						jsonButtonForm = new JsonButtonForm();
						jsonButtonForm.setSessionKey("0");
						jsonButtonForm.setHtmlText("Debe ingresar un monto de carga no mayor de S/" + visanetMaxAmount + " soles.");
						out.write(gsonJson.toJson(jsonButtonForm));
					}
				} else {
					jsonButtonForm = new JsonButtonForm();
					jsonButtonForm.setSessionKey("0");
					jsonButtonForm.setHtmlText("Debe ingresar un monto de carga a partir de S/" + visanetMinAmount + " soles.");
					out.write(gsonJson.toJson(jsonButtonForm));
				}
			} else {
				jsonButtonForm = new JsonButtonForm();
				jsonButtonForm.setSessionKey("0");
				jsonButtonForm.setHtmlText("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
				out.write(gsonJson.toJson(jsonButtonForm));
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			jsonButtonForm = new JsonButtonForm();
			jsonButtonForm.setSessionKey("0");
			jsonButtonForm.setHtmlText("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
			out.write(gsonJson.toJson(jsonButtonForm));
		}finally {
			LoggerApi.Log.info("------------- end "+log);
		}
	}
	
	@RequestMapping(value = "/registerCA")
	public void registerCA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String ip=ClientUtils.getClientIp(request);
		Integer clientId=0;
		PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        String rechargetoken=request.getHeader("rechargetoken");
		try {
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId = Integer.parseInt(tokenValidation.getClientId());
				String medio = request.getParameter("medio");
				String code = request.getParameter("code");
				String description = request.getParameter("description");
				String monto = request.getParameter("monto");
				String operatorId = request.getParameter("operatorId");
				String website = "LATINKA";
				if(operatorId!=null) {
	 				if(operatorId.equals("5586")) {
	 					website = "LATINKA";
	 				}else if(operatorId.equals("5587")) {
	 					website = "LAPOLLA";
	 				}else if(operatorId.equals("5588")) {
	 					website = "TEAPUESTO";
	 				}
	 			}
				
				Object[] valuesRegisterErrorCA = new Object[8];
				valuesRegisterErrorCA[0] = clientId;
				valuesRegisterErrorCA[1] = ip;
				valuesRegisterErrorCA[2] = "DESKTOP";
				valuesRegisterErrorCA[3] = website;
				valuesRegisterErrorCA[4] = "RECARGA";
				valuesRegisterErrorCA[5] = medio;
				valuesRegisterErrorCA[6] = code;
				valuesRegisterErrorCA[7] = description;
				PaymentPrizeProcedureRegisterErrorCA registerErrorCA = paymentPrizeBo.registerErrorCA(valuesRegisterErrorCA);
				if(registerErrorCA!=null && registerErrorCA.getState()!=null && registerErrorCA.getState().equals("BAN")) {
					Object[] valuesRegisterTYCPDPLog = new Object[10];
					valuesRegisterTYCPDPLog[0] = clientId;
					valuesRegisterTYCPDPLog[1] = "PRE";
					valuesRegisterTYCPDPLog[2] = "BO";
					valuesRegisterTYCPDPLog[3] = ip;
					valuesRegisterTYCPDPLog[4] = "DESKTOP";
					valuesRegisterTYCPDPLog[5] = website;
					valuesRegisterTYCPDPLog[6] = "RECARGA";
					valuesRegisterTYCPDPLog[7] = medio;
					valuesRegisterTYCPDPLog[8] = code;
					valuesRegisterTYCPDPLog[9] = description;
					paymentPrizeBo.registerTYCPDPLog(valuesRegisterTYCPDPLog);
					o.addProperty("ban", "OK");
					
					String body ="<html>" + 
							"<head>" + 
							"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" + 
							"</head>" + 
							"<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>" + 
							"<p>ID de cliente: " + clientId+
							"<br>Metodo: Recarga"+
							"<br>Medio: "+medio+
							"<br>Monto: "+monto+
							"</p>"+ 
							"</body>" + 
							"</html>";

					try {
						MailLib.sendValidMail(ConnectionFactory.operationProperty("mailSourceApp", Constants.contextSale), "LA TINKA", ConnectionFactory.operationProperty("mailTargetAntifraudeRecarga", Constants.contextSale),"Alerta de fraude", body, Constants.FORMAT_HTML_UTF8, null, null, null, null);
					} catch (Exception e) {
						LoggerApi.severe(e);
					}
				}else {
					o.addProperty("ban", "KO");
				}
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
		out.print(o);
	}
	
	@RequestMapping(value = "/findVisanetRecargaResultAPI")
	public void findVisanetRecargaResultAPI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="findVisanetRecargaResultAPI";
    	LoggerApi.Log.info("------------- start "+log);
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		VisanetParameters paramForm = gson.fromJson(reader, VisanetParameters.class);
		LoggerApi.Log.info("------------- pruebaResultApi: "+paramForm.toString());
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=ClientUtils.getClientIp(request);
		Integer clientId=0;
		String sk="";
		String jsonString="";

		PrintWriter out = response.getWriter();

		try {
			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId = Integer.parseInt(tokenValidation.getClientId());
				sk=clientSaleBo.findVisaSessionById(clientId);
				
				jsonString = callWsRecargaResult(request.getLocalAddr(), sk, clientId);
				LoggerApi.Log.info("------------- codigo promocional: "+paramForm.getCodePromotional());
				if (paramForm.getCodePromotional() !=null || !paramForm.getCodePromotional().isEmpty()) {
					JSONObject jsonObject = new JSONObject(jsonString);
					String balanceItem = jsonObject.getString("balanceItem");
					if (!balanceItem.equals("0")) {
						PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(clientId,Integer.parseInt(balanceItem));
						if (promoFistAccount != null) {
							String promotionMessage = promoFistAccount.getPromotion_message();
							if (promotionMessage.equals("OK")) {
								String promotionEco = promoFistAccount.getPromotion_eco();
								jsonObject.put("promotionMessage", promotionEco);
							} else {
								jsonObject.put("promotionMessage", promotionMessage);
							}
							jsonString = jsonObject.toString();
						}
					}
				}
			}else {
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("status", status);
					jsonString = jsonObject.toString();
				}
			}
						
			out.write(jsonString);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}finally {
			LoggerApi.Log.info("------------- end "+log);
		}
	}
		
	@RequestMapping(value = "/send-code-promotional-validation-api")
	public void codePromotionalValidationAPI(@RequestParam("callback") String callback, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String log="codePromotionalValidationAPI";
		LoggerApi.Log.info("-------------- START " +log); 
    	response.setContentType("application/json; charset=UTF-8");
    	//HttpSession session = request.getSession();
    	PinPrinted pinPrinted = null;
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        String rechargetoken=request.getHeader("rechargetoken");
        String ipToken=ClientUtils.getClientIp(request);
        try {
        	String ip = request.getRemoteAddr();
        	String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
        	Double amount = (request.getParameter("amount")!=null && !request.getParameter("amount").isEmpty() )?Double.parseDouble(request.getParameter("amount").toString().trim()):0;
        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";
         	LoggerApi.Log.info("codePromotional="+codePromotional + " amount="+amount);
        	
        	if(amount <= 0 && !channel.equals("IBK")) {
        		o.addProperty("status", "DES");
    			o.addProperty("message", "El monto no debe ser diferente de vacio o cero");
    			return;
        	}
        	
        	//Validar token
    		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
    		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ipToken);
    		if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
	        	String clientId= tokenValidation.getClientId();
	        	
	        	if(!lotocard.trim().isEmpty()) {
	        		pinPrinted = clientSaleBo.findLotocard(lotocard);
	        		if(pinPrinted!=null) {
	        			amount = pinPrinted.getPinAmount();
	        		}else {
	        			o.addProperty("status", "DES");
	        			o.addProperty("message", "C&oacute;digo lotocard no existe");
	        			return;
	        		}
	        	}
	        	
	        	Object[] values = new Object[6];
	        	values[0] = codePromotional.toUpperCase();
	        	values[1] = clientId;
	        	values[2] = channel;
	        	values[3] = "desktop";
	        	values[4] = amount;
	        	values[5] = ip;
	        	
	        	ClientProcedureCodeValidation clientProcedureCodeValidation = clientSaleBo.codePromotionalValidation(values);
	        	if(clientProcedureCodeValidation!=null) {
	        		o.addProperty("status", clientProcedureCodeValidation.getState());
	    			o.addProperty("message", clientProcedureCodeValidation.getMessage());
	    			o.addProperty("idCode", clientProcedureCodeValidation.getIdCodePromotional());
	        	}else {
	        		o.addProperty("status", 500);
	    			o.addProperty("message", "Incidente inesperado");
	        	}
    		}else {
    			String status=tokenValidation.getStatus();
    			if(status.equals("TIMEOUTTR")) {
    				o.addProperty("status", status);
    			}    			
    		}
        }catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("-------------- END "+log+" out="+o.toString());
		}
        
	}
	
	@RequestMapping(value = "/rechargeAgoraAPI")
	public void rechargeAgoraAPI(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String log="rechargeAgoraAPI";
		LoggerApi.Log.info("-------------- START " +log);
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
//			String ip = request.getRemoteAddr();
			String monto = request.getParameter("monto");
			String bono = request.getParameter("actbono");
			String wbbono = request.getParameter("actwbbono");
			String phoneUpdate = request.getParameter("phoneUpdate"); 
			String phoneUpdateAgora = request.getParameter("phoneUpdateAgora");
			String rechargetoken = request.getHeader("rechargetoken");
			String ip=ClientUtils.getClientIp(request);
			double amount = 0.0;
			int clientId = 0;
			LoggerApi.Log.info("ip: "+ip+" monto: "+monto+" bono: "+bono+" wbbono: "+wbbono+" phoneUpdateAgora: "+phoneUpdateAgora+" phoneUpdate: "+phoneUpdate);			
			if(monto!=null && !monto.trim().isEmpty()) {
				amount = Double.parseDouble(monto);
			}
			
			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}else {
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
					o.addProperty("message", Constants.MSG_EXCEPTION);
					out.print(o);
					return;
				}
			}
			
			ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();
			accountDataPart = clientSaleBo.findAccountDataPart(clientId);
			
			if(clientId>0) {
				if(amount<=accountDataPart.getAmtMaxRechargeAgr()) {
					if(amount>=accountDataPart.getAmtMinRechargeAgr()) {
						BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora = balanceSaleBo.resultEvalRulesAgora(clientId, amount);
						if(resultEvalRulesAgora.getResult().equals(Constants.RESULT_OK)) {
							String phone = accountDataPart.getMobilePhone();
							String msgPhoneValidation = "";
							if(accountDataPart.getRechargeAgora().trim().equals(Constants.STATE_WITHOUT_AGORA) && phoneUpdateAgora.equals("1")) {
								phone=phoneUpdate;
					            if(!ClientUtils.verifySintaxMobilePhone(phone)) {
					            	msgPhoneValidation = Constants.MSG_PHONE_INVALID;
					            }else {
					            	ClientProcedureValidateNewPhoneAgora objValidateNewPhoneAgora = clientSaleBo.validateNewPhoneAgora(clientId, phone);
					            	if(objValidateNewPhoneAgora!=null && !objValidateNewPhoneAgora.getResult().equals(Constants.RESULT_OK)) {
					            		msgPhoneValidation = objValidateNewPhoneAgora.getMessage();
					            	}
					            }
							}
							
							if(phone!=null && !phone.trim().isEmpty()) {
								if(msgPhoneValidation.isEmpty()) {
									//validar activación de bono
						            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
						        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
						        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";		        	
						            JsonObject jresult=ClientBalanceController.backCodePromotionalValidation(rechargetoken, ip, request.getRemoteAddr(), 
						            		codePromotional, channel, amount, lotocard, clientSaleBo);
						            bono=jresult.get("bono").getAsString();
						            wbbono=jresult.get("wbbono").getAsString();
						            String promotionKey = codePromotional.toUpperCase();
						            PaymentRequest paymentRequest = new PaymentRequest(); 
					                PaymentResponse paymentResponse = new PaymentResponse(); 
					                paymentRequest.setPlataform(Constants.PLATAFORM);
					                paymentRequest.setPromotionKey(promotionKey);
					                paymentRequest.setAmount(amount);
					                paymentRequest.setPhone(phone);
					                paymentRequest.setClientId(clientId);
					                Gson gson = new Gson();
					    			String json = gson.toJson(paymentRequest);	
					    			LoggerApi.Log.info("paymentRequest: "+paymentRequest.toString());
					                paymentResponse = getPaymentAgoraResponse(json, uuid);
					                LoggerApi.Log.info("paymentResponse: "+paymentResponse.toString());
					               
					                if(paymentResponse!=null) {
					                	if(paymentResponse.getState().equals(Constants.RESULT_OK)) {
					                		o.addProperty("btnName", "Volver a mi cuenta");
						                	String mensaje = "<p style='text-align: center;'>Confirma la recarga desde tu app Agora.</p>";
						                	if(accountDataPart.getRechargeAgora().trim().equals(Constants.STATE_WITHOUT_AGORA)) {
						                		ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora = clientSaleBo.updateStateRechargeAgora(clientId, phoneUpdateAgora, phone);
						                		if(updateStateRechargeAgora!=null && updateStateRechargeAgora.getResult().equals(Constants.RESULT_OK)) {
						                			accountDataPart.setRechargeAgora(Constants.STATE_WITH_AGORA);
						                			//session.setAttribute("accountDataPart",accountDataPart);
						                			if(updateStateRechargeAgora.getStateUpdatePhone().equals(Constants.RESULT_OK)) {
						                				mensaje += "<p style='text-align: justify;'>Para poder ver la recarga en tu cuenta, cierra &eacute;sta sesi&oacute;n, vuelve a iniciarla, y activa tu cuenta con el c&oacute;digo que te enviamos por SMS.</p>";
						                				o.addProperty("btnName", "Cerrar sesi&oacute;n");
						                			}
						                			o.addProperty("stateUpdatePhone", updateStateRechargeAgora.getStateUpdatePhone());
						                		}
						                	}
						                	o.addProperty("state", "OK");
											o.addProperty("message", mensaje);
					                	}else {
					                		String code = paymentResponse.getCode();
					                		if(code!=null && code.trim().equals(Constants.AGORA_ERROR_CODE_ECM_PAY_02)) {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constants.AGORA_MSG_ECM_PAY_02);
					                		}else {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constants.MSG_EXCEPTION);
					                		}
					                	}
					                }else {
					                	o.addProperty("state", "KO");
					    				o.addProperty("message", Constants.MSG_EXCEPTION);
					                }
								}else {
									o.addProperty("state", "KO");
				    				o.addProperty("message", msgPhoneValidation);
								}
							}else {
								o.addProperty("state", "KO");
			    				o.addProperty("message", Constants.MSG_PHONE_INVALID);
							}
						}else {
							o.addProperty("state", "KO");
		    				o.addProperty("message", resultEvalRulesAgora.getMessage());
						}
					}else {
						o.addProperty("state", "KO");
						o.addProperty("message", "Debe ingresar un monto de carga a partir de S/" + accountDataPart.getAmtMinRechargeAgr() + " soles.");
					}
				}else {
					o.addProperty("state", "KO");
					o.addProperty("message", "Debe ingresar un monto de carga no mayor de S/" + accountDataPart.getAmtMaxRechargeAgr() + " soles.");
				}
			}else {
				o.addProperty("state", "KO");
				o.addProperty("message", Constants.MSG_EXCEPTION);
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("state", "KO");
			o.addProperty("message", Constants.MSG_EXCEPTION);
		}finally {
			LoggerApi.Log.info("-------------- END "+ log);
		}
		
	}
	
	private String requestWSIflexApiRecharge(String json, String service) {
    	LoggerApi.Log.info("start requestWSIflexApiRecharge: "+json);
		String jsonResponseIflexApiRecharge="";
		try {
			String urlIflexapiRecharge = ConnectionFactory.operationProperty("urlIflexapiRecharge", Constants.contextRechargeApi);
			String secretIflexapiRecharge = ConnectionFactory.operationProperty("secretIflexapiRecharge", Constants.contextRechargeApi);
			String userIflexapiRecharge = ConnectionFactory.operationProperty("userIflexapiRecharge", Constants.contextRechargeApi);
			String passIflexapiRecharge = ConnectionFactory.operationProperty("passIflexapiRecharge", Constants.contextRechargeApi);
			String credenciales = userIflexapiRecharge+":"+passIflexapiRecharge;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlIflexapiRecharge+service);
// 	    	LoggerApi.Log.info("requestWSIflexApiRecharge: "+" urlIflexapiRecharge="+urlIflexapiRecharge+
// 	    			" secretIflexapiRecharge="+secretIflexapiRecharge+" passIflexapiRecharge="+passIflexapiRecharge+
// 	    			" credenciales="+credenciales+" url="+url.toString());
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
 			con.setRequestProperty("Secret", secretIflexapiRecharge);
 			con.setRequestProperty("Content-Type", Constants.APPLICATION_JSON);
 			con.setRequestProperty("Accept", Constants.APPLICATION_JSON);
     		con.setDoOutput(true);
     		OutputStream os = con.getOutputStream();
 			os.write(json.getBytes(Constants.CHARSET_UTF8));
 			os.flush();
 			os.close();
 			BufferedReader br = null;
 			int responseCode = con.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
 			}else {
 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE HTTP CODE: "+responseCode + " json: "+json);
 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
 			}
 			StringBuilder sb = new StringBuilder();
 			char[] buffer = new char[1000];
 	        int leido;
 	        while ((leido = br.read(buffer)) > 0) {
 	        	sb.append(new String(buffer, 0, leido));
 	        }
 			br.close();
 			con.disconnect();
 			jsonResponseIflexApiRecharge = sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE"+ service+"Response: "+jsonResponseIflexApiRecharge + " json: "+json);	
 			}
 			LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE "+service+"Response: "+jsonResponseIflexApiRecharge);
		} catch (Throwable e) {
			LoggerApi.severe(e);
		}finally {
			LoggerApi.Log.info("start requestWSIflexApiRecharge: "+jsonResponseIflexApiRecharge);
		}
		return jsonResponseIflexApiRecharge;
	}
	
	public static JsonObject backCodePromotionalValidation(String rechargetoken, String ipToken, String ip, 
			String codePromotional, String channel, Double amount, String lotocard, ClientSaleBo clientSaleBo) throws Exception {
		String log="backCodePromotionalValidation";
		LoggerApi.Log.info("-------------- START " +log); 
    	PinPrinted pinPrinted = null;
    	JsonObject o = new JsonObject();
    	String wbbono="false", bono="false";
        try {
        	//Validar token
    		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
    		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ipToken);
    		if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
	        	String clientId= tokenValidation.getClientId();
	        	
	        	if(!lotocard.trim().isEmpty()) {
	        		pinPrinted = clientSaleBo.findLotocard(lotocard);
	        		if(pinPrinted!=null) {
	        			amount = pinPrinted.getPinAmount();
	        		}else {
	        			o.addProperty("status", "DES");
	        			o.addProperty("message", "C&oacute;digo lotocard no existe");
	        			return o;
	        		}
	        	}
	        	
	        	Object[] values = new Object[6];
	        	values[0] = codePromotional;
	        	values[1] = clientId;
	        	values[2] = channel;
	        	values[3] = "desktop";
	        	values[4] = amount;
	        	values[5] = ip;
	        	
	        	ClientProcedureCodeValidation clientProcedureCodeValidation = clientSaleBo.codePromotionalValidation(values);
	        	if(clientProcedureCodeValidation!=null) {
	    			LoggerApi.Log.info(log+" message="+clientProcedureCodeValidation.getMessage());
	    	        	
	    	        if(clientProcedureCodeValidation.getState().equals("ACT")) {
	    				String idCode=clientProcedureCodeValidation.getIdCodePromotional();
	    				String codePromotion = clientProcedureCodeValidation.getPromotionCode();
	    	        	if(codePromotion != null && !codePromotion.isEmpty()){
	    	        		bono="true";
	    	        	}   	  
	    			}
	        	}else {
	        		o.addProperty("status", 500);
	    			o.addProperty("message", "Incidente inesperado");
	        	}
    		}else {
    			String status=tokenValidation.getStatus();
    			if(status.equals("TIMEOUTTR")) {
    				o.addProperty("status", status);
    			}    			
    		}
        }catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			LoggerApi.severe(e);
		} finally {
			o.addProperty("wbbono", wbbono);
			o.addProperty("bono", bono);
			LoggerApi.Log.info("-------------- END "+log+" out="+o.toString());
		}
		return o;
	}
	
	private ClientProcedureGetDataClient JsonConvertClient(JsonObject joDataClient) {
		ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
		dataClient.setUser(joDataClient.has("usuario")? joDataClient.get("usuario").getAsString():null);
		dataClient.setMail(joDataClient.has("email")? joDataClient.get("email").getAsString():null);
		dataClient.setNombre(joDataClient.has("nombres")?joDataClient.get("nombres").getAsString():null);
		dataClient.setTypeId(joDataClient.has("tipoDocumento")?joDataClient.get("tipoDocumento").getAsString():null);
		dataClient.setNumberId(joDataClient.has("numeroDocumento")?joDataClient.get("numeroDocumento").getAsString():null);
		dataClient.setApPaterno(joDataClient.has("apellidos")?joDataClient.get("apellidos").getAsString():null);
		dataClient.setGender(joDataClient.has("gender")?joDataClient.get("gender").getAsString():null);
		dataClient.setBirthDate(joDataClient.has("fechaNacimiento")?joDataClient.get("fechaNacimiento").getAsString():null);
		dataClient.setRegion(joDataClient.has("departamento")?joDataClient.get("departamento").getAsString():null);
		dataClient.setMobilePhone(joDataClient.has("celular")?joDataClient.get("celular").getAsString():null);
		dataClient.setConfirm(joDataClient.has("confirm")?joDataClient.get("confirm").getAsString():null);
		dataClient.setAddress2(joDataClient.has("direccion")?joDataClient.get("direccion").getAsString():null);
		dataClient.setProvince(joDataClient.has("provincia")?joDataClient.get("provincia").getAsString():null);
		dataClient.setDistrict(joDataClient.has("distrito")?joDataClient.get("distrito").getAsString():null);
		dataClient.setPpe(joDataClient.get("ppeFlag").getAsString().equals("1")?joDataClient.get("ppeFlag").getAsString():null);
		dataClient.setNregion(joDataClient.has("ndepartamento")?joDataClient.get("ndepartamento").getAsString():null);
		dataClient.setNprovince(joDataClient.has("nprovincia")?joDataClient.get("nprovincia").getAsString():null);
		dataClient.setNdistrict(joDataClient.has("ndistrito")?joDataClient.get("ndistrito").getAsString():null);
		dataClient.setCountry(joDataClient.has("nacionalidad")?joDataClient.get("nacionalidad").getAsString():null);
		dataClient.setNcountry(joDataClient.has("nnacionalidad")?joDataClient.get("nnacionalidad").getAsString():null);
		dataClient.setInsertDate(joDataClient.has("insertDate")?joDataClient.get("insertDate").getAsString():null);
		
		LoggerApi.Log.info("dataClient: "+ dataClient.toString() );
		
		
		return dataClient;
	}
	
	
	@RequestMapping(value = "/internavegacion/{game}", method = RequestMethod.GET)
	public String internavegacionLoyalty(@PathVariable("game") String game, @RequestParam(value="token",required = true)  String token,
			HttpServletRequest request, HttpServletResponse response) {
		// definir log
		String log="Loyalty ";
		LoggerApi.Log.info("================== START "+log);
		
		//validar game, token y request
		if(game.isEmpty() || token.isEmpty() || request.getRemoteAddr() == null) {
			LoggerApi.Log.info("Error token --> game: "+game);
			invalidateSession(request);
			return "redirect:/";
		}
		
		//validar el game
		if(!(game.equals("tinka") || game.equals("kinelo") || game.equals("kabala") || game.equals("ganadiario") || game.equals("ganagol"))) {
			LoggerApi.Log.info("Error datos --> game: "+game);
			invalidateSession(request);
			return "redirect:/";
		}
		
		LoginDataResponse responseLogin = new LoginDataResponse();
		Gson gson = new Gson();
		try {
			// validar el game
			if(game != null && token != null && !game.isEmpty() && !token.isEmpty()) {
				String ip = request.getRemoteAddr();
				LoggerApi.Log.info(log + " game="+ game + " token="+ token + "ip="+request.getRemoteAddr());	
			    Map<String,String> headers = new HashMap<String,String>();
				headers.put("X-Ip-Origin", "192.68.1.1");
				headers.put("X-Company", "ECOM");
				String tokenResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+token, "12345678", "12345678", headers);
				responseLogin = gson.fromJson(tokenResponse, LoginDataResponse.class);
				LoggerApi.Log.info("responseLogin="+responseLogin.getResult());
				if (responseLogin.getResult() != null) { //login exitoso
					//abrir una session
					HttpSession session = request.getSession();							
					//crear la session y cargar data
					securityUtils.createSession(responseLogin.getResult(), clientSaleBo, session, ip, response);
					//dirigir a la url
					LoggerApi.Log.info("redirect:/"+ "juega-" + game + ".html");
					return "redirect:/"+ "juega-" + game + ".html";
				} else {
					invalidateSession(request);
				}
			}else {
				return "redirect:/mi-cuenta.html";
			}
		  return "redirect:/mi-cuenta.html";
		} catch(Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info(log + " index");
			return "index";
		} finally {
			LoggerApi.Log.info("================== END ClientBalanceController/internavegacion/");
		}
	}
	
	// Método para invalidar la sesión si existe
	private void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);  // Obtener la sesión si existe, sin crear una nueva
        if (session != null) {
            session.invalidate();  // Invalidar la sesión
        }
    }

	
	@RequestMapping("/redirect")
	public String redirect(@RequestParam("token") String tokenRequest, @RequestParam(value = "source", required = false) String source, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginDataResponse responseLogin = new LoginDataResponse();
		Gson gson = new Gson();

		if (source != null && !source.equals("activation")) {
		    LoggerApi.Log.info("Valor inesperado para source: " + source);
		    source = null;
		}

		try {
		    LoggerApi.Log.info("Esta es tokenRequest " + tokenRequest);
		    String ip = request.getRemoteAddr();
		    LoggerApi.Log.info("Esta es ip "+request.getRemoteAddr());
		    String where = (request.getParameter("where") == null ? "" : request.getParameter("where"));
		    String ref = (request.getParameter("ref") == null ? "" : request.getParameter("ref").replaceAll("\\/", "").replaceAll("\\*", "/"));
			if (tokenRequest != null && ip != null) {
				Map<String,String> headers = new HashMap<String,String>();
				headers.put("X-Ip-Origin", "192.68.1.1");
				headers.put("X-Company", "ECOM");
				//obtiene token
				String tokenResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+tokenRequest, "12345678", "12345678", headers);
				responseLogin = gson.fromJson(tokenResponse, LoginDataResponse.class);
				LoggerApi.Log.info("tokenResponse="+tokenResponse);
				LoggerApi.Log.info("exitoso responseLogin.getResult()="+responseLogin.getResult());
				if (responseLogin.getResult() != null ) { //login exitoso
					String status = responseLogin.getResult().getStatus();
	                LoggerApi.Log.info("status=" + status);
					HttpSession session = request.getSession();
					
					session.setAttribute("tycPdpInitLogin", "1");

					if(!securityUtils.validarSession(request, responseLogin.getResult(), response)) {
						LoggerApi.Log.info("Entro a validar session - proteccion usuario ");
						return "redirect:validacion-datos.html";
					}

					securityUtils.createSession(responseLogin.getResult(), clientSaleBo, session, ip, response);
					LoggerApi.Log.info("where="+where);

					if( where != null && where.equals("loginteapuesto")) {
						String producto = ( ref == null ? "sport" : ref.replaceFirst("\\/", "") );
						request.setAttribute("producto",producto);
						LoggerApi.Log.info("producto="+producto);
						return "game/teapuesto/tav2_template";    
					}
					
					if( where != null && where.equals("") && responseLogin.getResult().getResponseService() != null  && Integer.parseInt(responseLogin.getResult().getResponseService().getResponseButton()) == 145 && responseLogin.getResult().getResponseService().getLogin().equals("ta")) {
						return "redirect:/mi-cuenta.html#yo-cambiar-pwd";
					}
					
					//Parametro para cerrar sesion de TeApuesto en otro dispositivo
					session.setAttribute("openSession","openSession");
					if( where != null && where.equals("") && responseLogin.getResult().getResponseService() != null && Integer.parseInt(responseLogin.getResult().getResponseService().getResponseButton()) == 145 && responseLogin.getResult().getResponseService().getLogin().equals("ecommerce") ) {
						return "redirect:/mi-cuenta.html";
					}
					if (StringUtils.equals(Constants.GameTeapuesto.DISPLAY_AVIONPERU, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        return "redirect:/avion-del-hincha-te-lleva-eliminatorias-peru.html";
                    }

					if( source != null && source.equals("activation")) {
						if(responseLogin != null && responseLogin.getResult() != null 
								&& (responseLogin.getResult().getMobileUpdate() != null && responseLogin.getResult().getMobileUpdate().equals("Y"))) {
							LoggerApi.Log.info("redirect:/bienvenido.html");
							return "redirect:/bienvenido.html";    
						}
					};
					
					LoggerApi.Log.info(" despues if ");
				}
			}
			return "redirect:/mi-cuenta.html";
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("index");
			return "index";
		} finally {
			LoggerApi.Log.info("-------------- END ClientBalanceController/redirect");
		}
	}
	
	
	@RequestMapping("/respuesta-lista")
	public String respuestaLista(@RequestParam("param1") String param1,
	                             @RequestParam("param2") String param2,
	                             @RequestParam("param3") String param3,
	                             @RequestParam(value = "action", required = false) String action,
	                             HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String no_user = "";
	    try {
	        String client_id = StringLib.decodeLabel(param1);
	        int p_client_id = Integer.parseInt(client_id);
	        String ip = StringLib.decodeLabel(param2);
	        String respuesta = StringLib.decodeLabel(param3);
	        
	        // Verificar que las variables no sean null ni estén vacías
	        if (client_id == null || client_id.isEmpty() || ip == null || ip.isEmpty() || respuesta == null || respuesta.isEmpty()) {
	            LoggerApi.Log.info("proteccion de usuario - variables nulas o vacias");
	            return "redirect:/inicio.html"; 
	        }
	        
	        GetClientSecurity result_cliente = clientSaleBo.getipWhitelist(p_client_id, ip);
	     
	        if(result_cliente.getStatus() != null && result_cliente.getStatus().equals("ERROR_UPDATE")) {
	        	LoggerApi.Log.info("Error ---- redirect:/home.html " + result_cliente.getStatus());
	        	return "redirect:/inicio.html"; 
	        }else {
			    if(respuesta.equals("SI")) {
			    	
	    	        String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constants.contextSale);
	    	        
	    	        if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true")) {
	    	        
			            ClientSecurityWhiteList result = clientSaleBo.updateipWhitelis(p_client_id, ip, "SI", "DESKTOP");
			            //Si se realiza el update a la lista blanca correctamente retorna un Ok
			            if ("OK".equals(result.getStatus())) {
			                LoggerApi.Log.info("result: Se actualizó el estado de la IP en la lista blanca ");
			                request.setAttribute("result_mensaje", result.getMensaje());
			                return "client/confirmation_ip_user"; // Redirigir al JSP correspondiente
			            } else {
			            	LoggerApi.Log.info("status !OK: " + result.getStatus());
			            	return "redirect:/inicio.html"; 
			            }
	    	        	
	    	        }

			    } else if(respuesta.equals("NO")) { 
		    	 	
		        	if(action == null || action.isEmpty()) {
		        		return "client/validate_not_user"; // Redirigir al jsp validate_not_user
		        	}
		        	no_user = action.trim();
		        	LoggerApi.Log.info("no_user: " + no_user);
		        	if(no_user!=null && no_user.equals("no_user")) {
		    	        String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constants.contextSale);
		    	        
		    	        if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true")) {
			        		 ClientSecurityWhiteList result = clientSaleBo.updateipWhitelis(p_client_id, ip, "NO","DESKTOP");
			        		 if(result.getStatus().equals("ERROR")) {
			        			 o.addProperty("status", "ERROR");
			        			 out.print(o);
			 	            	LoggerApi.Log.info("result: " + "La ip del usuario a sido registrado en la lista negra");
			 	            	request.setAttribute("url", ConnectionFactory.operationProperty("url_restablecer_contrasenia", Constants.contextSale));
			 	            	return "client/redirect_cuenta_restablecer";
			 	            } else {
			 	            	LoggerApi.Log.info("status: !ERROR" + result.getStatus());	
			 	           	return "redirect:/inicio.html"; 
				            }	    	        	
		    	        }
		        	}
		        	
		      } else {
		        	LoggerApi.Log.info("Error de respuesta: " + respuesta + "client_id: " + client_id + "ip: " + ip);
		        	return "redirect:/inicio.html"; 
	          }
	     }
	        
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    	LoggerApi.Log.info("Error " + e);
	    	 return "redirect:/inicio.html"; 
	    }
		return "";
	}
	
	@RequestMapping(value = "/yapePlinTupayVerifyTransactionAPI")
    public void yapePlinTupayVerifyTransactionAPI(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String log="yapePlinTupayVerifyTransactionAPI";
		LoggerApi.Log.info("-------------- start "+log);
		JsonObject o = new JsonObject();
		try {			
			response.setCharacterEncoding(Constants.CHARSET_UTF8);
			PrintWriter out = response.getWriter();	        
	        String rechargetoken=request.getHeader("rechargetoken");
	        String ip=ClientUtils.getClientIp(request);
	        
	        //Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
	        
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				Integer idClient = Integer.parseInt(tokenValidation.getClientId());	
				String channel = request.getParameter("channel");
				
				ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction = clientSaleBo.yapePlinTupayVerifyTransaction(idClient, channel);
				if(yapePlinTupayVerifyTransaction!=null && yapePlinTupayVerifyTransaction.getStatus().trim().equals("ACT")) {
					ClientProcedureAccountDataPart clientProcedureAccountDataPart = clientSaleBo.findAccountDataPart(idClient);
					o.addProperty("status", "ACT");
					o.addProperty("billetera1", clientProcedureAccountDataPart.getBalanceAmount());
					o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))));
					o.addProperty("billetera3", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("billetera3Cant", clientProcedureAccountDataPart.getOtherAmount());
					o.addProperty("amount", yapePlinTupayVerifyTransaction.getAmount());
					
					if(yapePlinTupayVerifyTransaction.getPromotionMessage()!=null || yapePlinTupayVerifyTransaction.getPromotionEco()!=null) {
						String promotionMessage = yapePlinTupayVerifyTransaction.getPromotionMessage();
						if (promotionMessage.equals("OK")) {
							String promotionEco = yapePlinTupayVerifyTransaction.getPromotionEco();
							o.addProperty("promotionMessage", promotionEco);
						} else {
							o.addProperty("promotionMessage", promotionMessage);
						}
					}
				}else{
					String mensaje = "";
					if(channel.trim().equals("YAPE")) {
						mensaje="Aún no se ha realizado el pago de tu código QR YAPE";
					}else if(channel.trim().equals("PLIN")) {
						mensaje="Aún no se ha realizado el pago de tu código QR PLIN";
					}				
					o.addProperty("status", "PEN");
					o.addProperty("message", mensaje);
				}
			}else {
				if(tokenValidation.getStatus().equals("TIMEOUTTR")) {
					o.addProperty("status", tokenValidation.getStatus());
				}else {
					o.addProperty("status", "ERROR");
					o.addProperty("message", "debe autenticarse");
				}
				
			}
			out.print(o);
		} catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        	LoggerApi.Log.info("-------------- end "+log);
		}
	}
	
	private String transformeBalanceListFilter(String resultClient,List<BalanceProcedureGetBalanceListFilter> balanceList,  UserBean userBean, HttpSession session ,ClientProcedureAccountDataPart clientProcedureAccountDataPart, Integer i ) {
		userBean.setpMonto(balanceList.get(0).getNewAmount());
        session.setAttribute(Constants.USR_SESION, userBean);
        
        Double montoPrevio = 0.0;
        Double nuevoMonto = 0.0;

        montoPrevio = balanceList.get(0).getPrevAmount();
        resultClient += i++ + "|";//Item
        resultClient += balanceList.get(0).getDescription() + "|";//Descripcion
        resultClient += balanceList.get(0).getBalanceDate() + "|"; // fecha para el filtro
        resultClient += balanceList.get(0).getPrevAmount() + "|"; //monto previo
        resultClient += balanceList.get(0).getLoadAmount() + "|"; // monto cargado
        resultClient += (balanceList.get(0).getNewAmount()+balanceList.get(0).getCommissionRecharge()+balanceList.get(0).getCommissionRequest()) + "|";
        resultClient += balanceList.get(0).getNeoprizeAmount() + "|"; // Monto ganado
        resultClient += (ClientUtils.formatAmountBalance(balanceList.get(0).getKironprizeAmount()+balanceList.get(0).getNeoprizeAmount())) + "|";
        resultClient += clientProcedureAccountDataPart.getBalanceAmount() + "|";
        resultClient += ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))) + "|";
        resultClient += clientProcedureAccountDataPart.getOtherAmount() + "|";
        resultClient += (balanceList.get(0).getCommissionRecharge()!=0?balanceList.get(0).getCommissionRecharge():"-") + "|";
        resultClient += (balanceList.get(0).getCommissionRequest()!=0?balanceList.get(0).getCommissionRequest():"-") + "#";
        //resultClient += balanceList.get(0).getSales_channel() + "#"; // canal de venta
        if(balanceList.size()>1) {
        	for (int j = 1; j < balanceList.size(); j++) {
        		nuevoMonto = balanceList.get(j).getNewAmount();
        		Double montoPrevioTemp = 0.0;
        		Double commissionRecharge = 0.0;
        		Double commissionRequest = 0.0;
        		if(montoPrevio.doubleValue()==nuevoMonto.doubleValue() && (balanceList.get(j).getCommissionRecharge()>0 || balanceList.get(j).getCommissionRequest()>0)) {
        			if(balanceList.get(j).getCommissionRecharge()<0) {
        				commissionRecharge=balanceList.get(j).getCommissionRecharge()*-1;
        			}else {
        				commissionRecharge=balanceList.get(j).getCommissionRecharge();
        			}
        			
        			if(balanceList.get(j).getCommissionRequest()<0) {
        				commissionRequest=balanceList.get(j).getCommissionRequest()*-1;
        			}else {
        				commissionRequest=balanceList.get(j).getCommissionRequest();
        			}
        			
        			montoPrevioTemp=balanceList.get(j).getPrevAmount()-commissionRecharge-commissionRequest;
        			//nuevoMonto=balanceList.get(j).getNewAmount();
        		}else {
        			montoPrevioTemp=balanceList.get(j).getPrevAmount();
        			nuevoMonto=balanceList.get(j).getNewAmount()+balanceList.get(j).getCommissionRecharge()+balanceList.get(j).getCommissionRequest();
        		}
        		montoPrevio = balanceList.get(j).getPrevAmount();
        		
                resultClient += i++ + "|";
                resultClient += balanceList.get(j).getDescription() + "|";
                resultClient += balanceList.get(j).getBalanceDate() + "|";
                resultClient += montoPrevioTemp + "|";
                resultClient += balanceList.get(j).getLoadAmount() + "|";
                resultClient += nuevoMonto + "|";
                resultClient += balanceList.get(j).getNeoprizeAmount() + "|";
                resultClient += (ClientUtils.formatAmountBalance(balanceList.get(j).getKironprizeAmount()+balanceList.get(j).getNeoprizeAmount())) + "|";
                resultClient += clientProcedureAccountDataPart.getBalanceAmount() + "|";
                resultClient += ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountDataPart.getBonusAmount().replaceAll(",","."))) + "|";
                resultClient += clientProcedureAccountDataPart.getOtherAmount() + "|";
                resultClient += (balanceList.get(j).getCommissionRecharge()!=0?balanceList.get(j).getCommissionRecharge():"-") + "|";
                resultClient += (balanceList.get(j).getCommissionRequest()!=0?balanceList.get(j).getCommissionRequest():"-") + "#";
               // resultClient += balanceList.get(j).getSales_channel() + "#"; // canal de venta
			}
        }
		return resultClient;
	}
	
	@RequestMapping(value = "/edit_client_autopayment_flag")
    public void editClientAutoPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- edit_client_autopayment_flag START");
		PrintWriter out = null;
	    String json = "";
	
        try {
            out = response.getWriter();
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute(Constants.USR_SESION) == null) {
                LoggerApi.Log.severe("-------------- ERROR edit_client_autopayment_flag: No hay sesión activa");
            } else {
                Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                String flagAutoPayment = request.getParameter("autoPayEnabled");

                LoggerApi.Log.info("idClient: " + idClient);
                LoggerApi.Log.info("stateFlag recibido: " + flagAutoPayment);

                if (flagAutoPayment == null || flagAutoPayment.trim().isEmpty()) {
                    LoggerApi.Log.info("-------------- ERROR edit_client_autopayment_flag: Parametro faltante autoPayEnabled");
                } else {
                	String switchStatus = Boolean.parseBoolean(flagAutoPayment) ? "WEB" : "PDV";
                	ClientInformationResponseDTO clientInformationRequestDTO = clientSaleBo.updateAutoPaymentFlag(idClient, switchStatus);
                	json = gson.toJson(clientInformationRequestDTO);
                }
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("-------------- END edit_client_autopayment_flag");
            if (out != null) {
                out.print(json);
                out.close();
            }
        }
    }
    
    @RequestMapping(value = "/get_client_autopayment_flag")
    public void getClientAutoPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- getClientAutoPayment Controller START");
		PrintWriter out = null;
        String json = "";

        try {
            out = response.getWriter();
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute(Constants.USR_SESION) == null) {
                LoggerApi.Log.severe("-------------- getClientAutoPayment ERROR: No hay sesión activa");
            } else {
                Integer idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                ClientInformationResponseDTO clientInformationRequestDTO = clientSaleBo.getClientAutoPayment(idClient);
                json = gson.toJson(clientInformationRequestDTO);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("-------------- END getClientAutoPayment Controller");
            if (out != null) {
                out.print(json);
                out.close();
            }
        }
    }
	
}
