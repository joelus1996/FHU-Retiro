package pe.com.intralot.loto.layer.controller.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.ClientBalanceController;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesPefe;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.LoggerApi;
import pe.com.intralot.loto.www.sale.client.lib.WebConsts;

/**<p> NAME:    portalPage.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    06/07/2018  Se cambia FINEST por INFO en el log. Se agrega LoggerAPI.severe en el catch
 * </pre>
 * </p>
 */

@Controller
public class portalPage {

    @Autowired
    private ClientSaleBo clientSaleBo;
    
    @Autowired
    private BalanceSaleBo balanceSaleBo;

    @RequestMapping(value = "/portal_page")
    protected void doPost(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
    	LoggerApi.Log.info("------------- START portal_page");  
        PrintWriter out = null;
        out = response.getWriter();
        HttpSession session = request.getSession();
	    String bono = "", wbbono = "", bonokey = "",promotionalCode="";
        Integer sessionId = 0;
        Integer clientId = 0;
        try {
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                sessionId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
                clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
                String channel = request.getParameter("channel");               
        	    double amount = 0, maxAmount = 0, minAmount = 0;
        	    String tamount = "";
        	    String msg = "";
        	    
        	    ClientProcedureAccountDataPart accountDataPart = (ClientProcedureAccountDataPart) session.getAttribute("accountDataPart"); 
				if(channel!=null) {
					if(channel.trim().equals("PEFE")) {
						minAmount=accountDataPart.getAmtMinRechargePefe();
						maxAmount=accountDataPart.getAmtMaxRechargePefe();
					}else if(channel.trim().equals("YAPE")) {
						minAmount=accountDataPart.getAmtMinRechargeYape();
						maxAmount=accountDataPart.getAmtMaxRechargeYape();
					}else if(channel.trim().equals("PLIN")) {
						minAmount=accountDataPart.getAmtMinRechargePlin();
						maxAmount=accountDataPart.getAmtMaxRechargePlin();
					}
								
				if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
	            	tamount = request.getParameter("posAmount").trim();
	                amount = Double.parseDouble(tamount);
	            }
                
				if(amount >= minAmount) {
					if(amount > maxAmount) {
						msg = "Debes ingresar un monto de carga no mayor de "+ClientUtils.formatCurrency(maxAmount);;
						out.print(" | "+msg);
					}else {
						ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
		                String firstname = dataClient.getNombre();
		                String lastname = dataClient.getApPaterno() + " " + (dataClient.getApMaterno()!=null?dataClient.getApMaterno():"");

		                String country = dataClient.getCountry();
		                String typeidNum = "";
		                if (dataClient.getTypeId().equals("DNI"))
		                    typeidNum = "DNI";
		                else if (dataClient.getTypeId().equals("CAREX"))
		                    typeidNum = "NAN";
		                else if (dataClient.getTypeId().equals("PASAP"))
		                    typeidNum = "PAS";
		                String numberid = dataClient.getNumberId();
		                String email = dataClient.getMail();
		                String posAmount = request.getParameter("posAmount");
		                bono = request.getParameter("activ-bono");
		                wbbono = request.getParameter("activ-wbbono");
		                promotionalCode = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
		                Logger.getLogger(LoggerAPI.SALECARD).info("/pagoEfectivo-portal_page: activ-bono="+bono+" activ-wbbono="+wbbono+" promotionalCode="+promotionalCode);
		                
		                //1. obtener token de autorizacion
		                NumberFormat formatter = new DecimalFormat("0.00");
		                String cashAmount = formatter.format(Double.parseDouble(posAmount));
		                JsonObject jdata = new JsonObject();
		                jdata.addProperty("clientId", clientId);
		                jdata.addProperty("sessionId", sessionId);
		                jdata.addProperty("amount", cashAmount);
		                jdata.addProperty("promotion", promotionalCode);
		                jdata.addProperty("channel", channel);
		                String pagoEfectivoResponse=requestWSPagoEfectivo(jdata.toString(), "authorization");
		                JSONObject convertedObject = new JSONObject(pagoEfectivoResponse);
		                String message = convertedObject.getString("message");
		                if(!message.equals("OK")) {
		                	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
		                    return;
		                }
		                
		                //2. generar cip
		                jdata.addProperty("token", convertedObject.getString("token"));
		                jdata.addProperty("transactionId", convertedObject.getString("transactionId"));
		                jdata.addProperty("fechaAutorizacion", convertedObject.getString("fechaAutorizacion"));
		                jdata.addProperty("fechaAutorizacionDb", convertedObject.getString("fechaAutorizacionDb"));
		                jdata.addProperty("fechaExpire", convertedObject.getString("fechaExpire"));
		                jdata.addProperty("userEmail", email);
		                jdata.addProperty("userName", firstname);
		                jdata.addProperty("userLastName", lastname);
		                jdata.addProperty("country", country);
		                jdata.addProperty("documentype", typeidNum);
		                jdata.addProperty("documentNumber", numberid);
		                jdata.addProperty("userPhone", dataClient.getMobilePhone());
		                jdata.addProperty("userCodeCountry", "+51");
		                jdata.addProperty("channel", channel);
		                pagoEfectivoResponse=requestWSPagoEfectivo(jdata.toString(), "generatecip");
		                convertedObject = new JSONObject(pagoEfectivoResponse); 
		                message = convertedObject.getString("message");
		                if(!message.equals("OK")) {
		                	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
		                    return;
		                }
		                String cipUrl=convertedObject.getString("cipUrl");
		                out.print(cipUrl);
					}
				}else {
					msg = "Debe ingresar un monto de carga a partir de " + ClientUtils.formatCurrency(minAmount);
					out.print(" | "+msg);
				}
            }
        } catch (Exception ex) {
        	try { ClientUtils.updateClientBalance(session, clientSaleBo);} catch (Exception e) {}
        	LoggerAPI.severe(LoggerAPI.SALECARD, ex);
        }
        LoggerApi.Log.info("------------- END portal_page");  
    }
    
    private String requestWSPagoEfectivo(String json, String service) {
    	LoggerApi.Log.info("pagoEfectivoRequest: "+json);
		String jsonResponsePagoEfectivo="";
		try {
			String urlTransferPEAPI = ConnectionFactory.operationProperty("urlTransferPEAPI", Constants.contextCardWeb);
			String userTransferPEAPI = ConnectionFactory.operationProperty("userTransferPEAPI", Constants.contextCardWeb);
			String passTransferPEAPI = ConnectionFactory.operationProperty("passTransferPEAPI", Constants.contextCardWeb);
			String credenciales = userTransferPEAPI+":"+passTransferPEAPI;
			credenciales = Base64.encodeBase64String(credenciales.getBytes());
 	    	URL url = new URL(urlTransferPEAPI+service);
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
 				LoggerApi.Log.info("API TRANSFERENCIA PAGOEEFECTIVO HTTP CODE: "+responseCode + " json: "+json);
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
 			jsonResponsePagoEfectivo = sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info("API TRANSFERENCIA PAGOEEFECTIVO"+ service+"Response: "+jsonResponsePagoEfectivo + " json: "+json);	
 			}
 			LoggerApi.Log.info("API TRANSFERENCIA PAGOEEFECTIVO "+service+"Response: "+jsonResponsePagoEfectivo);
		} catch (Throwable e) {
			LoggerApi.severe(e);
		}
		return jsonResponsePagoEfectivo;
	}
    
    @RequestMapping({ "/portal_page_api" })
    protected void portal_page_api(final HttpServletRequest request, final HttpServletResponse response, final ModelMap objectModelMap) throws ServletException, IOException {
    	String log="portal_page_api";
		LoggerApi.Log.info("-------------- START " +log);
    	PrintWriter out = null;
    	response.setCharacterEncoding(Constants.CHARSET_UTF8);
        out = response.getWriter();
	    String bono = "", wbbono = "", bonokey = "";
        Integer clientId = 0;
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=ClientUtils.getClientIp(request);
        try {
        	//Validar token
    		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
    		tokenValidation = clientSaleBo.getTokenValidation(rechargetoken, ip);
            if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
                clientId = Integer.parseInt(tokenValidation.getClientId());
                String channel = request.getParameter("channel");               
        	    double amount = 0, maxAmount = 0, minAmount = 0;
        	    String tamount = "";
        	    String msg = "";
        	    
        	    ClientProcedureAccountDataPart accountDataPart= new ClientProcedureAccountDataPart();
        		accountDataPart = clientSaleBo.findAccountDataPart(clientId);
        		Integer sessionId = accountDataPart.getSessionId();
        		
				if(channel!=null) {
					if(channel.trim().equals("PEFE")) {
						minAmount=accountDataPart.getAmtMinRechargePefe();
						maxAmount=accountDataPart.getAmtMaxRechargePefe();
					}else if(channel.trim().equals("YAPE")) {
						minAmount=accountDataPart.getAmtMinRechargeYape();
						maxAmount=accountDataPart.getAmtMaxRechargeYape();
					}else if(channel.trim().equals("PLIN")) {
						minAmount=accountDataPart.getAmtMinRechargePlin();
						maxAmount=accountDataPart.getAmtMaxRechargePlin();
					}
				}
				
				if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
	            	tamount = request.getParameter("posAmount").trim();
	                amount = Double.parseDouble(tamount);
	            }
                
				if(amount >= minAmount) {
					if(amount > maxAmount) {
						msg = "Debes ingresar un monto de carga no mayor de "+ClientUtils.formatCurrency(maxAmount);
						out.print(" | "+msg);
					}else {
						boolean isApproved = false;
						if(channel.trim().equals("PEFE")) {
						BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe = balanceSaleBo.resultEvalRulesPefe(clientId, amount);
						if(resultEvalRulesPefe.getResult().equals(Constants.RESULT_OK)) {
								isApproved = true;
							}else {
								msg = resultEvalRulesPefe.getMessage();
							}
						}else {
							isApproved = true;
						}
						if(isApproved) {
							ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
			                String firstname = dataClient.getNombre();
			                String lastname = dataClient.getApPaterno() + " " + (dataClient.getApMaterno()!=null?dataClient.getApMaterno():"");
	
			                String country = dataClient.getCountry();
			                String typeidNum = "";		                
			                if ( dataClient.getTypeId()!=null ) {
				                if (dataClient.getTypeId().equals("DNI"))
				                    typeidNum = "DNI";
				                else if (dataClient.getTypeId().equals("CAREX"))
				                    typeidNum = "NAN";
				                else if (dataClient.getTypeId().equals("PASAP"))
				                    typeidNum = "PAS";
			                }
			                String numberid = dataClient.getNumberId();
			                String email = dataClient.getMail();
			                String posAmount = request.getParameter("posAmount");
			                
			                //validar activación de bono
				            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
			                Logger.getLogger(LoggerAPI.SALECARD).info("/pagoEfectivo-portal_page: activ-bono="+bono+" activ-wbbono="+wbbono+" codePromotional="+codePromotional);
			                
			                //1. obtener token de autorizacion
			                NumberFormat formatter = new DecimalFormat("0.00");
			                String cashAmount = formatter.format(Double.parseDouble(posAmount));
			                JsonObject jdata = new JsonObject();
			                jdata.addProperty("clientId", clientId);
			                jdata.addProperty("sessionId", sessionId);
			                jdata.addProperty("amount", cashAmount);
			                jdata.addProperty("promotion", codePromotional);
			                jdata.addProperty("channel", channel);
			                String pagoEfectivoResponse=requestWSPagoEfectivo(jdata.toString(), "authorization");
			                JSONObject convertedObject = new JSONObject(pagoEfectivoResponse);
			                String message = convertedObject.getString("message");
			                if(!message.equals("OK")) {
			                	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
			                    return;
			                }
			                //Registrar recarga, identificar plataforma y web de recarga
							String transactionId = convertedObject.getString("transactionId");
							String platform=Constants.PLATAFORM;
							String operatorId=tokenValidation.getOperatorId();
							ClientProcedureOriginPefeRecharge originPefeRecharge = clientSaleBo.setOriginPefeRecharge(transactionId, platform, operatorId);
							if(!originPefeRecharge.getStatus().equals("OK")) {
								LoggerApi.Log.info("-------------- portal_page_api"+" originPefeRecharge.getMessage=" +originPefeRecharge.getMessage());
							}
			                
			                //2. generar cip
			                jdata.addProperty("token", convertedObject.getString("token"));
			                jdata.addProperty("transactionId", convertedObject.getString("transactionId"));
			                jdata.addProperty("fechaAutorizacion", convertedObject.getString("fechaAutorizacion"));
			                jdata.addProperty("fechaAutorizacionDb", convertedObject.getString("fechaAutorizacionDb"));
			                jdata.addProperty("fechaExpire", convertedObject.getString("fechaExpire"));
			                jdata.addProperty("userEmail", email);
			                jdata.addProperty("userName", firstname);
			                jdata.addProperty("userLastName", lastname);
			                jdata.addProperty("country", country);
			                jdata.addProperty("documentype", typeidNum);
			                jdata.addProperty("documentNumber", numberid);
			                jdata.addProperty("userPhone", dataClient.getMobilePhone());
			                jdata.addProperty("userCodeCountry", "+51");
			                jdata.addProperty("channel", channel);
			                pagoEfectivoResponse=requestWSPagoEfectivo(jdata.toString(), "generatecip");
			                convertedObject = new JSONObject(pagoEfectivoResponse); 
			                message = convertedObject.getString("message");
			                if(!message.equals("OK")) {
			                	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
			                    return;
			                }
			                String cipUrl=convertedObject.getString("cipUrl");
			                out.print(cipUrl);
						}else {	
							out.print(" | "+msg);
						}
					}
				}else {
					msg = "Debe ingresar un monto de carga a partir de " + ClientUtils.formatCurrency(minAmount);
					out.print(" | "+msg);
				}
            }else {
            	if(tokenValidation.getStatus().equals("TIMEOUTTR")) {
            		String msg = tokenValidation.getStatus();
					out.print(" | "+msg);
            	}
            }
        } catch (Exception ex) {
        	LoggerAPI.severe(LoggerAPI.SALECARD, ex);
        }finally {
        	LoggerApi.Log.info("-------------- END " +log);
        }
    }
}