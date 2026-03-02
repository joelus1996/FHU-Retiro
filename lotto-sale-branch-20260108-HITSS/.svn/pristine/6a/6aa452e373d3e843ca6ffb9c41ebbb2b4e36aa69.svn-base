package pe.com.intralot.loto.layer.service.client.boimpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientTicketBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ClientTicketBoImpl implements ClientTicketBo {

	@Autowired
	private ClientTicketDao clientTicketDao;

	@Override
	public ClientTicket findById(Long ticketId) throws Exception {
		LoggerApi.Log.info("ticketId=" + ticketId);

		ClientTicket objectDomain = new ClientTicket();

		try {
			objectDomain = clientTicketDao.findById(ticketId);

		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("ctAgencyCd=" + objectDomain.getCtAgencyCd() + " ctBalanceItem=" + objectDomain.getCtBalanceItem());
			}
		}

		return objectDomain;
	}

	@Override
	public ClientTicket findByTicketNumber(BigDecimal ticketNumber) throws Exception {
		LoggerApi.Log.info("ticketNumber=" + ticketNumber);

		ClientTicket objectDomain = new ClientTicket();

		try {
			objectDomain = clientTicketDao.findByTicketNumber(ticketNumber);

		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("ctAgencyCd=" + objectDomain.getCtAgencyCd() + " ctBalanceItem=" + objectDomain.getCtBalanceItem());
			}
		}

		return objectDomain;
	}

}
