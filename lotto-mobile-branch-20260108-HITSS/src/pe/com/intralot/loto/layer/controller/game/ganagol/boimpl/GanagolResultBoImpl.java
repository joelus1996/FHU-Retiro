package pe.com.intralot.loto.layer.controller.game.ganagol.boimpl;

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
import pe.com.intralot.loto.layer.controller.game.ganagol.bo.GanagolResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawItemDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.DrawItem;
import pe.com.intralot.loto.layer.model.pojo.GanagolList;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanGanagolResultBo")
public class GanagolResultBoImpl implements GanagolResultBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ViewDAO beanViewDAO;
	
	@Autowired
	private DrawItemDao beanDrawItemDao;
	
	
	public List<GanagolList> getResult() throws Exception {
		List<GanagolList> objectList=new ArrayList<GanagolList>();
     try {
    	    LoggerApi.Log.info("");
			objectList= beanViewDAO.findWithCondition03();
			for(GanagolList l:objectList) {
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


	public List<DrawItem> getResultForItem(Object[] params) throws Exception {
		List<DrawItem> objectList=new ArrayList<DrawItem>();
		try {
			    LoggerApi.Log.info("");
				
				objectList= beanDrawItemDao.findWithCondition01(params);
				return objectList;
				
			} catch (Exception e) {
				LoggerApi.severe(e);			
				throw new Exception(e);	
				
			} finally{
				if(objectList!=null){
					for (DrawItem i : objectList) {
						LoggerApi.Log.info(i.getDrawpk().getItem()+" "+i.getLocalName()+" "+i.getVisitorName());	
					}
				}else{
					LoggerApi.Log.info("objectList: "+"null");
				}
				
			}
		}
	
}