package pe.com.intralot.loto.layer.view.game.ganadiario;

import java.math.BigInteger;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
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
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.card.setup.MailingForSale;
import pe.com.intralot.loto.layer.controller.client.bo.ParameterBo;
import pe.com.intralot.loto.layer.controller.game.ganadiario.bo.GanadiarioBetBo;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioSale;
import pe.com.intralot.loto.layer.model.pojo.Tinka;
import pe.com.intralot.loto.layer.model.pojo.Ganadiario;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.Utils;
import pe.com.intralot.loto.model.Client;
import pe.com.intralot.loto.model.ClientTicket;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.model.Group;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.sale.card.model.WEBMessage;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;

@Controller
public class GanadiariolBetController {

	//static final Log logger = LogFactory.getLog(GanadiariolBetController.class);    

	@Autowired
	private GanadiarioBetBo beanGanadiarioBetBo;
	
	
	@Autowired
	private IntralotUtils intralotUtils;
	
	@Autowired
	private ParameterBo beanParameterBo;
	
	private boolean evaluateGanadiarioSession(HttpSession session, String typeBoleto) {
		boolean gdBoleto=false;
		
		if(session.getAttribute(typeBoleto)!=null) {
			Ganadiario ganadiarioRegular = (Ganadiario) session.getAttribute(typeBoleto);
			if(ganadiarioRegular.getBoleto()==null) gdBoleto=true;
			else if (ganadiarioRegular.getBoleto().isEmpty()) gdBoleto=true;
		} else gdBoleto=true;
		
		return gdBoleto;
	}
	
	private void generateGanadiario(HttpSession session,GanadiarioSale ganadiarioSale,boolean trigger, String typeBoleto,Integer typeGanadiario) {
		if(trigger) {
			Ganadiario ganadiario =  new Ganadiario(ganadiarioSale, typeGanadiario);
			session.setAttribute(typeBoleto, ganadiario);
		}
	}
	
	private void updateGanadiarioSession(HttpSession session, GanadiarioSale ganadiarioSale) {
		
		boolean gdREG=false,gdS30=false,gdS90=false,gdS180=false,gdS365=false;
		
		gdREG = evaluateGanadiarioSession(session,Constantes.BoletoGanadiario.boletoGanadiarioRegular);
		gdS30 = evaluateGanadiarioSession(session,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30);
		gdS90 = evaluateGanadiarioSession(session,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90);
		gdS180 = evaluateGanadiarioSession(session,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180);
		gdS365 = evaluateGanadiarioSession(session,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365);

		generateGanadiario(session,ganadiarioSale,gdREG,Constantes.BoletoGanadiario.boletoGanadiarioRegular,1);
		generateGanadiario(session,ganadiarioSale,gdS30,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30,30);
		generateGanadiario(session,ganadiarioSale,gdS90,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90,90);
		generateGanadiario(session,ganadiarioSale,gdS180,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180,180);
		generateGanadiario(session,ganadiarioSale,gdS365,Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365,365);

	}
	
	private String getTypeBoleto(String boleto) {
		if(boleto.endsWith("365")) {
			return Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365;
		}
		else if(boleto.endsWith("180")) {
			return Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180;
		}
		else if(boleto.endsWith("90")) {
			return Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90;
		}
		else if(boleto.endsWith("30")) {
			return Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30;
		} else if (boleto.endsWith("a") || boleto.endsWith("b") || boleto.endsWith("c") || boleto.endsWith("d")) {
			return Constantes.BoletoGanadiario.boletoGanadiarioRegular;
		} else {
			return "";
		}
	}
	
	private Integer validarCantidadJugadas(Map<String, List<String>> playList,Map<String, Map<String,List<String>>> game, String typePlayGanadiario) {
		
		Integer totalJugadasNew = 0;
		Integer totalJugadasBoleto = 0;
		
		if(playList!=null) totalJugadasNew = getTotalJugadas(playList);		
		LoggerApi.Log.info("/validarCantidadJugadas typePlayGanadiario="+typePlayGanadiario);
		if(typePlayGanadiario!="") game.remove(typePlayGanadiario);
		LoggerApi.Log.info("/validarCantidadJugadas game="+game);
		
		for (Map.Entry<String, Map<String,List<String>>> jugada : game.entrySet()) {
			Integer totalJugadasOld = 1;
			Integer cantidadBolillas = 0;
			for (Map.Entry<String,List<String>> bet : jugada.getValue().entrySet()) {
				cantidadBolillas += bet.getValue().size();
			}
			LoggerApi.Log.info("/validarCantidadJugadas cantidadBolillas="+cantidadBolillas);
			totalJugadasOld = bin_newton(cantidadBolillas).intValue();
			LoggerApi.Log.info("/validarCantidadJugadas totalJugadasOld="+totalJugadasOld);
			totalJugadasBoleto += totalJugadasOld; 
			LoggerApi.Log.info("/validarCantidadJugadas totalJugadasBoleto="+totalJugadasBoleto);
		}
		LoggerApi.Log.info("/validarCantidadJugadas totalJugadasBoleto+totalJugadasNew="+(totalJugadasBoleto+totalJugadasNew));
		return  totalJugadasBoleto+totalJugadasNew;
	}
	
	private Integer getTotalJugadas(Map<String, List<String>> playList) {
		Integer totalJugadas = 0;
		Integer cantidadBolillas = 0;
		
		for (Map.Entry<String, List<String>> bet : playList.entrySet()) {
			cantidadBolillas += bet.getValue().size();
		}
		LoggerApi.Log.info("/getTotalJugadas cantidadBolillas="+cantidadBolillas);
		totalJugadas = bin_newton(cantidadBolillas).intValue();
		
		return totalJugadas;
	}
	
	private static BigInteger bin_newton(Integer cantidad) {
		BigInteger base = new BigInteger("120");
		if(cantidad<5) return new BigInteger("0");
		return (factorial(cantidad)).divide(((factorial(cantidad-5)).multiply(base)));
	}
	
	private static BigInteger factorial(Integer cantidad) {
		BigInteger biCantidad = new BigInteger(String.valueOf(cantidad));
		
		if (cantidad < 0) return new BigInteger("0"); 
		else if (cantidad > 1) return factorial(cantidad - 1).multiply(biCantidad);
		else return new BigInteger("1");
	}
	
	private Double getCostoTotalRegularBet(Ganadiario ganadiario, Long consecutive) {
		
		Double costoTotalBet=0.00;
		
		Integer totalBet = ganadiario.getJugadasActuales();
		String algorithm = ganadiario.getPromotionAlgorithm();
		Double simpleBetPrice = ganadiario.getRegularPayment();
		int bets = ganadiario.getPromotionBets();
	    int pay = ganadiario.getPromotionPay();
	    Double cost = ganadiario.getPromotionCost();
	    int draw = ganadiario.getPromotionDraws();
	    
	    if (algorithm==null) algorithm="";
		    
         if (algorithm.equals("BETS")) {
             costoTotalBet = Utils.callTransformByBets(totalBet, consecutive, simpleBetPrice, bets, pay);
         } else {
             if (algorithm.equals("COST")) { 
                 costoTotalBet = Utils.callTransformByCost(totalBet, consecutive, simpleBetPrice, bets, cost);
             } else {
                 if (algorithm.equals("DRAW")) { 
                     costoTotalBet = Utils.callTransformByDraws(totalBet, consecutive, simpleBetPrice, draw, pay);
                 } else {
                 	if (algorithm.equals("DESC")) {
                         costoTotalBet = Utils.callTransformDESC(totalBet, consecutive, simpleBetPrice, pay, cost)[0];
                     } else {
                     	if (algorithm.startsWith("ESC")) {
	                            costoTotalBet = Utils.callTransformESC(algorithm, totalBet, consecutive, simpleBetPrice)[0];
	                        } else {
	                            costoTotalBet = ( simpleBetPrice * totalBet ) * consecutive;
	                        }
                     }
                 }
             }
         }  
		
		return costoTotalBet;
	}
	 	 	
	@RequestMapping("/game_ganadiario_show_menu")	
	public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		int clientId = 0;
		GanadiarioSale ganadiarioSale = new GanadiarioSale();
//		String user = "";
    	String rpage = "game/ganadiario/interface-home-preprod";
		try {
			
//		    Draw draw=beanGanadiarioBetBo.getDataCloseDateGame();
//			if(draw==null){draw = new Draw();}
//
//			objectModelMap.put("headerGame",draw);
//			if(draw.getJackpot() == null){draw.setJackpot(0.0);}
//			objectModelMap.put("pozo",intralotUtils.formatCurrency2(draw.getJackpot()));	
//
//			Draw draw2 = beanGanadiarioBetBo.getDrawsGanadiario();
//			
//			if(draw2 != null){
//				draw2.setResult(draw2.getResult().replace(" ", " - "));
//			}
//			objectModelMap.put("headerResult", draw2);
			HttpSession session = request.getSession();
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;			   
			ganadiarioSale = beanGanadiarioBetBo.findGanadiarioBetData(clientId);
			ganadiarioSale = intralotUtils.getdataGD(ganadiarioSale);
			objectModelMap.mergeAttributes(ganadiarioSale.toMap());
			updateGanadiarioSession(session,ganadiarioSale);
			objectModelMap.put("headerResult", ganadiarioSale);
			/*
			if(clientId != 0) {
				Client client = AccountController.getClientByClientId( String.valueOf(clientId) );
				user = client.getUser();
				LoggerApi.Log.info("ganadiario user: "+user);
				if( beanGanadiarioBetBo.isSubscriptionAllowedGoIn(user) ){
					rpage = "game/ganadiario/interface-home";
				}
			}
			*/
			String isGanadiarioSubscription=Constantes.isGanadiarioSubscription;
			request.setAttribute("isGanadiarioSubscription", isGanadiarioSubscription);
			return new ModelAndView("game/ganadiario/interface-home");
			//return new ModelAndView(rpage);
			
		} catch (NullPointerException e) {
			return new ModelAndView(rpage);
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView(rpage);
		} finally{
			LoggerApi.Log.info("game_ganadiario_show_menu");
		}  	
						
	}	
	 
	
	 	@RequestMapping("/game_ganadiario_show_bet")	
	public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception { 
		
	 	LoggerApi.Log.info("-------------- START game_ganadiario_show_bet");
	 	HttpSession session = request.getSession();		
		
		try {
			LoggerApi.Log.info("");
			
			String play = request.getParameter("play");			
			session.setAttribute("typePlayGanadiario",play);
			objectModelMap.put("typePlay",play.toUpperCase());
			
			LoggerApi.Log.info("/game_ganadiario_show_bet play="+play);
			
			String typeboleto=getTypeBoleto(play);
			 
			if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			
			String cart = request.getParameter("cart")!=null?request.getParameter("cart").toString():"none";
			
			Ganadiario ganadiario = null;
			LoggerApi.Log.info("/game_ganadiario_show_bet typeboleto="+typeboleto);
			if(StringUtils.isNotEmpty(typeboleto)) ganadiario = (Ganadiario) session.getAttribute(typeboleto);
			
			session.setAttribute(Constantes.Boleto.typeBoleto, typeboleto);
			 if(ganadiario.getBoleto()!=null && !cart.equals("go")) {
				 if(typeboleto.endsWith("0")|| typeboleto.endsWith("5")) return new ModelAndView("redirect:game_ganadiario_show_shoppingcart_suscripcion.html");
				 else if (typeboleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioRegular)) {
					 session.setAttribute("operation", "haveBoleto");
					 return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");
				 }
			 }
			 
			LoggerApi.Log.info("/game_ganadiario_show_bet ganadiario="+ganadiario.toString());
			
			if(ganadiario!=null)  objectModelMap.mergeAttributes(ganadiario.toMap());
			 String jugada = (ganadiario!=null && ganadiario.getTypeGanadiario()!= null && ganadiario.getTypeGanadiario().equals("REG"))? play : (ganadiario!=null && ganadiario.getDraws()!= null)?ganadiario.getDraws().toString():"";
			 session.setAttribute(Constantes.Boleto.idBoleto,"jugada_".concat(jugada));
			 
			if(ganadiario!=null && ganadiario.getTypeGanadiario().equals("REG")) { 
			
				if(StringUtils.equals((String)session.getAttribute("mobile_pointing"),Constantes.MOBILE_TOUCHSCREEN)){
					return new ModelAndView("game/ganadiario/interface-bet-touchscreen");	
				}else{
					return new ModelAndView("game/ganadiario/interface-bet-clickwheel");
				}
			}else {
				return new ModelAndView("game/ganadiario/interface-suscripcion-type");	
			}
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			
			if(StringUtils.equals((String)session.getAttribute("mobile_pointing"),Constantes.MOBILE_TOUCHSCREEN)){
				return new ModelAndView("game/ganadiario/interface-bet-touchscreen");	
			}else{
				return new ModelAndView("game/ganadiario/interface-bet-clickwheel");
			}
			
		}finally {
			LoggerApi.Log.info("/game_ganadiario_show_bet typeBoleto="+((session!=null && session.getAttribute("typeBoleto")!=null)?session.getAttribute("typeBoleto").toString():"null"));
		    LoggerApi.Log.info("-------------- END game_ganadiario_show_bet"); 
		} 
						
	}
	 	
	 	/**
		 * 
		 * @param request
		 * @param objectModelMap
		 * @return
		 * @throws Exception
		 * <p> En caso la suscripcion sea de tipo choose se utiliza este metodo para redireccionar
		 *  al landing para marcar la jugada </p>
		 */
		@RequestMapping("/game_ganadiario_show_bet_suscripcion")
		public ModelAndView showBetSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			LoggerApi.Log.info("-------------- START game_ganadiario_show_bet_suscripcion");
			HttpSession session = request.getSession();
			
			String boleto = request.getParameter("boleto").toString();
			
			if(request.getParameter("boleto")!=null) {
				boleto = request.getParameter("boleto").toString();
			} else return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			//request.getParameter("boleto").toString();
			if(StringUtils.isEmpty(boleto)) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			
			String typeboleto=getTypeBoleto(boleto);
			
			if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			session.setAttribute("typeBoletoTemp", typeboleto);
			Ganadiario ganadiarioSuscripcion = (Ganadiario) session.getAttribute(typeboleto);
			if(ganadiarioSuscripcion == null) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			ganadiarioSuscripcion.setTypePlay("SUS_IGUAL");

			objectModelMap.mergeAttributes(ganadiarioSuscripcion.toMap());

			LoggerApi.Log.info("-------------- END game_ganadiario_show_bet_suscripcion");
			return new ModelAndView("game/ganadiario/interface-bet-suscripcion");		
		}	 	
	 	
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping("/game_ganadiario_add_bet")	
		public ModelAndView addBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			
			try {
				LoggerApi.Log.info("-------------- START game_ganadiario_add_bet");
				
				Map game=new HashMap();
				
				Map<String,List<String>> playList=new HashMap();
				Map<String,String> cantidadBolillas = new LinkedHashMap();
				List playGanadiarioList =new ArrayList();
			
				String cad_gd="",cad_ult_gd="";
				if(!ObjectUtils.isEmpty(request.getParameterValues("gd"))){
				for (Object object : (request.getParameterValues("gd"))) {
					playGanadiarioList.add(object.toString());						
				} 
				}
				
							
				if(CollectionUtils.isNotEmpty(playGanadiarioList)){
					playList.put("ganadiario",playGanadiarioList);
					cad_gd=String.valueOf(playGanadiarioList.size());
					cad_ult_gd=cad_ult_gd+cad_gd+"-";
					///playList.put("ganadiario_cad",cad_ult_gd);
					cantidadBolillas.put("ganadiario_cad",cad_ult_gd);
	                LoggerApi.Log.info("/game_ganadiario_add_bet ganadiario_cad="+cad_ult_gd);
				}			
				
				if(CollectionUtils.isEmpty(playGanadiarioList)){
					playList.put("ganadiario",playGanadiarioList);
					cad_gd="0";
					cad_ult_gd=cad_ult_gd+cad_gd+"-";
					///playList.put("ganadiario_cad",cad_ult_gd);
					cantidadBolillas.put("ganadiario_cad",cad_ult_gd);
	                LoggerApi.Log.info("/game_ganadiario_add_bet ganadiario_cad="+cad_ult_gd);
				}
				
				HttpSession session = request.getSession();		
				String tipoBoleto = "";
				if(MapUtils.isNotEmpty(playList)){
					/*if(MapUtils.isEmpty((Map) session.getAttribute("gameGanadiarioBoleto"))){
						game.put((String) session.getAttribute("typePlayGanadiario"),playList);
			            session.setAttribute("gameGanadiarioBoleto", game);
					}else{
						game=(Map) session.getAttribute("gameGanadiarioBoleto");
						game.put((String) session.getAttribute("typePlayGanadiario"),playList);
						session.setAttribute("gameGanadiarioBoleto", game);
					}*/
					
					tipoBoleto = (session!=null && session.getAttribute(Constantes.Boleto.typeBoleto)!=null)?session.getAttribute(Constantes.Boleto.typeBoleto).toString():"";	
					Integer jugadasBet = getTotalJugadas(playList);
					
					
					
					if(jugadasBet>3003 || jugadasBet==0 ) {
						LoggerApi.Log.info("/game_ganadiario_add_bet jugadasBet="+jugadasBet);
						if(jugadasBet>3003) session.setAttribute("ganadiarioOvercomeJugadas", 1);
						if(tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioRegular)) 
							return new ModelAndView("game/ganadiario/interface-bet-touchscreen");
					 	else if(tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30) ||
					 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90) ||
					 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180) ||
					 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365)) 
					 		return new ModelAndView("game/ganadiario/interface-bet-suscripcion");
					} else {
						session.setAttribute("ganadiarioOvercomeJugadas", 0);
					}
					/*obtiene tipo de ganadiario en cuestión*/
					Ganadiario ganadiario = new Ganadiario();
					ganadiario = (Ganadiario) session.getAttribute(tipoBoleto);
					
					//ruth
					Double precioPorJugada=jugadasBet*ganadiario.getRegularPayment();
					LoggerApi.Log.info("precioPorJugada ganadiario--->"+precioPorJugada);
					
					LoggerApi.Log.info("/game_ganadiario_add_bet tipoBoleto="+tipoBoleto);
					
					/*obtiene el boleto en caso exista en session segun el tipo de juego*/
					if(MapUtils.isNotEmpty(ganadiario.getGame())) game = ganadiario.getGame();
					
					String typePlayGanadiario = (String) session.getAttribute(Constantes.Boleto.idBoleto);
					session.setAttribute("ultima_jugada", typePlayGanadiario);
					Integer totalJugadaBoleto = validarCantidadJugadas(playList,game,typePlayGanadiario);
					LoggerApi.Log.info("/game_ganadiario_add_bet totalJugadaBoleto="+totalJugadaBoleto);
					if(totalJugadaBoleto>3003 || totalJugadaBoleto==0) {
						LoggerApi.Log.info("/game_ganadiario_add_bet totalJugadaBoleto="+totalJugadaBoleto);
						if(jugadasBet>3003) session.setAttribute("ganadiarioOvercomeJugadas", 1);
						if(tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioRegular)) 
							return new ModelAndView("game/ganadiario/interface-bet-touchscreen");
					 	else if(tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30) ||
					 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90) ||
					 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180) ||
					 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365)) 
					 		return new ModelAndView("game/ganadiario/interface-bet-suscripcion");
						 
					} else {
						session.setAttribute("ganadiarioOvercomeJugadas", 0);
					}
					
					ganadiario.setJugadasActuales(totalJugadaBoleto);
					ganadiario.setJugadasLimite(3003-totalJugadaBoleto);
					game.put(typePlayGanadiario,playList);
					//Pobrar on y sin estos logs
					
					//LoggerApi.Log.info("/game_ganadiario_add_bet game="+game);
					//LoggerApi.Log.info("/game_ganadiario_add_bet new TreeMap(game)="+new TreeMap(game));
					ganadiario.setGame(game);
					ganadiario.setBolillas(playGanadiarioList);
					ganadiario.setBoleto(new TreeMap(game));
					ganadiario.setLastJugada(cantidadBolillas);
					session.setAttribute(tipoBoleto, ganadiario);
					session.setAttribute("precioPorJugada", precioPorJugada);
					session.setAttribute("consecu", "");
					
					String tipo = ganadiario.getTypeGanadiario().equals("REG")? "" : ganadiario.getDraws().toString();
					
					/*Esto puede ser reemplazado por tinka, testear cpn el boleto*/
					session.setAttribute("jugada"+tipo, playList);
		            session.setAttribute("jugada_gd"+tipo, playGanadiarioList);
		            session.setAttribute("cadi"+tipo, cad_gd);
					
					LoggerApi.Log.info("/game_ganadiario_add_bet "+tipoBoleto+"="+new TreeMap(game));
					LoggerApi.Log.info("/game_ganadiario_add_bet game="+game);
					
					if(MapUtils.isNotEmpty((Map) session.getAttribute("gameGanadiarioBoleto"))) game = (Map)session.getAttribute("gameGanadiarioBoleto");
					////**game.put((String) session.getAttribute("typePlayGanadiario"),playList);
					session.setAttribute("gameGanadiarioBoleto", new TreeMap(game));
					//session.getAttribute(null);
					///session.setAttribute("lastJugada", playList);
					session.setAttribute("lastJugadaGanadiario", playList);
					
					
					session.setAttribute("montoPagar", ganadiario.getDiscountPayment());
					
					session.removeAttribute("typePlayGanadiario");	
					IntralotUtils.carItemUpdate(session);
					
					LoggerApi.Log.info("/game_ganadiario_add_bet jugada="+playList +" jugada_gd="+playGanadiarioList+" lastJugada="+playList+" cadi="+cad_gd);
		            session.setAttribute("lastJugada", cantidadBolillas);
		            session.setAttribute("valorRemo", "");
		            session.setAttribute("consecutiveParam", "");
		            session.removeAttribute(Constantes.Boleto.idBoleto);
				}
				
				session.setAttribute("operation", "add");
				
				String redireccion = "";
			 	if(tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioRegular)) 
			 		redireccion = "redirect:game_ganadiario_show_shoppingcart.html";
			 	else if(tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion30) ||
			 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion90) ||
			 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion180) ||
			 			tipoBoleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioSuscripcion365)) 
			 		redireccion="redirect:game_ganadiario_show_shoppingcart_suscripcion.html";

			 	return new ModelAndView(redireccion);
				//return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");

			} catch (Exception e) {
				LoggerApi.severe(e);
				return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");
			} finally {
				LoggerApi.Log.info("-------------- END game_ganadiario_add_bet"); 
			}
			
	     }
		
		/**
		 * 
		 * @param request
		 * @param objectModelMap
		 * @return
		 * @throws Exception
		 * 
		 * <p>Se debe controlar una pagina de error de server para el caso de los null por caida</p>
		 * 
		 */
		@RequestMapping("/game_ganadiario_show_shoppingcart_suscripcion")	
		public ModelAndView showShoppingCartSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

			LoggerApi.Log.info("-------------- START game_ganadiario_show_shoppingcart_suscripcion");
			try {

				HttpSession session = request.getSession();
				session.setAttribute("tipoGanadiario", "suscripcion");
				String boleto="";
				if(request.getParameter("boleto")!=null) {
					boleto = request.getParameter("boleto").toString();
				} else if (session.getAttribute(Constantes.Boleto.typeBoleto)!=null) boleto = (String) session.getAttribute(Constantes.Boleto.typeBoleto);
				
				session.setAttribute("tipoBoletoSuscripcion", boleto);
				
				if(boleto.trim().equals("")) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
				
				String typeboleto=getTypeBoleto(boleto);
				
				Ganadiario ganadiarioSuscripcion = !typeboleto.equals("")?(Ganadiario) session.getAttribute(typeboleto):null;
				
				Integer totalbets = 0 ;
				
				if(ganadiarioSuscripcion!=null) {
					totalbets = validarCantidadJugadas(null,ganadiarioSuscripcion.getGame(),StringUtils.EMPTY);//getTotalBetFromJugadaTinka(typeboleto,session);
				}
				
				String indicadorPurchase = (totalbets>3003 || totalbets==0)?"no":"yes";
					
				if(totalbets>3003){
		    		objectModelMap.put("alertNumberPlayGanadiario","El numero de jugadas excede lo permitido (3003) !");
		    		return new ModelAndView("game/ganadiario/interface-shoppingcart-suscripcion");
				} else {
		    		
		    		if(ganadiarioSuscripcion!=null) {
		    			Double payment = (double)Math.round(ganadiarioSuscripcion.getPricePerPlay()*totalbets*ganadiarioSuscripcion.getDraws());
		    			Double regularPayment = ganadiarioSuscripcion.getRegularPricePerPlay()*totalbets*ganadiarioSuscripcion.getDraws();
			    		ganadiarioSuscripcion.setDiscountPayment(payment);
			    		ganadiarioSuscripcion.setJugadas(totalbets*ganadiarioSuscripcion.getDraws());
			    		ganadiarioSuscripcion.setRegularPayment(regularPayment);
			    		LoggerApi.Log.info("/game_ganadiario_show_shoppingcart_suscripcion boleto="+ganadiarioSuscripcion.getBoleto());
			    		LoggerApi.Log.info("/game_ganadiario_show_shoppingcart_suscripcion boleto="+ganadiarioSuscripcion.getTicket());
			    		session.setAttribute(typeboleto, ganadiarioSuscripcion);
			    		
			    		objectModelMap.mergeAttributes(ganadiarioSuscripcion.toMap());
			    		objectModelMap.mergeAttributes(ganadiarioSuscripcion.sendBoleto());

			    		LoggerApi.Log.info("/game_ganadiario_show_shoppingcart_suscripcion indicadorPurchase="+indicadorPurchase);
			    		objectModelMap.put("indicadorPurchase",indicadorPurchase);
			    		objectModelMap.put("negacion","no");
						objectModelMap.put("afirmacion","yes");

						return new ModelAndView("game/ganadiario/interface-shoppingcart-suscripcion");
		    		} 
		    	}	
				
			} catch (Exception e) {
				LoggerApi.severe(e);
				return new ModelAndView("game/ganadiario/interface-shoppingcart-suscripcion");
			} finally {
				LoggerApi.Log.info("-------------- END game_ganadiario_show_shoppingcart_suscripcion"); 
			}
			return new ModelAndView("game/ganadiario/interface-shoppingcart-suscripcion");

		}
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping("/game_ganadiario_show_shoppingcart")	
		public ModelAndView showShoppingCart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			int clientId = 0;
			try {						
				LoggerApi.Log.info("-------------- START game_ganadiario_show_shoppingcart");
						
					HttpSession session = request.getSession();		
					session.setAttribute("tipoGanadiario", "simple");
					Map map=(Map) session.getAttribute("gameGanadiarioBoleto");
					String typeboleto =Constantes.BoletoGanadiario.boletoGanadiarioRegular;					
					Ganadiario ganadiarioRegular = !typeboleto.equals("")?(Ganadiario) session.getAttribute(typeboleto):null;

				if(ganadiarioRegular!=null && ganadiarioRegular.getJugadasActuales()!=null){
						
					Integer totalBet = ganadiarioRegular.getJugadasActuales();
					String indicadorPurchase = (totalBet>3003 || totalBet==0)?"no":"yes";				
		    	
				   	if(totalBet>3003){
			    		objectModelMap.put("alertNumberPlay","El numero de jugadas excede lo permitido (1386) !");
				   	}
				   	Map consecutiveMap=(Map) session.getAttribute("consecutiveGanadiarioValue");
					Long consecutive=Long.valueOf(1);					
					if(MapUtils.isNotEmpty(consecutiveMap)){
						consecutive=Long.valueOf(((Map) session.getAttribute("consecutiveGanadiarioValue")).get("NUM_DRAW").toString());	
					}
					else {
						consecutive=Long.valueOf(1);	
					}
				   	Double totalPay = getCostoTotalRegularBet(ganadiarioRegular,consecutive);
		               
				    ganadiarioRegular.setDiscountPayment(totalPay);
				    LoggerApi.Log.info("/game_ganadiario_show_shoppingcart boleto="+ganadiarioRegular.getBoleto());
				    session.setAttribute(typeboleto, ganadiarioRegular);
	               
			    	session.setAttribute("totalGanadiarioSession",Double.valueOf(totalPay));
			    	
			    	objectModelMap.mergeAttributes(ganadiarioRegular.toMap());
			    	objectModelMap.mergeAttributes(ganadiarioRegular.sendBoleto());
			    	
					objectModelMap.put("negacion","no");
					objectModelMap.put("afirmacion","yes");
					objectModelMap.put("consecutive",consecutive);
					objectModelMap.put("ind_gd",indicadorPurchase);//ind_tk);
				   											
					//Map map = (Map) (!typeboleto.equals("")? session.getAttribute(typeboleto):null);
					
					int countPlay = 0;
					String cad_gd="";
					String ind_gd="";
					
				   	/*Iterator it = map.keySet().iterator();
				   	
					if(map!=null) {
				    	while(it.hasNext()) {*/
					if(MapUtils.isNotEmpty(map) && map.size()>0) {
						for(Iterator it=map.keySet().iterator();it.hasNext();) {
							String mapa = (String)it.next();					
							Map maping =(Map) map.get(mapa);
							
							switch (((List)((Map) map.get(mapa)).get("ganadiario")).size()) {
								case 5:	 countPlay ++;  break;
								case 6:	 countPlay +=6; break;
								case 7:  countPlay +=21;break;
								case 8:	 countPlay +=56;	break;
								case 9:	 countPlay +=126;	break;
								case 10: countPlay +=252;	break;	
								case 11: countPlay +=462;	break;	
								case 12: countPlay +=792;	break;
								case 13: countPlay +=1287;	break;
								case 14: countPlay +=2002;	break;
								case 15: countPlay +=3003;	break;
								default: countPlay +=0;	break;
							}
						
							
							if(CollectionUtils.isEmpty((List) maping.get("ganadiario"))){
								
								cad_gd = cad_gd+((String) ((Map)ganadiarioRegular.getLastJugada()).get("ganadiario_cad"));// maping.get("ganadiario_cad"));
						   	
								String sTexto_1 = cad_gd;
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
						                 if (car_1 < 5 ) {
						                	 indicador_1 = "no";
						                }
						                cade_1 = "";
						            }
						            inicial_1++;
						            siguiente_1++;
					            }
					        
					            ind_gd=indicador_1;
					           
							}
							
							if(CollectionUtils.isNotEmpty((List) maping.get("ganadiario"))) {
									
									cad_gd = cad_gd+((String) ((Map)ganadiarioRegular.getLastJugada()).get("ganadiario_cad"));//((String) maping.get("ganadiario_cad"));
							   	
									String sTexto_1 = cad_gd;
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
							                 if (car_1 < 5 ) {
							                	 indicador_1 = "no";
							                }
							                cade_1 = "";
			
							            }
			
							            inicial_1++;
							            siguiente_1++;
						            }
						        
						            ind_gd=indicador_1;
						           
							}
			
				    	}															
					}		

								
					Double nume=0.80;
					
					Long total_sesssion = new Long(0);
					total_sesssion=consecutive * countPlay;
					
				   	if(countPlay>3003){
			    		objectModelMap.put("alertNumberPlay","El numero de jugadas excede lo permitido (3003) !");
			    	}	
				   	
				   	//////////////////
				   	clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
				   	GanadiarioSale ganadiarioSale = beanGanadiarioBetBo.findGanadiarioBetData(clientId);
				   	
				    int fullTotal =  countPlay;

					LoggerApi.Log.info("ganadiarioSale="+ganadiarioSale);
				    
				    String algorithm = ganadiarioSale.getAlgorithm();
				    Double simpleBetPrice = ganadiarioSale.getSimpleBetPrice();
				    int bets = ganadiarioSale.getBets()==null?0:ganadiarioSale.getBets().intValue();
				    int pay = ganadiarioSale.getPay()==null?0:ganadiarioSale.getPay().intValue();
				    Double cost = ganadiarioSale.getCost();
				    int draw = ganadiarioSale.getDraws()==null?0:ganadiarioSale.getDraws().intValue();
				    /*
				    Double costoTotalBet=null;
				    if (algorithm==null) algorithm="";
				    
		            if (algorithm.equals("BETS")) {
		                costoTotalBet = Utils.callTransformByBets(fullTotal, consecutive, simpleBetPrice, bets, pay);
		            } else {
		                if (algorithm.equals("COST")) { 
		                    costoTotalBet = Utils.callTransformByCost(fullTotal, consecutive, simpleBetPrice, bets, cost);
		                } else {
		                    if (algorithm.equals("DRAW")) { 
		                        costoTotalBet = Utils.callTransformByDraws(fullTotal, consecutive, simpleBetPrice, draw, pay);
		                    } else {
		                    	if (algorithm.equals("DESC")) {
		                            costoTotalBet = Utils.callTransformDESC(fullTotal, consecutive, simpleBetPrice, pay, cost)[0];
		                        } else {
		                        	if (algorithm.startsWith("ESC")) {
			                            costoTotalBet = Utils.callTransformESC(algorithm, fullTotal, consecutive, simpleBetPrice)[0];
			                        } else {
			                            costoTotalBet = ( simpleBetPrice * fullTotal ) * consecutive;
			                        }
		                        }
		                    }
		                }
		            }  
		            */
	               /// Double totalPay = costoTotalBet; //
	                
				   	//////////////////
				   	
				   	//GanadiarioSale ganadiarioProcedureBetDataBean = beanGanadiarioBetBo.findGanadiarioBetData();
			    	/////session.setAttribute("totalGanadiarioSession",total_sesssion);
			    	objectModelMap.put("totalBet",countPlay);
			    	objectModelMap.put("draw","DRAW");
			    	objectModelMap.put("pay","PAY");
			    	objectModelMap.put("bet","BET");
			    	objectModelMap.put("nume",nume);
			    	objectModelMap.put("negacion","no");
					objectModelMap.put("afirmacion","yes");
					objectModelMap.put("ind_gd",ind_gd);
					objectModelMap.put("precioJugada",intralotUtils.formatCurrency(ganadiarioSale.getSimpleBetPrice()));
					objectModelMap.put("totalGanadiario_GD",intralotUtils.formatCurrency(totalPay));
					//objectModelMap.put("totalGanadiario",intralotUtils.formatCurrency((Long) session.getAttribute("totalGanadiarioSession")));
					
					request.setAttribute("ganadiarioProcedureBetData",ganadiarioSale);
					
					//start capturar precios por jugada(a,b,c,d)
	                String operation=session.getAttribute("operation").toString();
	                Map <String, Double> precio_detalle_gd= new HashMap<String, Double>();
	                if(operation.equals("add")) {
	                	if(ganadiarioRegular.getBoleto().size()==1) {	                		
	                		precio_detalle_gd.put("previusPrice", totalPay);
	                		objectModelMap.put("lastPrice", totalPay);
	                	}else {
	                		precio_detalle_gd=(Map)session.getAttribute("precio_detalle_gd");	                		
	                		objectModelMap.put("lastPrice", totalPay-precio_detalle_gd.get("previusPrice"));
	                		precio_detalle_gd.put("previusPrice", totalPay);
	                	}
	                	
	                	session.setAttribute("precio_detalle_gd",precio_detalle_gd);
	                }
	                if(operation.equals("delete")) {
	                	precio_detalle_gd=(Map)session.getAttribute("precio_detalle_gd");	                	
	                	objectModelMap.put("priceJuegoDelete", precio_detalle_gd.get("previusPrice")-totalPay);
	                	
	                	precio_detalle_gd.put("previusPrice", totalPay);               		
                		session.setAttribute("precio_detalle_gd",precio_detalle_gd);
	                }
	                if (operation.equals("consecutive")) {
	                	precio_detalle_gd = (Map) session.getAttribute("precio_detalle_gd");
						objectModelMap.put("lastPrice", totalPay-precio_detalle_gd.get("previusPrice"));
						precio_detalle_gd.put("previusPrice", totalPay);
						session.setAttribute("precio_detalle_gd",precio_detalle_gd);
					}
	                if(operation.equals("removeConsecutive")) {	                	
	                	precio_detalle_gd=(Map)session.getAttribute("precio_detalle_gd");	      
	                	objectModelMap.put("priceJuegoDelete", precio_detalle_gd.get("previusPrice")-totalPay);
	                	precio_detalle_gd.put("previusPrice", totalPay);               		
                		session.setAttribute("precio_detalle_gd",precio_detalle_gd);	                		                	
	                }
	                objectModelMap.put("operation", operation);	                
	                session.setAttribute("operation","default");
	                
	                Double flagGd = (beanParameterBo.findParameterById(Constantes.C_GD) == null) ? 0 : beanParameterBo.findParameterById(Constantes.C_GD).getNumber();
		            objectModelMap.put("flagConsecutivaGd",flagGd);
					
					return new ModelAndView("game/ganadiario/interface-shoppingcart");
					
				}else return new ModelAndView("redirect:game_ganadiario_show_menu.html");
					
		
			} catch (Exception e) {
				LoggerApi.severe(e);
				return new ModelAndView("game/ganadiario/interface-shoppingcart");
			}finally {
			    LoggerApi.Log.info("-------------- END game_ganadiario_show_shoppingcart"); 
			}
		
		}
			
		
		@SuppressWarnings({"rawtypes" })
		@RequestMapping("/game_ganadiario_delete_bet")	
		public ModelAndView deleteBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			
			try {
				LoggerApi.Log.info("-------------- START game_ganadiario_delete_bet");
				HttpSession session = request.getSession();		
				
				Map game1=(Map) session.getAttribute("gameGanadiarioBoleto");
				
			   if(MapUtils.isNotEmpty((Map) game1.get(request.getParameter("id")))){		   
				   game1.remove(request.getParameter("id"));
				   session.setAttribute("gameGanadiarioBoleto",game1);
				   IntralotUtils.carItemUpdate(session);
			   }
			   
			   //return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");
				   String id = "";
					if(request.getParameter("id")!=null) {
						id = request.getParameter("id").toString();
					} else return new ModelAndView("redirect:game_ganadiario_show_menu.html");
					
					LoggerApi.Log.info("/game_ganadiario_delete_bet id="+id);
					Map boleto = null;
				
					//String identifier = id.endsWith("")
					String typeboleto=getTypeBoleto(id);
					if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
					
					LoggerApi.Log.info("/game_ganadiario_delete_bet typeboleto="+typeboleto);
					if(StringUtils.isNotEmpty(typeboleto)) {
						Ganadiario ganadiario = (Ganadiario) session.getAttribute(typeboleto);
						
						boleto=ganadiario.getBoleto();	
						
						/**
						 * Aqui falta testearlo por el id
						 */
					   if(boleto!=null && MapUtils.isNotEmpty((Map) boleto.get(id))){
						   boleto.remove(id);
						   Map<String,Map<String,List<String>>> game = ganadiario.getGame();
						   game.remove(id);
						   Integer totalJugadas = validarCantidadJugadas(null,game,StringUtils.EMPTY);
						   LoggerApi.Log.info("/game_ganadiario_delete_bet game="+game);
						   ganadiario.setGame(game);
						   ganadiario.setJugadasActuales(totalJugadas);
						   ganadiario.setJugadasLimite(3003-totalJugadas);
						   LoggerApi.Log.info("/game_ganadiario_delete_bet totalJugadas="+totalJugadas);
						   LoggerApi.Log.info("/game_ganadiario_delete_bet boleto="+boleto);
						   //if(evaluateTinkaSession(session,typeboleto))
						   
						   LoggerApi.Log.info("ganadiario.getDiscountPayment()---->"+ganadiario.getDiscountPayment());
						   LoggerApi.Log.info("preciooo---->"+totalJugadas*ganadiario.getRegularPayment());
						
						   Double valorRemo=ganadiario.getDiscountPayment()-totalJugadas*ganadiario.getRegularPayment();
						   LoggerApi.Log.info("valorRemo ganadiario---->"+valorRemo);
						   
						   
						   
						   ganadiario.setBoleto(new TreeMap(boleto));
						   
						   
						   session.setAttribute(typeboleto,ganadiario);
						   session.setAttribute("valorRemo",valorRemo);
						   
						   if(typeboleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioRegular)) {
							   if(MapUtils.isEmpty(boleto)){
								   session.removeAttribute("consecutiveGanadiario");
								   session.removeAttribute("consecutiveGanadiarioValue");
							   }
						   }   
					   }					   					  
					}
					IntralotUtils.carItemUpdate(session);
					session.setAttribute("operation", "delete");
					session.setAttribute("ultima_jugada", id);
				 if(typeboleto.equals(Constantes.BoletoGanadiario.boletoGanadiarioRegular)) {
					 return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html"); 
				 } else {
					 return new ModelAndView("redirect:game_ganadiario_show_menu.html");
				 }
				
			} catch (Exception e) {
				LoggerApi.severe(e);
				return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");
			} finally{
				LoggerApi.Log.info("-------------- END game_ganadiario_delete_bet"); 
			}
		
	    }
		
		
		@RequestMapping("/game_ganadiario_show_consecutive")	
		public ModelAndView showConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			LoggerApi.Log.info("-------------- START game_ganadiario_show_consecutive"); 	
						
			try {
				HttpSession session = request.getSession();	
				
				if(ObjectUtils.isEmpty((HashMap[]) session.getAttribute("consecutiveGanadiarioList"))){
					session.setAttribute("consecutiveGanadiarioList", beanGanadiarioBetBo.getNumberConsecutive());
				}
				
				return new ModelAndView("game/ganadiario/interface-consecutive");
				
			} catch (Exception e) {		
				LoggerApi.severe(e);
				return new ModelAndView("game/ganadiario/interface-consecutive");
			}finally{
				LoggerApi.Log.info("-------------- END game_ganadiario_show_consecutive"); 
			}	     				
			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping("/game_ganadiario_add_consecutive")	
		public ModelAndView addConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			
			try {	
				
				LoggerApi.Log.info("-------------- START game_ganadiario_add_consecutive");
			    String consecutiveParam = "";
			    consecutiveParam=(request.getParameterValues("consecutive")!=null && request.getParameterValues("consecutive")[0]!=null)?request.getParameterValues("consecutive")[0]:"";
				HttpSession session = request.getSession(); 			
				session.setAttribute("consecutiveGanadiario",((consecutiveParam!=null)?consecutiveParam.trim():""));			
				HashMap[] consecutive=(HashMap[]) session.getAttribute("consecutiveGanadiarioList");
				
				objectModelMap.put("valor", 1);
				session.setAttribute("operation","consecutive");
				if(consecutive!=null){
				for (HashMap item : consecutive) {
				
				if(StringUtils.equals(String.valueOf(item.get("NUM_DRAW")),consecutiveParam)){
					session.setAttribute("consecutiveGanadiarioValue", item);
							  session.setAttribute("consecutiveParam", consecutiveParam);			
					break;
				}
					
			}
				}
			return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");	
				
			} catch (Exception e) {	
				LoggerApi.severe(e);
			    return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");	
			}finally{
				LoggerApi.Log.info("-------------- END game_ganadiario_add_consecutive"); 
			}   
			
		}
		
		
		@RequestMapping("/game_ganadiario_delete_consecutive")	
		public ModelAndView deleteConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
			
			try {
				LoggerApi.Log.info("-------------- START game_kabala_delete_consecutive");
						
				HttpSession session = request.getSession();				
				session.removeAttribute("consecutiveGanadiario");
				session.removeAttribute("consecutiveGanadiarioValue");	
				session.setAttribute("operation","removeConsecutive");
				
				return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");
				
			} catch (Exception e) {
				
				LoggerApi.severe(e);
				return new ModelAndView("redirect:game_ganadiario_show_shoppingcart.html");
			}finally{
				LoggerApi.Log.info("-------------- END game_ganadiario_delete_consecutive");
			}   
		
			
		}
		
		
		@SuppressWarnings({ "rawtypes", "static-access" })
		@RequestMapping("/game_ganadiario_play_bet")	
		public ModelAndView playBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
				
			HttpSession session = request.getSession();
			
			try {			
				LoggerApi.Log.info("");
				
				Map map=(Map) session.getAttribute("gameGanadiarioBoleto");
				
				if(MapUtils.isNotEmpty(map)){
					
					GroupAPI[] group = new GroupAPI[map.size()];
					
					
					int count=0;
			    	/*Iterator it = map.keySet().iterator();					
			    	while(it.hasNext()){*/
					if(map.size()>0) {
						for(Iterator it=map.keySet().iterator();it.hasNext();) {
				    		String mapa = (String)it.next();						
							Map maping =(Map) map.get(mapa);			
									
							List playList =(List) maping.get("ganadiario");			
							
							int[] numbers = new int[playList.size()];					
							
							int ganadiarioCount=0;
							for (Object item : playList) {
								numbers[ganadiarioCount]=Integer.valueOf((String) item);
								ganadiarioCount++;
							}
											
					        group[count] = new GroupAPI();
					        group[count].setLottoBet(Game.GANADIARIO, Group.NORMAL, numbers);				       
					        count++;			    		
				    	}
					}
			    	int numbersConsecutive=1;
					if(MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveGanadiarioValue"))){
						 numbersConsecutive= Integer.valueOf(((Map) session.getAttribute("consecutiveGanadiarioValue")).get("NUM_DRAW").toString());	
					}
			    	
			    	AccountController accountController = new AccountController();
					Client client = accountController.getClientByClientId((String) session.getAttribute("clientId"));
					
			    	
					Game game = new Game();
					game.setGame(Game.GANADIARIO);
																	
					DateAPI d = new DateAPI();
					WEBMessage web = new WEBMessage();
					web.setClient(client);
					web.setIp(request.getRemoteAddr());
					web.setGame(game);
					web.setGroup(group);
					web.setMessageId("W" + d.getTimeLong() + Game.GANADIARIO);
					web.setCarrier("MOBILE");
					
					int priceSale =(Integer) session.getAttribute("totalGanadiarioSession");
					
					ClientTicket ct = new ClientTicket();
					ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
					String messageResult=StringUtils.EMPTY;	
				
					
					if(ct.getMessage() != null) messageResult = ct.getMessage();				
					
					LoggerApi.Log.info("/game_ganadiario_play_bet messageResult="+messageResult);
					if(messageResult.equals("OK")) {
						session.removeAttribute("consecutiveGanadiario");
						session.removeAttribute("consecutiveGanadiarioValue");
						session.removeAttribute("totalGanadiarioSession");						
						session.removeAttribute("gameGanadiarioBoleto");
						IntralotUtils.carItemUpdate(session);
						
						session.setAttribute("alertPlay","Jugada exitosa !");
						return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=ok");
						
					} else if(StringUtils.contains(messageResult,"autoexclusión")) {
						session.setAttribute("alertPlay","Limite autoexclusion activado");
						return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=error");
					} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
						session.setAttribute("alertPlay","No se ha encontrado el registro del cliente");
						return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=error");
					} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
						session.setAttribute("alertPlay","No cuenta con saldo disponible para realizar este proceso");	
						return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=error");
					}else {		
						session.setAttribute("alertPlay","Ocurrio un error intente nuevamente  ");	
						return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=error");
					} 
					}	
				return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=error");
				
			} catch (Exception e) {
				session.setAttribute("alertPlay","Ocurrio un error intente nuevamente ");
				LoggerApi.severe(e);
				return new ModelAndView("redirect:client_play_show_information.html?game=ganadiario&status=error");
			}finally{
				//LoggerApi.Log.info("Salir al metodo: playBet. Estado : Satisfactorio");
				//LoggerApi.Log.info("Salir al action: GanadiariolBetController.");
			}	
		
			
		}
		
		@SuppressWarnings({ "rawtypes", "static-access" })
		@RequestMapping("/game_ganadiario_play_bet_result")	
		public ModelAndView playBetResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
				
			HttpSession session = request.getSession();
			GanadiarioSale ganadiarioSale = new GanadiarioSale();
			try {			
				LoggerApi.Log.info("-------------- START game_ganadiario_play_bet_result");
				
				Map map=(Map) session.getAttribute("gameGanadiarioBoleto");
				
				//////////////////////////
				Ganadiario ganadiario = session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioRegular)!=null?(Ganadiario) session.getAttribute(Constantes.BoletoGanadiario.boletoGanadiarioRegular):null;
				
				if(ganadiario!=null){
				
					map=ganadiario.getBoleto();
					
				
				}
				/////////////////////////
				
				if(ganadiario!=null){
					String numBolJugadaA="";String numBolJugadaB="";String numBolJugadaC="";String numBolJugadaD="";	
				if(MapUtils.isNotEmpty(map)){
					
					GroupAPI[] group = new GroupAPI[map.size()];
					
					
					int count=0;
			    	/*Iterator it = map.keySet().iterator();					
			    	while(it.hasNext()){*/
					if(map.size()>0) {
						for(Iterator it=map.keySet().iterator();it.hasNext();) {
			    		
				    		String mapa = (String)it.next();						
							Map maping =(Map) map.get(mapa);			
									
							List playList =(List) maping.get("ganadiario");			
							
							int[] numbers = new int[playList.size()];					
							
							int ganadiarioCount=0;
							for (Object item : playList) {
								numbers[ganadiarioCount]=Integer.valueOf((String) item);
								ganadiarioCount++;
							}
											
							if(mapa.equals("jugada_a")) {
								numBolJugadaA=ganadiarioCount+"";
							}
							else if(mapa.equals("jugada_b")) {
								numBolJugadaB=ganadiarioCount+"";
							}
							else if(mapa.equals("jugada_c")) {
								numBolJugadaC=ganadiarioCount+"";
							}
							else if(mapa.equals("jugada_d")) {
								numBolJugadaD=ganadiarioCount+"";
							}
							
					        group[count] = new GroupAPI();
					        group[count].setLottoBet(Game.GANADIARIO, Group.NORMAL, numbers);				       
					        count++;			    		
				    	}
					}
			    	int numbersConsecutive=1;
			    	String consecu="";
					if(MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveGanadiarioValue"))){
						 numbersConsecutive= Integer.valueOf(((Map) session.getAttribute("consecutiveGanadiarioValue")).get("NUM_DRAW").toString());	
						 consecu=numbersConsecutive+"";
					}
			    	
			    	AccountController accountController = new AccountController();
					Client client = accountController.getClientByClientId((String) session.getAttribute("clientId"));
					
			    	
					Game game = new Game();
					game.setGame(Game.GANADIARIO);
																	
					DateAPI d = new DateAPI();
					WEBMessage web = new WEBMessage();
					web.setClient(client);
					web.setIp(request.getRemoteAddr());
					web.setGame(game);
					web.setGroup(group);
					web.setMessageId("W" + d.getTimeLong() + Game.GANADIARIO);
					web.setCarrier("MOBILE");
					
					double priceSale =(Double) session.getAttribute("totalGanadiarioSession");
					
					ClientTicket ct = new ClientTicket();
					ganadiarioSale = beanGanadiarioBetBo.findGanadiarioBetData(Integer.parseInt(client.getClientId()));
					session.setAttribute("jugadasGratis", ganadiarioSale.getBalanceQuantityGame());
					
					
					ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
					ganadiarioSale = beanGanadiarioBetBo.findGanadiarioBetData(Integer.parseInt(client.getClientId()));
					String messageResult=StringUtils.EMPTY;
					if(ct.getMessage() != null) messageResult = ct.getMessage();
					objectModelMap.put("SubZona","Juega Gana Diario");
					LoggerApi.Log.info("/game_ganadiario_play_bet_result messageResult="+messageResult);
					if(messageResult.equals("OK")) {
						session.removeAttribute("consecutiveGanadiario");
						session.removeAttribute("consecutiveGanadiarioValue");
						session.removeAttribute("totalGanadiarioSession");						
						session.removeAttribute("gameGanadiarioBoleto");
						session.removeAttribute(Constantes.BoletoGanadiario.boletoGanadiarioRegular);
						IntralotUtils.carItemUpdate(session);
						
						//session.setAttribute("alertPlay","Jugada exitosa !");
						objectModelMap.put("alertPlay","Jugada exitosa !");
						objectModelMap.put("game","ganadiario");
						objectModelMap.put("status","ok");
						objectModelMap.put("newamount",intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
						session.setAttribute("saldo", intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
						objectModelMap.put("bonusOther",ganadiarioSale.getOtherQuantity());
						//objectModelMap.put("bonusOther",intralotUtils.formatCurrency(Double.parseDouble(ganadiarioSale.getOtherAmount())));
						session.setAttribute("bonoOtro", ganadiarioSale.getOtherQuantity());
						
						session.setAttribute("ticketId", ct.getTicketId());
						//envio de parametros
						session.setAttribute("importeTotal", ganadiario.getDiscountPayment());
//						session.setAttribute("jugadasGratis", ganadiario.getQuantityGame());
						session.setAttribute("jugadasActuales", ganadiario.getJugadasActuales());
						session.setAttribute("consecu", consecu);
						
						session.setAttribute("numBolJugadaA", numBolJugadaA);
						session.setAttribute("numBolJugadaB", numBolJugadaB);
						session.setAttribute("numBolJugadaC", numBolJugadaC);
						session.setAttribute("numBolJugadaD", numBolJugadaD);
						
						session.removeAttribute("precios_jugadas_gd");
						
						//tagging MxN
						objectModelMap.put("formatPricePerPlay2",ganadiario.getPricePerPlay());
						objectModelMap.put("discountPayment",ganadiario.getDiscountPayment());
						objectModelMap.put("promotionMessage",ganadiario.getPromotionMessage());
						
						return new ModelAndView("game/ganadiario/interface-result_game");
						
					}else if(StringUtils.contains(messageResult,"autoexclusión")) {
						objectModelMap.put("alertPlay","Limite autoexclusion activado");
						objectModelMap.put("game","ganadiario");
						objectModelMap.put("status","error");
						return new ModelAndView("game/ganadiario/interface-result_game");
					} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
						//session.setAttribute("alertPlay","No se ha encontrado el registro del cliente");
						objectModelMap.put("alertPlay","No se ha encontrado el registro del cliente");
						objectModelMap.put("game","ganadiario");
						objectModelMap.put("status","error");
						return new ModelAndView("game/ganadiario/interface-result_game");
					} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
						//session.setAttribute("alertPlay","No cuenta con saldo disponible para realizar su compra");	
						objectModelMap.put("alertPlay","No cuenta con saldo disponible para realizar su compra");
						objectModelMap.put("game","ganadiario");
						objectModelMap.put("status","saldo");
						return new ModelAndView("game/ganadiario/interface-result_game");
					}else {		
						//session.setAttribute("alertPlay","Ocurrió un error intente nuevamente  ");	
						objectModelMap.put("alertPlay","Ocurrió un error intente nuevamente  ");
						objectModelMap.put("game","ganadiario");
						objectModelMap.put("status","error");
						return new ModelAndView("game/ganadiario/interface-result_game");
					} 
					}	
				}
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","error");
				objectModelMap.put("alertPlay", "Ocurrio un error intente nuevamente");
				return new ModelAndView("game/ganadiario/interface-result_game");
				
			} catch (Exception e) {
				//session.setAttribute("alertPlay","Ocurrio un error intente nuevamente ");
				objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente ");
				LoggerApi.severe(e);
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","error");
				return new ModelAndView("game/ganadiario/interface-result_game");
			}finally{
				LoggerApi.Log.info("-------------- END game_ganadiario_play_bet_result"); 
			}	
		
			
		}
		
		/**
		 * 
		 * @param request
		 * @param objectModelMap
		 * @return
		 * @throws Exception
		 * 
		 * <p>PlayBetSuscription se encarga de realizar la transaccion de compra de ganadiario
		 * suscripcion, aun faltra implementar la parte de AZAR. Es posible combinar este método con la trassaccion de compra 
		 * de uno regular</p>
		 */
		@SuppressWarnings({ "rawtypes" })
		@RequestMapping("/game_ganadiario_play_bet_result_suscription")	
		public ModelAndView playBetSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
			
			/*
			 * Obtengo el boleto de la session e identifico la suscripcion
			 */
			/**
			 * Esta parte se repite en varias funciones, se puede refactorizar
			 */
			LoggerApi.Log.info("-------------- START game_ganadiario_play_bet_result_suscription"); 
			objectModelMap.put("SubZona","Combos Gana Diario");
			objectModelMap.put("tipoCompra","combo");
			objectModelMap.put("alertPlay","Error inesperado en el sistema");
			ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
			HttpSession session = request.getSession();
			
			String modelview = "game/ganadiario/interface-result_game";
			String boleto = "";
			
			if(request.getParameter("boleto")!=null) boleto = request.getParameter("boleto").toString();
			else if (session.getAttribute("carrierBoleto")!=null) {
				boleto = session.getAttribute("carrierBoleto").toString();
				session.removeAttribute("carrierBoleto");
			} else return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			
			LoggerApi.Log.info("/game_ganadiario_play_bet_result_suscription boleto="+boleto);
			
			if(boleto.trim().equals("")) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			
			
			String typeboleto=getTypeBoleto(boleto);
			
			if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_ganadiario_show_menu.html");
			session.setAttribute("typeBoletoTemp", typeboleto);
			Ganadiario ganadiarioSuscripcion = null;

			ganadiarioSuscripcion = (Ganadiario) session.getAttribute(typeboleto);
			String juego = "";
			LoggerApi.Log.info("/game_ganadiario_play_bet_result_suscription typeboleto="+typeboleto);
			
			Integer multiDraws = 0;
			String gameType = "";
			Double price = 0.00;
			if(StringUtils.isNotEmpty(typeboleto)) {
				
				
			    multiDraws = ganadiarioSuscripcion.getDraws();
				gameType = ganadiarioSuscripcion.getTypePlay();//session.getAttribute("tinkaSuscripcionTipo")!=null?session.getAttribute("tinkaSuscripcionTipo").toString():"SUS_AZAR";
				price = ganadiarioSuscripcion.getDiscountPayment();
				
				if(gameType.equals("SUS_AZAR")) juego = "AZAR";
				else if(gameType.equals("SUS_IGUAL")) {
					for (String bolilla : ganadiarioSuscripcion.getBolillas()) {
						juego += bolilla+" ";
					}
				}
			    
			}

			try {
				client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);
			} catch (Exception e) {
				return new ModelAndView("redirect:security_login_execute_authentication.html");
			}
			String ip = request.getRemoteAddr().toString();
			Integer gameId= Game.GANADIARIO;
			
			LoggerApi.Log.info("/game_ganadiario_play_bet_result_suscription juego="+juego+" multiDraws="+multiDraws+" gameType="+gameType+" price="+price+" client="+client+" ip="+ip+" gameId="+gameId);
			
			String[] o = null, next = null;
			String clientid = client.getClientId().toString();
			o = GameSaleDispatcher.playCouponByWeb(clientid, "MOBILE"+ip, gameId, juego, multiDraws, price, null, gameType);
			double availableBalance = 0;
			String[] arr = null;
			String messageResult=o[0]!=null?o[0].toString():"";
			
			if (!messageResult.trim().equals("")) {
				MailingForSale mailingForSale = new MailingForSale();
	        	
	            availableBalance = Double.parseDouble(o[3]);
	            client.setBalanceAmount(availableBalance);
	            session.setAttribute(Constantes.CLIENT_SESION,client);
	               
	            if(o[5]!=null && o[5].length()>0) arr = o[5].split("\\|");
	            next = beanGanadiarioBetBo.findGanadiarioNextDraw();
	            if (messageResult.equals("OK") && arr != null && arr[1] != null && arr[5] != null ) {
	                int send = mailingForSale.sendGanadiarioSubscription(client.getMail(), arr[5].toLowerCase(), arr[0], arr[3], arr[4], arr[11], arr[1].trim().replaceAll(" ", " - "), next[0], "S/ "+next[1]);
	                LoggerApi.Log.info(send + " CORREO ENVIADO");
	            }
	        }
			
			/**
			 * Falta limpiar el boleto, controlar los mensaje de error y la redireccion
			 */
			if(messageResult.equals("OK")) {
				session.removeAttribute(typeboleto);
				if(!gameType.equals("SUS_AZAR")) session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())-1);
				session.setAttribute("alertPlay2","Gracias por tu compra");
				objectModelMap.put("alertPlay","Suscripción Ganadiario realizado con &eacute;xito!");
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","ok");
				objectModelMap.put("newamount",intralotUtils.formatCurrency(availableBalance));
				session.setAttribute("saldo", intralotUtils.formatCurrency(availableBalance));
				try {
					objectModelMap.put("numCombo",ganadiarioSuscripcion.getDraws());
					objectModelMap.put("ticketIdCombo",o[1]);
					objectModelMap.put("precioCombo",ganadiarioSuscripcion.getDiscountPayment());
					objectModelMap.put("sorteosCombo",ganadiarioSuscripcion.getJugadas());
					objectModelMap.put("tipoJugadaCombo",gameType);
					if(gameType.equalsIgnoreCase("SUS_IGUAL")) {
						objectModelMap.put("bolillasCombo",ganadiarioSuscripcion.getBolillas().size());
					}else {
						objectModelMap.put("bolillasCombo",5);
					}
				} catch (Exception e) {		}
			
			} else if(StringUtils.contains(messageResult,"autoexclusión")) {
				objectModelMap.put("alertPlay","Limite autoexclusion activado");
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","error");
			} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
				objectModelMap.put("alertPlay","No se ha encontrado el registro del cliente");
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","error");
			} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
				
				objectModelMap.put("alertPlay","No cuenta con saldo disponible para realizar este proceso");
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","saldo");
			} else {
				objectModelMap.put("game","ganadiario");
				objectModelMap.put("status","error");
				objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente  ");
			}		
			
			LoggerApi.Log.info("-------------- END game_ganadiario_play_bet_result_suscription");
			return new ModelAndView(modelview);
		}
}



