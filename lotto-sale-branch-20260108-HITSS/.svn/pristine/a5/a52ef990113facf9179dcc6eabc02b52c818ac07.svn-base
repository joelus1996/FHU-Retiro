package pe.com.latinka.loto.layer.pam.cert;

import java.util.logging.Logger;

import static pe.com.intralot.loto.util.Constants.getPropertyContextSale;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientAddressLog;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.SmsProviderUtils;
import pe.com.intralot.loto.util.ApiClient;
import pe.com.intralot.loto.util.CasinoXpgUtils;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.MailLib;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.com.intralot.loto.layer.dto.pam.LoginDataBean;
import pe.com.intralot.loto.layer.dto.pam.LoginDataResponse;
import pe.com.intralot.loto.layer.dto.pam.SecurityTokenResponse;
import pe.com.intralot.loto.layer.model.bean.ResultBean;
import pe.com.intralot.loto.layer.model.bean.SmsResultBean;
import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetPlayerId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedurePutSmsRegisterData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientSecurityProcedureCheckIp;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureHasPendingNotificationsRead;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedurePasswordNotification;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Constantes;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.lib.LoggerApi;

/**
 * <p>
 * NOMBRE: PAMCertSecurityUtils.java
 * <br></p>
 * <p>
 * FUNCION: Utilitarios para el manejo de datos del inicio de sesión 
 * <br></p>
 * <p>
 * VERSION: 6295
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Disponibilidad de la activación del bono TA por recargas Interbank
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Repository("securityUtils")
public class PAMCertSecurityUtils {
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;

	@Autowired
    private ClientBo clientBo;
	
	@Autowired
	private ClientSaleBo clientSaleBo;
	
	@Autowired
	ServletContext context; 

	public ClientProcedureGetLoginData obtenerLogin(HttpServletRequest request, ClientSaleBo clientSaleBo) 
	throws Exception {

		ClientProcedureGetLoginData clientLoginData = null;
		JSONObject convertedObject=null;
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		boolean parameters = false;
		String typeDoc="B";
		LoginDataResponse responseLogin = null;
		SecurityTokenResponse securityTokenResponse = null;
		ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
		//Validar tipo de documento
		  if(request.getParameter("document-type")!=null && !request.getParameter("document-type").trim().equals("")) {
			  typeDoc=request.getParameter("document-type").trim();
		  }
		  if(request.getParameter("lg-document-type")!=null && !request.getParameter("lg-document-type").trim().equals("")) {
			  typeDoc=request.getParameter("lg-document-type").trim();
			  if(!request.getParameter("lg-document-type").trim().equals("DNI")){
				  session.setAttribute("typeDoc",typeDoc);
			  }
		  }
		  
		  if(session.getAttribute("typeDoc")!=null && !session.getAttribute("typeDoc").toString().trim().equals("") && !session.getAttribute("typeDoc").toString().trim().equals("DNI")) {
			  typeDoc=session.getAttribute("typeDoc").toString();
		  }
		
		//Validar usuario y contraseña
		String usr = request.getParameter("user-client");
		String pwd = request.getParameter("password-client");
		if(request.getAttribute("nuevoregistro")!=null && request.getAttribute("nuevoregistro").equals("true")) {
			  usr = request.getAttribute("pNumberId").toString();
		}else if(request.getParameter("lrdn")!=null && !request.getParameter("lrdn").equals("")){
			  String[] lrdn=StringLib.decodeLabel(request.getParameter("lrdn")).split("-");
			  usr = StringLib.decodeLabel(lrdn[0]).toLowerCase().trim();
			  pwd =StringLib.decodeLabel(lrdn[1]);
		  }
		String username = validarString(usr).toLowerCase().trim();
		
		String password = pwd;
		
		String documentType = typeDoc;
		
		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password))
			parameters = true;

		if (parameters) {//&& (captcha.equals(1) || captcha.equals(2))
			LoggerApi.Log.info("/common_login obtenerLogin username=" + username + " password=***");
			try {
				ClientAddressLog clientAddressLog = new ClientAddressLog();
				clientAddressLog.setCal_client_id(null);
				clientAddressLog.setCal_user(username);
				clientAddressLog.setCal_address("eCommerce Desktop");
				clientAddressLog.setCal_ip(request.getRemoteAddr());
				clientAddressLog.setCal_procedure("LOGIN");
				clientAddressLog.setCal_status("START");
				clientAddressLog.setCal_date(new Date());
				clientSaleBo.saveLoginLog(clientAddressLog);
			} catch (Exception e) {
				LoggerApi.severe(e);
			}
			int operatorId=(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").equals(""))?Integer.parseInt(session.getAttribute("operatorId").toString()):0;
        	if(operatorId==0) {
        		operatorId=Constants.OPERATOR_ID;
        	}
			JsonObject jdata = new JsonObject();
		      jdata.addProperty("documentNumber", username);
		      jdata.addProperty("documentType", documentType);
		      
    		  if(session.getAttribute("typeDoc")!=null && !session.getAttribute("typeDoc").toString().trim().equals("") && !session.getAttribute("typeDoc").toString().trim().equals("DNI")) {
    			  jdata.addProperty("documentType", session.getAttribute("typeDoc").toString());
			  }
		      
		      if(request.getParameter("document-type")!=null && !request.getParameter("document-type").trim().equals("")) {
				  jdata.addProperty("documentType", request.getParameter("document-type").trim() ); 
			  }
			  if(request.getParameter("lg-document-type")!=null && !request.getParameter("lg-document-type").trim().equals("")) {
				  jdata.addProperty("documentType", request.getParameter("lg-document-type").trim() ); 
			  }
			  
			  if(session.getAttribute("tipoDocumento")!=null && !session.getAttribute("tipoDocumento").toString().trim().equals("") && !session.getAttribute("tipoDocumento").toString().trim().equals("DNI")) {
				  jdata.addProperty("documentType", session.getAttribute("tipoDocumento").toString());
			  }
			  
		      jdata.addProperty("password",  password);
		      jdata.addProperty("playerIp", request.getLocalAddr());
		      jdata.addProperty("requestIp", "192.68.1.1"); // TODO : falta cambiar el request a request.getRemoteAddr()
		      jdata.addProperty("operatorId", Constants.OPERATOR_ID);
		      jdata.addProperty("platform", Constants.PLATAFORM);
		      
		      Map<String,String> headers = new HashMap<String,String>();
		      headers.put("X-Ip-Origin", "192.68.1.1");
		      headers.put("X-Company", "ECOM");
		      
	    	  String tokenIdentityResponse = ApiClient.post(getPropertyContextSale("urlIdentity"), jdata.toString(), "12345678", "12345678", headers);
		      securityTokenResponse = gson.fromJson(tokenIdentityResponse, SecurityTokenResponse.class);
			  
		      LoggerApi.Log.info("tokenIdentityResponse = "+securityTokenResponse.getToken());
		      
			  if (securityTokenResponse.getToken() != null && !securityTokenResponse.getToken().equals("")) {

				    String loginDataResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+securityTokenResponse.getToken(), "12345678", "12345678", headers);
					responseLogin = gson.fromJson(loginDataResponse, LoginDataResponse.class);
					LoggerApi.Log.info("loginDataResponse = "+loginDataResponse);
					
					// TODO : borrar esto
					/*
			jdata.addProperty("tipoDocumento", typeDoc);
			jdata.addProperty("numeroDocumento", username);
			jdata.addProperty("usuario", username);
			jdata.addProperty("password", password);
			jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
			jdata.addProperty("operatorId", operatorId);
			jdata.addProperty("platform", Constants.PLATAFORM);
			      
				    convertedObject = new JSONObject(requestPlayerWebApi(jdata.toString(), "login"));*/
			  }else {//nuevo
	      			session.removeAttribute("typeDoc");
	    	    	session.removeAttribute("tipoDocumento");
		}
	  
		      
		}
	  
		if(securityTokenResponse != null ) {
			if(responseLogin != null && responseLogin.getResult() != null) {
				clientLoginData = convertLoginDataBeanToClientProcedureGetLoginData(new ClientProcedureGetLoginData(),responseLogin.getResult());
				clientLoginData.setStatus("OK");
				session.setAttribute(Constants.CLT_SESSION, clientLoginData);
				
				//Parametro para cerrar sesion de TeApuesto en otro dispositivo
//				session.setAttribute("openSession","openSession");
				
				// verificar si tiene toda la data completa y pasarlo como atributo al jsp
				dataClient = clientSaleBo.findGetDataClient(clientLoginData.getSessionId(), clientLoginData.getClientId());
				LoggerApi.Log.info("clientLoginData.getClientId() " + clientLoginData.getClientId());
				
				JsonObject o = validarSessionUsuario(request, clientLoginData.getClientId(),clientLoginData.getMail());
				
				if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
					clientLoginData = new ClientProcedureGetLoginData();
					clientLoginData.setStatus("ERROR");
				    clientLoginData.setMessage("VALIDACION_DATOS");
				    return clientLoginData;
				}
				
				//agregar token de session
				LoggerApi.Log.info("Se incia captura de datos para cierre de session");
				JsonObject sessionData = new JsonObject();
				sessionData.addProperty("tokenSession", dataClient.getTokenSession());
				sessionData.addProperty("clientId", dataClient.getClientId());
				sessionData.addProperty("celular", dataClient.getMobilePhone());
				sessionData.addProperty("tipoDocumento", dataClient.getTypeId());
				sessionData.addProperty("numeroDocumento", dataClient.getNumberId());
				session.setAttribute("sessionData", sessionData.toString()); 
				LoggerApi.Log.info("Se finaliza captura de datos para cierre de session");
				
			}else if(securityTokenResponse.getError() != null) {
				clientLoginData = new ClientProcedureGetLoginData();
				clientLoginData.setStatus( securityTokenResponse.getError().getStatus() );
			    clientLoginData.setMessage( securityTokenResponse.getError().getResponseMessage() );
			    clientLoginData.setTitle( securityTokenResponse.getError().getResponseTitle() );
			    String button=securityTokenResponse.getError().getResponseButton();
			    clientLoginData.setButton(button);
			    if(button.equals("127")) {
			    	session.setAttribute("lrdn", StringLib.encodeLabel(StringLib.encodeLabel(usr)+"-"+StringLib.encodeLabel(pwd)));			    	
			    }else{
			    	session.removeAttribute("typeDoc");
			    	session.removeAttribute("tipoDocumento");
			    }
			    LoggerApi.Log.info("/SecurityUtils else mensaje="+securityTokenResponse.getError().getMessage() +" resp_message");			    
			}
		}else {
			LoggerApi.Log.info("/SecurityUtils else securityTokenResponse="+null);
		}
		
		return clientLoginData;
	}
	
	public ClientProcedureGetLoginData obtenerLoginSegCta(HttpServletRequest request, ClientSaleBo clientSaleBo) 
			throws Exception {

				ClientProcedureGetLoginData clientLoginData = null;
				JSONObject convertedObject=null;
				HttpSession session = request.getSession();
				ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();

				boolean parameters = false;
				String typeDoc="B";
				//Validar tipo de documento
				  if(request.getParameter("document-type")!=null && !request.getParameter("document-type").trim().equals("")) {
					  typeDoc=request.getParameter("document-type").trim();
				  }
				  if(request.getParameter("lg-document-type")!=null && !request.getParameter("lg-document-type").trim().equals("")) {
					  typeDoc=request.getParameter("lg-document-type").trim();
				  }
				
				//Validar usuario y contraseña
				String usr = request.getParameter("user-client");
				String pwd = request.getParameter("password-client");
				if(request.getAttribute("nuevoregistro")!=null && request.getAttribute("nuevoregistro").equals("true")) {
					  usr = request.getAttribute("pNumberId").toString();
				}else if(request.getParameter("lrdn")!=null && !request.getParameter("lrdn").equals("")){
					  String[] lrdn=StringLib.decodeLabel(request.getParameter("lrdn")).split("-");
					  usr = StringLib.decodeLabel(lrdn[0]).toLowerCase().trim();
					  pwd =StringLib.decodeLabel(lrdn[1]);
				  }
				String username = validarString(usr).toLowerCase().trim();
				
				String password = pwd;
				
				if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password))
					parameters = true;

				if (parameters) {//&& (captcha.equals(1) || captcha.equals(2))
					LoggerApi.Log.info("/common_login obtenerLogin username=" + username + " password=***");
					try {
						ClientAddressLog clientAddressLog = new ClientAddressLog();
						clientAddressLog.setCal_client_id(null);
						clientAddressLog.setCal_user(username);
						clientAddressLog.setCal_address("eCommerce Desktop");
						clientAddressLog.setCal_ip(request.getRemoteAddr());
						clientAddressLog.setCal_procedure("LOGIN");
						clientAddressLog.setCal_status("START");
						clientAddressLog.setCal_date(new Date());
						clientSaleBo.saveLoginLog(clientAddressLog);
					} catch (Exception e) {
						LoggerApi.severe(e);
					}
					int operatorId=(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").equals(""))?Integer.parseInt(session.getAttribute("operatorId").toString()):0;
		        	if(operatorId==0) {
		        		operatorId=Constants.OPERATOR_ID;
		        	}
					JsonObject jdata = new JsonObject();
					String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constants.contextPlayerWebApi);
		    		jdata.addProperty("token", tokenPlayerWebApi);
					jdata.addProperty("tipoDocumento", typeDoc);
					jdata.addProperty("numeroDocumento", username);
					jdata.addProperty("usuario", username);
					jdata.addProperty("password", password);
					jdata.addProperty("playerIp", ClientUtils.getClientIp(request));
					jdata.addProperty("operatorId", operatorId);
					jdata.addProperty("platform", Constants.PLATAFORM);
					convertedObject = new JSONObject(requestPlayerWebApi(jdata.toString(), "loginNew"));
				}
			  
				if(convertedObject!=null) {
					if(convertedObject.getString("estado").equals("OK")) {
						clientLoginData = clientSaleBo.getLoginData(convertedObject.getString("usuario"));
						clientLoginData.setStatus(convertedObject.getString("estado"));
						session.setAttribute(Constants.CLT_SESSION, clientLoginData); 
						
						//verificar vigencia de contraseña
						if(Integer.parseInt(convertedObject.getString("resp_button"))==145) {
							clientLoginData.setButton(convertedObject.getString("resp_button"));
							clientLoginData.setMessage(convertedObject.getString("resp_message"));
							clientLoginData.setTitle(convertedObject.getString("resp_title"));
							Integer clientId = clientLoginData.getClientId();
							PaymentPrizeProcedurePasswordNotification obj = paymentPrizeBo.passwordNotification(clientId);
			        		LoggerApi.Log.info("/SecurityUtils passwordNotification="+obj.getMessage());
						}
						
					    //////////LOGIN UNICA SESION
			//		    LoginDto dto = new LoginDto();
			//		    dto.setAccountId(clientProcedureLogin.getClientId().toString());
			//		    session.setAttribute("UserContext", dto);
					    //////////FIN LOGIN UNICA SESION
						//Parametro para cerrar sesion de TeApuesto en otro dispositivo
						session.setAttribute("openSession","openSession");
						
						// verificar si tiene toda la data completa y pasarlo como atributo al jsp
						dataClient = clientSaleBo.findGetDataClient(clientLoginData.getSessionId(), clientLoginData.getClientId());
						
						//agregar token de session
						LoggerApi.Log.info("Se incia captura de datos para cierre de session");
						JsonObject sessionData = new JsonObject();
						sessionData.addProperty("tokenSession", dataClient.getTokenSession());
						sessionData.addProperty("clientId", dataClient.getClientId());
						sessionData.addProperty("celular", dataClient.getMobilePhone());
						sessionData.addProperty("tipoDocumento", dataClient.getTypeId());
						sessionData.addProperty("numeroDocumento", dataClient.getNumberId());
						session.setAttribute("sessionData", sessionData.toString()); 
						LoggerApi.Log.info("Se finaliza captura de datos para cierre de session");
					} else {
						  clientLoginData = new ClientProcedureGetLoginData();
					      clientLoginData.setStatus(convertedObject.getString("estado"));
					      if(convertedObject.has("resp_message")) {
					    	  clientLoginData.setMessage(convertedObject.getString("resp_message"));
						      clientLoginData.setTitle(convertedObject.getString("resp_title"));
						      String button=convertedObject.getString("resp_button");
						      clientLoginData.setButton(button);
						      if(button.equals("127")) {			    	  
						    	  session.setAttribute("lrdn", StringLib.encodeLabel(StringLib.encodeLabel(usr)+"-"+StringLib.encodeLabel(pwd)));
						      }
					      }			      
						  LoggerApi.Log.info("/SecurityUtils else mensaje="+convertedObject.getString("mensaje") +" resp_message");
					  }
				} else {	
					  LoggerApi.Log.info("/SecurityUtils else convertedObject="+null);
				  }

				return clientLoginData;
			}
	
	public JsonObject validarUsuarioJson(ClientProcedureGetLoginData clientProcedureGetLoginData, Integer gameCode,
			HttpServletRequest request, ClientSaleBo clientSaleBo) throws Exception {
		 LoggerApi.Log.info("start ---------- validarUsuarioJson");
				Integer cid = clientProcedureGetLoginData.getClientId();
				String agreement = clientProcedureGetLoginData.getAgreement();
				String mverified = clientProcedureGetLoginData.getMailVerified();
				String phoneverified = clientProcedureGetLoginData.getMobileStatus()==null ? "DES" : clientProcedureGetLoginData.getMobileStatus();
				String username = clientProcedureGetLoginData.getUser();
				String promotion = "";//clientProcedureLogin.getPromotion();
				String promotionibk = "";//clientProcedureLogin.getPromotionibk();
				//String wbstatus = (clientProcedureLogin.getWbStatus()!=null && !clientProcedureLogin.getWbStatus().trim().equals(""))?clientProcedureLogin.getWbStatus().trim():"";
				  
				LoggerApi.Log.info("/common_login validarUsuarioJson cid=" + cid + " username=" + username 
									+ " agreement=" + agreement + " mverified=" + mverified + " mail=" + clientProcedureGetLoginData.getMail() + " phoneverified=" + phoneverified 
									+ " state=" + clientProcedureGetLoginData.getState()+" gameCode=" + gameCode);

				HttpSession session = request.getSession();

				UserBean userBean = getUserBeanFromLoginProcedure(clientProcedureGetLoginData, gameCode);
				  
				String mode = validarString(userBean.getpMode().toString());
				JsonObject o = new JsonObject();
				Double kironAmount = 0.0;
				boolean success = false;

				if (mode.equals("0") && !validarString(clientProcedureGetLoginData.getToday()).equals(""))
					kironAmount = Double.parseDouble(clientProcedureGetLoginData.getToday());

				userBean.setpUser(username);
				userBean.setpKironAmount(kironAmount);

				LoggerApi.Log.info("cid=" + cid + " Mode=" + mode);

				if (!mode.equals("0")) {
					o.addProperty("state", 999);
					o.addProperty("message", "Con esta cuenta no es posible ingresar a este sistema.");
				   
				} else {
					//System.out.println("gameCode="+gameCode);
					if (agreement == null || agreement.trim().equals("")) {
						o.addProperty("state", "TC");
						o.addProperty("message", "Por favor inf&oacute;rmese y confirme la aceptaci&oacute;n de los T&eacute;rminos y Condiciones.");
						//} else if (false) {
					//} else if (gameCode != 9 && Constants.flagValidacionSms.equals("true") && (phoneverified.equals("DES") || !ClientUtils.verifySintaxMobilePhone(clientProcedureLogin.getMobilePhone()))) {
					 } else if (Constants.flagValidacionSms.equals("true") && phoneverified.equals("DES") ) {
						 if ( ClientUtils.verifySintaxMobilePhone(clientProcedureGetLoginData.getMobilePhone()) ) {
		                     ResultBean beanResponseSendSms = putSmsClient(clientProcedureGetLoginData.getClientId(),clientProcedureGetLoginData.getMobilePhone(), clientSaleBo);
		                     o.addProperty("state", "AC");
		                     //o.addProperty("message", "<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span><p id='detailMessage' class='eml-p-text'>Ingresa el celular registrado en tu cuenta (Ejm: 999112233) o actual&iacute;zalo aqu&iacute;.<br/>Recibir&aacute;s un SMS con un c&oacute;digo de activaci&oacute;n.</p>");
		                     //o.addProperty("message", "<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span><p id='detailMessage' class='eml-p-text'>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.</p>");
		                     o.addProperty("message", "<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span><p id='detailMessage' class='eml-p-text'>Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.</p>");
		                     o.addProperty("phone", clientProcedureGetLoginData.getMobilePhone());
		                     if(clientProcedureGetLoginData.getMask_phone()==1 && clientProcedureGetLoginData.getRegister_incomplete()==1) {
		                    	 String phone=clientProcedureGetLoginData.getMobilePhone();
		                    	 phone = phone.substring(phone.length()-3, phone.length());
		                    	 phone = "*** *** "+phone;
		                    	 o.addProperty("phone", phone);
		                     }
		                     
		                     if(!beanResponseSendSms.getMessage().equals("")) o.addProperty("info", beanResponseSendSms.getMessage());
		                     /**
		                     * verificar si es un update o un registro 
		                      */
			              } else {
		                     o.addProperty("state", "AC");
		                     o.addProperty("message", "<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span><p id='detailMessage' class='eml-p-text'>Recibir&aacute;s un SMS con un c&oacute;digo de activaci&oacute;n.<br/><br/>Ingresa el celular registrado en tu cuenta o actual&iacute;zalo aqu&iacute;.</p>");
		                     //o.addProperty("message", "<span style='text-align:center;display:block;'><b>ACTIVA TU CUENTA</b></span><p id='detailMessage' class='eml-p-text'>Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.</p>");//--20181129
		                     o.addProperty("phone", "");
		                     /**
		                     * verificar si es un update o un registro 
		                      */
			              }
					} else if (Constants.flagValidacionMail.equals("true") && (mverified != null && mverified.equals("N"))) {
						if (mverified.equals("N")) {
							o.addProperty("state", "MV");
							o.addProperty("message", "Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta <b>"+username+"</b> ha sido registrado en otra cuenta.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico.");
							//o.addProperty("message", "Hola, hemos verificado que el correo electr&oacute;nico de la cuenta <b>" + username + "</b> ha sido registrado y activado en otra cuenta de usuario.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico");
						}
					} else if((gameCode == 1 || gameCode == 108 || gameCode == 5588) && Constants.flagRecargaInterbank.equals("true") && (promotionibk!=null && !promotionibk.equals(""))){
						o.addProperty("state", "IB");
						o.addProperty("message", promotionibk);
						
						if(promotionibk.contains("BONO DE BIENVENIDA")) {
							o.addProperty("wbMessage", 1);
						}else {
							o.addProperty("wbMessage", 0);
						}
						if(promotionibk.contains("BONO TE APUESTO")) {
							o.addProperty("taMessage", 1);
						}else {
							o.addProperty("taMessage", 0);
						}
					} else if((gameCode == 1 || gameCode == 108 || gameCode == 5588) && Constants.flagRecargaRedDigital.equals("true") && (promotion!=null && !promotion.equals(""))){
						o.addProperty("state", "RD");
						o.addProperty("message", promotion);
						
						if(promotion.contains("BONO DE BIENVENIDA")) {
							o.addProperty("wbMessage", 1);
						}else {
							o.addProperty("wbMessage", 0);
						}
						if(promotion.contains("BONO TE APUESTO")) {
							o.addProperty("taMessage", 1);
						}else {
							o.addProperty("taMessage", 0);
						}
					/*} else if(wbstatus.equals("Activo") && (Constants.welcameBonusUsers.contains(cid.toString())
			        			|| Constants.welcameBonusUsers.trim().equals("ALL-ALLOWED"))) {
						o.addProperty("state", "WB");
						o.addProperty("message", wbstatus);*/
					} else {

						String authToken = "0", lapollaToken = "0", tav2Token = "0";

						ClientProcedureTokenGeneration tokenGeneration = clientSaleBo.getToken(userBean.getpClientid(), "1", request.getRemoteAddr());
						if (tokenGeneration != null && tokenGeneration.getMessage().equals("OK")) {
							authToken = tokenGeneration.getIflexToken();
							userBean.setpToken(authToken);
							clientProcedureGetLoginData.setIflexToken(authToken);
						}
						
						ClientProcedureLPTokenGeneration lpTokenGeneration = clientSaleBo.getLPToken(userBean.getpClientid(), request.getRemoteAddr());
			          	if (lpTokenGeneration!=null && lpTokenGeneration.getMessage().equals("OK")) {
			          		lapollaToken = lpTokenGeneration.getLapollaToken();
			          		//userBean.setpLapollaToken(lapollaToken);
			          		clientProcedureGetLoginData.setLapollaToken(lapollaToken);
			          	}
			          	
			          	ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(userBean.getpClientid(), request.getRemoteAddr());
			          	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
			          		tav2Token = tanTokenGeneration.getTav2Token();
			          		//userBean.setpTav2Token(tav2Token);
			          		clientProcedureGetLoginData.setTav2Token(tav2Token);
			          	}
						
						success = true;
				    
						if(success) {
							session.setAttribute(Constants.USR_SESION, userBean); 
							session.setAttribute(Constants.CLT_SESSION, clientProcedureGetLoginData); 
						}
						ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(clientProcedureGetLoginData.getClientId());
						//System.out.println("WelcomeBonusStatus="+clientProcedureAccountData.getWelcomeBonusStatus()+" WelcomeBonusMessage="+clientProcedureAccountData.getWelcomeBonusMessage()+" WelcomeBonusPercentaje="+clientProcedureAccountData.getWelcomeBonusPercentaje()+" WelcomeBonusLastDate="+clientProcedureAccountData.getWelcomeBonusLastDate());
						clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
						if(StringUtils.isEmpty(clientProcedureAccountData.getBonusAmount().trim())) clientProcedureAccountData.setBonusAmount("0.00");
						int gameid = 0;
						String gameAmount = "", gameName = "", gameQuantity = "";
						String[] arrBonusGame = clientProcedureAccountData.getBonusGame().split("\\|");
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
						userBean.setpBilletera2(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getBonusAmount().replaceAll(",","."))));
						userBean.setpBilletera3(ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getOtherAmount().replaceAll(",","."))));
						userBean.setpBilletera3Cant(clientProcedureAccountData.getOtherQuantity());
						o.addProperty("billetera2", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getBonusAmount().replaceAll(",","."))));
						o.addProperty("billetera3", ClientUtils.formatCurrency(Double.parseDouble(clientProcedureAccountData.getOtherAmount().replaceAll(",","."))));
						o.addProperty("billetera3Cant", clientProcedureAccountData.getOtherQuantity());
						o.addProperty("state", "OK");
						o.addProperty("message", "OK");
						o.addProperty("username", username);
						String name=clientProcedureAccountData.getClientName();
						//Dar formato al nombre del cliente
						if(name!=null && !name.trim().equals("")) {
							//Primer nombre del cliente
							name=name.split(" ")[0];
							
							//Capitalize
							name=name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
							
						}
						o.addProperty("name", name);
						o.addProperty("amount", clientProcedureGetLoginData.getBalanceAmount());
						o.addProperty("idclient", clientProcedureGetLoginData.getClientId());
						o.addProperty("gameName", gameName);
						o.addProperty("gameAmount", gameAmount);
						o.addProperty("gameQuantity", gameQuantity);
						o.addProperty("otherAmount", clientProcedureAccountData.getOtherAmount());
						o.addProperty("otherQuantity", clientProcedureAccountData.getOtherQuantity());
						if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.lapollaOperatorId.toString().trim())) {
							o.addProperty("lapolla", Constants.lapollaGameProviderBaseUrl+" | "+ clientProcedureGetLoginData.getLapollaToken());
		                	Logger.getLogger(pe.com.intralot.loto.util.LoggerApi.LOGGERLAPOLLAAPI).info("================== client_lotocard_load_balances lapolla="+Constants.lapollaGameProviderBalanceUrl+ "clientid= "+clientProcedureGetLoginData.getClientId());
		    				session.removeAttribute("operatorId");
		    			}
		    			if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constants.tav2OperatorId.toString().trim())) {
		    				if(session.getAttribute("redirectGame") != null && session.getAttribute("redirectGame").toString().equals("DV"))
			        			o.addProperty("tav2", Constants.tav2GameProviderBaseUrl+" | "+clientProcedureGetLoginData.getTav2Token()+"&ref="+session.getAttribute("ref").toString());
			        	    else
			        		    o.addProperty("tav2", Constants.tav2GameProviderBaseUrl+" | "+ clientProcedureGetLoginData.getTav2Token());
		    				
		    				String paramSeccion = request.getParameter("seccion");
		    				if(paramSeccion==null || paramSeccion.trim().equals("")) {
		    					session.removeAttribute("operatorId");
		        				session.removeAttribute("redirectGame");
		         				session.removeAttribute("ref");
		    				}
		    				
		    			}
		    			o.addProperty("wbMessage", clientProcedureAccountData.getWelcomeBonusMessage());
		    			o.addProperty("wbMessagePor", clientProcedureAccountData.getWelcomeBonusMessagePor());
		    			o.addProperty("wbStatus", clientProcedureAccountData.getWelcomeBonusStatus());
						String result = new Gson().toJson(clientProcedureAccountData);
						session.setAttribute("clientBalance", result);
						o.addProperty("clientBalance", result);
						//System.out.println("o=["+o.toString()+"]");
						//if(wbstatus.equals("Activo") && (Constants.welcameBonusUsers.contains(cid.toString()) || Constants.welcameBonusUsers.trim().equals("ALL-ALLOWED"))) o.addProperty("message", wbstatus);
					}
					
					 LoggerApi.Log.info("END ---------- validarUsuarioJson");
				}

				return o;

	}
	
	public ResultBean putSmsClient(Integer p_clientId, String number, ClientSaleBo clientSaleBo) {
    	ResultBean bean = new ResultBean();
		String message = "Server Error [500]";
		Integer status = 500;
		String randomCode = "";
    	try {
    		SmsProviderUtils registerSms = new SmsProviderUtils();
        	randomCode = registerSms.generateRandomCode();
    		SmsResultBean result = registerSms.sendNetSMS(number,"LA TINKA. Tu codigo de activacion es "+randomCode+" ");
    		LoggerApi.Log.info("result="+result.toString());
    		if(result!=null && result.getCode() !=null && result.getCode()==200 && result.getStatus()==1) {
    			ClientProcedurePutSmsRegisterData domain = clientSaleBo.putSmsRegisterData(p_clientId, randomCode);
	        	if(domain.getState()==1) {
	        		message = "Hemos enviado un SMS con el c&oacute;digo para activar tu cuenta, revisa tu celular.";
	        		status= result.getCode();
	        	} else {
	        		message = domain.getMessage();
	        		status= domain.getState();
	        	}
    		} else {
    			message = "El c&oacute;digo de activaci&oacute;n no ha sido procesado. Intente ingresar a su cuenta m&aacute;s tarde.";//"Error al enviar el c&oacute;digo, int&eacute;ntelo m&aacute;s tarde.";  	
    		}
        } catch (Exception e) {
        	LoggerApi.Log.info(e.getMessage());
        }
		bean.setCode(randomCode);
		bean.setState(status);
		bean.setMessage(message);
		return bean;
    }
	
	@SuppressWarnings("unused")
	private Integer validarCaptcha(HttpServletRequest request) {

		LoggerApi.Log.info("Navigator=" + request.getParameter("user-browser"));
		LoggerApi.Log.info("UserAgent=" + request.getHeader("User-Agent"));

		HttpSession session = request.getSession();
		String capchaCode = validarString(request.getParameter("captcha-client"));
		Integer captcha = 0;
		if (capchaCode.equals("")) {
			LoggerApi.Log.info("/login LoginByUserPass sin captcha");
			captcha = 1;
		} else {
			String sessionCaptchaCode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if (capchaCode.equals(sessionCaptchaCode)) {
				Logger.getLogger(LoggerAPI.SALECARD).info("/login loginByUserPass con captcha");
				captcha = 2;
			}
		}
	  
		LoggerApi.Log.info("/common_login validarCaptcha captcha=" + captcha );
		return captcha;
		}
	
		public UserBean getUserBeanFromLoginProcedure(ClientProcedureGetLoginData clientProcedureGetLoginData, Integer gameCode) {

		  UserBean userBean = new UserBean();
		  userBean.setpSessionid(clientProcedureGetLoginData.getSessionId());
		  userBean.setpClientid(clientProcedureGetLoginData.getClientId());
		  userBean.setpNombre(clientProcedureGetLoginData.getCl_nombre());
		  userBean.setpMail(clientProcedureGetLoginData.getMail());
		  userBean.setpSessionCode(clientProcedureGetLoginData.getSessionCode());
		  userBean.setpStatus(clientProcedureGetLoginData.getStatus());
		  userBean.setpMode(Integer.parseInt(clientProcedureGetLoginData.getMode()));
		  userBean.setpAgreement(clientProcedureGetLoginData.getAgreement());
		  userBean.setpMailVerified(clientProcedureGetLoginData.getMailVerified());
		  userBean.setpMailStatus(clientProcedureGetLoginData.getMailStatus());
		  userBean.setpMobilePhone(clientProcedureGetLoginData.getMobilePhone());
		  userBean.setpMobileStatus(clientProcedureGetLoginData.getMobileStatus());
		  userBean.setpMonto(clientProcedureGetLoginData.getBalanceAmount());
		  userBean.setpGame(gameCode);

		  return userBean;
		  
	}
	
	private String validarString(String cadena) {
		if (StringUtils.isNotEmpty(cadena)) return cadena;
		else return "";
	}
	
	public boolean validarSessionDifferentUser() {
		return false;
	}
	
	public String requestPlayerWebApi(String json, String service) {
	 	String log="requestPlayerWebApi";
	 	log= log+" "+service;
//    	LoggerApi.Log.info("start "+ log+": "+json);
	 	LoggerApi.Log.info("start "+ log);
		String jsonResponsePlayerWebApi="";
		try {
			String urlPlayerWebApi = ConnectionFactory.operationProperty("urlPlayerWebApi", Constants.contextPlayerWebApi);
//			String secretIflexapiRecharge = ConnectionFactory.operationProperty("secretIflexapiRecharge", Constantes.contextPlayerWebApi);
			String userPlayerWebApi = ConnectionFactory.operationProperty("userPlayerWebApi", Constants.contextPlayerWebApi);
			String passPlayerWebApi = ConnectionFactory.operationProperty("passPlayerWebApi", Constants.contextPlayerWebApi);
			String credenciales = userPlayerWebApi+":"+passPlayerWebApi;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlPlayerWebApi+service);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
// 			con.setRequestProperty("Secret", secretIflexapiRecharge);
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
 				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode + " json: "+json);
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
 			JSONObject jresponse=new JSONObject(sb.toString());
 			jsonResponsePlayerWebApi =jresponse.getJSONObject("result").toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi + " json: "+json);	
 			}
 			buffer=null;
 			LoggerApi.Log.info(log+" Response: "+jsonResponsePlayerWebApi);
		} catch (Throwable e) {
			LoggerApi.severe(e);
		}finally {
//			LoggerApi.Log.info("end "+log+": "+jsonResponsePlayerWebApi);
			LoggerApi.Log.info("end "+log);
		}
		return jsonResponsePlayerWebApi;
	}
    
    public String requestPlayerWebApi2(String json, String service) {
	 	String log="requestPlayerWebApi2";
	 	log= log+" "+service;
//    	LoggerApi.Log.info("start "+ log+": "+json);
    	LoggerApi.Log.info("start "+ log);
		String jsonResponsePlayerWebApi="";
		try {
			String urlPlayerWebApi = ConnectionFactory.operationProperty("urlPlayerWebApi", Constants.contextPlayerWebApi);
			String userPlayerWebApi = ConnectionFactory.operationProperty("userPlayerWebApi", Constants.contextPlayerWebApi);
			String passPlayerWebApi = ConnectionFactory.operationProperty("passPlayerWebApi", Constants.contextPlayerWebApi);
			String credenciales = userPlayerWebApi+":"+passPlayerWebApi;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlPlayerWebApi+service);
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
 				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode + " json: "+json);
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
 			jsonResponsePlayerWebApi =sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
 				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi + " json: "+json);	
 			}
 			buffer=null;
 			LoggerApi.Log.info(log+" Response: "+jsonResponsePlayerWebApi);
		} catch (Throwable e) {
			LoggerApi.severe(e);
		}finally {
//			LoggerApi.Log.info("end "+log+": "+jsonResponsePlayerWebApi);
			LoggerApi.Log.info("end "+log);
		}
		return jsonResponsePlayerWebApi;
	}
	
	public void createSession(LoginDataBean clientLoginData, ClientSaleBo clientSaleBo, HttpSession session, String ip, HttpServletResponse response) throws Exception {
		try {
			
			JsonObject o = new JsonObject();
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			
			ClientAddressLog clientAddressLog = new ClientAddressLog();
			
			ClientProcedureGetLoginData clientProcedureLogin = new ClientProcedureGetLoginData(); 
			
			ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
			
			UserBean userBean = new UserBean();
			
			Client clientSession = new Client();
			
			clientAddressLog.setCal_client_id(null);
			clientAddressLog.setCal_user(clientLoginData.getUser());
			clientAddressLog.setCal_address("eCommerce Desktop");
			clientAddressLog.setCal_ip(ip);
			clientAddressLog.setCal_procedure("LOGIN");
			clientAddressLog.setCal_status("START");
			clientAddressLog.setCal_date(new Date());
			
			clientSaleBo.saveLoginLog(clientAddressLog);
			
			
			clientSession.setIdClient(clientLoginData.getClientId());
			clientSession.setName(clientLoginData.getClientName());
			clientSession.setLastname(clientLoginData.getLastName());
			clientSession.setMaidenname(clientLoginData.getMaternalLastName());
			clientSession.setMail(clientLoginData.getMail());
			clientSession.setDocNumber(clientLoginData.getDocumentNumber());
			clientSession.setDocType(clientLoginData.getDocumentType());
			
			session.setAttribute("name", clientSession.getName());
			session.setAttribute("lastname", clientSession.getLastname());
			session.setAttribute("maidenname", clientSession.getMaidenname());
			session.setAttribute("mail", clientSession.getMail());
			session.setAttribute("cid", clientSession.getIdClient());
			
			// falto mapear esta informacion
			session.setAttribute("email", clientSession.getMail());
			session.setAttribute("fullName", clientSession.getName());
			
			clientProcedureLogin = convertLoginDataBeanToClientProcedureGetLoginData(clientProcedureLogin,clientLoginData);
			
			LoggerApi.Log.info("Esta es el clientProcedureLogin " + clientProcedureLogin.toString());
 
			userBean.setpAgreement(clientLoginData.getAgreement());
			//userBean.setBalanceAmount(clientLoginData.getBalanceAmount());
			userBean.setpNombre(clientLoginData.getClientName());
			userBean.setpClientid(clientLoginData.getClientId());
			userBean.setpLuckyIcon(clientLoginData.getLuckyIcon());
			userBean.setpMail(clientLoginData.getMail());
			//userBean.setpMode(clientLoginData.getMailCode());
			userBean.setpMailStatus(clientLoginData.getMailStatus());
			userBean.setpMailVerified(clientLoginData.getMailVerified());
			userBean.setpMobilePhone(clientLoginData.getMobilePhone());
			userBean.setpMobileStatus(clientLoginData.getMobileSmsStatus());
			userBean.setpMode(Integer.parseInt(clientLoginData.getMode()));
			//userBean.setpNsessions(clientLoginData.getNumSessions());
			userBean.setpPromotion(clientLoginData.getPromotion());
			userBean.setpPromotionibk(clientLoginData.getPromotionIbk());
			userBean.setpSessionCode(clientLoginData.getSessionCode());
			userBean.setpSessionid(clientLoginData.getSessionId());
			userBean.setpStatus(clientLoginData.getState().toString());
			userBean.setpStatus(clientLoginData.getStatus());
			//userBean.setpToday(clientLoginData.getToday());
			userBean.setpUser(clientLoginData.getUser());
			
			
			// fatlo esto agregar
			ClientProcedureGetPlayerId dataPlayerId = clientSaleBo.findGetPlayerId(clientLoginData.getClientId());
        	if(dataPlayerId.getPlayerIdXpg() == null) {
        		CasinoXpgUtils u = new CasinoXpgUtils("createPlayer",clientLoginData.getClientId().toString(), clientSaleBo);            		
        		String playerId = u.processCreate();
        		try {
            		if(!playerId.isEmpty())
            			clientSaleBo.updatePlayerId(clientLoginData.getClientId(), playerId);
        		} catch (Exception e) {
                    LoggerApi.severe(e);	            
                }
        		
        	}
        	
        	// verificar si tiene toda la data completa y pasarlo como atributo al jsp
        	dataClient = clientSaleBo.findGetDataClient(clientLoginData.getSessionId(), clientLoginData.getClientId());
        	Integer isDataComplete = 1;
        	
			ClientProcedureGetDataClient clientS = new ClientProcedureGetDataClient();
	    	clientS.setClientId(clientLoginData.getClientId().toString());
	    	clientS.setNombre(dataClient.getNombre());
	    	clientS.setApPaterno(dataClient.getApPaterno());
	    	clientS.setApMaterno(dataClient.getApPaterno());
	    	clientS.setMail(clientLoginData.getMail());
	    	clientS.setNumberId(clientLoginData.getDocumentNumber());
	    	clientS.setTypeId(clientLoginData.getDocumentType());

			session.setAttribute("CLIENT_SESSION", clientS);
        	
			//agregar token de session
			LoggerApi.Log.info("Se incia captura de datos para cierre de session");
			JsonObject sessionData = new JsonObject();
			sessionData.addProperty("tokenSession", dataClient.getTokenSession());
			sessionData.addProperty("clientId", dataClient.getClientId());
			sessionData.addProperty("celular", dataClient.getMobilePhone());
			sessionData.addProperty("tipoDocumento", dataClient.getTypeId());
			sessionData.addProperty("numeroDocumento", dataClient.getNumberId());
			session.setAttribute("sessionData", sessionData.toString()); 
			LoggerApi.Log.info("Se finaliza captura de datos para cierre de session");
			        	
        	if( !dataClient.isDataComplete() ) isDataComplete = 0;
            
        	o.addProperty("isDataComplete", isDataComplete);
        	
        	out.print(o);
             	
			if (clientLoginData.getState().equals(new java.lang.Integer(1))) {
				clientProcedureLogin.setStatus("OK");
				session.setAttribute(Constants.CLT_SESSION, clientProcedureLogin); 
				session.setAttribute(Constants.CLIENT_SESION, clientProcedureLogin);
				session.setAttribute(Constants.USR_SESION, userBean);
				session.setAttribute("username", clientLoginData.getUser());
				//session.setAttribute("password", clientLoginData.getPassword()); --lo usa la polla
				session.setAttribute("clientId", clientLoginData.getClientId());
				LoggerApi.Log.info("Entre");
			}
			LoggerApi.Log.info("Esta es la sesion " + session.getAttribute(Constants.CLIENT_SESION));
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
	}
	
	public ClientProcedureGetLoginData convertLoginDataBeanToClientProcedureGetLoginData(ClientProcedureGetLoginData clientProcedureLogin,LoginDataBean clientLoginData) {
		clientProcedureLogin.setAgreement(clientLoginData.getAgreement());
		clientProcedureLogin.setBalanceAmount(clientLoginData.getBalanceAmount());
		clientProcedureLogin.setCl_nombre(clientLoginData.getClientName());
		clientProcedureLogin.setClientId(clientLoginData.getClientId());
		clientProcedureLogin.setLuckyIcon(clientLoginData.getLuckyIcon());
		clientProcedureLogin.setMail(clientLoginData.getMail());
		clientProcedureLogin.setMailCode(clientLoginData.getMailCode());
		clientProcedureLogin.setMailStatus(clientLoginData.getMailStatus());
		clientProcedureLogin.setMailVerified(clientLoginData.getMailVerified());
		clientProcedureLogin.setMobilePhone(clientLoginData.getMobilePhone());
		clientProcedureLogin.setMobileStatus(clientLoginData.getMobileSmsStatus());
		clientProcedureLogin.setMode(clientLoginData.getMode());
		clientProcedureLogin.setNsessions(clientLoginData.getNumSessions());
		clientProcedureLogin.setPromotion(clientLoginData.getPromotion());
		clientProcedureLogin.setPromotionibk(clientLoginData.getPromotionIbk());
		clientProcedureLogin.setSessionCode(clientLoginData.getSessionCode());
		clientProcedureLogin.setSessionId(clientLoginData.getSessionId());
		clientProcedureLogin.setState(clientLoginData.getState());
		clientProcedureLogin.setStatus(clientLoginData.getStatus());
		clientProcedureLogin.setToday(clientLoginData.getToday());
		clientProcedureLogin.setUser(clientLoginData.getUser());
		clientProcedureLogin.setMask_phone(Integer.parseInt(clientLoginData.getMaskPhone()));
		clientProcedureLogin.setRegister_incomplete(Integer.parseInt(clientLoginData.getRegisterIncomplete()));
		
		return clientProcedureLogin;
	}
	
	public String fetchTA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="fetchTA";
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		JsonObject o = new JsonObject();
		UserBean userBean = new UserBean();
		String url="";
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constants.USR_SESION)!=null) {
            	userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
//            	o.addProperty("message", "OK");
//                o.addProperty("redireccion", Constants.tav2GameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = clientSaleBo.getTANToken(userBean.getpClientid(), request.getRemoteAddr());
	          	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
//	          		o.addProperty("authToken", tanTokenGeneration.getTav2Token());
	          		String redireccion=Constants.tav2GameProviderBaseUrl;
	          		String authToken=tanTokenGeneration.getTav2Token();
	          		url = redireccion+"?authToken="+authToken;
//	     			HttpsURLConnection  con = (HttpsURLConnection )url.openConnection();
//	     			con.setRequestMethod("GET");
//	     			con.setDoOutput(true);
//	         		OutputStream os = con.getOutputStream();
//	     			os.write(json.getBytes(Constants.CHARSET_UTF8));
//	     			os.flush();
//	     			os.close();
//	     			BufferedReader br = null;
//	     			int responseCode = con.getResponseCode();
////	     			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
//	     				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constants.CHARSET_UTF8));
////	     			}else {
//	     				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode);
////	     				br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constants.CHARSET_UTF8));
////	     			}
//	     			StringBuilder sb = new StringBuilder();
//	     			char[] buffer = new char[1000];
//	     	        int leido;
//	     	        while ((leido = br.read(buffer)) > 0) {
//	     	        	sb.append(new String(buffer, 0, leido));
//	     	        }
//	     			br.close();
//	     			con.disconnect();
//	     			LoggerApi.Log.info(log+" Response: "+sb.toString());
////	     			jsonResponsePlayerWebApi =sb.toString();
////	     			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
////	     				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi + " json: "+json);	
////	     			}
//	     			buffer=null;
////	     			LoggerApi.Log.info(log+" Response: "+jsonResponsePlayerWebApi);
////	          		
////	          		fetch(d.redireccion+"?authToken="+d.authToken,"_parent")
	          	}
            } 
////            else {
////            	o.addProperty("message", "ON");
////                o.addProperty("redireccion", Constants.tav2GameProviderCloseUrl);
////            }
            return url;
        } catch (Exception e) {
            LoggerApi.severe(e);
            return url;
//            o.addProperty("message", "");
//            o.addProperty("redireccion", "");
        } finally {
//        	out.print(o);
        	LoggerApi.Log.info("end "+log);
        	
        }
    }
	
	public boolean validarSession(HttpServletRequest request, LoginDataBean clientLoginData, HttpServletResponse response) throws Exception {
	    try {
	        LoggerApi.Log.info("start ------------------ validarSession ");
	        
	        JsonObject o = new JsonObject();
			PrintWriter out = response.getWriter();
	        String ipUser = ClientUtils.getClientIp(request);
	        Integer client_id = clientLoginData.getClientId();
	        
	        try {
	        
	        LoggerApi.Log.info("Client ID: " + client_id + "Client IP: " + ipUser);
	        
	        Date fechaHoraActual = new Date();
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mma");
	        String fechaHoraFormateada = formato.format(fechaHoraActual).toLowerCase();
	        LoggerApi.Log.info("Formatted date and time: " + fechaHoraFormateada);
	        

	        ClientSecurityProcedureCheckIp result = clientSaleBo.findGetCheckIp(client_id, ipUser, "DESKTOP");
	        LoggerApi.Log.info("Check_ip status: " + result.getStatus());

	        String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constants.contextSale);
	        
	        String[] listaClientesProteccionUsuario = ConnectionFactory.operationProperty("listaClientesProteccionUsuario", Constants.contextSale).split(",");
	        
	        boolean flagCliente = false ;
	        
		    for (String clientePU : listaClientesProteccionUsuario) {
				if(String.valueOf(client_id).equals(clientePU)) {
					flagCliente=true;
					break;
				}
			}
			LoggerApi.Log.info("flagCliente: " + flagCliente);
			LoggerApi.Log.info("esActivoProteccionUsuario: " + esActivoProteccionUsuario);
	        if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true") && flagCliente) {
	        	
	        	if (result.getStatus().equals("ERROR_VALIDAR_IP") || result.getStatus().equals("OK_EMAIL") || result.getStatus().equals("OK") ) {
	        		
	    	        String esActivoCorreoProteccionUsuario = ConnectionFactory.operationProperty("esActivoCorreoProteccionUsuario", Constants.contextSale);
	    			LoggerApi.Log.info("esActivoCorreoProteccionUsuario: " + esActivoCorreoProteccionUsuario);	    		
	    	        if(esActivoCorreoProteccionUsuario!=null && esActivoCorreoProteccionUsuario.trim().equals("true")) {
			        	// Se manda un correo si la ip no existe en la lista blanca
			        	String resultSms = securitySendAlertMail(clientLoginData.getMail(), fechaHoraFormateada, client_id, ipUser);
		
			    		if (resultSms.equals("OK")) {
				        	LoggerApi.Log.info("CORREO PROTECCION USUARIO" );
			    			LoggerApi.Log.info("Correo enviado a: " + clientLoginData.getMail());
		
			    		} else {	
			    			LoggerApi.Log.info("status: " + result.getStatus() + "Error, no se logró enviar el correo de verificación de usuario: " + clientLoginData.getMail());
			    		}     		
	    	        }

		        /*} else if(result.getStatus().equals("OK_EMAIL")) {
		        	o.addProperty("status", result.getStatus());
		    		o.addProperty("titulo", result.getTitulo());
		    		o.addProperty("mensaje", result.getMensaje());
		        	LoggerApi.Log.info("No se ha enviado el correo y la ip sigue en estado pendiente");*/
		        	
		        } else if(result.getStatus().equals("ERROR_IP")) {
		        	/*Si la ip en la lista blanca tiene estado 3: desaprobado denegar acceso al usuario y mostrar un popup de alerta*/ 
		        	request.setAttribute("errorSession", "true");
		        	o.addProperty("status", result.getStatus());
		    		o.addProperty("titulo", result.getTitulo());
		    		o.addProperty("mensaje", result.getMensaje());
		    		LoggerApi.Log.info("Error, no puede iniciar session porque la ip esta desaprobada");
		    		return false;	    		
		    		
		        } else {
		        	o.addProperty("status", result.getStatus());
		    		o.addProperty("titulo", result.getTitulo());
		    		o.addProperty("mensaje", result.getMensaje());
		        	LoggerApi.Log.info("Ocurrió un incidente inesperado. Por favor, intente nuevamente." + "status=" +  result.getStatus());
		        } 
		        
	        }
		        
		    	out.print(o);
		    	
	        } catch (Exception e) {			
				//LoggerApi.severe(e, client_id);
				
	    		o.addProperty("status", "ERROR");
	    		o.addProperty("titulo", "Ha ocurrido un incidente en el servicio");
	    		o.addProperty("mensaje","Por favor realice la acci&oacute;n nuevamente.");
	    		
				out.print(o);
			}

	        LoggerApi.Log.info("End ------------------ validarSession ");
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	    }
	    
	    return true;
	}

	/*Permite validar si la ip del usuario esta registrado en la lista blanca con estado 1:pediente 2:aprobado 3:denegado*/
	public JsonObject validarSessionUsuario(HttpServletRequest request, Integer clientId, String mail) throws Exception {
	    JsonObject o = new JsonObject();
		
		try {
	        LoggerApi.Log.info("start ------------------ validarSession ");
	        
	        String ipUser = ClientUtils.getClientIp(request);
	        Integer client_id =  clientId;
	        
	        try {
	        
	        LoggerApi.Log.info("Client ID: " + client_id + "Client IP: " + ipUser);
	        
	        Date fechaHoraActual = new Date();
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mma");
	        String fechaHoraFormateada = formato.format(fechaHoraActual).toLowerCase();
	        LoggerApi.Log.info("Formatted date and time: " + fechaHoraFormateada);
	        

	        ClientSecurityProcedureCheckIp result = clientSaleBo.findGetCheckIp(client_id, ipUser, "DESKTOP");
	        LoggerApi.Log.info("Check IP status: " + result.getStatus());
	        
	        String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constants.contextSale);
	        
	        String[] listaClientesProteccionUsuario = ConnectionFactory.operationProperty("listaClientesProteccionUsuario", Constants.contextSale).split(",");
	        
		        boolean flagCliente = false ;
		        
			    for (String clientePU : listaClientesProteccionUsuario) {
					if(String.valueOf(client_id).equals(clientePU)) {
						flagCliente=true;
						break;
					}
				}
				LoggerApi.Log.info("flagCliente: " + flagCliente);
				LoggerApi.Log.info("esActivoProteccionUsuario: " + esActivoProteccionUsuario);
		        if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true") && flagCliente) {
		        	
		        	if (result.getStatus().equals("ERROR_VALIDAR_IP") || result.getStatus().equals("OK_EMAIL") || result.getStatus().equals("OK")) {
		        		
		    	        String esActivoCorreoProteccionUsuario = ConnectionFactory.operationProperty("esActivoCorreoProteccionUsuario", Constants.contextSale);
		    	        
		    			LoggerApi.Log.info("esActivoCorreoProteccionUsuario: " + esActivoCorreoProteccionUsuario);			    	        
		    	        if(esActivoCorreoProteccionUsuario!=null && esActivoCorreoProteccionUsuario.trim().equals("true")) {
				        	// Se manda un correo si la ip no existe en la lista blanca y se registra con estado 1:Pendiente
				        	String resultSms = securitySendAlertMail(mail, fechaHoraFormateada, client_id, ipUser);
			
				    		if (resultSms.equals("OK")) {
					         	LoggerApi.Log.info("CORREO PROTECCION USUARIO" );
				    			LoggerApi.Log.info("Correo enviado a: " + mail);
			
				    		} else {	
				    			LoggerApi.Log.info("status: " + result.getStatus() + "Error, no se logró enviar el correo de verificación de usuario: " + mail);
				    		}		    	        	
		    	        }

		    	      /*}  else if(result.getStatus().equals("OK_EMAIL")) {
			        	o.addProperty("status", result.getStatus());
			    		o.addProperty("titulo", result.getTitulo());
			    		o.addProperty("mensaje", result.getMensaje());
			        	LoggerApi.Log.info("No se ha enviado el correo y la ip sigue en estado pendiente");*/
			        	
			        } else if(result.getStatus().equals("ERROR_IP")) {
			        	/*Si la ip en la lista blanca tiene estado 3: desaprobado denegar acceso al usuario y mostrar un popup de alerta*/ 
			        	request.setAttribute("errorSession", "true");
			        	o.addProperty("status", result.getStatus());
			    		o.addProperty("titulo", result.getTitulo());
			    		o.addProperty("mensaje", result.getMensaje());
			    		o.addProperty("state", "OK");  
			    		
			    		LoggerApi.Log.info("Error, no puede iniciar session porque la ip esta desaprobada");   	
	
			        } else { 
			        	o.addProperty("status", result.getStatus());
			    		o.addProperty("titulo", result.getTitulo());
			    		o.addProperty("mensaje", result.getMensaje());
			        	LoggerApi.Log.info("Ocurrió un incidente inesperado. Por favor, intente nuevamente." + "status=" +  result.getStatus());
			        }
		        }
		        
	        } catch (Exception e) {			
				//LoggerApi.severe(e, client_id);
	    		o.addProperty("status", "ERROR");
	    		o.addProperty("titulo", "Ha ocurrido un incidente en el servicio");
	    		o.addProperty("mensaje","Por favor realice la acci&oacute;n nuevamente.");    		
			}

	        LoggerApi.Log.info("End ------------------ validarSession ");
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	    }
		return o;
	}
	
	
	public String securitySendAlertMail(String email, String date, Integer client_id, String ip) throws Exception {

		String client_id_encript = StringLib.encodeLabel(String.valueOf(client_id));
		String ip_encript = StringLib.encodeLabel(ip);
		//String respuesta_si = StringLib.encodeLabel("SI");
		String respuesta_no = StringLib.encodeLabel("NO");
		
        StringBuffer mailBodyPass = new StringBuffer();
        String mailSender = email;
        String mailSubject = "Nuevo inicio de sesión";
        String mailBody = "";
        String result = "";
        
        String baseUrl = ConnectionFactory.operationProperty("url_respuesta_lista_blanca", Constants.contextSale);
        
        //String urlBotonSi = baseUrl + "?param1=" + client_id_encript + "&param2=" + ip_encript + "&param3=" + respuesta_si;
        //String urlBotonNo = baseUrl + "?param1=" + client_id_encript + "&param2=" + ip_encript + "&param3=" + respuesta_no;
        
        String urlBotonNo = ConnectionFactory.operationProperty("url_restablecer_contrasenia", Constants.contextSale);
        
        String titulo = "Nuevo inicio de sesi&oacute;n";
        String mensaje= "Por tu seguridad te reportaremos todos los inicios de sesi&oacute;n a tu Cuenta Virtual. Si no has sido t&uacute;, te recomendamos cambiar tu contrase&ntilde;a.";
        String mensaje_final = "&Eacute;ste es un correo generado autom&aacute;ticamente. Tiene car&aacute;cter confidencial y solo puede ser utilizada por la persona a quien ha sido redirigida";
        //String si ="S&iacute;, he sido yo";
        String no = "Cambiar mi contrase&ntilde;a";
        
        mailBodyPass.append(    		   
                "<html>            "+
                        "<head>            "+
                        "<title>La Tinka - Autorizaci&oacute;n de retiro</title>            "+
                        "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>            "+
                        "</head>            "+
                        "<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>            "+
                        "            "+
                        "<table width='600' height='365' bgcolor='#FFFFFF'  align='center' border='0' cellpadding='0' cellspacing='0'>            "+
                        "	<tr>            "+
                        "		<td rowspan='2' bgcolor='#ffe510' width='65' height='106' alt=''></td>            "+
                        "		<td colspan='3' bgcolor='#ffe510' width='470' height='53' alt=''></td>            "+
                        "		<td rowspan='2' bgcolor='#ffe510' width='65' height='106' alt=''></td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "		<td colspan='3'>            "+
                        "<img src='cid:logoimg' width='470' height='53' alt='LA TINKA' style='display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;'>" +
                        "	</tr>            "+
                        "	<tr>            "+
                        "		<td rowspan='7' bgcolor='#dedede'  width='65' height='283' alt=''></td>            "+
                        "		<td colspan='3' bgcolor='#ffffff' width='470' height='38' alt=''></td>            "+
                        "		<td rowspan='7' bgcolor='#dedede'  width='65' height='283' alt=''></td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "		<td colspan='3' bgcolor='#ffffff' width='470' height='63' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;'><strong>"+titulo+"</strong></td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "       <td colspan='3' bgcolor='#ffffff' width='470' height='33' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:16px;font-weight: bold;'>" + date + "</td>" +
                        "		</td>            "+
                        "		<td width='24' height='33'></td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "<td bgcolor='#ffffff' colspan='3' width='470' height='70' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px; padding: 0 15px 0px 15px; margin: 0;'>" + mensaje + "</strong><br></td>" +
                        "	</tr>            "+
                        "	<tr>            "+
                        "<td colspan='3' bgcolor='#ffffff' width='470' height='33' style='text-align: center;'>" +
                        "<!--[if mso]>" +
                        "<v:roundrect xmlns:v='urn:schemas-microsoft-com:vml' xmlns:w='urn:schemas-microsoft-com:office:word' href='" + urlBotonNo + "' style='height:40px;v-text-anchor:middle;width:300px;' arcsize='10%' strokecolor='#e30613' fill='false'>" +
                            "<w:anchorlock/>" +
                            "<center style='color:#e30613;font-family:sans-serif;font-size:13px;font-weight:bold;'>"+no+"</center>" +
                        "</v:roundrect>" +
                        "<![endif]-->" +
                        "<!--[if !mso]><!-- -->" +
                        "<a href='" + urlBotonNo + "' style='display: inline-block; padding: 9px 99.9px; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size: 13px; text-decoration: none; border: 2px solid #e30613; color: #e30613;border-radius: 4px;'>"+no+"</a>" +
                        "<!--<![endif]-->" +
                    "</td>" +
                        "		<td width='24' height='33'></td>            "+
                        "   </td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "		<td colspan='3'bgcolor='#ffffff' width='470' height='49' alt=''></td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "		<td colspan='3'bgcolor='#dedede' width='470' height='76' alt='' style='color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'>"+mensaje_final+"</td>            "+
                        "	</tr>            "+
                        "	<tr>            "+
                        "		<td colspan='5' bgcolor='#dedede'>            "+
                        "<img src='cid:juegosimg' width='600' height='118' alt='Tinka - Te Apuesto - Casino - GanaYá - Virtuales - Ganagol - Kábala - Gana Diario - Kinelo' style='display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;'>" +
                        "	</tr>            "+
                        "	<tr>            "+
                        "	</tr>            "+
                        "</table>            "+
                        "</body>            "
                );


            // Convierte el cuerpo del correo a cadena
            mailBody = mailBodyPass.toString();
        try {

        	result = MailLib.sendValidMailEco_Security(ConnectionFactory.operationProperty("mailSourceApp", Constants.contextSale),mailSender, mailSubject, mailBody,context.getRealPath(Constants.INTERNAL_PATH_LOGO_MAIL), context.getRealPath(Constants.INTERNAL_PATH_LOGOS_JUEGOS_MAIL),ConnectionFactory.operationProperty("servidorCorreoProteccionUsuario", Constants.contextSale) );
        } catch (Exception e) {
            LoggerApi.severe(e);
            result = e.getMessage();
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
        
    }

}
