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
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesCategoryProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.Fingerprint;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * NOMBRE: VirtualesController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Virtuales
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
public class VirtualesController {

    @Autowired
    private ClientSaleBo clientSaleBo;
    private static String device = "d";

    @RequestMapping("/game_virtuales_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetVirtualesProductList> listProducts =  clientSaleBo.listVirtualesProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_virtuales_product_list_order")
	public void showProducListOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetVirtualesProductListOrder> listProducts =  clientSaleBo.listVirtualesProductsOrder();
    	
    	String jsonList = new Gson().toJson(listProducts);
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
		UserBean userBean = new UserBean();
		if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
			userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
			clientId = userBean.getpClientid();
		}
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
    
    @RequestMapping(value = "/juega-virtuales")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
    	String juego = "virtuales";
        
        request.setAttribute("type",juego);
        
        return "game/casino/home_casino_teapuesto";
    }
    
	@RequestMapping(value = "/juega-latinka-video-loterias")
	public String findIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList)
			throws Exception {
		HttpSession session = request.getSession();
		String context = Constants.contextCardWeb;
		Integer idSession = 0;
		Integer idClient = 0;
		String scategory = "";
		String forward = "game/videoloteria/home_videoloteria_user";
		ClientProcedureGetDataClient dataClient = null;

		try {
			UserBean userBean = new UserBean();

			JsonObject providers = new JsonObject();
			JsonObject category = new JsonObject();
			JsonObject categoryProviders = new JsonObject();
			// arma proveedores y categorias
			List<ClientProcedureGetVirtualesProviderList> listProvider = clientSaleBo.listProvidersVirtuales();
			List<ClientProcedureGetVirtualesCategoryProviderList> listCategoryProvider = clientSaleBo
					.listCategoryProvidersVirtuales();
			for (ClientProcedureGetVirtualesProviderList item : listProvider) {
				providers.addProperty(item.getProviderid(), item.getName());
			}
			request.setAttribute("providers", providers);
			scategory = listCategoryProvider.get(0).getCategory().toString();
			int count = 0;
			for (ClientProcedureGetVirtualesCategoryProviderList itemcp : listCategoryProvider) {
				if (scategory.equals(itemcp.getCategory().toString())) {
					categoryProviders.addProperty(String.valueOf(count), itemcp.getProviderid());
				} else {
					category.add(scategory, categoryProviders);
					scategory = itemcp.getCategory();
					categoryProviders = new JsonObject();
					categoryProviders.addProperty(String.valueOf(count), itemcp.getProviderid());
				}
				count++;
			}
			category.add(scategory, categoryProviders);
			request.setAttribute("categoryProviders", category);
			// fin

			if (session.getAttribute(Constants.USR_SESION) != null
					&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
					&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
				idSession = userBean.getpSessionid();
				idClient = userBean.getpClientid();
				ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
				dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
				request.setAttribute("clientSale", clientProcedureGetClient);
				request.setAttribute("dataClient", dataClient);
				if (clientProcedureGetClient == null) {
					session.invalidate();
					return "redirect:/inicio.html";
				}
				userBean.setpGame(Game.TINKA);
				if (clientProcedureGetClient != null && clientProcedureGetClient.getAmount() != null) {
					userBean.setpMonto(clientProcedureGetClient.getAmount());
				}

				JsonObject productos = new JsonObject();
				HashMap[] productList = clientSaleBo.getFavoriteProductVirtuales(String.valueOf(idClient));
				for (HashMap hashMap : productList) {
					productos.addProperty(hashMap.get("VF_PRODUCT_ID").toString(), 1);
				}
				request.setAttribute("productos", productos);
				// Si no hay productos, asignar por lo menos ("0",1)
				productos.addProperty("0", 1);

				ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
				clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,
						session);
				String result = new Gson().toJson(clientProcedureAccountData);
				session.setAttribute("clientBalance", result);

				session.setAttribute(Constants.USR_SESION, userBean);
				request.setAttribute("sesion", "1");
			} else {
				request.setAttribute("productos", "{}");
			}
			if (request.getParameter("mode") == null && request.getParameter("game") != null) {
				StringBuilder sbParametros = new StringBuilder();
				forward = "game/virtuales/home_virtuales_game";

				if (idClient != 0) {// con sesion activa
					String token = "0";
					ClientProcedureDDVVTokenGeneration ddvvTokenGeneration = clientSaleBo.getDDVVToken(idClient,
							request.getRemoteAddr(), device);
					if (ddvvTokenGeneration != null && ddvvTokenGeneration.getMessage().equals("OK")) {
						token = ddvvTokenGeneration.getToken();
					}
					String h = Fingerprint.hash(token, request.getParameter("game"), request.getRequestURL().toString(),
							Constants.XPRESS_MODE_REAL, Constants.XPRESS_LANGUAGE, Constants.XPRESS_PLATFORM);
					sbParametros.append("?token=").append(token).append("&game=").append(request.getParameter("game"))
							.append("&backurl=").append(request.getRequestURL().toString()).append("&mode=")
							.append(Constants.XPRESS_MODE_REAL).append("&language=").append(Constants.XPRESS_LANGUAGE)
							.append("&clientPlatform=").append(Constants.XPRESS_PLATFORM).append("&h=").append(h);
					request.setAttribute("iframeVirtualesLobbyURL",
							Constants.XPRESS_URL_LOBBY + sbParametros.toString());

				} else {// sin sesion activa
					String h = Fingerprint.hash(Constants.XPRESS_TOKEN_DEMO, request.getParameter("game"),
							request.getRequestURL().toString(), Constants.XPRESS_MODE_DEMO, Constants.XPRESS_LANGUAGE,
							Constants.XPRESS_PLATFORM);
					sbParametros.append("?token=").append(Constants.XPRESS_TOKEN_DEMO).append("&game=")
							.append(request.getParameter("game")).append("&backurl=")
							.append(request.getRequestURL().toString()).append("&mode=")
							.append(Constants.XPRESS_MODE_DEMO).append("&language=").append(Constants.XPRESS_LANGUAGE)
							.append("&clientPlatform=").append(Constants.XPRESS_PLATFORM).append("&h=").append(h);
					request.setAttribute("iframeVirtualesLobbyURL",
							Constants.XPRESS_URL_LOBBY + sbParametros.toString());
				}
				request.setAttribute("regresarLobbyDDVV1", Constants.XPRESS_REGRESAR_LOBBY1);
				request.setAttribute("regresarLobbyDDVV2", Constants.XPRESS_REGRESAR_LOBBY2);
			}
			JsonObject joDataClient = new JsonObject();
			joDataClient.addProperty("bcpMaxAmount",
					(ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)
							? ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim()
							: "10000");
			joDataClient.addProperty("bcpMinAmount",
					(ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)
							? ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim()
							: "50");
			joDataClient.addProperty("pefeMaxAmount",
					(ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)
							? ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim()
							: "3000");
			joDataClient.addProperty("pefeMinAmount",
					(ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)
							? ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim()
							: "40");
			joDataClient.addProperty("sfpyMaxAmount",
					(ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)
							? ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim()
							: "3000");
			joDataClient.addProperty("sfpyMinAmount",
					(ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)
							? ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim()
							: "40");
			request.setAttribute("chargeData", joDataClient);

			return forward;
		} catch (Exception e) {
			LoggerApi.severe(e);
			request.setAttribute(Constants.ALERT_MSG,
					"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
			return "game/videoloteria/home_videoloteria_user";
		} finally {
			request.setAttribute("isAllowed", true);
			LoggerApi.Log.info("isAllowed=" + true);
			LoggerApi.Log.info("idClient:=" + idClient + " idSession:=" + idSession);
		}

	}

    @RequestMapping("/set-favorito-virtuales")
    public void setFavorito(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			UserBean userBean = new UserBean();
            
			if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                clientId = userBean.getpClientid();                                
            }
            
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
