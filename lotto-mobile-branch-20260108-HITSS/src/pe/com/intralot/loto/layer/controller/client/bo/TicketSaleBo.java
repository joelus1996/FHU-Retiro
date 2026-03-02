package pe.com.intralot.loto.layer.controller.client.bo;

import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;

public interface TicketSaleBo {

	public TicketProcedureGetClientTicket findByClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid) throws Exception;
	
}
