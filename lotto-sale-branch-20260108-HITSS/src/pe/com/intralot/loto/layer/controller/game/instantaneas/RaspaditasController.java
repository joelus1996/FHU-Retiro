package pe.com.intralot.loto.layer.controller.game.instantaneas;

import java.io.PrintWriter;
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
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaGameId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductPozoList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductPriceList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.game.raspaditas.bo.RaspaditasBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>
 * NOMBRE: RaspaditasController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador juego Raspaditas
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Celso Larico  15/11/2019  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class RaspaditasController {

    @Autowired
    private RaspaditasBo raspaditasBo;
    @Autowired
    private ClientSaleBo clientSaleBo;

    @RequestMapping(value = "/juega-raspaya-")
    public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
        HttpSession session = request.getSession();
        String context = Constants.contextCardWeb;
        Integer idSession = 0;
        Integer idClient = 0;
        String user = "";
        String forward = "game/raspaditas/home_raspaditas_user";
        ClientProcedureGetDataClient dataClient = null;
        int state = 0;
        try {
        	if(request.getParameter("state")!=null && !request.getParameter("state").toString().trim().equals("")) state = Integer.parseInt(request.getParameter("state").toString().trim());
        	UserBean userBean = new UserBean();
            if(session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                    && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
                userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
                idSession = userBean.getpSessionid();
                idClient = userBean.getpClientid();
                user = userBean.getpUser();
                ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
                dataClient = clientSaleBo.findGetDataClient(idSession, idClient);
                request.setAttribute("clientSale", clientProcedureGetClient);
                request.setAttribute("dataClient", dataClient);
                if(clientProcedureGetClient == null) {
                    session.invalidate();
                    return "redirect:/inicio.html";
                }
                userBean.setpGame(Game.TINKA);
                if (clientProcedureGetClient!=null && clientProcedureGetClient.getAmount()!=null) {
                    userBean.setpMonto(clientProcedureGetClient.getAmount());
                }
                
                ClientProcedureAccountData clientProcedureAccountData = clientSaleBo.findAccountData(idClient);
				clientProcedureAccountData = ClientUtils.verifiedTestUsersWelcomeBonus(clientProcedureAccountData,session);
				String result = new Gson().toJson(clientProcedureAccountData);
				session.setAttribute("clientBalance", result);
				
                session.setAttribute(Constants.USR_SESION, userBean);
            }

            JsonObject joDataClient = new JsonObject();
			joDataClient.addProperty("bcpMaxAmount", (ConnectionFactory.operationProperty("maxTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("maxTerminalPriceBuy", context).trim():"10000");
            joDataClient.addProperty("bcpMinAmount", (ConnectionFactory.operationProperty("minTerminalPriceBuy", context) != null)?ConnectionFactory.operationProperty("minTerminalPriceBuy", context).trim():"50");
            joDataClient.addProperty("pefeMaxAmount", (ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMaxAmount", context).trim():"3000");
            joDataClient.addProperty("pefeMinAmount", (ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context) != null)?ConnectionFactory.operationProperty("pagoEfectivoMinAmount", context).trim():"40");
            joDataClient.addProperty("sfpyMaxAmount", (ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMaxAmount", context).trim():"3000");
            joDataClient.addProperty("sfpyMinAmount", (ConnectionFactory.operationProperty("safetyPaymentMinAmount", context) != null)?ConnectionFactory.operationProperty("safetyPaymentMinAmount", context).trim():"40");
            request.setAttribute("chargeData", joDataClient);
            
            JsonObject config = new JsonObject();
            if(request.getParameter("game")!=null){
            	String gameId = "";
            	String mode = "";
            	String token = "";
            	forward = "game/raspaditas/home_raspaditas_game";
            	
            	
            	ClientProcedureGetRaspayaGameId rgameId = clientSaleBo.findGetRaspayaGameId(request.getParameter("game").toString());
            	gameId = rgameId.getGameId();
            	
            	mode = request.getParameter("mode").toString();
            	
            	if(request.getParameter("mode").equals("live")) {
            		//validar que haya sesion activa
            		if(idSession != 0) {//existe sesion entonces genera token
            			ClientProcedureIIVVTokenGeneration iivvTokenGeneration = clientSaleBo.getIIVVToken(userBean.getpClientid(), request.getRemoteAddr(), "d");
        	          	if (iivvTokenGeneration!=null && iivvTokenGeneration.getMessage().equals("OK")) {
        	          		token = iivvTokenGeneration.getToken();
        	          	}
            			
            		}else {//no existe sesion
            			request.setAttribute("nolive","1");
            			forward = "game/raspaditas/home_raspaditas_user";
            		}
            	}
            	
            	 config.addProperty("gameid",gameId);
            	 config.addProperty("channel",Constants.RASPADITAS_CHANNEL);
            	 config.addProperty("token",token);
            	 config.addProperty("language",Constants.RASPADITAS_LANGUAGE);
            	 config.addProperty("currency",Constants.RASPADITAS_CURRENCY);
            	 config.addProperty("partner",Constants.RASPADITAS_PARTNER);
            	 config.addProperty("mode",mode);  
            	 config.addProperty("integrateorigin",request.getRequestURL().toString());
            	 config.addProperty("lobbyurl",request.getRequestURL().toString());
                 request.setAttribute("config",config);
                 request.setAttribute("mode",mode);
                 
                 if (gameId.equals("0")) {
             		request.setAttribute("nogame","1");
             		request.setAttribute("config","");
             		forward = "game/raspaditas/home_raspaditas_user";
             	}
            }	            
           
            return forward;
            
        } catch (Exception e) {
            LoggerApi.severe(e);
            request.setAttribute(Constants.ALERT_MSG, "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.");
            return "game/raspaditas/home_raspaditas_user";
        } finally {
            request.setAttribute("isAllowed", raspaditasBo.isAllowedGoIn(user));
            LoggerApi.Log.info("isAllowed=" + raspaditasBo.isAllowedGoIn(user));
            LoggerApi.Log.info("idClient:=" + idClient + " idSession:=" + idSession);
        }
    }
   
    @RequestMapping("/game_raspaya_product_list-")
	public void showProducList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductList> listProducts =  clientSaleBo.listRaspayaProducts();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_productprice_list")
	public void showProducPriceList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductPriceList> listProducts =  clientSaleBo.listRaspayaProductsPrice();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
    
    @RequestMapping("/game_raspaya_productpozo_list")
	public void showProducPozoList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetRaspayaProductPozoList> listProducts =  clientSaleBo.listRaspayaProductsPozo();
    	
    	String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
    }
}
