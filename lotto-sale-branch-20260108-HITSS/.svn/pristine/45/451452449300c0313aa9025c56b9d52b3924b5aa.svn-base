package pe.com.intralot.loto.layer.controller.game.instantaneas;

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

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureDDVVTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureDDVVTokenLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaCategoryProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.CasinoXpgUtils;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * NOMBRE: RaspayaController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Raspaya
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Celso Larico  23/02/2022  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class RaspayaController {

    @Autowired
    private ClientSaleBo clientSaleBo;
    private static String device = "d";

    @RequestMapping("/game_raspaya_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductList> listProducts =  clientSaleBo.listRaspayaProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_product_list_order")
	public void showProducListOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductListOrder> listProducts =  clientSaleBo.listRaspayaProductsOrder();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_favorite_product_list")
	public void showFavoriteProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		int clientId = 0;
		HttpSession session = request.getSession();
		UserBean userBean = new UserBean();
		if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
			userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
			clientId = userBean.getpClientid();
		}
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
    
    @RequestMapping(value = "/juega-raspaya")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String juego = request.getParameter("type");
        
        if(juego==null) juego="ganaya";
        
        request.setAttribute("type",juego);
        
        return "game/raspaya/home_raspaya_teapuesto";     
        
    }


    @RequestMapping(value = "/getLobbyRaspaya")
    public void getLobby(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();        
        Integer idClient = 0;
        String outData = "";
        String mode = "";
        PrintWriter out = null;
        out = response.getWriter();
        try {
        	UserBean userBean = new UserBean();
            if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                idClient = userBean.getpClientid();                        
            }
            
            if(request.getParameter("gameHacksaw")!=null){
            	mode = request.getParameter("mode").toString();
            	if(request.getParameter("mode").equals("live")) {
	            	if(idClient != 0) {
	            		outData = request.getParameter("gameHacksaw").toString();
	            		session.setAttribute("url", outData);
	        			session.setAttribute("mode", mode);
	            	}else {//no existe sesion
	        			request.setAttribute("nolive","1");
	        			outData = "sinSesion";
	        		}
            	}else{
            		outData = request.getParameter("gameHacksaw").toString();
        			session.setAttribute("url", outData);
        			session.setAttribute("mode", mode);
            	}	
            }else {
            	if(request.getParameter("demo")!=null){
                	outData = request.getParameter("demo") + "?language=es&currency=PEN";
        			session.setAttribute("url", request.getParameter("demo") + "?language=es&currency=PEN");
                }else {
                	if(request.getParameter("game")!=null){
                    	String gameId = request.getParameter("game");
                    	String lobbyResult = "";
                    	String lobbyIframe = "";                
                    	//validar que haya sesion activa
                		if(idClient != 0) {//existe sesion entonces genera urlLobby
                			//OBTENER URL LOBBY
                			String server = request.getRequestURL().toString();
                			CasinoXpgUtils xpg = new CasinoXpgUtils();            			
                			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"juega-raspaya.html" ;
                			
                			List<ClientProcedureGetRaspayaProductList> listProducts =  clientSaleBo.listRaspayaProducts();
            				for (ClientProcedureGetRaspayaProductList obj : listProducts) {
            					if(obj.getGameproductid().equals(gameId) && obj.getProvid().equals("IDS")) {
            						server = server.substring(0, server.lastIndexOf('/') + 1 ) +"retorna-casino.html" ;
            						break;
            					}
            				}
            				
            				if(request.getParameter("mainp")!=null && request.getParameter("mainp").equals("QTECH")){//Proveedor QTech
            					String tokensession = "";            					    
        		                ClientProcedureDDVVTokenGeneration casinoTokenGeneration = clientSaleBo.getDDVVToken(idClient, request.getRemoteAddr(), device);
        	            		ClientProcedureDDVVTokenLogin casinoTokenLogin = clientSaleBo.getDDVVLogin(casinoTokenGeneration.getToken());
        	            		if (casinoTokenLogin!=null && casinoTokenLogin.getMessage().equals("OK")) {
        	            			tokensession = casinoTokenLogin.getToken();
        	    	          	}
        		              	            		            
            					lobbyResult = xpg.getLobbyUrlQT(String.valueOf(idClient), gameId, server, tokensession);
            					lobbyIframe = lobbyResult.split("@")[2];
            				}            				
                			
                			outData = lobbyIframe;
                			session.setAttribute("url", lobbyIframe);            			
                			//marcar indicador de device 
            				clientSaleBo.updateDevice(idClient, device);        				
                		}else {//no existe sesion
                			request.setAttribute("nolive","1");
                			outData = "sinSesion";
                		}                	
                    }	            
                }
            }            
                                                
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	out.print(outData);
            LoggerApi.Log.info("getLobbyRaspaya OutData=" + outData);
        }
    }

    
    @RequestMapping(value = "/open-raspaya")
    public String opencasino(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();    	
    	if (session!=null) {
	    	String url = (session.getAttribute("url")!=null)?session.getAttribute("url").toString():"";
	    	request.setAttribute("url", url);
	    	session.removeAttribute("url");
    	}
        return "game/raspaya/home_raspaya_game";        
    }
    
    @RequestMapping(value = "/retorna-raspaya")
    public String retornaraspaya(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
	    return "game/raspaya/home_raspaya_retorna";        
    }
    
    @RequestMapping("/set-favorito-raspaya")
    public void setFavorito(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			UserBean userBean = new UserBean();
            
			if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                clientId = userBean.getpClientid();                                
            }
            
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
			LoggerApi.Log.info("-------------- END set-favorito");
		}
    }
    
    @RequestMapping(value = "/open-raspaya-hacksaw")
    public String opencasinoraspaya(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
        String token = "";
        String mode = "demo";
        JsonObject config = new JsonObject();
    	if (session!=null) {
	    	
    		String gameid = (session.getAttribute("url")!=null)?session.getAttribute("url").toString():"";
    		mode = (session.getAttribute("mode")!=null)?session.getAttribute("mode").toString():"";
    		
    		UserBean userBean = new UserBean();
            if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                
                clientSaleBo.updateDevice(userBean.getpClientid(), device);
            
                ClientProcedureIIVVTokenGeneration iivvTokenGeneration = clientSaleBo.getIIVVToken(userBean.getpClientid(), request.getRemoteAddr(), "d");
              	if (iivvTokenGeneration!=null && iivvTokenGeneration.getMessage().equals("OK")) {
              		token = iivvTokenGeneration.getToken();
              	}
            }
    		
          	String server = request.getRequestURL().toString();
			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"juega-raspaya.html" ;
          
			config.addProperty("gameid",gameid);
           	config.addProperty("channel",Constants.RASPADITAS_CHANNEL);
           	config.addProperty("token",token);
           	config.addProperty("language",Constants.RASPADITAS_LANGUAGE);
           	config.addProperty("currency",Constants.RASPADITAS_CURRENCY);
           	config.addProperty("partner",Constants.RASPADITAS_PARTNER);
           	config.addProperty("mode",mode);  
           	config.addProperty("lobbyurl",server);
            request.setAttribute("config",config);
            request.setAttribute("mode",mode);            
    	}
        return "game/raspaya/home_raspaya_game_ry";        
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
