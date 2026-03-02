package pe.com.intralot.loto.layer.controller.payment;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.ClientBalanceController;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesSpay;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.LoggerApi;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;

/**
 * @author PROYPERU
 */
@Controller
public class SafetyPage {
	
    @Autowired
    private ClientSaleBo clientSaleBo;
    
    @Autowired
    private BalanceSaleBo balanceSaleBo;

    @RequestMapping(value = "/safety_page_post")
    protected void doPost(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        AccountController controller = new AccountController();
        Object[] outCadenas;
        String bono = "", wbbono = "", bonokey = "";
        
        Integer sessionId = 0;
        Integer clientId = 0;
        
        try {
        	HttpSession session = request.getSession();
        	if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
        		sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
        	}
        	
        	bono = request.getParameter("activ-bono");
        	wbbono = request.getParameter("activ-wbbono");
        	bonokey = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]:"")));
            Logger.getLogger(LoggerAPI.SALECARD).info("/safety_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
            Logger.getLogger(LoggerAPI.SALECARD).info(
                    "cid=" + clientId.toString() + " sessionId=" + sessionId.toString() + " posAmount=" + request.getParameter("posAmount") + " typeToken=" + request.getParameter("typeToken"));
            outCadenas = AccountController.defineTransactionSafety(clientId.toString(), sessionId.toString(),
                    Double.parseDouble(request.getParameter("posAmount")), bonokey);
            int typeToken = Integer.parseInt(request.getParameter("typeToken"));
            String safetyCreateExpressToken = ConnectionFactory.operationProperty("safetyCreateExpressToken", Constants.contextCardWeb);
            String transactionOkURL = ConnectionFactory.operationProperty("safetyTransactionOkURL", Constants.contextCardWeb);
            String transactionErrorURL = ConnectionFactory.operationProperty("safetyTransactionErrorURL", Constants.contextCardWeb);
            String signature = ConnectionFactory.operationProperty("safetySignatureKey", Constants.contextCardWeb);
            String apikey = ConnectionFactory.operationProperty("safetyAPIKey", Constants.contextCardWeb);
            String signatura = "";
            String expirationTime = (typeToken==2)?"320":"20";
            signatura = outCadenas[2] + "PEN" + request.getParameter("posAmount") + outCadenas[0] + "ES" + "INTRALOT" + expirationTime + transactionOkURL + transactionErrorURL
                    + signature;
            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " signatura=" + signatura);
            MessageDigest md = null;
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(signatura.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : hash)
                sb.append(StringLib.padLeft(Integer.toHexString(b & 0xff), '0', 2));
            String parametros = "&ApiKey=" + apikey + "&RequestDateTime=" + outCadenas[2] + "&CurrencyCode=" + "PEN" + "&Amount=" + request.getParameter("posAmount")
                    + "&MerchantSalesID=" + outCadenas[0] + "&ExpirationTime=" + expirationTime + "&TrackingCode=" + "INTRALOT" + "&Language=" + "ES" + "&TransactionOkURL="
                    + transactionOkURL + "&TransactionErrorURL=" + transactionErrorURL + "&Signature=" + sb + "&ResponseFormat=" + "CSV";
            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " parametros=" + parametros);
            String respuesta = query(safetyCreateExpressToken, parametros);
            int ini = 0;
            int fin = 0;
            int countcoma = 0;
            String status = "";
            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " respuesta=" + respuesta);
            Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + clientId.toString()+ " respuesta=" + respuesta);
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
                    Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + clientId.toString() + " validacion=" + validacion);
                    String url = respuesta.substring(ini, fin);
                    if(typeToken==2) url += "&CountryId=PER&ChannelId=Cash";
                    Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " url=" + url);
                    out.print(url);
                }
            } else
                Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " error de Envio de parametros");

        } catch (Exception e) {
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
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
    
    @RequestMapping(value = "/safety_page_api_post")
    protected void safety_page_api_post(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
    	String log="safety_page_api_post";
		LoggerApi.Log.info("-------------- START " +log);
    	PrintWriter out = null;
        response.setCharacterEncoding(Constants.CHARSET_UTF8);
        out = response.getWriter();
        JsonObject o = new JsonObject();
        AccountController controller = new AccountController();
        Object[] outCadenas;
        String bono = "", wbbono = "", bonokey = "";
        
        Integer sessionId = 0;
        Integer clientId = 0;
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=ClientUtils.getClientIp(request);
        try {
        	//Validar token
    		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
    		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
        	if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
        		double maxAmount = 0;
        		double minAmount = 0;
        		double amount = 0;
                clientId = Integer.parseInt(tokenValidation.getClientId());
                
        		ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();
        		accountDataPart = clientSaleBo.findAccountDataPart(clientId);
        		sessionId = accountDataPart.getSessionId();
        		
        		minAmount=accountDataPart.getAmtMinRechargeSpay();
				maxAmount=accountDataPart.getAmtMaxRechargeSpay();
				
				if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
					amount = Double.parseDouble(request.getParameter("posAmount").trim());
				}
				
				if(amount >= minAmount) {
					if(amount > maxAmount) {
						o.addProperty("message", "Debes ingresar un monto de carga no mayor de "+ClientUtils.formatCurrency(maxAmount));
						out.print(o);
					}else {
						BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay = balanceSaleBo.resultEvalRulesSpay(clientId, amount);
						if(resultEvalRulesSpay.getResult().equals(Constants.RESULT_OK)) {
				        	//validar activación de bono
				            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
				        	String channel = (request.getParameter("channel")!=null)?request.getParameter("channel").toString().trim():"";
				        	String lotocard = (request.getParameter("lotocard")!=null)?request.getParameter("lotocard").toString().trim():"";		        	
				            JsonObject jresult=ClientBalanceController.backCodePromotionalValidation(rechargetoken, ip, request.getRemoteAddr(), 
				            		codePromotional, channel, amount, lotocard, clientSaleBo);
				            bono=jresult.get("bono").getAsString();
				            wbbono=jresult.get("wbbono").getAsString();
				            
				        	bonokey = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]:"")));
				            Logger.getLogger(LoggerAPI.SALECARD).info("/safety_page_post: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);
				            Logger.getLogger(LoggerAPI.SALECARD).info(
				                    "cid=" + clientId.toString() + " sessionId=" + sessionId.toString() + " posAmount=" + request.getParameter("posAmount") + " typeToken=" + request.getParameter("typeToken"));
				            outCadenas = AccountController.defineTransactionSafety(clientId.toString(), sessionId.toString(),
				                    Double.parseDouble(request.getParameter("posAmount")), bonokey);
				            int typeToken = Integer.parseInt(request.getParameter("typeToken"));
				            String safetyCreateExpressToken = ConnectionFactory.operationProperty("safetyCreateExpressToken", Constants.contextCardWeb);
				            String transactionOkURL = ConnectionFactory.operationProperty("safetyTransactionOkURL", Constants.contextCardWeb);
				            String transactionErrorURL = ConnectionFactory.operationProperty("safetyTransactionErrorURL", Constants.contextCardWeb);
				            String signature = ConnectionFactory.operationProperty("safetySignatureKey", Constants.contextCardWeb);
				            String apikey = ConnectionFactory.operationProperty("safetyAPIKey", Constants.contextCardWeb);
				            String signatura = "";
				            String expirationTime = (typeToken==2)?"320":"20";
				            signatura = outCadenas[2] + "PEN" + request.getParameter("posAmount") + outCadenas[0] + "ES" + "INTRALOT" + expirationTime + transactionOkURL + transactionErrorURL
				                    + signature;
				            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " signatura=" + signatura);
				            MessageDigest md = null;
				            md = MessageDigest.getInstance("SHA-256");
				            byte[] hash = md.digest(signatura.getBytes());
				            StringBuffer sb = new StringBuffer();
				            for (byte b : hash)
				                sb.append(StringLib.padLeft(Integer.toHexString(b & 0xff), '0', 2));
				            String parametros = "&ApiKey=" + apikey + "&RequestDateTime=" + outCadenas[2] + "&CurrencyCode=" + "PEN" + "&Amount=" + request.getParameter("posAmount")
				                    + "&MerchantSalesID=" + outCadenas[0] + "&ExpirationTime=" + expirationTime + "&TrackingCode=" + "INTRALOT" + "&Language=" + "ES" + "&TransactionOkURL="
				                    + transactionOkURL + "&TransactionErrorURL=" + transactionErrorURL + "&Signature=" + sb + "&ResponseFormat=" + "CSV";
				            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " parametros=" + parametros);
				            String respuesta = query(safetyCreateExpressToken, parametros);
				            int ini = 0;
				            int fin = 0;
				            int countcoma = 0;
				            String status = "";
				            Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " respuesta=" + respuesta);
				            Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + clientId.toString()+ " respuesta=" + respuesta);
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
				                    Logger.getLogger(LoggerAPI.SALECARD).finest("cid=" + clientId.toString() + " validacion=" + validacion);
				                    String url = respuesta.substring(ini, fin);
				                    if(typeToken==2) url += "&CountryId=PER&ChannelId=Cash";
				                    Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " url=" + url);
				                    o.addProperty("url", url);
				                    out.print(o);
				                }
				            } else
				                Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId.toString() + " error de Envio de parametros");
						}else {	
			            	o.addProperty("message", resultEvalRulesSpay.getMessage());
							out.print(o);
						}
					}
				}else {
					o.addProperty("message", "Debe ingresar un monto de carga a partir de " + ClientUtils.formatCurrency(minAmount));
					out.print(o);
				}
        	}else {
        		String state = tokenValidation.getStatus();
        		if(tokenValidation.getStatus().equals("TIMEOUTTR")) {
        			o.addProperty("state", state);
                    out.print(o);       		
            	}
        	}
        } catch (Exception e) {
            LoggerAPI.severe(LoggerAPI.SALECARD, e);
        }finally {
        	LoggerApi.Log.info("-------------- END " +log);
        }
    }

    @RequestMapping(value = "/safetypayURL")
    protected String safetyPayUrl(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
        return "client/home_user";
    }
}