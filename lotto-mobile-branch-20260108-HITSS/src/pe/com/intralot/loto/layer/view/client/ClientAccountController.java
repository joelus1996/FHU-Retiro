package pe.com.intralot.loto.layer.view.client;


import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.controller.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureEditSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePassClient;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedurePasswordNotification;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdateNotification;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdatePasswordNotification;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.client.dispatcher.SalesDispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;

@Controller
public class ClientAccountController {

	//static final Log logger = LogFactory.getLog(ClientAccountController.class);

	@Autowired
	private ClientAccountBo beanClientAccountBo;	
	
	@Autowired
	private IntralotUtils intralotUtils; 
	
    @Autowired
    private ClientSaleBo clientSaleBo;
    
    @Autowired
    private SecurityUtils securityUtils;
    
    @Autowired
	private PaymentPrizeBo paymentPrizeBo;
		
	@RequestMapping("/client_account_show_information")	
	public ModelAndView showInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
					
		try {
			 LoggerApi.Log.info("-------------- START client_account_show_information"); 
			
			 HttpSession session = request.getSession();
			 if(StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {	
				 Client objectPojo=beanClientAccountBo.findClientById(Integer.parseInt((String)session.getAttribute("clientId")));				
				 objectModelMap.put("Client",objectPojo);
				 return new ModelAndView("client/interface-account") ;	 	
			 } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} catch (Exception e) {
			LoggerApi.severe(e);			
			return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} finally {
			LoggerApi.Log.info("-------------- END client_account_show_information"); 
		}		 
	}
	
	//obtener valores del la configuración limite 
    @RequestMapping(value = "/getDataSelfControl")
    public void getDataSelfControl(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {

		LoggerApi.Log.info("-------------- START getDataSelfControl uuid=");
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        
        String clientId = "";
        Integer sessionId = 0;
    	try {
			if (!((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString().equals("")) {
                clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString();
                sessionId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getSessionId();

                ClientProcedureGetSelfcontrol getSelfcontrol = clientSaleBo.getDataSelfcontrol(Integer.valueOf(clientId) );
             	
                o.addProperty("clientId", getSelfcontrol.getClientId());
                o.addProperty("showDisable",getSelfcontrol.getShowDisable());
				o.addProperty("typeLimit",getSelfcontrol.getTypeLimit());
				o.addProperty("valueLimit",getSelfcontrol.getValueLimit());
				o.addProperty("dateLimit",getSelfcontrol.getDateLimit());
				
			}else {
				o.addProperty("controlFlag", "KO");
			}
			out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
	    } 
    	LoggerApi.Log.info("-------------- END getDataSelfControl ");
    }
	
    @RequestMapping(value = "/define-limit")
    public void defineLimit(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("define-limit");
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        String clientId = "";
        Integer sessionId = 0;
        String message = "";
        
        String p_type="OTRO";
        Integer monto_control=0;
        LoggerApi.Log.info("editar limites de autocontrol");
        
        try {
            PrintWriter out = response.getWriter();
            JsonObject o = new JsonObject();
            if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
                
            	try {
            		p_type= request.getParameter("type");
            		LoggerApi.Log.info("p_type=" + p_type);
            		if( p_type.equals("POR_MONTO")) {
            			monto_control = Integer.parseInt(request.getParameter("soles"));
            		}else if( p_type.equals("POR_HORAS")) {
            			monto_control = Integer.parseInt(request.getParameter("selectHour"));
            		}else if ( p_type.equals("POR_AUTOEXCLUSION")) {
            			monto_control = Integer.parseInt(request.getParameter("value-autoexclusion"));
            		}  				
				} catch (Exception e) {
					// TODO: handle exception
					monto_control=0;			
				}
                
                if (!((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString().equals("")) {
                   
                	clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString();
                    sessionId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getSessionId();
                   // message = SalesDispatcher.setDataSelfcontrol(clientId, amount, hours);
                    ClientProcedureEditSelfcontrol editSelfcontrol = clientSaleBo.editDataSelfcontrol(Integer.valueOf(clientId), monto_control, p_type );
                    message= editSelfcontrol.getMensaje();
                    
                    if (message.equals("OK")) {
                        o.addProperty("message", message);
                        ClientProcedureGetDataClient dataClient = clientSaleBo.findGetDataClient(sessionId, Integer.parseInt(clientId));
                        o.addProperty("lastDate", dataClient.getControlLastDate());
                    } else if (message.equals("ERROR_POR_FECHA")) {
                        o.addProperty("message", message);
                        o.addProperty("info",
                                "Ya tienes una opci&oacute;n de Autocontrol registrada en tu cuenta. \nPara modificarla o desactivarla debes esperar 24 horas desde tu elecci&oacute;n. \nInf&oacute;rmate en los t&eacute;rminos y condiciones.");
                    } else {
                        o.addProperty("message", message);
                        o.addProperty("info", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");
                    }
                }
            }
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("clientId=" + clientId);
        }
        
    }
    
    
    @RequestMapping("/client_edit_show_information")	
	public ModelAndView editInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
					
		try {
			 LoggerApi.Log.info("-------------- START client_edit_show_information"); 
			 Integer idSession = 0;
		     String idClient = "";
			 ClientProcedureGetDataClient dataClient = null; 
			 HttpSession session = request.getSession();
			 JsonObject joDataClientResponse=null;
			 
			 if(StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {
				 Client objectPojo=beanClientAccountBo.findClientById(Integer.parseInt((String)session.getAttribute("clientId")));				 
				 objectModelMap.put("Client",objectPojo);
				 
//				 ClientProcedureGetLoginData clientProcedureLogin = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
				 
	        	 idClient = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString();
	        	 idSession = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getSessionId();

//				 dataClient = clientSaleBo.findGetDataClient(idSession, Integer.parseInt(idClient));
				 
				 JsonObject jdata = new JsonObject();
        		 String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
	    		 jdata.addProperty("token", tokenPlayerWebApi);
	    		 jdata.addProperty("tipoDocumento", "");
	    		 jdata.addProperty("numeroDocumento", "");
	    		 jdata.addProperty("clientId", String.valueOf(idClient));
	    		 jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	    		 jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
	    		 jdata.addProperty("platform", Constantes.PLATAFORM);
		    	 JsonParser jsonParser = new JsonParser();
                 joDataClientResponse = jsonParser.parse(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData")).getAsJsonObject();
                 dataClient=securityUtils.JsonConvertClient(joDataClientResponse);
				 
				 JsonObject joDataClient = ClientConvertJson(dataClient);
				 //LoggerApi.Log.info("mobilePhoneUpdate ==> " + objectPojo.getMobilePhoneUpdate()); 
				 joDataClient.addProperty("mailUpdate", objectPojo.getMailUpdate());
				 joDataClient.addProperty("mobileUpdate", objectPojo.getMobileUpdate());
                 request.setAttribute("DataClient", joDataClient);
                 boolean hiddenUser = false;
                 String datePlayerWebApi = ConnectionFactory.operationProperty("datePlayerWebApi", Constantes.contextSale);
             	 if(datePlayerWebApi==null || datePlayerWebApi.equals("")) {
             		datePlayerWebApi="2023-07-14 00:00:00";
             	 }
                 Timestamp playerWebStart = Timestamp.valueOf(datePlayerWebApi);
                 String sInsertDate= dataClient.getInsertDate();
             	 Timestamp insertDate = Timestamp.valueOf(sInsertDate);
             	 if(playerWebStart.before(insertDate)) {
             		hiddenUser = true;
             		joDataClient.addProperty("user", "");
            		request.setAttribute("DataClient", joDataClient);
             	 }                	
             	 objectModelMap.put("hiddenUser",hiddenUser);
             	 
             	boolean hiddenPpe = false;
            	String datePerPolExp = ConnectionFactory.operationProperty("datePerPolExp", Constantes.contextSale);
            	if(datePlayerWebApi==null || datePlayerWebApi.equals("")) {
            		datePlayerWebApi="2024-01-12 00:00:00";
            	}
            	Timestamp ppeStart = Timestamp.valueOf(datePerPolExp);
            	Timestamp ppeInsertDate = Timestamp.valueOf(sInsertDate);
            	if(ppeStart.before(ppeInsertDate)) {
            		hiddenPpe = true;
            	}             	
            	objectModelMap.put("hiddenPpe",hiddenPpe);
                  
				 return new ModelAndView("client/interface-edit-perfil") ;
				 
			 } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} finally {
			LoggerApi.Log.info("-------------- END client_edit_show_information"); 
		}		 
	}
    
	@RequestMapping("/client_edit_password")	
	public ModelAndView editPassword(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
					
		try {
			 LoggerApi.Log.info("-------------- START client_edit_password"); 
			
			 HttpSession session = request.getSession();
			 if(StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {	
				 Client objectPojo=beanClientAccountBo.findClientById(Integer.parseInt((String)session.getAttribute("clientId")));				 
				 objectModelMap.put("Client",objectPojo);
				 
				 return new ModelAndView("client/interface-new-password") ;	 
				 
			 } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} catch (Exception e) {
			LoggerApi.severe(e);			
			return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} finally {
			LoggerApi.Log.info("-------------- END client_edit_password"); 
		}
	}
	
	@RequestMapping("/client_edit_auto_control")	
	public ModelAndView showAutoControl(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
					
		try {
			 LoggerApi.Log.info("-------------- START client_edit_auto_control"); 
			
			 HttpSession session = request.getSession();
			 if(StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {	
				 Client objectPojo=beanClientAccountBo.findClientById(Integer.parseInt((String)session.getAttribute("clientId")));				 
				 objectModelMap.put("Client",objectPojo);
				 
				 return new ModelAndView("client/interface-perfil-autocontrol") ;	 	
			 } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} catch (Exception e) {
			LoggerApi.severe(e);			
			return new ModelAndView("redirect:security_login_execute_authentication.html") ;
		} finally {
			LoggerApi.Log.info("-------------- END client_edit_auto_control"); 
		}		 
	}
    
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/user-update")
    public void userUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- STAR user-update"); 
		
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        Integer clientId = 0;
        Integer sessionId = 0; 
        String user = "";
        String ppe = "";
        PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject(); 
        JsonObject joDataClient = new JsonObject();
        JsonObject joDataClientResponse=null;
        try {
        	
            if (session == null || session.getAttribute(Constantes.CLIENT_SESION) == null) { 
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");    
            	return;
            } 
            if (((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString().equals("")) {
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            	return;
            }
            
            clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId();
            sessionId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getSessionId();
            ClientProcedureGetDataClient dataClient = new ClientProcedureGetDataClient();
             
            dataClient = requestDataClient(dataClient,request);
            user = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getUser();
            if(dataClient.getUser()!=user && user!=null && !user.equals("")) {
            	dataClient.setUser(user);
            }
            ppe = (session.getAttribute("isPerPolExp")!=null?session.getAttribute("isPerPolExp").toString():"");
            if(dataClient.getPpe()!=ppe && ppe!=null && !ppe.equals("")) {
            	dataClient.setPpe(ppe);
            }
             
            Map<Object,String> verificaData = verificaData(dataClient);
            
            if(!Boolean.parseBoolean(verificaData.get("verificador"))) {
            	o.addProperty("result", verificaData.get("status")); 
            	o.addProperty("message", verificaData.get("message"));
            	return;
            }
            
//        	ClientProcedureUpdateDataClient clientUpdate = clientSaleBo.updateClient(dataClient,sessionId, clientId);
          //servicio updateClientData
    		JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("clientId", String.valueOf(clientId));
//    		jdata.addProperty("usuario", user);
    		jdata.addProperty("nombres", dataClient.getNombre());
    		jdata.addProperty("apellidos", dataClient.getApPaterno());
    		jdata.addProperty("email", dataClient.getMail());
    		jdata.addProperty("fechaNacimiento", dataClient.getBirthDate());
    		jdata.addProperty("celular", dataClient.getMobilePhone());
    		jdata.addProperty("tipoDocumento", dataClient.getTypeId());
    		jdata.addProperty("numeroDocumento", dataClient.getNumberId());
    		jdata.addProperty("confirm", dataClient.getConfirm());
    		jdata.addProperty("nacionalidad", dataClient.getCountry());
    		jdata.addProperty("direccion", dataClient.getAddress2());
    		jdata.addProperty("departamento", dataClient.getRegion());
    		jdata.addProperty("provincia", dataClient.getProvince());
    		jdata.addProperty("distrito", dataClient.getDistrict());
    		jdata.addProperty("ppeFlag", dataClient.getPpe());
    		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
    		jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
    		jdata.addProperty("platform", Constantes.PLATAFORM);
    		
    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updateProfile"));
    		
    		o.addProperty("status", convertedObject.getString("status").equals("OK")?convertedObject.getString("state"):"0");
        	o.addProperty("message", convertedObject.getString("message"));
        	
        	if(!convertedObject.getString("status").equals("OK")) {
        		o.addProperty("result", "KO");
        		o.addProperty("title",convertedObject.getString("resp_title"));
            	o.addProperty("message",convertedObject.getString("resp_message"));
            	o.addProperty("button",convertedObject.getString("resp_button"));
        		return;
        	}
        	
        	JsonObject jdata2 = new JsonObject();
    		jdata2.addProperty("token", tokenPlayerWebApi);
    		jdata2.addProperty("tipoDocumento", "");
    		jdata2.addProperty("numeroDocumento", "");
    		jdata2.addProperty("clientId", String.valueOf(clientId));
    		jdata2.addProperty("playerIp", SecurityUtils.getClientIp(request));
    		jdata2.addProperty("operatorId", Constantes.OPERATOR_ID);
    		jdata2.addProperty("platform", Constantes.PLATAFORM);
	    	JsonParser jsonParser = new JsonParser();
            joDataClientResponse = jsonParser.parse(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData")).getAsJsonObject();
            dataClient=securityUtils.JsonConvertClient(joDataClientResponse);
        		  
//            dataClient = clientSaleBo.findGetDataClient(sessionId, clientId);
    		joDataClient = ClientConvertJson(dataClient);
            o.add("DataClient", joDataClient);
            o.addProperty("result", "OK");
            
            session.setAttribute("isDataComplete", 1);
            session.setAttribute("name", dataClient.getNombre());
            
        } catch (Exception e) {
        	o.addProperty("result", "KO");
        	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            LoggerApi.severe(e);
        } finally {
        	out.print(o);
        	LoggerApi.Log.info("-------------- END user-update");
        } 
    }

	
	@RequestMapping(value = "/password-update")
    public void passwordUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log="password-update";
    	LoggerApi.Log.info("-------------- STAR "+log); 
		JSONObject convertedObject=null;
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        JsonObject joDataClientResponse=null;
        
 
        try {
        	
        	if (session == null || session.getAttribute(Constantes.CLIENT_SESION) == null) { 
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");    
            	return;
            }
            if (((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId().toString().equals("")) {
            	o.addProperty("result", "KO");
            	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            	return;
            } 
            
        	String usr = session.getAttribute("username").toString();
        	String passActual = (request.getParameter("password-actual")!=null) ? request.getParameter("password-actual") : "";
        	
        	String passUpdate = (request.getParameter("new-password")!=null) ? request.getParameter("new-password") : "";
            String passConfirm = (request.getParameter("confirm-password")!=null) ? request.getParameter("confirm-password") : "";
            
            if(request.getParameter("password-actual").equals(passUpdate) ) {
        		o.addProperty("result", "KO");
            	o.addProperty("message", "La nueva contraseña no puede ser igual a la actual contraseña");
            	return;
        	}
            
        	String verifyString = intralotUtils.verifyPassword(usr, passUpdate, passConfirm);
        	if (!verifyString.equals("OK")) {
                o.addProperty("result", "KO");
                o.addProperty("message", verifyString);
                return;
            }
        	
        	Integer clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId();
        	//obtener datos del cliente
        	JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("tipoDocumento", "");
			jdata.addProperty("numeroDocumento", "");
			jdata.addProperty("clientId", String.valueOf(clientId));
			jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
			jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
			jdata.addProperty("platform", Constantes.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
        	
			//se retira validacion de contraseña que contenga datos del usuario
            String numeroDocumento=convertedObject.has("numeroDocumento")?convertedObject.getString("numeroDocumento"):"";

            /*String verifyString2 = intralotUtils.verifyPasswordChangePassword(passUpdate, nombres, apellidos, numeroDocumento, fechaNacimiento, celular);
        	if (!verifyString2.equals("OK")) {
                o.addProperty("result", "KO");
                o.addProperty("message", verifyString2);
                return;
            } */       	
        	
        	String tipoDocumento=convertedObject.has("tipoDocumento")?convertedObject.getString("tipoDocumento"):"";
        	jdata = new JsonObject();
        	jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("transaccionId", "");
			jdata.addProperty("tipoDocumento", tipoDocumento);
			jdata.addProperty("numeroDocumento", numeroDocumento);
			jdata.addProperty("passwordAnterior", passActual);
			jdata.addProperty("password", passUpdate);
			jdata.addProperty("passwordConfirm", passConfirm);
			jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
			jdata.addProperty("usuario", "");
			jdata.addProperty("platform", Constantes.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updatePassword"));
			o.addProperty("status", convertedObject.getString("mensaje"));
        	o.addProperty("message", convertedObject.getString("resp_message"));
			if(convertedObject.getString("estado").equals("OK")) {
				o.addProperty("result", "OK");
				
				//modificar notificacion de contraseña
				List<PaymentPrizeProcedureGetNotifications> listObj=paymentPrizeBo.getNotifications(clientId);
				for (PaymentPrizeProcedureGetNotifications notifications : listObj) {
					if(notifications.getType().equals("4")) {
//						PaymentPrizeProcedurePasswordNotification obj = paymentPrizeBo.passwordNotification(clientId);
						PaymentPrizeProcedureUpdatePasswordNotification obj = paymentPrizeBo.updatePasswordNotification(clientId, notifications.getId());
						LoggerApi.Log.info(log+" passwordNotification="+obj.getMessage());
					}
				}
        	}else {
        		o.addProperty("result", "KO");
        	}
			
        } catch (Exception e) {
        	o.addProperty("result", "KO");
        	o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
            LoggerApi.severe(e);
        } finally {
        	out.print(o);
        	LoggerApi.Log.info("-------------- END "+log);
        } 
        
    }
	
	
	@SuppressWarnings("static-access")
	private Map<Object,String> verificaData(ClientProcedureGetDataClient dataClient) throws Exception   {
		Map<Object,String> resultado = new HashMap<Object, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(sdf.parse(dataClient.getBirthDate()));
		Calendar calendario2 = Calendar.getInstance();
		calendario.add(Calendar.YEAR, 18);
		calendario2.setTime(sdf.parse(dataClient.getBirthDate()));
		calendario2.add(Calendar.YEAR, 101);
		boolean flagEdad = true;
		String expRegMobile = "^9\\d{8}";
		String expRegAddress = "[a-zA-Z0-9°#.,\\sáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ-]+";
		String expRegCode = "\\d{2}";
		String expCouCode = "^[A-Z]{2}$";
		
		//validar nacionalidad        
        Boolean verifyCountry = new RegexValidator(expCouCode).isValid(dataClient.getCountry());        
        if (!verifyCountry) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar una nacionalidad correcta");           
        }
		
		if(calendario.getTime().after(new Date())){
			resultado.put("status", "KO"); 
			resultado.put("message", "Los juegos son solo para mayores de 18 años.");
        	flagEdad = false;
		}
		
		if(calendario2.getTime().before(new Date())){
			resultado.put("status", "KO");
			resultado.put("message", "Los juegos son solo para menores de 101 años.");
        	flagEdad = false;
		}
        
		Boolean verifyBirthDate = DateValidator.getInstance().isValid(dataClient.getBirthDate(),"dd/mm/yyyy");
		if(!verifyBirthDate) {
			resultado.put("status", "KO");
        	resultado.put("message", "Ingresar un formato de fecha correcta");
		}
		
		String verifyEMailString = intralotUtils.verifyEmail(dataClient.getMail()); 
        if (!verifyEMailString.equals("OK")) {
        	resultado.put("status", "KO");
        	resultado.put("message", verifyEMailString);
        }
        
        Boolean verifyMailString = EmailValidator.getInstance().isValid(dataClient.getMail()) ;
        if (!verifyMailString) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Ingresar una direcci&oacute;n de correo correcto");
        }
        		
		Boolean verifyMobilePhone = new RegexValidator(expRegMobile).isValid(dataClient.getMobilePhone());
        if (!verifyMobilePhone) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Ingresar un tel&eacute;fono correcto");
           
        }
        
        //validar domicilio
        Boolean verifyAddress=true;
        if(dataClient.getAddress2().length()>70) {
        	verifyAddress=false;
        	resultado.put("status", "KO");
        	resultado.put("message", "La direcci&oacute;n debe tener menos de 70 caracteres");
        }else {
        	verifyAddress = new RegexValidator(expRegAddress).isValid((dataClient.getAddress2()).trim());        
            if (!verifyAddress) {
            	resultado.put("status", "KO");
            	resultado.put("message", "Ingresar una direcci&oacute;n correcta");           
            }
        }
        
        //validar departamento        
        Boolean verifyDepartamento = new RegexValidator(expRegCode).isValid(dataClient.getRegion());        
        if (!verifyDepartamento) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar un departamento correcto");           
        }
        //validar provincia        
        Boolean verifyProvincia = new RegexValidator(expRegCode).isValid(dataClient.getProvince());        
        if (!verifyProvincia) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar una provincia correcta");           
        }
        //validar distrito        
        Boolean verifyDistrito = new RegexValidator(expRegCode).isValid(dataClient.getDistrict());        
        if (!verifyDistrito) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar un distrito correcto");           
        }
        //validar check no es una persona politicamente expuesta   
        Boolean verifyPpe=true;
        if (!dataClient.getPpe().equals("1")) {
        	resultado.put("status", "KO");
        	resultado.put("message", "Seleccionar que no es una persona politicamente expuesta");           
        }
         
        
        if (verifyEMailString.equals("OK") && verifyBirthDate && verifyMailString && verifyMobilePhone && flagEdad
        		&& verifyAddress && verifyDepartamento && verifyProvincia && verifyDistrito && verifyPpe)
        	resultado.put("verificador","true");
         else
        	resultado.put("verificador","false");
        
        return resultado;
	}

	private ClientProcedureGetDataClient requestDataClient(ClientProcedureGetDataClient dataClient, HttpServletRequest request) {

		
		dataClient.setUser((request.getParameter("user-client")!=null) ? request.getParameter("user-client") : null);
        
        dataClient.setNombre((request.getParameter("name")!=null) ? request.getParameter("name") : null);
        
        dataClient.setApPaterno((request.getParameter("ap-paterno")!=null) ? request.getParameter("ap-paterno") : null);
        	 
        dataClient.setMail((request.getParameter("email")!=null) ? request.getParameter("email") : null);
        
        dataClient.setBirthDate((request.getParameter("fechanac")!=null) ? request.getParameter("fechanac") : null);
        
        dataClient.setMobilePhone((request.getParameter("mobile-phone")!=null) ? request.getParameter("mobile-phone") : null);
        
        dataClient.setTypeId((request.getParameter("document-type")!=null) ? request.getParameter("document-type") : null);
        
    	if("DNI".equals(dataClient.getTypeId()))
    		dataClient.setNumberId((request.getParameter("document-number")!=null) ? request.getParameter("document-number") : null);
        else if("PASAP".equals(dataClient.getTypeId()))
        	dataClient.setNumberId((request.getParameter("document-number-pasap")!=null) ? request.getParameter("document-number-pasap") : null);
        else if("CAREX".equals(dataClient.getTypeId()))
        	dataClient.setNumberId((request.getParameter("document-number-carex")!=null) ? request.getParameter("document-number-carex") : null);
            	
    	dataClient.setAddress2((request.getParameter("domicilio")!=null) ? request.getParameter("domicilio").trim() : null);
    	dataClient.setRegion((request.getParameter("departamento")!=null) ? request.getParameter("departamento").trim() : null);
    	dataClient.setProvince((request.getParameter("provincia")!=null) ? request.getParameter("provincia").trim() : null);
    	dataClient.setDistrict((request.getParameter("distrito")!=null) ? request.getParameter("distrito").trim() : null);
    	dataClient.setPpe((request.getParameter("ppe")!=null) ? request.getParameter("ppe").trim() : null);
    	dataClient.setCountry((request.getParameter("nacionalidad")!=null) ? request.getParameter("nacionalidad").trim() : null);
    	
        if( request.getParameter("confirm")!=null )
        	dataClient.setConfirm("Y");
        else
        	dataClient.setConfirm("N");
        
		return dataClient;
	}
	
	private JsonObject ClientConvertJson(ClientProcedureGetDataClient dataClient) {
		JsonObject joDataClient = new JsonObject();
		
		joDataClient.addProperty("user", (dataClient.getUser()!=null ) ? dataClient.getUser() : null);
		joDataClient.addProperty("email", (dataClient.getMail() !=null) ? dataClient.getMail() : null);
		joDataClient.addProperty("luckyIcon", (dataClient.getLuckyIcon() !=null) ? dataClient.getLuckyIcon() : null);
        joDataClient.addProperty("fullName", (dataClient.getNombre() !=null) ? dataClient.getNombre() : null);
        joDataClient.addProperty("typeId", (dataClient.getTypeId() !=null && dataClient.getNumberId() != null) ? dataClient.getTypeId() : null);
        joDataClient.addProperty("numberId", (dataClient.getNumberId() !=null && dataClient.getTypeId() !=null) ? dataClient.getNumberId() : null);
        joDataClient.addProperty("lastName", (dataClient.getApPaterno() !=null) ? dataClient.getApPaterno() : null);
        joDataClient.addProperty("gender", (dataClient.getGender() !=null) ? dataClient.getGender() : null);
        joDataClient.addProperty("birthDate", (dataClient.getBirthDate() !=null) ? dataClient.getBirthDate() : null);
        joDataClient.addProperty("region", (dataClient.getRegion() !=null) ? dataClient.getRegion() : null);
        joDataClient.addProperty("fixedPhone", (dataClient.getFixedPhone() !=null) ? dataClient.getFixedPhone() : null);
        joDataClient.addProperty("mobilePhone", (dataClient.getMobilePhone() !=null) ? dataClient.getMobilePhone() : null);
        //joDataClient.addProperty("mobilePhoneUpdate", dataClient.getMobilePhoneUpdate());
        joDataClient.addProperty("confirm", (dataClient.getConfirm() !=null) ? dataClient.getConfirm() : null);
        
        joDataClient.addProperty("nacionalidad", (dataClient.getCountry() !=null) ? dataClient.getCountry() : null);
        joDataClient.addProperty("nnacionalidad", (dataClient.getNcountry() !=null) ? dataClient.getNcountry() : null);
        joDataClient.addProperty("domicilio", (dataClient.getAddress2() !=null) ? dataClient.getAddress2() : null);
//        joDataClient.addProperty("departamento", (dataClient.getRegion() !=null) ? dataClient.getRegion() : null);
        joDataClient.addProperty("provincia", (dataClient.getProvince() !=null) ? dataClient.getProvince() : null);
        joDataClient.addProperty("distrito", (dataClient.getDistrict() !=null) ? dataClient.getDistrict() : null);
        joDataClient.addProperty("ppe", (dataClient.getPpe() !=null) ? dataClient.getPpe() : null);
        joDataClient.addProperty("nregion", (dataClient.getNregion() !=null) ? dataClient.getNregion() : null);
        joDataClient.addProperty("nprovincia", (dataClient.getNprovince() !=null) ? dataClient.getNprovince() : null);
        joDataClient.addProperty("ndistrito", (dataClient.getNdistrict() !=null) ? dataClient.getNdistrict() : null);
        LoggerApi.Log.info("joDataClient: "+ joDataClient.toString() );
		return joDataClient;
	}
	
	
    
}