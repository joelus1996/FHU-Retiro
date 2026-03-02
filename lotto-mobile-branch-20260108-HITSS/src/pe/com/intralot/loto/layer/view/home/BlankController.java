package pe.com.intralot.loto.layer.view.home;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.com.intralot.loto.sale.card.dispatcher.BussinessSaleDispatcher;
import pe.com.intralot.loto.sale.lib.LoggerApi;


@Controller
public class BlankController {

	//static final Log logger = LogFactory.getLog(BlankController.class);    

	@RequestMapping("/blank")	
	public ModelAndView showMenu(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");
		
		try {		   
    		
			BussinessSaleDispatcher s = new BussinessSaleDispatcher();
			s.restartTerminals();
			objectModelMap.put("mensaje_alerta","Restart Terminals");
			
			return new ModelAndView("home/interface-blank");	
			
		} catch (Exception e) {
			
			LoggerApi.severe(e);
			return new ModelAndView("home/interface-blank");
		} finally{
			//LoggerApi.Log.info("Salir al action: BlankController.");
			//LoggerApi.Log.info("Salir al metodo: HomeBlank. Estado : Satisfactorio");
			
		}
		}
						
	}
	