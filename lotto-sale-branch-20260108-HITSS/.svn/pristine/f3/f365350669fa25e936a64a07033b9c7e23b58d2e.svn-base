package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicket;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetClientTicketRetail;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetRetailTeApuestoGrecia;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsFilterList;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetTicketsList;

public interface TicketSaleDao {
	
	public List<TicketProcedureGetPrizesList> findPrizesList(Integer clientId) throws Exception;
	
	public List<TicketProcedureGetTicketsList> findTicketsList(Integer clientId) throws Exception;
	
	public TicketProcedureGetClientTicket findClientTicket(Integer p_clientid, Integer p_gameid, Long p_ticketid) throws Exception;
	
	public StringBuffer findCouponClientTicket(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketTeApuesto(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketFechaza(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketKinelo(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketPollayPollon(TicketProcedureGetClientTicket p_clientTicket) throws Exception;
	
	public StringBuffer findCouponClientTicketRapitinkas(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketElReventon(TicketProcedureGetClientTicket p_clientTicket, int tip_coupon) throws Exception;
	
	public StringBuffer findCouponClientTicketClicyGana(TicketProcedureGetClientTicket p_clientTicket) throws Exception;
	
	public StringBuffer findCouponClientTicketDeportesVirtuales(TicketProcedureGetClientTicket p_clientTicket)
	throws Exception;
	
	public StringBuffer findCouponClientTicketRetail(TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon, ClientProcedureGetDetail clientDetail ) throws Exception;
	
	public StringBuffer findCouponClientTicketTeApuestoGrecia(List<TicketProcedureGetRetailTeApuestoGrecia> p_detalleticket,TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon) throws Exception;
	 
	public List<TicketProcedureGetTicketsFilterList> findTicketsListFilter(Integer clientId, String start_date, String end_date) throws Exception;
	
	public StringBuffer findCouponByTicketRetailGanagol(TicketProcedureGetClientTicketRetail p_clientTicket, int tip_coupon, ClientProcedureGetDetail clientDetail) throws Exception;
	
	public List<TicketProcedureGetRetailTeApuestoGrecia> findByClientTickeTeApuestoGrecia(int p_programa, int p_cpn) throws Exception;
	
	Boolean searchDetailGrecia(String p_programa, String p_cpn)throws Exception ;
	
	public ClientProcedureGetDetail findClientDetail(Integer clientId) throws Exception; 

}
