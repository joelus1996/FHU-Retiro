package pe.com.intralot.loto.layer.controller.game.tinkamegabol.boimpl;

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
import pe.com.intralot.loto.layer.controller.game.tinkamegabol.bo.TinkamegabolResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.TinkaList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanTinkamegabolResultBo")
public class TinkamegabolResultBoImpl implements TinkamegabolResultBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());
 
	@Autowired
	private ViewDAO beanViewDAO;
	
	public List<TinkaList> getResult() throws Exception {
		List<TinkaList> objectList=new ArrayList<TinkaList>();
     try {
			LoggerApi.Log.info("");
			
			objectList= beanViewDAO.findWithCondition01();
			
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