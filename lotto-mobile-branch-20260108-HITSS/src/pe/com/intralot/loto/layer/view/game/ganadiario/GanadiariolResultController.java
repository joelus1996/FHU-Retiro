package pe.com.intralot.loto.layer.view.game.ganadiario;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.controller.game.ganadiario.bo.GanadiarioResultBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class GanadiariolResultController {

	//static final Log logger = LogFactory.getLog(GanadiariolResultController.class);    

	@Autowired
	private GanadiarioResultBo beaGanadiarioResultBo;
	
				
	@RequestMapping("/game_ganadiario_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
    	try { 
    		
			objectModelMap.put("getListResult",beaGanadiarioResultBo.getResult());
			
			return new ModelAndView("game/ganadiario/interface-result");
			
		} catch (Exception e) {
			
			LoggerApi.severe(e);
			return new ModelAndView("game/ganadiario/interface-result");
			
		} finally {
			LoggerApi.Log.info("game_ganadiario_show_result");
		}
    	
  }
	
}



