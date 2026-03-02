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

import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class HelpController {

	//static final Log logger = LogFactory.getLog(HelpController.class);

	@RequestMapping("/help")	
	public String help(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
		
		LoggerApi.Log.info("");    
	
		try {
					
			return "home/interface-help";
         
		} catch(Exception e){
			LoggerApi.severe(e);	
			return "home/interface-help";
		} finally {
			//LoggerApi.Log.info("Salir de la clase: HelpController.");
			//LoggerApi.Log.info("Salir al metodo: home. Estado : Satisfactorio");
		}
	}
}