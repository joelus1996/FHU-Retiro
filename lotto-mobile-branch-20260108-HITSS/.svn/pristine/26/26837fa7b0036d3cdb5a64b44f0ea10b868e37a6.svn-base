package pe.com.intralot.loto.layer.controller.game.elreventon.boimpl;

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
import pe.com.intralot.loto.layer.controller.game.elreventon.bo.ElreventonResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.ElreventonList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanElreventonResultBo")
public class ElreventonResultBoImpl implements ElreventonResultBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ViewDAO beanViewDAO;
	
	public List<ElreventonList> getResult() throws Exception {
		List<ElreventonList> objectList=new ArrayList<ElreventonList>();
     try {			
    	 	LoggerApi.Log.info("");
			objectList= beanViewDAO.findWithCondition06();
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