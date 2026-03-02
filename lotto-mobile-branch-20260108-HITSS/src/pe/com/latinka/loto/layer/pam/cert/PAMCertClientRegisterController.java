package pe.com.latinka.loto.layer.pam.cert;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.card.setup.MailingForSale;
import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientRegisterBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutClient;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.ApiNovusUtils;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetNovusId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;

/**
 * <p>
 * NOMBRE: PAMCertClientRegisterController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador de registro de cuentas
 * <br></p>
 * <p>
 * VERSION: 2750 
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Depuración de comentarios y cambio en la validación SMS
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class PAMCertClientRegisterController {
    @Autowired
    private ClientRegisterBo beanClientRegisterBo;
	@Autowired
	private ClientAccountBo beanClientAccountBo;
	@Autowired
    private SecurityUtils securityUtils;
	@Autowired
    private IntralotUtils intralotUtils;
	@Autowired
	private SecurityLoginBo securityLoginBo;
	
    @RequestMapping("/client_lotocard_show_term")
    public ModelAndView showTerm(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_lotocard_show_term"); 
    		return new ModelAndView("client/interface-terminos-condiciones");
            //return new ModelAndView("client/interface-term");
        } catch (Exception e) {
        	LoggerApi.severe(e);
        	return new ModelAndView("client/interface-terminos-condiciones");
            //return new ModelAndView("client/interface-term");
        } finally {
			LoggerApi.Log.info("-------------- END client_lotocard_show_term"); 
        }
    }
        
    @RequestMapping(value = "/validation-activation")
    public void validarActivacion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
            String outData = "";
    		String mobileSmsStatus  = "";
            JsonObject o = new JsonObject();
            
            if(session.getAttribute("clientIdRegister")!=null) {
            	Client cliente = beanClientAccountBo.findClientById(Integer.parseInt(session.getAttribute("clientIdRegister").toString()));
            	mobileSmsStatus = cliente.getMobileStatus();
            }
            
            o.addProperty("mobileSmsStatus", mobileSmsStatus);
    		outData = callback + "(" + o + ")";
			out.print(outData);
    	}catch (Exception e) {
    		LoggerApi.severe(e);
		}
    }   	
    
    @RequestMapping("/client_lotocard_show_form")
    public ModelAndView showForm(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_lotocard_show_form"); 
            HttpSession session = request.getSession();
            
            ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
            if(client != null) {
            	return new ModelAndView("home/interface-home");
            }
            
            session.setAttribute("locacionTYC", "register");
            if(request.getParameter("operatorId")!=null) session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            request.setAttribute("OperatorId", request.getParameter("operatorId"));
            request.setAttribute("redirectGame", request.getParameter("redirectGame"));
            request.setAttribute("urlRedirect5588", request.getParameter("urlRedirect5588"));
            request.setAttribute("urlRedirect5587", request.getParameter("urlRedirect5587"));
            request.setAttribute("ref", request.getParameter("ref"));
            //-----------
//            session.setAttribute("redirectGame", request.getParameter("redirectGame"));
//            session.setAttribute("urlRedirect5588", request.getParameter("urlRedirect5588"));
//            session.setAttribute("ref", request.getParameter("ref"));
            if(request.getParameter("operatorId")!=null) {
            	session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            	session.setAttribute("OperatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            }else {
            	session.setAttribute("operatorId", "");
            	session.setAttribute("OperatorId", "");
            }
            if(request.getParameter("redirectGame")!=null) {
            	session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
            }else {
            	session.setAttribute("redirectGame", "");
            }
            if(request.getParameter("ref")!=null) {
            	session.setAttribute("ref", String.valueOf(request.getParameter("ref")).toString().trim());
            }else {
            	session.setAttribute("ref", "");
            }
            if(request.getParameter("urlRedirect5588")!=null) {
            	session.setAttribute("urlRedirect5588", String.valueOf(request.getParameter("urlRedirect5588")).toString().trim());
            }else {
            	session.setAttribute("urlRedirect5588", "");
            }
            if(request.getParameter("urlRedirect5587")!=null) {
            	session.setAttribute("urlRedirect5587", String.valueOf(request.getParameter("urlRedirect5587")).toString().trim());
            }else {
            	session.setAttribute("urlRedirect5587", "");
            }
            //-----------            
            Constantes.BANNER_REGISTRO = String.valueOf(ConnectionFactory.operationProperty("bannerRegistro", Constantes.contextSale)).toString().trim();
            return new ModelAndView("client/interface-register_v2");
        } catch (Exception e) {
        	LoggerApi.severe(e);
        	Constantes.BANNER_REGISTRO = String.valueOf(ConnectionFactory.operationProperty("bannerRegistro", Constantes.contextSale)).toString().trim();
            return new ModelAndView("client/interface-register_v2");
        }finally {
			LoggerApi.Log.info("-------------- END client_lotocard_show_form"); 
		}
    }

    @RequestMapping(value = "/activar")
    public String formActivar(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) {	
    	return "client/interface-activate_form";
    }
    
    

    @SuppressWarnings("static-access")
	@RequestMapping("/client_lotocard_register_form")
    public void registerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log = "client_lotocard_register_form";
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        try {
    		LoggerApi.Log.info("-------------- START client_lotocard_register_form"); 
            MailingForSale mailingForSale = new MailingForSale();
            String pUser = request.getParameter("user");
            String pPassword = request.getParameter("password").trim();
            //String rePassword = request.getParameter("password02").toUpperCase().trim();
            String rePassword = pPassword;
            String pMail1 = request.getParameter("email");
            String pMail2 = request.getParameter("email");
            String pNombre = request.getParameter("name");
            String pApPaterno = request.getParameter("lastname");
            String pApMaterno = "";//request.getParameter("maidenname");
            String pTypeId = request.getParameter("typeDoc");
            String pNumberId = "";//request.getParameter("numberDoc");
            String pBirthDate = request.getParameter("dateBirth");
            String pMobilePhone = request.getParameter("mobilePhone");
            String pConfirm = "Y";
            
            // ATACO - BONO LIGA1
            String bonoQR = request.getParameter("channel")!=null ? request.getParameter("channel") : null ;
             
            if(bonoQR != null)
            	bonoQR = StringLib.decodeLongLabel(bonoQR).trim();
            // fin ATACO - BONO LIGA1
            
            if("DNI".equals(pTypeId)) {
            	pNumberId = request.getParameter("numberDoc");
            }else if("PASAP".equals(pTypeId)) {
            	pNumberId = request.getParameter("documento-pasap");
            }else if("CAREX".equals(pTypeId)) {
            	pNumberId = request.getParameter("documento-carex");
            }            
            String verifyPersonalInformation = intralotUtils.verifyPersonalInformation(pTypeId, pNumberId, pNombre, pApPaterno);     
            if (!verifyPersonalInformation.equals("OK")) {
                o.addProperty("status", "KO");
                o.addProperty("message", verifyPersonalInformation);                
                LoggerApi.Log.info(log+":" + verifyPersonalInformation);
                return;
               
            }
            request.setAttribute("pNumberId", pNumberId);
            Calendar calendario = Calendar.getInstance();
    		calendario.setTime(sdf.parse(pBirthDate));
    		Calendar calendario2 = Calendar.getInstance();
    		calendario.add(Calendar.YEAR, 18);
    		calendario2.setTime(sdf.parse(pBirthDate));
    		calendario2.add(Calendar.YEAR, 101);
    		boolean flagEdad = true;
    		if(calendario.getTime().after(new Date())){
    			o.addProperty("status", "KO");
            	o.addProperty("message", "Los juegos son solo para mayores de 18 años.");
            	flagEdad = false;
    		}
    		
    		if(calendario2.getTime().before(new Date())){
    			o.addProperty("status", "KO");
            	o.addProperty("message", "Los juegos son solo para menores de 101 años.");
            	flagEdad = false;
    		}
            
            String verifyString = intralotUtils.verifyPassword(pNumberId, pPassword, rePassword);     
            if (!verifyString.equals("OK")) {
                o.addProperty("status", "KO");
                o.addProperty("message", verifyString);
                
                LoggerApi.Log.info(pUser+":" + verifyString);
               
            }
            
          //validar que contraseña no contenga datos del usuario
        	String verifyString2 = intralotUtils.verifyPasswordRegisterClient(pPassword, pNombre, pApPaterno, pNumberId, pBirthDate, pMobilePhone);
        	if (!verifyString2.equals("OK")) {
        		o.addProperty("status", 0);
        		o.addProperty("message", "KO");
                o.addProperty("info", verifyString2);
                o.addProperty("rtitle", "Validaci&oacute;n de datos");
            	o.addProperty("rmessage", verifyString2);
//                out.print(o);
                return;
               
            }
            String verifyEMailString = intralotUtils.verifyEmail(pMail1);     
            if (!verifyEMailString.equals("OK")) {
                o.addProperty("status", "KO");
                o.addProperty("message", verifyEMailString);               
            }
            
            boolean verifyMailString = intralotUtils.verifySintaxMail(pMail1);
            if (!verifyMailString) {
                o.addProperty("status", "KO");
                o.addProperty("message", "Ingresar una direcci&oacute;n de correo correcto");
              
            }
            
            boolean verifyMobilePhone = intralotUtils.verifySintaxMobilePhone(pMobilePhone);
            if (!verifyMobilePhone) {
                o.addProperty("status", "KO");
                o.addProperty("message", "Ingresar un tel&eacute;fono correcto");
               
            }
            boolean flagdate = intralotUtils.validateDateFormat(pBirthDate); 
            if(!flagdate) {
            	o.addProperty("status", "KO");
                o.addProperty("message", "Error en el formato de fecha");
            }
            
            //validar nacionalidad, domicilio, departamento, provincia, distrito
            String nacionalidad = request.getParameter("nacionalidad");
            String domicilio = request.getParameter("domicilio");
            String departamento = request.getParameter("departamento");
            String provincia = request.getParameter("provincia");
            String distrito = request.getParameter("distrito");    
            String verifyContactInformation = intralotUtils.verifyContactInformation(nacionalidad, domicilio, departamento, provincia, distrito);
            if (!verifyContactInformation.equals("OK")) {
            	o.addProperty("status", 0);
                o.addProperty("message", "KO");
                o.addProperty("info", verifyContactInformation);
                o.addProperty("rtitle", "Validaci&oacute;n de datos");
            	o.addProperty("rmessage", verifyContactInformation);
            	LoggerApi.Log.info(log+":" + verifyContactInformation);
                return;
            }
            
            if (verifyEMailString.equals("OK") && verifyString.equals("OK") && verifyMailString && flagdate && verifyMobilePhone && flagEdad) {
            	HttpSession session = request.getSession();
            	Integer web = 0;
            	if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587")) {
            		web = 5587;
                }else if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5588")) {
                	web = 5588;
                }else {
                	web = 1;
                }
            	
	            //servicio registerPlayer
	    		JsonObject jdata = new JsonObject();
	    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("nombres", pNombre);
	    		jdata.addProperty("apellidos", (pApPaterno+" "+pApMaterno).trim());
	    		jdata.addProperty("tipoDocumento", pTypeId);
	    		jdata.addProperty("numeroDocumento", pNumberId.trim());
	    		jdata.addProperty("fechaNacimiento", pBirthDate);
//	    		if(pPassword!=null)pPassword = intralotUtils.encrypt(pPassword.toUpperCase());
	    		jdata.addProperty("password", pPassword);
	    		jdata.addProperty("email", pMail1.toLowerCase().trim());
	    		jdata.addProperty("celular", pMobilePhone.trim());
	    		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	    		jdata.addProperty("confirm", pConfirm);
	    		jdata.addProperty("operatorId", web);
	    		jdata.addProperty("platform", Constantes.PLATAFORM);
	    		jdata.addProperty("region", "");
	    		jdata.addProperty("nacionalidad", nacionalidad);
	    		jdata.addProperty("direccion", domicilio);
	    		jdata.addProperty("departamento", departamento);
	    		jdata.addProperty("provincia", provincia);
	    		jdata.addProperty("distrito", distrito);
	    		jdata.addProperty("ppeFlag", "1");
	            
	    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "newRegister"));//registerPlayer
	            
	            if (convertedObject.getString("estado").equals("OK")) {
	            	String welcome = "Bienvenido a La Tinka, tu registro se ha realizado correctamente.";
	                LoggerApi.Log.info("clientId="+convertedObject.getString("clientId")+" Nombre="+pNombre+" Mail1="+pMail1+" TEMPLATE="+mailingForSale.MAIL_TEMPLATE_ACTIVE);
	                Integer result = 200;
	                String code = "200";
	                	                
	                session.setAttribute("cel", pMobilePhone);
	                session.setAttribute("user1", pNumberId.toUpperCase());
	                session.setAttribute("pass", pPassword);
	                
	                
	                ClientProcedureGetLoginData client = null;
	                request.setAttribute("nuevoregistro", "true");
	                client = securityUtils.obtenerLogin(request, intralotUtils, beanClientAccountBo);
	                if(!client.getStatus().equals("OK")) {
	                	o.addProperty("status", 0);
//		            	o.addProperty("message", convertedObject.getString("mensaje"));
		            	o.addProperty("rtitle", client.getTitle());
		            	o.addProperty("rmessage", client.getMessage());
		            	o.addProperty("rbutton", client.getButton());
		            	return;
	                }
                	session.setAttribute("register-login", "register-login");
                	
                	session.setAttribute("clientIdRegister", client.getClientId());
                	session.setAttribute("clientSesionTMP", client);
	                // SMS ENVIO
	                /*ResultBean beanResponseSendSms = securityUtils.putSmsClient(putClient.getClientId(), pMobilePhone.trim(), beanSecurityLoginBo);
	                result = beanResponseSendSms.getState();
	                code = beanResponseSendSms.getCode();
                	if(!beanResponseSendSms.getMessage().equals("")) o.addProperty("message", beanResponseSendSms.getMessage());*/
                	
                	LoggerApi.Log.info("/client_lotocard_register_form clientId="+client.getClientId());//+" sms-state="+beanResponseSendSms.getState()+ " sms-code="+beanResponseSendSms.getCode());
                	o.addProperty("message", welcome);
	                o.addProperty("status", result);
	                o.addProperty("code", code);
	                o.addProperty("redireccion", redireccionarUltimaJugada(session));
	                if(session.getAttribute("operatorId")!=null &&!session.getAttribute("operatorId").equals("") && 
	                		String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())) {
	                	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
	                	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== client_lotocard_register_form status="+session.getAttribute("operatorId").toString().trim());
	                }
	                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())) {
	                	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
	                }

	                /*se envia client id para crear cliente novus id por ajax*/
	    			o.addProperty("clientid", client.getClientId());
	    			/*fin*/
	    			
	    			//se guarda dato bonoQR
	    			if(bonoQR != null)
	    				securityLoginBo.updateBonoQr(client.getClientId(), bonoQR);
	    			
	            } else {
	            	o.addProperty("status", 0);
	            	o.addProperty("message", convertedObject.getString("mensaje"));
	            	o.addProperty("rtitle", convertedObject.getString("resp_title"));
	            	o.addProperty("rmessage", convertedObject.getString("resp_message"));
	            	o.addProperty("rbutton", convertedObject.getString("resp_button"));
	            } 
	        }else {
	        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
	        	o.addProperty("rmessage", o.get("message").getAsString());
	        }
        } catch (Exception e) {
        	LoggerApi.severe(e);
        	o.addProperty("status", 0);
        	o.addProperty("message", "Problemas en el registro, int&eacute;ntelo en unos momentos");
        	o.addProperty("rtitle", "Problemas en el registro");
        	o.addProperty("rmessage", "Int&eacute;ntelo en unos momentos");
        } finally {
			LoggerApi.Log.info("-------------- END client_lotocard_register_form");
        	out.print(o);
		}
    }

    /**
     * Metodo que obtiene el ultimo boleto de juego realizado
     * @param session
     * @return redireccion (url) del ultimo boleto realizado
     */
	private String redireccionarUltimaJugada(HttpSession session) throws NullPointerException {	
		String redireccion="home.html";
    	try {
    		@SuppressWarnings("rawtypes")
			Map playList = (Map) session.getAttribute("lastJugada");
    		
    		try {if (StringUtils.isNotEmpty((String) playList.get("tinka_cad"))) {
    			
            	redireccion = "game_tinka_show_shoppingcart.html";
            }}catch (Exception e) {}
    		try {if (StringUtils.isNotEmpty((String) playList.get("ganadiario_cad"))) {
    			
            	redireccion = "game_ganadiario_show_shoppingcart.html";
            }}catch (Exception e) {}
    		try {if (StringUtils.isNotEmpty((String) playList.get("id_"))) {
    			
            	redireccion = "game_ganagol_show_shoppingcart.html";
            }}catch (Exception e) {}
    		try {if (StringUtils.isNotEmpty((String) playList.get("kabala_cad"))) {
    			
            	redireccion = "game_kabala_show_shoppingcart.html";
            }}catch (Exception e) {}

        } catch (Exception e) {}
    	
		return redireccion;
	}
	
	
	 @RequestMapping(value = "/recuperar-contrasenia")//recuperar-password
	   public String recuperarPassword(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		 HttpSession session = request.getSession();
    	 if(session.getAttribute("operatorId")!=null) {
    		session.removeAttribute("operatorId");
    	 }
		 return "client/interface-recuperar-password";
	   }
	 
	 @RequestMapping(value = "/cambiar-contrasenia")//cambiar-password
	   public String cambiarContrasenia(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		 String log="cambiar-contrasenia";
    	 LoggerApi.Log.info("-------------- START "+log);
    	 JSONObject convertedObject=null;
    	 String redirectUrl = Constantes.eCommerceHome;
		 String codigoPass = (request.getParameter("param1")!=null)?request.getParameter("param1").replaceAll(" ", "\\+"):"";
		 String email = (request.getParameter("param2")!=null)?request.getParameter("param2"):"";
		 
		 		 
		 try {
				JsonObject jdata = new JsonObject();
				String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi",	Constantes.contextPlayerWebApi);
				jdata.addProperty("token", tokenPlayerWebApi);
				jdata.addProperty("param1", codigoPass);
				jdata.addProperty("param2", email);  
				jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
				jdata.addProperty("platform", Constantes.PLATAFORM);
				convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "validateLink"));
				if (convertedObject.has("status") && convertedObject.getString("status").equals("OK")) {
					HttpSession session = request.getSession();
					session.setAttribute("clientIdRecoveryPass", convertedObject.get("clientId"));
					objectModelMap.put("codigoPass", codigoPass);
				    objectModelMap.put("email", email);
					return "client/interface-cambiar-password";
				}else {				
					 return "redirect:" + redirectUrl;
				}
	            
		 } catch (Exception e) {
	          	LoggerApi.severe(e);
	          	return "redirect:" + redirectUrl;
         } finally {
        	 	LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());        	
         }		 	 
	   	 
	   }
	 
	 @RequestMapping(value = "/recuperar-user")
	   public String recuperarUser(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
	   	 return "client/interface-recuperar-user";
	   }
	 
	 @RequestMapping(value = "/recuperar-contrasenia-ta")//recuperar-password-ta
	   public String recuperarPasswordTA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
	   	 return "game/teapuesto/tav2_recuperar_password";
	   }
	 
	 @RequestMapping(value = "/cambiar-contrasenia-ta")//cambiar-password-ta
	   public String cambiarContraseniaTA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		 String log="cambiar-contrasenia-ta";
    	 LoggerApi.Log.info("-------------- START "+log);
    	 JSONObject convertedObject=null;
    	 String redirectUrl = Constantes.tav2GameProviderCloseUrl;    	 

		 String codigoPass = (request.getParameter("param1")!=null)?request.getParameter("param1").replaceAll(" ", "\\+"):"";
		 String email = (request.getParameter("param2")!=null)?request.getParameter("param2"):"";
		 		 
		 try {
			JsonObject jdata = new JsonObject();
			String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi",	Constantes.contextPlayerWebApi);
			jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("param1", codigoPass);
			jdata.addProperty("param2", email);
			jdata.addProperty("operatorId", 5588);
			jdata.addProperty("platform", Constantes.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "validateLink"));
			if (convertedObject.has("status") && convertedObject.getString("status").equals("OK")) {
				HttpSession session = request.getSession();
				session.setAttribute("clientIdRecoveryPass", convertedObject.get("clientId"));
				objectModelMap.put("codigoPass", codigoPass);
			    objectModelMap.put("email", email);
			    return "game/teapuesto/tav2_cambiar_password";
			}else {				
				return "redirect:" + redirectUrl;
			}	           
		 } catch (Exception e) {
	         LoggerApi.severe(e);
	         return "redirect:" + redirectUrl;
	      } finally {
	     	LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
	      	
	      }
	   	 
	   }
	 
	 
	 @RequestMapping(value = "/recuperar-user-ta")
	   public String recuperarUserTA(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
	   	 return "game/teapuesto/tav2_recuperar_user";
	   }
	 
	 @RequestMapping(value = "/create-novus-id")
	    public void createNovusId(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        PrintWriter out = response.getWriter();
	        Integer p_clientId = Integer.parseInt(request.getParameter("client-id"));
	        JsonObject o = new JsonObject();
	        
	        ClientProcedureGetNovusId clientProcedureGetNovusId = securityLoginBo.findGetNovusId(p_clientId);
	        
	        /*se envia datos del nuevo cliente a novus y se actuliza tabla client cl_novus_id*/
	        ApiNovusUtils apiNovus = new ApiNovusUtils("/create-novus-id", p_clientId.longValue(), clientProcedureGetNovusId.getClientUser(), clientProcedureGetNovusId.getClientMail(), clientProcedureGetNovusId.getNombre());
			Long novusid = apiNovus.createUser();
			securityLoginBo.updateNovusId(p_clientId, novusid);
			/*fin*/
	        
	        out.print(o);
	    }
	    
	    @RequestMapping(value ="/documentvalidation")
	    public void documentvalidation(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
	    	JsonObject o = new JsonObject();
	    	response.setCharacterEncoding(Constantes.CHARSET_UTF8);
	    	PrintWriter out = response.getWriter();
	     	String tipoDocumento ="";
	    	String numeroDocumento="";
	    	
	    	try {
	    		tipoDocumento         = request.getParameter("docType");
	    		numeroDocumento         = request.getParameter("document");
	        	String mensajeError ="";
	        	
	        	if(tipoDocumento==null || tipoDocumento.trim().isEmpty()) {
	        		mensajeError ="Debes ingresar tipo de documento";
	        	}
	        	if(numeroDocumento==null || numeroDocumento.trim().isEmpty()) {
	        		mensajeError ="Debes ingresar N° de documento";
	        	}
	        	
	        	if(mensajeError.isEmpty()) {        				        	
	        		JsonObject jdata = new JsonObject();
	        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
		    		jdata.addProperty("token", tokenPlayerWebApi);
		    		jdata.addProperty("tipoDocumento", tipoDocumento);
		    		jdata.addProperty("numeroDocumento", numeroDocumento.trim());
		    		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
		    		jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
		    		jdata.addProperty("platform", Constantes.PLATAFORM);
		            
		    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
		            
		            if (convertedObject.getString("status").equals("OK")) {
		            	o.addProperty("message", convertedObject.getString("status"));
		            	o.addProperty("flag", convertedObject.getString("passwordFlag"));
		            	o.addProperty("locked", convertedObject.getString("listaNegra"));
		            }else {
		            	o.addProperty("message", convertedObject.getString("status"));
		            	if(convertedObject.getString("resp_title")!=null) {
		            		o.addProperty("titulo", convertedObject.getString("resp_title"));
			            	o.addProperty("mensaje", convertedObject.getString("resp_message"));
			            	o.addProperty("boton", convertedObject.getString("resp_button"));
		            	}
		            }
		        	 
		        	
	        	}else {
	        		o.addProperty("message", "KOO");
	    			o.addProperty("error", mensajeError);
	        	}
	        	out.print(o);
			} catch (Exception e) {
				o.addProperty("message", "KO");
				o.addProperty("error", "Revise los datos antes de enviarlos");
				out.print(o);
			}
	    }
	 
	 @RequestMapping("/client_lotocard_complete_form")
	    public ModelAndView completeForm(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		 String log="client_lotocard_complete_form";
	        try {	        	
	    		LoggerApi.Log.info("-------------- START "+log); 
	            HttpSession session = request.getSession();
	            
	            
	            ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
	            if(client != null) {
	            	return new ModelAndView("home/interface-home");
	            }
	            
	            session.setAttribute("locacionTYC", "register");
	            String typedoc=request.getParameter("typedoc");
	            String document=request.getParameter("document");
//	            String urlref = request.getParameter("urlref");
//	            request.setAttribute("typedoc", typedoc);
//	            request.setAttribute("document", document);
	            session.setAttribute("typedoc", typedoc);
	            session.setAttribute("document", document);
//	            session.setAttribute("urlref", urlref);
	            
	            //obtener celular	            
	            String celular="";
	            JsonObject jdata = new JsonObject();
        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", typedoc);
	    		jdata.addProperty("numeroDocumento", document.trim());
	    		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	    		jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
	    		jdata.addProperty("platform", Constantes.PLATAFORM);	            
	    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
	    		
	    		if (convertedObject.getString("status").equals("OK")) {
	    			if(!convertedObject.getString("passwordFlag").equals("9")) {
	    				return new ModelAndView("redirect:client_lotocard_show_form.html");
		    		}
	            	celular=convertedObject.getString("celular");
	            	session.setAttribute("celular", celular);
	            	int length=celular.length();
	            	celular=celular.substring(length-3, length);
	            	celular="*** *** "+celular;	            	
	            }else {
	            	return new ModelAndView("redirect:client_lotocard_show_form.html");
	            }
	    		session.setAttribute("cel", celular);
//	    		request.setAttribute("celular", celular);
	            
	            if(request.getParameter("operatorId")!=null) session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
	            request.setAttribute("OperatorId", request.getParameter("operatorId"));
	            request.setAttribute("redirectGame", request.getParameter("redirectGame"));
	            request.setAttribute("urlRedirect5588", request.getParameter("urlRedirect5588"));
	            request.setAttribute("urlRedirect5587", request.getParameter("urlRedirect5587"));
	            request.setAttribute("ref", request.getParameter("ref"));
	            
	            if(request.getParameter("operatorId")!=null) {
	            	session.setAttribute("operatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
	            	session.setAttribute("OperatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
	            }else {
	            	session.setAttribute("operatorId", "");
	            	session.setAttribute("OperatorId", "");
	            }
	            if(request.getParameter("redirectGame")!=null) {
	            	session.setAttribute("redirectGame", String.valueOf(request.getParameter("redirectGame")).toString().trim());
	            }else {
	            	session.setAttribute("redirectGame", "");
	            }
	            if(request.getParameter("ref")!=null) {
	            	session.setAttribute("ref", String.valueOf(request.getParameter("ref")).toString().trim());
	            }else {
	            	session.setAttribute("ref", "");
	            }
	            if(request.getParameter("urlRedirect5588")!=null) {
	            	session.setAttribute("urlRedirect5588", String.valueOf(request.getParameter("urlRedirect5588")).toString().trim());
	            }else {
	            	session.setAttribute("urlRedirect5588", "");
	            }
	            if(request.getParameter("urlRedirect5587")!=null) {
	            	session.setAttribute("urlRedirect5587", String.valueOf(request.getParameter("urlRedirect5587")).toString().trim());
	            }else {
	            	session.setAttribute("urlRedirect5587", "");
	            } 
	            Constantes.BANNER_REGISTRO = String.valueOf(ConnectionFactory.operationProperty("bannerRegistro", Constantes.contextSale)).toString().trim();
	            return new ModelAndView("client/interface-complete-registration_v2");
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	        	Constantes.BANNER_REGISTRO = String.valueOf(ConnectionFactory.operationProperty("bannerRegistro", Constantes.contextSale)).toString().trim();
	            return new ModelAndView("client/interface-complete-registration_v2");
	        }finally {
				LoggerApi.Log.info("-------------- END "+log); 
			}
	    }
	 
	 @SuppressWarnings("static-access")
		@RequestMapping("/client_lotocard_complete_registration_form")
	    public void completeRegistrationForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String log="client_lotocard_complete_registreation_form";
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    	PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        JsonObject o = new JsonObject();
	        try {
	    		LoggerApi.Log.info("-------------- START "+log); 
	            MailingForSale mailingForSale = new MailingForSale();
	            String pPassword = request.getParameter("password").trim();
	            String rePassword = pPassword;
	            String pMail1 = request.getParameter("email");
	            String pNombre = request.getParameter("name");
	            String pApellidos = request.getParameter("lastname");
	            HttpSession session = request.getSession();
	            String pTypeId = session.getAttribute("typedoc").toString();
	            String pNumberId = session.getAttribute("document").toString();
	            String pBirthDate = request.getParameter("dateBirth");
	            String pMobilePhone = request.getParameter("mobilePhone1");
	            String pConfirm = "Y";
	            
	            // ATACO - BONO LIGA1
	            String bonoQR = request.getParameter("channel")!=null ? request.getParameter("channel") : null ;
	             
	            if(bonoQR != null)
	            	bonoQR = StringLib.decodeLongLabel(bonoQR).trim();
	            // fin ATACO - BONO LIGA1
	            
	            String verifyPersonalInformation = intralotUtils.verifyPersonalInformation(pTypeId, pNumberId, pNombre, pApellidos);     
	            if (!verifyPersonalInformation.equals("OK")) {
	                o.addProperty("status", "KO");
	                o.addProperty("message", verifyPersonalInformation);                
	                LoggerApi.Log.info(log+":" + verifyPersonalInformation);
	                return;
	               
	            }
	            
	            request.setAttribute("pNumberId", pNumberId);
	            Calendar calendario = Calendar.getInstance();
	    		calendario.setTime(sdf.parse(pBirthDate));
	    		Calendar calendario2 = Calendar.getInstance();
	    		calendario.add(Calendar.YEAR, 18);
	    		calendario2.setTime(sdf.parse(pBirthDate));
	    		calendario2.add(Calendar.YEAR, 101);
	    		boolean flagEdad = true;
	    		if(calendario.getTime().after(new Date())){
	    			o.addProperty("status", "KO");
	            	o.addProperty("message", "Los juegos son solo para mayores de 18 años.");
	            	flagEdad = false;
	    		}
	    		
	    		if(calendario2.getTime().before(new Date())){
	    			o.addProperty("status", "KO");
	            	o.addProperty("message", "Los juegos son solo para menores de 101 años.");
	            	flagEdad = false;
	    		}
	            
	            String verifyString = intralotUtils.verifyPassword(pNumberId, pPassword, rePassword);     
	            if (!verifyString.equals("OK")) {
	                o.addProperty("status", "KO");
	                o.addProperty("message", verifyString);
	                
	                LoggerApi.Log.info(pNumberId+":" + verifyString);
	               
	            }
	            
	          //validar que contraseña no contenga datos del usuario
	        	String verifyString2 = intralotUtils.verifyPasswordRegisterClient(pPassword, pNombre, pApellidos, pNumberId, pBirthDate, pMobilePhone);
	        	if (!verifyString2.equals("OK")) {
	        		o.addProperty("status", 0);
	        		o.addProperty("message", "KO");
	                o.addProperty("info", verifyString2);
	                o.addProperty("rtitle", "Validaci&oacute;n de datos");
	            	o.addProperty("rmessage", verifyString2);
//	                out.print(o);
	                return;
	            }
	            
	            String verifyEMailString = intralotUtils.verifyEmail(pMail1);     
	            if (!verifyEMailString.equals("OK")) {
	                o.addProperty("status", "KO");
	                o.addProperty("message", verifyEMailString);               
	            }
	            
	            boolean verifyMailString = intralotUtils.verifySintaxMail(pMail1);
	            if (!verifyMailString) {
	                o.addProperty("status", "KO");
	                o.addProperty("message", "Ingresar una direcci&oacute;n de correo correcto");
	              
	            }
	            
//	            boolean verifyMobilePhone = intralotUtils.verifySintaxMobilePhone(pMobilePhone);
//	            if (!verifyMobilePhone) {
//	                o.addProperty("status", "KO");
//	                o.addProperty("message", "Ingresar un tel&eacute;fono correcto");
//	               
//	            }
	            boolean flagdate = intralotUtils.validateDateFormat(pBirthDate); 
	            if(!flagdate) {
	            	o.addProperty("status", "KO");
	                o.addProperty("message", "Error en el formato de fecha");
	            }
	            
	            //validar nacionalidad, domicilio, departamento, provincia, distrito
	            String nacionalidad = request.getParameter("nacionalidad");
	            String domicilio = request.getParameter("domicilio");
	            String departamento = request.getParameter("departamento");
	            String provincia = request.getParameter("provincia");
	            String distrito = request.getParameter("distrito");    
	            String verifyContactInformation = intralotUtils.verifyContactInformation(nacionalidad, domicilio, departamento, provincia, distrito);
	            if (!verifyContactInformation.equals("OK")) {
	            	o.addProperty("status", 0);
	                o.addProperty("message", "KO");
	                o.addProperty("info", verifyContactInformation);
	                o.addProperty("rtitle", "Validaci&oacute;n de datos");
	            	o.addProperty("rmessage", verifyContactInformation);
	            	LoggerApi.Log.info(log+":" + verifyContactInformation);
	                return;
	            }
	            
	            if (verifyEMailString.equals("OK") && verifyString.equals("OK") && verifyMailString && flagdate  && flagEdad) {
	            	
	            	Integer web = 0;
	            	if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587")) {
	            		web = 5587;
	                }else if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5588")) {
	                	web = 5588;
	                }else {
	                	web = 1;
	                }
	            	

		            //servicio updateClientData
		    		JsonObject jdata = new JsonObject();
		    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
		    		jdata.addProperty("token", tokenPlayerWebApi);
		    		jdata.addProperty("nombres", pNombre);
		    		jdata.addProperty("apellidos", pApellidos);
		    		jdata.addProperty("tipoDocumento", pTypeId);
		    		jdata.addProperty("numeroDocumento", pNumberId.trim());
		    		jdata.addProperty("fechaNacimiento", pBirthDate);
//		    		jdata.addProperty("password", intralotUtils.encrypt(pPassword.toUpperCase()));
		    		jdata.addProperty("password", pPassword);
		    		jdata.addProperty("email", pMail1.toLowerCase().trim());
//		    		jdata.addProperty("celular", pMobilePhone.trim());
		    		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
		    		jdata.addProperty("confirm", pConfirm);
		    		jdata.addProperty("operatorId", web);
		    		jdata.addProperty("platform", Constantes.PLATAFORM);
		    		jdata.addProperty("nacionalidad", nacionalidad);
		    		jdata.addProperty("direccion", domicilio);
		    		jdata.addProperty("departamento", departamento);
		    		jdata.addProperty("provincia", provincia);
		    		jdata.addProperty("distrito", distrito);
		    		jdata.addProperty("ppeFlag", "1");
		    		jdata.addProperty("celular", session.getAttribute("celular").toString());		    		
		            
		    		JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updateClientData"));
		            
		            if (convertedObject.getString("status").equals("OK")) {
		            	String welcome = "Bienvenido a La Tinka, tu registro se ha realizado correctamente.";
		                LoggerApi.Log.info("Documento="+pNumberId.trim()+" Nombre="+pNombre+" Mail1="+pMail1+" TEMPLATE="+mailingForSale.MAIL_TEMPLATE_ACTIVE);
		                Integer result = 201;
		                String code = "201";
		                	                
		                session.setAttribute("cel", pMobilePhone);
		                session.setAttribute("user1", pNumberId);
		                session.setAttribute("pass", pPassword);
		                session.setAttribute("registerType", "201");
		                
		                
		                ClientProcedureGetLoginData client = null;
		                request.setAttribute("nuevoregistro", "true");
		                client = securityUtils.obtenerLogin(request, intralotUtils, beanClientAccountBo);
	                	session.setAttribute("register-login", "register-login");
	                	session.setAttribute("celular", client.getMobilePhone());
	                	session.setAttribute("clientIdRegister", client.getClientId());
	                	session.setAttribute("clientSesionTMP", client);
		                // SMS ENVIO
		                /*ResultBean beanResponseSendSms = securityUtils.putSmsClient(putClient.getClientId(), pMobilePhone.trim(), beanSecurityLoginBo);
		                result = beanResponseSendSms.getState();
		                code = beanResponseSendSms.getCode();
	                	if(!beanResponseSendSms.getMessage().equals("")) o.addProperty("message", beanResponseSendSms.getMessage());*/
	                	
	                	LoggerApi.Log.info(log+"="+client.getClientId());//+" sms-state="+beanResponseSendSms.getState()+ " sms-code="+beanResponseSendSms.getCode());
	                	o.addProperty("message", welcome);
		                o.addProperty("status", result);
		                o.addProperty("code", code);
		                o.addProperty("redireccion", redireccionarUltimaJugada(session));
		                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())
		                		 && !session.getAttribute("operatorId").equals("")) {
		                	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
		                	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("=================="+ log+" status="+session.getAttribute("operatorId").toString().trim());
		                }
		                if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())
		                		&& !session.getAttribute("operatorId").equals("")) {
		                	o.addProperty("status", Integer.valueOf(session.getAttribute("operatorId").toString().trim()).intValue());
		                }
		                
		                /*se envia client id para crear cliente novus id por ajax*/
		    			o.addProperty("clientid", client.getClientId());
		    			/*fin*/
		    			
		    			//se guarda dato bonoQR
		    			if(bonoQR != null)
		    				securityLoginBo.updateBonoQr(client.getClientId(), bonoQR);
		    			
		            } else {
		            	o.addProperty("status", 0);
		            	o.addProperty("message", convertedObject.getString("message"));
		            	o.addProperty("rtitle", convertedObject.getString("resp_title"));
		            	o.addProperty("rmessage", convertedObject.getString("resp_message"));
		            	o.addProperty("rbutton", convertedObject.getString("resp_button"));
		            } 
		        }else {
		        	o.addProperty("rtitle", "Validaci&oacute;n de datos");
		        	o.addProperty("rmessage", o.get("message").getAsString());
		        }
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	        	o.addProperty("status", 0);
	        	o.addProperty("message", "Problemas en el registro, int&eacute;ntelo en unos momentos");
	        	o.addProperty("rtitle", "Problemas en el registro");
            	o.addProperty("rmessage", "Problemas en el registro, int&eacute;ntelo en unos momentos");
	        } finally {
				LoggerApi.Log.info("-------------- END "+log);
	        	out.print(o);
			}
	 }
	 

	    @RequestMapping(value = "/salirCA")
	    public void logoutUserCA(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	LoggerApi.Log.info("salirCA");
	    	PrintWriter out = response.getWriter();
	    	JsonObject o = new JsonObject();
	    	HttpSession session = request.getSession();
	        ClientUpdateProcedureClosedSession closedSession=null;
	        try {
	            if (session != null) {
	            	JsonParser jparser = new JsonParser();
	            	if(session.getAttribute("sessionData")!=null) {
	            		JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
	    	        	Integer clientId=sessionData.get("clientId").getAsInt();                    
	                    //closedSession=clientBo.closedSession(clientId);
	                    LoggerApi.Log.info("closedSession: estado="+closedSession.getState()+" mensaje="+closedSession.getMessage());
	            	}            	
	                session.invalidate();
	            }
	            o.addProperty("eCommerceHome", ConnectionFactory.operationProperty("eCommerceHome", "Constants.contextSale"));
	            out.print(o);
	        } catch (Exception e) {
	            String id = LoggerApi.severe(e);
	            //request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos." + id);
	            o.addProperty("eCommerceHome", ConnectionFactory.operationProperty("eCommerceHome", "Constants.contextSale"));
	            out.print(o);
	        } 
	    }
		
		
	  //obtener valores del la configuración limite 
	    @RequestMapping(value = "/getDataSelfControl")
	    public void getDataSelfControl(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
	    	UUID uuid = UUID.randomUUID();
			LoggerApi.Log.info("-------------- START getDataSelfControl uuid="+uuid.toString());
			//response.setCharacterEncoding(Constants.CHARSET_UTF8);
			PrintWriter out = response.getWriter();
	        JsonObject o = new JsonObject();
	    	try {
				HttpSession session = request.getSession();
				/* if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
					&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) { */
					
					Integer idClient = (Integer)session.getAttribute("Constants.USR_SESION");
	                ClientProcedureGetSelfcontrol getSelfcontrol = new ClientProcedureGetSelfcontrol();
	             	
	                o.addProperty("clientId", getSelfcontrol.getClientId());
					o.addProperty("showDisable",getSelfcontrol.getShowDisable());
					o.addProperty("typeLimit",getSelfcontrol.getTypeLimit());
					o.addProperty("valueLimit",getSelfcontrol.getValueLimit());
					o.addProperty("dateLimit",getSelfcontrol.getDateLimit());


				/* }else {
					o.addProperty("controlFlag", "KO");
				} */
				out.print(o);
			} catch (Exception e) {
				o.addProperty("status", "ERROR");
				out.print(o);
				LoggerApi.severe(e);
		    } 
	    	LoggerApi.Log.info("-------------- END getDataSelfControl uuid="+uuid.toString());
	    }
	    
	 
}
