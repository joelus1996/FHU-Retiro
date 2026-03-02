package pe.com.intralot.loto.layer.view.game.teapuesto;

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
import pe.com.intralot.loto.layer.controller.game.teapuesto.bo.TeapuestoResultBo;
import pe.com.intralot.loto.layer.model.pojo.Event;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class TeapuestoResultController {

	//static final Log logger = LogFactory.getLog(TeapuestoResultController.class);    

    @Autowired
    private TeapuestoResultBo beanTeapuestoResultBo;
				
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/game_teapuesto_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("TeapuestoResultController.showResult");     	    
    	try { 
    		
    		HttpSession session = request.getSession();  
    	   
    		if(CollectionUtils.isEmpty((List<Event>) session.getAttribute("dateResultTeapuesto"))){
    			List<Event> list = beanTeapuestoResultBo.getDataRegularHeaderForResult();
    			session.setAttribute("dateResultTeapuesto",list);
    			LoggerApi.Log.info("list.size()="+list.size()); 
    		}
    		    		   		
    		List<Date> list = (List<Date>) session.getAttribute("dateResultTeapuesto");
    		Date datep = list.get(0);
			//Date datep = e.getDatePrincipal();
    		   		
    		String filter= new SimpleDateFormat("yyyy-MM-dd").format(datep);

			LoggerApi.Log.info("filter="+filter); 
			
			return new ModelAndView("redirect:game_teapuesto_filter_result.html?filter="+filter);
			
		} catch (Exception e) {	 
			LoggerApi.severe(e);			
			return new ModelAndView("game/teapuesto/interface-result");
		}   	 	    	
    	
  }
	
	

	@RequestMapping("/game_teapuesto_filter_result")	
	public ModelAndView filterResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {		
		LoggerApi.Log.info("TeapuestoBetController.filterGame");     	    
    	try {    
    		
    		String filter=request.getParameter("filter");  
	    	LoggerApi.Log.info("TeapuestoBetController.filterGame filter="+filter);	
    		Date date= new SimpleDateFormat("yyyy-MM-dd").parse(filter);    		
    		objectModelMap.put("title",date); 
    		
    		Object params[]=new Object[1];    		
	   		
    		params[0]= new SimpleDateFormat("dd/MM/yyyy").format(date);    			
    		
    		objectModelMap.put("resultGamesTeapuesto",beanTeapuestoResultBo.getResultForEvent(params)); 
    		
	    	objectModelMap.put("filter","game_teapuesto_filter_result.html?filter="+new SimpleDateFormat("yyyy-MM-dd").format(date));
	    	
	    	LoggerApi.Log.info("date="+date);	
	    	
	    	return new ModelAndView("game/teapuesto/interface-result");	
	    	
		} catch (Exception e) {	 
			LoggerApi.severe(e);
			return new ModelAndView("game/teapuesto/interface-result");	
		}    	    	
    	
    	
  }	
	
}



