package pe.com.intralot.loto.layer.view.payment;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginBcpRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.PromoFirstAccount;
import pe.com.intralot.loto.layer.view.client.ClientBalanceController;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.client.model.KeyPay;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;

/**
 * <p>
 * NOMBRE: BcpPage.java
 * <br></p>
 * <p>
 * FUNCION: Controlador recargas BCP 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Depuración de comentarios y validación de variables en sesión
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class BcpPage {
    
	@Autowired
	ClientAccountBo beanClientAccountBo;
	@Autowired
	private ClientBalanceBo beanClientBalanceBo;
	@Autowired
	IntralotUtils intralotUtils;
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	@Autowired
	private ClientLotocardBo beanClientLotocardBo;
	
	@RequestMapping(value = "/check-transaction-bcp")
    public void getCheckTransactionBCP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String data = "";
		String outData = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		PrintWriter out = response.getWriter();
		try {
			String idClient = session.getAttribute("clientId").toString().trim();
			List<KeyPay> lista = SalesDispatcher.getCheckTransaction(idClient);
	        for (KeyPay kp : lista) {
	            if (kp.getShortId() != null && !kp.getShortId().trim().equals(""))
	                data += kp.getShortId() + "|";
	            else
	                data += " |";
	            if (kp.getAmount() != null)
	                data += intralotUtils.formatCurrency2(kp.getAmount()) + "|";
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
	        outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ");
	        out.print(outData);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
        LoggerApi.Log.info(" OutData=" + outData);
	}
	
	@RequestMapping(value = "/verifica-codigo-bcp")
    public void verifyKeyPayBCP(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoggerApi.Log.info("-------------- START verifica-codigo-bcp");
        String context = "CARD-WEB";
        String idSession = "";
        String idClient = "";
        int idClientInt = 0;
        String ipClient = "";
        HttpSession session = request.getSession();
        String data = "";
        int result = 0;
        String resulttrx = "";
        String trx = "";
        String mssg = "", bono = "", wbbono = "", bonokey = "", outData = "",promotion_key="";
        double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        PrintWriter out = null;
        out = response.getWriter();
        try {
        	if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    		idClientInt = Integer.parseInt(idClient);
	    	}
        	if(!idClient.equals("")) {
	            ipClient = request.getRemoteAddr();
//	            if(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)
//	            	maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim());
//	            if(ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)
//	            	minAmount = Double.parseDouble(ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim());
	            ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
	            maxAmount = accountDataPart.getAmtMaxRechargeBcp();
	            minAmount = accountDataPart.getAmtMinRechargeBcp();
	            
	            if(request.getParameter("bcp-amount") != null && !request.getParameter("bcp-amount").equals("")) {
	            	tamount = request.getParameter("bcp-amount").trim();
	                amount = Double.parseDouble(tamount);
	            }
	            if (request.getParameter("bcp-transact") != null)
	                trx = request.getParameter("bcp-transact").trim();
	            bono = request.getParameter("activ-bono");
	            wbbono = request.getParameter("activ-wbbono");
	            promotion_key = request.getParameter("codePromotional");

	            LoggerApi.Log.info("/verifica-codigo-bcp: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey + " promotion_key=" +promotion_key);
	            LoggerApi.Log.info("IdClient=" + idClient + " IpClient=" + ipClient + " Amount=" + amount + " MinAmount=" + minAmount + " MaxAmount=" + maxAmount + " Transaccion=" + trx);
                if (amount >= minAmount) {
                    if (amount > maxAmount)
                        mssg = "Debes ingresar un monto de carga no mayor de " + intralotUtils.formatCurrency2(maxAmount) + ".";
                    else {
                        resulttrx = SalesDispatcher.getDefineTransaction(idClient, idSession, amount, promotion_key);
                        if (resulttrx.equals(""))
                            mssg = "No se ha logrado generar el c&oacute;digo para realizar el pago con su cuenta BCP. ";
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
			                    data += intralotUtils.formatCurrency2(kp.getAmount()) + "|";
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
			            
			            if(idClientInt>0 ) {
			            	Client client = beanClientAccountBo.findClientById(idClientInt);
			            	
			            	if(client != null) {
			            		outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "||| |||" + intralotUtils.formatCurrency(client.getBalanceAmount());
			            		
			            		if (bono!=null&&bono.trim().equals("true")) {
			            			outData += "|||"+"TARECARGATE";
			            			ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(client.getClientId());
			            			accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
			            			intralotUtils.updateBalanceSession(session,accountData,0,"");
			            			outData += "|||"+session.getAttribute("bonoTeApuesto");
			            			outData += "|||"+session.getAttribute("bonoOtro");
			            		}
				                else 
				                	if (bono!=null&&bono.trim().contains("true-casino")) {
				                		outData += "|||"+bono.split("\\|")[1];
				            			ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(client.getClientId());
				            			accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
				            			intralotUtils.updateBalanceSession(session,accountData,0,"");
				            			outData += "|||"+session.getAttribute("bonoTeApuesto");
				            			outData += "|||"+session.getAttribute("bonoOtro");
				                	}else
				                		outData += "|||";
			                }
			            } else {
			                mssg = "No se ha completado la operaci&oacute;n.";
			                outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||-1||| ";
			            }
	                }
	        	} else {
	        		mssg = "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".";
	        		outData = " |||" + mssg + "|||-1||| ";
	        	}
        	}
            out.print(outData);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
            LoggerApi.Log.info("Resultado=" + result + " OutData=" + outData);
        }
        LoggerApi.Log.info("-------------- END verifica-codigo-bcp");
    }

    @RequestMapping(value = "/anular")
    public void expiryTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pin = request.getParameter("pin");
        int status = SalesDispatcher.getExpiryTransaction(pin);
        JsonObject o = new JsonObject();
        if (status == -1)
            o.addProperty("menssage", "No se pudo anular la transacci&oacute;n");
        else
            o.addProperty("message", "Anulado!");
    }

    @RequestMapping(value = "/verificar")
    public void verifyTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("-------------- START verificar");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        String idClient = (session.getAttribute("clientId") != null)?session.getAttribute("clientId").toString():"";
        String ipClient = request.getRemoteAddr();
        int idClientInt = (idClient != null)?Integer.parseInt(idClient):0;
        String alertmsg = "";
        String promotionMessage = "";
        double amount = ((request.getParameter("amount")!=null && !request.getParameter("amount").isEmpty())?Double.parseDouble(request.getParameter("amount").toString().replaceAll("S/ ", "").trim()):0);
        //int result = SalesDispatcher.getActiveTransaction(idClient, ipClient);
        String pin = request.getParameter("pin");
        int result = SalesDispatcher.getVerifyTransaction(pin, idClient);
        //Client client = beanClientAccountBo.findClientById(idClientInt);
        JsonObject o = new JsonObject();
        //if (result == 1) {
        if (result >= 1) {
        	ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(idClientInt);//client.getClientId());
        	accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
			intralotUtils.updateBalanceSession(session,accountData,0,"");
			PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(Integer.parseInt(idClient), result);
            if (promoFistAccount != null) {
            	LoggerApi.Log.info(" Mostrar eco message aplicando codigo promocional   idClient=" + idClient + " amount="+amount);
                promotionMessage = promoFistAccount.getPromotion_message();
                if (promotionMessage.equals("OK")) {
                	promotionMessage = promoFistAccount.getPromotion_eco();
                }
            }
            if(!promotionMessage.trim().equals("") && accountData.getBalanceAmount()>amount) {//client.getBalanceAmount()>amount) {
                if (promotionMessage.indexOf("insuficiente") > -1 ) {
                    alertmsg = promotionMessage + "<br/><br/>La recarga ha sido abonada a su saldo principal.<br/><br/>Monto cargado: S/ " + (accountData.getBalanceAmount()-amount);//client.getBalanceAmount()-amount);
                } else {
                    alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/><br/>Monto cargado: S/ " + (accountData.getBalanceAmount()-amount) + "<br/>" + promotionMessage;                               
                }
            } else {
            	 if(promotionMessage.contains("100%")) {
        	    	 alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/>"+ promotionMessage;
        	    }else {
        	    	alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/><br/>Monto cargado: S/ " + (accountData.getBalanceAmount()-amount) + "<br/>Tu saldo disponible es: S/ " + accountData.getBalanceAmount() + "<br/>" + promotionMessage;
        	    }
            }
            o.addProperty("state", "OK");
            o.addProperty("message", alertmsg);//"Se ha recargado saldo desde tu cuenta BCP. Tu nuevo saldo es S/." + client.getBalanceAmount());
            o.addProperty("amount", intralotUtils.formatCurrency(accountData.getBalanceAmount()));
            o.addProperty("bonusAmount", session.getAttribute("bonoTeApuesto").toString());
            o.addProperty("bonusOther", session.getAttribute("bonoOtro").toString());
            session.setAttribute("saldo", intralotUtils.formatCurrency(accountData.getBalanceAmount()));
            
            //redirecciona en caso tenga una boleta en session
            String redireccion = IntralotUtils.redireccionarUltimaJugada(session,"client_lotocard_load_balances.html?status=ok");
            o.addProperty("redireccion", redireccion);
        } else {
            o.addProperty("state", "KO");
            o.addProperty("message", "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BCP");
        }
        LoggerApi.Log.info("-------------- END verificar");
        out.print(o);
    }
    
    @RequestMapping(value = "/check-transaction-bcp-rt")
    public void getCheckTransactionBCPRT(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		HttpSession session = request.getSession();
		String data = "";
		String outData = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		PrintWriter out = response.getWriter();
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=SecurityUtils.getClientIp(request);
		try {
			//Validar token
			String idClient="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient=tokenValidation.getClientId();
			
	//			String idClient = session.getAttribute("clientId").toString().trim();
				List<KeyPay> lista = SalesDispatcher.getCheckTransaction(idClient);
		        for (KeyPay kp : lista) {
		            if (kp.getShortId() != null && !kp.getShortId().trim().equals(""))
		                data += kp.getShortId() + "|";
		            else
		                data += " |";
		            if (kp.getAmount() != null)
		                data += intralotUtils.formatCurrency2(kp.getAmount()) + "|";
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
			}else {
				String state=tokenValidation.getStatus();
				if(state.equals("TIMEOUTTR")) {
					data=state+" |";
				}
			}
	        outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ");
	        out.print(outData);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
        LoggerApi.Log.info(" OutData=" + outData);
	}
    
    @RequestMapping(value = "/verifica-codigo-bcp-rt")
    public void verifyKeyPayBCPRT(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoggerApi.Log.info("-------------- START verifica-codigo-bcp-rt");
        String context = "CARD-WEB";
        String idSession = "";
        String idClient = "";
        int idClientInt = 0;
        String ipClient = "";
//        HttpSession session = request.getSession();
        String data = "";
        int result = 0;
        String resulttrx = "";
        String trx = "";
        String mssg = "", bono = "", wbbono = "", bonokey = "", outData = "";
        double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        PrintWriter out = null;
        out = response.getWriter();
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=SecurityUtils.getClientIp(request);
        try {
        	//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient=tokenValidation.getClientId();
				idClientInt = Integer.parseInt(idClient);
			}else {
				mssg = tokenValidation.getStatus();
        		outData = " |||" + mssg + "|||-1||| ";
        		out.print(outData);
        		return;
			}
//        	if(session.getAttribute("clientId") != null) {
//	    		idClient = session.getAttribute("clientId").toString().trim();
//	    		idClientInt = Integer.parseInt(idClient);
//	    	}
        	if(!idClient.equals("")) {
	            ipClient = request.getRemoteAddr();
//	            if(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)
//	            	maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim());
//	            if(ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)
//	            	minAmount = Double.parseDouble(ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim());
//	            ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart");
	            ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(Integer.parseInt(idClient));
	            maxAmount = accountDataPart.getAmtMaxRechargeBcp();
	            minAmount = accountDataPart.getAmtMinRechargeBcp();
	            
	            if(request.getParameter("bcp-amount") != null && !request.getParameter("bcp-amount").equals("")) {
	            	tamount = request.getParameter("bcp-amount").trim();
	                amount = Double.parseDouble(tamount);
	            }
	            if (request.getParameter("bcp-transact") != null)
	                trx = request.getParameter("bcp-transact").trim();
	          //validar activación de bono
	            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
	        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
	        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";		        	
	            JsonObject jresult=ClientBalanceController.backCodePromotionalValidation(rechargetoken, ip, request.getRemoteAddr(), 
	            		codePromotional, channel, amount, lotocard, beanSecurityLoginBo, beanClientLotocardBo, beanClientBalanceBo);
	            bonokey = codePromotional;
	            LoggerApi.Log.info("/verifica-codigo-bcp: codePromotional="+codePromotional);
	            LoggerApi.Log.info("IdClient=" + idClient + " IpClient=" + ipClient + " Amount=" + amount + " MinAmount=" + minAmount + " MaxAmount=" + maxAmount + " Transaccion=" + trx);
                if (amount >= minAmount) {
                    if (amount > maxAmount)
                        mssg = "Debes ingresar un monto de carga no mayor de " + intralotUtils.formatCurrency2(maxAmount) + ".";
                    else {
                        resulttrx = SalesDispatcher.getDefineTransaction(idClient, idSession, amount, bonokey);
                        if (resulttrx.equals(""))
                            mssg = "No se ha logrado generar el c&oacute;digo para realizar el pago con su cuenta BCP. ";
			            if (!trx.equals("")) {
			                result = SalesDispatcher.getExpiryTransaction(trx);
			                if (result == -1)
			                    mssg = "No se ha logrado anular el pago pendiente";
			            }
			            //Registrar recarga, identificar plataforma y web de recarga
						String platform=Constantes.PLATAFORM;
						String operatorId=tokenValidation.getOperatorId();
						ClientProcedureOriginBcpRecharge originBcpRecharge = beanClientAccountBo.setOriginBcpRecharge(resulttrx, platform, operatorId);
						if(!originBcpRecharge.getStatus().equals("OK")) {
							LoggerApi.Log.info("-------------- verifyKeyPayBCPRT"+" originBcpRecharge.getMessage=" +originBcpRecharge.getMessage());
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
			                    data += intralotUtils.formatCurrency2(kp.getAmount()) + "|";
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
			            
			            if(idClientInt>0 ) {
			            	Client client = beanClientAccountBo.findClientById(idClientInt);
			            	
			            	if(client != null) {
			            		outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "||| |||" + intralotUtils.formatCurrency(client.getBalanceAmount());
			            		
			            		if (bono!=null&&bono.trim().equals("true")) {
			            			outData += "|||"+"TARECARGATE";
			            			ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(client.getClientId());
			            			accountData = intralotUtils.verifiedTestUsersWelcomeBonusRT(accountData,tokenValidation);
//			            			intralotUtils.updateBalanceSession(session,accountData,0,"");
//			            			p_session.setAttribute("bonoTeApuesto", formatCurrency(Double.parseDouble(p_accountData.getBonusAmount().replaceAll(",","."))));
			            			
			            			try {
			            				outData += "|||"+intralotUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",",".")));
			            	    	} catch (Exception e) {
			            	    		outData += "|||"+intralotUtils.formatCurrency(0.00);
			            			}
			            			try {
			            				outData += "|||"+accountData.getOtherQuantity();
			            	    	} catch (Exception e) {
			            	    		outData += "|||"+0;
			            			}
//			            			outData += "|||"+session.getAttribute("bonoTeApuesto");
			            			
//			            			outData += "|||"+session.getAttribute("bonoOtro");
			            		}
				                else 
				                	if (bono!=null&&bono.trim().contains("true-casino")) {
				                		outData += "|||"+bono.split("\\|")[1];
				            			ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(client.getClientId());
//				            			accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
				            			accountData = intralotUtils.verifiedTestUsersWelcomeBonusRT(accountData,tokenValidation);
//				            			intralotUtils.updateBalanceSession(session,accountData,0,"");
				            			try {
				            				outData += "|||"+intralotUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",",".")));
				            	    	} catch (Exception e) {
				            	    		outData += "|||"+intralotUtils.formatCurrency(0.00);
				            			}
				            			try {
				            				outData += "|||"+accountData.getOtherQuantity();
				            	    	} catch (Exception e) {
				            	    		outData += "|||"+0;
				            			}
				                	}else
				                		outData += "|||";
			                }
			            } else {
			                mssg = "No se ha completado la operaci&oacute;n.";
			                outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||-1||| ";
			            }
	                }
	        	} else {
	        		mssg = "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".";
	        		outData = " |||" + mssg + "|||-1||| ";
	        	}
        	}
            out.print(outData);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
//        	try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
            LoggerApi.Log.info("Resultado=" + result + " OutData=" + outData);
        }
        LoggerApi.Log.info("-------------- END verifica-codigo-bcp-rt");
    }
    
    @RequestMapping(value = "/verificar-rt")
    public void verifyTransactionRT(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("-------------- START verificar-rt");
    	DecimalFormat df = new DecimalFormat("0.00");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
//        HttpSession session = request.getSession();
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=SecurityUtils.getClientIp(request);
        JsonObject o = new JsonObject();
    	//Validar token
    	String idClient = "";
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
		if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
			idClient=tokenValidation.getClientId();
		}else {
			String state=tokenValidation.getStatus();
			o.addProperty("state", state);
            o.addProperty("message", tokenValidation.getMessage());
            out.print(o);
            return;
		}
        
        String ipClient = request.getRemoteAddr();
        int idClientInt = (idClient != null)?Integer.parseInt(idClient):0;
        String alertmsg = "";
        String promotionMessage = "";
        String smount=request.getParameter("amount");
        
        double amount = (smount != null && !smount.isEmpty())
        	    ? Double.parseDouble(smount.replaceAll("S/ ", "").trim())
        	    : 0;
        	    
        //int result = SalesDispatcher.getActiveTransaction(idClient, ipClient);
        String pin = request.getParameter("pin");
        int result = SalesDispatcher.getVerifyTransaction(pin, idClient);
        //Client client = beanClientAccountBo.findClientById(idClientInt);
        
        if (result >= 1) {
        	ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(idClientInt);//client.getClientId());
        	accountData = intralotUtils.verifiedTestUsersWelcomeBonusRT(accountData,tokenValidation);

			PromoFirstAccount promoFistAccount = beanClientAccountBo.promotionFirstAccount(Integer.parseInt(idClient), result);
            if (promoFistAccount != null) {
            	LoggerApi.Log.info(" Mostrar eco message aplicando codigo promocional   idClient=" + idClient + " amount="+amount);
                promotionMessage = promoFistAccount.getPromotion_message();
                if (promotionMessage.equals("OK")) {
                	promotionMessage = promoFistAccount.getPromotion_eco();
                }
            }
            if(!promotionMessage.trim().equals("") && accountData.getBalanceAmount()>amount) {//client.getBalanceAmount()>amount) {
                if (promotionMessage.indexOf("insuficiente") > -1 ) {
                    alertmsg = promotionMessage + "<br/><br/>La recarga ha sido abonada a su saldo principal.<br/><br/>Monto cargado: S/ " + df.format(accountData.getBalanceAmount()-amount);//client.getBalanceAmount()-amount);
                } else {
                    alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/><br/>Monto cargado: S/ " + df.format(accountData.getBalanceAmount()-amount) + "<br/>" + promotionMessage;                               
                }
            } else {
            	 if(promotionMessage.contains("100%")) {
        	    	 alertmsg = "Se ha realizado una recarga con éxito a su saldo.<br/>"+ promotionMessage;
        	    }else {
        	    	alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/><br/>Monto cargado: S/ " + df.format(accountData.getBalanceAmount()-amount) + "<br/>Tu saldo disponible es: S/ " + accountData.getBalanceAmount() + "<br/>" + promotionMessage;
        	    }
            }
            o.addProperty("state", "OK");
            o.addProperty("message", alertmsg);//"Se ha recargado saldo desde tu cuenta BCP. Tu nuevo saldo es S/." + client.getBalanceAmount());
            o.addProperty("amount", intralotUtils.formatCurrency(accountData.getBalanceAmount()));
            String bonusAmount="";
            try {
            	bonusAmount=intralotUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",",".")));
//        		p_session.setAttribute("bonoTeApuesto", formatCurrency(Double.parseDouble(p_accountData.getBonusAmount().replaceAll(",","."))));
        	} catch (Exception e) {
        		bonusAmount= intralotUtils.formatCurrency(0.00);
//        		p_session.setAttribute("bonoTeApuesto", formatCurrency(0.00));
    		}
            o.addProperty("bonusAmount", bonusAmount);
            String bonusOther="";
            try {
            	bonusOther = accountData.getOtherQuantity();
        	} catch (Exception e) {
        		bonusOther= "0";
    		}
            o.addProperty("bonusOther", bonusOther);
//            session.setAttribute("saldo", intralotUtils.formatCurrency(accountData.getBalanceAmount()));
            
            //redirecciona en caso tenga una boleta en session
//            String redireccion = IntralotUtils.redireccionarUltimaJugada(session,"client_lotocard_load_balances.html?status=ok");
//            o.addProperty("redireccion", redireccion);
        } else {
            o.addProperty("state", "KO");
            o.addProperty("message", "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BCP");
        }
        LoggerApi.Log.info("-------------- END verificar-rt");
        out.print(o);
    }
}