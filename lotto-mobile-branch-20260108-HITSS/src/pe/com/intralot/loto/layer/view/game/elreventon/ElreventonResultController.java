package pe.com.intralot.loto.layer.view.game.elreventon;

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
import pe.com.intralot.loto.layer.controller.game.elreventon.bo.ElreventonResultBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class ElreventonResultController {

	//static final Log logger = LogFactory.getLog(ElreventonResultController.class);    

	@Autowired
	private ElreventonResultBo beanElreventonResultBo;
	
	@RequestMapping("/game_elreventon_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");
    	try { 
    		objectModelMap.put("getListResult",beanElreventonResultBo.getResult());		
			return new ModelAndView("game/elreventon/interface-result");
			
		} catch (Exception e) {	
			LoggerApi.severe(e);			
			return new ModelAndView("game/elreventon/interface-result");
		}finally {
			//LoggerApi.Log.info("Salir al metodo: showResult. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir del action: ElreventonResultController.");
		}       	
	}	
}