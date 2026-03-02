package pe.com.intralot.loto.layer.controller.client.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientRegisterBo;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutClient;
import pe.com.intralot.loto.sale.lib.LoggerApi;


@Service("beanClientRegisterBo")
public class ClientRegisterBoImpl implements ClientRegisterBo {
  
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProcedureDao beanProcedureDao;	
 
	@SuppressWarnings("rawtypes")
	public Map  registerUser(Map param) throws Exception{
		Map objectMap=null;
		try {			
			LoggerApi.Log.info("registerUser param: "+param.size());
			objectMap= beanProcedureDao.registerUser(param);
			
			return objectMap;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
		} finally{
			if(objectMap!=null){
				LoggerApi.Log.info("registerUser objectMap: "+objectMap.size());
			}else{
				LoggerApi.Log.info("registerUser objectMap: "+"null");	
			}
			
			}
		
	}
	
	@SuppressWarnings("rawtypes")
    public ClientProcedurePutClient findPutclient(Object[] values) throws Exception {
        LoggerApi.Log.info("pNombre=" + values[0] + " pApPaterno=" + values[1] + " pApMaterno=" + values[2] + " pBirthDate= "
                + values[3] + " pTypeId=" + values[4] + " pNumberId=" + values[5] + " pNickName=" + values[6]
                + " pGender=" + values[7] + " pMarital=" + values[8] + " pUser=" + values[9] + " pMail1=" + values[10]);
        ClientProcedurePutClient objectDomain = new ClientProcedurePutClient();
        try {
            objectDomain = beanProcedureDao.findPutclient(values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findPutclient cid=" + objectDomain.getClientId() + " p_state=" + objectDomain.getState() 
                        + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
}