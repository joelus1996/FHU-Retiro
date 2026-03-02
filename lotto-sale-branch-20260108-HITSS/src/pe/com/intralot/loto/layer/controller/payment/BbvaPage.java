package pe.com.intralot.loto.layer.controller.payment;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.ClientBalanceController;
import pe.com.intralot.loto.layer.model.domain.BbvaProcedureCheckTransaction;
import pe.com.intralot.loto.layer.model.domain.BbvaProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.domain.PromoFirstAccount;
import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;

/**
 * <p>
 * NOMBRE: BbvaPage.java
 * <br></p>
 * <p>
 * FUNCION: Controlador recargas BBVA 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   C_DPARRENO  	12/10/2020   First comment
 * </pre>
 * <br></p>
 */

@Controller
public class BbvaPage {
    
    @Autowired
    private ClientSaleBo clientSaleBo;
    
    @Autowired
    private BalanceSaleBo balanceSaleBo;
    	
	@RequestMapping(value = "/genera-codigo-bbva-rt")
    public void defineTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LoggerApi.Log.info("-------------- START genera-codigo-bbva-rt"); 
		
        String idClient = "";
        int idClientInt = 0;
        String ipClient = "";
        String data = "";
        String resulttrx = "";
        String mssg = "", bono = "", wbbono = "", bonokey = "", outData = "";
        double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        PrintWriter out = null;
        out = response.getWriter();
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=ClientUtils.getClientIp(request);
        
        try {
        	//Validar token
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient=tokenValidation.getClientId();
				idClientInt = Integer.parseInt(idClient);
			}else {
				mssg = tokenValidation.getStatus();
        		outData = " |||" + mssg + "|||-1||| ";
        		out.print(outData);
        		return;
			}
        	if(!idClient.equals("")) {
        		List<BbvaProcedureCheckTransaction> listaActual = balanceSaleBo.getCheckTransactionBBVA(idClient);
        		String maximoCodigosBBVA = ((ConnectionFactory.operationProperty("maximoCodigosBBVA", Constants.contextSale) != null)
						? ConnectionFactory.operationProperty("maximoCodigosBBVA", Constants.contextSale).trim(): "3");
        		if(listaActual==null || listaActual.size()<Integer.parseInt(maximoCodigosBBVA)) {
		            ipClient = request.getRemoteAddr();
		            ClientProcedureAccountDataPart accountDataPart = clientSaleBo.findAccountDataPart(Integer.parseInt(idClient));
		            String idSession = accountDataPart.getSessionId().toString();
		            maxAmount = accountDataPart.getAmtMaxRechargeBbva();
		            minAmount = accountDataPart.getAmtMinRechargeBbva();
		            
		            if(request.getParameter("bbva-amount") != null && !request.getParameter("bbva-amount").equals("")) {
		            	tamount = request.getParameter("bbva-amount").trim();	            	
		            	Boolean veryfyAmount= DoubleValidator.getInstance().isValid(tamount);
		  			  	if(!veryfyAmount) {	  					
		  					mssg = "El monto ingresado es incorrecto";
		  	        		outData = " |||" + mssg + "|||-1||| ";
		  	        		out.print(outData);
		  	        		return;
		  				}
		                amount = Double.parseDouble(tamount);
		            }
		            
		            //validar activación de bono
		            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
		        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
		        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";		        	

		            LoggerApi.Log.info("/verifica-codigo-bbva: channel="+channel+" lotocard="+lotocard+" codePromotional="+codePromotional);
		            LoggerApi.Log.info("IdClient=" + idClient + " IpClient=" + ipClient + " Amount=" + amount + " MinAmount=" + minAmount + " MaxAmount=" + maxAmount);
	                if (amount >= minAmount) {
	                    if (amount > maxAmount)
	                        mssg = "Debes ingresar un monto de carga no mayor de " + ClientUtils.formatCurrency(maxAmount) + ".";
	                    else {
	                    	BbvaProcedureDefineTransaction resultado = balanceSaleBo.getDefineTransactionBBVA(idClient, amount, codePromotional, Constants.PLATAFORM, tokenValidation.getOperatorId());
	                    	resulttrx = resultado.getTransaction();
	                    	if (resulttrx.equals(""))
	                            mssg = "No se ha logrado generar el c&oacute;digo para realizar el pago con su cuenta BBVA. ";
				            
				            List<BbvaProcedureCheckTransaction> lista = balanceSaleBo.getCheckTransactionBBVA(idClient);
				            for (BbvaProcedureCheckTransaction kp : lista) {
				                if (kp.getId() != null && !kp.getId().trim().equals(""))
				                    data += kp.getId().substring(0, 6) + "|";
				                else
				                    data += " |";
				                if (kp.getAmount() != null)
				                    data += ClientUtils.formatCurrency(kp.getAmount()) + "|";
				                else
				                    data += " |";
				                if (kp.getExpiryDate() != null)
				                    data += kp.getExpiryDate() + "|";
				                else
				                    data += " |";
				                if (kp.getStatus() != null && !kp.getStatus().trim().equals(""))
				                    data += kp.getStatus() + "|";
				                else
				                    data += " |";
				                if (kp.getId() != null && !kp.getId().trim().equals(""))
				                    data += kp.getId() + "||";
				                else
				                    data += " ||";
				            }
				            
				            if(idClientInt>0 ) {
				            	ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(Integer.parseInt(idSession), Integer.parseInt(idClient));
				            	if(clientProcedureGetClient != null) {
				            		outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "||| |||" + ClientUtils.formatCurrency(clientProcedureGetClient.getAmount());
				            		
				            		if (bono!=null&& !bono.isEmpty()) {
				            			outData += "|||"+codePromotional;
				            			ClientProcedureAccountData accountData = clientSaleBo.findAccountData(idClientInt);		            			
				            			try {
				            				outData += "|||"+ClientUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",",".")));
				            	    	} catch (Exception e) {
				            	    		outData += "|||"+ClientUtils.formatCurrency(0.00);
				            			}
				            			try {
				            				outData += "|||"+accountData.getOtherQuantity();
				            	    	} catch (Exception e) {
				            	    		outData += "|||"+0;
				            			}
				            		} else
					                		outData += "|||";
				               }
				            } else {
				                mssg = "No se ha completado la operaci&oacute;n.";
				                outData = (data.length() > 2 ? data.substring(0, data.length() - 2) : " ") + "|||" + mssg + "|||-1||| ";
				            }
		                }
		        	} else {
		        		mssg = "Debe ingresar un monto de carga a partir de " + ClientUtils.formatCurrency(minAmount) + ".";
		        		outData = " |||" + mssg + "|||-1||| ";
		        	}
        		}else {
        			mssg = "Haz alcanzado el límite m&aacute;ximo de c&oacute;digos BBVA generados.";
	        		outData = " |||" + mssg + "|||-1||| ";
        		}
        	}
            out.print(outData);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info(" OutData=" + outData);
    		LoggerApi.Log.info("-------------- END genera-codigo-bbva-rt"); 
        }
    }
	
	@RequestMapping(value = "/check-transaction-bbva-rt")
    public void getCheckTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String data = "";
		String outData = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		PrintWriter out = response.getWriter();
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=ClientUtils.getClientIp(request);
		try {
			//Validar token
			String idClient="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient=tokenValidation.getClientId();
			
				List<BbvaProcedureCheckTransaction> lista = balanceSaleBo.getCheckTransactionBBVA(idClient);
		        for (BbvaProcedureCheckTransaction kp : lista) {
		            if (kp.getId() != null && !kp.getId().trim().equals(""))
	                    data += kp.getId().substring(0, 6) + "|";
		            else
		                data += " |";
		            if (kp.getAmount() != null)
		                data += ClientUtils.formatCurrency(kp.getAmount()) + "|";
		            else
		                data += " |";
		            if (kp.getExpiryDate() != null)
		            	data += kp.getExpiryDate() + "|";
		            else
		                data += " |";
		            if (kp.getStatus() != null && !kp.getStatus().trim().equals(""))
		                data += kp.getStatus() + "|";
		            else
		                data += " |";
		            if (kp.getId() != null && !kp.getId().trim().equals(""))
		                data += kp.getId() + "||";
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
	
    @RequestMapping(value = "/anularBBVA-rt")
    public void expiryTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pin = request.getParameter("pin");
        String rechargetoken=request.getHeader("rechargetoken");
		String ip=ClientUtils.getClientIp(request);
		PrintWriter out = response.getWriter();
		String outData = "";
		try {
			//Validar token
			String idClient="";
			ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
			tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient=tokenValidation.getClientId();			
				LoggerApi.Log.info("anularBBVA pin=" + pin+" idClient="+idClient);
				int status = balanceSaleBo.expiryTransactionBBVA(pin, idClient);
				if (status == -1)
					outData="No se pudo anular la transacci&oacute;n";
		        else
		        	outData="Anulado!";
			}else {
				String state=tokenValidation.getStatus();
				if(state.equals("TIMEOUTTR")) {
					outData=state;
				}
			}
			out.print(outData);
		}catch (Exception e) {
			LoggerApi.severe(e);
		}
		LoggerApi.Log.info(" OutData=" + outData);
    }
    
    @RequestMapping(value = "/verificarBBVA-rt")
    public void verifyTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LoggerApi.Log.info("-------------- START verificarBBVA-rt"); 
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=ClientUtils.getClientIp(request);
        JsonObject o = new JsonObject();
    	//Validar token
    	String idClient = "";
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
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
        double amount = ((smount!=null && !smount.isEmpty())?Double.parseDouble(request.getParameter("amount").toString().replaceAll("S/ ", "").trim()):0);
        String pin = request.getParameter("pin");
        Object[] resultado = balanceSaleBo.verifyTransactionBBVA(pin, idClient);
        int result = (Integer) resultado[0];
        
        if (result >= 1) {
        	LoggerApi.Log.info("amount="+amount + " idClientInt="+idClientInt); 
        	ClientProcedureAccountData accountData = clientSaleBo.findAccountData(idClientInt);
			PromoFirstAccount promoFistAccount = clientSaleBo.promotionFirstAccount(Integer.parseInt(idClient), result);
            if (promoFistAccount != null) {
                promotionMessage = promoFistAccount.getPromotion_message();
                if (promotionMessage.equals("OK")) {
                	promotionMessage = promoFistAccount.getPromotion_eco();
                }
            }
            if(!promotionMessage.trim().equals("") && accountData.getBalanceAmount()>amount) {
                if (promotionMessage.indexOf("insuficiente") > -1 ) {
                    alertmsg = promotionMessage + "<br/><br/>La recarga ha sido abonada a su saldo principal.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency( (Integer) resultado[1]);
                } else {
                    alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency( (Integer) resultado[1]) + "<br/>" + promotionMessage;                               
                }
            } else {
            	 if(promotionMessage.contains("100%")) {
        	    	 alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/>"+ promotionMessage;
        	    }else {
        	    	alertmsg = "Se ha realizado una recarga con &eacute;xito a su saldo.<br/><br/>Monto cargado: " + ClientUtils.formatCurrency( (Integer) resultado[1]) + "<br/>Tu saldo disponible es: S/ " + accountData.getBalanceAmount() + "<br/>" + promotionMessage;
        	    }
            }
            o.addProperty("state", "OK");
            o.addProperty("message", alertmsg);
            o.addProperty("amount", ClientUtils.formatCurrency(accountData.getBalanceAmount()));
            String bonusAmount="";
            try {
            	bonusAmount=ClientUtils.formatCurrency(Double.parseDouble(accountData.getBonusAmount().replaceAll(",",".")));
        	} catch (Exception e) {
        		bonusAmount= ClientUtils.formatCurrency(0.00);
    		}
            o.addProperty("bonusAmount", bonusAmount);
            String bonusOther="";
            try {
            	bonusOther = accountData.getOtherQuantity();
        	} catch (Exception e) {
        		bonusOther= "0";
    		}
            o.addProperty("bonusOther", bonusOther);
        } else {
            o.addProperty("state", "KO");
            o.addProperty("message", "A&uacute;n no se ha realizado la operaci&oacute;n desde tu cuenta BBVA");
        }
        out.print(o);
        LoggerApi.Log.info("-------------- END verificarBBVA-rt"); 
    }
}