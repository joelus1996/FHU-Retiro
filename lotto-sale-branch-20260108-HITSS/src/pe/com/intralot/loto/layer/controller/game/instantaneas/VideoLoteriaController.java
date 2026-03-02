package pe.com.intralot.loto.layer.controller.game.instantaneas;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLotteryProductList;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.VideoLoteriaUtils;

/**
 * <p>
 * NOMBRE: VideoLoteria.java <br>
 * </p>
 * <p>
 * FUNCION: Controlador juego Video Loteria <br>
 * </p>
 * <p>
 * NOTAS: Ninguna. <br>
 * </p>
 * <p>
 * VERSIONES
 * 
 * <pre>
 * VER   MODIFICADO       
 * 001   Morellia Rodriguez
 * </pre>
 * 
 * <br>
 * </p>
 */
@Controller
public class VideoLoteriaController {
	@Autowired
	private ClientSaleBo clientSaleBo;
	private static String device = "d";

	@RequestMapping("/game_videoloteria_product_list")
	public void showProducList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = null;
		response.setContentType("text/json; charset=UTF-8");
		out = response.getWriter();
		List<ClientProcedureGetLotteryProductList> listProducts = clientSaleBo.listLotteryProducts();

		String jsonList = new Gson().toJson(listProducts);
		out.println(jsonList);
	}

	@RequestMapping(value = "/open-videoloteria")
	public String openVideoloteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			String url = (session.getAttribute("url") != null) ? session.getAttribute("url").toString() : "";
			request.setAttribute("url", url);
			session.removeAttribute("url");
		}
		return "game/videoloteria/home_videoloteria_game";
	}

	@RequestMapping(value = "/getLobbyVideoLoteria")
	public void getLobbyVideoloteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer idClient = 0;
		String outData = "";
		String mode = "";
		PrintWriter out = null;
		out = response.getWriter();
		try {
			UserBean userBean = new UserBean();
			if (session.getAttribute(Constants.USR_SESION) != null
					&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
					&& ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null) {
				userBean = (UserBean) session.getAttribute(Constants.USR_SESION);
				idClient = userBean.getpClientid();
			}
			if (request.getParameter("demo") != null) {
				outData = request.getParameter("demo") + "?language=es&currency=PEN";
				session.setAttribute("url", request.getParameter("demo") + "?language=es&currency=PEN");
			} else {
				if (request.getParameter("game") != null) {
					String gameId = request.getParameter("game");
					String lobbyResult = "";
					String lobbyIframe = "";
					// validar que haya sesion activa
					if (idClient != 0) {// existe sesion entonces genera urlLobby
						// OBTENER URL LOBBY
						String server = request.getRequestURL().toString();
						VideoLoteriaUtils videoLoteriaUtils = new VideoLoteriaUtils();
						server = server.substring(0, server.lastIndexOf('/') + 1) + "juega-latinka-video-loterias.html";

						clientSaleBo.updateDevice(idClient, device);

						List<ClientProcedureGetLotteryProductList> listProducts = clientSaleBo.listLotteryProducts();
						for (ClientProcedureGetLotteryProductList obj : listProducts) {
							if (obj.getGameproductid().equals(gameId) && obj.getProvname().equals("Spinal")) {
								server = server.substring(0, server.lastIndexOf('/') + 1) + "retorna-videoloteria.html";
								break;
							}
						}

						if (request.getParameter("mainp") != null && request.getParameter("mainp").equals("XP")) {// Proveedor // XpressGaming
							if (request.getParameter("category") != null) {
								videoLoteriaUtils = new VideoLoteriaUtils("createPlayer", idClient.toString(), clientSaleBo);
								String playerId = videoLoteriaUtils.processCreate();
								try {
									if (!playerId.isEmpty())
										clientSaleBo.updatePlayerIdVl(idClient, playerId);
										lobbyResult = videoLoteriaUtils.getLobbyUrlVl(String.valueOf(idClient), gameId, server,
												Constants.VIDEO_LOTERIA_LANGUAGE);
								} catch (Exception e) {
									lobbyResult = "-@-@-@";
								}
							} else
								lobbyResult = videoLoteriaUtils.getLobbyUrlVl(String.valueOf(idClient), gameId, server,
										Constants.VIDEO_LOTERIA_LANGUAGE);

							lobbyIframe = lobbyResult;
						}
						outData = lobbyIframe;
						session.setAttribute("url", lobbyIframe);
						// marcar indicador de device = mobile.
						clientSaleBo.updateDevice(idClient, device);
					} else {// no existe sesion
						request.setAttribute("nolive", "1");
						outData = "sinSesion";
					}
				}
			}

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			LoggerApi.Log.info("getLobbyVl OutData=" + outData);
		}
	}
	
	 @RequestMapping(value = "/retorna-videoloteria")
	    public String retornaVideoLoteria(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	
		    return "game/videoloteria/home_videoloteria_retorna";        
	    }
	 

}
