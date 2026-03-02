package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author:   Oscar Erick Candela Carbajal
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.ClientBalance;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientBalanceDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ClientBalanceDaoImpl extends HibernateBaseDaoImpl implements ClientBalanceDao {

	@Override
	public ClientBalance findBy(Integer idClient) throws Exception {
		LoggerApi.Log.info("idClient=" + idClient);

		List<ClientBalance> resultQuery = new ArrayList<ClientBalance>();
		ClientBalance objectDomain = new ClientBalance();

		try {
			Object[] values = new Object[1];
			values[0] = idClient;
			String queryString = " FROM " + " ClientBalance c " + " WHERE " + " c.idClient = ?";
			resultQuery = super.find(queryString, values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("cbClientIp=" + objectDomain.getCbClientIp() + " cbSuperUser=" + objectDomain.getCbSuperUser());
			}
		}
		return objectDomain;
	}
}