package pe.com.intralot.loto.layer.view.game.raspaditas;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

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
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.CasinoXpgUtils;
import pe.com.intralot.loto.utils.Constantes;

@Controller
public class RaspayaBetController {
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientAccountBo clientAccountBo;
    private static String device = "m";

    @RequestMapping("/game_raspaya_product_list")
	public void showProducListRaspaya(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductList> listProducts =  clientAccountBo.listRaspayaProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_product_list_order")
	public void showProducListOrderRaspaya(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductListOrder> listProductsOrder =  clientAccountBo.listRaspayaProductsOrder();
    	
    	String jsonList = new Gson().toJson(listProductsOrder);
		out.println(jsonList);
    }
    
    @RequestMapping("/retorna-raspaya")
    public ModelAndView retornaraspaya(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String server = request.getRequestURL().toString();
	    server = server.substring(0, server.lastIndexOf('/') + 1 ) +"game_raspaya_show_home.html" ;
	    request.setAttribute("server", server);	    	

	    return new ModelAndView("game/raspaya/interface_raspaya_retorna");
    }
    
    @RequestMapping("/game_raspaya_favorite_product_list")
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
			HashMap[]  productList = clientSaleBo.getFavoriteProductRaspaya(String.valueOf(clientId));
			for (HashMap hashMap : productList) {
				productos = new JsonObject();
				productos.addProperty("gameproductid",hashMap.get("HF_PRODUCT_ID").toString());
				productos.addProperty("name"		 ,hashMap.get("W_NAME").toString());
				productos.addProperty("title"		 ,hashMap.get("W_TITLE").toString());
				productos.addProperty("image"		 ,hashMap.get("W_IMAGE").toString());								
				productos.addProperty("provid"		 ,hashMap.get("W_PROV_ID").toString());
				productos.addProperty("type"		 ,hashMap.get("W_TYPE").toString());
				productos.addProperty("newtag"		 ,hashMap.get("W_NEW").toString());
				productos.addProperty("pozo"		 ,hashMap.get("W_POZO").toString());
				productos.addProperty("mainprovider" ,hashMap.get("W_MAIN_PROVIDER").toString());
				lista.add(productos);
			}
		}
    	String jsonList = new Gson().toJson(lista);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_show_home")
    public ModelAndView showHomeRaspaya(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_raspaya_show_home"); 
    	String juego = request.getParameter("type");
        
        if(juego==null) juego="ganaya";
        
        request.setAttribute("type",juego);
        
        return new ModelAndView("game/casino/interface-home-teapuesto");
    }
    
    @RequestMapping("/set-favorito-raspaya")
    public void setFavoritoRaspaya(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {	    
    	LoggerApi.Log.info("-------------- START set-favorito-raspaya");
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
				ClientProcedureUpdateClientFavoriteRaspaya favorite =  clientSaleBo.updateFavoriteRaspaya(flagDelete, clientId, productId);
				o.addProperty("status",favorite.getState());
			}else {
				o.addProperty("status",0);
			}				
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			out.print(o);
			LoggerApi.Log.info(o.toString());
			LoggerApi.Log.info("-------------- END set-favorito-raspaya");
		}
    }
    
    @RequestMapping("/game_raspaya_show_home_ry")
    public ModelAndView showHomeiRyRaspaya(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_raspaya_show_home_ry");
    	int clientId = 0;
    	try {
    		request.setAttribute("type","ganaya");
            
            return new ModelAndView("game/casino/interface-home-teapuesto");
            
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_raspaya_show_home_ry"); 
			return new ModelAndView("game/raspaya/interface-home-user");
		}
    }
    
    @RequestMapping("/game_raspaya_show_home_ryi")
    public ModelAndView showHomeRyRaspaya(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_raspaya_show_home_ry");
    	int clientId = 0;
    	try {
    		HttpSession session = request.getSession();	
			String forward = "game/raspaya/interface-home-game-ry";
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
        	          	forward = "game/raspaya/interface-home-game-ry";
        	            //marcar indicador de device = mobile.
         				clientSaleBo.updateDevice(clientId, device);
            		}else {//no existe sesion
            			request.setAttribute("nolive","1");
            			forward = "game/raspaya/interface-home-user";
            		}
            	}
            	
            	String server = request.getRequestURL().toString();
    			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"retorna-raspaya.html" ;            	
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
    	
    		LoggerApi.Log.info("-------------- END game_raspaya_show_home_ry"); 
    		return new ModelAndView(forward);				
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_raspaya_show_home_ry"); 
			return new ModelAndView("game/raspaya/interface-home-user");
		}
    }
    
    @RequestMapping("/game_raspaya_most_played_list")
	public void showMostPlayedList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		JsonArray lista = new JsonArray();
		JsonObject productos = new JsonObject();		 
		
		HashMap[]  productList = clientSaleBo.getMostPlayedRaspaya();
		for (HashMap hashMap : productList) {
			productos = new JsonObject();
			productos.addProperty("gameproductid",hashMap.get("HMP_PRODUCT_ID").toString());
			productos.addProperty("name"		 ,hashMap.get("W_NAME").toString());
			productos.addProperty("title"		 ,hashMap.get("W_TITLE").toString());
			productos.addProperty("image"		 ,hashMap.get("W_IMAGE").toString());								
			productos.addProperty("provid"		 ,hashMap.get("W_PROV_ID").toString());
			productos.addProperty("type"		 ,hashMap.get("W_TYPE").toString());
			productos.addProperty("newtag"		 ,hashMap.get("W_NEW").toString());
			productos.addProperty("pozo"		 ,hashMap.get("W_POZO").toString());
			productos.addProperty("mainprovider" ,hashMap.get("W_MAIN_PROVIDER").toString());
			lista.add(productos);
		}
		
    	String jsonList = new Gson().toJson(lista);
		out.println(jsonList);
    }
    
}