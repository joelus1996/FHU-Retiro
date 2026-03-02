package pe.com.intralot.loto.layer.view.payment;

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
import org.apache.commons.validator.routines.DoubleValidator;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesPefe;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.view.client.ClientBalanceController;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.www.sale.client.lib.WebConsts;

/**
 * @author cristian.cortez
 */
@Controller
public class PagoefectivoPage {

	@Autowired
	ClientAccountBo beanClientAccountBo;
	@Autowired
	IntralotUtils intralotUtils;
	@Autowired
	private ClientBalanceBo beanClientBalanceBo;
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	@Autowired
	private ClientLotocardBo beanClientLotocardBo;
	
    @RequestMapping(value = "/portal_page")
    protected void doPost(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
    	
    	LoggerApi.Log.info("-------------- START portal_page");
    	String context = "CARD-WEB";
    	PrintWriter out = null;
        out = response.getWriter();
        HttpSession session = request.getSession();
        String mssg = "", bono = "", wbbono = "", bonokey = "", outData = "",codePromotional="";
//        String idSession="";
        String idClient = "";
	    int idClientInt = 0;
	    double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        try {
        	if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    		idClientInt = Integer.parseInt(idClient);
	    	}
        	if(!idClient.equals("")) {
        		String channel = request.getParameter("channel");
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
				}
//        		if(ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)
//	            	maxAmount = Double.parseDouble(ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim());
//	            if(ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)
//	            	minAmount = Double.parseDouble(ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim());
	            if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
	            	tamount = request.getParameter("posAmount").trim();
	                amount = Double.parseDouble(tamount);
	            }
	            if(amount >= minAmount) {
					if(amount > maxAmount)
						mssg = "Debes ingresar un monto de carga no mayor de " + intralotUtils.formatCurrency2(maxAmount) + ".";
					else {
			    		Client client = beanClientAccountBo.findClientById(idClientInt);
		                String firstname = client.getName();//dataClient.getNombre();
		                String lastname = client.getLastname() + " " + (client.getMaidenname()!=null?client.getMaidenname():"");//dataClient.getApPaterno() + " " + dataClient.getApMaterno();
		                String city = client.getRegion();//dataClient.getRegion();
		                String country = client.getCountry();//dataClient.getCountry();
		                String typeidNum = "1";
		                if(client.getDocType().equals("DNI"))//if (dataClient.getTypeId().equals("DNI"))
		                    typeidNum = "DNI";
		                else if(client.getDocType().equals("CAREX"))//else if (dataClient.getTypeId().equals("CAREX"))
		                    typeidNum = "NAN";
		                else if(client.getDocType().equals("PASAP"))//else if (dataClient.getTypeId().equals("PASAP"))
		                    typeidNum = "PAS";
		                String numberid = client.getDocNumber();//dataClient.getNumberId();
		                String email = client.getMail();//dataClient.getMail();
		                bono = request.getParameter("activ-bono");
		                wbbono = request.getParameter("activ-wbbono");
		                codePromotional = request.getParameter("codePromotional");
		                
		                LoggerApi.Log.info("/pagoEfectivo-portal_page: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey+" codePromotional=" +codePromotional);
		                Logger.getLogger(LoggerAPI.SALECARD).info("/pagoEfectivo-portal_page: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey+" codePromotional=" +codePromotional);
		                
		              //1. obtener token de autorizacion
		                NumberFormat formatter = new DecimalFormat("0.00");
		                String cashAmount = formatter.format(amount);
		                JsonObject jdata = new JsonObject();
		                jdata.addProperty("clientId", idClientInt);
//		                jdata.addProperty("sessionId", idSession);
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
		                
		                //2. generar cip
		                jdata.addProperty("token", convertedObject.getString("token"));
		                jdata.addProperty("transactionId", convertedObject.getString("transactionId"));
		                jdata.addProperty("fechaAutorizacion", convertedObject.getString("fechaAutorizacion"));
		                jdata.addProperty("fechaAutorizacionDb", convertedObject.getString("fechaAutorizacionDb"));
		                jdata.addProperty("fechaExpire", convertedObject.getString("fechaExpire"));
		                jdata.addProperty("userEmail", email);
		                jdata.addProperty("userName", firstname);
		                jdata.addProperty("userLastName", lastname);
//		                jdata.addProperty("ubigeo", dataClient);
		                jdata.addProperty("country", country);
		                jdata.addProperty("documentype", typeidNum);
		                jdata.addProperty("documentNumber", numberid);
		                jdata.addProperty("userPhone", client.getMobilePhone());
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
	            } else mssg = "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".";
	            	//request.setAttribute(WebConsts.ALERT_MSG, "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".");
            }
        	out.print(outData+" | "+mssg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        	try {intralotUtils.updateClientBalance(session,beanClientBalanceBo);} catch (Exception e) {}
        	LoggerApi.Log.info("-------------- END portal_page");
        }
    }
    
    private String requestWSPagoEfectivo(String json, String service) {
    	LoggerApi.Log.info("pagoEfectivoRequest: "+json);
		String jsonResponsePagoEfectivo="";
		try {
			String urlTransferPEAPI = ConnectionFactory.operationProperty("urlTransferPEAPI", Constantes.contextCardWeb);
			String userTransferPEAPI = ConnectionFactory.operationProperty("userTransferPEAPI", Constantes.contextCardWeb);
			String passTransferPEAPI = ConnectionFactory.operationProperty("passTransferPEAPI", Constantes.contextCardWeb);
			String credenciales = userTransferPEAPI+":"+passTransferPEAPI;
			credenciales = Base64.encodeBase64String(credenciales.getBytes());
 	    	URL url = new URL(urlTransferPEAPI+service);
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
 				LoggerApi.Log.info("API TRANSFERENCIA PAGOEEFECTIVO HTTP CODE: "+responseCode + " json: "+json);
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
	
    @RequestMapping(value = "/portal_page_rt")
    protected void portal_page_rt(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws ServletException, IOException {
    	LoggerApi.Log.info("-------------- START pagoEfectivo /portal_page_rt");
    	PrintWriter out = null;
    	response.setCharacterEncoding(Constantes.CHARSET_UTF8);
        out = response.getWriter();
		String rechargetoken=request.getHeader("rechargetoken");
		String ip=SecurityUtils.getClientIp(request);
		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
        String bono = "", wbbono = "", bonokey = "", cipUrl="";
        String idClient = "";
	    int idClientInt = 0;
	    double amount = 0, maxAmount = 0, minAmount = 0;
	    String tamount = "";
        try {
        	// Validación de token
			tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
			if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
				idClient = tokenValidation.getClientId();
	    		idClientInt = Integer.parseInt(idClient);
			
        	if(!idClient.equals("")) {
        		String channel = request.getParameter("channel");
				ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(idClientInt);
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
				tamount = (request.getParameter("posAmount")!=null)?request.getParameter("posAmount"):"";
				//Validar monto ingresado
				Boolean veryfyAmount= DoubleValidator.getInstance().isValid(tamount);
				if(!veryfyAmount) {			
					cipUrl="El monto ingresado es incorrecto";
					out.print(cipUrl);
					return;
				}
	            amount = Double.parseDouble(tamount);
	            if(amount >= minAmount) {
					if(amount > maxAmount)
						cipUrl = "Debes ingresar un monto de carga no mayor de " + intralotUtils.formatCurrency2(maxAmount) + ".";
					else {
						boolean isApproved = false;
						if(channel.trim().equals("PEFE")) {
						BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe = beanClientBalanceBo.resultEvalRulesPefe(idClientInt, amount);
						if(resultEvalRulesPefe.getResult().equals(Constantes.RESULT_OK)) {
								isApproved = true;
							}else {
								cipUrl = "|" + resultEvalRulesPefe.getMessage();
							}
						}else {
							isApproved = true;
						}
						if(isApproved) {
				    		Client client = beanClientAccountBo.findClientById(idClientInt);
			                String firstname = client.getName();//dataClient.getNombre();
			                String lastname = client.getLastname() + " " + (client.getMaidenname()!=null?client.getMaidenname():"");//dataClient.getApPaterno() + " " + dataClient.getApMaterno();
			                String city = client.getRegion();//dataClient.getRegion();
			                String country = client.getCountry();//dataClient.getCountry();
			                String typeidNum = "1";
			                if(client.getDocType().equals("DNI"))//if (dataClient.getTypeId().equals("DNI"))
			                    typeidNum = "DNI";
			                else if(client.getDocType().equals("CAREX"))//else if (dataClient.getTypeId().equals("CAREX"))
			                    typeidNum = "NAN";
			                else if(client.getDocType().equals("PASAP"))//else if (dataClient.getTypeId().equals("PASAP"))
			                    typeidNum = "PAS";
			                String numberid = client.getDocNumber();//dataClient.getNumberId();
			                String email = client.getMail();//dataClient.getMail();
			                
			                //validar activación de bono
				            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";
			                
			                bonokey = codePromotional;
			                
			                LoggerApi.Log.info(" codePromotional" +codePromotional + " idClientInt" + idClientInt);
			                
			                //1. obtener token de autorizacion
			                NumberFormat formatter = new DecimalFormat("0.00");
			                String cashAmount = formatter.format(amount);
			                JsonObject jdata = new JsonObject();
			                jdata.addProperty("clientId", idClientInt);
			                jdata.addProperty("amount", cashAmount);
			                jdata.addProperty("promotion", bonokey);
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
							String platform=Constantes.PLATAFORM;
							String operatorId=tokenValidation.getOperatorId();
							ClientProcedureOriginPefeRecharge originPefeRecharge = beanClientAccountBo.setOriginPefeRecharge(transactionId, platform, operatorId);
							if(!originPefeRecharge.getStatus().equals("OK")) {
								LoggerApi.Log.info("-------------- portal_page_rt"+" originPefeRecharge.getMessage=" +originPefeRecharge.getMessage());
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
			                jdata.addProperty("userPhone", client.getMobilePhone());
			                jdata.addProperty("userCodeCountry", "+51");
			                jdata.addProperty("channel", channel);
			                pagoEfectivoResponse=requestWSPagoEfectivo(jdata.toString(), "generatecip");
			                convertedObject = new JSONObject(pagoEfectivoResponse); 
			                message = convertedObject.getString("message");
			                if(!message.equals("OK")) {
			                	request.setAttribute(WebConsts.ALERT_MSG, "Ha ocurrido un error en el servidor. Vuelva a intentar en unos minutos");
			                    return;
			                }
			                cipUrl=convertedObject.getString("cipUrl");
	
						}
					}
	            } else {
	            	cipUrl = "|Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount) + ".";
	            }
	            
            }
        }else {
        	cipUrl = "|"+tokenValidation.getStatus();
        }
        	out.print(cipUrl);
        	
        } catch (Exception ex) {
            ex.printStackTrace();
		} finally {
			LoggerApi.Log.info("-------------- END pagoEfectivo /portal_page_rt cipUrl= "+cipUrl);
//			try {
//				intralotUtils.updateClientBalance(session, beanClientBalanceBo);
//			} catch (Exception e) {
//			}
		}
    }
    
}