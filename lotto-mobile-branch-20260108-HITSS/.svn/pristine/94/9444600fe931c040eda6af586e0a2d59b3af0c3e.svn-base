package pe.com.intralot.loto.layer.view.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesSpay;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.view.client.ClientBalanceController;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;

/**
 * @author cristian.cortez
 */
@Controller
public class SafetyPage {

	@Autowired
	IntralotUtils intralotUtils;
	@Autowired
	private ClientBalanceBo beanClientBalanceBo;
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	@Autowired
	private ClientLotocardBo beanClientLotocardBo;
	
    @RequestMapping(value = "/safety_page_post")
    protected void doPost(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
    	String context = "CARD-WEB";
        PrintWriter out = null;
        out = response.getWriter();
        HttpSession session = request.getSession();
        String idSession = "";
        String idClient = "";
        //int idClientInt = 0;
        double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        AccountController controller = new AccountController();
        Object[] outCadenas;
        String mssg = "", bono = "", wbbono = "", bonokey = "", outData = "";
        try {
        	if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    		//idClientInt = Integer.parseInt(idClient);
	    	}
        	if(!idClient.equals("")) {
				ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart"); 
				minAmount=accountDataPart.getAmtMinRechargeSpay();
				maxAmount=accountDataPart.getAmtMaxRechargeSpay();
//        		if(ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)
//	            	maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim());
//	            if(ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)
//	            	minAmount = Double.parseDouble(ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim());
	            if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
	            	tamount = request.getParameter("posAmount").trim();
	                amount = Double.parseDouble(tamount);
	            }
	            if(amount >= minAmount) {
					if(amount > maxAmount)
						//objectModelMap.put("alertCulqi", "Debe ingresar un monto de carga no mayor de S/. 3000.");
						mssg = "Debes ingresar un monto de carga no mayor de " + intralotUtils.formatCurrency2(maxAmount) + ".";
					else {
			        	bono = request.getParameter("activ-bono");
			        	wbbono = request.getParameter("activ-wbbono");
			        	/*String bonoBienvenida = intralotUtils.verifiedWelcomeBonus(session);
						 if (StringUtils.isNotEmpty(bonoBienvenida)) {
							 bonokey=bonoBienvenida+"|"+request.getRemoteAddr();
		                } else {
		                	bonokey = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE|":"");	
		                }*/
			            //bonokey = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":"");
			        	bonokey = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]:"")));
			            LoggerApi.Log.info("/safety_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
			            Logger.getLogger(LoggerAPI.SALECARD).info("/safety_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
			            /*Logger.getLogger(LoggerAPI.SALECARD).info(
			                    "cid=" + request.getParameter("clientId") + " sessionId=" + request.getParameter("sessionId") + " posAmount=" + request.getParameter("posAmount") + " typeToken=" + request.getParameter("typeToken"));*/
			            Logger.getLogger(LoggerAPI.SALECARD).info(
			                    "cid=" + idClient + " sessionId=" + idSession + " posAmount=" + tamount + " typeToken=" + request.getParameter("typeToken"));
			            /*outCadenas = AccountController.defineTransactionSafety(request.getParameter("clientId"), request.getParameter("sessionId"),
			                    Double.parseDouble(request.getParameter("posAmount")), bonokey);*/
			            outCadenas = AccountController.defineTransactionSafety(idClient, idSession, amount, bonokey);
			            int typeToken = Integer.parseInt(request.getParameter("typeToken"));
			            String safetyCreateExpressToken = ConnectionFactory.operationProperty("safetyCreateExpressToken", "CARD-WEB");
			            String transactionOkURL = ConnectionFactory.operationProperty("safetyTransactionOkURL", "CARD-WEB");
			            String transactionErrorURL = ConnectionFactory.operationProperty("safetyTransactionErrorURL", "CARD-WEB");
			            String signature = ConnectionFactory.operationProperty("safetySignatureKey", "CARD-WEB");
			            String apikey = ConnectionFactory.operationProperty("safetyAPIKey", "CARD-WEB");
			            String signatura = "";
			            String expirationTime = (typeToken==2)?"320":"20";
			            //signatura = outCadenas[2] + "PEN" + request.getParameter("posAmount") + outCadenas[0] + "ES" + "INTRALOT" + expirationTime + transactionOkURL + transactionErrorURL + signature;
			            signatura = outCadenas[2] + "PEN" + tamount + outCadenas[0] + "ES" + "INTRALOT" + expirationTime + transactionOkURL + transactionErrorURL + signature;
			            //Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + request.getParameter("clientId") + " signatura=" + signatura);
			            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " signatura=" + signatura);
			            MessageDigest md = null;
			            md = MessageDigest.getInstance("SHA-256");
			            byte[] hash = md.digest(signatura.getBytes());
			            StringBuffer sb = new StringBuffer();
			            for (byte b : hash)
			                sb.append(StringLib.padLeft(Integer.toHexString(b & 0xff), '0', 2));
			            String parametros = "&ApiKey=" + apikey + "&RequestDateTime=" + outCadenas[2] + "&CurrencyCode=" + "PEN" + "&Amount=" + tamount
			                    + "&MerchantSalesID=" + outCadenas[0] + "&ExpirationTime=" + expirationTime + "&TrackingCode=" + "INTRALOT" + "&Language=" + "ES" + "&TransactionOkURL="
			                    + transactionOkURL + "&TransactionErrorURL=" + transactionErrorURL + "&Signature=" + sb + "&ResponseFormat=" + "CSV";
			            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " parametros=" + parametros);
			            String respuesta = query(safetyCreateExpressToken, parametros);
			            int ini = 0;
			            int fin = 0;
			            int countcoma = 0;
			            String status = "";
			            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " respuesta=" + respuesta);
			            Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + idClient + " respuesta=" + respuesta);
			            if (respuesta != null && !respuesta.equals("")) {
			                if (respuesta.charAt(0) == '0') {
			                    for (int i = 0; i < respuesta.length(); i++)
			                        if (respuesta.charAt(i) == ',') {
			                            countcoma++;
			                            if (countcoma == 1)
			                                status = respuesta.substring(0, i);
			                            if (countcoma == 2)
			                                ini = i + 1;
			                            if (countcoma == 3)
			                                fin = i;
			                        }
			                    String validacion = controller.setTokenSafetyPay(outCadenas[0].toString(), respuesta, status);
			                    Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + idClient + " validacion=" + validacion);
			                    String url = respuesta.substring(ini, fin);
			                    if(typeToken==2) url += "&CountryId=PER&ChannelId=Cash";
			                    Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " url=" + url);
			                    outData = url;
			                }
			            } else {
			            	mssg = "No se ha completado la operaci&oacute;n.";
			                Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " error de Envio de parametros");
			            }
					}
	            } else mssg = "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".";
	            	//request.setAttribute(WebConsts.ALERT_MSG, "Debe ingresar un monto de carga a partir de S/. 40.");
        	}
        	out.print(outData+" | "+mssg);
        } catch (Exception e) {
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
        } finally {
        	try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
        }
    }

    public String query(String url1, String query) {
        Logger.getLogger(LoggerAPI.SALECARD).info("url1=" + url1 + " query=" + query);
        StringBuffer sb = new StringBuffer();
        try {
            // Abrimos la conexion y le pasamos nuestro contexto SSL
            // System.setProperty("https.proxyHost","192.168.100.14");
            // System.setProperty("https.proxyPort","8080");
            URL url = new URL(url1);
            HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
            conexion.setDoOutput(true);
            conexion.setDoInput(true);
            conexion.setUseCaches(false);
            OutputStreamWriter wr = new OutputStreamWriter(conexion.getOutputStream());
            //wr.write("i.do?m=contactenos");
            wr.write(query);
            wr.flush();
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];
            int leido;
            while ((leido = br.read(buffer)) > 0)
                // System.out.println(new String(buffer, 0, leido));
                sb.append(new String(buffer, 0, leido));
        } catch (MalformedURLException e) { 
            Logger.getLogger(LoggerAPI.SALECARD).info("La consulta para " + url1 + " es incorrecta");
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
        } catch (IOException e) { 
            Logger.getLogger(LoggerAPI.SALECARD).info("No se puede conectar a " + url1 + "  " + e.getMessage());
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
        } catch (Exception e) {
            Logger.getLogger(LoggerAPI.SALECARD).info("Error al conectar a " + url1 + " " + e.getMessage());
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
        }
        return sb.toString();
    }

    @RequestMapping(value = "/safetypayURL")
    protected String safetyPayUrl(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
        return "client/home_user";
    }
    
    @RequestMapping(value = "/safety_page_post_rt")
    protected void doPostRT(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
    	LoggerApi.Log.info("-------------- START safetyPage /safety_page_post_rt");
    	String context = "CARD-WEB";
        PrintWriter out = null;
        response.setCharacterEncoding(Constantes.CHARSET_UTF8);
        out = response.getWriter();
//        HttpSession session = request.getSession();
        String idSession = "";
        String idClient = "";
        int idClientInt = 0;
        double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        AccountController controller = new AccountController();
        Object[] outCadenas;
        String mssg = "", bono = "", wbbono = "", bonokey = "", outData = "";
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=SecurityUtils.getClientIp(request);
        ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
        try {
        	// Validación de token
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient = tokenValidation.getClientId();
	    		idClientInt = Integer.parseInt(idClient);
			
        	if(!idClient.equals("")) {
        		ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClientInt); 
				minAmount=accountDataPart.getAmtMinRechargeSpay();
				maxAmount=accountDataPart.getAmtMaxRechargeSpay();
//        		if(ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)
//	            	maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim());
//	            if(ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)
//	            	minAmount = Double.parseDouble(ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim());
	            if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
	            	tamount = request.getParameter("posAmount").trim();
	            	Boolean veryfyAmount= DoubleValidator.getInstance().isValid(tamount);
	            	//Validar monto ingresado
	            	if(!veryfyAmount) {	
	            		mssg="El monto ingresado es incorrecto";
	            		out.print(outData+" | "+mssg);
						return;
					}
	                amount = Double.parseDouble(tamount);
	            }
	            if(amount >= minAmount) {
					if(amount > maxAmount)
						//objectModelMap.put("alertCulqi", "Debe ingresar un monto de carga no mayor de S/. 3000.");
						mssg = "Debes ingresar un monto de carga no mayor de " + intralotUtils.formatCurrency2(maxAmount) + ".";
					else {
						BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay = beanClientBalanceBo.resultEvalRulesSpay(idClientInt, amount);
						if(resultEvalRulesSpay.getResult().equals(Constantes.RESULT_OK)) {
							//validar activación de bono
				            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
				        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
				        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";		        	
				            JsonObject jresult=ClientBalanceController.backCodePromotionalValidation(rechargetoken, ip, request.getRemoteAddr(), 
				            		codePromotional, channel, amount, lotocard, beanSecurityLoginBo, beanClientLotocardBo, beanClientBalanceBo);
				            bono=jresult.get("bono").getAsString();
				            wbbono=jresult.get("wbbono").getAsString();
				            
				        	bonokey = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]:"")));
				            LoggerApi.Log.info("/safety_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
				            Logger.getLogger(LoggerAPI.SALECARD).info("/safety_page_post_rt: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
				            /*Logger.getLogger(LoggerAPI.SALECARD).info(
				                    "cid=" + request.getParameter("clientId") + " sessionId=" + request.getParameter("sessionId") + " posAmount=" + request.getParameter("posAmount") + " typeToken=" + request.getParameter("typeToken"));*/
				            Logger.getLogger(LoggerAPI.SALECARD).info(
				                    "cid=" + idClient + " sessionId=" + idSession + " posAmount=" + tamount + " typeToken=" + request.getParameter("typeToken"));
				            /*outCadenas = AccountController.defineTransactionSafety(request.getParameter("clientId"), request.getParameter("sessionId"),
				                    Double.parseDouble(request.getParameter("posAmount")), bonokey);*/
				            outCadenas = AccountController.defineTransactionSafety(idClient, idSession, amount, bonokey);
				            int typeToken = Integer.parseInt(request.getParameter("typeToken"));
				            String safetyCreateExpressToken = ConnectionFactory.operationProperty("safetyCreateExpressToken", "CARD-WEB");
				            String transactionOkURL = ConnectionFactory.operationProperty("safetyTransactionOkURL", "CARD-WEB");
				            String transactionErrorURL = ConnectionFactory.operationProperty("safetyTransactionErrorURL", "CARD-WEB");
				            String signature = ConnectionFactory.operationProperty("safetySignatureKey", "CARD-WEB");
				            String apikey = ConnectionFactory.operationProperty("safetyAPIKey", "CARD-WEB");
				            String signatura = "";
				            String expirationTime = (typeToken==2)?"320":"20";
				            //signatura = outCadenas[2] + "PEN" + request.getParameter("posAmount") + outCadenas[0] + "ES" + "INTRALOT" + expirationTime + transactionOkURL + transactionErrorURL + signature;
				            signatura = outCadenas[2] + "PEN" + tamount + outCadenas[0] + "ES" + "INTRALOT" + expirationTime + transactionOkURL + transactionErrorURL + signature;
				            //Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + request.getParameter("clientId") + " signatura=" + signatura);
				            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " signatura=" + signatura);
				            MessageDigest md = null;
				            md = MessageDigest.getInstance("SHA-256");
				            byte[] hash = md.digest(signatura.getBytes());
				            StringBuffer sb = new StringBuffer();
				            for (byte b : hash)
				                sb.append(StringLib.padLeft(Integer.toHexString(b & 0xff), '0', 2));
				            String parametros = "&ApiKey=" + apikey + "&RequestDateTime=" + outCadenas[2] + "&CurrencyCode=" + "PEN" + "&Amount=" + tamount
				                    + "&MerchantSalesID=" + outCadenas[0] + "&ExpirationTime=" + expirationTime + "&TrackingCode=" + "INTRALOT" + "&Language=" + "ES" + "&TransactionOkURL="
				                    + transactionOkURL + "&TransactionErrorURL=" + transactionErrorURL + "&Signature=" + sb + "&ResponseFormat=" + "CSV";
				            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " parametros=" + parametros);
				            String respuesta = query(safetyCreateExpressToken, parametros);
				            int ini = 0;
				            int fin = 0;
				            int countcoma = 0;
				            String status = "";
				            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " respuesta=" + respuesta);
				            Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + idClient + " respuesta=" + respuesta);
				            if (respuesta != null && !respuesta.equals("")) {
				                if (respuesta.charAt(0) == '0') {
				                    for (int i = 0; i < respuesta.length(); i++)
				                        if (respuesta.charAt(i) == ',') {
				                            countcoma++;
				                            if (countcoma == 1)
				                                status = respuesta.substring(0, i);
				                            if (countcoma == 2)
				                                ini = i + 1;
				                            if (countcoma == 3)
				                                fin = i;
				                        }
				                    String validacion = controller.setTokenSafetyPay(outCadenas[0].toString(), respuesta, status);
				                    Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + idClient + " validacion=" + validacion);
				                    String url = respuesta.substring(ini, fin);
				                    if(typeToken==2) url += "&CountryId=PER&ChannelId=Cash";
				                    Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " url=" + url);
				                    outData = url;
				                }
				            } else {
				            	mssg = "No se ha completado la operaci&oacute;n.";
				                Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + idClient + " error de Envio de parametros");
				            }
						}else {
							mssg = resultEvalRulesSpay.getMessage();
						}
					}
	            } else mssg = "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".";
	            	//request.setAttribute(WebConsts.ALERT_MSG, "Debe ingresar un monto de carga a partir de S/. 40.");
        	}
        	
			}else {
        		String state = tokenValidation.getStatus();
        		mssg=state; 	
        	}
			out.print(outData+"|"+mssg);
        } catch (Exception e) {
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
        } finally {
        	LoggerApi.Log.info("-------------- END safetyPage /safety_page_post_rt outData= "+outData+" mssg="+mssg);
//        	try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
        }
    }
}