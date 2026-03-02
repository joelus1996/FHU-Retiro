package pe.com.intralot.loto.layer.view.game.copacasa;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.game.ganagol.bo.GanagolBetBo;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetWinCup;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoPromoList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class CopaCasaController {
	
	@Autowired
	private ClientBalanceBo clientBalanceBo;
	
	@RequestMapping("/lacopaentucasa")	
	public ModelAndView showMenuHouseCup(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		return new ModelAndView("home/interface-home");
		
		/*
		//LoggerApi.Log.info("Ingresando a game_copaentucasa_show_menu");
		HttpSession session = request.getSession();
		String idClient = "";
	    int idClientInt = 0;
		try {
			//LoggerApi.Log.info("Chekando cliente en session");
			if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    		idClientInt = Integer.parseInt(idClient);
	    	}
			
			objectModelMap.put("clientId", idClient);
			return new ModelAndView("game/copaentucasa/interface-home");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/copaentucasa/interface-home");
		}	*/
	}
	
	@RequestMapping("/game_copaentucasa_how-part")	
	public ModelAndView showHowPart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		return new ModelAndView("home/interface-home");
		
		/*
		//LoggerApi.Log.info("Ingresando a game_copaentucasa_show_menu");
		HttpSession session = request.getSession();
		String idClient = "";
	    int idClientInt = 0;
		try {
			//LoggerApi.Log.info("Chekando cliente en session");
			if(session.getAttribute("clientId") != null) {
	    		idClient = session.getAttribute("clientId").toString().trim();
	    		idClientInt = Integer.parseInt(idClient);
	    	}
			
			objectModelMap.put("clientId", idClient);
			return new ModelAndView("game/copaentucasa/interface-take-part");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/copaentucasa/interface-take-part");
		}	*/
	}
	
	
	@RequestMapping("/game_copaentucasa_results")	
	public ModelAndView resulstHouseCup(HttpServletRequest request, ModelMap modelList) throws Exception {
		
		return new ModelAndView("home/interface-home");
		
		/*
		//LoggerApi.Log.info("Ingresando a game_copaentucasa_show_menu");
		HttpSession session = request.getSession();
	    int clientId = 0;	    	 
	    double puntaje=0;
	    int puntajeNivel=0;
	    Date fechaHoy= new Date();
	    String sorteoActivo= "0";
	    int cantSorteoPromo=0;
	    String cantPremio="";
	    String activarWin="0";
	    String messageWallet = "";
	   
		try {			
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			List<ClientProcedureGetTeApuestoPromoList> list = clientBalanceBo.getTeApuestoPromoAccount(clientId);
								
			String pattern = "dd ' de ' MMMMM";			
			SimpleDateFormat simpleDateFormat =
			        new SimpleDateFormat(pattern, new Locale("es","PE"));
			
			
			if(!list.isEmpty() && clientId!=0) {
				String promo1="";
            	String fecha1 = "";
            	String promo2="";
            	String fecha2 = "";
            	String promo3="";
            	String fecha3 = "";
            	String promo4="";
            	String fecha4 = "";
            	String promo5="";
            	String fecha5 = "";
            	String promo6="";
            	String fecha6 = "";
            	String promo7="";
            	String fecha7 = "";
            	String promo8="";
            	String fecha8 = "";
            	String promo9="";
            	String fecha9 = "";
				for(ClientProcedureGetTeApuestoPromoList objList : list) {
					
						if(objList.getPromId().equals("TAF301")) {
							 promo1 = objList.getPromId();
							 fecha1 = objList.getPromDate();
							
						}else if(objList.getPromId().equals("TAF302")) {
							 promo2 = objList.getPromId();
							 fecha2 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF303")) {
							promo3 = objList.getPromId();
							 fecha3 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF304")) {
							 promo4 = objList.getPromId();
							 fecha4 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF305")) {
							 promo5 = objList.getPromId();
							 fecha5 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF306")) {
							 promo6 = objList.getPromId();
							 fecha6 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF307")) {
							 promo7 = objList.getPromId();
							 fecha7 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF308")) {
							 promo8 = objList.getPromId();
							 fecha8 = objList.getPromDate();
						}else if(objList.getPromId().equals("TAF309")) {
							 promo9 = objList.getPromId();
							 fecha9 = objList.getPromDate();
						}
					
						Date datePromo =new SimpleDateFormat("dd/MM/yyyy").parse(objList.getPromDate()); 
						long timeFechaPromo = datePromo.getTime();
						cantSorteoPromo = cantSorteoPromo + Integer.parseInt(objList.getPromCount());
				
						String fechaPromo = simpleDateFormat.format(datePromo);
						
						objList.setPromDate(fechaPromo);
						
						if(fechaHoy.getTime() < timeFechaPromo && Integer.parseInt(objList.getPromCount())>0 ) {    							
							sorteoActivo = objList.getPromId();
						}    						  				   						   					
					
				}
												
				if(cantSorteoPromo>=1 && cantSorteoPromo<=9 ) {
					puntaje = cantSorteoPromo*1.5;
				}else if(cantSorteoPromo>=10 && cantSorteoPromo<=29) {
					puntaje = cantSorteoPromo*2;
				}else if(cantSorteoPromo>=30 && cantSorteoPromo<=59) {
					puntaje = cantSorteoPromo*2.5;
				}else if(cantSorteoPromo>=60) {
					puntaje = cantSorteoPromo*3;
				}
				puntajeNivel = (int) Math.round(puntaje);
				
				Date dateProm1 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha1); 
				long timeDateProm1 = dateProm1.getTime();
				Date dateProm2 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha2); 
				long timeDateProm2 = dateProm2.getTime();
				Date dateProm3 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha3); 
				long timeDateProm3 = dateProm3.getTime();
				Date dateProm4 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha4); 
				long timeDateProm4 = dateProm4.getTime();
				Date dateProm5 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha5); 
				long timeDateProm5 = dateProm5.getTime();
				Date dateProm6 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha6); 
				long timeDateProm6 = dateProm6.getTime();
				Date dateProm7 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha7); 
				long timeDateProm7 = dateProm7.getTime();
				Date dateProm8 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha8); 
				long timeDateProm8 = dateProm8.getTime();
				Date dateProm9 =new SimpleDateFormat("dd/MM/yyyy").parse(fecha9); 
				long timeDateProm9 = dateProm9.getTime();
				
				
				if(fechaHoy.getTime()>=timeDateProm1 && fechaHoy.getTime()<timeDateProm2 ) {    	//12-31				
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo1);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
					
				}else if(fechaHoy.getTime()>=timeDateProm2 && fechaHoy.getTime()<timeDateProm3 ) { //31-07
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo2);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm3 && fechaHoy.getTime()<timeDateProm4 ) {//07-14
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo3);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm4 && fechaHoy.getTime()<timeDateProm5 ) {//14-21
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo4);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm5 && fechaHoy.getTime()<timeDateProm6 ) {//21-28
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo5);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm6 && fechaHoy.getTime()<timeDateProm7 ) {//28-05
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo6);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";	
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm7) {
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo7);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm8) {
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo8);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}else if(fechaHoy.getTime()>=timeDateProm9) {
					BalanceProcedureGetWinCup winPromCup = clientBalanceBo.findWinProm(clientId,promo9);
					if(winPromCup!= null) {
						cantPremio = winPromCup.getPrizeAmount();
						activarWin = "1";
						String wallet = winPromCup.getTipoWallet();
						if(wallet.equals("1")) {
							messageWallet="saldo";
						}else if(wallet.equals("2")) {
							messageWallet="bono";
						}
					}
				}
				
				request.setAttribute("activaPremio",sorteoActivo);
                request.setAttribute("totalTicket",cantSorteoPromo);
                request.setAttribute("puntajeNivel",puntajeNivel);
                request.setAttribute("win",activarWin);
                request.setAttribute("totalPremio", cantPremio);
                request.setAttribute("tipoPremio", messageWallet);
    			modelList.put("listTickets",list);
				
				return new ModelAndView("game/copaentucasa/interface-results");	
								
			}else {
				
				return new ModelAndView("game/copaentucasa/interface-home");
			}
					
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/copaentucasa/interface-results");
		}	*/
	}
	
	@RequestMapping("/game_copaentucasa_results_popup")	
	public void resulstHouseCupPopup(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//LoggerApi.Log.info("Ingresando a game_copaentucasa_show_menu");
		HttpSession session = request.getSession();
	    int clientId = 0;	    	 
	    double puntaje=0;
	    int puntajeNivel=0;
	    Date fechaHoy= new Date();
	    String sorteoActivo= "0";
	    int cantSorteoPromo=0;
	    response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
	   
		try {			
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			List<ClientProcedureGetTeApuestoPromoList> list = clientBalanceBo.getTeApuestoPromoAccount(clientId);
								
			String pattern = "dd ' de ' MMMMM";			
			SimpleDateFormat simpleDateFormat =
			        new SimpleDateFormat(pattern, new Locale("es","PE"));
			
			
			if(!list.isEmpty() && clientId!=0) {
				for(ClientProcedureGetTeApuestoPromoList objList : list) {
					
						Date datePromo =new SimpleDateFormat("dd/MM/yyyy").parse(objList.getPromDate()); 
						long timeFechaPromo = datePromo.getTime();
						cantSorteoPromo = cantSorteoPromo + Integer.parseInt(objList.getPromCount());
				
						String fechaPromo = simpleDateFormat.format(datePromo);
						
						objList.setPromDate(fechaPromo);
						
						if(fechaHoy.getTime() < timeFechaPromo && Integer.parseInt(objList.getPromCount())>0 ) {    							
							sorteoActivo = objList.getPromId();
						}    						  				   						   					
					
				}
												
				if(cantSorteoPromo>=1 && cantSorteoPromo<=9 ) {
					puntaje = cantSorteoPromo*1.5;
				}else if(cantSorteoPromo>=10 && cantSorteoPromo<=29) {
					puntaje = cantSorteoPromo*2;
				}else if(cantSorteoPromo>=30 && cantSorteoPromo<=59) {
					puntaje = cantSorteoPromo*2.5;
				}else if(cantSorteoPromo>=60) {
					puntaje = cantSorteoPromo*3;
				}
				puntajeNivel = (int) Math.round(puntaje);
				
				//request.setAttribute("activaPremio",sorteoActivo);
                //request.setAttribute("totalTicket",cantSorteoPromo);
                //request.setAttribute("puntajeNivel",puntajeNivel);
				o.addProperty("totalTicket",cantSorteoPromo);
				o.addProperty("puntajeNivel",puntajeNivel);
				out.print(o);
								
			}else {
				
				o.addProperty("message", "Incidente inesperado");
			}
					
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			
		}	
	}
		

}
