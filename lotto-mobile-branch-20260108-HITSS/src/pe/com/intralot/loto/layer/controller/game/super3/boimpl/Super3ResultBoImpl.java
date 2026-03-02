package pe.com.intralot.loto.layer.controller.game.super3.boimpl;

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
import pe.com.intralot.loto.layer.controller.game.super3.bo.Super3ResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.Super3List;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanSuper3ResultBo")
public class Super3ResultBoImpl implements Super3ResultBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());
 
	@Autowired
	private ViewDAO beanViewDAO;
	
	public List<Super3List> getResult() throws Exception {
		List<Super3List> objectList=new ArrayList<Super3List>();
     try {	
    	    LoggerApi.Log.info("");
			objectList= beanViewDAO.findWithCondition05();
			for(Super3List l:objectList) {
				if(l.getRawid()>5000) l.setDrwid(l.getRawid()-5000);
				else l.setDrwid(l.getRawid());
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