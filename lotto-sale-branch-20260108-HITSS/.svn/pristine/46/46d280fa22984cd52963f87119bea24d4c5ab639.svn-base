package pe.com.intralot.loto.layer.controller.game.instantaneas;

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

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureDDVVTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureDDVVTokenLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoCategoryProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductListOrder;
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
 * NOMBRE: CasinoController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Casino
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Celso Larico  22/04/2020  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class CasinoController {

    @Autowired
    private ClientSaleBo clientSaleBo;
    private static String device = "d";

    @RequestMapping("/game_casino_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetCasinoProductList> listProducts =  clientSaleBo.listCasinoProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_casino_product_list_order")
	public void showProducListOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetCasinoProductListOrder> listProducts =  clientSaleBo.listCasinoProductsOrder();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_casino_favorite_product_list")
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
    
    @RequestMapping(value = "/juega-casino")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        
        request.setAttribute("type",juego);
        
        return "game/casino/home_casino_teapuesto";        
    }


    @RequestMapping(value = "/getLobby")
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
            
            if(request.getParameter("gameRaspaya")!=null){
            	mode = request.getParameter("mode").toString();
            	if(request.getParameter("mode").equals("live")) {
	            	if(idClient != 0) {
	            		outData = request.getParameter("gameRaspaya").toString();
	            		session.setAttribute("url", outData);
	        			session.setAttribute("mode", mode);
	            	}else {//no existe sesion
	        			request.setAttribute("nolive","1");
	        			outData = "sinSesion";
	        		}
            	}else{
            		outData = request.getParameter("gameRaspaya").toString();
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
                			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"juega-casino.html" ;
                			
                			clientSaleBo.updateDevice(idClient, device);
            				
            				List<ClientProcedureGetCasinoProductList> listProducts =  clientSaleBo.listCasinoProducts();
            				for (ClientProcedureGetCasinoProductList obj : listProducts) {
            					if(obj.getGameproductid().equals(gameId) && obj.getProvname().equals("Spinal")) {
            						server = server.substring(0, server.lastIndexOf('/') + 1 ) +"retorna-casino.html" ;
            						break;
            					}
            				}
                			
            				if(request.getParameter("mainp")!=null && request.getParameter("mainp").equals("XP")){//Proveedor XpressGaming
            				
	            				if(request.getParameter("category")!=null && request.getParameter("category").equals("live")) {
	            					xpg = new CasinoXpgUtils("createPlayer",idClient.toString(), clientSaleBo);
	            					String playerId = xpg.processCreatePreprod();
	            					try {
	                            		if(!playerId.isEmpty())
	                            			lobbyResult = xpg.getLobbyUrlPreprod(String.valueOf(idClient), gameId, server, Constants.CASINO_LANGUAGE);
	                        		} catch (Exception e) {
	                        			lobbyResult="-@-@-@";	            
	                                }            					
	            				}
	            				else
	            					lobbyResult = xpg.getLobbyUrl(String.valueOf(idClient), gameId, server, Constants.CASINO_LANGUAGE);
	            				
	            				lobbyIframe = lobbyResult.split("@")[2];
            				}
            				
            				if(request.getParameter("mainp")!=null && request.getParameter("mainp").equals("QT")){//Proveedor QTech
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
                			//marcar indicador de device = mobile.
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
            LoggerApi.Log.info("getLobby OutData=" + outData);
        }
    }

    
    @RequestMapping(value = "/open-casino")
    public String opencasino(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();    	
    	if (session!=null) {
	    	String url = (session.getAttribute("url")!=null)?session.getAttribute("url").toString():"";
	    	request.setAttribute("url", url);
	    	session.removeAttribute("url");
    	}
        return "game/casino/home_casino_game";        
    }
    
    @RequestMapping(value = "/retorna-casino")
    public String retornacasino(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
	    return "game/casino/home_casino_retorna";        
    }
    
    @RequestMapping("/casino_submenu")
    public String submenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LoggerApi.Log.info("-------------- START game_casino_submenu"); 
		int clientId = 0;
		try {		   
			HttpSession session = request.getSession();	
			String forward = "game/casino/home-submenu";
			UserBean userBean = new UserBean();
			if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                clientId = userBean.getpClientid();                                
            }
			
			//VALIDAR SI EXISTE SESION PARA AGREGAR SUBMENU FAVORITOS*
			if(clientId != 0) {
				request.setAttribute("sesion","1");
			}
			
			return forward;				
		} catch (Exception e) {
			LoggerApi.severe(e);
			LoggerApi.Log.info("-------------- END game_casino_submenu"); 
			return "game/casino/home-submenu";
		}
    }
    
    @RequestMapping("/set-favorito")
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
    
    @RequestMapping(value = "/open-casino-raspaya")
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
			server = server.substring(0, server.lastIndexOf('/') + 1 ) +"juega-casino.html" ;
          
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
        return "game/casino/home_casino_game_ry";        
    }
    
    @RequestMapping(value = "/getJackpot")
    public void getJackpot(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        String jackpot = "-";
        out = response.getWriter();
        try {
        	if(request.getParameter("jackpotid")!=null)
        		jackpot = Constants.jackpotsMap.get(request.getParameter("jackpotid").toString());          	
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
