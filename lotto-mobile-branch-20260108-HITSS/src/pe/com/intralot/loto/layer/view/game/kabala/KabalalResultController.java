package pe.com.intralot.loto.layer.view.game.kabala;

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

import pe.com.intralot.loto.layer.controller.game.kabala.bo.KabalaResultBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Controller
public class KabalalResultController {

    //static final Log logger = LogFactory.getLog(KabalalResultController.class);
    @Autowired
    private KabalaResultBo beanKabalalResultBo;

    @RequestMapping("/game_kabala_show_result")
    public ModelAndView showResult(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        LoggerApi.Log.info("");
        try {
            objectModelMap.put("getListResult", beanKabalalResultBo.getResult());
            return new ModelAndView("game/kabala/interface-result");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/kabala/interface-result");
        } finally {
            //LoggerApi.Log.info("Salir del método: showResult. Estado : Satisfactorio");
            //LoggerApi.Log.info("Salir del action: KabalalResultController.");
        }
    }
}
