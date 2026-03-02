package pe.com.intralot.loto.layer.view.game.teapuesto;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import pe.com.intralot.loto.layer.controller.client.bo.PromSorteoBo;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetFlagClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetTicketsClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureInsertClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListFechaPromo;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListTicketClient;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;

@Controller
public class AvionQatarController {
	
	@Autowired
	private PromSorteoBo promSorteoBo;
	
	private static final String COD_PROMO = "AVION_QATAR";
	
	private static final String PROM_CHANNEL = "MOBILE";
	
	private static final Integer DIAS_EXTRAS = -7;
	
	@RequestMapping("/te-apuesto-te-lleva-final-qatar-registrar")
	public ModelAndView teApuestoLlevaQatarRegistrar(HttpServletRequest request, ModelMap objectModelMap) {
		try {
		
		LoggerApi.Log.info("Ingresando a registro promo - te apuesto te lleva a qatar");
		
		HttpSession session = request.getSession();
		String idClient = "";
		idClient = session.getAttribute("clientId").toString().trim();
		 
		if(idClient.isEmpty())	return new ModelAndView("redirect:te-apuesto-te-lleva-final-qatar.html");
		
		PromProcedureInsertClient insertClient = promSorteoBo.insertClient(COD_PROMO, Integer.parseInt(idClient) ,PROM_CHANNEL);
		
		if(insertClient.getState().equals(0))
			return new ModelAndView("redirect:home.html");
		
		return new ModelAndView("redirect:te-apuesto-te-lleva-final-qatar-resultados.html");
		
		}catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:te-apuesto-te-lleva-final-qatar.html");
		}
		
							
	}
		
	@RequestMapping("/te-apuesto-te-lleva-final-qatar")	
	public ModelAndView teApuestoLlevaQatar(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		try {
			LoggerApi.Log.info("Ingresando a landing - te apuesto te lleva a qatar");
			HttpSession session = request.getSession();
			Calendar calendarHoy = Calendar.getInstance();
			Calendar calendarInit = Calendar.getInstance();
			Calendar calendarFin = Calendar.getInstance();
			
			List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
			int idClient = session.getAttribute("clientId") != null? Integer.parseInt(session.getAttribute("clientId").toString().trim()) : 0;
			PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO, idClient );
			
			for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
				
				if(!fechaPromo.getValue().equals("PAGE")) continue;
				
				calendarInit.setTime(fechaPromo.getDateInit());
				calendarFin.setTime(fechaPromo.getDateFin());
				
				if( calendarHoy.before(calendarInit) )	return new ModelAndView("redirect:home.html");
				
				if(promProcedureGetFlagClient.isFlagClient())	calendarHoy.add(Calendar.DAY_OF_MONTH, DIAS_EXTRAS);
				
				if( calendarHoy.after(calendarFin) )	return new ModelAndView("redirect:home.html");
				 
			}
			 
			if(session.getAttribute("clientId") == null || !promProcedureGetFlagClient.isFlagClient())	
				return new ModelAndView("game/teapuesto/avionQatar/interface-home-registro");
			
    		objectModelMap.put("clientId", idClient);
    		 
			return new ModelAndView("game/teapuesto/avionQatar/interface-home");
			
							
		} catch (Exception e) {
			LoggerApi.Log.info(e.getMessage());
			return new ModelAndView("game/teapuesto/avionQatar/interface-home-registro");
		}	
	}
	
	
	@RequestMapping("/te-apuesto-te-lleva-final-qatar-como-participar")	
	public ModelAndView teApuestoLlevaQatarComoParticipar(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		try {
			
			LoggerApi.Log.info("Ingresando a como participar - te apuesto te lleva a qatar");
			HttpSession session = request.getSession();
			Calendar calendarHoy = Calendar.getInstance();
			Calendar calendarInit = Calendar.getInstance();
			Calendar calendarFin = Calendar.getInstance();
			
			List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
			int idClient = session.getAttribute("clientId") != null? Integer.parseInt(session.getAttribute("clientId").toString().trim()) :0;
			PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO, idClient );
			
			for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
				
				if(!fechaPromo.getValue().equals("PAGE")) continue;
				
				calendarInit.setTime(fechaPromo.getDateInit());
				calendarFin.setTime(fechaPromo.getDateFin());
				
				if( calendarHoy.before(calendarInit) )	return new ModelAndView("redirect:home.html");
				
				if(promProcedureGetFlagClient.isFlagClient())	calendarHoy.add(Calendar.DAY_OF_MONTH, DIAS_EXTRAS);
				
				if( calendarHoy.after(calendarFin) )	return new ModelAndView("redirect:home.html");
				 
			}
			
			objectModelMap.put("flagPromo", promProcedureGetFlagClient.isFlagClient());
			
			return new ModelAndView("game/teapuesto/avionQatar/interface-take-part");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/teapuesto/avionQatar/interface-take-part");
		}	
	}
	
	@RequestMapping("/te-apuesto-te-lleva-final-qatar-resultados")	
	public ModelAndView teApuestoLlevaQatarResultados(HttpServletRequest request, ModelMap modelList) throws Exception {
						
		LoggerApi.Log.info("Ingresando a resultados - te apuesto te lleva a qatar");
		HttpSession session = request.getSession();
	     	    	 
	    double puntaje=0;
	    int puntajeNivel=0;
	    Date fechaHoy= new Date();
	    String sorteoActivo= "0";
	    int cantSorteoPromo=0;

		try {
			
			Calendar calendarHoy = Calendar.getInstance();
			Calendar calendarInit = Calendar.getInstance();
			Calendar calendarFin = Calendar.getInstance();
			
			List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
			int idClient = session.getAttribute("clientId") != null ? Integer.parseInt(session.getAttribute("clientId").toString().trim()) : 0;
			
			PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO, idClient );
			
			for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
				
				if(!fechaPromo.getValue().equals("PAGE")) continue;
				
				calendarInit.setTime(fechaPromo.getDateInit());
				calendarFin.setTime(fechaPromo.getDateFin());
				
				if( calendarHoy.before(calendarInit) )	return new ModelAndView("redirect:home.html");
				
				if(promProcedureGetFlagClient.isFlagClient())	calendarHoy.add(Calendar.DAY_OF_MONTH, DIAS_EXTRAS);
				
				if( calendarHoy.after(calendarFin) )	return new ModelAndView("redirect:home.html");
				 
			}
			
			List<PromProcedureGetTicketsClient> list = promSorteoBo.getTicketsClient(COD_PROMO, idClient);				
			String pattern = "dd ' de ' MMMMM";			
			SimpleDateFormat simpleDateFormat =
			        new SimpleDateFormat(pattern, new Locale("es","PE"));
			
			boolean verifyPromo = promProcedureGetFlagClient.isFlagClient();
			
			if(list.isEmpty() || idClient==0 || !verifyPromo ) {
				return new ModelAndView("redirect:te-apuesto-te-lleva-final-qatar.html");
			}
			
			for(PromProcedureGetTicketsClient objList : list) {
														
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
			}else if(cantSorteoPromo>=10 && cantSorteoPromo<=49) {
				puntaje = cantSorteoPromo*2;
			}else if(cantSorteoPromo>=50 && cantSorteoPromo<=99) {
				puntaje = cantSorteoPromo*2.5;
			}else if(cantSorteoPromo>=100) {
				puntaje = cantSorteoPromo*3;
			}
			
			puntajeNivel = (int) Math.round(puntaje);
			
			request.setAttribute("activaPremio",sorteoActivo);
            request.setAttribute("totalTicket",cantSorteoPromo);
            request.setAttribute("puntajeNivel",puntajeNivel);
			modelList.put("listTickets",list);
			
			return new ModelAndView("game/teapuesto/avionQatar/interface-results");
					
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("redirect:te-apuesto-te-lleva-final-qatar.html");
		}	
	}
	
	@RequestMapping("/te-apuesto-te-lleva-final-qatar-resultados-popup")	
	public void teApuestoLlevaQatarResultadosPopup(HttpServletRequest request,HttpServletResponse response) throws Exception {

		LoggerApi.Log.info("Ingresando a popup Resultados - te apuesto te lleva a qatar");
		
		HttpSession session = request.getSession();
	    int clientId = 0;	    	 
	    double puntaje=0;
	    int puntajeNivel=0;	
	    int cantSorteoPromo=0;
	    response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
	    String refList = "";
	    String ticketList="";
	    int contadorTickets=0;
	    int activarPremio= 0;
	   
		try {			
			
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			List<PromProcedureGetTicketsClient> list = promSorteoBo.getTicketsClient(COD_PROMO, clientId);

			if(list.isEmpty() || clientId==0) {
				o.addProperty("message", "Incidente inesperado");
				out.print(o);
				return;
			}
			
			for(PromProcedureGetTicketsClient objList : list) {
				cantSorteoPromo = cantSorteoPromo + Integer.parseInt(objList.getPromCount());																		 						  				   						   									
			}
															
			if(cantSorteoPromo>=1 && cantSorteoPromo<=9 ) {
				puntaje = cantSorteoPromo*1.5;
			}else if(cantSorteoPromo>=10 && cantSorteoPromo<=49) {
				puntaje = cantSorteoPromo*2;
			}else if(cantSorteoPromo>=50 && cantSorteoPromo<=99) {
				puntaje = cantSorteoPromo*2.5;
			}else if(cantSorteoPromo>=100) {
				puntaje = cantSorteoPromo*3;
			}
			
			puntajeNivel = (int) Math.round(puntaje);
			List<PromProcedureListTicketClient> listTicketWin = promSorteoBo.getListTicketsClient(COD_PROMO, clientId);
			
			if(!listTicketWin.isEmpty()) {
				for (PromProcedureListTicketClient listTicketClient : listTicketWin) {
					 refList = refList + ", " + listTicketClient.getTicketId();
					 contadorTickets ++;
				}
				ticketList = refList.substring(1);
				activarPremio= 1;
			}
			
			o.addProperty("activarPremio",activarPremio);	
			o.addProperty("totalTickets",contadorTickets);				 
			o.addProperty("ticketsWin",ticketList);				
			o.addProperty("nivel",cantSorteoPromo);
			o.addProperty("puntajeNivel",puntajeNivel);
			out.print(o);
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
			
		}	
	}
	
	
	
	@RequestMapping("/te-apuesto-te-lleva-final-qatar-verificar-promocion")
	public void teApuestoLlevaQatarValidarClientePromocion(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		LoggerApi.Log.info("Ingresando a verificar client_promo - te apuesto te lleva a qatar");
		
		HttpSession session = request.getSession();
		String idClient = "";
		int clientId = 0;
		clientId = (session.getAttribute("clientId")!=null) ? Integer.valueOf((String) session.getAttribute("clientId")) : 0;
		  
		response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
	 
		PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO,clientId );
		boolean verifyPromo = promProcedureGetFlagClient.isFlagClient(); 
		
		o.addProperty("flagPromo",verifyPromo);
	    out.print(o);		
	}
	
	@RequestMapping("/te-apuesto-te-lleva-final-qatar-fechas-popup")
	public void teApuestoLlevaQatarValidarFechaPopup(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		LoggerApi.Log.info("Ingresando a verificar fechas popup - te apuesto te lleva a qatar");
		
		HttpSession session = request.getSession(); 
		int clientId = 0;
		clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
		
		response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
	 
		PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO,clientId );
		boolean verifyPromo = promProcedureGetFlagClient.isFlagClient();
			
		// validando las fechas de la promocion
		List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
		Date fechaDay = new Date();
		boolean flagPopup = false;
		for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
			if( fechaPromo.getValue().equals("POPUP") &&  fechaDay.after(fechaPromo.getDateInit()) && fechaDay.before(fechaPromo.getDateFin())  ) 
				flagPopup = true; 
			 
		}
		
		o.addProperty("flagPopup",flagPopup);
		
	    out.print(o);
	}
		
  
}
