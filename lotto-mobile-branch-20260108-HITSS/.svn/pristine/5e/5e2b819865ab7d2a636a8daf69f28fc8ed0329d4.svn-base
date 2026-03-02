package pe.com.intralot.loto.layer.view.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientSecurityWhiteList;
import pe.com.intralot.loto.layer.model.pojo.GetClientSecurity;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.lib.ConnectionFactory;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.wurfl.WurflDevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.dto.pam.LoginDataResponse;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.ApiClient;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.utils.StringLib;

import static pe.com.intralot.loto.utils.Constantes.getPropertyContextSale;

import pe.com.intralot.loto.layer.model.pojo.Tinka;

@Controller
public class HomeController {

	//static final Log logger = LogFactory.getLog(HomeController.class);
	@Autowired
	private IntralotUtils intralotUtils;
	
	@Autowired
	private ClientAccountBo beanClientAccountBo;
	
	@Autowired
    private SecurityUtils securityUtils;
	
	@Autowired
	private ClientSaleBo clientSaleBo;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/home")	
	public ModelAndView home(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
	
		try {			
			LoggerApi.Log.info("-------------- START HomeController");
			
			WurflDevice device = (WurflDevice)DeviceUtils.getCurrentDevice(request);
			//String userAgent = StringUtils.isNotEmpty(device.getUserAgent()) ? device.getUserAgent() : request.getHeader("User-Agent");
			String userAgentHeader = request.getHeader("User-Agent");
			LoggerApi.Log.info("userAgentHeader :: " + userAgentHeader);
			Map capabilities = device.getCapabilities();
			String resolution_width = MapUtils.getString(capabilities, "resolution_width");
			String resolution_height = MapUtils.getString(capabilities, "resolution_height");
			String physical_screen_width = MapUtils.getString(capabilities, "physical_screen_width");
			String physical_screen_height = MapUtils.getString(capabilities, "physical_screen_height");
			String mobile_browser = MapUtils.getString(capabilities, "mobile_browser");
			String mobile_pointing = MapUtils.getString(capabilities,"pointing_method");
			String device_os = MapUtils.getString(capabilities,"device_os");
			String indicador="0";
			ClientProcedureGetDataClient dataClient = null;
			LoggerApi.Log.info( "resolution_width :: " + resolution_width +
								" resolution_height :: " + resolution_height +
								" physical_screen_width :: " + physical_screen_width +
								" physical_screen_height :: " + physical_screen_height +
								" mobile_browser :: " + mobile_browser +
								" mobile_pointing :: " + mobile_pointing +
								" device_os :: " + device_os);
						
			String phoneNumber = StringUtils.EMPTY;
			JsonObject joDataClientResponse=null;

			if(StringUtils.isEmpty(phoneNumber)){
				
				/*
				 * SE OBTIENE EL NUMERO TELEFONICO DEL DISPOSITIVO MEDIANTE EL ID DEL HEADER
				 * DE ACUERDO AL EQUIPO PUEDE ESTAR EN MIN O MAYUS
				 */
			
				String[] header = StringUtils.split("x-up-calling-line-id, HTTP_X_UP_CALLING_LINE_ID, X-TLF-MSISDN");
            							
				for(int i = 0; i < header.length; i++){
					String value = request.getHeader(header[i]);
					if(StringUtils.isNotEmpty(value)){
						phoneNumber = value;
						break;
					}
				}
				LoggerApi.Log.info("phoneNumber : [" + phoneNumber + "]");
			}
			
			
			/*
			 * AGREGAR EN SESSION EL TIPO DE EQUIPO QUE SE HA CONECTADO
			 * QWERTY O TOUCHCREEN
			 */
			//clickwheel
			//touchscreen
			HttpSession session = request.getSession();
			session.setAttribute("locacionTYC", "home");
			//if(session.getAttribute("welcomeBonusStatus")!=null && session.getAttribute("welcomeBonusStatus").toString().trim().equals("Reciente")) session.setAttribute("welcomeBonusMessagePor", "<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+session.getAttribute("welcomeBonusPercentaje").toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
            //else session.setAttribute("welcomeBonusMessagePor", "");
			if(StringUtils.isNotEmpty(mobile_pointing)) {
				session.setAttribute("mobile_pointing", mobile_pointing);
			 }else {
				session.setAttribute("mobile_pointing",Constantes.MOBILE_TOUCHSCREEN);
			}
			/*
			 * AGREGAR EN SESSION SI EL SISTEMA OPERATIVO ES ANDROID 
			 */
			//is_android==true
			//is_android==false

			if(userAgentHeader.toLowerCase().indexOf("android")>=0) {
				session.setAttribute("is_android", "true");
			 }else {
				session.setAttribute("is_android", "false");
			}
			
			if(session.getAttribute("is_android").equals("true")){
				indicador="1";
			}
			objectModelMap.put("indicador", indicador);
			
			try {
				StringUtils.isEmpty(session.getAttribute("LottoCar").toString());
			} catch (Exception e) {
				session.setAttribute("LottoCar",0);
				session.setAttribute("LottoCarTinka",0);
                session.setAttribute("LottoCarGanagol",0);
                session.setAttribute("LottoCarKabala",0);
                session.setAttribute("LottoCarGanadiario",0);
                session.setAttribute("LottoCarKinelo",0);
			}
			
			int sessionId = 0;
			int clientId = 0;
			if(session.getAttribute("clientId")!=null && !session.getAttribute("clientId").toString().trim().isEmpty()) {
				ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
				sessionId=user.getSessionId();
				clientId=user.getClientId();
				JsonObject jdata = new JsonObject();
       		 	String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", "");
	    		jdata.addProperty("numeroDocumento", "");
	    		jdata.addProperty("clientId", String.valueOf(clientId));
	    		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	    		jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
	    		jdata.addProperty("platform", Constantes.PLATAFORM);
		    	JsonParser jsonParser = new JsonParser();
                joDataClientResponse = jsonParser.parse(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData")).getAsJsonObject();
                dataClient=securityUtils.JsonConvertClient(joDataClientResponse);
//				dataClient = beanClientSaleBo.findGetDataClient(sessionId, clientId);
//				clientId = session.getAttribute("clientId").toString().trim();
				Client objectPojo=beanClientAccountBo.findClientById(clientId);
				
				if(objectPojo!=null) {
					session.setAttribute("saldo", intralotUtils.formatCurrency(objectPojo.getBalanceAmount())); 
//					if(objectPojo.getName() == null || (objectPojo.getLastname() == null && objectPojo.getMaidenname() == null) || 
//	    			objectPojo.getDocType() == null || objectPojo.getDocNumber() == null  || objectPojo.getBirthDate() == null ||
//					objectPojo.getUser() == null	|| objectPojo.getMail() == null 	   || objectPojo.getMobilePhone() == null ||
//   				    dataClient.getPpe() == null) {
//						session.setAttribute("isDataComplete", 0);
//	                }
					if(dataClient.getNombre() == null || dataClient.getApPaterno() == null || 
		                       dataClient.getTypeId() == null || dataClient.getNumberId() == null  || dataClient.getBirthDate() == null ||
		                       dataClient.getUser() == null	|| dataClient.getMail() == null 	   || dataClient.getMobilePhone() == null ||
		      				   dataClient.getPpe()==null) {
		                    	session.setAttribute("isDataComplete", 0);
		                    }
					else {
	                	session.setAttribute("isPerPolExp", dataClient.getPpe());
	                }
				}
				
			}
//			else {
//				String closeSession=(String)session.getAttribute("closeSession");
//        		if(closeSession!=null) {
//        			request.setAttribute("closeSession", closeSession);
////        			session.removeAttribute("closeSession");
//        		}
//        		String urlTA=(String)session.getAttribute("urlTA");
//        		if(urlTA!=null) {
//        			request.setAttribute("urlTA", urlTA);
////        			session.removeAttribute("urlTA");
//        		}
//			}
			if(session.getAttribute("visanetTransaction")!=null) {
            	request.setAttribute("visanetTransaction", session.getAttribute("visanetTransaction"));
            }
			LoggerApi.Log.info("home/interface-home");
			return new ModelAndView("home/interface-home");
         
		} catch(Exception e){
			LoggerApi.severe(e);	
			LoggerApi.Log.info("home/interface-home");
			return new ModelAndView("home/interface-home");
		} finally {
			LoggerApi.Log.info("-------------- END HomeController");
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/routeLastPlayed")
    public void routeMenuLastPlayed(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LoggerApi.Log.info("-------------- START routeMenuLastPlayed");
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        o.addProperty("message", "KO"); 
        String game = request.getParameter("game");
        String redireccion = "";
        //o.addProperty("message", "OK");
        HttpSession session = request.getSession();
        try {

	        if(StringUtils.equals(game, "tinka")) {
	        	
//	        	if (!CollectionUtils.isEmpty((List) session.getAttribute("jugada_tk")) && session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null) {
//	        		if(((Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)).getBoleto()!=null) {
//	        			redireccion = "game_tinka_show_shoppingcart_tinkaexpress.html";//"game_tinka_show_shoppingcart.html";
//	        		}
//	            } else {
	            	redireccion = "game_tinka_show_menu.html";
//	            }
	        }
	        else if(StringUtils.equals(game, "kabala")) {
	        	//jugada_kb
	        	/*if (!MapUtils.isEmpty((Map) session.getAttribute("gameKabalaB")) && session.getAttribute("gameKabalaB")!=null)  {
	    			if(((Map) session.getAttribute("gameKabalaB")).size() > 0) {
	    				redireccion = "game_kabala_show_shoppingcart.html";
	    			}
	            	
	            } else {
	            	redireccion = "game_kabala_show_menu.html";
	            }*/
	        	redireccion = "game_kabala_show_menu.html";
	        }
	        else if(StringUtils.equals(game, "ganagol")) {
	        	//gameGanagolBoleto
	        	if (!MapUtils.isEmpty((Map) session.getAttribute("gameGanagolBoleto")) && session.getAttribute("gameGanagolBoleto")!=null) {
	    			if(((Map) session.getAttribute("gameGanagolBoleto")).size() > 0) {
	    				redireccion = "game_ganagol_show_shoppingcart.html";
	    			}
	            	
	            } else {
	            	redireccion = "game_ganagol_show_menu.html";
	            }
	        }
	        else if(StringUtils.equals(game, "ganadiario")) {
	        	//lastJugadaGanadiario
	        	/*if (!MapUtils.isEmpty((Map) session.getAttribute("gameGanadiarioBoleto")) && session.getAttribute("gameGanadiarioBoleto")!=null) {
	    			if(((Map) session.getAttribute("gameGanadiarioBoleto")).size() > 0) {
	    				redireccion = "game_ganadiario_show_shoppingcart.html";
	    			}
	            	
	            } else {
	            	redireccion = "game_ganadiario_show_menu.html";
	            }*/
	        	redireccion = "game_ganadiario_show_menu.html";
	        }else if(StringUtils.equals(game, "copaentucasa")) {
	        	redireccion = "lacopaentucasa.html";
	        }else if(StringUtils.equals(game, "videoloteria")) {
	        	redireccion = "game_video_loterias_show_menu.html";
	        }
        } catch (Exception e) { e.printStackTrace(); }
        if(StringUtils.isNotEmpty(redireccion)) {
        	o.addProperty("message", "OK");
        } else {
        	o.addProperty("message", "KO");
        }
        
        o.addProperty("redireccion", redireccion);

		LoggerApi.Log.info("-------------- END routeMenuLastPlayed redireccion="+redireccion);
		
        out.print(o);
	}
	
	@RequestMapping(value = "/checkChatbot")
    public void checkChatbot(HttpServletRequest request, HttpServletResponse response) throws Exception {
     	PrintWriter out = response.getWriter();
     	JsonObject gson = new JsonObject();
        try {
        	String srcChatbot = ConnectionFactory.operationProperty("chatbot_src", Constantes.contextSale);
        	gson.addProperty("src", srcChatbot);
        	
        	String flagChatbot = ConnectionFactory.operationProperty("chatbot_flag", Constantes.contextSale);
        	
			if(flagChatbot.equals(Constantes.chatbot_status_loggedin)) {
				HttpSession session = request.getSession();
				Client client = (Client) session.getAttribute("CLIENT_SESSION");
				if(client!=null) {
					gson.addProperty("visible", "TRUE");
					gson.addProperty("urls", ConnectionFactory.operationProperty("urls_active_chat", Constantes.contextSale));
					out.write(gson.toString());
				}else {
					gson.addProperty("visible", "FALSE");
					out.write(gson.toString());
				}
			}else if(flagChatbot.equals(Constantes.chatbot_status_always)) {
				gson.addProperty("visible", "TRUE");
				gson.addProperty("urls", ConnectionFactory.operationProperty("urls_active_chat", Constantes.contextSale));
				out.write(gson.toString());
			}else if(flagChatbot.equals(Constantes.chatbot_status_never)) {
				gson.addProperty("visible", "FALSE");
				out.write(gson.toString());
			}else {
				gson.addProperty("visible", "FALSE");
				out.write(gson.toString());
			}
        } catch (Exception e) {
        	LoggerApi.severe(e);
        	out.write("FALSE");
        }
    }
	
	@RequestMapping(value = "/internavegacion/{game}", method = RequestMethod.GET)
	public ModelAndView internavegacionLoyalty(@PathVariable String game, @RequestParam(value="token", required = true) String token, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		// definir log
		String log="Loyalty ";
		LoggerApi.Log.info("-------------- start "+log);
		
		//validar game, token y request
		if(game.isEmpty() || token.isEmpty() || request.getRemoteAddr() == null) {
			LoggerApi.Log.info("Error token --> game: "+game);
			invalidateSession(request);
			return new ModelAndView("redirect:/");
		}
				
		//validar el game
		if(!(game.equals("tinka") || game.equals("kinelo") || game.equals("kabala") || game.equals("ganadiario") || game.equals("ganagol"))) {
			LoggerApi.Log.info("Error datos --> game: "+game);
			invalidateSession(request);
			return new ModelAndView("redirect:/");
		}
				
		LoginDataResponse responseLogin = new LoginDataResponse();
		Gson gson = new Gson();
		try {
		    LoggerApi.Log.info("Esta es tokenRequest " + token);
		    String ip = request.getRemoteAddr();
		    LoggerApi.Log.info("Esta es ip "+request.getRemoteAddr());
		    
		    if (token != null && ip != null && !token.isEmpty() && !ip.isEmpty()) {
				Map<String,String> headers = new HashMap<String,String>();
				headers.put("X-Ip-Origin", "192.68.1.1");
				headers.put("X-Company", "ECOM");
				//obtiene token json
				String tokenResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+token, "12345678", "12345678", headers);
				responseLogin = gson.fromJson(tokenResponse, LoginDataResponse.class);
				LoggerApi.Log.info("tokenResponse="+tokenResponse);
				if (responseLogin.getResult() != null ) {
					HttpSession session = request.getSession();					
					securityUtils.createSession(responseLogin.getResult(), beanClientAccountBo, session, ip);
					LoggerApi.Log.info("home/"+ "game_" + game + "_show_menu.html");
					if(!game.equals("kinelo")) {
						return new ModelAndView("redirect:/game_" + game + "_show_menu.html");
					} else {
						return new ModelAndView("redirect:/game_" + game + "_show_home.html");
					}

				} else {
					invalidateSession(request);
				}
					
			}else {
				return new ModelAndView("redirect:/");
			}
			return new ModelAndView("redirect:/");
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("home/interface-home");
			return new ModelAndView("redirect:/");
		} finally {
			LoggerApi.Log.info("-------------- end "+log);
		}
	}
	
	// Método para invalidar la sesión si existe
	private void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);  // Obtener la sesión si existe, sin crear una nueva
        if (session != null) {
            session.invalidate();  // Invalidar la sesión
        }
    }
	
	@RequestMapping("/redirect")
	public ModelAndView redirect(@RequestParam("token") String tokenRequest, @RequestParam(value = "source", required = false) String source, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		LoginDataResponse responseLogin = new LoginDataResponse();
		Gson gson = new Gson();
		
		if (source != null && !source.equals("activation")) {
		    LoggerApi.Log.info("Valor inesperado para source: " + source);
		    source = null;
		}
		
		try {
		    LoggerApi.Log.info("Esta es tokenRequest " + tokenRequest);
		    String ip = request.getRemoteAddr();
		    LoggerApi.Log.info("Esta es ip "+request.getRemoteAddr());
		    String display = "";
		    String where = (request.getParameter("where") == null ? "" : request.getParameter("where"));
		    String ref = (request.getParameter("ref") == null ? "" : request.getParameter("ref").replaceAll("\\/", "").replaceAll("\\*", "/"));
			if (tokenRequest != null && ip != null) {
				Map<String,String> headers = new HashMap<String,String>();
				headers.put("X-Ip-Origin", "192.68.1.1");
				headers.put("X-Company", "ECOM");
				//obtiene token json
				String tokenResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+tokenRequest, "12345678", "12345678", headers);
				responseLogin = gson.fromJson(tokenResponse, LoginDataResponse.class);
				LoggerApi.Log.info("tokenResponse="+tokenResponse);
				if (responseLogin.getResult() != null ) {
					HttpSession session = request.getSession();
					
					session.setAttribute("tycPdpInitLogin", "1");
				
					if(!securityUtils.validarSession(request, responseLogin, response)) {
						LoggerApi.Log.info("Entro a validar session - proteccion usuario ");
						return new ModelAndView("client/validacion_datos"); 
					}
					
					securityUtils.createSession(responseLogin.getResult(), beanClientAccountBo, session, ip);
					display = (session.getAttribute("display") != null) ? ( "?display=" + session.getAttribute("display").toString() ) : "" ;
					display = (session.getAttribute("boleto") != null) ? ( display+"&boleto=" + session.getAttribute("boleto").toString() ) : display ;
					LoggerApi.Log.info("hay display? =  " + display);
					
					if( where.equals("") && responseLogin.getResult().getResponseService() != null  && Integer.parseInt(responseLogin.getResult().getResponseService().getResponseButton()) == 145 && responseLogin.getResult().getResponseService().getLogin().equals("ta")) {
						session.setAttribute("openSession","openSession");
						return new ModelAndView("redirect:client_edit_password.html");
					}
					
					if( source != null && source.equals("activation")) {
						if(responseLogin != null && responseLogin.getResult() != null 
								&& (responseLogin.getResult().getMobileUpdate() != null && responseLogin.getResult().getMobileUpdate().equals("Y"))) {
							LoggerApi.Log.info("redirect:/bienvenido.html");
							return new ModelAndView("redirect:bienvenido.html");
						}
					};
					
					if( where.equals("") && responseLogin.getResult().getResponseService() != null && Integer.parseInt(responseLogin.getResult().getResponseService().getResponseButton()) == 145 && responseLogin.getResult().getResponseService().getLogin().equals("ecommerce") ) {
						session.setAttribute("openSession","openSession");
						return new ModelAndView("home/interface-home");
					}
					
					if( where != null && where.equals("loginteapuesto")) {
							String producto = ( ref == null ? "sport" : ref.replaceFirst("\\/", "") );
							request.setAttribute("producto",producto);
							return new ModelAndView("game/teapuesto/tav2_template");	
					}
					
					if (StringUtils.equals(Constantes.GameTeapuesto.DISPLAY_AVIONPERU, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        session.removeAttribute("openSession");
                        return new ModelAndView("redirect:avion-del-hincha-te-lleva-eliminatorias-peru-registrar.html");
                    }
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("openSession","openSession");
			return new ModelAndView("redirect:security_login_execute_authentication.html");
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("home/interface-home");
			return new ModelAndView("home/interface-home");
		} finally {
			LoggerApi.Log.info("-------------- END HomeController/redirect");
		}
	}
	
	@RequestMapping("/respuesta-lista")
	public String respuestaLista(@RequestParam("param1") String param1,
	                             @RequestParam("param2") String param2,
	                             @RequestParam("param3") String param3,
	                             @RequestParam(value = "action", required = false) String action,
	                             HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String no_user = "";
	    try {
	        String client_id = StringLib.decodeLabel(param1);
	        int p_client_id = Integer.parseInt(client_id);
	        String ip = StringLib.decodeLabel(param2);
	        String respuesta = StringLib.decodeLabel(param3);
	        
	        // Verificar que las variables no sean null ni estén vacías
	        if (client_id == null || client_id.isEmpty() || ip == null || ip.isEmpty() || respuesta == null || respuesta.isEmpty()) {
	        	LoggerApi.Log.info("proteccion de usuario - variables nulas o vacias");
	            return "redirect:/home.html"; 
	        }
	        
	        
	        GetClientSecurity result_cliente = clientSaleBo.getipWhitelist(p_client_id, ip);
	     
	        if(result_cliente.getStatus() != null && result_cliente.getStatus().equals("ERROR_UPDATE")) {
	        	LoggerApi.Log.info("Error ---- redirect:/home.html " + result_cliente.getStatus());
	        	return "redirect:/home.html"; 
	        }else {
			    if(respuesta.equals("SI")) {
			    	String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constantes.contextSale);
	    	        
	        		if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true")) {
			            ClientSecurityWhiteList result = clientSaleBo.updateipWhitelis(p_client_id, ip, "SI","MOBILE" );
			            //Si se realiza el update a la lista blanca correctamente retorna un Ok
			            if ("OK".equals(result.getStatus())) {
			                LoggerApi.Log.info("result: Se actualizó el estado de la IP en la lista blanca");
			                return "client/confirmation_ip_user"; // Redirigir al JSP correspondiente
			            } else {
			            	LoggerApi.Log.info("status !OK: " + result.getStatus());
			            	LoggerApi.Log.info("status diferente OK ---- redirect:/home.html");
			            	return "redirect:/home.html"; 
			            }
	        		}
			    } else if(respuesta.equals("NO")) { 
		    	 	
		        	if(action == null || action.isEmpty()) {
		        		return "client/validate_not_user"; // Redirigir al jsp validate_not_user
		        	}
		        	no_user = action.trim();
		        	LoggerApi.Log.info("no_user: " + no_user);
		        	if(no_user!=null && no_user.equals("no_user")) {
		        		String esActivoProteccionUsuario = ConnectionFactory.operationProperty("esActivoProteccionUsuario", Constantes.contextSale);
		    	        
		        		if(esActivoProteccionUsuario!=null && esActivoProteccionUsuario.trim().equals("true")) {
			        		 ClientSecurityWhiteList result = clientSaleBo.updateipWhitelis(p_client_id, ip, "NO","MOBILE");
			        		 if(result.getStatus().equals("ERROR")) {
			        			 o.addProperty("status", "ERROR");
			        			 out.print(o);
			 	            	LoggerApi.Log.info("result: " + "La ip del usuario a sido registrado en la lista negra");
			 	            	request.setAttribute("url", ConnectionFactory.operationProperty("url_restablecer_contrasenia", Constantes.contextSale));
			 	            	return "client/redirect_cuenta_restablecer";
			 	            } else {
			 	            	LoggerApi.Log.info("status: !ERROR" + result.getStatus());
			 	            	return "redirect:/home.html"; 
				            }
		        		}
		        	}
		        	
		      } else {
		        	LoggerApi.Log.info("Error de respuesta: " + respuesta + "client_id: " + client_id + "ip: " + ip);
		        	return "redirect:/home.html"; 
		      }
	     }
	        
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    	 LoggerApi.Log.info("Error ---- redirect:/home.html" + e);
	    	 return "redirect:/home.html"; 
	    } finally {
			LoggerApi.Log.info("-------------- redirect:/home.html");
		}
		return "";
	}

	
	
}