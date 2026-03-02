package pe.com.intralot.loto.layer.service.client.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5Item;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketLotos5ItemDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketLotos5ItemBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ClientTicketLotos5ItemBoImpl implements ClientTicketLotos5ItemBo {

	@Autowired
	private ClientTicketLotos5ItemDao clientTicketLotos5ItemDao;

	@Override
	public ClientTicketLotos5Item findById(Integer ticketId) throws Exception {
		LoggerApi.Log.info("ticketId=" + ticketId);

		ClientTicketLotos5Item objectDomain = new ClientTicketLotos5Item();

		try {

			objectDomain = clientTicketLotos5ItemDao.findById(ticketId);

		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("ctiBet=" + objectDomain.getCtiBet() + " ctiApuetxt=" + objectDomain.getCtiApuetxt());
			}
		}

		return objectDomain;
	}

}
