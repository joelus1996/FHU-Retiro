package pe.com.intralot.loto.layer.controller.client.boimpl;

/**
 * @author:   Celso Larico
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.client.bo.ParameterBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ParameterDao;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.Parameter;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanParameterBo")
public class ParameterBoImpl implements ParameterBo {
  
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ParameterDao beanParameterDao;	

	public Parameter findParameterById(String id) throws Exception{
		LoggerApi.Log.info("cid="+id+" ParameterBoImpl findParameterById");
		Parameter objectPojo = new Parameter();
	    try {
	    	
			objectPojo=beanParameterDao.findByPk(id);
			
			return objectPojo;
			
		} catch (Exception e) {
		   LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectPojo!=null){
				LoggerApi.Log.info("pid="+id+" ParameterBoImpl objectPojo: "+objectPojo.toString());
			}else{
				LoggerApi.Log.info("pid="+id+" ParameterBoImpl objectPojo: "+"null");	
			}
			
			}
		
		
	}

}