package pe.com.intralot.loto.layer.view.game.kabala;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import pe.com.intralot.loto.layer.controller.client.bo.ParameterBo;
import pe.com.intralot.loto.layer.controller.game.kabala.bo.KabalaBetBo;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.KabalaChChSale;
import pe.com.intralot.loto.card.setup.MailingForSale;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.Kabala;
import pe.com.intralot.loto.sale.card.dispatcher.GameSaleDispatcher;
import pe.com.intralot.loto.layer.model.pojo.KabalaSale;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.DateAPI;
import pe.com.intralot.loto.lib.Utils;
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
public class KabalaBetController {

    //static final Log logger = LogFactory.getLog(KabalaBetController.class);
    @Autowired
    private KabalaBetBo beanKabalaBetBo;
    @Autowired
    private IntralotUtils intralotUtils;    
    @Autowired
	private ParameterBo beanParameterBo;
    
    private boolean evaluateKabalaSession(HttpSession session, String typeBoleto) {
		boolean kbBoleto=false;
		
		if(session.getAttribute(typeBoleto)!=null) {
			Kabala kabalaRegular = (Kabala) session.getAttribute(typeBoleto);
			if(kabalaRegular.getBoleto()==null) kbBoleto=true;
			else if (kabalaRegular.getBoleto().isEmpty()) kbBoleto=true;
		} else kbBoleto=true;
		
		return kbBoleto;
	}
	
	private void generateKabala(HttpSession session,KabalaSale KabalaSale,boolean trigger, String typeBoleto,Integer typeKabala) {
		if(trigger) {
			Kabala kabala=  new Kabala(KabalaSale, typeKabala);
			session.setAttribute(typeBoleto, kabala);
		}
	}
	
	private void updateKabalaSession(HttpSession session, KabalaSale kabalaSale) {
		
		boolean kbREG=false,kbS12=false,kbS36=false,kbS72=false,kbS144=false;
		
		kbREG = evaluateKabalaSession(session,Constantes.BoletoKabala.boletoKabalaRegular);
		kbS12 = evaluateKabalaSession(session,Constantes.BoletoKabala.boletoKabalaSuscripcion12);
		kbS36 = evaluateKabalaSession(session,Constantes.BoletoKabala.boletoKabalaSuscripcion36);
		kbS72 = evaluateKabalaSession(session,Constantes.BoletoKabala.boletoKabalaSuscripcion72);
		kbS144 = evaluateKabalaSession(session,Constantes.BoletoKabala.boletoKabalaSuscripcion144);
		generateKabala(session,kabalaSale,kbREG,Constantes.BoletoKabala.boletoKabalaRegular,1);
		generateKabala(session,kabalaSale,kbS12,Constantes.BoletoKabala.boletoKabalaSuscripcion12,12);
		generateKabala(session,kabalaSale,kbS36,Constantes.BoletoKabala.boletoKabalaSuscripcion36,36);
		generateKabala(session,kabalaSale,kbS72,Constantes.BoletoKabala.boletoKabalaSuscripcion72,72);
		generateKabala(session,kabalaSale,kbS144,Constantes.BoletoKabala.boletoKabalaSuscripcion144,144);
	}
    
	private String getTypeBoleto(String boleto) {
		if(boleto.endsWith("144")) {
			return Constantes.BoletoKabala.boletoKabalaSuscripcion144;
		}
		else if(boleto.endsWith("72")) {
			return Constantes.BoletoKabala.boletoKabalaSuscripcion72;
		}
		else if(boleto.endsWith("36")) {
			return Constantes.BoletoKabala.boletoKabalaSuscripcion36;
		}
		else if(boleto.endsWith("12")) {
			return Constantes.BoletoKabala.boletoKabalaSuscripcion12;
		} else if (boleto.endsWith("a") || boleto.endsWith("b") || boleto.endsWith("c") || boleto.endsWith("d")) {
			return Constantes.BoletoKabala.boletoKabalaRegular;
		} else {
			return "";
		}
	}
	
	private Integer validarCantidadJugadas(Map<String, List<String>> playList,Map<String, Map<String,List<String>>> game, String typePlayKabala) {
		
		Integer totalJugadasNew = 0;
		Integer totalJugadasBoleto = 0;
		
		if(playList!=null) totalJugadasNew = getTotalJugadas(playList);		
		LoggerApi.Log.info("/validarCantidadJugadas typePlayKabala="+typePlayKabala);
		if(typePlayKabala!="") game.remove(typePlayKabala);
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
		BigInteger base = new BigInteger("720");
		if(cantidad<6) return new BigInteger("0");
		return (factorial(cantidad)).divide(((factorial(cantidad-6)).multiply(base)));
	}
	
	private static BigInteger factorial(Integer cantidad) {
		BigInteger biCantidad = new BigInteger(String.valueOf(cantidad));
		
		if (cantidad < 0) return new BigInteger("0"); 
		else if (cantidad > 1) return factorial(cantidad - 1).multiply(biCantidad);
		else return new BigInteger("1");
	}
	
private Double getCostoTotalRegularBet(Kabala kabala, Long consecutive) {
		
		Double costoTotalBet=0.00;
		
		Integer totalBet = kabala.getJugadasActuales();
		String algorithm = kabala.getPromotionAlgorithm();
		Double simpleBetPrice = kabala.getRegularPayment();
		int bets = kabala.getPromotionBets();
	    int pay = kabala.getPromotionPay();
	    Double cost = kabala.getPromotionCost();
	    int draw = kabala.getPromotionDraws();
	    
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
	
    @RequestMapping("/game_kabala_show_menu")
    public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	int clientId = 0;
    	KabalaSale kabalaSale = new KabalaSale();
    	String user = "";
    	String rpage = "game/kabala/interface-home-preprod";
    	try {
            LoggerApi.Log.info("");
            HttpSession session = request.getSession();				
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;			
            Draw draw = beanKabalaBetBo.getDrawsKabala01();
            if (draw != null) {
                draw.setResult(draw.getResult().replace(" ", " - "));
                draw.setDrAddonResult2(draw.getDrAddonResult2().replace(" ", " - "));
                objectModelMap.put("headerResult", draw);
                draw = beanKabalaBetBo.getDrawsKabala02();
                if (draw.getJackpot() != null)
                    objectModelMap.put("pozoMillonario", intralotUtils.formatCurrency2(draw.getJackpot()));
                else
                    objectModelMap.put("pozoMillonario", intralotUtils.formatCurrency2(0));
            }
            draw = beanKabalaBetBo.getDataCloseDateGame();
            if (draw != null) {
                objectModelMap.put("closeDrawId", draw.getDrwid());//getDrawPk().getDrawId());
                objectModelMap.put("closeDraw", draw.getCloseHour() + ":" + draw.getCloseMinute());
//                objectModelMap.put("closeDate", draw.getCloseDate());
//                objectModelMap.put("closeDate1", draw.getCloseDate1());
            }
            //System.out.println("kabalaPlusEnabled="+Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"))+" kabalaChauChambaEnabled="+Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB")));
        	objectModelMap.put("plusEnabled", Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB")));
        	objectModelMap.put("chauchambaEnabled", Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB")));
        	
        	kabalaSale = beanKabalaBetBo.findKabalaBetData(clientId);
        	kabalaSale = intralotUtils.getdataKB(kabalaSale);
			objectModelMap.mergeAttributes(kabalaSale.toMap());
			updateKabalaSession(session,kabalaSale);
        	/*
			if(clientId != 0) {
				Client client = AccountController.getClientByClientId( String.valueOf(clientId) );
				user = client.getUser();
				LoggerApi.Log.info("kabala user: "+user);
				if( beanKabalaBetBo.isSubscriptionAllowedGoIn(user) ){
					rpage = "game/kabala/interface-home";
				}
			}
			*/
			/*Asigna tiempo formato epoch al entrar al home*/
			String time = String.valueOf(new java.util.Date().getTime());
			request.setAttribute("nowEpochKabala", time);
			String isKabalaSubscription=Constantes.isKabalaSubscription;
			request.setAttribute("isKabalaSubscription", isKabalaSubscription);
			/*fin*/
			
            return new ModelAndView("game/kabala/interface-home");
			//return new ModelAndView(rpage);
        } catch (NullPointerException e) {
			return new ModelAndView(rpage);
		} catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView(rpage);
        } finally {
            //LoggerApi.Log.info("Salir al metodo: showMenu. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir al action: KabalaBetController.");
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
	@RequestMapping("/game_kabala_show_shoppingcart_suscripcion")	
	public ModelAndView showShoppingCartSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
	
		LoggerApi.Log.info("-------------- START game_kabala_show_shoppingcart_suscripcion");
		try {
	
			HttpSession session = request.getSession();
			session.setAttribute("tipoKabala", "suscripcion");
			String boleto="";
			if(request.getParameter("boleto")!=null) {
				boleto = request.getParameter("boleto").toString();
			} else if (session.getAttribute(Constantes.Boleto.typeBoleto)!=null) boleto = (String) session.getAttribute(Constantes.Boleto.typeBoleto);
			
			session.setAttribute("tipoBoletoSuscripcion", boleto);
			
			if(boleto.trim().equals("")) return new ModelAndView("redirect:game_kabala_show_menu.html");
			
			String typeboleto=getTypeBoleto(boleto);
			
			Kabala kabalaSuscripcion = !typeboleto.equals("")?(Kabala) session.getAttribute(typeboleto):null;
			
			Integer totalbets = 0 ;
			
			if(kabalaSuscripcion!=null) {
				totalbets = validarCantidadJugadas(null,kabalaSuscripcion.getGame(),StringUtils.EMPTY);//getTotalBetFromJugadaTinka(typeboleto,session);
			}
			
			String indicadorPurchase = (totalbets>5005 || totalbets==0)?"no":"yes";
				
			if(totalbets>5005){
	    		objectModelMap.put("alertNumberPlayKabala","El numero de jugadas excede lo permitido (5005) !");
	    		return new ModelAndView("game/kabala/interface-shoppingcart-suscripcion");
			} else {
	    		
	    		if(kabalaSuscripcion!=null) {
	    			Double payment = kabalaSuscripcion.getPricePerPlay()*totalbets*kabalaSuscripcion.getDraws();
	    			Double regularPayment = kabalaSuscripcion.getRegularPricePerPlay()*totalbets*kabalaSuscripcion.getDraws();
		    		kabalaSuscripcion.setDiscountPayment(payment);
		    		kabalaSuscripcion.setJugadas(totalbets*kabalaSuscripcion.getDraws());
		    		kabalaSuscripcion.setRegularPayment(regularPayment);
		    		LoggerApi.Log.info("/game_kabala_show_shoppingcart_suscripcion boleto="+kabalaSuscripcion.getBoleto());
		    		LoggerApi.Log.info("/game_kabala_show_shoppingcart_suscripcion boleto="+kabalaSuscripcion.getTicket());
		    		session.setAttribute(typeboleto, kabalaSuscripcion);	    		
		    		objectModelMap.mergeAttributes(kabalaSuscripcion.toMap());
		    		objectModelMap.mergeAttributes(kabalaSuscripcion.sendBoleto());
		    		LoggerApi.Log.info("/game_kabala_show_shoppingcart_suscripcion indicadorPurchase="+indicadorPurchase);
		    		objectModelMap.put("indicadorPurchase",indicadorPurchase);
		    		//objectModelMap.put("ind_tk",indicadorPurchase);//ind_tk);
		    		objectModelMap.put("negacion","no");
					objectModelMap.put("afirmacion","yes");
					return new ModelAndView("game/kabala/interface-shoppingcart-suscripcion");
	    		} 
	    	}	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/kabala/interface-shoppingcart-suscripcion");
		} finally {
			LoggerApi.Log.info("-------------- END game_kabala_show_shoppingcart_suscripcion"); 
		}
		return new ModelAndView("game/kabala/interface-shoppingcart-suscripcion");
	}

    @SuppressWarnings("rawtypes")
    @RequestMapping("/game_kabala_show_shoppingcart")
    public ModelAndView showShoppingCart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	int clientId = 0;
        try {
        	String precioJugada2="";
        	LoggerApi.Log.info("-------------- START game_kabala_show_shoppingcart");
            HttpSession session = request.getSession();
            session.setAttribute("tipoKabala", "simple");
            Map consecutiveMap = (Map) session.getAttribute("consecutiveKabalaValue_KB");
            Long consecutive = Long.valueOf(1);
            if (MapUtils.isNotEmpty(consecutiveMap))
                consecutive = Long.valueOf(((Map) session.getAttribute("consecutiveKabalaValue_KB")).get("NUM_DRAW").toString());
            
			String typeboleto =Constantes.BoletoKabala.boletoKabalaRegular;
			
			Kabala kabalaRegular = !typeboleto.equals("")?(Kabala) session.getAttribute(typeboleto):null;
			
//			double discountPayment=kabalaRegular.getDiscountPayment();
			
			if(kabalaRegular!=null && kabalaRegular.getJugadasActuales()!=null){ 
				
				Double totalPay = getCostoTotalRegularBet(kabalaRegular,consecutive);
	            
				kabalaRegular.setDiscountPayment(totalPay);
			    LoggerApi.Log.info("/game_kabala_show_shoppingcart boleto="+kabalaRegular.getBoleto());
			    session.setAttribute(typeboleto, kabalaRegular);
	           
		    	session.setAttribute("totalGanadiarioSession",Double.valueOf(totalPay));
		    	
		    	objectModelMap.mergeAttributes(kabalaRegular.toMap());
		    	objectModelMap.mergeAttributes(kabalaRegular.sendBoleto());
		    	//doble botón
                objectModelMap.put("negacion", "no");
                objectModelMap.put("afirmacion", "yes");
                objectModelMap.put("ind_kb", "no");
		    	Map map = kabalaRegular.getBoleto();		    	
				
	            Double costoBoletoAdicionales = 0.0;
	            int totalBet = 0,  maxTotalBet = 0;
	            String cad_tk = "";
	            String ind_kb = "";
	            boolean kabalaPlusEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"));
	            boolean kabalaChauChambaEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB"));
	        	if(map.size()>0) {
	        		int ind_plus = 0, ind_chauchamba = 0, cantin_1 = 0, cantin_2 = 0, cantin_3 = 0, cantin_4 = 0, j1_plus = 0, j2_plus = 0, j3_plus = 0, j4_plus = 0, j1_chauchamba = 0, j2_chauchamba = 0, j3_chauchamba = 0, j4_chauchamba = 0;
					for(Iterator it = map.keySet().iterator();it.hasNext();) {
	                    String mapa = (String) it.next();
	                    Map maping = (Map) map.get(mapa);
	                    int countPlay = 0;
	                    switch (((List) maping.get("kabala")).size()) {
	                        case 6:
	                            countPlay++;
	                            break;
	                        case 7:
	                            countPlay += 7;
	                            break;
	                        case 8:
	                            countPlay += 28;
	                            break;
	                        case 9:
	                            countPlay += 84;
	                            break;
	                        case 10:
	                            countPlay += 210;
	                            break;
	                        case 11:
	                            countPlay += 462;
	                            break;
	                        case 12:
	                            countPlay += 924;
	                            break;
	                        case 13:
	                            countPlay += 1716;
	                            break;
	                        case 14:
	                            countPlay += 3003;
	                            break;
	                        case 15:
	                            countPlay += 5005;
	                            break;
	                        default:
	                            countPlay += 0;
	                            break;
	                    }
	                    if (CollectionUtils.isNotEmpty((List) maping.get("kabala"))) {
	                        cad_tk = cad_tk + (String) ((Map)kabalaRegular.getLastJugada()).get("kabala_cad");//maping.get("kabala_cad");
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
	                                if (car_1 < 6)
	                                    indicador_1 = "no";
	                                cade_1 = "";
	                            }
	                            inicial_1++;
	                            siguiente_1++;
	                        }
	                        ind_kb = indicador_1;
	                        //System.out.println("0ind_kb="+ind_kb+" 0car_1="+car_1+" 0inicial_1="+inicial_1+" 0siguiente_1="+siguiente_1);
	                        if(mapa.endsWith("a")) cantin_1 = countPlay;
	                        if(mapa.endsWith("b")) cantin_2 = countPlay;
	                        if(mapa.endsWith("c")) cantin_3 = countPlay;
	                        if(mapa.endsWith("d")) cantin_4 = countPlay;
	                    }
	                    if (CollectionUtils.isEmpty((List) maping.get("kabala"))) {
	                        cad_tk = cad_tk + "0-";
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
	                                if (car_1 < 6)
	                                    indicador_1 = "no";
	                                cade_1 = "";
	                            }
	                            inicial_1++;
	                            siguiente_1++;
	                        }
	                        ind_kb = indicador_1;
	                        //System.out.println("1ind_kb="+ind_kb+" 1car_1="+car_1+" 1inicial_1="+inicial_1+" 1siguiente_1="+siguiente_1);
	                    }
	                    if (CollectionUtils.isNotEmpty((List) maping.get("plus"))) {
	                        costoBoletoAdicionales += countPlay * 0.5;
	                        ind_plus += countPlay;
	                        if(mapa.endsWith("a")) j1_plus = 1;
	                        if(mapa.endsWith("b")) j2_plus = 1;
	                        if(mapa.endsWith("c")) j3_plus = 1;
	                        if(mapa.endsWith("d")) j4_plus = 1;
	                    }
	                    if (CollectionUtils.isNotEmpty((List) maping.get("chau_chamba"))) {
	                        costoBoletoAdicionales += countPlay * 1.0;
	                        ind_chauchamba += countPlay;
	                        if(mapa.endsWith("a")) j1_chauchamba = 1;
	                        if(mapa.endsWith("b")) j2_chauchamba = 1;
	                        if(mapa.endsWith("c")) j3_chauchamba = 1;
	                        if(mapa.endsWith("d")) j4_chauchamba = 1;
	                    }
	                    totalBet += countPlay;
	                }
	                /*****/
	                int total = 0, total_plus = 0, total_plusJ1 = 0,total_plusJ2 = 0, total_plusJ3 = 0, total_plusJ4 = 0, total_chauchamba = 0, total_chauchambaJ1 = 0, total_chauchambaJ2 = 0, total_chauchambaJ3 = 0, total_chauchambaJ4 = 0;
	                String plus = " KB P+", chauChamba = " KB CC", plus_text = "", chauchamba_text = "";
	                //System.out.println("j1_plus="+j1_plus+" j2_plus="+j2_plus+" j3_plus="+j3_plus+" j4_plus="+j4_plus+" j1_chauchamba="+j1_chauchamba+" j2_chauchamba="+j2_chauchamba+" j3_chauchamba="+j3_chauchamba+" j4_chauchamba="+j4_chauchamba);
	                //System.out.println("cantin_1="+cantin_1+" cantin_2="+cantin_2+" cantin_3="+cantin_3+" cantin_4="+cantin_4);
	                if (j1_plus==1 && cantin_1 > 0) {
	                    total_plusJ1 = cantin_1;// * 1;
	                    //add_onsJ1 = "AD1";
	                }
	                if (j2_plus==1 && cantin_2 > 0) {
	                    total_plusJ2 = cantin_2;// * 1;
	                    //add_onsJ2 = "AD1";
	                }
	                if (j3_plus==1 && cantin_3 > 0) {
	                    total_plusJ3 = cantin_3;// * 1;
	                    //add_onsJ3 = "AD1";
	                }
	                if (j4_plus==1 && cantin_4 > 0) {
	                    total_plusJ4 = cantin_4;// * 1;
	                    //add_onsJ4 = "AD1";
	                }
	                if (j1_chauchamba==1 && cantin_1 > 0) {
	                    total_chauchambaJ1 = cantin_1;// * 1;
	                    //add_oncJ1 = "AD2";
	                }
	                if (j2_chauchamba==1 && cantin_2 > 0) {
	                    total_chauchambaJ2 = cantin_2;// * 1;
	                    //add_oncJ2 = "AD2";
	                }
	                if (j3_chauchamba==1 && cantin_3 > 0) {
	                    total_chauchambaJ3 = cantin_3;// * 1;
	                    //add_oncJ3 = "AD2";
	                }
	                if (j4_chauchamba==1 && cantin_4 > 0) {
	                    total_chauchambaJ4 = cantin_4;// * 1;
	                    //add_oncJ4 = "AD2";
	                }
	                total = cantin_1 + cantin_2 + cantin_3 + cantin_4;
	                total_plus = total_plusJ1 + total_plusJ2 + total_plusJ3 + total_plusJ4;
	                total_chauchamba = total_chauchambaJ1 + total_chauchambaJ2 + total_chauchambaJ3 + total_chauchambaJ4;
	                /* total_plus = total_chauchamba + total_plus */
	                if(total_plus>0) plus_text = " + " + total_plus + plus;
	                if(total_chauchamba>0) chauchamba_text = " + " + total_chauchamba + chauChamba;
	                clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
	                /****/
				   	KabalaSale kabalaSale = new KabalaSale();
				   	if(!kabalaPlusEnabled && kabalaChauChambaEnabled){ 
				   		KabalaChChSale kabalaChChSale = beanKabalaBetBo.findKabalaBetDataChCh(clientId);
				   		kabalaSale.setStatus(kabalaChChSale.getStatus());
				   		kabalaSale.setMessage(kabalaChChSale.getMessage());
				   		kabalaSale.setPrize(kabalaChChSale.getPrize());
				   		kabalaSale.setPrizeExtra(kabalaChChSale.getPrizeExtra());
				   		kabalaSale.setActiveDraw(kabalaChChSale.getActiveDraw());
				   		kabalaSale.setCloseDate(kabalaChChSale.getCloseDate());
				   		kabalaSale.setCloseHour(kabalaChChSale.getCloseHour());
				   		kabalaSale.setNextDraw(kabalaChChSale.getNextDraw());
				   		kabalaSale.setOpenDate(kabalaChChSale.getOpenDate());
				   		kabalaSale.setOpenHour(kabalaChChSale.getOpenHour());
				   		kabalaSale.setNumbersMore(kabalaChChSale.getNumbersMore());
				   		kabalaSale.setNumbersLess(kabalaChChSale.getNumbersLess());
				   		kabalaSale.setPriceType(kabalaChChSale.getPriceType());
				   		kabalaSale.setPriceMessage(kabalaChChSale.getPriceMessage());
				   		kabalaSale.setSimpleBetPrice(kabalaChChSale.getSimpleBetPrice());
				   		kabalaSale.setPrevBetPrice(kabalaChChSale.getPrevBetPrice());
				   		kabalaSale.setPromotionType(kabalaChChSale.getPromotionType());
				   		kabalaSale.setAlgorithm(kabalaChChSale.getAlgorithm());
				   		kabalaSale.setBets(kabalaChChSale.getBets());
				   		kabalaSale.setPay(kabalaChChSale.getPay());
				   		kabalaSale.setDraws(kabalaChChSale.getDraws());
				   		kabalaSale.setCost(kabalaChChSale.getCost());
				   		kabalaSale.setBalanceAmount(kabalaChChSale.getBalanceAmount());
				   		kabalaSale.setBalanceAmountGame(kabalaChChSale.getBalanceAmountGame());
				   		kabalaSale.setBalanceQuantityGame(kabalaChChSale.getBalanceQuantityGame());
				   		kabalaSale.setOtherAmount(kabalaChChSale.getOtherAmount());
				   	}else kabalaSale = beanKabalaBetBo.findKabalaBetData(clientId);
				   	
				    int fullTotal = 0;
//				    if(!kabalaPlusEnabled && kabalaChauChambaEnabled) fullTotal =  totalBet + ind_chauchamba;
				    if(!kabalaPlusEnabled && kabalaChauChambaEnabled) fullTotal =  totalBet;
				    else fullTotal = totalBet + ind_plus + ind_chauchamba*2;
				    
				    String algorithm = kabalaSale.getAlgorithm();
				    Double simpleBetPrice = kabalaSale.getSimpleBetPrice();
				    Double prevBetPrice = kabalaSale.getPrevBetPrice();
				    int bets = kabalaSale.getBets().intValue();
				    int pay = kabalaSale.getPay().intValue();
				    Double cost = kabalaSale.getCost();
				    int draw = kabalaSale.getDraws().intValue();
				    String priceMessage = kabalaSale.getPriceMessage();
				    String precioJugada = intralotUtils.formatCurrency(kabalaSale.getSimpleBetPrice());
				    Double amountGame = kabalaSale.getBalanceAmountGame();
				    Integer quantityGame = kabalaSale.getBalanceQuantityGame();
				    
				    Double costoTotalBet=null;
				    if (algorithm==null) algorithm="";
				    
		            if (algorithm.equals("BETS")) {
		                costoTotalBet = callTransformByBets(fullTotal, consecutive, simpleBetPrice, bets, pay, ind_chauchamba);
		            } else {
		                if (algorithm.equals("COST")) { 
		                    costoTotalBet = callTransformByCost(fullTotal, consecutive, simpleBetPrice, bets, cost, ind_chauchamba);
		                } else {
		                    if (algorithm.equals("DRAW")) { 
		                        costoTotalBet = callTransformByDraws(fullTotal, consecutive, simpleBetPrice, draw, pay, ind_chauchamba);
		                    } else {
		                    	if (algorithm.equals("DESC")) {
		                            costoTotalBet = callTransformDESC(fullTotal, consecutive, simpleBetPrice, pay, cost, ind_chauchamba)[0];
		                        } else {
			                        	if (algorithm.startsWith("ESC")) {
				                            costoTotalBet = callTransformESC(algorithm, fullTotal, consecutive, simpleBetPrice, ind_chauchamba)[0];
				                        } else {
				                            costoTotalBet = ( simpleBetPrice * fullTotal ) * consecutive;
				                            costoTotalBet = costoTotalBet+( 1 * ind_chauchamba ) * consecutive;
				                        }
			                        
		                        }
		                    }
		                }
		            }  
					
	                totalPay = costoTotalBet; // (0.5 * totalBet + (ind_plus + ind_chauchamba)) * consecutive;
	                //System.out.println("totalPay="+totalPay+" costoTotalBet="+costoTotalBet+" fullTotal="+fullTotal+" totalBet="+totalBet);
	                if(!kabalaPlusEnabled && kabalaChauChambaEnabled) maxTotalBet = 6006;
	                else maxTotalBet = 1386;
	                //if (totalBet > 1386)
	                if(totalBet > maxTotalBet) objectModelMap.put("alertNumberPlay_KB", "El numero de jugadas excede lo permitido ("+maxTotalBet+") !");
	                session.setAttribute("totalkabalaSession_KB", Double.valueOf(totalPay));
	                objectModelMap.put("totalkabala_KB", intralotUtils.formatCurrency((Double) session.getAttribute("totalkabalaSession_KB")));
	                objectModelMap.put("totalkabalamonto_KB", totalPay);
	                objectModelMap.put("totalBet_KB", total+" KB"+plus_text+chauchamba_text);//totalBet);
	                session.setAttribute("totalBet_KB", total+" KB"+plus_text+chauchamba_text);
	                objectModelMap.put("jugadasActuales", total);
	                objectModelMap.put("formatPricePerPlay2", simpleBetPrice);
	                objectModelMap.put("consecutive",consecutive);
	                objectModelMap.put("negacion", "no");
	                objectModelMap.put("afirmacion", "yes");
	                objectModelMap.put("ind_kb", ind_kb);
	                objectModelMap.put("ind_plus", ind_plus);
	                objectModelMap.put("totalPlus", (!kabalaPlusEnabled && kabalaChauChambaEnabled)?intralotUtils.formatCurrency(prevBetPrice):ind_plus);
	                objectModelMap.put("ind_chauchamba", ind_chauchamba);
	                objectModelMap.put("totalChauChamba", (!kabalaPlusEnabled && kabalaChauChambaEnabled)?intralotUtils.formatCurrency(simpleBetPrice):ind_chauchamba);
	                objectModelMap.put("priceMessage", priceMessage);
	                objectModelMap.put("precioJugada",precioJugada);
	                precioJugada2=precioJugada;
	                objectModelMap.put("amountGame_KB",amountGame);
	                objectModelMap.put("quantityGame_KB",quantityGame);
	                objectModelMap.put("amountGameint_KB",amountGame.intValue());
	                objectModelMap.put("quantityGameint_KB",quantityGame.intValue());
	                objectModelMap.put("totalkabalamontoint_KB", totalPay.intValue());
	                LoggerApi.Log.info(">>> totalBet: " + totalBet);
	                LoggerApi.Log.info(">>> totalPay: " + totalPay);
	                LoggerApi.Log.info(">>> consecutive: " + consecutive);
	                LoggerApi.Log.info(">>> ind_plus: " + ind_plus);
	                LoggerApi.Log.info(">>> ind_chauchamba: " + ind_chauchamba);
	                //start capturar precios por jugada(a,b,c,d)
	                String operation=session.getAttribute("operation").toString();
	                Map <String, Double> precios_detalle= new HashMap<String, Double>();
	                double precioK=(simpleBetPrice * totalBet ) * consecutive;
           		 	double precioCC=(simpleBetPrice * ind_chauchamba ) * consecutive;
	                if(operation.equals("add")) {
	                	if(map.size()==1) {	  
	                		precios_detalle.put("precioK", precioK);
	                		precios_detalle.put("precioCC", precioCC);
	                		objectModelMap.put("lastPriceK", precioK);
	                		objectModelMap.put("lastPriceCC", precioCC);
	                	}else {
	                		precios_detalle= (Map)session.getAttribute("precios_jugadas_kb");
	                		
	                		objectModelMap.put("lastPriceK", precioK-precios_detalle.get("precioK"));
	                		objectModelMap.put("lastPriceCC", precioCC-precios_detalle.get("precioCC"));
	                		
	                		precios_detalle.put("precioK", precioK);
	                		precios_detalle.put("precioCC", precioCC);
	                	}
	                	objectModelMap.put("operation", operation);
	                	session.setAttribute("precios_jugadas_kb",precios_detalle);
	                	session.setAttribute("ultima_jugada","default");
	                }
	                if(operation.equals("delete")) {
	                	precios_detalle=(Map)session.getAttribute("precios_jugadas_kb");	                	
	                	
	                	objectModelMap.put("priceJuegoDelete", precios_detalle.get("precioK")-precioK);
	                	objectModelMap.put("priceJuegoDeleteCC", precios_detalle.get("precioCC")-precioCC);
	                	
	                	precios_detalle.put("precioK", precioK);
                		precios_detalle.put("precioCC", precioCC);
	                	
	                	objectModelMap.put("operation", operation);
                		session.setAttribute("precios_jugadas_kb",precios_detalle);
	                }
					if (operation.equals("consecutive")) {
						precios_detalle = (Map) session.getAttribute("precios_jugadas_kb");

						objectModelMap.put("lastPriceK", precioK - precios_detalle.get("precioK"));
						objectModelMap.put("lastPriceCC", precioCC - precios_detalle.get("precioCC"));

						precios_detalle.put("precioK", precioK);
						precios_detalle.put("precioCC", precioCC);
						objectModelMap.put("operation", operation);
						session.setAttribute("precios_jugadas_kb", precios_detalle);
						session.setAttribute("ultima_jugada", "default");
					}
					 if(operation.equals("removeConsecutive")) {	                	
	                	precios_detalle=(Map)session.getAttribute("precios_jugadas_kb");	                	
	                	                
	                	objectModelMap.put("priceJuegoDelete", precios_detalle.get("precioK")-total);
	                	objectModelMap.put("priceJuegoDeleteCC", precios_detalle.get("precioCC")-total_chauchamba);
	                	
	                	precios_detalle.put("precioK", precioK);
                		precios_detalle.put("precioCC", precioCC);
	                	
	                	objectModelMap.put("operation", operation);	                	
                		session.setAttribute("precios_jugadas_kb",precios_detalle);	                		                	
	                }
	                
					objectModelMap.put("priceK", precioK);
             		objectModelMap.put("priceCC", precioCC);
	                session.setAttribute("operation", "default");
	                session.setAttribute("jugada_gratis_kb", quantityGame);
	                
	              //end capturar precios 
	            }else {
	            	KabalaSale kabalaSale = new KabalaSale();
				   	if(!kabalaPlusEnabled && kabalaChauChambaEnabled){ 
				   		KabalaChChSale kabalaChChSale = beanKabalaBetBo.findKabalaBetDataChCh(clientId);
				   		kabalaSale.setBalanceQuantityGame(kabalaChChSale.getBalanceQuantityGame());
				   	}else kabalaSale = beanKabalaBetBo.findKabalaBetData(clientId);
				   	
				   	Integer quantityGame = kabalaSale.getBalanceQuantityGame();
				   	objectModelMap.put("quantityGameint_KB",quantityGame.intValue());
				   	
				   	//----------------
				   	String operation=session.getAttribute("operation").toString();
	                if(operation.equals("delete")) {
	                	Map <String, Double> precios_detalle=(Map)session.getAttribute("precios_jugadas_kb");
	                	objectModelMap.put("priceJuegoDelete", precios_detalle.get("precioK"));
	                	objectModelMap.put("priceJuegoDeleteCC", precios_detalle.get("precioCC"));	
	                	objectModelMap.put("operation", operation);	                	
                		session.removeAttribute("precios_jugadas_kb");	     
	                }
	                if(operation.equals("consecutive")) {
	                	objectModelMap.put("operation", "default");
	                }
	                if(operation.equals("removeConsecutive")) {
	                	objectModelMap.put("operation", "default");
	                }
	                //--------------------
	            }
	        	
	        	
	            LoggerApi.Log.info(">>> totalkabalaSession_KB: " + session.getAttribute("totalkabalaSession_KB").toString());
	            
	            Double flagKb = (beanParameterBo.findParameterById(Constantes.C_KB) == null) ? 0 : beanParameterBo.findParameterById(Constantes.C_KB).getNumber();
	            objectModelMap.put("flagConsecutivaKb",flagKb);
	            
	            return new ModelAndView("game/kabala/interface-shoppingcart");
        	}else return new ModelAndView("redirect:game_kabala_show_menu.html");     
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kabala/interface-shoppingcart");
        } finally {
		    LoggerApi.Log.info("-------------- END game_kabala_show_shoppingcart"); 
		}
    }
    
    @RequestMapping("/game_kabala_show_bet")
    public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        
    	LoggerApi.Log.info("-------------- START game_kabala_show_bet");
    	HttpSession session = request.getSession();
        boolean kabalaPlusEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"));
        boolean kabalaChauChambaEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB"));
        try {
            //LoggerApi.Log.info("");
            Map map = (Map) session.getAttribute("gameKabalaB");
            int totalBet = 0, ind_plus = 0, ind_chauchamba = 0;
            if (map != null) {
                //Iterator it = map.keySet().iterator();
                for(Iterator it = map.keySet().iterator();it.hasNext();) {
                    String mapa = (String) it.next();
                    Map maping = new HashMap();
                    if(mapa !=null && !mapa.trim().equals("")) maping = (Map) map.get(mapa);
                    List<String> lista1 = (List<String>) maping.get("kabala");
                    int countPlay = 0;
                    countPlay = (lista1.size()==6)?(countPlay+=1):(lista1.size()==7)?(countPlay+=7):(lista1.size()==8)?(countPlay+=28):(lista1.size()==9)?(countPlay+=84):(lista1.size()==10)?(countPlay+=210):
                    	(lista1.size()==11)?(countPlay+=462):(lista1.size()==12)?(countPlay+=924):(lista1.size()==13)?(countPlay+=1716):(lista1.size()==14)?(countPlay+=3003):(lista1.size()==15)?(countPlay+=5005):(countPlay+=0);
                    if(CollectionUtils.isNotEmpty((List) maping.get("plus"))) ind_plus += countPlay;
                    if(CollectionUtils.isNotEmpty((List) maping.get("chau_chamba"))) ind_chauchamba += countPlay;
                    totalBet += countPlay;
                }
			    if(!kabalaPlusEnabled && kabalaChauChambaEnabled) totalBet += ind_chauchamba;
			    else totalBet += ind_plus + ind_chauchamba*2;
            }
            String play = request.getParameter("play");
            LoggerApi.Log.info("/game_kabala_show_bet play="+play);
            
            String typeboleto=getTypeBoleto(play);
			 
			if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_kabala_show_menu.html");
			
			String cart = request.getParameter("cart")!=null?request.getParameter("cart").toString():"none";
			
			Kabala kabala = null;
			LoggerApi.Log.info("/game_kabala_show_bet typeboleto="+typeboleto);
			if(StringUtils.isNotEmpty(typeboleto)) kabala = (Kabala) session.getAttribute(typeboleto);
			
			session.setAttribute(Constantes.Boleto.typeBoleto, typeboleto);
			 if(kabala.getBoleto()!=null && !cart.equals("go")) {
				 if(typeboleto.endsWith("2")|| typeboleto.endsWith("6")|| typeboleto.endsWith("4")) return new ModelAndView("redirect:game_kabala_show_shoppingcart_suscripcion.html");
				 else if (typeboleto.equals(Constantes.BoletoKabala.boletoKabalaRegular)) return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
			 }
			 
			LoggerApi.Log.info("/game_kabala_show_bet kabala="+kabala.toString());
			
			if(kabala!=null)  objectModelMap.mergeAttributes(kabala.toMap());
			 String jugada = (kabala!=null && kabala.getTypeKabala()!= null && kabala.getTypeKabala().equals("REG"))? play : (kabala!=null && kabala.getDraws()!= null)?kabala.getDraws().toString():"";
			 session.setAttribute(Constantes.Boleto.idBoleto,"jugada_".concat(jugada));
			 
            session.setAttribute("typePlayKabala_KB", "jugada_".concat(play));
            objectModelMap.put("typePlay", play.toUpperCase());
            objectModelMap.put("plusBoolean", kabalaPlusEnabled);
            objectModelMap.put("chauchambaBoolean", kabalaChauChambaEnabled);
            objectModelMap.put("totalBet", totalBet);
            LoggerApi.Log.info("/game_kabala_show_bet typePlayKabala_KB="+session.getAttribute("typePlayKabala_KB"));
            LoggerApi.Log.info("/game_kabala_show_bet "+Constantes.Boleto.idBoleto+"="+session.getAttribute(Constantes.Boleto.idBoleto));
            //System.out.println("kabalaPlusEnabled="+kabalaPlusEnabled+" kabalaChauChambaEnabled="+kabalaChauChambaEnabled);
            if(kabala!=null && kabala.getTypeKabala().equals("REG")) {
            	if(!kabalaPlusEnabled && kabalaChauChambaEnabled) {
	            	if (StringUtils.equals((String) session.getAttribute("mobile_pointing"), Constantes.MOBILE_TOUCHSCREEN))
		                return new ModelAndView("game/kabala/interface-bet-touchscreen_chch");
	            		//return new ModelAndView("game/kabala/interface-bet-clickwheel_chch");
		            else
		                return new ModelAndView("game/kabala/interface-bet-clickwheel_chch");
	            } else {
		            if (StringUtils.equals((String) session.getAttribute("mobile_pointing"), Constantes.MOBILE_TOUCHSCREEN))
		                return new ModelAndView("game/kabala/interface-bet-touchscreen");
		            else
		                return new ModelAndView("game/kabala/interface-bet-clickwheel");
	            }
            }else {
            	
            	return new ModelAndView("game/kabala/interface-suscripcion-type");
            	
            }	
        } catch (Exception e) {
            LoggerApi.severe(e);
            if(!kabalaPlusEnabled && kabalaChauChambaEnabled) {
            	if (StringUtils.equals((String) session.getAttribute("mobile_pointing"), Constantes.MOBILE_TOUCHSCREEN))
	                return new ModelAndView("game/kabala/interface-bet-touchscreen_chch");
	            else
	                return new ModelAndView("game/kabala/interface-bet-clickwheel_chch");
            } else {
	            if (StringUtils.equals((String) session.getAttribute("mobile_pointing"), Constantes.MOBILE_TOUCHSCREEN))
	                return new ModelAndView("game/kabala/interface-bet-touchscreen");
	            else
	                return new ModelAndView("game/kabalaa/interface-bet-clickwheel");
            }
        } finally {
			LoggerApi.Log.info("/game_kabala_show_bet typeBoleto="+((session!=null && session.getAttribute("typeBoleto")!=null)?session.getAttribute("typeBoleto").toString():"null"));
		    LoggerApi.Log.info("-------------- END game_kabala_show_bet"); 
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
	@RequestMapping("/game_kabala_show_bet_suscripcion")
	public ModelAndView showBetSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		LoggerApi.Log.info("-------------- START game_kabala_show_bet_suscripcion");
		HttpSession session = request.getSession();
		
		String boleto = request.getParameter("boleto").toString();
		
		if(request.getParameter("boleto")!=null) {
			boleto = request.getParameter("boleto").toString();
		} else return new ModelAndView("redirect:game_kabala_show_menu.html");
		//request.getParameter("boleto").toString();
		if(StringUtils.isEmpty(boleto)) return new ModelAndView("redirect:game_kabala_show_menu.html");
		
		String typeboleto=getTypeBoleto(boleto);
		
		if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_kabala_show_menu.html");
		session.setAttribute("typeBoletoTemp", typeboleto);
		Kabala kabalaSuscripcion = (Kabala) session.getAttribute(typeboleto);
		if(kabalaSuscripcion == null) return new ModelAndView("redirect:game_kabala_show_menu.html");		
		kabalaSuscripcion.setTypePlay("SUS_IGUAL");
		objectModelMap.mergeAttributes(kabalaSuscripcion.toMap());

		LoggerApi.Log.info("-------------- END game_kabala_show_bet_suscripcion");
		return new ModelAndView("game/kabala/interface-bet-suscripcion");		
	}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/game_kabala_add_bet")
    public ModelAndView addBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("-------------- START game_kabala_add_bet");
            Map game = new HashMap();
            Map<String,String> cantidadBolillas = new LinkedHashMap();
            Map<String,List<String>> playList = new HashMap();
            List playKabalaList = new ArrayList();
            List playPlusList = new ArrayList();
            List playChauChambaList = new ArrayList();
            String cad_ult = "";
            String cad_t = "", cad_ult_t = "";
            boolean kabalaPlusEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"));
            boolean kabalaChauChambaEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB"));
            if (!ObjectUtils.isEmpty(request.getParameterValues("kb")))
                for (Object object : request.getParameterValues("kb")) {
                	System.out.println("kb="+object.toString());
                    playKabalaList.add(object.toString());
                }
            if (!ObjectUtils.isEmpty(request.getParameterValues("plus")))
                for (Object object : request.getParameterValues("plus")) {
                	System.out.println("plus="+object.toString());
                    playPlusList.add(object.toString());
                }
            if (!ObjectUtils.isEmpty(request.getParameterValues("chau_chamba")))
                for (Object object : request.getParameterValues("chau_chamba")) {
                	System.out.println("chau_chamba="+object.toString());
                    playChauChambaList.add(object.toString());
                }
            if (CollectionUtils.isNotEmpty(playKabalaList)) {
                playList.put("kabala", playKabalaList);
                cad_t = String.valueOf(playKabalaList.size());
                cad_ult_t = cad_ult_t + cad_t + "-";
                ///playList.put("kabala_cad", cad_ult_t);
                cantidadBolillas.put("kabala_cad",cad_ult_t);
                LoggerApi.Log.info("/game_kabala_add_bet kabala_cad="+cad_ult_t);
            }
            if (CollectionUtils.isEmpty(playKabalaList)) {
                playList.put("kabala", playKabalaList);
                cad_t = "0";
                cad_ult_t = cad_ult_t + cad_t + "-";
                ///playList.put("kabala_cad", cad_ult_t);
                cantidadBolillas.put("kabala_cad",cad_ult_t);
                LoggerApi.Log.info("/game_kabala_add_bet tinka_cad="+cad_ult_t);
            }
            playList.put("plus", playPlusList);
            playList.put("chau_chamba", playChauChambaList);
            String adicionalesGame = "";
            HttpSession session = request.getSession();
            if(playPlusList.size() == 0 && playChauChambaList.size() > 0){
            	for (Object item : playChauChambaList) {
                	//System.out.println("playchauChambaList="+item);
                    if (((String) item).equals("Chau Chamba"))
                        adicionalesGame = "4";
                }
            } else {
	            for (Object item : playPlusList)
	                if (((String) item).equals("Plus+"))
	                    adicionalesGame = "1";
	            for (Object item : playChauChambaList)
	                if (((String) item).equals("Chau Chamba"))
	                    adicionalesGame = "1 2";
            }
            session.setAttribute("adicionalesKabala", adicionalesGame);
            String tipoBoleto = "";
            if (MapUtils.isNotEmpty(playList)) {                
            	tipoBoleto = (session!=null && session.getAttribute(Constantes.Boleto.typeBoleto)!=null)?session.getAttribute(Constantes.Boleto.typeBoleto).toString():"";             	
            	
            	Integer jugadasBet = getTotalJugadas(playList);
            	LoggerApi.Log.info("/game_kabala_add_bet jugadasBet="+jugadasBet);
            	if(jugadasBet>5005 || jugadasBet==0 ) {
					LoggerApi.Log.info("/game_kabala_add_bet jugadasBet="+jugadasBet);
					if(jugadasBet>5005) session.setAttribute("kabalaOvercomeJugadas", 1);
					if(tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaRegular)) 
						if(!kabalaPlusEnabled && kabalaChauChambaEnabled) 
							return new ModelAndView("game/kabala/interface-bet-touchscreen_chch");
						else
							return new ModelAndView("game/kabala/interface-bet-touchscreen");
				 	else if(tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion12) ||
				 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion36) ||
				 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion72) ||
				 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion144)) 
				 		return new ModelAndView("game/kabala/interface-bet-suscripcion");
				} else {
					session.setAttribute("kabalaOvercomeJugadas", 0);
				}
				/*obtiene tipo de kabala en cuestión*/
            	
            	Kabala kabala = new Kabala();
				kabala = (Kabala) session.getAttribute(tipoBoleto);
				
				Double precioPorJugada=0.0;
				int canti=playChauChambaList.size();
				
				if(canti== 1&& jugadasBet==7) {
					jugadasBet=2;
					precioPorJugada=jugadasBet*kabala.getRegularPayment();
				}
				
				else {
					if(canti==1) {
						precioPorJugada=(jugadasBet*kabala.getRegularPayment())/2;
					}
					else {
						precioPorJugada=jugadasBet*kabala.getRegularPayment();
					}
					
				}
					
				
				LoggerApi.Log.info("precioPorJugada--->"+precioPorJugada);
				
				LoggerApi.Log.info("/game_kabala_add_bet tipoBoleto="+tipoBoleto);
				
				/*obtiene el boleto en caso exista en session segun el tipo de juego*/
				if(MapUtils.isNotEmpty(kabala.getGame())) game = kabala.getGame();
				
				String typePlayKabala = (String) session.getAttribute(Constantes.Boleto.idBoleto);
				session.setAttribute("ultima_jugada", typePlayKabala);
				Integer totalJugadaBoleto = validarCantidadJugadas(playList,game,typePlayKabala);
				LoggerApi.Log.info("/game_kabala_add_bet totalJugadaBoleto="+totalJugadaBoleto);
				if(totalJugadaBoleto>5005 || totalJugadaBoleto==0) {
					LoggerApi.Log.info("/game_kabala_add_bet totalJugadaBoleto="+totalJugadaBoleto);
					if(jugadasBet>5005) session.setAttribute("kabalaOvercomeJugadas", 1);
					if(tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaRegular)) { 
						if(!kabalaPlusEnabled && kabalaChauChambaEnabled) 
							return new ModelAndView("game/kabala/interface-bet-touchscreen_chch");
						else
							return new ModelAndView("game/kabala/interface-bet-touchscreen");
						
					}	
				 	else if(tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion12) ||
				 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion36) ||
				 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion72) ||
				 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion144)) 
				 		return new ModelAndView("game/kabala/interface-bet-suscripcion");
					 
				} else {
					session.setAttribute("kabalaOvercomeJugadas", 0);
				}
				
				kabala.setJugadasActuales(totalJugadaBoleto);
				kabala.setJugadasLimite(5005-totalJugadaBoleto);
				game.put(typePlayKabala,playList);
				LoggerApi.Log.info("/game_kabala_add_bet game="+game);
				LoggerApi.Log.info("/game_kabala_add_bet new TreeMap(game)="+new TreeMap(game));
				kabala.setGame(game);
				kabala.setBolillas(playKabalaList);
				kabala.setBoleto(new TreeMap(game));
				kabala.setLastJugada(cantidadBolillas);
				session.setAttribute(tipoBoleto, kabala);
				
				String tipo = kabala.getTypeKabala().equals("REG")? "" : kabala.getDraws().toString();
				
				/*Esto puede ser reemplazado por tinka, testear cpn el boleto*/
				session.setAttribute("jugada"+tipo, playList);
	            session.setAttribute("jugada_kb"+tipo, playKabalaList);
	            session.setAttribute("cadi"+tipo, cad_t);
				
				LoggerApi.Log.info("/game_kabala_add_bet "+tipoBoleto+"="+new TreeMap(game));
				LoggerApi.Log.info("/game_kabala_add_bet game="+game);
				
				           	
            	
            	if(MapUtils.isNotEmpty((Map) session.getAttribute("gameKabalaB"))) game = (Map)session.getAttribute("gameKabalaB");
				session.setAttribute("gameKabalaB", new TreeMap(game));
                session.setAttribute("jugada", playList);
                session.setAttribute("jugada_kb", playKabalaList);
                session.setAttribute("cadi", cad_ult);
                session.setAttribute("precioPorJugada", precioPorJugada);
                session.removeAttribute("typePlayKabala_KB");
                IntralotUtils.carItemUpdate(session);
                
                LoggerApi.Log.info("/game_kabala_add_bet jugada="+playList +" jugada_kb="+playKabalaList+" lastJugada="+playList+" cadi="+cad_t+" cantidadBolillas="+cantidadBolillas);
	            session.setAttribute("lastJugada", cantidadBolillas);
	            session.setAttribute("valorRemo", "");
	            session.setAttribute("consecutiveParam", "");
	            
	            session.removeAttribute(Constantes.Boleto.idBoleto);
                
            }
            session.setAttribute("operation", "add");
            
            
            String redireccion = "";
		 	if(tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaRegular)) 
		 		redireccion = "redirect:game_kabala_show_shoppingcart.html";
		 	else if(tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion12) ||
		 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion36) ||
		 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion72) ||
		 			tipoBoleto.equals(Constantes.BoletoKabala.boletoKabalaSuscripcion144)) 
		 		redireccion="redirect:game_kabala_show_shoppingcart_suscripcion.html";

		 	return new ModelAndView(redireccion);
            
            //return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } finally {
			LoggerApi.Log.info("-------------- END game_kabala_add_bet"); 
		}
    }

    @SuppressWarnings({ "rawtypes" })
    @RequestMapping("/game_kabala_delete_bet")
    public ModelAndView deleteBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
        	LoggerApi.Log.info("-------------- START game_kabala_delete_bet");
            HttpSession session = request.getSession();
            Map game1 = (Map) session.getAttribute("gameKabalaB");
            if (MapUtils.isNotEmpty((Map) game1.get(request.getParameter("id")))) {
                game1.remove(request.getParameter("id"));
                LoggerApi.Log.info("deleteBet key="+request.getParameter("id"));
                session.setAttribute("gameKabalaB", game1);
                IntralotUtils.carItemUpdate(session);
                if (MapUtils.isEmpty(game1)) {
                    session.removeAttribute("consecutiveKabala_KB");
                    session.removeAttribute("consecutiveKabalaValue_KB");
                }
            }
            //return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
            String id = "";
			if(request.getParameter("id")!=null) {
				id = request.getParameter("id").toString();
			} else return new ModelAndView("redirect:game_kabala_show_menu.html");
			
			LoggerApi.Log.info("/game_kabala_delete_bet id="+id);
			Map boleto = null;
		
			//String identifier = id.endsWith("")
			String typeboleto=getTypeBoleto(id);
			if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_kabala_show_menu.html");
			
			LoggerApi.Log.info("/game_kabala_delete_bet typeboleto="+typeboleto);
			if(StringUtils.isNotEmpty(typeboleto)) {
				Kabala kabala = (Kabala) session.getAttribute(typeboleto);
//				double precioCuesta= kabala.getAmountGame();
				
				boleto=kabala.getBoleto();	
				String chauu="";
				
				if(id.equals("jugada_a")) {
					System.out.println("boleto.get(id).toString()-->"+boleto.get(id));
					
					 chauu=	boleto.get(id).toString();	
				
				}
				else if(id.equals("jugada_b")) {
					 chauu=	boleto.get(id).toString();					
								}
				else if(id.equals("jugada_c")) {
					 chauu=	boleto.get(id).toString();	
				}
				else if(id.equals("jugada_d")) {
					 chauu=	boleto.get(id).toString();	
				}
			
				
				
				
				
				
				
				
				/**
				 * Aqui falta testearlo por el id
				 */
			   if(boleto!=null && MapUtils.isNotEmpty((Map) boleto.get(id))){
				   boleto.remove(id);
				   Map<String,Map<String,List<String>>> game = kabala.getGame();
				   game.remove(id);
				   Integer totalJugadas = validarCantidadJugadas(null,game,StringUtils.EMPTY);
				   LoggerApi.Log.info("/game_kabala_delete_bet game="+game);
				   kabala.setGame(game);
				   kabala.setJugadasActuales(totalJugadas);
				   kabala.setJugadasLimite(5005-totalJugadas);
				   LoggerApi.Log.info("/game_kabala_delete_bet totalJugadas="+totalJugadas);
				   LoggerApi.Log.info("/game_kabala_delete_bet boleto="+boleto);
				   //if(evaluateTinkaSession(session,typeboleto))
				   
				   
				   LoggerApi.Log.info("kabala.getDiscountPayment()---->"+kabala.getDiscountPayment());
				   
				   LoggerApi.Log.info("preciooo---->"+totalJugadas*kabala.getRegularPayment());
				
				   Double valorRemo=0.0;
				   
				   Boolean contenidBoleto=false;
					contenidBoleto=chauu.contains("Chau Chamba");
					
					valorRemo=kabala.getDiscountPayment()-totalJugadas;
				
				   
				   
				   LoggerApi.Log.info("valorRemo---->"+valorRemo);
				   
				   
				   kabala.setBoleto(new TreeMap(boleto));
				   
				   //session.setAttribute("precioDesc", totalJugadas * kabala.getRegularPayment());
				   session.setAttribute(typeboleto,kabala);
				   session.setAttribute("precioPorJugada", "");
				   session.setAttribute("valorRemo",valorRemo);
				   
				   if(typeboleto.equals(Constantes.BoletoKabala.boletoKabalaRegular)) {
					   if(MapUtils.isEmpty(boleto)){
						   session.removeAttribute("consecutiveKabala_KB");
						   session.removeAttribute("consecutiveKabalaValue_KB");
					   }
				   }   
			   }
			   			   
			}
			IntralotUtils.carItemUpdate(session);
			session.setAttribute("operation", "delete");
			session.setAttribute("ultima_jugada", id);
		 if(typeboleto.equals(Constantes.BoletoKabala.boletoKabalaRegular)) {
			 return new ModelAndView("redirect:game_kabala_show_shoppingcart.html"); 
		 } else {
			 return new ModelAndView("redirect:game_kabala_show_menu.html");
		 }
		 
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } finally{
			LoggerApi.Log.info("-------------- END game_kabala_delete_bet"); 
		}
    }

    @RequestMapping("/game_kabala_show_consecutive")
    public ModelAndView showConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_kabala_show_consecutive"); 
        
    	try {
        	HttpSession session = request.getSession();
            boolean kabalaPlusEnabled = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB").trim()).booleanValue();
        	boolean kabalaChauChambaEnabled = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB").trim()).booleanValue();
        	HashMap[] numberConsecutive = beanKabalaBetBo.getNumberConsecutive();
        	//System.out.println("consecutiveKabalaList_KB="+((HashMap[]) session.getAttribute("consecutiveKabalaList_KB")).length+" numberConsecutive="+numberConsecutive.length);
            //if (ObjectUtils.isEmpty((HashMap[]) session.getAttribute("consecutiveKabalaList_KB")) || ((HashMap[]) session.getAttribute("consecutiveKabalaList_KB")).length!=numberConsecutive.length){
            	//session.setAttribute("consecutiveKabalaList_KB", beanKabalaBetBo.getNumberConsecutive());
            	if(kabalaPlusEnabled && kabalaChauChambaEnabled){
            		for(int i=0; i<numberConsecutive.length; i++) {
            			//System.out.println("NUM_DRAW="+numberConsecutive[i].get("NUM_DRAW").toString().trim());
                		if(Integer.parseInt(numberConsecutive[i].get("NUM_DRAW").toString().trim()) == 1) {
                			HashMap consecutive = numberConsecutive[i];
                			numberConsecutive = new HashMap[1];
                			numberConsecutive[0] = consecutive;
                			break;
                		}
                	}
            	}
            	session.setAttribute("consecutiveKabalaList_KB", numberConsecutive);
            	
            //}
            return new ModelAndView("game/kabala/interface-consecutive");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kabala/interface-consecutive");
        } finally {
        	LoggerApi.Log.info("-------------- END game_kabala_show_consecutive"); 
        }
    }

    @RequestMapping("/game_kabala_delete_consecutive")
    public ModelAndView deleteConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("-------------- START game_kabala_delete_consecutive");
            HttpSession session = request.getSession();
            session.removeAttribute("consecutiveKabala_KB");
            session.removeAttribute("consecutiveKabalaValue_KB");
            session.setAttribute("operation","removeConsecutive");
            return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } finally {
        	LoggerApi.Log.info("-------------- END game_tinka_kabala_consecutive");
        }
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("/game_kabala_add_consecutive")
    public ModelAndView addConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("-------------- START game_kabala_add_consecutive");
            String consecutiveParam = "";
            if (request != null) {
                if (request.getParameterValues("consecutive") != null)
                    consecutiveParam = request.getParameterValues("consecutive")[0];
                HttpSession session = request.getSession();
                session.setAttribute("consecutiveKabala_KB", ((consecutiveParam!=null)?consecutiveParam.trim():""));
                session.setAttribute("operation","consecutive");
                session.setAttribute("ultima_jugada", consecutiveParam);
                HashMap[] consecutive = (HashMap[]) session.getAttribute("consecutiveKabalaList_KB");
                if (consecutive != null)
                    for (HashMap item : consecutive)
                        if (StringUtils.equals(String.valueOf(item.get("NUM_DRAW")), consecutiveParam)) {
                            session.setAttribute("consecutiveKabalaValue_KB", item);
                            session.setAttribute("consecutiveParam", consecutiveParam);
                            break;
                        }
            }
            return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:game_kabala_show_shoppingcart.html");
        } finally {
        	LoggerApi.Log.info("-------------- END game_kabala_add_consecutive"); 
        }
    }

    @SuppressWarnings({ "rawtypes", "static-access" })
    @RequestMapping("/game_kabala_play_bet")
    public ModelAndView playBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        try {
            LoggerApi.Log.info("");
            Map map = (Map) session.getAttribute("gameKabalaB");
            if (MapUtils.isNotEmpty(map)) {
                Game game = new Game();
                game.setGame(Game.KABALA);
                GroupAPI[] group = new GroupAPI[map.size()];
                int count = 0;
                /*Iterator it = map.keySet().iterator();
                while (it.hasNext()) {*/
                if(map.size()>0) {
					for(Iterator it = map.keySet().iterator();it.hasNext();) {
	                    String mapa = (String) it.next();
	                    Map maping = (Map) map.get(mapa);
	                    List playKabalaList = (List) maping.get("kabala");
	                    List playPlusList = (List) maping.get("plus");
	                    List playchauChambaList = (List) maping.get("chau_chamba");
	                    int[] numbers = new int[playKabalaList.size()];
	                    int tinkaCount = 0;
	                    String adicionalesGame = "";
	                    for (Object item : playKabalaList) {
	                    	//System.out.println("playKabalaList="+item);
	                        numbers[tinkaCount] = Integer.valueOf((String) item);
	                        tinkaCount++;
	                    }
	                    if(playPlusList.size() == 0 && playchauChambaList.size() > 0){
	                    	for (Object item : playchauChambaList) {
		                    	//System.out.println("playchauChambaList="+item);
		                        if (((String) item).equals("Chau Chamba"))
		                            adicionalesGame = "4";
		                    }
	                    } else {
		                    for (Object item : playPlusList){
		                    	//System.out.println("playPlusList="+item);
		                        if (((String) item).equals("Plus+"))
		                            adicionalesGame = "1";
		                    }
		                    for (Object item : playchauChambaList) {
		                    	//System.out.println("playchauChambaList="+item);
		                        if (((String) item).equals("Chau Chamba"))
		                            adicionalesGame = "1 2";
		                    }
	                    }
	                    group[count] = new GroupAPI();
	                    group[count].setLottoBetNewLotos5(Game.KABALA, Group.NORMAL, numbers, adicionalesGame);
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
                web.setMessageId("W" + d.getTimeLong() + Game.KABALA);
                web.setCarrier("MOBILE");
                String messageResult = StringUtils.EMPTY;
                int numbersConsecutive = 1;
                if (MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveKabalaValue_KB")))
                    numbersConsecutive = Integer.valueOf(((Map) session.getAttribute("consecutiveKabalaValue_KB")).get("NUM_DRAW").toString());
                double priceSale = 0.0;
                if (session.getAttribute("totalKabalaSession_KB") != null)
                    priceSale = (Double) session.getAttribute("totalKabalaSession_KB");
                ClientTicket ct = new ClientTicket();
                ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
                if (ct.getMessage() != null)
                    messageResult = ct.getMessage();
                
                LoggerApi.Log.info("/game_kabala_play_bet messageResult="+messageResult);
                if (messageResult.equals("OK")) {
                	session.removeAttribute("consecutiveKabala_KB");
                    session.removeAttribute("consecutiveKabalaValue_KB");
                    session.removeAttribute("totalKabalaSession_KB");
                    session.removeAttribute("gameKabalaB");
                    IntralotUtils.carItemUpdate(session);
                    session.setAttribute("alertPlay", "&iexcl;Jugada realizada con &eacute;xito!");
                    session.setAttribute("alertPlay2", "Gracias por tu compra");
                    return new ModelAndView("redirect:client_play_show_information.html?game=kabala&status=ok");
                } else if (StringUtils.contains(messageResult, "CLIENTE NO EXISTE")) {
                    session.setAttribute("alertPlay", "No se ha encontrado el registro del cliente");
                    return new ModelAndView("redirect:client_play_show_information.html?game=kabala&status=error");
                } else if (StringUtils.contains(messageResult, "CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {
                    session.setAttribute("alertPlay", "No cuenta con saldo disponible para realizar este proceso");
                    return new ModelAndView("redirect:client_play_show_information.html?game=kabala&status=error");
                } else {
                    session.setAttribute("alertPlay", "Ocurrio un error intente nuevamente  ");
                    return new ModelAndView("redirect:client_play_show_information.html?game=kabala&status=error");
                }
            }
            return new ModelAndView("redirect:client_play_show_information.html?game=kabala&status=error");
        } catch (Exception e) {
            session.setAttribute("alertPlay", "Ocurrio un error intente nuevamente ");
            LoggerApi.severe(e);
            return new ModelAndView("redirect:client_play_show_information.html?game=kabala&status=error");
        } finally {
            //LoggerApi.Log.info("Salir al metodo: playBet. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir al action: KabalaController.");
        }
    }
    
    @SuppressWarnings({ "rawtypes", "static-access" })
    @RequestMapping("/game_kabala_play_bet_result")
    public ModelAndView playBetResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        HttpSession session = request.getSession();
        KabalaSale kabalaSale = new KabalaSale();
        try {
            LoggerApi.Log.info("-------------- START game_kabala_play_bet_result");
            boolean kabalaPlusEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaPlusEnabled", "CARD-WEB"));
            boolean kabalaChauChambaEnabled = Boolean.parseBoolean(ConnectionFactory.operationProperty("kabalaChauChambaEnabled", "CARD-WEB"));
            Map map = (Map) session.getAttribute("gameKabalaB");
            
            /////////////////
            Kabala kabala = session.getAttribute(Constantes.BoletoKabala.boletoKabalaRegular)!=null?(Kabala) session.getAttribute(Constantes.BoletoKabala.boletoKabalaRegular):null;
			if(kabala!=null){
				map=kabala.getBoleto();
			}
            ////////////////
			if(kabala!=null){
				String numBolJugadaA="";String numBolJugadaB="";String numBolJugadaC="";String numBolJugadaD="";
				String chauA="";String chauB="";String chauC="";String chauD="";
            if (MapUtils.isNotEmpty(map)) {
                Game game = new Game();
                game.setGame(Game.KABALA);
                GroupAPI[] group = new GroupAPI[map.size()];
                int count = 0;
                int columns = 0;
                boolean flagAddon=false;
                /*Iterator it = map.keySet().iterator();
                while (it.hasNext()) {*/
                if(MapUtils.isNotEmpty(map) && map.size()>0) {
					for(Iterator it = map.keySet().iterator();it.hasNext();) {
	                    String mapa = (String) it.next();
	                    Map maping = new HashMap();
	                    if(mapa !=null && !mapa.trim().equals("")) maping = (Map) map.get(mapa);
	                    //Map maping = (Map) map.get(mapa);
	                    List playKabalaList = (maping.get("kabala")!=null)?((List) maping.get("kabala")):new ArrayList();
	                    List playPlusList = (maping.get("plus")!=null)?((List) maping.get("plus")):new ArrayList();
	                    List playchauChambaList = (maping.get("chau_chamba")!=null)?((List) maping.get("chau_chamba")):new ArrayList();
	                    int[] numbers = new int[playKabalaList.size()];
	                    int tinkaCount = 0;
	                    String adicionalesGame = "";
	                    for (Object item : playKabalaList) {
	                    	numbers[tinkaCount] = Integer.valueOf((String) item);
	                        tinkaCount++;
	                    }
	                    if(mapa.equals("jugada_a")) {
							numBolJugadaA=tinkaCount+"";
							
						}
						else if(mapa.equals("jugada_b")) {
							numBolJugadaB=tinkaCount+"";
						}
						else if(mapa.equals("jugada_c")) {
							numBolJugadaC=tinkaCount+"";
						}
						else if(mapa.equals("jugada_d")) {
							numBolJugadaD=tinkaCount+"";
						}
	                    //total+" KB"+plus_text+chauchamba_text-->
	                    if(playPlusList.size() == 0 && playchauChambaList.size() > 0){
	                    	for (Object item : playchauChambaList) {
		                    	if (((String) item).equals("Chau Chamba")) {
		                            adicionalesGame = "4";
		                            flagAddon = true;
		                    	}
		                    }
	                    	 if(mapa.equals("jugada_a")) {
	 							chauA="Chau Chamba";
	 							//chauA="Chau Chamba"
	 						}
	 						else if(mapa.equals("jugada_b")) {
	 							chauB="Chau Chamba";
	 						}
	 						else if(mapa.equals("jugada_c")) {
	 						chauC="Chau Chamba";
	 						}
	 						else if(mapa.equals("jugada_d")) {
	 							chauD="Chau Chamba";
	 						}
	 	               
	                    } else {
		                    for (Object item : playPlusList){
		                    	if (((String) item).equals("Plus+"))
		                            adicionalesGame = "1";
		                    }
		                    for (Object item : playchauChambaList) {
		                    	if (((String) item).equals("Chau Chamba"))
		                            adicionalesGame = "1 2";
		                    }
	                    }
	                    group[count] = new GroupAPI();
	                    group[count].setLottoBetNewLotos5(Game.KABALA, Group.NORMAL, numbers, adicionalesGame);
	                    columns = (int) (columns + group[count].getColumns());
	                    count++;
	                }
                }
                String zip="";
				if(!flagAddon) {
					zip=request.getRemoteAddr().toString();
				}else {
					zip = request.getRemoteAddr().toString() +"[1]V[2]"+game.getGameNumber()+"[3]"+columns;	
				}
                AccountController accountController = new AccountController();
                Client client = accountController.getClientByClientId((String) session.getAttribute("clientId"));
                DateAPI d = new DateAPI();
                WEBMessage web = new WEBMessage();
                web.setClient(client);
                web.setIp(zip);
                web.setGame(game);
                web.setGroup(group);
                web.setMessageId("W" + d.getTimeLong() + Game.KABALA);
                web.setCarrier("MOBILE");
                String messageResult = StringUtils.EMPTY;
                int numbersConsecutive = 1;
                String consecu="";
                if (MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveKabalaValue_KB"))) {
                    numbersConsecutive = Integer.valueOf(((Map) session.getAttribute("consecutiveKabalaValue_KB")).get("NUM_DRAW").toString());
                	 consecu=numbersConsecutive+"";
                }
                double priceSale = 0.0;
                if (session.getAttribute("totalkabalaSession_KB") != null)
                    priceSale = (Double) session.getAttribute("totalkabalaSession_KB");
                
                KabalaChChSale kabalaChChSaleTemp = beanKabalaBetBo.findKabalaBetDataChCh(Integer.parseInt(client.getClientId()));
                kabalaSale.setBalanceQuantityGame(kabalaChChSaleTemp.getBalanceQuantityGame());
                
                ClientTicket ct = new ClientTicket();
                ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
                if(!kabalaPlusEnabled && kabalaChauChambaEnabled) {
			   		KabalaChChSale kabalaChChSale = beanKabalaBetBo.findKabalaBetDataChCh(Integer.parseInt(client.getClientId()));
			   		kabalaSale.setStatus(kabalaChChSale.getStatus());
			   		kabalaSale.setMessage(kabalaChChSale.getMessage());
			   		kabalaSale.setPrize(kabalaChChSale.getPrize());
			   		kabalaSale.setPrizeExtra(kabalaChChSale.getPrizeExtra());
			   		kabalaSale.setActiveDraw(kabalaChChSale.getActiveDraw());
			   		kabalaSale.setCloseDate(kabalaChChSale.getCloseDate());
			   		kabalaSale.setCloseHour(kabalaChChSale.getCloseHour());
			   		kabalaSale.setNextDraw(kabalaChChSale.getNextDraw());
			   		kabalaSale.setOpenDate(kabalaChChSale.getOpenDate());
			   		kabalaSale.setOpenHour(kabalaChChSale.getOpenHour());
			   		kabalaSale.setNumbersMore(kabalaChChSale.getNumbersMore());
			   		kabalaSale.setNumbersLess(kabalaChChSale.getNumbersLess());
			   		kabalaSale.setPriceType(kabalaChChSale.getPriceType());
			   		kabalaSale.setPriceMessage(kabalaChChSale.getPriceMessage());
			   		kabalaSale.setSimpleBetPrice(kabalaChChSale.getSimpleBetPrice());
			   		kabalaSale.setPrevBetPrice(kabalaChChSale.getPrevBetPrice());
			   		kabalaSale.setPromotionType(kabalaChChSale.getPromotionType());
			   		kabalaSale.setAlgorithm(kabalaChChSale.getAlgorithm());
			   		kabalaSale.setBets(kabalaChChSale.getBets());
			   		kabalaSale.setPay(kabalaChChSale.getPay());
			   		kabalaSale.setDraws(kabalaChChSale.getDraws());
			   		kabalaSale.setCost(kabalaChChSale.getCost());
			   		kabalaSale.setBalanceAmount(kabalaChChSale.getBalanceAmount());
			   		kabalaSale.setBalanceAmountGame(kabalaChChSale.getBalanceAmountGame());
//			   		kabalaSale.setBalanceQuantityGame(kabalaChChSale.getBalanceQuantityGame());
			   		kabalaSale.setOtherAmount(kabalaChChSale.getOtherAmount());
			   		kabalaSale.setOtherQuantity(kabalaChChSale.getOtherQuantity());
			   	} else {
			   		kabalaSale = beanKabalaBetBo.findKabalaBetData(Integer.parseInt(client.getClientId()));
			   	}
                if (ct.getMessage() != null)
                    messageResult = ct.getMessage();
                objectModelMap.put("SubZona","Juega Kábala");
                LoggerApi.Log.info("/game_kabala_play_bet_result messageResult="+messageResult);
                if (messageResult.equals("OK")) {
                	session.removeAttribute("consecutiveKabala_KB");
                    session.removeAttribute("consecutiveKabalaValue_KB");
                    session.removeAttribute("totalKabalaSession_KB");
                    session.removeAttribute("gameKabalaB");
                    session.removeAttribute(Constantes.BoletoKabala.boletoKabalaRegular);
                    IntralotUtils.carItemUpdate(session);
                    session.setAttribute("alertPlay2", "Gracias por tu compra");
                    objectModelMap.put("alertPlay", "&iexcl;Jugada realizada con &eacute;xito!");
                    objectModelMap.put("game","kabala");
        			objectModelMap.put("status","ok");
        			objectModelMap.put("newamount",intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
        			session.setAttribute("saldo", intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
        			objectModelMap.put("bonusOther",kabalaSale.getOtherQuantity());
        			//objectModelMap.put("bonusOther",intralotUtils.formatCurrency(Double.parseDouble(kabalaSale.getOtherAmount())));
        			//session.setAttribute("bonoOtro", intralotUtils.formatCurrency(Double.parseDouble(kabalaSale.getOtherAmount())));
        			session.setAttribute("ticketId", ct.getTicketId());
        			//envio de parametros
        			session.setAttribute("importeTotal", kabala.getDiscountPayment());
        			session.setAttribute("jugada_gratis_kb", kabalaSale.getBalanceQuantityGame());
        			//session.setAttribute("jugadasActuales", kabala.getJugadasActuales());
        			session.setAttribute("consecu", consecu);
        			
        			session.setAttribute("numBolJugadaA", numBolJugadaA);
        			session.setAttribute("numBolJugadaB", numBolJugadaB);
        			session.setAttribute("numBolJugadaC", numBolJugadaC);
        			session.setAttribute("numBolJugadaD", numBolJugadaD);
        			
        			session.setAttribute("chauA", chauA);
        			session.setAttribute("chauB", chauB);
        			session.setAttribute("chauC", chauC);
        			session.setAttribute("chauD", chauD);
        			
        			
        		    String valorIncrem="";
        			session.setAttribute("valorIncrem", valorIncrem);
        			session.setAttribute("bonoOtro", kabalaSale.getOtherQuantity());
        			String totalkabala_KB=session.getAttribute("totalkabalaSession_KB").toString();
        			objectModelMap.put("totalkabala_KB", totalkabala_KB);
        			session.removeAttribute("precios_jugadas_kb");
        			return new ModelAndView("game/kabala/interface-result_game");
                
                }else if (StringUtils.contains(messageResult, "autoexclusión")) {
                	objectModelMap.put("alertPlay", "Limite autoexclusion activado");
                    objectModelMap.put("game","kabala");
        			objectModelMap.put("status","error");
        			return new ModelAndView("game/kabala/interface-result_game");
                } else if (StringUtils.contains(messageResult, "CLIENTE NO EXISTE")) {
                    //session.setAttribute("alertPlay", "No se ha encontrado el registro del cliente");
                	objectModelMap.put("alertPlay", "No se ha encontrado el registro del cliente");
                    objectModelMap.put("game","kabala");
        			objectModelMap.put("status","error");
        			return new ModelAndView("game/kabala/interface-result_game");
                } else if (StringUtils.contains(messageResult, "CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {
                    //session.setAttribute("alertPlay", "No cuenta con saldo disponible para realizar este proceso");
                	objectModelMap.put("alertPlay", "No cuenta con saldo disponible para realizar este proceso");
                    objectModelMap.put("game","kabala");
        			objectModelMap.put("status","saldo");
        			return new ModelAndView("game/kabala/interface-result_game");
                } else {
                    //session.setAttribute("alertPlay", "Ocurrio un error intente nuevamente  ");
                	objectModelMap.put("alertPlay", "Ocurrio un error intente nuevamente  ");
                    objectModelMap.put("game","kabala");
        			objectModelMap.put("status","error");
        			return new ModelAndView("game/kabala/interface-result_game");
                }
            }
			}
            objectModelMap.put("game","kabala");
			objectModelMap.put("status","error");
			objectModelMap.put("alertPlay", "Ocurrio un error intente nuevamente ");
			return new ModelAndView("game/kabala/interface-result_game");
        } catch (Exception e) {
            //session.setAttribute("alertPlay", "Ocurrio un error intente nuevamente ");
        	objectModelMap.put("alertPlay", "Ocurrio un error intente nuevamente ");
            LoggerApi.severe(e);
            objectModelMap.put("game","kabala");
			objectModelMap.put("status","error");
			return new ModelAndView("game/kabala/interface-result_game");
        } finally {
        	LoggerApi.Log.info("-------------- END game_kabala_play_bet_result"); 
        }
    }
    
    /**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>PlayBetSuscription se encarga de realizar la transaccion de compra de kabala
	 * suscripcion, aun faltra implementar la parte de AZAR. Es posible combinar este método con la trassaccion de compra 
	 * de uno regular</p>
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping("/game_kabala_play_bet_result_suscription")	
	public ModelAndView playBetSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		/*
		 * Obtengo el boleto de la session e identifico la suscripcion
		 */
		/**
		 * Esta parte se repite en varias funciones, se puede refactorizar
		 */
		LoggerApi.Log.info("-------------- START game_kabala_play_bet_result_suscription"); 
		objectModelMap.put("tipoCompra","combo");
		objectModelMap.put("SubZona","Combos Kábala");
		objectModelMap.put("alertPlay","Error inesperado en el sistema");
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
		HttpSession session = request.getSession();
		
		String modelview = "game/kabala/interface-result_game";
		String boleto = "";
		
		if(request.getParameter("boleto")!=null) boleto = request.getParameter("boleto").toString();
		else if (session.getAttribute("carrierBoleto")!=null) {
			boleto = session.getAttribute("carrierBoleto").toString();
			session.removeAttribute("carrierBoleto");
		} else return new ModelAndView("redirect:game_kabala_show_menu.html");
		
		LoggerApi.Log.info("/game_kabala_play_bet_result_suscription boleto="+boleto);
		
		if(boleto.trim().equals("")) return new ModelAndView("redirect:game_kabala_show_menu.html");
		
		
		String typeboleto=getTypeBoleto(boleto);
		
		if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_kabala_show_menu.html");
		session.setAttribute("typeBoletoTemp", typeboleto);
		Kabala kabalaSuscripcion = null;

		kabalaSuscripcion = (Kabala) session.getAttribute(typeboleto);
		String juego = "";
		LoggerApi.Log.info("/game_kabala_play_bet_result_suscription typeboleto="+typeboleto);
		
		Integer multiDraws = 0;
		String gameType = "";
		Double price = 0.00;
		if(StringUtils.isNotEmpty(typeboleto)) {
			
			
		    multiDraws = kabalaSuscripcion.getDraws();
			gameType = kabalaSuscripcion.getTypePlay();//session.getAttribute("tinkaSuscripcionTipo")!=null?session.getAttribute("tinkaSuscripcionTipo").toString():"SUS_AZAR";
			price = kabalaSuscripcion.getDiscountPayment();
			
			if(gameType.equals("SUS_AZAR")) juego = "AZAR";
			else if(gameType.equals("SUS_IGUAL")) {
				for (String bolilla : kabalaSuscripcion.getBolillas()) {
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
		Integer gameId= Game.KABALA;
		
	    LoggerApi.Log.info("/game_kabala_play_bet_result_suscription juego="+juego+" multiDraws="+multiDraws+" gameType="+gameType+" price="+price+" client="+client+" ip="+ip+" gameId="+gameId);
		
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
            next = beanKabalaBetBo.findKabalaNextDraw();
            if (messageResult.equals("OK") && arr != null && arr[1] != null && arr[5]!= null) {
                int send = mailingForSale.sendKabalaSubscription(client.getMail(), arr[5].toLowerCase(), arr[0], arr[3], arr[4], arr[11], arr[1].trim().replaceAll(" ", " - "), next[0], "S/ "+next[1]);
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
			objectModelMap.put("alertPlay","Suscripción Kabala realizado con &eacute;xito!");
			objectModelMap.put("game","kabala");
			objectModelMap.put("status","ok");
			objectModelMap.put("newamount",intralotUtils.formatCurrency(availableBalance));
			session.setAttribute("saldo", intralotUtils.formatCurrency(availableBalance));
			try {
				objectModelMap.put("numCombo",kabalaSuscripcion.getDraws());
				objectModelMap.put("ticketIdCombo",o[1]);
				objectModelMap.put("precioCombo",kabalaSuscripcion.getDiscountPayment());
				objectModelMap.put("sorteosCombo",kabalaSuscripcion.getJugadas());
				objectModelMap.put("tipoJugadaCombo",gameType);
				if(gameType.equalsIgnoreCase("SUS_IGUAL")) {
					objectModelMap.put("bolillasCombo",kabalaSuscripcion.getBolillas().size());
				}else {
					objectModelMap.put("bolillasCombo",6);
				}
			} catch (Exception e) {		}
		
		} else if(StringUtils.contains(messageResult,"autoexclusion")) {
			objectModelMap.put("alertPlay","Limite autoexclusion activado");
			objectModelMap.put("game","kabala");
			objectModelMap.put("status","error");
		} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
			objectModelMap.put("alertPlay","No se ha encontrado el registro del cliente");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
		} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
			
			objectModelMap.put("alertPlay","No cuenta con saldo disponible para realizar este proceso");
			objectModelMap.put("game","kabala");
			objectModelMap.put("status","saldo");
		} else {
			objectModelMap.put("game","kabala");
			objectModelMap.put("status","error");
			objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente  ");
		}		
		
		LoggerApi.Log.info("-------------- END game_kabala_play_bet_result_suscription");
		return new ModelAndView(modelview);
	}
	
	@RequestMapping("/newsKabala")
	public ModelAndView news_form(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		return new ModelAndView("game/kabala/newsKabala");		
	}
	
	public static Double callTransformByDraws(int p_sum_total_bet, long p_number_consecutive, double p_data_value_bet, int p_draws, int p_pay, int ind_chauchamba) {
        double var_total_cost = 0;
        double var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = var_sum_total_bet_consecutive * p_data_value_bet;
        if (p_number_consecutive >= p_draws) {
        	var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(p_number_consecutive / p_draws) * (p_draws - p_pay) * p_data_value_bet));
        }
        return var_total_cost;
    }
	
	public static Double callTransformByBets(int p_sum_total_bet, long p_number_consecutive, double p_data_value_bet, int p_bets, int p_pay, int ind_chauchamba) {
    	double var_total_cost = 0;
    	double var_sum_total_bet_consecutive = 0;
    	double var_sum_total_bet_consecutive_cc = 0;
    	double p_data_value_bet_cc=1;
    	var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_sum_total_bet_consecutive_cc = (ind_chauchamba * p_number_consecutive);
        double var_sum_total=(var_sum_total_bet_consecutive * p_data_value_bet) + (var_sum_total_bet_consecutive_cc * p_data_value_bet_cc);
        double sum_total_bet=Math.floor((var_sum_total_bet_consecutive / p_bets)+((var_sum_total_bet_consecutive_cc*(p_data_value_bet_cc/p_data_value_bet)) / p_bets));
        var_total_cost = (var_sum_total - (sum_total_bet * (p_bets - p_pay) * p_data_value_bet)) ;
        
        return var_total_cost;
    }

    public static Double callTransformByCost(int p_sum_total_bet, long p_number_consecutive, double p_data_value_bet, int p_bets, double p_cost, int ind_chauchamba) {
    	double var_total_cost = 0;
    	double var_sum_total_bet_consecutive = 0;
    	double var_sum_total_bet_consecutive_cc = 0;
    	double p_data_value_bet_cc=1;
    	var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_sum_total_bet_consecutive_cc = (ind_chauchamba * p_number_consecutive);
        double var_sum_total=(var_sum_total_bet_consecutive * p_data_value_bet) + (var_sum_total_bet_consecutive_cc * p_data_value_bet_cc);
        double sum_total_bet=Math.floor((var_sum_total_bet_consecutive / p_bets)+((var_sum_total_bet_consecutive_cc*(p_data_value_bet_cc/p_data_value_bet)) / p_bets));
        var_total_cost = ((var_sum_total) - (sum_total_bet * (p_bets * p_data_value_bet - p_cost)));
        
        return var_total_cost;
    }

    public static Double[] callTransformDESC(int full_total, long sorteos, double v_data_value_bet, int pay, double cost, int ind_chauchamba) {
    	double costoTotalBet=0;
    	double costoTotalBetMensaje=0;
    	if ( full_total>0 ) {
    		if ( pay>0 ) {
    			if ( (v_data_value_bet * full_total * sorteos) >= pay ) {
                	costoTotalBet = ( v_data_value_bet * full_total * cost ) * sorteos;
                	costoTotalBetMensaje = ( v_data_value_bet * ( full_total + 1) * cost ) * sorteos;
        		} else {
                    costoTotalBet = ( v_data_value_bet * full_total ) * sorteos;
        			if ( v_data_value_bet * ( full_total + 1) >= pay ) {
                    	costoTotalBetMensaje = ( v_data_value_bet * ( full_total + 1) * cost ) * sorteos;
        			} else {
                    	costoTotalBetMensaje = ( v_data_value_bet * ( full_total + 1) ) * sorteos;	                    				
        			}
        		}
    		} else {
            	costoTotalBet = ( v_data_value_bet * full_total * cost ) * sorteos;
            	costoTotalBetMensaje = ( v_data_value_bet * ( full_total + 1) * cost ) * sorteos;
    		} 
    	}
		return new Double[]{costoTotalBet,costoTotalBetMensaje};
    }
    

    public static Double[] callTransformESC(String algorithm, int total, long sorteos, double p_data_value_bet, int ind_chauchamba) {
    	double costoTotalBet=0;
    	double costoTotalBetMensaje=0;
    	//ESC;4;7;10;3
    	if (total>0) {
    		String elem[] = algorithm.split(";");
           	int total_bet_consecutive = (int)(total * sorteos);
    		if ( total_bet_consecutive < (elem.length - 1) ) {
    			costoTotalBet = Double.parseDouble(elem[total_bet_consecutive]);	
    		} else {
    			costoTotalBet = Double.parseDouble(elem[elem.length - 1])*total_bet_consecutive;
    		}
           	if (total_bet_consecutive > 1) {
           	    costoTotalBetMensaje = costoTotalBet + 1;
           	} else {
           		costoTotalBetMensaje = costoTotalBet;
           	}
    	}
		return new Double[]{costoTotalBet,costoTotalBetMensaje};
    }
}
