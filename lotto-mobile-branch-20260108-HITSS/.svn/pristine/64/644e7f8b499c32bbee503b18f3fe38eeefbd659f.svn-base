package pe.com.intralot.loto.layer.view.game.kinelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.controller.game.kinelo.bo.KineloResultBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureDrawData;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleLotos5Dispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;

@Controller
public class KineloBetController {

    @Autowired
    private KineloResultBo beanKineloResultBo;
    @Autowired
    private ClientSaleBo clientSaleBo;
    
    @Autowired
    private IntralotUtils intralotUtils;
    
    @Autowired
	private ClientBalanceBo beanClientBalanceBo;
    
    @RequestMapping("/game_kinelo_show_home")
    public ModelAndView showHome(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
        	HttpSession session = request.getSession();
        	if (session.getAttribute("gameKinelo")==null || !(Boolean)session.getAttribute("gameKinelo")) {
        		return new ModelAndView("game/kinelo/interface-home");
        	}else {
        		return new ModelAndView("game/kinelo/interface-shoppingcart");
        	}
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-home");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-home");
        } finally {

        }
    }
    
    @RequestMapping("/game_kinelo_show_home_direct")
    public ModelAndView showHomeDirect(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
        	return new ModelAndView("game/kinelo/interface-home");
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-home");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-home");
        } finally {

        }
    }
    
    @RequestMapping("/game_kinelo_siguiente")
    public ModelAndView showNext(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		try {
			// start capturar precios por jugada(a,b)
			HttpSession session = request.getSession();
			String operation = session.getAttribute("operation").toString();
			objectModelMap.put("operation", operation);

			session.setAttribute("operation", "default");

			return new ModelAndView("game/kinelo/interface-shoppingcart");
		} catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-shoppingcart");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-shoppingcart");
        } finally {

        }
    }
    
    @RequestMapping("/game_kinelo_last_results")
    public ModelAndView showLastResults(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/kinelo/interface-last-results");
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-last-results");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/iinterface-last-results");
        } finally {

        }
    }
    
    @RequestMapping("/game_kinelo_show_bet")
    public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
			Integer idClient = 0;
        	HttpSession session = request.getSession();
        	ClientProcedureGetLoginData clientProcedureLogin = (ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION);
			if(clientProcedureLogin!=null && clientProcedureLogin.getSessionId()!=null && StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {
				idClient = clientProcedureLogin.getClientId();
			}
			KineloProcedureBetData kineSaleBean = beanKineloResultBo.findByClientId(idClient);
        	if(kineSaleBean.getBalanceAmount()!=null)kineSaleBean.setBalanceBill01(intralotUtils.formatCurrency(kineSaleBean.getBalanceAmount()));
        	session.setAttribute("kineloSale", kineSaleBean);
        	
            return new ModelAndView("game/kinelo/interface-bet");
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-bet");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-bet");
        } finally {

        }
    }
    
    @RequestMapping("/game_kinelo_show_consecutive")
    public ModelAndView showConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
        	HttpSession session = request.getSession();

        	List<KineloProcedureDrawData> kineloSaleList = beanKineloResultBo.findListDrawData();
        	session.setAttribute("kineloSaleList", kineloSaleList);
            return new ModelAndView("game/kinelo/interface-consecutive");
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-consecutive");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-consecutive");
        } finally {

        }
    }
    
    //@RequestMapping("/game_kinelo_show_bet")
    @RequestMapping(value = "/game_kinelo_show_bet_set_data", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ResponseBody
    public Object showBetSetData(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
    	Map<String, Object> mapresult = new HashMap<String, Object>();
    	String context = "CARD-WEB";
    	Integer idClient = 0;
    	Integer idSession = 0;
    	String user = "";
    	ClientProcedureGetDataClient dataClient = null;
        try {
        	HttpSession session = request.getSession();
        	ClientProcedureGetLoginData clientProcedureLogin = (ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION);
        	if(clientProcedureLogin!=null && clientProcedureLogin.getSessionId()!=null && StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {
        		idSession = clientProcedureLogin.getSessionId();
        		idClient = clientProcedureLogin.getClientId();
        		user = clientProcedureLogin.getUser();
        		ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
                session.setAttribute("clientSale", clientProcedureGetClient);
                session.setAttribute("dataClient", dataClient);
                if (clientProcedureGetClient == null) {
                	session.invalidate();
                	mapresult.put("redirect", "home.html");
                }
                session.setAttribute("game",Game.KINELO);
                session.setAttribute(Constantes.USR_SESION, clientProcedureLogin);
        	}
    		    		
//        	KineloProcedureBetData kineSaleBean = beanKineloResultBo.findByClientId(idClient);
//        	if(kineSaleBean.getBalanceAmount()!=null)kineSaleBean.setBalanceBill01(intralotUtils.formatCurrency(kineSaleBean.getBalanceAmount()));
//        	session.setAttribute("kineloSale", kineSaleBean);
        	
        	if(parametros.get("typePlay")==null || parametros.get("typePlay").toString().isEmpty()) {
        		session.setAttribute("typePlay", "A");
        	}else {
        		session.setAttribute("typePlay", parametros.get("typePlay").toString());
        	}
        	if(parametros.get("idTypePlay")==null || parametros.get("idTypePlay").toString().isEmpty()) {
        		session.setAttribute("idTypePlay", "J1");
        	}else {
        		session.setAttribute("idTypePlay", parametros.get("idTypePlay").toString());
        	}
        	mapresult.put("redirect", "game_kinelo_show_bet.html");
            //return new ModelAndView("game/kinelo/interface-bet");
        } catch (Exception e) {
            LoggerApi.severe(e);
        } 
        return mapresult;
    }
    
    @RequestMapping(value = "/showLastResultsJson", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public Object showLastResultsJson() throws Exception {
    	Map<String, Object> mapresult = new HashMap<String, Object>();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
        	Draw draw = beanKineloResultBo.getKineloLastResult();
        	if(draw!=null) {
            	mapresult.put("draw", draw.getDrawPk().getDrawId());
            	mapresult.put("bolos", draw.getResult());
            	mapresult.put("hour",sdf.format(draw.getDrawDate()));
        	}
        } catch (Exception e) {
            LoggerApi.severe(e);
        } 
        return mapresult;
    }
    
    @RequestMapping(value = "/showLastResultsByFechaJson", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public Object showLastResultsByFechaJson(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
    	Map<String, Object> mapresult = new HashMap<String, Object>();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	SimpleDateFormat sdfView = new SimpleDateFormat("HH:mm");
    	SimpleDateFormat sdfBD = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
        	String fecha = parametros.get("fecha").toString();
        	String hora = parametros.get("hora").toString();
        	Date fechaMinima = sdf.parse(fecha+" "+hora);
        	Calendar calendario = Calendar.getInstance();
        	calendario.setTimeInMillis(fechaMinima.getTime());
        	calendario.add(Calendar.HOUR, 1);
        	List<Draw> listado = beanKineloResultBo.getKineloLastResultByFecha(sdfBD.format(fechaMinima), sdfBD.format(calendario.getTime()));
        	if(listado!=null) {
        		for (Draw draw : listado) {
        			draw.setAdditional(sdfView.format(draw.getDrawDate()));
				}
        	}
        	mapresult.put("listado", listado);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } 
        return mapresult;
    }
    
    @RequestMapping(value = "/game_kinelo_add_bet", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ResponseBody
	public Object addBet(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
		Map<String, Object> mapresult = new HashMap<String, Object>();
		try {
			HttpSession session = request.getSession();
			List<Integer> knBetA =  (List<Integer>) parametros.get("knBetA");
			List<Integer> knBetB = (List<Integer>) parametros.get("knBetB");
			int multiplierBetA = Integer.parseInt(parametros.get("multiplierBetA").toString());
			int multiplierBetB = Integer.parseInt(parametros.get("multiplierBetB").toString());
			int yourBetA = Integer.parseInt(parametros.get("yourBetA").toString());
			int yourBetB = Integer.parseInt(parametros.get("yourBetB").toString());
			session.setAttribute("gameKinelo", true);
			session.setAttribute("gameKineloA", knBetA);
			session.setAttribute("gameKineloB", knBetB);
			session.setAttribute("multiplierBetA", multiplierBetA);
			session.setAttribute("multiplierBetB", multiplierBetB);
			session.setAttribute("yourBetA", yourBetA);
			session.setAttribute("yourBetB", yourBetB);
			
			session.setAttribute("operation", "add");
			if(yourBetA>0) session.setAttribute("lastPlay", "jugadaA");
			if(yourBetB>0) session.setAttribute("lastPlay", "jugadaB");
			
			IntralotUtils.carItemUpdate(session);
			mapresult.put("redirect", "game_kinelo_siguiente.html");
		}catch (Exception e) {
			LoggerApi.severe(e);
		} 
		return mapresult;
	}
    
    @RequestMapping(value = "/game_kinelo_delete_bet", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBet(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
		Map<String, Object> mapresult = new HashMap<String, Object>();
		try {
			HttpSession session = request.getSession();
			String gameKinelo = parametros.get("gameKinelo").toString();
			String lastDelete = parametros.get("lastDelete").toString();
			
			session.removeAttribute(gameKinelo);
			if(gameKinelo.equals("gameKineloA")) {
				session.removeAttribute("multiplierBetA");
				session.removeAttribute("yourBetA");
				session.removeAttribute("gameKineloA");
			}else {
				session.removeAttribute("multiplierBetB");
				session.removeAttribute("yourBetB");
				session.removeAttribute("gameKineloB");
			}
			if( (session.getAttribute("gameKineloA")==null || ((List<String>) session.getAttribute("gameKineloA")).isEmpty()) && (session.getAttribute("gameKineloB")==null || ((List<String>) session.getAttribute("gameKineloB")).isEmpty()) ) {
				session.setAttribute("gameKinelo", false);
			}
			session.setAttribute("operation", "delete");
			session.setAttribute("lastDelete", lastDelete);
			IntralotUtils.carItemUpdate(session);
			mapresult.put("redirect", "game_kinelo_siguiente.html");
		}catch (Exception e) {
			LoggerApi.severe(e);
		} 
		return mapresult;
	}
    
    @RequestMapping(value = "/game_kinelo_add_consecutive", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ResponseBody
	public Object addConsecutive(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
		Map<String, Object> mapresult = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		try {	
			int num_draw =  Integer.parseInt(parametros.get("num_draw").toString());
			session.setAttribute("num_draw", num_draw);
			session.setAttribute("operation", "consecutive");
			mapresult.put("redirect", "game_kinelo_siguiente.html");
		} catch (NullPointerException e) {
			LoggerApi.severe(e);
			session.setAttribute("num_draw", 1);
			mapresult.put("redirect", "game_kinelo_siguiente.html");
		} catch (Exception e) {
			LoggerApi.severe(e);
		} 
		return mapresult;
	}
    
    
    @RequestMapping("/game_kinelo_delete_consecutive")
    public ModelAndView deleteConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		try {
			HttpSession session = request.getSession();

			// tagging remove consecutive
			objectModelMap.put("remove_num_draw", session.getAttribute("num_draw"));
			objectModelMap.put("operation", "removeConsecutive");
			session.setAttribute("operation", "default");
			// end tagging remove consecutive

			session.removeAttribute("num_draw");

            return new ModelAndView("game/kinelo/interface-shoppingcart");
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-shoppingcart");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-shoppingcart");
        } finally {

        }
    }

    @RequestMapping(value = "/game_kinelo_total_bet", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ResponseBody
	public Object setTotalBet(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
    	Map<String, Object> mapresult = new HashMap<String, Object>();
    	HttpSession session = request.getSession();
    	try {
			session.setAttribute("total_bet", parametros.get("total_bet").toString());
		} catch (Exception e) {
			LoggerApi.severe(e);
		}
    	return mapresult;
    }
    
    @RequestMapping(value = "/game_kinelo_play_bet", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ResponseBody
	public Object playBet(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws Exception {
    	Map<String, Object> mapresult = new HashMap<String, Object>();
    	HttpSession session = request.getSession();
     	try {
    		ClientProcedureGetLoginData clientProcedureLogin = (ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION);
    		if(clientProcedureLogin!=null && clientProcedureLogin.getSessionId()!=null && StringUtils.isNotEmpty((String)session.getAttribute("clientId"))) {
    			String clientId = clientProcedureLogin.getClientId().toString();
    			String ip = request.getRemoteAddr().toString();
    	        int gameId = Game.KINELO;
    	        Game gm = new Game(gameId);
                String name_game = gm.getName();
                int multiDraws = 1;
                StringBuilder play = new StringBuilder("");
                
                int multiplierBetAuxA = 1;
            	int multiplierBetAuxB = 1;
            	int num_drawAux=1;
            	int numBolJugadaA=0;
            	int numBolJugadaB=0;
            	int totalApuestas=0;
                
                if(session.getAttribute("gameKineloA")==null || ((List<String>) session.getAttribute("gameKineloA")).isEmpty()) {
                	int multiplierBetB = 1;
                	if(session.getAttribute("multiplierBetB")!=null) {
                		multiplierBetB = Integer.parseInt(session.getAttribute("multiplierBetB").toString());
                	}
                	
                	multiplierBetAuxB=multiplierBetB;
                	
                	List<String> knBetB = (List<String>) session.getAttribute("gameKineloB");
                	
                	numBolJugadaB=knBetB.size();
                	totalApuestas=1;
                	
                	for (String numero : knBetB) {
                		play.append(numero.trim());
                		play.append(Constantes.ESPACIO_VACIO);
					}
                	play.append(Constantes.CARACTER_X);
                	play.append(Constantes.ESPACIO_VACIO);
                	play.append(multiplierBetB);
                }else if(session.getAttribute("gameKineloB")==null || ((List<String>) session.getAttribute("gameKineloB")).isEmpty()) {
                	int multiplierBetA = 1;
                	if(session.getAttribute("multiplierBetA")!=null) {
                		multiplierBetA = Integer.parseInt(session.getAttribute("multiplierBetA").toString());
                	}
                	

                	multiplierBetAuxA=multiplierBetA;
                	totalApuestas=1;
                	
                	List<String> knBetA = (List<String>) session.getAttribute("gameKineloA");
                	
                	numBolJugadaA=knBetA.size();
                	
                	for (String numero : knBetA) {
                		play.append(numero.trim());
                		play.append(Constantes.ESPACIO_VACIO);
					}
                	play.append(Constantes.CARACTER_X);
                	play.append(Constantes.ESPACIO_VACIO);
                	play.append(multiplierBetA);
                }else {
                	int multiplierBetA = 1;
                	int multiplierBetB = 1;
                	
                	
                	
                	if(session.getAttribute("multiplierBetA")!=null) {
                		multiplierBetA = Integer.parseInt(session.getAttribute("multiplierBetA").toString());
                	}
                	if(session.getAttribute("multiplierBetB")!=null) {
                		multiplierBetB = Integer.parseInt(session.getAttribute("multiplierBetB").toString());
                	}
                	multiplierBetAuxA=multiplierBetA;
                	multiplierBetAuxB=multiplierBetB;
                	
                	
                	List<String> knBetA = (List<String>) session.getAttribute("gameKineloA");
                	List<String> knBetB = (List<String>) session.getAttribute("gameKineloB");
                	
                	
                	
                	numBolJugadaA=knBetA.size();
                	numBolJugadaB=knBetB.size();
                	
                	totalApuestas=2;
                	
                	
                	
                	for (String numero : knBetA) {
                		play.append(numero.trim());
                		play.append(Constantes.ESPACIO_VACIO);
					}
                	play.append(Constantes.CARACTER_X);
                	play.append(Constantes.ESPACIO_VACIO);
                	play.append(multiplierBetA);
                	play.append(Constantes.PIPE);
                	for (String numero : knBetB) {
                		play.append(numero.trim());
                		play.append(Constantes.ESPACIO_VACIO);
					}
                	play.append(Constantes.CARACTER_X);
                	play.append(Constantes.ESPACIO_VACIO);
                	play.append(multiplierBetB);
                }
		
                double price = Double.parseDouble(parametros.get("total_bet").toString());
              
                int jugadasGratis= Integer.parseInt(parametros.get("jugadasGratis").toString());
                
                String importePagar =parametros.get("total_bet").toString();
                if(session.getAttribute("num_draw")!=null) {
                	multiDraws =  Integer.parseInt(session.getAttribute("num_draw").toString());
                	num_drawAux=multiDraws;
                }
    			String[] o = GameSaleLotos5Dispatcher.playCouponByWeb(clientId, ip, gameId, play.toString(), multiDraws, 0, "", 0, price, null, Constantes.PLATAFORMA);
    			if(o!=null) {
    				if(o[0].equalsIgnoreCase("OK")) {
    					session.setAttribute("status", "ok");
    	    			session.setAttribute("gameKinelo", false);
    	    			
    	    			//Tagg
    	    			session.setAttribute("importePagar", importePagar);
    	    			session.setAttribute("ticketId", o[1]);
    	    			session.setAttribute("multiplierBetAuxA", multiplierBetAuxA);
       	  			    session.setAttribute("multiplierBetAuxB", multiplierBetAuxB);
       	  		        session.setAttribute("num_drawAux", num_drawAux);
       	  		        session.setAttribute("numBolJugadaA", numBolJugadaA);
       	  		        session.setAttribute("numBolJugadaB", numBolJugadaB);
       	  		        session.setAttribute("totalApuestas", totalApuestas);
       	  		        session.setAttribute("jugadasGratis", jugadasGratis);       	  		
       	  			    //tagg fin
       	  		        
    	    			IntralotUtils.carItemUpdate(session);
    	    			session.removeAttribute("kineloSaleList");
    	    			session.removeAttribute("game");
    	    			session.removeAttribute("kineloSale");
    	    			session.removeAttribute("typePlay");
    	    			session.removeAttribute("idTypePlay");
    	    			session.removeAttribute("gameKinelo");
    	    			session.removeAttribute("gameKineloA");
    	    			session.removeAttribute("gameKineloB");
    	    			session.removeAttribute("multiplierBetA");
    	    			session.removeAttribute("multiplierBetB");
    	    			session.removeAttribute("yourBetA");
    	    			session.removeAttribute("yourBetB");
    	    			session.removeAttribute("num_draw");
    	    			
    	    			
    	    			ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(clientProcedureLogin.getClientId());
    	  			  	accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
    	  			  	intralotUtils.updateBalanceSession(session,accountData,0,"");
    	  			  	
    	  			 
    	  			  	
    				}else if(o[0].contains("CREDITO INSUFICIENTE")) {
    					session.setAttribute("status", "saldo");
    					session.setAttribute("alertPlay","No cuenta con saldo disponible para realizar su compra");
    				}else {
    					session.setAttribute("status", "error");
    					session.setAttribute("alertPlay","Ocurrió un error intente nuevamente");
    				}
    				
    				
    			}else {
    				session.setAttribute("status", "error");
    			}
    			mapresult.put("redirect", "game_kinelo_play_bet_result.html");
    		}
    	}catch (Exception e) {
			LoggerApi.severe(e);
			session.setAttribute("status", "error");
			session.setAttribute("alertPlay","Ocurrió un error intente nuevamente");
			mapresult.put("redirect", "game_kinelo_play_bet_result.html");
		} 
    	return mapresult;
    }
    
    @RequestMapping("/game_kinelo_play_bet_result")
    public ModelAndView playBetResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/kinelo/interface-result_game");
        } catch (NullPointerException e) {
			return new ModelAndView("game/kinelo/interface-result_game");
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kinelo/interface-result_game");
        } finally {

        }
    }
    
    @RequestMapping("/game_kinelo_play_bet_result_login")
    public ModelAndView playBetResultLogin(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
     	try {
    		ClientProcedureGetLoginData clientProcedureLogin = (ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION);
			String clientId = clientProcedureLogin.getClientId().toString();
			String ip = request.getRemoteAddr().toString();
	        int gameId = Game.KINELO;
	        Game gm = new Game(gameId);
            String name_game = gm.getName();
            int multiDraws = 1;
            StringBuilder play = new StringBuilder("");
            
            int multiplierBetAuxA = 1;
        	int multiplierBetAuxB = 1;
        	int num_drawAux=1;
        	int numBolJugadaA=0;
        	int numBolJugadaB=0;
        	int totalApuestas=0;
            
            if(session.getAttribute("gameKineloA")==null || ((List<String>) session.getAttribute("gameKineloA")).isEmpty()) {
            	int multiplierBetB = 1;
            	if(session.getAttribute("multiplierBetB")!=null) {
            		multiplierBetB = Integer.parseInt(session.getAttribute("multiplierBetB").toString());
            	}
            	
            	multiplierBetAuxB=multiplierBetB;
            	
            	List<String> knBetB = (List<String>) session.getAttribute("gameKineloB");          	
            	
            	numBolJugadaB=knBetB.size();
            	totalApuestas=1;
            	
            	
            	
            	for (String numero : knBetB) {
            		play.append(numero.trim());
            		play.append(Constantes.ESPACIO_VACIO);
				}
            	play.append(Constantes.CARACTER_X);
            	play.append(Constantes.ESPACIO_VACIO);
            	play.append(multiplierBetB);
            	
            }else if(session.getAttribute("gameKineloB")==null || ((List<String>) session.getAttribute("gameKineloB")).isEmpty()) {
            	int multiplierBetA = 1;
            	if(session.getAttribute("multiplierBetA")!=null) {
            		multiplierBetA = Integer.parseInt(session.getAttribute("multiplierBetA").toString());
            	}
            	
            	multiplierBetAuxA=multiplierBetA;
            	
            	List<String> knBetA = (List<String>) session.getAttribute("gameKineloA");            	
            	
            	numBolJugadaA=knBetA.size();
            	totalApuestas=1;
            	
            	for (String numero : knBetA) {
            		play.append(numero.trim());
            		play.append(Constantes.ESPACIO_VACIO);
				}
            	play.append(Constantes.CARACTER_X);
            	play.append(Constantes.ESPACIO_VACIO);
            	play.append(multiplierBetA);
            }else {
            	int multiplierBetA = 1;
            	int multiplierBetB = 1;
            	if(session.getAttribute("multiplierBetA")!=null) {
            		multiplierBetA = Integer.parseInt(session.getAttribute("multiplierBetA").toString());
            	}
            	if(session.getAttribute("multiplierBetB")!=null) {
            		multiplierBetB = Integer.parseInt(session.getAttribute("multiplierBetB").toString());
            	}
            	
            	multiplierBetAuxA=multiplierBetA;
            	multiplierBetAuxB=multiplierBetB;
            	
            	List<String> knBetA = (List<String>) session.getAttribute("gameKineloA");
            	List<String> knBetB = (List<String>) session.getAttribute("gameKineloB");
            	
            	numBolJugadaA=knBetA.size();
            	numBolJugadaB=knBetB.size();
            	totalApuestas=2;
            	
            	for (String numero : knBetA) {
            		play.append(numero.trim());
            		play.append(Constantes.ESPACIO_VACIO);
				}
            	play.append(Constantes.CARACTER_X);
            	play.append(Constantes.ESPACIO_VACIO);
            	play.append(multiplierBetA);
            	play.append(Constantes.PIPE);
            	for (String numero : knBetB) {
            		play.append(numero.trim());
            		play.append(Constantes.ESPACIO_VACIO);
				}
            	play.append(Constantes.CARACTER_X);
            	play.append(Constantes.ESPACIO_VACIO);
            	play.append(multiplierBetB);
            }
	
            double price = Double.parseDouble(session.getAttribute("total_bet").toString());
            String importePagar =session.getAttribute("total_bet").toString();
            
            KineloProcedureBetData kineSaleBean = beanKineloResultBo.findByClientId(clientProcedureLogin.getClientId());
            session.setAttribute("jugadasGratis", kineSaleBean.getBalanceQuantityGame());
            
            if(session.getAttribute("num_draw")!=null) {
            	multiDraws =  Integer.parseInt(session.getAttribute("num_draw").toString());
            }
			String[] o = GameSaleLotos5Dispatcher.playCouponByWeb(clientId, ip, gameId, play.toString(), multiDraws, 0, "", 0, price, null, Constantes.PLATAFORMA);
			if(o!=null) {
				if(o[0].equalsIgnoreCase("OK")) {
					session.setAttribute("status", "ok");
	    			session.setAttribute("gameKinelo", false);
	    			
	    			//Tagg
	    			session.setAttribute("importePagar", importePagar);
	    			session.setAttribute("ticketId", o[1]);
	    			session.setAttribute("multiplierBetAuxA", multiplierBetAuxA);
   	  			    session.setAttribute("multiplierBetAuxB", multiplierBetAuxB);
   	  		        session.setAttribute("num_drawAux", num_drawAux);
   	  		        session.setAttribute("numBolJugadaA", numBolJugadaA);
   	  		        session.setAttribute("numBolJugadaB", numBolJugadaB);
   	  		        session.setAttribute("totalApuestas", totalApuestas);
   	  		              	  		
   	  			    //tagg fin
	    			
	    			IntralotUtils.carItemUpdate(session);
	    			session.removeAttribute("kineloSaleList");
	    			session.removeAttribute("game");
	    			session.removeAttribute("kineloSale");
	    			session.removeAttribute("typePlay");
	    			session.removeAttribute("idTypePlay");
	    			session.removeAttribute("gameKinelo");
	    			session.removeAttribute("gameKineloA");
	    			session.removeAttribute("gameKineloB");
	    			session.removeAttribute("multiplierBetA");
	    			session.removeAttribute("multiplierBetB");
	    			session.removeAttribute("yourBetA");
	    			session.removeAttribute("yourBetB");
	    			session.removeAttribute("num_draw");
	    			
	    			ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(clientProcedureLogin.getClientId());
	  			  	accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
	  			  	intralotUtils.updateBalanceSession(session,accountData,0,"");
				
				}else if(o[0].contains("autoexclusión")) {
					session.setAttribute("status", "autoexclusion");
				}else if(o[0].contains("CREDITO INSUFICIENTE")) {
					session.setAttribute("status", "saldo");
				}else {
					session.setAttribute("status", "error");
				}
			}else {
				session.setAttribute("status", "error");
			}
    	}catch (Exception e) {
			LoggerApi.severe(e);
			session.setAttribute("status", "error");
		} 
    	return new ModelAndView("game/kinelo/interface-result_game");
    }
	 
}
