package pe.com.intralot.loto.layer.view.game.ganagol;

import java.text.SimpleDateFormat;

/**
 * @author:   Joel Ramirez   
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 * @author:   Emanuel Barrera
 * @rol:	  Developer
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.layer.controller.game.ganagol.bo.GanagolBetBo;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.DrawItem;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetDataMobile;
import pe.com.intralot.loto.layer.model.pojo.GanagolSale;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.Utils;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.ClientTicket;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.model.Group;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;

@Controller
public class GanagolBetController {
	
	@Autowired
	private GanagolBetBo beanGanagolBetBo;
	
	@Autowired
	private IntralotUtils intralotUtils;

	@RequestMapping("/game_ganagol_show_menu")	
	public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		//LoggerApi.Log.info("Ingresando a game_ganagol_show_menu");
		HttpSession session = request.getSession();
		String idClient = "";
	    int idClientInt = 0;
		try {
			//LoggerApi.Log.info("Chekando cliente en session");
			if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    		idClientInt = Integer.parseInt(idClient);
	    	}
			//LoggerApi.Log.info("Obteniendo draw de getDrawsGanagol01");
			Draw draw=beanGanagolBetBo.getDrawsGanagol01();
			
			//LoggerApi.Log.info("Injectando draw como headerGame en objectModelMap");
			objectModelMap.put("headerGame",draw);
			
			//LoggerApi.Log.info("Injectando getJackpot como pozo en objectModelMap");
			objectModelMap.put("pozo",intralotUtils.formatCurrency2(draw.getJackpot() !=null? draw.getJackpot() :0));
			
			//LoggerApi.Log.info("Injectando getJackpot2 como jackpot en objectModelMap");
			objectModelMap.put("jackpot",intralotUtils.formatCurrency2(draw.getJackpot2()));		
			
			//LoggerApi.Log.info("Obteniendo draw de getDrawsGanagol02");
			draw=beanGanagolBetBo.getDrawsGanagol02();
			if(draw != null && draw.getResult() != null && !draw.getResult().trim().equals("")){

				draw.setResult(draw.getResult().replace(" ", " - "));
			  
			}
			//LoggerApi.Log.info("Injectando draw como headerResult en objectModelMap");
			objectModelMap.put("headerResult",draw);
			//Obteniendo la cantidad de goles del programa
			//String cantiGoles200 = draw.getDrAddonResult1();
			//objectModelMap.put("goles200",cantiGoles200);
			
			//LoggerApi.Log.info("Obteniendo ganagolSaleBean de findGanagolByClientId");
			//GanagolProcedureBetData ganagolSaleBean = beanGanagolBetBo.findGanagolByClientId(idClientInt);
			GanagolProcedureBetDataMobile ganagolSaleBean = beanGanagolBetBo.findGanagolByClientIdMobile(idClientInt);
			//LoggerApi.Log.info("Injectando ganagolSaleBean como ganagolSale en objectModelMap");
			
			if(ganagolSaleBean.getActiveDraw() != null && ganagolSaleBean.getPrize().equals("POZO ACUMULADO POR DEFINIR")) ganagolSaleBean.setStatus("LST");
										
			objectModelMap.put("ganagolSale", ganagolSaleBean);
            
			//LoggerApi.Log.info("Redirigiendo a la vista game/ganagol/interface-home");
			return new ModelAndView("game/ganagol/interface-home");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/ganagol/interface-home");
		}	
	}	
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>Muestra LEV por cada opción de apuesta, indica en cuál partido se encuentra</p>
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	@RequestMapping("/game_ganagol_show_betAdd")	
	public ModelAndView showBetadd(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			LoggerApi.Log.info("");
			HttpSession session = request.getSession();
			
			session.setAttribute("gameGanagolId","id_"+request.getParameter("id"));
	
			List<DrawItem> item=(List<DrawItem>) session.getAttribute("resultListGanagol");
			if(item!=null){
			for (DrawItem drawItem : item) {
				
				if(StringUtils.equals(String.valueOf(drawItem.getDrawpk().getItem()),request.getParameter("id"))){
					objectModelMap.put("itemPk",drawItem.getDrawpk().getItem());					          
					objectModelMap.put("title",drawItem.getDrawpk().getItem()+"/14 "+drawItem.getLocalName()+" vs "+drawItem.getVisitorName());
					objectModelMap.put("local",drawItem.getLocalName());	
					objectModelMap.put("visitante",drawItem.getVisitorName());	
					objectModelMap.put("torneo",drawItem.getDi_cup_name());	
					
					
					String sTexto = drawItem.getDi_cup_name().toString();
					 int car=0;String cadena="";String respuesta="hola"; 
					 for (int x=0; x < sTexto.length(); x++) {
					      if (sTexto.charAt(x) == '*'){
					        car++;cadena=cadena.concat("*");
				                }
					    }
					if(cadena.equalsIgnoreCase("*")){
						respuesta="Resultado primer tiempo";
					}	else if(cadena.equalsIgnoreCase("**")){
							respuesta="Resultado segundo tiempo";	
						}	else{
							respuesta=null;
								}
					objectModelMap.put("asterisco",cadena);	
					objectModelMap.put("tiempos",respuesta);	
				 break;	
				}
			}
			}
			return new ModelAndView("game/ganagol/interface-shoppingcart-add");
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/ganagol/interface-shoppingcart-add");
		}
	
	}
	
	private Integer validarCantidadJugadas(Map<String, List<String>> playList,Map<String, Map<String,List<String>>> game, String typePlayGanagol) {
		
		Integer totalJugadasNew = 1;
		Integer totalJugadasBoleto = 0;
		
		totalJugadasNew = getTotalJugadas(playList);		
		LoggerApi.Log.info("/validarCantidadJugadas typePlayGanagol="+typePlayGanagol);
		game.remove(typePlayGanagol);
		LoggerApi.Log.info("/validarCantidadJugadas game="+game);
		
		for (Map.Entry<String, Map<String,List<String>>> jugada : game.entrySet()) {
			Integer totalJugadasOld = 1;
			for (Map.Entry<String,List<String>> bet : jugada.getValue().entrySet()) {
				totalJugadasOld = totalJugadasOld * bet.getValue().size();
			}
			totalJugadasBoleto += totalJugadasOld; 
		}

		return  totalJugadasBoleto+totalJugadasNew;
	}
	
	private Integer getTotalJugadas(Map<String, List<String>> playList) {
		Integer totalJugadas = 1;
		
		for (Map.Entry<String, List<String>> bet : playList.entrySet()) {
			totalJugadas = totalJugadas*bet.getValue().size();
		}
		
		return totalJugadas;
	}
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>Añade LEV por cada opción de jugada, uno por uno</p>
	 * <p>Se tiene que modificar para que soporte todas las jugadas</p>
	 * Revisar con testing el formato de envio
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/game_ganagol_add_bet")	
	public ModelAndView addBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		HttpSession session = request.getSession();	
		session.setAttribute("ganagolOvercomeJugadas", 0);
		
		try {
		LoggerApi.Log.info("");		
			
			Map<String, Map<String,List<String>>> game=new HashMap<String, Map<String,List<String>>>();
			Map<String, List<String>> playList=new LinkedHashMap<String, List<String>>();
			List<String> betList =new ArrayList<String>();
			
			String play = "";

			Integer cantidadBets = 1;
			while(cantidadBets<=15) {
				String[] bets = request.getParameterValues("bet_"+cantidadBets);
				String bet = "";
				if(bets!=null && bets.length>0) {
					for (String option : bets) {
						bet += option;
					}
				}
				LoggerApi.Log.info("/game_ganagol_add_bet bet="+bet);
				play += bet+" ";
				LoggerApi.Log.info("/game_ganagol_add_bet paly="+play);
				cantidadBets++;
			}
			
			LoggerApi.Log.info("/game_ganagol_add_bet play final ="+play);
	       
	        String[] bets = play.split(" ");
	        LoggerApi.Log.info("/game_ganagol_add_bet bets= "+bets);
	       
			
	        Integer index=1;
			for (String bet : bets) {
				if(index != 15) {
					String firstOpt = bet.substring(0,1);
					String seconfOpt = bet.length()>1? bet.substring(1,2):"";
					String thirdOpt = bet.length()>2? bet.substring(2,3):"";
	
					betList.add(firstOpt);
					if (seconfOpt!="")betList.add(seconfOpt);
					if (thirdOpt!="")betList.add(thirdOpt);
				}else {
						String rangoG200= "";
						if(bets[bets.length-1].equals("08")) {
							rangoG200 = "0-8";
						}else if (bets[bets.length-1].equals("915")) {
							rangoG200 = "9-15";
						}else if (bets[bets.length-1].equals("1620")) {
							rangoG200 = "16-20";
						}else if (bets[bets.length-1].equals("2125")) {
							rangoG200 = "21-25";
						}else if (bets[bets.length-1].equals("2630")) {
							rangoG200 = "26-30";
						}else if (bets[bets.length-1].equals("3135")) {
							rangoG200 = "31-35";
						}else if (bets[bets.length-1].equals("3640")) {
							rangoG200 = "36-40";
						}else if (bets[bets.length-1].equals("4143")) {
							rangoG200 = "41-43";	
						}else if (bets[bets.length-1].equals("4445")) {
							rangoG200 = "44-46";
						}else if (bets[bets.length-1].equals("47")) {
							rangoG200 = "47-a más";
						}	
						betList.add(rangoG200);
					
				}
				LoggerApi.Log.info("/game_ganagol_add_bet betList= "+betList);
				playList.put("id_"+index++,betList);
				LoggerApi.Log.info("/game_ganagol_add_bet playList= "+playList);
				betList =  new ArrayList<String>();
			}
			LoggerApi.Log.info("/game_ganagol_add_bet playList final= "+playList);
			
			
			if(getTotalJugadas(playList)>288) {
				LoggerApi.Log.info("/game_ganagol_add_bet getTotalJugadas(playList)="+getTotalJugadas(playList));
				session.setAttribute("ganagolOvercomeJugadas", 1);
				return new ModelAndView("redirect:game_ganagol_show_menu.html"); 
			}

		if(MapUtils.isNotEmpty(playList)){
				
				if(session!=null && session.getAttribute("gameGanagolBoleto")!=null && MapUtils.isNotEmpty((Map) session.getAttribute("gameGanagolBoleto"))) game = (Map)session.getAttribute("gameGanagolBoleto");
				String typePlayGanagol = (String) session.getAttribute("typePlayGanagol");
				Integer totalJugadaBoleto = validarCantidadJugadas(playList,game,typePlayGanagol);
				if(totalJugadaBoleto>288) {
					LoggerApi.Log.info("/game_ganagol_add_bet totalJugadaBoleto="+totalJugadaBoleto);
					session.setAttribute("ganagolOvercomeJugadas", 1);
					return new ModelAndView("redirect:game_ganagol_show_menu.html");  
				}
					
				game.put(typePlayGanagol,playList);
				LoggerApi.Log.info("/game_ganagol_add_bet game="+game);
				session.setAttribute("gameGanagolBoleto", new TreeMap(game));
				session.getAttribute(null);
				session.removeAttribute("gameGanagolId");
				session.setAttribute("ganagolJugadas", 288-totalJugadaBoleto);
				IntralotUtils.carItemUpdate(session);
				
			}
			
		session.setAttribute("operation", "add");
		LoggerApi.Log.info("/game_ganagol_add_bet redirect:game_ganagol_show_shoppingcart.html");
		return new ModelAndView("redirect:game_ganagol_show_shoppingcart.html");
		
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_ganagol_show_shoppingcart.html");
		}
	
	}
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * Muestra los partidos y los lista e indica en que jugada se ecnuentra a,b,c o d
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/game_ganagol_show_bet")	
	public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception { 
					
		try {
            LoggerApi.Log.info("-------------- START game_ganagol_show_bet"); 
			
			Draw draw=beanGanagolBetBo.getDrawsGanagol01();
			
			objectModelMap.put("headerGame",draw);
			
			HttpSession session = request.getSession();		
			
			if(session.getAttribute("playGanagolList")!=null) session.removeAttribute("playGanagolList");
					
			session.setAttribute("typePlayGanagol",request.getParameter("play"));
			LoggerApi.Log.info("/game_ganagol_show_bet play="+request.getParameter("play"));
					
			if(CollectionUtils.isEmpty((List<DrawItem>) session.getAttribute("resultListGanagol"))){
				session.setAttribute("resultListGanagol",beanGanagolBetBo.findInformationForDrawItem());
			}
					
			Integer ganagolJugadas = 288;
			String valueCheck200="0";
			LoggerApi.Log.info("/game_ganagol_show_bet gameGanagolBoleto="+MapUtils.isNotEmpty((Map)session.getAttribute("gameGanagolBoleto")));
			Map mapa = new HashMap();			
			LoggerApi.Log.info("/game_ganagol_show_bet 1 "+session.getAttribute("gameGanagolBoleto"));
			if (session!=null && session.getAttribute("gameGanagolBoleto")!=null) mapa = (Map)session.getAttribute("gameGanagolBoleto");
			if (MapUtils.isNotEmpty(mapa)) {
				LoggerApi.Log.info("/game_ganagol_show_bet 2");
				Map<String,List<String>> playGanagolList = new HashMap<String, List<String>>();
				LoggerApi.Log.info("/game_ganagol_show_bet 3");
				if(request.getParameter("play")!=null && !(request.getParameter("play").toString().trim()).equals("")) playGanagolList = (Map<String, List<String>>) mapa.get(request.getParameter("play"));
				LoggerApi.Log.info("/game_ganagol_show_bet playGanagolList="+playGanagolList);
			
				if(playGanagolList!=null) {
					List<String> value_golazo200 = playGanagolList.get("id_15");
					
					if(value_golazo200!=null) {
						valueCheck200= value_golazo200.get(0);
						if(valueCheck200.equals("0-8")) {
							valueCheck200= "08";
						}else if(valueCheck200.equals("9-15")) {
							valueCheck200= "915";
						}else if(valueCheck200.equals("16-20")) {
							valueCheck200= "1620";
						}else if(valueCheck200.equals("21-25")) {
							valueCheck200= "2125";
						}else if(valueCheck200.equals("26-30")) {
							valueCheck200= "2630";
						}else if(valueCheck200.equals("31-35")) {
							valueCheck200= "3135";
						}else if(valueCheck200.equals("36-40")) {
							valueCheck200= "3640";
						}else if(valueCheck200.equals("41-43")) {
							valueCheck200= "4143";
						}else if(valueCheck200.equals("44-46")) {
							valueCheck200= "4446";
						}else if(valueCheck200.equals("47-a más")) {
							valueCheck200= "47";
						}
					}
					
					session.setAttribute("check200",valueCheck200);
					session.setAttribute("playGanagolList",mapa.get(request.getParameter("play")));//(Map)session.getAttribute("gameGanagolBoleto")).get(request.getParameter("play")));
					
					if(session.getAttribute("ganagolJugadas")!=null) ganagolJugadas = (Integer) session.getAttribute("ganagolJugadas");
					LoggerApi.Log.info("/game_ganagol_show_bet ganagolJugadas="+ganagolJugadas);
					
					Integer betJugadas = getTotalJugadas(playGanagolList);
					LoggerApi.Log.info("/game_ganagol_show_bet betJugadas="+betJugadas);
					
					ganagolJugadas = ganagolJugadas+betJugadas;
					LoggerApi.Log.info("/game_ganagol_show_bet ganagolJugadas="+ganagolJugadas);
					
					session.setAttribute("ganagolJugadas", ganagolJugadas);
				}else {
					session.setAttribute("check200",valueCheck200);
				}

			}else {
				session.setAttribute("check200",valueCheck200);
			}
			
			if(session.getAttribute("ganagolJugadas")==null) session.setAttribute("ganagolJugadas", ganagolJugadas);
			
			return new ModelAndView("game/ganagol/interface-bet");									
			
		} catch (Exception e) {
			LoggerApi.severe(e, "game_ganagol_show_bet","");
			
			return new ModelAndView("redirect:game_ganagol_show_menu.html");			
		} finally {
            LoggerApi.Log.info("-------------- END game_ganagol_show_bet"); 
		}
						
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/game_ganagol_show_shoppingcart")	
	public ModelAndView showShoppingCart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		int clientId = 0;
		try {
				LoggerApi.Log.info("/game_ganagol_show_shoppingcart on");
	
				HttpSession session = request.getSession();	
		
				int subtotalType2=0;
				int subtotalType3=0;
			    int total=0;
			    int totalJA=0;
			    int totalJB=0;
			    int totalJC=0;
			    int totalJD=0;
			    
			    String g200="";
			    int g200a=0;
			    int g200b=0;
			    int g200c=0;
			    int g200d=0;
				
			    String estado = "";
			    String recorre_cadena="";
			    
				Map map= (Map) session.getAttribute("gameGanagolBoleto");
				Map playList=new LinkedHashMap();
				Map gameGanagolBoleto=new HashMap();
				
				if(MapUtils.isNotEmpty(map) && map.size()>0) {
					for(Iterator it = map.keySet().iterator();it.hasNext();) {
					String mapa = (String)it.next();	
					Map maping = new HashMap();
                    if(mapa !=null && !mapa.trim().equals("")) maping =(Map) map.get(mapa);
					//Map maping =(Map) map.get(mapa);
					recorre_cadena=recorre_cadena+maping.size()+"-";
					
					String sTexto_1 = recorre_cadena;
		            int car_1 = 0;
		            String cadenita_1 = "", cade_1 = "";
		            int inicial_1 = 0, siguiente_1 = 1;
		            String indicador_1 = "yes";

		            for (int x = 0; x < sTexto_1.length(); x++) {

		            	cadenita_1 = sTexto_1.substring(inicial_1, siguiente_1);
		            if (!cadenita_1.equals("-") && !cadenita_1.equals("")) {
		            	cade_1 += cadenita_1;
		            	car_1 = Integer.parseInt(cade_1);
		            } else {
		                 if (car_1 < 14 ) {
		                	 indicador_1 = "no";
		                }
		                cade_1 = "";
		            }

		            inicial_1++;
		            siguiente_1++;
		            }
		            estado=indicador_1;
		            
		            int tamBet = maping.size();
					int countBet = maping.size()/tamBet ==1 ? 1 :0;
					int countType2=0;
					int countType3=0;
					
					
				   for(int i=1;i<16;i++){					   
					   List play= (List) maping.get("id_"+i);
					  if(CollectionUtils.isNotEmpty(play)){
						  playList.put("id_"+i,play);	
						  if(i!=15) {
							   if(play.size()==2){							  
								   countType2 ++;							   
							   }else if(play.size()==3){							  
								   countType3++;								 
							   }
						  }
					
					  }				  
				   }
				   				   				   
				   if(countType3!=0){					   
					   subtotalType3 = (int) Math.pow(3,countType3);					 
				   }else{
					   subtotalType3=1;
				   }
				   
				   if(countType2!=0){					   
					   subtotalType2 = (int) Math.pow(2,countType2);					  
				   }else{
					   subtotalType2=1;
				   }
				   
				   if(mapa.equals("a")) {
					   totalJA =countBet *(subtotalType2*subtotalType3);
					   if(playList.containsKey("id_15")) {
						   g200a=1;
						 }					  
				   }
				   if(mapa.equals("b")) {
					   totalJB =countBet *(subtotalType2*subtotalType3);
					   if(playList.containsKey("id_15")) {
						   g200b=1;
						 }
					  
				   }
				   if(mapa.equals("c")) {
					   totalJC =countBet *(subtotalType2*subtotalType3);
					   if(playList.containsKey("id_15")) {
						   g200c=1;
						 }
					  
				   }
				   if(mapa.equals("d")) {
					   totalJD =countBet *(subtotalType2*subtotalType3);
					   if(playList.containsKey("id_15")) {
						   g200d=1;
						 }
					  
				   }
				   /**
				    * 
				    game={
				    b={id_1=[V], id_2=[L], id_3=[E], id_4=[L], id_5=[V], id_6=[V], id_7=[E], id_8=[L], id_9=[E], id_10=[L], id_11=[L], id_12=[E], id_13=[E], id_14=[E]}, 
				    c={id_1=[L], id_2=[E], id_3=[L], id_4=[E], id_5=[V], id_6=[V], id_7=[V], id_8=[L], id_9=[L], id_10=[L], id_11=[V], id_12=[E], id_13=[L], id_14=[L]}, 
				    a={id_1=[E], id_2=[E], id_3=[E], id_4=[V], id_5=[V], id_6=[L], id_7=[E], id_8=[E], id_9=[E], id_10=[V], id_11=[E], id_12=[L], id_13=[E], id_14=[E]}}
				    * 
				    * 
				    */
				   //total +=countBet *(subtotalType2*subtotalType3);				   
				   gameGanagolBoleto.put(mapa, playList); 
				   
				   session.setAttribute("lastJugada", playList);
				   playList=new LinkedHashMap();
				   	  
		    	}
				}
				
				total=totalJA+totalJB+totalJC+totalJD;
				int ganagolTotal=totalJA*g200a +totalJB*g200b+totalJC*g200c+totalJD*g200d;
				
				if(ganagolTotal == 0) {
					   g200 = "";
				}else{
					   g200 = "+" +ganagolTotal + "G200"; 					   
				}
				
				clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
				GanagolSale ganagolSale = beanGanagolBetBo.findGanagolBetData(clientId);
			   	
		    	String algorithm = ganagolSale.getAlgorithm();
			    Double simpleBetPrice = ganagolSale.getSimpleBetPrice();
			    int bets = ganagolSale.getBets()==null?0:ganagolSale.getBets().intValue();
			    int pay = ganagolSale.getPay()==null?0:ganagolSale.getPay().intValue();
			    Double cost = ganagolSale.getCost();
			    int draw = ganagolSale.getDraws()==null?0:ganagolSale.getDraws().intValue();
			    int jugadasGratis=ganagolSale.getBalanceQuantityGame()==null?0:ganagolSale.getBalanceQuantityGame().intValue();
			    Double costoTotalBet=0.00;
			    if (algorithm==null) algorithm="";
			    
	            if (algorithm.equals("BETS")) {
	                costoTotalBet = Utils.callTransformByBets(total, 1, simpleBetPrice, bets, pay);
	            } else {
	                if (algorithm.equals("COST")) { 
	                    costoTotalBet = callTransformByCostGanagol(total + ganagolTotal*0.5, 1, simpleBetPrice, bets, cost);
	                } else {
	                    if (algorithm.equals("DRAW")) { 
	                        costoTotalBet = Utils.callTransformByDraws(total, 1, simpleBetPrice, draw, pay);
	                    } else {
	                    	if (algorithm.equals("DESC")) {
	                            costoTotalBet = Utils.callTransformDESC(total, 1, simpleBetPrice, pay, cost)[0];
	                        } else {
	                        	if (algorithm.startsWith("ESC")) {
		                            costoTotalBet = Utils.callTransformESC(algorithm, total, 1, simpleBetPrice)[0];
		                        } else {
		                        	costoTotalBet = total * ganagolSale.getSimpleBetPrice() + ganagolTotal*1.0;
		                        }
	                        }
	                    }
	                }
	            } 

			    request.setAttribute("ganagolProcedureBetData",ganagolSale);
			    gameGanagolBoleto = new TreeMap(gameGanagolBoleto);
		    	session.setAttribute("gameGanagolBoleto",gameGanagolBoleto);
		    	IntralotUtils.carItemUpdate(session);
		    	objectModelMap.put("costoTotalMonto",costoTotalBet.intValue());
		    	objectModelMap.put("total",intralotUtils.formatCurrency(costoTotalBet));	
		    	objectModelMap.put("numberPlay",total);
		    	objectModelMap.put("ganagolTotal",ganagolTotal);
		    	objectModelMap.put("numberGolazo200",g200);
		    	session.setAttribute("numberPlayGanagol",total);
		    	session.setAttribute("totalGanagol",costoTotalBet);
		    	objectModelMap.put("precioJugada",intralotUtils.formatCurrency(ganagolSale.getSimpleBetPrice()));
		    	objectModelMap.put("simpleBetPrice",simpleBetPrice);
		    	objectModelMap.put("recorre_cadena",recorre_cadena);
		    	objectModelMap.put("estado",estado);
		    	objectModelMap.put("costoTotalBet",costoTotalBet);
		    	objectModelMap.put("jugadasGratis",jugadasGratis);
		    	objectModelMap.put("yes","yes");
		    	objectModelMap.put("no","no");
		    	
		    	if(total>288){
		    		objectModelMap.put("alertNumberPlay","El numero de jugadas excede lo permitido !");
		    	}
		    	
		    	//start tagging operation
                String operation=session.getAttribute("operation").toString();
                Map <String, Double> precio_detalle_gd= new HashMap<String, Double>();
                if(operation.equals("add")) {
                	if(gameGanagolBoleto.size()==1) {	                		
                		precio_detalle_gd.put("previusPrice", costoTotalBet);
                		objectModelMap.put("lastPrice", costoTotalBet);
                	}else {
                		precio_detalle_gd=(Map)session.getAttribute("precio_detalle_gd");	                		
                		objectModelMap.put("lastPrice", costoTotalBet-precio_detalle_gd.get("previusPrice"));
                		precio_detalle_gd.put("previusPrice", costoTotalBet);
                	}
                	
                	session.setAttribute("precio_detalle_gd",precio_detalle_gd);
                }
                if(operation.equals("delete")) {
                	precio_detalle_gd=(Map)session.getAttribute("precio_detalle_gd");	                	
                	objectModelMap.put("priceJuegoDelete", precio_detalle_gd.get("previusPrice")-costoTotalBet);
                	
                	precio_detalle_gd.put("previusPrice", costoTotalBet);               		
            		session.setAttribute("precio_detalle_gd",precio_detalle_gd);
                }
                objectModelMap.put("operation", operation);	                
                session.setAttribute("operation","default");
                //end tagging operation
                
		    	LoggerApi.Log.info("game/ganagol/interface-shoppingcart on");	    	
		    	return new ModelAndView("game/ganagol/interface-shoppingcart");
				
		} catch (Exception e) {
			LoggerApi.severe(e);
			GanagolSale ganagolSale = beanGanagolBetBo.findGanagolBetData(clientId);
			request.setAttribute("ganagolProcedureBetData",ganagolSale);
			return new ModelAndView("game/ganagol/interface-shoppingcart");
		}
	
	}
	
	 	@SuppressWarnings("rawtypes")
		@RequestMapping("/game_ganagol_delete_bet")	
	public ModelAndView deleteBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			LoggerApi.Log.info("Ingresar al action: GanagolBetController.");
			LoggerApi.Log.info("Ingresar al metodo: deleteBet.");
			
			HttpSession session = request.getSession();		
			
			Map game=(Map) session.getAttribute("gameGanagolBoleto");
			
		   if(MapUtils.isNotEmpty(game) && request.getParameter("id")!=null && !request.getParameter("id").toString().trim().equals("") && MapUtils.isNotEmpty((Map) game.get(request.getParameter("id")))){		   
			   game.remove(request.getParameter("id"));
			   session.setAttribute("gameGanagolBoleto",game);
			   IntralotUtils.carItemUpdate(session);
		   }
		   
		   session.setAttribute("playGanagolList",null);
		   session.removeAttribute("playGanagolList");
		   		
		   session.setAttribute("operation", "delete");
		   		
		   return new ModelAndView("redirect:game_ganagol_show_shoppingcart.html");
			
		} catch (Exception e) {
			
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_ganagol_show_shoppingcart.html");
		}
	
    }
	
		@SuppressWarnings({ "rawtypes", "static-access" })
		@RequestMapping("/game_ganagol_play_bet")	
		public ModelAndView playBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
			
			LoggerApi.Log.info("");
					
			HttpSession session = request.getSession();
			
			try {
				
				int numbersConsecutive = 0;
				
				Map map=(Map) session.getAttribute("gameGanagolBoleto");
				
				if(MapUtils.isNotEmpty(map)){
					
					GroupAPI[] group = new GroupAPI[map.size()];
					
					int countGroup=0;
			    	
					if(map.size()>0) {
						for(Iterator it = map.keySet().iterator();it.hasNext();) {
						String mapa = (String)it.next();						
						Map maping =(Map) map.get(mapa);	
						
						String[] numbers = new String[maping.size()];					
				    	Iterator item = maping.keySet().iterator();	
				    	
				    	int count=0;
				    	while(item.hasNext()){
							String key = (String)item.next();						
							
							List objectList =(List) maping.get(key);
								
							String number = StringUtils.EMPTY;												
							
							for (Object itm : objectList) {
								number +=(String) itm;								
							}														
							numbers[count]=number;
							count++;
				    	}								
										
				  	  group[countGroup] = new GroupAPI();
				      group[countGroup].setTotoBet(Game.GANAGOL, Group.NORMAL, numbers);
				      countGroup++;
				    				      						    	
					}  	
				}
				AccountController accountController = new AccountController();
				Client client = accountController.getClientByClientId((String) session.getAttribute("clientId"));
				
				Game game = new Game();
				game.setGame(Game.GANAGOL);
																
				DateAPI d = new DateAPI();
				WEBMessage web = new WEBMessage();
				web.setClient(client);
				web.setIp(request.getRemoteAddr());
				web.setGame(game);
				web.setGroup(group);
				web.setMessageId("W" + d.getTimeLong() + Game.GANAGOL);
				web.setCarrier("MOBILE");
				
				int priceSale =(Integer) session.getAttribute("totalGanagol");
				ClientTicket ct = new ClientTicket();
				ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
				
				String messageResult=StringUtils.EMPTY;	
				
				if(ct.getMessage() != null) messageResult = ct.getMessage();				
				
				LoggerApi.Log.info("/game_ganagol_play_bet messageResult="+messageResult);
				if(messageResult.equals("OK")) {					
					session.removeAttribute("totalGanagol");
					session.removeAttribute("gameGanagolBoleto");
					session.removeAttribute("playGanagolList");
					IntralotUtils.carItemUpdate(session);
					session.setAttribute("alertPlay","Jugada exitosa !");
					return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=ok");
				
				} else if(StringUtils.contains(messageResult,"autoexclusión")) {
					session.setAttribute("alertPlay","Limite autoexclusion activado");
					return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=error");
				} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
					session.setAttribute("alertPlay","No se ha encontrado el registro del cliente");
					return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=error");
				} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
					session.setAttribute("alertPlay","No cuenta con saldo disponible para realizar este proceso");	
					return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=error");
				} else {		
					session.setAttribute("alertPlay","Ocurrio un error intente nuevamente  ");		
					return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=error");
				}
				}		
				return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=error");
				
			} catch (Exception e) {
				session.setAttribute("alertPlay","Ocurrio un error intente nuevamente ");
				LoggerApi.severe(e);
				return new ModelAndView("redirect:client_play_show_information.html?game=ganagol&status=error");
			}		
	 	}
		
		
		public static Double callTransformByCostGanagol(double p_sum_total_bet, long p_number_consecutive, double p_data_value_bet, int p_bets, double p_cost) {
	        double var_total_cost = 0;
	        double var_sum_total_bet_consecutive = 0;
	        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
	        var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets * p_data_value_bet - p_cost)));
	        return var_total_cost;
	    }
	
		@SuppressWarnings({ "rawtypes", "static-access" })
		@RequestMapping("/game_ganagol_play_bet_result")	
		public ModelAndView playBetResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
			
			LoggerApi.Log.info("");
					
			HttpSession session = request.getSession();
			GanagolSale ganagolSale = new GanagolSale();
			try {
				//if(session.getAttribute("welcomeBonusStatus")!=null && session.getAttribute("welcomeBonusStatus").toString().trim().equals("Reciente")) session.setAttribute("welcomeBonusMessagePor", "<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+session.getAttribute("welcomeBonusPercentaje").toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
		        //else session.setAttribute("welcomeBonusMessagePor", "");
				int numbersConsecutive = 0;
				
				Map map=(Map) session.getAttribute("gameGanagolBoleto");
				
				if(MapUtils.isNotEmpty(map)){
					
					GroupAPI[] group = new GroupAPI[map.size()];
					
					int countGroup=0;
			    	
					String numResJugadaA="";String numResJugadaB="";String numResJugadaC="";String numResJugadaD="";
					String addon= "";
					boolean flagAddon=false;
					int columns = 0;
					if(map.size()>0) {						
						for(Iterator it = map.keySet().iterator();it.hasNext();) {
						String mapa = (String)it.next();						
						Map maping =(Map) map.get(mapa);	
						
						String[] numbers = new String[maping.size()];					
				    	Iterator item = maping.keySet().iterator();	
				    	
				    	int count=0;
				    	String resultados="";
				    	
				    	while(item.hasNext()){
							String key = (String)item.next();						
							
							List objectList =(List) maping.get(key);
								
							String number = StringUtils.EMPTY;												
							
							for (Object itm : objectList) {
								number +=(String) itm;								
							}
							
							numbers[count]=number;
							count++;
							resultados=resultados+number;
							
				    	}
				    	
				    	String[] numbersFinal = {};
				    	
				    	if(maping.size()==14) {
				    		 numbersFinal = new String[maping.size()];
				    	}else {
				    	     numbersFinal = new String[maping.size()-1];
				    	}
				    	
				    	
						for(int i=0; i<14;i++) {
				    		numbersFinal[i]=numbers[i];
				    	}
						
						String resultadosAux = "";						
						resultadosAux = resultados.replace("L", "");
						resultadosAux = resultadosAux.replace("E", "");
						resultadosAux = resultadosAux.replace("V", "");
						resultadosAux = resultadosAux.replace("-", "");
				    	
						
				    	if(resultados.length()>14) {
				    		String addAux = resultadosAux;
				    		if(addAux.equals("08")) {
				    			addAux = "8";
				    		}
				    		if(addAux.equals("4446")) {
				    			addAux = "4445";
				    		}
				    		if(addAux.equals("47a más")) {
				    			addAux = "47";
				    		}
				    		addon = addAux;
				    	}else {
				    		addon="";
				    		
				    	}

				    	if (addon!=null) {
				    		if (addon.equals("")) {
				    			;
				    		} else {
					    		flagAddon=true;
				    		}
				    	}
			    		
				    	resultados = resultados.substring(1, 14);										
				    	if(mapa.equals("a")) {
							numResJugadaA=resultados.length()+"";
						}
						else if(mapa.equals("b")) {
							numResJugadaB=resultados.length()+"";
						}
						else if(mapa.equals("c")) {
							numResJugadaC=resultados.length()+"";
						}
						else if(mapa.equals("d")) {
							numResJugadaD=resultados.length()+"";
						}
										
				  	  group[countGroup] = new GroupAPI();
				      group[countGroup].setTotoBetNewLotos5(Game.GANAGOL, Group.NORMAL, numbersFinal,addon);
				      columns = (int) (columns + group[countGroup].getColumns());
				      countGroup++;
				    				      						    	
					} 
											
				}
									
				AccountController accountController = new AccountController();
				Client client = accountController.getClientByClientId((String) session.getAttribute("clientId"));
				
				Game game = new Game();
				game.setGame(Game.GANAGOL);
				String zip="";
				if(!flagAddon) {
					zip=request.getRemoteAddr().toString();
				}else {
					zip = request.getRemoteAddr().toString() +"[1]V[2]"+game.getGameNumber()+"[3]"+columns;	
				}
				
				
				DateAPI d = new DateAPI();
				WEBMessage web = new WEBMessage();
				web.setClient(client);
				web.setIp(zip);
				web.setGame(game);
				web.setGroup(group);
				web.setMessageId("W" + d.getTimeLong() + Game.GANAGOL);
				web.setCarrier("MOBILE");
				
				double priceSale =(Double) session.getAttribute("totalGanagol");
				int numberPlay=(Integer) session.getAttribute("numberPlayGanagol");
				ClientTicket ct = new ClientTicket();
				ganagolSale = beanGanagolBetBo.findGanagolBetData(Integer.parseInt(client.getClientId()));
				session.setAttribute("jugadasGratis", ganagolSale.getBalanceQuantityGame());
				
				ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);				
				ganagolSale = beanGanagolBetBo.findGanagolBetData(Integer.parseInt(client.getClientId()));
				String messageResult=StringUtils.EMPTY;	
				
				if(ct.getMessage() != null) messageResult = ct.getMessage();				
				
				LoggerApi.Log.info("/game_ganagol_play_bet_result messageResult="+messageResult);
				if(messageResult.equals("OK")) {					
					session.removeAttribute("totalGanagol");
					session.removeAttribute("gameGanagolBoleto");
					session.removeAttribute("playGanagolList");
					IntralotUtils.carItemUpdate(session);
					
					objectModelMap.put("alertPlay","Jugada exitosa !");
					objectModelMap.put("game","ganagol");
					objectModelMap.put("status","ok");
					objectModelMap.put("newamount",intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
					session.setAttribute("saldo", intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
					objectModelMap.put("bonusOther",ganagolSale.getOtherQuantity());
					//objectModelMap.put("bonusOther",intralotUtils.formatCurrency(Double.parseDouble(ganagolSale.getOtherAmount())));
					session.setAttribute("bonoOtro", ganagolSale.getOtherQuantity());
					
					//start tagging parameters
					objectModelMap.put("ticketId", ct.getTicketId());
					objectModelMap.put("importeTotal", priceSale);
					objectModelMap.put("jugadasActuales", numberPlay);
					objectModelMap.put("consecu", numbersConsecutive);
					objectModelMap.put("numResJugadaA", numResJugadaA);
					objectModelMap.put("numResJugadaB", numResJugadaB);
					objectModelMap.put("numResJugadaC", numResJugadaC);
					objectModelMap.put("numResJugadaD", numResJugadaD);
					
					//tagging MxN
					objectModelMap.put("formatPricePerPlay2",ganagolSale.getSimpleBetPrice());
					objectModelMap.put("discountPayment",priceSale);
					objectModelMap.put("promotionMessage",ganagolSale.getPromotionMessage());
					
					objectModelMap.put("priceType", ganagolSale.getPriceType());
					objectModelMap.put("priceMessage", ganagolSale.getPriceMessage());
					
					return new ModelAndView("game/ganagol/interface-result_game");
				
				} else if(StringUtils.contains(messageResult,"autoexclusión")) {
					objectModelMap.put("alertPlay","Limite autoexclusion activado");
					objectModelMap.put("game","ganagol");
					objectModelMap.put("status","error");
					return new ModelAndView("game/ganagol/interface-result_game");
				} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
					
					objectModelMap.put("alertPlay","No se ha encontrado el registro del cliente");
					objectModelMap.put("game","ganagol");
					objectModelMap.put("status","error");
					return new ModelAndView("game/ganagol/interface-result_game");
				} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
					
					objectModelMap.put("alertPlay","No cuenta con saldo disponible para realizar este proceso");
					objectModelMap.put("game","ganagol");
					objectModelMap.put("status","saldo");
					return new ModelAndView("game/ganagol/interface-result_game");
				} else {		
					
					objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente  ");
					objectModelMap.put("game","ganagol");
					objectModelMap.put("status","error");
					return new ModelAndView("game/ganagol/interface-result_game");
				}
				}		
				objectModelMap.put("game","ganagol");
				objectModelMap.put("status","error");
				objectModelMap.put("alertPlay", "Ocurrio un error intente nuevamente");
				return new ModelAndView("game/ganagol/interface-result_game");
				
			} catch (Exception e) {
				
				objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente ");
				LoggerApi.severe(e);
				objectModelMap.put("game","ganagol");
				objectModelMap.put("status","error");
				return new ModelAndView("game/ganagol/interface-result_game");
	
			}finally{
			}			
	 	}
}
