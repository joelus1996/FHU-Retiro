package pe.com.intralot.loto.layer.service.client.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientBalance;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientBalanceDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ClientBalanceBoImpl implements ClientBalanceBo {

	@Autowired
	private ClientBalanceDao clientBalanceDao;

	@Override
	public ClientBalance findByIdClient(Integer idClient) throws Exception {
		LoggerApi.Log.info("idClient=" + idClient);

		ClientBalance objectDomain = new ClientBalance();

		try {
			objectDomain = clientBalanceDao.findBy(idClient);

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