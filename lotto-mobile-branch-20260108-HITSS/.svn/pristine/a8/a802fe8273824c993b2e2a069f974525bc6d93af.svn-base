package pe.com.intralot.loto.layer.view.game.tinka;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.jboss.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;							
import pe.com.intralot.loto.api.model.GroupAPI;
import pe.com.intralot.loto.card.setup.MailingForSale;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.controller.client.bo.ParameterBo;
import pe.com.intralot.loto.layer.controller.game.tinka.bo.TinkaBetBo;
import pe.com.intralot.loto.layer.model.bean.Jugada;
import pe.com.intralot.loto.layer.model.bean.Jugadas;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureRegisterPopupLottery;
import pe.com.intralot.loto.layer.model.pojo.Tinka;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;
import pe.com.intralot.loto.lib.ConnectionFactory;
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

/**
 * <p>
 * NOMBRE: TinkaBetController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Tinka
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Depuración de comentarios y validación de variables en sesión
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class TinkaBetController {

	@Autowired
	private TinkaBetBo beanTinkaBetBo;
	
	@Autowired
	private IntralotUtils intralotUtils;
	
	@Autowired
	private ParameterBo beanParameterBo;
	
	@Autowired
    private ClientSaleBo clientSaleBo;

	private boolean evaluateTinkaSession(HttpSession session, String typeBoleto) {
		boolean tkBoleto=false;
		
		if(session.getAttribute(typeBoleto)!=null) {
			Tinka tinkaRegular = (Tinka) session.getAttribute(typeBoleto);
			if(tinkaRegular.getBoleto()==null) tkBoleto=true;
			else if (tinkaRegular.getBoleto().isEmpty()) tkBoleto=true;
		} else tkBoleto=true;
		
		return tkBoleto;
	}
	
	private void generateTinka(HttpSession session,TinkaSale tinkaSale,boolean trigger, String typeBoleto,Integer typeTinka) {
		if(trigger) {
			Tinka tinka =  new Tinka(tinkaSale, typeTinka);
			session.setAttribute(typeBoleto, tinka);
		}
	}
	
	private void updateTinkaSession(HttpSession session, TinkaSale tinkaSale) {
		
		boolean tkREG=false,tkS08=false,tkS24=false,tkS48=false,tkS96=false;
		
		tkREG = evaluateTinkaSession(session,Constantes.BoletoTinka.boletoTinkaRegular);
		tkS08 = evaluateTinkaSession(session,Constantes.BoletoTinka.boletoTinkaSuscripcion8);
		tkS24 = evaluateTinkaSession(session,Constantes.BoletoTinka.boletoTinkaSuscripcion24);
		tkS48 = evaluateTinkaSession(session,Constantes.BoletoTinka.boletoTinkaSuscripcion48);
		tkS96 = evaluateTinkaSession(session,Constantes.BoletoTinka.boletoTinkaSuscripcion96);

		generateTinka(session,tinkaSale,tkREG,Constantes.BoletoTinka.boletoTinkaRegular,1);
		generateTinka(session,tinkaSale,tkS08,Constantes.BoletoTinka.boletoTinkaSuscripcion8,8);
		generateTinka(session,tinkaSale,tkS24,Constantes.BoletoTinka.boletoTinkaSuscripcion24,24);
		generateTinka(session,tinkaSale,tkS48,Constantes.BoletoTinka.boletoTinkaSuscripcion48,48);
		generateTinka(session,tinkaSale,tkS96,Constantes.BoletoTinka.boletoTinkaSuscripcion96,96);

	}
	
	@RequestMapping("/game_tinka_show_menu")	
	public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		LoggerApi.Log.info("-------------- START game_tinka_show_menu"); 
		int clientId = 0;
		TinkaSale tinkaSale = new TinkaSale();
		try {		   
			//LoggerApi.Log.info("");
			HttpSession session = request.getSession();	
			
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			tinkaSale = beanTinkaBetBo.findTinkaBetData(clientId);
			
			tinkaSale = intralotUtils.getdata(tinkaSale);
			objectModelMap.mergeAttributes(tinkaSale.toMap());
			
			
			updateTinkaSession(session,tinkaSale);
			
			String isTinkaSubscription=Constantes.isTinkaSubscription;
			request.setAttribute("isTinkaSubscription", isTinkaSubscription);
			request.setAttribute("tinkaSale", tinkaSale);
			LoggerApi.Log.info("-------------- END game_tinka_show_menu"); 
			return new ModelAndView("game/tinka/interface-home");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_tinka_show_menu"); 
			return new ModelAndView("game/tinka/interface-home");
		}
		
						
	}
	
	private Integer validarCantidadJugadas(Map<String, List<String>> playList,Map<String, Map<String,List<String>>> game, String typePlayTinka) {

		Integer totalJugadasNew = 0;
		Integer totalJugadasBoleto = 0;
		
		if(playList!=null) totalJugadasNew = getTotalJugadas(playList);		
		LoggerApi.Log.info("/validarCantidadJugadas typePlayTinka="+typePlayTinka);
		if(typePlayTinka!="") game.remove(typePlayTinka);
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
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Deprecated
	private Integer getTotalBetFromJugadaTinka(String boleto, HttpSession session) {
		Integer totalBet=0;
		
		if(session.getAttribute(boleto)!=null){
			Map map=((Tinka) session.getAttribute(boleto)).getBoleto();	

			if(map.size()>0) {
			for(Iterator it=map.keySet().iterator();it.hasNext();) {
					String mapa = (String)it.next();						
					Map maping =(Map) map.get(mapa);	
					
					int countPlay = 0;			
					
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

				totalBet +=countPlay;
			}
			}
		}

		return totalBet;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Deprecated
	private String getIndicadorPurchaseFromJugadaTinka(String boleto, HttpSession session) {
		String ind_tk="no";
		
		if(session.getAttribute(boleto)!=null){
			
			Map map=((Tinka) session.getAttribute(boleto)).getGame();

			if(map.size()>0) {
				for(Iterator it=map.keySet().iterator();it.hasNext();) {
					String mapa = (String)it.next();						
					Map maping =(Map) map.get(mapa);
			
					String cad_tk="";

					if(CollectionUtils.isNotEmpty((List) maping.get("tinka"))){
						
						cad_tk = cad_tk+((String) maping.get("tinka_cad"));
						LoggerApi.Log.info("/getIndicadorPurchaseFromJugadaTinka cade_1="+cad_tk);
				   	
						String sTexto_1 = cad_tk;
			            int car_1 = 0;
			            String cadenita_1 = "", cade_1 = "";
			            int inicial_1 = 0, siguiente_1 = 1;
			            String indicador_1 = "yes";
			
			            for (int x = 0; x < sTexto_1.length(); x++) {
			            	LoggerApi.Log.info("/getIndicadorPurchaseFromJugadaTinka sTexto_1="+sTexto_1);
			            	cadenita_1 = sTexto_1.substring(inicial_1, siguiente_1);
			            	LoggerApi.Log.info("/getIndicadorPurchaseFromJugadaTinka cadenita_1="+cadenita_1);
				            if (!cadenita_1.equals("-") && !cadenita_1.equals("")) {
				            	cade_1 += cadenita_1;
				            	LoggerApi.Log.info("/getIndicadorPurchaseFromJugadaTinka cade_1="+cade_1);
				            	car_1 = Integer.parseInt(cade_1);
				            } else {
				                 if (car_1 < 6 ) {
				                	 indicador_1 = "no";
				                }
				                cade_1 = "";
				            }
				            inicial_1++;
				            siguiente_1++;
			            }
			            ind_tk=indicador_1;
					}
				
					if(CollectionUtils.isEmpty((List) maping.get("tinka"))) {
						
						cad_tk = cad_tk+"0-";
				   	
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
					             if (car_1 < 6 ) {
					            	 indicador_1 = "no";
					            }
					            cade_1 = "";
					        }
					        inicial_1++;
					        siguiente_1++;
				        }
				        ind_tk=indicador_1;
					}
				}
			}
		}
		
		return ind_tk;
	}

	private String getTypeBoleto(String boleto) {
		if(boleto.endsWith("96")) {
			return Constantes.BoletoTinka.boletoTinkaSuscripcion96;
		}
		else if(boleto.endsWith("48")) {
			return Constantes.BoletoTinka.boletoTinkaSuscripcion48;
		}
		else if(boleto.endsWith("24")) {
			return Constantes.BoletoTinka.boletoTinkaSuscripcion24;
		}
		else if(boleto.endsWith("8")) {
			return Constantes.BoletoTinka.boletoTinkaSuscripcion8;
		} else if (boleto.endsWith("a") || boleto.endsWith("b") || boleto.endsWith("c") || boleto.endsWith("d")) {
			return Constantes.BoletoTinka.boletoTinkaRegular;
		} else {
			return "";
		}
	}
	
	private Double getCostoTotalRegularBet(Tinka tinka, Long consecutive) {
		
		Double costoTotalBet=0.00;
		
		Integer totalBet = tinka.getJugadasActuales();
		String algorithm = tinka.getPromotionAlgorithm();
		Double simpleBetPrice = tinka.getRegularPayment();
		int bets = tinka.getPromotionBets();
	    int pay = tinka.getPromotionPay();
	    Double cost = tinka.getPromotionCost();
	    int draw = tinka.getPromotionDraws();
	    
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
	@RequestMapping("/game_tinka_show_shoppingcart_suscripcion")	
	public ModelAndView showShoppingCartSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

		LoggerApi.Log.info("-------------- START game_tinka_show_shoppingcart_suscripcion"); 
		try {
	
			HttpSession session = request.getSession();
			session.setAttribute("tipoTinka", "suscripcion");
			String boleto="";
			if(request.getParameter("boleto")!=null) {
				boleto = request.getParameter("boleto").toString();
			} else if (session.getAttribute(Constantes.Boleto.typeBoleto)!=null) boleto = (String) session.getAttribute(Constantes.Boleto.typeBoleto);
			
			session.setAttribute("tipoBoletoSuscripcion", boleto);
			
			if(boleto.trim().equals("")) return new ModelAndView("redirect:game_tinka_show_menu.html");
			
			String typeboleto=getTypeBoleto(boleto);
			
			Tinka tinkaSuscripcion = !typeboleto.equals("")?(Tinka) session.getAttribute(typeboleto):null;
			
			Integer totalbets = 0 ;
			
			if(tinkaSuscripcion!=null) {
				totalbets = validarCantidadJugadas(null,tinkaSuscripcion.getGame(),StringUtils.EMPTY);
			}
			
			String indicadorPurchase = (totalbets>5005 || totalbets==0)?"no":"yes";
				
			if(totalbets>5005){
	    		objectModelMap.put("alertNumberPlayTinka","El numero de jugadas excede lo permitido (5005) !");
	    		return new ModelAndView("game/tinka/interface-shoppingcart-suscripcion");
			} else {
	    		
	    		if(tinkaSuscripcion!=null) {
	    			Double payment = tinkaSuscripcion.getPricePerPlay()*totalbets*tinkaSuscripcion.getDraws();
	    			Double regularPayment = tinkaSuscripcion.getRegularPricePerPlay()*totalbets*tinkaSuscripcion.getDraws();
		    		tinkaSuscripcion.setDiscountPayment(payment);
		    		tinkaSuscripcion.setJugadas(totalbets*tinkaSuscripcion.getDraws());
		    		tinkaSuscripcion.setRegularPayment(regularPayment);
		    		LoggerApi.Log.info("/game_tinka_show_shoppingcart_suscripcion boleto="+tinkaSuscripcion.getBoleto());
		    		LoggerApi.Log.info("/game_tinka_show_shoppingcart_suscripcion boleto="+tinkaSuscripcion.getTicket());
		    		session.setAttribute(typeboleto, tinkaSuscripcion);
		    		
		    		objectModelMap.mergeAttributes(tinkaSuscripcion.toMap());
		    		objectModelMap.mergeAttributes(tinkaSuscripcion.sendBoleto());

		    		LoggerApi.Log.info("/game_tinka_show_shoppingcart_suscripcion indicadorPurchase="+indicadorPurchase);
		    		objectModelMap.put("indicadorPurchase",indicadorPurchase);
		    		objectModelMap.put("negacion","no");
					objectModelMap.put("afirmacion","yes");
					

					return new ModelAndView("game/tinka/interface-shoppingcart-suscripcion");
	    		} 
	    	}	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/tinka/interface-shoppingcart-suscripcion");
		} finally {
			LoggerApi.Log.info("-------------- END game_tinka_show_shoppingcart_suscripcion"); 
		}
		return new ModelAndView("game/tinka/interface-shoppingcart-suscripcion");

	}
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>Este metodo por el momento se utiliza de forma exclusiva para tinka regular</p>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/game_tinka_show_shoppingcart_tinkaexpress")
	public ModelAndView showShoppingCartv2(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			 	LoggerApi.Log.info("-------------- START game_tinka_show_shoppingcart"); 
					
				HttpSession session = request.getSession();		
				session.setAttribute("tipoTinka", "simple");

				HashMap[] consecutivas= beanTinkaBetBo.getNumberConsecutive();
				objectModelMap.put("consecutiveTinkaList_TK", consecutivas);
				session.setAttribute("consecutiveTinkaList_TK", consecutivas);
				
				String typeboleto =Constantes.BoletoTinka.boletoTinkaRegular;
				session.setAttribute(Constantes.Boleto.typeBoleto, typeboleto);
				
				Tinka tinkaRegular = !typeboleto.equals("")?(Tinka) session.getAttribute(typeboleto):null;

		    	//obtener número de jugadas gratis
		    	TinkaSale tinkaSale = new TinkaSale();
		    	int clientId = 0;
		    	clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
		    	tinkaSale = beanTinkaBetBo.findTinkaBetData(clientId);
		    	
		    	if(tinkaSale == null || tinkaRegular == null)
		    		return new ModelAndView("redirect:game_tinka_show_menu.html");
		    	
		    	tinkaRegular.setQuantityGame(tinkaSale.getBalanceQuantityGame());
		    	//end obtener número de jugadas gratis
		    	
		    	objectModelMap.mergeAttributes(tinkaRegular.toMap());
		    	objectModelMap.mergeAttributes(tinkaRegular.sendBoleto());
		    	
		    	objectModelMap.put("tinkaSale", tinkaSale);
		    	// mostrando la promocion si existe una
		    	if(tinkaRegular.getPromotionMessage().trim().length()>6)
												  
		    		objectModelMap.put("promocion", tinkaRegular.getPromotionMessage());
                
		    	
				Double flagTk = (beanParameterBo.findParameterById(Constantes.C_TK) == null) ? 0 : beanParameterBo.findParameterById(Constantes.C_TK).getNumber();
				objectModelMap.put("flagConsecutivaTk",flagTk);
						
				objectModelMap.put("bolillasMinima", 6);
				objectModelMap.put("n_bolillas", 50);
				objectModelMap.put("limiteJugadas", 5005);
				
				objectModelMap.put("consecutiveParam", session.getAttribute("consecutiveParam"));
				objectModelMap.put("jsonJugadas", session.getAttribute("jsonJugadas"));
				
				return new ModelAndView("game/tinka/interface-shoppingcart-tinkaexpress");

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinka_show_menu.html");
		}  finally {
		    LoggerApi.Log.info("-------------- END game_tinka_show_shoppingcart"); 
		}
	
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/game_tinka_show_shoppingcart")	
	public ModelAndView showShoppingCart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {	
			    LoggerApi.Log.info("-------------- START game_tinka_show_shoppingcart"); 
					
				HttpSession session = request.getSession();		
				session.setAttribute("tipoTinka", "simple");		
				Map consecutiveMap=(Map) session.getAttribute("consecutiveTinkaValue_TK");
				
				Long consecutive=Long.valueOf(1);
				
				if(MapUtils.isNotEmpty(consecutiveMap)){
					consecutive=Long.valueOf(((Map) session.getAttribute("consecutiveTinkaValue_TK")).get("NUM_DRAW").toString());	
				}
				
				String typeboleto =Constantes.BoletoTinka.boletoTinkaRegular;
				
				Tinka tinkaRegular = !typeboleto.equals("")?(Tinka) session.getAttribute(typeboleto):null;

				if(tinkaRegular!=null && tinkaRegular.getJugadasActuales()!=null){
					
					Integer totalBet = tinkaRegular.getJugadasActuales();
					String indicadorPurchase = (totalBet!=null && (totalBet>5005 || totalBet==0))?"no":"yes";				
		    	
			   	if(totalBet>5005){
		    		objectModelMap.put("alertNumberPlay_TK","El numero de jugadas excede lo permitido (1386) !");
			   	}	
			   	
                Double totalPay = getCostoTotalRegularBet(tinkaRegular,consecutive);
               
                //start capturar precios por jugada(a,b,c,d)
                if(session.getAttribute("ultima_jugada")!=null) {
	                String [] ultima_jugada=(String[])session.getAttribute("ultima_jugada");
//	                String uj=ultima_jugada[0];
	                String op=ultima_jugada[1];
//	                Object pj=session.getAttribute("precios_jugadas");
	                if(op.equals("add")) {
	                	if(tinkaRegular.getBoleto().size()==1) {
	                    	objectModelMap.put("lastPrice", totalPay);
	                    }else {
	                        objectModelMap.put("lastPrice", totalPay-tinkaRegular.getDiscountPayment());
	                    	}
	                	objectModelMap.put("operation", "add");
	                }
	                if(op.equals("delete")) {
	                	objectModelMap.put("operation", "delete");
	                	objectModelMap.put("priceJuegoDelete", tinkaRegular.getDiscountPayment()-totalPay);	     
	                	objectModelMap.put("lastPrice", totalPay);
	                }
	                if(op.equals("consecutive")) {
	                	objectModelMap.put("operation", "consecutive");
	                	objectModelMap.put("consecutivePrice", totalPay-tinkaRegular.getDiscountPayment());
	                }
	                if(op.equals("removeConsecutive")) {
	                	objectModelMap.put("operation", "removeConsecutive");
	                	objectModelMap.put("priceJuegoDelete", tinkaRegular.getDiscountPayment()-totalPay);	                	
	                }
	                
	                String[] df= {"default","default"};
	                session.setAttribute("ultima_jugada", df);
                }
               //end capturar precios
                
			    tinkaRegular.setDiscountPayment(totalPay);
			    LoggerApi.Log.info("/game_tinka_show_shoppingcart boleto="+tinkaRegular.getBoleto());
			    session.setAttribute(typeboleto, tinkaRegular);
               
		    	session.setAttribute("totalTinkaSession_TK",Double.valueOf(totalPay));
		    	
		    	//obtener número de jugadas gratis
		    	TinkaSale tinkaSale = new TinkaSale();
		    	int clientId = 0;
		    	clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
		    	tinkaSale = beanTinkaBetBo.findTinkaBetData(clientId);
		    	tinkaRegular.setQuantityGame(tinkaSale.getBalanceQuantityGame());
		    	//end obtener número de jugadas gratis
		    	
		    	objectModelMap.mergeAttributes(tinkaRegular.toMap());
		    	objectModelMap.mergeAttributes(tinkaRegular.sendBoleto());
		    	
				objectModelMap.put("negacion","no");
				objectModelMap.put("afirmacion","yes");
				objectModelMap.put("ind_tk",indicadorPurchase);
				objectModelMap.put("consecutive",consecutive);
//				objectModelMap.put("flag",true);
				Double flagTk = (beanParameterBo.findParameterById(Constantes.C_TK) == null) ? 0 : beanParameterBo.findParameterById(Constantes.C_TK).getNumber();
				objectModelMap.put("flagConsecutivaTk",flagTk);
						
		} else return new ModelAndView("redirect:game_tinka_show_menu.html");
				
		return new ModelAndView("game/tinka/interface-shoppingcart");
	
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/tinka/interface-shoppingcart");
		}  finally {
		    LoggerApi.Log.info("-------------- END game_tinka_show_shoppingcart"); 
		}
	
	}
	
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * <p> Se modifico para sosportar el caso de tinka suscripcion, en caso sea suscripcion
	 * redirecciona a interface-suscription-type </p> 
	 *
	 *
	 */
	@RequestMapping("/game_tinka_show_bet")	
	public ModelAndView showBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception { 

	    LoggerApi.Log.info("-------------- START game_tinka_show_bet"); 
		HttpSession session = request.getSession();		
		
		try {
			
			String play = "";
			
			//validacion para tinkaexpress
			int clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;


			if(request.getParameter("play")!=null) {
				play = request.getParameter("play").toString();
			} else return new ModelAndView("redirect:game_tinka_show_menu.html");
			
			LoggerApi.Log.info("/game_tinka_show_bet play="+play);
			
			// tipo de boleto - en este caso TkREG
			 String typeboleto=getTypeBoleto(play);
			 
			 if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_tinka_show_menu.html");
			 
			 String cart = request.getParameter("cart")!=null?request.getParameter("cart").toString():"none";
			 
			 session.setAttribute("cartTemp", cart);
			 
			 Tinka tinka = null;
			 LoggerApi.Log.info("/game_tinka_show_bet typeboleto="+typeboleto);
			 if(StringUtils.isNotEmpty(typeboleto)) tinka = (Tinka) session.getAttribute(typeboleto);

			 session.setAttribute(Constantes.Boleto.typeBoleto, typeboleto);
			 
			 // si la variable car esta en go y los otros parametros estan en null se retorna a la pestaña de carrito // esta parte ya no va
			 if(tinka!=null && tinka.getBoleto()!=null && !cart.equals("go")) {
				 // si el tipo de boleto termina en esos numeros es porque es TinkaCombos de lo contraio es tinka regular
				 if(typeboleto.endsWith("8")|| typeboleto.endsWith("4")|| typeboleto.endsWith("6")) return new ModelAndView("redirect:game_tinka_show_shoppingcart_suscripcion.html");
				 else if (typeboleto.equals(Constantes.BoletoTinka.boletoTinkaRegular)) {
					//seleccion tinkaexpress	
					 if(clientId == 0){
						return new ModelAndView("redirect:game_tinka_show_shoppingcart_tinkaexpress.html"); 
					 }
					//fin seleccion tinkaexpress
					 
					 return new ModelAndView("redirect:game_tinka_show_shoppingcart.html");
				 }
			 }
			 
			 if(tinka == null) return new ModelAndView("game/tinka/interface-bet");
			 
			 LoggerApi.Log.info("/game_tinka_show_bet tinka="+String.valueOf(tinka).toString());
			 LoggerApi.Log.info("/game_tinka_show_bet tinka.getBoleto()="+String.valueOf(tinka.getBoleto()).toString());
			 
			 if(tinka!=null)  objectModelMap.mergeAttributes(tinka.toMap());
			 
			 String jugada = (tinka!=null && tinka.getTypeTinka()!= null && tinka.getTypeTinka().equals("REG"))? play : (tinka!=null && tinka.getDraws()!= null)?tinka.getDraws().toString():"";
			 LoggerApi.Log.info("/game_tinka_show_bet jugada="+String.valueOf(jugada).toString());
			 
			 // separa la jugada si es A - B - C - D
			 session.setAttribute(Constantes.Boleto.idBoleto,"jugada_".concat(jugada));
			 
			 if(tinka!=null && tinka.getTypeTinka().equals("REG")) {
				 //seleccion tinkaexpress							    	
				if(clientId == 0){
					return new ModelAndView("redirect:game_tinka_show_shoppingcart_tinkaexpress.html"); 
				}
				//fin seleccion tinkaexpress
				
				 objectModelMap.put("typePlay",play.toUpperCase());
				 objectModelMap.mergeAttributes(tinka.toMap());
				 return new ModelAndView("game/tinka/interface-bet");
 
			 } else {
				 return new ModelAndView("game/tinka/interface-suscripcion-type");
			 }
			 
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/tinka/interface-bet");
			
		} finally {
			LoggerApi.Log.info("/game_tinka_show_bet typeBoleto="+((session!=null && session.getAttribute("typeBoleto")!=null)?session.getAttribute("typeBoleto").toString():"null"));
		    LoggerApi.Log.info("-------------- END game_tinka_show_bet"); 
		}
						
	}	
	
	
	@RequestMapping("/game_tinka_express_buy")
	public ModelAndView showTinkaExpress(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

	    LoggerApi.Log.info("-------------- START game_tinka_express_buy  "); 
		HttpSession session = request.getSession();		
		TinkaSale tinkaSale = new TinkaSale();
		ModelMap parametrosIframe = new ModelMap();
		DecimalFormat priceFormat = new DecimalFormat("0.00");
		DateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			
			Tinka tinka = session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null?(Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular):null;
			
			if(tinka==null || MapUtils.isEmpty(tinka.getBoleto())) 
				return new ModelAndView("redirect:game_tinka_show_shoppingcart_tinkaexpress.html");
			
			Map boleto=tinka.getBoleto();
			
			// se declaran las jugadas asi no se tenga nada en ese parametro
			parametrosIframe.put("a", "");
			parametrosIframe.put("b", "");
			parametrosIframe.put("c", "");
			parametrosIframe.put("d", "");
			
			// recorriendo el boleto con las jugadas
			if (!boleto.isEmpty()) {
			    Iterator it = boleto.keySet().iterator();
			    while (it.hasNext()) {
					String nombreJugada = (String) it.next();					
					List jugada =(List) ((Map) boleto.get(nombreJugada)).get("tinka");
					
					// Convertir la lista jugada en una cadena de texto separada por guiones
			        StringBuilder jugadaStrBuilder = new StringBuilder();
			        for (int i = 0; i < jugada.size(); i++) {
			            jugadaStrBuilder.append(jugada.get(i));
			            if (i < jugada.size() - 1) {
			                jugadaStrBuilder.append("-");
			            }
			        }
					
					parametrosIframe.put(nombreJugada.substring("jugada_".length()), jugadaStrBuilder.toString());
			        
				}
	    	}
			
			// consecutivas
			String  date_to = ((Map) session.getAttribute("consecutiveTinkaValue_TK")).get("DR_DATE").toString();
			date_to = outputDateFormat.format(inputDateFormat.parse(date_to));
			
			String total_draws = ((Map) session.getAttribute("consecutiveTinkaValue_TK")).get("NUM_DRAW").toString();

			Double totalPay = getCostoTotalRegularBet(tinka,Long.valueOf(total_draws));
			tinka.setDiscountPayment(totalPay);
			
			// demas parametros para el iframe
			parametrosIframe.put("price", priceFormat.format(tinka.getPricePerPlay())); 
			parametrosIframe.put("quantity", tinka.getJugadasActuales());
			
			parametrosIframe.put("total", priceFormat.format(tinka.getDiscountPayment()));
			
			parametrosIframe.put("total_draws",total_draws);
			parametrosIframe.put("date_to", date_to);
			
			parametrosIframe.put("promo",tinka.getPromotionMessage().length() > 6 ? tinka.getPromotionMessage() : "" );
			
			// Convertir el mapa parametrosIframe en una cadena de consulta de http GET
			StringBuilder paramsBuilder = new StringBuilder();
			for (Map.Entry<String, Object> entry : parametrosIframe.entrySet()) {
			    String key = entry.getKey();
			    Object value = entry.getValue();
			    String encodedKey = URLEncoder.encode(key, "UTF-8");
			    String encodedValue = URLEncoder.encode(String.valueOf(value), "UTF-8");
			    paramsBuilder.append(encodedKey).append("=").append(encodedValue).append("&");
			}

			// Obtener la cadena de consulta resultante eliminando el último "&" si es necesario
			String queryParams = paramsBuilder.toString();
			if (queryParams.endsWith("&")) {
			    queryParams = queryParams.substring(0, queryParams.length() - 1);
			}
			
			// Pasar la URL del iframe con los parametros al modelo del jsp
			
			String urlTinkaExpress = String.valueOf(ConnectionFactory.operationProperty("tinkaExpressIframe", "SALE")).toString().trim() ;
			
			objectModelMap.put("urlTinkaExpress", urlTinkaExpress);
			
			objectModelMap.put("iframeSrc", urlTinkaExpress+ "m?" + queryParams + "&crc=" + Constantes.calculateCRC(queryParams));
			
			
			 return new ModelAndView("game/tinka/interface-tinka-express-buy");
			 
		} catch (Exception e) {
			LoggerApi.Log.info("game_tinka_express_buy - error "); 
			LoggerApi.Log.info(e.getMessage());
			return new ModelAndView("redirect:game_tinka_show_shoppingcart-tinkaExpress.html");
		} finally {
		    LoggerApi.Log.info("-------------- END game_tinka_express_buy"); 
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
	@RequestMapping("/game_tinka_show_bet_suscripcion")
	public ModelAndView showBetSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		LoggerApi.Log.info("-------------- START game_tinka_show_bet_suscripcion"); 
		HttpSession session = request.getSession();
		
		String boleto = request.getParameter("boleto").toString();
		
		if(request.getParameter("boleto")!=null) {
			boleto = request.getParameter("boleto").toString();
		} else return new ModelAndView("redirect:game_tinka_show_menu.html");
		if(StringUtils.isEmpty(boleto)) return new ModelAndView("redirect:game_tinka_show_menu.html");
		
		String typeboleto=getTypeBoleto(boleto);
		
		if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_tinka_show_menu.html");
		
		session.setAttribute("typeBoletoTemp", typeboleto);
		
		Tinka tinkaSuscripcion = (Tinka) session.getAttribute(typeboleto);
		
		if(tinkaSuscripcion == null) return new ModelAndView("redirect:game_tinka_show_menu.html");
		
		tinkaSuscripcion.setTypePlay("SUS_IGUAL");

		objectModelMap.mergeAttributes(tinkaSuscripcion.toMap());

		LoggerApi.Log.info("-------------- END game_tinka_show_bet_suscripcion"); 
		return new ModelAndView("game/tinka/interface-bet-suscripcion");
	}
	

	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>Tinka add bet se puede utilizar para añadir la jugada de tinka suscripcion (choose),
	 * en este caso se tiene que manejar las variables de sesion que son guardadas para delimitar los datos de
	 * suscripción de los de una jugada regular, se puede aprovechar para aclarar los datos manejados</p>
	 * 
	 * <p>Cada tipo de juego genera su propio boleto, para este caso segun el tipo se debe generar el boleto correspondiente</p>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/game_tinka_add_bet")	
	public ModelAndView addBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

		/*
		 * falya validar
		 */
		try {
			LoggerApi.Log.info("-------------- START game_tinka_add_bet"); 
			
			/**
			 * Separar los maps
			 */
			Map<String,Map<String,List<String>>> game=new HashMap();
			
			Map<String,List<String>> playList=new HashMap();
			Map<String,String> cantidadBolillas = new LinkedHashMap();
			List<String> playTinkaList =new ArrayList();
			String cad_t="",cad_ult_t="",cad_ult="";
			// lista de bolillas
			if(!ObjectUtils.isEmpty(request.getParameterValues("tk"))){
				LoggerApi.Log.info("/game_tinka_add_bet bet="+request.getParameterValues("tk").toString());
				for (Object object : (request.getParameterValues("tk"))) {
					playTinkaList.add(object.toString());
				} 
			} else return new ModelAndView("redirect:game_tinka_show_menu.html");
			
			// valida si almenos hubo una marcacion
			if(CollectionUtils.isNotEmpty(playTinkaList)){
				playList.put("tinka",playTinkaList);
				cad_t=String.valueOf(playTinkaList.size());
				cad_ult_t=cad_ult_t+cad_t+"-";
				cantidadBolillas.put("tinka_cad",cad_ult_t);
				LoggerApi.Log.info("/game_tinka_add_bet tinka_cad="+cad_ult_t);
			}
			
			if(CollectionUtils.isEmpty(playTinkaList)){
				playList.put("tinka",playTinkaList);
				cad_t="0";
				cad_ult_t=cad_ult_t+cad_t+"-";
				cantidadBolillas.put("tinka_cad",cad_ult_t);
				LoggerApi.Log.info("/game_tinka_add_bet tinka_cad="+cad_ult_t);
			}	
			/*Hasta aqui obtiene la jugada tinka de request*/
			
			HttpSession session = request.getSession();		
			String tipoBoleto = "";
			if(MapUtils.isNotEmpty(playList)){
				tipoBoleto = (session!=null && session.getAttribute(Constantes.Boleto.typeBoleto)!=null)?session.getAttribute(Constantes.Boleto.typeBoleto).toString():"";	
				Integer jugadasBet = getTotalJugadas(playList);
				
				
				if(jugadasBet>5005 || jugadasBet==0 ) {
					LoggerApi.Log.info("/game_tinka_add_bet jugadasBet="+jugadasBet);
					if(jugadasBet>5005) session.setAttribute("tinkaOvercomeJugadas", 1);
					if(tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaRegular)) 
						return new ModelAndView("game/tinka/interface-bet");
				 	else if(tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion8) ||
				 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion24) ||
				 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion48) ||
				 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion96)) 
				 		return new ModelAndView("game/tinka/interface-bet-suscripcion");
				} else {
					session.setAttribute("tinkaOvercomeJugadas", 0);
				}
				/*obtiene tipo de tinka en cuestión*/
				
				Tinka tinka = new Tinka();//null;
				tinka = (Tinka) session.getAttribute(tipoBoleto);
				
				Double precioPorJugada=jugadasBet*tinka.getRegularPayment();
				LoggerApi.Log.info("precioPorJugada--->"+precioPorJugada);
				
				LoggerApi.Log.info("/game_tinka_add_bet tipoBoleto="+tipoBoleto);
				
				/*obtiene el boleto en caso exista en session segun el tipo de juego*/
				if(tinka!=null && tinka.getGame()!=null && MapUtils.isNotEmpty(tinka.getGame())) game = tinka.getGame();
				
				String typePlayTinka = (String) session.getAttribute(Constantes.Boleto.idBoleto);
				String[] ultima_jugada=new String[2];
				ultima_jugada[0]=typePlayTinka;
				ultima_jugada[1]="add";
				session.setAttribute("ultima_jugada", ultima_jugada);
				
				Integer totalJugadaBoleto = validarCantidadJugadas(playList,game,typePlayTinka);
				
				if(totalJugadaBoleto!=null && (totalJugadaBoleto>5005 || totalJugadaBoleto==0)) {
					LoggerApi.Log.info("/game_tinka_add_bet totalJugadaBoleto="+totalJugadaBoleto);
					if(jugadasBet>5005) session.setAttribute("tinkaOvercomeJugadas", 1);
					if(tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaRegular)) 
						return new ModelAndView("game/tinka/interface-bet");
				 	else if(tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion8) ||
				 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion24) ||
				 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion48) ||
				 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion96)) 
				 		return new ModelAndView("game/tinka/interface-bet-suscripcion");
					 
				} else {
					if(totalJugadaBoleto==null) totalJugadaBoleto = 0;
					session.setAttribute("tinkaOvercomeJugadas", 0);
				}
				
				tinka.setJugadasActuales(totalJugadaBoleto);
				tinka.setJugadasLimite(5005-totalJugadaBoleto);
				if(typePlayTinka !=null && !typePlayTinka.trim().equals("")) game.put(typePlayTinka,playList);
				TreeMap maping = new TreeMap();
				if(MapUtils.isNotEmpty(game)) maping = new TreeMap(game);
				LoggerApi.Log.info("/game_tinka_add_bet game="+game);
				LoggerApi.Log.info("/game_tinka_add_bet new TreeMap(game)="+maping);
				tinka.setGame(game);
				tinka.setBolillas(playTinkaList);
				tinka.setBoleto(maping);
				session.setAttribute(tipoBoleto, tinka);
				
				
				
				String tipo = tinka.getTypeTinka().equals("REG")? "" : tinka.getDraws().toString();
				String sehaceadd="si";
				/*Esto puede ser reemplazado por tinka, testear cpn el boleto*/
				session.setAttribute("jugada"+tipo, playList);
	            session.setAttribute("jugada_tk"+tipo, playTinkaList);
	            session.setAttribute("cadi"+tipo, cad_t);
	            session.setAttribute("precioPorJugada", precioPorJugada);
	            session.setAttribute("sehaceadd", sehaceadd);

				LoggerApi.Log.info("/game_tinka_add_bet "+tipoBoleto+"="+maping);
				LoggerApi.Log.info("/game_tinka_add_bet game="+game);
				
				IntralotUtils.carItemUpdate(session);
				
				/*guarda en session la jugada, para suscripcion se guarda en la clase
				 * 
				 * esto se tiene que reemplazar por cada boleto que pueda existir, (4 - por tipoBoleto)*/
				//siempre en vacio cad_ult
	            
	            LoggerApi.Log.info("/game_tinka_add_bet jugada="+playList +" jugada_tk="+playTinkaList+" lastJugada="+playList+" cadi="+cad_t);
	            session.setAttribute("lastJugada", cantidadBolillas);
	            session.setAttribute("valorRemo", "");
	            session.removeAttribute(Constantes.Boleto.idBoleto);
			}
			

			  String redireccion = "";
			 	if(tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaRegular)) 
			 		redireccion = "redirect:game_tinka_show_shoppingcart.html";
			 	else if(tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion8) ||
			 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion24) ||
			 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion48) ||
			 			tipoBoleto.equals(Constantes.BoletoTinka.boletoTinkaSuscripcion96)) 
			 		redireccion = "redirect:game_tinka_show_shoppingcart_suscripcion.html";

			return new ModelAndView(redireccion);

		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinka_show_shoppingcart.html");
		} finally {
			LoggerApi.Log.info("-------------- END game_tinka_add_bet"); 
		}
		
     }
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>Se ha agregado la funcionalidad de eliminar el boleto correspondiente.
	 * Este se identifica en el parámetro 'id' segun sus últimas letras </p>
	 */
	@SuppressWarnings({"rawtypes", "unchecked" })
	@RequestMapping("/game_tinka_delete_bet")	
	public ModelAndView deleteBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {
			LoggerApi.Log.info("-------------- START game_tinka_delete_bet"); 
			
			String id = "";
			if(request.getParameter("id")!=null) {
				id = request.getParameter("id").toString();
			} else return new ModelAndView("redirect:game_tinka_show_menu.html");
			
			LoggerApi.Log.info("/game_tinka_delete_bet id="+id);
			Map boleto = null;
			HttpSession session = request.getSession();
			String[] ultima_jugada=new String[2];
			ultima_jugada[0]=id;
			ultima_jugada[1]="delete";
			session.setAttribute("ultima_jugada", ultima_jugada);
			String typeboleto=getTypeBoleto(id);
			if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_tinka_show_menu.html");
			
			LoggerApi.Log.info("/game_tinka_delete_bet typeboleto="+typeboleto);
			if(StringUtils.isNotEmpty(typeboleto)) {
				Tinka tinka = (session.getAttribute(typeboleto)!=null)?(Tinka) session.getAttribute(typeboleto):new Tinka();
				
				boleto=tinka.getBoleto();
				
				/**
				 * Aqui falta testearlo por el id
				 */
			   if(boleto!=null && MapUtils.isNotEmpty(boleto) && MapUtils.isNotEmpty((Map) boleto.get(id))){
				   boleto.remove(id);
				   Map<String,Map<String,List<String>>> game = tinka.getGame();
				   game.remove(id);
				   Integer totalJugadas = validarCantidadJugadas(null,game,StringUtils.EMPTY);
				   LoggerApi.Log.info("/game_tinka_delete_bet game="+game);
				   tinka.setGame(game);
				   tinka.setJugadasActuales(totalJugadas);
				   tinka.setJugadasLimite(5005-totalJugadas);
				   LoggerApi.Log.info("/game_tinka_delete_bet totalJugadas="+totalJugadas);
				   
				   LoggerApi.Log.info("tinka.getDiscountPayment()---->"+tinka.getDiscountPayment());
				   LoggerApi.Log.info("preciooo---->"+totalJugadas*tinka.getRegularPayment());
				
				   Double valorRemo=tinka.getDiscountPayment()-totalJugadas*tinka.getRegularPayment();
				   LoggerApi.Log.info("valorRemo---->"+valorRemo);
				   
				   
				   LoggerApi.Log.info("/game_tinka_delete_bet boleto="+boleto);
				   
				   tinka.setBoleto(new TreeMap(boleto));
				   
				   
				   session.setAttribute(typeboleto,tinka);
				   
				   session.setAttribute("valorRemo",valorRemo);
				   session.setAttribute("precioPorJugada", "");
				   
				   
				   
				   if(typeboleto.equals(Constantes.BoletoTinka.boletoTinkaRegular)) {
					   if(MapUtils.isEmpty(boleto)){
						   session.removeAttribute("consecutiveTinka_TK");
						   session.removeAttribute("consecutiveTinkaValue_TK");
					   }
				   }   
			   }
			   
			   IntralotUtils.carItemUpdate(session);
			}
			
		 if(typeboleto.equals(Constantes.BoletoTinka.boletoTinkaRegular)) {
			 return new ModelAndView("redirect:game_tinka_show_shoppingcart.html"); 
		 } else {
			 return new ModelAndView("redirect:game_tinka_show_menu.html");
		 }
		   
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinka_show_menu.html");
		}finally{
			LoggerApi.Log.info("-------------- END game_tinka_delete_bet"); 
		}
	
    }

		
	
	/**
	 * 
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 * 
	 * <p>PlayBetSuscription se encarga de realizar la transaccion de compra de tinka
	 * suscripcion, aun faltra implementar la parte de AZAR. Es posible combinar este método con la trassaccion de compra 
	 * de uno regular</p>
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping("/game_tinka_play_bet_result_suscription")	
	public ModelAndView playBetSuscripcion(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		/*
		 * Obtengo el boleto de la session e identifico la suscripcion
		 */
		/**
		 * Esta parte se repite en varias funciones, se puede refactorizar
		 */
		LoggerApi.Log.info("-------------- START game_tinka_play_bet_result_suscription"); 
		objectModelMap.put("tipoCompra","combo");
		objectModelMap.put("SubZona","Combos Tinkeros");
		objectModelMap.put("alertPlay","Error inesperado en el sistema");
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
		HttpSession session = request.getSession();
		//if(session.getAttribute("welcomeBonusStatus")!=null && session.getAttribute("welcomeBonusStatus").toString().trim().equals("Reciente")) session.setAttribute("welcomeBonusMessagePor", "<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+session.getAttribute("welcomeBonusPercentaje").toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
        //else session.setAttribute("welcomeBonusMessagePor", "");
		String modelview = "game/tinka/interface-result_game";
		String boleto = "";
		if(request.getParameter("boleto")!=null) boleto = request.getParameter("boleto").toString();
		else if (session.getAttribute("carrierBoleto")!=null) {
			boleto = session.getAttribute("carrierBoleto").toString();
			session.removeAttribute("carrierBoleto");
		} else return new ModelAndView("redirect:game_tinka_show_menu.html");
		LoggerApi.Log.info("/game_tinka_play_bet_result_suscription boleto="+boleto);
		if(boleto.trim().equals("")) return new ModelAndView("redirect:game_tinka_show_menu.html");
		String typeboleto=getTypeBoleto(boleto);
		if(StringUtils.isEmpty(typeboleto)) return new ModelAndView("redirect:game_tinka_show_menu.html");
		
		session.setAttribute("typeBoletoTemp", typeboleto);
		
		Tinka tinkaSuscripcion = null;
		tinkaSuscripcion = (Tinka) session.getAttribute(typeboleto);
		String juego = "";
		LoggerApi.Log.info("/game_tinka_play_bet_result_suscription typeboleto="+typeboleto);
		Integer multiDraws = 0;
		String gameType = "";
		Double price = 0.00;
		if(StringUtils.isNotEmpty(typeboleto)) {
		    multiDraws = tinkaSuscripcion.getDraws();
			gameType = tinkaSuscripcion.getTypePlay();
			price = tinkaSuscripcion.getDiscountPayment();
			if(gameType.equals("SUS_AZAR")) juego = "AZAR";
			else if(gameType.equals("SUS_IGUAL")) {
				for (String bolilla : tinkaSuscripcion.getBolillas()) {
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
		Integer gameId= Game.TINKA;
	    LoggerApi.Log.info("/game_tinka_play_bet_result_suscription juego="+juego+" multiDraws="+multiDraws+" gameType="+gameType+" price="+price+" client="+client+" ip="+ip+" gameId="+gameId);
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
            next = beanTinkaBetBo.findTinkaNextDraw();
            if (messageResult.equals("OK") && arr != null && arr[1] != null && arr[5] != null) {
                int send = mailingForSale.sendTinkaSubscription(client.getMail(), arr[5].toLowerCase(), arr[0], arr[3], arr[4], arr[11], arr[1].trim().replaceAll(" ", " - "), next[0], "S/ "+next[1]);
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
			objectModelMap.put("alertPlay","Suscripción Tinka realizado con &eacute;xito!");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","ok");
			objectModelMap.put("newamount",intralotUtils.formatCurrency(availableBalance));
			session.setAttribute("saldo", intralotUtils.formatCurrency(availableBalance));
			try {
				objectModelMap.put("numCombo",tinkaSuscripcion.getDraws());
				objectModelMap.put("ticketIdCombo",o[1]);
				objectModelMap.put("precioCombo",tinkaSuscripcion.getDiscountPayment());
				objectModelMap.put("sorteosCombo",tinkaSuscripcion.getJugadas());
				objectModelMap.put("tipoJugadaCombo",gameType);
				if(gameType.equalsIgnoreCase("SUS_IGUAL")) {
					objectModelMap.put("bolillasCombo",tinkaSuscripcion.getBolillas().size());
				}else {
					objectModelMap.put("bolillasCombo",6);
				}
			} catch (Exception e) {		}
			
			//popup tinka guarda evento
			if(session.getAttribute("popup-tinka-source") != null) {
				ClientProcedureRegisterPopupLottery popup = clientSaleBo.registerPopupLottery(client.getClientId(), session.getAttribute("popup-tinka-device").toString(), session.getAttribute("popup-tinka-source").toString(), Game.TINKA);
				if(popup.getState() == 1) {//graba entonces limpia variable de sesion
					session.removeAttribute("popup-tinka-source");
					session.removeAttribute("popup-tinka-device");
				}
			}	
			//fin popup tinka
			
		} else if(StringUtils.contains(messageResult,"autoexclusión")) {
			objectModelMap.put("alertPlay","Limite autoexclusion activado");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
		} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
			objectModelMap.put("alertPlay","No se ha encontrado el registro del cliente");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
		} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {
			objectModelMap.put("alertPlay","No cuenta con saldo disponible para realizar este proceso");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","saldo");
		} else {
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
			objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente  ");
		}
		LoggerApi.Log.info("-------------- END game_tinka_play_bet_result_suscription"); 
		return new ModelAndView(modelview);
	}
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@RequestMapping("/game_tinka_play_bet_result")	
	public ModelAndView playBetResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		HttpSession session = request.getSession();
		TinkaSale tinkaSale = new TinkaSale();
		try {
			//if(session.getAttribute("welcomeBonusStatus")!=null && session.getAttribute("welcomeBonusStatus").toString().trim().equals("Reciente")) session.setAttribute("welcomeBonusMessagePor", "<fieldset><div class=\"top-saldo\">&iexcl;OBT&Eacute;N TU BONO<br/>DE BIENVENIDA!<br/><span><b>"+session.getAttribute("welcomeBonusPercentaje").toString().trim()+"</b>% DE TU RECARGA</span><div class=\"saldo-add\">para jugar Te Apuesto<br/><label>(recarga m&iacute;nima de S/20)</label><h3>+</h3><span>JUGADAS GRATIS</span>de todas nuestras loter&iacute;as</div><img src=\"layer-view-image/v2/logos.png\" alt=\"\" /></div></fieldset><div class=\"control-form\"><input type=\"button\" onclick=\"window.location.href=\\'client_lotocard_show_information.html\\';\" value=\"ACT&Iacute;VALO AQU&Iacute;\" class=\"js-close-modal btn btn-orange white wcb-button-text\" /></div><p class=\"tyc-block\">Inf&oacute;rmate de los t&eacute;rminos y condiciones antes de realizar tu recarga</p>");
	        //else session.setAttribute("welcomeBonusMessagePor", "");
			LoggerApi.Log.info("-------------- START game_tinka_play_bet_result"); 
			Map map=null;
			Tinka tinka = session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null?(Tinka) session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular):null;
			
			if(tinka!=null){
				map=tinka.getBoleto();
			}
			if(tinka!=null){
				
			String numBolJugadaA="";String numBolJugadaB="";String numBolJugadaC="";String numBolJugadaD="";	
				
			if(MapUtils.isNotEmpty(map)){
				
			Game game = new Game();
			game.setGame(Game.TINKA);
			
			GroupAPI[] group = new GroupAPI[map.size()];
			
			int count=0;
			if(map.size()>0) {
				for(Iterator it=map.keySet().iterator();it.hasNext();) {
					String mapa = (String)it.next();						
					Map maping =(Map) map.get(mapa);			
							
					List playTinkaList =(List) maping.get("tinka");
					
					int[] numbers = new int[playTinkaList.size()];
					
					int tinkaCount=0;
					for (Object item : playTinkaList) {
						numbers[tinkaCount]=Integer.valueOf((String) item);
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
					
			        group[count] = new GroupAPI();
			        group[count].setLottoBet(Game.TINKA, Group.NORMAL, numbers);
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
		web.setMessageId("W" + d.getTimeLong() + Game.TINKA);
		web.setCarrier("MOBILE");
		
		String messageResult=StringUtils.EMPTY;	
		
		int numbersConsecutive=1;
		
		if(MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveTinkaValue_TK"))){
			 numbersConsecutive= Integer.valueOf(((Map) session.getAttribute("consecutiveTinkaValue_TK")).get("NUM_DRAW").toString());	
		}
		String consecu=numbersConsecutive+"";
		
		double priceSale =0.0;
		if(session.getAttribute("totalTinkaSession_TK") != null){
			 priceSale = tinka.getDiscountPayment();
		}
		
		//obtener número de jugadas gratis
    	tinkaSale = beanTinkaBetBo.findTinkaBetData(Integer.parseInt(client.getClientId()));
    	
    	session.setAttribute("jugadasGratis", tinkaSale.getBalanceQuantityGame());
		
		ClientTicket ct = new ClientTicket();
		ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
		tinkaSale = beanTinkaBetBo.findTinkaBetData(Integer.parseInt(client.getClientId()));
				
		if(ct.getMessage() != null) messageResult = ct.getMessage();
		objectModelMap.put("SubZona","Juega Tinka");
		if(messageResult.equals("OK")) {
			session.removeAttribute("consecutiveTinka_TK");
			session.removeAttribute("consecutiveTinkaValue_TK");
			session.removeAttribute("totalTinkaSession_TK");
			session.removeAttribute(Constantes.BoletoTinka.boletoTinkaRegular);
			session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())-1);
			session.setAttribute("alertPlay2","Gracias por tu compra");
			objectModelMap.put("alertPlay","Jugada realizada con &eacute;xito!");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","ok");
			objectModelMap.put("tipoCompra","individual");
			objectModelMap.put("newamount",intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
			session.setAttribute("saldo", intralotUtils.formatCurrency(ct.getNewBalanceAmount()));
			objectModelMap.put("bonusOther",tinkaSale.getOtherQuantity());
			//objectModelMap.put("bonusOther",intralotUtils.formatCurrency(Double.parseDouble(tinkaSale.getOtherAmount())));
			//session.setAttribute("bonoOtro", intralotUtils.formatCurrency(Double.parseDouble(tinkaSale.getOtherAmount())));
			session.setAttribute("bonoOtro", tinkaSale.getOtherQuantity());
			session.setAttribute("ticketId", ct.getTicketId());
			//envio de parametros
			session.setAttribute("importeTotal", tinka.getDiscountPayment());
			session.setAttribute("jugadasActuales", tinka.getJugadasActuales());
			session.setAttribute("consecu", consecu);
			
			session.setAttribute("numBolJugadaA", numBolJugadaA);
			session.setAttribute("numBolJugadaB", numBolJugadaB);
			session.setAttribute("numBolJugadaC", numBolJugadaC);
			session.setAttribute("numBolJugadaD", numBolJugadaD);
		
			
			
			session.setAttribute("priceSale", priceSale);//este de aqui ya no  se usa
			session.removeAttribute("precios_jugadas");
			
			//tagging MxN
			objectModelMap.put("formatPricePerPlay2",tinka.getPricePerPlay());
			objectModelMap.put("discountPayment",tinka.getDiscountPayment());
			objectModelMap.put("promotionMessage",tinka.getPromotionMessage());
			objectModelMap.put("consecutive",numbersConsecutive);
			
			//popup tinka guarda evento
			if(session.getAttribute("popup-tinka-source") != null) {
				ClientProcedureRegisterPopupLottery popup = clientSaleBo.registerPopupLottery(Integer.parseInt(client.getClientId()), session.getAttribute("popup-tinka-device").toString(), session.getAttribute("popup-tinka-source").toString(), Game.TINKA);
				if(popup.getState() == 1) {//graba entonces limpia variable de sesion
					session.removeAttribute("popup-tinka-source");
					session.removeAttribute("popup-tinka-device");
				}
			}	
			//fin popup tinka
			
			return new ModelAndView("game/tinka/interface-result_game");
		
		} else if(StringUtils.contains(messageResult,"autoexclusión")) {
			objectModelMap.put("alertPlay","Limite autoexclusion activado");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
			return new ModelAndView("game/tinka/interface-result_game");
		} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
			objectModelMap.put("alertPlay","No se ha encontrado el registro del cliente");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
			return new ModelAndView("game/tinka/interface-result_game");
		} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {
			objectModelMap.put("alertPlay","No cuenta con saldo disponible para realizar este proceso");
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","saldo");
			return new ModelAndView("game/tinka/interface-result_game");
		} else {
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
			objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente  ");
			return new ModelAndView("game/tinka/interface-result_game");
		}		
		
		}
			}
			
			// if tinka == null, no hay boleto pendiente retorna al home
			return new ModelAndView("redirect:/game_tinka_show_menu.html");
		
		} catch (Exception e) {
			objectModelMap.put("alertPlay","Ocurrio un error intente nuevamente ");
			LoggerApi.severe(e);
			objectModelMap.put("game","tinka");
			objectModelMap.put("status","error");
			return new ModelAndView("game/tinka/interface-result_game");
		}finally{
			LoggerApi.Log.info("-------------- END game_tinka_play_bet_result"); 
		} 
	
	}
	
	@RequestMapping("/game_tinka_show_consecutive")	
	public ModelAndView showConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {

		LoggerApi.Log.info("-------------- START game_tinka_show_consecutive"); 
		
		try {
				
			HttpSession session = request.getSession();	
			if(session!=null){
			if(ObjectUtils.isEmpty((HashMap[]) session.getAttribute("consecutiveTinkaList_TK"))){
				if(beanTinkaBetBo!=null){
					if(beanTinkaBetBo.getNumberConsecutive()!=null){
						session.setAttribute("consecutiveTinkaList_TK", beanTinkaBetBo.getNumberConsecutive());	
					}
				}
			}
			}
			
		return new ModelAndView("game/tinka/interface-consecutive");
			
		} catch (Exception e) {		
			LoggerApi.severe(e);
			return new ModelAndView("game/tinka/interface-consecutive");
		}finally{
			LoggerApi.Log.info("-------------- END game_tinka_show_consecutive"); 
		}
     
			
		
	}	
	
	@RequestMapping("/game_tinka_delete_consecutive")	
	public ModelAndView deleteConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
		
		try {

			LoggerApi.Log.info("-------------- START game_tinka_delete_consecutive"); 
					
			HttpSession session = request.getSession();				
			session.removeAttribute("consecutiveTinka_TK");
			session.removeAttribute("consecutiveTinkaValue_TK");	
			String[] ultima_jugada=new String[2];
			ultima_jugada[0]="removeConsecutive";
			ultima_jugada[1]="removeConsecutive";
			session.setAttribute("ultima_jugada", ultima_jugada);
			return new ModelAndView("redirect:game_tinka_show_shoppingcart.html");
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:game_tinka_show_shoppingcart.html");
		}finally{
			LoggerApi.Log.info("-------------- END game_tinka_delete_consecutive"); 
		}
	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/game_tinka_add_consecutive")	
	public ModelAndView addConsecutive(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		try {

		LoggerApi.Log.info("-------------- START game_tinka_add_consecutive"); 
		String consecutiveParam="";
		HttpSession session = null;
		HashMap[] consecutive=null;
		
		if(request!=null){
			if(request.getParameterValues("consecutive")!=null){
				consecutiveParam=(request.getParameterValues("consecutive")[0]!=null && !request.getParameterValues("consecutive")[0].toString().trim().equals(""))?request.getParameterValues("consecutive")[0].toString().trim():"";	
				session = request.getSession();	
			} 
		}
				
		if(session!=null) session.setAttribute("consecutiveTinka_TK",((consecutiveParam!=null)?consecutiveParam.trim():""));	
		if(session!=null){
			if(session.getAttribute("consecutiveTinkaList_TK")!=null){
				consecutive=(HashMap[]) session.getAttribute("consecutiveTinkaList_TK");	
			}
		}
		
		if(consecutive!=null && !ObjectUtils.isEmpty(consecutive)){
			for (HashMap item : consecutive) {
				
				if(StringUtils.equals(String.valueOf(item.get("NUM_DRAW")),consecutiveParam)){
					session.setAttribute("consecutiveTinkaValue_TK", item);
					break;
				}
			}	
		}
		String[] ultima_jugada=new String[2];
		ultima_jugada[0]="consecutive";
		ultima_jugada[1]="consecutive";
		session.setAttribute("ultima_jugada", ultima_jugada);
		return new ModelAndView("redirect:game_tinka_show_shoppingcart.html");	
			
		} catch (Exception e) {		
			LoggerApi.severe(e);
		    return new ModelAndView("redirect:game_tinka_show_shoppingcart.html");	
		}finally{
			LoggerApi.Log.info("-------------- END game_tinka_add_consecutive"); 
		}   
		
	}
	
	@RequestMapping(value = "/popup-tinka")
    public String popupTinka(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();        
        try {
        	session.setAttribute("popup-tinka-source", request.getParameter("source"));
        	session.setAttribute("popup-tinka-device", request.getParameter("device"));        
        	
            return "redirect:/game_tinka_show_menu.html";
        } catch (Exception e) {
            LoggerApi.severe(e);
            return "redirect:/game_tinka_show_menu.html";
        } finally {
        	
        }
    }
	
	@RequestMapping(value = "/popup-tinka-3x12")
    public void popupTinka3x12(HttpServletRequest request, HttpServletResponse response) {
		LoggerApi.Log.info("Ingresando a guardar data session de popupTinka3x12");
        HttpSession session = request.getSession();
        try {
        	session.setAttribute("popup-tinka-source", request.getParameter("source"));
        	session.setAttribute("popup-tinka-device", request.getParameter("device"));
        	response.getWriter().print(true);
        } catch (Exception e) {
            LoggerApi.severe(e);
        }
    }
	
	@RequestMapping(value = "/game-tinka-add-jugadas")
    public void addJugadas(HttpServletRequest request, HttpServletResponse response) {
		LoggerApi.Log.info("-------------- START game_tinka_add_jugadas");
        HttpSession session = request.getSession();
        Boolean todoOk = false;
        try {
        	
        	// Obtener el JSON de las jugadas enviado por AJAX
            String jsonJugadas = request.getParameter("jugadas");
            String consecutiveParam = request.getParameter("consecutive");
            
            // Convertir el JSON en un objeto que contenga todas las jugadas
            Gson gson = new Gson();
            Jugadas jugadas = gson.fromJson(jsonJugadas, Jugadas.class);
            
            List<Jugada> listJugadas = new ArrayList<Jugada>();
            listJugadas.add(jugadas.getJugada_A());
            listJugadas.add(jugadas.getJugada_B());
            listJugadas.add(jugadas.getJugada_C());
            listJugadas.add(jugadas.getJugada_D());
            
            for (Jugada jugada : listJugadas) {
            	if(jugada.getTotalJugada()<1 || jugada.getBolillas().size() < 6 ) continue;
            	
            	Map<String,Map<String,List<String>>> game=new HashMap();
            	
            	Map<String,List<String>> playList=new HashMap();
            	Map<String,String> cantidadBolillas = new LinkedHashMap();
            	List<String> playTinkaList =new ArrayList();
            	String cad_t="",cad_ult_t="";
            	
            	for (Integer bolilla : jugada.getBolillas() ) {
        			playTinkaList.add(bolilla.toString());
        		}
            	
            	playList.put("tinka",playTinkaList);
        		cad_t=String.valueOf(playTinkaList.size());
        		cad_ult_t=cad_ult_t+cad_t+"-";
        		cantidadBolillas.put("tinka_cad",cad_ult_t);
            	
        		
        		if(MapUtils.isEmpty(playList)) continue;
        		
        		String tipoBoleto = Constantes.BoletoTinka.boletoTinkaRegular;
        		
        		Integer jugadasBet = getTotalJugadas(playList);
        	
        		Tinka tinka = new Tinka();//null;
        		tinka = (Tinka) session.getAttribute(tipoBoleto);
        		
        		Double precioPorJugada=jugadasBet*tinka.getRegularPayment();
        		
        		
        		/*obtiene el boleto en caso exista en session segun el tipo de juego*/
        		if(tinka!=null && tinka.getGame()!=null && MapUtils.isNotEmpty(tinka.getGame())) game = tinka.getGame();
        		
        		session.setAttribute(Constantes.Boleto.idBoleto,"jugada_".concat(jugada.getId().toLowerCase()));
        		
        		String typePlayTinka = (String) session.getAttribute(Constantes.Boleto.idBoleto);

        		String[] ultima_jugada=new String[2];
        		ultima_jugada[0]=typePlayTinka;
        		ultima_jugada[1]="add";
        		session.setAttribute("ultima_jugada", ultima_jugada);
        		
        		Integer totalJugadaBoleto = validarCantidadJugadas(playList,game,typePlayTinka);
        		
        		if(totalJugadaBoleto!=null && (totalJugadaBoleto>5005 || totalJugadaBoleto==0)) {
        			LoggerApi.Log.info("/game_tinka_add_bet totalJugadaBoleto="+totalJugadaBoleto);
        		} else {
        			if(totalJugadaBoleto==null) totalJugadaBoleto = 0;
        		}
        		
        		tinka.setJugadasActuales(totalJugadaBoleto);
        		tinka.setJugadasLimite(5005-totalJugadaBoleto);
        		
        		if(typePlayTinka !=null && !typePlayTinka.trim().equals("")) game.put(typePlayTinka,playList);
        		TreeMap maping = new TreeMap();
        		if(MapUtils.isNotEmpty(game)) maping = new TreeMap(game);
        		
        		tinka.setGame(game);
        		tinka.setBolillas(playTinkaList);
        		tinka.setBoleto(maping);
        		session.setAttribute(tipoBoleto, tinka);
        		
        		String tipo = tinka.getTypeTinka().equals("REG")? "" : tinka.getDraws().toString();
        		String sehaceadd="si";
        		/*Esto puede ser reemplazado por tinka, testear cpn el boleto*/
        		session.setAttribute("jugada"+tipo, playList);
        		session.setAttribute("jugada_tk"+tipo, playTinkaList);
        		session.setAttribute("cadi"+tipo, cad_t);
        		session.setAttribute("precioPorJugada", precioPorJugada);
        		session.setAttribute("sehaceadd", sehaceadd);

        		session.setAttribute("lastJugada", cantidadBolillas);
        		session.setAttribute("valorRemo", "");
        		session.removeAttribute(Constantes.Boleto.idBoleto);
        		
                LoggerApi.Log.info(" /game_tinka_add_jugadas  -> Jugada " + jugada.toString());
            }
            
            HashMap[] consecutive=(HashMap[]) session.getAttribute("consecutiveTinkaList_TK");
            
            if(consecutive!=null && !ObjectUtils.isEmpty(consecutive)){
    			for (HashMap item : consecutive) {
    				
    				if(StringUtils.equals(String.valueOf(item.get("NUM_DRAW")),consecutiveParam)){
    					session.setAttribute("consecutiveTinkaValue_TK", item);
    					break;
    				}
    			}	
    		}
            
            // guardando la jugada en session
            IntralotUtils.carItemUpdate(session);
            session.setAttribute("consecutiveParam", consecutiveParam);
            session.setAttribute("jsonJugadas", jsonJugadas);
            
        	response.getWriter().print(true);
        	
        } catch (Exception e) {
            LoggerApi.severe(e);
        }finally {
        	LoggerApi.Log.info("-------------- END game_tinka_add_jugadas");
        }
    }
	
	@RequestMapping(value = "/game-tinka-delete-jugada")
    public void eliminarJugadaSession(HttpServletRequest request, HttpServletResponse response) {
		LoggerApi.Log.info("-------------- START game-tinka-delete-jugada");
        HttpSession session = request.getSession();
        Boolean todoOk = false;
        try {
        	session.removeAttribute("consecutiveTinka_TK");
        	session.removeAttribute("consecutiveTinkaValue_TK");
        	session.removeAttribute("totalTinkaSession_TK");
        	session.removeAttribute("consecutiveParam");
        	session.removeAttribute("jsonJugadas");
        	session.removeAttribute(Constantes.BoletoTinka.boletoTinkaRegular);
        	session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())-1);
            
        	response.getWriter().print(true);
        	
        } catch (Exception e) {
            LoggerApi.severe(e);
        }finally {
        	LoggerApi.Log.info("-------------- END game-tinka-delete-jugada");
        }
    }
        
	/**
	 * Unused
	 * @param request
	 * @param objectModelMap
	 * @return
	 * @throws Exception
	 */
	/*
	@SuppressWarnings({ "rawtypes", "static-access" })
	@RequestMapping("/game_tinka_play_bet")	
	public ModelAndView playBet(HttpServletRequest request, ModelMap objectModelMap) throws Exception {	
		
		
				
		HttpSession session = request.getSession();
		
		try {
			LoggerApi.Log.info("");
			
			Map map=null;
			boolean boletoTinkaRegular = session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null?true:false;
			LoggerApi.Log.info("/game_tinka_play_bet boletoTinkaRegular= "+boletoTinkaRegular);
			if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null){
				map=(Map) session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular);
			}
			if(session.getAttribute(Constantes.BoletoTinka.boletoTinkaRegular)!=null){
			
			boolean boletoTinkaNotEmpty = MapUtils.isNotEmpty(map);
			LoggerApi.Log.info("/game_tinka_play_bet boletoTinkaNotEmpty= "+boletoTinkaNotEmpty);	
			if(MapUtils.isNotEmpty(map)){
				
			Game game = new Game();
			game.setGame(Game.TINKA);
			
			GroupAPI[] group = new GroupAPI[map.size()];
			
			int count=0;

			if(map.size()>0) {
				for(Iterator it=map.keySet().iterator();it.hasNext();) {
					String mapa = (String)it.next();						
					Map maping =(Map) map.get(mapa);			
							
					List playTinkaList =(List) maping.get("tinka");
					
					int[] numbers = new int[playTinkaList.size()];
					
					int tinkaCount=0;
					for (Object item : playTinkaList) {
						numbers[tinkaCount]=Integer.valueOf((String) item);
						tinkaCount++;
					}
			        group[count] = new GroupAPI();
			        group[count].setLottoBet(Game.TINKA, Group.NORMAL, numbers);
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
		web.setMessageId("W" + d.getTimeLong() + Game.TINKA);
		web.setCarrier("MOBILE");
		
		String messageResult=StringUtils.EMPTY;	
		
		int numbersConsecutive=1;
		if(MapUtils.isNotEmpty((Map) session.getAttribute("consecutiveTinkaValue_TK"))){
			 numbersConsecutive= Integer.valueOf(((Map) session.getAttribute("consecutiveTinkaValue_TK")).get("NUM_DRAW").toString());	
		}
		
		double priceSale =0.0;
		if(session.getAttribute("totalTinkaSession_TK") != null){
			 priceSale =(Double) session.getAttribute("totalTinkaSession_TK");
		}
		ClientTicket ct = new ClientTicket();
		ct = accountController.playCouponByWebTransaction(client, web, game, numbersConsecutive, group, priceSale);
		if(ct.getMessage() != null) messageResult = ct.getMessage();
		
		LoggerApi.Log.info("/game_tinka_play_bet messageResult="+messageResult);
		if(messageResult.equals("OK")) {			
			session.removeAttribute("consecutiveTinka_TK");
			session.removeAttribute("consecutiveTinkaValue_TK");
			session.removeAttribute("totalTinkaSession_TK");
			session.removeAttribute(Constantes.BoletoTinka.boletoTinkaRegular);
			session.setAttribute("LottoCar",Integer.parseInt(session.getAttribute("LottoCar").toString())-1);
			session.setAttribute("alertPlay","Jugada realizada con &eacute;xito!");
			session.setAttribute("alertPlay2","Gracias por tu compra");
			IntralotUtils.carItemUpdate(session);
			return new ModelAndView("redirect:client_play_show_information.html?game=tinka&status=ok");
		} else if(StringUtils.contains(messageResult,"CLIENTE NO EXISTE")) {
			session.setAttribute("alertPlay","No se ha encontrado el registro del cliente");
			return new ModelAndView("redirect:client_play_show_information.html?game=tinka&status=error");
		} else if(StringUtils.contains(messageResult,"CREDITO INSUFICIENTE") || StringUtils.contains(messageResult, "Cuenta Lotocard ha expirado")) {		
			session.setAttribute("alertPlay","No cuenta con saldo disponible para realizar este proceso");
			return new ModelAndView("redirect:client_play_show_information.html?game=tinka&status=error");
		} else {		
			session.setAttribute("alertPlay","Ocurrio un error intente nuevamente  ");	
			return new ModelAndView("redirect:client_play_show_information.html?game=tinka&status=error");
		}		
		
		}
			}
		return new ModelAndView("redirect:client_play_show_information.html?game=tinka&status=error");
		
		} catch (Exception e) {
			session.setAttribute("alertPlay","Ocurrio un error intente nuevamente ");
			LoggerApi.severe(e);
			return new ModelAndView("redirect:client_play_show_information.html?game=tinka&status=error");
		}finally{
			//LoggerApi.Log.info("Salir al metodo: playBet. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir al action: TinkaController.");
		} -
	
	}
	*/
	
	
}



