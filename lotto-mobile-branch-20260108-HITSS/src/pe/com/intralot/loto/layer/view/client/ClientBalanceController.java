package pe.com.intralot.loto.layer.view.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.controller.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.agora.PaymentRequest;
import pe.com.intralot.loto.layer.dto.agora.PaymentResponse;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceInformationRequestDTO;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceInformationResponseDTO;
import pe.com.intralot.loto.layer.dto.visa.JsonButtonForm;
import pe.com.intralot.loto.layer.dto.visa.PagoParameters;
import pe.com.intralot.loto.layer.dto.visa.VisanetParameters;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetMontoPorDia;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetMontoPorDiaAgora;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.pojo.BonoOtroJuego;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCodeValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBalanceList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBalanceListFilter;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetGamesBonusList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoBonusList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoPromoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginVisaRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateStateRechargeAgora;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateVisaSession;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureValidateNewPhoneAgora;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureRegisterErrorCA;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;
import pe.com.intralot.loto.layer.model.pojo.ProcedureDefineTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedurePayTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinTupayVerifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinVerifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.PromoFirstAccount;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;

import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.MailLib;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.utils.TSLSocketConnectionFactory;
import pe.com.intralot.loto.www.sale.client.lib.WebConsts;

/**
 * <p>
 * NOMBRE: ClientBalanceController.java <br>
 * </p>
 * <p>
 * FUNCION: Controlador movimientos de cuenta <br>
 * </p>
 * <p>
 * NOTAS: Ninguna. <br>
 * </p>
 * <p>
 * VERSIONES
 * 
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Depuración de comentarios e imports sobrantes
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * 
 * <br>
 * </p>
 */

@Controller
public class ClientBalanceController {

	@Autowired
	private ClientBalanceBo beanClientBalanceBo;

	@Autowired
	private ClientLotocardBo beanClientLotocardBo;

	@Autowired
	private IntralotUtils intralotUtils;

	@Autowired
	private ClientAccountBo beanClientAccountBo;
	
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;
	
	@Autowired
    private ClientSaleBo clientSaleBo;
	
	private final Gson gson = new Gson();
	
	@RequestMapping(value = "/recarga-epago")
    public String payment_prizes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "client/interface-recarga_epago";
    }
		
	@RequestMapping(value = "/validacion-datos")
    public String validacion_datos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "client/validacion_datos";
    }
	
    @RequestMapping(value = "/errorIzipay")
   	public void error_epago_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
   			throws Exception {
   		String uuid = UUID.randomUUID().toString().replace("-", "");
   		LoggerApi.Log.info("-------------- START errorIzipay");
   		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
   		PrintWriter out = response.getWriter();
   		JsonObject o = new JsonObject();
   		try {
 			String uniqueIdentifier = request.getParameter("uniqueIdentifier");
 			String number = request.getParameter("number");
 			String brand = request.getParameter("brand");
 			String amount = request.getParameter("amount");
 			String code = request.getParameter("code");
 			String rechargetoken = request.getHeader("rechargetoken");
			String ip=SecurityUtils.getClientIp(request);
 			String operatorId = request.getParameter("operatorId");
 			String jsonRequest = request.getParameter("json_request");
 			String jsonResponse = request.getParameter("json_response");
 			String platform = Constantes.PLATAFORM;
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
 			
 			String idClient = "";
 			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient = tokenValidation.getClientId();
			}else {				
				o.addProperty("state", "KO");
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
				}
				o.addProperty("message", Constantes.MSG_EXCEPTION);
				out.print(o);
				LoggerApi.Log.info("tokenValidation ="+tokenValidation.toString());
				return;
			}	
 			clientId = Integer.parseInt(idClient);
			
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
                beanClientBalanceBo.registerErrorIzipay(values);    
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                o.addProperty("fecha", sdf.format(new Date()));
                o.addProperty("state", "OK");
			}else {
 				o.addProperty("state", "KO");
 				o.addProperty("message", Constantes.MSG_EXCEPTION);
 			}
 			out.print(o);
   		} catch (Exception e) {
 			LoggerApi.severe(e);
 			o.addProperty("state", "KO");
 			o.addProperty("message", Constantes.MSG_EXCEPTION);
 		}
 		LoggerApi.Log.info("-------------- END errorIzipay");
 	}
    
    @RequestMapping(value = "/defineRechargeIzipay")
 	public void define_recharge_izipay(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
 			throws Exception {
    	String uuid = UUID.randomUUID().toString().replace("-", "");
 		LoggerApi.Log.info("-------------- START defineRechargeIzipay");
 		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
 		PrintWriter out = response.getWriter();
 		JsonObject o = new JsonObject();
	 	try {
 			String amount = request.getParameter("amount");
 			String actbono = request.getParameter("actbono");
 			String actwbbono = request.getParameter("actwbbono");
 			String codePromotional = request.getParameter("codePromotional"); 
 			String rechargetoken = request.getHeader("rechargetoken");
 			String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
			String ip=SecurityUtils.getClientIp(request);
 			String operatorId = request.getParameter("operatorId");
 			String platform = Constantes.PLATAFORM;
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
 			LoggerApi.Log.info("ip: "+ip+" amount: "+amount+" actbono: "+actbono+" actwbbono: "+actwbbono+" codePromotional: "+codePromotional+" channel:"+channel + " operatorId" + operatorId);			
 			if(amount!=null && !amount.trim().isEmpty()) {
 				amountD = Double.parseDouble(amount);
 			}
 			
 			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=Integer.parseInt(tokenValidation.getClientId());
			}else {
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
					o.addProperty("message", Constantes.MSG_EXCEPTION);
					out.print(o);
					return;
				}
			}
 			 			
 			if(clientId>0) {	
 				LoggerApi.Log.info("ip: "+ip+" amount: "+amount+" codePromotional: "+codePromotional+" channel:"+channel);	
 				Object[] values = new Object[7];
                values[0] = ip;
                values[1] = amountD;
                values[2] = codePromotional;
                values[3] = operatorId;
                values[4] = platform;
                values[5] = website;
                values[6] = clientId;
                ProcedureDefineTransactionIzipay defineTransactionIzipay = beanClientBalanceBo.defineTransactionIzipay(values);
                LoggerApi.Log.info("-------------- IdTransactionIzipay "+defineTransactionIzipay.getIdTransactionIzipay());                
                o.addProperty("idTransactionIzipay", defineTransactionIzipay.getIdTransactionIzipay());
                o.addProperty("state", defineTransactionIzipay.getStatus());
                if(defineTransactionIzipay!=null && defineTransactionIzipay.getStatus()!=null && defineTransactionIzipay.getStatus().equals(Constantes.RESULT_OK)) {
                	String signature = Constantes.generateSignatureSHA512(Constantes.EPAGO_API_KEY+defineTransactionIzipay.getIdTransactionIzipay()+"PEN"+amount+Constantes.EPAGO_SECRET_KEY);
                	LoggerApi.Log.info("-------------- signature Ok");    
                	if(!signature.equals("ERROR")) {
                		o.addProperty("signature", signature);
                		o.addProperty("apiKey", Constantes.EPAGO_API_KEY);
                	}else {
                		o.addProperty("state", "ERROR");
                		o.addProperty("message", Constantes.MSG_EXCEPTION);
                	}
                }else {
                	o.addProperty("state", "KO");
                	o.addProperty("message", Constantes.MSG_EXCEPTION);
                }
 			}else {
 				o.addProperty("state", "KO");
 				o.addProperty("message", Constantes.MSG_EXCEPTION);
 			}
	 		
	 		out.print(o);
 		} catch (Exception e) {
 			LoggerApi.severe(e);
 			o.addProperty("state", "KO");
 			o.addProperty("message", Constantes.MSG_EXCEPTION);
 		}
 		LoggerApi.Log.info("-------------- END defineRechargeIzipay");
    }
    
    @RequestMapping(value = "/rechargeIzipay")
 	public void recarga_epago_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
 			throws Exception {
 		String uuid = UUID.randomUUID().toString().replace("-", "");
 		LoggerApi.Log.info("-------------- START rechargeIzipay");
 		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
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
			String ip=SecurityUtils.getClientIp(request);
 			String operatorId = request.getParameter("operatorId");
 			String jsonRequest = request.getParameter("json_request");
 			String jsonResponse = request.getParameter("json_response");
 			String idIzipay = request.getParameter("idIzipay");
 			String platform = Constantes.PLATAFORM;
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
 					+" created: "+created+" code: "+code+" message: "+message+" operationNumber: "+operationNumber+" actbono: "+actbono+" actwbbono: "+actwbbono+" codePromotional: "+codePromotional + " channel="+channel );		
 			
 			if(amount!=null && !amount.trim().isEmpty()) {
 				amountD = Double.parseDouble(amount);
 			}
 			
 			String idClient = "";
 			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			
			LoggerApi.Log.info("tokenValidation: " +tokenValidation.getStatus());
			
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient = tokenValidation.getClientId();
			}else {				
				o.addProperty("state", "KO");
				String status=tokenValidation.getStatus();
				if(status.equals("TIMEOUTTR")) {
					o.addProperty("state", status);
				}
				o.addProperty("message", Constantes.MSG_EXCEPTION);
				out.print(o);
				LoggerApi.Log.info("tokenValidation ="+tokenValidation.toString());
				return;
			}	
 			clientId = Integer.parseInt(idClient);
 			
 			if(clientId>0) {		
 				
 	 			LoggerApi.Log.info("jsonRequest: " +jsonRequest.toString());
 	 			LoggerApi.Log.info("jsonResponse: " +jsonResponse.toString());
 	 			
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
                ProcedurePayTransactionIzipay payTransactionIzipay = beanClientBalanceBo.payTransactionIzipay(values);
 				o.addProperty("newAmount", payTransactionIzipay.getNewAmount());	
 				
 				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                o.addProperty("fecha", sdf.format(new Date()));
 				
 				if (codePromotional != null && !codePromotional.isEmpty()) {
 					LoggerApi.Log.info("Mensaje eco aplicando codigo promocional");
					PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(clientId, payTransactionIzipay.getBalanceItem());
					if (promoFistAccount != null) {
						String promotionMessage = promoFistAccount.getPromotion_message();
						if (promotionMessage.equals("OK")) {
							String promotionEco = promoFistAccount.getPromotion_eco();
							o.addProperty("promotionMessage", promotionEco);
						} else {
							o.addProperty("promotionMessage", promotionMessage);
						}
					}
 					
 				}
 			}else {
 				LoggerApi.Log.info("ERROR");
 				o.addProperty("state", "KO");
 				o.addProperty("message", Constantes.MSG_EXCEPTION);
 			}
 			out.print(o);
 		} catch (Exception e) {
 			LoggerApi.severe(e);
 			o.addProperty("state", "KO");
 			o.addProperty("message", Constantes.MSG_EXCEPTION);
 		}
 		LoggerApi.Log.info("-------------- END rechargeIzipay");
 	}
	
	@RequestMapping("/client_balance_show_information-bk")
	public ModelAndView showInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_show_information");

			HttpSession session = request.getSession();
			session.setAttribute("listavacia",null);
			session.setAttribute("rangosuperadofechas",null);
			session.setAttribute("fechasincorrectas",null);
			if (session.getAttribute("clientId") != null) {
				if (StringUtils.isEmpty((String) request.getParameter("from"))) {
					String idClient = ((String) session.getAttribute("clientId")).trim();
					if (!idClient.equals("")) {
						List<ClientProcedureGetBalanceList> balanceList = beanClientBalanceBo.getCurrentAccount((Integer.valueOf((String) session.getAttribute("clientId"))));
								                
						if(balanceList!=null && balanceList.size()>0) {
							Double montoPrevio = 0.0;
			                Double nuevoMonto = 0.0;
			                
			                ClientProcedureGetBalanceList temp = balanceList.get(0);
			                montoPrevio = temp.getPrevAmount();
			                temp.setNewAmount(temp.getNewAmount()+temp.getCommissionRecharge()+temp.getCommissionRequest());
			                balanceList.set(0, temp);
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
		                       		
		                       		balanceList.get(j).setPrevAmount(montoPrevioTemp);
		                       		balanceList.get(j).setNewAmount(nuevoMonto);
			                	}
			                }
						}else {
							session.setAttribute("client_balance_show_informationList", new ArrayList());
	                   	 	session.setAttribute("listavacia","No tienes movimientos");	
						}
						LoggerApi.Log.info("-------------- Lista: " + balanceList.size());
						session.setAttribute("client_balance_show_informationList", balanceList);
					}
				}
				objectModelMap.put("alert", (String) session.getAttribute("alertAccount"));
				session.removeAttribute("alertAccount");
				return new ModelAndView("client/interface-balance");
			} else
				return new ModelAndView("redirect:security_login_execute_authentication.html");
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-balance");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_show_information");
		}

	}
	
	@RequestMapping("/client_balance_show_information_filter")
	public ModelAndView showInformationFilter(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_show_information_filter");

			HttpSession session = request.getSession();
			session.setAttribute("client_balance_show_informationList", new ArrayList());
			if (session.getAttribute("clientId") != null) {
				
				if (StringUtils.isEmpty((String) request.getParameter("from"))) {
					session.setAttribute("listavacia",null);
					String idClient = ((String) session.getAttribute("clientId")).trim();
					if (!idClient.equals("")) {
						 	String startdate = request.getParameter("startdate");
			        		String enddate = request.getParameter("enddate");
			        		if(startdate != null && enddate != null) {
			        			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			        			
			        			Calendar calendarioinicio = Calendar.getInstance();
			        			calendarioinicio.setTime(sdf.parse(startdate));
			        			
			        			Calendar calendariofin = Calendar.getInstance();
			        			calendariofin.setTime(sdf.parse(enddate));
			        			
			        			Date timeinicio = calendarioinicio.getTime();
			        			Date timefin = calendariofin.getTime();
			        			long day = TimeUnit.MILLISECONDS.toDays(Math.abs(timefin.getTime()-timeinicio.getTime()));
			        			session.setAttribute("rangosuperadofechas",null);
			        			session.setAttribute("fechasincorrectas",null);
			        			
			        			if(timefin.before(timeinicio)) {
			        				session.setAttribute("client_balance_show_informationListFilter", new ArrayList());
			        				session.setAttribute("fechasincorrectas","La fecha de finalización debe ser posterior a la fecha de inicio.");
			        				session.removeAttribute("alertAccount");
									return new ModelAndView("client/interface-balance");
			        			}

			        			if(day > 29) { 
			        				session.setAttribute("client_balance_show_informationListFilter", new ArrayList());
			        				session.setAttribute("rangosuperadofechas","El rango de las fechas de inicio y fin no debe superar los 30 dias");
			        				objectModelMap.put("alert","El rango de las fechas de inicio y fin no debe superar los 30 dias");
			        				session.removeAttribute("alertAccount");
			        				return new ModelAndView("client/interface-balance");
			        			}
			        		}

						if(startdate != null &&  enddate != null) {

			                	 List<ClientProcedureGetBalanceListFilter> balanceListFilter = beanClientBalanceBo.getCurrentAccountFilter((Integer.valueOf((String) session.getAttribute("clientId"))), startdate, enddate);
			                	 if(balanceListFilter!=null && !balanceListFilter.isEmpty()) {
			                			Double montoPrevio = 0.0;
			                	        Double nuevoMonto = 0.0;
			                	        
			                	        ClientProcedureGetBalanceListFilter temp = balanceListFilter.get(0);
			                	        montoPrevio = temp.getPrevAmount();
			                	        temp.setNewAmount(temp.getNewAmount()+temp.getCommissionRecharge()+temp.getCommissionRequest());
			                	        balanceListFilter.set(0, temp);
			                	        if(balanceListFilter.size()>1) {
			                	        	for (int j = 1; j < balanceListFilter.size(); j++) {
			                	        		nuevoMonto = balanceListFilter.get(j).getNewAmount();
			                	        		Double montoPrevioTemp = 0.0;
			                	        		Double commissionRecharge = 0.0;
			                	        		Double commissionRequest = 0.0;
			                	        		
			                	           		if(montoPrevio.doubleValue()==nuevoMonto.doubleValue() && (balanceListFilter.get(j).getCommissionRecharge()>0 || balanceListFilter.get(j).getCommissionRequest()>0)) {
			                	        			if(balanceListFilter.get(j).getCommissionRecharge()<0) {
			                	        				commissionRecharge=balanceListFilter.get(j).getCommissionRecharge()*-1;
			                	        			}else {
			                	        				commissionRecharge=balanceListFilter.get(j).getCommissionRecharge();
			                	        			}
			                	        			
			                	        			if(balanceListFilter.get(j).getCommissionRequest()<0) {
			                	        				commissionRequest=balanceListFilter.get(j).getCommissionRequest()*-1;
			                	        			}else {
			                	        				commissionRequest=balanceListFilter.get(j).getCommissionRequest();
			                	        			}
			                	        			
			                	        			montoPrevioTemp=balanceListFilter.get(j).getPrevAmount()-commissionRecharge-commissionRequest;
			                	        			//nuevoMonto=balanceList.get(j).getNewAmount();
			                	           		}else {
			                	           			montoPrevioTemp=balanceListFilter.get(j).getPrevAmount();
			                	        			nuevoMonto=balanceListFilter.get(j).getNewAmount()+balanceListFilter.get(j).getCommissionRecharge()+balanceListFilter.get(j).getCommissionRequest();
			                	           		}
			                	           		montoPrevio = balanceListFilter.get(j).getPrevAmount();
			                	           		
			                	           		balanceListFilter.get(j).setPrevAmount(montoPrevioTemp);
			                	           		balanceListFilter.get(j).setNewAmount(nuevoMonto);
			                	        	}
			                	        	
			                	        }
			                	     	
			    						session.setAttribute("client_balance_show_informationListFilter", balanceListFilter);
			    						session.setAttribute("r_List", balanceListFilter.size());
			    						
			    						LoggerApi.Log.info("-------------- balanceListFilter " + balanceListFilter.size());
			                     }else {
			                    	 session.setAttribute("client_balance_show_informationListFilter", new ArrayList());
			                    	 session.setAttribute("listavacia","No tienes movimientos");
			                     }
			                	
			             }
					
					}
				}
				objectModelMap.put("alert", (String) session.getAttribute("alertAccount"));
				session.removeAttribute("alertAccount");
				return new ModelAndView("client/interface-balance");
			} else
				return new ModelAndView("redirect:security_login_execute_authentication.html");
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-balance");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_show_information_filter");
		}

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/client_balance_find_information")
	public ModelAndView findInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		try {
			LoggerApi.Log.info("-------------- START client_balance_find_information");
			HttpSession session = request.getSession();
			
			List<ClientProcedureGetBalanceList> list = (List<ClientProcedureGetBalanceList>) session
					.getAttribute("client_balance_show_informationList");
			String startdate = request.getParameter("startdate");
			String date = request.getParameter("date");
			String desc = request.getParameter("desc");
			String balanceItemData = request.getParameter("balanceItemData");
			if(startdate != null) {
				List<ClientProcedureGetBalanceListFilter> listFilter = (List<ClientProcedureGetBalanceListFilter>) session
						.getAttribute("client_balance_show_informationListFilter");
				if(listFilter != null) {
					for (ClientProcedureGetBalanceListFilter clientBalance : listFilter) {
						if (StringUtils.equals(clientBalance.getDescription(), desc)
								&& StringUtils.equals(clientBalance.getBalanceDate().toString(), date)  
								&& StringUtils.equals(clientBalance.getBalanceItem().toString(), balanceItemData) ) {
							LoggerApi.Log.info("clientBalance=" + clientBalance + " client_balance_find_information");
							objectModelMap.put("client_balance_show_informationInfo", clientBalance);
							objectModelMap.put("prevAmount", intralotUtils.formatCurrency(clientBalance.getPrevAmount()));
							objectModelMap.put("loadAmount", intralotUtils.formatCurrency(clientBalance.getLoadAmount()));
							objectModelMap.put("newAmount", intralotUtils.formatCurrency(clientBalance.getNewAmount()));
							if(clientBalance.getCommissionRequest()!=0) {
								objectModelMap.put("commission", intralotUtils.formatCurrency(clientBalance.getCommissionRequest()));
								if(clientBalance.getCommissionRequest()>0) {
									objectModelMap.put("commissionText", "Dev. comisi&oacute;n por retiro Tarjeta Visa");
								}else {
									objectModelMap.put("commissionText", "Comisi&oacute;n por retiro con Tarjeta Visa");
								}
							}else if(clientBalance.getCommissionRecharge()!=0) {
								objectModelMap.put("commission", intralotUtils.formatCurrency(clientBalance.getCommissionRecharge()));
								objectModelMap.put("commissionText", "Comisi&oacute;n por recarga con Tarjeta Visa");
							}
							break;
						}
					}
				} 
				return new ModelAndView("client/interface-balance-detail");
			}
			
			LoggerApi.Log.info("date=" + date + " desc=" + desc +" balanceItemData="+balanceItemData+ " client_balance_find_information");
			if (list != null) {
				for (ClientProcedureGetBalanceList clientBalance : list) {
					if (StringUtils.equals(clientBalance.getDescription(), desc)
							&& StringUtils.equals(clientBalance.getBalanceDate().toString(), date)  
							&& StringUtils.equals(clientBalance.getBalanceItem().toString(), balanceItemData) ) {
						LoggerApi.Log.info("clientBalance=" + clientBalance + " client_balance_find_information");
						objectModelMap.put("client_balance_show_informationInfo", clientBalance);
						objectModelMap.put("prevAmount", intralotUtils.formatCurrency(clientBalance.getPrevAmount()));
						objectModelMap.put("loadAmount", intralotUtils.formatCurrency(clientBalance.getLoadAmount()));
						objectModelMap.put("newAmount", intralotUtils.formatCurrency(clientBalance.getNewAmount()));
						if(clientBalance.getCommissionRequest()!=0) {
							objectModelMap.put("commission", intralotUtils.formatCurrency(clientBalance.getCommissionRequest()));
							if(clientBalance.getCommissionRequest()>0) {
								objectModelMap.put("commissionText", "Dev. comisi&oacute;n por retiro Tarjeta Visa");
							}else {
								objectModelMap.put("commissionText", "Comisi&oacute;n por retiro con Tarjeta Visa");
							}
						}else if(clientBalance.getCommissionRecharge()!=0) {
							objectModelMap.put("commission", intralotUtils.formatCurrency(clientBalance.getCommissionRecharge()));
							objectModelMap.put("commissionText", "Comisi&oacute;n por recarga con Tarjeta Visa");
						}
						break;
					}
				}
			}
			return new ModelAndView("client/interface-balance-detail");

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-balance-detail");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_find_information");
		}
	}

	@RequestMapping(value = "/client_balance_promo_te_apuesto_show_information")
	public ModelAndView findPromoTeApuestoByIdCliente(HttpServletRequest request, ModelMap objectModelMap)
			throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_promo_te_apuesto_show_information");

			HttpSession session = request.getSession();

			if (session.getAttribute("clientId") != null) {
				if (StringUtils.isEmpty((String) request.getParameter("from"))) {
					String idClient = ((String) session.getAttribute("clientId")).trim();
					if (!idClient.equals("")) {
						ClientProcedureAccountData accountData = beanClientBalanceBo
								.findAccountData(Integer.valueOf(idClient));
						accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData, session);
						intralotUtils.updateBalanceSession(session, accountData, 0, "");
						session.setAttribute("client_promo_te_apuesto_balance_show_informationList",
								beanClientBalanceBo.getTeApuestoPromoAccount((Integer.valueOf(idClient))));
					}
				}
			} else {
				return new ModelAndView("redirect:security_login_execute_authentication.html");
			}
			objectModelMap.put("alert", (String) session.getAttribute("alertAccount"));
			session.removeAttribute("alertAccount");
			return new ModelAndView("client/interface-promo-te-apuesto-balance");
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-promo-te-apuesto-balance");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_promo_te_apuesto_show_information");
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/client_balance_promo_te_apuesto_find_information")
	public ModelAndView findPromoTeApuestoInformation(HttpServletRequest request, ModelMap objectModelMap)
			throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_promo_te_apuesto_find_information");
			HttpSession session = request.getSession();
			List<ClientProcedureGetTeApuestoPromoList> list = (List<ClientProcedureGetTeApuestoPromoList>) session
					.getAttribute("client_promo_te_apuesto_balance_show_informationList");
			String date = request.getParameter("date");
			String desc = request.getParameter("desc");
			// String prom = "";
			LoggerApi.Log.info("date=" + date + " desc=" + desc + " client_balance_promo_te_apuesto_find_information");
			if (list != null) {
				LoggerApi.Log.info("tamano lista " + list.size());
				for (ClientProcedureGetTeApuestoPromoList clientTeapuestoPromo : list) {
					if (StringUtils.equals(clientTeapuestoPromo.getDescription(), desc)
							&& StringUtils.equals(clientTeapuestoPromo.getPromDate().toString(), date)) {
						LoggerApi.Log.info("clientTeapuestoPromo=" + clientTeapuestoPromo
								+ " client_balance_promo_te_apuesto_find_information");
						// prom = clientTeapuestoPromo.getPromId();
						objectModelMap.put("client_balance_promo_te_apuesto_show_informationInfo",
								clientTeapuestoPromo);
						break;
					}
				}
			}
			/*
			 * if(session.getAttribute("clientId")!=null){ String
			 * idClient=((String)session.getAttribute("clientId")).trim();
			 * if(!prom.trim().equals("")) session.setAttribute(
			 * "client_promo_te_apuesto_tickets_balance_show_informationList",
			 * beanClientBalanceBo.getTeApuestoTicketsPromoAccount((Integer.valueOf(idClient
			 * )), prom)); }
			 */
			return new ModelAndView("client/interface-promo-te-apuesto-balance-detail");

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-promo-te-apuesto-balance-detail");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_promo_te_apuesto_find_information");
		}

	}

	@RequestMapping(value = "/client_balance_bono_te_apuesto_show_information")
	public ModelAndView findBonusTeApuestoByIdCliente(HttpServletRequest request, ModelMap objectModelMap)
			throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_bono_te_apuesto_show_information");

			HttpSession session = request.getSession();

			if (session.getAttribute("clientId") != null) {
				if (StringUtils.isEmpty((String) request.getParameter("from"))) {
					String idClient = ((String) session.getAttribute("clientId")).trim();
					if (!idClient.equals("")) {
						ClientProcedureAccountData accountData = beanClientBalanceBo
								.findAccountData(Integer.valueOf(idClient));
						accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData, session);
						intralotUtils.updateBalanceSession(session, accountData, 0, "");
						session.setAttribute("client_bonus_te_apuesto_balance_show_informationList",
								beanClientBalanceBo.getTeApuestoBonusAccount((Integer.valueOf(idClient))));
					}
				}
			} else {
				return new ModelAndView("redirect:security_login_execute_authentication.html");
			}
			objectModelMap.put("alert", (String) session.getAttribute("alertAccount"));
			session.removeAttribute("alertAccount");
			return new ModelAndView("client/interface-bonus-te-apuesto-balance");
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-bonus-te-apuesto-balance");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_bono_te_apuesto_show_information");
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/client_balance_bono_te_apuesto_find_information")
	public ModelAndView findBonoTeApuestoInformation(HttpServletRequest request, ModelMap objectModelMap)
			throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_bono_te_apuesto_find_information");
			HttpSession session = request.getSession();
			List<ClientProcedureGetTeApuestoBonusList> list = (List<ClientProcedureGetTeApuestoBonusList>) session
					.getAttribute("client_bonus_te_apuesto_balance_show_informationList");

			String date = request.getParameter("date");
			String desc = request.getParameter("desc");
			if (list != null) {
				LoggerApi.Log.info("desc " + desc);
				LoggerApi.Log.info("date " + date);
				for (ClientProcedureGetTeApuestoBonusList clientTeApuestoBalance : list) {
					// LoggerApi.Log.info("clientTeApuestoBalance.getDescription()
					// "+clientTeApuestoBalance.getDescription());
					// LoggerApi.Log.info("clientTeApuestoBalance.getBalanceDate().toString()
					// "+clientTeApuestoBalance.getBalanceDate().toString());
					if (StringUtils.equals(clientTeApuestoBalance.getDescription(), desc)
							&& StringUtils.equals(clientTeApuestoBalance.getBalanceDate().toString(), date)) {
						LoggerApi.Log.info("CUMPLE CONDICION :::::::::::::::::::::::::");
						String description[] = clientTeApuestoBalance.getDescription().split(" ");
						if (description[0].equals("Teapuesto"))
							desc = "TE APUESTO " + description[1];

						objectModelMap.put("descripcion", desc);
						objectModelMap.put("client_balance_bono_te_apuesto_show_informationInfo",
								clientTeApuestoBalance);
						objectModelMap.put("prevAmount",
								intralotUtils.formatCurrency(clientTeApuestoBalance.getPrevAmount()));
						objectModelMap.put("loadAmount",
								intralotUtils.formatCurrency(clientTeApuestoBalance.getLoadAmount()));
						objectModelMap.put("newAmount",
								intralotUtils.formatCurrency(clientTeApuestoBalance.getNewAmount()));
						objectModelMap.put("rolloverTimes", clientTeApuestoBalance.getRolloverTimes());
						objectModelMap.put("rolloverValidates", clientTeApuestoBalance.getRolloverValidates());
						objectModelMap.put("rolloverStatus", clientTeApuestoBalance.getRolloverStatus().trim());
						objectModelMap.put("prizeStatus", clientTeApuestoBalance.getPrizeStatus().trim());
						break;
					}
				}
			}
			return new ModelAndView("client/interface-bonus-te-apuesto-balance-detail");

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-bonus-te-apuesto-balance-detail");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_bono_te_apuesto_find_information");
		}

	}

	@RequestMapping(value = "/client_balance_bono_games_show_information")
	public ModelAndView findBonusGamesByIdCliente(HttpServletRequest request, ModelMap objectModelMap)
			throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_bono_games_show_information");

			HttpSession session = request.getSession();

			if (session.getAttribute("clientId") != null) {
				if (StringUtils.isEmpty((String) request.getParameter("from"))) {
					String idClient = ((String) session.getAttribute("clientId")).trim();
					int gameid = (request.getParameter("gameId") != null
							&& !((String) request.getParameter("gameId")).trim().equals(""))
									? Integer.parseInt(((String) request.getParameter("gameId")).trim())
									: 0;
					String gamename = (request.getParameter("gameName") != null
							&& !((String) request.getParameter("gameName")).trim().equals(""))
									? ((String) request.getParameter("gameName")).trim()
									: "";
					if (!idClient.equals("")) {
						ClientProcedureAccountData accountData = beanClientBalanceBo
								.findAccountData(Integer.valueOf(idClient));
						LoggerApi.Log.info(accountData.getBonusGame());
						accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData, session);
						
						String cadenaJunta="";
						
						gameid = intralotUtils.updateBalanceSession(session, accountData, gameid, gamename);
						//Ruth inicio
						List<ClientProcedureGetGamesBonusList> result = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaTinka = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaGanaDiario = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaGanagol = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaKabala = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaKinelo = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaDeportes = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaRaspaditas = new ArrayList<ClientProcedureGetGamesBonusList>();
						List<ClientProcedureGetGamesBonusList> listaCasino = new ArrayList<ClientProcedureGetGamesBonusList>();
				
						String cantGanagol="";
						String cantTinka="";								
						String cantDeportes="";
						String cantKabala="";
						String cantGanaDiario="";
						String cantKinelo="";
						String cantRaspaditas="";
						String cantCasino="";
						
							result = beanClientBalanceBo.getGamesBonusAccount(Integer.valueOf(idClient));				
							for(int i=0; result.size()>i;i++){								
								String idMasCantidad="";
								int idGamee=result.get(i).getGameId();
								
								switch(idGamee)
								{								  
								   case 4 :
									   //ClientProcedureGetGamesBonusList beanGa=new ClientProcedureGetGamesBonusList();									   
									   listaGanagol.add(result.get(i));									  
								      break; 								   
								   case 41 :
									   listaTinka.add(result.get(i));
								      break;								   
								   case 29 :
									   listaDeportes.add(result.get(i));
									      break; 									      
								   case 42 :
									   listaKabala.add(result.get(i));
									      break; 									      
								   case 164 :
									   listaGanaDiario.add(result.get(i));
									      break; 
								   case 1121 :
									   listaKinelo.add(result.get(i));
									      break; 
									      
								   case 30 :
									   listaRaspaditas.add(result.get(i));
									      break;
								   case 31 :
									   listaCasino.add(result.get(i));
									      break;	      
								}
              
								 cantGanagol=4+"_"+listaGanagol.size();
								 cantTinka=41+"_"+listaTinka.size();
								 cantDeportes=29+"_"+listaDeportes.size();
								 cantKabala=42+"_"+listaKabala.size();
								 cantGanaDiario=164+"_"+listaGanaDiario.size();
								 cantKinelo=1121+"_"+listaKinelo.size();
								 cantRaspaditas=30+"_"+listaRaspaditas.size();
								 cantCasino=31+"_"+listaCasino.size();
						
							}							
							 cadenaJunta=cantTinka+","+cantGanaDiario+","+cantGanagol+","+cantKabala+","+cantKinelo+","+cantDeportes+","+cantRaspaditas+","+cantCasino;
						List<BonoOtroJuego> headers = new ArrayList<BonoOtroJuego>();
						if (accountData != null) {
							headers = intralotUtils.bonoOtroJuegoHeader(accountData.getBonusGameMobile(),cadenaJunta);
							LoggerApi.Log.info("Headers size" + headers.size());
							
							result = beanClientBalanceBo.getGamesBonusAccount(Integer.valueOf(idClient));
							session.setAttribute("client_bonus_games_balance", result);
						}
						session.setAttribute("header_bono_otro", headers);
                    //ruth fin
					}
				}
			} else {
				return new ModelAndView("redirect:security_login_execute_authentication.html");
			}
			objectModelMap.put("alert", (String) session.getAttribute("alertAccount"));
			session.removeAttribute("alertAccount");
			return new ModelAndView("client/interface-bonus-games-balance");
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-bonus-games-balance");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_bono_games_show_information");
		}
	}

	@RequestMapping(value = "/client_balance_bono_games_show_other")
	public void findBonusGamesByIdGameandIdCliente(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoggerApi.Log.info("-------------- START client_balance_bono_games_show_other");

		PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		HttpSession session = request.getSession();
		List<ClientProcedureGetGamesBonusList> list = new ArrayList<ClientProcedureGetGamesBonusList>();
		if (session.getAttribute("clientId") != null) {
			String idClient = ((String) session.getAttribute("clientId")).trim();
			int gameid = (request.getParameter("gameId") != null
					&& !((String) request.getParameter("gameId")).trim().equals(""))
							? Integer.parseInt(((String) request.getParameter("gameId")).trim())
							: 0;
			String gamename = (request.getParameter("gameName") != null
					&& !((String) request.getParameter("gameName")).trim().equals(""))
							? ((String) request.getParameter("gameName")).trim()
							: "";
			if (!idClient.equals("")) {
				ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(Integer.valueOf(idClient));
				LoggerApi.Log.info(accountData.getBonusGameMobile());
				accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData, session);
				gameid = intralotUtils.updateBalanceSession(session, accountData, gameid, gamename);

			}
			List<ClientProcedureGetGamesBonusList> result = new ArrayList<ClientProcedureGetGamesBonusList>();
			if (session.getAttribute("client_bonus_games_balance") == null || request.getParameter("gameId") == null) {
				result = beanClientBalanceBo.getGamesBonusAccount(Integer.valueOf(idClient));
				session.setAttribute("client_bonus_games_balance", result);
			} else
				result = (List<ClientProcedureGetGamesBonusList>) session.getAttribute("client_bonus_games_balance");

			LoggerApi.Log.info("gameid: " + gameid);
			for (ClientProcedureGetGamesBonusList obj : result) {
				if (obj.getGameId() == gameid) {
					list.add(obj);
				}
			}
			session.setAttribute("client_bonus_games_balance_show_informationList", list);
			LoggerApi.Log.info("tamano de lista juego " + gamename + " es: " + list.size());
		}

		// Gson gson = new Gson();
		String jsonList = new Gson().toJson(list);
		out.println(jsonList);

		LoggerApi.Log.info("-------------- END client_balance_bono_games_show_other");

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/client_balance_bono_games_find_information")
	public ModelAndView findBonoGamesInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

		try {
			LoggerApi.Log.info("-------------- START client_balance_bono_games_find_information");
			HttpSession session = request.getSession();
			List<ClientProcedureGetGamesBonusList> list = (List<ClientProcedureGetGamesBonusList>) session
					.getAttribute("client_bonus_games_balance_show_informationList");
			String date = request.getParameter("date");
			String desc = request.getParameter("desc");
			if (list != null) {
				LoggerApi.Log.info("tamano lista " + list.size());
				for (ClientProcedureGetGamesBonusList clientGamesBalance : list) {
					LoggerApi.Log.info("clientGamesBalance.getDescription() " + clientGamesBalance.getDescription());
					LoggerApi.Log.info("desc " + desc);
					LoggerApi.Log.info("clientGamesBalance.getBalanceDate().toString() "
							+ clientGamesBalance.getBalanceDate().toString());
					LoggerApi.Log.info("date " + date);
					if (StringUtils.equals(clientGamesBalance.getDescription(), desc)
							&& StringUtils.equals(clientGamesBalance.getBalanceDate().toString(), date)) {
						LoggerApi.Log.info("CUMPLE CONDICION :::::::::::::::::::::::::");
						String description[] = clientGamesBalance.getDescription().split(" ");
						if (description[0].equals("Teapuesto"))
							desc = "TE APUESTO " + description[1];

						objectModelMap.put("descripcion", desc);
						objectModelMap.put("client_balance_bono_games_show_informationInfo", clientGamesBalance);
						objectModelMap.put("prevAmount",
								intralotUtils.formatCurrency(clientGamesBalance.getPrevAmount()));
						objectModelMap.put("loadAmount",
								intralotUtils.formatCurrency(clientGamesBalance.getLoadAmount()));
						objectModelMap.put("newAmount",
								intralotUtils.formatCurrency(clientGamesBalance.getNewAmount()));
						objectModelMap.put("gameId", clientGamesBalance.getGameId());
						break;
					}
				}
			}
			return new ModelAndView("client/interface-bonus-games-balance-detail");

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("client/interface-bonus-games-balance-detail");
		} finally {
			LoggerApi.Log.info("-------------- END client_balance_bono_games_find_information");
		}

	}

	@RequestMapping(value = "/rechargei")
	public String recharge_form(@RequestParam("marca") String marca, HttpServletRequest request,
			HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String version = "1"; 
		request.setAttribute("visanet_merchantlogo", baseUri + "/layer-view-image/v2/landing/img/" + marca + "?v=" + version);
		HttpSession session = request.getSession();
		String clientId = null;
		String operatorId="5586";
		objectModelMap.put("operatorId",operatorId);
		IntralotUtils util =  new IntralotUtils();
		try {
			LoggerApi.Log.info("recharge form en ecommerce ");
			ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
			clientId = (user.getClientId() != null) ? user.getClientId().toString() : "0";
			
			String urlAutocontrol = ConnectionFactory.operationProperty("urlAutocontrol", Constantes.contextSale).trim();	

			 ClientProcedureGetSelfcontrol getSelfcontrol = clientSaleBo.getDataSelfcontrol(Integer.valueOf(clientId) );
			if(getSelfcontrol.getTypeLimit().equals("AUTOEXCLUSION") && getSelfcontrol.getValueLimit()>0 ) {
				//enviar vista que no muestre btns de recarga
				LoggerApi.Log.info("activado autoexclusion ");
				objectModelMap.put("urlAutocontrol",urlAutocontrol);
				
				ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(Integer.valueOf(clientId));
				LoggerApi.Log.info("traer los saldo en teapuesto ->amount:" + accountDataPart.getBalanceAmount());

				objectModelMap.put("billetera1Recarga",accountDataPart.getBalanceAmount());
				objectModelMap.put("billetera2Recarga",util.formatCurrency(Double.parseDouble(accountDataPart.getBonusAmount().replaceAll(",","."))));
				objectModelMap.put("billetera3Recarga", accountDataPart.getOtherAmount());
				
				return "client/interface-recharge_form_autocontrol";
			}else {
				 LoggerApi.Log.info(" no activado autocontrol");
			}

		
		} catch (Exception e) {
        	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
            return "client/interface-recharge_form_rt";			
		}
		//servicio tokenrecharge
		JsonObject jdata = new JsonObject();
        jdata.addProperty("operatorId", operatorId);
        jdata.addProperty("platform", "mobile");
        jdata.addProperty("playerId", clientId);
        jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
        String iarechargeResponse=requestWSIflexApiRecharge(jdata.toString(), "tokenrecharge2");
        JSONObject convertedObject = new JSONObject(iarechargeResponse);
        String status = convertedObject.getString("status");
        if(!status.equals("OK")) {
        	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
            return "client/interface-recharge_form_rt";
        }
        
        String token=convertedObject.getString("token");
//        String operatorId=jdata.get("operatorId").getAsString(); // convertedObject.getString("operatorId");
		objectModelMap.put("rechargetoken",token);
//		objectModelMap.put("operatorId",operatorId);
//		HttpSession session = request.getSession();
//		session.setAttribute("WS_URL_PAGO_TOKEN_RESULT",
//				ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT", Constantes.contextSale));
//		session.setAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT",
//				ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", Constantes.contextSale));
		return "client/interface-recharge_form_rt";
	}

	@RequestMapping(value = "/recharge")
	public String recharge_form(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String baseUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String token=request.getParameter("rechargetoken");
		
		Integer clientId = null;
		HttpSession session = request.getSession();
		
		objectModelMap.put("rechargetoken",token);
		request.setAttribute("visanet_merchantlogo", baseUri + "/layer-view-image/v2/landing/img/logo-teapuesto_03_v2.png");
		
		
		//Validar si cliente tiene activado limite de autoexclusion para teapuesto 
		LoggerApi.Log.info("recharge form en te apuesto");
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		String ip=SecurityUtils.getClientIp(request);
		
		try {
			LoggerApi.Log.info("obtener data de autocontrol RECHARGE Te Apuesto");
			tokenValidation = beanSecurityLoginBo.getTokenValidation(token, ip);
			LoggerApi.Log.info("result de tokenValidation:" +tokenValidation.toString());
			if ((tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Show")) || (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) ) {	
				objectModelMap.put("rechargetoken",tokenValidation.getRechargeToken());
				clientId = Integer.parseInt(tokenValidation.getClientId());
				LoggerApi.Log.info("clientId:" + clientId);
				String urlAutocontrol = ConnectionFactory.operationProperty("urlAutocontrol", Constantes.contextSale).trim();
				ClientProcedureGetSelfcontrol getSelfcontrol = clientSaleBo.getDataSelfcontrol(clientId );
				if(getSelfcontrol.getTypeLimit().equals("AUTOEXCLUSION") && getSelfcontrol.getValueLimit()>0 ) {
					//enviar vista que no muestre btns de recarga
					LoggerApi.Log.info("activado autoexclusion en Te Apuesto ");
					objectModelMap.put("urlAutocontrol",urlAutocontrol);
					objectModelMap.put("operatorId",tokenValidation.getOperatorId());
					return "client/interface-recharge_form_autocontrol";
				}	
			}	
		} catch (Exception e) {
        	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
            return "client/interface-recharge_form_rt";			
		}
		
//		HttpSession session = request.getSession();
//		session.setAttribute("WS_URL_PAGO_TOKEN_RESULT",
//				ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_TA", Constantes.contextSale));
//		session.setAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT",
//				ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT_TA", Constantes.contextSale));
//        session.setAttribute("WS_URL_PAYMENT_CALLBACK", ConnectionFactory.operationProperty("WS_URL_PAYMENT_CALLBACK", Constantes.contextSale));
//        session.setAttribute("auth_key_payment_callback", ConnectionFactory.operationProperty("auth_key_payment_callback", Constantes.contextSale));
		return "client/interface-recharge_form_rt";
	}

	@RequestMapping(value = "/send-code-promotional-validation")
	public void codePromotionalValidation(@RequestParam("callback") String callback, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START sendCodePromotionalValidation");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		PinPrinted pinPrinted = null;
		JsonObject o = new JsonObject();
		PrintWriter out = response.getWriter();
		String outData = "";

		try {
			String ip = request.getRemoteAddr();
			String codePromotional = (request.getParameter("codePromotional") != null)
					? request.getParameter("codePromotional").toString().trim()
					: "";
			String channel = (request.getParameter("channel") != null)
					? request.getParameter("channel").toString().trim()
					: "";
			Double amount = (request.getParameter("amount") != null  && !request.getParameter("amount").isEmpty())
					? Double.parseDouble(request.getParameter("amount").toString().trim())
					: 0;
			String lotocard = (request.getParameter("lotocard") != null)
					? request.getParameter("lotocard").toString().trim()
					: "";
			ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
			String clientId = (user.getClientId() != null) ? user.getClientId().toString() : "0";
			
        	if(amount <= 0 && !channel.equals("IBK")) {
        		o.addProperty("status", "DES");
    			o.addProperty("message", "El monto no debe ser diferente de vacio o cero");
    			LoggerApi.Log.info("El monto no debe ser diferente de vacio o cero");
    			return;
        	}

			if (!lotocard.trim().isEmpty()) {
				pinPrinted = beanClientLotocardBo.findLotocard(lotocard);
				if (pinPrinted != null) {
					amount = pinPrinted.getPinAmount();
				} else {
					o.addProperty("status", "DES");
					o.addProperty("message", "C&oacute;digo lotocard no existe");
					return;
				}
			}

			Object[] values = new Object[6];
			values[0] = codePromotional.toUpperCase();
			values[1] = clientId;
			values[2] = channel;
			values[3] = "mobile";
			values[4] = amount;
			values[5] = ip;

			ClientProcedureCodeValidation clientProcedureCodeValidation = beanClientBalanceBo
					.codePromotionalValidation(values);
			if (clientProcedureCodeValidation != null) {
				o.addProperty("status", clientProcedureCodeValidation.getState());
				o.addProperty("message", clientProcedureCodeValidation.getMessage());
				o.addProperty("idCode", clientProcedureCodeValidation.getIdCodePromotional());
			} else {
				o.addProperty("status", 500);
				o.addProperty("message", "Incidente inesperado");
			}
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/sendCodePromotionalValidation " + o.toString());
		}
		LoggerApi.Log.info("-------------- END sendCodePromotionalValidation");
	}
	
	@RequestMapping(value = "/yapePlinVerifyTransaction")
    public void yapePlinVerifyTransaction(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	        
			if ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION) != null
					&& ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getSessionId() != null
					&& ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId() != null) {
				Integer idClient = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId();		
				String channel = request.getParameter("channel");
				
				ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction = beanClientBalanceBo.yapePlinVerifyTransaction(idClient, channel);
				if(yapePlinVerifyTransaction!=null && yapePlinVerifyTransaction.getStatus().trim().equals("ACT")) {
					ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClient);
					o.addProperty("status", "ACT");
					o.addProperty("billetera1", accountDataPart.getBalanceAmount());
					o.addProperty("billetera2", intralotUtils.formatCurrency(Double.parseDouble(accountDataPart.getBonusAmount().replaceAll(",", "."))));
					o.addProperty("billetera3", accountDataPart.getOtherAmount());
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

	@RequestMapping(value = "/load_recharge")
	public void loadRecharge(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		try {
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			if ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION) != null
					&& ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getSessionId() != null
					&& ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId() != null) {
				Integer idClient = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId();		
				ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClient);
				o.addProperty("billetera1", accountDataPart.getBalanceAmount());
				o.addProperty("billetera2", intralotUtils.formatCurrency(Double.parseDouble(accountDataPart.getBonusAmount().replaceAll(",", "."))));
				o.addProperty("billetera3", accountDataPart.getOtherAmount());
				o.addProperty("amtMinRechargeAgr", accountDataPart.getAmtMinRechargeAgr());
				o.addProperty("amtMaxRechargeAgr", accountDataPart.getAmtMaxRechargeAgr());
				o.addProperty("stateRechargeAgr", accountDataPart.getStateRechargeAgr());
				
				o.addProperty("amtMinRechargeVisa", accountDataPart.getAmtMinRechargeVisa());
				o.addProperty("amtMaxRechargeVisa", accountDataPart.getAmtMaxRechargeVisa());
				o.addProperty("comMinRan1Visa", accountDataPart.getComMinRan1Visa());
				o.addProperty("comMaxRan1Visa", accountDataPart.getComMaxRan1Visa());
				o.addProperty("comAmtRan1Visa", accountDataPart.getComAmtRan1Visa());
				o.addProperty("comMinRan2Visa", accountDataPart.getComMinRan2Visa());
				o.addProperty("comMaxRan2Visa", accountDataPart.getComMaxRan2Visa());
				o.addProperty("comAmtRan2Visa", accountDataPart.getComAmtRan2Visa());
				o.addProperty("comMinRan3Visa", accountDataPart.getComMinRan3Visa());
				o.addProperty("comMaxRan3Visa", accountDataPart.getComMaxRan3Visa());
				o.addProperty("comAmtRan3Visa", accountDataPart.getComAmtRan3Visa());
				o.addProperty("comMinRan4Visa", accountDataPart.getComMinRan4Visa());
				o.addProperty("comMaxRan4Visa", accountDataPart.getComMaxRan4Visa());
				o.addProperty("comAmtRan4Visa", accountDataPart.getComAmtRan4Visa());
				o.addProperty("comMinRan1Agr", accountDataPart.getComMinRan1Agr());
				o.addProperty("comMaxRan1Agr", accountDataPart.getComMaxRan1Agr());
				o.addProperty("comAmtRan1Agr", accountDataPart.getComAmtRan1Agr());
				o.addProperty("comMinRan2Agr", accountDataPart.getComMinRan2Agr());
				o.addProperty("comMaxRan2Agr", accountDataPart.getComMaxRan2Agr());
				o.addProperty("comAmtRan2Agr", accountDataPart.getComAmtRan2Agr());
				o.addProperty("comMinRan3Agr", accountDataPart.getComMinRan3Agr());
				o.addProperty("comMaxRan3Agr", accountDataPart.getComMaxRan3Agr());
				o.addProperty("comAmtRan3Agr", accountDataPart.getComAmtRan3Agr());
				o.addProperty("comMinRan4Agr", accountDataPart.getComMinRan4Agr());
				o.addProperty("comMaxRan4Agr", accountDataPart.getComMaxRan4Agr());
				o.addProperty("comAmtRan4Agr", accountDataPart.getComAmtRan4Agr());
				o.addProperty("msjComVisa", accountDataPart.getMsjComVisa());
				o.addProperty("msjComAgr", accountDataPart.getMsjComAgr());
				o.addProperty("rechargeAgora", accountDataPart.getRechargeAgora());
				o.addProperty("mobilePhone", accountDataPart.getMobilePhone());
				o.addProperty("amtMinRechargeBcp", accountDataPart.getAmtMinRechargeBcp());
				o.addProperty("amtMaxRechargeBcp", accountDataPart.getAmtMaxRechargeBcp());
				o.addProperty("maxRechargePerDayVisa", accountDataPart.getMaxRechargePerDayVisa());
				o.addProperty("maxAmtPerWeekVisa", accountDataPart.getMaxAmtPerWeekVisa());
				
				o.addProperty("stateRechargeVisa", accountDataPart.getStateRechargeVisa());
				o.addProperty("stateRechargeBcp", accountDataPart.getStateRechargeBcp());
				o.addProperty("stateRechargeLoto", accountDataPart.getStateRechargeLoto());
				o.addProperty("stateRechargeIbk", accountDataPart.getStateRechargeIbk());
				o.addProperty("amtMinRechargeIbk", accountDataPart.getAmtMinRechargeIbk());
				o.addProperty("amtMaxRechargeIbk", accountDataPart.getAmtMaxRechargeIbk());
				o.addProperty("stateRechargePefe", accountDataPart.getStateRechargePefe());
				o.addProperty("amtMinRechargePefe", accountDataPart.getAmtMinRechargePefe());
				o.addProperty("amtMaxRechargePefe", accountDataPart.getAmtMaxRechargePefe());
				o.addProperty("stateRechargeSpay", accountDataPart.getStateRechargeSpay());
				o.addProperty("amtMinRechargeSpay", accountDataPart.getAmtMinRechargeSpay());
				o.addProperty("amtMaxRechargeSpay", accountDataPart.getAmtMaxRechargeSpay());
				
				o.addProperty("stateRechargeYape", accountDataPart.getStateRechargeYape());
				o.addProperty("amtMinRechargeYape", accountDataPart.getAmtMinRechargeYape());
				o.addProperty("amtMaxRechargeYape", accountDataPart.getAmtMaxRechargeYape());
				o.addProperty("stateRechargePlin", accountDataPart.getStateRechargePlin());
				o.addProperty("amtMinRechargePlin", accountDataPart.getAmtMinRechargePlin());
				o.addProperty("amtMaxRechargePlin", accountDataPart.getAmtMaxRechargePlin());

				session.setAttribute("accountDataPart", accountDataPart);
				
				String maximoCodigosBCP = ((ConnectionFactory.operationProperty("maximoCodigosBCP",
						Constantes.contextSale) != null)
								? ConnectionFactory.operationProperty("maximoCodigosBCP", Constantes.contextSale).trim()
								: "3");
				o.addProperty("maximoCodigosBCP", maximoCodigosBCP);
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
	}

	@RequestMapping(value = "/load_recharge_rt")
	public void loadRechargeRT(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		try {
			LoggerApi.Log.info("-------------- START load_recharge_rt");
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			JsonObject o = new JsonObject();
			//parametro que debe enviar TA
			String rechargetoken=request.getHeader("rechargetoken");
			String ip=SecurityUtils.getClientIp(request);	
			String rstatus=(request.getParameter("rstatus")!=null)?request.getParameter("rstatus"):"";
			
			if (rechargetoken != null && !rechargetoken.equals("")) {
				// Validación de token
				tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
				if ((tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Show")) ||(tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated"))) {
					o.addProperty("status", tokenValidation.getStatus());
					o.addProperty("rechargetoken", tokenValidation.getRechargeToken());
					o.addProperty("operatorId", tokenValidation.getOperatorId());
					
					Integer idClient = Integer.parseInt(tokenValidation.getClientId());
					ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClient);
					o.addProperty("billetera1", accountDataPart.getBalanceAmount());
					o.addProperty("billetera2", intralotUtils
							.formatCurrency(Double.parseDouble(accountDataPart.getBonusAmount().replaceAll(",", "."))));
					o.addProperty("billetera3", accountDataPart.getOtherAmount());
					o.addProperty("amtMinRechargeAgr", accountDataPart.getAmtMinRechargeAgr());
					o.addProperty("amtMaxRechargeAgr", accountDataPart.getAmtMaxRechargeAgr());
					o.addProperty("stateRechargeAgr", accountDataPart.getStateRechargeAgr());

					o.addProperty("amtMinRechargeVisa", accountDataPart.getAmtMinRechargeVisa());
					o.addProperty("amtMaxRechargeVisa", accountDataPart.getAmtMaxRechargeVisa());
					o.addProperty("comMinRan1Visa", accountDataPart.getComMinRan1Visa());
					o.addProperty("comMaxRan1Visa", accountDataPart.getComMaxRan1Visa());
					o.addProperty("comAmtRan1Visa", accountDataPart.getComAmtRan1Visa());
					o.addProperty("comMinRan2Visa", accountDataPart.getComMinRan2Visa());
					o.addProperty("comMaxRan2Visa", accountDataPart.getComMaxRan2Visa());
					o.addProperty("comAmtRan2Visa", accountDataPart.getComAmtRan2Visa());
					o.addProperty("comMinRan3Visa", accountDataPart.getComMinRan3Visa());
					o.addProperty("comMaxRan3Visa", accountDataPart.getComMaxRan3Visa());
					o.addProperty("comAmtRan3Visa", accountDataPart.getComAmtRan3Visa());
					o.addProperty("comMinRan4Visa", accountDataPart.getComMinRan4Visa());
					o.addProperty("comMaxRan4Visa", accountDataPart.getComMaxRan4Visa());
					o.addProperty("comAmtRan4Visa", accountDataPart.getComAmtRan4Visa());
					o.addProperty("comMinRan1Agr", accountDataPart.getComMinRan1Agr());
					o.addProperty("comMaxRan1Agr", accountDataPart.getComMaxRan1Agr());
					o.addProperty("comAmtRan1Agr", accountDataPart.getComAmtRan1Agr());
					o.addProperty("comMinRan2Agr", accountDataPart.getComMinRan2Agr());
					o.addProperty("comMaxRan2Agr", accountDataPart.getComMaxRan2Agr());
					o.addProperty("comAmtRan2Agr", accountDataPart.getComAmtRan2Agr());
					o.addProperty("comMinRan3Agr", accountDataPart.getComMinRan3Agr());
					o.addProperty("comMaxRan3Agr", accountDataPart.getComMaxRan3Agr());
					o.addProperty("comAmtRan3Agr", accountDataPart.getComAmtRan3Agr());
					o.addProperty("comMinRan4Agr", accountDataPart.getComMinRan4Agr());
					o.addProperty("comMaxRan4Agr", accountDataPart.getComMaxRan4Agr());
					o.addProperty("comAmtRan4Agr", accountDataPart.getComAmtRan4Agr());
					o.addProperty("msjComVisa", accountDataPart.getMsjComVisa());
					o.addProperty("msjComAgr", accountDataPart.getMsjComAgr());
					o.addProperty("rechargeAgora", accountDataPart.getRechargeAgora());
					o.addProperty("mobilePhone", accountDataPart.getMobilePhone());
					o.addProperty("amtMinRechargeBcp", accountDataPart.getAmtMinRechargeBcp());
					o.addProperty("amtMaxRechargeBcp", accountDataPart.getAmtMaxRechargeBcp());
					o.addProperty("maxRechargePerDayVisa", accountDataPart.getMaxRechargePerDayVisa());
					o.addProperty("maxAmtPerWeekVisa", accountDataPart.getMaxAmtPerWeekVisa());

					o.addProperty("stateRechargeVisa", accountDataPart.getStateRechargeVisa());
					o.addProperty("stateRechargeBcp", accountDataPart.getStateRechargeBcp());
					o.addProperty("stateRechargeLoto", accountDataPart.getStateRechargeLoto());
					o.addProperty("stateRechargeIbk", accountDataPart.getStateRechargeIbk());
					o.addProperty("amtMinRechargeIbk", accountDataPart.getAmtMinRechargeIbk());
					o.addProperty("amtMaxRechargeIbk", accountDataPart.getAmtMaxRechargeIbk());
					o.addProperty("stateRechargePefe", accountDataPart.getStateRechargePefe());
					o.addProperty("amtMinRechargePefe", accountDataPart.getAmtMinRechargePefe());
					o.addProperty("amtMaxRechargePefe", accountDataPart.getAmtMaxRechargePefe());
					o.addProperty("stateRechargeSpay", accountDataPart.getStateRechargeSpay());
					o.addProperty("amtMinRechargeSpay", accountDataPart.getAmtMinRechargeSpay());
					o.addProperty("amtMaxRechargeSpay", accountDataPart.getAmtMaxRechargeSpay());

					o.addProperty("stateRechargeYape", accountDataPart.getStateRechargeYape());
					o.addProperty("amtMinRechargeYape", accountDataPart.getAmtMinRechargeYape());
					o.addProperty("amtMaxRechargeYape", accountDataPart.getAmtMaxRechargeYape());
					o.addProperty("stateRechargePlin", accountDataPart.getStateRechargePlin());
					o.addProperty("amtMinRechargePlin", accountDataPart.getAmtMinRechargePlin());
					o.addProperty("amtMaxRechargePlin", accountDataPart.getAmtMaxRechargePlin());
					
					o.addProperty("stateRechargeBbva", accountDataPart.getStateRechargeBbva());
					o.addProperty("amtMinRechargeBbva", accountDataPart.getAmtMinRechargeBbva());
					o.addProperty("amtMaxRechargeBbva", accountDataPart.getAmtMaxRechargeBbva());
					
					o.addProperty("stateRechargeIzi", accountDataPart.getStateRechargeIzi());
					o.addProperty("amtMinRechargeIzi", accountDataPart.getAmtMinRechargeIzi());
					o.addProperty("amtMaxRechargeIzi", accountDataPart.getAmtMaxRechargeIzi());
					
					o.addProperty("docTypeIzi", accountDataPart.getDocTypeIzi());
					o.addProperty("docNumber", accountDataPart.getDocNumber());
					o.addProperty("nombre", accountDataPart.getNombre());
					o.addProperty("apellidos", accountDataPart.getApellidos());
					o.addProperty("cid", tokenValidation.getClientId());
					o.addProperty("stateRechargePlinTupay", accountDataPart.getStateRechargePlinTupay());
					o.addProperty("amtMinRechargePlinTupay", accountDataPart.getAmtMinRechargePlinTupay());
					o.addProperty("amtMaxRechargePlinTupay", accountDataPart.getAmtMaxRechargePlinTupay());
					o.addProperty("stateRechargeYapeTupay", accountDataPart.getStateRechargeYapeTupay());
					o.addProperty("amtMinRechargeYapeTupay", accountDataPart.getAmtMinRechargeYapeTupay());
					o.addProperty("amtMaxRechargeYapeTupay", accountDataPart.getAmtMaxRechargeYapeTupay());

					session.setAttribute("accountDataPart", accountDataPart);

					String maximoCodigosBCP = ((ConnectionFactory.operationProperty("maximoCodigosBCP",
							Constantes.contextSale) != null)
									? ConnectionFactory.operationProperty("maximoCodigosBCP", Constantes.contextSale)
											.trim()
									: "3");
					o.addProperty("maximoCodigosBCP", maximoCodigosBCP);
					
					String maximoCodigosBBVA = ((ConnectionFactory.operationProperty("maximoCodigosBBVA", Constantes.contextSale) != null)
									? ConnectionFactory.operationProperty("maximoCodigosBBVA", Constantes.contextSale).trim(): "3");
					o.addProperty("maximoCodigosBBVA", maximoCodigosBBVA);
				}
				
				o.addProperty("message", tokenValidation.getMessage());
				
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			LoggerApi.Log.info("-------------- end loadRechargeTR"+" tokenValidation=" +tokenValidation);
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

			LoggerApi.Log.info("url_pago " + url_pago);

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

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK
					&& conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

			String output;
			while ((output = br.readLine()) != null) {
				break;
			}
			conn.disconnect();

			// Resultado
			// PagoResult jsonButtonForm = gson.fromJson(output, PagoResult.class);

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
		String ip=SecurityUtils.getClientIp(request);
//		Enumeration<String> headerNames = request.getHeaderNames();
//		if (headerNames != null) {
//		  while (headerNames.hasMoreElements()) {
//			String headerName=headerNames.nextElement();
//			LoggerApi.Log.info("Header "+ headerName+":" + request.getHeader(headerName));
//		  }
//		}

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

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK
					&& conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

			}
			conn.disconnect();

//			HttpSession session = request.getSession();
//			Client client = (Client) session.getAttribute("CLIENT_SESSION");
			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
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
			jsonObject.put("monto", intralotUtils.formatCurrency(Double.parseDouble(monto)).replace("S", "").replace("/", ""));
						
			if (actbono.contains("true-casino") || actbono.equalsIgnoreCase("true") || actwbbono.equalsIgnoreCase("true")) {
				String balanceItem = jsonObject.getString("balanceItem");
				if (!balanceItem.equals("0")) {
					PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(clientId,
							Integer.parseInt(balanceItem));
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
			jsonString = jsonObject.toString();
			HttpSession session = request.getSession();
			session.setAttribute("visanetTransaction", jsonString);
//			response.sendRedirect(session.getAttribute("WS_URL_PAGO_TOKEN_RESULT_REDIRECT").toString());
			if(redirect) {
				response.sendRedirect(ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT", Constantes.contextSale));
			}else {
				response.sendRedirect("white.html");
			}
			LoggerApi.Log.info("----- end "+log);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/pagoTokenFormResultTA")
	public void pagoTokenFormResultTA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="pagoTokenFormResultTA";
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
		String ip=SecurityUtils.getClientIp(request);
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

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK
					&& conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

			}
			conn.disconnect();

//			HttpSession session = request.getSession();
//			Client client = (Client) session.getAttribute("CLIENT_SESSION");
			
			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
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
			if (actbono.contains("true-casino") || actbono.equalsIgnoreCase("true") || actwbbono.equalsIgnoreCase("true")) {
				String balanceItem = jsonObject.getString("balanceItem");
				if (!balanceItem.equals("0")) {
					PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(clientId,
							Integer.parseInt(balanceItem));
					if (promoFistAccount != null) {
						promotionMessage = promoFistAccount.getPromotion_message();
						if (promotionMessage.equals("OK")) {
							String promotionEco = promoFistAccount.getPromotion_eco();
							promotionMessage = promotionEco;
							jsonObject.put("promotionMessage", promotionEco);
						} else {
							jsonObject.put("promotionMessage", promotionMessage);
						}
						jsonString = jsonObject.toString();
					}
				}
			}

			String time = String.valueOf(new java.util.Date().getTime() / 1000);
			String auth = DigestUtils.sha1Hex(clientId +  ConnectionFactory.operationProperty("auth_key_payment_callback", Constantes.contextSale) + time);
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
					rptaTransaccion+="<br>Comisión por recarga con Tarjeta Visa: "+intralotUtils.formatCurrency(comision);
				}
				rptaTransaccion += "<br><br><span style=\"font-size: 11px;\">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>";
				String montoFormateado = intralotUtils.formatCurrency(Double.parseDouble(monto));
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

			URL urlApi = new URL(ConnectionFactory.operationProperty("WS_URL_PAYMENT_CALLBACK", Constantes.contextSale));
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
				response.sendRedirect(ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_REDIRECT_TA", Constantes.contextSale));
			}else {
				response.sendRedirect("white.html");
			}
			LoggerApi.Log.info("----- end "+log);
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
		LoggerApi.Log.info("-------------- START buildVisaForm");
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		Gson gsonJson = new Gson();
		JsonButtonForm jsonButtonForm = null;
		try {
			BufferedReader reader = request.getReader();
			Gson gsonForm = new Gson();
			VisanetParameters paramForm = gsonForm.fromJson(reader, VisanetParameters.class);

			if (paramForm != null) {
				HttpSession session = request.getSession();
				ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
				int visanetMinAmount = 20;
				int visanetMaxAmount = 1000;
				double comision = 0;
				double amount = Double.parseDouble(paramForm.getAmount());
				//int amount = Integer.parseInt(paramForm.getAmount());
				//int visanetMinAmount = ((ConnectionFactory.operationProperty("visanetMinAmount", "CARD-WEB") != null) ? Integer.parseInt(ConnectionFactory.operationProperty("visanetMinAmount", "CARD-WEB").trim()): 20);
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
					jsonButtonForm.setHtmlText("<div class='info'></div><p>Tipo de tarjeta no v&aacute;lido.</p>");
					out.write(gsonJson.toJson(jsonButtonForm));
					return;
				}
				
				if (amount >= visanetMinAmount) {
					//int visanetMaxAmount = ((ConnectionFactory.operationProperty("visanetMaxAmount","CARD-WEB") != null)? Integer.parseInt(ConnectionFactory.operationProperty("visanetMaxAmount", "CARD-WEB").trim()): 10);
					if (amount <= visanetMaxAmount) {
						Client client = (Client) session.getAttribute("CLIENT_SESSION");
						
						BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa = beanClientBalanceBo.resultEvalRulesVisa(client.getClientId(), amount);
						if(resultEvalRulesVisa.getResult().equals(Constantes.RESULT_OK)) {
							VisanetParameters param = new VisanetParameters();
							param.setClientId(client.getClientId());
							//param.setAmount(paramForm.getAmount());
							double montoTotal = amount+comision;
							param.setAmount(montoTotal+"");
							param.setRemoteAddr(request.getRemoteAddr());
							param.setCardHolderName(client.getName().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a")
									.replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o")
									.replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "")
									.replace("5", "").replace("6", "").replace("7", "").replace("8", ""));
							param.setCardHolderLastName((client.getLastname() + ((client.getMaidenname() != null) ? " " + client.getMaidenname() : "")).toLowerCase().replace("á", "a").replace("é", "e")
									.replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a")
									.replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "")
									.replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "")); 
							param.setCardHolderEmail("CID" + client.getClientId() + "@intralot.com.pe");
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
							session.setAttribute("VISANET_SK", sk);
							if (!sk.equals("0")) {
								jsonButtonForm.setSessionKey("");
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
				jsonButtonForm.setHtmlText(
						"<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
				out.write(gsonJson.toJson(jsonButtonForm));
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			jsonButtonForm = new JsonButtonForm();
			jsonButtonForm.setSessionKey("0");
			jsonButtonForm.setHtmlText(
					"<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
			out.write(gsonJson.toJson(jsonButtonForm));
		}
		LoggerApi.Log.info("-------------- END buildVisaForm");
	}

	public String callWsVisaForm(String serverIP, String json) {
		try {
			// String urlVisanetForm = visanetParametrosBo.getUrlVisanetForm(serverIP);
			String urlVisanetForm = getUrWslVisanet();

			LoggerApi.Log.info("urlVisanetForm " + urlVisanetForm);

			URL url = new URL(urlVisanetForm);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK
					&& conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

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
		 * try { InputStream input =
		 * ClientBalanceController.class.getClassLoader().getResourceAsStream(
		 * "resource/visanet.properties");
		 * 
		 * Properties prop = new Properties();
		 * 
		 * if (input == null) {
		 * System.out.println("Sorry, unable to find config.properties"); return null; }
		 * 
		 * //load a properties file from class path, inside static method
		 * prop.load(input);
		 * 
		 * //get the property value and print it out return
		 * prop.getProperty("url_ws_visanet");
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); return null; }
		 */
	}

	@RequestMapping(value = "/findVisanetRecargaResult")
	public void findVisanetRecargaResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		VisanetParameters paramForm = gson.fromJson(reader, VisanetParameters.class);

		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("CLIENT_SESSION");
		String sk = (String) session.getAttribute("VISANET_SK");

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			String jsonString = callWsRecargaResult(request.getLocalAddr(), sk, client.getClientId());

			if (paramForm.getCodePromotional() != null || !paramForm.getCodePromotional().isEmpty()) {
				LoggerApi.Log.info("-------------- codigo promocional: " + paramForm.getCodePromotional() );
				JSONObject jsonObject = new JSONObject(jsonString);
				String balanceItem = jsonObject.getString("balanceItem");
				if (!balanceItem.equals("0")) {
					PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(client.getClientId(),
							Integer.parseInt(balanceItem));
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
	}

	public String callWsRecargaResult(String serverIP, String sk, Integer clientId) {
		try {
			// String urlUpdateBalance = visanetParametrosBo.getUrlUpdateBalance(serverIP);
			String urlUpdateBalance = ConnectionFactory.operationProperty("url_ws_result", "sale");

			URL url = new URL(urlUpdateBalance + "/" + sk + "/" + "CID" + clientId + "@intralot.com.pe"); // param.getCardHolderEmail());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			int responseCode = conn.getResponseCode();

			if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + responseCode);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

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

	@RequestMapping(value = "/redireccionarRecarga")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("client/redirect");
	}
	
	@RequestMapping(value = "/white")
	public ModelAndView white(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("client/white");
	}

	@RequestMapping(value = "/resetVisanetTransaction")
	public void resetVisanetTransaction(HttpServletRequest request, HttpServletResponse response,
			ModelMap objectModelMap) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("visanetTransaction", null);
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	o.addProperty("reset", "OK");
    	out.print(o);
	}
	
	@RequestMapping(value = "/montoPorDia")
    public void findByMontoPorDia(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            PrintWriter out = null;
            out = response.getWriter();
            String resultClient = "";
            
            Client client = (Client) session.getAttribute("CLIENT_SESSION");
                 
                List<BalanceProcedureGetMontoPorDia> balanceList = beanClientBalanceBo.findMontoPorDia(client.getClientId());
                if(balanceList.get(0)!=null) {
                	 resultClient=balanceList.get(0).getM_dia();
                	 out.print(resultClient);
                }
                else {
                	  resultClient="0";
                      out.print(resultClient);
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
		PrintWriter out = response.getWriter();
		String resultClient = "0";
        try {
            Client client = (Client) session.getAttribute("CLIENT_SESSION");
            List<BalanceProcedureGetMontoPorDiaAgora> balanceList = beanClientBalanceBo.findMontoPorDiaAgora(client.getClientId());
            if(balanceList!= null && balanceList.get(0)!=null) {
            	resultClient=balanceList.get(0).getMontoPorDia();
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } 
        out.print(resultClient);
    }
	
	@RequestMapping(value = "/rechargeAgora")
	public void rechargeAgora(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		LoggerApi.Log.info("-------------- START rechargeAgora");
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
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
			String codePromotional = request.getParameter("codePromotional");
			String idClient = "";
			double amount = 0.0;
						
			LoggerApi.Log.info("ip: "+ip+" monto: "+monto+" bono: "+bono+" wbbono: "+wbbono+" phoneUpdateAgora: "+phoneUpdateAgora+" phoneUpdate: "+phoneUpdate + " codePromotional="+codePromotional);			
			if(monto!=null && !monto.trim().isEmpty()) {
				amount = Double.parseDouble(monto);
			}
			if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    	}
			
			ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
			if(!idClient.isEmpty()) {
				if(amount<=accountDataPart.getAmtMaxRechargeAgr()) {
					if(amount>=accountDataPart.getAmtMinRechargeAgr()) {
						int clientId = Integer.parseInt(idClient);
						BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora = beanClientBalanceBo.resultEvalRulesAgora(clientId, amount);
						if(resultEvalRulesAgora.getResult().equals(Constantes.RESULT_OK)) {		
							String phone = accountDataPart.getMobilePhone();
							String msgPhoneValidation = "";
							if(accountDataPart.getRechargeAgora().trim().equals(Constantes.STATE_WITHOUT_AGORA) && phoneUpdateAgora.equals("1")) {
								phone=phoneUpdate;
								boolean verifyMobilePhone = intralotUtils.verifySintaxMobilePhone(phone);
					            if (!verifyMobilePhone) {
					            	msgPhoneValidation = Constantes.MSG_PHONE_INVALID;
					            }else {
					            	ClientProcedureValidateNewPhoneAgora objValidateNewPhoneAgora = beanClientBalanceBo.validateNewPhoneAgora(clientId, phone);
					            	if(objValidateNewPhoneAgora!=null && !objValidateNewPhoneAgora.getResult().equals(Constantes.RESULT_OK)) {
					            		msgPhoneValidation = objValidateNewPhoneAgora.getMessage();
					            	}
					            }
							}
							
							if(phone!=null && !phone.trim().isEmpty()) {
								if(msgPhoneValidation.isEmpty()) {

									PaymentRequest paymentRequest = new PaymentRequest(); 
					                PaymentResponse paymentResponse = new PaymentResponse(); 
					                paymentRequest.setPlataform(Constantes.PLATAFORM);
					                paymentRequest.setPromotionKey(codePromotional);
					                paymentRequest.setAmount(amount);
					                paymentRequest.setPhone(phone);
					                paymentRequest.setClientId(clientId);
					                Gson gson = new Gson();
					    			String json = gson.toJson(paymentRequest);	
					                paymentResponse = getPaymentAgoraResponse(json, uuid);
					                if(paymentResponse!=null) {
					                	if(paymentResponse.getState().equals(Constantes.RESULT_OK)) {
					                		o.addProperty("btnName", "Volver a mi cuenta");
						                	String mensaje = "<p style='text-align: center;'>Confirma la recarga desde tu app Agora.</p>";
						                	if(accountDataPart.getRechargeAgora().trim().equals(Constantes.STATE_WITHOUT_AGORA)) {
						                		ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora = beanClientBalanceBo.updateStateRechargeAgora(clientId, phoneUpdateAgora, phone);
						                		if(updateStateRechargeAgora!=null && updateStateRechargeAgora.getResult().equals(Constantes.RESULT_OK)) {
						                			accountDataPart.setRechargeAgora(Constantes.STATE_WITH_AGORA);
						                			session.setAttribute("accountDataPart",accountDataPart);
						                			if(updateStateRechargeAgora.getStateUpdatePhone().equals(Constantes.RESULT_OK)) {
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
					                		if(code!=null && code.trim().equals(Constantes.AGORA_ERROR_CODE_ECM_PAY_02)) {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constantes.AGORA_MSG_ECM_PAY_02);
					                		}else {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constantes.MSG_EXCEPTION);
					                		}
					                	}
					                }else {
					                	o.addProperty("state", "KO");
					    				o.addProperty("message", Constantes.MSG_EXCEPTION);
					                }
								}else {
									o.addProperty("state", "KO");
				    				o.addProperty("message", msgPhoneValidation);
								}
							}else {
								o.addProperty("state", "KO");
			    				o.addProperty("message", Constantes.MSG_PHONE_INVALID);
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
				o.addProperty("message", Constantes.MSG_EXCEPTION);
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("state", "KO");
			o.addProperty("message", Constantes.MSG_EXCEPTION);
		}
		LoggerApi.Log.info("-------------- START rechargeAgora");
	}
	
	private PaymentResponse getPaymentAgoraResponse(String json, String uuid) {
		PaymentResponse paymentResponse = new PaymentResponse();
		Gson gson = new Gson();
		try {
			String urlPaymentAgoraAPI = ConnectionFactory.operationProperty("urlPaymentAgoraAPI", Constantes.contextSale);
			String userAgoraAPI = ConnectionFactory.operationProperty("userAgoraAPI", Constantes.contextSale);
			String passAgoraAPI = ConnectionFactory.operationProperty("passAgoraAPI", Constantes.contextSale);
			String credenciales = userAgoraAPI+":"+passAgoraAPI;
			credenciales = Base64.encodeBase64String(credenciales.getBytes());
 	    	URL url = new URL(urlPaymentAgoraAPI);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
 			con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
 			con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
     		con.setDoOutput(true);
     		OutputStream os = con.getOutputStream();
 			os.write(json.getBytes(Constantes.CHARSET_UTF8));
 			os.flush();
 			os.close();
 			BufferedReader br = null;
 			int responseCode = con.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
 			}else {
 				LoggerApi.Log.info("API Agora HTTP CODE: "+responseCode+" uuid: "+uuid+ " json: "+json);
 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
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
	
	@RequestMapping(value = "/buildVisaFormRT")
	public void buildVisaFormRT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START buildVisaFormRT");
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		Gson gsonJson = new Gson();
		JsonButtonForm jsonButtonForm = null;
		try {
			BufferedReader reader = request.getReader();
			Gson gsonForm = new Gson();
			VisanetParameters paramForm = gsonForm.fromJson(reader, VisanetParameters.class);
			String rechargetoken=request.getHeader("rechargetoken");
			String ip=SecurityUtils.getClientIp(request);	

			if (paramForm != null) {
				//HttpSession session = request.getSession();
				ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();
				Client client= new Client();
				String pagoTokenUrl="";
				
				//Validar token
				ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
				tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
				if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
					Integer idClient = Integer.parseInt(tokenValidation.getClientId());
					accountDataPart = beanClientBalanceBo.findAccountDataPart(idClient);						
					client=beanClientAccountBo.findClientById(idClient);
					if(tokenValidation.getOperatorId().equals("5586")) {
						pagoTokenUrl=ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT", Constantes.contextSale);
					}
					else {
						pagoTokenUrl=ConnectionFactory.operationProperty("WS_URL_PAGO_TOKEN_RESULT_TA", Constantes.contextSale);
					}
					
				}else {
					jsonButtonForm = new JsonButtonForm();
					jsonButtonForm.setSessionKey("0");
					String estado=tokenValidation.getStatus();
					String msj="<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>";
					if(estado.equals("TIMEOUTTR")) {
						msj=estado;
					}
					jsonButtonForm.setHtmlText(msj);
					out.write(gsonJson.toJson(jsonButtonForm));
					LoggerApi.Log.info("-------------- end buildVisaFormRT"+" tokenValidation=" +tokenValidation);
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
				  jsonButtonForm.setHtmlText("<div class='info'></div><p>El monto ingresado es incorrecto</p>");
				  out.write(gsonJson.toJson(jsonButtonForm));
				  LoggerApi.Log.info("-------------- end buildVisaFormRT"+" samount=" +samount);
				  return;
				}
				double amount = Double.parseDouble(samount);
				//int amount = Integer.parseInt(paramForm.getAmount());
				//int visanetMinAmount = ((ConnectionFactory.operationProperty("visanetMinAmount", "CARD-WEB") != null) ? Integer.parseInt(ConnectionFactory.operationProperty("visanetMinAmount", "CARD-WEB").trim()): 20);
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
					jsonButtonForm.setHtmlText("<div class='info'></div><p>Tipo de tarjeta no v&aacute;lido.</p>");
					out.write(gsonJson.toJson(jsonButtonForm));
					return;
				}
				
				if (amount >= visanetMinAmount) {
					//int visanetMaxAmount = ((ConnectionFactory.operationProperty("visanetMaxAmount","CARD-WEB") != null)? Integer.parseInt(ConnectionFactory.operationProperty("visanetMaxAmount", "CARD-WEB").trim()): 10);
					if (amount <= visanetMaxAmount) {
						
						
						BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa = beanClientBalanceBo.resultEvalRulesVisa(client.getClientId(), amount);
						if(resultEvalRulesVisa.getResult().equals(Constantes.RESULT_OK)) {
							VisanetParameters param = new VisanetParameters();
							param.setClientId(client.getClientId());
							//param.setAmount(paramForm.getAmount());
							double montoTotal = amount+comision;
							param.setAmount(montoTotal+"");
							param.setRemoteAddr(request.getRemoteAddr());
							param.setCardHolderName(client.getName().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a")
									.replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o")
									.replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "")
									.replace("5", "").replace("6", "").replace("7", "").replace("8", ""));
							param.setCardHolderLastName((client.getLastname() + ((client.getMaidenname() != null) ? " " + client.getMaidenname() : "")).toLowerCase().replace("á", "a").replace("é", "e")
									.replace("í", "i").replace("ó", "o").replace("ú", "u").replace("à", "a").replace("è", "e").replace("ì", "i").replace("ò", "o").replace("ù", "u").replace("ä", "a")
									.replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u").replace("ñ", "n").replace("'", "").replace("0", "").replace("9", "").replace("1", "")
									.replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "")); 
							param.setCardHolderEmail("CID" + client.getClientId() + "@intralot.com.pe");
							param.setMerchantLogo(paramForm.getMerchantLogo());
							param.setTimeoutUrl(paramForm.getTimeoutUrl());
							//validar activación de bono
				            String codePromotional = (paramForm.getCodePromotional() !=null)?paramForm.getCodePromotional().toString().trim():"";
				        	String channel = (paramForm.getChannel()!=null)?paramForm.getChannel().toString().trim():"";		        	

				        	LoggerApi.Log.info("buildVisaFormRT "+" channel=" +channel + " codePromotional=" + codePromotional);
				        	
							param.setActbono("");
							param.setActwbbono("");
							param.setCodePromotional(codePromotional);
							param.setPagoTokenUrl(pagoTokenUrl);
							param.setTypeCard(paramForm.getTypeCard());
							param.setComision(comision);
	
							Gson gson = new Gson();
							String json = gson.toJson(param);
	
							String jsonString = callWsVisaForm(request.getLocalAddr(), json);
							jsonButtonForm = gsonJson.fromJson(jsonString, JsonButtonForm.class);
							String sk = jsonButtonForm.getSessionKey();
							//session.setAttribute("VISANET_SK", sk);
							ClientProcedureUpdateVisaSession visaSession = beanClientAccountBo.setVisaSession(client.getClientId(), sk);
							if(!visaSession.getMessage().equals("OK")) {
								jsonButtonForm = new JsonButtonForm();
								jsonButtonForm.setSessionKey("0");
								jsonButtonForm.setHtmlText(
										"<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
								out.write(gsonJson.toJson(jsonButtonForm));
								LoggerApi.Log.info("-------------- END buildVisaFormRT"+" visaSession.getMessage=" +visaSession.getMessage());
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
							String platform=Constantes.PLATAFORM;
							String operatorId=tokenValidation.getOperatorId();
							
							LoggerApi.Log.info("clientId= "+clientId +" platform=" + platform + " operatorId="+operatorId + " montoTotal="+montoTotal);
							
							ClientProcedureOriginVisaRecharge originVisaRecharge = beanClientAccountBo.setOriginVisaRecharge(sk, clientId, montoTotal, platform, operatorId);
							if(!originVisaRecharge.getStatus().equals("OK")) {
								LoggerApi.Log.info("-------------- buildVisaFormRT"+" originVisaRecharge.getMessage=" +originVisaRecharge.getMessage());
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
				jsonButtonForm.setHtmlText(
						"<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
				out.write(gsonJson.toJson(jsonButtonForm));
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			jsonButtonForm = new JsonButtonForm();
			jsonButtonForm.setSessionKey("0");
			jsonButtonForm.setHtmlText(
					"<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
			out.write(gsonJson.toJson(jsonButtonForm));
		}
		
		LoggerApi.Log.info("-------------- END buildVisaFormRT");
	}
	
	@RequestMapping(value = "/registerCA")
	public void registerCA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		String ip=SecurityUtils.getClientIp(request);
		Integer clientId=0;
		PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        String rechargetoken=request.getHeader("rechargetoken");
		try {
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
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
				valuesRegisterErrorCA[2] = "MOBILE";
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
					valuesRegisterTYCPDPLog[4] = "MOBILE";
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
						MailLib.sendValidMail(ConnectionFactory.operationProperty("mailSourceApp", Constantes.contextSale), "LA TINKA", ConnectionFactory.operationProperty("mailTargetAntifraudeRecarga", Constantes.contextSale),"Alerta de fraude", body, Constantes.FORMAT_HTML_UTF8, null, null, null, null);
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
	
	@RequestMapping(value = "/findVisanetRecargaResultRT")
	public void findVisanetRecargaResultRT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START findVisanetRecargaResultRT");
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		VisanetParameters paramForm = gson.fromJson(reader, VisanetParameters.class);
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=SecurityUtils.getClientIp(request);	
		Integer clientId=0;
		String sk="";
		String jsonString="";

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId = Integer.parseInt(tokenValidation.getClientId());
				sk=beanClientAccountBo.findVisaSessionById(clientId);
				
				jsonString = callWsRecargaResult(request.getLocalAddr(), sk, clientId);

				if (paramForm.getCodePromotional() != null || !paramForm.getCodePromotional().isEmpty()) {
					LoggerApi.Log.info("-------------- codigo promocional: " + paramForm.getCodePromotional() );
					JSONObject jsonObject = new JSONObject(jsonString);
					String balanceItem = jsonObject.getString("balanceItem");
					if (!balanceItem.equals("0")) {
						PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(clientId,
								Integer.parseInt(balanceItem));
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
				LoggerApi.Log.info("-------------- status: " + tokenValidation.getStatus());
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
		}
		LoggerApi.Log.info("-------------- END findVisanetRecargaResultRT");
	}
	
	@RequestMapping(value = "/rechargeAgoraRT")
	public void rechargeAgoraRT(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		LoggerApi.Log.info("-------------- START rechargeAgoraRT");
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
//		HttpSession session = request.getSession();
		String rechargetoken=request.getHeader("rechargetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		
		try {
			//Validar token
			ClientProcedureAccountDataPart accountDataPart = new ClientProcedureAccountDataPart();
			String idClient="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient = tokenValidation.getClientId();
				accountDataPart = beanClientBalanceBo.findAccountDataPart(Integer.parseInt(idClient));
			}else {				
				o.addProperty("state", "KO");
				String state=tokenValidation.getStatus();
				if(state.equals("TIMEOUTTR")) {
					o.addProperty("state", state);
				}
				o.addProperty("message", Constantes.MSG_EXCEPTION);
				out.print(o);
				LoggerApi.Log.info("tokenValidation ="+tokenValidation.toString());
				return;
			}	
			String ip = request.getRemoteAddr();
			String monto = (request.getParameter("monto")!=null)?request.getParameter("monto"):"";
			//Validar monto ingresado
			Boolean veryfyAmount= DoubleValidator.getInstance().isValid(monto);
			if(!veryfyAmount) {			
				o.addProperty("state", "KO");
				o.addProperty("message", "El monto ingresado es incorrecto");
				out.print(o);
				LoggerApi.Log.info("rechargeAgoraRT monto="+monto);
				return;
			}
			String bono = request.getParameter("actbono");
			String wbbono = request.getParameter("actwbbono");
			String phoneUpdate = request.getParameter("phoneUpdate"); 
			String phoneUpdateAgora = request.getParameter("phoneUpdateAgora");

			double amount = 0.0;
						
			LoggerApi.Log.info("ip: "+ip+" monto: "+monto+" bono: "+bono+" wbbono: "+wbbono+" phoneUpdateAgora: "+phoneUpdateAgora+" phoneUpdate: "+phoneUpdate);			
			if(monto!=null && !monto.trim().isEmpty()) {
				amount = Double.parseDouble(monto);
			}

			if(!idClient.isEmpty()) {
				if(amount<=accountDataPart.getAmtMaxRechargeAgr()) {
					if(amount>=accountDataPart.getAmtMinRechargeAgr()) {
						int clientId = Integer.parseInt(idClient);
						BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora = beanClientBalanceBo.resultEvalRulesAgora(clientId, amount);
						if(resultEvalRulesAgora.getResult().equals(Constantes.RESULT_OK)) {		
							String phone = accountDataPart.getMobilePhone();
							String msgPhoneValidation = "";
							if(accountDataPart.getRechargeAgora().trim().equals(Constantes.STATE_WITHOUT_AGORA) && phoneUpdateAgora.equals("1")) {
								phone=phoneUpdate;
								boolean verifyMobilePhone = intralotUtils.verifySintaxMobilePhone(phone);
					            if (!verifyMobilePhone) {
					            	msgPhoneValidation = Constantes.MSG_PHONE_INVALID;
					            }else {
					            	ClientProcedureValidateNewPhoneAgora objValidateNewPhoneAgora = beanClientBalanceBo.validateNewPhoneAgora(clientId, phone);
					            	if(objValidateNewPhoneAgora!=null && !objValidateNewPhoneAgora.getResult().equals(Constantes.RESULT_OK)) {
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

						        	LoggerApi.Log.info("ip: "+ip+" monto: "+monto+" codePromotional: "+codePromotional+" channel: "+channel+" lotocard: "+lotocard);	
						        	
						            PaymentRequest paymentRequest = new PaymentRequest(); 
					                PaymentResponse paymentResponse = new PaymentResponse(); 
					                paymentRequest.setPlataform(Constantes.PLATAFORM);
					                paymentRequest.setPromotionKey(codePromotional);
					                paymentRequest.setAmount(amount);
					                paymentRequest.setPhone(phone);
					                paymentRequest.setClientId(clientId);
					                Gson gson = new Gson();
					    			String json = gson.toJson(paymentRequest);	
					                paymentResponse = getPaymentAgoraResponse(json, uuid);
					                if(paymentResponse!=null) {
					                	if(paymentResponse.getState().equals(Constantes.RESULT_OK)) {
					                		o.addProperty("btnName", "Volver a mi cuenta");
						                	String mensaje = "<p style='text-align: center;'>Confirma la recarga desde tu app Agora.</p>";
						                	if(accountDataPart.getRechargeAgora().trim().equals(Constantes.STATE_WITHOUT_AGORA)) {
						                		ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora = beanClientBalanceBo.updateStateRechargeAgora(clientId, phoneUpdateAgora, phone);
						                		if(updateStateRechargeAgora!=null && updateStateRechargeAgora.getResult().equals(Constantes.RESULT_OK)) {
						                			accountDataPart.setRechargeAgora(Constantes.STATE_WITH_AGORA);
//						                			session.setAttribute("accountDataPart",accountDataPart);
						                			if(updateStateRechargeAgora.getStateUpdatePhone().equals(Constantes.RESULT_OK)) {
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
					                		if(code!=null && code.trim().equals(Constantes.AGORA_ERROR_CODE_ECM_PAY_02)) {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constantes.AGORA_MSG_ECM_PAY_02);
					                		}else {
					                			o.addProperty("state", "KO");
							    				o.addProperty("message", Constantes.MSG_EXCEPTION);
					                		}
					                	}
					                }else {
					                	o.addProperty("state", "KO");
					    				o.addProperty("message", Constantes.MSG_EXCEPTION);
					                }
								}else {
									o.addProperty("state", "KO");
				    				o.addProperty("message", msgPhoneValidation);
								}
							}else {
								o.addProperty("state", "KO");
			    				o.addProperty("message", Constantes.MSG_PHONE_INVALID);
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
				o.addProperty("message", Constantes.MSG_EXCEPTION);
			}
			out.print(o);
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("state", "KO");
			o.addProperty("message", Constantes.MSG_EXCEPTION);
		}
		finally {
			LoggerApi.Log.info("-------------- END rechargeAgoraRT");
		}
		
	}
	
	@RequestMapping(value = "/send-code-promotional-validation-rt")
	public void codePromotionalValidationRT(@RequestParam("callback") String callback, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START sendCodePromotionalValidationRT");
		response.setContentType("application/json; charset=UTF-8");
//		HttpSession session = request.getSession();
		PinPrinted pinPrinted = null;
		JsonObject o = new JsonObject();
		PrintWriter out = response.getWriter();
		String outData = "";
		String rechargetoken=request.getHeader("rechargetoken");
		String ipToken=SecurityUtils.getClientIp(request);	
		
		try {
			String ip = request.getRemoteAddr();
			String codePromotional = (request.getParameter("codePromotional") != null)
					? request.getParameter("codePromotional").toString().trim()
					: "";
					
			//Validar código de bono que contiene caracteres en minúscula, mayúscula y números, sin espacios
			String expRegCodePromotional="[a-zA-Z\\d]{1,20}";
			Boolean veryfyCodePromotional= new RegexValidator(expRegCodePromotional).isValid(codePromotional);
			if(!veryfyCodePromotional) {
				o.addProperty("status", "DES");
				o.addProperty("message", "C&oacute;digo promocional no existe");
				return;
			}
			String channel = (request.getParameter("channel") != null)
					? request.getParameter("channel").toString().trim()
					: "";
			//Validar medio de pago
			String expRegChannel="[A-Z\\_]{1,8}";
			Boolean veryfyCodeChannel= new RegexValidator(expRegChannel).isValid(channel);
			if(!veryfyCodeChannel) {
				o.addProperty("status", "DES");
				o.addProperty("message", "Medio de pago no existe");
				return;
			}
			//Validar monto de recarga
			String samount = (request.getParameter("amount") != null)? request.getParameter("amount").trim(): "";

			Boolean veryfyAmount= DoubleValidator.getInstance().isValid(samount);
			  if(!veryfyAmount) {
					o.addProperty("status", "DES");
					o.addProperty("message", "El monto ingresado es incorrecto");
					return;
				}
			Double amount =Double.parseDouble(samount);

        	if(amount <= 0 && !channel.equals("IBK")) {
        		o.addProperty("status", "DES");
    			o.addProperty("message", "El monto no debe ser diferente de vacio o cero");
    			LoggerApi.Log.info("El monto no debe ser diferente de vacio o cero");
    			return;
		    }		  
		  
			String lotocard = (request.getParameter("lotocard") != null)
					? request.getParameter("lotocard").toString().trim()
					: "";

			String clientId="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId=tokenValidation.getClientId();			

				if (!lotocard.trim().isEmpty()) {
					//Validar código lotocard
					String expRegLotocard="[0-9]{14,14}";
					Boolean veryfyLotocard= new RegexValidator(expRegLotocard).isValid(lotocard);
					if(!veryfyLotocard) {
						o.addProperty("status", "DES");
						o.addProperty("message", "C&oacute;digo lotocard no existe");
						return;
					}
					pinPrinted = beanClientLotocardBo.findLotocard(lotocard);
					if (pinPrinted != null) {
						amount = pinPrinted.getPinAmount();
					} else {
						o.addProperty("status", "DES");
						o.addProperty("message", "C&oacute;digo lotocard no existe");
						return;
					}
				}
	
				Object[] values = new Object[6];
				values[0] = codePromotional;
				values[1] = clientId;
				values[2] = channel;
				values[3] = "mobile";
				values[4] = amount;
				values[5] = ip;
	
				ClientProcedureCodeValidation clientProcedureCodeValidation = beanClientBalanceBo
						.codePromotionalValidation(values);
				if (clientProcedureCodeValidation != null) {
					o.addProperty("status", clientProcedureCodeValidation.getState());
					o.addProperty("message", clientProcedureCodeValidation.getMessage());
					o.addProperty("idCode", clientProcedureCodeValidation.getIdCodePromotional());
				} else {
					o.addProperty("status", 500);
					o.addProperty("message", "Incidente inesperado");
				}
			}else {
    			String status=tokenValidation.getStatus();
    			if(status.equals("TIMEOUTTR")) {
    				o.addProperty("status", status);
    			}    			
    		}
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/sendCodePromotionalValidationRT " + o.toString());
		}
		LoggerApi.Log.info("-------------- END sendCodePromotionalValidationRT");
	}
	
	@RequestMapping(value = "/yapePlinVerifyTransactionRT")
    public void yapePlinVerifyTransactionRT(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			LoggerApi.Log.info("-------------- START yapePlinVerifyTransactionRT");
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
//			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	        String rechargetoken=request.getHeader("rechargetoken");
	        String ip=SecurityUtils.getClientIp(request);
	        
	        //Validar token
			String clientId="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId = tokenValidation.getClientId();
//			if ((ClientProcedureLogin) session.getAttribute(Constantes.USR_SESION) != null
//					&& ((ClientProcedureLogin) session.getAttribute(Constantes.USR_SESION)).getSessionId() != null
//					&& ((ClientProcedureLogin) session.getAttribute(Constantes.USR_SESION)).getClientId() != null) {
				Integer idClient = Integer.parseInt(clientId);		
				String channel = request.getParameter("channel");
				
				ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction = beanClientBalanceBo.yapePlinVerifyTransaction(idClient, channel);
				if(yapePlinVerifyTransaction!=null && yapePlinVerifyTransaction.getStatus().trim().equals("ACT")) {
					ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClient);
					o.addProperty("status", "ACT");
					o.addProperty("billetera1", accountDataPart.getBalanceAmount());
					o.addProperty("billetera2", intralotUtils.formatCurrency(Double.parseDouble(accountDataPart.getBonusAmount().replaceAll(",", "."))));
					o.addProperty("billetera3", accountDataPart.getOtherAmount());
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
        	LoggerApi.Log.info("-------------- END yapePlinVerifyTransactionRT");
		}
	}
	private String requestWSIflexApiRecharge(String json, String service) {
    	LoggerApi.Log.info("start requestWSIflexApiRecharge: "+json);
		String jsonResponseIflexApiRecharge="";
		try {
			String urlIflexapiRecharge = ConnectionFactory.operationProperty("urlIflexapiRecharge", Constantes.contextRechargeApi);
			String secretIflexapiRecharge = ConnectionFactory.operationProperty("secretIflexapiRecharge", Constantes.contextRechargeApi);
			String userIflexapiRecharge = ConnectionFactory.operationProperty("userIflexapiRecharge", Constantes.contextRechargeApi);
			String passIflexapiRecharge = ConnectionFactory.operationProperty("passIflexapiRecharge", Constantes.contextRechargeApi);
			String credenciales = userIflexapiRecharge+":"+passIflexapiRecharge;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlIflexapiRecharge+service);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
 			con.setRequestProperty("Secret", secretIflexapiRecharge);
 			con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
 			con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
     		con.setDoOutput(true);
     		OutputStream os = con.getOutputStream();
 			os.write(json.getBytes(Constantes.CHARSET_UTF8));
 			os.flush();
 			os.close();
 			BufferedReader br = null;
 			int responseCode = con.getResponseCode();
 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
 			}else {
 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE HTTP CODE: "+responseCode + " json: "+json);
 				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
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
			LoggerApi.Log.info("end requestWSIflexApiRecharge: "+jsonResponseIflexApiRecharge);
		}
		return jsonResponseIflexApiRecharge;
	}
	
	public static JsonObject backCodePromotionalValidation(String rechargetoken, String ipToken, String ip,
			String codePromotional, String channel, Double amount, String lotocard, SecurityLoginBo beanSecurityLoginBo,
			ClientLotocardBo beanClientLotocardBo, ClientBalanceBo beanClientBalanceBo) throws Exception {
		String log = "backCodePromotionalValidation";
		LoggerApi.Log.info("-------------- START " + log);

		JsonObject o = new JsonObject();
		String wbbono = "false", bono = "false",promotioncodekey="";
		PinPrinted pinPrinted = null;
		try {
			// Validar código de bono que contiene caracteres en minúscula, mayúscula y
			// números, sin espacios
			String expRegCodePromotional = "[a-zA-Z\\d]{1,20}";
			Boolean veryfyCodePromotional = new RegexValidator(expRegCodePromotional).isValid(codePromotional);
			if (!veryfyCodePromotional) {
				o.addProperty("status", "DES");
				o.addProperty("message", "C&oacute;digo promocional no existe");
				return o;
			}
			// Validar medio de pago
			String expRegChannel = "[A-Z\\_]{1,8}";
			Boolean veryfyCodeChannel = new RegexValidator(expRegChannel).isValid(channel);
			if (!veryfyCodeChannel) {
				o.addProperty("status", "DES");
				o.addProperty("message", "Medio de pago no existe");
				return o;
			}
			// Validar monto de recarga
			String samount = (amount != null) ? String.valueOf(amount) : "";
			Boolean veryfyAmount = DoubleValidator.getInstance().isValid(samount);
			if (!veryfyAmount) {
				o.addProperty("status", "DES");
				o.addProperty("message", "El monto ingresado es incorrecto");
				return o;
			}

			String clientId = "";
			ClientProcedureTokenValidation tokenValidation = new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ipToken);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId = tokenValidation.getClientId();

				if (!lotocard.trim().isEmpty()) {
					// Validar código lotocard
					String expRegLotocard = "[0-9]{14,14}";
					Boolean veryfyLotocard = new RegexValidator(expRegLotocard).isValid(lotocard);
					if (!veryfyLotocard) {
						o.addProperty("status", "DES");
						o.addProperty("message", "C&oacute;digo lotocard no existe");
						return o;
					}
					pinPrinted = beanClientLotocardBo.findLotocard(lotocard);
					if (pinPrinted != null) {
						amount = pinPrinted.getPinAmount();
					} else {
						o.addProperty("status", "DES");
						o.addProperty("message", "C&oacute;digo lotocard no existe");
						return o;
					}
				}

				Object[] values = new Object[6];
				values[0] = codePromotional;
				values[1] = clientId;
				values[2] = channel;
				values[3] = "mobile";
				values[4] = amount;
				values[5] = ip;

				ClientProcedureCodeValidation clientProcedureCodeValidation = beanClientBalanceBo
						.codePromotionalValidation(values);
				if (clientProcedureCodeValidation != null) {
					o.addProperty("status", clientProcedureCodeValidation.getState());
					o.addProperty("message", clientProcedureCodeValidation.getMessage());
					o.addProperty("idCode", clientProcedureCodeValidation.getIdCodePromotional());

					LoggerApi.Log.info(log + " message=" + clientProcedureCodeValidation.getMessage());

					if (clientProcedureCodeValidation.getState().equals("ACT")) {
						String idCode = clientProcedureCodeValidation.getIdCodePromotional();
						promotioncodekey=clientProcedureCodeValidation.getPromotionCode();
						bono = "true";
						wbbono = "true";
					}
				} else {
					o.addProperty("status", 500);
					o.addProperty("message", "Incidente inesperado");
				}
			} else {
				String status = tokenValidation.getStatus();
				if (status.equals("TIMEOUTTR")) {
					o.addProperty("status", status);
				}
			}
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			LoggerApi.severe(e);
		} finally {
			LoggerApi.Log.info("-------------- END " + log + " out=" + o.toString());
			o.addProperty("wbbono", wbbono);
			o.addProperty("bono", bono);
		}
		return o;
	}
	
	@RequestMapping(value = "/yapePlinTupayVerifyTransactionAPI")
    public void yapePlinTupayVerifyTransactionAPI(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			LoggerApi.Log.info("-------------- START yapePlinTupayVerifyTransactionAPI");
			response.setCharacterEncoding(Constantes.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	        String rechargetoken=request.getHeader("rechargetoken");
	        String ip=SecurityUtils.getClientIp(request);
	        
	        //Validar token
			String clientId="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				clientId = tokenValidation.getClientId();
				Integer idClient = Integer.parseInt(clientId);		
				String channel = request.getParameter("channel");
				
				ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction = beanClientBalanceBo.yapePlinTupayVerifyTransaction(idClient, channel);
				if(yapePlinTupayVerifyTransaction!=null && yapePlinTupayVerifyTransaction.getStatus().trim().equals("ACT")) {
					ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClient);
					o.addProperty("status", "ACT");
					o.addProperty("billetera1", accountDataPart.getBalanceAmount());
					o.addProperty("billetera2", intralotUtils.formatCurrency(Double.parseDouble(accountDataPart.getBonusAmount().replaceAll(",", "."))));
					o.addProperty("billetera3", accountDataPart.getOtherAmount());
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
        	LoggerApi.Log.info("-------------- END yapePlinTupayVerifyTransactionAPI");
		}
	}
	
	
	@RequestMapping("/client_balance_show_information")
	public String client_balance_information(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			LoggerApi.Log.info("-------------- START client_balance_information");

			HttpSession session = request.getSession();
			ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
			
			if(user == null) {
				LoggerApi.Log.info("No es posible identificar al usuario.");
				return "redirect:security_login_execute_authentication.html";
			}
			
			String clientId = user.getClientId().toString();
			String secretDataIflexapiRecharge = ConnectionFactory.operationProperty("secretDataIflexapiRecharge", Constantes.contextRechargeApi);
			String balanceServiceIflexapiRecharge = ConnectionFactory.operationProperty("balanceServiceIflexapiRecharge", Constantes.contextRechargeApi);
			
			JsonObject jdata = new JsonObject();
	        jdata.addProperty("operatorId", "6");
	        jdata.addProperty("playerId", clientId);
	        jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	        jdata.addProperty("platform", "PTA");
	        jdata.addProperty("secret", secretDataIflexapiRecharge);

	        String iarechargeResponse= beanSecurityLoginBo.requestWSIflexApiRecharge(jdata.toString(), balanceServiceIflexapiRecharge);
	        JSONObject convertedObject = new JSONObject(iarechargeResponse);
	        String status = convertedObject.getString("status");
	        
	        if(!status.equals("OK")) {
	        	LoggerApi.Log.info("Error interno iflex.");
				return "redirect:security_login_execute_authentication.html";
	        }
	        
	        String token=convertedObject.getString("token");
	        objectModelMap.put("token",token);
	        objectModelMap.put("operatorId","1");
	        return "client/interface-balance_main";
		} catch (Exception e) {
			LoggerApi.Log.info("-------------- client_balance_information ERROR" + e.getMessage());
			LoggerApi.Log.info("Error interno desconocido.");
			return "redirect:security_login_execute_authentication.html";
		}
	}
	
	@RequestMapping(value = "/client_balance_information_api")
	public String client_balance_information_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		try {
			LoggerApi.Log.info("-------------- START client_balance_information_api");
	
			String authToken = request.getHeader("authToken");
			
			if(authToken == null) {
				authToken = request.getParameter("authToken");
			}
			
			if (authToken == null) {
				objectModelMap.put("message","No es posible identificar la sesión.");
				return "client/interface-balance_error";
			}
			
			String ipToken = SecurityUtils.getClientIp(request);
			HttpSession session = request.getSession();
	
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(authToken, ipToken);
			
			if (!tokenValidation.getStatus().equals("OK")) {
				objectModelMap.put("message","La sesión no es valida.");
				return "client/interface-balance_error";
			}
			
			if(session.getAttribute("clientId") == null) {
				if(tokenValidation.getClientId() == null) {
					LoggerApi.Log.info("-------------- client_balance_information_api TOKEN INVÁLIDO");
					objectModelMap.put("message","ClientID no existe en validación de token.");
					return "client/interface-balance_error";
				}
				session.setAttribute("clientId", tokenValidation.getClientId());
			}else {
				String clientId = session.getAttribute("clientId").toString();
				
				if(!clientId.equalsIgnoreCase(tokenValidation.getClientId())) {
					objectModelMap.put("message","Usuario de la petición es incorrecto.");
					return "client/interface-balance_error";
				}
			}
			
			String rechargeToken = tokenValidation.getRechargeToken();

			objectModelMap.put("token",rechargeToken);
			objectModelMap.put("operatorId","6");
			
			LoggerApi.Log.info("-------------- END client_balance_information_api");
			
			return "client/interface-balance_form";
		} catch (Exception e) {
			LoggerApi.Log.info("-------------- client_balance_information_api ERROR" + e.getMessage());
			objectModelMap.put("message","Error interno desconocido.");
			return "client/interface-balance_error";
		}
	}
	
	@RequestMapping(value = "/client_balance_information_api_data")
	public void client_balance_information_api_data(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START client_balance_information_api_data");

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String json = "";
		
		try {
			
			String authToken = request.getHeader("authToken");
			
			if(authToken == null) {
				authToken = request.getParameter("authToken");
			}
			
			ClientBalanceInformationRequestDTO clientBalanceInformationRequestDTO = new ClientBalanceInformationRequestDTO();
			clientBalanceInformationRequestDTO.setToken(authToken);
			clientBalanceInformationRequestDTO.setClientIp(SecurityUtils.getClientIp(request));
			clientBalanceInformationRequestDTO.setStartDate(request.getParameter("startdate"));
			clientBalanceInformationRequestDTO.setEndDate(request.getParameter("enddate"));
			
			ClientBalanceInformationResponseDTO clientBalanceResponseDTO = beanClientBalanceBo.getClientBalanceInformation(clientBalanceInformationRequestDTO);
			json = gson.toJson(clientBalanceResponseDTO);
			
			LoggerApi.Log.info("-------------- END client_balance_information_api_data");
		} catch (Exception e) {
			LoggerApi.Log.info("-------------- client_balance_information_api_data ERROR" + e.getMessage());
		}
		
		out.print(json);
	}
	
	

}