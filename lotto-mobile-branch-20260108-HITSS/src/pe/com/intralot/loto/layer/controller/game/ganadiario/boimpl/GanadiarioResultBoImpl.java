package pe.com.intralot.loto.layer.controller.game.ganadiario.boimpl;

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
import pe.com.intralot.loto.layer.controller.game.ganadiario.bo.GanadiarioResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanGanadiarioResultBo")
public class GanadiarioResultBoImpl implements GanadiarioResultBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ViewDAO beanViewDAO;
	
	public List<GanadiarioList> getResult() throws Exception {
		List<GanadiarioList> objectList=new ArrayList<GanadiarioList>();
     try {
    	 	LoggerApi.Log.info("");
			objectList= beanViewDAO.findWithCondition02();
			for(GanadiarioList l:objectList) {
				if(l.getRawid()>5000) l.setDrwid(l.getRawid()-5000);
				else l.setDrwid(l.getRawid());
			}
			return objectList;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
		} finally {
			if(objectList!=null){
				LoggerApi.Log.info("objectList: "+objectList.size());	
			}else{
				LoggerApi.Log.info("objectList: "+"null");
			}
			
				}
	}




	
	
}