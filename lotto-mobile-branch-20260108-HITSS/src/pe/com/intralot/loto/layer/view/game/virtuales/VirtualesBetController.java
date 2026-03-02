package pe.com.intralot.loto.layer.view.game.virtuales;

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
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.Fingerprint;

@Controller
public class VirtualesBetController {
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientAccountBo clientAccountBo;
    private static String device = "m";

    @RequestMapping("/game_virtuales_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetVirtualesProductList> listProducts =  clientAccountBo.listVirtualesProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_virtuales_product_list_order")
	public void showProducListOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetVirtualesProductListOrder> listProductsOrder =  clientAccountBo.listVirtualesProductsOrder();
    	
    	String jsonList = new Gson().toJson(listProductsOrder);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_virtuales_favorite_product_list")
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
			HashMap[]  productList = clientSaleBo.getFavoriteProductVirtuales(String.valueOf(clientId));
			for (HashMap hashMap : productList) {
				productos = new JsonObject();
				productos.addProperty("gameproductid",hashMap.get("VF_PRODUCT_ID").toString());
				productos.addProperty("name"		 ,hashMap.get("W_NAME").toString());
				productos.addProperty("provname"	 ,hashMap.get("W_PROVNAME").toString());
				productos.addProperty("image"		 ,hashMap.get("W_IMAGE").toString());
				if(hashMap.get("W_DEMO_LINK") != null)
					productos.addProperty("demolink" ,hashMap.get("W_DEMO_LINK").toString());				
				productos.addProperty("provid"		 ,hashMap.get("W_PROV_ID").toString());
				productos.addProperty("type"		 ,hashMap.get("W_TYPE").toString());
				productos.addProperty("newtag"		 ,hashMap.get("W_NEW").toString());
				lista.add(productos);
			}
		}
    	String jsonList = new Gson().toJson(lista);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_virtuales_show_home")
    public ModelAndView showHome(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_virtuales_show_home");
    	String juego = "virtuales";
        
        request.setAttribute("type",juego);
        
        return new ModelAndView("game/casino/interface-home-teapuesto");
    }
    
    @RequestMapping("/set-favorito-virtuales")
    public void setFavorito(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {	    
    	LoggerApi.Log.info("-------------- START set-favorito-virtuales");
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
				ClientProcedureUpdateClientFavoriteVirtuales favorite =  clientSaleBo.updateFavoriteVirtuales(flagDelete, clientId, productId);
				o.addProperty("status",favorite.getState());
			}else {
				o.addProperty("status",0);
			}				
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			out.print(o);
			LoggerApi.Log.info(o.toString());
			LoggerApi.Log.info("-------------- END set-favorito-virtuales");
		}
    }
    
    @RequestMapping("/game_virtuales_most_played_list")
	public void showMostPlayedList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		JsonArray lista = new JsonArray();
		JsonObject productos = new JsonObject();		 
		
		HashMap[]  productList = clientSaleBo.getMostPlayedVirtual();
		for (HashMap hashMap : productList) {
			productos = new JsonObject();
			productos.addProperty("gameproductid",hashMap.get("VMP_PRODUCT_ID").toString());
			productos.addProperty("name"		 ,hashMap.get("W_NAME").toString());
			productos.addProperty("provname"	 ,hashMap.get("W_PROVNAME").toString());
			productos.addProperty("image"		 ,hashMap.get("W_IMAGE").toString());
			if(hashMap.get("W_DEMO_LINK") != null)
				productos.addProperty("demolink" ,hashMap.get("W_DEMO_LINK").toString());				
			productos.addProperty("provid"		 ,hashMap.get("W_PROV_ID").toString());
			productos.addProperty("type"		 ,hashMap.get("W_TYPE").toString());
			productos.addProperty("newtag"		 ,hashMap.get("W_NEW").toString());
			lista.add(productos);
		}
		
    	String jsonList = new Gson().toJson(lista);
		out.println(jsonList);
    }
    
}