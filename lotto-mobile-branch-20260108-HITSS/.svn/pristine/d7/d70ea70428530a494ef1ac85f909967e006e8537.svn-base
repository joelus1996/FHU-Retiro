package pe.com.intralot.loto.layer.view.game.virtuales;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLotteryProductList;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.VideoLoteriaUtils;

@Controller
public class VideoLoteriaController {
	@Autowired
	private ClientSaleBo clientSaleBo;
	@Autowired
	private ClientAccountBo clientAccountBo;
	private static String device = "m";
	
	@RequestMapping("/game_videoloteria_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetLotteryProductList> listProducts = clientSaleBo.listLotteryProducts();

		String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
	}
	
	  @RequestMapping("/retorna-videoloteria")
	    public ModelAndView retornacasino(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	String server = request.getRequestURL().toString();
		    server = server.substring(0, server.lastIndexOf('/') + 1 ) +"game_casino_show_home.html" ;
		    request.setAttribute("server", server);	    	

		    return new ModelAndView("game/casino/interface_videoloteria_retorna");
	    }
	    

	
	@RequestMapping("/game_video_loterias_show_menu")
	public ModelAndView showHome(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		LoggerApi.Log.info("-------------- START game_video_loteria_show_menu");
		int clientId = 150002921;
		String scategory = "";
		String forward = "game/videoloteria/interface-videoloteria-user";
		try {
			HttpSession session = request.getSession();	
			
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			JsonObject productos = new JsonObject();
			JsonObject providers = new JsonObject();
			JsonObject category = new JsonObject();
			JsonObject categoryProviders = new JsonObject(); 
			
			List<ClientProcedureGetCasinoProviderList> listProvider =  clientAccountBo.listProviders();
			List<ClientProcedureGetCasinoCategoryProviderList> listCategoryProvider =  clientAccountBo.listCategoryProviders();
			for (ClientProcedureGetCasinoProviderList item : listProvider){
				providers.addProperty(item.getProviderid(), item.getName());
			}			
			request.setAttribute("providers",providers);
			scategory = listCategoryProvider.get(0).getCategory().toString();
			int count = 0;
			for (ClientProcedureGetCasinoCategoryProviderList itemcp :listCategoryProvider){				
		    	if(scategory.equals(itemcp.getCategory().toString())) {
		    		categoryProviders.addProperty(String.valueOf(count), itemcp.getProviderid());
		    	}else {
		    		category.add(scategory, categoryProviders);
		    		scategory = itemcp.getCategory();
		    		categoryProviders = new JsonObject();
		    		categoryProviders.addProperty(String.valueOf(count), itemcp.getProviderid());
		    	}
		    	count++;
			}
			category.add(scategory, categoryProviders);
		    request.setAttribute("categoryProviders",category);
		    
		    if(clientId != 0){
				HashMap[]  productList = clientSaleBo.getFavoriteProduct(String.valueOf(clientId));
				for (HashMap hashMap : productList) {
					productos.addProperty(hashMap.get("XF_PRODUCT_ID").toString(),1);
				}
				request.setAttribute("productos",productos);
        		//Si no hay productos, asignar por lo menos ("0",1)
				productos.addProperty("0",1);
				request.setAttribute("sesion","1");
			}else {
				request.setAttribute("productos","{}");
				request.setAttribute("sesion","0");
			}
		  //se obtiene jackpotids solamente
			StringBuilder sbjackpotids = new StringBuilder();
			for (Map.Entry<String, String> entry : Constantes.jackpotsMap.entrySet()) {
				sbjackpotids.append(entry.getKey()+",");
			}
			if(sbjackpotids.toString().length()>0)
				request.setAttribute("jackpotids",sbjackpotids.toString());
			else
				request.setAttribute("jackpotids","-");
			
			if(request.getParameter("demo")!=null){
				String url = request.getParameter("demo");
				request.setAttribute("lobbyIframe",url);
				forward = "game/videoloteria/interface-home-game";
			}
			
            if(request.getParameter("game")!=null){
            	String gameId = request.getParameter("game");
            	String lobbyResult = "";
            	String lobbyIframe = "";
            	forward = "game/videoloteria/interface-videoloteria-user";
        		//validar que haya sesion activa
            	if(clientId != 0) {
        			//OBTENER URL LOBBY
        			String server = request.getRequestURL().toString();
        			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"retorna-videoloteria.html" ;
        			VideoLoteriaUtils xpg = new VideoLoteriaUtils();
        			
        			if(request.getParameter("mainp")!=null && request.getParameter("mainp").equals("XP")){//Proveedor XpressGaming
	        			
	    					xpg = new VideoLoteriaUtils("createPlayer",String.valueOf(clientId), null);
	    					String playerId = xpg.processCreate();
	    					try {
	                    		if(!playerId.isEmpty()){
	                    			clientSaleBo.updatePlayerIdVl(clientId, playerId);
	                    			lobbyResult = xpg.getLobbyUrlVl(String.valueOf(clientId), gameId, server, Constantes.VIDEO_LOTERIA_LANGUAGE);
								}	                		
							} catch (Exception e) {
	                			lobbyResult="-@-@-@";	            
	                        }            					
	    				
	        			lobbyIframe = lobbyResult;
	        			//lobbyIframe = lobbyResult.split("@")[2];
	        			if(lobbyIframe.equals("-")) {
	        				request.setAttribute("nolive","2");
	        			}else {
	        				//marcar indicador de device = mobile.
	        				clientSaleBo.updateDevice(clientId, device);
	        				request.setAttribute("lobbyIframe",lobbyIframe);
	        				//REDIRIGIR AL IFRAME DEL JUEGO: categoria Live a fullscreen sin header
	        				if(request.getParameter("category")!=null && request.getParameter("category").equals("live"))
	        					forward = "game/videoloteria/interface-home-game";
	        				else
	        					forward = "game/videoloteria/interface-home-game";
	        			} 
        			}
        			request.setAttribute("lobbyIframe",lobbyIframe);
        			//marcar indicador de device = mobile.
    				clientSaleBo.updateDevice(clientId, device);
        			
        		}else {//no existe sesion
        			request.setAttribute("nolive","1");
        			forward = "game/videoloteria/interface-videoloteria-user";
        		}             		
            }  
			LoggerApi.Log.info("-------------- END game_videoloteria_show_home"); 
			return new ModelAndView(forward);
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_video_loteria_show_menu");
			return new ModelAndView("game/videoloteria/interface-videoloteria-user");
		}
	}
}
