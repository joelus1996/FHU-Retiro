package pe.com.intralot.loto.layer.view.game.ganagol;

import java.util.ArrayList;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.intralot.loto.layer.controller.game.ganagol.bo.GanagolBetBo;
import pe.com.intralot.loto.layer.controller.game.ganagol.bo.GanagolResultBo;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.GanagolList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class GanagollResultController {

	//static final Log logger = LogFactory.getLog(GanagollResultController.class);    

	@Autowired
	private GanagolResultBo beaGanagolResultBo;
	
	@Autowired
	private GanagolBetBo beanGanagolBetBo;
				
	@SuppressWarnings("unchecked")
	@RequestMapping("/game_ganagol_show_result")	
	public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		    
    	try { 
    		
     		HttpSession session = request.getSession();  
     	   
    		if(CollectionUtils.isEmpty((List<GanagolList>) session.getAttribute("dateResultGanagol"))){    			
    			session.setAttribute("dateResultGanagol",beaGanagolResultBo.getResult());
    		}
    		
    		List<GanagolList> objectList=(List<GanagolList>)session.getAttribute("dateResultGanagol");
    		for(GanagolList l:objectList) {
    			Object params[]=new Object[2]; 
    			params[0]=l.getRawid();
    			params[1]=l.getDate();
				Draw resultDraw=beanGanagolBetBo.findInformationForDraw(params);
				l.setResultadoG200(resultDraw.getDrAddonResult1());
			}
    		    		   		
    		Integer filter= ((List<GanagolList>) session.getAttribute("dateResultGanagol")).get(0).getRawid();
    		
    		String date =((List<GanagolList>) session.getAttribute("dateResultGanagol")).get(0).getDate();
			
			return new ModelAndView("redirect:game_ganagol_filter_result.html?filter="+filter+"&date="+date);
			
		} catch (Exception e) {	
			LoggerApi.severe(e);		
			return new ModelAndView("game/ganagol/interface-result");
		}   	 	    	
    	
  }
	
	@RequestMapping("/game_ganagol_filter_result")	
	public ModelAndView filterResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
    	try {
    		String filter=request.getParameter("filter");  
    		String date=request.getParameter("date");
    		Integer drwid = (filter!=null&&!filter.trim().equals(""))?Integer.parseInt(filter.trim()):null;
    		if(drwid!=null&&drwid>5000) drwid = drwid-5000;
    		objectModelMap.put("drwid",drwid); 
    		objectModelMap.put("title",date); 
    		
    		Object params[]=new Object[1];    		
	   		
    		params[0]=(filter!=null && !filter.toString().trim().equals(""))?Integer.valueOf(filter).intValue():0;
    		
    		objectModelMap.put("resultGamesGanagol",beaGanagolResultBo.getResultForItem(params));
    		
	    	objectModelMap.put("filter","game_ganagol_filter_result.html?filter="+filter+"&"+date);
	    	
	    	Object params2[]=new Object[2];
	    	params2[0]=(filter!=null && !filter.toString().trim().equals(""))?Integer.valueOf(filter).intValue():0;
	    	params2[1]=date;
	    	Draw resultDraw=beanGanagolBetBo.findInformationForDraw(params2);
	    	objectModelMap.put("resultadoG200",resultDraw.getDrAddonResult1());
	    	
	    	return new ModelAndView("game/ganagol/interface-result");	
	    	
		} catch (Exception e) {	
			LoggerApi.severe(e);
			return new ModelAndView("game/ganagol/interface-result");	
		}    	    	
    	
    	
  }	
}



