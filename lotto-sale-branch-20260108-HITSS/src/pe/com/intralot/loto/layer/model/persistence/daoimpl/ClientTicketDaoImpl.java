package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.ClientTicket;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
@Repository
public class ClientTicketDaoImpl extends HibernateBaseDaoImpl implements ClientTicketDao {

	@Override
	public ClientTicket findById(Long ticketId) throws Exception {

		LoggerApi.Log.info("ticketId=" + ticketId);

		List<ClientTicket> resultQuery = new ArrayList<ClientTicket>();
		ClientTicket objectDomain = new ClientTicket();

		try {

			Object[] values = new Object[1];
			values[0] = ticketId;

			String queryString = " FROM " + " 		ClientTicket ct " + " WHERE " + " 	  	ct.ticketId = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (ClientTicket) DataAccessUtils.uniqueResult(resultQuery);

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

		List<ClientTicket> resultQuery = new ArrayList<ClientTicket>();
		ClientTicket objectDomain = new ClientTicket();

		try {

			Object[] values = new Object[1];
			values[0] = ticketNumber;

			String queryString = " FROM " + " 		ClientTicket ct " + " WHERE " + " 	  	ct.ctTicketNum = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (ClientTicket) DataAccessUtils.uniqueResult(resultQuery);

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
