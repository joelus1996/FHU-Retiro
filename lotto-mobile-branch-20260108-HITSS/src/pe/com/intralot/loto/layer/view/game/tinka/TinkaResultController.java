package pe.com.intralot.loto.layer.view.game.tinka;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.controller.game.tinka.bo.TinkaResultBo;
import pe.com.intralot.loto.layer.model.pojo.TinkaList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class TinkaResultController {

	//static final Log logger = LogFactory.getLog(TinkaResultController.class);    

	@Autowired
	private TinkaResultBo beanTinkaResultBo;
				
	
	@RequestMapping("/game_tinka_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");
		try { 
    		List<TinkaList> list = beanTinkaResultBo.getResult();
			objectModelMap.put("getListResult",list);
			return new ModelAndView("game/tinka/interface-result");
			
		} catch (Exception e) {	
			LoggerApi.severe(e);			
			return new ModelAndView("game/tinka/interface-result");
		}   finally{
			//LoggerApi.Log.info("Salir del método: showResult. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir del action: TinkaResultController.");
			
		} 	 	    	
    	
  }
	
}



