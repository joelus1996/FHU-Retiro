package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;

public interface TicketRetailDao {
	
	public List<TicketProcedureGetTicketsList> findByClientTicketRetailList(Integer p_clientId) throws Exception;
	
	public List<TicketProcedureGetTicketsFilterList> findTicketsRetailListFilter(Integer p_clientId, String p_start_date, String p_end_date) throws Exception;
	
	public TicketProcedureGetClientTicketRetail findByClientDetailTicketRetail(Integer p_clientid, Integer p_gameid, String p_ticketid) throws Exception;

}
