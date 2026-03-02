package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketLotos5Dao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
@Repository
public class ClientTicketLotos5DaoImpl extends HibernateBaseDaoImpl implements ClientTicketLotos5Dao {

	@Override
	public ClientTicketLotos5 findById(Integer ticketId) throws Exception {
		LoggerApi.Log.info("ticketId=" + ticketId);

		List<ClientTicketLotos5> resultQuery = new ArrayList<ClientTicketLotos5>();
		ClientTicketLotos5 objectDomain = new ClientTicketLotos5();

		try {

			Object[] values = new Object[1];
			values[0] = ticketId;

			String queryString = " FROM " + " 		ClientTicketLotos5 ct " + " WHERE " + " 	  	ct.ticketId = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (ClientTicketLotos5) DataAccessUtils.uniqueResult(resultQuery);

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
	public ClientTicketLotos5 findByTicketNumber(BigDecimal ticketNumber) throws Exception {
		LoggerApi.Log.info("ticketId=" + ticketNumber);

		List<ClientTicketLotos5> resultQuery = new ArrayList<ClientTicketLotos5>();
		ClientTicketLotos5 objectDomain = new ClientTicketLotos5();

		try {

			Object[] values = new Object[1];
			values[0] = ticketNumber;

			String queryString = " FROM " + " 		ClientTicketLotos5 ct " + " WHERE " + " 	  	ct.ctTicketNum = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (ClientTicketLotos5) DataAccessUtils.uniqueResult(resultQuery);

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
	public ClientTicketLotos5 findByCouponId(Integer couponId) throws Exception {
		LoggerApi.Log.info("-couponId=" + couponId);

		List<ClientTicketLotos5> resultQuery = new ArrayList<ClientTicketLotos5>();
		ClientTicketLotos5 objectDomain = new ClientTicketLotos5();

		try {

			Object[] values = new Object[2];
			values[0] = 3;
			values[1] = couponId;

			String queryString = " FROM " + " 		ClientTicketLotos5 ct " + " WHERE  ct.ctIflexChannel = ? AND " + " 	  	ct.ctIflexPlacebetId = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (ClientTicketLotos5) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("ticketId=" + objectDomain.getTicketId());
			}
		}

		return objectDomain;
	}

}
