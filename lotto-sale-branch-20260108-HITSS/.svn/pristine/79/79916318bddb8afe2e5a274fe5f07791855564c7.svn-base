package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.TicketWinner;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketWinnerDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
@Repository
public class TicketWinnerDaoImpl extends HibernateBaseDaoImpl implements TicketWinnerDao {

	@Override
	public TicketWinner findById(Long ticketId) throws Exception {
		LoggerApi.Log.info("ticketId= " + ticketId);

		List<TicketWinner> resultQuery = new ArrayList<TicketWinner>();
		TicketWinner objectDomain = new TicketWinner();

		try {

			Object[] values = new Object[1];
			values[0] = ticketId;

			String queryString = " FROM " + " 		TicketWinner t " + " WHERE " + " 	  	t.twTicketId = ? ";

			resultQuery = super.find(queryString, values);

			objectDomain = (TicketWinner) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQuery != null) {
				LoggerApi.Log.info("twCarrierPhone= " + objectDomain.getTwCarrierPhone() + "twMovilCompany= " + objectDomain.getTwMovilCompany());
			}
		}

		return objectDomain;
	}

	@Override
	public TicketWinner findByTicketNumber(String ticketNumber) throws Exception {
		LoggerApi.Log.info("ticketNumber= " + ticketNumber);

		List<TicketWinner> resultQuery = new ArrayList<TicketWinner>();
		TicketWinner objectDomain = new TicketWinner();

		try {

			Object[] values = new Object[1];
			values[0] = ticketNumber;

			String queryString = " FROM " + " 		TicketWinner t " + " WHERE " + " 	  	t.twTicketNumber = ? ";

			resultQuery = super.find(queryString, values);

			objectDomain = (TicketWinner) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQuery != null) {
				LoggerApi.Log.info("twCarrierPhone= " + objectDomain.getTwCarrierPhone() + "twMovilCompany= " + objectDomain.getTwMovilCompany());
			}
		}

		return objectDomain;
	}

}
