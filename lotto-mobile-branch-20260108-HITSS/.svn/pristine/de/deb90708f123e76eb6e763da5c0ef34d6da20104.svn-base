package pe.com.intralot.loto.layer.view.game.tinkamegabol;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.layer.controller.game.tinkamegabol.bo.TinkamegabolBetBo;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.ClientTicket;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.model.Group;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;


@Controller
public class TinkamegabolBetController {

	//static final Log logger = LogFactory.getLog(TinkamegabolBetController.class);    

	@Autowired
	private TinkamegabolBetBo beanTinkamegabolBetBo;
	
	@Autowired
	private IntralotUtils intralotUtils;
	
	 
	@RequestMapping("/game_tinkamegabol_show_menu")	
	public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {		   
			LoggerApi.Log.info("");
			
			Draw draw = beanTinkamegabolBetBo.getDrawsTinkaMegabol01();
			if(draw!=null){
			draw.setResult(draw.getResult().replace(" ", " - "));
			objectModelMap.put("headerResult",draw);
			}
			
			draw=beanTinkamegabolBetBo.getDrawsTinkaMegabol02();
			if(draw!=null){
				objectModelMap.put("pozoMillonario",intralotUtils.formatCurrency2(draw.getJackpot()));
				objectModelMap.put("megaPozo",intralotUtils.formatCurrency2(draw.getGross11()));	
			}
			
			if(draw!=null){
			draw=beanTinkamegabolBetBo.getDataCloseDateGame();
			objectModelMap.put("closeDrawId", draw.getDrawPk().getDrawId());
			objectModelMap.put("closeDraw", draw.getCloseHour()+":"+draw.getCloseMinute());			
			objectModelMap.put("closeDate",draw.getCloseDate());
			}
			return new ModelAndView("game/tinkamegabol/interface-home");	
			
		} catch (NullPointerException e) {
			return new ModelAndView("game/tinkamegabol/interface-home");
		}  catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/tinkamegabol/interface-home");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: showMenu. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolBetController.");
			
		}
		
						
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/game_tinkamegabol_show_shoppingcart")	
	public ModelAndView showShoppingCart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
	    
		try {
					
				LoggerApi.Log.info("");
					
				HttpSession session = request.getSession();		
						
				Map consecutiveMap=(Map) session.getAttribute("consecutiveTinkaValue");
				Long consecutive=Long.valueOf(1);
				
				if(MapUtils.isNotEmpty(consecutiveMap)){
					consecutive=Long.valueOf(((Map) session.getAttribute("consecutiveTinkaValue")).get("NUM_DRAW").toString());	
				}
				
				Map map=(Map) session.getAttribute("gameTinkaBoleto");
			
				 
				int totalBet=0;
				String cad_mb="";
				String cad_tk="";
				String ind_tk="";
				String ind_mb="";
				 String me="";
		    	/*Iterator it = map.keySet().iterator();					
		    	while(it.hasNext()){*/
			 if(map.size()>0) {
					for(Iterator it = map.keySet().iterator();it.hasNext();) {
					String mapa = (String)it.next();						
					Map maping =(Map) map.get(mapa);	
					
					int countPlay = 0;				
					int mgBolilla=0;	
					
					
					switch (((List)((List) maping.get("tinka"))).size()) {
					case 6:	 countPlay ++;  break;
					case 7:	 countPlay +=7; break;
					case 8:  countPlay +=28;break;					
					case 9:	 countPlay +=84;	break;
					case 10: countPlay +=210;	break;	
					case 11: countPlay +=462;	break;	
					case 12: countPlay +=924;	break;
					case 13: countPlay +=1716;	break;
					case 14: countPlay +=3003;	break;
					case 15: countPlay +=5005;	break;
					default: countPlay +=0;	break;
					}
					
					if(CollectionUtils.isNotEmpty((List) maping.get("megabolilla")) && CollectionUtils.isNotEmpty((List) maping.get("tinka"))){
						mgBolilla=mgBolilla+((List) maping.get("megabolilla")).size();	
						cad_mb = cad_mb+((String) maping.get("megabolilla_cad"));
						cad_tk = cad_tk+((String) maping.get("tinka_cad"));
					   	
						    String sTexto = cad_mb;
				            int car = 0;
				            String cadenita = "", cade = "";
				            int inicial = 0, siguiente = 1;
				            String indicador = "yes";

				            for (int x = 0; x < sTexto.length(); x++) {

				               cadenita = sTexto.substring(inicial, siguiente);
				            if (!cadenita.equals("-") && !cadenita.equals("")) {
				                cade += cadenita;
				                car = Integer.parseInt(cade);



				            } else {
				                 if (car < 1 ) {
				                    indicador = "no";
				                }
				                ////System.out.println("cadena: " + car);
				                cade = "";

				            }

				                inicial++;
				                siguiente++;
				            }
							ind_mb=indicador;
							
							String sTexto_1 = cad_tk;
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
				                 if (car_1 < 6) {
				                	 indicador_1 = "no";
				                }
				                //System.out.println("cadena: " + car_1);
				                cade_1 = "";

				            }

				            inicial_1++;
				            siguiente_1++;
				            }
				        
				            ind_tk=indicador_1;
				             me="pasanado 1";	
							
					}
					
					if(CollectionUtils.isEmpty((List) maping.get("megabolilla")) && CollectionUtils.isEmpty((List) maping.get("tinka"))){
						mgBolilla=mgBolilla+((List) maping.get("megabolilla")).size();	
						cad_mb = cad_mb+"0-";
						cad_tk = cad_tk+"0-";
					  
						    String sTexto = cad_mb;
				            int car = 0;
				            String cadenita = "", cade = "";
				            int inicial = 0, siguiente = 1;
				            String indicador = "yes";

				            String sTexto_1 = cad_tk;
				            int car_1 = 0;
				            String cadenita_1 = "", cade_1 = "";
				            int inicial_1 = 0, siguiente_1 = 1;
				            String indicador_1 = "yes";
				            
				            for (int x = 0; x < sTexto.length(); x++) {

				               cadenita = sTexto.substring(inicial, siguiente);
				            if (!cadenita.equals("-") && !cadenita.equals("")) {
				                cade += cadenita;
				                car = Integer.parseInt(cade);



				            } else {
				                 if (car < 1 ) {
				                    indicador = "no";
				                }
				                //System.out.println("cadena: " + car);
				                cade = "";

				            }

				                inicial++;
				                siguiente++;
				            }
				            
				            for (int x = 0; x < sTexto_1.length(); x++) {

				            	cadenita_1 = sTexto_1.substring(inicial_1, siguiente_1);
				            if (!cadenita_1.equals("-") && !cadenita_1.equals("")) {
				            	cade_1 += cadenita_1;
				            	car_1 = Integer.parseInt(cade_1);



				            } else {
				                 if (car_1 < 6 ) {
				                	 indicador_1 = "no";
				                }
				                //System.out.println("cadena: " + car_1);
				                cade_1 = "";

				            }

				            inicial_1++;
				            siguiente_1++;
				            }
				            
				            
				            
							ind_mb=indicador;
						 me="pasanado 2";	
				            ind_tk=indicador_1;
							
							
					}
					
					
					if(CollectionUtils.isNotEmpty((List) maping.get("megabolilla")) && CollectionUtils.isEmpty((List) maping.get("tinka"))){
						mgBolilla=mgBolilla+((List) maping.get("megabolilla")).size();	
						cad_mb = cad_mb+((String) maping.get("megabolilla_cad"));
						cad_tk = cad_tk+"0-";
					  
						    String sTexto = cad_mb;
				            int car = 0;
				            String cadenita = "", cade = "";
				            int inicial = 0, siguiente = 1;
				            String indicador = "yes";

				            String sTexto_1 = cad_tk;
				            int car_1 = 0;
				            String cadenita_1 = "", cade_1 = "";
				            int inicial_1 = 0, siguiente_1 = 1;
				            String indicador_1 = "yes";
				            
				            for (int x = 0; x < sTexto.length(); x++) {

				               cadenita = sTexto.substring(inicial, siguiente);
				            if (!cadenita.equals("-") && !cadenita.equals("")) {
				                cade += cadenita;
				                car = Integer.parseInt(cade);

				            } else {
				                 if (car < 1 ) {
				                    indicador = "no";
				                }
				                //System.out.println("cadena: " + car);
				                cade = "";

				            }

				                inicial++;
				                siguiente++;
				            }
				            
				            for (int x = 0; x < sTexto_1.length(); x++) {

				            	cadenita_1 = sTexto_1.substring(inicial_1, siguiente_1);
				            if (!cadenita_1.equals("-") && !cadenita_1.equals("")) {
				            	cade_1 += cadenita_1;
				            	car_1 = Integer.parseInt(cade_1);



				            } else {
				                 if (car_1 < 6 ) {
				                	 indicador_1 = "no";
				                }
				                //System.out.println("cadena: " + car_1);
				                cade_1 = "";

				            }

				            inicial_1++;
				            siguiente_1++;
				            }
				            
				            
				            
							ind_mb=indicador;
						 me="pasanado 3";	
				            ind_tk=indicador_1;
							
							
					}
					
					if(CollectionUtils.isEmpty((List) maping.get("megabolilla")) && CollectionUtils.isNotEmpty((List) maping.get("tinka"))){
						mgBolilla=mgBolilla+((List) maping.get("megabolilla")).size();	
						cad_mb = cad_mb+"0-";
						cad_tk = cad_tk+((String) maping.get("tinka_cad"));
					  
						    String sTexto = cad_mb;
				            int car = 0;
				            String cadenita = "", cade = "";
				            int inicial = 0, siguiente = 1;
				            String indicador = "yes";

				            String sTexto_1 = cad_tk;
				            int car_1 = 0;
				            String cadenita_1 = "", cade_1 = "";
				            int inicial_1 = 0, siguiente_1 = 1;
				            String indicador_1 = "yes";
				            
				            for (int x = 0; x < sTexto.length(); x++) {

				               cadenita = sTexto.substring(inicial, siguiente);
				            if (!cadenita.equals("-") && !cadenita.equals("")) {
				                cade += cadenita;
				                car = Integer.parseInt(cade);



				            } else {
				                 if (car < 1 ) {
				                    indicador = "no";
				                }
				                //System.out.println("cadena: " + car);
				                cade = "";

				            }

				                inicial++;
				                siguiente++;
				            }
				            
				            for (int x = 0; x < sTexto_1.length(); x++) {

				            	cadenita_1 = sTexto_1.substring(inicial_1, siguiente_1);
				            if (!cadenita_1.equals("-") && !cadenita_1.equals("")) {
				            	cade_1 += cadenita_1;
				            	car_1 = Integer.parseInt(cade_1);

				            } else {
				                 if (car_1 < 6 ) {
				                	 indicador_1 = "no";
				                }
				                //System.out.println("cadena: " + car_1);
				                cade_1 = "";

				            }

				            inicial_1++;
				            siguiente_1++;
				            }
				            
							ind_mb=indicador;	
				            ind_tk=indicador_1;
							
					}
					
					totalBet +=countPlay*mgBolilla;
					
				}
			 }
			   	if(totalBet>1386){
		    		objectModelMap.put("alertNumberPlay","El numero de jugadas excede lo permitido (1386) !");
		    	}	
				 
		    	session.setAttribute("totalTinkaSession",Double.valueOf(4.0 *consecutive*totalBet));
				objectModelMap.put("totalTinka",intralotUtils.formatCurrency((Double) session.getAttribute("totalTinkaSession")));
				objectModelMap.put("totalBet",totalBet);
				objectModelMap.put("tinks",cad_tk);
				objectModelMap.put("megs",cad_mb);
				objectModelMap.put("negacion","no");
				objectModelMap.put("afirmacion","yes");
				objectModelMap.put("ind_tk",ind_tk);
				objectModelMap.put("ind_mb",ind_mb);
				objectModelMap.put("mensaje",me);
				
				
				
			return new ModelAndView("game/tinkamegabol/interface-shoppingcart");
	
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/tinkamegabol/interface-shoppingcart");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: showShoppingCart. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolBetController.");
			
		}
	
	}
	
	@RequestMapping("/game_tinkamegabol_show_bet")	
	public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception { 
		
		HttpSession session = request.getSession();		
		
		try {
			LoggerApi.Log.info("");
			
			String play = request.getParameter("play");
			session.setAttribute("typePlayTinka","jugada_".concat(play));
			objectModelMap.put("typePlay",play.toUpperCase());
						
			if(StringUtils.equals((String)session.getAttribute("mobile_pointing"),Constantes.MOBILE_TOUCHSCREEN)){
				return new ModelAndView("game/tinkamegabol/interface-bet-touchscreen");	
			}else{
				return new ModelAndView("game/tinkamegabol/interface-bet-clickwheel");
			}
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			
			if(StringUtils.equals((String)session.getAttribute("mobile_pointing"),Constantes.MOBILE_TOUCHSCREEN)){
				return new ModelAndView("game/tinkamegabol/interface-bet-touchscreen");	
			}else{
				return new ModelAndView("game/tinkamegabol/interface-bet-clickwheel");
			}
			
		}finally{
			//LoggerApi.Log.info("Salir al metodo: showBet. Estado : Satisfactorio");
			LoggerApi.Log.info("Ingresar al action: TinkaMegaBolBetController.");
			
		}
						
	}			
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/game_tinkamegabol_add_bet")	
	public ModelAndView addBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			LoggerApi.Log.info("");
			
			Map game=new HashMap();
			
			Map playList=new HashMap();
			List playTinkaList =new ArrayList();
			List playMegaBolillaList=new ArrayList();	
			String cad_t="",cad_ult_t="";
			String cad_m="",cad_ult_m="";
			
			if(!ObjectUtils.isEmpty(request.getParameterValues("tk"))){
			for (Object object : (request.getParameterValues("tk"))) {
				playTinkaList.add(object.toString());
					
			} 
			}
			
			if(!ObjectUtils.isEmpty(request.getParameterValues("mg"))){
			for (Object object : (request.getParameterValues("mg"))) {
				playMegaBolillaList.add(object.toString());
			} 
			}
			
			if(CollectionUtils.isNotEmpty(playTinkaList)){
				playList.put("tinka",playTinkaList);
				cad_t=String.valueOf(playTinkaList.size());
				cad_ult_t=cad_ult_t+cad_t+"-";
				playList.put("tinka_cad",cad_ult_t);
				
			}
			
			if(CollectionUtils.isNotEmpty(playMegaBolillaList)){
				playList.put("megabolilla",playMegaBolillaList);
				cad_m=String.valueOf(playMegaBolillaList.size());
				cad_ult_m=cad_ult_m+cad_m+"-";
				playList.put("megabolilla_cad",cad_ult_m);
				
			}
		
			if(CollectionUtils.isEmpty(playTinkaList)){
				playList.put("tinka",playTinkaList);
				cad_t="0";
				cad_ult_t=cad_ult_t+cad_t+"-";
				playList.put("tinka_cad",cad_ult_t);
				
				
			}
			
			if(CollectionUtils.isEmpty(playMegaBolillaList)){
				playList.put("megabolilla",playMegaBolillaList);
				cad_m=String.valueOf(playMegaBolillaList.size());
			cad_ult_m=cad_ult_m+cad_m+"-";
				playList.put("megabolilla_cad",cad_ult_m);
				
			}
				
			
			HttpSession session = request.getSession();		
			 
			if(MapUtils.isNotEmpty(playList)){
				
				/*if(MapUtils.isEmpty((Map) session.getAttribute("gameTinkaBoleto"))){
					game.put((String) session.getAttribute("typePlayTinka"),playList);
		            session.setAttribute("gameTinkaBoleto", game);
		            
				}else{
					game=(Map) session.getAttribute("gameTinkaBoleto");
					game.put((String) session.getAttribute("typePlayTinka"),playList);
					session.setAttribute("gameTinkaBoleto", game);
				   
				}*/
				if(MapUtils.isNotEmpty((Map) session.getAttribute("gameTinkaBoleto"))) game = (Map)session.getAttribute("gameTinkaBoleto");
				game.put((String) session.getAttribute("typePlayTinka"),playList);
				session.setAttribute("gameTinkaBoleto", new TreeMap(game));
				session.getAttribute(null);
				session.removeAttribute("typePlayTinka");
				
			}
			return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: addBet. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
			
		}
		
     }
	
	@SuppressWarnings({"rawtypes" })
	@RequestMapping("/game_tinkamegabol_delete_bet")	
	public ModelAndView deleteBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			LoggerApi.Log.info("");
			
			HttpSession session = request.getSession();		
			
			Map game=(Map) session.getAttribute("gameTinkaBoleto");
			
		   if(MapUtils.isNotEmpty((Map) game.get(request.getParameter("id")))){		
			   
			   game.remove(request.getParameter("id"));
			   session.setAttribute("gameTinkaBoleto",game);
			   
			   if(MapUtils.isEmpty(game)){
				   session.removeAttribute("consecutiveTinka");
				   session.removeAttribute("consecutiveTinkaValue");
				  
			   }
		   }
		   return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: deleteBet. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
			
		}
	
    }

	@RequestMapping("/game_tinkamegabol_show_consecutive")	
	public ModelAndView showConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
				
		try {
			LoggerApi.Log.info("");
			
			HttpSession session = request.getSession();	
			
			if(ObjectUtils.isEmpty((HashMap[]) session.getAttribute("consecutiveTinkaList"))){
				session.setAttribute("consecutiveTinkaList", beanTinkamegabolBetBo.getNumberConsecutive());
			}
		return new ModelAndView("game/tinkamegabol/interface-consecutive");
			
		} catch (Exception e) {		
			LoggerApi.severe(e);
			return new ModelAndView("game/tinkamegabol/interface-consecutive");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: showConsecutive. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
			
		}
		
	}	
	
	@RequestMapping("/game_tinkamegabol_delete_consecutive")	
	public ModelAndView deleteConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
		
		try {
			LoggerApi.Log.info("");
					
			HttpSession session = request.getSession();				
			session.removeAttribute("consecutiveTinka");
			session.removeAttribute("consecutiveTinkaValue");	
			
			return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: deleteConsecutive. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/game_tinkamegabol_add_consecutive")	
	public ModelAndView addConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			
		LoggerApi.Log.info("Ingresar al action: TinkaMegaBolController.");
		LoggerApi.Log.info("Ingresar al metodo: addConsecutive.");
		String consecutiveParam=request.getParameterValues("consecutive")[0];
		HttpSession session = request.getSession(); 			
		session.setAttribute("consecutiveTinka",consecutiveParam);			
		HashMap[] consecutive=(HashMap[]) session.getAttribute("consecutiveTinkaList");
		
		for (HashMap item : consecutive) {
			
			if(StringUtils.equals(String.valueOf(item.get("NUM_DRAW")),consecutiveParam)){
				session.setAttribute("consecutiveTinkaValue", item);
				break;
			}
		}
		
		//LoggerApi.Log.info("Salir al metodo: addConsecutive. Estado : Satisfactorio");
		//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
		
		return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");	
			
		} catch (Exception e) {		
			//LoggerApi.Log.info("Salir al metodo: addConsecutive. Estado : Erroneo");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
			LoggerApi.severe(e);
		    return new ModelAndView("redirect:game_tinkamegabol_show_shoppingcart.html");	
		}   
		
	}	
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@RequestMapping("/game_tinkamegabol_play_bet")	
	public ModelAndView playBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
			
		HttpSession session = request.getSession();
		
	try {
		LoggerApi.Log.info("");	
		Map map=(Map) session.getAttribute("gameTinkaBoleto");
		
		if(MapUtils.isNotEmpty(map)){
			
	
		Game game = new Game();
		game.setGame(Game.MEGATINKA);
		
		GroupAPI[] group = new GroupAPI[map.size()];
		
		int count=0;
    	/*Iterator it = map.keySet().iterator();					
    	while(it.hasNext()){*/
		if(map.size()>0) {
			for(Iterator it = map.keySet().iterator();it.hasNext();) {
				String mapa = (String)it.next();						
				Map maping =(Map) map.get(mapa);			
						
				List playTinkaList =(List) maping.get("tinka");
				List playMegaBolillaList=(List) maping.get("megabolilla");	
				
				int[] numbers = new int[playTinkaList.size()];
				int[] extra = new int[playMegaBolillaList.size()];	
				
				int tinkaCount=0;
				for (Object item : playTinkaList) {
					numbers[tinkaCount]=Integer.valueOf((String) item);
					tinkaCount++;
				}
				
				int mgBolillaCount=0;
		        for (Object item : playMegaBolillaList) {
		        	extra[mgBolillaCount]=Integer.valueOf((String) item);
		        	mgBolillaCount++;
				}
		        group[count] = new GroupAPI();
		        group[count].setExtraBet(Game.MEGATINKA, Group.NORMAL, numbers, extra);
		        count++;
				    	
			}
		}
    	AccountController accountController = new AccountController();
    	Client client = accountController.getClientByClientId((String) session.getAttribute("clientId"));
				
		
		DateAPI d = new DateAPI();
		WEBMessage web = new WEBMessage();
		web.setClient(client);
		web.setIp(request.getRemoteAddr());
		web.setGame(game);
		web.setGroup(group);
		web.setMessageId("W" + d.getTimeLong() + Game.MEGATINKA);
		web.setCarrier("MOBILE");
		
		String messageResult=StringUtils.EMPTY;	
		
		int numbersConsecutive=1;
		if(MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveTinkaValue"))){
			 numbersConsecutive= Integer.valueOf(((Map) session.getAttribute("consecutiveTinkaValue")).get("NUM_DRAW").toString());	
		}
		
		double priceSale =(Double) session.getAttribute("totalTinkaSession");
		
		ClientTicket ct = new ClientTicket();
		ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
		if(ct.getMessage() != null) messageResult = ct.getMessage();

		LoggerApi.Log.info("/game_tinkamegabol_play_bet messageResult="+messageResult);
		if(messageResult.equals("OK")) {
			session.removeAttribute("consecutiveTinka");
			session.removeAttribute("consecutiveTinkaValue");
			session.removeAttribute("totalTinkaSession");
			session.removeAttribute("gameTinkaBoleto");
			session.setAttribute("alertPlay","Jugada realizada con &eacute;xito!");
			session.setAttribute("alertPlay2","Gracias por tu compra");
			return new ModelAndView("redirect:client_play_show_information.html?game=tinkamegabol&status=ok");
		} else if(StringUtils.equals(messageResult,"CLIENTE NO EXISTE")) {
			session.setAttribute("alertPlay","No se ha encontrado el registro del cliente");
			return new ModelAndView("redirect:client_play_show_information.html?game=tinkamegabol&status=error");
		} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE")) {		
			session.setAttribute("alertPlay","No cuenta con saldo disponible para realizar este proceso");
			return new ModelAndView("redirect:client_play_show_information.html?game=tinkamegabol&status=error");
		} else {		
			session.setAttribute("alertPlay","Ocurrio un error intente nuevamente  ");	
			return new ModelAndView("redirect:client_play_show_information.html?game=tinkamegabol&status=error");
		}		
		
		}
		
		
		return new ModelAndView("redirect:client_play_show_information.html?game=tinkamegabol&status=error");
		
		} catch (Exception e) {
			session.setAttribute("alertPlay","Ocurrio un error intente nuevamente ");
			LoggerApi.severe(e);
			return new ModelAndView("redirect:client_play_show_information.html?game=tinkamegabol&status=error");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: playBet. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaMegaBolController.");
			
		}
	
	}	
	
}



