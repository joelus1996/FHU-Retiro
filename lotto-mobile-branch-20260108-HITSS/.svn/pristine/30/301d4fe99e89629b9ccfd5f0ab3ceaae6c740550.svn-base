package pe.com.intralot.loto.layer.view.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pe.com.intralot.loto.layer.controller.client.bo.ClientPlayBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientTicketLotos5Bo;
import pe.com.intralot.loto.layer.controller.client.bo.DeportesVirtualesBo;
import pe.com.intralot.loto.layer.controller.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.client.ClientDataSessionDTO;
import pe.com.intralot.loto.layer.dto.client.ClientGameInformationRequestDTO;
import pe.com.intralot.loto.layer.dto.client.ClientGameInformationResponseDTO;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenColor;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenDog;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenFutbol;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenGiraGana;
import pe.com.intralot.loto.layer.dto.golden.TicketGoldenKinelo;
import pe.com.intralot.loto.layer.model.bean.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.ApiGoldenUtils;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.QrUtil;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.utils.StringLib;

/**
 * <p>
 * NOMBRE: ClientPlayController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador operaciones de los juegos 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Métodos de activación y rechazo del bono TA por recargas Interbank
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class ClientPlayController {

    @Autowired
    private ClientPlayBo beanClientPlayBo;
    @Autowired
    private IntralotUtils intralotUtils;
    @Autowired
    private ClientTicketLotos5Bo beanClientTicketLotos5Bo;
    
    @Autowired
    private TicketSaleBo ticketSaleBo;
    @Autowired
    private QrUtil qrUtil;

    @Autowired
    private DeportesVirtualesBo deportesVirtualesBo;
    
    @Autowired
    ApiGoldenUtils  apiGoldenUtils = new ApiGoldenUtils(deportesVirtualesBo);
    
    @Autowired
    private SecurityLoginBo beanSecurityLoginBo;
    
    private final Gson gson = new Gson();

    @RequestMapping("/client_play_show_information-bk")
    public ModelAndView showInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("-------------- START client_play_show_information");
            HttpSession session = request.getSession();
            if (StringUtils.isEmpty(request.getParameter("from")))
            	session.setAttribute("listavacia",null);
            	session.setAttribute("client_play_show_informationList",null);
                if (session!=null && session.getAttribute("clientId") != null) {
                    String idClient = ((String) session.getAttribute("clientId")).trim();
                    LoggerApi.Log.info("cid="+idClient+" client_play_show_informationList");
                    if (!idClient.equals("")) {
              
                    	//Obtener el listado de jugadas web + retail
	        		    HashMap[] coupons = beanClientPlayBo.getClientPlayCouponAll(Integer.valueOf(idClient));   

	        		    if (coupons != null && coupons.length > 0) {
	        		    	 List<HashMap> couponList = new ArrayList<HashMap>();
			                    for (HashMap coupon : coupons) {
			                        couponList.add(coupon);
			                    }
			                    Collections.sort(couponList, new Comparator<HashMap>() {
			                        @Override
			                        public int compare(HashMap o1, HashMap o2) {
			                            Date date1 = (Date) o1.get("CT_TICKET_DATE");
			                            Date date2 = (Date) o2.get("CT_TICKET_DATE");

			                            // Comparar las fechas en orden descendente
			                            return date2.compareTo(date1); 
			                        }
			                    });
			                // Convertir la lista de nuevo a un array de HashMap[]
			                coupons = couponList.toArray(new HashMap[0]);
	        		        session.setAttribute("client_play_show_informationList", coupons);
	        		    } else {
	        		    	 session.setAttribute("client_play_show_informationList", new ArrayList());
	                    	 session.setAttribute("listavacia","No tienes jugadas");
	        		    }
                    }
                } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
            if (session!=null && session.getAttribute("alertPlay") != null) {
                objectModelMap.put("alert", session.getAttribute("alertPlay"));
                session.removeAttribute("alertPlay");
                LoggerApi.Log.info("client_play_show_information alertPlay="+session.getAttribute("alertPlay"));
            }
            if (session!=null && session.getAttribute("alertPlay2") != null) {
                objectModelMap.put("alert2", session.getAttribute("alertPlay2"));
                session.removeAttribute("alertPlay2");
                LoggerApi.Log.info("client_play_show_information alertPlay2="+session.getAttribute("alertPlay2"));
            }
            if (session!=null && session.getAttribute("clientId") != null) {
               // LoggerApi.Log.info("cid="+session.getAttribute("clientId")+" client_play_show_information != null");
            	if (beanClientPlayBo.findClientById(Integer.valueOf((String) session.getAttribute("clientId"))) != null) {
            		Client clientBean = beanClientPlayBo.findAccountData(Integer.valueOf((String) session.getAttribute("clientId")));
                    objectModelMap.put("balanceAmount",intralotUtils.formatCurrency(clientBean.getBalanceAmount()));
                    session.setAttribute("saldo", intralotUtils.formatCurrency(clientBean.getBalanceAmount()));
                    objectModelMap.put("balanceMessage",clientBean.getPromotional());
                   // LoggerApi.Log.info("cid="+session.getAttribute("clientId")+" clientBean="+clientBean);
                } 
            	
            } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
                
            return new ModelAndView("client/interface-game");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game");
        } finally {
            LoggerApi.Log.info("-------------- END client_play_show_information");
        }
    }
    
    @RequestMapping("/client_play_show_information_filter")
    public ModelAndView showInformationFilter(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("--------------START client_play_show_information_filter");
            HttpSession session = request.getSession();
            if (StringUtils.isEmpty(request.getParameter("from")))
            	session.setAttribute("listavacia",null);
            	session.setAttribute("r_List",null);
            	session.setAttribute("client_play_show_informationListFilter",null);
                if (session!=null && session.getAttribute("clientId") != null) {
                    String idClient = ((String) session.getAttribute("clientId")).trim();
                    LoggerApi.Log.info("cid="+idClient+" client_play_show_informationFilter");
                    if (!idClient.equals("")){
                    	String startdate = request.getParameter("startdate");
		        		String enddate = request.getParameter("enddate");
		        		
		        		if (startdate != null && enddate != null) {
		        			
		        			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        			
		        			Calendar calendarioinicio = Calendar.getInstance();
		        			calendarioinicio.setTime(sdf.parse(startdate));
		        			
		        			Calendar calendariofin = Calendar.getInstance();
		        			calendariofin.setTime(sdf.parse(enddate));
		        			
		        			Date timeinicio = calendarioinicio.getTime();
		        			Date timefin = calendariofin.getTime();
		        			long day = TimeUnit.MILLISECONDS.toDays(Math.abs(timefin.getTime()-timeinicio.getTime()));
		        			session.setAttribute("rangosuperadofechas",null);
		        			session.setAttribute("fechasincorrectas",null);
		        			
		        			if(timefin.before(timeinicio)) {
		                        LoggerApi.Log.info("-------------- aqui fechas incorrectas ");
		        				session.setAttribute("client_play_show_informationListFilter", new ArrayList());
		        				session.setAttribute("fechasincorrectas","La fecha de finalización debe ser posterior a la fecha de inicio.");
		        				session.removeAttribute("alertAccount");
		        				 LoggerApi.Log.info("-------------- aqui fechas incorrectas ");
								return new ModelAndView("client/interface-game");
		        			}

		        			if(day > 29) {
		        				session.setAttribute("client_play_show_informationListFilter", new ArrayList());
		        				session.setAttribute("rangosuperadofechas","El rango de las fechas de inicio y fin no debe superar los 30 dias");
		        				objectModelMap.put("alert","El rango de las fechas de inicio y fin no debe superar los 30 dias");
		        				session.removeAttribute("alertAccount");
		        				return new ModelAndView("client/interface-game");
		        			}			

		        			//Obtener el listado de jugadas web + retail	
		        		    HashMap[] coupons = beanClientPlayBo.getClientPlayCouponFilterAll(Integer.valueOf(idClient), startdate, enddate);
		        		    
		        		    if (coupons != null && coupons.length > 0) {
			                    List<HashMap> couponList = new ArrayList<HashMap>();
			                    for (HashMap coupon : coupons) {
			                        couponList.add(coupon);
			                    }
			                    Collections.sort(couponList, new Comparator<HashMap>() {
			                        @Override
			                        public int compare(HashMap o1, HashMap o2) {
			                            Date date1 = (Date) o1.get("CT_TICKET_DATE");
			                            Date date2 = (Date) o2.get("CT_TICKET_DATE");

			                            // Comparar las fechas en orden descendente
			                            return date2.compareTo(date1); 
			                        }
			                    });
			                    // Convertir la lista de nuevo a un array de HashMap[]
				                coupons = couponList.toArray(new HashMap[0]);  
		        		        session.setAttribute("client_play_show_informationListFilter", coupons);
		        		        session.setAttribute("r_List", coupons.length);
		        		    } else {
		        		    	 session.setAttribute("client_play_show_informationListFilter", new ArrayList());
		                    	 session.setAttribute("listavacia","No tienes jugadas");
		        		    }
		        		} else {
		        		    return new ModelAndView("redirect:security_login_execute_authentication.html");
		        		}


                    	
                    }
  
                } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
            if (session!=null && session.getAttribute("alertPlay") != null) {
                objectModelMap.put("alert", session.getAttribute("alertPlay"));
                session.removeAttribute("alertPlay");
                LoggerApi.Log.info("client_play_show_information_filter alertPlay="+session.getAttribute("alertPlay"));
            }
            if (session!=null && session.getAttribute("alertPlay2") != null) {
                objectModelMap.put("alert2", session.getAttribute("alertPlay2"));
                session.removeAttribute("alertPlay2");
                LoggerApi.Log.info("client_play_show_information_filter alertPlay2="+session.getAttribute("alertPlay2"));
            }
            if (session!=null && session.getAttribute("clientId") != null) {
            	
               // LoggerApi.Log.info("cid="+session.getAttribute("clientId")+" client_play_show_information != null");
            	if (beanClientPlayBo.findClientById(Integer.valueOf((String) session.getAttribute("clientId"))) != null) {
            		Client clientBean = beanClientPlayBo.findAccountData(Integer.valueOf((String) session.getAttribute("clientId")));
                    objectModelMap.put("balanceAmount",intralotUtils.formatCurrency(clientBean.getBalanceAmount()));
                    session.setAttribute("saldo", intralotUtils.formatCurrency(clientBean.getBalanceAmount()));
                    objectModelMap.put("balanceMessage",clientBean.getPromotional());
                   // LoggerApi.Log.info("cid="+session.getAttribute("clientId")+" clientBean="+clientBean);
                } 
            	
            } else return new ModelAndView("redirect:security_login_execute_authentication.html") ;
                
            return new ModelAndView("client/interface-game");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game");
        } finally {
            LoggerApi.Log.info("-------------- END client_play_show_information_filter");
        }
    }

    @RequestMapping("/client_play_show_detail_teapuesto")
    public void showDetailTeApuesto(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        LoggerApi.Log.info("-------------- START client_play_show_detail_teapuesto");
        
        try {

        	PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            
            HttpSession session = request.getSession();
            
            JsonObject o = new JsonObject(); 

            String url = "";
            String idClient = "";
            String tokenClient = "";
            String pTicket = request.getParameter("ticket");
            
            if(session.getAttribute("clientId") != null) idClient = ((String) session.getAttribute("clientId")).trim();
            
            if((idClient == null || idClient.isEmpty()) && request.getParameter("dataSession") != null) {
            	idClient = extractDataSessionFromData(request.getParameter("dataSession")).getClientId();
            }
            
            if(session.getAttribute("clientToken") != null) tokenClient = ((String) session.getAttribute("clientToken")).trim();
            
            LoggerApi.Log.info("cid="+idClient+" START client_play_show_detail_teapuesto tokenClient="+tokenClient+" pTicket="+pTicket);
            
            String iflexGameProviderBaseUrl = ConnectionFactory.operationProperty("iflexGameProviderBaseUrl", "SALE").trim();
                        
            url = iflexGameProviderBaseUrl+"web/guest/coupon-details?couponId="+pTicket+"&authToken="+tokenClient+"&playerId="+idClient;
            
	        //Celso. se agrega obtencion de ticketId para abrir ticket detalle de Novus
	        String TANTicketId = null, time = "", auth = "";
	        String urlTAN = ((ConnectionFactory.operationProperty("TANServerURI", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANServerURI", "CARD-WEB").trim():"");
	    	String authKey = ((ConnectionFactory.operationProperty("TANauthKey", "CARD-WEB") != null)?ConnectionFactory.operationProperty("TANauthKey", "CARD-WEB").trim():"");
	    	time = String.valueOf(new java.util.Date().getTime()/1000);
		    
	        try {
	        	int num = Integer.parseInt(pTicket);
	        	TANTicketId = beanClientTicketLotos5Bo.findTicketIdByCoupon(pTicket);        	
	        }catch(NumberFormatException ex) {
	        	TANTicketId = pTicket;
	        }
	        catch(Exception e) {
	        	TANTicketId = null;
	        }
	        if(TANTicketId!=null && !TANTicketId.equals("null")) {//validar si el couponId es de Nuevo TA Novus: Channel=3
	        	auth = DigestUtils.sha1Hex(TANTicketId + authKey + time);
	        	url = urlTAN+"?platform=mobile&time="+time+"&ticket_id="+TANTicketId+"&auth="+auth;
	            LoggerApi.Log.info("cid="+idClient+" client_play_show_detail_teapuesto TANTicketId="+TANTicketId+" urlTAN="+urlTAN+" time="+time+" pTicket="+pTicket);
	        }
	        //fin celso.
        
            o.addProperty("url",url);
            
            //LoggerApi.Log.info(o.toString());
            out.print(o);
            
           // LoggerApi.Log.info("cid="+idClient+" END client_play_show_detail_teapuesto url="+url+" tokenClient="+tokenClient+" pTicket="+pTicket);
            
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("-------------- END client_play_show_detail_teapuesto");
        }
        
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/client_play_show_detail_teapuesto_grecia")
    public ModelAndView client_detail_teapuesto_grecia(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
        	LoggerApi.Log.info("-------------- START client_play_find_information");
    		HttpSession session = request.getSession();
    		String gameId = request.getParameter("gameId");
            String ticket = request.getParameter("ticket");
            String clientId = (String) session.getAttribute("clientId");
            
            if((clientId == null || clientId.isEmpty()) && request.getParameter("dataSession") != null) {
            	clientId = extractDataSessionFromData(request.getParameter("dataSession")).getClientId();
            }
            
            String programa = request.getParameter("programa");
            String cpn = request.getParameter("cpn");
            HashMap[] map = beanClientPlayBo.getTicketDetailRetail(Integer.parseInt(clientId), Integer.parseInt(gameId), ticket);
            
            if(programa != null && cpn != null ) {
                HashMap[] mapEventos = beanClientPlayBo.getTicketDetailRetailGrecia(Integer.parseInt(programa), Integer.parseInt(cpn));	
                if(mapEventos != null) {
                	
                	ArrayList<Map<String, String>> hashMapEventos = new ArrayList<Map<String, String>>();
                	for (Map<String, Object> hashMap : mapEventos) {
                		Map<String, String> objEvento = new HashMap<String, String>();
                		for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                			objEvento.put((String )entry.getKey(),String.valueOf(entry.getValue()));
                		}
                		hashMapEventos.add(objEvento);
                	}
                		 objectModelMap.put("eventosInfo", hashMapEventos);
                }
            }


            if (map != null) {
              for (HashMap<String, Object> hashMap : map) {
                     objectModelMap.put("playCouponInfo", hashMap);
                     objectModelMap.put("GAMOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GAMOUNT").toString())));
                     objectModelMap.put("GMAX_AMOUNT_WINNER", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GMAX_AMOUNT_WINNER").toString())));
                     objectModelMap.put("GPRIZE", hashMap.get("GPRIZE") != null ? intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GPRIZE").toString())) : intralotUtils.formatCurrency(Double.valueOf(0.00)));
                }
            }
            return new ModelAndView("client/interface-game-detail-iflex");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-detail-iflex");
        } finally {
			LoggerApi.Log.info("-------------- END client_play_show_detail_teapuesto_grecia");
        }
    }
    
    
    @RequestMapping("/consultaDetalleVirtuales")
    public void consultaDetalleVirtuales(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String url = Constantes.GOLDEN_URL_FINDBYID;	// "https://america-api.virtustec.com/api/external/v2/ticket/findById";
        String tipo = "findTicket";
        String respuestaApiGolden = "ERROR";
        response.setContentType("application/json");
        JsonObject jsonResponse = new JsonObject();
        String method="consultaDetalleVirtuales";

        try {
        	LoggerApi.Log.info( method + "START ============================================================================");
            String ticket = request.getParameter("ticket");
            // Realizar conexion y recibir rpta
            LoggerApi.Log.info("input sendRequestGolden: ticketId" + ticket + " url=" + url + " tipo=" + tipo);
            respuestaApiGolden = apiGoldenUtils.sendRequestGolden(ticket, url, tipo);
            LoggerApi.Log.info("-------------- ticket=" + ticket);

            if (respuestaApiGolden == null || respuestaApiGolden.isEmpty() || "ERROR".equals(respuestaApiGolden)) {
                LoggerApi.Log.info("No se encontraron datos method=consultaDetalleVirtuales");
                jsonResponse.addProperty("status", "ERROR");
                jsonResponse.addProperty("message", "No se encontraron datos");
            } else {
                LoggerApi.Log.info("Se encontraron datos ticket=" + ticket);
                jsonResponse.addProperty("status", "OK");
                jsonResponse.addProperty("data", respuestaApiGolden); // Assuming respuestaApiGolden is already a JSON string
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            jsonResponse.addProperty("status", "ERROR");
            jsonResponse.addProperty("message", "Error en el servidor");
        } finally {
            LoggerApi.Log.info("-------------- END consultaDetalleVirtuales");
            out.print(jsonResponse.toString());
        }
        
        LoggerApi.Log.info( method + " END ============================================================================");
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/detalleVirtualesTicket")
    public ModelAndView detalleVirtualesTicket(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        
    	String respuestaApiGolden ="ERROR";
    	String typeGameGolden ="OTRO";
    	String htmlTextTemplate;
    	String method="detalleVirtualesTicket";
    	
    	LoggerApi.Log.info( method + " START ============================================================================");
    	try {
            String ticketId = request.getParameter("ticket");
            String url = Constantes.GOLDEN_URL_FINDBYID;
        	String tipo="findTicket";	
        	Map<String, String> couponInfo = new HashMap<String, String>(); 	
        	
        	//Realizar conexion y recibir rpta
        	LoggerApi.Log.info("input sendRequestGolden: ticketId" + ticketId + " url=" +url + " tipo=" +tipo );
        	respuestaApiGolden = apiGoldenUtils.sendRequestGolden(ticketId, url, tipo);
        	if( respuestaApiGolden != "ERROR" ) {	
        		LoggerApi.Log.info("respuestaApiGolden: "+ respuestaApiGolden);
        		//obtener tipo de juego
        		typeGameGolden = apiGoldenUtils.getCodeGame(respuestaApiGolden);
        		if(typeGameGolden !="OTRO" || !typeGameGolden.equals("OTRO")) {	
        			Object objeto = null;
            		//Realizar casteo de rpta de golden
            		Map<String, Class<?>> gameTypeMap = new HashMap<String, Class<?>>();
            		gameTypeMap.put("CH", TicketGoldenFutbol.class);
            		gameTypeMap.put("DOG", TicketGoldenDog.class);
            		gameTypeMap.put("HORSE", TicketGoldenDog.class);
            		gameTypeMap.put("DIRTTRACK", TicketGoldenDog.class);
            		gameTypeMap.put("KART", TicketGoldenDog.class);
            		gameTypeMap.put("MOTORBIKE", TicketGoldenDog.class);
            		gameTypeMap.put("MMA", TicketGoldenDog.class);
            		gameTypeMap.put("KN", TicketGoldenKinelo.class);
            		gameTypeMap.put("SN", TicketGoldenGiraGana.class);
            		gameTypeMap.put("RAINBOW", TicketGoldenColor.class);
            		gameTypeMap.put("PENALTY", TicketGoldenGiraGana.class);
            		
            		Class<?> clazz = gameTypeMap.get(typeGameGolden);
            		if (clazz != null) {
            		    objeto = clazz.getDeclaredConstructor().newInstance();
            		}	
            		LoggerApi.Log.info("Invocado Casteo de response");
            		htmlTextTemplate = apiGoldenUtils.castReponseGolden(objeto, respuestaApiGolden );    		
            		request.setAttribute("htmlText", htmlTextTemplate);
        		}
        	}     
            return new ModelAndView("client/interface-game-virtuales");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-virtuales");
        } finally {
        	LoggerApi.Log.info( method + " END ============================================================================");
		}
    	
    	
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping("/consultarDataTeApuestoGrecia")
    public void consultarEventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        try {
            LoggerApi.Log.info("-------------- START consultarDataTeApuestoGrecia");
            String programa = request.getParameter("programa");
            String cpn = request.getParameter("cpn");

            LoggerApi.Log.info("-------------- programa=" + programa + " cpn=" + cpn);
            if (programa == null || programa.isEmpty() || cpn == null || cpn.isEmpty()) {
                LoggerApi.Log.info("No se proporcionaron programa o cpn válidos.");
                response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
                return;
            }
            int programaInt = Integer.parseInt(programa);
            int cpnInt = Integer.parseInt(cpn);

            HashMap<String, Object>[] mapEventos = beanClientPlayBo.getTicketDetailRetailGrecia(programaInt, cpnInt);

            if (mapEventos == null || mapEventos.length == 0) {
                LoggerApi.Log.info("No se encontraron eventos para programa=" + programa + " cpn=" + cpn);
                response.setStatus(HttpServletResponse.SC_OK);
                out.print("No se encontraron datos");
            } else {
                LoggerApi.Log.info("Se encontraron eventos para programa=" + programa + " cpn=" + cpn);
                response.setStatus(HttpServletResponse.SC_OK); 
                out.print("OK");
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Devuelve error interno del servidor
            out.print("Error en el servidor");
        } finally {
            LoggerApi.Log.info("-------------- END consultarDataTeApuestoGrecia");
        }
    }
    
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/client_play_find_information")
    public ModelAndView findInformation(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_play_find_information");
    		HttpSession session = request.getSession();
    		String gameId = request.getParameter("gameId");
            String ticket = request.getParameter("ticket");
            String listaFiltrada = request.getParameter("listaFiltrada");
    		// Obtencion de QR
            String clientId = (String) session.getAttribute("clientId");
            
            ClientDataSessionDTO clientDataSessionDTO = new ClientDataSessionDTO();
            
            if((clientId == null || clientId.isEmpty()) && request.getParameter("dataSession") != null) {
            	clientDataSessionDTO = extractDataSessionFromData(request.getParameter("dataSession"));
            	clientId = clientDataSessionDTO.getClientId();
            }
            
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;

        	LoggerApi.Log.info("-------------- gameId= " + gameId + "ticket= " + ticket);
            if(clientId!=null && gameId!=null && ticket!=null) {
        		LoggerApi.Log.info("-------------- gameId= " + gameId + "ticket= " + ticket);
                	ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(Integer.parseInt(clientId), Integer.parseInt(gameId), Long.valueOf(ticket));	
            }
            
            String base64Qr = qrUtil.generateQR(ticketProcedureGetClientTicket);
            HashMap[] map;
            if(listaFiltrada != null && listaFiltrada.equals("OK")) {
                map = (HashMap[]) session.getAttribute("client_play_show_informationListFilter");
                if(map == null && clientDataSessionDTO.getCouponFilter() != null) map = StringLib.deserializeHashMapArray(clientDataSessionDTO.getCouponFilter());
            }else {
                map = (HashMap[]) session.getAttribute("client_play_show_informationList");
                if(map == null && clientDataSessionDTO.getCoupon() != null) map = StringLib.deserializeHashMapArray(clientDataSessionDTO.getCoupon());
            }

            
            //HashMap<String, Object> ticketMap = beanClientPrizeBo.getPendingPrizeByTicketid(Integer.valueOf(gameId), Integer.valueOf(ticket));
            //HashMap<String, Object> ticketMap = beanClientPrizeBo.getTicketById(Integer.valueOf(gameId), Integer.valueOf(ticket));
            //boolean kabalaPlusEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"));
            //boolean kabalaChauChambaEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB"));
            int chChDrawEnabled = Integer.valueOf(ConnectionFactory.operationProperty("kabalaChChDrawEnabled", "CARD-WEB").trim()).intValue();
            if (map != null)
                for (HashMap hashMap : map)
                    if (StringUtils.equals(hashMap.get("GAMEID").toString(), gameId) && StringUtils.equals(hashMap.get("GTICKET").toString(), ticket)) {
                    	//hashMap.put("STATUS", ticketMap.get("STATUS"));
                		//hashMap.put("GSTATUS", ticketMap.get("GSTATUS"));
                    	//System.out.println("CT_ADDON_1="+hashMap.get("CT_ADDON_1")+" CT_ADDON_2="+hashMap.get("CT_ADDON_2")+" CT_ADDON_3="+hashMap.get("CT_ADDON_3")+" CT_ADDON_4="+hashMap.get("CT_ADDON_4"));
                    	if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.KABALA) {
	                    	if(Integer.parseInt(hashMap.get("GFROMDRAW").toString())>=chChDrawEnabled){
	                    		if(hashMap.get("CT_ADDON_1") != null)
	                                if(hashMap.get("CT_ADDON_1").equals("1")) objectModelMap.put("Addon1", "(Plus+)");
	                                else objectModelMap.put("Addon1", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_2") != null)
	                                if(hashMap.get("CT_ADDON_2").equals("1")) objectModelMap.put("Addon2", "(Plus+)");
	                                else objectModelMap.put("Addon2", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_3") != null)
	                                if(hashMap.get("CT_ADDON_3").equals("1")) objectModelMap.put("Addon3", "(Plus+)");
	                                else objectModelMap.put("Addon3", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_4") != null)
	                                if(hashMap.get("CT_ADDON_4").equals("1")) objectModelMap.put("Addon4", "(Plus+)");
	                                else objectModelMap.put("Addon4", "(Chau Chamba)");
	                    	} else {
		                    	if (hashMap.get("CT_ADDON_1") != null)
		                            if (hashMap.get("CT_ADDON_1").equals("1")) objectModelMap.put("Addon1", "(Plus+)");
		                            else objectModelMap.put("Addon1", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_2") != null)
		                            if (hashMap.get("CT_ADDON_2").equals("1")) objectModelMap.put("Addon2", "(Plus+)");
		                            else objectModelMap.put("Addon2", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_3") != null)
		                            if (hashMap.get("CT_ADDON_3").equals("1")) objectModelMap.put("Addon3", "(Plus+)");
		                            else objectModelMap.put("Addon3", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_4") != null)
		                            if (hashMap.get("CT_ADDON_4").equals("1")) objectModelMap.put("Addon4", "(Plus+)");
		                            else objectModelMap.put("Addon4", "(Plus+)  (Chau Chamba)");
	                    	}
                    	}
                    	if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.KINELO) {
                			if(hashMap.get("GMATRIX1")!=null && !hashMap.get("GMATRIX1").toString().isEmpty()) {
                				String GMATRIX1 = hashMap.get("GMATRIX1").toString();
                				int indice = GMATRIX1.indexOf("x");
                				if(indice>0) {
                					String jugada = GMATRIX1.substring(0, indice);
                    				String multiplicador = GMATRIX1.substring(indice, GMATRIX1.length());
                    				GMATRIX1 = jugada.trim().replace(" ", "-").concat(" ").concat(multiplicador);
                    				hashMap.put("GMATRIX1", GMATRIX1);
                				}
                			}
                			if(hashMap.get("GMATRIX2")!=null && !hashMap.get("GMATRIX2").toString().isEmpty()) {
                				String GMATRIX2 = hashMap.get("GMATRIX2").toString();
                				int indice = GMATRIX2.indexOf("x");
                				if(indice>0) {
                					String jugada = GMATRIX2.substring(0, indice);
                    				String multiplicador = GMATRIX2.substring(indice, GMATRIX2.length());
                    				GMATRIX2 = jugada.trim().replace(" ", "-").concat(" ").concat(multiplicador);
                    				hashMap.put("GMATRIX2", GMATRIX2);
                				}
                			}
                		}
                    	
                    	if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.GANAGOL) {
                    		if(hashMap.get("CT_ADDON_1") != null) {
                    			 if(hashMap.get("CT_ADDON_1").equals("8")) { 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 0-8");  
                    			 }else if(hashMap.get("CT_ADDON_1").equals("915")) {                  					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 9-15");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("1620")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 16-20");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("2125")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 21-25");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("2630")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 26-30");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("3135")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 31-35");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("3640")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 36-40");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("4143")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 41-43");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("4445")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 44-46");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("47")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 47-a más");
                    			 }else {
                    				 objectModelMap.put("Addon1", "");
                    			 }
                    		}
                    		
                    		if(hashMap.get("CT_ADDON_2") != null) {
                      			 if(hashMap.get("CT_ADDON_2").equals("8")) { 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 0-8");  
                      			 }else if(hashMap.get("CT_ADDON_2").equals("915")) {                  					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 9-15");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("1620")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 16-20");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("2125")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 21-25");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("2630")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 26-30");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("3135")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 31-35");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("3640")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 36-40");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("4143")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 41-43");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("4445")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 44-46");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("47")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 47-a más");
                      			 }else {
                      				 objectModelMap.put("Addon2", "");
                      			 }
                       		}
                    		
                    		if(hashMap.get("CT_ADDON_3") != null) {
                      			 if(hashMap.get("CT_ADDON_3").equals("8")) { 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 0-8");  
                      			 }else if(hashMap.get("CT_ADDON_3").equals("915")) {                  					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 9-15");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("1620")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 16-20");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("2125")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 21-25");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("2630")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 26-30");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("3135")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 31-35");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("3640")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 36-40");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("4143")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 41-43");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("4445")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 44-46");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("47")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 47-a más");
                      			 }else {
                      				 objectModelMap.put("Addon3", "");
                      			 }
                       		}
                    		
                    		if(hashMap.get("CT_ADDON_4") != null) {
                      			 if(hashMap.get("CT_ADDON_4").equals("8")) { 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 0-8");  
                      			 }else if(hashMap.get("CT_ADDON_4").equals("915")) {                  					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 9-15");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("1620")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 16-20");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("2125")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 21-25");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("2630")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 26-30");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("3135")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 31-35");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("3640")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 36-40");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("4143")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 41-43");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("4445")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 44-46");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("47")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 47-a más");
                      			 }else {
                      				 objectModelMap.put("Addon4", "");
                      			 }
                       		}
                    	}
                        objectModelMap.put("playCouponInfo", hashMap);
                        objectModelMap.put("GAMOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GAMOUNT").toString())));
                        objectModelMap.put("GDISCOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GDISCOUNT").toString())));
                        objectModelMap.put("base64Qr", base64Qr);
                        break;
                    }
            return new ModelAndView("client/interface-game-detail");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-detail");
        } finally {
			LoggerApi.Log.info("-------------- END client_play_find_information");
        }
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/client_play_find_information_retail")
    public ModelAndView findInformationRetail(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_play_find_information");
    		HttpSession session = request.getSession();
    		String gameId = request.getParameter("gameId");
            String ticket = request.getParameter("ticket");
            String clientId = (String) session.getAttribute("clientId");
            
            if((clientId == null || clientId.isEmpty()) && request.getParameter("dataSession") != null) {
            	clientId = extractDataSessionFromData(request.getParameter("dataSession")).getClientId();
            }
            
            HashMap[] map = beanClientPlayBo.getTicketDetailRetail(Integer.parseInt(clientId), Integer.parseInt(gameId), ticket);

            if (map != null)
                for (HashMap<String, Object> hashMap : map)
                    if (StringUtils.equals(hashMap.get("GAMEID").toString(), gameId) && StringUtils.equals(hashMap.get("GTICKET").toString(), ticket)) {
                    	//hashMap.put("STATUS", map.get("STATUS"));
                		//hashMap.put("GSTATUS", ticketMap.get("GSTATUS"));
                    	//System.out.println("CT_ADDON_1="+hashMap.get("CT_ADDON_1")+" CT_ADDON_2="+hashMap.get("CT_ADDON_2")+" CT_ADDON_3="+hashMap.get("CT_ADDON_3")+" CT_ADDON_4="+hashMap.get("CT_ADDON_4"));
                        objectModelMap.put("playCouponInfo", hashMap);
                        objectModelMap.put("GAMEID", hashMap.get("GAMEID"));
                        objectModelMap.put("GTICKET", hashMap.get("GTICKET"));
                        objectModelMap.put("GNAME", hashMap.get("GNAME"));
                        objectModelMap.put("GDATE", hashMap.get("GDATE"));
                        objectModelMap.put("GAMOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GAMOUNT").toString())));
                        objectModelMap.put("GDISCOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GDISCOUNT").toString())));
                        objectModelMap.put("GMATRIX1", hashMap.get("GMATRIX1"));
                        objectModelMap.put("GMATRIX2", hashMap.get("GMATRIX2"));
                        objectModelMap.put("GMATRIX3", hashMap.get("GMATRIX3"));
                        objectModelMap.put("GMATRIX4", hashMap.get("GMATRIX4"));
                        objectModelMap.put("GRESULT", hashMap.get("GRESULT"));
                        objectModelMap.put("GFROMDRAW", hashMap.get("GFROMDRAW"));
                        objectModelMap.put("GTODRAW", hashMap.get("GTODRAW"));
                        objectModelMap.put("GSTATUS", hashMap.get("GSTATUS"));
                        objectModelMap.put("GFROMDRAWDATE", hashMap.get("GFROMDRAWDATE"));
                        objectModelMap.put("GPRIZE", hashMap.get("GPRIZE"));
                        objectModelMap.put("GFREE", hashMap.get("GFREE"));
                        objectModelMap.put("GTWOXONE", hashMap.get("GTWOXONE"));
                        objectModelMap.put("GTYPE", hashMap.get("GTYPE"));
                        objectModelMap.put("CT_ADDON_1", hashMap.get("CT_ADDON_1"));
                        objectModelMap.put("CT_ADDON_2", hashMap.get("CT_ADDON_2"));
                        objectModelMap.put("CT_ADDON_3", hashMap.get("CT_ADDON_3"));
                        objectModelMap.put("CT_ADDON_4", hashMap.get("CT_ADDON_4"));
                        objectModelMap.put("STATUS", hashMap.get("STATUS"));
                        objectModelMap.put("MORE_STATUS", hashMap.get("MORE_STATUS"));
                        objectModelMap.put("GSUSCRIPTION", hashMap.get("GSUSCRIPTION"));
                        objectModelMap.put("CT_TICKET_DATE", hashMap.get("CT_TICKET_DATE"));
                        objectModelMap.put("GCODE", hashMap.get("GCODE"));
                        objectModelMap.put("SALESCHANNEL", hashMap.get("SALESCHANNEL"));
                        objectModelMap.put("GAMOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GAMOUNT").toString())));
                        objectModelMap.put("GDISCOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GDISCOUNT").toString())));
                        objectModelMap.put("CT_PID_TICKET", hashMap.get("CT_PID_TICKET")); // codigo para te apuesto novus
                        break;
                    }
            return new ModelAndView("client/interface-game-detail");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-detail");
        } finally {
			LoggerApi.Log.info("-------------- END client_play_find_information");
        }
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping("/client_play_find_information_pp")
    public ModelAndView findInformationPP(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
    		LoggerApi.Log.info("-------------- START client_play_find_information");
    		HttpSession session = request.getSession();
    		String gameId = request.getParameter("gameId");
            String ticket = request.getParameter("ticket");
    		// Obtencion de QR
            String clientId = (String) session.getAttribute("clientId");
            TicketProcedureGetClientTicket ticketProcedureGetClientTicket = null;

        	LoggerApi.Log.info("-------------- gameId= " + gameId + "ticket= " + ticket);
            if(clientId!=null && gameId!=null && ticket!=null) {
        		LoggerApi.Log.info("-------------- gameId= " + gameId + "ticket= " + ticket);
            	ticketProcedureGetClientTicket = ticketSaleBo.findByClientTicket(Integer.parseInt(clientId), Integer.parseInt(gameId), Long.valueOf(ticket));
            }
            
            //String base64Qr = qrUtil.generateQR(ticketProcedureGetClientTicket);
            session.setAttribute("client_play_show_informationList", beanClientPlayBo.getClientPlayCouponPP(Integer.valueOf(clientId),Integer.valueOf(ticket)));
            HashMap[] map = (HashMap[]) session.getAttribute("client_play_show_informationList");
             
            int chChDrawEnabled = Integer.valueOf(ConnectionFactory.operationProperty("kabalaChChDrawEnabled", "CARD-WEB").trim()).intValue();
            if (map != null)
                for (HashMap hashMap : map)
                    if (StringUtils.equals(hashMap.get("GAMEID").toString(), gameId) && StringUtils.equals(hashMap.get("GTICKET").toString(), ticket)) {
                    	if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.KABALA) {
	                    	if(Integer.parseInt(hashMap.get("GFROMDRAW").toString())>=chChDrawEnabled){
	                    		if(hashMap.get("CT_ADDON_1") != null)
	                                if(hashMap.get("CT_ADDON_1").equals("1")) objectModelMap.put("Addon1", "(Plus+)");
	                                else objectModelMap.put("Addon1", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_2") != null)
	                                if(hashMap.get("CT_ADDON_2").equals("1")) objectModelMap.put("Addon2", "(Plus+)");
	                                else objectModelMap.put("Addon2", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_3") != null)
	                                if(hashMap.get("CT_ADDON_3").equals("1")) objectModelMap.put("Addon3", "(Plus+)");
	                                else objectModelMap.put("Addon3", "(Chau Chamba)");
	                            if(hashMap.get("CT_ADDON_4") != null)
	                                if(hashMap.get("CT_ADDON_4").equals("1")) objectModelMap.put("Addon4", "(Plus+)");
	                                else objectModelMap.put("Addon4", "(Chau Chamba)");
	                    	} else {
		                    	if (hashMap.get("CT_ADDON_1") != null)
		                            if (hashMap.get("CT_ADDON_1").equals("1")) objectModelMap.put("Addon1", "(Plus+)");
		                            else objectModelMap.put("Addon1", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_2") != null)
		                            if (hashMap.get("CT_ADDON_2").equals("1")) objectModelMap.put("Addon2", "(Plus+)");
		                            else objectModelMap.put("Addon2", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_3") != null)
		                            if (hashMap.get("CT_ADDON_3").equals("1")) objectModelMap.put("Addon3", "(Plus+)");
		                            else objectModelMap.put("Addon3", "(Plus+)  (Chau Chamba)");
		                        if (hashMap.get("CT_ADDON_4") != null)
		                            if (hashMap.get("CT_ADDON_4").equals("1")) objectModelMap.put("Addon4", "(Plus+)");
		                            else objectModelMap.put("Addon4", "(Plus+)  (Chau Chamba)");
	                    	}
                    	}
                    	if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.KINELO) {
                			if(hashMap.get("GMATRIX1")!=null && !hashMap.get("GMATRIX1").toString().isEmpty()) {
                				String GMATRIX1 = hashMap.get("GMATRIX1").toString();
                				int indice = GMATRIX1.indexOf("x");
                				if(indice>0) {
                					String jugada = GMATRIX1.substring(0, indice);
                    				String multiplicador = GMATRIX1.substring(indice, GMATRIX1.length());
                    				GMATRIX1 = jugada.trim().replace(" ", "-").concat(" ").concat(multiplicador);
                    				hashMap.put("GMATRIX1", GMATRIX1);
                				}
                			}
                			if(hashMap.get("GMATRIX2")!=null && !hashMap.get("GMATRIX2").toString().isEmpty()) {
                				String GMATRIX2 = hashMap.get("GMATRIX2").toString();
                				int indice = GMATRIX2.indexOf("x");
                				if(indice>0) {
                					String jugada = GMATRIX2.substring(0, indice);
                    				String multiplicador = GMATRIX2.substring(indice, GMATRIX2.length());
                    				GMATRIX2 = jugada.trim().replace(" ", "-").concat(" ").concat(multiplicador);
                    				hashMap.put("GMATRIX2", GMATRIX2);
                				}
                			}
                		}
                    	
                    	if(Integer.parseInt(hashMap.get("GAMEID").toString())==Game.GANAGOL) {
                    		if(hashMap.get("CT_ADDON_1") != null) {
                    			 if(hashMap.get("CT_ADDON_1").equals("8")) { 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 0-8");  
                    			 }else if(hashMap.get("CT_ADDON_1").equals("915")) {                  					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 9-15");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("1620")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 16-20");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("2125")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 21-25");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("2630")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 26-30");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("3135")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 31-35");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("3640")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 36-40");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("4143")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 41-43");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("4445")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 44-46");
                    			 }else if(hashMap.get("CT_ADDON_1").equals("47")) {               					 
                    				 objectModelMap.put("Addon1", "/ Golazo 200: 47-a más");
                    			 }else {
                    				 objectModelMap.put("Addon1", "");
                    			 }
                    		}
                    		
                    		if(hashMap.get("CT_ADDON_2") != null) {
                      			 if(hashMap.get("CT_ADDON_2").equals("8")) { 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 0-8");  
                      			 }else if(hashMap.get("CT_ADDON_2").equals("915")) {                  					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 9-15");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("1620")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 16-20");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("2125")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 21-25");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("2630")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 26-30");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("3135")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 31-35");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("3640")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 36-40");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("4143")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 41-43");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("4445")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 44-46");
                      			 }else if(hashMap.get("CT_ADDON_2").equals("47")) {               					 
                      				 objectModelMap.put("Addon2", "/ Golazo 200: 47-a más");
                      			 }else {
                      				 objectModelMap.put("Addon2", "");
                      			 }
                       		}
                    		
                    		if(hashMap.get("CT_ADDON_3") != null) {
                      			 if(hashMap.get("CT_ADDON_3").equals("8")) { 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 0-8");  
                      			 }else if(hashMap.get("CT_ADDON_3").equals("915")) {                  					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 9-15");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("1620")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 16-20");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("2125")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 21-25");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("2630")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 26-30");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("3135")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 31-35");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("3640")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 36-40");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("4143")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 41-43");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("4445")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 44-46");
                      			 }else if(hashMap.get("CT_ADDON_3").equals("47")) {               					 
                      				 objectModelMap.put("Addon3", "/ Golazo 200: 47-a más");
                      			 }else {
                      				 objectModelMap.put("Addon3", "");
                      			 }
                       		}
                    		
                    		if(hashMap.get("CT_ADDON_4") != null) {
                      			 if(hashMap.get("CT_ADDON_4").equals("8")) { 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 0-8");  
                      			 }else if(hashMap.get("CT_ADDON_4").equals("915")) {                  					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 9-15");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("1620")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 16-20");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("2125")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 21-25");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("2630")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 26-30");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("3135")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 31-35");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("3640")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 36-40");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("4143")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 41-43");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("4445")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 44-46");
                      			 }else if(hashMap.get("CT_ADDON_4").equals("47")) {               					 
                      				 objectModelMap.put("Addon4", "/ Golazo 200: 47-a más");
                      			 }else {
                      				 objectModelMap.put("Addon4", "");
                      			 }
                       		}
                    	}
                        objectModelMap.put("playCouponInfo", hashMap);
                        objectModelMap.put("GAMOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GAMOUNT").toString())));
                        objectModelMap.put("GDISCOUNT", intralotUtils.formatCurrency(Double.valueOf(hashMap.get("GDISCOUNT").toString())));
                        //objectModelMap.put("base64Qr", base64Qr);
                        break;
                    }
            return new ModelAndView("client/interface-game-detail");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("client/interface-game-detail");
        } finally {
			LoggerApi.Log.info("-------------- END client_play_find_information");
        }
    }
    
    @RequestMapping("/iflex_launch")
    public void gameLaunch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- START iflex_launch"); 
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
      
        Integer clientId = 0;
       
        String authToken = "0";
    	String iflexConfig = Constantes.iflexGameProviderBaseUrl+" | "+Constantes.iflexLanguage+" | "+Constantes.iflexOperatorId+" | "+Constantes.iflexCurrency;
        String message = null;
        boolean agreement = false;
        
        ClientProcedureGetLoginData userLogin = null;
        try {
        	userLogin = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
        	clientId = userLogin.getClientId();
        	authToken = userLogin.getpToken();
        } catch (Exception e) {
        	out.print(iflexConfig+" | "+clientId+" | "+authToken+" | No ha iniciado sesi&oacute;n");
    		LoggerApi.Log.info(iflexConfig+" | "+clientId+" | "+authToken+" | No ha iniciado sesi&oacute;n"); 
        	return;
        }
 
		if (clientId==null) {
			message = "LOGOUT";
			session.setAttribute("loggedTeApuesto", false);
		} else { 
			  Double saldo = null; 
			  Double bono  = null;	
			  
			pe.com.intralot.loto.lib.Dbms rs = null;
			try {
				 rs = new pe.com.intralot.loto.lib.Dbms();
				 String sql = " select max(nvl(cl_balance_amount,0)) + sum(nvl(decode(cg_sale_type,0,cg_balance_amount,0),0)), sum(nvl(decode(cg_sale_type,1,cg_balance_amount,0),0)) from lotocard.client, lotocard.client_game where client_id = ? and client_id = cg_client_id(+) and cg_game_id(+) = 108 ";
				 rs.setSql(sql);
			     rs.setString(1,String.valueOf(userLogin.getClientId()));
			     rs.executeQuery();
			     if (rs.next()) {
			        saldo = rs.getDouble(1);
			        bono  = rs.getDouble(2);
			     }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) {
						System.out.println("<--------------------ClientPlayController cerrando conexion------------------->");
						rs.close();
					}
				} catch (Exception e) {
					System.out.println("<--------------------ClientPlayController error cerrando conexion------------------->");
					e.printStackTrace();
				}
				
			}
	        	message = "LOGGED";
	        	session.setAttribute("loggedTeApuesto", agreement);
	        	session.setAttribute("user", userLogin.getUser());
	        	session.setAttribute("saldo", saldo);
	        	session.setAttribute("bono", bono);
	        	agreement = (userLogin.getAgreement()==null || userLogin.getAgreement().trim().equals(""))?false:true;
	        	LoggerApi.Log.info("/iflex_parameters loggedTeApuesto="+agreement+" user="+userLogin.getUser()+" saldo="+saldo+" bono="+bono);
		}
		
    	out.print(iflexConfig+" | "+clientId+" | "+authToken+" | "+message);
		LoggerApi.Log.info("/iflex_launch cid="+clientId+" iflexConfig="+iflexConfig+" | "+clientId+" | "+userLogin.getUser()+" | "+authToken+" | "+agreement+" | "+message+" 3");
		LoggerApi.Log.info("-------------- END iflex_launch"); 
    }
    
    
    @RequestMapping(value = "/client_play_show_information")
	public String client_play_information(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	try {
			LoggerApi.Log.info("-------------- START client_play_information");

			HttpSession session = request.getSession();
			ClientProcedureGetLoginData user = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
			
			if(user == null) {
				LoggerApi.Log.info("No es posible identificar al usuario.");
				return "redirect:security_login_execute_authentication.html";
			}
			
			String clientId = user.getClientId().toString();
			
			String secretDataIflexapiRecharge = ConnectionFactory.operationProperty("secretDataIflexapiRecharge", Constantes.contextRechargeApi);
			String balanceServiceIflexapiRecharge = ConnectionFactory.operationProperty("balanceServiceIflexapiRecharge", Constantes.contextRechargeApi);
			
			JsonObject jdata = new JsonObject();
	        jdata.addProperty("operatorId", "6");
	        jdata.addProperty("playerId", clientId);
	        jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
	        jdata.addProperty("platform", "PTA");
	        jdata.addProperty("secret", secretDataIflexapiRecharge);
	
	        String iarechargeResponse = beanSecurityLoginBo.requestWSIflexApiRecharge(jdata.toString(), balanceServiceIflexapiRecharge);
	        JSONObject convertedObject = new JSONObject(iarechargeResponse);
	        String status = convertedObject.getString("status");
	        
	        if(!status.equals("OK")) {
	        	LoggerApi.Log.info("Error interno iflex.");
				return "redirect:security_login_execute_authentication.html";
	        }
	        
	        String token=convertedObject.getString("token");
	        objectModelMap.put("token",token);
	        objectModelMap.put("operatorId","1");
	        
	        LoggerApi.Log.info("-------------- END client_play_information");
	        return "client/interface-game_main";
    	} catch (Exception e) {
			LoggerApi.Log.info("-------------- client_play_information ERROR" + e.getMessage());
			LoggerApi.Log.info("Error interno desconocido.");
			return "redirect:security_login_execute_authentication.html";
		}
	}
    
    @RequestMapping(value = "/client_play_information_api")
	public String client_play_information_api(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	
		try {
			LoggerApi.Log.info("-------------- START client_play_information_api");
			
			String authToken = request.getHeader("authToken");
			
			if(authToken == null) {
				authToken = request.getParameter("authToken");
			}
			
			if (authToken == null) {
				objectModelMap.put("message","No es posible identificar la sesión.");
				return "client/interface-game_error";
			}
			
			HttpSession session = request.getSession();
			String ipToken = SecurityUtils.getClientIp(request);
			ClientProcedureTokenValidation tokenValidation = new ClientProcedureTokenValidation();
			tokenValidation = beanSecurityLoginBo.getTokenValidation(authToken, ipToken);

			if (!tokenValidation.getStatus().equals("OK")) {
				objectModelMap.put("message","La sesión no es valida.");
				return "client/interface-game_error";
			}
			
			if(session.getAttribute("clientId") == null) {
				if(tokenValidation.getClientId() == null) {
					LoggerApi.Log.info("-------------- client_play_information_api TOKEN INVÁLIDO");
					objectModelMap.put("message","ClientID no existe en validación de token.");
					return "client/interface-game_error";
				}
				session.setAttribute("clientId", tokenValidation.getClientId());
			}else {
				String clientId = session.getAttribute("clientId").toString();
				
				if(!clientId.equalsIgnoreCase(tokenValidation.getClientId())) {
					objectModelMap.put("message","Usuario de la petición es incorrecto.");
					return "client/interface-game_error";
				}
			}
			
			String rechargeToken = tokenValidation.getRechargeToken();
			String dataEncrypted = StringLib.encodeLabel(gson.toJson(new ClientDataSessionDTO(session.getAttribute("clientId").toString())));

			objectModelMap.put("dataSession", dataEncrypted);
			objectModelMap.put("token", rechargeToken);
			objectModelMap.put("operatorId","6");
			
			LoggerApi.Log.info("-------------- END client_play_information_api");
			return "client/interface-game_form";
		} catch (Exception e) {
			LoggerApi.Log.info("-------------- client_play_information_api ERROR" + e.getMessage());
			objectModelMap.put("message","Error interno desconocido.");
			return "client/interface-game_error";
		}
	}
    
    @RequestMapping(value = "/client_play_information_api_data")
	public void client_play_information_api_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	LoggerApi.Log.info("-------------- START client_play_information_api_data");
    	
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String json = "";
		
		try {
			HttpSession session = request.getSession();
			String authToken = request.getHeader("authToken");
			
			if(authToken == null) {
				authToken = request.getParameter("authToken");
			}
			
			ClientGameInformationRequestDTO clientGameInformationRequestDTO = new ClientGameInformationRequestDTO();
			clientGameInformationRequestDTO.setToken(authToken);
			clientGameInformationRequestDTO.setClientIp(SecurityUtils.getClientIp(request));
			clientGameInformationRequestDTO.setStartDate(request.getParameter("startdate"));
			clientGameInformationRequestDTO.setEndDate(request.getParameter("enddate"));
			
			ClientGameInformationResponseDTO clientGameResponseDTO = beanClientPlayBo.getClientGameInformation(clientGameInformationRequestDTO, session);
						
            if(session.getAttribute("clientId") == null && request.getParameter("dataSession") != null) {
            	ClientDataSessionDTO clientDataSessionDTO = extractDataSessionFromData(request.getParameter("dataSession"));
            	clientDataSessionDTO.setCoupon(StringLib.serializeHashMapArray(StringLib.toHashMapArray(session.getAttribute("client_play_show_informationList"))));
            	clientDataSessionDTO.setCouponFilter(StringLib.serializeHashMapArray(StringLib.toHashMapArray(session.getAttribute("client_play_show_informationListFilter"))));
    			String dataSession = StringLib.encodeLabel(gson.toJson(clientDataSessionDTO));
    			clientGameResponseDTO.setDataSession(dataSession);
            }
            
			json = gson.toJson(clientGameResponseDTO);
			
			LoggerApi.Log.info("-------------- END client_play_information_api_data");
		} catch (Exception e) {
			LoggerApi.Log.info("-------------- client_play_information_api_data ERROR" + e.getMessage());
		}
		
		out.print(json);
	}
    
    private ClientDataSessionDTO extractDataSessionFromData(String requestData) {
    	try {
    		String dataEncrypted = URLDecoder.decode(requestData, "UTF-8");
        	String dataDecrypted = StringLib.decodeLabel(dataEncrypted);
        	ClientDataSessionDTO obj = gson.fromJson(dataDecrypted, ClientDataSessionDTO.class);        	
        	return obj;
    	}catch(Exception e) {
    		LoggerApi.Log.info("-------------- extractDataSessionFromRequest " + e.getMessage());
    	}
    	return null;
    }
}
