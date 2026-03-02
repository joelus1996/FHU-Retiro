package pe.com.intralot.loto.layer.service.client.bo;

import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;

public interface TicketRetailBo {
	
	public TicketProcedureGetClientTicketRetail findByClientDetailTicketRetail(Integer p_clientid, Integer p_gameid, String p_ticketid) throws Exception;
	
}
