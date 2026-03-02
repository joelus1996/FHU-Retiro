package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.TicketWinnerLotos5;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketWinnerLotos5Dao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
@Repository
public class TicketWinnerLotos5DaoImpl extends HibernateBaseDaoImpl implements TicketWinnerLotos5Dao {

	@Override
	public TicketWinnerLotos5 findById(Long ticketId) throws Exception {
		LoggerApi.Log.info("ticketId= " + ticketId);

		List<TicketWinnerLotos5> resultQuery = new ArrayList<TicketWinnerLotos5>();
		TicketWinnerLotos5 objectDomain = new TicketWinnerLotos5();

		try {

			Object[] values = new Object[1];
			values[0] = ticketId;

			String queryString = " FROM " + " 		TicketWinnerLotos5 t " + " WHERE " + " 	  	t.twTicketId = ? ";

			resultQuery = super.find(queryString, values);

			objectDomain = (TicketWinnerLotos5) DataAccessUtils.uniqueResult(resultQuery);

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
	public TicketWinnerLotos5 findByTicketNumber(String ticketNumber) throws Exception {
		LoggerApi.Log.info("ticketNumber= " + ticketNumber);

		List<TicketWinnerLotos5> resultQuery = new ArrayList<TicketWinnerLotos5>();
		TicketWinnerLotos5 objectDomain = new TicketWinnerLotos5();

		try {

			Object[] values = new Object[1];
			values[0] = ticketNumber;

			String queryString = " FROM " + " 		TicketWinnerLotos5 t " + " WHERE " + " 	  	t.twTicketNumber = ? ";

			resultQuery = super.find(queryString, values);

			objectDomain = (TicketWinnerLotos5) DataAccessUtils.uniqueResult(resultQuery);

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
