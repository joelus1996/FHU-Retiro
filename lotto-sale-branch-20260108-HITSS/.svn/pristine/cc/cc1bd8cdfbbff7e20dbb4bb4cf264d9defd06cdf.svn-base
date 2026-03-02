package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketRetailDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class TicketRetailDaoImpl extends HibernateBaseDaoImpl implements TicketRetailDao {



	@Override
	public List<TicketProcedureGetTicketsList> findByClientTicketRetailList(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId);
		List<TicketProcedureGetTicketsList> resultQuery = new ArrayList<TicketProcedureGetTicketsList>();
		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamedBdTrans("TICKETRETAIL_GETTICKETSLIST", values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("ticketRetail size=" + resultQuery.size());
		}
		return resultQuery;
	}

	@Override
	public List<TicketProcedureGetTicketsFilterList> findTicketsRetailListFilter(Integer p_clientId, String p_start_date,
			String p_end_date) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " start_date="+p_start_date + "end_date="+p_end_date);
	   	List<TicketProcedureGetTicketsFilterList> resultQuery = new ArrayList<TicketProcedureGetTicketsFilterList>();
	   	try {
	   		Object[] values = new Object[3];
	   		values[0] = p_clientId;
	   		values[1] = p_start_date;
	        values[2] = p_end_date;
	        
	   		resultQuery = super.findForNamedBdTrans("TICKET_RETAIL_FILTER_LIST", values);
	   	} catch (Exception e) {
	   		LoggerApi.severe(e);
	   		throw e;
	   	} finally {
	   		LoggerApi.Log.info("ticketRetail size=" + resultQuery.size());
	   	}
	   	return resultQuery;
	}
	

	@Override
	public TicketProcedureGetClientTicketRetail findByClientDetailTicketRetail(Integer p_clientid, Integer p_gameid,
			String p_ticketid) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid + " p_ticketid=" + p_ticketid);
   		List<TicketProcedureGetClientTicketRetail> resultQuery = new ArrayList<TicketProcedureGetClientTicketRetail>();
   		TicketProcedureGetClientTicketRetail objectDomain = new TicketProcedureGetClientTicketRetail();
   		try {
   			Object[] values = new Object[3];
   			values[0] = p_clientid;
   			values[1] = p_gameid;
   			values[2] = p_ticketid;
   			resultQuery = super.findForNamedBdTrans("TICKETSALE_GETCLIENTTICKET_RETAIL", values);
   			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
   		} catch (Exception e) {
   			LoggerApi.severe(e);
   			throw e;
   		} finally {
   			if (objectDomain != null) {
                   LoggerApi.Log.info("cid="+p_clientid+" p_ctticketid=" + objectDomain.getCtTicketId() + " p_ctclientid=" + objectDomain.getCtClientId() + " p_ticketnum="
                           + objectDomain.getCtTicketNumber() + " p_ctgameid=" + objectDomain.getCtGameId() + " p_ticketdate=" + objectDomain.getCtTicketDate());
   			} else {
   				LoggerApi.Log.info("cid=" + p_clientid + " objectDomain=" + objectDomain);
   			}
   		}
   		return objectDomain;
	}

}
