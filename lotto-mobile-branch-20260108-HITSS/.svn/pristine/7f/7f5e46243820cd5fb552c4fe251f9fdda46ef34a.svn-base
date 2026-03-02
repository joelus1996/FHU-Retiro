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
import pe.com.intralot.loto.layer.controller.game.teapuesto.bo.TeapuestoBetBo;
import pe.com.intralot.loto.layer.model.persistence.dao.EventDao;
import pe.com.intralot.loto.layer.model.pojo.Event;
import pe.com.intralot.loto.layer.model.pojo.TeapuestoV;
import pe.com.intralot.loto.sale.lib.LoggerApi;
@Service("beanTeapuestoBetBo")
public class TeapuestoBetBoImpl implements TeapuestoBetBo {
 
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private EventDao beanEventDao; 
	
	public List<TeapuestoV> findInformationForEvent() throws Exception {
		List<TeapuestoV> objectList=new ArrayList<TeapuestoV>();
		try {
			
			LoggerApi.Log.info("");
			objectList= beanEventDao.findWithCondition01();
			
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
	public Event getByPkInformationForEvent(Object[] params) throws Exception {
		Event objectList=new Event();
	    try {
	    	if(params!=null){
	    	LoggerApi.Log.info("params:"+params.length);
			objectList= beanEventDao.findWithCondition02(params);
			}
	    	
			return objectList;
			
		} catch (Exception e) {
	    	LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectList!=null){
				LoggerApi.Log.info("objectList: "+objectList.toString());
			}else {
				LoggerApi.Log.info("objectList: "+"null");
			}
			
		 	}
	
	
	}
	
	 public List<Event>  getDataRegularHeaderForEvent() throws Exception{
		 List<Event> objectList=new ArrayList<Event>();
			try {
				LoggerApi.Log.info("");
				objectList= beanEventDao.findWithCondition03();
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
	 
	 public List<Event>  findByFilterInformationForEvent(Object params[]) throws Exception {
		 List<Event> objectList=new ArrayList<Event>();
			try {
				if(params!=null){
				LoggerApi.Log.info("params:"+params.length);
				objectList= beanEventDao.findWithCondition05(params);
				}
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