package pe.com.intralot.loto.layer.controller.client.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.TicketSaleBo;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketSaleDao;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class TicketSaleBoImpl implements TicketSaleBo {

	@Autowired
	private TicketSaleDao ticketSaleDao;
	
	public TicketProcedureGetClientTicket findByClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid)
			throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid+" p_ticketid=" + p_ticketid);

		TicketProcedureGetClientTicket objectDomain = new TicketProcedureGetClientTicket();
		try {
			objectDomain = ticketSaleDao.findClientTicket(p_clientid, p_gameid,	p_ticketid);
			LoggerApi.Log.info("cid=" + p_clientid + " objectDomain=" + objectDomain);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain!=null) {
				LoggerApi.Log.info("cid=" + objectDomain.getCtClientId()
						+ " p_gameid=" + objectDomain.getCtGameId()
						+ " p_ticketid=" + objectDomain.getCtTicketId());
			} else {
				LoggerApi.Log.info("cid=null");
			}
		}
		return objectDomain;
	}
	
}


