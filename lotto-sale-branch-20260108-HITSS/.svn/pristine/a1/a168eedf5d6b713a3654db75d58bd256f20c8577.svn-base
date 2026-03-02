package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.ClientTicketLotos5Item;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketLotos5ItemDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
@Repository
public class ClientTicketLotos5ItemDaoImpl extends HibernateBaseDaoImpl implements ClientTicketLotos5ItemDao {

	@Override
	public ClientTicketLotos5Item findById(Integer ticketId) throws Exception {
		LoggerApi.Log.info("ticketId=" + ticketId);

		List<ClientTicketLotos5Item> resultQuery = new ArrayList<ClientTicketLotos5Item>();
		ClientTicketLotos5Item objectDomain = new ClientTicketLotos5Item();

		try {

			Object[] values = new Object[1];
			values[0] = ticketId;

			String queryString = " FROM " + " 		ClientTicketLotos5Item ct " + " WHERE " + " 	  	ct.ctiTicketId = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (ClientTicketLotos5Item) DataAccessUtils.uniqueResult(resultQuery);

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
