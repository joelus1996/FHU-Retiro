package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author:   Celso Larico
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.Parameter;
import pe.com.intralot.loto.layer.model.persistence.dao.ParameterDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ParameterDaoImpl extends HibernateBaseDaoImpl implements ParameterDao {

	@Override
	public Parameter findByIdParameter(String idParameter) throws Exception {

		LoggerApi.Log.info("parameterId=" + idParameter);

		List<Parameter> resultQuery = new ArrayList<Parameter>();
		Parameter objectDomain = new Parameter();

		try {

			Object[] values = new Object[1];
			values[0] = idParameter;

			String queryString = " FROM " + " 		Parameter p " + " WHERE " + " 	  	p.parameterId = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("parameterId= " + objectDomain.getParameterId() + " description=" + objectDomain.getDescription());
			}
		}

		return objectDomain;
	}

}