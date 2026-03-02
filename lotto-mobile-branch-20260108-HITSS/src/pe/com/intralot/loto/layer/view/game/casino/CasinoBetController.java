package pe.com.intralot.loto.layer.view.game.casino;

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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureDDVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureDDVVTokenLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.CasinoXpgUtils;
import pe.com.intralot.loto.utils.Constantes;

@Controller
public class CasinoBetController {
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientAccountBo clientAccountBo;
    private static String device = "m";

    @RequestMapping("/game_casino_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetCasinoProductList> listProducts =  clientAccountBo.listCasinoProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_casino_product_list_order")
	public void showProducListOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetCasinoProductListOrder> listProductsOrder =  clientAccountBo.listCasinoProductsOrder();
    	
    	String jsonList = new Gson().toJson(listProductsOrder);
		out.println(jsonList);
    }
    
    @RequestMapping("/retorna-casino")
    public ModelAndView retornacasino(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String server = request.getRequestURL().toString();
	    server = server.substring(0, server.lastIndexOf('/') + 1 ) +"game_casino_show_home.html" ;
	    request.setAttribute("server", server);	    	

	    return new ModelAndView("game/casino/interface_casino_retorna");
    }
    
    @RequestMapping("/game_casino_favorite_product_list")
	public void showFavoriteProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		int clientId = 0;
		HttpSession session = request.getSession();	
		clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
		JsonArray lista = new JsonArray();
		JsonObject productos = new JsonObject();		 
		if(clientId != 0){
			HashMap[]  productList = clientSaleBo.getFavoriteProduct(String.valueOf(clientId));
			for (HashMap hashMap : productList) {
				productos = new JsonObject();
				productos.addProperty("gameproductid",hashMap.get("XF_PRODUCT_ID").toString());
				productos.addProperty("name"		 ,hashMap.get("W_NAME").toString());
				productos.addProperty("provname"	 ,hashMap.get("W_PROVNAME").toString());
				productos.addProperty("image"		 ,hashMap.get("W_IMAGE").toString());
				if(hashMap.get("W_DEMO_LINK") != null)
					productos.addProperty("demolink" ,hashMap.get("W_DEMO_LINK").toString());
				productos.addProperty("provid"		 ,hashMap.get("W_PROV_ID").toString());
				productos.addProperty("type"		 ,hashMap.get("W_TYPE").toString());
				productos.addProperty("newtag"		 ,hashMap.get("W_NEW").toString());
				productos.addProperty("jackpotid"	 ,hashMap.get("W_JACKPOT_ID").toString());
				productos.addProperty("subtype"	 	 ,hashMap.get("W_SUBTYPE").toString());
				productos.addProperty("mainprovider" ,hashMap.get("W_MAIN_PROVIDER").toString());
				lista.add(productos);
			}
		}
    	String jsonList = new Gson().toJson(lista);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_casino_show_home")
    public ModelAndView showHome(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_casino_show_home"); 
    	String juego = request.getParameter("type");
        
        if(juego==null) juego="casino";
        
        if(juego.equals("todos"))
        	juego = "casino";
        else if(juego.equals("masjugados"))
        	juego = "casino/detail?gameType=Juegos%20Populares#toFilter";
        else if(juego.equals("favoritos"))
        	juego = "casino/detail?gameType=Top%20Juegos#toFilter";
        else if(juego.equals("favoritos"))
        	juego = "casino/detail?gameType=Top%20Juegos#toFilter";
        else if(juego.equals("slots"))
        	juego = "casino/detail?gameType=Juegos%20Populares#toFilter";
        else if(juego.equals("live"))
        	juego = "live-casino";
        else if(juego.equals("bingo"))
        	juego = "casino/detail?gameType=Juegos%20de%20BINGO#toFilter";
        else if(juego.equals("mesa"))
        	juego = "casino/detail?gameType=Juegos%20de%20Mesa#toFilter";
        else if(juego.equals("jackpot"))
        	juego = "casino/detail?gameType=Jackpots#toFilter";
        else if(juego.equals("virtual"))
        	juego = "casino/detail?gameType=Crash%20Games#toFilter";
        else
        	juego = "casino";
        
        request.setAttribute("type",juego);
        
        return new ModelAndView("game/casino/interface-home-teapuesto");
    }
    
    @RequestMapping("/set-favorito")
    public void setFavorito(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {	    
    	LoggerApi.Log.info("-------------- START set-favorito");
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        int clientId = 0;
    	try {		
	    	String flagDelete = (request.getParameter("flagDelete") != null)
					? request.getParameter("flagDelete").toString().trim()
					: "";
			String productId = (request.getParameter("productId") != null)
					? request.getParameter("productId").toString().trim()
					: "";		
			HttpSession session = request.getSession();	
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;

			//SI EXISTE SESION ACTUALIZA FAVORITOS*
			if(clientId != 0) {
				ClientProcedureUpdateClientFavorite favorite =  clientSaleBo.updateFavorite(flagDelete, clientId, productId);
				o.addProperty("status",favorite.getState());
			}else {
				o.addProperty("status",0);
			}				
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			out.print(o);
			LoggerApi.Log.info(o.toString());
			LoggerApi.Log.info("-------------- END set-favorito");
		}
    }
    
    @RequestMapping("/game_casino_show_home_ry")
    public ModelAndView showHomeiRy(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_casino_show_home_ry");
    	int clientId = 0;
    	try {
    		HttpSession session = request.getSession();	
			String forward = "game/casino/interface-home-game-iry";
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			JsonObject productos = new JsonObject();
			
			if(clientId != 0){
				HashMap[]  productList = clientSaleBo.getFavoriteProduct(String.valueOf(clientId));
				for (HashMap hashMap : productList) {
					productos.addProperty(hashMap.get("XF_PRODUCT_ID").toString(),1);
				}
				request.setAttribute("productos",productos);
        		//Si no hay productos, asignar por lo menos ("0",1)
				productos.addProperty("0",1);
			}else {
				request.setAttribute("productos","{}");
			}	
			
            if(request.getParameter("game")!=null){
            	String gameId = request.getParameter("game").toString();
            	String mode = "";
            	
            	mode = request.getParameter("mode").toString();
            	
            	if(request.getParameter("mode").equals("live")) {
            		//validar que haya sesion activa
            		if(clientId != 0) {//existe sesion entonces genera token
            			forward = "game/casino/interface-home-game-iry";
            		}else {//no existe sesion
            			request.setAttribute("nolive","1");
            			forward = "game/casino/interface-home-user";
            		}
            	}
            	
            	String server = request.getRequestURL().toString();
    			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"game_casino_show_home_ryi.html?game=" + gameId + "&mode=" + mode;            	
            	
    			request.setAttribute("lobbyIframe",server);
    			
 				if (gameId.equals("0")) {
                	request.setAttribute("nolive","2");
             		request.setAttribute("config","");
             		forward = "game/casino/interface-home-user";
             	}
            }
    	
    		LoggerApi.Log.info("-------------- END game_casino_show_home_ry"); 
    		return new ModelAndView(forward);				
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_casino_show_home_ry"); 
			return new ModelAndView("game/casino/interface-home-user");
		}
    }
    
    @RequestMapping("/game_casino_show_home_ryi")
    public ModelAndView showHomeRy(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_casino_show_home_ry");
    	int clientId = 0;
    	try {
    		HttpSession session = request.getSession();	
			String forward = "game/casino/interface-home-game-ry";
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;
			JsonObject config = new JsonObject();
            if(request.getParameter("game")!=null){
            	String gameId = request.getParameter("game").toString();
            	String mode = "";
            	String token = "";
            	
            	mode = request.getParameter("mode").toString();
            	
            	if(request.getParameter("mode").equals("live")) {
            		//validar que haya sesion activa
            		if(clientId != 0) {//existe sesion entonces genera token
            			ClientProcedureIIVVTokenGeneration iivvTokenGeneration = clientSaleBo.getIIVVToken(clientId, request.getRemoteAddr(), "m");
        	          	if (iivvTokenGeneration!=null && iivvTokenGeneration.getMessage().equals("OK")) {
        	          		token = iivvTokenGeneration.getToken();
        	          	}
        	          	forward = "game/casino/interface-home-game-ry";
        	            //marcar indicador de device = mobile.
         				clientSaleBo.updateDevice(clientId, device);
            		}else {//no existe sesion
            			request.setAttribute("nolive","1");
            			forward = "game/casino/interface-home-user";
            		}
            	}
            	
            	String server = request.getRequestURL().toString();
    			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"retorna-casino.html" ;            	
            	config.addProperty("gameid",gameId);
            	config.addProperty("channel",Constantes.RASPADITAS_CHANNEL);
            	config.addProperty("token",token);
            	config.addProperty("language",Constantes.RASPADITAS_LANGUAGE);
            	config.addProperty("currency",Constantes.RASPADITAS_CURRENCY);
            	config.addProperty("partner",Constantes.RASPADITAS_PARTNER);
            	config.addProperty("mode",mode);  
            	config.addProperty("lobbyurl",server);
                request.setAttribute("config",config);
                
 				if (gameId.equals("0")) {
                	request.setAttribute("nolive","2");
             		request.setAttribute("config","");
             	}
            }
    	
    		LoggerApi.Log.info("-------------- END game_casino_show_home_ry"); 
    		return new ModelAndView(forward);				
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_casino_show_home_ry"); 
			return new ModelAndView("game/casino/interface-home-user");
		}
    }
    
    @RequestMapping(value = "/getJackpot")
    public void getJackpot(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        String jackpot = "-";
        out = response.getWriter();
        try {
        	if(request.getParameter("jackpotid")!=null)
        		jackpot = Constantes.jackpotsMap.get(request.getParameter("jackpotid").toString());  
        	
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        	out.print(jackpot);
        	out.close();
        }
    }
    
    @RequestMapping("/game_casino_most_played_list")
	public void showMostPlayedList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	JsonArray lista = new JsonArray();
		JsonObject productos = new JsonObject();		 		
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		
		HashMap[]  productList = clientSaleBo.getMostPlayedCasino();
		for (HashMap hashMap : productList) {
			productos = new JsonObject();
			productos.addProperty("gameproductid",hashMap.get("XMP_PRODUCT_ID").toString());
			productos.addProperty("name"		 ,hashMap.get("W_NAME").toString());
			productos.addProperty("provname"	 ,hashMap.get("W_PROVNAME").toString());
			productos.addProperty("image"		 ,hashMap.get("W_IMAGE").toString());
			if(hashMap.get("W_DEMO_LINK") != null)
				productos.addProperty("demolink" ,hashMap.get("W_DEMO_LINK").toString());				
			productos.addProperty("provid"		 ,hashMap.get("W_PROV_ID").toString());
			productos.addProperty("type"		 ,hashMap.get("W_TYPE").toString());
			productos.addProperty("newtag"		 ,hashMap.get("W_NEW").toString());
			productos.addProperty("jackpotid"	 ,hashMap.get("W_JACKPOT_ID").toString());
			productos.addProperty("subtype"	 	 ,hashMap.get("W_SUBTYPE").toString());
			productos.addProperty("mainprovider" ,hashMap.get("W_MAIN_PROVIDER").toString());
			lista.add(productos);
		}
		String jsonList = new Gson().toJson(lista);
		out.println(jsonList);
    }
}