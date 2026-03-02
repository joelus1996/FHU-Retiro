package pe.com.intralot.loto.layer.view.game.kinelo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.com.intralot.loto.layer.controller.game.kinelo.bo.KineloResultBo;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;

@Controller
public class KineloResultController {

	//static final Log logger = LogFactory.getLog(KineloResultController.class);    

	@Autowired
	private KineloResultBo beanKineloResultBo;
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/game_kinelo_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");
		try { 
    		HttpSession session = request.getSession(); 
    		
    		if(CollectionUtils.isEmpty((List<Draw>) session.getAttribute("dateResultKinelo"))){    			
    			session.setAttribute("dateResultKinelo",beanKineloResultBo.getResult());
    		}
     		
    		Date date =((List<Date>) session.getAttribute("dateResultKinelo")).get(0);
    		
			return new ModelAndView("redirect:game_kinelo_filter_result.html?filter="+new SimpleDateFormat("yyyy-MM-dd").format(date));
			
		} catch (Exception e) {	
			LoggerApi.severe(e);			
			return new ModelAndView("game/kinelo/interface-result");
		} finally{
			//LoggerApi.Log.info("Salir del método: showResult. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir del action: KineloResultController.");
		}   	
    	
  }
	
	
	@RequestMapping("/game_kinelo_filter_result")	
	public ModelAndView filterResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {		
		LoggerApi.Log.info("");
		try {    
    		String filter=request.getParameter("filter");  
    		Date date= new SimpleDateFormat("yyyy-MM-dd").parse(filter);    		
    		objectModelMap.put("title",date); 
    		    		
    		Object params[]=new Object[2];    		
	   		
    		params[0]=Constantes.GameKinelo.GAME_ID;
    		params[1]=new SimpleDateFormat("dd/MM/yyyy").format(date);  			
    		
    		objectModelMap.put("resultGamesKinelo",beanKineloResultBo.getResultForItem(params));
    		    		
	    	objectModelMap.put("filter","game_kinelo_filter_result.html?filter="+filter);
	    	
	    	return new ModelAndView("game/kinelo/interface-result");	
	    	
		} catch (Exception e) {	
			LoggerApi.severe(e);
			return new ModelAndView("game/kinelo/interface-result");	
		} finally{
			//LoggerApi.Log.info("Salir del método: filterResult. Estado : Satisfactorio");
	    	//LoggerApi.Log.info("Salir del action: GanagollResultController.");	
		}     	    	
    	
    	
  }	
	

	
}



