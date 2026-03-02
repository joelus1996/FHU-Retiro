package pe.com.intralot.loto.layer.controller.game.copabicolor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.model.Game;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetBicolorPromoList;
import pe.com.intralot.loto.layer.model.domain.ListTicketBicolorClient;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;

@Controller
public class CopaBicolorController {
	
	@Autowired
	private BalanceSaleBo balanceSaleBo;
	@Autowired
	private ClientSaleBo clientSaleBo;
	
	@RequestMapping("/registrarpromopremiazoganagol")	
	public ModelAndView registrarPromo(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
								
		LoggerApi.Log.info("Registro de promocion la bicolor");
		HttpSession session = request.getSession();
		Integer idClient = 0;
		String idClientPromo ="";
		UserBean userBean = new UserBean();
        if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
            userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
            idClient = userBean.getpClientid();
            idClientPromo = Integer.toString(idClient);
        }    
        if(Boolean.TRUE) {
            return new ModelAndView("redirect:home.html");
        }
			
		if(!idClientPromo.isEmpty()) {
			
			Dbms rs = null;
	        try {
	            rs = new Dbms();
	    	    String sql = "update lotocard.client set status_prom_bicolor = ? , cl_date_prom_bicolor = sysdate , cl_channel_prom_bicolor = 'DESKTOP' where client_id = ? and status_prom_bicolor is null ";
	    	    rs.setSql(sql);
	            rs.setString(1,"1");
	            rs.setString(2,idClientPromo);
	            rs.executeUpdate();
	           
			} finally {
				try {
					if(rs!=null) {
						System.out.println("<--------------------SecurityLoginController cerrando conexion------------------->");
						 rs.close();
						 
					}
				} catch (Exception e) {
					System.out.println("<--------------------SecurityLoginController error cerrando conexion------------------->");
					e.printStackTrace();
					return new ModelAndView("game/copabicolor/interface-home-registro");
				}
								
			}
	        
	    	return new ModelAndView("redirect:premiazoganagol_resultados.html");
		}else {
			
			return new ModelAndView("game/copabicolor/interface-home-registro");
		}
										
	}
	

	@RequestMapping("/premiazoganagol")	
	public ModelAndView showcopabicolor(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("Ingresando a la bicolor en tu casa");
		HttpSession session = request.getSession();
		Integer idClient = 0;
		boolean flagPromo;
		try {
			//LoggerApi.Log.info("Chekando cliente en session");
			
			
			UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
                idClient = userBean.getpClientid();
                objectModelMap.put("clientId", idClient);
            }
									
    		flagPromo = verifyPromo(idClient);
						
			if(idClient == 0) {
				
				return new ModelAndView("game/copabicolor/interface-home-registro");
			}else {
				if(flagPromo) {
					
					return new ModelAndView("game/copabicolor/interface-home");
				}else {
					
					return new ModelAndView("game/copabicolor/interface-home-registro");					
				}
				
			}
						
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/copabicolor/interface-home-registro");
		}	
	}
	
	@RequestMapping("/como-participar-premiazoganagol")	
	public ModelAndView showHowPart(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
						
		
		LoggerApi.Log.info("Ingresando a como participar la bicolor en tu casa");
		HttpSession session = request.getSession();
		int idClient = 0;
		boolean flagPromo = false;

		try {
			//LoggerApi.Log.info("Chekando cliente en session");
			 UserBean userBean = new UserBean();
	            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
	                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
	                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
	                idClient = userBean.getpClientid();	    		
	                flagPromo = verifyPromo(idClient);
	    	}
					
			objectModelMap.put("clientId", idClient);
			objectModelMap.put("flagPromo", flagPromo);
			return new ModelAndView("game/copabicolor/interface-take-part");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/copabicolor/interface-take-part");
		}	
	}
	
	@RequestMapping("/soyleyenda-bicolor")	
	public ModelAndView showAmLegend(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
						
		
		LoggerApi.Log.info("Ingresando a como participar la bicolor en tu casa");
		
		HttpSession session = request.getSession();
		int idClient = 0;
		boolean flagPromo = false;
		
		try {
			//LoggerApi.Log.info("Chekando cliente en session");
			 UserBean userBean = new UserBean();
	            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
	                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
	                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
	                idClient = userBean.getpClientid();	    		
	                flagPromo = verifyPromo(idClient);
	    	}
					
			objectModelMap.put("clientId", idClient);
			objectModelMap.put("flagPromo", flagPromo);
			return new ModelAndView("game/copabicolor/interface-home");	
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			return new ModelAndView("game/copabicolor/interface-home");
		}	
	}
	
	@RequestMapping(value = "/premiazoganagol_resultados")
    public ModelAndView showResultsCupHouse2(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
			
        HttpSession session = request.getSession();
        
        Integer idClient = 0;       
	    double puntaje=0;
	    int puntajeNivel=0;
	    Date fechaHoy= new Date();
	    String sorteoActivo= "0";
	    int cantSorteoPromo=0;
	    	        
        try {
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
                idClient = userBean.getpClientid();
                List<ClientProcedureGetBicolorPromoList> list = balanceSaleBo.findPromoBicolorList(idClient);             
                                                               		   			
    			String pattern = "dd ' de ' MMMMM";		
    			SimpleDateFormat simpleDateFormat =
    			        new SimpleDateFormat(pattern, new Locale("es","PE"));
    			
    			boolean verifyPromo = verifyPromo(idClient);   	
    			
                if(!list.isEmpty() && idClient!=0 && verifyPromo == true) {
               	               	
    				for(ClientProcedureGetBicolorPromoList objList : list) {
    					   					   					   				   					
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
    				
    				request.setAttribute("activaPremio",sorteoActivo);
                    request.setAttribute("totalTicket",cantSorteoPromo);
                    request.setAttribute("puntajeNivel",puntajeNivel);                              
        			modelList.put("listTickets",list);
        			
        			return new ModelAndView( "game/copabicolor/interface-results");  														   				
   				   								  				
    			}else {
    				return new ModelAndView("redirect:premiazoganagol.html");
    			}
                                                               
            }else {
            	return new ModelAndView("redirect:premiazoganagol.html");
            }
                            
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return new ModelAndView("redirect:premiazoganagol.html");
        }  
    }
	
	@RequestMapping(value = "/game_premiazoganagol_resultados_popup")
    public void showResultsCupHouse_popup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        
        Integer idClient = 0;       
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
            UserBean userBean = new UserBean();
            if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
                idClient = userBean.getpClientid();
                List<ClientProcedureGetBicolorPromoList> list = balanceSaleBo.findPromoBicolorList(idClient);
                                		   			    			   			                
                if(!list.isEmpty()) {
    				for(ClientProcedureGetBicolorPromoList objList : list) {    					  			
    					cantSorteoPromo = cantSorteoPromo + Integer.parseInt(objList.getPromCount());																																		   					
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
    				
    				List<ListTicketBicolorClient> listTicketsWin = balanceSaleBo.getListBicolorTickets(idClient);
    				if(!listTicketsWin.isEmpty()) {
    					for (ListTicketBicolorClient listTicketBicolorClient : listTicketsWin) {
    						 refList = refList + ", " + listTicketBicolorClient.getTicketId();
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
    			   			                              
	            }else {
	            	o.addProperty("message", "Incidente inesperado");
	            }
           }
                
        } catch (Exception e) {
        	LoggerApi.severe(e);
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado");
        } 
    }
	
	@RequestMapping("/verificar_promocion")
	public void validarClientePromocion(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
		int idClient = 0;
		String flagPromoBicolor = Constants.flagPromoBicolor;
		UserBean userBean = new UserBean();
		
		if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
            userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
            idClient = userBean.getpClientid();
		}    
	
			boolean verifyPromo = verifyPromo(idClient);
			
			o.addProperty("flagPromo",verifyPromo);
			o.addProperty("flagPromoBicolor",flagPromoBicolor);//Activa el popup categoria de la promocion 
		    out.print(o);		
	}
	
public boolean verifyPromo(int idClient)  throws Exception {
		
		Dbms rs2 = null;
		String p_status_prom_bicolor = "";
		boolean flagPromo = false;
		String idClientPromo = Integer.toString(idClient);
		
		try {
            rs2 = new Dbms();
    	    String sql = "select status_prom_bicolor from lotocard.client where client_id = ? ";
    	    rs2.setSql(sql);
            rs2.setString(1,idClientPromo);
            rs2.executeQuery();
            if (rs2.next()) {
            	p_status_prom_bicolor = rs2.getString(1);
            	
            }
		} finally {
			try {
				if(rs2!=null) {
					System.out.println("<--------------------SecurityLoginController cerrando conexion------------------->");
					 rs2.close();
				}
			} catch (Exception e) {
				System.out.println("<--------------------SecurityLoginController error cerrando conexion------------------->");
				e.printStackTrace();
			}
			
		}
        
       if(p_status_prom_bicolor !=  null) {
    	   if(p_status_prom_bicolor.equals("1")) {
    		   flagPromo = true;
    	   }
       }
       
       return flagPromo;
	}

	@RequestMapping("/verificar_promocion_hincha")
	public void validarClientePromocionHincha(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		response.setContentType("application/json; charset=UTF-8");
	    JsonObject o = new JsonObject();
	    PrintWriter out = response.getWriter();
		int idClient = 0;
		String flagPromoHincha = Constants.flagPromoHincha;
		UserBean userBean = new UserBean();
		boolean verifyPromo = false;
		
		if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
	            && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
	        userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
	        idClient = userBean.getpClientid();
		}    
	
		HashMap[]  productList = clientSaleBo.getPromoHincha(String.valueOf(idClient));
		for (HashMap hashMap : productList) {
			if( Integer.parseInt(hashMap.get("W_PARTICIPA").toString()) > 0 ) {
				verifyPromo = true;
			}else {
				verifyPromo = false;
			}
			break;
		}
		
		o.addProperty("flagParticipa",verifyPromo);
		o.addProperty("flagPromoHincha",flagPromoHincha);//Activa el popup categoria de la promocion 
	    out.print(o);		
	}

	@RequestMapping("/registrar_promocion_hincha")	
	public void registrarPromoHincha(HttpServletRequest request, HttpServletResponse response) throws Exception {
								
		LoggerApi.Log.info("Registro de promocion Hincha");
		HttpSession session = request.getSession();
		Integer idClient = 0;
		String idClientPromo ="";
		UserBean userBean = new UserBean();
        if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
            userBean = (UserBean) session.getAttribute(Constants.USR_SESION);                
            idClient = userBean.getpClientid();
            idClientPromo = Integer.toString(idClient);
        }    
			
		if(!idClientPromo.isEmpty()) {			
			clientSaleBo.registerPopupLottery(idClient, "Desktop", "H", Game.TEAPUESTO);												
		}
	}	
}
