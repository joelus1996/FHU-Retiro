package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.persistence.dao.ClientAddressLogDao;
import pe.com.intralot.loto.layer.model.pojo.ClientAddressLog;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;

@Repository
public class ClientAddressLogDaoImpl extends HibernateBaseDaoImpl  implements ClientAddressLogDao{

	@Override
	public void saveLoginLog(ClientAddressLog clientAddressLog) throws Exception {
		try {
			super.save(clientAddressLog);
		} catch (Exception e) {
			 LoggerApi.severe(e);
	         throw e;
		}
	}
}
