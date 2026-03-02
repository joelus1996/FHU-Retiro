package pe.com.intralot.loto.layer.view.game.virtuales;

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

@Controller
public class JuegaGanaDeportesVirtualesController {
	
	@Autowired
	private PromSorteoBo promSorteoBo;
	
	private static final String COD_PROMO = "JUEGA_GANA_DDVV_V2";
	
	private static final String PROM_CHANNEL = "MOBILE";
	
	private static final Integer DIAS_EXTRAS = -7;
	
	/**
	 * rutas de los archivos
	 * */
	
	private static final String RUTA_PRINCIPAL = "game/virtuales/juegaGanaConVirtuales/";
	
	private static final String RUTA_HOME_REGISTRO = RUTA_PRINCIPAL + "interface-home-registro";
	
	private static final String RUTA_HOME = RUTA_PRINCIPAL + "interface-home";
	
	private static final String RUTA_TYC = RUTA_PRINCIPAL + "interface-take-part";
	
	private static final String RUTA_RESULTADOS = RUTA_PRINCIPAL + "interface-results";
	
	/**
	 * url's de las paginas
	 * */
	
	private static final String URL_HOME_PROMO = "juega-y-gana-con-virtuales";
	
	private static final String URL_TYC = URL_HOME_PROMO + "-como-participar";
	
	private static final String URL_REGISTRAR = URL_HOME_PROMO + "-registrar";
	
	private static final String URL_RESULTADOS = URL_HOME_PROMO + "-resultados";
	
	private static final String URL_RESULTADOS_POPUP = URL_HOME_PROMO + "-resultados-popup";
	
	private static final String URL_VERIFICAR_PROMO = URL_HOME_PROMO + "-verificar-promocion";
	
	private static final String URL_FECHAS_POPUP = URL_HOME_PROMO + "-fechas-popup";
	
	private static final String DESCRIPCION = "juega y gana con Virtuales";
	
	/**
	 * redirect's
	 * */
	
	private static final String REDIRECT = "redirect:/";
	
	private static final String REDIRECT_HOME = "redirect:"+URL_HOME_PROMO+".html";
	
	private static final String REDIRECT_RESULTADOS = "redirect:"+URL_RESULTADOS+".html";
	
	
	@RequestMapping("/"+URL_HOME_PROMO)	
	public ModelAndView teApuestoLlevaEstambul(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
								
		HttpSession session = request.getSession();

		try {
			LoggerApi.Log.info("Ingresando a landing - " + DESCRIPCION);
			
			Calendar calendarHoy = Calendar.getInstance();
			Calendar calendarInit = Calendar.getInstance();
			Calendar calendarFin = Calendar.getInstance();
			List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
			
			Integer idClient = promSorteoBo.getByIdClient(session);
					
            PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO, idClient );
            
            for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
            	
            	if(fechaPromo.getValue().equals("PROMOCION")) 
					request.setAttribute("fechaPromo",promSorteoBo.formatearFechaPromocion(fechaPromo.getDateInit(),fechaPromo.getDateFin()));
				
				if(!fechaPromo.getValue().equals("PAGE")) continue;
				
				calendarInit.setTime(fechaPromo.getDateInit());
				calendarFin.setTime(fechaPromo.getDateFin());
				
				if( calendarHoy.before(calendarInit) )	return new ModelAndView(REDIRECT);
				
				if(promProcedureGetFlagClient.isFlagClient())	calendarHoy.add(Calendar.DAY_OF_MONTH, DIAS_EXTRAS); 
				
				if( calendarHoy.after(calendarFin) )	return new ModelAndView(REDIRECT);
				
				
			}
            
			if(idClient == 0 || !promProcedureGetFlagClient.isFlagClient() ) 
				return new ModelAndView(RUTA_HOME_REGISTRO);
			
			objectModelMap.put("clientId", idClient);
			
			return new ModelAndView(RUTA_HOME);
							
		} catch (Exception e) {
			LoggerApi.Log.info(e.getMessage());
			return new ModelAndView(REDIRECT);
		}	
	}
	
	@RequestMapping("/"+URL_TYC)	
	public ModelAndView teApuestoLlevaEstambulComoParticipar(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		try {
			
			LoggerApi.Log.info("Ingresando a como participar - " + DESCRIPCION);
			HttpSession session = request.getSession();

			Calendar calendarHoy = Calendar.getInstance();
			Calendar calendarInit = Calendar.getInstance();
			Calendar calendarFin = Calendar.getInstance();
			
			List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
			
			Integer idClient = promSorteoBo.getByIdClient(session);
			
	        PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO, idClient );
	            
	        for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
	        	
	        	if(fechaPromo.getValue().equals("PROMOCION")) 
					request.setAttribute("fechaPromo",promSorteoBo.formatearFechaPromocion(fechaPromo.getDateInit(),fechaPromo.getDateFin()));
	        	        	
	        	if(fechaPromo.getValue().contains("SORTEO"))
					request.setAttribute(fechaPromo.getValue(),promSorteoBo.formatearFechaSorteo(fechaPromo.getDateFin()));
	        	
				if(!fechaPromo.getValue().equals("PAGE")) continue;
				
				calendarInit.setTime(fechaPromo.getDateInit());
				calendarFin.setTime(fechaPromo.getDateFin());
				
				if( calendarHoy.before(calendarInit) )	return new ModelAndView(REDIRECT);
				
				if(promProcedureGetFlagClient.isFlagClient())	calendarHoy.add(Calendar.DAY_OF_MONTH, DIAS_EXTRAS);
				
				if( calendarHoy.after(calendarFin) )	return new ModelAndView(REDIRECT);
				 
			}

			objectModelMap.put("flagPromo", promProcedureGetFlagClient.isFlagClient());
			
			return new ModelAndView(RUTA_TYC);
			
		} catch (Exception e) {
			LoggerApi.Log.info(e.getMessage());
			return new ModelAndView(REDIRECT_HOME);
		}	
	}
	
	@RequestMapping("/"+URL_REGISTRAR)
	public ModelAndView teApuestoLlevaEstambulRegistrar(HttpServletRequest request, ModelMap objectModelMap) {
								
		LoggerApi.Log.info("Ingresando a registro promo - " + DESCRIPCION);
		try {
			
		HttpSession session = request.getSession();

		Integer idClient = promSorteoBo.getByIdClient(session);
		
		if(idClient == 0) return new ModelAndView(REDIRECT_HOME);
		
		PromProcedureInsertClient insertClient = promSorteoBo.insertClient(COD_PROMO, idClient ,PROM_CHANNEL);
			
		if(insertClient.getState().equals(0))
			return new ModelAndView(REDIRECT_HOME);
			
		
		return new ModelAndView(REDIRECT_RESULTADOS);
		
		}catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView(REDIRECT_HOME);
		}
		
							
	}
	
	@RequestMapping("/"+URL_RESULTADOS)	
	public ModelAndView teApuestoLlevaEstambulResultados(HttpServletRequest request, ModelMap modelList) throws Exception {
		
		LoggerApi.Log.info("Ingresando a resultados - " + DESCRIPCION);
		HttpSession session = request.getSession();
	    double puntaje=0;
	    int puntajeNivel=0;
	    Date fechaHoy= new Date();
	    String sorteoActivo= "0";
	    int cantSorteoPromo=0;
	    Calendar calendarHoy = Calendar.getInstance();
		Calendar calendarInit = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();
	   
		try {		
			List<PromProcedureListFechaPromo> listFechaPromo = promSorteoBo.getListFechaPromo(COD_PROMO);
			
			Integer idClient = promSorteoBo.getByIdClient(session);
            
            PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO, idClient );
			
			for(PromProcedureListFechaPromo fechaPromo : listFechaPromo) {
				
				if(fechaPromo.getValue().equals("PROMOCION")) 
					request.setAttribute("fechaPromo", promSorteoBo. formatearFechaPromocion(fechaPromo.getDateInit(),fechaPromo.getDateFin()));
	        	
	        	if(fechaPromo.getValue().contains("SORTEO1"))
					request.setAttribute(fechaPromo.getValue(), promSorteoBo.formatearFechaSorteoSinAnio(fechaPromo.getDateFin()));
	        	
	        	if(fechaPromo.getValue().contains("SORTEO2"))
					request.setAttribute(fechaPromo.getValue(), promSorteoBo.formatearFechaSorteo(fechaPromo.getDateFin()));
	        	
				if(!fechaPromo.getValue().equals("PAGE")) continue;
				
				calendarInit.setTime(fechaPromo.getDateInit());
				calendarFin.setTime(fechaPromo.getDateFin());
				
				if( calendarHoy.before(calendarInit) )	return new ModelAndView(REDIRECT);
				
				if(promProcedureGetFlagClient.isFlagClient())	calendarHoy.add(Calendar.DAY_OF_MONTH, DIAS_EXTRAS);
				
				if( calendarHoy.after(calendarFin) )	return new ModelAndView(REDIRECT);
				 
			}
             
			List<PromProcedureGetTicketsClient> list = promSorteoBo.getTicketsClient(COD_PROMO, idClient);				
			
			String pattern = "dd ' de ' MMMMM";			
			SimpleDateFormat simpleDateFormat =
			        new SimpleDateFormat(pattern, new Locale("es","PE"));
			 
			boolean verifyPromo = promProcedureGetFlagClient.isFlagClient();
			
			if(list.isEmpty() || idClient==0 || !verifyPromo ) {
				return new ModelAndView(REDIRECT_HOME);
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
			
			puntajeNivel = (int) Math.round(promSorteoBo.puntajePorJugadas(cantSorteoPromo));
			
			request.setAttribute("activaPremio",sorteoActivo);
            request.setAttribute("totalTicket",cantSorteoPromo);
            request.setAttribute("puntajeNivel",puntajeNivel);
			modelList.put("listTickets",list);
			
			return new ModelAndView(RUTA_RESULTADOS);
					
		} catch (Exception e) {
			LoggerApi.Log.info(e.getMessage());
			return new ModelAndView(REDIRECT_HOME);
		}	
	}
	
	@RequestMapping("/"+URL_RESULTADOS_POPUP)	
	public void teApuestoLlevaEstambulResultadosPopup(HttpServletRequest request,HttpServletResponse response) throws Exception {

		LoggerApi.Log.info("Ingresando a popup Resultados - " + DESCRIPCION);
		
		HttpSession session = request.getSession();
	    	 
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
			
			Integer idClient = promSorteoBo.getByIdClient(session);
			
			List<PromProcedureGetTicketsClient> list = promSorteoBo.getTicketsClient(COD_PROMO, idClient);
						
			if(list.isEmpty() || idClient==0) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "el usuario no esta en la promoción");
				return;
			}

			for(PromProcedureGetTicketsClient objList : list) {					
				cantSorteoPromo = cantSorteoPromo + Integer.parseInt(objList.getPromCount());																		 						  				   						   									
			}
																
			puntajeNivel = (int) Math.round(promSorteoBo.puntajePorJugadas(cantSorteoPromo));
			
			List<PromProcedureListTicketClient> listTicketWin = promSorteoBo.getListTicketsClient(COD_PROMO, idClient);

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
			  
					
		} catch (Exception e ) {
			LoggerApi.Log.info(e.getMessage());
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Hubo un error en la petición");
			
		}	
	}
	
	@RequestMapping("/"+URL_VERIFICAR_PROMO)
	public void teApuestoLlevaEstambulValidarClientePromocion(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		response.setContentType("application/json; charset=UTF-8");
		JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();

		Integer idClient = promSorteoBo.getByIdClient(session);
		
		PromProcedureGetFlagClient promProcedureGetFlagClient = promSorteoBo.getFlagClient(COD_PROMO,idClient ); 
		
		o.addProperty("flagPromo",promProcedureGetFlagClient.isFlagClient());
		 
	    out.print(o);
	}
	
	@RequestMapping("/"+URL_FECHAS_POPUP)
	public void teApuestoLlevaEstambulValidarFechaPopup(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		// Eliminar este log
		LoggerApi.Log.info("Ingresando a verificar fechas popup - " + DESCRIPCION);
		
		response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
			
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
