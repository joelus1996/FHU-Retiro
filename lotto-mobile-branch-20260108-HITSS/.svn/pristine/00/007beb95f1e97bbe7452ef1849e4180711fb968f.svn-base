package pe.com.intralot.loto.layer.controller.game.kabala.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobil
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.game.kabala.bo.KabalaResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.KabalaList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanKabalaResultBo")
public class KabalaResultBoImpl implements KabalaResultBo {

    //protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private ViewDAO beanViewDAO;

    public List<KabalaList> getResult() throws Exception {
        List<KabalaList> objectList = new ArrayList<KabalaList>();
        try {
            LoggerApi.Log.info("");
            objectList = beanViewDAO.findWithCondition04();
            for(KabalaList l:objectList) {
				if(l.getRawid()>5000) l.setDrwid(l.getRawid()-5000);
				else l.setDrwid(l.getRawid());
			}
            return objectList;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (objectList != null)
                LoggerApi.Log.info("objectList: " + objectList.size());
            else
                LoggerApi.Log.info("objectList: " + "null");
        }
    }
}