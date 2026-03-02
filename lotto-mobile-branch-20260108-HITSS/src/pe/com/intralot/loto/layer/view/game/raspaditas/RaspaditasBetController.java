package pe.com.intralot.loto.layer.view.game.raspaditas;

import java.io.PrintWriter;
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
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaGameId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductPozoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductPriceList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;

@Controller
public class RaspaditasBetController {

   
    @Autowired
    private ClientSaleBo clientSaleBo;
    @Autowired
    private ClientAccountBo clientAccountBo;
    
    @RequestMapping("/game_raspaya_show_home-")
    public ModelAndView showHome(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START game_raspaya_show_home"); 
		int clientId = 0;
		try {		   
			HttpSession session = request.getSession();	
			String forward = "game/raspaditas/interface-home-user";
			clientId = (session.getAttribute("clientId")!=null)?Integer.valueOf((String) session.getAttribute("clientId")):0;

			JsonObject config = new JsonObject();
            if(request.getParameter("game")!=null){
            	String gameId = "";
            	String mode = "";
            	String token = "";
            	forward = "game/raspaditas/interface-home-user";
            	
            	ClientProcedureGetRaspayaGameId rgameId = clientSaleBo.findGetRaspayaGameId(request.getParameter("game").toString());
            	gameId = rgameId.getGameId();
            	
            	mode = request.getParameter("mode").toString();
            	
            	if(request.getParameter("mode").equals("live")) {
            		//validar que haya sesion activa
            		if(clientId != 0) {//existe sesion entonces genera token
            			ClientProcedureIIVVTokenGeneration iivvTokenGeneration = clientSaleBo.getIIVVToken(clientId, request.getRemoteAddr(), "m");
        	          	if (iivvTokenGeneration!=null && iivvTokenGeneration.getMessage().equals("OK")) {
        	          		token = iivvTokenGeneration.getToken();
        	          	}            			
            		}else {//no existe sesion
            			request.setAttribute("nolive","1");
            			forward = "game/raspaditas/interface-home-user";
            		}
            	}
            	
            	 config.addProperty("gameid",gameId);
            	 config.addProperty("channel",Constantes.RASPADITAS_CHANNEL);
            	 config.addProperty("token",token);
            	 config.addProperty("language",Constantes.RASPADITAS_LANGUAGE);
            	 config.addProperty("currency",Constantes.RASPADITAS_CURRENCY);
            	 config.addProperty("partner",Constantes.RASPADITAS_PARTNER);
            	 config.addProperty("mode",mode);  
            	 config.addProperty("lobbyurl",request.getRequestURL().toString());
                 request.setAttribute("config",config);
                 
                 if (gameId.equals("0")) {
             		request.setAttribute("nogame","1");
             		request.setAttribute("config","");
             	}
            }			
			LoggerApi.Log.info("-------------- END game_raspaya_show_home"); 
			return new ModelAndView(forward);				
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_raspaya_show_home"); 
			return new ModelAndView("game/raspaditas/interface-home-user");
		}
    }	 
    
    @RequestMapping("/game_raspaya_product_list-")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductList> listProducts =  clientAccountBo.listRaspayaProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_productprice_list-")
	public void showProducPriceList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductPriceList> listProducts =  clientAccountBo.listRaspayaProductsPrice();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_productpozo_list-")
	public void showProducPozoList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductPozoList> listProducts =  clientAccountBo.listRaspayaProductsPozo();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
}
