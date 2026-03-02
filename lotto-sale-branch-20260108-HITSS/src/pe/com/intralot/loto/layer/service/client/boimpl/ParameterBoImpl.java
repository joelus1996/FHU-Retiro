package pe.com.intralot.loto.layer.service.client.boimpl;

/**
 * @author:   Celso Larico
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.Parameter;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ParameterDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.layer.service.client.bo.ParameterBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ParameterBoImpl implements ParameterBo {

   
    @Autowired
    private ParameterDao parameterDao;

    @Override
    public Parameter findByIdParameter(String idParameter) throws Exception {
    	LoggerApi.Log.info("parameterId=" + idParameter);
        Parameter objectDomain = new Parameter();
        try {
            objectDomain = parameterDao.findByIdParameter(idParameter);
        } catch (Exception e) {
        	LoggerApi.severe(e);
			throw e;
        } finally {
        	if (objectDomain != null) {
				LoggerApi.Log.info("idParameter= " + objectDomain.getParameterId() + " description=" + objectDomain.getDescription());
			}
        }
        return objectDomain;
    }
}