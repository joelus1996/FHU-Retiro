package pe.com.intralot.loto.layer.controller.game.teapuesto.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.game.teapuesto.bo.TeapuestoResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.EventDao;
import pe.com.intralot.loto.layer.model.pojo.Event;
import pe.com.intralot.loto.sale.lib.LoggerApi;
@Service("beanTeapuestoResultBo")
public class TeapuestoResultBoImpl implements TeapuestoResultBo {
 
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private EventDao beanEventDao;
	
	public List<Event> getDataRegularHeaderForResult() throws Exception {
		List<Event> objectList=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("getDataRegularHeaderForResult()");
			objectList= beanEventDao.findWithCondition06();
			
			return objectList;
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectList!=null){
				LoggerApi.Log.info("objectList: "+objectList.size());	
			}else{
				LoggerApi.Log.info("objectList: "+"null");
			}
			
			
		}
	}


	
	public List<Event> getResultForEvent(Object[] params) throws Exception {
		List<Event> objectList=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("params:"+params.length);
			objectList= beanEventDao.findWithCondition07(params);
			
			return objectList;
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectList!=null){
				LoggerApi.Log.info("objectList: "+objectList.size());
			}else{
				LoggerApi.Log.info("objectList: "+"null");
			}
			
			}
	}
	
	
}