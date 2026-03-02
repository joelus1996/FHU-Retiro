package pe.com.intralot.loto.layer.controller.game.tinkamegabol.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.game.tinkamegabol.bo.TinkamegabolBetBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanTinkamegabolBetBo")
public class TinkamegabolBetBoImpl implements TinkamegabolBetBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());
 
	@Autowired
	private DrawDao beanDrawDao;
 
	@Autowired
	private ProcedureDao beanProcedureDao;
 
	/*@Autowired
	private ViewDAO beanViewDAO;*/
	
	@SuppressWarnings("rawtypes")
	public  HashMap[] getNumberConsecutive() throws Exception { 
		HashMap[] objectMap=null;
		try {
			LoggerApi.Log.info("");
			objectMap= beanProcedureDao.getNumberConsecutiveTinkamegabol();
			
			return objectMap;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			}else{
				LoggerApi.Log.info("objectMap: "+"null");
			}
			
			
			}
	
	}


	
	public Draw getDataCloseDateGame() throws Exception {
		Draw objectPojo=new Draw();
	   try {
			LoggerApi.Log.info("");
			
			objectPojo= beanDrawDao.findAllWithCondition03();
			return  objectPojo;
			
		} catch (NullPointerException e) {
        	return null;
        }  catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
	    } finally{
	    	if(objectPojo!=null){
	    		LoggerApi.Log.info("objectPojo: "+objectPojo.toString());
	    	}else{
	    		LoggerApi.Log.info("objectPojo: "+"null");
	    	}
			
		}
	

	}


	
	public Draw getDrawsTinkaMegabol01() throws Exception {
		Draw objectPojo=new Draw();
	    try {
	    	LoggerApi.Log.info("");
			
			objectPojo= beanDrawDao.findAllWithCondition01();
			return  objectPojo;
			
		} catch (Exception e) {
		 	LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectPojo!=null){
				LoggerApi.Log.info("objectPojo: "+objectPojo.toString());
			}else{
				LoggerApi.Log.info("objectPojo: "+"null");
			}
			
		}
	
	
	}


	
	public Draw getDrawsTinkaMegabol02() throws Exception {
		Draw objectPojo=new Draw();
	   try {
			LoggerApi.Log.info("");
			objectPojo= beanDrawDao.findAllWithCondition02();
			return  objectPojo;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally {
			if(objectPojo!=null){
				LoggerApi.Log.info("objectPojo: "+objectPojo.toString());
			}else{
				LoggerApi.Log.info("objectPojo: "+"null");
			}
			
		}
	
	
	}
	
	
}