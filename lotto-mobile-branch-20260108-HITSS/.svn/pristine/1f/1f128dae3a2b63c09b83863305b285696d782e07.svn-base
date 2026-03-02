package pe.com.intralot.loto.layer.controller.game.fechaza.boimpl;

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
import pe.com.intralot.loto.layer.controller.game.fechaza.bo.FechazaResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanFechazaResultBo")
public class FechazaResultBoImpl implements FechazaResultBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DrawDao beanDrawDao;
	
	public List<Draw> getResult() throws Exception {
		List<Draw> objectList= new ArrayList<Draw>();
     try {		
    	 	LoggerApi.Log.info("");
			objectList= beanDrawDao.findWithCondition10();
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


	
	public List<Draw> getResultForItem(Object[] params) throws Exception {
		List<Draw> objectList=new ArrayList<Draw>();
	     try {
	    	 	LoggerApi.Log.info("params:"+params.length);
	    	 	objectList= beanDrawDao.findWithCondition09(params);
				
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