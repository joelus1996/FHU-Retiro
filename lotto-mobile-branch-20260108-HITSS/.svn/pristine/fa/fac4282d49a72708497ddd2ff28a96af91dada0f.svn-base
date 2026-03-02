package pe.com.intralot.loto.layer.controller.client.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanClientLotocardBo")
public class ClientLotocardBoImpl implements ClientLotocardBo {
  
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ClientDao beanClientDao;	

	public Client findClientById(Integer id) throws Exception{
		LoggerApi.Log.info("cid="+id+" ClientLotocardBoImpl findClientById");
		Client objectPojo = new Client();
	    try {
	    	
			objectPojo=beanClientDao.findByPk(id);
			
			return objectPojo;
			
		} catch (Exception e) {
		   LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectPojo!=null){
				LoggerApi.Log.info("cid="+id+" ClientLotocardBoImpl objectPojo: "+objectPojo.toString());
			}else{
				LoggerApi.Log.info("cid="+id+" ClientLotocardBoImpl objectPojo: "+"null");	
			}
			
			}
		
		
	}

	public PinPrinted findLotocard(String pin) throws Exception {
		return beanClientDao.findLotocard(pin);
	}

	@Override
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId,
			String mobilePhone, String docType, String docNumber) throws Exception {
		return beanClientDao.validateSession(tokenSession, clientId, mobilePhone, docType, docNumber);
	}

	@Override
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception {
		return beanClientDao.expiredSession(clientId);
	}

	@Override
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception {
		return beanClientDao.closedSession(clientId);
		
	}

}