package pe.com.intralot.loto.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.controller.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.pam.LoginDataBean;
import pe.com.intralot.loto.layer.dto.pam.LoginDataResponse;
import pe.com.intralot.loto.layer.model.bean.ResultBean;
import pe.com.intralot.loto.layer.model.bean.SmsResultBean;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientAddressLog;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutSmsRegisterData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientSecurityProcedureCheckIp;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedurePasswordNotification;
import pe.com.intralot.loto.layer.model.pojo.TYCPDPProcedureConsultPendingDocuments;
import pe.com.intralot.loto.layer.model.pojo.TYCPDPProcedureConsultPendingDocumentsTemplate;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.SmsProviderUtils;

/**
 * <p>
 * NOMBRE: SecurityUtils.java
 * <br></p>
 * <p>
 * FUNCION: Utilitarios de inicio e sesión 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Depuración de comentarios
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Repository("securityUtils")
public class SecurityUtils {
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;	
	
	@Autowired
	IntralotUtils intralotUtils;

	@Autowired
    private ClientSaleBo clientSaleBo;
	
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;

	@Autowired
	ServletContext context; 

	public ResultBean putSmsClient(Integer p_clientId,String number,SecurityLoginBo beanSecurityLoginBo) {
    	ResultBean bean = new ResultBean();
		String message = "Server Error [500]";
		Integer status = 500;
		String randomCode = "";
    	try {
        	SmsProviderUtils registerSms = new SmsProviderUtils();//new SmsProviderUtils(Constantes.contextSaleSms, Constantes.contextSaleSmsRegister);
        	randomCode = registerSms.generateRandomCode();
    		SmsResultBean result = registerSms.sendNetSMS(number,"LA TINKA. Tu codigo de activacion es "+randomCode+" ");
    		LoggerApi.Log.info("result="+result.toString());
    		if(result!=null && result.getCode() !=null && result.getCode()==200 && result.getStatus()==1) {
    			ClientProcedurePutSmsRegisterData domain = beanSecurityLoginBo.putSmsRegisterData(p_clientId, randomCode);
	        	if(domain.getState()==1) {
	        		message = "Hemos enviado un c&oacute;digo para activar tu cuenta, revisa tu celular.";
	        		status= result.getCode();
	        	} else {
	        		message = domain.getMessage();
	        		status= domain.getState();
	        	}
    		} else {
    			message = "El c&oacute;digo de activaci&oacute;n no ha sido procesado. Intenta ingresar a tu cuenta m&aacute;s tarde.";
    		}
        } catch (Exception e) {
        	LoggerApi.Log.info(e.getMessage());
        }
		bean.setCode(randomCode);
		bean.setState(status);
		bean.setMessage(message);
		return bean;
    }
	
	public ResultBean putWaClient(Integer p_clientId, String number, SecurityLoginBo beanSecurityLoginBo) {
    	ResultBean bean = new ResultBean();
		String message = "Server Error [500]";
		Integer status = 500;
		String randomCode = "";
    	try {
    		SmsProviderUtils registerWa = new SmsProviderUtils();
        	randomCode = registerWa.generateRandomCode();
    		SmsResultBean result = registerWa.sendNetWa(number,"LA TINKA. Tu codigo de activacion es "+randomCode+" ");
    		LoggerApi.Log.info("result="+result.toString());
    		if(result!=null && result.getCode() !=null && result.getCode()==200 && result.getStatus()==1) {
    			ClientProcedurePutSmsRegisterData domain = beanSecurityLoginBo.putSmsRegisterData(p_clientId, randomCode);
	        	if(domain.getState()==1) {
	        		message = "Hemos enviado un c&oacute;digo para activar tu cuenta, revisa tu celular.";
	        		status= result.getCode();
	        	} else {
	        		message = domain.getMessage();
	        		status= domain.getState();
	        	}
    		} else {
    			message = "El c&oacute;digo de activaci&oacute;n no ha sido procesado. Intenta ingresar a tu cuenta m&aacute;s tarde."; 	
    		}
        } catch (Exception e) {
        	LoggerApi.Log.info(e.getMessage());
        }
		bean.setCode(randomCode);
		bean.setState(status);
		bean.setMessage(message);
		return bean;
    }
	
	public ClientProcedureGetLoginData obtenerLogin(HttpServletRequest request,IntralotUtils intralotUtils,ClientAccountBo beanClientAccountBo) 
			 throws Exception {

	  ClientProcedureGetLoginData clientLoginData = null;
	  JSONObject convertedObject=null;

	  boolean parameters = false;
	  String username = "", password = "", usr = "", pwd = "", typeDoc= "B";
	  
	  HttpSession session = request.getSession();
	  
	  ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
	  
	  //Validar tipo de documento
	  if(request.getParameter("typeDoc")!=null && !request.getParameter("typeDoc").trim().equals("")) {
		  typeDoc=request.getParameter("typeDoc").trim();
	  }
			  
	  //Validar usuario
	  usr = request.getParameter("user");	  
	  if(request.getAttribute("nuevoregistro")!=null && request.getAttribute("nuevoregistro").equals("true")) {
		  usr = request.getAttribute("pNumberId").toString();
	  }
//	  else if(session.getAttribute("user127")!=null && !session.getAttribute("user127").toString().equals("")){
//		  usr = session.getAttribute("user127").toString();
//		  session.removeAttribute("user127");
//	  }
	  

	  //validar contraseña
	  if (StringUtils.isNotEmpty(usr) && StringUtils.isNotEmpty(request.getParameter("password"))) {
		  usr = usr.toLowerCase().trim();
		  pwd = request.getParameter("password");
		  username = intralotUtils.validarString(usr);
		  password = intralotUtils.validarString(pwd);
	  } else if(request.getParameter("lrdn")!=null && !request.getParameter("lrdn").equals("")){
		  String[] lrdn=intralotUtils.decodeLabel(request.getParameter("lrdn")).split("-");
		  usr = intralotUtils.decodeLabel(lrdn[0]).toLowerCase().trim();
		  pwd =intralotUtils.decodeLabel(lrdn[1]);
		  username = intralotUtils.validarString(usr);
		  password = intralotUtils.validarString(pwd);
	  }else {
	      //LoggerApi.Log.info("/SecurityUtils request.getParameter(user)=" + request.getParameter("user"));
	      //LoggerApi.Log.info("/SecurityUtils StringUtils.isNotEmpty(request.getParameter(password))=" + StringUtils.isNotEmpty(request.getParameter("password")) );
	  }
	
	  if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password))
	   parameters = true;

	  if (parameters) {
	      //LoggerApi.Log.info("/SecurityUtils obtenerLogin username=" + username + " password=***");
		  try {
				ClientAddressLog clientAddressLog = new ClientAddressLog();
				clientAddressLog.setCal_client_id(null);
				clientAddressLog.setCal_user(username);
				clientAddressLog.setCal_address("eCommerce Mobile");
				clientAddressLog.setCal_ip(request.getRemoteAddr());
				clientAddressLog.setCal_procedure("LOGIN");
				clientAddressLog.setCal_status("START");
				clientAddressLog.setCal_date(new Date());
				beanClientAccountBo.saveLoginLog(clientAddressLog);
			} catch (Exception e) {
				LoggerApi.severe(e);
			}
	      
		  int operatorId=(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").equals(""))?Integer.parseInt(session.getAttribute("operatorId").toString()):0;
	      if(operatorId==0) {
	      		operatorId=Constantes.OPERATOR_ID;
	      }
	      JsonObject jdata = new JsonObject();
	      String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
  		  jdata.addProperty("token", tokenPlayerWebApi);
  		  jdata.addProperty("transaccionId", "");
	      jdata.addProperty("tipoDocumento", typeDoc);
	      jdata.addProperty("numeroDocumento", username);
	      jdata.addProperty("usuario", username);
	      jdata.addProperty("password", password);
	      jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	      jdata.addProperty("operatorId", operatorId);
	      jdata.addProperty("platform", Constantes.PLATAFORM);
	      convertedObject = new JSONObject(requestPlayerWebApi(jdata.toString(), "loginNew"));
	      
	      
	  } else {
		  LoggerApi.Log.info("/SecurityUtils parameters="+parameters+ " username="+username+" StringUtils.isNotEmpty(password)="+StringUtils.isNotEmpty(password));
	  }
	  
	  if(convertedObject!=null) {
		  if(convertedObject.getString("estado").equals("OK")) {
			  clientLoginData = beanClientAccountBo.getLoginData(convertedObject.getString("usuario"));
		      clientLoginData.setStatus(convertedObject.getString("estado"));
//			  HttpSession session = request.getSession();
			  session.setAttribute(Constantes.CLIENT_SESION, clientLoginData);	
			  session.setAttribute("cl_nombre", clientLoginData.getCl_nombre());
			  
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
//  			  LoginDto dto = new LoginDto();
//			  dto.setAccountId(clientProcedureLogin.getClientId().toString());
//			  session.setAttribute("UserContext", dto);
			  //////////FIN LOGIN UNICA SESION
				
				//Parametro para cerrar sesion de TeApuesto en otro dispositivo
				session.setAttribute("openSession","openSession");
				
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
				

		  } else {
			  clientLoginData = new ClientProcedureGetLoginData();
		      clientLoginData.setStatus(convertedObject.getString("estado"));
		      if(convertedObject.has("resp_message")) {
		    	  clientLoginData.setMessage(convertedObject.getString("resp_message"));
			      clientLoginData.setTitle(convertedObject.getString("resp_title"));
			      String button=convertedObject.getString("resp_button");
			      clientLoginData.setButton(button);
			      if(button.equals("127")) {
			    	  session.setAttribute("lrdn", intralotUtils.encrypt(intralotUtils.encrypt(usr)+"-"+intralotUtils.encrypt(pwd)));
			      }
		      }else {
		    	  clientLoginData.setTitle("Datos incorrectos");
		    	  clientLoginData.setMessage("Uno de tus datos es incorrecto o no existe. Revisa si digitaste correctamente y vuelve a intentarlo");
		        	
		      }
		      
			  LoggerApi.Log.info("/SecurityUtils else mensaje="+convertedObject.getString("mensaje") +" resp_message");
		  }
	  } else {	
		  LoggerApi.Log.info("/SecurityUtils else convertedObject="+null);
	  }
	  
	  return clientLoginData;
	 }
	
	public String htmlMailValidationAccount(ClientProcedureGetLoginData client) {
		String content = "<h2>ACTUALIZA TU CORREO</h2><p><b>Hola, hemos verificado que el correo electr&oacute;nico de la cuenta <b>"+client.getUser()+"</b> ha sido registrado en otra cuenta.<br/></b></p><p> Registra aqu&iacute; un nuevo correo electr&oacute;nico.</p>";
    	return  "<div class='content-modal has-action over-visible'>" +content+
				"			<form class='form-register' action='send_user_mail_verify_account.html' method='post' id='frm-user-send-verify-account' data-response-type='json'>" +
				"				<div class='control-form'>" +
				"					<input class='control-custom' type='email' id='email-usr' name='email-usr' autocomplete='off' placeholder='Ingresa tu correo' style='background-color: rgba(0, 0, 0, 0.4);' required />" +
				"				</div>" +
				"		   	 	<div class='error' id='alertVerify'></div>" +
				"		   	 	<div class='ok' id='alertNotify'></div>" +
				"				<div class='control-form'><i></i>" +
				"					<button id='btn-send-user-verify-account' class='js-close-modal btn btn-orange white' type='button'>ENVIAR</button>" +
				"				</div>" +
				"			</form><br/>" +
				"</div>";
	}
    
    public String htmlSmsValidationAccount(ClientProcedureGetLoginData client) {
    	String content = "<h2>ACTIVA TU CUENTA</h2><p id='detailMessage'>Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.</p>";
    	if(client.getMask_phone()==1 && client.getRegister_incomplete()==1) {
        	 String phone=((client.getMobilePhone()!=null && !client.getMobilePhone().trim().equals(""))?client.getMobilePhone().trim():" ");
        	 phone = phone.substring(phone.length()-3, phone.length());
        	 phone = "*** *** "+phone;
        	 return  "<div class='content-modal has-action over-visible'>" +content+ 
         			"			<br/><form class='form-register' method='post' id='frm-user-active-sms' data-response-type='jsonp'>" +
         			"					<div id='containerSendSms' class='hide'>"+
         			"					<div class='control-form'>" +
         			"						<input class='control-custom input-custom' type='text' id='telf-sms' name='telf-sms' autocomplete='off' placeholder='Ingresa tu celular'  required disabled value='"+phone+"'/>" +
         			"					</div>" +
         			"		   	 		<div class='error' id='alertTelfVerify1'></div>" +
         			"		   	 		<div class='ok' id='alertTelfNotify'></div>" +
         			"					<div class='control-form'><i></i>" +
         			"						<button id='btn-send-sms-validation' class='js-close-modal btn btn-orange white' type='button'>ENVIAR SMS</button><br>" +
         			"					</div><button id='lnkActiveCode' class='js-close-modal btn btn-orange white'>YA TENGO CÓDIGO DE ACTIVACIÓN</button>" +
         			"				</div><div id='containerSendCode' class='hide'>"+
         			"					<div class='control-form'>" +
         			"						<input class='control-custom input-custom' type='number' id='send-code' name='send-code' autocomplete='off' placeholder='Digita el c&oacute;digo'  required />" +
         			"					</div>" +
         			"		   	 		<div class='error' id='alertCodeVerify'></div>" +
         			"		   	 		<div class='ok' id='alertCodeNotify'></div>" +
         			"					<div class='control-form'><i></i>" +
         			"						<button id='btn-send-code-validation' class='js-close-modal btn btn-orange white' type='button'>CONFIRMAR</button><br>" +
         			"					</div><button id='lnkSendSms' class='js-close-modal btn btn-orange white'>ENVIAR CÓDIGO NUEVAMENTE</button>" +
         			"				</div>"+
         			"			</form>" +
         			"</div>";
         }else {
        	 return  "<div class='content-modal has-action over-visible'>" +content+ 
         			"			<br/><form class='form-register' method='post' id='frm-user-active-sms' data-response-type='jsonp'>" +
         			"					<div id='containerSendSms' class='hide'>"+
         			"					<div class='control-form'>" +
         			"						<input class='control-custom input-custom' type='number' id='telf-sms' name='telf-sms' autocomplete='off' placeholder='Ingresa tu celular'  required "+((client.getMobilePhone()!=null && !client.getMobilePhone().trim().equals(""))?" value='"+client.getMobilePhone().trim():" ")+"'/>" +
         			"					</div>" +
         			"		   	 		<div class='error' id='alertTelfVerify'></div>" +
         			"		   	 		<div class='ok' id='alertTelfNotify'></div>" +
         			"					<div class='control-form'><i></i>" +
         			"						<button id='btn-send-sms-validation' class='js-close-modal btn btn-orange white' type='button'>ENVIAR SMS</button><br>" +
         			"					</div><button id='lnkActiveCode' class='js-close-modal btn btn-orange white'>YA TENGO CÓDIGO DE ACTIVACIÓN</button>" +
         			"				</div><div id='containerSendCode' class='hide'>"+
         			"					<div class='control-form'>" +
         			"						<input class='control-custom input-custom' type='number' id='send-code' name='send-code' autocomplete='off' placeholder='Digita el c&oacute;digo'  required />" +
         			"					</div>" +
         			"		   	 		<div class='error' id='alertCodeVerify'></div>" +
         			"		   	 		<div class='ok' id='alertCodeNotify'></div>" +
         			"					<div class='control-form'><i></i>" +
         			"						<button id='btn-send-code-validation' class='js-close-modal btn btn-orange white' type='button'>CONFIRMAR</button><br>" +
         			"					</div><button id='lnkSendSms' class='js-close-modal btn btn-orange white'>ENVIAR CÓDIGO NUEVAMENTE</button>" +
         			"				</div>"+
         			"			</form>" +
         			"</div>";
         }
    	
    }
    
    public static String getClientIp(HttpServletRequest request) {
    	String log="getClientIp";
    	String url = escapeChar(request.getRequestURL().toString());
		LoggerApi.Log.info(log+" user-agent	="+request.getHeader("user-agent"));
		LoggerApi.Log.info(log+" url="+url);
    	String clientIp=request.getHeader("Incap-Client-IP");
		LoggerApi.Log.info(log+" Incap-Client-IP=" +clientIp);
		if (clientIp==null || clientIp.equals("") || clientIp.equals("NULL") || clientIp.equals("unknown")) {
	    	clientIp=request.getHeader("X-Forwarded-For");
			LoggerApi.Log.info(log+" X-Forwarded-For IP=" +clientIp);
			if (clientIp==null || clientIp.equals("") || clientIp.equals("NULL") || clientIp.equals("unknown")) {
				clientIp=request.getRemoteAddr();
				LoggerApi.Log.info(log+" getRemoteAddr IP=" +clientIp);
			}
		}
    	return clientIp;
    }
    
    private static String escapeChar(String str) {
        char src[] = str.toCharArray();
        int len = src.length;
        for (int i = 0; i < src.length; i++) {
            switch (src[i]) {
                case '<':    // to "&lt;"
                    len += 3;
                    break;
                case '>':    // to "&gt;"
                    len += 3;
                    break;
                case '&':    // to "&amp;"
                    len += 4;
                    break;
            }
        }
        char ret[] = new char[len];
        int j = 0;
        for (int i = 0; i < src.length; i++) {
            switch (src[i]) {
                case '<':    // to "&lt;"
                    ret[j++] = '&';
                    ret[j++] = 'l';
                    ret[j++] = 't';
                    ret[j++] = ';';
                    break;
                case '>':    // to "&gt;"
                    ret[j++] = '&';
                    ret[j++] = 'g';
                    ret[j++] = 't';
                    ret[j++] = ';';
                    break;
                case '&':    // to "&amp;"
                    ret[j++] = '&';
                    ret[j++] = 'a';
                    ret[j++] = 'm';
                    ret[j++] = 'p';
                    ret[j++] = ';';
                    break;
                default:
                    ret[j++] = src[i];
                    break;
            }
        }
        return new String(ret);
    }
    
    public String requestPlayerWebApi(String json, String service) {
	 	String log="requestPlayerWebApi";
	 	log= log+" "+service;
//    	LoggerApi.Log.info("start "+ log+": "+json);
    	LoggerApi.Log.info("start "+ log);
		String jsonResponsePlayerWebApi="";
		try {
			String urlPlayerWebApi = ConnectionFactory.operationProperty("urlPlayerWebApi", Constantes.contextPlayerWebApi);
			String userPlayerWebApi = ConnectionFactory.operationProperty("userPlayerWebApi", Constantes.contextPlayerWebApi);
			String passPlayerWebApi = ConnectionFactory.operationProperty("passPlayerWebApi", Constantes.contextPlayerWebApi);
			String credenciales = userPlayerWebApi+":"+passPlayerWebApi;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlPlayerWebApi+service);
 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
 			con.setRequestMethod("POST");
 			con.setRequestProperty("Authorization", "Basic "+credenciales);
// 			con.setRequestProperty("Secret", secretIflexapiRecharge);
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
// 				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode + " json: "+json);
 				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode);
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
// 			jsonResponsePlayerWebApi = sb.toString();
 			JSONObject jresponse=new JSONObject(sb.toString());
 			jsonResponsePlayerWebApi =jresponse.getJSONObject("result").toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
// 				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi + " json: "+json);	
 				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi);	
 			}
 			buffer = null;
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
	 	String log="requestPlayerWebApi";
	 	log= log+" "+service;
//    	LoggerApi.Log.info("start "+ log+": "+json);
    	LoggerApi.Log.info("start "+ log);
		String jsonResponsePlayerWebApi="";
		try {
			String urlPlayerWebApi = ConnectionFactory.operationProperty("urlPlayerWebApi", Constantes.contextPlayerWebApi);
			String userPlayerWebApi = ConnectionFactory.operationProperty("userPlayerWebApi", Constantes.contextPlayerWebApi);
			String passPlayerWebApi = ConnectionFactory.operationProperty("passPlayerWebApi", Constantes.contextPlayerWebApi);
			String credenciales = userPlayerWebApi+":"+passPlayerWebApi;
			credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
 	    	URL url = new URL(urlPlayerWebApi+service);
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
// 				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode + " json: "+json);
 				LoggerApi.Log.info(log+" HTTP CODE: "+responseCode);
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
// 			JSONObject jresponse=new JSONObject(sb.toString());
 			jsonResponsePlayerWebApi =sb.toString();
 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
// 				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi + " json: "+json);
 				LoggerApi.Log.info(log+" "+ service+" Response: "+jsonResponsePlayerWebApi);	
 			}
 			buffer = null;
 			LoggerApi.Log.info(log+" Response: "+jsonResponsePlayerWebApi);
		} catch (Throwable e) {
			LoggerApi.severe(e);
		}finally {
//			LoggerApi.Log.info("end "+log+": "+jsonResponsePlayerWebApi);
			LoggerApi.Log.info("end "+log);
		}
		return jsonResponsePlayerWebApi;
	}
    
    public ClientProcedureGetDataClient JsonConvertClient(JsonObject joDataClient) {
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

    public void createSession(LoginDataBean clientLoginData, ClientAccountBo beanClientAccountBo, HttpSession session, String ip) throws Exception {
		try {
			ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
			ClientAddressLog clientAddressLog = new ClientAddressLog();
			clientAddressLog.setCal_client_id(null);
			clientAddressLog.setCal_user(clientLoginData.getUser());
			clientAddressLog.setCal_address("eCommerce Mobile");
			clientAddressLog.setCal_ip(ip);
			clientAddressLog.setCal_procedure("LOGIN");
			clientAddressLog.setCal_status("START");
			clientAddressLog.setCal_date(new Date());
			beanClientAccountBo.saveLoginLog(clientAddressLog);

			Client clientSession = new Client();
			clientSession.setClientId(clientLoginData.getClientId());
			clientSession.setName(clientLoginData.getClientName());
			clientSession.setLastname(clientLoginData.getLastName());
			clientSession.setMaidenname(clientLoginData.getMaternalLastName());
			clientSession.setMail(clientLoginData.getMail());
			clientSession.setDocNumber(clientLoginData.getDocumentNumber());
			clientSession.setDocType(clientLoginData.getDocumentType());
 
			session.setAttribute("CLIENT_SESSION", clientSession);
			session.setAttribute("name", clientSession.getName());
			session.setAttribute("lastname", clientSession.getLastname());
			session.setAttribute("maidenname", clientSession.getMaidenname());
			session.setAttribute("mail", clientSession.getMail());
			session.setAttribute("cid", clientSession.getClientId());
			
			session.setAttribute("clientId", String.valueOf(clientSession.getClientId()) );
			
			//Parametro para cerrar sesion de TeApuesto en otro dispositivo
//			session.setAttribute("openSession","openSession");
			
			//agregar token de session
			LoggerApi.Log.info("Se incia captura de datos para cierre de session");
			dataClient = clientSaleBo.findGetDataClient(clientLoginData.getSessionId(), clientLoginData.getClientId());
			JsonObject sessionData = new JsonObject();
			sessionData.addProperty("tokenSession", dataClient.getTokenSession());
			sessionData.addProperty("clientId", dataClient.getClientId());
			sessionData.addProperty("celular", dataClient.getMobilePhone());
			sessionData.addProperty("tipoDocumento", dataClient.getTypeId());
			sessionData.addProperty("numeroDocumento", dataClient.getNumberId());
			session.setAttribute("sessionData", sessionData.toString());
			LoggerApi.Log.info("Se finaliza captura de datos para cierre de session");
			
			ClientProcedureGetLoginData clientProcedureLogin = new ClientProcedureGetLoginData(); 
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
			LoggerApi.Log.info("Esta es el clientProcedureLogin " + clientProcedureLogin.toString());
 
			if (clientLoginData.getState().equals(new java.lang.Integer(1))) {
				clientProcedureLogin.setStatus("OK");
				session.setAttribute(Constantes.CLIENT_SESION, clientProcedureLogin);
				session.setAttribute(Constantes.USR_SESION, clientProcedureLogin);
				session.setAttribute("username", clientLoginData.getUser());
				//session.setAttribute("password", clientLoginData.getPassword()); --lo usa la polla
				
				session.setAttribute("clientId", String.valueOf(clientLoginData.getClientId()) );
				LoggerApi.Log.info("Entre");
			}
			LoggerApi.Log.info("Esta es la sesion " + session.getAttribute(Constantes.CLIENT_SESION));
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
	}
    
    public String fetchTA(HttpServletRequest request) throws Exception {
		String log="fetchTA";
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		JsonObject o = new JsonObject();
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
		String url="";
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constantes.USR_SESION)!=null) {
            	client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);//Constantes.CLIENT_SESION);

                ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(client.getClientId(), request.getRemoteAddr());
	          	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
	          		String redireccion=Constantes.tav2GameProviderBaseUrl;
	          		String authToken=tanTokenGeneration.getTav2Token();
	          		url = redireccion+"?authToken="+authToken;
	          	}
            } 
            return url;
            
        } catch (Exception e) {
            LoggerApi.severe(e);
            return url;
        } finally {
        	LoggerApi.Log.info("end "+log);        	
        }
    }
    
    /*Permite validar si la ip del usuario esta registrado en la lista blanca con estado 1:pediente 2:aprobado 3:denegado*/
	public boolean validarSession(HttpServletRequest request, LoginDataResponse responseLogin, HttpServletResponse response) throws Exception {
	    try {
	        LoggerApi.Log.info("start ------------------ validarSession ");
	        
	        JsonObject o = new JsonObject();
			PrintWriter out = response.getWriter();
	        String ipUser = SecurityUtils.getClientIp(request);
	        Integer client_id = responseLogin.getResult().getClientId();
	        
	        try {
	        
	        LoggerApi.Log.info("Client ID: " + client_id + "Client IP: " + ipUser);
	        
	        Date fechaHoraActual = new Date();
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mma");
	        String fechaHoraFormateada = formato.format(fechaHoraActual).toLowerCase();
	        LoggerApi.Log.info("Formatted date and time: " + fechaHoraFormateada);
	        

	        ClientSecurityProcedureCheckIp result = clientSaleBo.findGetCheckIp(client_id, ipUser, "MOBILE");
	        LoggerApi.Log.info("Check IP status: " + result.getStatus());
	        
	        String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constantes.contextSale);
		    
	        
	        String[] listaClientesProteccionUsuario = ConnectionFactory.operationProperty("listaClientesProteccionUsuario", Constantes.contextSale).split(",");
	        
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
	        	if (result.getStatus().equals("ERROR_VALIDAR_IP") 	|| result.getStatus().equals("OK_EMAIL") || result.getStatus().equals("OK")) {
		        	// Se manda un correo si la ip no existe en la lista blanca
	        		
	        		String esActivoCorreoProteccionUsuario = ConnectionFactory.operationProperty("esActivoCorreoProteccionUsuario", Constantes.contextSale);
	    			LoggerApi.Log.info("esActivoCorreoProteccionUsuario: " + esActivoCorreoProteccionUsuario);	 	        		
	        		 if(esActivoCorreoProteccionUsuario!=null && esActivoCorreoProteccionUsuario.trim().equals("true")) {
	 		        	String resultSms = securitySendAlertMail(responseLogin.getResult().getMail(), fechaHoraFormateada, client_id, ipUser);
	 		       	
			    		if (resultSms.equals("OK")) {
			    			LoggerApi.Log.info("CORREO PROTECCION USUARIO: ERROR_VALIDAR_IP" );
			    			LoggerApi.Log.info("Correo enviado a: " + responseLogin.getResult().getMail());
		
			    		} else {	
			    			LoggerApi.Log.info("status: " + result.getStatus() + "Error, no se logró enviar el correo de verificación de usuario: " + responseLogin.getResult().getMail());		    		
			    		}
	        		 }
	
		        /*} else if (result.getStatus().equals("OK_EMAIL")) {
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
		    		
		        }  else {
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

	        String ipUser = SecurityUtils.getClientIp(request);
	        Integer client_id =  clientId;
	        
	        try {
	        
	        LoggerApi.Log.info("Client ID: " + client_id + "Client IP: " + ipUser);
	        
	        Date fechaHoraActual = new Date();
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mma");
	        String fechaHoraFormateada = formato.format(fechaHoraActual).toLowerCase();
	        LoggerApi.Log.info("Formatted date and time: " + fechaHoraFormateada);
	        

	        ClientSecurityProcedureCheckIp result = clientSaleBo.findGetCheckIp(client_id, ipUser, "MOBILE");
	        LoggerApi.Log.info("Check IP status: " + result.getStatus());
	        
	        String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constantes.contextSale);
	        
	        String[] listaClientesProteccionUsuario = ConnectionFactory.operationProperty("listaClientesProteccionUsuario", Constantes.contextSale).split(",");
	        
	        boolean flagCliente = false ;
	        
		    for (String clientePU : listaClientesProteccionUsuario) {
				if(String.valueOf(client_id).equals(clientePU)) {
					flagCliente=true;
					break;
				}
			}

			LoggerApi.Log.info("flagCliente: " + flagCliente);
			LoggerApi.Log.info("esActivoProteccionUsuario: " + esActivoProteccionUsuario);
	        if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true")  && flagCliente) {
	        	
	        	if (result.getStatus().equals("ERROR_VALIDAR_IP") || result.getStatus().equals("OK_EMAIL") || result.getStatus().equals("OK")) {
		        	// Se manda un correo si la ip no existe en la lista blanca y se registra con estado 1:pendiente
	        		
	        		String esActivoCorreoProteccionUsuario = ConnectionFactory.operationProperty("esActivoCorreoProteccionUsuario", Constantes.contextSale);
	    			LoggerApi.Log.info("esActivoCorreoProteccionUsuario: " + esActivoCorreoProteccionUsuario);
	    			
	        		 if(esActivoCorreoProteccionUsuario!=null && esActivoCorreoProteccionUsuario.trim().equals("true")) {
	 		        	String resultSms = securitySendAlertMail(mail, fechaHoraFormateada, client_id, ipUser);
	 		       	
			    		if (resultSms.equals("OK")) {
				         	LoggerApi.Log.info("CORREO PROTECCION USUARIO: ERROR_VALIDAR_IP" );
			    			LoggerApi.Log.info("Correo enviado a: " + mail);
		
			    		} else {	
			    			LoggerApi.Log.info("status: " + result.getStatus() + "Error, no se logró enviar el correo de verificación de usuario: " + mail);		    		
			    		}
	        		 }
	
		       /* } else if (result.getStatus().equals("OK_EMAIL")) {
		        	o.addProperty("status", result.getStatus());
		    		o.addProperty("titulo", result.getTitulo());
		    		o.addProperty("mensaje", result.getMensaje());
		        	LoggerApi.Log.info("No se ha enviado el correo y la ip sigue en estado pendiente");*/
		        } else if(result.getStatus().equals("ERROR_IP")) {
		        	//Si la ip en la lista blanca tiene estado 3: desaprobado denegar acceso al usuario y mostrar un popup de alerta
		        	request.setAttribute("errorSession", "true");
		        	o.addProperty("status", result.getStatus());
		    		o.addProperty("titulo", result.getTitulo());
		    		o.addProperty("mensaje", result.getMensaje());
		    		LoggerApi.Log.info("Error, no puede iniciar session porque la ip esta desaprobada");   	
		    		o.addProperty("state", "OK");  
		    		
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
        
        String baseUrl = ConnectionFactory.operationProperty("url_respuesta_lista_blanca", Constantes.contextSale);
        
        //String urlBotonSi = baseUrl + "?param1=" + client_id_encript + "&param2=" + ip_encript + "&param3=" + respuesta_si;
        
        //String urlBotonNo = baseUrl + "?param1=" + client_id_encript + "&param2=" + ip_encript + "&param3=" + respuesta_no;
        
        String urlBotonNo = ConnectionFactory.operationProperty("url_restablecer_contrasenia", Constantes.contextSale);
        
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
        	result = MailLib.sendValidMailEco_Security(ConnectionFactory.operationProperty("mailSourceApp", Constantes.contextSale),mailSender, mailSubject, mailBody,context.getRealPath(Constantes.INTERNAL_PATH_LOGO_MAIL), context.getRealPath(Constantes.INTERNAL_PATH_LOGOS_JUEGOS_MAIL), ConnectionFactory.operationProperty("servidorCorreoProteccionUsuario", Constantes.contextSale));
            
        } catch (Exception e) {
            LoggerApi.severe(e);
            result = e.getMessage();
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
        
    }
	
	public String validationreniecWs(String log, String json) throws Exception { 
		//LoggerApi.Log.info(log+"---------- start [validationreniecWs] JSON: " + StringLib.encodeLongLabel(json));
		long startTime = System.currentTimeMillis();
		HttpURLConnection conn = null;
		
		String responseApi= "";
		try {
			
			String userReniecAPI = Constantes.USER_RENIEC_WS;
			String passReniecAPI = Constantes.PASS_RENIEC_WS;
			String credenciales = userReniecAPI+":"+passReniecAPI;
			credenciales = Base64.encodeBase64String(credenciales.getBytes());
            
			
			URL url = new URL(Constantes.API_RENIECWS);
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + credenciales);
			conn.setDoOutput(true);
			
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes("utf-8"));
            os.flush();
			os.close();
			
			int statusCode = conn.getResponseCode();
			
			BufferedReader reader = null;
			
			if(statusCode < HttpServletResponse.SC_BAD_REQUEST) {
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),Constantes.CHARSET_UTF8));
			}else {
				LoggerApi.Log.info("HTTP CODE: " + statusCode + "JSON: " + json);
				reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(),Constantes.CHARSET_UTF8));
			}
			
			StringBuilder sb = new StringBuilder();
			char[] buffer = new char[1000];
	        int leido;
	        while ((leido = reader.read(buffer)) > 0) {
	        	sb.append(new String(buffer, 0, leido));
	        }
	        reader.close();
			conn.disconnect();
            
            JSONObject jsonResponse = new JSONObject(sb.toString());
            
            responseApi = jsonResponse.toString();
            //LoggerApi.Log.info("RESPONSEAPI :" +responseApi);
            
            buffer=null;
            
		} catch (Exception e) { 
			LoggerApi.Log.info("Exception :" +e);
			throw e;
		} finally {
			LoggerApi.Log.info(log+"---------- end [validationreniecWs] response "+(System.currentTimeMillis()-startTime)/1000.0 +" seconds");
			if (conn!=null) conn.disconnect(); conn = null;
		}
		return responseApi;
	}	
	
	public TYCPDPProcedureConsultPendingDocumentsTemplate validatePendingDocumentsForApproval(Integer clientId) {
		JsonObject joDataPendingDocsResponse = null;
		TYCPDPProcedureConsultPendingDocumentsTemplate dataPendingDocs = new TYCPDPProcedureConsultPendingDocumentsTemplate();
		try {
			
			JsonObject jdata = new JsonObject();
			String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
			jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("clientId", String.valueOf(clientId));
			jdata.addProperty("operatorId", Constantes.OPERATOR_ID);	
			jdata.addProperty("platform", Constantes.PLATAFORM);
			
			JsonParser jsonParser = new JsonParser();
			// obtener objeto
			joDataPendingDocsResponse = jsonParser.parse(requestPlayerWebApi(jdata.toString(), "getPendingDocumentsForApproval")).getAsJsonObject();
			// converitr de objeto a entidad
			dataPendingDocs = JsonConvertPendingDocsTemplate(joDataPendingDocsResponse);
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
		return dataPendingDocs;
	}
	
	private TYCPDPProcedureConsultPendingDocumentsTemplate JsonConvertPendingDocsTemplate(JsonObject joDataPendingDocs) {
		TYCPDPProcedureConsultPendingDocumentsTemplate dataPendingDocsResponse = new TYCPDPProcedureConsultPendingDocumentsTemplate();
		dataPendingDocsResponse.setState(joDataPendingDocs.has("state")? joDataPendingDocs.get("state").getAsString():null);
		dataPendingDocsResponse.setStatus(joDataPendingDocs.has("status")? joDataPendingDocs.get("status").getAsString():null);
		dataPendingDocsResponse.setError(joDataPendingDocs.has("error")?joDataPendingDocs.get("error").getAsString():null);
		dataPendingDocsResponse.setMessage(joDataPendingDocs.has("message")?joDataPendingDocs.get("message").getAsString():null);
		dataPendingDocsResponse.setResp_title(joDataPendingDocs.has("resp_title")?joDataPendingDocs.get("resp_title").getAsString():null);
		dataPendingDocsResponse.setResp_message(joDataPendingDocs.has("resp_message")?joDataPendingDocs.get("resp_message").getAsString():null);
		dataPendingDocsResponse.setResp_button(joDataPendingDocs.has("resp_button")?joDataPendingDocs.get("resp_button").getAsString():null);

		ArrayList<TYCPDPProcedureConsultPendingDocuments> documentList = new ArrayList<TYCPDPProcedureConsultPendingDocuments>();
	    if (joDataPendingDocs.has("documents") && joDataPendingDocs.get("documents").isJsonArray()) {
	        JsonArray jsonDocuments = joDataPendingDocs.getAsJsonArray("documents");
	        Gson gson = new Gson();
	        
	        for (JsonElement jsonElement : jsonDocuments) {
	            TYCPDPProcedureConsultPendingDocuments document = gson.fromJson(jsonElement, TYCPDPProcedureConsultPendingDocuments.class);
	            documentList.add(document);
	        }
	    }
	    dataPendingDocsResponse.setDocuments(documentList);
		
		LoggerApi.Log.info("dataPendingDocsResponse: "+ dataPendingDocsResponse.toString() );
		
		return dataPendingDocsResponse;
	}


}
