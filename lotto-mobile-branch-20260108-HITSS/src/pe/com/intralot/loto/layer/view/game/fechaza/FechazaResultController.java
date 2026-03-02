package pe.com.intralot.loto.layer.view.game.fechaza;

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

import pe.com.intralot.loto.layer.controller.game.fechaza.bo.FechazaResultBo;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;


@Controller
public class FechazaResultController {

	//static final Log logger = LogFactory.getLog(FechazaResultController.class);    

	@Autowired
	private FechazaResultBo beanFechazaResultBo;
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/game_fechaza_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");     	    
    	try { 
    		HttpSession session = request.getSession(); 
    		
    		if(CollectionUtils.isEmpty((List<Draw>) session.getAttribute("dateResultFechaza"))){    			
    			session.setAttribute("dateResultFechaza",beanFechazaResultBo.getResult());
    		}
     		
    		Date date =((List<Date>) session.getAttribute("dateResultFechaza")).get(0);
    		
			return new ModelAndView("redirect:game_fechaza_filter_result.html?filter="+new SimpleDateFormat("yyyy-MM-dd").format(date));
			
			
		} catch (Exception e) {	
			LoggerApi.severe(e);			
			return new ModelAndView("game/fechaza/interface-result");
		} finally{
			//LoggerApi.Log.info("Salir del método: showResult. Estado : Satisfactorio");
			//LoggerApi.Log.info("Salir del action: FechazaResultController.");
		}  	
    	
  }
	
	
	@RequestMapping("/game_fechaza_filter_result")	
	public ModelAndView filterResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {		
		LoggerApi.Log.info("");     	    
    	try {    
    		
    		String filter=request.getParameter("filter");  
    		Date date= new SimpleDateFormat("yyyy-MM-dd").parse(filter);    		
    		objectModelMap.put("title",date); 
    		    		
    		Object params[]=new Object[2];    		
	   		
    		params[0]=Constantes.GameFechaza.GAME_ID;
    		params[1]=new SimpleDateFormat("dd/MM/yyyy").format(date);  			
    		
    		objectModelMap.put("resultGamesFechaza",beanFechazaResultBo.getResultForItem(params));
    		    		
	    	objectModelMap.put("filter","game_fechaza_filter_result.html?filter="+filter);
	    	
	    	return new ModelAndView("game/fechaza/interface-result");	
	    	
		} catch (Exception e) {	
			LoggerApi.severe(e);
			return new ModelAndView("game/fechaza/interface-result");	
		}  finally{
			//LoggerApi.Log.info("Salir del método: filterResult. Estado : Satisfactorio");
	    	//LoggerApi.Log.info("Salir del action: FechazaResultController.");	
		}    	    	
    	
    	
  }	
	

	
}



