package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.pojo.TicketProcedureGetClientTicketRetail;

public interface TicketSaleDao {

	public TicketProcedureGetClientTicket findClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid) throws Exception;
	public TicketProcedureGetClientTicketRetail findClientTicketRetail(Integer p_clientid, Integer p_gameid, String p_ticketid) throws Exception;
}
