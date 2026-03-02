package pe.com.intralot.loto.layer.view.client;

import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.LongValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginLotocardRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.PromoFirstAccount;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.model.PinLoaded;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;

/**
 * <p>
 * NOMBRE: ClientLotocardController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador recargas de saldo
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Límite montos mínimos y maximos de recarga parametrizado
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class ClientLotocardController {

	@Autowired
	private ClientLotocardBo beanClientLotocardBo;
	@Autowired
	private IntralotUtils intralotUtils;
	@Autowired
	private ClientBalanceBo beanClientBalanceBo;
	@Autowired
	private ClientAccountBo beanClientAccountBo;
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	private String message="";	 	
	private Double amount=0.0;
	private Double newAmount=0.0;
	private String messageRecarga="";
	private boolean bonoRecharge;
	private String balanceItem="";
	
	@RequestMapping("/client_lotocard_show_information")	
	public ModelAndView showInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		String context = "CARD-WEB";
		LoggerApi.Log.info("-------------- START client_lotocard_show_information"); 
		try {		
			HttpSession session = request.getSession();	
			LoggerApi.Log.info("cid= "+session.getAttribute("clientId")+" client_lotocard_show_information"); 
			if(session.getAttribute("clientId") != null){
				String idClient=((String)session.getAttribute("clientId")).trim();
				if(!idClient.equals("")){
					String balanceAmount = intralotUtils.formatCurrency(beanClientLotocardBo.findClientById(Integer.valueOf(idClient)).getBalanceAmount());
					objectModelMap.put("balanceAmount", balanceAmount);
					session.setAttribute("saldo", balanceAmount);
					boolean pefeflag = Boolean.valueOf(ConnectionFactory.operationProperty("pagoEfectivoSaleEnabled", "SALE").trim()).booleanValue();
					boolean sfpyflag = Boolean.valueOf(ConnectionFactory.operationProperty("safetyPaySaleEnabled", "SALE").trim()).booleanValue();
					boolean rddgflag = Boolean.valueOf(ConnectionFactory.operationProperty("flagRecargaRedDigital", "SALE").trim()).booleanValue();
					boolean ibnkflag = Boolean.valueOf(ConnectionFactory.operationProperty("flagRecargaInterbank", "SALE").trim()).booleanValue();
					request.setAttribute("pefeFlag", pefeflag);
					request.setAttribute("sfpyFlag", sfpyflag);
					request.setAttribute("rddgflag", rddgflag);
					request.setAttribute("ibnkflag", ibnkflag);
	                JsonObject joDataClient = new JsonObject();
					joDataClient.addProperty("bcpMaxAmount", (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim():"10000");
	                joDataClient.addProperty("bcpMinAmount", (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim():"30");
	                joDataClient.addProperty("pefeMaxAmount", (ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim():"3000");
	                joDataClient.addProperty("pefeMinAmount", (ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim():"40");
	                joDataClient.addProperty("sfpyMaxAmount", (ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim():"3000");
	                joDataClient.addProperty("sfpyMinAmount", (ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim():"40");
	                request.setAttribute("chargeData", joDataClient);
	                if(request.getParameter("operatorId")!=null) session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
	                request.setAttribute("OperatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
	                if(request.getParameter("redirectGame")!=null) session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
	                /*if(request.getParameter("urlRedirect5587")!=null) {
	                	session.setAttribute("urlRedirect5587", String.valueOf(request.getParameter("urlRedirect5587")).toString().trim());
	                	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== client_lotocard_show_information urlRedirect5587="+request.getParameter("urlRedirect5587")+ "clientid= "+session.getAttribute("clientId"));
	                }
	                if(request.getParameter("urlRedirect5588")!=null) session.setAttribute("urlRedirect5588", String.valueOf(request.getParameter("urlRedirect5588")).toString().trim());*/
				}
				//return new ModelAndView("client/interface-lottocard");
				return new ModelAndView("home/interface-home");
			} else return new ModelAndView("redirect:security_login_execute_authentication.html");
		} catch (Exception e) {
			LoggerApi.severe(e);							
			return new ModelAndView("redirect:security_login_execute_authentication.html");
		}finally {
			LoggerApi.Log.info("-------------- END client_lotocard_show_information"); 
		}
		 		
	}
		
	@RequestMapping("/client_lotocard_load_balances")	
	public void loadBalances(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START client_lotocard_load_balances"); 
		HttpSession session = request.getSession(); 
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String alertPrepaidCard = "", clientID = "", balanceAmount = "";
        int indicador = 0;
        ClientProcedureAccountData accountData = new ClientProcedureAccountData();
		try {
			LoggerApi.Log.info("");
			if(StringUtils.contains(message, "OK")) {
				//balanceAmount = intralotUtils.formatCurrency(beanClientLotocardBo.findClientById(Integer.valueOf(clientID)).getBalanceAmount());
				//session.setAttribute("saldo", balanceAmount);
				if(session.getAttribute("clientId")!=null){
					clientID = ((String)session.getAttribute("clientId")).trim();
					if(!clientID.equals("")){
						if (bonoRecharge) {
							accountData = beanClientBalanceBo.findAccountData(Integer.valueOf(clientID));
							accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
							intralotUtils.updateBalanceSession(session,accountData,0,"");
							bonoRecharge = false;
							 if(messageRecarga==null || messageRecarga.trim().isEmpty()) {
								 messageRecarga = "Se ha recargado el saldo con un monto de S/"+amount+". Su nuevo saldo es de S/"+newAmount;
							 }
						} else {
							accountData = beanClientBalanceBo.findAccountData(Integer.valueOf(clientID));
							intralotUtils.updateBalanceSession(session,accountData,0,"");
							messageRecarga = "Se ha recargado el saldo con un monto de S/"+amount+". Su nuevo saldo es de S/"+newAmount;
						}
					}
				}
				indicador=1;
				alertPrepaidCard = messageRecarga;
				messageRecarga = "";
				/*
				if(StringUtils.isNotEmpty(IntralotUtils.redireccionarUltimaJugada(session,"urlDefault"))) {
					String redireccion = IntralotUtils.redireccionarUltimaJugada(session,"urlDefault");
					if(!redireccion.equals("urlDefault")) { response.sendRedirect(redireccion);}
				}
				*/
			} else {
				indicador=2;
				if(StringUtils.contains(message,"CÓDIGO LOTOCARD NO EXISTE")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar no existe";
				} else if(StringUtils.contains(message,"CÓDIGO LOTOCARD EXPIRADO EL")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar ha expirado en la fecha"+message.substring(message.indexOf("CODIGO LOTOCARD EXPIRADO EL "));
				} else if(StringUtils.contains(message,"CÓDIGO LOTOCARD YA UTILIZADO")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar ya ha sido utilizado";
				} else if(StringUtils.contains(message, "CÓDIGO LOTOCARD YA ASIGNADO")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar ya ha sido asiganado a un cliente";
				} else if(StringUtils.contains(message, "CLIENTE NO ESTÁ DEFINIDO")) {
					alertPrepaidCard="Ha expirado su sesion o no se ha podido definir al cliente";
				} else if(StringUtils.contains(message,"CLIENTE NO EXISTE")) {
					alertPrepaidCard="No se ha encontrado el registro del cliente";
				} else if(StringUtils.contains(message,"CRÉDITO INSUFICIENTE")) {
					alertPrepaidCard="No cuenta con saldo disponible para realizar este proceso";
				} else {
					alertPrepaidCard="No se ha logrado realizar la recarga.<br/>"+message;
				}	
			}
			balanceAmount = ((accountData.getBalanceAmount()!=null)?intralotUtils.formatCurrency(accountData.getBalanceAmount()):intralotUtils.formatCurrency(0.00));
			//session.setAttribute("saldo", balanceAmount);
			//intralotUtils.updateBalanceSession(session,accountData,0,"");
			o.addProperty("message", message);
			o.addProperty("alertPrepaidCard", alertPrepaidCard);
			o.addProperty("indicador", indicador);
			o.addProperty("amount", amount);
			o.addProperty("balanceItem", balanceItem);
			o.addProperty("newamount", balanceAmount);
			o.addProperty("bonusAmount", ((accountData.getBonusAmount()!=null && !accountData.getBonusAmount().trim().equals(""))?intralotUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",","."))):intralotUtils.formatCurrency(0.00)));//session.getAttribute("bonoTeApuesto").toString());
			//o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?intralotUtils.formatCurrency(Double.parseDouble(accountData.getOtherAmount().replaceAll(",","."))):intralotUtils.formatCurrency(0.00)));//session.getAttribute("bonoOtro").toString());
			o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?accountData.getOtherQuantity():"0"));
			if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())) {
				o.addProperty("lapolla", Constantes.lapollaGameProviderBalanceUrl+" | ");
				Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== client_lotocard_load_balances lapolla="+Constantes.lapollaGameProviderBalanceUrl+" clientid= "+clientID);
				if(indicador==1) session.removeAttribute("operatorId");
			}
			if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())) {
				ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(Integer.valueOf(clientID), request.getRemoteAddr());
				 if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
					 String authToken = tanTokenGeneration.getTav2Token();					
					  if(session.getAttribute("redirectGame") != null && session.getAttribute("redirectGame").toString().equals("DV"))
		        			o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | "+authToken+"&ref=/virtuals");
		        	  else
		        			o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | "+authToken);
				  }
				 //o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | ");
				 if(indicador==1) {
					 session.removeAttribute("operatorId");
					 session.removeAttribute("redirectGame");
				 }
			}
		} catch (Exception e) {
			LoggerApi.severe(e);							
		} finally {
			LoggerApi.Log.info("/loadBalances: "+o.toString()+" alertPrepaidCard="+alertPrepaidCard+" message="+message+" client_lotocard_load_balances");
			LoggerApi.Log.info("-------------- END client_lotocard_load_balances"); 
			out.print(o);
		}
		 		
	}
	

	@RequestMapping("/client_lotocard_load_balance")	
	public ModelAndView loadBalance(HttpServletRequest request, ModelMap objectModelMap) {

		LoggerApi.Log.info("-------------- START client_lotocard_load_balance"); 
		
		HttpSession session = request.getSession();
		String ip = "", bono = "", wbbono = "";
		try {		
			LoggerApi.Log.info(""); 
			
			if(StringUtils.isNotEmpty((String)session.getAttribute("clientId"))){
				 
				pe.com.intralot.loto.model.Client cliente = new pe.com.intralot.loto.model.Client();
				cliente.setClientId((String)session.getAttribute("clientId"));				 	
				 
				bono = request.getParameter("activ-bono");
				wbbono = request.getParameter("activ-wbbono");
				/*String bonoBienvenida = intralotUtils.verifiedWelcomeBonus(session);
				if (StringUtils.isNotEmpty(bonoBienvenida)) {
                    ip=bonoBienvenida+"|"+request.getRemoteAddr();
                } else {
					ip = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":"")+request.getRemoteAddr();	
                }*/
				ip = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA|":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]+"|":"")))+request.getRemoteAddr();
				PinLoaded pl = new PinLoaded();
				WEBMessage webMessage = new WEBMessage();				 
				webMessage.setClient(cliente);
				webMessage.setIp(ip);
//				if(wbbono!=null&&wbbono.trim().equals("true")) {
//					webMessage.setCarrier("BVBONO");
//				}else {
					webMessage.setCarrier(Constantes.PLATAFORMA);
//				}
								
				LoggerApi.Log.info("/lotocard_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" ip="+ip);
				pl = AccountController.loadPrepaidCardByWeb(webMessage,String.valueOf(request.getParameter("numberCard")).trim());
				message = pl.getMessage();
				 
				LoggerApi.Log.info("/client_lotocard_load_balance messageResult="+message);
				if(StringUtils.contains(message, "OK")) {
					amount = pl.getAmount();
					balanceItem = pl.getBalanceItem();
					pe.com.intralot.loto.model.ClientBalance cb =pl.getBalance();
					newAmount = cb.getNewAmount();
					PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(Integer.parseInt(cliente.getClientId()), Integer.parseInt(cb.getBalanceItem()));
					if (promoFistAccount != null) {
						LoggerApi.Log.info("/getPromotion_message: getPromotion_message-bono="+messageRecarga);
						messageRecarga = promoFistAccount.getPromotion_message();
                        if (messageRecarga.equals("OK")) {
                            LoggerApi.Log.info("/getPromotion_eco: getPromotion_eco="+messageRecarga);
                            messageRecarga = promoFistAccount.getPromotion_eco();
                        }
                        bonoRecharge = ((bono!=null&&bono.trim().equals("true")) || (wbbono!=null&&wbbono.trim().equals("true")) ||(bono!=null&&bono.trim().contains("true-casino")));
					}else {
						bonoRecharge = false;
					}
					
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=ok");
				} else if(StringUtils.contains(message,"CODIGO LOTOCARD NO EXISTE")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else if(StringUtils.contains(message,"CODIGO LOTOCARD EXPIRADO EL")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else if(StringUtils.contains(message,"CODIGO LOTOCARD YA UTILIZADO")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else if(StringUtils.contains(message, "CODIGO LOTOCARD YA ASIGNADO")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else if(StringUtils.contains(message, "CLIENTE NO ESTA DEFINIDO")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else if(StringUtils.contains(message,"CLIENTE NO EXISTE")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else if(StringUtils.contains(message,"CREDITO INSUFICIENTE") || StringUtils.contains(message, "Cuenta Lotocard ha expirado")) {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				} else {
					return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
				}
			}
			return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
		} catch (Exception e) {	
			objectModelMap.put("alertPrepaidCard", "No se ha logrado realizar la recarga");
			objectModelMap.put("indicador", 2);	
			 try {
				 if(session.getAttribute("clientId")!=null){
					 String balanceAmount = intralotUtils.formatCurrency(beanClientLotocardBo.findClientById(Integer.valueOf((String)session.getAttribute("clientId"))).getBalanceAmount());
				objectModelMap.put("balanceAmount", balanceAmount);
				session.setAttribute("saldo", balanceAmount);
				 }
			} catch (Exception e1) {				
				LoggerApi.severe(e);	
			}	
			LoggerApi.severe(e);	
			return new ModelAndView("redirect:client_lotocard_load_balances.html?status=error");
		}finally {
			try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
			LoggerApi.Log.info("-------------- END client_lotocard_load_balance"); 
		}
		
		
	}
	
	@RequestMapping("/find_lotocard")	
	public void findLotocard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START findLotocard"); 
		String pin = "";
    	PinPrinted pinPrinted = null;
    	PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
    	if (request.getParameter("pin-number") != null) {
    		pin = request.getParameter("pin-number");
    		try {
    			pinPrinted = beanClientLotocardBo.findLotocard(pin);
			} catch (Exception e) {
				LoggerApi.severe(e);
			}
    	}
    	if(pinPrinted==null) {
    		o.addProperty("message", "No Existe");
    	}else {
    		o.addProperty("message", "Existe");
    		o.addProperty("amount",pinPrinted.getPinAmount());
    	}
    	LoggerApi.Log.info("-------------- END findLotocard"); 
    	out.print(o);
    	
	}	
	
	@RequestMapping("/client_lotocard_load_balance_rt")	
	public ModelAndView loadBalanceRT(HttpServletRequest request, ModelMap objectModelMap) {

		LoggerApi.Log.info("-------------- START client_lotocard_load_balance_rt"); 
		
//		HttpSession session = request.getSession();
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=SecurityUtils.getClientIp(request);
        ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		String bono = "", wbbono = "";
		String idClient = "";
        int idClientInt = 0;
		try {		
			LoggerApi.Log.info(""); 
			// Validación de token
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient = tokenValidation.getClientId();
	    		idClientInt = Integer.parseInt(idClient);
//			if(StringUtils.isNotEmpty((String)session.getAttribute("clientId"))){
				 
				pe.com.intralot.loto.model.Client cliente = new pe.com.intralot.loto.model.Client();
//				cliente.setClientId((String)session.getAttribute("clientId"));
				cliente.setClientId(idClient);	
				 
				//validar activación de bono
	            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
	        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
	        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";		        	
	            JsonObject jresult=ClientBalanceController.backCodePromotionalValidation(rechargetoken, ip, request.getRemoteAddr(), 
	            		codePromotional, channel, amount, lotocard, beanSecurityLoginBo, beanClientLotocardBo, beanClientBalanceBo);
	            bono=jresult.get("bono").getAsString();
	            wbbono=jresult.get("wbbono").getAsString();
				
				ip = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA|":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]+"|":"")))+request.getRemoteAddr();
				PinLoaded pl = new PinLoaded();
				WEBMessage webMessage = new WEBMessage();				 
				webMessage.setClient(cliente);
				webMessage.setIp(ip);
//				if(wbbono!=null&&wbbono.trim().equals("true")) {
//					webMessage.setCarrier("BVBONO");
//				}else {
					webMessage.setCarrier(Constantes.PLATAFORMA);
//				}
								
				LoggerApi.Log.info("/lotocard_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" ip="+ip);
				String numberCard=String.valueOf(request.getParameter("numberCard")).trim();
				//Validar código ingresado
				Boolean veryfyAmount= LongValidator.getInstance().isValid(numberCard);
				if(!veryfyAmount) {	
					LoggerApi.Log.info("/client_lotocard_load_balance_rt CODIGO LOTOCARD NO EXISTE");
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				}
				String pin=request.getParameter("numberCard").trim();
				pl = AccountController.loadPrepaidCardByWeb(webMessage,String.valueOf(pin));
				message = pl.getMessage();
				 
				LoggerApi.Log.info("/client_lotocard_load_balance_rt messageResult="+message);
				if(StringUtils.contains(message, "OK")) {
					//Registrar recarga, identificar web de recarga
					String platform = Constantes.PLATAFORM;
					String transactionId = StringLib.encodeLabel(pin);
					String operatorId=tokenValidation.getOperatorId();
					ClientProcedureOriginLotocardRecharge originLotocardRecharge = beanClientAccountBo.setOriginLotocardRecharge(transactionId, platform, operatorId);
					if(!originLotocardRecharge.getStatus().equals("OK")) {
						LoggerApi.Log.info("-------------- client_lotocard_load_balance_rt"+" originLotocardRecharge.getMessage=" +originLotocardRecharge.getMessage());
					}
					
					amount = pl.getAmount();
					balanceItem = pl.getBalanceItem();
					pe.com.intralot.loto.model.ClientBalance cb =pl.getBalance();
					newAmount = cb.getNewAmount();
					PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(Integer.parseInt(cliente.getClientId()), Integer.parseInt(cb.getBalanceItem()));
					if (promoFistAccount != null) {
						LoggerApi.Log.info("/getPromotion_message: getPromotion_message-bono="+messageRecarga);
						messageRecarga = promoFistAccount.getPromotion_message();
                        if (messageRecarga.equals("OK")) {
                            LoggerApi.Log.info("/getPromotion_eco: getPromotion_eco="+messageRecarga);
                            messageRecarga = promoFistAccount.getPromotion_eco();
                        }
                        bonoRecharge = ((bono!=null&&bono.trim().equals("true")) || (wbbono!=null&&wbbono.trim().equals("true")) ||(bono!=null&&bono.trim().contains("true-casino")));
					}else {
						bonoRecharge = false;
					}
					
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=ok");
				} else if(StringUtils.contains(message,"CODIGO LOTOCARD NO EXISTE")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else if(StringUtils.contains(message,"CODIGO LOTOCARD EXPIRADO EL")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else if(StringUtils.contains(message,"CODIGO LOTOCARD YA UTILIZADO")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else if(StringUtils.contains(message, "CODIGO LOTOCARD YA ASIGNADO")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else if(StringUtils.contains(message, "CLIENTE NO ESTA DEFINIDO")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else if(StringUtils.contains(message,"CLIENTE NO EXISTE")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else if(StringUtils.contains(message,"CREDITO INSUFICIENTE") || StringUtils.contains(message, "Cuenta Lotocard ha expirado")) {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				} else {
					return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
				}
			}else {
				message=tokenValidation.getStatus();
			}
			return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
		} catch (Exception e) {	
			objectModelMap.put("alertPrepaidCard", "No se ha logrado realizar la recarga");
			objectModelMap.put("indicador", 2);	
			 try {
//				 if(session.getAttribute("clientId")!=null){
				 if(idClient!=null){
					 String balanceAmount = intralotUtils.formatCurrency(beanClientLotocardBo.findClientById(idClientInt).getBalanceAmount());
				objectModelMap.put("balanceAmount", balanceAmount);
//				session.setAttribute("saldo", balanceAmount);
				 }
			} catch (Exception e1) {				
				LoggerApi.severe(e);	
			}	
			LoggerApi.severe(e);	
			return new ModelAndView("redirect:client_lotocard_load_balances_rt.html?status=error");
		}finally {
//			try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
			LoggerApi.Log.info("-------------- END client_lotocard_load_balance_rt"); 
		}
		
		
	}
	
	@RequestMapping("/client_lotocard_load_balances_rt")	
	public void loadBalancesRT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START client_lotocard_load_balances_rt"); 
//		HttpSession session = request.getSession(); 
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=SecurityUtils.getClientIp(request);
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		int idClientInt=0;
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        String alertPrepaidCard = "", clientID = "", balanceAmount = "";
        int indicador = 0;
        ClientProcedureAccountData accountData = new ClientProcedureAccountData();
		try {
			LoggerApi.Log.info("");
			if(StringUtils.contains(message, "OK")) {
				//balanceAmount = intralotUtils.formatCurrency(beanClientLotocardBo.findClientById(Integer.valueOf(clientID)).getBalanceAmount());
				//session.setAttribute("saldo", balanceAmount);
				tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
				if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
					clientID = tokenValidation.getClientId();
		    		idClientInt = Integer.parseInt(clientID);
//				if(session.getAttribute("clientId")!=null){
//					clientID = ((String)session.getAttribute("clientId")).trim();
					if(!clientID.equals("")){
						if (bonoRecharge) {
							accountData = beanClientBalanceBo.findAccountData(Integer.valueOf(clientID));
							accountData = intralotUtils.verifiedTestUsersWelcomeBonusRT(accountData,tokenValidation);
//							intralotUtils.updateBalanceSession(session,accountData,0,"");
							bonoRecharge = false;
							 if(messageRecarga==null || messageRecarga.trim().isEmpty()) {
								 messageRecarga = "Se ha recargado el saldo con un monto de S/"+amount+". Su nuevo saldo es de S/"+newAmount;
							 }
						} else {
							accountData = beanClientBalanceBo.findAccountData(Integer.valueOf(clientID));
//							intralotUtils.updateBalanceSession(session,accountData,0,"");
							messageRecarga = "Se ha recargado el saldo con un monto de S/"+amount+". Su nuevo saldo es de S/"+newAmount;
						}
					}
				}
				indicador=1;
				alertPrepaidCard = messageRecarga;
				messageRecarga = "";
				/*
				if(StringUtils.isNotEmpty(IntralotUtils.redireccionarUltimaJugada(session,"urlDefault"))) {
					String redireccion = IntralotUtils.redireccionarUltimaJugada(session,"urlDefault");
					if(!redireccion.equals("urlDefault")) { response.sendRedirect(redireccion);}
				}
				*/
			} else {
				indicador=2;
				if(StringUtils.contains(message,"CÓDIGO LOTOCARD NO EXISTE")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar no existe";
				} else if(StringUtils.contains(message,"CÓDIGO LOTOCARD EXPIRADO EL")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar ha expirado en la fecha"+message.substring(message.indexOf("CODIGO LOTOCARD EXPIRADO EL "));
				} else if(StringUtils.contains(message,"CÓDIGO LOTOCARD YA UTILIZADO")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar ya ha sido utilizado";
				} else if(StringUtils.contains(message, "CÓDIGO LOTOCARD YA ASIGNADO")) {
					alertPrepaidCard="El c&oacute;digo Lotocard que intenta ingresar ya ha sido asiganado a un cliente";
				} else if(StringUtils.contains(message, "CLIENTE NO ESTÁ DEFINIDO")) {
					alertPrepaidCard="Ha expirado su sesion o no se ha podido definir al cliente";
				} else if(StringUtils.contains(message,"CLIENTE NO EXISTE")) {
					alertPrepaidCard="No se ha encontrado el registro del cliente";
				} else if(StringUtils.contains(message,"CRÉDITO INSUFICIENTE")) {
					alertPrepaidCard="No cuenta con saldo disponible para realizar este proceso";
				} else if(StringUtils.contains(message,"TIMEOUTTR")) {
					alertPrepaidCard=message;}
				else {
					alertPrepaidCard="No se ha logrado realizar la recarga.<br/>"+message;
				}	
			}
			balanceAmount = ((accountData.getBalanceAmount()!=null)?intralotUtils.formatCurrency(accountData.getBalanceAmount()):intralotUtils.formatCurrency(0.00));
			//session.setAttribute("saldo", balanceAmount);
			//intralotUtils.updateBalanceSession(session,accountData,0,"");
			o.addProperty("message", message);
			o.addProperty("alertPrepaidCard", alertPrepaidCard);
			o.addProperty("indicador", indicador);
			o.addProperty("amount", amount);
			o.addProperty("balanceItem", balanceItem);
			o.addProperty("newamount", balanceAmount);
			o.addProperty("bonusAmount", ((accountData.getBonusAmount()!=null && !accountData.getBonusAmount().trim().equals(""))?intralotUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",","."))):intralotUtils.formatCurrency(0.00)));//session.getAttribute("bonoTeApuesto").toString());
			//o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?intralotUtils.formatCurrency(Double.parseDouble(accountData.getOtherAmount().replaceAll(",","."))):intralotUtils.formatCurrency(0.00)));//session.getAttribute("bonoOtro").toString());
			o.addProperty("bonusOther", ((accountData.getOtherAmount()!=null && !accountData.getOtherAmount().trim().equals(""))?accountData.getOtherQuantity():"0"));
//			if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())) {
//				o.addProperty("lapolla", Constantes.lapollaGameProviderBalanceUrl+" | ");
//				Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== client_lotocard_load_balances lapolla="+Constantes.lapollaGameProviderBalanceUrl+" clientid= "+clientID);
//				if(indicador==1) session.removeAttribute("operatorId");
//			}
//			if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())) {
//				ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(Integer.valueOf(clientID), request.getRemoteAddr());
//				 if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
//					 String authToken = tanTokenGeneration.getTav2Token();					
//					  if(session.getAttribute("redirectGame") != null && session.getAttribute("redirectGame").toString().equals("DV"))
//		        			o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | "+authToken+"&ref=/virtuals");
//		        	  else
//		        			o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | "+authToken);
//				  }
//				 //o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | ");
//				 if(indicador==1) {
//					 session.removeAttribute("operatorId");
//					 session.removeAttribute("redirectGame");
//				 }
//			}
		} catch (Exception e) {
			LoggerApi.severe(e);							
		} finally {
			LoggerApi.Log.info("/loadBalances: "+o.toString()+" alertPrepaidCard="+alertPrepaidCard+" message="+message+" client_lotocard_load_balances_rt");
			LoggerApi.Log.info("-------------- END client_lotocard_load_balances_rt"); 
			out.print(o);
		}
		 		
	}
	
}



