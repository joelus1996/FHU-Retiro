package pe.com.intralot.loto.layer.view.game.tinkamegabol;

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
import pe.com.intralot.loto.layer.controller.game.tinkamegabol.bo.TinkamegabolResultBo;
import pe.com.intralot.loto.layer.model.pojo.TinkaList;
import pe.com.intralot.loto.sale.lib.LoggerApi;


@Controller
public class TinkamegabolResultController {

	//static final Log logger = LogFactory.getLog(TinkamegabolResultController.class);    

	@Autowired
	private TinkamegabolResultBo beanTinkamegabolResultBo;
	
	@RequestMapping("/game_tinkamegabol_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");
		try { 
    		List<TinkaList> list = beanTinkamegabolResultBo.getResult();
    		for (TinkaList tinkaList : list) {
    			tinkaList.setResult(tinkaList.getResult().replace(" ", " - "));
			}
			objectModelMap.put("getListResult",list);
						
			return new ModelAndView("game/tinkamegabol/interface-result");
			
		} catch (Exception e) {	
			LoggerApi.severe(e);		
			return new ModelAndView("game/tinkamegabol/interface-result");
		}  finally{
			//LoggerApi.Log.info("Salir del método: showResult. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir del action: TinkamegaBolResultController.");
			
		} 	 	    	
    	
  }
	
}



