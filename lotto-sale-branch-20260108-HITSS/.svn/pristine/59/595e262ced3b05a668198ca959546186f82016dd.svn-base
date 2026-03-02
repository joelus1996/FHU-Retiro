package pe.com.intralot.loto.layer.controller.game.tinkamegabol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.game.tinka.bo.TinkaBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;

@Controller
public class TinkaMegabolController {
	@Autowired
	private TinkaBo tinkaBo;

	@Autowired
	private ClientSaleBo clientSaleBo;

	@RequestMapping(value = "/tinkaMegabol_find_idClient")
	public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
		// Integer
		// idClient=Integer.parseInt(request.getParameter("clienIdClient"));
		// pruebas con valor 4
		HttpSession session = request.getSession();
		Integer idSession = 0;
		Integer idClient = 0;
		try {
			if ((UserBean) session.getAttribute(Constants.USR_SESION) != null) {
				idSession = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid();
				idClient = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
				// System.out.println("idSession="+idSession+" idClient="+idClient);
				ClientProcedureGetClient clientProcedureGetClient = clientSaleBo.findClient(idSession, idClient);
				request.setAttribute("clientSale", clientProcedureGetClient);
				// Validamos que la session y el redireccionamiento a la pagina
				// principal
				if (clientProcedureGetClient == null) {
					session.invalidate();
					return "redirect:/inicio.html";
				}
			}
			List<TinkaProcedureDrawData> tinkaSaleList = tinkaBo.findListDraw();

			modelList.put("tinkaSaleList", tinkaSaleList);

			TinkaProcedureBetData tinkaSaleBean = tinkaBo.findByClientId(idClient);

			 if(tinkaSaleBean.getPriceMessage().trim().length()>6) {
	            	tinkaSaleBean.setPromotionMessage(tinkaSaleBean.getPriceMessage());
	            	tinkaSaleBean.setPriceMessage("");
	            } else {
	            	tinkaSaleBean.setPromotionMessage("Costo por jugada: ");
	            }
			request.setAttribute("tinkaSale", tinkaSaleBean);
			return "game/tinka/home_tinka_user";

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {

		}
	}

	@RequestMapping(value = "/tinkaMegabol_find_listDraw")
	public String findListDaw(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		try {
			List<TinkaProcedureDrawData> tinkaSaleList = tinkaBo.findListDraw();

			model.put("tinkaSaleList", tinkaSaleList);
			return "";

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {

		}
	}

}
