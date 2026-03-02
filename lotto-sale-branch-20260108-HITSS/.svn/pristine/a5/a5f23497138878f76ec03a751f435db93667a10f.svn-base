package pe.com.intralot.loto.layer.controller.game.giromagico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.intralot.loto.sale.lib.LoggerApi;

public class GiromagicoController {

	@RequestMapping(value = "/juega_giromagico")
	public String findByIdCliente(HttpServletRequest request, HttpServletResponse response, ModelMap modelList) throws Exception {
		try {
			return "game/giromagico/home_giromagico_user";
		} catch (Exception e) {
			LoggerApi.severe(e);
			return "game/giromagico/home_giromagico_user";
		} finally {
		}
	}

}
