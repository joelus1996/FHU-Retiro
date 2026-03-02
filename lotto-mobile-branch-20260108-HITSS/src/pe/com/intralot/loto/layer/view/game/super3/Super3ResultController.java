package pe.com.intralot.loto.layer.view.game.super3;

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
import pe.com.intralot.loto.layer.controller.game.super3.bo.Super3ResultBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class Super3ResultController {

	//static final Log logger = LogFactory.getLog(Super3ResultController.class);    

	@Autowired
	private Super3ResultBo beanSuper3ResultBo;
	

	@RequestMapping("/game_super3_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");
    	try { 
    			objectModelMap.put("getListResult",beanSuper3ResultBo.getResult());
    		
			return new ModelAndView("game/super3/interface-result");
			
		} catch (Exception e) {	
			LoggerApi.severe(e);			
			return new ModelAndView("game/super3/interface-result");
		} finally{
			//LoggerApi.Log.info("Salir del método: showResult. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir del action: Super3ResultController.");
		}    	
    	
  }
	

	
}



