package pe.com.intralot.loto.layer.service.client.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.persistence.dao.TicketRetailDao;
import pe.com.intralot.loto.layer.service.client.bo.TicketRetailBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class TicketRetailBoImpl implements TicketRetailBo {

	@Autowired
	private TicketRetailDao ticketRetailDao;
	

	@Override
	public TicketProcedureGetClientTicketRetail findByClientDetailTicketRetail(Integer p_clientid, Integer p_gameid, String p_ticketid)throws Exception {

		LoggerApi.Log.info("cid=" + p_clientid + " p_gameid=" + p_gameid+" p_ticketid=" + p_ticketid);

		TicketProcedureGetClientTicketRetail objectDomain = new TicketProcedureGetClientTicketRetail();
		try {
			objectDomain = ticketRetailDao.findByClientDetailTicketRetail(p_clientid, p_gameid,	p_ticketid);
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
